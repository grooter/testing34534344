package ru.tattelecom.intercom.data.remote.model;

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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;", "", "seen1", "", "deviceApiVersion", "", "appVersionCode", "sentAt", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersionCode$annotations", "()V", "getAppVersionCode", "()Ljava/lang/String;", "getDeviceApiVersion$annotations", "getDeviceApiVersion", "getSentAt$annotations", "getSentAt", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DeviceInfoData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appVersionCode;
    private final String deviceApiVersion;
    private final String sentAt;

    public static /* synthetic */ DeviceInfoData copy$default(DeviceInfoData deviceInfoData, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfoData.deviceApiVersion;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfoData.appVersionCode;
        }
        if ((i & 4) != 0) {
            str3 = deviceInfoData.sentAt;
        }
        return deviceInfoData.copy(str, str2, str3);
    }

    @SerialName("app_version_code")
    public static /* synthetic */ void getAppVersionCode$annotations() {
    }

    @SerialName("api_version")
    public static /* synthetic */ void getDeviceApiVersion$annotations() {
    }

    @SerialName("sent_at")
    public static /* synthetic */ void getSentAt$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceApiVersion() {
        return this.deviceApiVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersionCode() {
        return this.appVersionCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSentAt() {
        return this.sentAt;
    }

    public final DeviceInfoData copy(String deviceApiVersion, String appVersionCode, String sentAt) {
        return new DeviceInfoData(deviceApiVersion, appVersionCode, sentAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfoData)) {
            return false;
        }
        DeviceInfoData deviceInfoData = (DeviceInfoData) other;
        return Intrinsics.areEqual(this.deviceApiVersion, deviceInfoData.deviceApiVersion) && Intrinsics.areEqual(this.appVersionCode, deviceInfoData.appVersionCode) && Intrinsics.areEqual(this.sentAt, deviceInfoData.sentAt);
    }

    public int hashCode() {
        String str = this.deviceApiVersion;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appVersionCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sentAt;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "DeviceInfoData(deviceApiVersion=" + this.deviceApiVersion + ", appVersionCode=" + this.appVersionCode + ", sentAt=" + this.sentAt + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/DeviceInfoData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeviceInfoData> serializer() {
            return DeviceInfoData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DeviceInfoData(int i, @SerialName("api_version") String str, @SerialName("app_version_code") String str2, @SerialName("sent_at") String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, DeviceInfoData$$serializer.INSTANCE.getDescriptor());
        }
        this.deviceApiVersion = str;
        this.appVersionCode = str2;
        this.sentAt = str3;
    }

    public DeviceInfoData(String str, String str2, String str3) {
        this.deviceApiVersion = str;
        this.appVersionCode = str2;
        this.sentAt = str3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(DeviceInfoData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.deviceApiVersion);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.appVersionCode);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.sentAt);
    }

    public final String getDeviceApiVersion() {
        return this.deviceApiVersion;
    }

    public final String getAppVersionCode() {
        return this.appVersionCode;
    }

    public final String getSentAt() {
        return this.sentAt;
    }
}
