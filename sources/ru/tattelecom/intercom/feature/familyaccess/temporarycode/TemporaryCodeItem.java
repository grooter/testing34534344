package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: TemporaryCodeAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeItem;", "", NavArg.VerifyCode.APARTMENT_ID, "", "address", "", "temporaryCode", "isTemporaryCodeLoading", "", "(ILjava/lang/String;Ljava/lang/Integer;Z)V", "getAddress", "()Ljava/lang/String;", "getApartmentId", "()I", "()Z", "setTemporaryCodeLoading", "(Z)V", "getTemporaryCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(ILjava/lang/String;Ljava/lang/Integer;Z)Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeItem;", "equals", "other", "hashCode", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class TemporaryCodeItem {
    private final String address;
    private final int apartmentId;
    private boolean isTemporaryCodeLoading;
    private final Integer temporaryCode;

    public static /* synthetic */ TemporaryCodeItem copy$default(TemporaryCodeItem temporaryCodeItem, int i, String str, Integer num, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = temporaryCodeItem.apartmentId;
        }
        if ((i2 & 2) != 0) {
            str = temporaryCodeItem.address;
        }
        if ((i2 & 4) != 0) {
            num = temporaryCodeItem.temporaryCode;
        }
        if ((i2 & 8) != 0) {
            z = temporaryCodeItem.isTemporaryCodeLoading;
        }
        return temporaryCodeItem.copy(i, str, num, z);
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

    /* renamed from: component4, reason: from getter */
    public final boolean getIsTemporaryCodeLoading() {
        return this.isTemporaryCodeLoading;
    }

    public final TemporaryCodeItem copy(int apartmentId, String address, Integer temporaryCode, boolean isTemporaryCodeLoading) {
        return new TemporaryCodeItem(apartmentId, address, temporaryCode, isTemporaryCodeLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemporaryCodeItem)) {
            return false;
        }
        TemporaryCodeItem temporaryCodeItem = (TemporaryCodeItem) other;
        return this.apartmentId == temporaryCodeItem.apartmentId && Intrinsics.areEqual(this.address, temporaryCodeItem.address) && Intrinsics.areEqual(this.temporaryCode, temporaryCodeItem.temporaryCode) && this.isTemporaryCodeLoading == temporaryCodeItem.isTemporaryCodeLoading;
    }

    public int hashCode() {
        int i = this.apartmentId * 31;
        String str = this.address;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.temporaryCode;
        return ((hashCode + (num != null ? num.hashCode() : 0)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isTemporaryCodeLoading);
    }

    public String toString() {
        return "TemporaryCodeItem(apartmentId=" + this.apartmentId + ", address=" + this.address + ", temporaryCode=" + this.temporaryCode + ", isTemporaryCodeLoading=" + this.isTemporaryCodeLoading + ")";
    }

    public TemporaryCodeItem(int i, String str, Integer num, boolean z) {
        this.apartmentId = i;
        this.address = str;
        this.temporaryCode = num;
        this.isTemporaryCodeLoading = z;
    }

    public /* synthetic */ TemporaryCodeItem(int i, String str, Integer num, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, num, (i2 & 8) != 0 ? false : z);
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

    public final boolean isTemporaryCodeLoading() {
        return this.isTemporaryCodeLoading;
    }

    public final void setTemporaryCodeLoading(boolean z) {
        this.isTemporaryCodeLoading = z;
    }
}
