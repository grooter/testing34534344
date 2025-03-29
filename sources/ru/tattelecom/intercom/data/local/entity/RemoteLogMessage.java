package ru.tattelecom.intercom.data.local.entity;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;

/* compiled from: RemoteLogEntity.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 h2\u00020\u0001:\u0002ghBý\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aBé\u0001\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u001bJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jí\u0001\u0010Y\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010Z\u001a\u00020[2\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0003HÖ\u0001J\t\u0010^\u001a\u00020\u0005HÖ\u0001J&\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u00002\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020eHÁ\u0001¢\u0006\u0002\bfR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\u001fR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001d\u001a\u0004\b%\u0010\u001fR&\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010)R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u001fR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u001fR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001d\u001a\u0004\b1\u0010\u001fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u001fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u001d\u001a\u0004\b5\u0010\u001fR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u001d\u001a\u0004\b7\u0010\u001fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001d\u001a\u0004\b9\u0010\u001fR\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\u001fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010\u001fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010\u001d\u001a\u0004\b?\u0010\u001fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001d\u001a\u0004\bA\u0010\u001fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u001d\u001a\u0004\bC\u0010\u001fR\u001e\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bD\u0010\u001d\u001a\u0004\bE\u0010\u001f¨\u0006i"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;", "", "seen1", "", "type", "", PushNotificationArg.CATEGORY, "priority", "originalPriority", "notificationTitle", "notificationBody", "dataTitle", "dataBody", "url", "sipUUID", NavArg.SIP_ADDRESS, NavArg.SIP_PORT, NavArg.SIP_TRANSPORT, "sipRegistrationState", "sipRegistrationMessage", NavArg.DEVICE_ID, "callId", "message", "exception", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCallId$annotations", "()V", "getCallId", "()Ljava/lang/String;", "getCategory$annotations", "getCategory", "getDataBody$annotations", "getDataBody", "getDataTitle$annotations", "getDataTitle", "getDeviceId$annotations", "getDeviceId", "setDeviceId", "(Ljava/lang/String;)V", "getException$annotations", "getException", "getMessage$annotations", "getMessage", "getNotificationBody$annotations", "getNotificationBody", "getNotificationTitle$annotations", "getNotificationTitle", "getOriginalPriority$annotations", "getOriginalPriority", "getPriority$annotations", "getPriority", "getSipAddress$annotations", "getSipAddress", "getSipPort$annotations", "getSipPort", "getSipRegistrationMessage$annotations", "getSipRegistrationMessage", "getSipRegistrationState$annotations", "getSipRegistrationState", "getSipTransport$annotations", "getSipTransport", "getSipUUID$annotations", "getSipUUID", "getType$annotations", "getType", "getUrl$annotations", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class RemoteLogMessage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String callId;
    private final String category;
    private final String dataBody;
    private final String dataTitle;
    private String deviceId;
    private final String exception;
    private final String message;
    private final String notificationBody;
    private final String notificationTitle;
    private final String originalPriority;
    private final String priority;
    private final String sipAddress;
    private final String sipPort;
    private final String sipRegistrationMessage;
    private final String sipRegistrationState;
    private final String sipTransport;
    private final String sipUUID;
    private final String type;
    private final String url;

    public RemoteLogMessage() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 524287, (DefaultConstructorMarker) null);
    }

    @SerialName("call_id")
    public static /* synthetic */ void getCallId$annotations() {
    }

    @SerialName(PushNotificationArg.CATEGORY)
    public static /* synthetic */ void getCategory$annotations() {
    }

    @SerialName("data_body")
    public static /* synthetic */ void getDataBody$annotations() {
    }

    @SerialName("data_title")
    public static /* synthetic */ void getDataTitle$annotations() {
    }

    @SerialName("device_id")
    public static /* synthetic */ void getDeviceId$annotations() {
    }

    @SerialName("exception")
    public static /* synthetic */ void getException$annotations() {
    }

    @SerialName("message")
    public static /* synthetic */ void getMessage$annotations() {
    }

    @SerialName("notification_body")
    public static /* synthetic */ void getNotificationBody$annotations() {
    }

    @SerialName("notification_title")
    public static /* synthetic */ void getNotificationTitle$annotations() {
    }

    @SerialName("original_priority")
    public static /* synthetic */ void getOriginalPriority$annotations() {
    }

    @SerialName("priority")
    public static /* synthetic */ void getPriority$annotations() {
    }

    @SerialName(PushNotificationArg.SIP_ADDRESS)
    public static /* synthetic */ void getSipAddress$annotations() {
    }

    @SerialName(PushNotificationArg.SIP_PORT)
    public static /* synthetic */ void getSipPort$annotations() {
    }

    @SerialName("sip_registration_message")
    public static /* synthetic */ void getSipRegistrationMessage$annotations() {
    }

    @SerialName("sip_registration_state")
    public static /* synthetic */ void getSipRegistrationState$annotations() {
    }

    @SerialName(PushNotificationArg.SIP_TRANSPORT)
    public static /* synthetic */ void getSipTransport$annotations() {
    }

    @SerialName("sip_uuid")
    public static /* synthetic */ void getSipUUID$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    @SerialName("data_url")
    public static /* synthetic */ void getUrl$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSipUUID() {
        return this.sipUUID;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSipAddress() {
        return this.sipAddress;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSipPort() {
        return this.sipPort;
    }

    /* renamed from: component13, reason: from getter */
    public final String getSipTransport() {
        return this.sipTransport;
    }

    /* renamed from: component14, reason: from getter */
    public final String getSipRegistrationState() {
        return this.sipRegistrationState;
    }

    /* renamed from: component15, reason: from getter */
    public final String getSipRegistrationMessage() {
        return this.sipRegistrationMessage;
    }

    /* renamed from: component16, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component17, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* renamed from: component18, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component19, reason: from getter */
    public final String getException() {
        return this.exception;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPriority() {
        return this.priority;
    }

    /* renamed from: component4, reason: from getter */
    public final String getOriginalPriority() {
        return this.originalPriority;
    }

    /* renamed from: component5, reason: from getter */
    public final String getNotificationTitle() {
        return this.notificationTitle;
    }

    /* renamed from: component6, reason: from getter */
    public final String getNotificationBody() {
        return this.notificationBody;
    }

    /* renamed from: component7, reason: from getter */
    public final String getDataTitle() {
        return this.dataTitle;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDataBody() {
        return this.dataBody;
    }

    /* renamed from: component9, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final RemoteLogMessage copy(String type, String category, String priority, String originalPriority, String notificationTitle, String notificationBody, String dataTitle, String dataBody, String url, String sipUUID, String sipAddress, String sipPort, String sipTransport, String sipRegistrationState, String sipRegistrationMessage, String deviceId, String callId, String message, String exception) {
        return new RemoteLogMessage(type, category, priority, originalPriority, notificationTitle, notificationBody, dataTitle, dataBody, url, sipUUID, sipAddress, sipPort, sipTransport, sipRegistrationState, sipRegistrationMessage, deviceId, callId, message, exception);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteLogMessage)) {
            return false;
        }
        RemoteLogMessage remoteLogMessage = (RemoteLogMessage) other;
        return Intrinsics.areEqual(this.type, remoteLogMessage.type) && Intrinsics.areEqual(this.category, remoteLogMessage.category) && Intrinsics.areEqual(this.priority, remoteLogMessage.priority) && Intrinsics.areEqual(this.originalPriority, remoteLogMessage.originalPriority) && Intrinsics.areEqual(this.notificationTitle, remoteLogMessage.notificationTitle) && Intrinsics.areEqual(this.notificationBody, remoteLogMessage.notificationBody) && Intrinsics.areEqual(this.dataTitle, remoteLogMessage.dataTitle) && Intrinsics.areEqual(this.dataBody, remoteLogMessage.dataBody) && Intrinsics.areEqual(this.url, remoteLogMessage.url) && Intrinsics.areEqual(this.sipUUID, remoteLogMessage.sipUUID) && Intrinsics.areEqual(this.sipAddress, remoteLogMessage.sipAddress) && Intrinsics.areEqual(this.sipPort, remoteLogMessage.sipPort) && Intrinsics.areEqual(this.sipTransport, remoteLogMessage.sipTransport) && Intrinsics.areEqual(this.sipRegistrationState, remoteLogMessage.sipRegistrationState) && Intrinsics.areEqual(this.sipRegistrationMessage, remoteLogMessage.sipRegistrationMessage) && Intrinsics.areEqual(this.deviceId, remoteLogMessage.deviceId) && Intrinsics.areEqual(this.callId, remoteLogMessage.callId) && Intrinsics.areEqual(this.message, remoteLogMessage.message) && Intrinsics.areEqual(this.exception, remoteLogMessage.exception);
    }

    public int hashCode() {
        String str = this.type;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.category;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.priority;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.originalPriority;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.notificationTitle;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.notificationBody;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.dataTitle;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.dataBody;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.url;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.sipUUID;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.sipAddress;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.sipPort;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.sipTransport;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.sipRegistrationState;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.sipRegistrationMessage;
        int hashCode15 = (hashCode14 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.deviceId;
        int hashCode16 = (hashCode15 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.callId;
        int hashCode17 = (hashCode16 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.message;
        int hashCode18 = (hashCode17 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.exception;
        return hashCode18 + (str19 != null ? str19.hashCode() : 0);
    }

    public String toString() {
        return "RemoteLogMessage(type=" + this.type + ", category=" + this.category + ", priority=" + this.priority + ", originalPriority=" + this.originalPriority + ", notificationTitle=" + this.notificationTitle + ", notificationBody=" + this.notificationBody + ", dataTitle=" + this.dataTitle + ", dataBody=" + this.dataBody + ", url=" + this.url + ", sipUUID=" + this.sipUUID + ", sipAddress=" + this.sipAddress + ", sipPort=" + this.sipPort + ", sipTransport=" + this.sipTransport + ", sipRegistrationState=" + this.sipRegistrationState + ", sipRegistrationMessage=" + this.sipRegistrationMessage + ", deviceId=" + this.deviceId + ", callId=" + this.callId + ", message=" + this.message + ", exception=" + this.exception + ")";
    }

    /* compiled from: RemoteLogEntity.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RemoteLogMessage> serializer() {
            return RemoteLogMessage$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RemoteLogMessage(int i, @SerialName("type") String str, @SerialName("category") String str2, @SerialName("priority") String str3, @SerialName("original_priority") String str4, @SerialName("notification_title") String str5, @SerialName("notification_body") String str6, @SerialName("data_title") String str7, @SerialName("data_body") String str8, @SerialName("data_url") String str9, @SerialName("sip_uuid") String str10, @SerialName("sip_address") String str11, @SerialName("sip_port") String str12, @SerialName("sip_transport") String str13, @SerialName("sip_registration_state") String str14, @SerialName("sip_registration_message") String str15, @SerialName("device_id") String str16, @SerialName("call_id") String str17, @SerialName("message") String str18, @SerialName("exception") String str19, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.type = null;
        } else {
            this.type = str;
        }
        if ((i & 2) == 0) {
            this.category = null;
        } else {
            this.category = str2;
        }
        if ((i & 4) == 0) {
            this.priority = null;
        } else {
            this.priority = str3;
        }
        if ((i & 8) == 0) {
            this.originalPriority = null;
        } else {
            this.originalPriority = str4;
        }
        if ((i & 16) == 0) {
            this.notificationTitle = null;
        } else {
            this.notificationTitle = str5;
        }
        if ((i & 32) == 0) {
            this.notificationBody = null;
        } else {
            this.notificationBody = str6;
        }
        if ((i & 64) == 0) {
            this.dataTitle = null;
        } else {
            this.dataTitle = str7;
        }
        if ((i & 128) == 0) {
            this.dataBody = null;
        } else {
            this.dataBody = str8;
        }
        if ((i & 256) == 0) {
            this.url = null;
        } else {
            this.url = str9;
        }
        if ((i & 512) == 0) {
            this.sipUUID = null;
        } else {
            this.sipUUID = str10;
        }
        if ((i & 1024) == 0) {
            this.sipAddress = null;
        } else {
            this.sipAddress = str11;
        }
        if ((i & 2048) == 0) {
            this.sipPort = null;
        } else {
            this.sipPort = str12;
        }
        if ((i & 4096) == 0) {
            this.sipTransport = null;
        } else {
            this.sipTransport = str13;
        }
        if ((i & 8192) == 0) {
            this.sipRegistrationState = null;
        } else {
            this.sipRegistrationState = str14;
        }
        if ((i & 16384) == 0) {
            this.sipRegistrationMessage = null;
        } else {
            this.sipRegistrationMessage = str15;
        }
        if ((32768 & i) == 0) {
            this.deviceId = null;
        } else {
            this.deviceId = str16;
        }
        if ((65536 & i) == 0) {
            this.callId = null;
        } else {
            this.callId = str17;
        }
        if ((131072 & i) == 0) {
            this.message = null;
        } else {
            this.message = str18;
        }
        if ((i & 262144) == 0) {
            this.exception = null;
        } else {
            this.exception = str19;
        }
    }

    public RemoteLogMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19) {
        this.type = str;
        this.category = str2;
        this.priority = str3;
        this.originalPriority = str4;
        this.notificationTitle = str5;
        this.notificationBody = str6;
        this.dataTitle = str7;
        this.dataBody = str8;
        this.url = str9;
        this.sipUUID = str10;
        this.sipAddress = str11;
        this.sipPort = str12;
        this.sipTransport = str13;
        this.sipRegistrationState = str14;
        this.sipRegistrationMessage = str15;
        this.deviceId = str16;
        this.callId = str17;
        this.message = str18;
        this.exception = str19;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(RemoteLogMessage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.category != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.category);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.priority != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.priority);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.originalPriority != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.originalPriority);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.notificationTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.notificationTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.notificationBody != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.notificationBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.dataTitle != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.dataTitle);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.dataBody != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.dataBody);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.url != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.url);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.sipUUID != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.sipUUID);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.sipAddress != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.sipAddress);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.sipPort != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.sipPort);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 12) || self.sipTransport != null) {
            output.encodeNullableSerializableElement(serialDesc, 12, StringSerializer.INSTANCE, self.sipTransport);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.sipRegistrationState != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, StringSerializer.INSTANCE, self.sipRegistrationState);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.sipRegistrationMessage != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, StringSerializer.INSTANCE, self.sipRegistrationMessage);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.deviceId != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, StringSerializer.INSTANCE, self.deviceId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.callId != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, StringSerializer.INSTANCE, self.callId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 17) || self.message != null) {
            output.encodeNullableSerializableElement(serialDesc, 17, StringSerializer.INSTANCE, self.message);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 18) && self.exception == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 18, StringSerializer.INSTANCE, self.exception);
    }

    public /* synthetic */ RemoteLogMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) != 0 ? null : str15, (i & 32768) != 0 ? null : str16, (i & 65536) != 0 ? null : str17, (i & 131072) != 0 ? null : str18, (i & 262144) != 0 ? null : str19);
    }

    public final String getType() {
        return this.type;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final String getOriginalPriority() {
        return this.originalPriority;
    }

    public final String getNotificationTitle() {
        return this.notificationTitle;
    }

    public final String getNotificationBody() {
        return this.notificationBody;
    }

    public final String getDataTitle() {
        return this.dataTitle;
    }

    public final String getDataBody() {
        return this.dataBody;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getSipUUID() {
        return this.sipUUID;
    }

    public final String getSipAddress() {
        return this.sipAddress;
    }

    public final String getSipPort() {
        return this.sipPort;
    }

    public final String getSipTransport() {
        return this.sipTransport;
    }

    public final String getSipRegistrationState() {
        return this.sipRegistrationState;
    }

    public final String getSipRegistrationMessage() {
        return this.sipRegistrationMessage;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getException() {
        return this.exception;
    }
}
