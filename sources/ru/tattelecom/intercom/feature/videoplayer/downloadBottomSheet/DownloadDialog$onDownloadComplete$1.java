package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadEvent;

/* compiled from: DownloadDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$onDownloadComplete$1", f = "DownloadDialog.kt", i = {}, l = {371, 373}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class DownloadDialog$onDownloadComplete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $downloadId;
    int label;
    final /* synthetic */ DownloadDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadDialog$onDownloadComplete$1(DownloadDialog downloadDialog, long j, Continuation<? super DownloadDialog$onDownloadComplete$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadDialog;
        this.$downloadId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadDialog$onDownloadComplete$1(this.this$0, this.$downloadId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadDialog$onDownloadComplete$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DownloadViewModel downloadViewModel;
        Integer dMStatus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            downloadViewModel = this.this$0.getDownloadViewModel();
            this.label = 1;
            obj = DownloadViewModel.getDownload$default(downloadViewModel, this.$downloadId, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        dMStatus = this.this$0.getDMStatus(this.$downloadId);
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1((DownloadDto) obj, this.this$0, dMStatus, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: DownloadDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$onDownloadComplete$1$1", f = "DownloadDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$onDownloadComplete$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DownloadDto $model;
        final /* synthetic */ Integer $status;
        int label;
        final /* synthetic */ DownloadDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadDto downloadDto, DownloadDialog downloadDialog, Integer num, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$model = downloadDto;
            this.this$0 = downloadDialog;
            this.$status = num;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$model, this.this$0, this.$status, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DownloadViewModel downloadViewModel;
            VideoPlayerViewModel videoPlayerViewModel;
            VideoPlayerViewModel videoPlayerViewModel2;
            DownloadViewModel downloadViewModel2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DownloadDto downloadDto = this.$model;
            if (downloadDto != null) {
                String urlDescription = downloadDto.getUrlDescription();
                downloadViewModel = this.this$0.getDownloadViewModel();
                if (Intrinsics.areEqual(urlDescription, downloadViewModel.getUrlDescription())) {
                    Integer num = this.$status;
                    if (num != null && num.intValue() == 8) {
                        videoPlayerViewModel2 = this.this$0.getVideoPlayerViewModel();
                        VideoPlayerViewModel.reportEvent$default(videoPlayerViewModel2, this.$model.isIntercomStream() ? 40 : 44, null, 2, null);
                        downloadViewModel2 = this.this$0.getDownloadViewModel();
                        downloadViewModel2.sendEvent(DownloadEvent.DownloadComplete.INSTANCE);
                    } else {
                        Integer num2 = this.$status;
                        if (num2 != null && num2.intValue() == 16) {
                            videoPlayerViewModel = this.this$0.getVideoPlayerViewModel();
                            VideoPlayerViewModel.reportEvent$default(videoPlayerViewModel, this.$model.isIntercomStream() ? 40 : 44, null, 2, null);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }
}
