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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.GateEventEntitiesKt;
import ru.tattelecom.intercom.data.local.entity.GateEventEntity;

/* loaded from: classes5.dex */
public final class GateEventDao_Impl implements GateEventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<GateEventEntity> __insertionAdapterOfGateEventEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearOld;

    public GateEventDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfGateEventEntity = new EntityInsertionAdapter<GateEventEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.GateEventDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `gate_events` (`id`,`gateId`,`type`,`startDate`,`duration`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final GateEventEntity entity) {
                if (entity.getId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getId());
                }
                statement.bindLong(2, entity.getGateId());
                if (entity.getType() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getType());
                }
                statement.bindLong(4, entity.getStartDate());
                statement.bindLong(5, entity.getDuration());
            }
        };
        this.__preparedStmtOfClearOld = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.GateEventDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM gate_events WHERE startDate < ?";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.GateEventDao
    public Object add(final List<GateEventEntity> gateEvents, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.GateEventDao_Impl.3
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                GateEventDao_Impl.this.__db.beginTransaction();
                try {
                    GateEventDao_Impl.this.__insertionAdapterOfGateEventEntity.insert((Iterable) gateEvents);
                    GateEventDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    GateEventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.GateEventDao
    public Object clearOld(final long date, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.GateEventDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = GateEventDao_Impl.this.__preparedStmtOfClearOld.acquire();
                acquire.bindLong(1, date);
                try {
                    GateEventDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        GateEventDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        GateEventDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    GateEventDao_Impl.this.__preparedStmtOfClearOld.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.GateEventDao
    public Flow<List<GateEventEntity>> getAsFlow(final int gateId) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM gate_events WHERE gateId = ? ORDER BY startDate DESC", 1);
        acquire.bindLong(1, gateId);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{GateEventEntitiesKt.GATE_EVENT_TABLE}, new Callable<List<GateEventEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.GateEventDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<GateEventEntity> call() throws Exception {
                Cursor query = DBUtil.query(GateEventDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "type");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "startDate");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "duration");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new GateEventEntity(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4), query.getLong(columnIndexOrThrow5)));
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
