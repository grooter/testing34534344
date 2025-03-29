package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJZ\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\u000fR\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000f¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "", TtmlNode.ATTR_ID, "", LogWriteConstants.BUILDING_ID, "address", "", "guestPhones", "", "remainingInvites", "intercomTemporaryCode", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAddress", "()Ljava/lang/String;", "getBuildingId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGuestPhones", "()Ljava/util/List;", "setGuestPhones", "(Ljava/util/List;)V", "getId", "()I", "getIntercomTemporaryCode", "getRemainingInvites", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "equals", "", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ApartmentEntity {
    private final String address;
    private final Integer buildingId;
    private List<String> guestPhones;
    private final int id;
    private final Integer intercomTemporaryCode;
    private final Integer remainingInvites;

    public static /* synthetic */ ApartmentEntity copy$default(ApartmentEntity apartmentEntity, int i, Integer num, String str, List list, Integer num2, Integer num3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = apartmentEntity.id;
        }
        if ((i2 & 2) != 0) {
            num = apartmentEntity.buildingId;
        }
        Integer num4 = num;
        if ((i2 & 4) != 0) {
            str = apartmentEntity.address;
        }
        String str2 = str;
        if ((i2 & 8) != 0) {
            list = apartmentEntity.guestPhones;
        }
        List list2 = list;
        if ((i2 & 16) != 0) {
            num2 = apartmentEntity.remainingInvites;
        }
        Integer num5 = num2;
        if ((i2 & 32) != 0) {
            num3 = apartmentEntity.intercomTemporaryCode;
        }
        return apartmentEntity.copy(i, num4, str2, list2, num5, num3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getBuildingId() {
        return this.buildingId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final List<String> component4() {
        return this.guestPhones;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getRemainingInvites() {
        return this.remainingInvites;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }

    public final ApartmentEntity copy(int id, Integer buildingId, String address, List<String> guestPhones, Integer remainingInvites, Integer intercomTemporaryCode) {
        return new ApartmentEntity(id, buildingId, address, guestPhones, remainingInvites, intercomTemporaryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentEntity)) {
            return false;
        }
        ApartmentEntity apartmentEntity = (ApartmentEntity) other;
        return this.id == apartmentEntity.id && Intrinsics.areEqual(this.buildingId, apartmentEntity.buildingId) && Intrinsics.areEqual(this.address, apartmentEntity.address) && Intrinsics.areEqual(this.guestPhones, apartmentEntity.guestPhones) && Intrinsics.areEqual(this.remainingInvites, apartmentEntity.remainingInvites) && Intrinsics.areEqual(this.intercomTemporaryCode, apartmentEntity.intercomTemporaryCode);
    }

    public int hashCode() {
        int i = this.id * 31;
        Integer num = this.buildingId;
        int hashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.address;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<String> list = this.guestPhones;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.remainingInvites;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.intercomTemporaryCode;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "ApartmentEntity(id=" + this.id + ", buildingId=" + this.buildingId + ", address=" + this.address + ", guestPhones=" + this.guestPhones + ", remainingInvites=" + this.remainingInvites + ", intercomTemporaryCode=" + this.intercomTemporaryCode + ")";
    }

    public ApartmentEntity(int i, Integer num, String str, List<String> list, Integer num2, Integer num3) {
        this.id = i;
        this.buildingId = num;
        this.address = str;
        this.guestPhones = list;
        this.remainingInvites = num2;
        this.intercomTemporaryCode = num3;
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getBuildingId() {
        return this.buildingId;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<String> getGuestPhones() {
        return this.guestPhones;
    }

    public final void setGuestPhones(List<String> list) {
        this.guestPhones = list;
    }

    public final Integer getRemainingInvites() {
        return this.remainingInvites;
    }

    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }
}
