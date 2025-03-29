package ru.tattelecom.intercom.android.resources;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringResourceFinder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"getMessageText", "", "messageKey", "", "context", "Landroid/content/Context;", "android-resources_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StringResourceFinderKt {
    public static final CharSequence getMessageText(String str, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            String string = context.getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
            Intrinsics.checkNotNull(string);
            return string;
        } catch (Exception unused) {
            return String.valueOf(str);
        }
    }
}
