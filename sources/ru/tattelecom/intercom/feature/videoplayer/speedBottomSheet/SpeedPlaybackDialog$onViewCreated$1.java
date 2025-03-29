package ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.SpeedPlayback;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: SpeedPlaybackDialog.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class SpeedPlaybackDialog$onViewCreated$1 extends FunctionReferenceImpl implements Function1<SpeedPlayback, Unit> {
    SpeedPlaybackDialog$onViewCreated$1(Object obj) {
        super(1, obj, VideoPlayerViewModel.class, "onSpeedClick", "onSpeedClick(Lru/tattelecom/intercom/feature/videoplayer/SpeedPlayback;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpeedPlayback speedPlayback) {
        invoke2(speedPlayback);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpeedPlayback p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((VideoPlayerViewModel) this.receiver).onSpeedClick(p0);
    }
}
