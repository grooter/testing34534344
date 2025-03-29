package ru.tattelecom.intercom.data.remote.model.responses;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdvResponses.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0002\u001f B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dHÁ\u0001¢\u0006\u0002\b\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006!"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData;", "", "seen1", "", "light", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;", "dark", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;)V", "getDark", "()Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;", "getLight", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetBottomData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdvBottomSheetBottomDataItem dark;
    private final AdvBottomSheetBottomDataItem light;

    public AdvBottomSheetBottomData() {
        this((AdvBottomSheetBottomDataItem) null, (AdvBottomSheetBottomDataItem) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdvBottomSheetBottomData copy$default(AdvBottomSheetBottomData advBottomSheetBottomData, AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem, AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem2, int i, Object obj) {
        if ((i & 1) != 0) {
            advBottomSheetBottomDataItem = advBottomSheetBottomData.light;
        }
        if ((i & 2) != 0) {
            advBottomSheetBottomDataItem2 = advBottomSheetBottomData.dark;
        }
        return advBottomSheetBottomData.copy(advBottomSheetBottomDataItem, advBottomSheetBottomDataItem2);
    }

    /* renamed from: component1, reason: from getter */
    public final AdvBottomSheetBottomDataItem getLight() {
        return this.light;
    }

    /* renamed from: component2, reason: from getter */
    public final AdvBottomSheetBottomDataItem getDark() {
        return this.dark;
    }

    public final AdvBottomSheetBottomData copy(AdvBottomSheetBottomDataItem light, AdvBottomSheetBottomDataItem dark) {
        return new AdvBottomSheetBottomData(light, dark);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetBottomData)) {
            return false;
        }
        AdvBottomSheetBottomData advBottomSheetBottomData = (AdvBottomSheetBottomData) other;
        return Intrinsics.areEqual(this.light, advBottomSheetBottomData.light) && Intrinsics.areEqual(this.dark, advBottomSheetBottomData.dark);
    }

    public int hashCode() {
        AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem = this.light;
        int hashCode = (advBottomSheetBottomDataItem == null ? 0 : advBottomSheetBottomDataItem.hashCode()) * 31;
        AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem2 = this.dark;
        return hashCode + (advBottomSheetBottomDataItem2 != null ? advBottomSheetBottomDataItem2.hashCode() : 0);
    }

    public String toString() {
        return "AdvBottomSheetBottomData(light=" + this.light + ", dark=" + this.dark + ")";
    }

    /* compiled from: AdvResponses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdvBottomSheetBottomData> serializer() {
            return AdvBottomSheetBottomData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AdvBottomSheetBottomData(int i, AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem, AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.light = null;
        } else {
            this.light = advBottomSheetBottomDataItem;
        }
        if ((i & 2) == 0) {
            this.dark = null;
        } else {
            this.dark = advBottomSheetBottomDataItem2;
        }
    }

    public AdvBottomSheetBottomData(AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem, AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem2) {
        this.light = advBottomSheetBottomDataItem;
        this.dark = advBottomSheetBottomDataItem2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AdvBottomSheetBottomData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.light != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, AdvBottomSheetBottomDataItem$$serializer.INSTANCE, self.light);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.dark == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, AdvBottomSheetBottomDataItem$$serializer.INSTANCE, self.dark);
    }

    public /* synthetic */ AdvBottomSheetBottomData(AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem, AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : advBottomSheetBottomDataItem, (i & 2) != 0 ? null : advBottomSheetBottomDataItem2);
    }

    public final AdvBottomSheetBottomDataItem getLight() {
        return this.light;
    }

    public final AdvBottomSheetBottomDataItem getDark() {
        return this.dark;
    }
}
