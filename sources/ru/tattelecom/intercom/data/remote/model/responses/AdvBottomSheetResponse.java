package ru.tattelecom.intercom.data.remote.model.responses;

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

/* compiled from: AdvResponses.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u001f\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J&\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 HÁ\u0001¢\u0006\u0002\b!R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetResponse;", "", "seen1", "", "success", "", "advData", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IZLru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ZLru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;)V", "getAdvData$annotations", "()V", "getAdvData", "()Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;", "getSuccess", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdvBottomSheetData advData;
    private final boolean success;

    public static /* synthetic */ AdvBottomSheetResponse copy$default(AdvBottomSheetResponse advBottomSheetResponse, boolean z, AdvBottomSheetData advBottomSheetData, int i, Object obj) {
        if ((i & 1) != 0) {
            z = advBottomSheetResponse.success;
        }
        if ((i & 2) != 0) {
            advBottomSheetData = advBottomSheetResponse.advData;
        }
        return advBottomSheetResponse.copy(z, advBottomSheetData);
    }

    @SerialName("data")
    public static /* synthetic */ void getAdvData$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final AdvBottomSheetData getAdvData() {
        return this.advData;
    }

    public final AdvBottomSheetResponse copy(boolean success, AdvBottomSheetData advData) {
        return new AdvBottomSheetResponse(success, advData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetResponse)) {
            return false;
        }
        AdvBottomSheetResponse advBottomSheetResponse = (AdvBottomSheetResponse) other;
        return this.success == advBottomSheetResponse.success && Intrinsics.areEqual(this.advData, advBottomSheetResponse.advData);
    }

    public int hashCode() {
        int m = AdvThemeDto$$ExternalSyntheticBackport0.m(this.success) * 31;
        AdvBottomSheetData advBottomSheetData = this.advData;
        return m + (advBottomSheetData == null ? 0 : advBottomSheetData.hashCode());
    }

    public String toString() {
        return "AdvBottomSheetResponse(success=" + this.success + ", advData=" + this.advData + ")";
    }

    /* compiled from: AdvResponses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdvBottomSheetResponse> serializer() {
            return AdvBottomSheetResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AdvBottomSheetResponse(int i, boolean z, @SerialName("data") AdvBottomSheetData advBottomSheetData, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, AdvBottomSheetResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.success = z;
        if ((i & 2) == 0) {
            this.advData = null;
        } else {
            this.advData = advBottomSheetData;
        }
    }

    public AdvBottomSheetResponse(boolean z, AdvBottomSheetData advBottomSheetData) {
        this.success = z;
        this.advData = advBottomSheetData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AdvBottomSheetResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeBooleanElement(serialDesc, 0, self.success);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.advData == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, AdvBottomSheetData$$serializer.INSTANCE, self.advData);
    }

    public /* synthetic */ AdvBottomSheetResponse(boolean z, AdvBottomSheetData advBottomSheetData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : advBottomSheetData);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final AdvBottomSheetData getAdvData() {
        return this.advData;
    }
}
