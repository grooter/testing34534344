package ru.tattelecom.intercom.feature.call;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.ktx.FirebaseCrashlyticsKt;
import com.google.firebase.ktx.Firebase;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;
import ru.tattelecom.intercom.android.resources.ConnectionChecker;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.call.CallReceiver;

/* compiled from: CallService.kt */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r*\u0001\u0006\u0018\u00002\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010)\u001a\u00020*2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020&H\u0017J\b\u0010,\u001a\u00020&H\u0016J\u0012\u0010-\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\"\u0010.\u001a\u00020/2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/H\u0016J\u0012\u00102\u001a\u00020&2\b\u00103\u001a\u0004\u0018\u00010(H\u0016J\u0012\u00104\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020&H\u0002J\b\u00107\u001a\u00020&H\u0002J\b\u00108\u001a\u00020&H\u0002J\u0006\u00109\u001a\u00020&J\f\u0010:\u001a\u00020&*\u00020\u0017H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallService;", "Landroid/app/Service;", "()V", "binder", "Lru/tattelecom/intercom/feature/call/CallService$CallBinder;", "callActionBroadcastReceiver", "ru/tattelecom/intercom/feature/call/CallService$callActionBroadcastReceiver$1", "Lru/tattelecom/intercom/feature/call/CallService$callActionBroadcastReceiver$1;", "callServiceScope", "Lkotlinx/coroutines/CoroutineScope;", "intercomInteractor", "Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "getIntercomInteractor", "()Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "intercomInteractor$delegate", "Lkotlin/Lazy;", "isBound", "", "isInForeground", "isLogged", "notificationLifeTimer", "Ljava/util/Timer;", "player", "Landroid/media/MediaPlayer;", "sipManager", "Lru/tattelecom/intercom/feature/call/SipManager;", "getSipManager", "()Lru/tattelecom/intercom/feature/call/SipManager;", "setSipManager", "(Lru/tattelecom/intercom/feature/call/SipManager;)V", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "getUserInteractor", "()Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "userInteractor$delegate", "vibrator", "Landroid/os/Vibrator;", FirebaseAnalytics.Event.LOGIN, "", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onBind", "Landroid/os/IBinder;", "onCreate", "onDestroy", "onRebind", "onStartCommand", "", "flags", "startId", "onTaskRemoved", "rootIntent", "onUnbind", "showForeground", "startRinging", "startRingtone", "startVibration", "stopRinging", "prepareRingtone", "CallBinder", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallService extends Service {
    private final CallBinder binder;
    private final CallService$callActionBroadcastReceiver$1 callActionBroadcastReceiver;
    private final CoroutineScope callServiceScope;

    /* renamed from: intercomInteractor$delegate, reason: from kotlin metadata */
    private final Lazy intercomInteractor;
    private boolean isBound;
    private boolean isInForeground;
    private boolean isLogged;
    private Timer notificationLifeTimer;
    private MediaPlayer player;
    private SipManager sipManager;

    /* renamed from: userInteractor$delegate, reason: from kotlin metadata */
    private final Lazy userInteractor;
    private Vibrator vibrator;

    /* JADX WARN: Type inference failed for: r0v7, types: [ru.tattelecom.intercom.feature.call.CallService$callActionBroadcastReceiver$1] */
    public CallService() {
        final CallService callService = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.intercomInteractor = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IntercomInteractor>() { // from class: ru.tattelecom.intercom.feature.call.CallService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.IntercomInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final IntercomInteractor invoke() {
                ComponentCallbacks componentCallbacks = callService;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IntercomInteractor.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.userInteractor = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<UserInteractor>() { // from class: ru.tattelecom.intercom.feature.call.CallService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.UserInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final UserInteractor invoke() {
                ComponentCallbacks componentCallbacks = callService;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UserInteractor.class), b2, b3);
            }
        });
        this.callServiceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        this.binder = new CallBinder();
        this.callActionBroadcastReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.call.CallService$callActionBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                SipManager sipManager;
                CallService.this.stopRinging();
                if (intent == null || !intent.getBooleanExtra(CallReceiver.Arg.END_CALL, false) || (sipManager = CallService.this.getSipManager()) == null) {
                    return;
                }
                sipManager.endCall();
            }
        };
    }

    public final SipManager getSipManager() {
        return this.sipManager;
    }

    public final void setSipManager(SipManager sipManager) {
        this.sipManager = sipManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntercomInteractor getIntercomInteractor() {
        return (IntercomInteractor) this.intercomInteractor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserInteractor getUserInteractor() {
        return (UserInteractor) this.userInteractor.getValue();
    }

    /* compiled from: CallService.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallService$CallBinder;", "Landroid/os/Binder;", "(Lru/tattelecom/intercom/feature/call/CallService;)V", "getService", "Lru/tattelecom/intercom/feature/call/CallService;", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class CallBinder extends Binder {
        public CallBinder() {
        }

        /* renamed from: getService, reason: from getter */
        public final CallService getThis$0() {
            return CallService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
        this.isInForeground = false;
        this.isBound = true;
        return this.binder;
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        if (Build.VERSION.SDK_INT >= 24) {
            stopForeground(1);
        } else {
            stopForeground(true);
        }
        this.isInForeground = false;
        this.isBound = true;
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        showForeground();
        this.isInForeground = true;
        this.isBound = false;
        return true;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.sipManager = new SipManager(this);
        Object systemService = getSystemService("vibrator");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        this.vibrator = (Vibrator) systemService;
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.callActionBroadcastReceiver, new IntentFilter(CallReceiver.Name.CALL), 4);
        } else {
            registerReceiver(this.callActionBroadcastReceiver, new IntentFilter(CallReceiver.Name.CALL));
        }
        SipManager sipManager = this.sipManager;
        if (sipManager != null) {
            sipManager.start();
        }
        BuildersKt__Builders_commonKt.launch$default(this.callServiceScope, null, null, new CallService$onCreate$1(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.callServiceScope, null, null, new CallService$onCreate$2(this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(this.callServiceScope, null, null, new CallService$onCreate$3(this, null), 3, null);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        String stringExtra;
        super.onStartCommand(intent, flags, startId);
        if (!getUserInteractor().isSessionActive().getValue().booleanValue()) {
            stopSelf();
            return 2;
        }
        login(intent);
        if (intent != null && (stringExtra = intent.getStringExtra(NavArg.INTERCOM_LOGIN)) != null) {
            BuildersKt__Builders_commonKt.launch$default(this.callServiceScope, null, null, new CallService$onStartCommand$1$1(this, stringExtra, null), 3, null);
        }
        if (!this.isBound && !this.isInForeground) {
            showForeground();
            this.isInForeground = true;
            if (!getUserInteractor().isWorkInBackgroundEnabled().getValue().booleanValue()) {
                Timer timer = new Timer("notificationLife");
                timer.schedule(new TimerTask() { // from class: ru.tattelecom.intercom.feature.call.CallService$onStartCommand$2$1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        CallService.this.stopSelf();
                    }
                }, 10000L);
                this.notificationLifeTimer = timer;
                return 2;
            }
        }
        return 1;
    }

    private final void login(Intent intent) {
        if (this.isLogged) {
            return;
        }
        ConnectionChecker.Companion companion = ConnectionChecker.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        String connectionType = companion.getConnectionType(applicationContext);
        if (intent != null && intent.hasExtra("uuid") && intent.hasExtra(NavArg.SIP_ADDRESS) && intent.hasExtra(NavArg.SIP_PORT)) {
            BuildersKt__Builders_commonKt.launch$default(this.callServiceScope, null, null, new CallService$login$1(this, intent, connectionType, null), 3, null);
        }
    }

    private final void showForeground() {
        MutableStateFlow<Boolean> isRegistered;
        MutableStateFlow<Boolean> isRegistered2;
        try {
            Boolean bool = null;
            if (Build.VERSION.SDK_INT >= 29) {
                CallService callService = this;
                boolean booleanValue = getUserInteractor().isWorkInBackgroundEnabled().getValue().booleanValue();
                SipManager sipManager = this.sipManager;
                if (sipManager != null && (isRegistered2 = sipManager.isRegistered()) != null) {
                    bool = isRegistered2.getValue();
                }
                startForeground(2, NotificationsKt.getSyncNotification(callService, booleanValue, bool), 2);
                return;
            }
            CallService callService2 = this;
            boolean booleanValue2 = getUserInteractor().isWorkInBackgroundEnabled().getValue().booleanValue();
            SipManager sipManager2 = this.sipManager;
            if (sipManager2 != null && (isRegistered = sipManager2.isRegistered()) != null) {
                bool = isRegistered.getValue();
            }
            startForeground(2, NotificationsKt.getSyncNotification(callService2, booleanValue2, bool));
        } catch (Exception e) {
            FirebaseCrashlyticsKt.getCrashlytics(Firebase.INSTANCE).recordException(e);
        }
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        if (!getUserInteractor().isWorkInBackgroundEnabled().getValue().booleanValue()) {
            stopSelf();
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) CallService.class);
        intent.setPackage(getPackageName());
        Unit unit = Unit.INSTANCE;
        PendingIntent service = PendingIntent.getService(this, 1, intent, 1140850688);
        Object systemService = getApplicationContext().getSystemService("alarm");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        ((AlarmManager) systemService).set(3, SystemClock.elapsedRealtime() + 1000, service);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Timer timer = this.notificationLifeTimer;
        if (timer != null) {
            timer.cancel();
        }
        CoroutineScopeKt.cancel$default(this.callServiceScope, null, 1, null);
        SipManager sipManager = this.sipManager;
        if (sipManager != null) {
            sipManager.stop();
        }
        stopRinging();
        unregisterReceiver(this.callActionBroadcastReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startRinging() {
        CallService callService = this;
        if (NotificationsKt.areIncomingCallsEnabled(callService)) {
            startService(new Intent(callService, (Class<?>) CallService.class));
            Timer timer = this.notificationLifeTimer;
            if (timer != null) {
                timer.cancel();
            }
            if (ActivityCompat.checkSelfPermission(callService, "android.permission.POST_NOTIFICATIONS") == 0) {
                NotificationManagerCompat from = NotificationManagerCompat.from(callService);
                SipManager sipManager = this.sipManager;
                from.notify(1, NotificationsKt.getCallNotification(callService, NotificationsKt.getPlayerActivityIntent(callService, sipManager != null ? sipManager.getCallLogin() : null)));
            }
            startVibration();
            startRingtone();
        }
    }

    public final void stopRinging() {
        NotificationManagerCompat.from(this).cancel(1);
        Vibrator vibrator = this.vibrator;
        if (vibrator != null) {
            vibrator.cancel();
        }
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        MediaPlayer mediaPlayer2 = this.player;
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
        }
        MediaPlayer mediaPlayer3 = this.player;
        if (mediaPlayer3 != null) {
            mediaPlayer3.reset();
        }
        MediaPlayer mediaPlayer4 = this.player;
        if (mediaPlayer4 != null) {
            mediaPlayer4.release();
        }
        this.player = null;
    }

    private final void startVibration() {
        VibrationEffect createWaveform;
        long[] jArr = {0, 1000, 1000};
        if (Build.VERSION.SDK_INT >= 26) {
            Vibrator vibrator = this.vibrator;
            if (vibrator != null) {
                createWaveform = VibrationEffect.createWaveform(jArr, new int[]{0, -1, 0}, 1);
                vibrator.vibrate(createWaveform, new AudioAttributes.Builder().setUsage(6).build());
                return;
            }
            return;
        }
        Vibrator vibrator2 = this.vibrator;
        if (vibrator2 != null) {
            vibrator2.vibrate(jArr, 1);
        }
    }

    private final void startRingtone() {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setLooping(true);
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
            try {
                prepareRingtone(mediaPlayer);
            } catch (Exception unused) {
                getUserInteractor().setDefaultRingtone();
                prepareRingtone(mediaPlayer);
            }
            mediaPlayer.start();
            this.player = mediaPlayer;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void prepareRingtone(MediaPlayer mediaPlayer) {
        mediaPlayer.setDataSource(this, Uri.parse(getUserInteractor().getRingtone()));
        mediaPlayer.prepare();
    }
}
