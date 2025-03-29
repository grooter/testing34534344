package ru.tattelecom.intercom.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.common.C;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.huawei.hms.support.api.entity.common.CommonConstant;
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
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;
import ru.tattelecom.intercom.R;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationAction;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationCategory;
import ru.tattelecom.intercom.data.helper.ExtensionsKt;
import ru.tattelecom.intercom.data.local.entity.RemoteLogMessage;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.domain.workers.SendPushTokenWorker;
import ru.tattelecom.intercom.feature.call.CallService;
import ru.tattelecom.intercom.main.MainActivity;
import ru.tattelecom.intercom.workers.SendLogsWorker;
import timber.log.Timber;

/* compiled from: NotificationService.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002JN\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0016H\u0002J\f\u0010!\u001a\u00020\u0016*\u00020\"H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006#"}, d2 = {"Lru/tattelecom/intercom/notifications/NotificationService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "getUserInteractor", "()Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "userInteractor$delegate", "Lkotlin/Lazy;", "userPrefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "getUserPrefsSource", "()Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "userPrefsSource$delegate", "createNotification", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onMessageReceived", "message", "onNewToken", PushNotificationArg.TECH_LOG_TOKEN, "", "showAlarmNotification", "showNotification", "startCallService", NavArg.INTERCOM_LOGIN, "uuid", NavArg.SIP_ADDRESS, NavArg.SIP_PORT, NavArg.SIP_TRANSPORT, "callId", NavArg.DEVICE_ID, "toPriorityString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class NotificationService extends FirebaseMessagingService {

    /* renamed from: userInteractor$delegate, reason: from kotlin metadata */
    private final Lazy userInteractor;

    /* renamed from: userPrefsSource$delegate, reason: from kotlin metadata */
    private final Lazy userPrefsSource;

    public NotificationService() {
        final NotificationService notificationService = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.userPrefsSource = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UserPrefsSource>() { // from class: ru.tattelecom.intercom.notifications.NotificationService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.data.prefs.UserPrefsSource] */
            @Override // kotlin.jvm.functions.Function0
            public final UserPrefsSource invoke() {
                ComponentCallbacks componentCallbacks = notificationService;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.userInteractor = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<UserInteractor>() { // from class: ru.tattelecom.intercom.notifications.NotificationService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.UserInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final UserInteractor invoke() {
                ComponentCallbacks componentCallbacks = notificationService;
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

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        Timber.INSTANCE.i("PUSH|" + ExtensionsKt.toJson(new RemoteLogMessage("new_token", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getUserPrefsSource().getSipSettingsLogin(), (String) null, (String) null, (String) null, 491518, (DefaultConstructorMarker) null)), new Object[0]);
        WorkManager workManager = WorkManager.getInstance(getApplicationContext());
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SendPushTokenWorker.class);
        Data build = new Data.Builder().putString(SendPushTokenWorker.PUSH_TOKEN, token).putString(SendPushTokenWorker.PUSH_SERVICE, "fcm").build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        workManager.enqueueUniqueWork("SendingPushToken", existingWorkPolicy, builder.setInputData(build).build());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Timber.Companion companion = Timber.INSTANCE;
        RemoteMessage.Notification notification = message.getNotification();
        String title = notification != null ? notification.getTitle() : null;
        RemoteMessage.Notification notification2 = message.getNotification();
        companion.i("PUSH|" + ExtensionsKt.toJson(new RemoteLogMessage(message.getData().get("type"), message.getData().get(PushNotificationArg.CATEGORY), toPriorityString(message.getPriority()), toPriorityString(message.getOriginalPriority()), title, notification2 != null ? notification2.getBody() : null, message.getData().get("title"), message.getData().get("body"), message.getData().get(PushNotificationArg.URL_STRING), message.getData().get("uuid"), message.getData().get(PushNotificationArg.SIP_ADDRESS), message.getData().get(PushNotificationArg.SIP_PORT), message.getData().get(PushNotificationArg.SIP_TRANSPORT), (String) null, (String) null, getUserPrefsSource().getSipSettingsLogin(), message.getData().get(PushNotificationArg.SIP_CALL_ID), (String) null, (String) null, 417792, (DefaultConstructorMarker) null)), new Object[0]);
        createNotification(message);
    }

    private final void createNotification(RemoteMessage remoteMessage) {
        try {
            if (Intrinsics.areEqual(remoteMessage.getData().get("type"), "alarm")) {
                showAlarmNotification(remoteMessage);
                return;
            }
            if (!Intrinsics.areEqual(remoteMessage.getData().get(PushNotificationArg.CATEGORY), PushNotificationCategory.START_CALL)) {
                if (Intrinsics.areEqual(remoteMessage.getData().get(PushNotificationArg.CATEGORY), PushNotificationCategory.SEND_LOGS)) {
                    WorkManager workManager = WorkManager.getInstance(getApplicationContext());
                    ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.KEEP;
                    OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SendLogsWorker.class);
                    Data build = new Data.Builder().putString(NavArg.SEND_LOGS_TOKEN, remoteMessage.getData().get(PushNotificationArg.TECH_LOG_TOKEN)).build();
                    Intrinsics.checkNotNullExpressionValue(build, "build(...)");
                    workManager.enqueueUniqueWork(PushNotificationCategory.SEND_LOGS, existingWorkPolicy, builder.setInputData(build).build());
                    return;
                }
                if (getUserInteractor().getNotificationPermissionRequestStatus()) {
                    if (CollectionsKt.contains(CollectionsKt.listOf((Object[]) new String[]{"notification", PushNotificationCategory.NOTIFICATION_URL}), remoteMessage.getData().get(PushNotificationArg.CATEGORY)) || remoteMessage.getData().isEmpty()) {
                        showNotification(remoteMessage);
                        return;
                    }
                    return;
                }
                return;
            }
            String str = remoteMessage.getData().get("title");
            startCallService(str != null ? StringsKt.substringAfter$default(str, "intercom_sip_login=", (String) null, 2, (Object) null) : null, remoteMessage.getData().get("uuid"), remoteMessage.getData().get(PushNotificationArg.SIP_ADDRESS), remoteMessage.getData().get(PushNotificationArg.SIP_PORT), remoteMessage.getData().get(PushNotificationArg.SIP_TRANSPORT), remoteMessage.getData().get(PushNotificationArg.SIP_CALL_ID), getUserPrefsSource().getSipSettingsLogin());
        } catch (Exception e) {
            Timber.INSTANCE.e("PUSH|{" + ExtensionsKt.toJson(new RemoteLogMessage((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, getUserPrefsSource().getSipSettingsLogin(), (String) null, (String) null, e.getMessage(), 229375, (DefaultConstructorMarker) null)) + "}", new Object[0]);
            e.printStackTrace();
        }
    }

    private final void showNotification(RemoteMessage remoteMessage) {
        Intent intent;
        String str = remoteMessage.getData().get("title");
        if (str == null) {
            RemoteMessage.Notification notification = remoteMessage.getNotification();
            str = notification != null ? notification.getTitle() : null;
            if (str == null) {
                str = "Мой дом";
            }
        }
        String str2 = remoteMessage.getData().get("body");
        if (str2 == null) {
            RemoteMessage.Notification notification2 = remoteMessage.getNotification();
            String body = notification2 != null ? notification2.getBody() : null;
            str2 = body == null ? "Вам пришло уведомление" : body;
        }
        String str3 = remoteMessage.getData().get(PushNotificationArg.URL_STRING);
        String str4 = str3;
        if (str4 != null && str4.length() != 0 && !Intrinsics.areEqual(str3, AbstractJsonLexerKt.NULL) && URLUtil.isValidUrl(str3)) {
            intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str3));
        } else {
            intent = new Intent(this, (Class<?>) MainActivity.class);
            intent.setAction(PushNotificationAction.ACTION_PUSH);
            intent.putExtra(PushNotificationAction.ACTION_PUSH, true);
        }
        intent.setFlags(C.BUFFER_FLAG_LAST_SAMPLE);
        NotificationService notificationService = this;
        String str5 = str2;
        NotificationCompat.Builder style = new NotificationCompat.Builder(notificationService, getString(R.string.default_notification_channel_id)).setSmallIcon(R.drawable.ic_statusbar_icon).setContentTitle(str).setContentText(str5).setAutoCancel(true).setPriority(2).setContentIntent(PendingIntent.getActivity(notificationService, Random.INSTANCE.nextInt(), intent, 201326592)).setStyle(new NotificationCompat.BigTextStyle().bigText(str5));
        Intrinsics.checkNotNullExpressionValue(style, "setStyle(...)");
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(4, style.build());
    }

    private final void showAlarmNotification(RemoteMessage remoteMessage) {
        String str = remoteMessage.getData().get("title");
        String str2 = remoteMessage.getData().get("body");
        NotificationService notificationService = this;
        NotificationManagerCompat from = NotificationManagerCompat.from(notificationService);
        if (ActivityCompat.checkSelfPermission(notificationService, "android.permission.POST_NOTIFICATIONS") == 0) {
            from.notify(3, new NotificationCompat.Builder(notificationService, getString(R.string.emergency_alarm_notification_channel_id)).setPriority(2).setDefaults(-1).setContentTitle(str).setContentText(str2).setSmallIcon(R.drawable.ic_statusbar_icon).build());
        }
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

    private final String toPriorityString(int i) {
        if (i == 1) {
            return "High";
        }
        if (i == 2) {
            return "Normal";
        }
        return "Unknown";
    }
}
