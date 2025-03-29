package ru.tattelecom.intercom.feature.videoplayer.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.extensions.ExtensionsKt;
import ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener;

/* compiled from: VideoPlayerGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\u0010\u0012J\u0006\u0010.\u001a\u00020\u0010J\b\u0010/\u001a\u000200H\u0002J\u0016\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0010J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u000209J\b\u0010:\u001a\u00020\u0010H\u0002R&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureDetector;", "", "context", "Landroid/content/Context;", "onSingleClick", "Lkotlin/Function0;", "", "scaleView", "Landroid/view/View;", "tvScaleFactorView", "Landroid/widget/TextView;", "getScaleString", "Lkotlin/Function1;", "", "", "keepScaleFactorView", "", "onDoubleTapStarted", "(Landroid/content/Context;Lkotlin/jvm/functions/Function0;Landroid/view/View;Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "value", "", "doubleTapDelay", "getDoubleTapDelay", "()J", "setDoubleTapDelay", "(J)V", "gestureDetector", "Landroid/view/GestureDetector;", "isDoubleTappingAvailable", "()Z", "setDoubleTappingAvailable", "(Z)V", VideoPlayerViewModel.IS_LIVE, "setLive", "originContentRect", "Landroid/graphics/Rect;", "getOriginContentRect", "()Landroid/graphics/Rect;", "originContentRect$delegate", "Lkotlin/Lazy;", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "translationHandler", "Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerTranslationListener;", "videoPlayerGestureListener", "Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener;", "cancelInDoubleTapMode", "getContentViewTranslation", "Landroid/graphics/PointF;", "handleTouchEvents", "view", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "isInDoubleTapMode", "keepInDoubleTapMode", "setController", "controller", "Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener$PlayerDoubleTapListener;", "translateToOriginalRect", "Companion", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoPlayerGestureDetector {
    private static final long CORRECT_LOCATION_ANIMATION_DURATION = 300;
    private long doubleTapDelay;
    private final GestureDetector gestureDetector;
    private boolean isDoubleTappingAvailable;
    private boolean isLive;

    /* renamed from: originContentRect$delegate, reason: from kotlin metadata */
    private final Lazy originContentRect;
    private final ScaleGestureDetector scaleGestureDetector;
    private final View scaleView;
    private final VideoPlayerTranslationListener translationHandler;
    private final VideoPlayerGestureListener videoPlayerGestureListener;

    public VideoPlayerGestureDetector(Context context, Function0<Boolean> onSingleClick, View scaleView, TextView tvScaleFactorView, Function1<? super Float, String> getScaleString, Function0<Unit> keepScaleFactorView, Function0<Unit> onDoubleTapStarted) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onSingleClick, "onSingleClick");
        Intrinsics.checkNotNullParameter(scaleView, "scaleView");
        Intrinsics.checkNotNullParameter(tvScaleFactorView, "tvScaleFactorView");
        Intrinsics.checkNotNullParameter(getScaleString, "getScaleString");
        Intrinsics.checkNotNullParameter(keepScaleFactorView, "keepScaleFactorView");
        Intrinsics.checkNotNullParameter(onDoubleTapStarted, "onDoubleTapStarted");
        this.scaleView = scaleView;
        VideoPlayerGestureListener videoPlayerGestureListener = new VideoPlayerGestureListener(onSingleClick, onDoubleTapStarted);
        this.videoPlayerGestureListener = videoPlayerGestureListener;
        this.scaleGestureDetector = new ScaleGestureDetector(context, new VideoPlayerScaleListener(scaleView, tvScaleFactorView, getScaleString, keepScaleFactorView, new VideoPlayerGestureDetector$scaleGestureDetector$1(this)));
        this.originContentRect = LazyKt.lazy(new Function0<Rect>() { // from class: ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureDetector$originContentRect$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Rect invoke() {
                View view;
                view = VideoPlayerGestureDetector.this.scaleView;
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                return new Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight());
            }
        });
        this.translationHandler = new VideoPlayerTranslationListener(scaleView, new VideoPlayerGestureDetector$translationHandler$1(this));
        this.isDoubleTappingAvailable = true;
        this.isLive = true;
        this.doubleTapDelay = 1000L;
        this.gestureDetector = new GestureDetector(context, videoPlayerGestureListener);
    }

    private final Rect getOriginContentRect() {
        return (Rect) this.originContentRect.getValue();
    }

    public final boolean isDoubleTappingAvailable() {
        return this.videoPlayerGestureListener.getIsDoubleTappingAvailable();
    }

    public final void setDoubleTappingAvailable(boolean z) {
        this.videoPlayerGestureListener.setDoubleTappingAvailable(z);
        this.isDoubleTappingAvailable = z;
    }

    public final boolean isLive() {
        return this.videoPlayerGestureListener.getIsLive();
    }

    public final void setLive(boolean z) {
        this.videoPlayerGestureListener.setLive(z);
        this.isLive = z;
    }

    public final boolean isInDoubleTapMode() {
        return this.videoPlayerGestureListener.getIsDoubleTapping();
    }

    public final long getDoubleTapDelay() {
        return this.videoPlayerGestureListener.getDoubleTapDelay();
    }

    public final void setDoubleTapDelay(long j) {
        this.videoPlayerGestureListener.setDoubleTapDelay(j);
        this.doubleTapDelay = j;
    }

    public final VideoPlayerGestureDetector setController(VideoPlayerGestureListener.PlayerDoubleTapListener controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.videoPlayerGestureListener.setControls(controller);
        return this;
    }

    public final void keepInDoubleTapMode() {
        this.videoPlayerGestureListener.keepInDoubleTapMode();
    }

    public final void cancelInDoubleTapMode() {
        this.videoPlayerGestureListener.cancelInDoubleTapMode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void translateToOriginalRect() {
        PointF contentViewTranslation = getContentViewTranslation();
        if (Intrinsics.areEqual(contentViewTranslation, new PointF(0.0f, 0.0f))) {
            contentViewTranslation = null;
        }
        if (contentViewTranslation != null) {
            ViewPropertyAnimator translationYBy = ExtensionsKt.animateWithDetach(this.scaleView).translationXBy(contentViewTranslation.x).translationYBy(contentViewTranslation.y);
            translationYBy.setDuration(CORRECT_LOCATION_ANIMATION_DURATION);
            translationYBy.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.PointF getContentViewTranslation() {
        /*
            r10 = this;
            android.view.View r0 = r10.scaleView
            android.graphics.Rect r1 = r10.getOriginContentRect()
            r2 = 2
            int[] r2 = new int[r2]
            r0.getLocationOnScreen(r2)
            android.graphics.PointF r3 = new android.graphics.PointF
            r4 = 0
            r5 = r2[r4]
            int r6 = r1.left
            r7 = 0
            if (r5 <= r6) goto L1e
            int r5 = r1.left
            float r5 = (float) r5
            r4 = r2[r4]
            float r4 = (float) r4
        L1c:
            float r5 = r5 - r4
            goto L46
        L1e:
            r5 = r2[r4]
            float r5 = (float) r5
            int r6 = r0.getWidth()
            float r6 = (float) r6
            float r8 = r0.getScaleX()
            float r6 = r6 * r8
            float r5 = r5 + r6
            int r6 = r1.right
            float r6 = (float) r6
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 >= 0) goto L45
            int r5 = r1.right
            float r5 = (float) r5
            r4 = r2[r4]
            float r4 = (float) r4
            int r6 = r0.getWidth()
            float r6 = (float) r6
            float r8 = r0.getScaleX()
            float r6 = r6 * r8
            float r4 = r4 + r6
            goto L1c
        L45:
            r5 = r7
        L46:
            r4 = 1
            r6 = r2[r4]
            int r8 = r1.top
            if (r6 <= r8) goto L56
            int r0 = r1.top
            float r0 = (float) r0
            r1 = r2[r4]
            float r1 = (float) r1
            float r7 = r0 - r1
            goto L7e
        L56:
            r6 = r2[r4]
            float r6 = (float) r6
            int r8 = r0.getHeight()
            float r8 = (float) r8
            float r9 = r0.getScaleY()
            float r8 = r8 * r9
            float r6 = r6 + r8
            int r8 = r1.bottom
            float r8 = (float) r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L7e
            int r1 = r1.bottom
            float r1 = (float) r1
            r2 = r2[r4]
            float r2 = (float) r2
            int r4 = r0.getHeight()
            float r4 = (float) r4
            float r0 = r0.getScaleY()
            float r4 = r4 * r0
            float r2 = r2 + r4
            float r7 = r1 - r2
        L7e:
            r3.<init>(r5, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureDetector.getContentViewTranslation():android.graphics.PointF");
    }

    public final boolean handleTouchEvents(View view, MotionEvent event) {
        boolean onTouchEvent;
        boolean z;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        if (isDoubleTappingAvailable()) {
            z = this.scaleGestureDetector.onTouchEvent(event);
            onTouchEvent = (z && this.scaleGestureDetector.isInProgress()) ? false : this.gestureDetector.onTouchEvent(event);
            this.translationHandler.onTouch(view, event);
        } else {
            onTouchEvent = this.gestureDetector.onTouchEvent(event);
            z = false;
        }
        return onTouchEvent || (z && this.scaleGestureDetector.isInProgress());
    }
}
