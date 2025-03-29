package ru.tattelecom.intercom.data.local.dao;

import android.database.Cursor;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.RemoteLogEntity;

/* loaded from: classes5.dex */
public final class RemoteLogsDao_Impl implements RemoteLogsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<RemoteLogEntity> __insertionAdapterOfRemoteLogEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOldLogs;

    public RemoteLogsDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRemoteLogEntity = new EntityInsertionAdapter<RemoteLogEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `remote_logs` (`id`,`timestamp`,`message`,`tag`,`logLevel`,`type`) VALUES (nullif(?, 0),?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final RemoteLogEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getTimestamp());
                if (entity.getMessage() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getMessage());
                }
                if (entity.getTag() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getTag());
                }
                if (entity.getLogLevel() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getLogLevel());
                }
                if (entity.getType() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getType());
                }
            }
        };
        this.__preparedStmtOfDeleteOldLogs = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM remote_logs WHERE id IN (SELECT id FROM remote_logs ORDER BY id ASC LIMIT ?)";
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM remote_logs";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.RemoteLogsDao
    public void insertLog(final RemoteLogEntity remoteLogEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRemoteLogEntity.insert((EntityInsertionAdapter<RemoteLogEntity>) remoteLogEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.RemoteLogsDao
    public void deleteOldLogs(final int count) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteOldLogs.acquire();
        acquire.bindLong(1, count);
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteOldLogs.release(acquire);
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.RemoteLogsDao
    public Object clear(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = RemoteLogsDao_Impl.this.__preparedStmtOfClear.acquire();
                try {
                    RemoteLogsDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        RemoteLogsDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        RemoteLogsDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    RemoteLogsDao_Impl.this.__preparedStmtOfClear.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.RemoteLogsDao
    public long getLogsCount() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM remote_logs", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            return query.moveToFirst() ? query.getLong(0) : 0L;
        } finally {
            query.close();
            acquire.release();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.RemoteLogsDao
    public Object getAllLogs(final Continuation<? super List<RemoteLogEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM remote_logs", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<RemoteLogEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<RemoteLogEntity> call() throws Exception {
                Cursor query = DBUtil.query(RemoteLogsDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "message");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, RemoteMessageConst.Notification.TAG);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "logLevel");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new RemoteLogEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6)));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.RemoteLogsDao
    public Flow<List<RemoteLogEntity>> observeAllLogs() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM remote_logs", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.REMOTE_LOGS_TABLE}, new Callable<List<RemoteLogEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl.6
            @Override // java.util.concurrent.Callable
            public List<RemoteLogEntity> call() throws Exception {
                Cursor query = DBUtil.query(RemoteLogsDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "timestamp");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "message");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, RemoteMessageConst.Notification.TAG);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "logLevel");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new RemoteLogEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? null : query.getString(columnIndexOrThrow5), query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6)));
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
