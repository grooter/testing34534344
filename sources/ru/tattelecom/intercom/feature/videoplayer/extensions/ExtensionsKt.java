package ru.tattelecom.intercom.feature.videoplayer.extensions;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0014\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0000\u001a\u0014\u0010\n\u001a\u00020\b*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, d2 = {"animateWithDetach", "Landroid/view/ViewPropertyAnimator;", "Landroid/view/View;", "dpToPx", "", "res", "Landroid/content/res/Resources;", "scale", "", "", "setPivot", "point", "Landroid/graphics/PointF;", "videoplayer_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ExtensionsKt {
    public static final int dpToPx(int i, Resources res) {
        Intrinsics.checkNotNullParameter(res, "res");
        return (int) (i * (res.getDisplayMetrics().densityDpi / 160));
    }

    public static final void scale(View view, float f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setScaleX(f);
        view.setScaleY(f);
    }

    public static final void setPivot(View view, PointF point) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(point, "point");
        view.setPivotX(point.x);
        view.setPivotY(point.y);
    }

    public static final ViewPropertyAnimator animateWithDetach(final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!view.isAttachedToWindow()) {
            view.animate().cancel();
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.extensions.ExtensionsKt$animateWithDetach$$inlined$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    view2.animate().cancel();
                }
            });
        }
        ViewPropertyAnimator animate = view.animate();
        Intrinsics.checkNotNullExpressionValue(animate, "animate(...)");
        return animate;
    }
}
