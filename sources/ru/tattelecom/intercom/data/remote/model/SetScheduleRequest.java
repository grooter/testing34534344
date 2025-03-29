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
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 T2\u00020\u0001:\u0002STB©\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\r\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r\u0012\b\b\u0001\u0010\u000f\u001a\u00020\r\u0012\b\b\u0001\u0010\u0010\u001a\u00020\r\u0012\b\b\u0001\u0010\u0011\u001a\u00020\r\u0012\b\b\u0001\u0010\u0012\u001a\u00020\r\u0012\b\b\u0001\u0010\u0013\u001a\u00020\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016By\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\r¢\u0006\u0002\u0010\u0017J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\rHÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\t\u0010E\u001a\u00020\rHÆ\u0003J\u0099\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\rHÆ\u0001J\u0013\u0010G\u001a\u00020\r2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020\u0003HÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001J&\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QHÁ\u0001¢\u0006\u0002\bRR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u0019\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001eR\u001c\u0010\u0011\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010#R\u001c\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001eR\u001c\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010#R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR\u001c\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u0019\u001a\u0004\b+\u0010#R\u001c\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0019\u001a\u0004\b-\u0010\u001eR\u001c\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u0019\u001a\u0004\b/\u0010\u001eR\u001c\u0010\u0013\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u0019\u001a\u0004\b1\u0010#R\u001c\u0010\u0010\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b2\u0010\u0019\u001a\u0004\b3\u0010#R\u001c\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b4\u0010\u0019\u001a\u0004\b5\u0010#R\u001c\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010\u0019\u001a\u0004\b7\u0010#¨\u0006U"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SetScheduleRequest;", "", "seen1", "", "phone", "", "deviceCode", NavArg.INTERCOM_ID, "startHour", "startMinute", "finishHour", "finishMinute", "monday", "", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;IIIIIZZZZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;IIIIIZZZZZZZ)V", "getDeviceCode$annotations", "()V", "getDeviceCode", "()Ljava/lang/String;", "getFinishHour$annotations", "getFinishHour", "()I", "getFinishMinute$annotations", "getFinishMinute", "getFriday$annotations", "getFriday", "()Z", "getIntercomId$annotations", "getIntercomId", "getMonday$annotations", "getMonday", "getPhone$annotations", "getPhone", "getSaturday$annotations", "getSaturday", "getStartHour$annotations", "getStartHour", "getStartMinute$annotations", "getStartMinute", "getSunday$annotations", "getSunday", "getThursday$annotations", "getThursday", "getTuesday$annotations", "getTuesday", "getWednesday$annotations", "getWednesday", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SetScheduleRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String deviceCode;
    private final int finishHour;
    private final int finishMinute;
    private final boolean friday;
    private final int intercomId;
    private final boolean monday;
    private final String phone;
    private final boolean saturday;
    private final int startHour;
    private final int startMinute;
    private final boolean sunday;
    private final boolean thursday;
    private final boolean tuesday;
    private final boolean wednesday;

    @SerialName("device_code")
    public static /* synthetic */ void getDeviceCode$annotations() {
    }

    @SerialName("finish_h")
    public static /* synthetic */ void getFinishHour$annotations() {
    }

    @SerialName("finish_m")
    public static /* synthetic */ void getFinishMinute$annotations() {
    }

    @SerialName("friday")
    public static /* synthetic */ void getFriday$annotations() {
    }

    @SerialName("intercom_id")
    public static /* synthetic */ void getIntercomId$annotations() {
    }

    @SerialName("monday")
    public static /* synthetic */ void getMonday$annotations() {
    }

    @SerialName("phone")
    public static /* synthetic */ void getPhone$annotations() {
    }

    @SerialName("saturday")
    public static /* synthetic */ void getSaturday$annotations() {
    }

    @SerialName("start_h")
    public static /* synthetic */ void getStartHour$annotations() {
    }

    @SerialName("start_m")
    public static /* synthetic */ void getStartMinute$annotations() {
    }

    @SerialName("sunday")
    public static /* synthetic */ void getSunday$annotations() {
    }

    @SerialName("thursday")
    public static /* synthetic */ void getThursday$annotations() {
    }

    @SerialName("tuesday")
    public static /* synthetic */ void getTuesday$annotations() {
    }

    @SerialName("wednesday")
    public static /* synthetic */ void getWednesday$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getWednesday() {
        return this.wednesday;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getThursday() {
        return this.thursday;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getFriday() {
        return this.friday;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getSaturday() {
        return this.saturday;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getSunday() {
        return this.sunday;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceCode() {
        return this.deviceCode;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIntercomId() {
        return this.intercomId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getStartHour() {
        return this.startHour;
    }

    /* renamed from: component5, reason: from getter */
    public final int getStartMinute() {
        return this.startMinute;
    }

    /* renamed from: component6, reason: from getter */
    public final int getFinishHour() {
        return this.finishHour;
    }

    /* renamed from: component7, reason: from getter */
    public final int getFinishMinute() {
        return this.finishMinute;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getMonday() {
        return this.monday;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getTuesday() {
        return this.tuesday;
    }

    public final SetScheduleRequest copy(String phone, String deviceCode, int intercomId, int startHour, int startMinute, int finishHour, int finishMinute, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
        return new SetScheduleRequest(phone, deviceCode, intercomId, startHour, startMinute, finishHour, finishMinute, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetScheduleRequest)) {
            return false;
        }
        SetScheduleRequest setScheduleRequest = (SetScheduleRequest) other;
        return Intrinsics.areEqual(this.phone, setScheduleRequest.phone) && Intrinsics.areEqual(this.deviceCode, setScheduleRequest.deviceCode) && this.intercomId == setScheduleRequest.intercomId && this.startHour == setScheduleRequest.startHour && this.startMinute == setScheduleRequest.startMinute && this.finishHour == setScheduleRequest.finishHour && this.finishMinute == setScheduleRequest.finishMinute && this.monday == setScheduleRequest.monday && this.tuesday == setScheduleRequest.tuesday && this.wednesday == setScheduleRequest.wednesday && this.thursday == setScheduleRequest.thursday && this.friday == setScheduleRequest.friday && this.saturday == setScheduleRequest.saturday && this.sunday == setScheduleRequest.sunday;
    }

    public int hashCode() {
        String str = this.phone;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceCode;
        return ((((((((((((((((((((((((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.intercomId) * 31) + this.startHour) * 31) + this.startMinute) * 31) + this.finishHour) * 31) + this.finishMinute) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.monday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.tuesday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.wednesday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.thursday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.friday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.saturday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.sunday);
    }

    public String toString() {
        return "SetScheduleRequest(phone=" + this.phone + ", deviceCode=" + this.deviceCode + ", intercomId=" + this.intercomId + ", startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", finishHour=" + this.finishHour + ", finishMinute=" + this.finishMinute + ", monday=" + this.monday + ", tuesday=" + this.tuesday + ", wednesday=" + this.wednesday + ", thursday=" + this.thursday + ", friday=" + this.friday + ", saturday=" + this.saturday + ", sunday=" + this.sunday + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SetScheduleRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/SetScheduleRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SetScheduleRequest> serializer() {
            return SetScheduleRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SetScheduleRequest(int i, @SerialName("phone") String str, @SerialName("device_code") String str2, @SerialName("intercom_id") int i2, @SerialName("start_h") int i3, @SerialName("start_m") int i4, @SerialName("finish_h") int i5, @SerialName("finish_m") int i6, @SerialName("monday") boolean z, @SerialName("tuesday") boolean z2, @SerialName("wednesday") boolean z3, @SerialName("thursday") boolean z4, @SerialName("friday") boolean z5, @SerialName("saturday") boolean z6, @SerialName("sunday") boolean z7, SerializationConstructorMarker serializationConstructorMarker) {
        if (16383 != (i & 16383)) {
            PluginExceptionsKt.throwMissingFieldException(i, 16383, SetScheduleRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.phone = str;
        this.deviceCode = str2;
        this.intercomId = i2;
        this.startHour = i3;
        this.startMinute = i4;
        this.finishHour = i5;
        this.finishMinute = i6;
        this.monday = z;
        this.tuesday = z2;
        this.wednesday = z3;
        this.thursday = z4;
        this.friday = z5;
        this.saturday = z6;
        this.sunday = z7;
    }

    public SetScheduleRequest(String str, String str2, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.phone = str;
        this.deviceCode = str2;
        this.intercomId = i;
        this.startHour = i2;
        this.startMinute = i3;
        this.finishHour = i4;
        this.finishMinute = i5;
        this.monday = z;
        this.tuesday = z2;
        this.wednesday = z3;
        this.thursday = z4;
        this.friday = z5;
        this.saturday = z6;
        this.sunday = z7;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(SetScheduleRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.phone);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.deviceCode);
        output.encodeIntElement(serialDesc, 2, self.intercomId);
        output.encodeIntElement(serialDesc, 3, self.startHour);
        output.encodeIntElement(serialDesc, 4, self.startMinute);
        output.encodeIntElement(serialDesc, 5, self.finishHour);
        output.encodeIntElement(serialDesc, 6, self.finishMinute);
        output.encodeBooleanElement(serialDesc, 7, self.monday);
        output.encodeBooleanElement(serialDesc, 8, self.tuesday);
        output.encodeBooleanElement(serialDesc, 9, self.wednesday);
        output.encodeBooleanElement(serialDesc, 10, self.thursday);
        output.encodeBooleanElement(serialDesc, 11, self.friday);
        output.encodeBooleanElement(serialDesc, 12, self.saturday);
        output.encodeBooleanElement(serialDesc, 13, self.sunday);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getDeviceCode() {
        return this.deviceCode;
    }

    public final int getIntercomId() {
        return this.intercomId;
    }

    public final int getStartHour() {
        return this.startHour;
    }

    public final int getStartMinute() {
        return this.startMinute;
    }

    public final int getFinishHour() {
        return this.finishHour;
    }

    public final int getFinishMinute() {
        return this.finishMinute;
    }

    public final boolean getMonday() {
        return this.monday;
    }

    public final boolean getTuesday() {
        return this.tuesday;
    }

    public final boolean getWednesday() {
        return this.wednesday;
    }

    public final boolean getThursday() {
        return this.thursday;
    }

    public final boolean getFriday() {
        return this.friday;
    }

    public final boolean getSaturday() {
        return this.saturday;
    }

    public final boolean getSunday() {
        return this.sunday;
    }
}
