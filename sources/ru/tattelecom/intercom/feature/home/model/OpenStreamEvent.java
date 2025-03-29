package ru.tattelecom.intercom.feature.home.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: OpenStreamEvent.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0017\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010(\u001a\u00020\u0006HÆ\u0003J\t\u0010)\u001a\u00020\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010-\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0098\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u00020\bHÖ\u0001R\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u001dR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\r\u0010\u001eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00065"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/OpenStreamEvent;", "Ljava/io/Serializable;", "streamId", "", "buildingServices", "Lkotlin/Pair;", "", "streamDescription", "", "isFavorite", "cameraUrl", "intercomVideoUrl", "gateId", "isFlussonic", "cameraLiveSource", "cameraArchiveSource", "cameraExportSource", "(ILkotlin/Pair;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuildingServices", "()Lkotlin/Pair;", "getCameraArchiveSource", "()Ljava/lang/String;", "getCameraExportSource", "getCameraLiveSource", "getCameraUrl", "getGateId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIntercomVideoUrl", "()Z", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getStreamDescription", "getStreamId", "()I", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILkotlin/Pair;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/tattelecom/intercom/feature/home/model/OpenStreamEvent;", "equals", "other", "", "hashCode", "toString", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class OpenStreamEvent implements Serializable {
    private final Pair<Integer, Boolean> buildingServices;
    private final String cameraArchiveSource;
    private final String cameraExportSource;
    private final String cameraLiveSource;
    private final String cameraUrl;
    private final Integer gateId;
    private final String intercomVideoUrl;
    private final boolean isFavorite;
    private final Boolean isFlussonic;
    private final String streamDescription;
    private final int streamId;

    /* renamed from: component1, reason: from getter */
    public final int getStreamId() {
        return this.streamId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCameraArchiveSource() {
        return this.cameraArchiveSource;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCameraExportSource() {
        return this.cameraExportSource;
    }

    public final Pair<Integer, Boolean> component2() {
        return this.buildingServices;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStreamDescription() {
        return this.streamDescription;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCameraUrl() {
        return this.cameraUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIntercomVideoUrl() {
        return this.intercomVideoUrl;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getGateId() {
        return this.gateId;
    }

    /* renamed from: component8, reason: from getter */
    public final Boolean getIsFlussonic() {
        return this.isFlussonic;
    }

    /* renamed from: component9, reason: from getter */
    public final String getCameraLiveSource() {
        return this.cameraLiveSource;
    }

    public final OpenStreamEvent copy(int streamId, Pair<Integer, Boolean> buildingServices, String streamDescription, boolean isFavorite, String cameraUrl, String intercomVideoUrl, Integer gateId, Boolean isFlussonic, String cameraLiveSource, String cameraArchiveSource, String cameraExportSource) {
        Intrinsics.checkNotNullParameter(cameraUrl, "cameraUrl");
        return new OpenStreamEvent(streamId, buildingServices, streamDescription, isFavorite, cameraUrl, intercomVideoUrl, gateId, isFlussonic, cameraLiveSource, cameraArchiveSource, cameraExportSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenStreamEvent)) {
            return false;
        }
        OpenStreamEvent openStreamEvent = (OpenStreamEvent) other;
        return this.streamId == openStreamEvent.streamId && Intrinsics.areEqual(this.buildingServices, openStreamEvent.buildingServices) && Intrinsics.areEqual(this.streamDescription, openStreamEvent.streamDescription) && this.isFavorite == openStreamEvent.isFavorite && Intrinsics.areEqual(this.cameraUrl, openStreamEvent.cameraUrl) && Intrinsics.areEqual(this.intercomVideoUrl, openStreamEvent.intercomVideoUrl) && Intrinsics.areEqual(this.gateId, openStreamEvent.gateId) && Intrinsics.areEqual(this.isFlussonic, openStreamEvent.isFlussonic) && Intrinsics.areEqual(this.cameraLiveSource, openStreamEvent.cameraLiveSource) && Intrinsics.areEqual(this.cameraArchiveSource, openStreamEvent.cameraArchiveSource) && Intrinsics.areEqual(this.cameraExportSource, openStreamEvent.cameraExportSource);
    }

    public int hashCode() {
        int i = this.streamId * 31;
        Pair<Integer, Boolean> pair = this.buildingServices;
        int hashCode = (i + (pair == null ? 0 : pair.hashCode())) * 31;
        String str = this.streamDescription;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isFavorite)) * 31) + this.cameraUrl.hashCode()) * 31;
        String str2 = this.intercomVideoUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.gateId;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isFlussonic;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.cameraLiveSource;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cameraArchiveSource;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cameraExportSource;
        return hashCode7 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "OpenStreamEvent(streamId=" + this.streamId + ", buildingServices=" + this.buildingServices + ", streamDescription=" + this.streamDescription + ", isFavorite=" + this.isFavorite + ", cameraUrl=" + this.cameraUrl + ", intercomVideoUrl=" + this.intercomVideoUrl + ", gateId=" + this.gateId + ", isFlussonic=" + this.isFlussonic + ", cameraLiveSource=" + this.cameraLiveSource + ", cameraArchiveSource=" + this.cameraArchiveSource + ", cameraExportSource=" + this.cameraExportSource + ")";
    }

    public OpenStreamEvent(int i, Pair<Integer, Boolean> pair, String str, boolean z, String cameraUrl, String str2, Integer num, Boolean bool, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(cameraUrl, "cameraUrl");
        this.streamId = i;
        this.buildingServices = pair;
        this.streamDescription = str;
        this.isFavorite = z;
        this.cameraUrl = cameraUrl;
        this.intercomVideoUrl = str2;
        this.gateId = num;
        this.isFlussonic = bool;
        this.cameraLiveSource = str3;
        this.cameraArchiveSource = str4;
        this.cameraExportSource = str5;
    }

    public /* synthetic */ OpenStreamEvent(int i, Pair pair, String str, boolean z, String str2, String str3, Integer num, Boolean bool, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, pair, str, z, str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : bool, (i2 & 256) != 0 ? null : str4, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : str6);
    }

    public final int getStreamId() {
        return this.streamId;
    }

    public final Pair<Integer, Boolean> getBuildingServices() {
        return this.buildingServices;
    }

    public final String getStreamDescription() {
        return this.streamDescription;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final String getCameraUrl() {
        return this.cameraUrl;
    }

    public final String getIntercomVideoUrl() {
        return this.intercomVideoUrl;
    }

    public final Integer getGateId() {
        return this.gateId;
    }

    public final Boolean isFlussonic() {
        return this.isFlussonic;
    }

    public final String getCameraLiveSource() {
        return this.cameraLiveSource;
    }

    public final String getCameraArchiveSource() {
        return this.cameraArchiveSource;
    }

    public final String getCameraExportSource() {
        return this.cameraExportSource;
    }
}
