package ru.tattelecom.intercom.data.remote.source.paging;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u001a¨\u0006("}, d2 = {"Lru/tattelecom/intercom/data/remote/source/paging/HistoryBanner;", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "type", "", TtmlNode.ATTR_ID, "", CrashHianalyticsData.TIME, "", "bannerType", "bannerTitle", "bannerInfo", "(ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;)V", "getBannerInfo", "()Ljava/lang/String;", "getBannerTitle", "getBannerType", "()I", "getId", "setId", "(Ljava/lang/String;)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class HistoryBanner implements HistoryItem {
    private final String bannerInfo;
    private final String bannerTitle;
    private final int bannerType;
    private String id;
    private long time;
    private int type;

    public static /* synthetic */ HistoryBanner copy$default(HistoryBanner historyBanner, int i, String str, long j, int i2, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = historyBanner.type;
        }
        if ((i3 & 2) != 0) {
            str = historyBanner.id;
        }
        String str4 = str;
        if ((i3 & 4) != 0) {
            j = historyBanner.time;
        }
        long j2 = j;
        if ((i3 & 8) != 0) {
            i2 = historyBanner.bannerType;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            str2 = historyBanner.bannerTitle;
        }
        String str5 = str2;
        if ((i3 & 32) != 0) {
            str3 = historyBanner.bannerInfo;
        }
        return historyBanner.copy(i, str4, j2, i4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component4, reason: from getter */
    public final int getBannerType() {
        return this.bannerType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBannerTitle() {
        return this.bannerTitle;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBannerInfo() {
        return this.bannerInfo;
    }

    public final HistoryBanner copy(int type, String id, long time, int bannerType, String bannerTitle, String bannerInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(bannerTitle, "bannerTitle");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        return new HistoryBanner(type, id, time, bannerType, bannerTitle, bannerInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryBanner)) {
            return false;
        }
        HistoryBanner historyBanner = (HistoryBanner) other;
        return this.type == historyBanner.type && Intrinsics.areEqual(this.id, historyBanner.id) && this.time == historyBanner.time && this.bannerType == historyBanner.bannerType && Intrinsics.areEqual(this.bannerTitle, historyBanner.bannerTitle) && Intrinsics.areEqual(this.bannerInfo, historyBanner.bannerInfo);
    }

    public int hashCode() {
        return (((((((((this.type * 31) + this.id.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.time)) * 31) + this.bannerType) * 31) + this.bannerTitle.hashCode()) * 31) + this.bannerInfo.hashCode();
    }

    public String toString() {
        return "HistoryBanner(type=" + this.type + ", id=" + this.id + ", time=" + this.time + ", bannerType=" + this.bannerType + ", bannerTitle=" + this.bannerTitle + ", bannerInfo=" + this.bannerInfo + ")";
    }

    public HistoryBanner(int i, String id, long j, int i2, String bannerTitle, String bannerInfo) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(bannerTitle, "bannerTitle");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.type = i;
        this.id = id;
        this.time = j;
        this.bannerType = i2;
        this.bannerTitle = bannerTitle;
        this.bannerInfo = bannerInfo;
    }

    @Override // ru.tattelecom.intercom.data.remote.source.paging.HistoryItem
    public int getType() {
        return this.type;
    }

    @Override // ru.tattelecom.intercom.data.remote.source.paging.HistoryItem
    public void setType(int i) {
        this.type = i;
    }

    @Override // ru.tattelecom.intercom.data.remote.source.paging.HistoryItem
    public String getId() {
        return this.id;
    }

    @Override // ru.tattelecom.intercom.data.remote.source.paging.HistoryItem
    public void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    @Override // ru.tattelecom.intercom.data.remote.source.paging.HistoryItem
    public long getTime() {
        return this.time;
    }

    @Override // ru.tattelecom.intercom.data.remote.source.paging.HistoryItem
    public void setTime(long j) {
        this.time = j;
    }

    public final int getBannerType() {
        return this.bannerType;
    }

    public final String getBannerTitle() {
        return this.bannerTitle;
    }

    public final String getBannerInfo() {
        return this.bannerInfo;
    }
}
