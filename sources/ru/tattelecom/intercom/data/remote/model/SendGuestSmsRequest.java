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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0005HÖ\u0001J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0014¨\u0006."}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SendGuestSmsRequest;", "", "seen1", "", "phone", "", "deviceCode", NavArg.VerifyCode.GUEST_PHONE, NavArg.VerifyCode.APARTMENT_ID, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getApartmentId$annotations", "()V", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDeviceCode$annotations", "getDeviceCode", "()Ljava/lang/String;", "getGuestPhone$annotations", "getGuestPhone", "getPhone$annotations", "getPhone", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/SendGuestSmsRequest;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SendGuestSmsRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apartmentId;
    private final String deviceCode;
    private final String guestPhone;
    private final String phone;

    public static /* synthetic */ SendGuestSmsRequest copy$default(SendGuestSmsRequest sendGuestSmsRequest, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sendGuestSmsRequest.phone;
        }
        if ((i & 2) != 0) {
            str2 = sendGuestSmsRequest.deviceCode;
        }
        if ((i & 4) != 0) {
            str3 = sendGuestSmsRequest.guestPhone;
        }
        if ((i & 8) != 0) {
            num = sendGuestSmsRequest.apartmentId;
        }
        return sendGuestSmsRequest.copy(str, str2, str3, num);
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

    /* renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceCode() {
        return this.deviceCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getGuestPhone() {
        return this.guestPhone;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getApartmentId() {
        return this.apartmentId;
    }

    public final SendGuestSmsRequest copy(String phone, String deviceCode, String guestPhone, Integer apartmentId) {
        return new SendGuestSmsRequest(phone, deviceCode, guestPhone, apartmentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SendGuestSmsRequest)) {
            return false;
        }
        SendGuestSmsRequest sendGuestSmsRequest = (SendGuestSmsRequest) other;
        return Intrinsics.areEqual(this.phone, sendGuestSmsRequest.phone) && Intrinsics.areEqual(this.deviceCode, sendGuestSmsRequest.deviceCode) && Intrinsics.areEqual(this.guestPhone, sendGuestSmsRequest.guestPhone) && Intrinsics.areEqual(this.apartmentId, sendGuestSmsRequest.apartmentId);
    }

    public int hashCode() {
        String str = this.phone;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceCode;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.guestPhone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.apartmentId;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "SendGuestSmsRequest(phone=" + this.phone + ", deviceCode=" + this.deviceCode + ", guestPhone=" + this.guestPhone + ", apartmentId=" + this.apartmentId + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SendGuestSmsRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/SendGuestSmsRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SendGuestSmsRequest> serializer() {
            return SendGuestSmsRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SendGuestSmsRequest(int i, @SerialName("phone") String str, @SerialName("device_code") String str2, @SerialName("guest_phone") String str3, @SerialName("apartment_id") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, SendGuestSmsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.phone = str;
        this.deviceCode = str2;
        this.guestPhone = str3;
        this.apartmentId = num;
    }

    public SendGuestSmsRequest(String str, String str2, String str3, Integer num) {
        this.phone = str;
        this.deviceCode = str2;
        this.guestPhone = str3;
        this.apartmentId = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(SendGuestSmsRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.phone);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deviceCode);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.guestPhone);
        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.apartmentId);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final String getGuestPhone() {
        return this.guestPhone;
    }

    public final Integer getApartmentId() {
        return this.apartmentId;
    }
}
