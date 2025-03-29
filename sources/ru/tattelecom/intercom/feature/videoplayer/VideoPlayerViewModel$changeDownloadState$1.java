package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$changeDownloadState$1", f = "VideoPlayerViewModel.kt", i = {1, 1}, l = {1121, 1233}, m = "invokeSuspend", n = {"eventId", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2"})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$changeDownloadState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $downloadId;
    final /* synthetic */ int $percentage;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$changeDownloadState$1(VideoPlayerViewModel videoPlayerViewModel, long j, int i, Continuation<? super VideoPlayerViewModel$changeDownloadState$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$downloadId = j;
        this.$percentage = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$changeDownloadState$1(this.this$0, this.$downloadId, this.$percentage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$changeDownloadState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0084 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:7:0x006d, B:8:0x007e, B:10:0x0084, B:13:0x0095, B:17:0x009f, B:19:0x00a3, B:20:0x00b6, B:22:0x00bc, B:24:0x00cd, B:26:0x00dd, B:29:0x00e1, B:30:0x00e6), top: B:6:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a3 A[Catch: all -> 0x00ec, TryCatch #0 {all -> 0x00ec, blocks: (B:7:0x006d, B:8:0x007e, B:10:0x0084, B:13:0x0095, B:17:0x009f, B:19:0x00a3, B:20:0x00b6, B:22:0x00bc, B:24:0x00cd, B:26:0x00dd, B:29:0x00e1, B:30:0x00e6), top: B:6:0x006d }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$changeDownloadState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
