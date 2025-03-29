package ru.tattelecom.intercom.data.local.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ0\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;", "", NavArg.VerifyCode.APARTMENT_ID, "", "address", "", "temporaryCode", "(ILjava/lang/String;Ljava/lang/Integer;)V", "getAddress", "()Ljava/lang/String;", "getApartmentId", "()I", "getTemporaryCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;", "equals", "", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ApartmentTemporaryCodeEntity {
    private final String address;
    private final int apartmentId;
    private final Integer temporaryCode;

    public static /* synthetic */ ApartmentTemporaryCodeEntity copy$default(ApartmentTemporaryCodeEntity apartmentTemporaryCodeEntity, int i, String str, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = apartmentTemporaryCodeEntity.apartmentId;
        }
        if ((i2 & 2) != 0) {
            str = apartmentTemporaryCodeEntity.address;
        }
        if ((i2 & 4) != 0) {
            num = apartmentTemporaryCodeEntity.temporaryCode;
        }
        return apartmentTemporaryCodeEntity.copy(i, str, num);
    }

    /* renamed from: component1, reason: from getter */
    public final int getApartmentId() {
        return this.apartmentId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getTemporaryCode() {
        return this.temporaryCode;
    }

    public final ApartmentTemporaryCodeEntity copy(int apartmentId, String address, Integer temporaryCode) {
        return new ApartmentTemporaryCodeEntity(apartmentId, address, temporaryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentTemporaryCodeEntity)) {
            return false;
        }
        ApartmentTemporaryCodeEntity apartmentTemporaryCodeEntity = (ApartmentTemporaryCodeEntity) other;
        return this.apartmentId == apartmentTemporaryCodeEntity.apartmentId && Intrinsics.areEqual(this.address, apartmentTemporaryCodeEntity.address) && Intrinsics.areEqual(this.temporaryCode, apartmentTemporaryCodeEntity.temporaryCode);
    }

    public int hashCode() {
        int i = this.apartmentId * 31;
        String str = this.address;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.temporaryCode;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ApartmentTemporaryCodeEntity(apartmentId=" + this.apartmentId + ", address=" + this.address + ", temporaryCode=" + this.temporaryCode + ")";
    }

    public ApartmentTemporaryCodeEntity(int i, String str, Integer num) {
        this.apartmentId = i;
        this.address = str;
        this.temporaryCode = num;
    }

    public final int getApartmentId() {
        return this.apartmentId;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Integer getTemporaryCode() {
        return this.temporaryCode;
    }
}
