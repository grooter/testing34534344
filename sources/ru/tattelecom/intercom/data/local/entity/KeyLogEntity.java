package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/KeyLogEntity;", "", TtmlNode.ATTR_ID, "", NavArg.INTERCOM_ID, "", NavArg.VerifyCode.APARTMENT_ID, CrashHianalyticsData.TIME, "", "snapshot", "(Ljava/lang/String;IIJLjava/lang/String;)V", "getApartmentId", "()I", "getId", "()Ljava/lang/String;", "getIntercomId", "getSnapshot", "getTime", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KeyLogEntity {
    private final int apartmentId;
    private final String id;
    private final int intercomId;
    private final String snapshot;
    private final long time;

    public static /* synthetic */ KeyLogEntity copy$default(KeyLogEntity keyLogEntity, String str, int i, int i2, long j, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = keyLogEntity.id;
        }
        if ((i3 & 2) != 0) {
            i = keyLogEntity.intercomId;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = keyLogEntity.apartmentId;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            j = keyLogEntity.time;
        }
        long j2 = j;
        if ((i3 & 16) != 0) {
            str2 = keyLogEntity.snapshot;
        }
        return keyLogEntity.copy(str, i4, i5, j2, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIntercomId() {
        return this.intercomId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getApartmentId() {
        return this.apartmentId;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSnapshot() {
        return this.snapshot;
    }

    public final KeyLogEntity copy(String id, int intercomId, int apartmentId, long time, String snapshot) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return new KeyLogEntity(id, intercomId, apartmentId, time, snapshot);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KeyLogEntity)) {
            return false;
        }
        KeyLogEntity keyLogEntity = (KeyLogEntity) other;
        return Intrinsics.areEqual(this.id, keyLogEntity.id) && this.intercomId == keyLogEntity.intercomId && this.apartmentId == keyLogEntity.apartmentId && this.time == keyLogEntity.time && Intrinsics.areEqual(this.snapshot, keyLogEntity.snapshot);
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.intercomId) * 31) + this.apartmentId) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.time)) * 31) + this.snapshot.hashCode();
    }

    public String toString() {
        return "KeyLogEntity(id=" + this.id + ", intercomId=" + this.intercomId + ", apartmentId=" + this.apartmentId + ", time=" + this.time + ", snapshot=" + this.snapshot + ")";
    }

    public KeyLogEntity(String id, int i, int i2, long j, String snapshot) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.id = id;
        this.intercomId = i;
        this.apartmentId = i2;
        this.time = j;
        this.snapshot = snapshot;
    }

    public final String getId() {
        return this.id;
    }

    public final int getIntercomId() {
        return this.intercomId;
    }

    public final int getApartmentId() {
        return this.apartmentId;
    }

    public final long getTime() {
        return this.time;
    }

    public final String getSnapshot() {
        return this.snapshot;
    }
}
