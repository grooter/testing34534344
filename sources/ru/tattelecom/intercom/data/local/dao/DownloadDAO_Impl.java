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
import ru.tattelecom.intercom.data.local.entity.DownloadEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* loaded from: classes5.dex */
public final class DownloadDAO_Impl implements DownloadDAO {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<DownloadEntity> __insertionAdapterOfDownloadEntity;
    private final SharedSQLiteStatement __preparedStmtOfDelete;

    public DownloadDAO_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDownloadEntity = new EntityInsertionAdapter<DownloadEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `downloads` (`urlDescription`,`downloadId`,`isIntercomStream`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, DownloadEntity downloadEntity) {
                if (downloadEntity.getUrlDescription() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, downloadEntity.getUrlDescription());
                }
                supportSQLiteStatement.bindLong(2, downloadEntity.getDownloadId());
                supportSQLiteStatement.bindLong(3, downloadEntity.isIntercomStream() ? 1L : 0L);
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM downloads WHERE urlDescription=?";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.DownloadDAO
    public Object addList(final List<DownloadEntity> downloadList, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.3
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                DownloadDAO_Impl.this.__db.beginTransaction();
                try {
                    DownloadDAO_Impl.this.__insertionAdapterOfDownloadEntity.insert((Iterable) downloadList);
                    DownloadDAO_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    DownloadDAO_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.DownloadDAO
    public Object add(final DownloadEntity download, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.4
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                DownloadDAO_Impl.this.__db.beginTransaction();
                try {
                    DownloadDAO_Impl.this.__insertionAdapterOfDownloadEntity.insert((EntityInsertionAdapter) download);
                    DownloadDAO_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    DownloadDAO_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.DownloadDAO
    public Object delete(final String description, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = DownloadDAO_Impl.this.__preparedStmtOfDelete.acquire();
                String str = description;
                if (str == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindString(1, str);
                }
                try {
                    DownloadDAO_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        DownloadDAO_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        DownloadDAO_Impl.this.__db.endTransaction();
                    }
                } finally {
                    DownloadDAO_Impl.this.__preparedStmtOfDelete.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.DownloadDAO
    public Flow<List<DownloadEntity>> observeAll() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM downloads", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.DOWNLOADS_TABLE}, new Callable<List<DownloadEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.6
            @Override // java.util.concurrent.Callable
            public List<DownloadEntity> call() throws Exception {
                Cursor query = DBUtil.query(DownloadDAO_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "urlDescription");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "downloadId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "isIntercomStream");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new DownloadEntity(query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow), query.getLong(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3) != 0));
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

    @Override // ru.tattelecom.intercom.data.local.dao.DownloadDAO
    public Object getByDescription(final String description, final Continuation<? super DownloadEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM downloads WHERE urlDescription=?", 1);
        if (description == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, description);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<DownloadEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.7
            @Override // java.util.concurrent.Callable
            public DownloadEntity call() throws Exception {
                DownloadEntity downloadEntity = null;
                String string = null;
                Cursor query = DBUtil.query(DownloadDAO_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "urlDescription");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "downloadId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "isIntercomStream");
                    if (query.moveToFirst()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            string = query.getString(columnIndexOrThrow);
                        }
                        downloadEntity = new DownloadEntity(string, query.getLong(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3) != 0);
                    }
                    return downloadEntity;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.DownloadDAO
    public Object getById(final long id, final Continuation<? super DownloadEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM downloads WHERE downloadId = ?", 1);
        acquire.bindLong(1, id);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<DownloadEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl.8
            @Override // java.util.concurrent.Callable
            public DownloadEntity call() throws Exception {
                DownloadEntity downloadEntity = null;
                String string = null;
                Cursor query = DBUtil.query(DownloadDAO_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "urlDescription");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "downloadId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "isIntercomStream");
                    if (query.moveToFirst()) {
                        if (!query.isNull(columnIndexOrThrow)) {
                            string = query.getString(columnIndexOrThrow);
                        }
                        downloadEntity = new DownloadEntity(string, query.getLong(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3) != 0);
                    }
                    return downloadEntity;
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
