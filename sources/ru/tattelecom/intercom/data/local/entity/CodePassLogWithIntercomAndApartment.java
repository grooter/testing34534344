package ru.tattelecom.intercom.data.local.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/data/local/entity/CodePassLogWithIntercomAndApartment;", "", "codePassLogs", "Lru/tattelecom/intercom/data/local/entity/CodePassLogEntity;", "intercom", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "apartment", "Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "services", "", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "(Lru/tattelecom/intercom/data/local/entity/CodePassLogEntity;Lru/tattelecom/intercom/data/local/entity/IntercomEntity;Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;Ljava/util/List;)V", "getApartment", "()Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "getCodePassLogs", "()Lru/tattelecom/intercom/data/local/entity/CodePassLogEntity;", "getIntercom", "()Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "getServices", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CodePassLogWithIntercomAndApartment {
    private final ApartmentEntity apartment;
    private final CodePassLogEntity codePassLogs;
    private final IntercomEntity intercom;
    private final List<ApartmentServicesEntity> services;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CodePassLogWithIntercomAndApartment copy$default(CodePassLogWithIntercomAndApartment codePassLogWithIntercomAndApartment, CodePassLogEntity codePassLogEntity, IntercomEntity intercomEntity, ApartmentEntity apartmentEntity, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            codePassLogEntity = codePassLogWithIntercomAndApartment.codePassLogs;
        }
        if ((i & 2) != 0) {
            intercomEntity = codePassLogWithIntercomAndApartment.intercom;
        }
        if ((i & 4) != 0) {
            apartmentEntity = codePassLogWithIntercomAndApartment.apartment;
        }
        if ((i & 8) != 0) {
            list = codePassLogWithIntercomAndApartment.services;
        }
        return codePassLogWithIntercomAndApartment.copy(codePassLogEntity, intercomEntity, apartmentEntity, list);
    }

    /* renamed from: component1, reason: from getter */
    public final CodePassLogEntity getCodePassLogs() {
        return this.codePassLogs;
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

    public final CodePassLogWithIntercomAndApartment copy(CodePassLogEntity codePassLogs, IntercomEntity intercom, ApartmentEntity apartment, List<ApartmentServicesEntity> services) {
        Intrinsics.checkNotNullParameter(codePassLogs, "codePassLogs");
        return new CodePassLogWithIntercomAndApartment(codePassLogs, intercom, apartment, services);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CodePassLogWithIntercomAndApartment)) {
            return false;
        }
        CodePassLogWithIntercomAndApartment codePassLogWithIntercomAndApartment = (CodePassLogWithIntercomAndApartment) other;
        return Intrinsics.areEqual(this.codePassLogs, codePassLogWithIntercomAndApartment.codePassLogs) && Intrinsics.areEqual(this.intercom, codePassLogWithIntercomAndApartment.intercom) && Intrinsics.areEqual(this.apartment, codePassLogWithIntercomAndApartment.apartment) && Intrinsics.areEqual(this.services, codePassLogWithIntercomAndApartment.services);
    }

    public int hashCode() {
        int hashCode = this.codePassLogs.hashCode() * 31;
        IntercomEntity intercomEntity = this.intercom;
        int hashCode2 = (hashCode + (intercomEntity == null ? 0 : intercomEntity.hashCode())) * 31;
        ApartmentEntity apartmentEntity = this.apartment;
        int hashCode3 = (hashCode2 + (apartmentEntity == null ? 0 : apartmentEntity.hashCode())) * 31;
        List<ApartmentServicesEntity> list = this.services;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "CodePassLogWithIntercomAndApartment(codePassLogs=" + this.codePassLogs + ", intercom=" + this.intercom + ", apartment=" + this.apartment + ", services=" + this.services + ")";
    }

    public CodePassLogWithIntercomAndApartment(CodePassLogEntity codePassLogs, IntercomEntity intercomEntity, ApartmentEntity apartmentEntity, List<ApartmentServicesEntity> list) {
        Intrinsics.checkNotNullParameter(codePassLogs, "codePassLogs");
        this.codePassLogs = codePassLogs;
        this.intercom = intercomEntity;
        this.apartment = apartmentEntity;
        this.services = list;
    }

    public final CodePassLogEntity getCodePassLogs() {
        return this.codePassLogs;
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
