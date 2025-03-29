package ru.tattelecom.intercom.data.local;

import androidx.room.RoomDatabase;
import kotlin.Metadata;
import ru.tattelecom.intercom.data.local.dao.AddressDao;
import ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao;
import ru.tattelecom.intercom.data.local.dao.DownloadDAO;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.local.dao.GateEventDao;
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.dao.LockGateDao;
import ru.tattelecom.intercom.data.local.dao.RemoteLogsDao;
import ru.tattelecom.intercom.data.local.dao.ScheduleDao;
import ru.tattelecom.intercom.data.local.dao.StreamDao;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao;

/* compiled from: IntercomDatabase.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&J\b\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/data/local/IntercomDatabase;", "Landroidx/room/RoomDatabase;", "()V", "addressDao", "Lru/tattelecom/intercom/data/local/dao/AddressDao;", "advBottomSheetDao", "Lru/tattelecom/intercom/data/local/dao/AdvBottomSheetDao;", "apartmentDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentDao;", "apartmentGuestsDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentGuestsDao;", "apartmentServicesDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentServicesDao;", "callDao", "Lru/tattelecom/intercom/data/local/dao/EventDao;", "downloadDao", "Lru/tattelecom/intercom/data/local/dao/DownloadDAO;", "gateEventDao", "Lru/tattelecom/intercom/data/local/dao/GateEventDao;", "intercomDao", "Lru/tattelecom/intercom/data/local/dao/IntercomDao;", "lockGateDao", "Lru/tattelecom/intercom/data/local/dao/LockGateDao;", "remoteLogsDao", "Lru/tattelecom/intercom/data/local/dao/RemoteLogsDao;", "scheduleDao", "Lru/tattelecom/intercom/data/local/dao/ScheduleDao;", "streamDao", "Lru/tattelecom/intercom/data/local/dao/StreamDao;", "supportContactDao", "Lru/tattelecom/intercom/data/local/dao/SupportContactDao;", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class IntercomDatabase extends RoomDatabase {
    public static final String DB_NAME = "intercom_app.db";

    public abstract AddressDao addressDao();

    public abstract AdvBottomSheetDao advBottomSheetDao();

    public abstract ApartmentDao apartmentDao();

    public abstract ApartmentGuestsDao apartmentGuestsDao();

    public abstract ApartmentServicesDao apartmentServicesDao();

    public abstract EventDao callDao();

    public abstract DownloadDAO downloadDao();

    public abstract GateEventDao gateEventDao();

    public abstract IntercomDao intercomDao();

    public abstract LockGateDao lockGateDao();

    public abstract RemoteLogsDao remoteLogsDao();

    public abstract ScheduleDao scheduleDao();

    public abstract StreamDao streamDao();

    public abstract SupportContactDao supportContactDao();
}
