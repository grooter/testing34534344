package ru.tattelecom.intercom.data.remote.model.requests;

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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: LeadRequests.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ&\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;", "", "seen1", "", "entityScreen", "", NavArg.ENTITY_ID, "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Long;)V", "getEntityId$annotations", "()V", "getEntityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEntityScreen$annotations", "getEntityScreen", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Long;)Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class LeaveOrderRequestData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long entityId;
    private final String entityScreen;

    public static /* synthetic */ LeaveOrderRequestData copy$default(LeaveOrderRequestData leaveOrderRequestData, String str, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            str = leaveOrderRequestData.entityScreen;
        }
        if ((i & 2) != 0) {
            l = leaveOrderRequestData.entityId;
        }
        return leaveOrderRequestData.copy(str, l);
    }

    @SerialName("entity_id")
    public static /* synthetic */ void getEntityId$annotations() {
    }

    @SerialName("entity_screen")
    public static /* synthetic */ void getEntityScreen$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getEntityScreen() {
        return this.entityScreen;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getEntityId() {
        return this.entityId;
    }

    public final LeaveOrderRequestData copy(String entityScreen, Long entityId) {
        return new LeaveOrderRequestData(entityScreen, entityId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LeaveOrderRequestData)) {
            return false;
        }
        LeaveOrderRequestData leaveOrderRequestData = (LeaveOrderRequestData) other;
        return Intrinsics.areEqual(this.entityScreen, leaveOrderRequestData.entityScreen) && Intrinsics.areEqual(this.entityId, leaveOrderRequestData.entityId);
    }

    public int hashCode() {
        String str = this.entityScreen;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.entityId;
        return hashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "LeaveOrderRequestData(entityScreen=" + this.entityScreen + ", entityId=" + this.entityId + ")";
    }

    /* compiled from: LeadRequests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/requests/LeaveOrderRequestData;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LeaveOrderRequestData> serializer() {
            return LeaveOrderRequestData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LeaveOrderRequestData(int i, @SerialName("entity_screen") String str, @SerialName("entity_id") Long l, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, LeaveOrderRequestData$$serializer.INSTANCE.getDescriptor());
        }
        this.entityScreen = str;
        this.entityId = l;
    }

    public LeaveOrderRequestData(String str, Long l) {
        this.entityScreen = str;
        this.entityId = l;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(LeaveOrderRequestData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.entityScreen);
        output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.entityId);
    }

    public final String getEntityScreen() {
        return this.entityScreen;
    }

    public final Long getEntityId() {
        return this.entityId;
    }
}
