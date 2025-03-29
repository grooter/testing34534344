package ru.tattelecom.intercom.feature.videoplayer.gestures;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: VideoPlayerGestureDetector.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class VideoPlayerGestureDetector$translationHandler$1 extends FunctionReferenceImpl implements Function0<Unit> {
    VideoPlayerGestureDetector$translationHandler$1(Object obj) {
        super(0, obj, VideoPlayerGestureDetector.class, "translateToOriginalRect", "translateToOriginalRect()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((VideoPlayerGestureDetector) this.receiver).translateToOriginalRect();
    }
}
