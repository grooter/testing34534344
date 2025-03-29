package ru.tattelecom.intercom.data.remote.model;

import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB;\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J?\u0010\u0016\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/EventHistoryResponse;", "", "seen1", "", "data", "", "Lru/tattelecom/intercom/data/remote/model/AllRemote;", EntitiesKt.CALLS_TABLE, "Lru/tattelecom/intercom/data/remote/model/CallRemote;", "passes", "Lru/tattelecom/intercom/data/remote/model/PassRemote;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCalls", "()Ljava/util/List;", "getData", "getPasses", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class EventHistoryResponse {
    private final List<CallRemote> calls;
    private final List<AllRemote> data;
    private final List<PassRemote> passes;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(AllRemote$$serializer.INSTANCE), new ArrayListSerializer(CallRemote$$serializer.INSTANCE), new ArrayListSerializer(PassRemote$$serializer.INSTANCE)};

    public EventHistoryResponse() {
        this((List) null, (List) null, (List) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventHistoryResponse copy$default(EventHistoryResponse eventHistoryResponse, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = eventHistoryResponse.data;
        }
        if ((i & 2) != 0) {
            list2 = eventHistoryResponse.calls;
        }
        if ((i & 4) != 0) {
            list3 = eventHistoryResponse.passes;
        }
        return eventHistoryResponse.copy(list, list2, list3);
    }

    public final List<AllRemote> component1() {
        return this.data;
    }

    public final List<CallRemote> component2() {
        return this.calls;
    }

    public final List<PassRemote> component3() {
        return this.passes;
    }

    public final EventHistoryResponse copy(List<AllRemote> data, List<CallRemote> calls, List<PassRemote> passes) {
        return new EventHistoryResponse(data, calls, passes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventHistoryResponse)) {
            return false;
        }
        EventHistoryResponse eventHistoryResponse = (EventHistoryResponse) other;
        return Intrinsics.areEqual(this.data, eventHistoryResponse.data) && Intrinsics.areEqual(this.calls, eventHistoryResponse.calls) && Intrinsics.areEqual(this.passes, eventHistoryResponse.passes);
    }

    public int hashCode() {
        List<AllRemote> list = this.data;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<CallRemote> list2 = this.calls;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<PassRemote> list3 = this.passes;
        return hashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "EventHistoryResponse(data=" + this.data + ", calls=" + this.calls + ", passes=" + this.passes + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/EventHistoryResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/EventHistoryResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<EventHistoryResponse> serializer() {
            return EventHistoryResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ EventHistoryResponse(int i, List list, List list2, List list3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.data = null;
        } else {
            this.data = list;
        }
        if ((i & 2) == 0) {
            this.calls = null;
        } else {
            this.calls = list2;
        }
        if ((i & 4) == 0) {
            this.passes = null;
        } else {
            this.passes = list3;
        }
    }

    public EventHistoryResponse(List<AllRemote> list, List<CallRemote> list2, List<PassRemote> list3) {
        this.data = list;
        this.calls = list2;
        this.passes = list3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(EventHistoryResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, kSerializerArr[0], self.data);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.calls != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.calls);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.passes == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, kSerializerArr[2], self.passes);
    }

    public /* synthetic */ EventHistoryResponse(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : list2, (i & 4) != 0 ? null : list3);
    }

    public final List<AllRemote> getData() {
        return this.data;
    }

    public final List<CallRemote> getCalls() {
        return this.calls;
    }

    public final List<PassRemote> getPasses() {
        return this.passes;
    }
}
