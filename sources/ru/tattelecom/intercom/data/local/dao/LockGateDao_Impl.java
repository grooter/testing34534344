package ru.tattelecom.intercom.data.local.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.LockGateEntity;

/* loaded from: classes5.dex */
public final class LockGateDao_Impl implements LockGateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<LockGateEntity> __insertionAdapterOfLockGateEntity;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByDate;

    public LockGateDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfLockGateEntity = new EntityInsertionAdapter<LockGateEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `lock_gate` (`gateId`,`date`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final LockGateEntity entity) {
                statement.bindLong(1, entity.getGateId());
                statement.bindLong(2, entity.getDate());
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM lock_gate WHERE gateId = ?";
            }
        };
        this.__preparedStmtOfDeleteByDate = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM lock_gate WHERE date <= ?";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.LockGateDao
    public void insert(final LockGateEntity data) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfLockGateEntity.insert((EntityInsertionAdapter<LockGateEntity>) data);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.LockGateDao
    public void delete(final int gateId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        acquire.bindLong(1, gateId);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.LockGateDao
    public Object deleteByDate(final long date, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = LockGateDao_Impl.this.__preparedStmtOfDeleteByDate.acquire();
                acquire.bindLong(1, date);
                try {
                    LockGateDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        LockGateDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        LockGateDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    LockGateDao_Impl.this.__preparedStmtOfDeleteByDate.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.LockGateDao
    public Flow<List<LockGateEntity>> getAll() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM lock_gate", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.LOCK_GATE}, new Callable<List<LockGateEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<LockGateEntity> call() throws Exception {
                Cursor query = DBUtil.query(LockGateDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "date");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new LockGateEntity(query.getInt(columnIndexOrThrow), query.getLong(columnIndexOrThrow2)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // ru.tattelecom.intercom.data.local.dao.LockGateDao
    public Flow<LockGateEntity> getById(final int gateId) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM lock_gate WHERE gateId = ?", 1);
        acquire.bindLong(1, gateId);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.LOCK_GATE}, new Callable<LockGateEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.6
            @Override // java.util.concurrent.Callable
            public LockGateEntity call() throws Exception {
                Cursor query = DBUtil.query(LockGateDao_Impl.this.__db, acquire, false, null);
                try {
                    return query.moveToFirst() ? new LockGateEntity(query.getInt(CursorUtil.getColumnIndexOrThrow(query, "gateId")), query.getLong(CursorUtil.getColumnIndexOrThrow(query, "date"))) : null;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // ru.tattelecom.intercom.data.local.dao.LockGateDao
    public Object getUnlockGateId(final Continuation<? super List<Integer>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT intercom.gateId FROM lock_gate lockedGates LEFT JOIN intercoms intercom ON lockedGates.gateId = intercom.gateId ", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<Integer>>() { // from class: ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl.7
            @Override // java.util.concurrent.Callable
            public List<Integer> call() throws Exception {
                Cursor query = DBUtil.query(LockGateDao_Impl.this.__db, acquire, false, null);
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(query.isNull(0) ? null : Integer.valueOf(query.getInt(0)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
