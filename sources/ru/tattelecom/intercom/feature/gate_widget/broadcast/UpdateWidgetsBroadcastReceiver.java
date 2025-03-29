package ru.tattelecom.intercom.feature.gate_widget.broadcast;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.gate_widget.GateWidgetProvider;

/* compiled from: UpdateWidgetsBroadcastReceiver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/broadcast/UpdateWidgetsBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intect", "Landroid/content/Intent;", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UpdateWidgetsBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intect) {
        if (context == null) {
            return;
        }
        int[] appWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, (Class<?>) GateWidgetProvider.class));
        Intrinsics.checkNotNullExpressionValue(appWidgetIds, "getAppWidgetIds(...)");
        for (int i : appWidgetIds) {
            GateWidgetProvider.Companion.provideWidget$default(GateWidgetProvider.INSTANCE, context, i, 0, 4, null);
        }
    }
}
