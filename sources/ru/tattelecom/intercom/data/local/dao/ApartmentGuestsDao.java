package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: ApartmentGuestsDao.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0007\u001a\u00020\u0003H'J\u0016\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\tH'¨\u0006\n"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/ApartmentGuestsDao;", "", "add", "", EntitiesKt.APARTMENTS_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "clear", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ApartmentGuestsDao {
    void add(List<ApartmentGuestsEntity> apartments);

    void clear();

    Flow<List<ApartmentGuestsEntity>> observeAll();
}
