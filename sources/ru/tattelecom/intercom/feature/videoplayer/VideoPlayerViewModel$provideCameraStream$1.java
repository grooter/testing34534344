package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$provideCameraStream$1", f = "VideoPlayerViewModel.kt", i = {2, 2}, l = {TarConstants.XSTAR_MAGIC_OFFSET, 520, 529}, m = "invokeSuspend", n = {"streamSource", "url"}, s = {"L$0", "L$2"})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$provideCameraStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $additionalTimeInMs;
    final /* synthetic */ boolean $isInit;
    final /* synthetic */ Long $startTimeInSeconds;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$provideCameraStream$1(VideoPlayerViewModel videoPlayerViewModel, Long l, long j, boolean z, Continuation<? super VideoPlayerViewModel$provideCameraStream$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$startTimeInSeconds = l;
        this.$additionalTimeInMs = j;
        this.$isInit = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$provideCameraStream$1(this.this$0, this.$startTimeInSeconds, this.$additionalTimeInMs, this.$isInit, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$provideCameraStream$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0105 A[Catch: all -> 0x0034, Exception -> 0x0169, TryCatch #2 {Exception -> 0x0169, all -> 0x0034, blocks: (B:8:0x001e, B:9:0x00f8, B:11:0x0105, B:12:0x0108, B:23:0x002b, B:24:0x00d2, B:25:0x00d4, B:27:0x00da, B:29:0x00e4, B:34:0x0125, B:36:0x012f, B:37:0x0030, B:38:0x0076, B:40:0x003a, B:41:0x0040, B:44:0x0054, B:46:0x0058, B:49:0x0079, B:51:0x0081, B:52:0x00b4, B:55:0x0088), top: B:2:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$provideCameraStream$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
