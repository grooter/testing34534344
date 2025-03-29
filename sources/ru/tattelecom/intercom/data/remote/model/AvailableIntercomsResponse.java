package ru.tattelecom.intercom.data.remote.model;

import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,BW\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012 \u0010\u0004\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBG\u0012\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J#\u0010\u001a\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0018JP\u0010\u001d\u001a\u00020\u00002\"\b\u0002\u0010\u0004\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÁ\u0001¢\u0006\u0002\b*R+\u0010\u0004\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0019\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006-"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/AvailableIntercomsResponse;", "", "seen1", "", EntitiesKt.ADDRESSES_TABLE, "", "", "", "Lru/tattelecom/intercom/data/remote/model/IntercomResponse;", EntitiesKt.APARTMENTS_TABLE, "Lru/tattelecom/intercom/data/remote/model/ApartmentResponse;", "areMuted", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/List;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Boolean;)V", "getAddresses", "()Ljava/util/Map;", "getApartments", "()Ljava/util/List;", "getAreMuted$annotations", "()V", "getAreMuted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/util/Map;Ljava/util/List;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/remote/model/AvailableIntercomsResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AvailableIntercomsResponse {
    private final Map<String, List<IntercomResponse>> addresses;
    private final List<ApartmentResponse> apartments;
    private final Boolean areMuted;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new LinkedHashMapSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(BuiltinSerializersKt.getNullable(IntercomResponse$$serializer.INSTANCE)))), new ArrayListSerializer(ApartmentResponse$$serializer.INSTANCE), null};

    public AvailableIntercomsResponse() {
        this((Map) null, (List) null, (Boolean) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AvailableIntercomsResponse copy$default(AvailableIntercomsResponse availableIntercomsResponse, Map map, List list, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            map = availableIntercomsResponse.addresses;
        }
        if ((i & 2) != 0) {
            list = availableIntercomsResponse.apartments;
        }
        if ((i & 4) != 0) {
            bool = availableIntercomsResponse.areMuted;
        }
        return availableIntercomsResponse.copy(map, list, bool);
    }

    @SerialName("mute")
    public static /* synthetic */ void getAreMuted$annotations() {
    }

    public final Map<String, List<IntercomResponse>> component1() {
        return this.addresses;
    }

    public final List<ApartmentResponse> component2() {
        return this.apartments;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getAreMuted() {
        return this.areMuted;
    }

    public final AvailableIntercomsResponse copy(Map<String, ? extends List<IntercomResponse>> addresses, List<ApartmentResponse> apartments, Boolean areMuted) {
        return new AvailableIntercomsResponse(addresses, apartments, areMuted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvailableIntercomsResponse)) {
            return false;
        }
        AvailableIntercomsResponse availableIntercomsResponse = (AvailableIntercomsResponse) other;
        return Intrinsics.areEqual(this.addresses, availableIntercomsResponse.addresses) && Intrinsics.areEqual(this.apartments, availableIntercomsResponse.apartments) && Intrinsics.areEqual(this.areMuted, availableIntercomsResponse.areMuted);
    }

    public int hashCode() {
        Map<String, List<IntercomResponse>> map = this.addresses;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        List<ApartmentResponse> list = this.apartments;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.areMuted;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "AvailableIntercomsResponse(addresses=" + this.addresses + ", apartments=" + this.apartments + ", areMuted=" + this.areMuted + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/AvailableIntercomsResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/AvailableIntercomsResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AvailableIntercomsResponse> serializer() {
            return AvailableIntercomsResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AvailableIntercomsResponse(int i, Map map, List list, @SerialName("mute") Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.addresses = null;
        } else {
            this.addresses = map;
        }
        if ((i & 2) == 0) {
            this.apartments = null;
        } else {
            this.apartments = list;
        }
        if ((i & 4) == 0) {
            this.areMuted = null;
        } else {
            this.areMuted = bool;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvailableIntercomsResponse(Map<String, ? extends List<IntercomResponse>> map, List<ApartmentResponse> list, Boolean bool) {
        this.addresses = map;
        this.apartments = list;
        this.areMuted = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AvailableIntercomsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.addresses != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.addresses);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.apartments != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.apartments);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.areMuted == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.areMuted);
    }

    public /* synthetic */ AvailableIntercomsResponse(Map map, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : bool);
    }

    public final Map<String, List<IntercomResponse>> getAddresses() {
        return this.addresses;
    }

    public final List<ApartmentResponse> getApartments() {
        return this.apartments;
    }

    public final Boolean getAreMuted() {
        return this.areMuted;
    }
}
