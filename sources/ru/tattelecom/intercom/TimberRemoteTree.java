package ru.tattelecom.intercom;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.tattelecom.intercom.data.local.entity.RemoteLogEntity;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import timber.log.Timber;

/* compiled from: TimberRemoteTree.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/tattelecom/intercom/TimberRemoteTree;", "Ltimber/log/Timber$DebugTree;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "(Lru/tattelecom/intercom/domain/interactors/LogInteractor;)V", LogWriteConstants.LOG_TYPE, "", "priority", "", RemoteMessageConst.Notification.TAG, "", "message", "t", "", "priorityAsString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimberRemoteTree extends Timber.DebugTree {
    private final LogInteractor logInteractor;

    public TimberRemoteTree(LogInteractor logInteractor) {
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        this.logInteractor = logInteractor;
    }

    @Override // timber.log.Timber.DebugTree, timber.log.Timber.Tree
    protected void log(int i, String str, String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.logInteractor.featRemoteLogging()) {
            this.logInteractor.addToDatabase(new RemoteLogEntity(0L, TimeUnit.MILLISECONDS.toSeconds(new Date().getTime()), StringsKt.substringAfter$default(message, "|", (String) null, 2, (Object) null), str == null ? "" : str, priorityAsString(i), StringsKt.substringBefore$default(message, "|", (String) null, 2, (Object) null), 1, null));
        }
    }

    private final String priorityAsString(int priority) {
        switch (priority) {
            case 2:
                return "VERBOSE";
            case 3:
                return "DEBUG";
            case 4:
                return "INFO";
            case 5:
                return "WARN";
            case 6:
                return "ERROR";
            case 7:
                return "ASSERT";
            default:
                return String.valueOf(priority);
        }
    }
}
