package ru.tattelecom.intercom.data.remote.model.responses;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: AdvResponses.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 N2\u00020\u0001:\u0002MNB£\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018B\u0089\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0019J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\nHÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0099\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u0010A\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\u0003HÖ\u0001J\t\u0010D\u001a\u00020\nHÖ\u0001J&\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00002\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KHÁ\u0001¢\u0006\u0002\bLR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010 R\u001c\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010&R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001b\u001a\u0004\b\u0006\u0010+R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b0\u0010\u001b\u001a\u0004\b1\u00102¨\u0006O"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;", "", "seen1", "", TtmlNode.ATTR_ID, "", "isRead", "", "endDate", "title", "", "description", "buttonText", "type", "typeData", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetTypeData;", "titleAlign", "descriptionAlign", "image", RemoteMessageConst.Notification.ICON, "bottomData", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetTypeData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetTypeData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData;)V", "getBottomData$annotations", "()V", "getBottomData", "()Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomData;", "getButtonText$annotations", "getButtonText", "()Ljava/lang/String;", "getDescription", "getDescriptionAlign$annotations", "getDescriptionAlign", "getEndDate$annotations", "getEndDate", "()J", "getIcon", "getId", "getImage", "isRead$annotations", "()Z", "getTitle", "getTitleAlign$annotations", "getTitleAlign", "getType", "getTypeData$annotations", "getTypeData", "()Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetTypeData;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AdvBottomSheetBottomData bottomData;
    private final String buttonText;
    private final String description;
    private final String descriptionAlign;
    private final long endDate;
    private final String icon;
    private final long id;
    private final String image;
    private final boolean isRead;
    private final String title;
    private final String titleAlign;
    private final String type;
    private final AdvBottomSheetTypeData typeData;

    @SerialName("bottom_data")
    public static /* synthetic */ void getBottomData$annotations() {
    }

    @SerialName("button_text")
    public static /* synthetic */ void getButtonText$annotations() {
    }

    @SerialName("description_align")
    public static /* synthetic */ void getDescriptionAlign$annotations() {
    }

    @SerialName(FirebaseAnalytics.Param.END_DATE)
    public static /* synthetic */ void getEndDate$annotations() {
    }

    @SerialName("title_align")
    public static /* synthetic */ void getTitleAlign$annotations() {
    }

    @SerialName("type_data")
    public static /* synthetic */ void getTypeData$annotations() {
    }

    @SerialName("is_read")
    public static /* synthetic */ void isRead$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDescriptionAlign() {
        return this.descriptionAlign;
    }

    /* renamed from: component11, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component12, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component13, reason: from getter */
    public final AdvBottomSheetBottomData getBottomData() {
        return this.bottomData;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndDate() {
        return this.endDate;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final AdvBottomSheetTypeData getTypeData() {
        return this.typeData;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTitleAlign() {
        return this.titleAlign;
    }

    public final AdvBottomSheetData copy(long r18, boolean isRead, long endDate, String title, String description, String buttonText, String type, AdvBottomSheetTypeData typeData, String titleAlign, String descriptionAlign, String image, String r31, AdvBottomSheetBottomData bottomData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new AdvBottomSheetData(r18, isRead, endDate, title, description, buttonText, type, typeData, titleAlign, descriptionAlign, image, r31, bottomData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetData)) {
            return false;
        }
        AdvBottomSheetData advBottomSheetData = (AdvBottomSheetData) other;
        return this.id == advBottomSheetData.id && this.isRead == advBottomSheetData.isRead && this.endDate == advBottomSheetData.endDate && Intrinsics.areEqual(this.title, advBottomSheetData.title) && Intrinsics.areEqual(this.description, advBottomSheetData.description) && Intrinsics.areEqual(this.buttonText, advBottomSheetData.buttonText) && Intrinsics.areEqual(this.type, advBottomSheetData.type) && Intrinsics.areEqual(this.typeData, advBottomSheetData.typeData) && Intrinsics.areEqual(this.titleAlign, advBottomSheetData.titleAlign) && Intrinsics.areEqual(this.descriptionAlign, advBottomSheetData.descriptionAlign) && Intrinsics.areEqual(this.image, advBottomSheetData.image) && Intrinsics.areEqual(this.icon, advBottomSheetData.icon) && Intrinsics.areEqual(this.bottomData, advBottomSheetData.bottomData);
    }

    public int hashCode() {
        int m = ((((((((((AdvThemeDto$$ExternalSyntheticBackport0.m(this.id) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isRead)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.endDate)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.buttonText.hashCode()) * 31;
        String str = this.type;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        AdvBottomSheetTypeData advBottomSheetTypeData = this.typeData;
        int hashCode2 = (hashCode + (advBottomSheetTypeData == null ? 0 : advBottomSheetTypeData.hashCode())) * 31;
        String str2 = this.titleAlign;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.descriptionAlign;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.icon;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        AdvBottomSheetBottomData advBottomSheetBottomData = this.bottomData;
        return hashCode6 + (advBottomSheetBottomData != null ? advBottomSheetBottomData.hashCode() : 0);
    }

    public String toString() {
        return "AdvBottomSheetData(id=" + this.id + ", isRead=" + this.isRead + ", endDate=" + this.endDate + ", title=" + this.title + ", description=" + this.description + ", buttonText=" + this.buttonText + ", type=" + this.type + ", typeData=" + this.typeData + ", titleAlign=" + this.titleAlign + ", descriptionAlign=" + this.descriptionAlign + ", image=" + this.image + ", icon=" + this.icon + ", bottomData=" + this.bottomData + ")";
    }

    /* compiled from: AdvResponses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AdvBottomSheetData> serializer() {
            return AdvBottomSheetData$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AdvBottomSheetData(int i, long j, @SerialName("is_read") boolean z, @SerialName("end_date") long j2, String str, String str2, @SerialName("button_text") String str3, String str4, @SerialName("type_data") AdvBottomSheetTypeData advBottomSheetTypeData, @SerialName("title_align") String str5, @SerialName("description_align") String str6, String str7, String str8, @SerialName("bottom_data") AdvBottomSheetBottomData advBottomSheetBottomData, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, AdvBottomSheetData$$serializer.INSTANCE.getDescriptor());
        }
        this.id = j;
        this.isRead = z;
        this.endDate = j2;
        this.title = str;
        this.description = str2;
        this.buttonText = str3;
        if ((i & 64) == 0) {
            this.type = null;
        } else {
            this.type = str4;
        }
        if ((i & 128) == 0) {
            this.typeData = null;
        } else {
            this.typeData = advBottomSheetTypeData;
        }
        if ((i & 256) == 0) {
            this.titleAlign = null;
        } else {
            this.titleAlign = str5;
        }
        if ((i & 512) == 0) {
            this.descriptionAlign = null;
        } else {
            this.descriptionAlign = str6;
        }
        if ((i & 1024) == 0) {
            this.image = null;
        } else {
            this.image = str7;
        }
        if ((i & 2048) == 0) {
            this.icon = null;
        } else {
            this.icon = str8;
        }
        if ((i & 4096) == 0) {
            this.bottomData = null;
        } else {
            this.bottomData = advBottomSheetBottomData;
        }
    }

    public AdvBottomSheetData(long j, boolean z, long j2, String title, String description, String buttonText, String str, AdvBottomSheetTypeData advBottomSheetTypeData, String str2, String str3, String str4, String str5, AdvBottomSheetBottomData advBottomSheetBottomData) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.id = j;
        this.isRead = z;
        this.endDate = j2;
        this.title = title;
        this.description = description;
        this.buttonText = buttonText;
        this.type = str;
        this.typeData = advBottomSheetTypeData;
        this.titleAlign = str2;
        this.descriptionAlign = str3;
        this.image = str4;
        this.icon = str5;
        this.bottomData = advBottomSheetBottomData;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AdvBottomSheetData self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.id);
        output.encodeBooleanElement(serialDesc, 1, self.isRead);
        output.encodeLongElement(serialDesc, 2, self.endDate);
        output.encodeStringElement(serialDesc, 3, self.title);
        output.encodeStringElement(serialDesc, 4, self.description);
        output.encodeStringElement(serialDesc, 5, self.buttonText);
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.typeData != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, AdvBottomSheetTypeData$$serializer.INSTANCE, self.typeData);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.titleAlign != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.titleAlign);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.descriptionAlign != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.descriptionAlign);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.image != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.image);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.icon != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.icon);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 12) && self.bottomData == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 12, AdvBottomSheetBottomData$$serializer.INSTANCE, self.bottomData);
    }

    public /* synthetic */ AdvBottomSheetData(long j, boolean z, long j2, String str, String str2, String str3, String str4, AdvBottomSheetTypeData advBottomSheetTypeData, String str5, String str6, String str7, String str8, AdvBottomSheetBottomData advBottomSheetBottomData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, j2, str, str2, str3, (i & 64) != 0 ? null : str4, (i & 128) != 0 ? null : advBottomSheetTypeData, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? null : str6, (i & 1024) != 0 ? null : str7, (i & 2048) != 0 ? null : str8, (i & 4096) != 0 ? null : advBottomSheetBottomData);
    }

    public final long getId() {
        return this.id;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final long getEndDate() {
        return this.endDate;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getButtonText() {
        return this.buttonText;
    }

    public final String getType() {
        return this.type;
    }

    public final AdvBottomSheetTypeData getTypeData() {
        return this.typeData;
    }

    public final String getTitleAlign() {
        return this.titleAlign;
    }

    public final String getDescriptionAlign() {
        return this.descriptionAlign;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final AdvBottomSheetBottomData getBottomData() {
        return this.bottomData;
    }
}
