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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB#\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f¨\u0006*"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SetIntercomCallsRequest;", "", "seen1", "", "phone", "", "deviceCode", NavArg.INTERCOM_ID, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDeviceCode$annotations", "()V", "getDeviceCode", "()Ljava/lang/String;", "getIntercomId$annotations", "getIntercomId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPhone$annotations", "getPhone", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/SetIntercomCallsRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SetIntercomCallsRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String deviceCode;
    private final Integer intercomId;
    private final String phone;

    public static /* synthetic */ SetIntercomCallsRequest copy$default(SetIntercomCallsRequest setIntercomCallsRequest, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setIntercomCallsRequest.phone;
        }
        if ((i & 2) != 0) {
            str2 = setIntercomCallsRequest.deviceCode;
        }
        if ((i & 4) != 0) {
            num = setIntercomCallsRequest.intercomId;
        }
        return setIntercomCallsRequest.copy(str, str2, num);
    }

    @SerialName("device_code")
    public static /* synthetic */ void getDeviceCode$annotations() {
    }

    @SerialName("intercom_id")
    public static /* synthetic */ void getIntercomId$annotations() {
    }

    @SerialName("phone")
    public static /* synthetic */ void getPhone$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceCode() {
        return this.deviceCode;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getIntercomId() {
        return this.intercomId;
    }

    public final SetIntercomCallsRequest copy(String phone, String deviceCode, Integer intercomId) {
        return new SetIntercomCallsRequest(phone, deviceCode, intercomId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetIntercomCallsRequest)) {
            return false;
        }
        SetIntercomCallsRequest setIntercomCallsRequest = (SetIntercomCallsRequest) other;
        return Intrinsics.areEqual(this.phone, setIntercomCallsRequest.phone) && Intrinsics.areEqual(this.deviceCode, setIntercomCallsRequest.deviceCode) && Intrinsics.areEqual(this.intercomId, setIntercomCallsRequest.intercomId);
    }

    public int hashCode() {
        String str = this.phone;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.intercomId;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "SetIntercomCallsRequest(phone=" + this.phone + ", deviceCode=" + this.deviceCode + ", intercomId=" + this.intercomId + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SetIntercomCallsRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/SetIntercomCallsRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SetIntercomCallsRequest> serializer() {
            return SetIntercomCallsRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SetIntercomCallsRequest(int i, @SerialName("phone") String str, @SerialName("device_code") String str2, @SerialName("intercom_id") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, SetIntercomCallsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.phone = str;
        this.deviceCode = str2;
        this.intercomId = num;
    }

    public SetIntercomCallsRequest(String str, String str2, Integer num) {
        this.phone = str;
        this.deviceCode = str2;
        this.intercomId = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(SetIntercomCallsRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.phone);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deviceCode);
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.intercomId);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final Integer getIntercomId() {
        return this.intercomId;
    }
}
