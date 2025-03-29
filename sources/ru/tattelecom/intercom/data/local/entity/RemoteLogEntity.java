package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: RemoteLogEntity.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/data/local/entity/RemoteLogEntity;", "", TtmlNode.ATTR_ID, "", "timestamp", "message", "", RemoteMessageConst.Notification.TAG, "logLevel", "type", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getLogLevel", "()Ljava/lang/String;", "getMessage", "getTag", "getTimestamp", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RemoteLogEntity {
    private final long id;
    private final String logLevel;
    private final String message;
    private final String tag;
    private final long timestamp;
    private final String type;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLogLevel() {
        return this.logLevel;
    }

    /* renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final RemoteLogEntity copy(long id, long timestamp, String message, String tag, String logLevel, String type) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(type, "type");
        return new RemoteLogEntity(id, timestamp, message, tag, logLevel, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RemoteLogEntity)) {
            return false;
        }
        RemoteLogEntity remoteLogEntity = (RemoteLogEntity) other;
        return this.id == remoteLogEntity.id && this.timestamp == remoteLogEntity.timestamp && Intrinsics.areEqual(this.message, remoteLogEntity.message) && Intrinsics.areEqual(this.tag, remoteLogEntity.tag) && Intrinsics.areEqual(this.logLevel, remoteLogEntity.logLevel) && Intrinsics.areEqual(this.type, remoteLogEntity.type);
    }

    public int hashCode() {
        return (((((((((AdvThemeDto$$ExternalSyntheticBackport0.m(this.id) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.timestamp)) * 31) + this.message.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.logLevel.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "RemoteLogEntity(id=" + this.id + ", timestamp=" + this.timestamp + ", message=" + this.message + ", tag=" + this.tag + ", logLevel=" + this.logLevel + ", type=" + this.type + ")";
    }

    public RemoteLogEntity(long j, long j2, String message, String tag, String logLevel, String type) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = j;
        this.timestamp = j2;
        this.message = message;
        this.tag = tag;
        this.logLevel = logLevel;
        this.type = type;
    }

    public /* synthetic */ RemoteLogEntity(long j, long j2, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, j2, str, str2, str3, str4);
    }

    public final long getId() {
        return this.id;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getLogLevel() {
        return this.logLevel;
    }

    public final String getType() {
        return this.type;
    }
}
