package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.LockGateEntity;

/* compiled from: LockGateDao.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH'J\u0018\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\fH§@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH'¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/LockGateDao;", "", "delete", "", "gateId", "", "deleteByDate", "date", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/tattelecom/intercom/data/local/entity/LockGateEntity;", "getById", "getUnlockGateId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "data", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface LockGateDao {
    void delete(int gateId);

    Object deleteByDate(long j, Continuation<? super Unit> continuation);

    Flow<List<LockGateEntity>> getAll();

    Flow<LockGateEntity> getById(int gateId);

    Object getUnlockGateId(Continuation<? super List<Integer>> continuation);

    void insert(LockGateEntity data);
}
