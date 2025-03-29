package ru.tattelecom.intercom.data.remote.model.requests;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: LeadRequests.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()BG\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006*"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequest;", "", "seen1", "", "phone", "", "name", "service", "", "data", "Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;)V", "getData", "()Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;", "getName", "()Ljava/lang/String;", "getPhone", "getService", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class LeaveOrderRequest {
    private final LeaveOrderRequestData data;
    private final String name;
    private final String phone;
    private final List<Integer> service;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new ArrayListSerializer(IntSerializer.INSTANCE), null};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LeaveOrderRequest copy$default(LeaveOrderRequest leaveOrderRequest, String str, String str2, List list, LeaveOrderRequestData leaveOrderRequestData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveOrderRequest.phone;
        }
        if ((i & 2) != 0) {
            str2 = leaveOrderRequest.name;
        }
        if ((i & 4) != 0) {
            list = leaveOrderRequest.service;
        }
        if ((i & 8) != 0) {
            leaveOrderRequestData = leaveOrderRequest.data;
        }
        return leaveOrderRequest.copy(str, str2, list, leaveOrderRequestData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Integer> component3() {
        return this.service;
    }

    /* renamed from: component4, reason: from getter */
    public final LeaveOrderRequestData getData() {
        return this.data;
    }

    public final LeaveOrderRequest copy(String phone, String name, List<Integer> service, LeaveOrderRequestData data) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        return new LeaveOrderRequest(phone, name, service, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveOrderRequest)) {
            return false;
        }
        LeaveOrderRequest leaveOrderRequest = (LeaveOrderRequest) other;
        return Intrinsics.areEqual(this.phone, leaveOrderRequest.phone) && Intrinsics.areEqual(this.name, leaveOrderRequest.name) && Intrinsics.areEqual(this.service, leaveOrderRequest.service) && Intrinsics.areEqual(this.data, leaveOrderRequest.data);
    }

    public int hashCode() {
        int hashCode = ((((this.phone.hashCode() * 31) + this.name.hashCode()) * 31) + this.service.hashCode()) * 31;
        LeaveOrderRequestData leaveOrderRequestData = this.data;
        return hashCode + (leaveOrderRequestData == null ? 0 : leaveOrderRequestData.hashCode());
    }

    public String toString() {
        return "LeaveOrderRequest(phone=" + this.phone + ", name=" + this.name + ", service=" + this.service + ", data=" + this.data + ")";
    }

    /* compiled from: LeadRequests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LeaveOrderRequest> serializer() {
            return LeaveOrderRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LeaveOrderRequest(int i, String str, String str2, List list, LeaveOrderRequestData leaveOrderRequestData, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, LeaveOrderRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.phone = str;
        this.name = str2;
        this.service = list;
        this.data = leaveOrderRequestData;
    }

    public LeaveOrderRequest(String phone, String name, List<Integer> service, LeaveOrderRequestData leaveOrderRequestData) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        this.phone = phone;
        this.name = name;
        this.service = service;
        this.data = leaveOrderRequestData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(LeaveOrderRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.phone);
        output.encodeStringElement(serialDesc, 1, self.name);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.service);
        output.encodeNullableSerializableElement(serialDesc, 3, LeaveOrderRequestData$$serializer.INSTANCE, self.data);
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getService() {
        return this.service;
    }

    public final LeaveOrderRequestData getData() {
        return this.data;
    }
}
