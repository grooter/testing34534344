package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289Bq\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011B]\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u0011\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0018Jn\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\u0006HÖ\u0001J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0018R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u0018R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001b¨\u0006:"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ApartmentResponse;", "", "seen1", "", TtmlNode.ATTR_ID, "address", "", "guests", "", "Lru/tattelecom/intercom/data/remote/model/Guest;", "services", "Lru/tattelecom/intercom/data/remote/model/Services;", "remainingInvites", LogWriteConstants.BUILDING_ID, "intercomTemporaryCode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAddress", "()Ljava/lang/String;", "getBuildingId$annotations", "()V", "getBuildingId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGuests", "()Ljava/util/List;", "getId", "getIntercomTemporaryCode$annotations", "getIntercomTemporaryCode", "getRemainingInvites$annotations", "getRemainingInvites", "getServices", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/ApartmentResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ApartmentResponse {
    private final String address;
    private final Integer buildingId;
    private final List<Guest> guests;
    private final Integer id;
    private final Integer intercomTemporaryCode;
    private final Integer remainingInvites;
    private final List<Services> services;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(Guest$$serializer.INSTANCE), new ArrayListSerializer(Services$$serializer.INSTANCE), null, null, null};

    public static /* synthetic */ ApartmentResponse copy$default(ApartmentResponse apartmentResponse, Integer num, String str, List list, List list2, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = apartmentResponse.id;
        }
        if ((i & 2) != 0) {
            str = apartmentResponse.address;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            list = apartmentResponse.guests;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = apartmentResponse.services;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            num2 = apartmentResponse.remainingInvites;
        }
        Integer num5 = num2;
        if ((i & 32) != 0) {
            num3 = apartmentResponse.buildingId;
        }
        Integer num6 = num3;
        if ((i & 64) != 0) {
            num4 = apartmentResponse.intercomTemporaryCode;
        }
        return apartmentResponse.copy(num, str2, list3, list4, num5, num6, num4);
    }

    @SerialName("building_id")
    public static /* synthetic */ void getBuildingId$annotations() {
    }

    @SerialName("door_code")
    public static /* synthetic */ void getIntercomTemporaryCode$annotations() {
    }

    @SerialName("remaining_invites")
    public static /* synthetic */ void getRemainingInvites$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final List<Guest> component3() {
        return this.guests;
    }

    public final List<Services> component4() {
        return this.services;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getRemainingInvites() {
        return this.remainingInvites;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getBuildingId() {
        return this.buildingId;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }

    public final ApartmentResponse copy(Integer id, String address, List<Guest> guests, List<Services> services, Integer remainingInvites, Integer buildingId, Integer intercomTemporaryCode) {
        return new ApartmentResponse(id, address, guests, services, remainingInvites, buildingId, intercomTemporaryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentResponse)) {
            return false;
        }
        ApartmentResponse apartmentResponse = (ApartmentResponse) other;
        return Intrinsics.areEqual(this.id, apartmentResponse.id) && Intrinsics.areEqual(this.address, apartmentResponse.address) && Intrinsics.areEqual(this.guests, apartmentResponse.guests) && Intrinsics.areEqual(this.services, apartmentResponse.services) && Intrinsics.areEqual(this.remainingInvites, apartmentResponse.remainingInvites) && Intrinsics.areEqual(this.buildingId, apartmentResponse.buildingId) && Intrinsics.areEqual(this.intercomTemporaryCode, apartmentResponse.intercomTemporaryCode);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<Guest> list = this.guests;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Services> list2 = this.services;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num2 = this.remainingInvites;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.buildingId;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.intercomTemporaryCode;
        return hashCode6 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "ApartmentResponse(id=" + this.id + ", address=" + this.address + ", guests=" + this.guests + ", services=" + this.services + ", remainingInvites=" + this.remainingInvites + ", buildingId=" + this.buildingId + ", intercomTemporaryCode=" + this.intercomTemporaryCode + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ApartmentResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ApartmentResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ApartmentResponse> serializer() {
            return ApartmentResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ApartmentResponse(int i, Integer num, String str, List list, List list2, @SerialName("remaining_invites") Integer num2, @SerialName("building_id") Integer num3, @SerialName("door_code") Integer num4, SerializationConstructorMarker serializationConstructorMarker) {
        if (51 != (i & 51)) {
            PluginExceptionsKt.throwMissingFieldException(i, 51, ApartmentResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = num;
        this.address = str;
        if ((i & 4) == 0) {
            this.guests = null;
        } else {
            this.guests = list;
        }
        if ((i & 8) == 0) {
            this.services = null;
        } else {
            this.services = list2;
        }
        this.remainingInvites = num2;
        this.buildingId = num3;
        if ((i & 64) == 0) {
            this.intercomTemporaryCode = null;
        } else {
            this.intercomTemporaryCode = num4;
        }
    }

    public ApartmentResponse(Integer num, String str, List<Guest> list, List<Services> list2, Integer num2, Integer num3, Integer num4) {
        this.id = num;
        this.address = str;
        this.guests = list;
        this.services = list2;
        this.remainingInvites = num2;
        this.buildingId = num3;
        this.intercomTemporaryCode = num4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ApartmentResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.address);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.guests != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.guests);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.services != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.services);
        }
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.remainingInvites);
        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.buildingId);
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.intercomTemporaryCode == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, IntSerializer.INSTANCE, self.intercomTemporaryCode);
    }

    public /* synthetic */ ApartmentResponse(Integer num, String str, List list, List list2, Integer num2, Integer num3, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, str, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2, num2, num3, (i & 64) != 0 ? null : num4);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<Guest> getGuests() {
        return this.guests;
    }

    public final List<Services> getServices() {
        return this.services;
    }

    public final Integer getRemainingInvites() {
        return this.remainingInvites;
    }

    public final Integer getBuildingId() {
        return this.buildingId;
    }

    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }
}
