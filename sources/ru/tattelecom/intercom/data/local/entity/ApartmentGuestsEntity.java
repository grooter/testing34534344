package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "", TtmlNode.ATTR_ID, "", "address", "", "guestPhones", "", "remainingInvites", "isMaster", "", "(ILjava/lang/String;Ljava/util/List;IZ)V", "getAddress", "()Ljava/lang/String;", "getGuestPhones", "()Ljava/util/List;", "setGuestPhones", "(Ljava/util/List;)V", "getId", "()I", "()Z", "getRemainingInvites", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ApartmentGuestsEntity {
    private final String address;
    private List<String> guestPhones;
    private final int id;
    private final boolean isMaster;
    private final int remainingInvites;

    public static /* synthetic */ ApartmentGuestsEntity copy$default(ApartmentGuestsEntity apartmentGuestsEntity, int i, String str, List list, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = apartmentGuestsEntity.id;
        }
        if ((i3 & 2) != 0) {
            str = apartmentGuestsEntity.address;
        }
        String str2 = str;
        if ((i3 & 4) != 0) {
            list = apartmentGuestsEntity.guestPhones;
        }
        List list2 = list;
        if ((i3 & 8) != 0) {
            i2 = apartmentGuestsEntity.remainingInvites;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            z = apartmentGuestsEntity.isMaster;
        }
        return apartmentGuestsEntity.copy(i, str2, list2, i4, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final List<String> component3() {
        return this.guestPhones;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRemainingInvites() {
        return this.remainingInvites;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsMaster() {
        return this.isMaster;
    }

    public final ApartmentGuestsEntity copy(int id, String address, List<String> guestPhones, int remainingInvites, boolean isMaster) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(guestPhones, "guestPhones");
        return new ApartmentGuestsEntity(id, address, guestPhones, remainingInvites, isMaster);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentGuestsEntity)) {
            return false;
        }
        ApartmentGuestsEntity apartmentGuestsEntity = (ApartmentGuestsEntity) other;
        return this.id == apartmentGuestsEntity.id && Intrinsics.areEqual(this.address, apartmentGuestsEntity.address) && Intrinsics.areEqual(this.guestPhones, apartmentGuestsEntity.guestPhones) && this.remainingInvites == apartmentGuestsEntity.remainingInvites && this.isMaster == apartmentGuestsEntity.isMaster;
    }

    public int hashCode() {
        return (((((((this.id * 31) + this.address.hashCode()) * 31) + this.guestPhones.hashCode()) * 31) + this.remainingInvites) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isMaster);
    }

    public String toString() {
        return "ApartmentGuestsEntity(id=" + this.id + ", address=" + this.address + ", guestPhones=" + this.guestPhones + ", remainingInvites=" + this.remainingInvites + ", isMaster=" + this.isMaster + ")";
    }

    public ApartmentGuestsEntity(int i, String address, List<String> guestPhones, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(guestPhones, "guestPhones");
        this.id = i;
        this.address = address;
        this.guestPhones = guestPhones;
        this.remainingInvites = i2;
        this.isMaster = z;
    }

    public final int getId() {
        return this.id;
    }

    public final String getAddress() {
        return this.address;
    }

    public final List<String> getGuestPhones() {
        return this.guestPhones;
    }

    public final void setGuestPhones(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.guestPhones = list;
    }

    public final int getRemainingInvites() {
        return this.remainingInvites;
    }

    public final boolean isMaster() {
        return this.isMaster;
    }
}
