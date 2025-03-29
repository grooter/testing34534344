package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.GateEventEntity;

/* compiled from: GateEventDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\r2\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/GateEventDao;", "", "add", "", "gateEvents", "", "Lru/tattelecom/intercom/data/local/entity/GateEventEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearOld", "date", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAsFlow", "Lkotlinx/coroutines/flow/Flow;", "gateId", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GateEventDao {
    Object add(List<GateEventEntity> list, Continuation<? super Unit> continuation);

    Object clearOld(long j, Continuation<? super Unit> continuation);

    Flow<List<GateEventEntity>> getAsFlow(int gateId);
}
