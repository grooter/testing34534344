package ru.tattelecom.intercom.data.remote.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,BG\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB-\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J1\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÁ\u0001¢\u0006\u0002\b*R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0014¨\u0006-"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ArchiveStreamResponse;", "", "seen1", "", "keepAliveSeconds", "", "keepAliveUrl", "", "stopUrl", VideoPlayerViewModel.STREAM_URL, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKeepAliveSeconds$annotations", "()V", "getKeepAliveSeconds", "()J", "getKeepAliveUrl$annotations", "getKeepAliveUrl", "()Ljava/lang/String;", "getStopUrl$annotations", "getStopUrl", "getStreamUrl$annotations", "getStreamUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ArchiveStreamResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long keepAliveSeconds;
    private final String keepAliveUrl;
    private final String stopUrl;
    private final String streamUrl;

    public ArchiveStreamResponse() {
        this(0L, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ArchiveStreamResponse copy$default(ArchiveStreamResponse archiveStreamResponse, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = archiveStreamResponse.keepAliveSeconds;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = archiveStreamResponse.keepAliveUrl;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = archiveStreamResponse.stopUrl;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = archiveStreamResponse.streamUrl;
        }
        return archiveStreamResponse.copy(j2, str4, str5, str3);
    }

    @SerialName("keep_alive_seconds")
    public static /* synthetic */ void getKeepAliveSeconds$annotations() {
    }

    @SerialName("keep_alive_url")
    public static /* synthetic */ void getKeepAliveUrl$annotations() {
    }

    @SerialName("stop_url")
    public static /* synthetic */ void getStopUrl$annotations() {
    }

    @SerialName("stream_url")
    public static /* synthetic */ void getStreamUrl$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getKeepAliveSeconds() {
        return this.keepAliveSeconds;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKeepAliveUrl() {
        return this.keepAliveUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStopUrl() {
        return this.stopUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final ArchiveStreamResponse copy(long keepAliveSeconds, String keepAliveUrl, String stopUrl, String streamUrl) {
        Intrinsics.checkNotNullParameter(keepAliveUrl, "keepAliveUrl");
        Intrinsics.checkNotNullParameter(stopUrl, "stopUrl");
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        return new ArchiveStreamResponse(keepAliveSeconds, keepAliveUrl, stopUrl, streamUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchiveStreamResponse)) {
            return false;
        }
        ArchiveStreamResponse archiveStreamResponse = (ArchiveStreamResponse) other;
        return this.keepAliveSeconds == archiveStreamResponse.keepAliveSeconds && Intrinsics.areEqual(this.keepAliveUrl, archiveStreamResponse.keepAliveUrl) && Intrinsics.areEqual(this.stopUrl, archiveStreamResponse.stopUrl) && Intrinsics.areEqual(this.streamUrl, archiveStreamResponse.streamUrl);
    }

    public int hashCode() {
        return (((((AdvThemeDto$$ExternalSyntheticBackport0.m(this.keepAliveSeconds) * 31) + this.keepAliveUrl.hashCode()) * 31) + this.stopUrl.hashCode()) * 31) + this.streamUrl.hashCode();
    }

    public String toString() {
        return "ArchiveStreamResponse(keepAliveSeconds=" + this.keepAliveSeconds + ", keepAliveUrl=" + this.keepAliveUrl + ", stopUrl=" + this.stopUrl + ", streamUrl=" + this.streamUrl + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ArchiveStreamResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ArchiveStreamResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchiveStreamResponse> serializer() {
            return ArchiveStreamResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ArchiveStreamResponse(int i, @SerialName("keep_alive_seconds") long j, @SerialName("keep_alive_url") String str, @SerialName("stop_url") String str2, @SerialName("stream_url") String str3, SerializationConstructorMarker serializationConstructorMarker) {
        this.keepAliveSeconds = (i & 1) == 0 ? 60L : j;
        if ((i & 2) == 0) {
            this.keepAliveUrl = "";
        } else {
            this.keepAliveUrl = str;
        }
        if ((i & 4) == 0) {
            this.stopUrl = "";
        } else {
            this.stopUrl = str2;
        }
        if ((i & 8) == 0) {
            this.streamUrl = "";
        } else {
            this.streamUrl = str3;
        }
    }

    public ArchiveStreamResponse(long j, String keepAliveUrl, String stopUrl, String streamUrl) {
        Intrinsics.checkNotNullParameter(keepAliveUrl, "keepAliveUrl");
        Intrinsics.checkNotNullParameter(stopUrl, "stopUrl");
        Intrinsics.checkNotNullParameter(streamUrl, "streamUrl");
        this.keepAliveSeconds = j;
        this.keepAliveUrl = keepAliveUrl;
        this.stopUrl = stopUrl;
        this.streamUrl = streamUrl;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ArchiveStreamResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.keepAliveSeconds != 60) {
            output.encodeLongElement(serialDesc, 0, self.keepAliveSeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual(self.keepAliveUrl, "")) {
            output.encodeStringElement(serialDesc, 1, self.keepAliveUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual(self.stopUrl, "")) {
            output.encodeStringElement(serialDesc, 2, self.stopUrl);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && Intrinsics.areEqual(self.streamUrl, "")) {
            return;
        }
        output.encodeStringElement(serialDesc, 3, self.streamUrl);
    }

    public /* synthetic */ ArchiveStreamResponse(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 60L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final long getKeepAliveSeconds() {
        return this.keepAliveSeconds;
    }

    public final String getKeepAliveUrl() {
        return this.keepAliveUrl;
    }

    public final String getStopUrl() {
        return this.stopUrl;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }
}
