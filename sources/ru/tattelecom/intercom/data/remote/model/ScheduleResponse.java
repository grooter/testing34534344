package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.apache.commons.compress.archivers.zip.UnixStat;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 S2\u00020\u0001:\u0002RSB\u0099\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013B}\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010<\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010=\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010>\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u009e\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\u00062\b\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\t\u0010H\u001a\u00020IHÖ\u0001J&\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020PHÁ\u0001¢\u0006\u0002\bQR(\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001b\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001b\u0012\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R(\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001b\u0012\u0004\b)\u0010\u0016\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR(\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0002\u0010\u001b\u0012\u0004\b,\u0010\u0016\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001e\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"¨\u0006T"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ScheduleResponse;", "", "seen1", "", TtmlNode.ATTR_ID, "monday", "", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "startHour", "startMinute", "finishHour", "finishMinute", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getFinishHour$annotations", "()V", "getFinishHour", "()Ljava/lang/Integer;", "setFinishHour", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFinishMinute$annotations", "getFinishMinute", "setFinishMinute", "getFriday", "()Ljava/lang/Boolean;", "setFriday", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getId", "getMonday", "setMonday", "getSaturday", "setSaturday", "getStartHour$annotations", "getStartHour", "setStartHour", "getStartMinute$annotations", "getStartMinute", "setStartMinute", "getSunday", "setSunday", "getThursday", "setThursday", "getTuesday", "setTuesday", "getWednesday", "setWednesday", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/ScheduleResponse;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ScheduleResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Integer finishHour;
    private Integer finishMinute;
    private Boolean friday;
    private final Integer id;
    private Boolean monday;
    private Boolean saturday;
    private Integer startHour;
    private Integer startMinute;
    private Boolean sunday;
    private Boolean thursday;
    private Boolean tuesday;
    private Boolean wednesday;

    @SerialName("finish_h")
    public static /* synthetic */ void getFinishHour$annotations() {
    }

    @SerialName("finish_m")
    public static /* synthetic */ void getFinishMinute$annotations() {
    }

    @SerialName("start_h")
    public static /* synthetic */ void getStartHour$annotations() {
    }

    @SerialName("start_m")
    public static /* synthetic */ void getStartMinute$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Integer getStartMinute() {
        return this.startMinute;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getFinishHour() {
        return this.finishHour;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getFinishMinute() {
        return this.finishMinute;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getMonday() {
        return this.monday;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getTuesday() {
        return this.tuesday;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getWednesday() {
        return this.wednesday;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getThursday() {
        return this.thursday;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getFriday() {
        return this.friday;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getSaturday() {
        return this.saturday;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getSunday() {
        return this.sunday;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getStartHour() {
        return this.startHour;
    }

    public final ScheduleResponse copy(Integer r15, Boolean monday, Boolean tuesday, Boolean wednesday, Boolean thursday, Boolean friday, Boolean saturday, Boolean sunday, Integer startHour, Integer startMinute, Integer finishHour, Integer finishMinute) {
        return new ScheduleResponse(r15, monday, tuesday, wednesday, thursday, friday, saturday, sunday, startHour, startMinute, finishHour, finishMinute);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduleResponse)) {
            return false;
        }
        ScheduleResponse scheduleResponse = (ScheduleResponse) other;
        return Intrinsics.areEqual(this.id, scheduleResponse.id) && Intrinsics.areEqual(this.monday, scheduleResponse.monday) && Intrinsics.areEqual(this.tuesday, scheduleResponse.tuesday) && Intrinsics.areEqual(this.wednesday, scheduleResponse.wednesday) && Intrinsics.areEqual(this.thursday, scheduleResponse.thursday) && Intrinsics.areEqual(this.friday, scheduleResponse.friday) && Intrinsics.areEqual(this.saturday, scheduleResponse.saturday) && Intrinsics.areEqual(this.sunday, scheduleResponse.sunday) && Intrinsics.areEqual(this.startHour, scheduleResponse.startHour) && Intrinsics.areEqual(this.startMinute, scheduleResponse.startMinute) && Intrinsics.areEqual(this.finishHour, scheduleResponse.finishHour) && Intrinsics.areEqual(this.finishMinute, scheduleResponse.finishMinute);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.monday;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.tuesday;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.wednesday;
        int hashCode4 = (hashCode3 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.thursday;
        int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Boolean bool5 = this.friday;
        int hashCode6 = (hashCode5 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.saturday;
        int hashCode7 = (hashCode6 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Boolean bool7 = this.sunday;
        int hashCode8 = (hashCode7 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Integer num2 = this.startHour;
        int hashCode9 = (hashCode8 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.startMinute;
        int hashCode10 = (hashCode9 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.finishHour;
        int hashCode11 = (hashCode10 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.finishMinute;
        return hashCode11 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        return "ScheduleResponse(id=" + this.id + ", monday=" + this.monday + ", tuesday=" + this.tuesday + ", wednesday=" + this.wednesday + ", thursday=" + this.thursday + ", friday=" + this.friday + ", saturday=" + this.saturday + ", sunday=" + this.sunday + ", startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", finishHour=" + this.finishHour + ", finishMinute=" + this.finishMinute + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ScheduleResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ScheduleResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ScheduleResponse> serializer() {
            return ScheduleResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ScheduleResponse(int i, Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, @SerialName("start_h") Integer num2, @SerialName("start_m") Integer num3, @SerialName("finish_h") Integer num4, @SerialName("finish_m") Integer num5, SerializationConstructorMarker serializationConstructorMarker) {
        if (4095 != (i & UnixStat.PERM_MASK)) {
            PluginExceptionsKt.throwMissingFieldException(i, UnixStat.PERM_MASK, ScheduleResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = num;
        this.monday = bool;
        this.tuesday = bool2;
        this.wednesday = bool3;
        this.thursday = bool4;
        this.friday = bool5;
        this.saturday = bool6;
        this.sunday = bool7;
        this.startHour = num2;
        this.startMinute = num3;
        this.finishHour = num4;
        this.finishMinute = num5;
    }

    public ScheduleResponse(Integer num, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.id = num;
        this.monday = bool;
        this.tuesday = bool2;
        this.wednesday = bool3;
        this.thursday = bool4;
        this.friday = bool5;
        this.saturday = bool6;
        this.sunday = bool7;
        this.startHour = num2;
        this.startMinute = num3;
        this.finishHour = num4;
        this.finishMinute = num5;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ScheduleResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.monday);
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.tuesday);
        output.encodeNullableSerializableElement(serialDesc, 3, BooleanSerializer.INSTANCE, self.wednesday);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.thursday);
        output.encodeNullableSerializableElement(serialDesc, 5, BooleanSerializer.INSTANCE, self.friday);
        output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.saturday);
        output.encodeNullableSerializableElement(serialDesc, 7, BooleanSerializer.INSTANCE, self.sunday);
        output.encodeNullableSerializableElement(serialDesc, 8, IntSerializer.INSTANCE, self.startHour);
        output.encodeNullableSerializableElement(serialDesc, 9, IntSerializer.INSTANCE, self.startMinute);
        output.encodeNullableSerializableElement(serialDesc, 10, IntSerializer.INSTANCE, self.finishHour);
        output.encodeNullableSerializableElement(serialDesc, 11, IntSerializer.INSTANCE, self.finishMinute);
    }

    public final Integer getId() {
        return this.id;
    }

    public final Boolean getMonday() {
        return this.monday;
    }

    public final void setMonday(Boolean bool) {
        this.monday = bool;
    }

    public final Boolean getTuesday() {
        return this.tuesday;
    }

    public final void setTuesday(Boolean bool) {
        this.tuesday = bool;
    }

    public final Boolean getWednesday() {
        return this.wednesday;
    }

    public final void setWednesday(Boolean bool) {
        this.wednesday = bool;
    }

    public final Boolean getThursday() {
        return this.thursday;
    }

    public final void setThursday(Boolean bool) {
        this.thursday = bool;
    }

    public final Boolean getFriday() {
        return this.friday;
    }

    public final void setFriday(Boolean bool) {
        this.friday = bool;
    }

    public final Boolean getSaturday() {
        return this.saturday;
    }

    public final void setSaturday(Boolean bool) {
        this.saturday = bool;
    }

    public final Boolean getSunday() {
        return this.sunday;
    }

    public final void setSunday(Boolean bool) {
        this.sunday = bool;
    }

    public final Integer getStartHour() {
        return this.startHour;
    }

    public final void setStartHour(Integer num) {
        this.startHour = num;
    }

    public final Integer getStartMinute() {
        return this.startMinute;
    }

    public final void setStartMinute(Integer num) {
        this.startMinute = num;
    }

    public final Integer getFinishHour() {
        return this.finishHour;
    }

    public final void setFinishHour(Integer num) {
        this.finishHour = num;
    }

    public final Integer getFinishMinute() {
        return this.finishMinute;
    }

    public final void setFinishMinute(Integer num) {
        this.finishMinute = num;
    }
}
