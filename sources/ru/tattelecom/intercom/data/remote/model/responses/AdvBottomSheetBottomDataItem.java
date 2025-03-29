package ru.tattelecom.intercom.data.remote.model.responses;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdvResponses.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002-.BU\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001J&\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+HÁ\u0001¢\u0006\u0002\b,R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011¨\u0006/"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;", "", "seen1", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "buttonTextColor", "titleColor", "descriptionColor", "buttonBackgroundColor", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBackgroundColor$annotations", "()V", "getBackgroundColor", "()Ljava/lang/String;", "getButtonBackgroundColor$annotations", "getButtonBackgroundColor", "getButtonTextColor$annotations", "getButtonTextColor", "getDescriptionColor$annotations", "getDescriptionColor", "getTitleColor$annotations", "getTitleColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetBottomDataItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String backgroundColor;
    private final String buttonBackgroundColor;
    private final String buttonTextColor;
    private final String descriptionColor;
    private final String titleColor;

    public AdvBottomSheetBottomDataItem() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AdvBottomSheetBottomDataItem copy$default(AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = advBottomSheetBottomDataItem.backgroundColor;
        }
        if ((i & 2) != 0) {
            str2 = advBottomSheetBottomDataItem.buttonTextColor;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = advBottomSheetBottomDataItem.titleColor;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = advBottomSheetBottomDataItem.descriptionColor;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = advBottomSheetBottomDataItem.buttonBackgroundColor;
        }
        return advBottomSheetBottomDataItem.copy(str, str6, str7, str8, str5);
    }

    @SerialName("background_color")
    public static /* synthetic */ void getBackgroundColor$annotations() {
    }

    @SerialName("button_background_color")
    public static /* synthetic */ void getButtonBackgroundColor$annotations() {
    }

    @SerialName("button_text_color")
    public static /* synthetic */ void getButtonTextColor$annotations() {
    }

    @SerialName("description_color")
    public static /* synthetic */ void getDescriptionColor$annotations() {
    }

    @SerialName("title_color")
    public static /* synthetic */ void getTitleColor$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component2, reason: from getter */
    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescriptionColor() {
        return this.descriptionColor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }

    public final AdvBottomSheetBottomDataItem copy(String r8, String buttonTextColor, String titleColor, String descriptionColor, String buttonBackgroundColor) {
        return new AdvBottomSheetBottomDataItem(r8, buttonTextColor, titleColor, descriptionColor, buttonBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetBottomDataItem)) {
            return false;
        }
        AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem = (AdvBottomSheetBottomDataItem) other;
        return Intrinsics.areEqual(this.backgroundColor, advBottomSheetBottomDataItem.backgroundColor) && Intrinsics.areEqual(this.buttonTextColor, advBottomSheetBottomDataItem.buttonTextColor) && Intrinsics.areEqual(this.titleColor, advBottomSheetBottomDataItem.titleColor) && Intrinsics.areEqual(this.descriptionColor, advBottomSheetBottomDataItem.descriptionColor) && Intrinsics.areEqual(this.buttonBackgroundColor, advBottomSheetBottomDataItem.buttonBackgroundColor);
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.buttonTextColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.descriptionColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buttonBackgroundColor;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "AdvBottomSheetBottomDataItem(backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ")";
    }

    /* compiled from: AdvResponses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdvBottomSheetBottomDataItem> serializer() {
            return AdvBottomSheetBottomDataItem$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AdvBottomSheetBottomDataItem(int i, @SerialName("background_color") String str, @SerialName("button_text_color") String str2, @SerialName("title_color") String str3, @SerialName("description_color") String str4, @SerialName("button_background_color") String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.backgroundColor = null;
        } else {
            this.backgroundColor = str;
        }
        if ((i & 2) == 0) {
            this.buttonTextColor = null;
        } else {
            this.buttonTextColor = str2;
        }
        if ((i & 4) == 0) {
            this.titleColor = null;
        } else {
            this.titleColor = str3;
        }
        if ((i & 8) == 0) {
            this.descriptionColor = null;
        } else {
            this.descriptionColor = str4;
        }
        if ((i & 16) == 0) {
            this.buttonBackgroundColor = null;
        } else {
            this.buttonBackgroundColor = str5;
        }
    }

    public AdvBottomSheetBottomDataItem(String str, String str2, String str3, String str4, String str5) {
        this.backgroundColor = str;
        this.buttonTextColor = str2;
        this.titleColor = str3;
        this.descriptionColor = str4;
        this.buttonBackgroundColor = str5;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AdvBottomSheetBottomDataItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.backgroundColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.backgroundColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.buttonTextColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.buttonTextColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.titleColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.titleColor);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.descriptionColor != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.descriptionColor);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.buttonBackgroundColor == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.buttonBackgroundColor);
    }

    public /* synthetic */ AdvBottomSheetBottomDataItem(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    public final String getTitleColor() {
        return this.titleColor;
    }

    public final String getDescriptionColor() {
        return this.descriptionColor;
    }

    public final String getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }
}
