package ru.tattelecom.intercom.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: StreamDtos.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/domain/model/StreamSourceDto;", "", VideoPlayerViewModel.STREAM_URL, "", "axxonDto", "Lru/tattelecom/intercom/domain/model/StreamSourceDto$AxxonDto;", "(Ljava/lang/String;Lru/tattelecom/intercom/domain/model/StreamSourceDto$AxxonDto;)V", "getAxxonDto", "()Lru/tattelecom/intercom/domain/model/StreamSourceDto$AxxonDto;", "getStreamUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "AxxonDto", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StreamSourceDto {
    private final AxxonDto axxonDto;
    private final String streamUrl;

    public static /* synthetic */ StreamSourceDto copy$default(StreamSourceDto streamSourceDto, String str, AxxonDto axxonDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamSourceDto.streamUrl;
        }
        if ((i & 2) != 0) {
            axxonDto = streamSourceDto.axxonDto;
        }
        return streamSourceDto.copy(str, axxonDto);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final AxxonDto getAxxonDto() {
        return this.axxonDto;
    }

    public final StreamSourceDto copy(String streamUrl, AxxonDto axxonDto) {
        return new StreamSourceDto(streamUrl, axxonDto);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamSourceDto)) {
            return false;
        }
        StreamSourceDto streamSourceDto = (StreamSourceDto) other;
        return Intrinsics.areEqual(this.streamUrl, streamSourceDto.streamUrl) && Intrinsics.areEqual(this.axxonDto, streamSourceDto.axxonDto);
    }

    public int hashCode() {
        String str = this.streamUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        AxxonDto axxonDto = this.axxonDto;
        return hashCode + (axxonDto != null ? axxonDto.hashCode() : 0);
    }

    public String toString() {
        return "StreamSourceDto(streamUrl=" + this.streamUrl + ", axxonDto=" + this.axxonDto + ")";
    }

    public StreamSourceDto(String str, AxxonDto axxonDto) {
        this.streamUrl = str;
        this.axxonDto = axxonDto;
    }

    public /* synthetic */ StreamSourceDto(String str, AxxonDto axxonDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : axxonDto);
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final AxxonDto getAxxonDto() {
        return this.axxonDto;
    }

    /* compiled from: StreamDtos.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/domain/model/StreamSourceDto$AxxonDto;", "", "keepAliveMs", "", "keepAliveUrl", "", "stopUrl", "(JLjava/lang/String;Ljava/lang/String;)V", "getKeepAliveMs", "()J", "getKeepAliveUrl", "()Ljava/lang/String;", "getStopUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class AxxonDto {
        private final long keepAliveMs;
        private final String keepAliveUrl;
        private final String stopUrl;

        public AxxonDto() {
            this(0L, null, null, 7, null);
        }

        public static /* synthetic */ AxxonDto copy$default(AxxonDto axxonDto, long j, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                j = axxonDto.keepAliveMs;
            }
            if ((i & 2) != 0) {
                str = axxonDto.keepAliveUrl;
            }
            if ((i & 4) != 0) {
                str2 = axxonDto.stopUrl;
            }
            return axxonDto.copy(j, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final long getKeepAliveMs() {
            return this.keepAliveMs;
        }

        /* renamed from: component2, reason: from getter */
        public final String getKeepAliveUrl() {
            return this.keepAliveUrl;
        }

        /* renamed from: component3, reason: from getter */
        public final String getStopUrl() {
            return this.stopUrl;
        }

        public final AxxonDto copy(long keepAliveMs, String keepAliveUrl, String stopUrl) {
            Intrinsics.checkNotNullParameter(keepAliveUrl, "keepAliveUrl");
            Intrinsics.checkNotNullParameter(stopUrl, "stopUrl");
            return new AxxonDto(keepAliveMs, keepAliveUrl, stopUrl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AxxonDto)) {
                return false;
            }
            AxxonDto axxonDto = (AxxonDto) other;
            return this.keepAliveMs == axxonDto.keepAliveMs && Intrinsics.areEqual(this.keepAliveUrl, axxonDto.keepAliveUrl) && Intrinsics.areEqual(this.stopUrl, axxonDto.stopUrl);
        }

        public int hashCode() {
            return (((AdvThemeDto$$ExternalSyntheticBackport0.m(this.keepAliveMs) * 31) + this.keepAliveUrl.hashCode()) * 31) + this.stopUrl.hashCode();
        }

        public String toString() {
            return "AxxonDto(keepAliveMs=" + this.keepAliveMs + ", keepAliveUrl=" + this.keepAliveUrl + ", stopUrl=" + this.stopUrl + ")";
        }

        public AxxonDto(long j, String keepAliveUrl, String stopUrl) {
            Intrinsics.checkNotNullParameter(keepAliveUrl, "keepAliveUrl");
            Intrinsics.checkNotNullParameter(stopUrl, "stopUrl");
            this.keepAliveMs = j;
            this.keepAliveUrl = keepAliveUrl;
            this.stopUrl = stopUrl;
        }

        public /* synthetic */ AxxonDto(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 30L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
        }

        public final long getKeepAliveMs() {
            return this.keepAliveMs;
        }

        public final String getKeepAliveUrl() {
            return this.keepAliveUrl;
        }

        public final String getStopUrl() {
            return this.stopUrl;
        }
    }
}
