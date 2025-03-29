package ru.tattelecom.intercom.feature.videoplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import ru.tattelecom.intercom.feature.videoplayer.model.PlayerEvent;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$saveScreenshot$1", f = "VideoPlayerViewModel.kt", i = {}, l = {860, 866, 873}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$saveScreenshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$saveScreenshot$1(VideoPlayerViewModel videoPlayerViewModel, Bitmap bitmap, Context context, Continuation<? super VideoPlayerViewModel$saveScreenshot$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$bitmap = bitmap;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$saveScreenshot$1(this.this$0, this.$bitmap, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$saveScreenshot$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            mutableSharedFlow = this.this$0._events;
            this.label = 3;
            if (mutableSharedFlow.emit(new PlayerEvent.ShowSnackbar(R.string.something_went_wrong, 0, 2, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, this.$bitmap, this.$context, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        mutableSharedFlow2 = this.this$0._events;
        this.label = 2;
        if (mutableSharedFlow2.emit(new PlayerEvent.ShowSnackbar(R.string.image_saved, 0, 2, null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* compiled from: VideoPlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$saveScreenshot$1$1", f = "VideoPlayerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$saveScreenshot$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
        final /* synthetic */ Bitmap $bitmap;
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ VideoPlayerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoPlayerViewModel videoPlayerViewModel, Bitmap bitmap, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = videoPlayerViewModel;
            this.$bitmap = bitmap;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$bitmap, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
            return invoke2(coroutineScope, (Continuation<Object>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Job saveScreenshotUsingFile;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT <= 28) {
                saveScreenshotUsingFile = this.this$0.saveScreenshotUsingFile(this.$bitmap);
                return saveScreenshotUsingFile;
            }
            VideoPlayerViewModel videoPlayerViewModel = this.this$0;
            Context context = this.$context;
            videoPlayerViewModel.saveScreenshotUsingMediaStore(context != null ? context.getApplicationContext() : null, this.$bitmap);
            return Unit.INSTANCE;
        }
    }
}
