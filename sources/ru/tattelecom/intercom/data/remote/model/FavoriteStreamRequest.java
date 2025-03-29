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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B/\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000eR\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/FavoriteStreamRequest;", "", "seen1", "", "stream", "", "isFavorite", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Z)V", "isFavorite$annotations", "()V", "()Z", "getStream$annotations", "getStream", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class FavoriteStreamRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isFavorite;
    private final String stream;

    public static /* synthetic */ FavoriteStreamRequest copy$default(FavoriteStreamRequest favoriteStreamRequest, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = favoriteStreamRequest.stream;
        }
        if ((i & 2) != 0) {
            z = favoriteStreamRequest.isFavorite;
        }
        return favoriteStreamRequest.copy(str, z);
    }

    @SerialName("stream")
    public static /* synthetic */ void getStream$annotations() {
    }

    @SerialName("is_favorite")
    public static /* synthetic */ void isFavorite$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getStream() {
        return this.stream;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final FavoriteStreamRequest copy(String stream, boolean isFavorite) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        return new FavoriteStreamRequest(stream, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FavoriteStreamRequest)) {
            return false;
        }
        FavoriteStreamRequest favoriteStreamRequest = (FavoriteStreamRequest) other;
        return Intrinsics.areEqual(this.stream, favoriteStreamRequest.stream) && this.isFavorite == favoriteStreamRequest.isFavorite;
    }

    public int hashCode() {
        return (this.stream.hashCode() * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isFavorite);
    }

    public String toString() {
        return "FavoriteStreamRequest(stream=" + this.stream + ", isFavorite=" + this.isFavorite + ")";
    }

    /* compiled from: Requests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/FavoriteStreamRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/FavoriteStreamRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<FavoriteStreamRequest> serializer() {
            return FavoriteStreamRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ FavoriteStreamRequest(int i, @SerialName("stream") String str, @SerialName("is_favorite") boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, FavoriteStreamRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.stream = str;
        this.isFavorite = z;
    }

    public FavoriteStreamRequest(String stream, boolean z) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
        this.isFavorite = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(FavoriteStreamRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.stream);
        output.encodeBooleanElement(serialDesc, 1, self.isFavorite);
    }

    public final String getStream() {
        return this.stream;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }
}
