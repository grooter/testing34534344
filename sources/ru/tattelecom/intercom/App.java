package ru.tattelecom.intercom;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.os.Build;
import com.google.android.gms.common.GoogleApiAvailability;
import com.huawei.hms.maps.MapsInitializer;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import im.threads.business.core.UnreadMessagesCountListener;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.android.ext.koin.KoinExtKt;
import org.koin.core.KoinApplication;
import org.koin.core.context.DefaultContextExtKt;
import org.koin.core.qualifier.Qualifier;
import ru.tattelecom.intercom.lib_chat.EDNAChat;
import timber.log.Timber;

/* compiled from: App.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u000b²\u0006\n\u0010\f\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"Lru/tattelecom/intercom/App;", "Landroid/app/Application;", "()V", "createNotificationChannels", "", "initAppMetrica", "initEDNAChat", "initKoin", "initLogger", "initializerHuaweiMap", "onCreate", "app_release", "timberRemoteTree", "Lru/tattelecom/intercom/TimberRemoteTree;"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class App extends Application {
    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        initKoin();
        initAppMetrica();
        createNotificationChannels();
        initializerHuaweiMap();
        initLogger();
        initEDNAChat();
    }

    private final void initLogger() {
        final App app = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        Timber.INSTANCE.plant(initLogger$lambda$0(LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TimberRemoteTree>() { // from class: ru.tattelecom.intercom.App$initLogger$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.TimberRemoteTree] */
            @Override // kotlin.jvm.functions.Function0
            public final TimberRemoteTree invoke() {
                ComponentCallbacks componentCallbacks = app;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TimberRemoteTree.class), qualifier, b);
            }
        })));
    }

    private static final TimberRemoteTree initLogger$lambda$0(Lazy<TimberRemoteTree> lazy) {
        return lazy.getValue();
    }

    private final void initEDNAChat() {
        EDNAChat.INSTANCE.setBaseUrl(ru.tattelecom.intercom.data.BuildConfig.EDNA_BASE_URL).setDataStoreUrl(ru.tattelecom.intercom.data.BuildConfig.EDNA_DATASTORE_URL).setThreadsGateUrl(ru.tattelecom.intercom.data.BuildConfig.EDNA_THREADS_GATE_URL).setThreadsGateProviderUid(ru.tattelecom.intercom.data.BuildConfig.EDNA_THREADS_GATE_PROVIDER_UID).setUnreadMessagesCountListener(new UnreadMessagesCountListener() { // from class: ru.tattelecom.intercom.App$initEDNAChat$1
            @Override // im.threads.business.core.UnreadMessagesCountListener
            public void onUnreadMessagesCountChanged(int count) {
                Intent intent = new Intent(EDNAChat.APP_UNREAD_COUNT_BROADCAST);
                intent.putExtra(EDNAChat.UNREAD_COUNT_KEY, count);
                App.this.sendBroadcast(intent);
            }
        }).run(this, new Function1<String, Unit>() { // from class: ru.tattelecom.intercom.App$initEDNAChat$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                System.out.println((Object) str);
            }
        });
    }

    private final void initKoin() {
        DefaultContextExtKt.startKoin(new Function1<KoinApplication, Unit>() { // from class: ru.tattelecom.intercom.App$initKoin$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(KoinApplication koinApplication) {
                invoke2(koinApplication);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(KoinApplication startKoin) {
                Intrinsics.checkNotNullParameter(startKoin, "$this$startKoin");
                KoinExtKt.androidContext(startKoin, App.this);
                startKoin.modules(ModulesKt.getDispatchersModule(), ModulesKt.getLocalSourceModule(), ModulesKt.getRemoteSourceModule(), ModulesKt.getInteractorModule(), ModulesKt.getViewModelModule(), ModulesKt.getRemoteLoggerModule());
            }
        });
    }

    private final void createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            App$$ExternalSyntheticApiModelOutline0.m3144m();
            NotificationChannel m = App$$ExternalSyntheticApiModelOutline0.m(getString(R.string.foreground_notification_channel_id), getString(R.string.foreground_notification_channel_name), 2);
            m.setShowBadge(false);
            notificationManager.createNotificationChannel(m);
            App$$ExternalSyntheticApiModelOutline0.m3144m();
            NotificationChannel m2 = App$$ExternalSyntheticApiModelOutline0.m(getString(R.string.open_gate_notification_channel_id), getString(R.string.open_gate_channel_name), 2);
            m2.setShowBadge(false);
            notificationManager.createNotificationChannel(m2);
            App$$ExternalSyntheticApiModelOutline0.m3144m();
            NotificationChannel m3 = App$$ExternalSyntheticApiModelOutline0.m(getString(R.string.call_notification_channel_id), getString(R.string.call_notification_channel_name), 4);
            m3.setSound(null, null);
            m3.setShowBadge(false);
            notificationManager.createNotificationChannel(m3);
            App$$ExternalSyntheticApiModelOutline0.m3144m();
            NotificationChannel m4 = App$$ExternalSyntheticApiModelOutline0.m(getString(R.string.emergency_alarm_notification_channel_id), getString(R.string.emergency_alarm_channel_name), 4);
            m4.enableVibration(true);
            notificationManager.createNotificationChannel(m4);
            App$$ExternalSyntheticApiModelOutline0.m3144m();
            NotificationChannel m5 = App$$ExternalSyntheticApiModelOutline0.m(getString(R.string.default_notification_channel_id), getString(R.string.default_notification_channel_name), 4);
            m5.setShowBadge(false);
            notificationManager.createNotificationChannel(m5);
        }
    }

    private final void initAppMetrica() {
        YandexMetricaConfig build = YandexMetricaConfig.newConfigBuilder(BuildConfig.YANDEX_API_KEY).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        YandexMetrica.activate(getApplicationContext(), build);
        YandexMetrica.enableActivityAutoTracking(this);
    }

    private final void initializerHuaweiMap() {
        App app = this;
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(app) != 0) {
            MapsInitializer.initialize(app);
            MapsInitializer.setApiKey("DAEDAD6/01iuXSPAfaFUCtsQegq+t7f8uF9u5kKgEEFKgTbhZbnR9X7N2Pww+t7QFiiOn+DvIJpTwAf6CFCqkeUO8RPjz8zxwELRDg==");
        }
    }
}
