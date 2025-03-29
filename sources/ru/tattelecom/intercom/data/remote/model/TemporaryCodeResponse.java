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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 $2\u00020\u0001:\u0002#$B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!HÁ\u0001¢\u0006\u0002\b\"R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006%"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/TemporaryCodeResponse;", "", "seen1", "", NavArg.VerifyCode.APARTMENT_ID, "intercomTemporaryCode", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getApartmentId$annotations", "()V", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIntercomTemporaryCode$annotations", "getIntercomTemporaryCode", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/TemporaryCodeResponse;", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class TemporaryCodeResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apartmentId;
    private final Integer intercomTemporaryCode;

    public TemporaryCodeResponse() {
        this((Integer) null, (Integer) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ TemporaryCodeResponse copy$default(TemporaryCodeResponse temporaryCodeResponse, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = temporaryCodeResponse.apartmentId;
        }
        if ((i & 2) != 0) {
            num2 = temporaryCodeResponse.intercomTemporaryCode;
        }
        return temporaryCodeResponse.copy(num, num2);
    }

    @SerialName("apartment_id")
    public static /* synthetic */ void getApartmentId$annotations() {
    }

    @SerialName("door_code")
    public static /* synthetic */ void getIntercomTemporaryCode$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getApartmentId() {
        return this.apartmentId;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }

    public final TemporaryCodeResponse copy(Integer apartmentId, Integer intercomTemporaryCode) {
        return new TemporaryCodeResponse(apartmentId, intercomTemporaryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemporaryCodeResponse)) {
            return false;
        }
        TemporaryCodeResponse temporaryCodeResponse = (TemporaryCodeResponse) other;
        return Intrinsics.areEqual(this.apartmentId, temporaryCodeResponse.apartmentId) && Intrinsics.areEqual(this.intercomTemporaryCode, temporaryCodeResponse.intercomTemporaryCode);
    }

    public int hashCode() {
        Integer num = this.apartmentId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.intercomTemporaryCode;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "TemporaryCodeResponse(apartmentId=" + this.apartmentId + ", intercomTemporaryCode=" + this.intercomTemporaryCode + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/TemporaryCodeResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/TemporaryCodeResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TemporaryCodeResponse> serializer() {
            return TemporaryCodeResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TemporaryCodeResponse(int i, @SerialName("apartment_id") Integer num, @SerialName("door_code") Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.apartmentId = null;
        } else {
            this.apartmentId = num;
        }
        if ((i & 2) == 0) {
            this.intercomTemporaryCode = null;
        } else {
            this.intercomTemporaryCode = num2;
        }
    }

    public TemporaryCodeResponse(Integer num, Integer num2) {
        this.apartmentId = num;
        this.intercomTemporaryCode = num2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(TemporaryCodeResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.apartmentId != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.apartmentId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.intercomTemporaryCode == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.intercomTemporaryCode);
    }

    public /* synthetic */ TemporaryCodeResponse(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public final Integer getApartmentId() {
        return this.apartmentId;
    }

    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }
}
