package ru.tattelecom.intercom.android.resources;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionChecker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lru/tattelecom/intercom/android/resources/ConnectionChecker;", "", "()V", "getConnectionType", "", "context", "Landroid/content/Context;", "getNetworkTypeString", "networkType", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectionChecker {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: ConnectionChecker.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0017\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/android/resources/ConnectionChecker$Companion;", "", "()V", "checkConnection", "", "context", "Landroid/content/Context;", "getConnectionType", "", "getNetworkQuality", "netSubType", "", "(Ljava/lang/Integer;)Z", "getNetworkTypeString", "networkType", "(Ljava/lang/Integer;)Ljava/lang/String;", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean checkConnection(Context context) {
            ConnectivityManager connectivityManager = (ConnectivityManager) (context != null ? context.getSystemService("connectivity") : null);
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
            Integer valueOf2 = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getSubtype()) : null;
            NetworkCapabilities networkCapabilities = (connectivityManager != null ? connectivityManager.getActiveNetwork() : null) != null ? connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()) : null;
            if ((valueOf != null && valueOf.intValue() == 17) || (networkCapabilities != null && networkCapabilities.hasTransport(4))) {
                return false;
            }
            if (valueOf != null && valueOf.intValue() == 1) {
                return true;
            }
            return getNetworkQuality(valueOf2);
        }

        private final boolean getNetworkQuality(Integer netSubType) {
            if (netSubType != null && netSubType.intValue() == 7) {
                return false;
            }
            if (netSubType != null && netSubType.intValue() == 4) {
                return false;
            }
            if (netSubType != null && netSubType.intValue() == 2) {
                return false;
            }
            if (netSubType != null && netSubType.intValue() == 1) {
                return false;
            }
            if (netSubType != null && netSubType.intValue() == 11) {
                return false;
            }
            return (netSubType != null && netSubType.intValue() == 5) || (netSubType != null && netSubType.intValue() == 6) || ((netSubType != null && netSubType.intValue() == 8) || ((netSubType != null && netSubType.intValue() == 10) || ((netSubType != null && netSubType.intValue() == 9) || ((netSubType != null && netSubType.intValue() == 3) || ((netSubType != null && netSubType.intValue() == 14) || ((netSubType != null && netSubType.intValue() == 12) || ((netSubType != null && netSubType.intValue() == 15) || (netSubType != null && netSubType.intValue() == 13))))))));
        }

        public final String getConnectionType(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
            Integer valueOf2 = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getSubtype()) : null;
            if (valueOf != null && valueOf.intValue() == 1) {
                return "Wi-Fi";
            }
            return getNetworkTypeString(valueOf2);
        }

        private final String getNetworkTypeString(Integer networkType) {
            return (networkType != null && networkType.intValue() == 4) ? "CDMA" : (networkType != null && networkType.intValue() == 7) ? "1xRTT" : (networkType != null && networkType.intValue() == 2) ? "EDGE" : (networkType != null && networkType.intValue() == 14) ? "eHRPD" : (networkType != null && networkType.intValue() == 5) ? "EVDO rev 0" : (networkType != null && networkType.intValue() == 6) ? "EVDO rev A" : (networkType != null && networkType.intValue() == 12) ? "EVDO rev B" : (networkType != null && networkType.intValue() == 1) ? "GPRS" : (networkType != null && networkType.intValue() == 16) ? "GSM" : (networkType != null && networkType.intValue() == 8) ? "HSDPA" : (networkType != null && networkType.intValue() == 10) ? "HSPA" : (networkType != null && networkType.intValue() == 15) ? "HSPA+" : (networkType != null && networkType.intValue() == 9) ? "HSUPA" : (networkType != null && networkType.intValue() == 11) ? "iDen" : (networkType != null && networkType.intValue() == 18) ? "IWLAN" : (networkType != null && networkType.intValue() == 13) ? "LTE" : (networkType != null && networkType.intValue() == 20) ? "NR (new radio) 5G" : (networkType != null && networkType.intValue() == 17) ? "TD_SCDMA" : (networkType != null && networkType.intValue() == 3) ? "UMTS" : "Unknown";
        }
    }

    public final String getConnectionType(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        Integer valueOf = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getType()) : null;
        Integer valueOf2 = activeNetworkInfo != null ? Integer.valueOf(activeNetworkInfo.getSubtype()) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            return "Wi-Fi";
        }
        return getNetworkTypeString(valueOf2);
    }

    public final String getNetworkTypeString(Integer networkType) {
        return (networkType != null && networkType.intValue() == 4) ? "CDMA" : (networkType != null && networkType.intValue() == 7) ? "1xRTT" : (networkType != null && networkType.intValue() == 2) ? "EDGE" : (networkType != null && networkType.intValue() == 14) ? "eHRPD" : (networkType != null && networkType.intValue() == 5) ? "EVDO rev 0" : (networkType != null && networkType.intValue() == 6) ? "EVDO rev A" : (networkType != null && networkType.intValue() == 12) ? "EVDO rev B" : (networkType != null && networkType.intValue() == 1) ? "GPRS" : (networkType != null && networkType.intValue() == 16) ? "GSM" : (networkType != null && networkType.intValue() == 8) ? "HSDPA" : (networkType != null && networkType.intValue() == 10) ? "HSPA" : (networkType != null && networkType.intValue() == 15) ? "HSPA+" : (networkType != null && networkType.intValue() == 9) ? "HSUPA" : (networkType != null && networkType.intValue() == 11) ? "iDen" : (networkType != null && networkType.intValue() == 18) ? "IWLAN" : (networkType != null && networkType.intValue() == 13) ? "LTE" : (networkType != null && networkType.intValue() == 20) ? "NR (new radio) 5G" : (networkType != null && networkType.intValue() == 17) ? "TD_SCDMA" : (networkType != null && networkType.intValue() == 3) ? "UMTS" : "[Unknown]";
    }
}
