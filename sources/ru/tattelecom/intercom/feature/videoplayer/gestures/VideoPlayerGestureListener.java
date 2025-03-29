package ru.tattelecom.intercom.feature.videoplayer.gestures;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.huawei.hms.feature.dynamic.e.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: VideoPlayerGestureListener.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u0000 52\u00020\u0001:\u000256B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010 \u001a\u00020\u0006J\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J*\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J*\u0010/\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020$2\u0006\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020,H\u0016J\u0010\u00102\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00103\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010#\u001a\u00020$H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleClick", "Lkotlin/Function0;", "", "onDoubleTapStarted", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "controls", "Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener$PlayerDoubleTapListener;", "getControls", "()Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener$PlayerDoubleTapListener;", "setControls", "(Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener$PlayerDoubleTapListener;)V", "doubleTapDelay", "", "getDoubleTapDelay", "()J", "setDoubleTapDelay", "(J)V", "isDoubleTapping", "()Z", "setDoubleTapping", "(Z)V", "isDoubleTappingAvailable", "setDoubleTappingAvailable", VideoPlayerViewModel.IS_LIVE, "setLive", "mHandler", "Landroid/os/Handler;", "mRunnable", "Ljava/lang/Runnable;", "cancelInDoubleTapMode", "keepInDoubleTapMode", "onContextClick", e.f202a, "Landroid/view/MotionEvent;", "onDoubleTap", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "", "velocityY", "onLongPress", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "Companion", "PlayerDoubleTapListener", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoPlayerGestureListener extends GestureDetector.SimpleOnGestureListener {
    private static boolean DEBUG = true;
    private static final String TAG = "VideoPlayerGestureListener";
    private PlayerDoubleTapListener controls;
    private long doubleTapDelay;
    private boolean isDoubleTapping;
    private boolean isDoubleTappingAvailable;
    private boolean isLive;
    private final Handler mHandler;
    private final Runnable mRunnable;
    private final Function0<Unit> onDoubleTapStarted;
    private final Function0<Boolean> onSingleClick;

    /* compiled from: VideoPlayerGestureListener.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureListener$PlayerDoubleTapListener;", "", "isLeft", "", "posX", "", "posY", "(FF)Ljava/lang/Boolean;", "onDoubleTapFinished", "", "onDoubleTapProgressDown", "onDoubleTapProgressUp", "onDoubleTapStarted", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface PlayerDoubleTapListener {

        /* compiled from: VideoPlayerGestureListener.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onDoubleTapFinished(PlayerDoubleTapListener playerDoubleTapListener) {
            }

            public static void onDoubleTapProgressDown(PlayerDoubleTapListener playerDoubleTapListener, float f, float f2) {
            }

            public static void onDoubleTapProgressUp(PlayerDoubleTapListener playerDoubleTapListener, float f, float f2) {
            }

            public static void onDoubleTapStarted(PlayerDoubleTapListener playerDoubleTapListener, float f, float f2) {
            }
        }

        Boolean isLeft(float posX, float posY);

        void onDoubleTapFinished();

        void onDoubleTapProgressDown(float posX, float posY);

        void onDoubleTapProgressUp(float posX, float posY);

        void onDoubleTapStarted(float posX, float posY);
    }

    public VideoPlayerGestureListener(Function0<Boolean> onSingleClick, Function0<Unit> onDoubleTapStarted) {
        Intrinsics.checkNotNullParameter(onSingleClick, "onSingleClick");
        Intrinsics.checkNotNullParameter(onDoubleTapStarted, "onDoubleTapStarted");
        this.onSingleClick = onSingleClick;
        this.onDoubleTapStarted = onDoubleTapStarted;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mRunnable = new Runnable() { // from class: ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayerGestureListener.mRunnable$lambda$0(VideoPlayerGestureListener.this);
            }
        };
        this.isDoubleTappingAvailable = true;
        this.isLive = true;
        this.doubleTapDelay = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunnable$lambda$0(VideoPlayerGestureListener this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (DEBUG) {
            Log.d(TAG, "Runnable called");
        }
        this$0.isDoubleTapping = false;
        PlayerDoubleTapListener playerDoubleTapListener = this$0.controls;
        if (playerDoubleTapListener != null) {
            playerDoubleTapListener.onDoubleTapFinished();
        }
    }

    public final PlayerDoubleTapListener getControls() {
        return this.controls;
    }

    public final void setControls(PlayerDoubleTapListener playerDoubleTapListener) {
        this.controls = playerDoubleTapListener;
    }

    /* renamed from: isDoubleTappingAvailable, reason: from getter */
    public final boolean getIsDoubleTappingAvailable() {
        return this.isDoubleTappingAvailable;
    }

    public final void setDoubleTappingAvailable(boolean z) {
        this.isDoubleTappingAvailable = z;
    }

    /* renamed from: isLive, reason: from getter */
    public final boolean getIsLive() {
        return this.isLive;
    }

    public final void setLive(boolean z) {
        this.isLive = z;
    }

    /* renamed from: isDoubleTapping, reason: from getter */
    public final boolean getIsDoubleTapping() {
        return this.isDoubleTapping;
    }

    public final void setDoubleTapping(boolean z) {
        this.isDoubleTapping = z;
    }

    public final long getDoubleTapDelay() {
        return this.doubleTapDelay;
    }

    public final void setDoubleTapDelay(long j) {
        this.doubleTapDelay = j;
    }

    public final void keepInDoubleTapMode() {
        this.isDoubleTapping = true;
        this.mHandler.removeCallbacks(this.mRunnable);
        this.mHandler.postDelayed(this.mRunnable, this.doubleTapDelay);
    }

    public final void cancelInDoubleTapMode() {
        this.mHandler.removeCallbacks(this.mRunnable);
        this.isDoubleTapping = false;
        PlayerDoubleTapListener playerDoubleTapListener = this.controls;
        if (playerDoubleTapListener != null) {
            playerDoubleTapListener.onDoubleTapFinished();
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (DEBUG) {
            Log.d(TAG, "onSingleTapConfirmed: isDoubleTap = " + this.isDoubleTapping);
        }
        if (this.isDoubleTapping) {
            return true;
        }
        return this.onSingleClick.invoke().booleanValue();
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "onScroll " + distanceX + " " + distanceY);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
    
        if ((r0 != null ? kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.isLeft(r6.getX(), r6.getY()), (java.lang.Object) false) : false) == false) goto L15;
     */
    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onDoubleTap(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.DEBUG
            if (r0 == 0) goto L10
            java.lang.String r0 = "VideoPlayerGestureListener"
            java.lang.String r1 = "onDoubleTap"
            android.util.Log.d(r0, r1)
        L10:
            boolean r0 = r5.isDoubleTapping
            r1 = 1
            if (r0 != 0) goto L51
            boolean r0 = r5.isDoubleTappingAvailable
            if (r0 == 0) goto L51
            boolean r0 = r5.isLive
            if (r0 == 0) goto L38
            ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener$PlayerDoubleTapListener r0 = r5.controls
            r2 = 0
            if (r0 == 0) goto L36
            float r3 = r6.getX()
            float r4 = r6.getY()
            java.lang.Boolean r0 = r0.isLeft(r3, r4)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
        L36:
            if (r2 != 0) goto L51
        L38:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r5.onDoubleTapStarted
            r0.invoke()
            r5.isDoubleTapping = r1
            r5.keepInDoubleTapMode()
            ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener$PlayerDoubleTapListener r0 = r5.controls
            if (r0 == 0) goto L51
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.onDoubleTapStarted(r2, r6)
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureListener.onDoubleTap(android.view.MotionEvent):boolean");
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (DEBUG) {
            Log.d(TAG, "onDoubleTapEvent");
        }
        if (e.getActionMasked() == 1 && this.isDoubleTapping) {
            if (DEBUG) {
                Log.d(TAG, "onDoubleTapEvent, ACTION_UP");
            }
            PlayerDoubleTapListener playerDoubleTapListener = this.controls;
            if (playerDoubleTapListener != null) {
                playerDoubleTapListener.onDoubleTapProgressUp(e.getX(), e.getY());
            }
            return true;
        }
        return super.onDoubleTapEvent(e);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "onFling");
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
    public boolean onContextClick(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (!DEBUG) {
            return false;
        }
        Log.d(TAG, "onContextClick");
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (DEBUG) {
            Log.d(TAG, "onDown: isDoubleTapping = " + this.isDoubleTapping);
        }
        if (this.isDoubleTapping) {
            PlayerDoubleTapListener playerDoubleTapListener = this.controls;
            if (playerDoubleTapListener == null) {
                return true;
            }
            playerDoubleTapListener.onDoubleTapProgressDown(e.getX(), e.getY());
            return true;
        }
        return super.onDown(e);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (DEBUG) {
            Log.d(TAG, "onLongPress");
        }
        super.onLongPress(e);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (DEBUG) {
            Log.d(TAG, "onShowPress");
        }
        super.onShowPress(e);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (DEBUG) {
            Log.d(TAG, "onSingleTapUp: isDoubleTapping = " + this.isDoubleTapping);
        }
        if (this.isDoubleTapping) {
            PlayerDoubleTapListener playerDoubleTapListener = this.controls;
            if (playerDoubleTapListener != null) {
                playerDoubleTapListener.onDoubleTapProgressUp(e.getX(), e.getY());
            }
            return true;
        }
        return super.onSingleTapUp(e);
    }
}
