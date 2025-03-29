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
import kotlin.jvm.functions.Function1;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;

/* compiled from: CallScheduleViewModel.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel$onSave$1", f = "CallScheduleViewModel.kt", i = {}, l = {105}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleViewModel$onSave$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean[] $days;
    final /* synthetic */ Calendar $finishTime;
    final /* synthetic */ Calendar $startTime;
    int label;
    final /* synthetic */ CallScheduleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallScheduleViewModel$onSave$1(CallScheduleViewModel callScheduleViewModel, Calendar calendar, Calendar calendar2, Boolean[] boolArr, Continuation<? super CallScheduleViewModel$onSave$1> continuation) {
        super(1, continuation);
        this.this$0 = callScheduleViewModel;
        this.$startTime = calendar;
        this.$finishTime = calendar2;
        this.$days = boolArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CallScheduleViewModel$onSave$1(this.this$0, this.$startTime, this.$finishTime, this.$days, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((CallScheduleViewModel$onSave$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomInteractor intercomInteractor;
        Integer num;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intercomInteractor = this.this$0.interactor;
            num = this.this$0.intercomId;
            this.label = 1;
            if (intercomInteractor.setSchedule(num.intValue(), this.this$0.getScheduleId().getValue(), TuplesKt.to(Boxing.boxInt(this.$startTime.get(11)), Boxing.boxInt(this.$startTime.get(12))), TuplesKt.to(Boxing.boxInt(this.$finishTime.get(11)), Boxing.boxInt(this.$finishTime.get(12))), this.$days, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
