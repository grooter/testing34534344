package ru.tattelecom.intercom.feature.player;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$17", f = "PlayerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerActivity$provideUiChanges$1$17 extends SuspendLambda implements Function2<PlayerViewModel.Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideUiChanges$1$17(PlayerActivity playerActivity, Continuation<? super PlayerActivity$provideUiChanges$1$17> continuation) {
        super(2, continuation);
        this.this$0 = playerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlayerActivity$provideUiChanges$1$17 playerActivity$provideUiChanges$1$17 = new PlayerActivity$provideUiChanges$1$17(this.this$0, continuation);
        playerActivity$provideUiChanges$1$17.L$0 = obj;
        return playerActivity$provideUiChanges$1$17;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(PlayerViewModel.Event event, Continuation<? super Unit> continuation) {
        return ((PlayerActivity$provideUiChanges$1$17) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.provideEvent((PlayerViewModel.Event) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
