package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.ScheduleEntity;

/* compiled from: ScheduleDao.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0007\u001a\u00020\u0003H'J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/ScheduleDao;", "", "add", "", EntitiesKt.SCHEDULES_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "clear", "getByIntercomId", NavArg.INTERCOM_ID, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ScheduleDao {
    void add(List<ScheduleEntity> schedules);

    void clear();

    Object getByIntercomId(int i, Continuation<? super ScheduleEntity> continuation);
}
