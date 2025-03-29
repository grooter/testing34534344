package ru.tattelecom.intercom.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.common.C;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;
import ru.tattelecom.intercom.R;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationAction;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationCategory;
import ru.tattelecom.intercom.core.PushService;
import ru.tattelecom.intercom.data.helper.ExtensionsKt;
import ru.tattelecom.intercom.data.local.entity.RemoteLogMessage;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.domain.workers.SendPushTokenWorker;
import ru.tattelecom.intercom.feature.call.CallService;
import ru.tattelecom.intercom.main.MainActivity;
import ru.tattelecom.intercom.workers.SendLogsWorker;
import timber.log.Timber;

/* compiled from: HmsNotificationService.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JN\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00192\b\u0010 \u001a\u0004\u0018\u00010\u00192\b\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010\u00192\b\u0010$\u001a\u0004\u0018\u00010\u00192\b\u0010%\u001a\u0004\u0018\u00010\u0019H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/notifications/HmsNotificationService;", "Lcom/huawei/hms/push/HmsMessageService;", "()V", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "getUserInteractor", "()Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "userInteractor$delegate", "Lkotlin/Lazy;", "userPrefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "getUserPrefsSource", "()Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "userPrefsSource$delegate", "createNotification", "", "remoteMessage", "Lcom/huawei/hms/push/RemoteMessage;", "doMsgReceived", "p0", "Landroid/content/Intent;", "onMessageReceived", "message", "onNewToken", PushNotificationArg.TECH_LOG_TOKEN, "", "bundle", "Landroid/os/Bundle;", "showAlarmNotification", "showNotification", "startCallService", NavArg.INTERCOM_LOGIN, "uuid", NavArg.SIP_ADDRESS, NavArg.SIP_PORT, NavArg.SIP_TRANSPORT, "callId", NavArg.DEVICE_ID, "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HmsNotificationService extends HmsMessageService {

    /* renamed from: userInteractor$delegate, reason: from kotlin metadata */
    private final Lazy userInteractor;

    /* renamed from: userPrefsSource$delegate, reason: from kotlin metadata */
    private final Lazy userPrefsSource;

    public HmsNotificationService() {
        final HmsNotificationService hmsNotificationService = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.userPrefsSource = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UserPrefsSource>() { // from class: ru.tattelecom.intercom.notifications.HmsNotificationService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.data.prefs.UserPrefsSource] */
            @Override // kotlin.jvm.functions.Function0
            public final UserPrefsSource invoke() {
                ComponentCallbacks componentCallbacks = hmsNotificationService;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.userInteractor = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<UserInteractor>() { // from class: ru.tattelecom.intercom.notifications.HmsNotificationService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.UserInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final UserInteractor invoke() {
                ComponentCallbacks componentCallbacks = hmsNotificationService;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UserInteractor.class), b2, b3);
            }
        });
    }

    private final UserPrefsSource getUserPrefsSource() {
        return (UserPrefsSource) this.userPrefsSource.getValue();
    }

    private final UserInteractor getUserInteractor() {
        return (UserInteractor) this.userInteractor.getValue();
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String token, Bundle bundle) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        Timber.INSTANCE.i("PUSH|" + ExtensionsKt.toJson(new RemoteLogMessage("new_token", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getUserPrefsSource().getSipSettingsLogin(), (String) null, (String) null, (String) null, 491518, (DefaultConstructorMarker) null)), new Object[0]);
        WorkManager workManager = WorkManager.getInstance(getApplicationContext());
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SendPushTokenWorker.class);
        Data build = new Data.Builder().putString(SendPushTokenWorker.PUSH_TOKEN, token).putString(SendPushTokenWorker.PUSH_SERVICE, PushService.HMS).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        workManager.enqueueUniqueWork("SendingPushToken", existingWorkPolicy, builder.setInputData(build).build());
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage message) {
        Map<String, String> dataOfMap;
        Map<String, String> dataOfMap2;
        Map<String, String> dataOfMap3;
        Map<String, String> dataOfMap4;
        Map<String, String> dataOfMap5;
        Map<String, String> dataOfMap6;
        Map<String, String> dataOfMap7;
        Map<String, String> dataOfMap8;
        Map<String, String> dataOfMap9;
        Map<String, String> dataOfMap10;
        RemoteMessage.Notification notification;
        RemoteMessage.Notification notification2;
        Timber.Companion companion = Timber.INSTANCE;
        String str = null;
        String title = (message == null || (notification2 = message.getNotification()) == null) ? null : notification2.getTitle();
        String body = (message == null || (notification = message.getNotification()) == null) ? null : notification.getBody();
        String str2 = (message == null || (dataOfMap10 = message.getDataOfMap()) == null) ? null : dataOfMap10.get("type");
        String str3 = (message == null || (dataOfMap9 = message.getDataOfMap()) == null) ? null : dataOfMap9.get(PushNotificationArg.CATEGORY);
        String str4 = (message == null || (dataOfMap8 = message.getDataOfMap()) == null) ? null : dataOfMap8.get("title");
        String str5 = (message == null || (dataOfMap7 = message.getDataOfMap()) == null) ? null : dataOfMap7.get("body");
        String str6 = (message == null || (dataOfMap6 = message.getDataOfMap()) == null) ? null : dataOfMap6.get(PushNotificationArg.URL_STRING);
        String str7 = (message == null || (dataOfMap5 = message.getDataOfMap()) == null) ? null : dataOfMap5.get("uuid");
        String str8 = (message == null || (dataOfMap4 = message.getDataOfMap()) == null) ? null : dataOfMap4.get(PushNotificationArg.SIP_ADDRESS);
        String str9 = (message == null || (dataOfMap3 = message.getDataOfMap()) == null) ? null : dataOfMap3.get(PushNotificationArg.SIP_PORT);
        String str10 = (message == null || (dataOfMap2 = message.getDataOfMap()) == null) ? null : dataOfMap2.get(PushNotificationArg.SIP_TRANSPORT);
        if (message != null && (dataOfMap = message.getDataOfMap()) != null) {
            str = dataOfMap.get(PushNotificationArg.SIP_CALL_ID);
        }
        companion.i("PUSH|" + ExtensionsKt.toJson(new RemoteLogMessage(str2, str3, (String) null, (String) null, title, body, str4, str5, str6, str7, str8, str9, str10, (String) null, (String) null, getUserPrefsSource().getSipSettingsLogin(), str, (String) null, (String) null, 417804, (DefaultConstructorMarker) null)), new Object[0]);
        if (message != null) {
            createNotification(message);
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    protected void doMsgReceived(Intent p0) {
        super.doMsgReceived(p0);
    }

    private final void createNotification(RemoteMessage remoteMessage) {
        Map<String, String> dataOfMap;
        try {
            if (Intrinsics.areEqual(remoteMessage.getDataOfMap().get("type"), "alarm")) {
                showAlarmNotification(remoteMessage);
                return;
            }
            if (!Intrinsics.areEqual(remoteMessage.getDataOfMap().get(PushNotificationArg.CATEGORY), PushNotificationCategory.START_CALL)) {
                if (Intrinsics.areEqual(remoteMessage.getDataOfMap().get(PushNotificationArg.CATEGORY), PushNotificationCategory.SEND_LOGS)) {
                    WorkManager workManager = WorkManager.getInstance(getApplicationContext());
                    ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.KEEP;
                    OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SendLogsWorker.class);
                    Data build = new Data.Builder().putString(NavArg.SEND_LOGS_TOKEN, remoteMessage.getDataOfMap().get(PushNotificationArg.TECH_LOG_TOKEN)).build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    workManager.enqueueUniqueWork(PushNotificationCategory.SEND_LOGS, existingWorkPolicy, builder.setInputData(build).build());
                    return;
                }
                if (getUserInteractor().getNotificationPermissionRequestStatus()) {
                    if (CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{"notification", PushNotificationCategory.NOTIFICATION_URL}), remoteMessage.getDataOfMap().get(PushNotificationArg.CATEGORY)) || ((dataOfMap = remoteMessage.getDataOfMap()) != null && dataOfMap.isEmpty())) {
                        showNotification(remoteMessage);
                        return;
                    }
                    return;
                }
                return;
            }
            String str = remoteMessage.getDataOfMap().get("title");
            startCallService(str != null ? StringsKt.substringAfter$default(str, "intercom_sip_login=", (String) null, 2, (Object) null) : null, remoteMessage.getDataOfMap().get("uuid"), remoteMessage.getDataOfMap().get(PushNotificationArg.SIP_ADDRESS), remoteMessage.getDataOfMap().get(PushNotificationArg.SIP_PORT), remoteMessage.getDataOfMap().get(PushNotificationArg.SIP_TRANSPORT), remoteMessage.getDataOfMap().get(PushNotificationArg.SIP_CALL_ID), getUserPrefsSource().getSipSettingsLogin());
        } catch (Exception e) {
            Timber.INSTANCE.e("EXCEPTION|" + ExtensionsKt.toJson(new RemoteLogMessage((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getUserPrefsSource().getSipSettingsLogin(), (String) null, (String) null, e.getMessage(), 229375, (DefaultConstructorMarker) null)), new Object[0]);
            e.printStackTrace();
        }
    }

    private final void showNotification(RemoteMessage remoteMessage) {
        String str = remoteMessage.getDataOfMap().get("title");
        if (str == null) {
            RemoteMessage.Notification notification = remoteMessage.getNotification();
            str = notification != null ? notification.getTitle() : null;
            if (str == null) {
                str = "Мой дом";
            }
        }
        String str2 = remoteMessage.getDataOfMap().get("body");
        if (str2 == null) {
            RemoteMessage.Notification notification2 = remoteMessage.getNotification();
            String body = notification2 != null ? notification2.getBody() : null;
            str2 = body == null ? "Вам пришло уведомление" : body;
        }
        HmsNotificationService hmsNotificationService = this;
        Intent intent = new Intent(hmsNotificationService, (Class<?>) MainActivity.class);
        intent.setPackage(getApplicationContext().getPackageName());
        intent.setAction(PushNotificationAction.ACTION_PUSH);
        intent.putExtra(PushNotificationAction.ACTION_PUSH, true);
        intent.setFlags(C.BUFFER_FLAG_LAST_SAMPLE);
        String str3 = str2;
        NotificationCompat.Builder style = new NotificationCompat.Builder(hmsNotificationService, getString(R.string.default_notification_channel_id)).setSmallIcon(R.drawable.ic_statusbar_icon).setContentTitle(str).setContentText(str3).setAutoCancel(true).setPriority(2).setContentIntent(PendingIntent.getActivity(hmsNotificationService, Random.INSTANCE.nextInt(), intent, 201326592)).setStyle(new NotificationCompat.BigTextStyle().bigText(str3));
        Intrinsics.checkNotNullExpressionValue(style, "setStyle(...)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(4, style.build());
    }

    private final void showAlarmNotification(RemoteMessage remoteMessage) {
        String str = remoteMessage.getDataOfMap().get("title");
        String str2 = remoteMessage.getDataOfMap().get("body");
        HmsNotificationService hmsNotificationService = this;
        NotificationManagerCompat from = NotificationManagerCompat.from(hmsNotificationService);
        if (ActivityCompat.checkSelfPermission(hmsNotificationService, "android.permission.POST_NOTIFICATIONS") != 0) {
            return;
        }
        from.notify(3, new NotificationCompat.Builder(hmsNotificationService, getString(R.string.emergency_alarm_notification_channel_id)).setPriority(2).setDefaults(-1).setContentTitle(str).setContentText(str2).setSmallIcon(R.drawable.ic_statusbar_icon).build());
    }

    private final void startCallService(String intercomLogin, String uuid, String sipAddress, String sipPort, String sipTransport, String callId, String deviceId) {
        Intent intent = new Intent(this, (Class<?>) CallService.class);
        intent.putExtra(NavArg.INTERCOM_LOGIN, intercomLogin);
        if (uuid == null) {
            uuid = "";
        }
        intent.putExtra("uuid", uuid);
        if (sipAddress == null) {
            sipAddress = "";
        }
        intent.putExtra(NavArg.SIP_ADDRESS, sipAddress);
        if (sipPort == null) {
            sipPort = "";
        }
        intent.putExtra(NavArg.SIP_PORT, sipPort);
        if (sipTransport == null) {
            sipTransport = "";
        }
        intent.putExtra(NavArg.SIP_TRANSPORT, sipTransport);
        intent.putExtra("callId", callId);
        intent.putExtra(NavArg.DEVICE_ID, deviceId);
        startService(intent);
    }
}
