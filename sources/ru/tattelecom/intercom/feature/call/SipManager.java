package ru.tattelecom.intercom.feature.call;

import android.content.Context;
import android.os.CountDownTimer;
import androidx.media3.common.C;
import androidx.media3.exoplayer.rtsp.RtpPayloadFormat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.linphone.core.Account;
import org.linphone.core.AccountParams;
import org.linphone.core.Address;
import org.linphone.core.AudioDevice;
import org.linphone.core.AuthInfo;
import org.linphone.core.Call;
import org.linphone.core.CallListenerStub;
import org.linphone.core.CallLog;
import org.linphone.core.Core;
import org.linphone.core.CoreListenerStub;
import org.linphone.core.Factory;
import org.linphone.core.PayloadType;
import org.linphone.core.ProxyConfig;
import org.linphone.core.RegistrationState;
import org.linphone.core.TransportType;
import org.linphone.core.Transports;
import org.linphone.core.VideoActivationPolicy;
import org.linphone.mediastream.video.capture.CaptureTextureView;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.helper.ExtensionsKt;
import ru.tattelecom.intercom.data.local.entity.RemoteLogMessage;
import ru.tattelecom.intercom.feature.call.CallReceiver;
import ru.tattelecom.intercom.feature.call.CallState;
import timber.log.Timber;

/* compiled from: SipManager.kt */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n*\u0003\f\u0016\"\u0018\u0000 D2\u00020\u0001:\u0001DB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020%H\u0002J\u0006\u0010'\u001a\u00020%J\b\u0010(\u001a\u0004\u0018\u00010\u0006J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u001cJk\u0010+\u001a\u00020%2\u0006\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u00062\b\u00100\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\u00062\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u00103\u001a\u00020\u0006¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010\u0006J\u001e\u00107\u001a\u00020%2\u0006\u00108\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010:\u001a\u00020;J\u0016\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020;J\b\u0010?\u001a\u00020%H\u0002J\u0006\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u00020%J\u0006\u0010B\u001a\u00020%J\u0006\u0010C\u001a\u00020%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006E"}, d2 = {"Lru/tattelecom/intercom/feature/call/SipManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callId", "", "getCallId", "()Ljava/lang/String;", "setCallId", "(Ljava/lang/String;)V", "callListener", "ru/tattelecom/intercom/feature/call/SipManager$callListener$1", "Lru/tattelecom/intercom/feature/call/SipManager$callListener$1;", "callState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/tattelecom/intercom/feature/call/CallState;", "getCallState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "core", "Lorg/linphone/core/Core;", "coreListener", "ru/tattelecom/intercom/feature/call/SipManager$coreListener$1", "Lru/tattelecom/intercom/feature/call/SipManager$coreListener$1;", NavArg.DEVICE_ID, "getDeviceId", "setDeviceId", "isLogged", "", "isRegistered", "isVideoLoaded", "sipManagerScope", "Lkotlinx/coroutines/CoroutineScope;", "timer", "ru/tattelecom/intercom/feature/call/SipManager$timer$1", "Lru/tattelecom/intercom/feature/call/SipManager$timer$1;", "acceptCall", "", "clearAccounts", CallReceiver.Arg.END_CALL, "getCallLogin", "isMicEnabled", "isEnabled", FirebaseAnalytics.Event.LOGIN, "password", "regExpire", "", "uuid", NavArg.SIP_ADDRESS, NavArg.SIP_PORT, "sipTransportType", "networkType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "makeCall", "sipLogin", "setVideoCrop", "isLandscape", "isFullscreen", "textureView", "Lorg/linphone/mediastream/video/capture/CaptureTextureView;", "setVideoWindow", "videoId", "previewId", "shutDownCall", TtmlNode.START, "startTimer", "stop", "unregister", "Companion", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SipManager {
    private static final String TLS = "tls";
    private static final String UDP = "udp";
    private String callId;
    private final SipManager$callListener$1 callListener;
    private final MutableStateFlow<CallState> callState;
    private Core core;
    private final SipManager$coreListener$1 coreListener;
    private String deviceId;
    private final MutableStateFlow<Boolean> isLogged;
    private final MutableStateFlow<Boolean> isRegistered;
    private final MutableStateFlow<Boolean> isVideoLoaded;
    private final CoroutineScope sipManagerScope;
    private final SipManager$timer$1 timer;

    /* JADX WARN: Type inference failed for: r3v7, types: [ru.tattelecom.intercom.feature.call.SipManager$timer$1] */
    /* JADX WARN: Type inference failed for: r3v8, types: [ru.tattelecom.intercom.feature.call.SipManager$callListener$1] */
    /* JADX WARN: Type inference failed for: r3v9, types: [ru.tattelecom.intercom.feature.call.SipManager$coreListener$1] */
    public SipManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.sipManagerScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        Core createCore = Factory.instance().createCore(null, null, context);
        Intrinsics.checkNotNullExpressionValue(createCore, "createCore(...)");
        this.core = createCore;
        this.callState = StateFlowKt.MutableStateFlow(CallState.NoCall.INSTANCE);
        this.isRegistered = StateFlowKt.MutableStateFlow(false);
        this.isLogged = StateFlowKt.MutableStateFlow(false);
        this.isVideoLoaded = StateFlowKt.MutableStateFlow(false);
        this.timer = new CountDownTimer() { // from class: ru.tattelecom.intercom.feature.call.SipManager$timer$1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
            }

            {
                super(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                SipManager.this.shutDownCall();
            }
        };
        this.callListener = new CallListenerStub() { // from class: ru.tattelecom.intercom.feature.call.SipManager$callListener$1
            @Override // org.linphone.core.CallListenerStub, org.linphone.core.CallListener
            public void onNextVideoFrameDecoded(Call call) {
                Intrinsics.checkNotNullParameter(call, "call");
                SipManager.this.isVideoLoaded().setValue(true);
            }
        };
        this.coreListener = new CoreListenerStub() { // from class: ru.tattelecom.intercom.feature.call.SipManager$coreListener$1

            /* compiled from: SipManager.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Call.State.values().length];
                    try {
                        iArr[Call.State.IncomingReceived.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Call.State.Connected.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Call.State.End.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Call.State.Released.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onAccountRegistrationStateChanged(Core core, Account account, RegistrationState state, String message) {
                Intrinsics.checkNotNullParameter(core, "core");
                Intrinsics.checkNotNullParameter(account, "account");
                Intrinsics.checkNotNullParameter(message, "message");
                super.onAccountRegistrationStateChanged(core, account, state, message);
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            @Deprecated(message = "Deprecated in Java")
            public void onRegistrationStateChanged(Core core, ProxyConfig proxyConfig, RegistrationState state, String message) {
                Intrinsics.checkNotNullParameter(core, "core");
                Intrinsics.checkNotNullParameter(proxyConfig, "proxyConfig");
                Intrinsics.checkNotNullParameter(message, "message");
                Timber.Companion companion = Timber.INSTANCE;
                companion.i("SIP|" + ExtensionsKt.toJson(new RemoteLogMessage((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, state != null ? state.toString() : null, message, SipManager.this.getDeviceId(), SipManager.this.getCallId(), (String) null, (String) null, 401407, (DefaultConstructorMarker) null)), new Object[0]);
                SipManager.this.isRegistered().setValue(Boolean.valueOf(state == RegistrationState.Ok));
            }

            @Override // org.linphone.core.CoreListenerStub, org.linphone.core.CoreListener
            public void onCallStateChanged(Core core, Call call, Call.State state, String message) {
                SipManager$timer$1 sipManager$timer$1;
                SipManager$callListener$1 sipManager$callListener$1;
                SipManager$callListener$1 sipManager$callListener$12;
                Intrinsics.checkNotNullParameter(core, "core");
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(message, "message");
                Timber.Companion companion = Timber.INSTANCE;
                companion.i("SIP|" + ExtensionsKt.toJson(new RemoteLogMessage((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, state != null ? state.toString() : null, message, SipManager.this.getDeviceId(), SipManager.this.getCallId(), (String) null, (String) null, 401407, (DefaultConstructorMarker) null)), new Object[0]);
                sipManager$timer$1 = SipManager.this.timer;
                sipManager$timer$1.cancel();
                int i = state == null ? -1 : WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
                if (i == 1) {
                    SipManager.this.getCallState().setValue(CallState.Incoming.INSTANCE);
                    return;
                }
                if (i == 2) {
                    sipManager$callListener$1 = SipManager.this.callListener;
                    call.addListener(sipManager$callListener$1);
                    SipManager.this.getCallState().setValue(CallState.Accepted.INSTANCE);
                } else if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    SipManager.this.getCallState().setValue(CallState.Released.INSTANCE);
                } else {
                    SipManager.this.getCallState().setValue(CallState.Ended.INSTANCE);
                    sipManager$callListener$12 = SipManager.this.callListener;
                    call.removeListener(sipManager$callListener$12);
                    SipManager.this.isVideoLoaded().setValue(false);
                    SipManager.this.unregister();
                }
            }
        };
    }

    public final MutableStateFlow<CallState> getCallState() {
        return this.callState;
    }

    public final MutableStateFlow<Boolean> isRegistered() {
        return this.isRegistered;
    }

    public final MutableStateFlow<Boolean> isLogged() {
        return this.isLogged;
    }

    public final MutableStateFlow<Boolean> isVideoLoaded() {
        return this.isVideoLoaded;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final void setCallId(String str) {
        this.callId = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void start() {
        Core core = this.core;
        core.setIpv6Enabled(false);
        core.setEchoCancellationEnabled(false);
        core.setAdaptiveRateControlEnabled(false);
        core.setNativeRingingEnabled(false);
        core.setRing(null);
        core.enterBackground();
        Transports transportsUsed = core.getTransportsUsed();
        transportsUsed.setTlsPort(-1);
        transportsUsed.setUdpPort(-1);
        core.setTransports(transportsUsed);
        PayloadType[] audioPayloadTypes = core.getAudioPayloadTypes();
        Intrinsics.checkNotNullExpressionValue(audioPayloadTypes, "getAudioPayloadTypes(...)");
        PayloadType[] payloadTypeArr = audioPayloadTypes;
        for (PayloadType payloadType : payloadTypeArr) {
            payloadType.enable(Intrinsics.areEqual(payloadType.getMimeType(), RtpPayloadFormat.RTP_MEDIA_PCMA));
        }
        core.setAudioPayloadTypes(payloadTypeArr);
        AudioDevice[] audioDevices = this.core.getAudioDevices();
        Intrinsics.checkNotNullExpressionValue(audioDevices, "getAudioDevices(...)");
        for (AudioDevice audioDevice : audioDevices) {
            if (audioDevice.getType() == AudioDevice.Type.Speaker) {
                this.core.setDefaultOutputAudioDevice(audioDevice);
            }
        }
        PayloadType[] videoPayloadTypes = core.getVideoPayloadTypes();
        Intrinsics.checkNotNullExpressionValue(videoPayloadTypes, "getVideoPayloadTypes(...)");
        PayloadType[] payloadTypeArr2 = videoPayloadTypes;
        for (PayloadType payloadType2 : payloadTypeArr2) {
            payloadType2.enable(Intrinsics.areEqual(payloadType2.getMimeType(), RtpPayloadFormat.RTP_MEDIA_H264));
        }
        core.setVideoPayloadTypes(payloadTypeArr2);
        VideoActivationPolicy videoActivationPolicy = core.getVideoActivationPolicy();
        videoActivationPolicy.setAutomaticallyInitiate(true);
        videoActivationPolicy.setAutomaticallyAccept(true);
        core.setVideoActivationPolicy(videoActivationPolicy);
        core.addListener(this.coreListener);
        core.start();
    }

    public final void login(String login, String password, Integer regExpire, String uuid, String sipAddress, String sipPort, String sipTransportType, String callId, String deviceId, String networkType) {
        Intrinsics.checkNotNullParameter(login, "login");
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        String str = callId;
        if (str != null && str.length() != 0) {
            this.callId = callId;
        }
        String str2 = deviceId;
        if (str2 != null && str2.length() != 0) {
            this.deviceId = deviceId;
        }
        this.isLogged.setValue(true);
        String str3 = sipAddress + ":" + sipPort;
        AuthInfo createAuthInfo = Factory.instance().createAuthInfo(login, null, password, null, null, str3);
        Intrinsics.checkNotNullExpressionValue(createAuthInfo, "createAuthInfo(...)");
        this.core.addAuthInfo(createAuthInfo);
        AccountParams createAccountParams = this.core.createAccountParams();
        Intrinsics.checkNotNullExpressionValue(createAccountParams, "createAccountParams(...)");
        Address createAddress = Factory.instance().createAddress("sip:" + login + "@" + str3);
        Factory instance = Factory.instance();
        StringBuilder sb = new StringBuilder("sip:");
        sb.append(str3);
        Address createAddress2 = instance.createAddress(sb.toString());
        if (Intrinsics.areEqual(sipTransportType, TLS)) {
            this.core.verifyServerCertificates(false);
            if (createAddress2 != null) {
                createAddress2.setTransport(TransportType.Tls);
            }
        } else if (Intrinsics.areEqual(sipTransportType, UDP)) {
            if (createAddress2 != null) {
                createAddress2.setTransport(TransportType.Udp);
            }
        } else if (createAddress2 != null) {
            createAddress2.setTransport(TransportType.Udp);
        }
        createAccountParams.setIdentityAddress(createAddress);
        createAccountParams.setServerAddress(createAddress2);
        createAccountParams.setRegisterEnabled(true);
        createAccountParams.setExpires(regExpire != null ? regExpire.intValue() : 60);
        Account createAccount = this.core.createAccount(createAccountParams);
        Intrinsics.checkNotNullExpressionValue(createAccount, "createAccount(...)");
        String str4 = uuid;
        if (str4 != null && str4.length() != 0) {
            createAccount.setCustomHeader("X-UUID", uuid);
        }
        createAccount.setCustomHeader("X-Network", networkType);
        this.core.addAccount(createAccount);
        this.core.setDefaultAccount(createAccount);
    }

    public final void unregister() {
        this.isLogged.setValue(false);
        Account defaultAccount = this.core.getDefaultAccount();
        if (defaultAccount != null) {
            AccountParams params = defaultAccount.getParams();
            Intrinsics.checkNotNullExpressionValue(params, "getParams(...)");
            AccountParams mo3121clone = params.mo3121clone();
            Intrinsics.checkNotNullExpressionValue(mo3121clone, "clone(...)");
            mo3121clone.setRegisterEnabled(false);
            defaultAccount.setParams(mo3121clone);
        }
    }

    private final void clearAccounts() {
        Core core = this.core;
        core.clearAccounts();
        core.clearAllAuthInfo();
    }

    public final String getCallLogin() {
        CallLog callLog;
        Address remoteAddress;
        Call currentCall = this.core.getCurrentCall();
        if (currentCall == null || (callLog = currentCall.getCallLog()) == null || (remoteAddress = callLog.getRemoteAddress()) == null) {
            return null;
        }
        return remoteAddress.getUsername();
    }

    public final void acceptCall() {
        Call currentCall = this.core.getCurrentCall();
        if (currentCall != null) {
            currentCall.accept();
        }
    }

    public final void endCall() {
        Call currentCall = this.core.getCurrentCall();
        if (currentCall != null) {
            currentCall.terminate();
        }
    }

    public final void makeCall(String sipLogin) {
        Address interpretUrl;
        Core core = this.core;
        if (sipLogin == null || (interpretUrl = core.interpretUrl(sipLogin)) == null) {
            return;
        }
        core.inviteAddress(interpretUrl);
    }

    public final void isMicEnabled(boolean isEnabled) {
        Call currentCall = this.core.getCurrentCall();
        if (currentCall == null) {
            return;
        }
        currentCall.setMicrophoneMuted(!isEnabled);
    }

    public final void setVideoWindow(CaptureTextureView videoId, CaptureTextureView previewId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        Intrinsics.checkNotNullParameter(previewId, "previewId");
        this.core.setNativeVideoWindowId(videoId);
        this.core.setNativePreviewWindowId(previewId);
    }

    public final void setVideoCrop(boolean isLandscape, boolean isFullscreen, CaptureTextureView textureView) {
        float max;
        Intrinsics.checkNotNullParameter(textureView, "textureView");
        Call currentCall = this.core.getCurrentCall();
        if (currentCall != null) {
            if (isFullscreen) {
                int height = textureView.getHeight();
                int width = textureView.getWidth();
                float f = isLandscape ? 16.0f : 9.0f;
                float f2 = isLandscape ? 9.0f : 16.0f;
                float f3 = height;
                float f4 = width;
                max = Math.max(f3 / ((f * f4) / f2), f4 / ((f * f3) / f2));
            } else {
                max = 1.0f;
            }
            currentCall.zoom(max, 0.5f, 0.5f);
        }
    }

    public final void stop() {
        CoroutineScopeKt.cancel$default(this.sipManagerScope, null, 1, null);
        unregister();
        this.core.removeListener(this.coreListener);
        this.core.stop();
    }

    public final void startTimer() {
        start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void shutDownCall() {
        Timber.INSTANCE.i("SIP|" + ExtensionsKt.toJson(new RemoteLogMessage((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, this.deviceId, this.callId, "call timeout shut down", (String) null, 294911, (DefaultConstructorMarker) null)), new Object[0]);
        this.callState.setValue(CallState.Ended.INSTANCE);
        Call currentCall = this.core.getCurrentCall();
        if (currentCall != null) {
            currentCall.removeListener(this.callListener);
        }
        this.isVideoLoaded.setValue(false);
        unregister();
        this.callState.setValue(CallState.NoCall.INSTANCE);
    }
}
