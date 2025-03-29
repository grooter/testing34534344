package ru.tattelecom.intercom.domain.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.entity.SupportContactEntity;
import ru.tattelecom.intercom.data.local.entity.SupportWithAuthContactEntity;
import ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse;
import ru.tattelecom.intercom.domain.model.SupportContactDto;

/* compiled from: SupportDtos.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002*\b\u0012\u0004\u0012\u00020\u00070\u0002\u001a\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0002*\b\u0012\u0004\u0012\u00020\u00070\u0002\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0007\u001a\f\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\n\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\b\u0012\u0004\u0012\u00020\n0\u0002\u001a\f\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0006\u001a\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00060\u0002¨\u0006\u000f"}, d2 = {"getContact", "Lru/tattelecom/intercom/domain/model/SupportContactDto$Item;", "", "type", "Lru/tattelecom/intercom/domain/model/SupportContactDto$Type;", "toContactWithAuthEntity", "Lru/tattelecom/intercom/data/local/entity/SupportWithAuthContactEntity;", "Lru/tattelecom/intercom/data/remote/model/responses/TtkPhonesResponse$Item;", "toContactsWithAuthEntity", "toEntity", "Lru/tattelecom/intercom/data/local/entity/SupportContactEntity;", "toSupportDto", "toSupportListDto", "toSupportWithAuthDto", "toSupportWithAuthListDto", "domain_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SupportDtosKt {
    public static final List<SupportContactEntity> toEntity(List<TtkPhonesResponse.Item> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<TtkPhonesResponse.Item> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toEntity((TtkPhonesResponse.Item) it.next()));
        }
        return arrayList;
    }

    public static final SupportContactEntity toEntity(TtkPhonesResponse.Item item) {
        Intrinsics.checkNotNullParameter(item, "<this>");
        String name = item.getName();
        Intrinsics.checkNotNull(name, "null cannot be cast to non-null type kotlin.String");
        return new SupportContactEntity(name, item.getDescription(), item.getValue(), item.isEnabled());
    }

    public static final List<SupportWithAuthContactEntity> toContactsWithAuthEntity(List<TtkPhonesResponse.Item> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<TtkPhonesResponse.Item> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toContactWithAuthEntity((TtkPhonesResponse.Item) it.next()));
        }
        return arrayList;
    }

    public static final SupportWithAuthContactEntity toContactWithAuthEntity(TtkPhonesResponse.Item item) {
        Intrinsics.checkNotNullParameter(item, "<this>");
        String name = item.getName();
        Intrinsics.checkNotNull(name, "null cannot be cast to non-null type kotlin.String");
        return new SupportWithAuthContactEntity(name, item.getDescription(), item.getValue(), item.isEnabled());
    }

    public static final SupportContactDto.Item getContact(List<SupportContactDto.Item> list, SupportContactDto.Type type) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((SupportContactDto.Item) obj).getType() == type) {
                break;
            }
        }
        return (SupportContactDto.Item) obj;
    }

    public static final List<SupportContactDto.Item> toSupportListDto(List<SupportContactEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SupportContactDto.Item supportDto = toSupportDto((SupportContactEntity) it.next());
            if (supportDto != null) {
                arrayList.add(supportDto);
            }
        }
        return arrayList;
    }

    public static final SupportContactDto.Item toSupportDto(SupportContactEntity supportContactEntity) {
        SupportContactDto.Type type;
        Intrinsics.checkNotNullParameter(supportContactEntity, "<this>");
        if (supportContactEntity.getValue() == null) {
            return null;
        }
        String name = supportContactEntity.getName();
        if (Intrinsics.areEqual(name, "call_phone")) {
            type = SupportContactDto.Type.CALL_PHONE;
        } else {
            if (!Intrinsics.areEqual(name, "telegram")) {
                return null;
            }
            type = SupportContactDto.Type.TELEGRAM;
        }
        String description = supportContactEntity.getDescription();
        String value = supportContactEntity.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
        return new SupportContactDto.Item(type, description, value, supportContactEntity.isEnabled());
    }

    public static final List<SupportContactDto.Item> toSupportWithAuthListDto(List<SupportWithAuthContactEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SupportContactDto.Item supportWithAuthDto = toSupportWithAuthDto((SupportWithAuthContactEntity) it.next());
            if (supportWithAuthDto != null) {
                arrayList.add(supportWithAuthDto);
            }
        }
        return arrayList;
    }

    public static final SupportContactDto.Item toSupportWithAuthDto(SupportWithAuthContactEntity supportWithAuthContactEntity) {
        SupportContactDto.Type type;
        Intrinsics.checkNotNullParameter(supportWithAuthContactEntity, "<this>");
        if (supportWithAuthContactEntity.getValue() == null) {
            return null;
        }
        String name = supportWithAuthContactEntity.getName();
        int hashCode = name.hashCode();
        if (hashCode == -1360467711) {
            if (name.equals("telegram")) {
                type = SupportContactDto.Type.TELEGRAM;
                String description = supportWithAuthContactEntity.getDescription();
                String value = supportWithAuthContactEntity.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                return new SupportContactDto.Item(type, description, value, supportWithAuthContactEntity.isEnabled());
            }
            return null;
        }
        if (hashCode == 3052376) {
            if (name.equals("chat")) {
                type = SupportContactDto.Type.CHAT;
                String description2 = supportWithAuthContactEntity.getDescription();
                String value2 = supportWithAuthContactEntity.getValue();
                Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.String");
                return new SupportContactDto.Item(type, description2, value2, supportWithAuthContactEntity.isEnabled());
            }
            return null;
        }
        if (hashCode == 1928092749 && name.equals("call_phone")) {
            type = SupportContactDto.Type.CALL_PHONE;
            String description22 = supportWithAuthContactEntity.getDescription();
            String value22 = supportWithAuthContactEntity.getValue();
            Intrinsics.checkNotNull(value22, "null cannot be cast to non-null type kotlin.String");
            return new SupportContactDto.Item(type, description22, value22, supportWithAuthContactEntity.isEnabled());
        }
        return null;
    }
}
