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
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.StringListConverter;
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* loaded from: classes5.dex */
public final class ApartmentGuestsDao_Impl implements ApartmentGuestsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ApartmentGuestsEntity> __insertionAdapterOfApartmentGuestsEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final StringListConverter __stringListConverter = new StringListConverter();

    public ApartmentGuestsDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfApartmentGuestsEntity = new EntityInsertionAdapter<ApartmentGuestsEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `apartment_guests` (`id`,`address`,`guestPhones`,`remainingInvites`,`isMaster`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ApartmentGuestsEntity apartmentGuestsEntity) {
                supportSQLiteStatement.bindLong(1, apartmentGuestsEntity.getId());
                if (apartmentGuestsEntity.getAddress() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, apartmentGuestsEntity.getAddress());
                }
                String fromStringsList = ApartmentGuestsDao_Impl.this.__stringListConverter.fromStringsList(apartmentGuestsEntity.getGuestPhones());
                if (fromStringsList == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, fromStringsList);
                }
                supportSQLiteStatement.bindLong(4, apartmentGuestsEntity.getRemainingInvites());
                supportSQLiteStatement.bindLong(5, apartmentGuestsEntity.isMaster() ? 1L : 0L);
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM apartment_guests";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao
    public void add(final List<ApartmentGuestsEntity> apartments) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfApartmentGuestsEntity.insert(apartments);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao
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

    @Override // ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao
    public Flow<List<ApartmentGuestsEntity>> observeAll() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM apartment_guests", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.APARTMENT_GUESTS_TABLE}, new Callable<List<ApartmentGuestsEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao_Impl.3
            @Override // java.util.concurrent.Callable
            public List<ApartmentGuestsEntity> call() throws Exception {
                Cursor query = DBUtil.query(ApartmentGuestsDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "guestPhones");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "remainingInvites");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "isMaster");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new ApartmentGuestsEntity(query.getInt(columnIndexOrThrow), query.isNull(columnIndexOrThrow2) ? null : query.getString(columnIndexOrThrow2), ApartmentGuestsDao_Impl.this.__stringListConverter.toStringsList(query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3)), query.getInt(columnIndexOrThrow4), query.getInt(columnIndexOrThrow5) != 0));
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
