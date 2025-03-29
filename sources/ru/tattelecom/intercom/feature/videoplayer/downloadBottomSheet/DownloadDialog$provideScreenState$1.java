package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.ts.TsExtractor;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.databinding.DialogDownloadBinding;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.ScreenState;

/* compiled from: DownloadDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$provideScreenState$1", f = "DownloadDialog.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class DownloadDialog$provideScreenState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DownloadDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadDialog$provideScreenState$1(DownloadDialog downloadDialog, Continuation<? super DownloadDialog$provideScreenState$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadDialog$provideScreenState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadDialog$provideScreenState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: DownloadDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$provideScreenState$1$1", f = "DownloadDialog.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$provideScreenState$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DownloadDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DownloadDialog downloadDialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadDialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DownloadViewModel downloadViewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                downloadViewModel = this.this$0.getDownloadViewModel();
                StateFlow<ScreenState> screenState = downloadViewModel.getScreenState();
                final DownloadDialog downloadDialog = this.this$0;
                this.label = 1;
                if (screenState.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.provideScreenState.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ScreenState) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ScreenState screenState2, Continuation<? super Unit> continuation) {
                        DialogDownloadBinding binding;
                        DialogDownloadBinding binding2;
                        if (Intrinsics.areEqual(screenState2, ScreenState.VideoDownloadSettings.INSTANCE)) {
                            binding2 = DownloadDialog.this.getBinding();
                            LinearLayout llDownloadSetting = binding2.llDownloadSetting;
                            Intrinsics.checkNotNullExpressionValue(llDownloadSetting, "llDownloadSetting");
                            llDownloadSetting.setVisibility(0);
                            LinearLayout llDownloadInfo = binding2.llDownloadInfo;
                            Intrinsics.checkNotNullExpressionValue(llDownloadInfo, "llDownloadInfo");
                            llDownloadInfo.setVisibility(8);
                        } else if (Intrinsics.areEqual(screenState2, ScreenState.VideoDownloadPreparing.INSTANCE)) {
                            binding = DownloadDialog.this.getBinding();
                            DownloadDialog downloadDialog2 = DownloadDialog.this;
                            LinearLayout llDownloadSetting2 = binding.llDownloadSetting;
                            Intrinsics.checkNotNullExpressionValue(llDownloadSetting2, "llDownloadSetting");
                            llDownloadSetting2.setVisibility(8);
                            LinearLayout llDownloadInfo2 = binding.llDownloadInfo;
                            Intrinsics.checkNotNullExpressionValue(llDownloadInfo2, "llDownloadInfo");
                            llDownloadInfo2.setVisibility(0);
                            binding.tvInfoTitle.setText(R.string.video_download_preparing_title);
                            binding.tvInfoContent.setText(R.string.video_download_preparing_body);
                            binding.ivDownloadInfo.setImageDrawable(ResourcesCompat.getDrawable(downloadDialog2.getResources(), R.drawable.ic_download_preparing, null));
                            binding.pbDownload.setProgress(0);
                            binding.tvDownloadProgress.setText(downloadDialog2.getResources().getString(R.string.video_download_percentage, Boxing.boxInt(0)));
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
