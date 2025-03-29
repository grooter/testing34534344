package ru.tattelecom.intercom.feature.player;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HardwareManager.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0007J\u0006\u0010\u001a\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013R\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/tattelecom/intercom/feature/player/HardwareManager;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "onCloseToProximity", "Lkotlin/Function1;", "", "", "(Landroidx/appcompat/app/AppCompatActivity;Lkotlin/jvm/functions/Function1;)V", "audioManager", "Landroid/media/AudioManager;", "bluetoothHeadsetStateReceiver", "Landroid/content/BroadcastReceiver;", "isRunning", "proximitySensorEventListener", "Landroid/hardware/SensorEventListener;", "sensorManager", "Landroid/hardware/SensorManager;", "wakeLock", "Landroid/os/PowerManager$WakeLock;", "Landroid/os/PowerManager;", "changeSpeakerphoneStatus", "isCloseToProximity", "setBluetoothHeadset", "isConnected", TtmlNode.START, "stop", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HardwareManager {
    private final AppCompatActivity activity;
    private AudioManager audioManager;
    private BroadcastReceiver bluetoothHeadsetStateReceiver;
    private boolean isRunning;
    private final Function1<Boolean, Unit> onCloseToProximity;
    private SensorEventListener proximitySensorEventListener;
    private SensorManager sensorManager;
    private PowerManager.WakeLock wakeLock;

    /* JADX WARN: Multi-variable type inference failed */
    public HardwareManager(AppCompatActivity activity, Function1<? super Boolean, Unit> onCloseToProximity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onCloseToProximity, "onCloseToProximity");
        this.activity = activity;
        this.onCloseToProximity = onCloseToProximity;
        Object systemService = activity.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        this.audioManager = (AudioManager) systemService;
        Object systemService2 = activity.getSystemService("sensor");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.sensorManager = (SensorManager) systemService2;
        Object systemService3 = activity.getSystemService("power");
        Intrinsics.checkNotNull(systemService3, "null cannot be cast to non-null type android.os.PowerManager");
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService3).newWakeLock(32, activity.getLocalClassName());
        Intrinsics.checkNotNullExpressionValue(newWakeLock, "newWakeLock(...)");
        this.wakeLock = newWakeLock;
        this.bluetoothHeadsetStateReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.player.HardwareManager$1$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AppCompatActivity appCompatActivity;
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                appCompatActivity = HardwareManager.this.activity;
                final HardwareManager hardwareManager = HardwareManager.this;
                defaultAdapter.getProfileProxy(appCompatActivity, new BluetoothProfile.ServiceListener() { // from class: ru.tattelecom.intercom.feature.player.HardwareManager$1$1$onReceive$1
                    @Override // android.bluetooth.BluetoothProfile.ServiceListener
                    public void onServiceDisconnected(int profile) {
                    }

                    @Override // android.bluetooth.BluetoothProfile.ServiceListener
                    public void onServiceConnected(int profile, BluetoothProfile proxy) {
                        List<BluetoothDevice> connectedDevices;
                        HardwareManager hardwareManager2 = HardwareManager.this;
                        boolean z = false;
                        if (proxy != null && (connectedDevices = proxy.getConnectedDevices()) != null && (!connectedDevices.isEmpty())) {
                            z = true;
                        }
                        hardwareManager2.setBluetoothHeadset(z);
                    }
                }, 1);
            }
        };
        this.proximitySensorEventListener = new SensorEventListener() { // from class: ru.tattelecom.intercom.feature.player.HardwareManager$1$2
            @Override // android.hardware.SensorEventListener
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            @Override // android.hardware.SensorEventListener
            public void onSensorChanged(SensorEvent event) {
                Function1 function1;
                AudioManager audioManager;
                PowerManager.WakeLock wakeLock;
                float[] fArr;
                boolean areEqual = Intrinsics.areEqual((event == null || (fArr = event.values) == null) ? null : Float.valueOf(fArr[0]), 0.0f);
                function1 = HardwareManager.this.onCloseToProximity;
                function1.invoke(Boolean.valueOf(areEqual));
                HardwareManager hardwareManager = HardwareManager.this;
                audioManager = hardwareManager.audioManager;
                hardwareManager.changeSpeakerphoneStatus(audioManager, areEqual);
                wakeLock = HardwareManager.this.wakeLock;
                if (areEqual) {
                    if (wakeLock.isHeld()) {
                        return;
                    }
                    wakeLock.acquire(120000L);
                } else if (wakeLock.isHeld()) {
                    wakeLock.release();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeSpeakerphoneStatus(AudioManager audioManager, boolean isCloseToProximity) {
        AudioDeviceInfo communicationDevice;
        List availableCommunicationDevices;
        Object obj;
        if (Build.VERSION.SDK_INT < 31) {
            if (audioManager.isSpeakerphoneOn() == isCloseToProximity) {
                audioManager.setSpeakerphoneOn(!isCloseToProximity);
                return;
            }
            return;
        }
        int i = isCloseToProximity ? 2 : 1;
        communicationDevice = audioManager.getCommunicationDevice();
        if (communicationDevice == null || communicationDevice.getType() != i) {
            availableCommunicationDevices = audioManager.getAvailableCommunicationDevices();
            Intrinsics.checkNotNullExpressionValue(availableCommunicationDevices, "getAvailableCommunicationDevices(...)");
            Iterator it = availableCommunicationDevices.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((AudioDeviceInfo) obj).getType() == i) {
                        break;
                    }
                }
            }
            AudioDeviceInfo audioDeviceInfo = (AudioDeviceInfo) obj;
            if (audioDeviceInfo != null) {
                audioManager.setCommunicationDevice(audioDeviceInfo);
            }
        }
    }

    public final void start() {
        if (this.isRunning) {
            return;
        }
        SensorManager sensorManager = this.sensorManager;
        sensorManager.registerListener(this.proximitySensorEventListener, sensorManager.getDefaultSensor(8), 3);
        if (Build.VERSION.SDK_INT >= 33) {
            AppCompatActivity appCompatActivity = this.activity;
            BroadcastReceiver broadcastReceiver = this.bluetoothHeadsetStateReceiver;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            Unit unit = Unit.INSTANCE;
            appCompatActivity.registerReceiver(broadcastReceiver, intentFilter, 2);
        } else {
            AppCompatActivity appCompatActivity2 = this.activity;
            BroadcastReceiver broadcastReceiver2 = this.bluetoothHeadsetStateReceiver;
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
            Unit unit2 = Unit.INSTANCE;
            appCompatActivity2.registerReceiver(broadcastReceiver2, intentFilter2);
        }
        try {
            if (BluetoothAdapter.getDefaultAdapter().isEnabled() && BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) == 2) {
                setBluetoothHeadset(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isRunning = true;
    }

    public final void stop() {
        if (this.isRunning) {
            if (this.wakeLock.isHeld()) {
                this.wakeLock.release();
            }
            this.sensorManager.unregisterListener(this.proximitySensorEventListener);
            this.activity.unregisterReceiver(this.bluetoothHeadsetStateReceiver);
            this.isRunning = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBluetoothHeadset(boolean isConnected) {
        AudioManager audioManager = this.audioManager;
        audioManager.setSpeakerphoneOn(!isConnected);
        if (isConnected) {
            audioManager.startBluetoothSco();
        } else {
            audioManager.stopBluetoothSco();
        }
    }
}
