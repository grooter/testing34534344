package ru.tattelecom.intercom.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: StreamDtos.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/domain/model/StreamDownloadStatus;", "", "status", "", "url", "", "(DLjava/lang/String;)V", "getStatus", "()D", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StreamDownloadStatus {
    private final double status;
    private final String url;

    public static /* synthetic */ StreamDownloadStatus copy$default(StreamDownloadStatus streamDownloadStatus, double d, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = streamDownloadStatus.status;
        }
        if ((i & 2) != 0) {
            str = streamDownloadStatus.url;
        }
        return streamDownloadStatus.copy(d, str);
    }

    /* renamed from: component1, reason: from getter */
    public final double getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final StreamDownloadStatus copy(double status, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new StreamDownloadStatus(status, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamDownloadStatus)) {
            return false;
        }
        StreamDownloadStatus streamDownloadStatus = (StreamDownloadStatus) other;
        return Double.compare(this.status, streamDownloadStatus.status) == 0 && Intrinsics.areEqual(this.url, streamDownloadStatus.url);
    }

    public int hashCode() {
        return (AdvThemeDto$$ExternalSyntheticBackport0.m(this.status) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "StreamDownloadStatus(status=" + this.status + ", url=" + this.url + ")";
    }

    public StreamDownloadStatus(double d, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.status = d;
        this.url = url;
    }

    public final double getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }
}
