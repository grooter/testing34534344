package ru.tattelecom.intercom.data.remote.source.paging;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003Ji\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0011\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00062"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/paging/EventHistory;", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "type", "", TtmlNode.ATTR_ID, "", CrashHianalyticsData.TIME, "", VideoPlayerViewModel.STREAM_URL, "gate", "address", "snapshot", "removeAbility", "", "streamIsAvailable", "(ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V", "getAddress", "()Ljava/lang/String;", "getGate", "getId", "setId", "(Ljava/lang/String;)V", "getRemoveAbility", "()Z", "getSnapshot", "getStreamIsAvailable", "getStreamUrl", "getTime", "()J", "setTime", "(J)V", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EventHistory implements HistoryItem {
    private final String address;
    private final String gate;
    private String id;
    private final boolean removeAbility;
    private final String snapshot;
    private final boolean streamIsAvailable;
    private final String streamUrl;
    private long time;
    private int type;

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
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGate() {
        return this.gate;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSnapshot() {
        return this.snapshot;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getRemoveAbility() {
        return this.removeAbility;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getStreamIsAvailable() {
        return this.streamIsAvailable;
    }

    public final EventHistory copy(int type, String id, long time, String streamUrl, String gate, String address, String snapshot, boolean removeAbility, boolean streamIsAvailable) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        return new EventHistory(type, id, time, streamUrl, gate, address, snapshot, removeAbility, streamIsAvailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventHistory)) {
            return false;
        }
        EventHistory eventHistory = (EventHistory) other;
        return this.type == eventHistory.type && Intrinsics.areEqual(this.id, eventHistory.id) && this.time == eventHistory.time && Intrinsics.areEqual(this.streamUrl, eventHistory.streamUrl) && Intrinsics.areEqual(this.gate, eventHistory.gate) && Intrinsics.areEqual(this.address, eventHistory.address) && Intrinsics.areEqual(this.snapshot, eventHistory.snapshot) && this.removeAbility == eventHistory.removeAbility && this.streamIsAvailable == eventHistory.streamIsAvailable;
    }

    public int hashCode() {
        int hashCode = ((((this.type * 31) + this.id.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.time)) * 31;
        String str = this.streamUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.gate;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.address;
        return ((((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.snapshot.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.removeAbility)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.streamIsAvailable);
    }

    public String toString() {
        return "EventHistory(type=" + this.type + ", id=" + this.id + ", time=" + this.time + ", streamUrl=" + this.streamUrl + ", gate=" + this.gate + ", address=" + this.address + ", snapshot=" + this.snapshot + ", removeAbility=" + this.removeAbility + ", streamIsAvailable=" + this.streamIsAvailable + ")";
    }

    public EventHistory(int i, String id, long j, String str, String str2, String str3, String snapshot, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        this.type = i;
        this.id = id;
        this.time = j;
        this.streamUrl = str;
        this.gate = str2;
        this.address = str3;
        this.snapshot = snapshot;
        this.removeAbility = z;
        this.streamIsAvailable = z2;
    }

    public /* synthetic */ EventHistory(int i, String str, long j, String str2, String str3, String str4, String str5, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, j, str2, str3, str4, str5, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? true : z2);
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

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getGate() {
        return this.gate;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getSnapshot() {
        return this.snapshot;
    }

    public final boolean getRemoveAbility() {
        return this.removeAbility;
    }

    public final boolean getStreamIsAvailable() {
        return this.streamIsAvailable;
    }
}
