package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.exoplayer.rtsp.SessionDescription;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002'(BE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB'\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J&\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÁ\u0001¢\u0006\u0002\b&R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStartRequest;", "", "seen1", "", "source", "", "type", "startTime", "duration", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDuration$annotations", "()V", "getDuration", "()Ljava/lang/String;", "getSource", "getStartTime$annotations", "getStartTime", "getType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ArchiveDownloadStartRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String duration;
    private final String source;
    private final String startTime;
    private final String type;

    public static /* synthetic */ ArchiveDownloadStartRequest copy$default(ArchiveDownloadStartRequest archiveDownloadStartRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveDownloadStartRequest.source;
        }
        if ((i & 2) != 0) {
            str2 = archiveDownloadStartRequest.type;
        }
        if ((i & 4) != 0) {
            str3 = archiveDownloadStartRequest.startTime;
        }
        if ((i & 8) != 0) {
            str4 = archiveDownloadStartRequest.duration;
        }
        return archiveDownloadStartRequest.copy(str, str2, str3, str4);
    }

    @SerialName(SessionDescription.ATTR_LENGTH)
    public static /* synthetic */ void getDuration$annotations() {
    }

    @SerialName("start_time")
    public static /* synthetic */ void getStartTime$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component2, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDuration() {
        return this.duration;
    }

    public final ArchiveDownloadStartRequest copy(String source, String type, String startTime, String duration) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(duration, "duration");
        return new ArchiveDownloadStartRequest(source, type, startTime, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchiveDownloadStartRequest)) {
            return false;
        }
        ArchiveDownloadStartRequest archiveDownloadStartRequest = (ArchiveDownloadStartRequest) other;
        return Intrinsics.areEqual(this.source, archiveDownloadStartRequest.source) && Intrinsics.areEqual(this.type, archiveDownloadStartRequest.type) && Intrinsics.areEqual(this.startTime, archiveDownloadStartRequest.startTime) && Intrinsics.areEqual(this.duration, archiveDownloadStartRequest.duration);
    }

    public int hashCode() {
        String str = this.source;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.duration.hashCode();
    }

    public String toString() {
        return "ArchiveDownloadStartRequest(source=" + this.source + ", type=" + this.type + ", startTime=" + this.startTime + ", duration=" + this.duration + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStartRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStartRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchiveDownloadStartRequest> serializer() {
            return ArchiveDownloadStartRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ArchiveDownloadStartRequest(int i, String str, String str2, @SerialName("start_time") String str3, @SerialName("length") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, ArchiveDownloadStartRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.source = str;
        this.type = str2;
        this.startTime = str3;
        this.duration = str4;
    }

    public ArchiveDownloadStartRequest(String str, String type, String startTime, String duration) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(duration, "duration");
        this.source = str;
        this.type = type;
        this.startTime = startTime;
        this.duration = duration;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ArchiveDownloadStartRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.source);
        output.encodeStringElement(serialDesc, 1, self.type);
        output.encodeStringElement(serialDesc, 2, self.startTime);
        output.encodeStringElement(serialDesc, 3, self.duration);
    }

    public final String getSource() {
        return this.source;
    }

    public final String getType() {
        return this.type;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getDuration() {
        return this.duration;
    }
}
