package ru.tattelecom.intercom.data.local.dao;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.StringListConverter;
import ru.tattelecom.intercom.data.local.entity.AddressEntity;
import ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams;
import ru.tattelecom.intercom.data.local.entity.ApartmentEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.data.local.entity.StreamEntity;

/* loaded from: classes5.dex */
public final class AddressDao_Impl implements AddressDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AddressEntity> __insertionAdapterOfAddressEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final StringListConverter __stringListConverter = new StringListConverter();

    public AddressDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAddressEntity = new EntityInsertionAdapter<AddressEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `addresses` (`id`,`address`) VALUES (?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final AddressEntity entity) {
                statement.bindLong(1, entity.getId());
                if (entity.getAddress() == null) {
                    statement.bindNull(2);
                } else {
                    statement.bindString(2, entity.getAddress());
                }
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM addresses";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AddressDao
    public void add(final List<AddressEntity> addresses) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAddressEntity.insert(addresses);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AddressDao
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

    @Override // ru.tattelecom.intercom.data.local.dao.AddressDao
    public Object observeAll(final Continuation<? super List<AddressWithIntercomsAndStreams>> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM addresses", 0);
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable<List<AddressWithIntercomsAndStreams>>() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.3
            /* JADX WARN: Removed duplicated region for block: B:58:0x0133  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x013f A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0156  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x0162 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:68:0x017a  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x0186 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x019e  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x01aa A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x01b5 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x01a0 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:81:0x0191 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x017c A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:83:0x016d A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:84:0x0158 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x014a A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            /* JADX WARN: Removed duplicated region for block: B:86:0x0135 A[Catch: all -> 0x01e2, TryCatch #0 {all -> 0x01e2, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #1 }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 503
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.AnonymousClass3.call():java.util.List");
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AddressDao
    public Flow<List<AddressWithIntercomsAndStreams>> getAllAsFlow() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM addresses", 0);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{EntitiesKt.INTERCOMS_TABLE, EntitiesKt.STREAM_TABLE, EntitiesKt.APARTMENT_SERVICES_TABLE, EntitiesKt.APARTMENTS_TABLE, EntitiesKt.ADDRESSES_TABLE}, new Callable<List<AddressWithIntercomsAndStreams>>() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.4
            /* JADX WARN: Removed duplicated region for block: B:58:0x0133  */
            /* JADX WARN: Removed duplicated region for block: B:60:0x013f A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:63:0x0156  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x0162 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:68:0x017a  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x0186 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x019e  */
            /* JADX WARN: Removed duplicated region for block: B:75:0x01aa A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x01b5 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x01a0 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:81:0x0191 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x017c A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:83:0x016d A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:84:0x0158 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x014a A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            /* JADX WARN: Removed duplicated region for block: B:86:0x0135 A[Catch: all -> 0x01dd, TryCatch #1 {all -> 0x01dd, blocks: (B:5:0x0019, B:6:0x0039, B:8:0x003f, B:12:0x0051, B:14:0x005b, B:15:0x0067, B:19:0x0079, B:21:0x0083, B:22:0x008f, B:26:0x00a1, B:28:0x00ab, B:29:0x00b7, B:34:0x00c9, B:37:0x00d3, B:42:0x00bf, B:43:0x0097, B:44:0x006f, B:45:0x0047, B:47:0x00e1, B:48:0x0102, B:50:0x0108, B:52:0x010e, B:56:0x012d, B:60:0x013f, B:61:0x014f, B:65:0x0162, B:66:0x0172, B:70:0x0186, B:71:0x0196, B:75:0x01aa, B:77:0x01ba, B:78:0x01b5, B:80:0x01a0, B:81:0x0191, B:82:0x017c, B:83:0x016d, B:84:0x0158, B:85:0x014a, B:86:0x0135, B:87:0x0117, B:90:0x0127, B:91:0x0123, B:93:0x01c7), top: B:4:0x0019, outer: #0 }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.List<ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 493
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.AnonymousClass4.call():java.util.List");
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AddressDao
    public Object getFirst(final Continuation<? super AddressEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM addresses LIMIT 1", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<AddressEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl.5
            @Override // java.util.concurrent.Callable
            public AddressEntity call() throws Exception {
                AddressEntity addressEntity = null;
                String string = null;
                Cursor query = DBUtil.query(AddressDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "address");
                    if (query.moveToFirst()) {
                        int i = query.getInt(columnIndexOrThrow);
                        if (!query.isNull(columnIndexOrThrow2)) {
                            string = query.getString(columnIndexOrThrow2);
                        }
                        addressEntity = new AddressEntity(i, string);
                    }
                    return addressEntity;
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

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(final LongSparseArray<ArrayList<IntercomEntity>> _map) {
        Boolean valueOf;
        Boolean valueOf2;
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, true, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$0;
                    lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$0 = AddressDao_Impl.this.lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$0((LongSparseArray) obj);
                    return lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$0;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`addressId`,`login`,`name`,`gateId`,`gateName`,`gateTypeId`,`streamUrl`,`base64Preview`,`callsMuted`,`intercomEmergencyCode`,`intercomEmergencyCodeUpdateTime`,`intercomTemporaryCode`,`isFavorite`,`isExit` FROM `intercoms` WHERE `addressId` IN (");
        int size = _map.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (int i2 = 0; i2 < _map.size(); i2++) {
            acquire.bindLong(i, _map.keyAt(i2));
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "addressId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<IntercomEntity> arrayList = _map.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    int i3 = query.getInt(0);
                    int i4 = query.getInt(1);
                    String string = query.isNull(2) ? null : query.getString(2);
                    String string2 = query.isNull(3) ? null : query.getString(3);
                    Integer valueOf3 = query.isNull(4) ? null : Integer.valueOf(query.getInt(4));
                    String string3 = query.isNull(5) ? null : query.getString(5);
                    Integer valueOf4 = query.isNull(6) ? null : Integer.valueOf(query.getInt(6));
                    String string4 = query.isNull(7) ? null : query.getString(7);
                    String string5 = query.isNull(8) ? null : query.getString(8);
                    boolean z = query.getInt(9) != 0;
                    Integer valueOf5 = query.isNull(10) ? null : Integer.valueOf(query.getInt(10));
                    Integer valueOf6 = query.isNull(11) ? null : Integer.valueOf(query.getInt(11));
                    Integer valueOf7 = query.isNull(12) ? null : Integer.valueOf(query.getInt(12));
                    Integer valueOf8 = query.isNull(13) ? null : Integer.valueOf(query.getInt(13));
                    if (valueOf8 == null) {
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(valueOf8.intValue() != 0);
                    }
                    Integer valueOf9 = query.isNull(14) ? null : Integer.valueOf(query.getInt(14));
                    if (valueOf9 == null) {
                        valueOf2 = null;
                    } else {
                        valueOf2 = Boolean.valueOf(valueOf9.intValue() != 0);
                    }
                    arrayList.add(new IntercomEntity(i3, i4, string, string2, valueOf3, string3, valueOf4, string4, string5, z, valueOf5, valueOf6, valueOf7, valueOf, valueOf2));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$0(LongSparseArray longSparseArray) {
        __fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity(final LongSparseArray<ArrayList<StreamEntity>> _map) {
        Boolean valueOf;
        Boolean valueOf2;
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, true, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity$1;
                    lambda$__fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity$1 = AddressDao_Impl.this.lambda$__fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity$1((LongSparseArray) obj);
                    return lambda$__fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity$1;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`addressId`,`name`,`liveSource`,`snapshotUrl`,`archiveSource`,`archiveExportSource`,`isFlussonic`,`isSelected`,`isFavorite` FROM `streams` WHERE `addressId` IN (");
        int size = _map.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (int i2 = 0; i2 < _map.size(); i2++) {
            acquire.bindLong(i, _map.keyAt(i2));
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, "addressId");
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<StreamEntity> arrayList = _map.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    int i3 = query.getInt(0);
                    int i4 = query.getInt(1);
                    String string = query.isNull(2) ? null : query.getString(2);
                    String string2 = query.isNull(3) ? null : query.getString(3);
                    String string3 = query.isNull(4) ? null : query.getString(4);
                    String string4 = query.isNull(5) ? null : query.getString(5);
                    String string5 = query.isNull(6) ? null : query.getString(6);
                    boolean z = query.getInt(7) != 0;
                    Integer valueOf3 = query.isNull(8) ? null : Integer.valueOf(query.getInt(8));
                    if (valueOf3 == null) {
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(valueOf3.intValue() != 0);
                    }
                    Integer valueOf4 = query.isNull(9) ? null : Integer.valueOf(query.getInt(9));
                    if (valueOf4 == null) {
                        valueOf2 = null;
                    } else {
                        valueOf2 = Boolean.valueOf(valueOf4.intValue() != 0);
                    }
                    arrayList.add(new StreamEntity(i3, i4, string, string2, string3, string4, string5, z, valueOf, valueOf2));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity$1(LongSparseArray longSparseArray) {
        __fetchRelationshipstreamsAsruTattelecomIntercomDataLocalEntityStreamEntity(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(final LongSparseArray<ArrayList<ApartmentServicesEntity>> _map) {
        Boolean valueOf;
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, true, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$2;
                    lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$2 = AddressDao_Impl.this.lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$2((LongSparseArray) obj);
                    return lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$2;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`buildingId`,`apartmentId`,`name`,`active` FROM `apartment_services` WHERE `buildingId` IN (");
        int size = _map.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (int i2 = 0; i2 < _map.size(); i2++) {
            acquire.bindLong(i, _map.keyAt(i2));
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, LogWriteConstants.BUILDING_ID);
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                ArrayList<ApartmentServicesEntity> arrayList = _map.get(query.getLong(columnIndex));
                if (arrayList != null) {
                    int i3 = query.getInt(0);
                    int i4 = query.getInt(1);
                    int i5 = query.getInt(2);
                    String string = query.isNull(3) ? null : query.getString(3);
                    Integer valueOf2 = query.isNull(4) ? null : Integer.valueOf(query.getInt(4));
                    if (valueOf2 == null) {
                        valueOf = null;
                    } else {
                        valueOf = Boolean.valueOf(valueOf2.intValue() != 0);
                    }
                    arrayList.add(new ApartmentServicesEntity(i3, i4, i5, string, valueOf));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$2(LongSparseArray longSparseArray) {
        __fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity(final LongSparseArray<ArrayList<ApartmentEntity>> _map) {
        ArrayList<ApartmentEntity> arrayList;
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, true, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.AddressDao_Impl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3;
                    lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3 = AddressDao_Impl.this.lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3((LongSparseArray) obj);
                    return lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`buildingId`,`address`,`guestPhones`,`remainingInvites`,`intercomTemporaryCode` FROM `apartments` WHERE `buildingId` IN (");
        int size = _map.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (int i2 = 0; i2 < _map.size(); i2++) {
            acquire.bindLong(i, _map.keyAt(i2));
            i++;
        }
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(query, LogWriteConstants.BUILDING_ID);
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                Long valueOf = query.isNull(columnIndex) ? null : Long.valueOf(query.getLong(columnIndex));
                if (valueOf != null && (arrayList = _map.get(valueOf.longValue())) != null) {
                    arrayList.add(new ApartmentEntity(query.getInt(0), query.isNull(1) ? null : Integer.valueOf(query.getInt(1)), query.isNull(2) ? null : query.getString(2), this.__stringListConverter.toStringsList(query.isNull(3) ? null : query.getString(3)), query.isNull(4) ? null : Integer.valueOf(query.getInt(4)), query.isNull(5) ? null : Integer.valueOf(query.getInt(5))));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3(LongSparseArray longSparseArray) {
        __fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity(longSparseArray);
        return Unit.INSTANCE;
    }
}
