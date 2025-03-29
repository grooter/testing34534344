package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0002CDB\u0089\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014Bu\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u00101\u001a\u00020\u000bHÆ\u0003J\t\u00102\u001a\u00020\u000bHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\u0098\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u00020\u000b2\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0003HÖ\u0001J\t\u00109\u001a\u00020:HÖ\u0001J&\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020AHÁ\u0001¢\u0006\u0002\bBR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b!\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001b¨\u0006E"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "", "seen1", "", TtmlNode.ATTR_ID, NavArg.INTERCOM_ID, "startHour", "startMinute", "finishHour", "finishMinute", "monday", "", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZZZZZZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZZZZZZ)V", "getFinishHour", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFinishMinute", "getFriday", "()Z", "getId", "()I", "getIntercomId", "getMonday", "getSaturday", "getStartHour", "getStartMinute", "getSunday", "getThursday", "getTuesday", "getWednesday", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZZZZZZ)Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ScheduleEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer finishHour;
    private final Integer finishMinute;
    private final boolean friday;
    private final int id;
    private final int intercomId;
    private final boolean monday;
    private final boolean saturday;
    private final Integer startHour;
    private final Integer startMinute;
    private final boolean sunday;
    private final boolean thursday;
    private final boolean tuesday;
    private final boolean wednesday;

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getThursday() {
        return this.thursday;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getFriday() {
        return this.friday;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getSaturday() {
        return this.saturday;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getSunday() {
        return this.sunday;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIntercomId() {
        return this.intercomId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getStartHour() {
        return this.startHour;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getStartMinute() {
        return this.startMinute;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getFinishHour() {
        return this.finishHour;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getFinishMinute() {
        return this.finishMinute;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getMonday() {
        return this.monday;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getTuesday() {
        return this.tuesday;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getWednesday() {
        return this.wednesday;
    }

    public final ScheduleEntity copy(int id, int intercomId, Integer startHour, Integer startMinute, Integer finishHour, Integer finishMinute, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday) {
        return new ScheduleEntity(id, intercomId, startHour, startMinute, finishHour, finishMinute, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScheduleEntity)) {
            return false;
        }
        ScheduleEntity scheduleEntity = (ScheduleEntity) other;
        return this.id == scheduleEntity.id && this.intercomId == scheduleEntity.intercomId && Intrinsics.areEqual(this.startHour, scheduleEntity.startHour) && Intrinsics.areEqual(this.startMinute, scheduleEntity.startMinute) && Intrinsics.areEqual(this.finishHour, scheduleEntity.finishHour) && Intrinsics.areEqual(this.finishMinute, scheduleEntity.finishMinute) && this.monday == scheduleEntity.monday && this.tuesday == scheduleEntity.tuesday && this.wednesday == scheduleEntity.wednesday && this.thursday == scheduleEntity.thursday && this.friday == scheduleEntity.friday && this.saturday == scheduleEntity.saturday && this.sunday == scheduleEntity.sunday;
    }

    public int hashCode() {
        int i = ((this.id * 31) + this.intercomId) * 31;
        Integer num = this.startHour;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.startMinute;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.finishHour;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.finishMinute;
        return ((((((((((((((hashCode3 + (num4 != null ? num4.hashCode() : 0)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.monday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.tuesday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.wednesday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.thursday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.friday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.saturday)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.sunday);
    }

    public String toString() {
        return "ScheduleEntity(id=" + this.id + ", intercomId=" + this.intercomId + ", startHour=" + this.startHour + ", startMinute=" + this.startMinute + ", finishHour=" + this.finishHour + ", finishMinute=" + this.finishMinute + ", monday=" + this.monday + ", tuesday=" + this.tuesday + ", wednesday=" + this.wednesday + ", thursday=" + this.thursday + ", friday=" + this.friday + ", saturday=" + this.saturday + ", sunday=" + this.sunday + ")";
    }

    /* compiled from: Entities.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/ScheduleEntity$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ScheduleEntity> serializer() {
            return ScheduleEntity$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ScheduleEntity(int i, int i2, int i3, Integer num, Integer num2, Integer num3, Integer num4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, SerializationConstructorMarker serializationConstructorMarker) {
        if (8191 != (i & 8191)) {
            PluginExceptionsKt.throwMissingFieldException(i, 8191, ScheduleEntity$$serializer.INSTANCE.getDescriptor());
        }
        this.id = i2;
        this.intercomId = i3;
        this.startHour = num;
        this.startMinute = num2;
        this.finishHour = num3;
        this.finishMinute = num4;
        this.monday = z;
        this.tuesday = z2;
        this.wednesday = z3;
        this.thursday = z4;
        this.friday = z5;
        this.saturday = z6;
        this.sunday = z7;
    }

    public ScheduleEntity(int i, int i2, Integer num, Integer num2, Integer num3, Integer num4, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.id = i;
        this.intercomId = i2;
        this.startHour = num;
        this.startMinute = num2;
        this.finishHour = num3;
        this.finishMinute = num4;
        this.monday = z;
        this.tuesday = z2;
        this.wednesday = z3;
        this.thursday = z4;
        this.friday = z5;
        this.saturday = z6;
        this.sunday = z7;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ScheduleEntity self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeIntElement(serialDesc, 1, self.intercomId);
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.startHour);
        output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.startMinute);
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.finishHour);
        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.finishMinute);
        output.encodeBooleanElement(serialDesc, 6, self.monday);
        output.encodeBooleanElement(serialDesc, 7, self.tuesday);
        output.encodeBooleanElement(serialDesc, 8, self.wednesday);
        output.encodeBooleanElement(serialDesc, 9, self.thursday);
        output.encodeBooleanElement(serialDesc, 10, self.friday);
        output.encodeBooleanElement(serialDesc, 11, self.saturday);
        output.encodeBooleanElement(serialDesc, 12, self.sunday);
    }

    public final int getId() {
        return this.id;
    }

    public final int getIntercomId() {
        return this.intercomId;
    }

    public final Integer getStartHour() {
        return this.startHour;
    }

    public final Integer getStartMinute() {
        return this.startMinute;
    }

    public final Integer getFinishHour() {
        return this.finishHour;
    }

    public final Integer getFinishMinute() {
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
