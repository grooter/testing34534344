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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.ScheduleEntity;

/* loaded from: classes5.dex */
public final class ScheduleDao_Impl implements ScheduleDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ScheduleEntity> __insertionAdapterOfScheduleEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;

    public ScheduleDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfScheduleEntity = new EntityInsertionAdapter<ScheduleEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ScheduleDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `schedules` (`id`,`intercomId`,`startHour`,`startMinute`,`finishHour`,`finishMinute`,`monday`,`tuesday`,`wednesday`,`thursday`,`friday`,`saturday`,`sunday`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ScheduleEntity scheduleEntity) {
                supportSQLiteStatement.bindLong(1, scheduleEntity.getId());
                supportSQLiteStatement.bindLong(2, scheduleEntity.getIntercomId());
                if (scheduleEntity.getStartHour() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, scheduleEntity.getStartHour().intValue());
                }
                if (scheduleEntity.getStartMinute() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, scheduleEntity.getStartMinute().intValue());
                }
                if (scheduleEntity.getFinishHour() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, scheduleEntity.getFinishHour().intValue());
                }
                if (scheduleEntity.getFinishMinute() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, scheduleEntity.getFinishMinute().intValue());
                }
                supportSQLiteStatement.bindLong(7, scheduleEntity.getMonday() ? 1L : 0L);
                supportSQLiteStatement.bindLong(8, scheduleEntity.getTuesday() ? 1L : 0L);
                supportSQLiteStatement.bindLong(9, scheduleEntity.getWednesday() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, scheduleEntity.getThursday() ? 1L : 0L);
                supportSQLiteStatement.bindLong(11, scheduleEntity.getFriday() ? 1L : 0L);
                supportSQLiteStatement.bindLong(12, scheduleEntity.getSaturday() ? 1L : 0L);
                supportSQLiteStatement.bindLong(13, scheduleEntity.getSunday() ? 1L : 0L);
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ScheduleDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM schedules";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ScheduleDao
    public void add(final List<ScheduleEntity> schedules) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfScheduleEntity.insert(schedules);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ScheduleDao
    public void clear() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClear.acquire();
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfClear.release(acquire);
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ScheduleDao
    public Object getByIntercomId(final int intercomId, final Continuation<? super ScheduleEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM schedules WHERE intercomId = ?", 1);
        acquire.bindLong(1, intercomId);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<ScheduleEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.ScheduleDao_Impl.3
            @Override // java.util.concurrent.Callable
            public ScheduleEntity call() throws Exception {
                ScheduleEntity scheduleEntity = null;
                Cursor query = DBUtil.query(ScheduleDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "startHour");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "startMinute");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "finishHour");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "finishMinute");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "monday");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "tuesday");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "wednesday");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "thursday");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "friday");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "saturday");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "sunday");
                    if (query.moveToFirst()) {
                        scheduleEntity = new ScheduleEntity(query.getInt(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow3)), query.isNull(columnIndexOrThrow4) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5)), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6)), query.getInt(columnIndexOrThrow7) != 0, query.getInt(columnIndexOrThrow8) != 0, query.getInt(columnIndexOrThrow9) != 0, query.getInt(columnIndexOrThrow10) != 0, query.getInt(columnIndexOrThrow11) != 0, query.getInt(columnIndexOrThrow12) != 0, query.getInt(columnIndexOrThrow13) != 0);
                    }
                    return scheduleEntity;
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
