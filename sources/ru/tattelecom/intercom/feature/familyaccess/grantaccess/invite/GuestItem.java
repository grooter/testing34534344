package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: GuestsAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestItem;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteItem;", NavArg.VerifyCode.APARTMENT_ID, "", "phone", "", "isMaster", "", "(ILjava/lang/String;Z)V", "getApartmentId", "()I", "()Z", "getPhone", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class GuestItem extends InviteItem {
    private final int apartmentId;
    private final boolean isMaster;
    private final String phone;

    public static /* synthetic */ GuestItem copy$default(GuestItem guestItem, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guestItem.apartmentId;
        }
        if ((i2 & 2) != 0) {
            str = guestItem.phone;
        }
        if ((i2 & 4) != 0) {
            z = guestItem.isMaster;
        }
        return guestItem.copy(i, str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getApartmentId() {
        return this.apartmentId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsMaster() {
        return this.isMaster;
    }

    public final GuestItem copy(int apartmentId, String phone, boolean isMaster) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new GuestItem(apartmentId, phone, isMaster);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuestItem)) {
            return false;
        }
        GuestItem guestItem = (GuestItem) other;
        return this.apartmentId == guestItem.apartmentId && Intrinsics.areEqual(this.phone, guestItem.phone) && this.isMaster == guestItem.isMaster;
    }

    public int hashCode() {
        return (((this.apartmentId * 31) + this.phone.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isMaster);
    }

    public String toString() {
        return "GuestItem(apartmentId=" + this.apartmentId + ", phone=" + this.phone + ", isMaster=" + this.isMaster + ")";
    }

    public final int getApartmentId() {
        return this.apartmentId;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final boolean isMaster() {
        return this.isMaster;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuestItem(int i, String phone, boolean z) {
        super(0);
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.apartmentId = i;
        this.phone = phone;
        this.isMaster = z;
    }
}
