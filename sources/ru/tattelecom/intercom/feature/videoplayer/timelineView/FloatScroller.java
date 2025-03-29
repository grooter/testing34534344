package ru.tattelecom.intercom.feature.videoplayer.timelineView;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FloatScroller.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u001d\u0018\u0000 U2\u00020\u0001:\u0002UVB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0002J\u0006\u0010=\u001a\u00020\u0007J\u000e\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\nJF\u0010@\u001a\u00020:2\u0006\u00105\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nJ\u000e\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020\u0007J\u0010\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0002J\u0010\u0010K\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0002J\u0010\u0010L\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0002J\u0016\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nJ\u000e\u0010P\u001a\u00020:2\u0006\u0010<\u001a\u00020\nJ2\u0010Q\u001a\u00020:2\u0006\u00105\u001a\u00020\n2\u0006\u00107\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nH\u0007J\u0006\u0010T\u001a\u00020/R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001e\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR$\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u0018R\u001e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\fR\u001e\u00107\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\f¨\u0006W"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/FloatScroller;", "", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "flywheel", "", "(Landroid/content/Context;Landroid/view/animation/Interpolator;Z)V", "currVelocity", "", "getCurrVelocity", "()F", "<set-?>", "currX", "getCurrX", "currY", "getCurrY", "duration", "getDuration", "newX", "finalX", "getFinalX", "setFinalX", "(F)V", "newY", "finalY", "getFinalY", "setFinalY", "isFinished", "()Z", "mCurrVelocity", "mDeceleration", "mDeltaX", "mDeltaY", "mDistance", "mDurationReciprocal", "mFinalX", "mFinalY", "mFlingFriction", "mFlywheel", "mInterpolator", "mMaxX", "mMaxY", "mMinX", "mMinY", "mMode", "", "mPhysicalCoeff", "mPpi", "mStartTime", "", "mVelocity", "startX", "getStartX", "startY", "getStartY", "abortAnimation", "", "computeDeceleration", "friction", "computeScrollOffset", "extendDuration", "extend", "fling", "velX", "velY", "minX", "maxX", "minY", "maxY", "forceFinished", "finished", "getSplineDeceleration", "velocity", "getSplineFlingDistance", "getSplineFlingDuration", "isScrollingInDirection", "xvel", "yvel", "setFriction", "startScroll", "dx", "dy", "timePassed", "Companion", "ViscousFluidInterpolator", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class FloatScroller {
    private static final float DEFAULT_DURATION = 250.0f;
    private static final float END_TENSION = 1.0f;
    private static final int FLING_MODE = 1;
    private static final float INFLEXION = 0.35f;
    private static final int NB_SAMPLES = 100;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final int SCROLL_MODE = 0;
    private static final float START_TENSION = 0.5f;
    private float currX;
    private float currY;
    private float duration;
    private boolean isFinished;
    private float mCurrVelocity;
    private float mDeceleration;
    private float mDeltaX;
    private float mDeltaY;
    private float mDistance;
    private float mDurationReciprocal;
    private float mFinalX;
    private float mFinalY;
    private float mFlingFriction;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private float mMaxX;
    private float mMaxY;
    private float mMinX;
    private float mMinY;
    private int mMode;
    private final float mPhysicalCoeff;
    private final float mPpi;
    private long mStartTime;
    private float mVelocity;
    private float startX;
    private float startY;
    private static final float DECELERATION_RATE = ((float) Math.log(0.78f)) / ((float) Math.log(0.9f));
    private static final float[] SPLINE_POSITION = new float[101];
    private static final float[] SPLINE_TIME = new float[101];

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatScroller(Context context) {
        this(context, null, false, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FloatScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, false, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void startScroll(float f, float f2, float f3, float f4) {
        startScroll$default(this, f, f2, f3, f4, 0.0f, 16, null);
    }

    public FloatScroller(Context context, ViscousFluidInterpolator viscousFluidInterpolator, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.isFinished = true;
        this.mFlingFriction = ViewConfiguration.getScrollFriction();
        this.mInterpolator = viscousFluidInterpolator == null ? new ViscousFluidInterpolator() : viscousFluidInterpolator;
        this.mPpi = context.getResources().getDisplayMetrics().density * 160.0f;
        this.mDeceleration = computeDeceleration(ViewConfiguration.getScrollFriction());
        this.mFlywheel = z;
        this.mPhysicalCoeff = computeDeceleration(0.84f);
    }

    public /* synthetic */ FloatScroller(Context context, Interpolator interpolator, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : interpolator, (i & 4) != 0 ? context.getApplicationInfo().targetSdkVersion >= 11 : z);
    }

    public final float getStartX() {
        return this.startX;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final float getCurrX() {
        return this.currX;
    }

    public final float getCurrY() {
        return this.currY;
    }

    public final float getDuration() {
        return this.duration;
    }

    /* renamed from: isFinished, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    public final void setFriction(float friction) {
        this.mDeceleration = computeDeceleration(friction);
        this.mFlingFriction = friction;
    }

    private final float computeDeceleration(float friction) {
        return this.mPpi * 386.0878f * friction;
    }

    public final void forceFinished(boolean finished) {
        this.isFinished = finished;
    }

    public final float getCurrVelocity() {
        return this.mMode == 1 ? this.mCurrVelocity : this.mVelocity - ((this.mDeceleration * timePassed()) / 2000.0f);
    }

    /* renamed from: getFinalX, reason: from getter */
    public final float getMFinalX() {
        return this.mFinalX;
    }

    public final void setFinalX(float f) {
        this.mFinalX = f;
        this.mDeltaX = f - this.startX;
        this.isFinished = false;
    }

    /* renamed from: getFinalY, reason: from getter */
    public final float getMFinalY() {
        return this.mFinalY;
    }

    public final void setFinalY(float f) {
        this.mFinalY = f;
        this.mDeltaY = f - this.startY;
        this.isFinished = false;
    }

    public final boolean computeScrollOffset() {
        float f;
        float f2;
        if (this.isFinished) {
            return false;
        }
        float currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
        float f3 = this.duration;
        if (currentAnimationTimeMillis < f3) {
            int i = this.mMode;
            if (i == 0) {
                Interpolator interpolator = this.mInterpolator;
                Intrinsics.checkNotNull(interpolator);
                float interpolation = interpolator.getInterpolation(currentAnimationTimeMillis * this.mDurationReciprocal);
                this.currX = this.startX + Math.round(this.mDeltaX * interpolation);
                this.currY = this.startY + Math.round(interpolation * this.mDeltaY);
            } else if (i == 1) {
                float f4 = currentAnimationTimeMillis / f3;
                float f5 = 100;
                int i2 = (int) (f5 * f4);
                if (i2 < 100) {
                    float f6 = i2 / f5;
                    int i3 = i2 + 1;
                    float f7 = i3 / f5;
                    float[] fArr = SPLINE_POSITION;
                    float f8 = fArr[i2];
                    f2 = (fArr[i3] - f8) / (f7 - f6);
                    f = f8 + ((f4 - f6) * f2);
                } else {
                    f = 1.0f;
                    f2 = 0.0f;
                }
                this.mCurrVelocity = ((f2 * this.mDistance) / f3) * 1000.0f;
                float round = this.startX + Math.round((this.mFinalX - r0) * f);
                this.currX = round;
                float min = Math.min(round, this.mMaxX);
                this.currX = min;
                this.currX = Math.max(min, this.mMinX);
                float round2 = this.startY + Math.round(f * (this.mFinalY - r0));
                this.currY = round2;
                float min2 = Math.min(round2, this.mMaxY);
                this.currY = min2;
                float max = Math.max(min2, this.mMinY);
                this.currY = max;
                if (this.currX == this.mFinalX && max == this.mFinalY) {
                    this.isFinished = true;
                }
            }
        } else {
            this.currX = this.mFinalX;
            this.currY = this.mFinalY;
            this.isFinished = true;
        }
        return true;
    }

    public static /* synthetic */ void startScroll$default(FloatScroller floatScroller, float f, float f2, float f3, float f4, float f5, int i, Object obj) {
        if ((i & 16) != 0) {
            f5 = DEFAULT_DURATION;
        }
        floatScroller.startScroll(f, f2, f3, f4, f5);
    }

    public final void startScroll(float startX, float startY, float dx, float dy, float duration) {
        this.mMode = 0;
        this.isFinished = false;
        this.duration = duration;
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.startX = startX;
        this.startY = startY;
        this.mFinalX = startX + dx;
        this.mFinalY = startY + dy;
        this.mDeltaX = dx;
        this.mDeltaY = dy;
        this.mDurationReciprocal = 1.0f / this.duration;
    }

    public final void fling(float startX, float startY, float velX, float velY, float minX, float maxX, float minY, float maxY) {
        if (this.mFlywheel && !this.isFinished) {
            float currVelocity = getCurrVelocity();
            float f = this.mFinalX - this.startX;
            float f2 = this.mFinalY - this.startY;
            float hypot = (float) Math.hypot(f, f2);
            float f3 = (f / hypot) * currVelocity;
            float f4 = (f2 / hypot) * currVelocity;
            if (Math.signum(velX) == Math.signum(f3) && Math.signum(velY) == Math.signum(f4)) {
                velX += f3;
                velY += f4;
            }
        }
        this.mMode = 1;
        this.isFinished = false;
        float hypot2 = (float) Math.hypot(velX, velY);
        this.mVelocity = hypot2;
        this.duration = getSplineFlingDuration(hypot2);
        this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        this.startX = startX;
        this.startY = startY;
        float f5 = hypot2 == 0.0f ? 1.0f : velX / hypot2;
        float f6 = hypot2 != 0.0f ? velY / hypot2 : 1.0f;
        this.mDistance = Math.signum(hypot2) * getSplineFlingDistance(hypot2);
        this.mMinX = minX;
        this.mMaxX = maxX;
        this.mMinY = minY;
        this.mMaxY = maxY;
        float round = startX + Math.round(f5 * r11);
        this.mFinalX = round;
        float min = Math.min(round, this.mMaxX);
        this.mFinalX = min;
        this.mFinalX = Math.max(min, this.mMinX);
        float round2 = startY + Math.round(r11 * f6);
        this.mFinalY = round2;
        float min2 = Math.min(round2, this.mMaxY);
        this.mFinalY = min2;
        this.mFinalY = Math.max(min2, this.mMinY);
    }

    private final float getSplineDeceleration(float velocity) {
        return (float) Math.log((Math.abs(velocity) * INFLEXION) / (this.mFlingFriction * this.mPhysicalCoeff));
    }

    private final float getSplineFlingDuration(float velocity) {
        return ((float) Math.exp(getSplineDeceleration(velocity) / (DECELERATION_RATE - 1.0f))) * 1000.0f;
    }

    private final float getSplineFlingDistance(float velocity) {
        float splineDeceleration = getSplineDeceleration(velocity);
        float f = DECELERATION_RATE;
        return this.mFlingFriction * this.mPhysicalCoeff * ((float) Math.exp((f / (f - 1.0f)) * splineDeceleration));
    }

    public final void abortAnimation() {
        this.currX = this.mFinalX;
        this.currY = this.mFinalY;
        this.isFinished = true;
    }

    public final void extendDuration(float extend) {
        float timePassed = timePassed() + extend;
        this.duration = timePassed;
        this.mDurationReciprocal = 1.0f / timePassed;
        this.isFinished = false;
    }

    public final int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime);
    }

    public final boolean isScrollingInDirection(float xvel, float yvel) {
        return !this.isFinished && Math.signum(xvel) == Math.signum(this.mFinalX - this.startX) && Math.signum(yvel) == Math.signum(this.mFinalY - this.startY);
    }

    /* compiled from: FloatScroller.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/FloatScroller$ViscousFluidInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "getInterpolation", "", "input", "Companion", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViscousFluidInterpolator implements Interpolator {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final float VISCOUS_FLUID_NORMALIZE;
        private static final float VISCOUS_FLUID_OFFSET;
        private static final float VISCOUS_FLUID_SCALE = 8.0f;

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float input) {
            float viscousFluid = VISCOUS_FLUID_NORMALIZE * INSTANCE.viscousFluid(input);
            return viscousFluid > 0.0f ? viscousFluid + VISCOUS_FLUID_OFFSET : viscousFluid;
        }

        /* compiled from: FloatScroller.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/FloatScroller$ViscousFluidInterpolator$Companion;", "", "()V", "VISCOUS_FLUID_NORMALIZE", "", "VISCOUS_FLUID_OFFSET", "VISCOUS_FLUID_SCALE", "viscousFluid", "x", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final float viscousFluid(float x) {
                float f = x * 8.0f;
                if (f < 1.0f) {
                    return f - (1.0f - ((float) Math.exp(-f)));
                }
                return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - f))) * 0.63212055f);
            }
        }

        static {
            Companion companion = new Companion(null);
            INSTANCE = companion;
            float viscousFluid = 1.0f / companion.viscousFluid(1.0f);
            VISCOUS_FLUID_NORMALIZE = viscousFluid;
            VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * companion.viscousFluid(1.0f));
        }
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int i = 0; i < 100; i++) {
            float f11 = i / 100;
            float f12 = 1.0f;
            while (true) {
                f = ((f12 - f9) / 2.0f) + f9;
                f2 = 1.0f - f;
                f3 = f * 3.0f * f2;
                f4 = f * f * f;
                float f13 = (((f2 * P1) + (f * P2)) * f3) + f4;
                if (Math.abs(f13 - f11) < 1.0E-5d) {
                    break;
                } else if (f13 > f11) {
                    f12 = f;
                } else {
                    f9 = f;
                }
            }
            float f14 = 0.5f;
            SPLINE_POSITION[i] = (f3 * ((f2 * 0.5f) + f)) + f4;
            float f15 = 1.0f;
            while (true) {
                f5 = ((f15 - f10) / 2.0f) + f10;
                f6 = 1.0f - f5;
                f7 = f5 * 3.0f * f6;
                f8 = f5 * f5 * f5;
                float f16 = (((f6 * f14) + f5) * f7) + f8;
                if (Math.abs(f16 - f11) >= 1.0E-5d) {
                    if (f16 > f11) {
                        f15 = f5;
                    } else {
                        f10 = f5;
                    }
                    f14 = 0.5f;
                }
            }
            SPLINE_TIME[i] = (f7 * ((f6 * P1) + (f5 * P2))) + f8;
        }
        SPLINE_TIME[100] = 1.0f;
        SPLINE_POSITION[100] = 1.0f;
    }
}
