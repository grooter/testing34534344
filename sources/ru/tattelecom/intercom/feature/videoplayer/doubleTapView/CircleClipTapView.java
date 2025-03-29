package ru.tattelecom.intercom.feature.videoplayer.doubleTapView;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.R;

/* compiled from: CircleClipTapView.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010-\u001a\u00020+H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u000eH\u0002J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u000202H\u0014J(\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u00020\u001d2\u0006\u00107\u001a\u00020\u001dH\u0014J\u0014\u00108\u001a\u00020#2\f\u00109\u001a\b\u0012\u0004\u0012\u00020#0\"J\b\u0010:\u001a\u00020#H\u0002J\u0016\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000eR$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/doubleTapView/CircleClipTapView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "animationDuration", "getAnimationDuration", "()J", "setAnimationDuration", "(J)V", "", "arcSize", "getArcSize$videoplayer_release", "()F", "setArcSize$videoplayer_release", "(F)V", "backgroundPaint", "Landroid/graphics/Paint;", "cX", "cY", "circlePaint", "currentRadius", "forceReset", "", "heightPx", "", "isLeft", "maxRadius", "minRadius", "performAtEnd", "Lkotlin/Function0;", "", "getPerformAtEnd", "()Lkotlin/jvm/functions/Function0;", "setPerformAtEnd", "(Lkotlin/jvm/functions/Function0;)V", "shapePath", "Landroid/graphics/Path;", "valueAnimator", "Landroid/animation/ValueAnimator;", "widthPx", "getCircleAnimator", "invalidateWithCurrentRadius", "factor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", CmcdData.Factory.STREAMING_FORMAT_HLS, "oldw", "oldh", "resetAnimation", "body", "updatePathShape", "updatePosition", "x", "y", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CircleClipTapView extends View {
    private float arcSize;
    private Paint backgroundPaint;
    private float cX;
    private float cY;
    private Paint circlePaint;
    private float currentRadius;
    private boolean forceReset;
    private int heightPx;
    private boolean isLeft;
    private int maxRadius;
    private int minRadius;
    private Function0<Unit> performAtEnd;
    private Path shapePath;
    private ValueAnimator valueAnimator;
    private int widthPx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleClipTapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.backgroundPaint = new Paint();
        this.circlePaint = new Paint();
        this.shapePath = new Path();
        this.isLeft = true;
        if (context == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CircleClipTapView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.isLeft = obtainStyledAttributes.getBoolean(R.styleable.CircleClipTapView_isLeft, true);
        obtainStyledAttributes.recycle();
        Paint paint = this.backgroundPaint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor("#80000000"));
        Paint paint2 = this.circlePaint;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setColor(Color.parseColor("#80000000"));
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.widthPx = displayMetrics.widthPixels;
        this.heightPx = displayMetrics.heightPixels;
        this.minRadius = (int) (displayMetrics.density * 30.0f);
        this.maxRadius = (int) (displayMetrics.density * 400.0f);
        updatePathShape();
        this.valueAnimator = getCircleAnimator();
        this.performAtEnd = new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.CircleClipTapView$performAtEnd$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
        this.arcSize = 80.0f;
    }

    public final Function0<Unit> getPerformAtEnd() {
        return this.performAtEnd;
    }

    public final void setPerformAtEnd(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.performAtEnd = function0;
    }

    /* renamed from: getArcSize$videoplayer_release, reason: from getter */
    public final float getArcSize() {
        return this.arcSize;
    }

    public final void setArcSize$videoplayer_release(float f) {
        this.arcSize = f;
        updatePathShape();
    }

    private final long getAnimationDuration() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            return valueAnimator.getDuration();
        }
        return 750L;
    }

    private final void setAnimationDuration(long j) {
        getCircleAnimator().setDuration(j);
    }

    private final void invalidateWithCurrentRadius(float factor) {
        this.currentRadius = this.minRadius + ((this.maxRadius - r0) * factor);
        invalidate();
    }

    public final void updatePosition(float x, float y) {
        this.cX = x;
        this.cY = y;
        updatePathShape();
    }

    private final void updatePathShape() {
        int i = this.widthPx;
        this.shapePath.reset();
        this.shapePath.setFillType(Path.FillType.WINDING);
        boolean z = this.isLeft;
        float f = z ? 0.0f : this.widthPx;
        int i2 = z ? 1 : -1;
        this.shapePath.moveTo(f, 0.0f);
        float f2 = i2;
        float f3 = i;
        this.shapePath.lineTo(((f3 - this.arcSize) * f2) + f, 0.0f);
        Path path = this.shapePath;
        float f4 = this.arcSize;
        int i3 = this.heightPx;
        path.quadTo(((f3 + f4) * f2) + f, i3 / 2, (f2 * (f3 - f4)) + f, i3);
        this.shapePath.lineTo(f, this.heightPx);
        this.shapePath.close();
        invalidate();
    }

    private final ValueAnimator getCircleAnimator() {
        if (this.valueAnimator == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(getAnimationDuration());
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.CircleClipTapView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CircleClipTapView.getCircleAnimator$lambda$4$lambda$3(CircleClipTapView.this, valueAnimator);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.CircleClipTapView$getCircleAnimator$1$2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    CircleClipTapView.this.setVisibility(0);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    boolean z;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    z = CircleClipTapView.this.forceReset;
                    if (z) {
                        return;
                    }
                    CircleClipTapView.this.getPerformAtEnd().invoke();
                }
            });
            this.valueAnimator = ofFloat;
        }
        ValueAnimator valueAnimator = this.valueAnimator;
        Intrinsics.checkNotNull(valueAnimator);
        return valueAnimator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getCircleAnimator$lambda$4$lambda$3(CircleClipTapView this$0, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        this$0.invalidateWithCurrentRadius(((Float) animatedValue).floatValue());
    }

    public final void resetAnimation(Function0<Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.forceReset = true;
        getCircleAnimator().end();
        body.invoke();
        this.forceReset = false;
        getCircleAnimator().start();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.widthPx = w;
        this.heightPx = h;
        updatePathShape();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.clipPath(this.shapePath);
        canvas.drawPath(this.shapePath, this.backgroundPaint);
        canvas.drawCircle(this.cX, this.cY, this.currentRadius, this.circlePaint);
    }
}
