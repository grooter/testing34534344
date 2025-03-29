package ru.tattelecom.intercom.data.remote.model;

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

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J&\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0012\u0012\u0004\b\u0010\u0010\f\u001a\u0004\b\u0005\u0010\u0011¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/FavoriteGateRequest;", "", "seen1", "", "gateId", "isFavorite", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getGateId$annotations", "()V", "getGateId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "isFavorite$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/remote/model/FavoriteGateRequest;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class FavoriteGateRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer gateId;
    private final Boolean isFavorite;

    public static /* synthetic */ FavoriteGateRequest copy$default(FavoriteGateRequest favoriteGateRequest, Integer num, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            num = favoriteGateRequest.gateId;
        }
        if ((i & 2) != 0) {
            bool = favoriteGateRequest.isFavorite;
        }
        return favoriteGateRequest.copy(num, bool);
    }

    @SerialName("gate_id")
    public static /* synthetic */ void getGateId$annotations() {
    }

    @SerialName("is_favorite")
    public static /* synthetic */ void isFavorite$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getGateId() {
        return this.gateId;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final FavoriteGateRequest copy(Integer gateId, Boolean isFavorite) {
        return new FavoriteGateRequest(gateId, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FavoriteGateRequest)) {
            return false;
        }
        FavoriteGateRequest favoriteGateRequest = (FavoriteGateRequest) other;
        return Intrinsics.areEqual(this.gateId, favoriteGateRequest.gateId) && Intrinsics.areEqual(this.isFavorite, favoriteGateRequest.isFavorite);
    }

    public int hashCode() {
        Integer num = this.gateId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.isFavorite;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "FavoriteGateRequest(gateId=" + this.gateId + ", isFavorite=" + this.isFavorite + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/FavoriteGateRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/FavoriteGateRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FavoriteGateRequest> serializer() {
            return FavoriteGateRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ FavoriteGateRequest(int i, @SerialName("gate_id") Integer num, @SerialName("is_favorite") Boolean bool, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, FavoriteGateRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.gateId = num;
        this.isFavorite = bool;
    }

    public FavoriteGateRequest(Integer num, Boolean bool) {
        this.gateId = num;
        this.isFavorite = bool;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(FavoriteGateRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.gateId);
        output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isFavorite);
    }

    public final Integer getGateId() {
        return this.gateId;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }
}
