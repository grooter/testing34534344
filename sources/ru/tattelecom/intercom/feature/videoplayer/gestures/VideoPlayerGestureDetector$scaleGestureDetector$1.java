package ru.tattelecom.intercom.feature.videoplayer.gestures;

import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: VideoPlayerGestureDetector.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class VideoPlayerGestureDetector$scaleGestureDetector$1 extends FunctionReferenceImpl implements Function0<PointF> {
    VideoPlayerGestureDetector$scaleGestureDetector$1(Object obj) {
        super(0, obj, VideoPlayerGestureDetector.class, "getContentViewTranslation", "getContentViewTranslation()Landroid/graphics/PointF;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PointF invoke() {
        PointF contentViewTranslation;
        contentViewTranslation = ((VideoPlayerGestureDetector) this.receiver).getContentViewTranslation();
        return contentViewTranslation;
    }
}
