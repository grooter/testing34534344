package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+BE\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013¨\u0006,"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;", "", "seen1", "", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "close", "openText", "", "closeText", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getClose", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCloseText$annotations", "()V", "getCloseText", "()Ljava/lang/String;", "getOpen", "getOpenText$annotations", "getOpenText", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class OfficeSchedule {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer close;
    private final String closeText;
    private final Integer open;
    private final String openText;

    public OfficeSchedule() {
        this((Integer) null, (Integer) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ OfficeSchedule copy$default(OfficeSchedule officeSchedule, Integer num, Integer num2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = officeSchedule.open;
        }
        if ((i & 2) != 0) {
            num2 = officeSchedule.close;
        }
        if ((i & 4) != 0) {
            str = officeSchedule.openText;
        }
        if ((i & 8) != 0) {
            str2 = officeSchedule.closeText;
        }
        return officeSchedule.copy(num, num2, str, str2);
    }

    @SerialName("close_text")
    public static /* synthetic */ void getCloseText$annotations() {
    }

    @SerialName("open_text")
    public static /* synthetic */ void getOpenText$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getOpen() {
        return this.open;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getClose() {
        return this.close;
    }

    /* renamed from: component3, reason: from getter */
    public final String getOpenText() {
        return this.openText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCloseText() {
        return this.closeText;
    }

    public final OfficeSchedule copy(Integer open, Integer close, String openText, String closeText) {
        return new OfficeSchedule(open, close, openText, closeText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficeSchedule)) {
            return false;
        }
        OfficeSchedule officeSchedule = (OfficeSchedule) other;
        return Intrinsics.areEqual(this.open, officeSchedule.open) && Intrinsics.areEqual(this.close, officeSchedule.close) && Intrinsics.areEqual(this.openText, officeSchedule.openText) && Intrinsics.areEqual(this.closeText, officeSchedule.closeText);
    }

    public int hashCode() {
        Integer num = this.open;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.close;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.openText;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.closeText;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "OfficeSchedule(open=" + this.open + ", close=" + this.close + ", openText=" + this.openText + ", closeText=" + this.closeText + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/OfficeSchedule$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OfficeSchedule> serializer() {
            return OfficeSchedule$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ OfficeSchedule(int i, Integer num, Integer num2, @SerialName("open_text") String str, @SerialName("close_text") String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.open = null;
        } else {
            this.open = num;
        }
        if ((i & 2) == 0) {
            this.close = null;
        } else {
            this.close = num2;
        }
        if ((i & 4) == 0) {
            this.openText = null;
        } else {
            this.openText = str;
        }
        if ((i & 8) == 0) {
            this.closeText = null;
        } else {
            this.closeText = str2;
        }
    }

    public OfficeSchedule(Integer num, Integer num2, String str, String str2) {
        this.open = num;
        this.close = num2;
        this.openText = str;
        this.closeText = str2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(OfficeSchedule self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.open != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.open);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.close != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.close);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.openText != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.openText);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.closeText == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.closeText);
    }

    public /* synthetic */ OfficeSchedule(Integer num, Integer num2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
    }

    public final Integer getOpen() {
        return this.open;
    }

    public final Integer getClose() {
        return this.close;
    }

    public final String getOpenText() {
        return this.openText;
    }

    public final String getCloseText() {
        return this.closeText;
    }
}
