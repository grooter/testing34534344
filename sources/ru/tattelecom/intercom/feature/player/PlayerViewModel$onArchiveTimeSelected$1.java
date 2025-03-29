package ru.tattelecom.intercom.feature.player;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$onArchiveTimeSelected$1", f = "PlayerViewModel.kt", i = {}, l = {480}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerViewModel$onArchiveTimeSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeInSeconds;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$onArchiveTimeSelected$1(PlayerViewModel playerViewModel, long j, Continuation<? super PlayerViewModel$onArchiveTimeSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
        this.$timeInSeconds = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$onArchiveTimeSelected$1(this.this$0, this.$timeInSeconds, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$onArchiveTimeSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerViewModel.PlayerState.IntercomArchive.INSTANCE) || Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerViewModel.PlayerState.CallArchive.INSTANCE) || (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerViewModel.PlayerState.CameraArchive.INSTANCE) && this.this$0.getIsFlussonic())) {
                channel = this.this$0._events;
                this.label = 1;
                if (channel.send(new PlayerViewModel.Event.SeekTo(TimeUnit.SECONDS.toMillis(this.$timeInSeconds)), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerViewModel.PlayerState.CameraArchive.INSTANCE) && !this.this$0.getIsFlussonic()) {
            this.this$0.provideCameraStream(this.$timeInSeconds);
        }
        return Unit.INSTANCE;
    }
}
