package ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet;

import android.app.Dialog;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import ru.tattelecom.intercom.feature.videoplayer.PlaybackSpeedDialogEvent;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: SpeedPlaybackDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog$onViewCreated$4", f = "SpeedPlaybackDialog.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class SpeedPlaybackDialog$onViewCreated$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpeedPlaybackDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SpeedPlaybackDialog$onViewCreated$4(SpeedPlaybackDialog speedPlaybackDialog, Continuation<? super SpeedPlaybackDialog$onViewCreated$4> continuation) {
        super(2, continuation);
        this.this$0 = speedPlaybackDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpeedPlaybackDialog$onViewCreated$4(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpeedPlaybackDialog$onViewCreated$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: SpeedPlaybackDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog$onViewCreated$4$1", f = "SpeedPlaybackDialog.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog$onViewCreated$4$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SpeedPlaybackDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SpeedPlaybackDialog speedPlaybackDialog, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = speedPlaybackDialog;
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
            VideoPlayerViewModel sharedViewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sharedViewModel = this.this$0.getSharedViewModel();
                SharedFlow<PlaybackSpeedDialogEvent> playbackSpeedDialogEvent = sharedViewModel.getPlaybackSpeedDialogEvent();
                final SpeedPlaybackDialog speedPlaybackDialog = this.this$0;
                this.label = 1;
                if (playbackSpeedDialogEvent.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog.onViewCreated.4.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((PlaybackSpeedDialogEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(PlaybackSpeedDialogEvent playbackSpeedDialogEvent2, Continuation<? super Unit> continuation) {
                        Dialog dialog;
                        if (Intrinsics.areEqual(playbackSpeedDialogEvent2, PlaybackSpeedDialogEvent.Close.INSTANCE) && (dialog = SpeedPlaybackDialog.this.getDialog()) != null) {
                            dialog.dismiss();
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
