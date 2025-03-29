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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BQ\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fB5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019JH\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0006HÖ\u0001J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÁ\u0001¢\u0006\u0002\b/R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u001a\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u000b\u0010\u0019R\u001c\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u0016¨\u00062"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ApartmentGuestsResponse;", "", "seen1", "", TtmlNode.ATTR_ID, "address", "", "guests", "", "Lru/tattelecom/intercom/data/remote/model/Guest;", "remainingInvites", "isMaster", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/util/List;ILjava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;Ljava/util/List;ILjava/lang/Boolean;)V", "getAddress", "()Ljava/lang/String;", "getGuests", "()Ljava/util/List;", "getId", "()I", "isMaster$annotations", "()V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRemainingInvites$annotations", "getRemainingInvites", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/String;Ljava/util/List;ILjava/lang/Boolean;)Lru/tattelecom/intercom/data/remote/model/ApartmentGuestsResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ApartmentGuestsResponse {
    private final String address;
    private final List<Guest> guests;
    private final int id;
    private final Boolean isMaster;
    private final int remainingInvites;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(Guest$$serializer.INSTANCE), null, null};

    public static /* synthetic */ ApartmentGuestsResponse copy$default(ApartmentGuestsResponse apartmentGuestsResponse, int i, String str, List list, int i2, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = apartmentGuestsResponse.id;
        }
        if ((i3 & 2) != 0) {
            str = apartmentGuestsResponse.address;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            list = apartmentGuestsResponse.guests;
        }
        List list2 = list;
        if ((i3 & 8) != 0) {
            i2 = apartmentGuestsResponse.remainingInvites;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            bool = apartmentGuestsResponse.isMaster;
        }
        return apartmentGuestsResponse.copy(i, str2, list2, i4, bool);
    }

    @SerialName("remaining_invites")
    public static /* synthetic */ void getRemainingInvites$annotations() {
    }

    @SerialName("is_master")
    public static /* synthetic */ void isMaster$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final List<Guest> component3() {
        return this.guests;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRemainingInvites() {
        return this.remainingInvites;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsMaster() {
        return this.isMaster;
    }

    public final ApartmentGuestsResponse copy(int id, String address, List<Guest> guests, int remainingInvites, Boolean isMaster) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(guests, "guests");
        return new ApartmentGuestsResponse(id, address, guests, remainingInvites, isMaster);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentGuestsResponse)) {
            return false;
        }
        ApartmentGuestsResponse apartmentGuestsResponse = (ApartmentGuestsResponse) other;
        return this.id == apartmentGuestsResponse.id && Intrinsics.areEqual(this.address, apartmentGuestsResponse.address) && Intrinsics.areEqual(this.guests, apartmentGuestsResponse.guests) && this.remainingInvites == apartmentGuestsResponse.remainingInvites && Intrinsics.areEqual(this.isMaster, apartmentGuestsResponse.isMaster);
    }

    public int hashCode() {
        int hashCode = ((((((this.id * 31) + this.address.hashCode()) * 31) + this.guests.hashCode()) * 31) + this.remainingInvites) * 31;
        Boolean bool = this.isMaster;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "ApartmentGuestsResponse(id=" + this.id + ", address=" + this.address + ", guests=" + this.guests + ", remainingInvites=" + this.remainingInvites + ", isMaster=" + this.isMaster + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ApartmentGuestsResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ApartmentGuestsResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ApartmentGuestsResponse> serializer() {
            return ApartmentGuestsResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ApartmentGuestsResponse(int i, int i2, String str, List list, @SerialName("remaining_invites") int i3, @SerialName("is_master") Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, ApartmentGuestsResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = i2;
        this.address = str;
        this.guests = list;
        this.remainingInvites = i3;
        this.isMaster = bool;
    }

    public ApartmentGuestsResponse(int i, String address, List<Guest> guests, int i2, Boolean bool) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(guests, "guests");
        this.id = i;
        this.address = address;
        this.guests = guests;
        this.remainingInvites = i2;
        this.isMaster = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ApartmentGuestsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.address);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.guests);
        output.encodeIntElement(serialDesc, 3, self.remainingInvites);
        output.encodeNullableSerializableElement(serialDesc, 4, BooleanSerializer.INSTANCE, self.isMaster);
    }

    public final int getId() {
        return this.id;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<Guest> getGuests() {
        return this.guests;
    }

    public final int getRemainingInvites() {
        return this.remainingInvites;
    }

    public final Boolean isMaster() {
        return this.isMaster;
    }
}
