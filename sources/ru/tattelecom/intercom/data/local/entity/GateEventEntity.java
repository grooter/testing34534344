package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: GateEventEntities.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/GateEventEntity;", "", TtmlNode.ATTR_ID, "", "gateId", "", "type", "startDate", "", "duration", "(Ljava/lang/String;ILjava/lang/String;JJ)V", "getDuration", "()J", "getGateId", "()I", "getId", "()Ljava/lang/String;", "getStartDate", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GateEventEntity {
    private final long duration;
    private final int gateId;
    private final String id;
    private final long startDate;
    private final String type;

    public static /* synthetic */ GateEventEntity copy$default(GateEventEntity gateEventEntity, String str, int i, String str2, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gateEventEntity.id;
        }
        if ((i2 & 2) != 0) {
            i = gateEventEntity.gateId;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = gateEventEntity.type;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            j = gateEventEntity.startDate;
        }
        long j3 = j;
        if ((i2 & 16) != 0) {
            j2 = gateEventEntity.duration;
        }
        return gateEventEntity.copy(str, i3, str3, j3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGateId() {
        return this.gateId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final long getStartDate() {
        return this.startDate;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final GateEventEntity copy(String id, int gateId, String type, long startDate, long duration) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        return new GateEventEntity(id, gateId, type, startDate, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GateEventEntity)) {
            return false;
        }
        GateEventEntity gateEventEntity = (GateEventEntity) other;
        return Intrinsics.areEqual(this.id, gateEventEntity.id) && this.gateId == gateEventEntity.gateId && Intrinsics.areEqual(this.type, gateEventEntity.type) && this.startDate == gateEventEntity.startDate && this.duration == gateEventEntity.duration;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.gateId) * 31) + this.type.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.startDate)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.duration);
    }

    public String toString() {
        return "GateEventEntity(id=" + this.id + ", gateId=" + this.gateId + ", type=" + this.type + ", startDate=" + this.startDate + ", duration=" + this.duration + ")";
    }

    public GateEventEntity(String id, int i, String type, long j, long j2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.gateId = i;
        this.type = type;
        this.startDate = j;
        this.duration = j2;
    }

    public final String getId() {
        return this.id;
    }

    public final int getGateId() {
        return this.gateId;
    }

    public final String getType() {
        return this.type;
    }

    public final long getStartDate() {
        return this.startDate;
    }

    public final long getDuration() {
        return this.duration;
    }
}
