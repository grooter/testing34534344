package ru.tattelecom.intercom.feature.videoplayer;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
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
import ru.tattelecom.intercom.feature.videoplayer.PlayerState;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$onArchiveTimeSelected$1", f = "VideoPlayerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$onArchiveTimeSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNeedToScrollEventList;
    final /* synthetic */ long $timeInMs;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$onArchiveTimeSelected$1(VideoPlayerViewModel videoPlayerViewModel, long j, boolean z, Continuation<? super VideoPlayerViewModel$onArchiveTimeSelected$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$timeInMs = j;
        this.$isNeedToScrollEventList = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$onArchiveTimeSelected$1(this.this$0, this.$timeInMs, this.$isNeedToScrollEventList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$onArchiveTimeSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.setIsLive(false);
        this.this$0.resetAxxonTimeline();
        VideoPlayerViewModel videoPlayerViewModel = this.this$0;
        long j = this.$timeInMs;
        Long value = videoPlayerViewModel.getDayStartTime().getValue();
        videoPlayerViewModel.setStreamStartTime(j - (value != null ? value.longValue() : Calendar.getInstance().getTimeInMillis()));
        if (this.this$0.getSelectedDayId().getValue().intValue() == -1) {
            this.this$0.setSelectedDayId(6);
        }
        PlayerState value2 = this.this$0.getScreenState().getValue();
        if (Intrinsics.areEqual(value2, PlayerState.Intercom.INSTANCE)) {
            this.this$0.provideIntercomStream(TimeUnit.DAYS.toMillis(1L), Boxing.boxLong(this.$timeInMs));
        } else if (Intrinsics.areEqual(value2, PlayerState.Camera.INSTANCE)) {
            VideoPlayerViewModel.provideCameraStream$default(this.this$0, 0L, Boxing.boxLong(this.$timeInMs), false, 5, null);
        }
        if (this.$isNeedToScrollEventList) {
            this.this$0.scrollEventList(this.$timeInMs);
        }
        return Unit.INSTANCE;
    }
}
