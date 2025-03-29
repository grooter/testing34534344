package ru.tattelecom.intercom.android.resources.timerangepicker;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Dimensions.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0007"}, d2 = {"dimen", "", "Landroid/content/Context;", "resource", "dip", "value", "", "android-resources_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DimensionsKt {
    public static final int dip(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    public static final int dip(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (f * context.getResources().getDisplayMetrics().density);
    }

    public static final int dimen(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDimensionPixelSize(i);
    }
}
