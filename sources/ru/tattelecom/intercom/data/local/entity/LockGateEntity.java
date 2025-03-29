package ru.tattelecom.intercom.data.local.entity;

import kotlin.Metadata;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/LockGateEntity;", "", "gateId", "", "date", "", "(IJ)V", "getDate", "()J", "getGateId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LockGateEntity {
    private final long date;
    private final int gateId;

    public static /* synthetic */ LockGateEntity copy$default(LockGateEntity lockGateEntity, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = lockGateEntity.gateId;
        }
        if ((i2 & 2) != 0) {
            j = lockGateEntity.date;
        }
        return lockGateEntity.copy(i, j);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGateId() {
        return this.gateId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    public final LockGateEntity copy(int gateId, long date) {
        return new LockGateEntity(gateId, date);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LockGateEntity)) {
            return false;
        }
        LockGateEntity lockGateEntity = (LockGateEntity) other;
        return this.gateId == lockGateEntity.gateId && this.date == lockGateEntity.date;
    }

    public int hashCode() {
        return (this.gateId * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.date);
    }

    public String toString() {
        return "LockGateEntity(gateId=" + this.gateId + ", date=" + this.date + ")";
    }

    public LockGateEntity(int i, long j) {
        this.gateId = i;
        this.date = j;
    }

    public final int getGateId() {
        return this.gateId;
    }

    public final long getDate() {
        return this.date;
    }
}
