package ru.tattelecom.intercom.domain.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: GateDtos.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/domain/model/GateEventDto;", "", TtmlNode.ATTR_ID, "", "gateId", "", "type", "startDate", "Ljava/util/Date;", "duration", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Date;J)V", "getDuration", "()J", "getGateId", "()I", "getId", "()Ljava/lang/String;", "getStartDate", "()Ljava/util/Date;", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GateEventDto {
    private final long duration;
    private final int gateId;
    private final String id;
    private final Date startDate;
    private final String type;

    public static /* synthetic */ GateEventDto copy$default(GateEventDto gateEventDto, String str, int i, String str2, Date date, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = gateEventDto.id;
        }
        if ((i2 & 2) != 0) {
            i = gateEventDto.gateId;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = gateEventDto.type;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            date = gateEventDto.startDate;
        }
        Date date2 = date;
        if ((i2 & 16) != 0) {
            j = gateEventDto.duration;
        }
        return gateEventDto.copy(str, i3, str3, date2, j);
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
    public final Date getStartDate() {
        return this.startDate;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    public final GateEventDto copy(String id, int gateId, String type, Date startDate, long duration) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        return new GateEventDto(id, gateId, type, startDate, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GateEventDto)) {
            return false;
        }
        GateEventDto gateEventDto = (GateEventDto) other;
        return Intrinsics.areEqual(this.id, gateEventDto.id) && this.gateId == gateEventDto.gateId && Intrinsics.areEqual(this.type, gateEventDto.type) && Intrinsics.areEqual(this.startDate, gateEventDto.startDate) && this.duration == gateEventDto.duration;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.gateId) * 31) + this.type.hashCode()) * 31) + this.startDate.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.duration);
    }

    public String toString() {
        return "GateEventDto(id=" + this.id + ", gateId=" + this.gateId + ", type=" + this.type + ", startDate=" + this.startDate + ", duration=" + this.duration + ")";
    }

    public GateEventDto(String id, int i, String type, Date startDate, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        this.id = id;
        this.gateId = i;
        this.type = type;
        this.startDate = startDate;
        this.duration = j;
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

    public final Date getStartDate() {
        return this.startDate;
    }

    public final long getDuration() {
        return this.duration;
    }
}
