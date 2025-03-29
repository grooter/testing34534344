package ru.tattelecom.intercom.data.local.dao;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.data.local.entity.StreamEntity;

/* loaded from: classes5.dex */
public final class StreamDao_Impl implements StreamDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<StreamEntity> __insertionAdapterOfStreamEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfSetFavoriteStatus;

    public StreamDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfStreamEntity = new EntityInsertionAdapter<StreamEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.StreamDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `streams` (`id`,`addressId`,`name`,`liveSource`,`snapshotUrl`,`archiveSource`,`archiveExportSource`,`isFlussonic`,`isSelected`,`isFavorite`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, StreamEntity streamEntity) {
                supportSQLiteStatement.bindLong(1, streamEntity.getId());
                supportSQLiteStatement.bindLong(2, streamEntity.getAddressId());
                if (streamEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, streamEntity.getName());
                }
                if (streamEntity.getLiveSource() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, streamEntity.getLiveSource());
                }
                if (streamEntity.getSnapshotUrl() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, streamEntity.getSnapshotUrl());
                }
                if (streamEntity.getArchiveSource() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, streamEntity.getArchiveSource());
                }
                if (streamEntity.getArchiveExportSource() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, streamEntity.getArchiveExportSource());
                }
                supportSQLiteStatement.bindLong(8, streamEntity.isFlussonic() ? 1L : 0L);
                if ((streamEntity.isSelected() == null ? null : Integer.valueOf(streamEntity.isSelected().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindLong(9, r0.intValue());
                }
                if ((streamEntity.isFavorite() != null ? Integer.valueOf(streamEntity.isFavorite().booleanValue() ? 1 : 0) : null) == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindLong(10, r1.intValue());
                }
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.StreamDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM streams";
            }
        };
        this.__preparedStmtOfSetFavoriteStatus = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.StreamDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE streams SET isFavorite = ? WHERE liveSource = ?";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.StreamDao
    public void add(final List<StreamEntity> streams) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfStreamEntity.insert(streams);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.StreamDao
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

    @Override // ru.tattelecom.intercom.data.local.dao.StreamDao
    public Object setFavoriteStatus(final String stream, final boolean isFavorite, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.StreamDao_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = StreamDao_Impl.this.__preparedStmtOfSetFavoriteStatus.acquire();
                acquire.bindLong(1, isFavorite ? 1L : 0L);
                String str = stream;
                if (str == null) {
                    acquire.bindNull(2);
                } else {
                    acquire.bindString(2, str);
                }
                try {
                    StreamDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        StreamDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        StreamDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    StreamDao_Impl.this.__preparedStmtOfSetFavoriteStatus.release(acquire);
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
