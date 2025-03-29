package ru.tattelecom.intercom.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: PushPrefsSource.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001eR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00128B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/data/prefs/PushPrefsSource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "value", "", "pushService", "getPushService", "()Ljava/lang/String;", "setPushService", "(Ljava/lang/String;)V", "pushToken", "getPushToken", "setPushToken", "", "pushTokenStatus", "getPushTokenStatus", "()Z", "setPushTokenStatus", "(Z)V", "getPushInfo", "Lru/tattelecom/intercom/data/prefs/model/PushInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPushInfo", "", "pushInfo", "(Lru/tattelecom/intercom/data/prefs/model/PushInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushPrefsSource {
    private static final String PUSH_PREFERENCES = "pushPreferences";
    private static final String PUSH_SERVICE = "pushService";
    private static final String PUSH_TOKEN = "pushToken";
    private static final String PUSH_TOKEN_STATUS = "pushTokenStatus";
    private final SharedPreferences prefs;
    private static final Mutex mutex = MutexKt.Mutex$default(false, 1, null);

    public PushPrefsSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences(PUSH_PREFERENCES, 0);
    }

    private final String getPushService() {
        return this.prefs.getString("pushService", null);
    }

    private final void setPushService(String str) {
        this.prefs.edit().putString("pushService", str).apply();
    }

    private final String getPushToken() {
        return this.prefs.getString("pushToken", null);
    }

    private final void setPushToken(String str) {
        this.prefs.edit().putString("pushToken", str).apply();
    }

    private final boolean getPushTokenStatus() {
        return this.prefs.getBoolean("pushTokenStatus", true);
    }

    private final void setPushTokenStatus(boolean z) {
        this.prefs.edit().putBoolean("pushTokenStatus", z).apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setPushInfo(ru.tattelecom.intercom.data.prefs.model.PushInfo r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.prefs.PushPrefsSource$setPushInfo$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.prefs.PushPrefsSource$setPushInfo$1 r0 = (ru.tattelecom.intercom.data.prefs.PushPrefsSource$setPushInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.prefs.PushPrefsSource$setPushInfo$1 r0 = new ru.tattelecom.intercom.data.prefs.PushPrefsSource$setPushInfo$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 != r4) goto L39
            java.lang.Object r6 = r0.L$2
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.L$1
            ru.tattelecom.intercom.data.prefs.model.PushInfo r1 = (ru.tattelecom.intercom.data.prefs.model.PushInfo) r1
            java.lang.Object r0 = r0.L$0
            ru.tattelecom.intercom.data.prefs.PushPrefsSource r0 = (ru.tattelecom.intercom.data.prefs.PushPrefsSource) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r1
            goto L56
        L39:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = ru.tattelecom.intercom.data.prefs.PushPrefsSource.mutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r0 = r7.lock(r3, r0)
            if (r0 != r1) goto L55
            return r1
        L55:
            r0 = r5
        L56:
            java.lang.String r1 = r6.getPushService()     // Catch: java.lang.Throwable -> L73
            r0.setPushService(r1)     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = r6.getPushToken()     // Catch: java.lang.Throwable -> L73
            r0.setPushToken(r1)     // Catch: java.lang.Throwable -> L73
            boolean r6 = r6.getPushTokenStatus()     // Catch: java.lang.Throwable -> L73
            r0.setPushTokenStatus(r6)     // Catch: java.lang.Throwable -> L73
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L73
            r7.unlock(r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L73:
            r6 = move-exception
            r7.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.prefs.PushPrefsSource.setPushInfo(ru.tattelecom.intercom.data.prefs.model.PushInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getPushInfo(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.prefs.model.PushInfo> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof ru.tattelecom.intercom.data.prefs.PushPrefsSource$getPushInfo$1
            if (r0 == 0) goto L14
            r0 = r6
            ru.tattelecom.intercom.data.prefs.PushPrefsSource$getPushInfo$1 r0 = (ru.tattelecom.intercom.data.prefs.PushPrefsSource$getPushInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            ru.tattelecom.intercom.data.prefs.PushPrefsSource$getPushInfo$1 r0 = new ru.tattelecom.intercom.data.prefs.PushPrefsSource$getPushInfo$1
            r0.<init>(r5, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r1 = r0.L$1
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.L$0
            ru.tattelecom.intercom.data.prefs.PushPrefsSource r0 = (ru.tattelecom.intercom.data.prefs.PushPrefsSource) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4f
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3b:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = ru.tattelecom.intercom.data.prefs.PushPrefsSource.mutex
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r0 = r6.lock(r3, r0)
            if (r0 != r1) goto L4d
            return r1
        L4d:
            r0 = r5
            r1 = r6
        L4f:
            ru.tattelecom.intercom.data.prefs.model.PushInfo r6 = new ru.tattelecom.intercom.data.prefs.model.PushInfo     // Catch: java.lang.Throwable -> L64
            java.lang.String r2 = r0.getPushService()     // Catch: java.lang.Throwable -> L64
            java.lang.String r4 = r0.getPushToken()     // Catch: java.lang.Throwable -> L64
            boolean r0 = r0.getPushTokenStatus()     // Catch: java.lang.Throwable -> L64
            r6.<init>(r2, r4, r0)     // Catch: java.lang.Throwable -> L64
            r1.unlock(r3)
            return r6
        L64:
            r6 = move-exception
            r1.unlock(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.prefs.PushPrefsSource.getPushInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
