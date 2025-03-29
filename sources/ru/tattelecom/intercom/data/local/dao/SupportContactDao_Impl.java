package ru.tattelecom.intercom.data.local.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
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
import kotlin.jvm.functions.Function1;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao;
import ru.tattelecom.intercom.data.local.entity.SupportContactEntity;
import ru.tattelecom.intercom.data.local.entity.SupportWithAuthContactEntity;

/* loaded from: classes5.dex */
public final class SupportContactDao_Impl implements SupportContactDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SupportContactEntity> __insertionAdapterOfSupportContactEntity;
    private final EntityInsertionAdapter<SupportWithAuthContactEntity> __insertionAdapterOfSupportWithAuthContactEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfClearContactsWithAuth;

    public SupportContactDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSupportContactEntity = new EntityInsertionAdapter<SupportContactEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `support_contacts` (`name`,`description`,`value`,`isEnabled`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SupportContactEntity supportContactEntity) {
                if (supportContactEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, supportContactEntity.getName());
                }
                if (supportContactEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, supportContactEntity.getDescription());
                }
                if (supportContactEntity.getValue() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, supportContactEntity.getValue());
                }
                if ((supportContactEntity.isEnabled() == null ? null : Integer.valueOf(supportContactEntity.isEnabled().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, r5.intValue());
                }
            }
        };
        this.__insertionAdapterOfSupportWithAuthContactEntity = new EntityInsertionAdapter<SupportWithAuthContactEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR IGNORE INTO `support_with_auth_contacts` (`name`,`description`,`value`,`isEnabled`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, SupportWithAuthContactEntity supportWithAuthContactEntity) {
                if (supportWithAuthContactEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, supportWithAuthContactEntity.getName());
                }
                if (supportWithAuthContactEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, supportWithAuthContactEntity.getDescription());
                }
                if (supportWithAuthContactEntity.getValue() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, supportWithAuthContactEntity.getValue());
                }
                if ((supportWithAuthContactEntity.isEnabled() == null ? null : Integer.valueOf(supportWithAuthContactEntity.isEnabled().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindLong(4, r5.intValue());
                }
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM support_contacts";
            }
        };
        this.__preparedStmtOfClearContactsWithAuth = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM support_with_auth_contacts";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object insert(final List<SupportContactEntity> contacts, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportContactDao_Impl.this.__db.beginTransaction();
                try {
                    SupportContactDao_Impl.this.__insertionAdapterOfSupportContactEntity.insert((Iterable) contacts);
                    SupportContactDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    SupportContactDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object insertContactsWithAuth(final List<SupportWithAuthContactEntity> contacts, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportContactDao_Impl.this.__db.beginTransaction();
                try {
                    SupportContactDao_Impl.this.__insertionAdapterOfSupportWithAuthContactEntity.insert((Iterable) contacts);
                    SupportContactDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    SupportContactDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$allUpdate$0(List list, Continuation continuation) {
        return SupportContactDao.DefaultImpls.allUpdate(this, list, continuation);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object allUpdate(final List<SupportContactEntity> contacts, final Continuation<? super Unit> $completion) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$allUpdate$0;
                lambda$allUpdate$0 = SupportContactDao_Impl.this.lambda$allUpdate$0(contacts, (Continuation) obj);
                return lambda$allUpdate$0;
            }
        }, $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$updateContactsWithAuth$1(List list, Continuation continuation) {
        return SupportContactDao.DefaultImpls.updateContactsWithAuth(this, list, continuation);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object updateContactsWithAuth(final List<SupportWithAuthContactEntity> contacts, final Continuation<? super Unit> $completion) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$updateContactsWithAuth$1;
                lambda$updateContactsWithAuth$1 = SupportContactDao_Impl.this.lambda$updateContactsWithAuth$1(contacts, (Continuation) obj);
                return lambda$updateContactsWithAuth$1;
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object clear(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = SupportContactDao_Impl.this.__preparedStmtOfClear.acquire();
                try {
                    SupportContactDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        SupportContactDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        SupportContactDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    SupportContactDao_Impl.this.__preparedStmtOfClear.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object clearContactsWithAuth(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = SupportContactDao_Impl.this.__preparedStmtOfClearContactsWithAuth.acquire();
                try {
                    SupportContactDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        SupportContactDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        SupportContactDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    SupportContactDao_Impl.this.__preparedStmtOfClearContactsWithAuth.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object getContact(final Continuation<? super List<SupportContactEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM support_contacts", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<SupportContactEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.9
            @Override // java.util.concurrent.Callable
            public List<SupportContactEntity> call() throws Exception {
                Boolean valueOf;
                Cursor query = DBUtil.query(SupportContactDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "value");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        Integer valueOf2 = query.isNull(columnIndexOrThrow4) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow4));
                        if (valueOf2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                        }
                        arrayList.add(new SupportContactEntity(string, string2, string3, valueOf));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.SupportContactDao
    public Object getContactsWithAuth(final Continuation<? super List<SupportWithAuthContactEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM support_with_auth_contacts", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<SupportWithAuthContactEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<SupportWithAuthContactEntity> call() throws Exception {
                Boolean valueOf;
                Cursor query = DBUtil.query(SupportContactDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "value");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "isEnabled");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        String string = query.isNull(columnIndexOrThrow) ? null : query.getString(columnIndexOrThrow);
                        String string2 = query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2);
                        String string3 = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        Integer valueOf2 = query.isNull(columnIndexOrThrow4) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow4));
                        if (valueOf2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                        }
                        arrayList.add(new SupportWithAuthContactEntity(string, string2, string3, valueOf));
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
