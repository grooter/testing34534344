package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 G2\u00020\u0001:\u0002FGB\u0087\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015B}\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\n¢\u0006\u0002\u0010\u0016J\u0010\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nHÆ\u0003J\u0088\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0003HÖ\u0001J\t\u0010=\u001a\u00020\u0006HÖ\u0001J&\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DHÁ\u0001¢\u0006\u0002\bER\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u001b\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR&\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R&\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010#\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'¨\u0006H"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "", "seen1", "", TtmlNode.ATTR_ID, "address", "", "latlong", "Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;", "services", "", "Lru/tattelecom/intercom/data/remote/model/OfficeServices;", "workWeekday", "Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;", "workSaturday", "workSunday", "name", "contacts", "Lru/tattelecom/intercom/data/remote/model/OfficeContacts;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;Ljava/util/List;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;Ljava/util/List;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Ljava/lang/String;Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "getContacts", "()Ljava/util/List;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLatlong", "()Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;", "getName", "getServices", "getWorkSaturday$annotations", "()V", "getWorkSaturday", "()Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;", "setWorkSaturday", "(Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;)V", "getWorkSunday$annotations", "getWorkSunday", "setWorkSunday", "getWorkWeekday$annotations", "getWorkWeekday", "setWorkWeekday", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;Ljava/util/List;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;Ljava/lang/String;Ljava/util/List;)Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class OfficeResponse {
    private final String address;
    private final List<OfficeContacts> contacts;
    private final Integer id;
    private final OfficeLatlong latlong;
    private final String name;
    private final List<OfficeServices> services;
    private OfficeSchedule workSaturday;
    private OfficeSchedule workSunday;
    private OfficeSchedule workWeekday;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, null, new ArrayListSerializer(BuiltinSerializersKt.getNullable(OfficeServices$$serializer.INSTANCE)), null, null, null, null, new ArrayListSerializer(OfficeContacts$$serializer.INSTANCE)};

    @SerialName("work_saturday")
    public static /* synthetic */ void getWorkSaturday$annotations() {
    }

    @SerialName("work_sunday")
    public static /* synthetic */ void getWorkSunday$annotations() {
    }

    @SerialName("work_weekday")
    public static /* synthetic */ void getWorkWeekday$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component3, reason: from getter */
    public final OfficeLatlong getLatlong() {
        return this.latlong;
    }

    public final List<OfficeServices> component4() {
        return this.services;
    }

    /* renamed from: component5, reason: from getter */
    public final OfficeSchedule getWorkWeekday() {
        return this.workWeekday;
    }

    /* renamed from: component6, reason: from getter */
    public final OfficeSchedule getWorkSaturday() {
        return this.workSaturday;
    }

    /* renamed from: component7, reason: from getter */
    public final OfficeSchedule getWorkSunday() {
        return this.workSunday;
    }

    /* renamed from: component8, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<OfficeContacts> component9() {
        return this.contacts;
    }

    public final OfficeResponse copy(Integer id, String address, OfficeLatlong latlong, List<OfficeServices> services, OfficeSchedule workWeekday, OfficeSchedule workSaturday, OfficeSchedule workSunday, String name, List<OfficeContacts> contacts) {
        return new OfficeResponse(id, address, latlong, services, workWeekday, workSaturday, workSunday, name, contacts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficeResponse)) {
            return false;
        }
        OfficeResponse officeResponse = (OfficeResponse) other;
        return Intrinsics.areEqual(this.id, officeResponse.id) && Intrinsics.areEqual(this.address, officeResponse.address) && Intrinsics.areEqual(this.latlong, officeResponse.latlong) && Intrinsics.areEqual(this.services, officeResponse.services) && Intrinsics.areEqual(this.workWeekday, officeResponse.workWeekday) && Intrinsics.areEqual(this.workSaturday, officeResponse.workSaturday) && Intrinsics.areEqual(this.workSunday, officeResponse.workSunday) && Intrinsics.areEqual(this.name, officeResponse.name) && Intrinsics.areEqual(this.contacts, officeResponse.contacts);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        OfficeLatlong officeLatlong = this.latlong;
        int hashCode3 = (hashCode2 + (officeLatlong == null ? 0 : officeLatlong.hashCode())) * 31;
        List<OfficeServices> list = this.services;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        OfficeSchedule officeSchedule = this.workWeekday;
        int hashCode5 = (hashCode4 + (officeSchedule == null ? 0 : officeSchedule.hashCode())) * 31;
        OfficeSchedule officeSchedule2 = this.workSaturday;
        int hashCode6 = (hashCode5 + (officeSchedule2 == null ? 0 : officeSchedule2.hashCode())) * 31;
        OfficeSchedule officeSchedule3 = this.workSunday;
        int hashCode7 = (hashCode6 + (officeSchedule3 == null ? 0 : officeSchedule3.hashCode())) * 31;
        String str2 = this.name;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<OfficeContacts> list2 = this.contacts;
        return hashCode8 + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        return "OfficeResponse(id=" + this.id + ", address=" + this.address + ", latlong=" + this.latlong + ", services=" + this.services + ", workWeekday=" + this.workWeekday + ", workSaturday=" + this.workSaturday + ", workSunday=" + this.workSunday + ", name=" + this.name + ", contacts=" + this.contacts + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/OfficeResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OfficeResponse> serializer() {
            return OfficeResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ OfficeResponse(int i, Integer num, String str, OfficeLatlong officeLatlong, List list, @SerialName("work_weekday") OfficeSchedule officeSchedule, @SerialName("work_saturday") OfficeSchedule officeSchedule2, @SerialName("work_sunday") OfficeSchedule officeSchedule3, String str2, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, OfficeResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = num;
        if ((i & 2) == 0) {
            this.address = null;
        } else {
            this.address = str;
        }
        if ((i & 4) == 0) {
            this.latlong = null;
        } else {
            this.latlong = officeLatlong;
        }
        if ((i & 8) == 0) {
            this.services = null;
        } else {
            this.services = list;
        }
        if ((i & 16) == 0) {
            this.workWeekday = null;
        } else {
            this.workWeekday = officeSchedule;
        }
        if ((i & 32) == 0) {
            this.workSaturday = null;
        } else {
            this.workSaturday = officeSchedule2;
        }
        if ((i & 64) == 0) {
            this.workSunday = null;
        } else {
            this.workSunday = officeSchedule3;
        }
        if ((i & 128) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        if ((i & 256) == 0) {
            this.contacts = null;
        } else {
            this.contacts = list2;
        }
    }

    public OfficeResponse(Integer num, String str, OfficeLatlong officeLatlong, List<OfficeServices> list, OfficeSchedule officeSchedule, OfficeSchedule officeSchedule2, OfficeSchedule officeSchedule3, String str2, List<OfficeContacts> list2) {
        this.id = num;
        this.address = str;
        this.latlong = officeLatlong;
        this.services = list;
        this.workWeekday = officeSchedule;
        this.workSaturday = officeSchedule2;
        this.workSunday = officeSchedule3;
        this.name = str2;
        this.contacts = list2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(OfficeResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.address);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.latlong != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, OfficeLatlong$$serializer.INSTANCE, self.latlong);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.services != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.services);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.workWeekday != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, OfficeSchedule$$serializer.INSTANCE, self.workWeekday);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.workSaturday != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, OfficeSchedule$$serializer.INSTANCE, self.workSaturday);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.workSunday != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, OfficeSchedule$$serializer.INSTANCE, self.workSunday);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, StringSerializer.INSTANCE, self.name);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 8) && self.contacts == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 8, kSerializerArr[8], self.contacts);
    }

    public /* synthetic */ OfficeResponse(Integer num, String str, OfficeLatlong officeLatlong, List list, OfficeSchedule officeSchedule, OfficeSchedule officeSchedule2, OfficeSchedule officeSchedule3, String str2, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : officeLatlong, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : officeSchedule, (i & 32) != 0 ? null : officeSchedule2, (i & 64) != 0 ? null : officeSchedule3, (i & 128) != 0 ? null : str2, (i & 256) == 0 ? list2 : null);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getAddress() {
        return this.address;
    }

    public final OfficeLatlong getLatlong() {
        return this.latlong;
    }

    public final List<OfficeServices> getServices() {
        return this.services;
    }

    public final OfficeSchedule getWorkWeekday() {
        return this.workWeekday;
    }

    public final void setWorkWeekday(OfficeSchedule officeSchedule) {
        this.workWeekday = officeSchedule;
    }

    public final OfficeSchedule getWorkSaturday() {
        return this.workSaturday;
    }

    public final void setWorkSaturday(OfficeSchedule officeSchedule) {
        this.workSaturday = officeSchedule;
    }

    public final OfficeSchedule getWorkSunday() {
        return this.workSunday;
    }

    public final void setWorkSunday(OfficeSchedule officeSchedule) {
        this.workSunday = officeSchedule;
    }

    public final String getName() {
        return this.name;
    }

    public final List<OfficeContacts> getContacts() {
        return this.contacts;
    }
}
