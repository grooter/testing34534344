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
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+BC\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB/\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0013\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0003J:\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0006HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/BuildingResponse;", "", "seen1", "", TtmlNode.ATTR_ID, "address", "", EntitiesKt.STREAM_TABLE, "", "Lru/tattelecom/intercom/data/remote/model/StreamResponse;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)V", "getAddress$annotations", "()V", "getAddress", "()Ljava/lang/String;", "getId$annotations", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStreams", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;)Lru/tattelecom/intercom/data/remote/model/BuildingResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class BuildingResponse {
    private final String address;
    private final Integer id;
    private final List<StreamResponse> streams;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(BuiltinSerializersKt.getNullable(StreamResponse$$serializer.INSTANCE))};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BuildingResponse copy$default(BuildingResponse buildingResponse, Integer num, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = buildingResponse.id;
        }
        if ((i & 2) != 0) {
            str = buildingResponse.address;
        }
        if ((i & 4) != 0) {
            list = buildingResponse.streams;
        }
        return buildingResponse.copy(num, str, list);
    }

    @SerialName("building_address")
    public static /* synthetic */ void getAddress$annotations() {
    }

    @SerialName("building_id")
    public static /* synthetic */ void getId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final List<StreamResponse> component3() {
        return this.streams;
    }

    public final BuildingResponse copy(Integer id, String address, List<StreamResponse> streams) {
        return new BuildingResponse(id, address, streams);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BuildingResponse)) {
            return false;
        }
        BuildingResponse buildingResponse = (BuildingResponse) other;
        return Intrinsics.areEqual(this.id, buildingResponse.id) && Intrinsics.areEqual(this.address, buildingResponse.address) && Intrinsics.areEqual(this.streams, buildingResponse.streams);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<StreamResponse> list = this.streams;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "BuildingResponse(id=" + this.id + ", address=" + this.address + ", streams=" + this.streams + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/BuildingResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/BuildingResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BuildingResponse> serializer() {
            return BuildingResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BuildingResponse(int i, @SerialName("building_id") Integer num, @SerialName("building_address") String str, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, BuildingResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = num;
        if ((i & 2) == 0) {
            this.address = null;
        } else {
            this.address = str;
        }
        if ((i & 4) == 0) {
            this.streams = null;
        } else {
            this.streams = list;
        }
    }

    public BuildingResponse(Integer num, String str, List<StreamResponse> list) {
        this.id = num;
        this.address = str;
        this.streams = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(BuildingResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.address);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.streams == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.streams);
    }

    public /* synthetic */ BuildingResponse(Integer num, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<StreamResponse> getStreams() {
        return this.streams;
    }
}
