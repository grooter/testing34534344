package ru.tattelecom.intercom.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: SupportPrefsSource.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010$\u001a\u00020%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\rR(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR(\u0010!\u001a\u0004\u0018\u00010\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001d¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/data/prefs/SupportPrefsSource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "changeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "value", "", "policy", "getPolicy", "()Ljava/lang/String;", "setPolicy", "(Ljava/lang/String;)V", "policyFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getPolicyFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", SupportPrefsSource.SUPPORT_CONTACT_HEADER, "getSupportContactHeader", "setSupportContactHeader", "Ljava/util/Date;", SupportPrefsSource.SUPPORT_CONTACT_LAST_UPDATE, "getSupportContactLastUpdate", "()Ljava/util/Date;", "setSupportContactLastUpdate", "(Ljava/util/Date;)V", SupportPrefsSource.SUPPORT_WITH_AUTH_HEADER, "getSupportWithAuthHeader", "setSupportWithAuthHeader", SupportPrefsSource.SUPPORT_WITH_AUTH_LAST_UPDATE, "getSupportWithAuthLastUpdate", "setSupportWithAuthLastUpdate", "clear", "", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SupportPrefsSource {
    private static final String DEFAULT_POLICY = "https://policy.letai.ru/policy1.html";
    private static final String POLICY_URL = "policyUrl";
    private static final String SUPPORT_PREFERENCES = "supportPreferences";
    private final SharedPreferences.OnSharedPreferenceChangeListener changeListener;
    private final MutableStateFlow<String> policyFlow;
    private final SharedPreferences prefs;
    private static final String SUPPORT_CONTACT_LAST_UPDATE = "supportContactLastUpdate";
    private static final String SUPPORT_CONTACT_HEADER = "supportContactHeader";
    private static final String SUPPORT_WITH_AUTH_LAST_UPDATE = "supportWithAuthLastUpdate";
    private static final String SUPPORT_WITH_AUTH_HEADER = "supportWithAuthHeader";
    private static final List<String> prefsToDelete = CollectionsKt.listOf((Object[]) new String[]{SUPPORT_CONTACT_LAST_UPDATE, SUPPORT_CONTACT_HEADER, SUPPORT_WITH_AUTH_LAST_UPDATE, SUPPORT_WITH_AUTH_HEADER});

    public SupportPrefsSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(SUPPORT_PREFERENCES, 0);
        this.prefs = sharedPreferences;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: ru.tattelecom.intercom.data.prefs.SupportPrefsSource$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                SupportPrefsSource.changeListener$lambda$0(SupportPrefsSource.this, sharedPreferences2, str);
            }
        };
        this.changeListener = onSharedPreferenceChangeListener;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.policyFlow = StateFlowKt.MutableStateFlow(getPolicy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeListener$lambda$0(SupportPrefsSource this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null && str.hashCode() == -225688867 && str.equals(POLICY_URL)) {
            this$0.policyFlow.setValue(this$0.getPolicy());
        }
    }

    public final MutableStateFlow<String> getPolicyFlow() {
        return this.policyFlow;
    }

    public final Date getSupportContactLastUpdate() {
        long j = this.prefs.getLong(SUPPORT_CONTACT_LAST_UPDATE, 0L);
        if (j == 0) {
            return null;
        }
        return new Date(j);
    }

    public final void setSupportContactLastUpdate(Date date) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (date != null) {
            edit.putLong(SUPPORT_CONTACT_LAST_UPDATE, date.getTime());
        } else {
            edit.putLong(SUPPORT_CONTACT_LAST_UPDATE, 0L);
        }
        edit.apply();
    }

    public final Date getSupportWithAuthLastUpdate() {
        long j = this.prefs.getLong(SUPPORT_WITH_AUTH_LAST_UPDATE, 0L);
        if (j == 0) {
            return null;
        }
        return new Date(j);
    }

    public final void setSupportWithAuthLastUpdate(Date date) {
        SharedPreferences.Editor edit = this.prefs.edit();
        if (date != null) {
            edit.putLong(SUPPORT_WITH_AUTH_LAST_UPDATE, date.getTime());
        } else {
            edit.putLong(SUPPORT_WITH_AUTH_LAST_UPDATE, 0L);
        }
        edit.apply();
    }

    public final String getSupportContactHeader() {
        return this.prefs.getString(SUPPORT_CONTACT_HEADER, "");
    }

    public final void setSupportContactHeader(String str) {
        this.prefs.edit().putString(SUPPORT_CONTACT_HEADER, str).apply();
    }

    public final String getSupportWithAuthHeader() {
        return this.prefs.getString(SUPPORT_WITH_AUTH_HEADER, "");
    }

    public final void setSupportWithAuthHeader(String str) {
        this.prefs.edit().putString(SUPPORT_WITH_AUTH_HEADER, str).apply();
    }

    public final String getPolicy() {
        String string = this.prefs.getString(POLICY_URL, DEFAULT_POLICY);
        return string == null ? DEFAULT_POLICY : string;
    }

    public final void setPolicy(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString(POLICY_URL, value).apply();
    }

    public final void clear() {
        Iterator<T> it = prefsToDelete.iterator();
        while (it.hasNext()) {
            this.prefs.edit().remove((String) it.next()).apply();
        }
    }
}
