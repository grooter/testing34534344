package ru.tattelecom.intercom.feature.call_schedule;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.data.local.entity.ScheduleEntity;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;

/* compiled from: CallScheduleViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel$1$1", f = "CallScheduleViewModel.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleViewModel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallScheduleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallScheduleViewModel$1$1(CallScheduleViewModel callScheduleViewModel, Continuation<? super CallScheduleViewModel$1$1> continuation) {
        super(2, continuation);
        this.this$0 = callScheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallScheduleViewModel$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallScheduleViewModel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomInteractor intercomInteractor;
        Integer num;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Calendar provideTime;
        Calendar provideTime2;
        MutableStateFlow mutableStateFlow3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intercomInteractor = this.this$0.interactor;
            num = this.this$0.intercomId;
            this.label = 1;
            obj = intercomInteractor.getSchedule(num.intValue(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ScheduleEntity scheduleEntity = (ScheduleEntity) obj;
        if (scheduleEntity != null) {
            CallScheduleViewModel callScheduleViewModel = this.this$0;
            mutableStateFlow = callScheduleViewModel._scheduleId;
            mutableStateFlow.setValue(Boxing.boxInt(scheduleEntity.getId()));
            mutableStateFlow2 = callScheduleViewModel._time;
            provideTime = callScheduleViewModel.provideTime(scheduleEntity.getStartHour(), scheduleEntity.getStartMinute());
            provideTime2 = callScheduleViewModel.provideTime(scheduleEntity.getFinishHour(), scheduleEntity.getFinishMinute());
            mutableStateFlow2.setValue(TuplesKt.to(provideTime, provideTime2));
            mutableStateFlow3 = callScheduleViewModel._days;
            mutableStateFlow3.setValue(new Boolean[]{Boxing.boxBoolean(scheduleEntity.getMonday()), Boxing.boxBoolean(scheduleEntity.getTuesday()), Boxing.boxBoolean(scheduleEntity.getWednesday()), Boxing.boxBoolean(scheduleEntity.getThursday()), Boxing.boxBoolean(scheduleEntity.getFriday()), Boxing.boxBoolean(scheduleEntity.getSaturday()), Boxing.boxBoolean(scheduleEntity.getSunday())});
        }
        return Unit.INSTANCE;
    }
}
