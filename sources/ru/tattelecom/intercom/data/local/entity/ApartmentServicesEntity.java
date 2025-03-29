package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\fJD\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "", TtmlNode.ATTR_ID, "", LogWriteConstants.BUILDING_ID, NavArg.VerifyCode.APARTMENT_ID, "name", "", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "", "(IIILjava/lang/String;Ljava/lang/Boolean;)V", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getApartmentId", "()I", "getBuildingId", "getId", "getName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "(IIILjava/lang/String;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "equals", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ApartmentServicesEntity {
    private final Boolean active;
    private final int apartmentId;
    private final int buildingId;
    private final int id;
    private final String name;

    public static /* synthetic */ ApartmentServicesEntity copy$default(ApartmentServicesEntity apartmentServicesEntity, int i, int i2, int i3, String str, Boolean bool, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = apartmentServicesEntity.id;
        }
        if ((i4 & 2) != 0) {
            i2 = apartmentServicesEntity.buildingId;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = apartmentServicesEntity.apartmentId;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            str = apartmentServicesEntity.name;
        }
        String str2 = str;
        if ((i4 & 16) != 0) {
            bool = apartmentServicesEntity.active;
        }
        return apartmentServicesEntity.copy(i, i5, i6, str2, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getBuildingId() {
        return this.buildingId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getApartmentId() {
        return this.apartmentId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getActive() {
        return this.active;
    }

    public final ApartmentServicesEntity copy(int id, int buildingId, int apartmentId, String name, Boolean active) {
        return new ApartmentServicesEntity(id, buildingId, apartmentId, name, active);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentServicesEntity)) {
            return false;
        }
        ApartmentServicesEntity apartmentServicesEntity = (ApartmentServicesEntity) other;
        return this.id == apartmentServicesEntity.id && this.buildingId == apartmentServicesEntity.buildingId && this.apartmentId == apartmentServicesEntity.apartmentId && Intrinsics.areEqual(this.name, apartmentServicesEntity.name) && Intrinsics.areEqual(this.active, apartmentServicesEntity.active);
    }

    public int hashCode() {
        int i = ((((this.id * 31) + this.buildingId) * 31) + this.apartmentId) * 31;
        String str = this.name;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.active;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ApartmentServicesEntity(id=" + this.id + ", buildingId=" + this.buildingId + ", apartmentId=" + this.apartmentId + ", name=" + this.name + ", active=" + this.active + ")";
    }

    public ApartmentServicesEntity(int i, int i2, int i3, String str, Boolean bool) {
        this.id = i;
        this.buildingId = i2;
        this.apartmentId = i3;
        this.name = str;
        this.active = bool;
    }

    public final int getId() {
        return this.id;
    }

    public final int getBuildingId() {
        return this.buildingId;
    }

    public final int getApartmentId() {
        return this.apartmentId;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getActive() {
        return this.active;
    }
}
