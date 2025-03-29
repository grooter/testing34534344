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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 22\u00020\u0001:\u000212BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003JJ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0007HÖ\u0001J&\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/HÁ\u0001¢\u0006\u0002\b0R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\u0016R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0016¨\u00063"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/StreamLiveResponse;", "", "seen1", "", "keepAliveSeconds", "", "keepAliveUrl", "", "stopUrl", VideoPlayerViewModel.STREAM_URL, "streamUrlMpeg", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKeepAliveSeconds$annotations", "()V", "getKeepAliveSeconds", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getKeepAliveUrl$annotations", "getKeepAliveUrl", "()Ljava/lang/String;", "getStopUrl$annotations", "getStopUrl", "getStreamUrl$annotations", "getStreamUrl", "getStreamUrlMpeg$annotations", "getStreamUrlMpeg", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/tattelecom/intercom/data/remote/model/StreamLiveResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StreamLiveResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long keepAliveSeconds;
    private final String keepAliveUrl;
    private final String stopUrl;
    private final String streamUrl;
    private final String streamUrlMpeg;

    public StreamLiveResponse() {
        this((Long) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StreamLiveResponse copy$default(StreamLiveResponse streamLiveResponse, Long l, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            l = streamLiveResponse.keepAliveSeconds;
        }
        if ((i & 2) != 0) {
            str = streamLiveResponse.keepAliveUrl;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = streamLiveResponse.stopUrl;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = streamLiveResponse.streamUrl;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = streamLiveResponse.streamUrlMpeg;
        }
        return streamLiveResponse.copy(l, str5, str6, str7, str4);
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

    @SerialName("stream_url_mpeg")
    public static /* synthetic */ void getStreamUrlMpeg$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Long getKeepAliveSeconds() {
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

    /* renamed from: component5, reason: from getter */
    public final String getStreamUrlMpeg() {
        return this.streamUrlMpeg;
    }

    public final StreamLiveResponse copy(Long keepAliveSeconds, String keepAliveUrl, String stopUrl, String streamUrl, String streamUrlMpeg) {
        return new StreamLiveResponse(keepAliveSeconds, keepAliveUrl, stopUrl, streamUrl, streamUrlMpeg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamLiveResponse)) {
            return false;
        }
        StreamLiveResponse streamLiveResponse = (StreamLiveResponse) other;
        return Intrinsics.areEqual(this.keepAliveSeconds, streamLiveResponse.keepAliveSeconds) && Intrinsics.areEqual(this.keepAliveUrl, streamLiveResponse.keepAliveUrl) && Intrinsics.areEqual(this.stopUrl, streamLiveResponse.stopUrl) && Intrinsics.areEqual(this.streamUrl, streamLiveResponse.streamUrl) && Intrinsics.areEqual(this.streamUrlMpeg, streamLiveResponse.streamUrlMpeg);
    }

    public int hashCode() {
        Long l = this.keepAliveSeconds;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.keepAliveUrl;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.stopUrl;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.streamUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.streamUrlMpeg;
        return hashCode4 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "StreamLiveResponse(keepAliveSeconds=" + this.keepAliveSeconds + ", keepAliveUrl=" + this.keepAliveUrl + ", stopUrl=" + this.stopUrl + ", streamUrl=" + this.streamUrl + ", streamUrlMpeg=" + this.streamUrlMpeg + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/StreamLiveResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/StreamLiveResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StreamLiveResponse> serializer() {
            return StreamLiveResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ StreamLiveResponse(int i, @SerialName("keep_alive_seconds") Long l, @SerialName("keep_alive_url") String str, @SerialName("stop_url") String str2, @SerialName("stream_url") String str3, @SerialName("stream_url_mpeg") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.keepAliveSeconds = null;
        } else {
            this.keepAliveSeconds = l;
        }
        if ((i & 2) == 0) {
            this.keepAliveUrl = null;
        } else {
            this.keepAliveUrl = str;
        }
        if ((i & 4) == 0) {
            this.stopUrl = null;
        } else {
            this.stopUrl = str2;
        }
        if ((i & 8) == 0) {
            this.streamUrl = null;
        } else {
            this.streamUrl = str3;
        }
        if ((i & 16) == 0) {
            this.streamUrlMpeg = null;
        } else {
            this.streamUrlMpeg = str4;
        }
    }

    public StreamLiveResponse(Long l, String str, String str2, String str3, String str4) {
        this.keepAliveSeconds = l;
        this.keepAliveUrl = str;
        this.stopUrl = str2;
        this.streamUrl = str3;
        this.streamUrlMpeg = str4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(StreamLiveResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.keepAliveSeconds != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, LongSerializer.INSTANCE, self.keepAliveSeconds);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.keepAliveUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.keepAliveUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.stopUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.stopUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.streamUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.streamUrl);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.streamUrlMpeg == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.streamUrlMpeg);
    }

    public /* synthetic */ StreamLiveResponse(Long l, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final Long getKeepAliveSeconds() {
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

    public final String getStreamUrlMpeg() {
        return this.streamUrlMpeg;
    }
}
