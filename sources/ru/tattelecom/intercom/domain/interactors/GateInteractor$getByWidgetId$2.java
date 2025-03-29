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
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: GateInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.GateInteractor$getByWidgetId$2", f = "GateInteractor.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class GateInteractor$getByWidgetId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IntercomEntity>, Object> {
    final /* synthetic */ int $widgetId;
    int label;
    final /* synthetic */ GateInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GateInteractor$getByWidgetId$2(GateInteractor gateInteractor, int i, Continuation<? super GateInteractor$getByWidgetId$2> continuation) {
        super(2, continuation);
        this.this$0 = gateInteractor;
        this.$widgetId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GateInteractor$getByWidgetId$2(this.this$0, this.$widgetId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IntercomEntity> continuation) {
        return ((GateInteractor$getByWidgetId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomDao intercomDao;
        UserPrefsSource userPrefsSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intercomDao = this.this$0.intercomDao;
            userPrefsSource = this.this$0.prefs;
            this.label = 1;
            obj = intercomDao.getByGateId(userPrefsSource.getGateIdByWidgetId(this.$widgetId), this);
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
