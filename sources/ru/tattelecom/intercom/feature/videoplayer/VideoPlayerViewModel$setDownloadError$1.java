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
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$setDownloadError$1", f = "VideoPlayerViewModel.kt", i = {1, 1}, l = {1166, 1233, 1181}, m = "invokeSuspend", n = {"eventId", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2"})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$setDownloadError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $downloadId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$setDownloadError$1(VideoPlayerViewModel videoPlayerViewModel, long j, Continuation<? super VideoPlayerViewModel$setDownloadError$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$downloadId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$setDownloadError$1(this.this$0, this.$downloadId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$setDownloadError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0087 A[Catch: all -> 0x00e5, TryCatch #0 {all -> 0x00e5, blocks: (B:14:0x0070, B:15:0x0081, B:17:0x0087, B:21:0x009a, B:23:0x009e, B:24:0x00b1, B:26:0x00b7, B:28:0x00c8, B:30:0x00d6, B:33:0x00da), top: B:13:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e A[Catch: all -> 0x00e5, TryCatch #0 {all -> 0x00e5, blocks: (B:14:0x0070, B:15:0x0081, B:17:0x0087, B:21:0x009a, B:23:0x009e, B:24:0x00b1, B:26:0x00b7, B:28:0x00c8, B:30:0x00d6, B:33:0x00da), top: B:13:0x0070 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$setDownloadError$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
