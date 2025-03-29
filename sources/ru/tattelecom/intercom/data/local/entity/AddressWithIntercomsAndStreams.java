package ru.tattelecom.intercom.data.local.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00052\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006\""}, d2 = {"Lru/tattelecom/intercom/data/local/entity/AddressWithIntercomsAndStreams;", "", "address", "Lru/tattelecom/intercom/data/local/entity/AddressEntity;", EntitiesKt.INTERCOMS_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", EntitiesKt.STREAM_TABLE, "Lru/tattelecom/intercom/data/local/entity/StreamEntity;", "services", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", EntitiesKt.APARTMENTS_TABLE, "Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "(Lru/tattelecom/intercom/data/local/entity/AddressEntity;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAddress", "()Lru/tattelecom/intercom/data/local/entity/AddressEntity;", "getApartments", "()Ljava/util/List;", "getIntercoms", "getServices", "getStreams", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AddressWithIntercomsAndStreams {
    private final AddressEntity address;
    private final List<ApartmentEntity> apartments;
    private final List<IntercomEntity> intercoms;
    private final List<ApartmentServicesEntity> services;
    private final List<StreamEntity> streams;

    public static /* synthetic */ AddressWithIntercomsAndStreams copy$default(AddressWithIntercomsAndStreams addressWithIntercomsAndStreams, AddressEntity addressEntity, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            addressEntity = addressWithIntercomsAndStreams.address;
        }
        if ((i & 2) != 0) {
            list = addressWithIntercomsAndStreams.intercoms;
        }
        List list5 = list;
        if ((i & 4) != 0) {
            list2 = addressWithIntercomsAndStreams.streams;
        }
        List list6 = list2;
        if ((i & 8) != 0) {
            list3 = addressWithIntercomsAndStreams.services;
        }
        List list7 = list3;
        if ((i & 16) != 0) {
            list4 = addressWithIntercomsAndStreams.apartments;
        }
        return addressWithIntercomsAndStreams.copy(addressEntity, list5, list6, list7, list4);
    }

    /* renamed from: component1, reason: from getter */
    public final AddressEntity getAddress() {
        return this.address;
    }

    public final List<IntercomEntity> component2() {
        return this.intercoms;
    }

    public final List<StreamEntity> component3() {
        return this.streams;
    }

    public final List<ApartmentServicesEntity> component4() {
        return this.services;
    }

    public final List<ApartmentEntity> component5() {
        return this.apartments;
    }

    public final AddressWithIntercomsAndStreams copy(AddressEntity address, List<IntercomEntity> intercoms, List<StreamEntity> streams, List<ApartmentServicesEntity> services, List<ApartmentEntity> apartments) {
        return new AddressWithIntercomsAndStreams(address, intercoms, streams, services, apartments);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AddressWithIntercomsAndStreams)) {
            return false;
        }
        AddressWithIntercomsAndStreams addressWithIntercomsAndStreams = (AddressWithIntercomsAndStreams) other;
        return Intrinsics.areEqual(this.address, addressWithIntercomsAndStreams.address) && Intrinsics.areEqual(this.intercoms, addressWithIntercomsAndStreams.intercoms) && Intrinsics.areEqual(this.streams, addressWithIntercomsAndStreams.streams) && Intrinsics.areEqual(this.services, addressWithIntercomsAndStreams.services) && Intrinsics.areEqual(this.apartments, addressWithIntercomsAndStreams.apartments);
    }

    public int hashCode() {
        AddressEntity addressEntity = this.address;
        int hashCode = (addressEntity == null ? 0 : addressEntity.hashCode()) * 31;
        List<IntercomEntity> list = this.intercoms;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<StreamEntity> list2 = this.streams;
        int hashCode3 = (hashCode2 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<ApartmentServicesEntity> list3 = this.services;
        int hashCode4 = (hashCode3 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<ApartmentEntity> list4 = this.apartments;
        return hashCode4 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "AddressWithIntercomsAndStreams(address=" + this.address + ", intercoms=" + this.intercoms + ", streams=" + this.streams + ", services=" + this.services + ", apartments=" + this.apartments + ")";
    }

    public AddressWithIntercomsAndStreams(AddressEntity addressEntity, List<IntercomEntity> list, List<StreamEntity> list2, List<ApartmentServicesEntity> list3, List<ApartmentEntity> list4) {
        this.address = addressEntity;
        this.intercoms = list;
        this.streams = list2;
        this.services = list3;
        this.apartments = list4;
    }

    public final AddressEntity getAddress() {
        return this.address;
    }

    public final List<IntercomEntity> getIntercoms() {
        return this.intercoms;
    }

    public final List<StreamEntity> getStreams() {
        return this.streams;
    }

    public final List<ApartmentServicesEntity> getServices() {
        return this.services;
    }

    public final List<ApartmentEntity> getApartments() {
        return this.apartments;
    }
}
