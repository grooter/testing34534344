package ru.tattelecom.intercom.data.local.dao;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.StringListConverter;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.local.entity.ApartmentEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;
import ru.tattelecom.intercom.data.local.entity.CallEntity;
import ru.tattelecom.intercom.data.local.entity.CallWithIntercomAndApartment;
import ru.tattelecom.intercom.data.local.entity.CodePassLogEntity;
import ru.tattelecom.intercom.data.local.entity.CodePassLogWithIntercomAndApartment;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.data.local.entity.KeyLogEntity;
import ru.tattelecom.intercom.data.local.entity.KeyLogsWithIntercomAndApartment;

/* loaded from: classes5.dex */
public final class EventDao_Impl implements EventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<CallEntity> __insertionAdapterOfCallEntity;
    private final EntityInsertionAdapter<CodePassLogEntity> __insertionAdapterOfCodePassLogEntity;
    private final EntityInsertionAdapter<KeyLogEntity> __insertionAdapterOfKeyLogEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearCallLogs;
    private final SharedSQLiteStatement __preparedStmtOfClearKeyLogs;
    private final StringListConverter __stringListConverter = new StringListConverter();

    public EventDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfCallEntity = new EntityInsertionAdapter<CallEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `calls` (`id`,`intercomId`,`apartmentId`,`time`,`snapshot`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CallEntity entity) {
                statement.bindLong(1, entity.getId());
                statement.bindLong(2, entity.getIntercomId());
                statement.bindLong(3, entity.getApartmentId());
                statement.bindLong(4, entity.getTime());
                if (entity.getSnapshot() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getSnapshot());
                }
            }
        };
        this.__insertionAdapterOfKeyLogEntity = new EntityInsertionAdapter<KeyLogEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `key_logs` (`id`,`intercomId`,`apartmentId`,`time`,`snapshot`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final KeyLogEntity entity) {
                if (entity.getId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getId());
                }
                statement.bindLong(2, entity.getIntercomId());
                statement.bindLong(3, entity.getApartmentId());
                statement.bindLong(4, entity.getTime());
                if (entity.getSnapshot() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getSnapshot());
                }
            }
        };
        this.__insertionAdapterOfCodePassLogEntity = new EntityInsertionAdapter<CodePassLogEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `code_pass_logs` (`id`,`intercomId`,`apartmentId`,`time`,`snapshot`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final CodePassLogEntity entity) {
                if (entity.getId() == null) {
                    statement.bindNull(1);
                } else {
                    statement.bindString(1, entity.getId());
                }
                statement.bindLong(2, entity.getIntercomId());
                statement.bindLong(3, entity.getApartmentId());
                statement.bindLong(4, entity.getTime());
                if (entity.getSnapshot() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getSnapshot());
                }
            }
        };
        this.__preparedStmtOfClearCallLogs = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM calls";
            }
        };
        this.__preparedStmtOfClearKeyLogs = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM key_logs";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object addCallLog(final List<CallEntity> callLogs, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                EventDao_Impl.this.__db.beginTransaction();
                try {
                    EventDao_Impl.this.__insertionAdapterOfCallEntity.insert((Iterable) callLogs);
                    EventDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    EventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object addKeyLog(final List<KeyLogEntity> keyLogs, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                EventDao_Impl.this.__db.beginTransaction();
                try {
                    EventDao_Impl.this.__insertionAdapterOfKeyLogEntity.insert((Iterable) keyLogs);
                    EventDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    EventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object addCodePassLog(final List<CodePassLogEntity> codePassLogs, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                EventDao_Impl.this.__db.beginTransaction();
                try {
                    EventDao_Impl.this.__insertionAdapterOfCodePassLogEntity.insert((Iterable) codePassLogs);
                    EventDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    EventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$refreshCallLogs$0(List list, Continuation continuation) {
        return EventDao.DefaultImpls.refreshCallLogs(this, list, continuation);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object refreshCallLogs(final List<CallEntity> calls, final Continuation<? super Unit> $completion) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$refreshCallLogs$0;
                lambda$refreshCallLogs$0 = EventDao_Impl.this.lambda$refreshCallLogs$0(calls, (Continuation) obj);
                return lambda$refreshCallLogs$0;
            }
        }, $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$refreshKeyLogs$1(List list, Continuation continuation) {
        return EventDao.DefaultImpls.refreshKeyLogs(this, list, continuation);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object refreshKeyLogs(final List<KeyLogEntity> keyLogs, final Continuation<? super Unit> $completion) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$refreshKeyLogs$1;
                lambda$refreshKeyLogs$1 = EventDao_Impl.this.lambda$refreshKeyLogs$1(keyLogs, (Continuation) obj);
                return lambda$refreshKeyLogs$1;
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object clearCallLogs(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.9
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = EventDao_Impl.this.__preparedStmtOfClearCallLogs.acquire();
                try {
                    EventDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        EventDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        EventDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    EventDao_Impl.this.__preparedStmtOfClearCallLogs.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object clearKeyLogs(final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.10
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = EventDao_Impl.this.__preparedStmtOfClearKeyLogs.acquire();
                try {
                    EventDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        EventDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        EventDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    EventDao_Impl.this.__preparedStmtOfClearKeyLogs.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object getCallLogs(final List<Integer> ids, final Continuation<? super List<CallWithIntercomAndApartment>> $completion) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM calls WHERE id IN (");
        int size = ids.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") ORDER BY time DESC");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        Iterator<Integer> it = ids.iterator();
        int i = 1;
        while (it.hasNext()) {
            if (it.next() == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindLong(i, r3.intValue());
            }
            i++;
        }
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable<List<CallWithIntercomAndApartment>>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List<CallWithIntercomAndApartment> call() throws Exception {
                EventDao_Impl.this.__db.beginTransaction();
                try {
                    String str = null;
                    Cursor query = DBUtil.query(EventDao_Impl.this.__db, acquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_ID);
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, NavArg.VerifyCode.APARTMENT_ID);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, CrashHianalyticsData.TIME);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "snapshot");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        LongSparseArray longSparseArray3 = new LongSparseArray();
                        while (query.moveToNext()) {
                            longSparseArray.put(query.getLong(columnIndexOrThrow2), null);
                            longSparseArray2.put(query.getLong(columnIndexOrThrow3), null);
                            long j = query.getLong(columnIndexOrThrow3);
                            if (!longSparseArray3.containsKey(j)) {
                                longSparseArray3.put(j, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        EventDao_Impl.this.__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(longSparseArray);
                        EventDao_Impl.this.__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity(longSparseArray2);
                        EventDao_Impl.this.__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(longSparseArray3);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            arrayList.add(new CallWithIntercomAndApartment(new CallEntity(query.getInt(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? str : query.getString(columnIndexOrThrow5)), (IntercomEntity) longSparseArray.get(query.getLong(columnIndexOrThrow2)), (ApartmentEntity) longSparseArray2.get(query.getLong(columnIndexOrThrow3)), (ArrayList) longSparseArray3.get(query.getLong(columnIndexOrThrow3))));
                            columnIndexOrThrow2 = columnIndexOrThrow2;
                            str = null;
                        }
                        EventDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                        acquire.release();
                    }
                } finally {
                    EventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object getKeyLogs(final List<String> ids, final Continuation<? super List<KeyLogsWithIntercomAndApartment>> $completion) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM key_logs WHERE id IN (");
        int size = ids.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") ORDER BY time DESC");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : ids) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable<List<KeyLogsWithIntercomAndApartment>>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.12
            @Override // java.util.concurrent.Callable
            public List<KeyLogsWithIntercomAndApartment> call() throws Exception {
                EventDao_Impl.this.__db.beginTransaction();
                try {
                    String str2 = null;
                    Cursor query = DBUtil.query(EventDao_Impl.this.__db, acquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_ID);
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, NavArg.VerifyCode.APARTMENT_ID);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, CrashHianalyticsData.TIME);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "snapshot");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        LongSparseArray longSparseArray3 = new LongSparseArray();
                        while (query.moveToNext()) {
                            longSparseArray.put(query.getLong(columnIndexOrThrow2), null);
                            longSparseArray2.put(query.getLong(columnIndexOrThrow3), null);
                            long j = query.getLong(columnIndexOrThrow3);
                            if (!longSparseArray3.containsKey(j)) {
                                longSparseArray3.put(j, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        EventDao_Impl.this.__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(longSparseArray);
                        EventDao_Impl.this.__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity(longSparseArray2);
                        EventDao_Impl.this.__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(longSparseArray3);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            arrayList.add(new KeyLogsWithIntercomAndApartment(new KeyLogEntity(query.isNull(columnIndexOrThrow) ? str2 : query.getString(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? str2 : query.getString(columnIndexOrThrow5)), (IntercomEntity) longSparseArray.get(query.getLong(columnIndexOrThrow2)), (ApartmentEntity) longSparseArray2.get(query.getLong(columnIndexOrThrow3)), (ArrayList) longSparseArray3.get(query.getLong(columnIndexOrThrow3))));
                            columnIndexOrThrow2 = columnIndexOrThrow2;
                            str2 = null;
                        }
                        EventDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                        acquire.release();
                    }
                } finally {
                    EventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.EventDao
    public Object getCodePassLogs(final List<String> ids, final Continuation<? super List<CodePassLogWithIntercomAndApartment>> $completion) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT * FROM code_pass_logs WHERE id IN (");
        int size = ids.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(") ORDER BY time DESC");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size);
        int i = 1;
        for (String str : ids) {
            if (str == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, str);
            }
            i++;
        }
        return CoroutinesRoom.execute(this.__db, true, DBUtil.createCancellationSignal(), new Callable<List<CodePassLogWithIntercomAndApartment>>() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl.13
            @Override // java.util.concurrent.Callable
            public List<CodePassLogWithIntercomAndApartment> call() throws Exception {
                EventDao_Impl.this.__db.beginTransaction();
                try {
                    String str2 = null;
                    Cursor query = DBUtil.query(EventDao_Impl.this.__db, acquire, true, null);
                    try {
                        int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                        int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_ID);
                        int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, NavArg.VerifyCode.APARTMENT_ID);
                        int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, CrashHianalyticsData.TIME);
                        int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "snapshot");
                        LongSparseArray longSparseArray = new LongSparseArray();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        LongSparseArray longSparseArray3 = new LongSparseArray();
                        while (query.moveToNext()) {
                            longSparseArray.put(query.getLong(columnIndexOrThrow2), null);
                            longSparseArray2.put(query.getLong(columnIndexOrThrow3), null);
                            long j = query.getLong(columnIndexOrThrow3);
                            if (!longSparseArray3.containsKey(j)) {
                                longSparseArray3.put(j, new ArrayList());
                            }
                        }
                        query.moveToPosition(-1);
                        EventDao_Impl.this.__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(longSparseArray);
                        EventDao_Impl.this.__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity(longSparseArray2);
                        EventDao_Impl.this.__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(longSparseArray3);
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            arrayList.add(new CodePassLogWithIntercomAndApartment(new CodePassLogEntity(query.isNull(columnIndexOrThrow) ? str2 : query.getString(columnIndexOrThrow), query.getInt(columnIndexOrThrow2), query.getInt(columnIndexOrThrow3), query.getLong(columnIndexOrThrow4), query.isNull(columnIndexOrThrow5) ? str2 : query.getString(columnIndexOrThrow5)), (IntercomEntity) longSparseArray.get(query.getLong(columnIndexOrThrow2)), (ApartmentEntity) longSparseArray2.get(query.getLong(columnIndexOrThrow3)), (ArrayList) longSparseArray3.get(query.getLong(columnIndexOrThrow3))));
                            columnIndexOrThrow2 = columnIndexOrThrow2;
                            str2 = null;
                        }
                        EventDao_Impl.this.__db.setTransactionSuccessful();
                        return arrayList;
                    } finally {
                        query.close();
                        acquire.release();
                    }
                } finally {
                    EventDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(final LongSparseArray<IntercomEntity> _map) {
        Boolean valueOf;
        Boolean valueOf2;
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, false, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$2;
                    lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$2 = EventDao_Impl.this.lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$2((LongSparseArray) obj);
                    return lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$2;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`addressId`,`login`,`name`,`gateId`,`gateName`,`gateTypeId`,`streamUrl`,`base64Preview`,`callsMuted`,`intercomEmergencyCode`,`intercomEmergencyCodeUpdateTime`,`intercomTemporaryCode`,`isFavorite`,`isExit` FROM `intercoms` WHERE `id` IN (");
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
            int columnIndex = CursorUtil.getColumnIndex(query, TtmlNode.ATTR_ID);
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                long j = query.getLong(columnIndex);
                if (_map.containsKey(j)) {
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
                    _map.put(j, new IntercomEntity(i3, i4, string, string2, valueOf3, string3, valueOf4, string4, string5, z, valueOf5, valueOf6, valueOf7, valueOf, valueOf2));
                }
            }
        } finally {
            query.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity$2(LongSparseArray longSparseArray) {
        __fetchRelationshipintercomsAsruTattelecomIntercomDataLocalEntityIntercomEntity(longSparseArray);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity(final LongSparseArray<ApartmentEntity> _map) {
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, false, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3;
                    lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3 = EventDao_Impl.this.lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3((LongSparseArray) obj);
                    return lambda$__fetchRelationshipapartmentsAsruTattelecomIntercomDataLocalEntityApartmentEntity$3;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`buildingId`,`address`,`guestPhones`,`remainingInvites`,`intercomTemporaryCode` FROM `apartments` WHERE `id` IN (");
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
            int columnIndex = CursorUtil.getColumnIndex(query, TtmlNode.ATTR_ID);
            if (columnIndex == -1) {
                return;
            }
            while (query.moveToNext()) {
                long j = query.getLong(columnIndex);
                if (_map.containsKey(j)) {
                    _map.put(j, new ApartmentEntity(query.getInt(0), query.isNull(1) ? null : Integer.valueOf(query.getInt(1)), query.isNull(2) ? null : query.getString(2), this.__stringListConverter.toStringsList(query.isNull(3) ? null : query.getString(3)), query.isNull(4) ? null : Integer.valueOf(query.getInt(4)), query.isNull(5) ? null : Integer.valueOf(query.getInt(5))));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(final LongSparseArray<ArrayList<ApartmentServicesEntity>> _map) {
        Boolean valueOf;
        if (_map.isEmpty()) {
            return;
        }
        if (_map.size() > 999) {
            RelationUtil.recursiveFetchLongSparseArray(_map, true, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.EventDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$4;
                    lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$4 = EventDao_Impl.this.lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$4((LongSparseArray) obj);
                    return lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$4;
                }
            });
            return;
        }
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT `id`,`buildingId`,`apartmentId`,`name`,`active` FROM `apartment_services` WHERE `apartmentId` IN (");
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
            int columnIndex = CursorUtil.getColumnIndex(query, NavArg.VerifyCode.APARTMENT_ID);
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
    public /* synthetic */ Unit lambda$__fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity$4(LongSparseArray longSparseArray) {
        __fetchRelationshipapartmentServicesAsruTattelecomIntercomDataLocalEntityApartmentServicesEntity(longSparseArray);
        return Unit.INSTANCE;
    }
}
