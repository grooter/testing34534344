package ru.tattelecom.intercom.data.local;

import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dao.AddressDao;
import ru.tattelecom.intercom.data.local.dao.AddressDao_Impl;
import ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao;
import ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao_Impl;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao_Impl;
import ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao_Impl;
import ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao_Impl;
import ru.tattelecom.intercom.data.local.dao.DownloadDAO;
import ru.tattelecom.intercom.data.local.dao.DownloadDAO_Impl;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.local.dao.EventDao_Impl;
import ru.tattelecom.intercom.data.local.dao.GateEventDao;
import ru.tattelecom.intercom.data.local.dao.GateEventDao_Impl;
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.dao.IntercomDao_Impl;
import ru.tattelecom.intercom.data.local.dao.LockGateDao;
import ru.tattelecom.intercom.data.local.dao.LockGateDao_Impl;
import ru.tattelecom.intercom.data.local.dao.RemoteLogsDao;
import ru.tattelecom.intercom.data.local.dao.RemoteLogsDao_Impl;
import ru.tattelecom.intercom.data.local.dao.ScheduleDao;
import ru.tattelecom.intercom.data.local.dao.ScheduleDao_Impl;
import ru.tattelecom.intercom.data.local.dao.StreamDao;
import ru.tattelecom.intercom.data.local.dao.StreamDao_Impl;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao_Impl;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.GateEventEntitiesKt;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* loaded from: classes5.dex */
public final class IntercomDatabase_Impl extends IntercomDatabase {
    private volatile AddressDao _addressDao;
    private volatile AdvBottomSheetDao _advBottomSheetDao;
    private volatile ApartmentDao _apartmentDao;
    private volatile ApartmentGuestsDao _apartmentGuestsDao;
    private volatile ApartmentServicesDao _apartmentServicesDao;
    private volatile DownloadDAO _downloadDAO;
    private volatile EventDao _eventDao;
    private volatile GateEventDao _gateEventDao;
    private volatile IntercomDao _intercomDao;
    private volatile LockGateDao _lockGateDao;
    private volatile RemoteLogsDao _remoteLogsDao;
    private volatile ScheduleDao _scheduleDao;
    private volatile StreamDao _streamDao;
    private volatile SupportContactDao _supportContactDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        return config.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(new RoomOpenHelper(config, new RoomOpenHelper.Delegate(27) { // from class: ru.tattelecom.intercom.data.local.IntercomDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `addresses` (`id` INTEGER NOT NULL, `address` TEXT, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `apartments` (`id` INTEGER NOT NULL, `buildingId` INTEGER, `address` TEXT, `guestPhones` TEXT, `remainingInvites` INTEGER, `intercomTemporaryCode` INTEGER, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `apartment_guests` (`id` INTEGER NOT NULL, `address` TEXT NOT NULL, `guestPhones` TEXT NOT NULL, `remainingInvites` INTEGER NOT NULL, `isMaster` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `apartment_services` (`id` INTEGER NOT NULL, `buildingId` INTEGER NOT NULL, `apartmentId` INTEGER NOT NULL, `name` TEXT, `active` INTEGER, PRIMARY KEY(`apartmentId`, `id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `apartment_temporary_code` (`apartmentId` INTEGER NOT NULL, `address` TEXT, `temporaryCode` INTEGER, PRIMARY KEY(`apartmentId`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `calls` (`id` INTEGER NOT NULL, `intercomId` INTEGER NOT NULL, `apartmentId` INTEGER NOT NULL, `time` INTEGER NOT NULL, `snapshot` TEXT NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `downloads` (`urlDescription` TEXT NOT NULL, `downloadId` INTEGER NOT NULL, `isIntercomStream` INTEGER NOT NULL, PRIMARY KEY(`urlDescription`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `intercoms` (`id` INTEGER NOT NULL, `addressId` INTEGER NOT NULL, `login` TEXT, `name` TEXT, `gateId` INTEGER, `gateName` TEXT, `gateTypeId` INTEGER, `streamUrl` TEXT, `base64Preview` TEXT, `callsMuted` INTEGER NOT NULL, `intercomEmergencyCode` INTEGER, `intercomEmergencyCodeUpdateTime` INTEGER, `intercomTemporaryCode` INTEGER, `isFavorite` INTEGER, `isExit` INTEGER, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `key_logs` (`id` TEXT NOT NULL, `intercomId` INTEGER NOT NULL, `apartmentId` INTEGER NOT NULL, `time` INTEGER NOT NULL, `snapshot` TEXT NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `code_pass_logs` (`id` TEXT NOT NULL, `intercomId` INTEGER NOT NULL, `apartmentId` INTEGER NOT NULL, `time` INTEGER NOT NULL, `snapshot` TEXT NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `remote_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `message` TEXT NOT NULL, `tag` TEXT NOT NULL, `logLevel` TEXT NOT NULL, `type` TEXT NOT NULL)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `schedules` (`id` INTEGER NOT NULL, `intercomId` INTEGER NOT NULL, `startHour` INTEGER, `startMinute` INTEGER, `finishHour` INTEGER, `finishMinute` INTEGER, `monday` INTEGER NOT NULL, `tuesday` INTEGER NOT NULL, `wednesday` INTEGER NOT NULL, `thursday` INTEGER NOT NULL, `friday` INTEGER NOT NULL, `saturday` INTEGER NOT NULL, `sunday` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `streams` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `addressId` INTEGER NOT NULL, `name` TEXT, `liveSource` TEXT, `snapshotUrl` TEXT, `archiveSource` TEXT, `archiveExportSource` TEXT, `isFlussonic` INTEGER NOT NULL, `isSelected` INTEGER, `isFavorite` INTEGER)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `adv_bottom_sheet_design` (`advBottomSheetId` INTEGER NOT NULL, `theme` TEXT NOT NULL, `backgroundColor` TEXT, `buttonTextColor` TEXT, `titleColor` TEXT, `descriptionColor` TEXT, `buttonBackgroundColor` TEXT, PRIMARY KEY(`theme`, `advBottomSheetId`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `adv_bottom_sheet` (`id` INTEGER NOT NULL, `isRead` INTEGER NOT NULL, `endDate` INTEGER NOT NULL, `title` TEXT NOT NULL, `description` TEXT NOT NULL, `buttonText` TEXT NOT NULL, `type` TEXT, `typeDataUrl` TEXT, `typeDataScreen` TEXT, `typeDataSelectedServices` TEXT, `titleAlign` TEXT, `descriptionAlign` TEXT, `image` TEXT, `icon` TEXT, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `support_contacts` (`name` TEXT NOT NULL, `description` TEXT, `value` TEXT, `isEnabled` INTEGER, PRIMARY KEY(`name`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `support_with_auth_contacts` (`name` TEXT NOT NULL, `description` TEXT, `value` TEXT, `isEnabled` INTEGER, PRIMARY KEY(`name`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `lock_gate` (`gateId` INTEGER NOT NULL, `date` INTEGER NOT NULL, PRIMARY KEY(`gateId`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `gate_events` (`id` TEXT NOT NULL, `gateId` INTEGER NOT NULL, `type` TEXT NOT NULL, `startDate` INTEGER NOT NULL, `duration` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '27f0f7b24414cdc3b71b498c03049035')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `addresses`");
                db.execSQL("DROP TABLE IF EXISTS `apartments`");
                db.execSQL("DROP TABLE IF EXISTS `apartment_guests`");
                db.execSQL("DROP TABLE IF EXISTS `apartment_services`");
                db.execSQL("DROP TABLE IF EXISTS `apartment_temporary_code`");
                db.execSQL("DROP TABLE IF EXISTS `calls`");
                db.execSQL("DROP TABLE IF EXISTS `downloads`");
                db.execSQL("DROP TABLE IF EXISTS `intercoms`");
                db.execSQL("DROP TABLE IF EXISTS `key_logs`");
                db.execSQL("DROP TABLE IF EXISTS `code_pass_logs`");
                db.execSQL("DROP TABLE IF EXISTS `remote_logs`");
                db.execSQL("DROP TABLE IF EXISTS `schedules`");
                db.execSQL("DROP TABLE IF EXISTS `streams`");
                db.execSQL("DROP TABLE IF EXISTS `adv_bottom_sheet_design`");
                db.execSQL("DROP TABLE IF EXISTS `adv_bottom_sheet`");
                db.execSQL("DROP TABLE IF EXISTS `support_contacts`");
                db.execSQL("DROP TABLE IF EXISTS `support_with_auth_contacts`");
                db.execSQL("DROP TABLE IF EXISTS `lock_gate`");
                db.execSQL("DROP TABLE IF EXISTS `gate_events`");
                List list = IntercomDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List list = IntercomDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                IntercomDatabase_Impl.this.mDatabase = db;
                IntercomDatabase_Impl.this.internalInitInvalidationTracker(db);
                List list = IntercomDatabase_Impl.this.mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((RoomDatabase.Callback) it.next()).onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap hashMap = new HashMap(2);
                hashMap.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo(EntitiesKt.ADDRESSES_TABLE, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(db, EntitiesKt.ADDRESSES_TABLE);
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "addresses(ru.tattelecom.intercom.data.local.entity.AddressEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(6);
                hashMap2.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap2.put(LogWriteConstants.BUILDING_ID, new TableInfo.Column(LogWriteConstants.BUILDING_ID, "INTEGER", false, 0, null, 1));
                hashMap2.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, 1));
                hashMap2.put("guestPhones", new TableInfo.Column("guestPhones", "TEXT", false, 0, null, 1));
                hashMap2.put("remainingInvites", new TableInfo.Column("remainingInvites", "INTEGER", false, 0, null, 1));
                hashMap2.put("intercomTemporaryCode", new TableInfo.Column("intercomTemporaryCode", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo(EntitiesKt.APARTMENTS_TABLE, hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(db, EntitiesKt.APARTMENTS_TABLE);
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "apartments(ru.tattelecom.intercom.data.local.entity.ApartmentEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(5);
                hashMap3.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap3.put("address", new TableInfo.Column("address", "TEXT", true, 0, null, 1));
                hashMap3.put("guestPhones", new TableInfo.Column("guestPhones", "TEXT", true, 0, null, 1));
                hashMap3.put("remainingInvites", new TableInfo.Column("remainingInvites", "INTEGER", true, 0, null, 1));
                hashMap3.put("isMaster", new TableInfo.Column("isMaster", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo(EntitiesKt.APARTMENT_GUESTS_TABLE, hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(db, EntitiesKt.APARTMENT_GUESTS_TABLE);
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "apartment_guests(ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(5);
                hashMap4.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 2, null, 1));
                hashMap4.put(LogWriteConstants.BUILDING_ID, new TableInfo.Column(LogWriteConstants.BUILDING_ID, "INTEGER", true, 0, null, 1));
                hashMap4.put(NavArg.VerifyCode.APARTMENT_ID, new TableInfo.Column(NavArg.VerifyCode.APARTMENT_ID, "INTEGER", true, 1, null, 1));
                hashMap4.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap4.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "INTEGER", false, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo(EntitiesKt.APARTMENT_SERVICES_TABLE, hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(db, EntitiesKt.APARTMENT_SERVICES_TABLE);
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "apartment_services(ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(3);
                hashMap5.put(NavArg.VerifyCode.APARTMENT_ID, new TableInfo.Column(NavArg.VerifyCode.APARTMENT_ID, "INTEGER", true, 1, null, 1));
                hashMap5.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, 1));
                hashMap5.put("temporaryCode", new TableInfo.Column("temporaryCode", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo(EntitiesKt.APARTMENT_TEMPORARY_CODE, hashMap5, new HashSet(0), new HashSet(0));
                TableInfo read5 = TableInfo.read(db, EntitiesKt.APARTMENT_TEMPORARY_CODE);
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "apartment_temporary_code(ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(5);
                hashMap6.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap6.put(NavArg.INTERCOM_ID, new TableInfo.Column(NavArg.INTERCOM_ID, "INTEGER", true, 0, null, 1));
                hashMap6.put(NavArg.VerifyCode.APARTMENT_ID, new TableInfo.Column(NavArg.VerifyCode.APARTMENT_ID, "INTEGER", true, 0, null, 1));
                hashMap6.put(CrashHianalyticsData.TIME, new TableInfo.Column(CrashHianalyticsData.TIME, "INTEGER", true, 0, null, 1));
                hashMap6.put("snapshot", new TableInfo.Column("snapshot", "TEXT", true, 0, null, 1));
                TableInfo tableInfo6 = new TableInfo(EntitiesKt.CALLS_TABLE, hashMap6, new HashSet(0), new HashSet(0));
                TableInfo read6 = TableInfo.read(db, EntitiesKt.CALLS_TABLE);
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "calls(ru.tattelecom.intercom.data.local.entity.CallEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(3);
                hashMap7.put("urlDescription", new TableInfo.Column("urlDescription", "TEXT", true, 1, null, 1));
                hashMap7.put("downloadId", new TableInfo.Column("downloadId", "INTEGER", true, 0, null, 1));
                hashMap7.put("isIntercomStream", new TableInfo.Column("isIntercomStream", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo(EntitiesKt.DOWNLOADS_TABLE, hashMap7, new HashSet(0), new HashSet(0));
                TableInfo read7 = TableInfo.read(db, EntitiesKt.DOWNLOADS_TABLE);
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "downloads(ru.tattelecom.intercom.data.local.entity.DownloadEntity).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                HashMap hashMap8 = new HashMap(15);
                hashMap8.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap8.put("addressId", new TableInfo.Column("addressId", "INTEGER", true, 0, null, 1));
                hashMap8.put(FirebaseAnalytics.Event.LOGIN, new TableInfo.Column(FirebaseAnalytics.Event.LOGIN, "TEXT", false, 0, null, 1));
                hashMap8.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap8.put("gateId", new TableInfo.Column("gateId", "INTEGER", false, 0, null, 1));
                hashMap8.put("gateName", new TableInfo.Column("gateName", "TEXT", false, 0, null, 1));
                hashMap8.put("gateTypeId", new TableInfo.Column("gateTypeId", "INTEGER", false, 0, null, 1));
                hashMap8.put(VideoPlayerViewModel.STREAM_URL, new TableInfo.Column(VideoPlayerViewModel.STREAM_URL, "TEXT", false, 0, null, 1));
                hashMap8.put("base64Preview", new TableInfo.Column("base64Preview", "TEXT", false, 0, null, 1));
                hashMap8.put("callsMuted", new TableInfo.Column("callsMuted", "INTEGER", true, 0, null, 1));
                hashMap8.put(NavArg.INTERCOM_EMERGENCY_CODE, new TableInfo.Column(NavArg.INTERCOM_EMERGENCY_CODE, "INTEGER", false, 0, null, 1));
                hashMap8.put("intercomEmergencyCodeUpdateTime", new TableInfo.Column("intercomEmergencyCodeUpdateTime", "INTEGER", false, 0, null, 1));
                hashMap8.put("intercomTemporaryCode", new TableInfo.Column("intercomTemporaryCode", "INTEGER", false, 0, null, 1));
                hashMap8.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", false, 0, null, 1));
                hashMap8.put("isExit", new TableInfo.Column("isExit", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo8 = new TableInfo(EntitiesKt.INTERCOMS_TABLE, hashMap8, new HashSet(0), new HashSet(0));
                TableInfo read8 = TableInfo.read(db, EntitiesKt.INTERCOMS_TABLE);
                if (!tableInfo8.equals(read8)) {
                    return new RoomOpenHelper.ValidationResult(false, "intercoms(ru.tattelecom.intercom.data.local.entity.IntercomEntity).\n Expected:\n" + tableInfo8 + "\n Found:\n" + read8);
                }
                HashMap hashMap9 = new HashMap(5);
                hashMap9.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "TEXT", true, 1, null, 1));
                hashMap9.put(NavArg.INTERCOM_ID, new TableInfo.Column(NavArg.INTERCOM_ID, "INTEGER", true, 0, null, 1));
                hashMap9.put(NavArg.VerifyCode.APARTMENT_ID, new TableInfo.Column(NavArg.VerifyCode.APARTMENT_ID, "INTEGER", true, 0, null, 1));
                hashMap9.put(CrashHianalyticsData.TIME, new TableInfo.Column(CrashHianalyticsData.TIME, "INTEGER", true, 0, null, 1));
                hashMap9.put("snapshot", new TableInfo.Column("snapshot", "TEXT", true, 0, null, 1));
                TableInfo tableInfo9 = new TableInfo(EntitiesKt.KEY_LOG_TABLE, hashMap9, new HashSet(0), new HashSet(0));
                TableInfo read9 = TableInfo.read(db, EntitiesKt.KEY_LOG_TABLE);
                if (!tableInfo9.equals(read9)) {
                    return new RoomOpenHelper.ValidationResult(false, "key_logs(ru.tattelecom.intercom.data.local.entity.KeyLogEntity).\n Expected:\n" + tableInfo9 + "\n Found:\n" + read9);
                }
                HashMap hashMap10 = new HashMap(5);
                hashMap10.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "TEXT", true, 1, null, 1));
                hashMap10.put(NavArg.INTERCOM_ID, new TableInfo.Column(NavArg.INTERCOM_ID, "INTEGER", true, 0, null, 1));
                hashMap10.put(NavArg.VerifyCode.APARTMENT_ID, new TableInfo.Column(NavArg.VerifyCode.APARTMENT_ID, "INTEGER", true, 0, null, 1));
                hashMap10.put(CrashHianalyticsData.TIME, new TableInfo.Column(CrashHianalyticsData.TIME, "INTEGER", true, 0, null, 1));
                hashMap10.put("snapshot", new TableInfo.Column("snapshot", "TEXT", true, 0, null, 1));
                TableInfo tableInfo10 = new TableInfo(EntitiesKt.CODE_PASS_LOG_TABLE, hashMap10, new HashSet(0), new HashSet(0));
                TableInfo read10 = TableInfo.read(db, EntitiesKt.CODE_PASS_LOG_TABLE);
                if (!tableInfo10.equals(read10)) {
                    return new RoomOpenHelper.ValidationResult(false, "code_pass_logs(ru.tattelecom.intercom.data.local.entity.CodePassLogEntity).\n Expected:\n" + tableInfo10 + "\n Found:\n" + read10);
                }
                HashMap hashMap11 = new HashMap(6);
                hashMap11.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap11.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
                hashMap11.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, 1));
                hashMap11.put(RemoteMessageConst.Notification.TAG, new TableInfo.Column(RemoteMessageConst.Notification.TAG, "TEXT", true, 0, null, 1));
                hashMap11.put("logLevel", new TableInfo.Column("logLevel", "TEXT", true, 0, null, 1));
                hashMap11.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                TableInfo tableInfo11 = new TableInfo(EntitiesKt.REMOTE_LOGS_TABLE, hashMap11, new HashSet(0), new HashSet(0));
                TableInfo read11 = TableInfo.read(db, EntitiesKt.REMOTE_LOGS_TABLE);
                if (!tableInfo11.equals(read11)) {
                    return new RoomOpenHelper.ValidationResult(false, "remote_logs(ru.tattelecom.intercom.data.local.entity.RemoteLogEntity).\n Expected:\n" + tableInfo11 + "\n Found:\n" + read11);
                }
                HashMap hashMap12 = new HashMap(13);
                hashMap12.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap12.put(NavArg.INTERCOM_ID, new TableInfo.Column(NavArg.INTERCOM_ID, "INTEGER", true, 0, null, 1));
                hashMap12.put("startHour", new TableInfo.Column("startHour", "INTEGER", false, 0, null, 1));
                hashMap12.put("startMinute", new TableInfo.Column("startMinute", "INTEGER", false, 0, null, 1));
                hashMap12.put("finishHour", new TableInfo.Column("finishHour", "INTEGER", false, 0, null, 1));
                hashMap12.put("finishMinute", new TableInfo.Column("finishMinute", "INTEGER", false, 0, null, 1));
                hashMap12.put("monday", new TableInfo.Column("monday", "INTEGER", true, 0, null, 1));
                hashMap12.put("tuesday", new TableInfo.Column("tuesday", "INTEGER", true, 0, null, 1));
                hashMap12.put("wednesday", new TableInfo.Column("wednesday", "INTEGER", true, 0, null, 1));
                hashMap12.put("thursday", new TableInfo.Column("thursday", "INTEGER", true, 0, null, 1));
                hashMap12.put("friday", new TableInfo.Column("friday", "INTEGER", true, 0, null, 1));
                hashMap12.put("saturday", new TableInfo.Column("saturday", "INTEGER", true, 0, null, 1));
                hashMap12.put("sunday", new TableInfo.Column("sunday", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo12 = new TableInfo(EntitiesKt.SCHEDULES_TABLE, hashMap12, new HashSet(0), new HashSet(0));
                TableInfo read12 = TableInfo.read(db, EntitiesKt.SCHEDULES_TABLE);
                if (!tableInfo12.equals(read12)) {
                    return new RoomOpenHelper.ValidationResult(false, "schedules(ru.tattelecom.intercom.data.local.entity.ScheduleEntity).\n Expected:\n" + tableInfo12 + "\n Found:\n" + read12);
                }
                HashMap hashMap13 = new HashMap(10);
                hashMap13.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap13.put("addressId", new TableInfo.Column("addressId", "INTEGER", true, 0, null, 1));
                hashMap13.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap13.put("liveSource", new TableInfo.Column("liveSource", "TEXT", false, 0, null, 1));
                hashMap13.put("snapshotUrl", new TableInfo.Column("snapshotUrl", "TEXT", false, 0, null, 1));
                hashMap13.put("archiveSource", new TableInfo.Column("archiveSource", "TEXT", false, 0, null, 1));
                hashMap13.put("archiveExportSource", new TableInfo.Column("archiveExportSource", "TEXT", false, 0, null, 1));
                hashMap13.put("isFlussonic", new TableInfo.Column("isFlussonic", "INTEGER", true, 0, null, 1));
                hashMap13.put("isSelected", new TableInfo.Column("isSelected", "INTEGER", false, 0, null, 1));
                hashMap13.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo(EntitiesKt.STREAM_TABLE, hashMap13, new HashSet(0), new HashSet(0));
                TableInfo read13 = TableInfo.read(db, EntitiesKt.STREAM_TABLE);
                if (!tableInfo13.equals(read13)) {
                    return new RoomOpenHelper.ValidationResult(false, "streams(ru.tattelecom.intercom.data.local.entity.StreamEntity).\n Expected:\n" + tableInfo13 + "\n Found:\n" + read13);
                }
                HashMap hashMap14 = new HashMap(7);
                hashMap14.put("advBottomSheetId", new TableInfo.Column("advBottomSheetId", "INTEGER", true, 2, null, 1));
                hashMap14.put("theme", new TableInfo.Column("theme", "TEXT", true, 1, null, 1));
                hashMap14.put(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, new TableInfo.Column(TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "TEXT", false, 0, null, 1));
                hashMap14.put("buttonTextColor", new TableInfo.Column("buttonTextColor", "TEXT", false, 0, null, 1));
                hashMap14.put("titleColor", new TableInfo.Column("titleColor", "TEXT", false, 0, null, 1));
                hashMap14.put("descriptionColor", new TableInfo.Column("descriptionColor", "TEXT", false, 0, null, 1));
                hashMap14.put("buttonBackgroundColor", new TableInfo.Column("buttonBackgroundColor", "TEXT", false, 0, null, 1));
                TableInfo tableInfo14 = new TableInfo(EntitiesKt.ADV_BOTTOM_SHEET_DESIGN, hashMap14, new HashSet(0), new HashSet(0));
                TableInfo read14 = TableInfo.read(db, EntitiesKt.ADV_BOTTOM_SHEET_DESIGN);
                if (!tableInfo14.equals(read14)) {
                    return new RoomOpenHelper.ValidationResult(false, "adv_bottom_sheet_design(ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity).\n Expected:\n" + tableInfo14 + "\n Found:\n" + read14);
                }
                HashMap hashMap15 = new HashMap(14);
                hashMap15.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "INTEGER", true, 1, null, 1));
                hashMap15.put("isRead", new TableInfo.Column("isRead", "INTEGER", true, 0, null, 1));
                hashMap15.put("endDate", new TableInfo.Column("endDate", "INTEGER", true, 0, null, 1));
                hashMap15.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, 1));
                hashMap15.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                hashMap15.put("buttonText", new TableInfo.Column("buttonText", "TEXT", true, 0, null, 1));
                hashMap15.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
                hashMap15.put("typeDataUrl", new TableInfo.Column("typeDataUrl", "TEXT", false, 0, null, 1));
                hashMap15.put("typeDataScreen", new TableInfo.Column("typeDataScreen", "TEXT", false, 0, null, 1));
                hashMap15.put("typeDataSelectedServices", new TableInfo.Column("typeDataSelectedServices", "TEXT", false, 0, null, 1));
                hashMap15.put("titleAlign", new TableInfo.Column("titleAlign", "TEXT", false, 0, null, 1));
                hashMap15.put("descriptionAlign", new TableInfo.Column("descriptionAlign", "TEXT", false, 0, null, 1));
                hashMap15.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, 1));
                hashMap15.put(RemoteMessageConst.Notification.ICON, new TableInfo.Column(RemoteMessageConst.Notification.ICON, "TEXT", false, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo(EntitiesKt.ADV_BOTTOM_SHEET, hashMap15, new HashSet(0), new HashSet(0));
                TableInfo read15 = TableInfo.read(db, EntitiesKt.ADV_BOTTOM_SHEET);
                if (!tableInfo15.equals(read15)) {
                    return new RoomOpenHelper.ValidationResult(false, "adv_bottom_sheet(ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity).\n Expected:\n" + tableInfo15 + "\n Found:\n" + read15);
                }
                HashMap hashMap16 = new HashMap(4);
                hashMap16.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                hashMap16.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                hashMap16.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, 1));
                hashMap16.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo16 = new TableInfo(EntitiesKt.SUPPORT_CONTACTS, hashMap16, new HashSet(0), new HashSet(0));
                TableInfo read16 = TableInfo.read(db, EntitiesKt.SUPPORT_CONTACTS);
                if (!tableInfo16.equals(read16)) {
                    return new RoomOpenHelper.ValidationResult(false, "support_contacts(ru.tattelecom.intercom.data.local.entity.SupportContactEntity).\n Expected:\n" + tableInfo16 + "\n Found:\n" + read16);
                }
                HashMap hashMap17 = new HashMap(4);
                hashMap17.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, 1));
                hashMap17.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, 1));
                hashMap17.put("value", new TableInfo.Column("value", "TEXT", false, 0, null, 1));
                hashMap17.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo17 = new TableInfo(EntitiesKt.SUPPORT_WITH_AUTH_CONTACTS, hashMap17, new HashSet(0), new HashSet(0));
                TableInfo read17 = TableInfo.read(db, EntitiesKt.SUPPORT_WITH_AUTH_CONTACTS);
                if (!tableInfo17.equals(read17)) {
                    return new RoomOpenHelper.ValidationResult(false, "support_with_auth_contacts(ru.tattelecom.intercom.data.local.entity.SupportWithAuthContactEntity).\n Expected:\n" + tableInfo17 + "\n Found:\n" + read17);
                }
                HashMap hashMap18 = new HashMap(2);
                hashMap18.put("gateId", new TableInfo.Column("gateId", "INTEGER", true, 1, null, 1));
                hashMap18.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo18 = new TableInfo(EntitiesKt.LOCK_GATE, hashMap18, new HashSet(0), new HashSet(0));
                TableInfo read18 = TableInfo.read(db, EntitiesKt.LOCK_GATE);
                if (!tableInfo18.equals(read18)) {
                    return new RoomOpenHelper.ValidationResult(false, "lock_gate(ru.tattelecom.intercom.data.local.entity.LockGateEntity).\n Expected:\n" + tableInfo18 + "\n Found:\n" + read18);
                }
                HashMap hashMap19 = new HashMap(5);
                hashMap19.put(TtmlNode.ATTR_ID, new TableInfo.Column(TtmlNode.ATTR_ID, "TEXT", true, 1, null, 1));
                hashMap19.put("gateId", new TableInfo.Column("gateId", "INTEGER", true, 0, null, 1));
                hashMap19.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, 1));
                hashMap19.put("startDate", new TableInfo.Column("startDate", "INTEGER", true, 0, null, 1));
                hashMap19.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo19 = new TableInfo(GateEventEntitiesKt.GATE_EVENT_TABLE, hashMap19, new HashSet(0), new HashSet(0));
                TableInfo read19 = TableInfo.read(db, GateEventEntitiesKt.GATE_EVENT_TABLE);
                if (!tableInfo19.equals(read19)) {
                    return new RoomOpenHelper.ValidationResult(false, "gate_events(ru.tattelecom.intercom.data.local.entity.GateEventEntity).\n Expected:\n" + tableInfo19 + "\n Found:\n" + read19);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "27f0f7b24414cdc3b71b498c03049035", "bb39bc23c910bfdc8913d80c3d8fca8c")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), EntitiesKt.ADDRESSES_TABLE, EntitiesKt.APARTMENTS_TABLE, EntitiesKt.APARTMENT_GUESTS_TABLE, EntitiesKt.APARTMENT_SERVICES_TABLE, EntitiesKt.APARTMENT_TEMPORARY_CODE, EntitiesKt.CALLS_TABLE, EntitiesKt.DOWNLOADS_TABLE, EntitiesKt.INTERCOMS_TABLE, EntitiesKt.KEY_LOG_TABLE, EntitiesKt.CODE_PASS_LOG_TABLE, EntitiesKt.REMOTE_LOGS_TABLE, EntitiesKt.SCHEDULES_TABLE, EntitiesKt.STREAM_TABLE, EntitiesKt.ADV_BOTTOM_SHEET_DESIGN, EntitiesKt.ADV_BOTTOM_SHEET, EntitiesKt.SUPPORT_CONTACTS, EntitiesKt.SUPPORT_WITH_AUTH_CONTACTS, EntitiesKt.LOCK_GATE, GateEventEntitiesKt.GATE_EVENT_TABLE);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `addresses`");
            writableDatabase.execSQL("DELETE FROM `apartments`");
            writableDatabase.execSQL("DELETE FROM `apartment_guests`");
            writableDatabase.execSQL("DELETE FROM `apartment_services`");
            writableDatabase.execSQL("DELETE FROM `apartment_temporary_code`");
            writableDatabase.execSQL("DELETE FROM `calls`");
            writableDatabase.execSQL("DELETE FROM `downloads`");
            writableDatabase.execSQL("DELETE FROM `intercoms`");
            writableDatabase.execSQL("DELETE FROM `key_logs`");
            writableDatabase.execSQL("DELETE FROM `code_pass_logs`");
            writableDatabase.execSQL("DELETE FROM `remote_logs`");
            writableDatabase.execSQL("DELETE FROM `schedules`");
            writableDatabase.execSQL("DELETE FROM `streams`");
            writableDatabase.execSQL("DELETE FROM `adv_bottom_sheet_design`");
            writableDatabase.execSQL("DELETE FROM `adv_bottom_sheet`");
            writableDatabase.execSQL("DELETE FROM `support_contacts`");
            writableDatabase.execSQL("DELETE FROM `support_with_auth_contacts`");
            writableDatabase.execSQL("DELETE FROM `lock_gate`");
            writableDatabase.execSQL("DELETE FROM `gate_events`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(AddressDao.class, AddressDao_Impl.getRequiredConverters());
        hashMap.put(ApartmentDao.class, ApartmentDao_Impl.getRequiredConverters());
        hashMap.put(ApartmentGuestsDao.class, ApartmentGuestsDao_Impl.getRequiredConverters());
        hashMap.put(ApartmentServicesDao.class, ApartmentServicesDao_Impl.getRequiredConverters());
        hashMap.put(EventDao.class, EventDao_Impl.getRequiredConverters());
        hashMap.put(IntercomDao.class, IntercomDao_Impl.getRequiredConverters());
        hashMap.put(RemoteLogsDao.class, RemoteLogsDao_Impl.getRequiredConverters());
        hashMap.put(ScheduleDao.class, ScheduleDao_Impl.getRequiredConverters());
        hashMap.put(StreamDao.class, StreamDao_Impl.getRequiredConverters());
        hashMap.put(DownloadDAO.class, DownloadDAO_Impl.getRequiredConverters());
        hashMap.put(SupportContactDao.class, SupportContactDao_Impl.getRequiredConverters());
        hashMap.put(LockGateDao.class, LockGateDao_Impl.getRequiredConverters());
        hashMap.put(AdvBottomSheetDao.class, AdvBottomSheetDao_Impl.getRequiredConverters());
        hashMap.put(GateEventDao.class, GateEventDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        return new ArrayList();
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public AddressDao addressDao() {
        AddressDao addressDao;
        if (this._addressDao != null) {
            return this._addressDao;
        }
        synchronized (this) {
            if (this._addressDao == null) {
                this._addressDao = new AddressDao_Impl(this);
            }
            addressDao = this._addressDao;
        }
        return addressDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public ApartmentDao apartmentDao() {
        ApartmentDao apartmentDao;
        if (this._apartmentDao != null) {
            return this._apartmentDao;
        }
        synchronized (this) {
            if (this._apartmentDao == null) {
                this._apartmentDao = new ApartmentDao_Impl(this);
            }
            apartmentDao = this._apartmentDao;
        }
        return apartmentDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public ApartmentGuestsDao apartmentGuestsDao() {
        ApartmentGuestsDao apartmentGuestsDao;
        if (this._apartmentGuestsDao != null) {
            return this._apartmentGuestsDao;
        }
        synchronized (this) {
            if (this._apartmentGuestsDao == null) {
                this._apartmentGuestsDao = new ApartmentGuestsDao_Impl(this);
            }
            apartmentGuestsDao = this._apartmentGuestsDao;
        }
        return apartmentGuestsDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public ApartmentServicesDao apartmentServicesDao() {
        ApartmentServicesDao apartmentServicesDao;
        if (this._apartmentServicesDao != null) {
            return this._apartmentServicesDao;
        }
        synchronized (this) {
            if (this._apartmentServicesDao == null) {
                this._apartmentServicesDao = new ApartmentServicesDao_Impl(this);
            }
            apartmentServicesDao = this._apartmentServicesDao;
        }
        return apartmentServicesDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public EventDao callDao() {
        EventDao eventDao;
        if (this._eventDao != null) {
            return this._eventDao;
        }
        synchronized (this) {
            if (this._eventDao == null) {
                this._eventDao = new EventDao_Impl(this);
            }
            eventDao = this._eventDao;
        }
        return eventDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public IntercomDao intercomDao() {
        IntercomDao intercomDao;
        if (this._intercomDao != null) {
            return this._intercomDao;
        }
        synchronized (this) {
            if (this._intercomDao == null) {
                this._intercomDao = new IntercomDao_Impl(this);
            }
            intercomDao = this._intercomDao;
        }
        return intercomDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public RemoteLogsDao remoteLogsDao() {
        RemoteLogsDao remoteLogsDao;
        if (this._remoteLogsDao != null) {
            return this._remoteLogsDao;
        }
        synchronized (this) {
            if (this._remoteLogsDao == null) {
                this._remoteLogsDao = new RemoteLogsDao_Impl(this);
            }
            remoteLogsDao = this._remoteLogsDao;
        }
        return remoteLogsDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public ScheduleDao scheduleDao() {
        ScheduleDao scheduleDao;
        if (this._scheduleDao != null) {
            return this._scheduleDao;
        }
        synchronized (this) {
            if (this._scheduleDao == null) {
                this._scheduleDao = new ScheduleDao_Impl(this);
            }
            scheduleDao = this._scheduleDao;
        }
        return scheduleDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public StreamDao streamDao() {
        StreamDao streamDao;
        if (this._streamDao != null) {
            return this._streamDao;
        }
        synchronized (this) {
            if (this._streamDao == null) {
                this._streamDao = new StreamDao_Impl(this);
            }
            streamDao = this._streamDao;
        }
        return streamDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public DownloadDAO downloadDao() {
        DownloadDAO downloadDAO;
        if (this._downloadDAO != null) {
            return this._downloadDAO;
        }
        synchronized (this) {
            if (this._downloadDAO == null) {
                this._downloadDAO = new DownloadDAO_Impl(this);
            }
            downloadDAO = this._downloadDAO;
        }
        return downloadDAO;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public SupportContactDao supportContactDao() {
        SupportContactDao supportContactDao;
        if (this._supportContactDao != null) {
            return this._supportContactDao;
        }
        synchronized (this) {
            if (this._supportContactDao == null) {
                this._supportContactDao = new SupportContactDao_Impl(this);
            }
            supportContactDao = this._supportContactDao;
        }
        return supportContactDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public LockGateDao lockGateDao() {
        LockGateDao lockGateDao;
        if (this._lockGateDao != null) {
            return this._lockGateDao;
        }
        synchronized (this) {
            if (this._lockGateDao == null) {
                this._lockGateDao = new LockGateDao_Impl(this);
            }
            lockGateDao = this._lockGateDao;
        }
        return lockGateDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public AdvBottomSheetDao advBottomSheetDao() {
        AdvBottomSheetDao advBottomSheetDao;
        if (this._advBottomSheetDao != null) {
            return this._advBottomSheetDao;
        }
        synchronized (this) {
            if (this._advBottomSheetDao == null) {
                this._advBottomSheetDao = new AdvBottomSheetDao_Impl(this);
            }
            advBottomSheetDao = this._advBottomSheetDao;
        }
        return advBottomSheetDao;
    }

    @Override // ru.tattelecom.intercom.data.local.IntercomDatabase
    public GateEventDao gateEventDao() {
        GateEventDao gateEventDao;
        if (this._gateEventDao != null) {
            return this._gateEventDao;
        }
        synchronized (this) {
            if (this._gateEventDao == null) {
                this._gateEventDao = new GateEventDao_Impl(this);
            }
            gateEventDao = this._gateEventDao;
        }
        return gateEventDao;
    }
}
