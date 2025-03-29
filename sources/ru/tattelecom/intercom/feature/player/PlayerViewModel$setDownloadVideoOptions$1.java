package ru.tattelecom.intercom.feature.player;

import com.huawei.location.lite.common.http.exception.ErrorCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$setDownloadVideoOptions$1", f = "PlayerViewModel.kt", i = {}, l = {ErrorCode.HTTP_BAD_GATEWAY, 509, TarConstants.XSTAR_MAGIC_OFFSET, 515, 523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerViewModel$setDownloadVideoOptions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $duration;
    final /* synthetic */ long $startTime;
    Object L$0;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$setDownloadVideoOptions$1(PlayerViewModel playerViewModel, long j, int i, Continuation<? super PlayerViewModel$setDownloadVideoOptions$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
        this.$startTime = j;
        this.$duration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$setDownloadVideoOptions$1(this.this$0, this.$startTime, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$setDownloadVideoOptions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.player.PlayerViewModel$setDownloadVideoOptions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
