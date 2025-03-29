package ru.tattelecom.intercom.android.resources.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickableMotionLayout.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/ClickableMotionLayout;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mDownX", "", "mDownY", "mSlop", "mSwiping", "", "onInterceptTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClickableMotionLayout extends MotionLayout {
    private float mDownX;
    private float mDownY;
    private final int mSlop;
    private boolean mSwiping;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableMotionLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableMotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickableMotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r6) {
        Integer valueOf = r6 != null ? Integer.valueOf(r6.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            this.mDownX = r6.getX();
            this.mDownY = r6.getY();
            this.mSwiping = false;
            return super.onInterceptTouchEvent(r6);
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            if (this.mSwiping) {
                return super.onInterceptTouchEvent(r6);
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            float x = r6.getX();
            float y = r6.getY();
            float abs = Math.abs(x - this.mDownX);
            float abs2 = Math.abs(y - this.mDownY);
            if (abs2 > this.mSlop && abs2 / 2 > abs) {
                this.mSwiping = true;
            }
        }
        return false;
    }
}
