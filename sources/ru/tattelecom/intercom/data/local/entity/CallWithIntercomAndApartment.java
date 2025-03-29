package ru.tattelecom.intercom.data.local.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/data/local/entity/CallWithIntercomAndApartment;", "", "callLogs", "Lru/tattelecom/intercom/data/local/entity/CallEntity;", "intercom", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "apartment", "Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "services", "", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "(Lru/tattelecom/intercom/data/local/entity/CallEntity;Lru/tattelecom/intercom/data/local/entity/IntercomEntity;Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;Ljava/util/List;)V", "getApartment", "()Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "getCallLogs", "()Lru/tattelecom/intercom/data/local/entity/CallEntity;", "getIntercom", "()Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "getServices", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CallWithIntercomAndApartment {
    private final ApartmentEntity apartment;
    private final CallEntity callLogs;
    private final IntercomEntity intercom;
    private final List<ApartmentServicesEntity> services;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CallWithIntercomAndApartment copy$default(CallWithIntercomAndApartment callWithIntercomAndApartment, CallEntity callEntity, IntercomEntity intercomEntity, ApartmentEntity apartmentEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            callEntity = callWithIntercomAndApartment.callLogs;
        }
        if ((i & 2) != 0) {
            intercomEntity = callWithIntercomAndApartment.intercom;
        }
        if ((i & 4) != 0) {
            apartmentEntity = callWithIntercomAndApartment.apartment;
        }
        if ((i & 8) != 0) {
            list = callWithIntercomAndApartment.services;
        }
        return callWithIntercomAndApartment.copy(callEntity, intercomEntity, apartmentEntity, list);
    }

    /* renamed from: component1, reason: from getter */
    public final CallEntity getCallLogs() {
        return this.callLogs;
    }

    /* renamed from: component2, reason: from getter */
    public final IntercomEntity getIntercom() {
        return this.intercom;
    }

    /* renamed from: component3, reason: from getter */
    public final ApartmentEntity getApartment() {
        return this.apartment;
    }

    public final List<ApartmentServicesEntity> component4() {
        return this.services;
    }

    public final CallWithIntercomAndApartment copy(CallEntity callLogs, IntercomEntity intercom, ApartmentEntity apartment, List<ApartmentServicesEntity> services) {
        Intrinsics.checkNotNullParameter(callLogs, "callLogs");
        return new CallWithIntercomAndApartment(callLogs, intercom, apartment, services);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallWithIntercomAndApartment)) {
            return false;
        }
        CallWithIntercomAndApartment callWithIntercomAndApartment = (CallWithIntercomAndApartment) other;
        return Intrinsics.areEqual(this.callLogs, callWithIntercomAndApartment.callLogs) && Intrinsics.areEqual(this.intercom, callWithIntercomAndApartment.intercom) && Intrinsics.areEqual(this.apartment, callWithIntercomAndApartment.apartment) && Intrinsics.areEqual(this.services, callWithIntercomAndApartment.services);
    }

    public int hashCode() {
        int hashCode = this.callLogs.hashCode() * 31;
        IntercomEntity intercomEntity = this.intercom;
        int hashCode2 = (hashCode + (intercomEntity == null ? 0 : intercomEntity.hashCode())) * 31;
        ApartmentEntity apartmentEntity = this.apartment;
        int hashCode3 = (hashCode2 + (apartmentEntity == null ? 0 : apartmentEntity.hashCode())) * 31;
        List<ApartmentServicesEntity> list = this.services;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "CallWithIntercomAndApartment(callLogs=" + this.callLogs + ", intercom=" + this.intercom + ", apartment=" + this.apartment + ", services=" + this.services + ")";
    }

    public CallWithIntercomAndApartment(CallEntity callLogs, IntercomEntity intercomEntity, ApartmentEntity apartmentEntity, List<ApartmentServicesEntity> list) {
        Intrinsics.checkNotNullParameter(callLogs, "callLogs");
        this.callLogs = callLogs;
        this.intercom = intercomEntity;
        this.apartment = apartmentEntity;
        this.services = list;
    }

    public final CallEntity getCallLogs() {
        return this.callLogs;
    }

    public final IntercomEntity getIntercom() {
        return this.intercom;
    }

    public final ApartmentEntity getApartment() {
        return this.apartment;
    }

    public final List<ApartmentServicesEntity> getServices() {
        return this.services;
    }
}
