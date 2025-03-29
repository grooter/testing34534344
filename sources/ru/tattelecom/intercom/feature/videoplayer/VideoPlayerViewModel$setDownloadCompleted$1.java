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
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$setDownloadCompleted$1", f = "VideoPlayerViewModel.kt", i = {1, 1}, l = {1146, 1233, 1156}, m = "invokeSuspend", n = {"eventId", "$this$withLock_u24default$iv"}, s = {"L$1", "L$2"})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$setDownloadCompleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $downloadId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$setDownloadCompleted$1(VideoPlayerViewModel videoPlayerViewModel, long j, Continuation<? super VideoPlayerViewModel$setDownloadCompleted$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$downloadId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$setDownloadCompleted$1(this.this$0, this.$downloadId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$setDownloadCompleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0083 A[Catch: all -> 0x00a9, TryCatch #0 {all -> 0x00a9, blocks: (B:14:0x006c, B:15:0x007d, B:17:0x0083, B:21:0x0096, B:23:0x009a), top: B:13:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009a A[Catch: all -> 0x00a9, TRY_LEAVE, TryCatch #0 {all -> 0x00a9, blocks: (B:14:0x006c, B:15:0x007d, B:17:0x0083, B:21:0x0096, B:23:0x009a), top: B:13:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 3
            r3 = 1
            r4 = 2
            r5 = 0
            if (r1 == 0) goto L33
            if (r1 == r3) goto L2f
            if (r1 == r4) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.throwOnFailure(r14)
            goto Lce
        L17:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1f:
            java.lang.Object r1 = r13.L$2
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r3 = r13.L$1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r6 = r13.L$0
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r6 = (ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel) r6
            kotlin.ResultKt.throwOnFailure(r14)
            goto L6c
        L2f:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4d
        L33:
            kotlin.ResultKt.throwOnFailure(r14)
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r14 = r13.this$0
            ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor r6 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.access$getUserInteractor$p(r14)
            long r7 = r13.$downloadId
            r10 = r13
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r13.label = r3
            r9 = 0
            r11 = 2
            r12 = 0
            java.lang.Object r14 = ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor.DefaultImpls.getDownload$default(r6, r7, r9, r10, r11, r12)
            if (r14 != r0) goto L4d
            return r0
        L4d:
            ru.tattelecom.intercom.domain.model.DownloadDto r14 = (ru.tattelecom.intercom.domain.model.DownloadDto) r14
            if (r14 == 0) goto Lae
            java.lang.String r3 = r14.getUrlDescription()
            if (r3 == 0) goto Lae
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r6 = r13.this$0
            kotlinx.coroutines.sync.Mutex r1 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.access$get_downloadListMutex$p(r6)
            r13.L$0 = r6
            r13.L$1 = r3
            r13.L$2 = r1
            r13.label = r4
            java.lang.Object r14 = r1.lock(r5, r13)
            if (r14 != r0) goto L6c
            return r0
        L6c:
            kotlinx.coroutines.flow.StateFlow r14 = r6.getDownloadListFlow()     // Catch: java.lang.Throwable -> La9
            java.lang.Object r14 = r14.getValue()     // Catch: java.lang.Throwable -> La9
            java.util.List r14 = (java.util.List) r14     // Catch: java.lang.Throwable -> La9
            r7 = r14
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch: java.lang.Throwable -> La9
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> La9
        L7d:
            boolean r8 = r7.hasNext()     // Catch: java.lang.Throwable -> La9
            if (r8 == 0) goto L95
            java.lang.Object r8 = r7.next()     // Catch: java.lang.Throwable -> La9
            r9 = r8
            ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem r9 = (ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem) r9     // Catch: java.lang.Throwable -> La9
            java.lang.String r9 = r9.getEventId()     // Catch: java.lang.Throwable -> La9
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r3)     // Catch: java.lang.Throwable -> La9
            if (r9 == 0) goto L7d
            goto L96
        L95:
            r8 = r5
        L96:
            ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem r8 = (ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem) r8     // Catch: java.lang.Throwable -> La9
            if (r8 == 0) goto La5
            java.lang.Iterable r14 = (java.lang.Iterable) r14     // Catch: java.lang.Throwable -> La9
            java.util.List r14 = kotlin.collections.CollectionsKt.minus(r14, r8)     // Catch: java.lang.Throwable -> La9
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.access$updateDownloadList(r6, r14)     // Catch: java.lang.Throwable -> La9
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> La9
        La5:
            r1.unlock(r5)
            goto Lae
        La9:
            r14 = move-exception
            r1.unlock(r5)
            throw r14
        Lae:
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r14 = r13.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r14 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.access$get_events$p(r14)
            ru.tattelecom.intercom.feature.videoplayer.model.PlayerEvent$ShowSnackbar r1 = new ru.tattelecom.intercom.feature.videoplayer.model.PlayerEvent$ShowSnackbar
            int r3 = ru.tattelecom.intercom.feature.videoplayer.R.string.video_download_completed
            r6 = 0
            r1.<init>(r3, r6, r4, r5)
            r3 = r13
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r13.L$0 = r5
            r13.L$1 = r5
            r13.L$2 = r5
            r13.label = r2
            java.lang.Object r14 = r14.emit(r1, r3)
            if (r14 != r0) goto Lce
            return r0
        Lce:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$setDownloadCompleted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
