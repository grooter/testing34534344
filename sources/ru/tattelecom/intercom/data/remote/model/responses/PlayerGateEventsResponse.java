package ru.tattelecom.intercom.data.remote.model.responses;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: GateResponses.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0003!\"#B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J%\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse;", "", "seen1", "", "success", "", "events", "", "Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse$GateEvent;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLjava/util/List;)V", "getEvents", "()Ljava/util/List;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "GateEvent", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class PlayerGateEventsResponse {
    private final List<GateEvent> events;
    private final boolean success;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(PlayerGateEventsResponse$GateEvent$$serializer.INSTANCE)};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PlayerGateEventsResponse copy$default(PlayerGateEventsResponse playerGateEventsResponse, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = playerGateEventsResponse.success;
        }
        if ((i & 2) != 0) {
            list = playerGateEventsResponse.events;
        }
        return playerGateEventsResponse.copy(z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final List<GateEvent> component2() {
        return this.events;
    }

    public final PlayerGateEventsResponse copy(boolean success, List<GateEvent> events) {
        return new PlayerGateEventsResponse(success, events);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerGateEventsResponse)) {
            return false;
        }
        PlayerGateEventsResponse playerGateEventsResponse = (PlayerGateEventsResponse) other;
        return this.success == playerGateEventsResponse.success && Intrinsics.areEqual(this.events, playerGateEventsResponse.events);
    }

    public int hashCode() {
        int m = AdvThemeDto$$ExternalSyntheticBackport0.m(this.success) * 31;
        List<GateEvent> list = this.events;
        return m + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "PlayerGateEventsResponse(success=" + this.success + ", events=" + this.events + ")";
    }

    /* compiled from: GateResponses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PlayerGateEventsResponse> serializer() {
            return PlayerGateEventsResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PlayerGateEventsResponse(int i, boolean z, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, PlayerGateEventsResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.success = z;
        if ((i & 2) == 0) {
            this.events = null;
        } else {
            this.events = list;
        }
    }

    public PlayerGateEventsResponse(boolean z, List<GateEvent> list) {
        this.success = z;
        this.events = list;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(PlayerGateEventsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeBooleanElement(serialDesc, 0, self.success);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.events == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.events);
    }

    public /* synthetic */ PlayerGateEventsResponse(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : list);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* compiled from: GateResponses.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&B5\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse$GateEvent;", "", "seen1", "", "type", "", CrashHianalyticsData.TIME, "", "duration", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;JJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;JJ)V", "getDuration", "()J", "getTime", "getType$annotations", "()V", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class GateEvent {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long duration;
        private final long time;
        private final String type;

        public static /* synthetic */ GateEvent copy$default(GateEvent gateEvent, String str, long j, long j2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = gateEvent.type;
            }
            if ((i & 2) != 0) {
                j = gateEvent.time;
            }
            long j3 = j;
            if ((i & 4) != 0) {
                j2 = gateEvent.duration;
            }
            return gateEvent.copy(str, j3, j2);
        }

        @SerialName("event_type")
        public static /* synthetic */ void getType$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final String getType() {
            return this.type;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTime() {
            return this.time;
        }

        /* renamed from: component3, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        public final GateEvent copy(String type, long time, long duration) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new GateEvent(type, time, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GateEvent)) {
                return false;
            }
            GateEvent gateEvent = (GateEvent) other;
            return Intrinsics.areEqual(this.type, gateEvent.type) && this.time == gateEvent.time && this.duration == gateEvent.duration;
        }

        public int hashCode() {
            return (((this.type.hashCode() * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.time)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.duration);
        }

        public String toString() {
            return "GateEvent(type=" + this.type + ", time=" + this.time + ", duration=" + this.duration + ")";
        }

        /* compiled from: GateResponses.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse$GateEvent$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse$GateEvent;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<GateEvent> serializer() {
                return PlayerGateEventsResponse$GateEvent$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ GateEvent(int i, @SerialName("event_type") String str, long j, long j2, SerializationConstructorMarker serializationConstructorMarker) {
            if (7 != (i & 7)) {
                PluginExceptionsKt.throwMissingFieldException(i, 7, PlayerGateEventsResponse$GateEvent$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
            this.time = j;
            this.duration = j2;
        }

        public GateEvent(String type, long j, long j2) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
            this.time = j;
            this.duration = j2;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$data_release(GateEvent self, CompositeEncoder output, SerialDescriptor serialDesc) {
            output.encodeStringElement(serialDesc, 0, self.type);
            output.encodeLongElement(serialDesc, 1, self.time);
            output.encodeLongElement(serialDesc, 2, self.duration);
        }

        public final String getType() {
            return this.type;
        }

        public final long getTime() {
            return this.time;
        }

        public final long getDuration() {
            return this.duration;
        }
    }

    public final List<GateEvent> getEvents() {
        return this.events;
    }
}
