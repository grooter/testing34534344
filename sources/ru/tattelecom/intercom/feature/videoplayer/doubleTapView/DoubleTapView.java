package ru.tattelecom.intercom.feature.videoplayer.doubleTapView;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.databinding.DoubleTapViewBinding;
import ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView;
import ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener;

/* compiled from: DoubleTapView.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\"B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001f\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0017\u0010 \u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010!R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0010¨\u0006#"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/doubleTapView/DoubleTapView;", "Landroid/widget/FrameLayout;", "Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener$PlayerDoubleTapListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/DoubleTapViewBinding;", "performListener", "Lru/tattelecom/intercom/feature/videoplayer/doubleTapView/DoubleTapView$PerformListener;", "value", "", "secondsBackward", "setSecondsBackward", "(I)V", "secondsForward", "setSecondsForward", "seekSeconds", "getSeekSeconds", "()I", "setSeekSeconds", "isLeft", "", "posX", "", "posY", "(FF)Ljava/lang/Boolean;", "onDoubleTapProgressUp", "", "setPerformListener", "shouldForward", "(F)Ljava/lang/Boolean;", "PerformListener", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DoubleTapView extends FrameLayout implements VideoPlayerGestureListener.PlayerDoubleTapListener {
    private final DoubleTapViewBinding binding;
    private PerformListener performListener;
    private int secondsBackward;
    private int secondsForward;
    private int seekSeconds;

    /* compiled from: DoubleTapView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/doubleTapView/DoubleTapView$PerformListener;", "", "onAnimationEnd", "", "seconds", "", "onAnimationStart", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface PerformListener {
        void onAnimationEnd(long seconds);

        void onAnimationStart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DoubleTapView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DoubleTapView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.PlayerDoubleTapListener
    public void onDoubleTapFinished() {
        VideoPlayerGestureListener.PlayerDoubleTapListener.DefaultImpls.onDoubleTapFinished(this);
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.PlayerDoubleTapListener
    public void onDoubleTapProgressDown(float f, float f2) {
        VideoPlayerGestureListener.PlayerDoubleTapListener.DefaultImpls.onDoubleTapProgressDown(this, f, f2);
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.PlayerDoubleTapListener
    public void onDoubleTapStarted(float f, float f2) {
        VideoPlayerGestureListener.PlayerDoubleTapListener.DefaultImpls.onDoubleTapStarted(this, f, f2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DoubleTapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        final DoubleTapViewBinding inflate = DoubleTapViewBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        inflate.cctvForward.setPerformAtEnd(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DoubleTapView.PerformListener performListener;
                int i;
                performListener = DoubleTapView.this.performListener;
                if (performListener != null) {
                    i = DoubleTapView.this.secondsForward;
                    performListener.onAnimationEnd(i);
                }
                inflate.clForward.setVisibility(4);
                DoubleTapView.this.setSecondsForward(0);
            }
        });
        inflate.cctvBackward.setPerformAtEnd(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                DoubleTapView.PerformListener performListener;
                int i;
                performListener = DoubleTapView.this.performListener;
                if (performListener != null) {
                    i = DoubleTapView.this.secondsBackward;
                    performListener.onAnimationEnd(-i);
                }
                inflate.clBackward.setVisibility(4);
                DoubleTapView.this.setSecondsBackward(0);
            }
        });
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DoubleTapView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        inflate.cctvBackward.setArcSize$videoplayer_release(obtainStyledAttributes.getFloat(R.styleable.DoubleTapView_backwardArcSize, 80.0f));
        inflate.cctvForward.setArcSize$videoplayer_release(obtainStyledAttributes.getFloat(R.styleable.DoubleTapView_forwardArcSize, 80.0f));
        obtainStyledAttributes.recycle();
        this.seekSeconds = 10;
    }

    public final int getSeekSeconds() {
        return this.seekSeconds;
    }

    public final void setSeekSeconds(int i) {
        this.seekSeconds = i;
    }

    public final void setSecondsForward(int i) {
        this.binding.tvSecondsForward.setText(getContext().getResources().getQuantityString(R.plurals.quick_seek_x_second, i, Integer.valueOf(i)));
        this.secondsForward = i;
    }

    public final void setSecondsBackward(int i) {
        this.binding.tvSecondsBackward.setText(getContext().getResources().getQuantityString(R.plurals.quick_seek_x_second, i, Integer.valueOf(i)));
        this.secondsBackward = i;
    }

    public final DoubleTapView setPerformListener(PerformListener performListener) {
        Intrinsics.checkNotNullParameter(performListener, "performListener");
        this.performListener = performListener;
        return this;
    }

    private final Boolean shouldForward(float posX) {
        double d = posX;
        if (d < getWidth() * 0.3d) {
            return false;
        }
        return d > ((double) getWidth()) * 0.7d ? true : null;
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.PlayerDoubleTapListener
    public Boolean isLeft(float posX, float posY) {
        double d = posX;
        if (d < getWidth() * 0.3d) {
            return true;
        }
        return d > ((double) getWidth()) * 0.7d ? false : null;
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.PlayerDoubleTapListener
    public void onDoubleTapProgressUp(final float posX, final float posY) {
        Boolean shouldForward = shouldForward(posX);
        if (Intrinsics.areEqual((Object) shouldForward, (Object) false)) {
            if (this.binding.clBackward.getVisibility() != 0) {
                PerformListener performListener = this.performListener;
                if (performListener != null) {
                    performListener.onAnimationStart();
                }
                this.binding.clForward.setVisibility(4);
                this.binding.clBackward.setVisibility(0);
            }
            if (this.secondsForward > 0) {
                setSecondsForward(0);
                setSecondsBackward(0);
            }
            this.binding.cctvBackward.resetAnimation(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView$onDoubleTapProgressUp$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DoubleTapViewBinding doubleTapViewBinding;
                    doubleTapViewBinding = DoubleTapView.this.binding;
                    doubleTapViewBinding.cctvBackward.updatePosition(posX, posY);
                }
            });
            setSecondsBackward(this.secondsBackward + this.seekSeconds);
            return;
        }
        if (Intrinsics.areEqual((Object) shouldForward, (Object) true)) {
            if (this.binding.clForward.getVisibility() != 0) {
                PerformListener performListener2 = this.performListener;
                if (performListener2 != null) {
                    performListener2.onAnimationStart();
                }
                this.binding.clBackward.setVisibility(4);
                this.binding.clForward.setVisibility(0);
            }
            if (this.secondsBackward > 0) {
                setSecondsBackward(0);
                setSecondsForward(0);
            }
            this.binding.cctvForward.resetAnimation(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView$onDoubleTapProgressUp$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DoubleTapViewBinding doubleTapViewBinding;
                    DoubleTapViewBinding doubleTapViewBinding2;
                    doubleTapViewBinding = DoubleTapView.this.binding;
                    CircleClipTapView circleClipTapView = doubleTapViewBinding.cctvForward;
                    float f = posX;
                    doubleTapViewBinding2 = DoubleTapView.this.binding;
                    circleClipTapView.updatePosition(f - doubleTapViewBinding2.clForward.getLeft(), posY);
                }
            });
            setSecondsForward(this.secondsForward + this.seekSeconds);
        }
    }
}
