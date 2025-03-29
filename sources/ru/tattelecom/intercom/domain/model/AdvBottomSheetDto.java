package ru.tattelecom.intercom.domain.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: AdvBottomSheetDtos.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0012¢\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u0012HÆ\u0003J\t\u00100\u001a\u00020\u0012HÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\t\u00102\u001a\u00020\u0012HÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jµ\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0012HÆ\u0001J\u0013\u0010=\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\u0012HÖ\u0001J\t\u0010@\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006A"}, d2 = {"Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "", TtmlNode.ATTR_ID, "", "isRead", "", "title", "", "description", "buttonText", "type", "typeData", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDataDto;", "titleAlign", "descriptionAlign", "image", RemoteMessageConst.Notification.ICON, TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "buttonTextColor", "titleColor", "descriptionColor", "buttonBackgroundColor", "(JZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/domain/model/AdvBottomSheetDataDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIII)V", "getBackgroundColor", "()I", "getButtonBackgroundColor", "getButtonText", "()Ljava/lang/String;", "getButtonTextColor", "getDescription", "getDescriptionAlign", "getDescriptionColor", "getIcon", "getId", "()J", "getImage", "()Z", "getTitle", "getTitleAlign", "getTitleColor", "getType", "getTypeData", "()Lru/tattelecom/intercom/domain/model/AdvBottomSheetDataDto;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetDto {
    private final int backgroundColor;
    private final int buttonBackgroundColor;
    private final String buttonText;
    private final int buttonTextColor;
    private final String description;
    private final String descriptionAlign;
    private final int descriptionColor;
    private final String icon;
    private final long id;
    private final String image;
    private final boolean isRead;
    private final String title;
    private final String titleAlign;
    private final int titleColor;
    private final String type;
    private final AdvBottomSheetDataDto typeData;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component11, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component12, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component13, reason: from getter */
    public final int getButtonTextColor() {
        return this.buttonTextColor;
    }

    /* renamed from: component14, reason: from getter */
    public final int getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component15, reason: from getter */
    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    /* renamed from: component16, reason: from getter */
    public final int getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component5, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    /* renamed from: component6, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component7, reason: from getter */
    public final AdvBottomSheetDataDto getTypeData() {
        return this.typeData;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTitleAlign() {
        return this.titleAlign;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescriptionAlign() {
        return this.descriptionAlign;
    }

    public final AdvBottomSheetDto copy(long id, boolean isRead, String title, String description, String buttonText, String type, AdvBottomSheetDataDto typeData, String titleAlign, String descriptionAlign, String image, String icon, int backgroundColor, int buttonTextColor, int titleColor, int descriptionColor, int buttonBackgroundColor) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new AdvBottomSheetDto(id, isRead, title, description, buttonText, type, typeData, titleAlign, descriptionAlign, image, icon, backgroundColor, buttonTextColor, titleColor, descriptionColor, buttonBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetDto)) {
            return false;
        }
        AdvBottomSheetDto advBottomSheetDto = (AdvBottomSheetDto) other;
        return this.id == advBottomSheetDto.id && this.isRead == advBottomSheetDto.isRead && Intrinsics.areEqual(this.title, advBottomSheetDto.title) && Intrinsics.areEqual(this.description, advBottomSheetDto.description) && Intrinsics.areEqual(this.buttonText, advBottomSheetDto.buttonText) && Intrinsics.areEqual(this.type, advBottomSheetDto.type) && Intrinsics.areEqual(this.typeData, advBottomSheetDto.typeData) && Intrinsics.areEqual(this.titleAlign, advBottomSheetDto.titleAlign) && Intrinsics.areEqual(this.descriptionAlign, advBottomSheetDto.descriptionAlign) && Intrinsics.areEqual(this.image, advBottomSheetDto.image) && Intrinsics.areEqual(this.icon, advBottomSheetDto.icon) && this.backgroundColor == advBottomSheetDto.backgroundColor && this.buttonTextColor == advBottomSheetDto.buttonTextColor && this.titleColor == advBottomSheetDto.titleColor && this.descriptionColor == advBottomSheetDto.descriptionColor && this.buttonBackgroundColor == advBottomSheetDto.buttonBackgroundColor;
    }

    public int hashCode() {
        int m = ((((((((AdvThemeDto$$ExternalSyntheticBackport0.m(this.id) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isRead)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.buttonText.hashCode()) * 31;
        String str = this.type;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        AdvBottomSheetDataDto advBottomSheetDataDto = this.typeData;
        int hashCode2 = (hashCode + (advBottomSheetDataDto == null ? 0 : advBottomSheetDataDto.hashCode())) * 31;
        String str2 = this.titleAlign;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.descriptionAlign;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.image;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.icon;
        return ((((((((((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.backgroundColor) * 31) + this.buttonTextColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.buttonBackgroundColor;
    }

    public String toString() {
        return "AdvBottomSheetDto(id=" + this.id + ", isRead=" + this.isRead + ", title=" + this.title + ", description=" + this.description + ", buttonText=" + this.buttonText + ", type=" + this.type + ", typeData=" + this.typeData + ", titleAlign=" + this.titleAlign + ", descriptionAlign=" + this.descriptionAlign + ", image=" + this.image + ", icon=" + this.icon + ", backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ")";
    }

    public AdvBottomSheetDto(long j, boolean z, String title, String description, String buttonText, String str, AdvBottomSheetDataDto advBottomSheetDataDto, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        this.id = j;
        this.isRead = z;
        this.title = title;
        this.description = description;
        this.buttonText = buttonText;
        this.type = str;
        this.typeData = advBottomSheetDataDto;
        this.titleAlign = str2;
        this.descriptionAlign = str3;
        this.image = str4;
        this.icon = str5;
        this.backgroundColor = i;
        this.buttonTextColor = i2;
        this.titleColor = i3;
        this.descriptionColor = i4;
        this.buttonBackgroundColor = i5;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean isRead() {
        return this.isRead;
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

    public final AdvBottomSheetDataDto getTypeData() {
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

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getButtonTextColor() {
        return this.buttonTextColor;
    }

    public final int getTitleColor() {
        return this.titleColor;
    }

    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    public final int getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }
}
