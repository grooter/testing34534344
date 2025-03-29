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
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;

/* loaded from: classes5.dex */
public final class ApartmentServicesDao_Impl implements ApartmentServicesDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ApartmentServicesEntity> __insertionAdapterOfApartmentServicesEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;

    public ApartmentServicesDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfApartmentServicesEntity = new EntityInsertionAdapter<ApartmentServicesEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `apartment_services` (`id`,`buildingId`,`apartmentId`,`name`,`active`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ApartmentServicesEntity apartmentServicesEntity) {
                supportSQLiteStatement.bindLong(1, apartmentServicesEntity.getId());
                supportSQLiteStatement.bindLong(2, apartmentServicesEntity.getBuildingId());
                supportSQLiteStatement.bindLong(3, apartmentServicesEntity.getApartmentId());
                if (apartmentServicesEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, apartmentServicesEntity.getName());
                }
                if ((apartmentServicesEntity.getActive() == null ? null : Integer.valueOf(apartmentServicesEntity.getActive().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, r5.intValue());
                }
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM apartment_services";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao
    public void add(final List<ApartmentServicesEntity> apartments) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfApartmentServicesEntity.insert(apartments);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao
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

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao
    public Object getByBuildingId(final Integer buildingId, final Continuation<? super List<ApartmentServicesEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartment_services WHERE buildingId=?", 1);
        if (buildingId == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindLong(1, buildingId.intValue());
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ApartmentServicesEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao_Impl.3
            @Override // java.util.concurrent.Callable
            public List<ApartmentServicesEntity> call() throws Exception {
                Boolean valueOf;
                Cursor query = DBUtil.query(ApartmentServicesDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, LogWriteConstants.BUILDING_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, NavArg.VerifyCode.APARTMENT_ID);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i = query.getInt(columnIndexOrThrow);
                        int i2 = query.getInt(columnIndexOrThrow2);
                        int i3 = query.getInt(columnIndexOrThrow3);
                        String string = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf2 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        if (valueOf2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                        }
                        arrayList.add(new ApartmentServicesEntity(i, i2, i3, string, valueOf));
                    }
                    return arrayList;
                } finally {
                    query.close();
                    acquire.release();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao
    public Object getByApartmentId(final Integer apartmentId, final Continuation<? super List<ApartmentServicesEntity>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartment_services WHERE apartmentId=?", 1);
        if (apartmentId == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindLong(1, apartmentId.intValue());
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ApartmentServicesEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao_Impl.4
            @Override // java.util.concurrent.Callable
            public List<ApartmentServicesEntity> call() throws Exception {
                Boolean valueOf;
                Cursor query = DBUtil.query(ApartmentServicesDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, LogWriteConstants.BUILDING_ID);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, NavArg.VerifyCode.APARTMENT_ID);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i = query.getInt(columnIndexOrThrow);
                        int i2 = query.getInt(columnIndexOrThrow2);
                        int i3 = query.getInt(columnIndexOrThrow3);
                        String string = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf2 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        if (valueOf2 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                        }
                        arrayList.add(new ApartmentServicesEntity(i, i2, i3, string, valueOf));
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
