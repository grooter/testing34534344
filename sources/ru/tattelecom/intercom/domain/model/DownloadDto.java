package ru.tattelecom.intercom.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: UserDtos.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/domain/model/DownloadDto;", "", "urlDescription", "", "downloadId", "", "isIntercomStream", "", "(Ljava/lang/String;JZ)V", "getDownloadId", "()J", "()Z", "getUrlDescription", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DownloadDto {
    private final long downloadId;
    private final boolean isIntercomStream;
    private final String urlDescription;

    public static /* synthetic */ DownloadDto copy$default(DownloadDto downloadDto, String str, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloadDto.urlDescription;
        }
        if ((i & 2) != 0) {
            j = downloadDto.downloadId;
        }
        if ((i & 4) != 0) {
            z = downloadDto.isIntercomStream;
        }
        return downloadDto.copy(str, j, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrlDescription() {
        return this.urlDescription;
    }

    /* renamed from: component2, reason: from getter */
    public final long getDownloadId() {
        return this.downloadId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsIntercomStream() {
        return this.isIntercomStream;
    }

    public final DownloadDto copy(String urlDescription, long downloadId, boolean isIntercomStream) {
        Intrinsics.checkNotNullParameter(urlDescription, "urlDescription");
        return new DownloadDto(urlDescription, downloadId, isIntercomStream);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadDto)) {
            return false;
        }
        DownloadDto downloadDto = (DownloadDto) other;
        return Intrinsics.areEqual(this.urlDescription, downloadDto.urlDescription) && this.downloadId == downloadDto.downloadId && this.isIntercomStream == downloadDto.isIntercomStream;
    }

    public int hashCode() {
        return (((this.urlDescription.hashCode() * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.downloadId)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isIntercomStream);
    }

    public String toString() {
        return "DownloadDto(urlDescription=" + this.urlDescription + ", downloadId=" + this.downloadId + ", isIntercomStream=" + this.isIntercomStream + ")";
    }

    public DownloadDto(String urlDescription, long j, boolean z) {
        Intrinsics.checkNotNullParameter(urlDescription, "urlDescription");
        this.urlDescription = urlDescription;
        this.downloadId = j;
        this.isIntercomStream = z;
    }

    public final String getUrlDescription() {
        return this.urlDescription;
    }

    public final long getDownloadId() {
        return this.downloadId;
    }

    public final boolean isIntercomStream() {
        return this.isIntercomStream;
    }
}
