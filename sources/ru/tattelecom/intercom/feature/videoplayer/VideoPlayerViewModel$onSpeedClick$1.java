package ru.tattelecom.intercom.feature.videoplayer;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import ru.tattelecom.intercom.feature.videoplayer.PlaybackSpeedDialogEvent;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$onSpeedClick$1", f = "VideoPlayerViewModel.kt", i = {}, l = {940}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$onSpeedClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SpeedPlayback $speed;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$onSpeedClick$1(SpeedPlayback speedPlayback, VideoPlayerViewModel videoPlayerViewModel, Continuation<? super VideoPlayerViewModel$onSpeedClick$1> continuation) {
        super(2, continuation);
        this.$speed = speedPlayback;
        this.this$0 = videoPlayerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$onSpeedClick$1(this.$speed, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$onSpeedClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$speed.getValue() != 1.0f) {
                this.this$0.reportEvent(106, MapsKt.mapOf(TuplesKt.to("Скорость", this.$speed.getValue() + "x")));
            }
            this.this$0.setPlaybackSpeed(this.$speed);
            List<SpeedPlayback> speedPlaybackValues = this.this$0.getSpeedPlaybackValues();
            SpeedPlayback speedPlayback = this.$speed;
            for (SpeedPlayback speedPlayback2 : speedPlaybackValues) {
                speedPlayback2.setSelected(speedPlayback2.getValue() == speedPlayback.getValue());
            }
            mutableSharedFlow = this.this$0._playbackSpeedDialogEvent;
            this.label = 1;
            if (mutableSharedFlow.emit(PlaybackSpeedDialogEvent.Close.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.updatePlaybackValues();
        return Unit.INSTANCE;
    }
}
