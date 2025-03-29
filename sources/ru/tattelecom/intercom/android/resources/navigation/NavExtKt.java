package ru.tattelecom.intercom.android.resources.navigation;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NavExt.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"navigateSafe", "", "Landroidx/navigation/NavController;", FirebaseAnalytics.Param.DESTINATION, "", "args", "Landroid/os/Bundle;", "navOptions", "Landroidx/navigation/NavOptions;", "android-resources_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NavExtKt {
    public static /* synthetic */ void navigateSafe$default(NavController navController, int i, Bundle bundle, NavOptions navOptions, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bundle = null;
        }
        if ((i2 & 4) != 0) {
            navOptions = null;
        }
        navigateSafe(navController, i, bundle, navOptions);
    }

    public static final void navigateSafe(NavController navController, int i, Bundle bundle, NavOptions navOptions) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        try {
            navController.navigate(i, bundle, navOptions);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
