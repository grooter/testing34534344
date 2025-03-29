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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B;\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J2\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'HÁ\u0001¢\u0006\u0002\b(R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/StatusWithMessageResponse;", "", "seen1", "", "status", "", "errorCode", "errorText", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorCode$annotations", "()V", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorText$annotations", "getErrorText", "()Ljava/lang/String;", "getStatus", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lru/tattelecom/intercom/data/remote/model/StatusWithMessageResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class StatusWithMessageResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer errorCode;
    private final String errorText;
    private final Boolean status;

    public StatusWithMessageResponse() {
        this((Boolean) null, (Integer) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ StatusWithMessageResponse copy$default(StatusWithMessageResponse statusWithMessageResponse, Boolean bool, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = statusWithMessageResponse.status;
        }
        if ((i & 2) != 0) {
            num = statusWithMessageResponse.errorCode;
        }
        if ((i & 4) != 0) {
            str = statusWithMessageResponse.errorText;
        }
        return statusWithMessageResponse.copy(bool, num, str);
    }

    @SerialName("error_code")
    public static /* synthetic */ void getErrorCode$annotations() {
    }

    @SerialName("error_text")
    public static /* synthetic */ void getErrorText$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorText() {
        return this.errorText;
    }

    public final StatusWithMessageResponse copy(Boolean status, Integer errorCode, String errorText) {
        return new StatusWithMessageResponse(status, errorCode, errorText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatusWithMessageResponse)) {
            return false;
        }
        StatusWithMessageResponse statusWithMessageResponse = (StatusWithMessageResponse) other;
        return Intrinsics.areEqual(this.status, statusWithMessageResponse.status) && Intrinsics.areEqual(this.errorCode, statusWithMessageResponse.errorCode) && Intrinsics.areEqual(this.errorText, statusWithMessageResponse.errorText);
    }

    public int hashCode() {
        Boolean bool = this.status;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.errorCode;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.errorText;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "StatusWithMessageResponse(status=" + this.status + ", errorCode=" + this.errorCode + ", errorText=" + this.errorText + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/StatusWithMessageResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/StatusWithMessageResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<StatusWithMessageResponse> serializer() {
            return StatusWithMessageResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ StatusWithMessageResponse(int i, Boolean bool, @SerialName("error_code") Integer num, @SerialName("error_text") String str, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.status = null;
        } else {
            this.status = bool;
        }
        if ((i & 2) == 0) {
            this.errorCode = null;
        } else {
            this.errorCode = num;
        }
        if ((i & 4) == 0) {
            this.errorText = null;
        } else {
            this.errorText = str;
        }
    }

    public StatusWithMessageResponse(Boolean bool, Integer num, String str) {
        this.status = bool;
        this.errorCode = num;
        this.errorText = str;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(StatusWithMessageResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.status != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.errorCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.errorCode);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.errorText == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.errorText);
    }

    public /* synthetic */ StatusWithMessageResponse(Boolean bool, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str);
    }

    public final Boolean getStatus() {
        return this.status;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorText() {
        return this.errorText;
    }
}
