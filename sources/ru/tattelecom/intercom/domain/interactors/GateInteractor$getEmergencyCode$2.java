package ru.tattelecom.intercom.domain.interactors;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;

/* compiled from: GateInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.GateInteractor$getEmergencyCode$2", f = "GateInteractor.kt", i = {0}, l = {82}, m = "invokeSuspend", n = {"dateInSecond"}, s = {"J$0"})
/* loaded from: classes5.dex */
final class GateInteractor$getEmergencyCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $gateId;
    long J$0;
    int label;
    final /* synthetic */ GateInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GateInteractor$getEmergencyCode$2(GateInteractor gateInteractor, int i, Continuation<? super GateInteractor$getEmergencyCode$2> continuation) {
        super(2, continuation);
        this.this$0 = gateInteractor;
        this.$gateId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GateInteractor$getEmergencyCode$2(this.this$0, this.$gateId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((GateInteractor$getEmergencyCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomDao intercomDao;
        long j;
        Integer intercomEmergencyCodeUpdateTime;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long seconds = TimeUnit.MILLISECONDS.toSeconds(Calendar.getInstance().getTimeInMillis());
            intercomDao = this.this$0.intercomDao;
            this.J$0 = seconds;
            this.label = 1;
            obj = intercomDao.getByGateId(this.$gateId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            j = seconds;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        }
        IntercomEntity intercomEntity = (IntercomEntity) obj;
        return j - ((long) ((intercomEntity == null || (intercomEmergencyCodeUpdateTime = intercomEntity.getIntercomEmergencyCodeUpdateTime()) == null) ? 0 : intercomEmergencyCodeUpdateTime.intValue())) > ((long) RemoteMessageConst.DEFAULT_TTL) ? Boxing.boxInt(0) : intercomEntity != null ? intercomEntity.getIntercomEmergencyCode() : null;
    }
}
