package ru.tattelecom.intercom.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: RemoteConfigPrefsSource.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010+\u001a\u00020,R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0011R$\u0010&\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0011¨\u0006."}, d2 = {"Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "changeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "value", "", RemoteConfigPrefsSource.IS_SHOW_TRIAL_FOR_TOOLTIPS, "()Z", "setShowTrialForToolTips", "(Z)V", RemoteConfigPrefsSource.IS_TRIAL_ACTIVATED, "setTrialActivated", "isTrialActivatedFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "", "lockGateTimeout", "getLockGateTimeout", "()I", "setLockGateTimeout", "(I)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "", "toolTips", "getToolTips", "()Ljava/lang/String;", "setToolTips", "(Ljava/lang/String;)V", "trialId", "getTrialId", "setTrialId", "trialIdFlow", "getTrialIdFlow", RemoteConfigPrefsSource.TRIAL_REMAIN_DAYS, "getTrialRemainDays", "setTrialRemainDays", "trialRemainDaysFlow", "getTrialRemainDaysFlow", "clear", "", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoteConfigPrefsSource {
    private static final String IS_SHOW_TRIAL_FOR_TOOLTIPS = "isShowTrialForToolTips";
    private static final String LOCK_GATE_TIMEOUT = "lockDoorTimeout";
    private static final String REMOTE_CONFIG_PREFERENCES = "remoteConfigPreferences";
    private static final String TOOLTIPS_MAP_STRING = "tooltipsMapString";
    private static final String TRIAL_ID = "trialId";
    private final SharedPreferences.OnSharedPreferenceChangeListener changeListener;
    private final MutableStateFlow<Boolean> isTrialActivatedFlow;
    private final SharedPreferences prefs;
    private final MutableStateFlow<Integer> trialIdFlow;
    private final MutableStateFlow<Integer> trialRemainDaysFlow;
    private static final String IS_TRIAL_ACTIVATED = "isTrialActivated";
    private static final String TRIAL_REMAIN_DAYS = "trialRemainDays";
    private static final List<String> prefsToDelete = CollectionsKt.listOf((Object[]) new String[]{IS_TRIAL_ACTIVATED, TRIAL_REMAIN_DAYS, "trialId"});

    public RemoteConfigPrefsSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(REMOTE_CONFIG_PREFERENCES, 0);
        this.prefs = sharedPreferences;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: ru.tattelecom.intercom.data.prefs.RemoteConfigPrefsSource$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                RemoteConfigPrefsSource.changeListener$lambda$0(RemoteConfigPrefsSource.this, sharedPreferences2, str);
            }
        };
        this.changeListener = onSharedPreferenceChangeListener;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.trialIdFlow = StateFlowKt.MutableStateFlow(Integer.valueOf(getTrialId()));
        this.isTrialActivatedFlow = StateFlowKt.MutableStateFlow(Boolean.valueOf(isTrialActivated()));
        this.trialRemainDaysFlow = StateFlowKt.MutableStateFlow(Integer.valueOf(getTrialRemainDays()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeListener$lambda$0(RemoteConfigPrefsSource this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -1732863847) {
                if (str.equals(TRIAL_REMAIN_DAYS)) {
                    this$0.trialRemainDaysFlow.setValue(Integer.valueOf(this$0.getTrialRemainDays()));
                }
            } else if (hashCode == -1060066607) {
                if (str.equals("trialId")) {
                    this$0.trialIdFlow.setValue(Integer.valueOf(this$0.getTrialId()));
                }
            } else if (hashCode == 1520761637 && str.equals(IS_TRIAL_ACTIVATED)) {
                this$0.isTrialActivatedFlow.setValue(Boolean.valueOf(this$0.isTrialActivated()));
            }
        }
    }

    public final MutableStateFlow<Integer> getTrialIdFlow() {
        return this.trialIdFlow;
    }

    public final MutableStateFlow<Boolean> isTrialActivatedFlow() {
        return this.isTrialActivatedFlow;
    }

    public final MutableStateFlow<Integer> getTrialRemainDaysFlow() {
        return this.trialRemainDaysFlow;
    }

    public final int getLockGateTimeout() {
        return this.prefs.getInt(LOCK_GATE_TIMEOUT, -1);
    }

    public final void setLockGateTimeout(int i) {
        this.prefs.edit().putInt(LOCK_GATE_TIMEOUT, i).apply();
    }

    public final int getTrialId() {
        return this.prefs.getInt("trialId", -1);
    }

    public final void setTrialId(int i) {
        this.prefs.edit().putInt("trialId", i).apply();
    }

    public final boolean isTrialActivated() {
        return this.prefs.getBoolean(IS_TRIAL_ACTIVATED, false);
    }

    public final void setTrialActivated(boolean z) {
        this.prefs.edit().putBoolean(IS_TRIAL_ACTIVATED, z).apply();
    }

    public final int getTrialRemainDays() {
        return this.prefs.getInt(TRIAL_REMAIN_DAYS, 0);
    }

    public final void setTrialRemainDays(int i) {
        this.prefs.edit().putInt(TRIAL_REMAIN_DAYS, i).apply();
    }

    public final String getToolTips() {
        return String.valueOf(this.prefs.getString(TOOLTIPS_MAP_STRING, ""));
    }

    public final void setToolTips(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.prefs.edit().putString(TOOLTIPS_MAP_STRING, value).apply();
    }

    public final boolean isShowTrialForToolTips() {
        return this.prefs.getBoolean(IS_SHOW_TRIAL_FOR_TOOLTIPS, false);
    }

    public final void setShowTrialForToolTips(boolean z) {
        this.prefs.edit().putBoolean(IS_SHOW_TRIAL_FOR_TOOLTIPS, z).apply();
    }

    public final void clear() {
        Iterator<T> it = prefsToDelete.iterator();
        while (it.hasNext()) {
            this.prefs.edit().remove((String) it.next()).apply();
        }
    }
}
