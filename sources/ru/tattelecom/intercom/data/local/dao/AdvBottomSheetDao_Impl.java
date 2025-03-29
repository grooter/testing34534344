package ru.tattelecom.intercom.data.local.dao;

import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.IntListConverter;
import ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* loaded from: classes5.dex */
public final class AdvBottomSheetDao_Impl implements AdvBottomSheetDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AdvBottomSheetDesignEntity> __insertionAdapterOfAdvBottomSheetDesignEntity;
    private final EntityInsertionAdapter<AdvBottomSheetEntity> __insertionAdapterOfAdvBottomSheetEntity;
    private final IntListConverter __intListConverter = new IntListConverter();
    private final SharedSQLiteStatement __preparedStmtOfClearAdvBottomSheet;
    private final SharedSQLiteStatement __preparedStmtOfClearAdvBottomSheetDesign;

    public AdvBottomSheetDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfAdvBottomSheetEntity = new EntityInsertionAdapter<AdvBottomSheetEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `adv_bottom_sheet` (`id`,`isRead`,`endDate`,`title`,`description`,`buttonText`,`type`,`typeDataUrl`,`typeDataScreen`,`typeDataSelectedServices`,`titleAlign`,`descriptionAlign`,`image`,`icon`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, AdvBottomSheetEntity advBottomSheetEntity) {
                supportSQLiteStatement.bindLong(1, advBottomSheetEntity.getId());
                supportSQLiteStatement.bindLong(2, advBottomSheetEntity.isRead() ? 1L : 0L);
                supportSQLiteStatement.bindLong(3, advBottomSheetEntity.getEndDate());
                if (advBottomSheetEntity.getTitle() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, advBottomSheetEntity.getTitle());
                }
                if (advBottomSheetEntity.getDescription() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, advBottomSheetEntity.getDescription());
                }
                if (advBottomSheetEntity.getButtonText() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, advBottomSheetEntity.getButtonText());
                }
                if (advBottomSheetEntity.getType() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, advBottomSheetEntity.getType());
                }
                if (advBottomSheetEntity.getTypeDataUrl() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, advBottomSheetEntity.getTypeDataUrl());
                }
                if (advBottomSheetEntity.getTypeDataScreen() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, advBottomSheetEntity.getTypeDataScreen());
                }
                String fromIntList = AdvBottomSheetDao_Impl.this.__intListConverter.fromIntList(advBottomSheetEntity.getTypeDataSelectedServices());
                if (fromIntList == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, fromIntList);
                }
                if (advBottomSheetEntity.getTitleAlign() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, advBottomSheetEntity.getTitleAlign());
                }
                if (advBottomSheetEntity.getDescriptionAlign() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, advBottomSheetEntity.getDescriptionAlign());
                }
                if (advBottomSheetEntity.getImage() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, advBottomSheetEntity.getImage());
                }
                if (advBottomSheetEntity.getIcon() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, advBottomSheetEntity.getIcon());
                }
            }
        };
        this.__insertionAdapterOfAdvBottomSheetDesignEntity = new EntityInsertionAdapter<AdvBottomSheetDesignEntity>(__db) { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `adv_bottom_sheet_design` (`advBottomSheetId`,`theme`,`backgroundColor`,`buttonTextColor`,`titleColor`,`descriptionColor`,`buttonBackgroundColor`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final AdvBottomSheetDesignEntity entity) {
                statement.bindLong(1, entity.getAdvBottomSheetId());
                statement.bindString(2, AdvBottomSheetDao_Impl.this.__AdvBottomSheetDesignTheme_enumToString(entity.getTheme()));
                if (entity.getBackgroundColor() == null) {
                    statement.bindNull(3);
                } else {
                    statement.bindString(3, entity.getBackgroundColor());
                }
                if (entity.getButtonTextColor() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getButtonTextColor());
                }
                if (entity.getTitleColor() == null) {
                    statement.bindNull(5);
                } else {
                    statement.bindString(5, entity.getTitleColor());
                }
                if (entity.getDescriptionColor() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getDescriptionColor());
                }
                if (entity.getButtonBackgroundColor() == null) {
                    statement.bindNull(7);
                } else {
                    statement.bindString(7, entity.getButtonBackgroundColor());
                }
            }
        };
        this.__preparedStmtOfClearAdvBottomSheet = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM adv_bottom_sheet";
            }
        };
        this.__preparedStmtOfClearAdvBottomSheetDesign = new SharedSQLiteStatement(__db) { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM adv_bottom_sheet_design";
            }
        };
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao
    public Object insertAdvBottomSheet(final AdvBottomSheetEntity entity, final Continuation<? super Long> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                AdvBottomSheetDao_Impl.this.__db.beginTransaction();
                try {
                    Long valueOf = Long.valueOf(AdvBottomSheetDao_Impl.this.__insertionAdapterOfAdvBottomSheetEntity.insertAndReturnId(entity));
                    AdvBottomSheetDao_Impl.this.__db.setTransactionSuccessful();
                    return valueOf;
                } finally {
                    AdvBottomSheetDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao
    public Object insertAdvBottomSheetDesign(final AdvBottomSheetDesignEntity entity, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                AdvBottomSheetDao_Impl.this.__db.beginTransaction();
                try {
                    AdvBottomSheetDao_Impl.this.__insertionAdapterOfAdvBottomSheetDesignEntity.insert((EntityInsertionAdapter) entity);
                    AdvBottomSheetDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    AdvBottomSheetDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$createAdvBottomSheetWithDesign$0(AdvBottomSheetEntity advBottomSheetEntity, List list, Continuation continuation) {
        return AdvBottomSheetDao.DefaultImpls.createAdvBottomSheetWithDesign(this, advBottomSheetEntity, list, continuation);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao
    public Object createAdvBottomSheetWithDesign(final AdvBottomSheetEntity adv, final List<AdvThemeDto> design, final Continuation<? super Unit> $completion) {
        return RoomDatabaseKt.withTransaction(this.__db, new Function1() { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Object lambda$createAdvBottomSheetWithDesign$0;
                lambda$createAdvBottomSheetWithDesign$0 = AdvBottomSheetDao_Impl.this.lambda$createAdvBottomSheetWithDesign$0(adv, design, (Continuation) obj);
                return lambda$createAdvBottomSheetWithDesign$0;
            }
        }, $completion);
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao
    public void clearAdvBottomSheet() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearAdvBottomSheet.acquire();
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfClearAdvBottomSheet.release(acquire);
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao
    public void clearAdvBottomSheetDesign() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearAdvBottomSheetDesign.acquire();
        try {
            this.__db.beginTransaction();
            try {
                acquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfClearAdvBottomSheetDesign.release(acquire);
        }
    }

    @Override // ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao
    public Flow<Map<AdvBottomSheetEntity, AdvBottomSheetDesignEntity>> getAdvBottomSheet(final long date, final AdvBottomSheetDesignTheme theme) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM adv_bottom_sheet LEFT JOIN  adv_bottom_sheet_design design ON adv_bottom_sheet.id = design.advBottomSheetId WHERE  adv_bottom_sheet.endDate >= ? AND design.theme = ?", 2);
        acquire.bindLong(1, date);
        acquire.bindString(2, __AdvBottomSheetDesignTheme_enumToString(theme));
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{EntitiesKt.ADV_BOTTOM_SHEET, EntitiesKt.ADV_BOTTOM_SHEET_DESIGN}, new Callable<Map<AdvBottomSheetEntity, AdvBottomSheetDesignEntity>>() { // from class: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.7
            /* JADX WARN: Removed duplicated region for block: B:59:0x021e  */
            /* JADX WARN: Removed duplicated region for block: B:62:0x022d  */
            /* JADX WARN: Removed duplicated region for block: B:65:0x023c  */
            /* JADX WARN: Removed duplicated region for block: B:68:0x024b  */
            /* JADX WARN: Removed duplicated region for block: B:71:0x025a  */
            /* JADX WARN: Removed duplicated region for block: B:74:0x0270 A[Catch: all -> 0x0299, TRY_LEAVE, TryCatch #0 {all -> 0x0299, blocks: (B:3:0x0010, B:4:0x00a3, B:6:0x00a9, B:9:0x00ba, B:12:0x00cd, B:15:0x00dc, B:18:0x00eb, B:21:0x00fa, B:24:0x0109, B:27:0x0118, B:30:0x012e, B:33:0x0147, B:36:0x0156, B:39:0x0169, B:42:0x0178, B:44:0x0189, B:46:0x0193, B:48:0x019d, B:50:0x01a7, B:52:0x01b1, B:54:0x01bb, B:84:0x01c5, B:57:0x0205, B:60:0x0227, B:63:0x0236, B:66:0x0245, B:69:0x0254, B:72:0x0263, B:74:0x0270, B:78:0x025d, B:79:0x024e, B:80:0x023f, B:81:0x0230, B:82:0x0221, B:98:0x0172, B:99:0x0161, B:100:0x0150, B:101:0x0141, B:102:0x0124, B:103:0x0112, B:104:0x0103, B:105:0x00f4, B:106:0x00e5, B:107:0x00d6, B:108:0x00c7), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x025d A[Catch: all -> 0x0299, TryCatch #0 {all -> 0x0299, blocks: (B:3:0x0010, B:4:0x00a3, B:6:0x00a9, B:9:0x00ba, B:12:0x00cd, B:15:0x00dc, B:18:0x00eb, B:21:0x00fa, B:24:0x0109, B:27:0x0118, B:30:0x012e, B:33:0x0147, B:36:0x0156, B:39:0x0169, B:42:0x0178, B:44:0x0189, B:46:0x0193, B:48:0x019d, B:50:0x01a7, B:52:0x01b1, B:54:0x01bb, B:84:0x01c5, B:57:0x0205, B:60:0x0227, B:63:0x0236, B:66:0x0245, B:69:0x0254, B:72:0x0263, B:74:0x0270, B:78:0x025d, B:79:0x024e, B:80:0x023f, B:81:0x0230, B:82:0x0221, B:98:0x0172, B:99:0x0161, B:100:0x0150, B:101:0x0141, B:102:0x0124, B:103:0x0112, B:104:0x0103, B:105:0x00f4, B:106:0x00e5, B:107:0x00d6, B:108:0x00c7), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:79:0x024e A[Catch: all -> 0x0299, TryCatch #0 {all -> 0x0299, blocks: (B:3:0x0010, B:4:0x00a3, B:6:0x00a9, B:9:0x00ba, B:12:0x00cd, B:15:0x00dc, B:18:0x00eb, B:21:0x00fa, B:24:0x0109, B:27:0x0118, B:30:0x012e, B:33:0x0147, B:36:0x0156, B:39:0x0169, B:42:0x0178, B:44:0x0189, B:46:0x0193, B:48:0x019d, B:50:0x01a7, B:52:0x01b1, B:54:0x01bb, B:84:0x01c5, B:57:0x0205, B:60:0x0227, B:63:0x0236, B:66:0x0245, B:69:0x0254, B:72:0x0263, B:74:0x0270, B:78:0x025d, B:79:0x024e, B:80:0x023f, B:81:0x0230, B:82:0x0221, B:98:0x0172, B:99:0x0161, B:100:0x0150, B:101:0x0141, B:102:0x0124, B:103:0x0112, B:104:0x0103, B:105:0x00f4, B:106:0x00e5, B:107:0x00d6, B:108:0x00c7), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x023f A[Catch: all -> 0x0299, TryCatch #0 {all -> 0x0299, blocks: (B:3:0x0010, B:4:0x00a3, B:6:0x00a9, B:9:0x00ba, B:12:0x00cd, B:15:0x00dc, B:18:0x00eb, B:21:0x00fa, B:24:0x0109, B:27:0x0118, B:30:0x012e, B:33:0x0147, B:36:0x0156, B:39:0x0169, B:42:0x0178, B:44:0x0189, B:46:0x0193, B:48:0x019d, B:50:0x01a7, B:52:0x01b1, B:54:0x01bb, B:84:0x01c5, B:57:0x0205, B:60:0x0227, B:63:0x0236, B:66:0x0245, B:69:0x0254, B:72:0x0263, B:74:0x0270, B:78:0x025d, B:79:0x024e, B:80:0x023f, B:81:0x0230, B:82:0x0221, B:98:0x0172, B:99:0x0161, B:100:0x0150, B:101:0x0141, B:102:0x0124, B:103:0x0112, B:104:0x0103, B:105:0x00f4, B:106:0x00e5, B:107:0x00d6, B:108:0x00c7), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:81:0x0230 A[Catch: all -> 0x0299, TryCatch #0 {all -> 0x0299, blocks: (B:3:0x0010, B:4:0x00a3, B:6:0x00a9, B:9:0x00ba, B:12:0x00cd, B:15:0x00dc, B:18:0x00eb, B:21:0x00fa, B:24:0x0109, B:27:0x0118, B:30:0x012e, B:33:0x0147, B:36:0x0156, B:39:0x0169, B:42:0x0178, B:44:0x0189, B:46:0x0193, B:48:0x019d, B:50:0x01a7, B:52:0x01b1, B:54:0x01bb, B:84:0x01c5, B:57:0x0205, B:60:0x0227, B:63:0x0236, B:66:0x0245, B:69:0x0254, B:72:0x0263, B:74:0x0270, B:78:0x025d, B:79:0x024e, B:80:0x023f, B:81:0x0230, B:82:0x0221, B:98:0x0172, B:99:0x0161, B:100:0x0150, B:101:0x0141, B:102:0x0124, B:103:0x0112, B:104:0x0103, B:105:0x00f4, B:106:0x00e5, B:107:0x00d6, B:108:0x00c7), top: B:2:0x0010 }] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x0221 A[Catch: all -> 0x0299, TryCatch #0 {all -> 0x0299, blocks: (B:3:0x0010, B:4:0x00a3, B:6:0x00a9, B:9:0x00ba, B:12:0x00cd, B:15:0x00dc, B:18:0x00eb, B:21:0x00fa, B:24:0x0109, B:27:0x0118, B:30:0x012e, B:33:0x0147, B:36:0x0156, B:39:0x0169, B:42:0x0178, B:44:0x0189, B:46:0x0193, B:48:0x019d, B:50:0x01a7, B:52:0x01b1, B:54:0x01bb, B:84:0x01c5, B:57:0x0205, B:60:0x0227, B:63:0x0236, B:66:0x0245, B:69:0x0254, B:72:0x0263, B:74:0x0270, B:78:0x025d, B:79:0x024e, B:80:0x023f, B:81:0x0230, B:82:0x0221, B:98:0x0172, B:99:0x0161, B:100:0x0150, B:101:0x0141, B:102:0x0124, B:103:0x0112, B:104:0x0103, B:105:0x00f4, B:106:0x00e5, B:107:0x00d6, B:108:0x00c7), top: B:2:0x0010 }] */
            @Override // java.util.concurrent.Callable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.Map<ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity, ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity> call() throws java.lang.Exception {
                /*
                    Method dump skipped, instructions count: 670
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl.AnonymousClass7.call():java.util.Map");
            }

            protected void finalize() {
                acquire.release();
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* renamed from: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl$8, reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$ru$tattelecom$intercom$data$local$entity$AdvBottomSheetDesignTheme;

        static {
            int[] iArr = new int[AdvBottomSheetDesignTheme.values().length];
            $SwitchMap$ru$tattelecom$intercom$data$local$entity$AdvBottomSheetDesignTheme = iArr;
            try {
                iArr[AdvBottomSheetDesignTheme.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ru$tattelecom$intercom$data$local$entity$AdvBottomSheetDesignTheme[AdvBottomSheetDesignTheme.DARK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String __AdvBottomSheetDesignTheme_enumToString(final AdvBottomSheetDesignTheme _value) {
        int i = AnonymousClass8.$SwitchMap$ru$tattelecom$intercom$data$local$entity$AdvBottomSheetDesignTheme[_value.ordinal()];
        if (i == 1) {
            return "LIGHT";
        }
        if (i == 2) {
            return "DARK";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + _value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdvBottomSheetDesignTheme __AdvBottomSheetDesignTheme_stringToEnum(final String _value) {
        _value.hashCode();
        if (_value.equals("DARK")) {
            return AdvBottomSheetDesignTheme.DARK;
        }
        if (_value.equals("LIGHT")) {
            return AdvBottomSheetDesignTheme.LIGHT;
        }
        throw new IllegalArgumentException("Can't convert value to enum, unknown value: " + _value);
    }
}
