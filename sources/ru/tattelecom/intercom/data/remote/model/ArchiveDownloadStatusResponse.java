package ru.tattelecom.intercom.data.remote.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0002 !B+\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eHÁ\u0001¢\u0006\u0002\b\u001fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStatusResponse;", "", "seen1", "", "url", "", "loading", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;DLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;D)V", "getLoading", "()D", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ArchiveDownloadStatusResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double loading;
    private final String url;

    public static /* synthetic */ ArchiveDownloadStatusResponse copy$default(ArchiveDownloadStatusResponse archiveDownloadStatusResponse, String str, double d, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveDownloadStatusResponse.url;
        }
        if ((i & 2) != 0) {
            d = archiveDownloadStatusResponse.loading;
        }
        return archiveDownloadStatusResponse.copy(str, d);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final double getLoading() {
        return this.loading;
    }

    public final ArchiveDownloadStatusResponse copy(String url, double loading) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new ArchiveDownloadStatusResponse(url, loading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchiveDownloadStatusResponse)) {
            return false;
        }
        ArchiveDownloadStatusResponse archiveDownloadStatusResponse = (ArchiveDownloadStatusResponse) other;
        return Intrinsics.areEqual(this.url, archiveDownloadStatusResponse.url) && Double.compare(this.loading, archiveDownloadStatusResponse.loading) == 0;
    }

    public int hashCode() {
        return (this.url.hashCode() * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.loading);
    }

    public String toString() {
        return "ArchiveDownloadStatusResponse(url=" + this.url + ", loading=" + this.loading + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStatusResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStatusResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ArchiveDownloadStatusResponse> serializer() {
            return ArchiveDownloadStatusResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ArchiveDownloadStatusResponse(int i, String str, double d, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, ArchiveDownloadStatusResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.url = str;
        this.loading = d;
    }

    public ArchiveDownloadStatusResponse(String url, double d) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.loading = d;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ArchiveDownloadStatusResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.url);
        output.encodeDoubleElement(serialDesc, 1, self.loading);
    }

    public final String getUrl() {
        return this.url;
    }

    public final double getLoading() {
        return this.loading;
    }
}
