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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B-\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J&\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fHÁ\u0001¢\u0006\u0002\b R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006#"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;", "", "seen1", "", "lat", "", "long", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Double;Ljava/lang/Double;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getLat", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLong", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class OfficeLatlong {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Double lat;
    private final Double long;

    public OfficeLatlong() {
        this((Double) null, (Double) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ OfficeLatlong copy$default(OfficeLatlong officeLatlong, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = officeLatlong.lat;
        }
        if ((i & 2) != 0) {
            d2 = officeLatlong.long;
        }
        return officeLatlong.copy(d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final Double getLat() {
        return this.lat;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getLong() {
        return this.long;
    }

    public final OfficeLatlong copy(Double lat, Double r3) {
        return new OfficeLatlong(lat, r3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficeLatlong)) {
            return false;
        }
        OfficeLatlong officeLatlong = (OfficeLatlong) other;
        return Intrinsics.areEqual((Object) this.lat, (Object) officeLatlong.lat) && Intrinsics.areEqual((Object) this.long, (Object) officeLatlong.long);
    }

    public int hashCode() {
        Double d = this.lat;
        int hashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.long;
        return hashCode + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "OfficeLatlong(lat=" + this.lat + ", long=" + this.long + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/OfficeLatlong$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/OfficeLatlong;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OfficeLatlong> serializer() {
            return OfficeLatlong$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ OfficeLatlong(int i, Double d, Double d2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.lat = null;
        } else {
            this.lat = d;
        }
        if ((i & 2) == 0) {
            this.long = null;
        } else {
            this.long = d2;
        }
    }

    public OfficeLatlong(Double d, Double d2) {
        this.lat = d;
        this.long = d2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(OfficeLatlong self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.lat != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, DoubleSerializer.INSTANCE, self.lat);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.long == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, DoubleSerializer.INSTANCE, self.long);
    }

    public /* synthetic */ OfficeLatlong(Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2);
    }

    public final Double getLat() {
        return this.lat;
    }

    public final Double getLong() {
        return this.long;
    }
}
