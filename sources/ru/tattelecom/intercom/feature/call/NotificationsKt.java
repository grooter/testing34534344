package ru.tattelecom.intercom.feature.call;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Notifications.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a$\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f\u001a\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u001a'\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"areIncomingCallsEnabled", "", "context", "Landroid/content/Context;", "getActionText", "Landroid/text/Spannable;", "stringRes", "", "colorRes", "getCallNotification", "Landroid/app/Notification;", "playerActivityIntent", "Landroid/content/Intent;", "getMainActivityIntent", "getPlayerActivityIntent", "callLogin", "", "getSyncNotification", "workInBackgroundEnabled", "isRegistered", "(Landroid/content/Context;ZLjava/lang/Boolean;)Landroid/app/Notification;", "feature-call_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class NotificationsKt {
    public static /* synthetic */ Notification getSyncNotification$default(Context context, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 4) != 0) {
            bool = null;
        }
        return getSyncNotification(context, z, bool);
    }

    public static final Notification getSyncNotification(Context context, boolean z, Boolean bool) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(context, "context");
        PendingIntent activity = PendingIntent.getActivity(context, 0, getMainActivityIntent(context), 201326592);
        if (bool == null) {
            i = R.string.sync;
        } else if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            i = R.string.online;
        } else {
            if (!Intrinsics.areEqual((Object) bool, (Object) false)) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.offline;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (z) {
            i2 = R.string.notification_can_be_hidden_in_profile;
        } else {
            i2 = R.string.app_running_in_background;
        }
        String string2 = context.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Notification build = new NotificationCompat.Builder(context, context.getString(R.string.foreground_notification_channel_id)).setPriority(-1).setContentTitle(string).setContentText(string2).setSmallIcon(R.drawable.ic_statusbar_icon).setContentIntent(activity).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static final Notification getCallNotification(Context context, Intent playerActivityIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerActivityIntent, "playerActivityIntent");
        PendingIntent activity = PendingIntent.getActivity(context, 0, playerActivityIntent, 201326592);
        Notification build = new NotificationCompat.Builder(context, context.getString(R.string.call_notification_channel_id)).setSmallIcon(R.drawable.ic_statusbar_icon).setContentTitle(context.getString(R.string.incoming_call_title)).setContentText(context.getString(R.string.press_to_watch_video)).setPriority(2).setDefaults(2).setFullScreenIntent(activity, true).setAutoCancel(true).setOngoing(true).addAction(R.drawable.ic_end_call, getActionText(R.string.decline, android.R.color.holo_red_dark, context), PendingIntent.getBroadcast(context, 0, new Intent(context, (Class<?>) EndCallReceiver.class), 201326592)).addAction(R.drawable.ic_accept_call, getActionText(R.string.show, R.color.septenary, context), PendingIntent.getActivity(context, 0, playerActivityIntent, 201326592)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public static final Intent getMainActivityIntent(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent className = new Intent().setClassName(context, "ru.tattelecom.intercom.main.MainActivity");
        className.setAction("android.intent.action.MAIN");
        className.setFlags(603979776);
        className.addCategory("android.intent.category.LAUNCHER");
        Intrinsics.checkNotNullExpressionValue(className, "apply(...)");
        return className;
    }

    public static final Intent getPlayerActivityIntent(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent addFlags = new Intent().setClassName(context, "ru.tattelecom.intercom.feature.player.PlayerActivity").putExtra(NavArg.INTERCOM_LOGIN, str).addFlags(8388608);
        Intrinsics.checkNotNullExpressionValue(addFlags, "addFlags(...)");
        return addFlags;
    }

    private static final Spannable getActionText(int i, int i2, Context context) {
        SpannableString spannableString = new SpannableString(context.getText(i));
        if (Build.VERSION.SDK_INT >= 25) {
            spannableString.setSpan(new ForegroundColorSpan(context.getColor(i2)), 0, spannableString.length(), 0);
        }
        return spannableString;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        r2 = r5.getNotificationChannelGroup(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        r5 = r5.getNotificationChannel(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean areIncomingCallsEnabled(android.content.Context r5) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            androidx.core.app.NotificationManagerCompat r0 = androidx.core.app.NotificationManagerCompat.from(r5)
            boolean r0 = r0.areNotificationsEnabled()
            r1 = 0
            if (r0 != 0) goto L11
            return r1
        L11:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            r3 = 1
            if (r0 < r2) goto L4f
            int r0 = ru.tattelecom.intercom.feature.call.R.string.call_notification_channel_id
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.lang.String r2 = "notification"
            java.lang.Object r5 = r5.getSystemService(r2)
            android.app.NotificationManager r5 = (android.app.NotificationManager) r5
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r2 < r4) goto L40
            if (r5 == 0) goto L40
            android.app.NotificationChannelGroup r2 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m3142m(r5, r0)
            if (r2 == 0) goto L40
            boolean r2 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r2)
            if (r2 != r3) goto L40
            return r1
        L40:
            if (r5 == 0) goto L4f
            android.app.NotificationChannel r5 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r5, r0)
            if (r5 == 0) goto L4f
            int r5 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r5)
            if (r5 != 0) goto L4f
            return r1
        L4f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.call.NotificationsKt.areIncomingCallsEnabled(android.content.Context):boolean");
    }
}
