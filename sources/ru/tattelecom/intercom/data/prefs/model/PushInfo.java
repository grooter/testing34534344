package ru.tattelecom.intercom.data.prefs.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.domain.workers.SendPushTokenWorker;
import ru.tattelecom.intercom.domain.workers.SetPushTokenStatusWorker;

/* compiled from: PushPrefsModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/tattelecom/intercom/data/prefs/model/PushInfo;", "", SendPushTokenWorker.PUSH_SERVICE, "", SendPushTokenWorker.PUSH_TOKEN, SetPushTokenStatusWorker.PUSH_TOKEN_STATUS, "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getPushService", "()Ljava/lang/String;", "getPushToken", "getPushTokenStatus", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PushInfo {
    private final String pushService;
    private final String pushToken;
    private final boolean pushTokenStatus;

    public static /* synthetic */ PushInfo copy$default(PushInfo pushInfo, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushInfo.pushService;
        }
        if ((i & 2) != 0) {
            str2 = pushInfo.pushToken;
        }
        if ((i & 4) != 0) {
            z = pushInfo.pushTokenStatus;
        }
        return pushInfo.copy(str, str2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPushService() {
        return this.pushService;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPushToken() {
        return this.pushToken;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPushTokenStatus() {
        return this.pushTokenStatus;
    }

    public final PushInfo copy(String pushService, String pushToken, boolean pushTokenStatus) {
        return new PushInfo(pushService, pushToken, pushTokenStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PushInfo)) {
            return false;
        }
        PushInfo pushInfo = (PushInfo) other;
        return Intrinsics.areEqual(this.pushService, pushInfo.pushService) && Intrinsics.areEqual(this.pushToken, pushInfo.pushToken) && this.pushTokenStatus == pushInfo.pushTokenStatus;
    }

    public int hashCode() {
        String str = this.pushService;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.pushToken;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.pushTokenStatus);
    }

    public String toString() {
        return "PushInfo(pushService=" + this.pushService + ", pushToken=" + this.pushToken + ", pushTokenStatus=" + this.pushTokenStatus + ")";
    }

    public PushInfo(String str, String str2, boolean z) {
        this.pushService = str;
        this.pushToken = str2;
        this.pushTokenStatus = z;
    }

    public final String getPushService() {
        return this.pushService;
    }

    public final String getPushToken() {
        return this.pushToken;
    }

    public final boolean getPushTokenStatus() {
        return this.pushTokenStatus;
    }
}
