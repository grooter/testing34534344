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
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.StringListConverter;
import ru.tattelecom.intercom.data.local.entity.ApartmentEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* loaded from: classes5.dex */
public final class ApartmentDao_Impl implements ApartmentDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ApartmentEntity> __insertionAdapterOfApartmentEntity;
    private final EntityInsertionAdapter<ApartmentTemporaryCodeEntity> __insertionAdapterOfApartmentTemporaryCodeEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfClearTemporaryCodes;
    private final SharedSQLiteStatement __preparedStmtOfUpdateTemporaryCode;
    private final StringListConverter __stringListConverter = new StringListConverter();

    public ApartmentDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfApartmentEntity = new EntityInsertionAdapter<ApartmentEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `apartments` (`id`,`buildingId`,`address`,`guestPhones`,`remainingInvites`,`intercomTemporaryCode`) VALUES (?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final ApartmentEntity entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getBuildingId() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindLong(2, entity.getBuildingId().intValue());
                }
                if (entity.getAddress() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getAddress());
                }
                String fromStringsList = ApartmentDao_Impl.this.__stringListConverter.fromStringsList(entity.getGuestPhones());
                if (fromStringsList == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, fromStringsList);
                }
                if (entity.getRemainingInvites() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindLong(5, entity.getRemainingInvites().intValue());
                }
                if (entity.getIntercomTemporaryCode() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindLong(6, entity.getIntercomTemporaryCode().intValue());
                }
            }
        };
        this.__insertionAdapterOfApartmentTemporaryCodeEntity = new EntityInsertionAdapter<ApartmentTemporaryCodeEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `apartment_temporary_code` (`apartmentId`,`address`,`temporaryCode`) VALUES (?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final ApartmentTemporaryCodeEntity entity) {
                statement.bindLong(1, entity.getApartmentId());
                if (entity.getAddress() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getAddress());
                }
                if (entity.getTemporaryCode() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindLong(3, entity.getTemporaryCode().intValue());
                }
            }
        };
        this.__preparedStmtOfUpdateTemporaryCode = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE apartments SET intercomTemporaryCode=? WHERE id = ?";
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM apartments";
            }
        };
        this.__preparedStmtOfClearTemporaryCodes = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM apartment_temporary_code";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public void add(final List<ApartmentEntity> apartments) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfApartmentEntity.insert(apartments);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public void addTemporaryCodes(final List<ApartmentTemporaryCodeEntity> apartmentCodes) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfApartmentTemporaryCodeEntity.insert(apartmentCodes);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public Object addTemporaryCode(final ApartmentTemporaryCodeEntity apartmentCode, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                ApartmentDao_Impl.this.__db.beginTransaction();
                try {
                    ApartmentDao_Impl.this.__insertionAdapterOfApartmentTemporaryCodeEntity.insert((EntityInsertionAdapter) apartmentCode);
                    ApartmentDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    ApartmentDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public Object updateTemporaryCode(final int id, final Integer intercomTemporaryCode, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = ApartmentDao_Impl.this.__preparedStmtOfUpdateTemporaryCode.acquire();
                if (intercomTemporaryCode == null) {
                    acquire.bindNull(1);
                } else {
                    acquire.bindLong(1, r1.intValue());
                }
                acquire.bindLong(2, id);
                try {
                    ApartmentDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        ApartmentDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        ApartmentDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    ApartmentDao_Impl.this.__preparedStmtOfUpdateTemporaryCode.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
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

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public void clearTemporaryCodes() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearTemporaryCodes.acquire();
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfClearTemporaryCodes.release(acquire);
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public Flow<List<ApartmentEntity>> observeAll() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartments", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.APARTMENTS_TABLE}, new Callable<List<ApartmentEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.8
            @Override // java.util.concurrent.Callable
            public List<ApartmentEntity> call() throws Exception {
                Cursor query = DBUtil.query(ApartmentDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, LogWriteConstants.BUILDING_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "guestPhones");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "remainingInvites");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new ApartmentEntity(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow2)), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), ApartmentDao_Impl.this.__stringListConverter.toStringsList(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5)), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6))));
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

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public Object getAll(final Continuation<? super List<ApartmentEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartments", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ApartmentEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.9
            @Override // java.util.concurrent.Callable
            public List<ApartmentEntity> call() throws Exception {
                Cursor query = DBUtil.query(ApartmentDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, LogWriteConstants.BUILDING_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "guestPhones");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "remainingInvites");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new ApartmentEntity(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow2)), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), ApartmentDao_Impl.this.__stringListConverter.toStringsList(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5)), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6))));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public Object observeAllTemporaryCodes(final Continuation<? super List<ApartmentTemporaryCodeEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartment_temporary_code", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ApartmentTemporaryCodeEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<ApartmentTemporaryCodeEntity> call() throws Exception {
                Cursor query = DBUtil.query(ApartmentDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, NavArg.VerifyCode.APARTMENT_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "temporaryCode");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new ApartmentTemporaryCodeEntity(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), query.isNull(columnIndexOrThrow3) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow3))));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentDao
    public Object getApartmentsById(final Integer apartmentId, final Continuation<? super ApartmentEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartments WHERE id=?", 1);
        if (apartmentId == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindLong(1, apartmentId.intValue());
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<ApartmentEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl.11
            @Override // java.util.concurrent.Callable
            public ApartmentEntity call() throws Exception {
                ApartmentEntity apartmentEntity = null;
                Cursor query = DBUtil.query(ApartmentDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, LogWriteConstants.BUILDING_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "guestPhones");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "remainingInvites");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    if (query.moveToFirst()) {
                        apartmentEntity = new ApartmentEntity(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow2)), query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3), ApartmentDao_Impl.this.__stringListConverter.toStringsList(query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4)), query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5)), query.isNull(columnIndexOrThrow6) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow6)));
                    }
                    return apartmentEntity;
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
