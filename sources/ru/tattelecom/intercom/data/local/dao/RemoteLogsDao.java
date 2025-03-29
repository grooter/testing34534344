package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.RemoteLogEntity;

/* compiled from: RemoteLogsDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH§@¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\nH'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0010H'¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/RemoteLogsDao;", "", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldLogs", "count", "", "getAllLogs", "", "Lru/tattelecom/intercom/data/local/entity/RemoteLogEntity;", "getLogsCount", "", "insertLog", "remoteLogEntity", "observeAllLogs", "Lkotlinx/coroutines/flow/Flow;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface RemoteLogsDao {
    Object clear(Continuation<? super Unit> continuation);

    void deleteOldLogs(int count);

    Object getAllLogs(Continuation<? super List<RemoteLogEntity>> continuation);

    long getLogsCount();

    void insertLog(RemoteLogEntity remoteLogEntity);

    Flow<List<RemoteLogEntity>> observeAllLogs();
}
