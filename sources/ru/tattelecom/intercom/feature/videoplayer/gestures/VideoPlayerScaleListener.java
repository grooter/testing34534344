package ru.tattelecom.intercom.feature.videoplayer.gestures;

import android.graphics.PointF;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.tattelecom.intercom.feature.videoplayer.extensions.ExtensionsKt;

/* compiled from: VideoPlayerScaleListener.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerScaleListener;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "scaleView", "Landroid/view/View;", "tvScaleFactorView", "Landroid/widget/TextView;", "getScaleString", "Lkotlin/Function1;", "", "", "keepScaleFactorView", "Lkotlin/Function0;", "", "getContentViewTranslation", "Landroid/graphics/PointF;", "(Landroid/view/View;Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "totalScale", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "Companion", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoPlayerScaleListener implements ScaleGestureDetector.OnScaleGestureListener {
    private static final float MAX_SCALE_FACTOR = 8.0f;
    private static final float MIN_SCALE_FACTOR = 1.0f;
    private final Function0<PointF> getContentViewTranslation;
    private final Function1<Float, String> getScaleString;
    private final Function0<Unit> keepScaleFactorView;
    private final View scaleView;
    private float totalScale;
    private final TextView tvScaleFactorView;

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VideoPlayerScaleListener(View scaleView, TextView tvScaleFactorView, Function1<? super Float, String> getScaleString, Function0<Unit> keepScaleFactorView, Function0<? extends PointF> getContentViewTranslation) {
        Intrinsics.checkNotNullParameter(scaleView, "scaleView");
        Intrinsics.checkNotNullParameter(tvScaleFactorView, "tvScaleFactorView");
        Intrinsics.checkNotNullParameter(getScaleString, "getScaleString");
        Intrinsics.checkNotNullParameter(keepScaleFactorView, "keepScaleFactorView");
        Intrinsics.checkNotNullParameter(getContentViewTranslation, "getContentViewTranslation");
        this.scaleView = scaleView;
        this.tvScaleFactorView = tvScaleFactorView;
        this.getScaleString = getScaleString;
        this.keepScaleFactorView = keepScaleFactorView;
        this.getContentViewTranslation = getContentViewTranslation;
        this.totalScale = 1.0f;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        View view = this.scaleView;
        float focusX = detector.getFocusX() - view.getTranslationX();
        float pivotX = view.getPivotX();
        float f = this.totalScale;
        float f2 = 1;
        float f3 = (focusX + (pivotX * (f - f2))) / f;
        float focusY = detector.getFocusY() - view.getTranslationY();
        float pivotY = view.getPivotY();
        float f4 = this.totalScale;
        PointF pointF = new PointF(f3, (focusY + (pivotY * (f4 - f2))) / f4);
        view.setTranslationX(view.getTranslationX() - ((view.getPivotX() - pointF.x) * (this.totalScale - f2)));
        view.setTranslationY(view.getTranslationY() - ((view.getPivotY() - pointF.y) * (this.totalScale - f2)));
        ExtensionsKt.setPivot(view, pointF);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        float coerceIn = RangesKt.coerceIn(this.totalScale * detector.getScaleFactor(), 1.0f, 8.0f);
        this.totalScale = coerceIn;
        View view = this.scaleView;
        ExtensionsKt.scale(view, coerceIn);
        PointF invoke = this.getContentViewTranslation.invoke();
        view.setTranslationX(view.getTranslationX() + invoke.x);
        view.setTranslationY(view.getTranslationY() + invoke.y);
        TextView textView = this.tvScaleFactorView;
        textView.setVisibility(0);
        textView.setText(this.getScaleString.invoke(Float.valueOf(this.totalScale)));
        this.keepScaleFactorView.invoke();
        return true;
    }
}
