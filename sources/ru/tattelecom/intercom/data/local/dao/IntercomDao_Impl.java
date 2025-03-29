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
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* loaded from: classes5.dex */
public final class IntercomDao_Impl implements IntercomDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<IntercomEntity> __insertionAdapterOfIntercomEntity;
    private final SharedSQLiteStatement __preparedStmtOfClear;
    private final SharedSQLiteStatement __preparedStmtOfSetCalls;
    private final SharedSQLiteStatement __preparedStmtOfSetFavoriteStatus;

    public IntercomDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfIntercomEntity = new EntityInsertionAdapter<IntercomEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `intercoms` (`id`,`addressId`,`login`,`name`,`gateId`,`gateName`,`gateTypeId`,`streamUrl`,`base64Preview`,`callsMuted`,`intercomEmergencyCode`,`intercomEmergencyCodeUpdateTime`,`intercomTemporaryCode`,`isFavorite`,`isExit`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, IntercomEntity intercomEntity) {
                supportSQLiteStatement.bindLong(1, intercomEntity.getId());
                supportSQLiteStatement.bindLong(2, intercomEntity.getAddressId());
                if (intercomEntity.getLogin() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, intercomEntity.getLogin());
                }
                if (intercomEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, intercomEntity.getName());
                }
                if (intercomEntity.getGateId() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, intercomEntity.getGateId().intValue());
                }
                if (intercomEntity.getGateName() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, intercomEntity.getGateName());
                }
                if (intercomEntity.getGateTypeId() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, intercomEntity.getGateTypeId().intValue());
                }
                if (intercomEntity.getStreamUrl() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, intercomEntity.getStreamUrl());
                }
                if (intercomEntity.getBase64Preview() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, intercomEntity.getBase64Preview());
                }
                supportSQLiteStatement.bindLong(10, intercomEntity.getCallsMuted() ? 1L : 0L);
                if (intercomEntity.getIntercomEmergencyCode() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, intercomEntity.getIntercomEmergencyCode().intValue());
                }
                if (intercomEntity.getIntercomEmergencyCodeUpdateTime() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, intercomEntity.getIntercomEmergencyCodeUpdateTime().intValue());
                }
                if (intercomEntity.getIntercomTemporaryCode() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindLong(13, intercomEntity.getIntercomTemporaryCode().intValue());
                }
                if ((intercomEntity.isFavorite() == null ? null : Integer.valueOf(intercomEntity.isFavorite().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindLong(14, r0.intValue());
                }
                if ((intercomEntity.isExit() != null ? Integer.valueOf(intercomEntity.isExit().booleanValue() ? 1 : 0) : null) == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindLong(15, r1.intValue());
                }
            }
        };
        this.__preparedStmtOfSetCalls = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE intercoms SET callsMuted = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfSetFavoriteStatus = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE intercoms SET isFavorite = ? WHERE gateId = ?";
            }
        };
        this.__preparedStmtOfClear = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM intercoms";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public void add(final List<IntercomEntity> intercoms) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfIntercomEntity.insert(intercoms);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Object setCalls(final int intercomId, final boolean muted, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = IntercomDao_Impl.this.__preparedStmtOfSetCalls.acquire();
                acquire.bindLong(1, muted ? 1L : 0L);
                acquire.bindLong(2, intercomId);
                try {
                    IntercomDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        IntercomDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        IntercomDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    IntercomDao_Impl.this.__preparedStmtOfSetCalls.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Object setFavoriteStatus(final int gateId, final boolean isFavorite, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement acquire = IntercomDao_Impl.this.__preparedStmtOfSetFavoriteStatus.acquire();
                acquire.bindLong(1, isFavorite ? 1L : 0L);
                acquire.bindLong(2, gateId);
                try {
                    IntercomDao_Impl.this.__db.beginTransaction();
                    try {
                        acquire.executeUpdateDelete();
                        IntercomDao_Impl.this.__db.setTransactionSuccessful();
                        return Unit.INSTANCE;
                    } finally {
                        IntercomDao_Impl.this.__db.endTransaction();
                    }
                } finally {
                    IntercomDao_Impl.this.__preparedStmtOfSetFavoriteStatus.release(acquire);
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
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

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Flow<List<IntercomEntity>> observeAll() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM intercoms", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.INTERCOMS_TABLE}, new Callable<List<IntercomEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.7
            @Override // java.util.concurrent.Callable
            public List<IntercomEntity> call() throws Exception {
                Integer valueOf;
                int i;
                Boolean valueOf2;
                Boolean valueOf3;
                int i2;
                Cursor query = DBUtil.query(IntercomDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "addressId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Event.LOGIN);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gateName");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "gateTypeId");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, VideoPlayerViewModel.STREAM_URL);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "base64Preview");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "callsMuted");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_EMERGENCY_CODE);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "intercomEmergencyCodeUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isFavorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "isExit");
                    int i3 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        int i4 = query.getInt(columnIndexOrThrow);
                        int i5 = query.getInt(columnIndexOrThrow2);
                        String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf4 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        String string3 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        Integer valueOf5 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        String string4 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string5 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        boolean z = true;
                        boolean z2 = query.getInt(columnIndexOrThrow10) != 0;
                        Integer valueOf6 = query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11));
                        Integer valueOf7 = query.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow12));
                        if (query.isNull(columnIndexOrThrow13)) {
                            i = i3;
                            valueOf = null;
                        } else {
                            valueOf = Integer.valueOf(query.getInt(columnIndexOrThrow13));
                            i = i3;
                        }
                        Integer valueOf8 = query.isNull(i) ? null : Integer.valueOf(query.getInt(i));
                        if (valueOf8 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Boolean.valueOf(valueOf8.intValue() != 0);
                        }
                        int i6 = columnIndexOrThrow15;
                        int i7 = columnIndexOrThrow;
                        Integer valueOf9 = query.isNull(i6) ? null : Integer.valueOf(query.getInt(i6));
                        if (valueOf9 == null) {
                            i2 = i6;
                            valueOf3 = null;
                        } else {
                            if (valueOf9.intValue() == 0) {
                                z = false;
                            }
                            valueOf3 = Boolean.valueOf(z);
                            i2 = i6;
                        }
                        arrayList.add(new IntercomEntity(i4, i5, string, string2, valueOf4, string3, valueOf5, string4, string5, z2, valueOf6, valueOf7, valueOf, valueOf2, valueOf3));
                        columnIndexOrThrow = i7;
                        columnIndexOrThrow15 = i2;
                        i3 = i;
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

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Flow<IntercomEntity> observe(final String login) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM intercoms WHERE login=?", 1);
        if (login == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, login);
        }
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.INTERCOMS_TABLE}, new Callable<IntercomEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.8
            @Override // java.util.concurrent.Callable
            public IntercomEntity call() throws Exception {
                IntercomEntity intercomEntity;
                Boolean valueOf;
                Boolean valueOf2;
                Cursor query = DBUtil.query(IntercomDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "addressId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Event.LOGIN);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gateName");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "gateTypeId");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, VideoPlayerViewModel.STREAM_URL);
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "base64Preview");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "callsMuted");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_EMERGENCY_CODE);
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "intercomEmergencyCodeUpdateTime");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isFavorite");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "isExit");
                    if (query.moveToFirst()) {
                        int i = query.getInt(columnIndexOrThrow);
                        int i2 = query.getInt(columnIndexOrThrow2);
                        String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf3 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        String string3 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        Integer valueOf4 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        String string4 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string5 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        boolean z = query.getInt(columnIndexOrThrow10) != 0;
                        Integer valueOf5 = query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11));
                        Integer valueOf6 = query.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow12));
                        Integer valueOf7 = query.isNull(columnIndexOrThrow13) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow13));
                        Integer valueOf8 = query.isNull(columnIndexOrThrow14) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow14));
                        if (valueOf8 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf8.intValue() != 0);
                        }
                        Integer valueOf9 = query.isNull(columnIndexOrThrow15) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow15));
                        if (valueOf9 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Boolean.valueOf(valueOf9.intValue() != 0);
                        }
                        intercomEntity = new IntercomEntity(i, i2, string, string2, valueOf3, string3, valueOf4, string4, string5, z, valueOf5, valueOf6, valueOf7, valueOf, valueOf2);
                    } else {
                        intercomEntity = null;
                    }
                    return intercomEntity;
                } finally {
                    query.close();
                }
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Object getByLogin(final String login, final Continuation<? super IntercomEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM intercoms WHERE login=?", 1);
        if (login == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, login);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<IntercomEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.9
            @Override // java.util.concurrent.Callable
            public IntercomEntity call() throws Exception {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                IntercomEntity intercomEntity;
                Boolean valueOf;
                Boolean valueOf2;
                AnonymousClass9 anonymousClass9 = this;
                Cursor query = DBUtil.query(IntercomDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "addressId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Event.LOGIN);
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gateName");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "gateTypeId");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, VideoPlayerViewModel.STREAM_URL);
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "base64Preview");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "callsMuted");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_EMERGENCY_CODE);
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "intercomEmergencyCodeUpdateTime");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isFavorite");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "isExit");
                    if (query.moveToFirst()) {
                        int i = query.getInt(columnIndexOrThrow);
                        int i2 = query.getInt(columnIndexOrThrow2);
                        String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf3 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        String string3 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        Integer valueOf4 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        String string4 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string5 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        boolean z = query.getInt(columnIndexOrThrow10) != 0;
                        Integer valueOf5 = query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11));
                        Integer valueOf6 = query.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow12));
                        Integer valueOf7 = query.isNull(columnIndexOrThrow13) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow13));
                        Integer valueOf8 = query.isNull(columnIndexOrThrow14) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow14));
                        if (valueOf8 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf8.intValue() != 0);
                        }
                        Integer valueOf9 = query.isNull(columnIndexOrThrow15) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow15));
                        if (valueOf9 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Boolean.valueOf(valueOf9.intValue() != 0);
                        }
                        intercomEntity = new IntercomEntity(i, i2, string, string2, valueOf3, string3, valueOf4, string4, string5, z, valueOf5, valueOf6, valueOf7, valueOf, valueOf2);
                    } else {
                        intercomEntity = null;
                    }
                    query.close();
                    acquire.release();
                    return intercomEntity;
                } catch (Throwable th2) {
                    th = th2;
                    anonymousClass9 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Object getById(final int id, final Continuation<? super IntercomEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM intercoms WHERE id = ?", 1);
        acquire.bindLong(1, id);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<IntercomEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.10
            @Override // java.util.concurrent.Callable
            public IntercomEntity call() throws Exception {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                IntercomEntity intercomEntity;
                Boolean valueOf;
                Boolean valueOf2;
                AnonymousClass10 anonymousClass10 = this;
                Cursor query = DBUtil.query(IntercomDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "addressId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Event.LOGIN);
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gateName");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "gateTypeId");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, VideoPlayerViewModel.STREAM_URL);
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "base64Preview");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "callsMuted");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_EMERGENCY_CODE);
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "intercomEmergencyCodeUpdateTime");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isFavorite");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "isExit");
                    if (query.moveToFirst()) {
                        int i = query.getInt(columnIndexOrThrow);
                        int i2 = query.getInt(columnIndexOrThrow2);
                        String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf3 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        String string3 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        Integer valueOf4 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        String string4 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string5 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        boolean z = query.getInt(columnIndexOrThrow10) != 0;
                        Integer valueOf5 = query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11));
                        Integer valueOf6 = query.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow12));
                        Integer valueOf7 = query.isNull(columnIndexOrThrow13) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow13));
                        Integer valueOf8 = query.isNull(columnIndexOrThrow14) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow14));
                        if (valueOf8 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf8.intValue() != 0);
                        }
                        Integer valueOf9 = query.isNull(columnIndexOrThrow15) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow15));
                        if (valueOf9 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Boolean.valueOf(valueOf9.intValue() != 0);
                        }
                        intercomEntity = new IntercomEntity(i, i2, string, string2, valueOf3, string3, valueOf4, string4, string5, z, valueOf5, valueOf6, valueOf7, valueOf, valueOf2);
                    } else {
                        intercomEntity = null;
                    }
                    query.close();
                    acquire.release();
                    return intercomEntity;
                } catch (Throwable th2) {
                    th = th2;
                    anonymousClass10 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.IntercomDao
    public Object getByGateId(final int gateId, final Continuation<? super IntercomEntity> $completion) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM intercoms WHERE gateId = ?", 1);
        acquire.bindLong(1, gateId);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<IntercomEntity>() { // from class: ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl.11
            @Override // java.util.concurrent.Callable
            public IntercomEntity call() throws Exception {
                int columnIndexOrThrow;
                int columnIndexOrThrow2;
                int columnIndexOrThrow3;
                int columnIndexOrThrow4;
                int columnIndexOrThrow5;
                int columnIndexOrThrow6;
                int columnIndexOrThrow7;
                int columnIndexOrThrow8;
                int columnIndexOrThrow9;
                int columnIndexOrThrow10;
                int columnIndexOrThrow11;
                int columnIndexOrThrow12;
                int columnIndexOrThrow13;
                int columnIndexOrThrow14;
                IntercomEntity intercomEntity;
                Boolean valueOf;
                Boolean valueOf2;
                AnonymousClass11 anonymousClass11 = this;
                Cursor query = DBUtil.query(IntercomDao_Impl.this.__db, acquire, false, null);
                try {
                    columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, TtmlNode.ATTR_ID);
                    columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "addressId");
                    columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Event.LOGIN);
                    columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "gateId");
                    columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "gateName");
                    columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "gateTypeId");
                    columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, VideoPlayerViewModel.STREAM_URL);
                    columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "base64Preview");
                    columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "callsMuted");
                    columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, NavArg.INTERCOM_EMERGENCY_CODE);
                    columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "intercomEmergencyCodeUpdateTime");
                    columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "intercomTemporaryCode");
                    columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "isFavorite");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "isExit");
                    if (query.moveToFirst()) {
                        int i = query.getInt(columnIndexOrThrow);
                        int i2 = query.getInt(columnIndexOrThrow2);
                        String string = query.isNull(columnIndexOrThrow3) ? null : query.getString(columnIndexOrThrow3);
                        String string2 = query.isNull(columnIndexOrThrow4) ? null : query.getString(columnIndexOrThrow4);
                        Integer valueOf3 = query.isNull(columnIndexOrThrow5) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow5));
                        String string3 = query.isNull(columnIndexOrThrow6) ? null : query.getString(columnIndexOrThrow6);
                        Integer valueOf4 = query.isNull(columnIndexOrThrow7) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow7));
                        String string4 = query.isNull(columnIndexOrThrow8) ? null : query.getString(columnIndexOrThrow8);
                        String string5 = query.isNull(columnIndexOrThrow9) ? null : query.getString(columnIndexOrThrow9);
                        boolean z = query.getInt(columnIndexOrThrow10) != 0;
                        Integer valueOf5 = query.isNull(columnIndexOrThrow11) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow11));
                        Integer valueOf6 = query.isNull(columnIndexOrThrow12) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow12));
                        Integer valueOf7 = query.isNull(columnIndexOrThrow13) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow13));
                        Integer valueOf8 = query.isNull(columnIndexOrThrow14) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow14));
                        if (valueOf8 == null) {
                            valueOf = null;
                        } else {
                            valueOf = Boolean.valueOf(valueOf8.intValue() != 0);
                        }
                        Integer valueOf9 = query.isNull(columnIndexOrThrow15) ? null : Integer.valueOf(query.getInt(columnIndexOrThrow15));
                        if (valueOf9 == null) {
                            valueOf2 = null;
                        } else {
                            valueOf2 = Boolean.valueOf(valueOf9.intValue() != 0);
                        }
                        intercomEntity = new IntercomEntity(i, i2, string, string2, valueOf3, string3, valueOf4, string4, string5, z, valueOf5, valueOf6, valueOf7, valueOf, valueOf2);
                    } else {
                        intercomEntity = null;
                    }
                    query.close();
                    acquire.release();
                    return intercomEntity;
                } catch (Throwable th2) {
                    th = th2;
                    anonymousClass11 = this;
                    query.close();
                    acquire.release();
                    throw th;
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
