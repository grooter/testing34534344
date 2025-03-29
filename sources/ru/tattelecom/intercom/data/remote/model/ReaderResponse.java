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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 92\u00020\u0001:\u000289Bk\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBU\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0010J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010!Jb\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010+J\u0013\u0010,\u001a\u00020\f2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001J&\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÁ\u0001¢\u0006\u0002\b7R\u001e\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0018\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0017R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u001f\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\"\u0012\u0004\b \u0010\u0012\u001a\u0004\b\u000b\u0010!¨\u0006:"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ReaderResponse;", "", "seen1", "", TtmlNode.ATTR_ID, "addressId", "gateId", "gateName", "", "gateTypeId", "address", "isFavorite", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAddress$annotations", "()V", "getAddress", "()Ljava/lang/String;", "getAddressId$annotations", "getAddressId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGateId$annotations", "getGateId", "getGateName$annotations", "getGateName", "getGateTypeId$annotations", "getGateTypeId", "getId", "isFavorite$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/remote/model/ReaderResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ReaderResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private final Integer addressId;
    private final Integer gateId;
    private final String gateName;
    private final Integer gateTypeId;
    private final Integer id;
    private final Boolean isFavorite;

    public static /* synthetic */ ReaderResponse copy$default(ReaderResponse readerResponse, Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = readerResponse.id;
        }
        if ((i & 2) != 0) {
            num2 = readerResponse.addressId;
        }
        Integer num5 = num2;
        if ((i & 4) != 0) {
            num3 = readerResponse.gateId;
        }
        Integer num6 = num3;
        if ((i & 8) != 0) {
            str = readerResponse.gateName;
        }
        String str3 = str;
        if ((i & 16) != 0) {
            num4 = readerResponse.gateTypeId;
        }
        Integer num7 = num4;
        if ((i & 32) != 0) {
            str2 = readerResponse.address;
        }
        String str4 = str2;
        if ((i & 64) != 0) {
            bool = readerResponse.isFavorite;
        }
        return readerResponse.copy(num, num5, num6, str3, num7, str4, bool);
    }

    @SerialName("building_address")
    public static /* synthetic */ void getAddress$annotations() {
    }

    @SerialName("building_id")
    public static /* synthetic */ void getAddressId$annotations() {
    }

    @SerialName("gate_id")
    public static /* synthetic */ void getGateId$annotations() {
    }

    @SerialName("gate_name")
    public static /* synthetic */ void getGateName$annotations() {
    }

    @SerialName("gate_type_id")
    public static /* synthetic */ void getGateTypeId$annotations() {
    }

    @SerialName("is_favorite")
    public static /* synthetic */ void isFavorite$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getAddressId() {
        return this.addressId;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getGateId() {
        return this.gateId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGateName() {
        return this.gateName;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final ReaderResponse copy(Integer id, Integer addressId, Integer gateId, String gateName, Integer gateTypeId, String address, Boolean isFavorite) {
        return new ReaderResponse(id, addressId, gateId, gateName, gateTypeId, address, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReaderResponse)) {
            return false;
        }
        ReaderResponse readerResponse = (ReaderResponse) other;
        return Intrinsics.areEqual(this.id, readerResponse.id) && Intrinsics.areEqual(this.addressId, readerResponse.addressId) && Intrinsics.areEqual(this.gateId, readerResponse.gateId) && Intrinsics.areEqual(this.gateName, readerResponse.gateName) && Intrinsics.areEqual(this.gateTypeId, readerResponse.gateTypeId) && Intrinsics.areEqual(this.address, readerResponse.address) && Intrinsics.areEqual(this.isFavorite, readerResponse.isFavorite);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.addressId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.gateId;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str = this.gateName;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num4 = this.gateTypeId;
        int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str2 = this.address;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isFavorite;
        return hashCode6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ReaderResponse(id=" + this.id + ", addressId=" + this.addressId + ", gateId=" + this.gateId + ", gateName=" + this.gateName + ", gateTypeId=" + this.gateTypeId + ", address=" + this.address + ", isFavorite=" + this.isFavorite + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ReaderResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ReaderResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ReaderResponse> serializer() {
            return ReaderResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ReaderResponse(int i, Integer num, @SerialName("building_id") Integer num2, @SerialName("gate_id") Integer num3, @SerialName("gate_name") String str, @SerialName("gate_type_id") Integer num4, @SerialName("building_address") String str2, @SerialName("is_favorite") Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ReaderResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = num;
        this.addressId = num2;
        if ((i & 4) == 0) {
            this.gateId = null;
        } else {
            this.gateId = num3;
        }
        if ((i & 8) == 0) {
            this.gateName = null;
        } else {
            this.gateName = str;
        }
        if ((i & 16) == 0) {
            this.gateTypeId = null;
        } else {
            this.gateTypeId = num4;
        }
        if ((i & 32) == 0) {
            this.address = null;
        } else {
            this.address = str2;
        }
        if ((i & 64) == 0) {
            this.isFavorite = null;
        } else {
            this.isFavorite = bool;
        }
    }

    public ReaderResponse(Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, Boolean bool) {
        this.id = num;
        this.addressId = num2;
        this.gateId = num3;
        this.gateName = str;
        this.gateTypeId = num4;
        this.address = str2;
        this.isFavorite = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ReaderResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.addressId);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.gateId != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.gateId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.gateName != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.gateName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.gateTypeId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.gateTypeId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.address);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 6) && self.isFavorite == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 6, BooleanSerializer.INSTANCE, self.isFavorite);
    }

    public /* synthetic */ ReaderResponse(Integer num, Integer num2, Integer num3, String str, Integer num4, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : num4, (i & 32) != 0 ? null : str2, (i & 64) != 0 ? null : bool);
    }

    public final Integer getId() {
        return this.id;
    }

    public final Integer getAddressId() {
        return this.addressId;
    }

    public final Integer getGateId() {
        return this.gateId;
    }

    public final String getGateName() {
        return this.gateName;
    }

    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }
}
