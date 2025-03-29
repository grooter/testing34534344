package ru.tattelecom.intercom.feature.home;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: HomeListAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\bE\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003¢\u0006\u0002\u0010\u001cJ\t\u00102\u001a\u00020\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010G\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u008a\u0002\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010JJ\u0013\u0010K\u001a\u00020\u00032\b\u0010L\u001a\u0004\u0018\u00010MHÖ\u0003J\t\u0010N\u001a\u00020\u0005HÖ\u0001J\t\u0010O\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0017\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010%R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010%R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010%R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010%R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001e¨\u0006P"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeStream;", "Lru/tattelecom/intercom/feature/home/HomeItem;", "isIntercom", "", TtmlNode.ATTR_ID, "", "url", "", "preview", "name", "address", "gateId", "gateName", "gateTypeId", FirebaseAnalytics.Event.LOGIN, "callsMuted", "archive", "archiveExport", "isFlussonic", "archiveDaysAvailable", "temporaryCode", VideoPlayerViewModel.IS_OPEN_DOOR_LOADING, "isTemporaryCodeLoading", LogWriteConstants.BUILDING_ID, "isCollapsed", "isFavorite", "openDoorIsEnable", "isExit", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;ZZIZZZZ)V", "getAddress", "()Ljava/lang/String;", "getArchive", "getArchiveDaysAvailable", "()I", "getArchiveExport", "getBuildingId", "getCallsMuted", "()Z", "getGateId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGateName", "getGateTypeId", "getId", "getLogin", "getName", "getOpenDoorIsEnable", "getPreview", "getTemporaryCode", "getUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;ZZIZZZZ)Lru/tattelecom/intercom/feature/home/HomeStream;", "equals", "other", "", "hashCode", "toString", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class HomeStream extends HomeItem {
    private final String address;
    private final String archive;
    private final int archiveDaysAvailable;
    private final String archiveExport;
    private final int buildingId;
    private final boolean callsMuted;
    private final Integer gateId;
    private final String gateName;
    private final Integer gateTypeId;
    private final int id;
    private final boolean isCollapsed;
    private final boolean isExit;
    private final boolean isFavorite;
    private final boolean isFlussonic;
    private final boolean isIntercom;
    private final boolean isOpenDoorLoading;
    private final boolean isTemporaryCodeLoading;
    private final String login;
    private final String name;
    private final boolean openDoorIsEnable;
    private final String preview;
    private final Integer temporaryCode;
    private final String url;

    /* renamed from: component1, reason: from getter */
    public final boolean getIsIntercom() {
        return this.isIntercom;
    }

    /* renamed from: component10, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getCallsMuted() {
        return this.callsMuted;
    }

    /* renamed from: component12, reason: from getter */
    public final String getArchive() {
        return this.archive;
    }

    /* renamed from: component13, reason: from getter */
    public final String getArchiveExport() {
        return this.archiveExport;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getIsFlussonic() {
        return this.isFlussonic;
    }

    /* renamed from: component15, reason: from getter */
    public final int getArchiveDaysAvailable() {
        return this.archiveDaysAvailable;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getTemporaryCode() {
        return this.temporaryCode;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsOpenDoorLoading() {
        return this.isOpenDoorLoading;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getIsTemporaryCodeLoading() {
        return this.isTemporaryCodeLoading;
    }

    /* renamed from: component19, reason: from getter */
    public final int getBuildingId() {
        return this.buildingId;
    }

    /* renamed from: component2, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    /* renamed from: component21, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component22, reason: from getter */
    public final boolean getOpenDoorIsEnable() {
        return this.openDoorIsEnable;
    }

    /* renamed from: component23, reason: from getter */
    public final boolean getIsExit() {
        return this.isExit;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPreview() {
        return this.preview;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getGateId() {
        return this.gateId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getGateName() {
        return this.gateName;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    public final HomeStream copy(boolean isIntercom, int id, String url, String preview, String name, String address, Integer gateId, String gateName, Integer gateTypeId, String login, boolean callsMuted, String archive, String archiveExport, boolean isFlussonic, int archiveDaysAvailable, Integer temporaryCode, boolean isOpenDoorLoading, boolean isTemporaryCodeLoading, int buildingId, boolean isCollapsed, boolean isFavorite, boolean openDoorIsEnable, boolean isExit) {
        return new HomeStream(isIntercom, id, url, preview, name, address, gateId, gateName, gateTypeId, login, callsMuted, archive, archiveExport, isFlussonic, archiveDaysAvailable, temporaryCode, isOpenDoorLoading, isTemporaryCodeLoading, buildingId, isCollapsed, isFavorite, openDoorIsEnable, isExit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeStream)) {
            return false;
        }
        HomeStream homeStream = (HomeStream) other;
        return this.isIntercom == homeStream.isIntercom && this.id == homeStream.id && Intrinsics.areEqual(this.url, homeStream.url) && Intrinsics.areEqual(this.preview, homeStream.preview) && Intrinsics.areEqual(this.name, homeStream.name) && Intrinsics.areEqual(this.address, homeStream.address) && Intrinsics.areEqual(this.gateId, homeStream.gateId) && Intrinsics.areEqual(this.gateName, homeStream.gateName) && Intrinsics.areEqual(this.gateTypeId, homeStream.gateTypeId) && Intrinsics.areEqual(this.login, homeStream.login) && this.callsMuted == homeStream.callsMuted && Intrinsics.areEqual(this.archive, homeStream.archive) && Intrinsics.areEqual(this.archiveExport, homeStream.archiveExport) && this.isFlussonic == homeStream.isFlussonic && this.archiveDaysAvailable == homeStream.archiveDaysAvailable && Intrinsics.areEqual(this.temporaryCode, homeStream.temporaryCode) && this.isOpenDoorLoading == homeStream.isOpenDoorLoading && this.isTemporaryCodeLoading == homeStream.isTemporaryCodeLoading && this.buildingId == homeStream.buildingId && this.isCollapsed == homeStream.isCollapsed && this.isFavorite == homeStream.isFavorite && this.openDoorIsEnable == homeStream.openDoorIsEnable && this.isExit == homeStream.isExit;
    }

    public int hashCode() {
        int m = ((AdvThemeDto$$ExternalSyntheticBackport0.m(this.isIntercom) * 31) + this.id) * 31;
        String str = this.url;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.preview;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.address;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.gateId;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.gateName;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.gateTypeId;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str6 = this.login;
        int hashCode8 = (((hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.callsMuted)) * 31;
        String str7 = this.archive;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.archiveExport;
        int hashCode10 = (((((hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isFlussonic)) * 31) + this.archiveDaysAvailable) * 31;
        Integer num3 = this.temporaryCode;
        return ((((((((((((((hashCode10 + (num3 != null ? num3.hashCode() : 0)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isOpenDoorLoading)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isTemporaryCodeLoading)) * 31) + this.buildingId) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isCollapsed)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isFavorite)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.openDoorIsEnable)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isExit);
    }

    public String toString() {
        return "HomeStream(isIntercom=" + this.isIntercom + ", id=" + this.id + ", url=" + this.url + ", preview=" + this.preview + ", name=" + this.name + ", address=" + this.address + ", gateId=" + this.gateId + ", gateName=" + this.gateName + ", gateTypeId=" + this.gateTypeId + ", login=" + this.login + ", callsMuted=" + this.callsMuted + ", archive=" + this.archive + ", archiveExport=" + this.archiveExport + ", isFlussonic=" + this.isFlussonic + ", archiveDaysAvailable=" + this.archiveDaysAvailable + ", temporaryCode=" + this.temporaryCode + ", isOpenDoorLoading=" + this.isOpenDoorLoading + ", isTemporaryCodeLoading=" + this.isTemporaryCodeLoading + ", buildingId=" + this.buildingId + ", isCollapsed=" + this.isCollapsed + ", isFavorite=" + this.isFavorite + ", openDoorIsEnable=" + this.openDoorIsEnable + ", isExit=" + this.isExit + ")";
    }

    public /* synthetic */ HomeStream(boolean z, int i, String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, String str6, boolean z2, String str7, String str8, boolean z3, int i2, Integer num3, boolean z4, boolean z5, int i3, boolean z6, boolean z7, boolean z8, boolean z9, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, str, str2, (i4 & 16) != 0 ? null : str3, (i4 & 32) != 0 ? null : str4, (i4 & 64) != 0 ? null : num, (i4 & 128) != 0 ? null : str5, (i4 & 256) != 0 ? null : num2, (i4 & 512) != 0 ? null : str6, (i4 & 1024) != 0 ? false : z2, (i4 & 2048) != 0 ? null : str7, (i4 & 4096) != 0 ? null : str8, (i4 & 8192) != 0 ? false : z3, (i4 & 16384) != 0 ? 2 : i2, (32768 & i4) != 0 ? null : num3, (65536 & i4) != 0 ? false : z4, (131072 & i4) != 0 ? false : z5, (262144 & i4) != 0 ? 0 : i3, z6, z7, (2097152 & i4) != 0 ? true : z8, (i4 & 4194304) != 0 ? false : z9);
    }

    public final boolean isIntercom() {
        return this.isIntercom;
    }

    public final int getId() {
        return this.id;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getPreview() {
        return this.preview;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final Integer getGateId() {
        return this.gateId;
    }

    public final String getGateName() {
        return this.gateName;
    }

    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    public final String getLogin() {
        return this.login;
    }

    public final boolean getCallsMuted() {
        return this.callsMuted;
    }

    public final String getArchive() {
        return this.archive;
    }

    public final String getArchiveExport() {
        return this.archiveExport;
    }

    public final boolean isFlussonic() {
        return this.isFlussonic;
    }

    public final int getArchiveDaysAvailable() {
        return this.archiveDaysAvailable;
    }

    public final Integer getTemporaryCode() {
        return this.temporaryCode;
    }

    public final boolean isOpenDoorLoading() {
        return this.isOpenDoorLoading;
    }

    public final boolean isTemporaryCodeLoading() {
        return this.isTemporaryCodeLoading;
    }

    public final int getBuildingId() {
        return this.buildingId;
    }

    public final boolean isCollapsed() {
        return this.isCollapsed;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final boolean getOpenDoorIsEnable() {
        return this.openDoorIsEnable;
    }

    public final boolean isExit() {
        return this.isExit;
    }

    public HomeStream(boolean z, int i, String str, String str2, String str3, String str4, Integer num, String str5, Integer num2, String str6, boolean z2, String str7, String str8, boolean z3, int i2, Integer num3, boolean z4, boolean z5, int i3, boolean z6, boolean z7, boolean z8, boolean z9) {
        super(((num2 != null && num2.intValue() == 5) || (num2 != null && num2.intValue() == 6) || z9) ? 3 : 2, z ? String.valueOf(i) : String.valueOf(str));
        this.isIntercom = z;
        this.id = i;
        this.url = str;
        this.preview = str2;
        this.name = str3;
        this.address = str4;
        this.gateId = num;
        this.gateName = str5;
        this.gateTypeId = num2;
        this.login = str6;
        this.callsMuted = z2;
        this.archive = str7;
        this.archiveExport = str8;
        this.isFlussonic = z3;
        this.archiveDaysAvailable = i2;
        this.temporaryCode = num3;
        this.isOpenDoorLoading = z4;
        this.isTemporaryCodeLoading = z5;
        this.buildingId = i3;
        this.isCollapsed = z6;
        this.isFavorite = z7;
        this.openDoorIsEnable = z8;
        this.isExit = z9;
    }
}
