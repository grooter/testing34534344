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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 82\u00020\u0001:\u000278Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBK\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0010J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J]\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001J\t\u0010.\u001a\u00020\u0005HÖ\u0001J&\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205HÁ\u0001¢\u0006\u0002\b6R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014¨\u00069"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/DeviceInfoRequest;", "", "seen1", "", "deviceOsVersion", "", "appVersionName", "deviceAppVersionData", "Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;", "providerName", "deviceName", "connectionType", "batteryLevel", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersionName$annotations", "()V", "getAppVersionName", "()Ljava/lang/String;", "getBatteryLevel$annotations", "getBatteryLevel", "getConnectionType$annotations", "getConnectionType", "getDeviceAppVersionData$annotations", "getDeviceAppVersionData", "()Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;", "getDeviceName$annotations", "getDeviceName", "getDeviceOsVersion$annotations", "getDeviceOsVersion", "getProviderName$annotations", "getProviderName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class DeviceInfoRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appVersionName;
    private final String batteryLevel;
    private final String connectionType;
    private final DeviceInfoData deviceAppVersionData;
    private final String deviceName;
    private final String deviceOsVersion;
    private final String providerName;

    public static /* synthetic */ DeviceInfoRequest copy$default(DeviceInfoRequest deviceInfoRequest, String str, String str2, DeviceInfoData deviceInfoData, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfoRequest.deviceOsVersion;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfoRequest.appVersionName;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            deviceInfoData = deviceInfoRequest.deviceAppVersionData;
        }
        DeviceInfoData deviceInfoData2 = deviceInfoData;
        if ((i & 8) != 0) {
            str3 = deviceInfoRequest.providerName;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = deviceInfoRequest.deviceName;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = deviceInfoRequest.connectionType;
        }
        String str10 = str5;
        if ((i & 64) != 0) {
            str6 = deviceInfoRequest.batteryLevel;
        }
        return deviceInfoRequest.copy(str, str7, deviceInfoData2, str8, str9, str10, str6);
    }

    @SerialName("device_app_version")
    public static /* synthetic */ void getAppVersionName$annotations() {
    }

    @SerialName("battery_level")
    public static /* synthetic */ void getBatteryLevel$annotations() {
    }

    @SerialName("connection_type")
    public static /* synthetic */ void getConnectionType$annotations() {
    }

    @SerialName("device_app_version_data")
    public static /* synthetic */ void getDeviceAppVersionData$annotations() {
    }

    @SerialName("device_name")
    public static /* synthetic */ void getDeviceName$annotations() {
    }

    @SerialName("device_os_version")
    public static /* synthetic */ void getDeviceOsVersion$annotations() {
    }

    @SerialName("provider_name")
    public static /* synthetic */ void getProviderName$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersionName() {
        return this.appVersionName;
    }

    /* renamed from: component3, reason: from getter */
    public final DeviceInfoData getDeviceAppVersionData() {
        return this.deviceAppVersionData;
    }

    /* renamed from: component4, reason: from getter */
    public final String getProviderName() {
        return this.providerName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getConnectionType() {
        return this.connectionType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getBatteryLevel() {
        return this.batteryLevel;
    }

    public final DeviceInfoRequest copy(String deviceOsVersion, String appVersionName, DeviceInfoData deviceAppVersionData, String providerName, String deviceName, String connectionType, String batteryLevel) {
        return new DeviceInfoRequest(deviceOsVersion, appVersionName, deviceAppVersionData, providerName, deviceName, connectionType, batteryLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfoRequest)) {
            return false;
        }
        DeviceInfoRequest deviceInfoRequest = (DeviceInfoRequest) other;
        return Intrinsics.areEqual(this.deviceOsVersion, deviceInfoRequest.deviceOsVersion) && Intrinsics.areEqual(this.appVersionName, deviceInfoRequest.appVersionName) && Intrinsics.areEqual(this.deviceAppVersionData, deviceInfoRequest.deviceAppVersionData) && Intrinsics.areEqual(this.providerName, deviceInfoRequest.providerName) && Intrinsics.areEqual(this.deviceName, deviceInfoRequest.deviceName) && Intrinsics.areEqual(this.connectionType, deviceInfoRequest.connectionType) && Intrinsics.areEqual(this.batteryLevel, deviceInfoRequest.batteryLevel);
    }

    public int hashCode() {
        String str = this.deviceOsVersion;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.appVersionName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        DeviceInfoData deviceInfoData = this.deviceAppVersionData;
        int hashCode3 = (hashCode2 + (deviceInfoData == null ? 0 : deviceInfoData.hashCode())) * 31;
        String str3 = this.providerName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.deviceName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.connectionType;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.batteryLevel;
        return hashCode6 + (str6 != null ? str6.hashCode() : 0);
    }

    public String toString() {
        return "DeviceInfoRequest(deviceOsVersion=" + this.deviceOsVersion + ", appVersionName=" + this.appVersionName + ", deviceAppVersionData=" + this.deviceAppVersionData + ", providerName=" + this.providerName + ", deviceName=" + this.deviceName + ", connectionType=" + this.connectionType + ", batteryLevel=" + this.batteryLevel + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/DeviceInfoRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/DeviceInfoRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<DeviceInfoRequest> serializer() {
            return DeviceInfoRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DeviceInfoRequest(int i, @SerialName("device_os_version") String str, @SerialName("device_app_version") String str2, @SerialName("device_app_version_data") DeviceInfoData deviceInfoData, @SerialName("provider_name") String str3, @SerialName("device_name") String str4, @SerialName("connection_type") String str5, @SerialName("battery_level") String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, DeviceInfoRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.deviceOsVersion = str;
        this.appVersionName = str2;
        this.deviceAppVersionData = deviceInfoData;
        this.providerName = str3;
        this.deviceName = str4;
        this.connectionType = str5;
        this.batteryLevel = str6;
    }

    public DeviceInfoRequest(String str, String str2, DeviceInfoData deviceInfoData, String str3, String str4, String str5, String str6) {
        this.deviceOsVersion = str;
        this.appVersionName = str2;
        this.deviceAppVersionData = deviceInfoData;
        this.providerName = str3;
        this.deviceName = str4;
        this.connectionType = str5;
        this.batteryLevel = str6;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(DeviceInfoRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.deviceOsVersion);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.appVersionName);
        output.encodeNullableSerializableElement(serialDesc, 2, DeviceInfoData$$serializer.INSTANCE, self.deviceAppVersionData);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.providerName);
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.deviceName);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.connectionType);
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.batteryLevel);
    }

    public final String getDeviceOsVersion() {
        return this.deviceOsVersion;
    }

    public final String getAppVersionName() {
        return this.appVersionName;
    }

    public final DeviceInfoData getDeviceAppVersionData() {
        return this.deviceAppVersionData;
    }

    public final String getProviderName() {
        return this.providerName;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getConnectionType() {
        return this.connectionType;
    }

    public final String getBatteryLevel() {
        return this.batteryLevel;
    }
}
