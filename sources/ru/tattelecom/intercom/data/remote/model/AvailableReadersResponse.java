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
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%BE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012 \u0010\u0006\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J#\u0010\u0015\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\u0007HÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\"\b\u0002\u0010\u0006\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R+\u0010\u0006\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/AvailableReadersResponse;", "", "seen1", "", "success", "", EntitiesKt.ADDRESSES_TABLE, "", "", "", "Lru/tattelecom/intercom/data/remote/model/ReaderResponse;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/util/Map;)V", "getAddresses", "()Ljava/util/Map;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/util/Map;)Lru/tattelecom/intercom/data/remote/model/AvailableReadersResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AvailableReadersResponse {
    private final Map<String, List<ReaderResponse>> addresses;
    private final Boolean success;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new LinkedHashMapSerializer(BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(BuiltinSerializersKt.getNullable(ReaderResponse$$serializer.INSTANCE))))};

    public AvailableReadersResponse() {
        this((Boolean) null, (Map) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AvailableReadersResponse copy$default(AvailableReadersResponse availableReadersResponse, Boolean bool, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = availableReadersResponse.success;
        }
        if ((i & 2) != 0) {
            map = availableReadersResponse.addresses;
        }
        return availableReadersResponse.copy(bool, map);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final Map<String, List<ReaderResponse>> component2() {
        return this.addresses;
    }

    public final AvailableReadersResponse copy(Boolean success, Map<String, ? extends List<ReaderResponse>> addresses) {
        return new AvailableReadersResponse(success, addresses);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvailableReadersResponse)) {
            return false;
        }
        AvailableReadersResponse availableReadersResponse = (AvailableReadersResponse) other;
        return Intrinsics.areEqual(this.success, availableReadersResponse.success) && Intrinsics.areEqual(this.addresses, availableReadersResponse.addresses);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Map<String, List<ReaderResponse>> map = this.addresses;
        return hashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "AvailableReadersResponse(success=" + this.success + ", addresses=" + this.addresses + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/AvailableReadersResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/AvailableReadersResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AvailableReadersResponse> serializer() {
            return AvailableReadersResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AvailableReadersResponse(int i, Boolean bool, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.success = null;
        } else {
            this.success = bool;
        }
        if ((i & 2) == 0) {
            this.addresses = null;
        } else {
            this.addresses = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AvailableReadersResponse(Boolean bool, Map<String, ? extends List<ReaderResponse>> map) {
        this.success = bool;
        this.addresses = map;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AvailableReadersResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.success != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.success);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.addresses == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.addresses);
    }

    public /* synthetic */ AvailableReadersResponse(Boolean bool, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : map);
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final Map<String, List<ReaderResponse>> getAddresses() {
        return this.addresses;
    }
}
