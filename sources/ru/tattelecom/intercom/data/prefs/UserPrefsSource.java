package ru.tattelecom.intercom.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse;

/* compiled from: UserPrefsSource.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 Y2\u00020\u0001:\u0001YB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020>J\u0006\u0010T\u001a\u00020QJ\u000e\u0010U\u001a\u00020>2\u0006\u0010R\u001a\u00020>J\u0006\u0010V\u001a\u00020\u0006J\u0006\u0010W\u001a\u00020QJ\u000e\u0010X\u001a\u00020Q2\u0006\u0010R\u001a\u00020>R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR(\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001c¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR$\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b+\u0010\t\"\u0004\b,\u0010\u000bR(\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u0016\u00100\u001a\n 2*\u0004\u0018\u00010101X\u0082\u0004¢\u0006\u0002\n\u0000R(\u00103\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u0019\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u001c¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001dR(\u00108\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0012\"\u0004\b:\u0010\u0014R(\u0010;\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0012\"\u0004\b=\u0010\u0014R(\u0010?\u001a\u0004\u0018\u00010>2\b\u0010\u0005\u001a\u0004\u0018\u00010>8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR(\u0010D\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0012\"\u0004\bF\u0010\u0014R(\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\u0005\u001a\u0004\u0018\u00010G8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\t\"\u0004\bO\u0010\u000b¨\u0006Z"}, d2 = {"Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", UserPrefsSource.CALLS_MUTED, "getCallsMuted", "()Z", "setCallsMuted", "(Z)V", "changeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "defaultRingtonePath", "", "deviceId", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", UserPrefsSource.DOUBLE_TAP_HINT_SHOWN, "getDoubleTapHintShown", "setDoubleTapHintShown", UserPrefsSource.FEAT_REMOTE_LOGGING, "getFeatRemoteLogging", "setFeatRemoteLogging", "isCallsMuted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "()Lkotlinx/coroutines/flow/MutableStateFlow;", UserPrefsSource.IS_NEW_USER, "setNewUser", "isSessionActive", UserPrefsSource.IS_WELCOME_SCREEN_SHOWN, "setWelcomeScreenShown", "isWorkInBackgroundEnabled", "", UserPrefsSource.LAST_IN_APP_REVIEW_TIME_STAMP, "getLastInAppReviewTimeStamp", "()J", "setLastInAppReviewTimeStamp", "(J)V", UserPrefsSource.NOTIFICATION_PERMISSION_REQUEST_STATUS, "getNotificationPermissionRequestStatus", "setNotificationPermissionRequestStatus", UserPrefsSource.PHONE_NUMBER, "getPhoneNumber", "setPhoneNumber", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", UserPrefsSource.RINGTONE_PATH, "getRingtonePath", "setRingtonePath", "selectedRingtonePath", "getSelectedRingtonePath", UserPrefsSource.SIP_SETTINGS_LOGIN, "getSipSettingsLogin", "setSipSettingsLogin", UserPrefsSource.SIP_SETTINGS_PASSWORD, "getSipSettingsPassword", "setSipSettingsPassword", "", UserPrefsSource.SIP_SETTINGS_REG_EXPIRE, "getSipSettingsRegExpire", "()Ljava/lang/Integer;", "setSipSettingsRegExpire", "(Ljava/lang/Integer;)V", "token", "getToken", "setToken", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", UserPrefsSource.USER_CONFIG, "getUserConfig", "()Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "setUserConfig", "(Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;)V", UserPrefsSource.WORK_IN_BACKGROUND_ENABLED, "getWorkInBackgroundEnabled", "setWorkInBackgroundEnabled", "bindWidgetIdToGateId", "", "widgetId", "gateId", "clear", "getGateIdByWidgetId", "isAdmin", "setDefaultRingtone", "unbindWidgetId", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserPrefsSource {
    private static final String DEVICE_ID = "deviceId";
    private static final String FEAT_REMOTE_LOGGING = "featRemoteLogging";
    private static final String GATE_WIDGET_ID = "gateWidgetId";
    private static final String IS_NEW_USER = "isNewUser";
    private static final String IS_WELCOME_SCREEN_SHOWN = "isWelcomeScreenShown";
    private static final String NOTIFICATION_PERMISSION_REQUEST_STATUS = "notificationPermissionRequestStatus";
    private static final String SIP_SETTINGS_LOGIN = "sipSettingsLogin";
    private static final String SIP_SETTINGS_PASSWORD = "sipSettingsPassword";
    private static final String SIP_SETTINGS_REG_EXPIRE = "sipSettingsRegExpire";
    private static final String TOKEN = "token";
    private static final String USER_PREFERENCES = "userPreferences";
    private final SharedPreferences.OnSharedPreferenceChangeListener changeListener;
    private final String defaultRingtonePath;
    private final MutableStateFlow<Boolean> isCallsMuted;
    private final MutableStateFlow<Boolean> isSessionActive;
    private final MutableStateFlow<Boolean> isWorkInBackgroundEnabled;
    private final SharedPreferences prefs;
    private final MutableStateFlow<String> selectedRingtonePath;
    private static final String[] adminPhoneNumbers = {"79523102385", "79196913194"};
    private static final String CALLS_MUTED = "callsMuted";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String RINGTONE_PATH = "ringtonePath";
    private static final String WORK_IN_BACKGROUND_ENABLED = "workInBackgroundEnabled";
    private static final String LAST_IN_APP_REVIEW_TIME_STAMP = "lastInAppReviewTimeStamp";
    private static final String DOUBLE_TAP_HINT_SHOWN = "doubleTapHintShown";
    private static final String USER_CONFIG = "userConfig";
    private static final List<String> prefsToDelete = CollectionsKt.listOf((Object[]) new String[]{"token", "deviceId", CALLS_MUTED, PHONE_NUMBER, RINGTONE_PATH, WORK_IN_BACKGROUND_ENABLED, LAST_IN_APP_REVIEW_TIME_STAMP, DOUBLE_TAP_HINT_SHOWN, USER_CONFIG});

    public UserPrefsSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(USER_PREFERENCES, 0);
        this.prefs = sharedPreferences;
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: ru.tattelecom.intercom.data.prefs.UserPrefsSource$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                UserPrefsSource.changeListener$lambda$0(UserPrefsSource.this, sharedPreferences2, str);
            }
        };
        this.changeListener = onSharedPreferenceChangeListener;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        String token = getToken();
        this.isSessionActive = StateFlowKt.MutableStateFlow(Boolean.valueOf(!(token == null || token.length() == 0)));
        this.isCallsMuted = StateFlowKt.MutableStateFlow(Boolean.valueOf(getCallsMuted()));
        this.isWorkInBackgroundEnabled = StateFlowKt.MutableStateFlow(Boolean.valueOf(getWorkInBackgroundEnabled()));
        this.selectedRingtonePath = StateFlowKt.MutableStateFlow(getRingtonePath());
        this.defaultRingtonePath = "android.resource://" + context.getPackageName() + "/raw/ringtone_intercom";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final void changeListener$lambda$0(UserPrefsSource this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            switch (str.hashCode()) {
                case -1826222954:
                    if (str.equals(CALLS_MUTED)) {
                        this$0.isCallsMuted.setValue(Boolean.valueOf(this$0.getCallsMuted()));
                        break;
                    }
                    break;
                case -1428054851:
                    if (str.equals(WORK_IN_BACKGROUND_ENABLED)) {
                        this$0.isWorkInBackgroundEnabled.setValue(Boolean.valueOf(this$0.getWorkInBackgroundEnabled()));
                        break;
                    }
                    break;
                case -515476761:
                    if (str.equals(RINGTONE_PATH)) {
                        this$0.selectedRingtonePath.setValue(this$0.getRingtonePath());
                        break;
                    }
                    break;
                case 110541305:
                    if (str.equals("token")) {
                        MutableStateFlow<Boolean> mutableStateFlow = this$0.isSessionActive;
                        String string = sharedPreferences.getString("token", null);
                        mutableStateFlow.setValue(Boolean.valueOf(!(string == null || string.length() == 0)));
                        break;
                    }
                    break;
            }
        }
    }

    public final MutableStateFlow<Boolean> isSessionActive() {
        return this.isSessionActive;
    }

    public final MutableStateFlow<Boolean> isCallsMuted() {
        return this.isCallsMuted;
    }

    public final MutableStateFlow<Boolean> isWorkInBackgroundEnabled() {
        return this.isWorkInBackgroundEnabled;
    }

    public final MutableStateFlow<String> getSelectedRingtonePath() {
        return this.selectedRingtonePath;
    }

    public final String getDeviceId() {
        return this.prefs.getString("deviceId", "device_id");
    }

    public final void setDeviceId(String str) {
        this.prefs.edit().putString("deviceId", str).apply();
    }

    public final String getPhoneNumber() {
        return this.prefs.getString(PHONE_NUMBER, null);
    }

    public final void setPhoneNumber(String str) {
        this.prefs.edit().putString(PHONE_NUMBER, str).apply();
    }

    public final String getToken() {
        return this.prefs.getString("token", null);
    }

    public final void setToken(String str) {
        this.prefs.edit().putString("token", str).apply();
    }

    public final String isNewUser() {
        return this.prefs.getString(IS_NEW_USER, null);
    }

    public final void setNewUser(String str) {
        this.prefs.edit().putString(IS_NEW_USER, str).apply();
    }

    public final ConfigResponse getUserConfig() {
        String str = "";
        try {
            Json.Companion companion = Json.INSTANCE;
            String string = this.prefs.getString(USER_CONFIG, "");
            if (string != null) {
                str = string;
            }
            KSerializer<Object> serializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(ConfigResponse.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (ConfigResponse) companion.decodeFromString(serializer, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void setUserConfig(ConfigResponse configResponse) {
        SharedPreferences.Editor edit = this.prefs.edit();
        Json.Companion companion = Json.INSTANCE;
        KSerializer<Object> serializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(ConfigResponse.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        edit.putString(USER_CONFIG, companion.encodeToString(serializer, configResponse)).apply();
    }

    public final long getLastInAppReviewTimeStamp() {
        return this.prefs.getLong(LAST_IN_APP_REVIEW_TIME_STAMP, 0L);
    }

    public final void setLastInAppReviewTimeStamp(long j) {
        this.prefs.edit().putLong(LAST_IN_APP_REVIEW_TIME_STAMP, j).apply();
    }

    public final boolean isWelcomeScreenShown() {
        return this.prefs.getBoolean(IS_WELCOME_SCREEN_SHOWN, false);
    }

    public final void setWelcomeScreenShown(boolean z) {
        this.prefs.edit().putBoolean(IS_WELCOME_SCREEN_SHOWN, z).apply();
    }

    public final boolean getCallsMuted() {
        return this.prefs.getBoolean(CALLS_MUTED, false);
    }

    public final void setCallsMuted(boolean z) {
        this.prefs.edit().putBoolean(CALLS_MUTED, z).apply();
    }

    public final boolean getFeatRemoteLogging() {
        return this.prefs.getBoolean(FEAT_REMOTE_LOGGING, false);
    }

    public final void setFeatRemoteLogging(boolean z) {
        this.prefs.edit().putBoolean(FEAT_REMOTE_LOGGING, z).apply();
    }

    public final String getSipSettingsLogin() {
        return this.prefs.getString(SIP_SETTINGS_LOGIN, "");
    }

    public final void setSipSettingsLogin(String str) {
        this.prefs.edit().putString(SIP_SETTINGS_LOGIN, str).apply();
    }

    public final String getSipSettingsPassword() {
        return this.prefs.getString(SIP_SETTINGS_PASSWORD, null);
    }

    public final void setSipSettingsPassword(String str) {
        if (str != null) {
            this.prefs.edit().putString(SIP_SETTINGS_PASSWORD, str).apply();
        }
    }

    public final Integer getSipSettingsRegExpire() {
        return Integer.valueOf(this.prefs.getInt(SIP_SETTINGS_REG_EXPIRE, -1));
    }

    public final void setSipSettingsRegExpire(Integer num) {
        if (num != null) {
            this.prefs.edit().putInt(SIP_SETTINGS_REG_EXPIRE, num.intValue()).apply();
        }
    }

    public final String getRingtonePath() {
        return this.prefs.getString(RINGTONE_PATH, null);
    }

    public final void setRingtonePath(String str) {
        this.prefs.edit().putString(RINGTONE_PATH, str).apply();
    }

    public final boolean getNotificationPermissionRequestStatus() {
        return this.prefs.getBoolean(NOTIFICATION_PERMISSION_REQUEST_STATUS, false);
    }

    public final void setNotificationPermissionRequestStatus(boolean z) {
        this.prefs.edit().putBoolean(NOTIFICATION_PERMISSION_REQUEST_STATUS, z).apply();
    }

    public final boolean getWorkInBackgroundEnabled() {
        return this.prefs.getBoolean(WORK_IN_BACKGROUND_ENABLED, false);
    }

    public final void setWorkInBackgroundEnabled(boolean z) {
        this.prefs.edit().putBoolean(WORK_IN_BACKGROUND_ENABLED, z).apply();
    }

    public final boolean getDoubleTapHintShown() {
        return this.prefs.getBoolean(DOUBLE_TAP_HINT_SHOWN, false);
    }

    public final void setDoubleTapHintShown(boolean z) {
        this.prefs.edit().putBoolean(DOUBLE_TAP_HINT_SHOWN, z).apply();
    }

    public final boolean isAdmin() {
        return ArraysKt.contains(adminPhoneNumbers, getPhoneNumber());
    }

    public final void setDefaultRingtone() {
        setRingtonePath(this.defaultRingtonePath);
    }

    public final void bindWidgetIdToGateId(int widgetId, int gateId) {
        this.prefs.edit().putInt(GATE_WIDGET_ID + widgetId, gateId).apply();
    }

    public final int getGateIdByWidgetId(int widgetId) {
        return this.prefs.getInt(GATE_WIDGET_ID + widgetId, 0);
    }

    public final void unbindWidgetId(int widgetId) {
        this.prefs.edit().remove(GATE_WIDGET_ID + widgetId).apply();
    }

    public final void clear() {
        Iterator<T> it = prefsToDelete.iterator();
        while (it.hasNext()) {
            this.prefs.edit().remove((String) it.next()).apply();
        }
    }
}
