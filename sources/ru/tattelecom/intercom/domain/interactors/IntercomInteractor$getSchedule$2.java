package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.local.dao.ScheduleDao;
import ru.tattelecom.intercom.data.local.entity.ScheduleEntity;

/* compiled from: IntercomInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.IntercomInteractor$getSchedule$2", f = "IntercomInteractor.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class IntercomInteractor$getSchedule$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ScheduleEntity>, Object> {
    final /* synthetic */ int $id;
    int label;
    final /* synthetic */ IntercomInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntercomInteractor$getSchedule$2(IntercomInteractor intercomInteractor, int i, Continuation<? super IntercomInteractor$getSchedule$2> continuation) {
        super(2, continuation);
        this.this$0 = intercomInteractor;
        this.$id = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomInteractor$getSchedule$2(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ScheduleEntity> continuation) {
        return ((IntercomInteractor$getSchedule$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScheduleDao scheduleDao;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            scheduleDao = this.this$0.scheduleDao;
            this.label = 1;
            obj = scheduleDao.getByIntercomId(this.$id, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
