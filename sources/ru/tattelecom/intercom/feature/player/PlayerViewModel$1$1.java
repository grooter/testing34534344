package ru.tattelecom.intercom.feature.player;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$1$1", f = "PlayerViewModel.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerViewModel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    Object L$0;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$1$1(PlayerViewModel playerViewModel, String str, Continuation<? super PlayerViewModel$1$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
        this.$it = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GateInteractor gateInteractor;
        PlayerViewModel playerViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PlayerViewModel playerViewModel2 = this.this$0;
            gateInteractor = playerViewModel2.gateInteractor;
            this.L$0 = playerViewModel2;
            this.label = 1;
            Object gateId = gateInteractor.getGateId(this.$it, this);
            if (gateId == coroutine_suspended) {
                return coroutine_suspended;
            }
            playerViewModel = playerViewModel2;
            obj = gateId;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            playerViewModel = (PlayerViewModel) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        playerViewModel.gateId = (Integer) obj;
        return Unit.INSTANCE;
    }
}
