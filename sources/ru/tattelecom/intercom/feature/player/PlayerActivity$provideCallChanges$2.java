package ru.tattelecom.intercom.feature.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$2", f = "PlayerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerActivity$provideCallChanges$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideCallChanges$2(PlayerActivity playerActivity, Continuation<? super PlayerActivity$provideCallChanges$2> continuation) {
        super(2, continuation);
        this.this$0 = playerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlayerActivity$provideCallChanges$2 playerActivity$provideCallChanges$2 = new PlayerActivity$provideCallChanges$2(this.this$0, continuation);
        playerActivity$provideCallChanges$2.Z$0 = ((Boolean) obj).booleanValue();
        return playerActivity$provideCallChanges$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((PlayerActivity$provideCallChanges$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
    
        r0 = r5.this$0.streamPlayer;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r5.label
            if (r0 != 0) goto L53
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r5.Z$0
            ru.tattelecom.intercom.feature.player.PlayerActivity r0 = r5.this$0
            ru.tattelecom.intercom.feature.player.PlayerViewModel r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getViewModel(r0)
            r0.onSipVideoLoaded(r6)
            if (r6 == 0) goto L22
            ru.tattelecom.intercom.feature.player.PlayerActivity r0 = r5.this$0
            androidx.media3.exoplayer.ExoPlayer r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getStreamPlayer$p(r0)
            if (r0 == 0) goto L22
            r0.release()
        L22:
            ru.tattelecom.intercom.feature.player.PlayerActivity r0 = r5.this$0
            ru.tattelecom.intercom.feature.player.PlayerViewModel r1 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getViewModel(r0)
            androidx.lifecycle.MutableLiveData r1 = r1.isVideoZoomed()
            java.lang.Object r1 = r1.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            ru.tattelecom.intercom.feature.player.PlayerActivity.access$setSipVideoCrop(r0, r1)
            ru.tattelecom.intercom.feature.player.PlayerActivity r0 = r5.this$0
            ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getBinding(r0)
            org.linphone.mediastream.video.capture.CaptureTextureView r1 = r0.tvSipVideo
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r6 == 0) goto L44
            r4 = r2
            goto L45
        L44:
            r4 = r3
        L45:
            r1.setAlpha(r4)
            androidx.media3.ui.PlayerView r0 = r0.vvStream
            if (r6 == 0) goto L4d
            r2 = r3
        L4d:
            r0.setAlpha(r2)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L53:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
