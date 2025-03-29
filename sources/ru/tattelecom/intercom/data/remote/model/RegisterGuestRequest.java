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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000234BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB7\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001J&\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201HÁ\u0001¢\u0006\u0002\b2R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0016R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001e\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/RegisterGuestRequest;", "", "seen1", "", "phone", "", "deviceCode", "smsCode", "", NavArg.VerifyCode.GUEST_PHONE, NavArg.VerifyCode.APARTMENT_ID, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "getApartmentId$annotations", "()V", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeviceCode$annotations", "getDeviceCode", "()Ljava/lang/String;", "getGuestPhone$annotations", "getGuestPhone", "getPhone$annotations", "getPhone", "getSmsCode$annotations", "getSmsCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/RegisterGuestRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class RegisterGuestRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apartmentId;
    private final String deviceCode;
    private final String guestPhone;
    private final String phone;
    private final Long smsCode;

    public static /* synthetic */ RegisterGuestRequest copy$default(RegisterGuestRequest registerGuestRequest, String str, String str2, Long l, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registerGuestRequest.phone;
        }
        if ((i & 2) != 0) {
            str2 = registerGuestRequest.deviceCode;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            l = registerGuestRequest.smsCode;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            str3 = registerGuestRequest.guestPhone;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            num = registerGuestRequest.apartmentId;
        }
        return registerGuestRequest.copy(str, str4, l2, str5, num);
    }

    @SerialName("apartment_id")
    public static /* synthetic */ void getApartmentId$annotations() {
    }

    @SerialName("device_code")
    public static /* synthetic */ void getDeviceCode$annotations() {
    }

    @SerialName("guest_phone")
    public static /* synthetic */ void getGuestPhone$annotations() {
    }

    @SerialName("phone")
    public static /* synthetic */ void getPhone$annotations() {
    }

    @SerialName("sms_code")
    public static /* synthetic */ void getSmsCode$annotations() {
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
    public final Long getSmsCode() {
        return this.smsCode;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGuestPhone() {
        return this.guestPhone;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getApartmentId() {
        return this.apartmentId;
    }

    public final RegisterGuestRequest copy(String phone, String deviceCode, Long smsCode, String guestPhone, Integer apartmentId) {
        return new RegisterGuestRequest(phone, deviceCode, smsCode, guestPhone, apartmentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterGuestRequest)) {
            return false;
        }
        RegisterGuestRequest registerGuestRequest = (RegisterGuestRequest) other;
        return Intrinsics.areEqual(this.phone, registerGuestRequest.phone) && Intrinsics.areEqual(this.deviceCode, registerGuestRequest.deviceCode) && Intrinsics.areEqual(this.smsCode, registerGuestRequest.smsCode) && Intrinsics.areEqual(this.guestPhone, registerGuestRequest.guestPhone) && Intrinsics.areEqual(this.apartmentId, registerGuestRequest.apartmentId);
    }

    public int hashCode() {
        String str = this.phone;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.smsCode;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        String str3 = this.guestPhone;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.apartmentId;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "RegisterGuestRequest(phone=" + this.phone + ", deviceCode=" + this.deviceCode + ", smsCode=" + this.smsCode + ", guestPhone=" + this.guestPhone + ", apartmentId=" + this.apartmentId + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/RegisterGuestRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/RegisterGuestRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<RegisterGuestRequest> serializer() {
            return RegisterGuestRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ RegisterGuestRequest(int i, @SerialName("phone") String str, @SerialName("device_code") String str2, @SerialName("sms_code") Long l, @SerialName("guest_phone") String str3, @SerialName("apartment_id") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, RegisterGuestRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.phone = str;
        this.deviceCode = str2;
        this.smsCode = l;
        this.guestPhone = str3;
        this.apartmentId = num;
    }

    public RegisterGuestRequest(String str, String str2, Long l, String str3, Integer num) {
        this.phone = str;
        this.deviceCode = str2;
        this.smsCode = l;
        this.guestPhone = str3;
        this.apartmentId = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(RegisterGuestRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.phone);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deviceCode);
        output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.smsCode);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.guestPhone);
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.apartmentId);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final Long getSmsCode() {
        return this.smsCode;
    }

    public final String getGuestPhone() {
        return this.guestPhone;
    }

    public final Integer getApartmentId() {
        return this.apartmentId;
    }
}
