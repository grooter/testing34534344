package ru.tattelecom.intercom.feature.videoplayer.gestures;

import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerTranslationListener.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001c\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0017J\b\u0010\u0011\u001a\u00020\u0006H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerTranslationListener;", "Landroid/view/View$OnTouchListener;", "scaleView", "Landroid/view/View;", "translateToOriginalRect", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "moveStarted", "", "prevX", "", "prevY", "onTouch", "view", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "reset", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoPlayerTranslationListener implements View.OnTouchListener {
    private boolean moveStarted;
    private float prevX;
    private float prevY;
    private final View scaleView;
    private final Function0<Unit> translateToOriginalRect;

    public VideoPlayerTranslationListener(View scaleView, Function0<Unit> translateToOriginalRect) {
        Intrinsics.checkNotNullParameter(scaleView, "scaleView");
        Intrinsics.checkNotNullParameter(translateToOriginalRect, "translateToOriginalRect");
        this.scaleView = scaleView;
        this.translateToOriginalRect = translateToOriginalRect;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent event) {
        if (event == null || this.scaleView.getScaleX() == 1.0f) {
            return false;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.prevX = event.getX();
            this.prevY = event.getY();
        } else if (actionMasked != 1) {
            if (actionMasked != 2) {
                if (actionMasked == 6 && event.getActionIndex() == 0) {
                    try {
                        this.prevX = event.getX(1);
                        this.prevY = event.getY(1);
                    } catch (Exception unused) {
                    }
                }
            } else {
                if (event.getPointerCount() > 1) {
                    this.prevX = event.getX();
                    this.prevY = event.getY();
                    return false;
                }
                this.moveStarted = true;
                View view2 = this.scaleView;
                view2.setTranslationX(view2.getTranslationX() + (event.getX() - this.prevX));
                view2.setTranslationY(view2.getTranslationY() + (event.getY() - this.prevY));
                this.prevX = event.getX();
                this.prevY = event.getY();
            }
        } else {
            if (!this.moveStarted) {
                return false;
            }
            reset();
            this.translateToOriginalRect.invoke();
        }
        return true;
    }

    private final void reset() {
        this.prevX = 0.0f;
        this.prevY = 0.0f;
        this.moveStarted = false;
    }
}
