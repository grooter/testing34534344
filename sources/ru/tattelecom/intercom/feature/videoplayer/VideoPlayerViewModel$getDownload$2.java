package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor;
import ru.tattelecom.intercom.domain.model.DownloadDto;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$getDownload$2", f = "VideoPlayerViewModel.kt", i = {}, l = {1112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$getDownload$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DownloadDto>, Object> {
    final /* synthetic */ String $downloadDescription;
    final /* synthetic */ long $downloadId;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$getDownload$2(VideoPlayerViewModel videoPlayerViewModel, long j, String str, Continuation<? super VideoPlayerViewModel$getDownload$2> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$downloadId = j;
        this.$downloadDescription = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$getDownload$2(this.this$0, this.$downloadId, this.$downloadDescription, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DownloadDto> continuation) {
        return ((VideoPlayerViewModel$getDownload$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlayerUserInteractor playerUserInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            playerUserInteractor = this.this$0.userInteractor;
            this.label = 1;
            obj = playerUserInteractor.getDownload(this.$downloadId, this.$downloadDescription, this);
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
