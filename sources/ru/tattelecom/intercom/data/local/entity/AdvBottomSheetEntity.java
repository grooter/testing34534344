package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: AdvEntities.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0015J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u0011\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\bHÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\bHÆ\u0003J«\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0010HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006:"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetEntity;", "", TtmlNode.ATTR_ID, "", "isRead", "", "endDate", "title", "", "description", "buttonText", "type", "typeDataUrl", "typeDataScreen", "typeDataSelectedServices", "", "", "titleAlign", "descriptionAlign", "image", RemoteMessageConst.Notification.ICON, "(JZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getButtonText", "()Ljava/lang/String;", "getDescription", "getDescriptionAlign", "getEndDate", "()J", "getIcon", "getId", "getImage", "()Z", "getTitle", "getTitleAlign", "getType", "getTypeDataScreen", "getTypeDataSelectedServices", "()Ljava/util/List;", "getTypeDataUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetEntity {
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
    private final String typeDataScreen;
    private final List<Integer> typeDataSelectedServices;
    private final String typeDataUrl;

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final List<Integer> component10() {
        return this.typeDataSelectedServices;
    }

    /* renamed from: component11, reason: from getter */
    public final String getTitleAlign() {
        return this.titleAlign;
    }

    /* renamed from: component12, reason: from getter */
    public final String getDescriptionAlign() {
        return this.descriptionAlign;
    }

    /* renamed from: component13, reason: from getter */
    public final String getImage() {
        return this.image;
    }

    /* renamed from: component14, reason: from getter */
    public final String getIcon() {
        return this.icon;
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
    public final String getTypeDataUrl() {
        return this.typeDataUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTypeDataScreen() {
        return this.typeDataScreen;
    }

    public final AdvBottomSheetEntity copy(long id, boolean isRead, long endDate, String title, String description, String buttonText, String type, String typeDataUrl, String typeDataScreen, List<Integer> typeDataSelectedServices, String titleAlign, String descriptionAlign, String image, String icon) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        return new AdvBottomSheetEntity(id, isRead, endDate, title, description, buttonText, type, typeDataUrl, typeDataScreen, typeDataSelectedServices, titleAlign, descriptionAlign, image, icon);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetEntity)) {
            return false;
        }
        AdvBottomSheetEntity advBottomSheetEntity = (AdvBottomSheetEntity) other;
        return this.id == advBottomSheetEntity.id && this.isRead == advBottomSheetEntity.isRead && this.endDate == advBottomSheetEntity.endDate && Intrinsics.areEqual(this.title, advBottomSheetEntity.title) && Intrinsics.areEqual(this.description, advBottomSheetEntity.description) && Intrinsics.areEqual(this.buttonText, advBottomSheetEntity.buttonText) && Intrinsics.areEqual(this.type, advBottomSheetEntity.type) && Intrinsics.areEqual(this.typeDataUrl, advBottomSheetEntity.typeDataUrl) && Intrinsics.areEqual(this.typeDataScreen, advBottomSheetEntity.typeDataScreen) && Intrinsics.areEqual(this.typeDataSelectedServices, advBottomSheetEntity.typeDataSelectedServices) && Intrinsics.areEqual(this.titleAlign, advBottomSheetEntity.titleAlign) && Intrinsics.areEqual(this.descriptionAlign, advBottomSheetEntity.descriptionAlign) && Intrinsics.areEqual(this.image, advBottomSheetEntity.image) && Intrinsics.areEqual(this.icon, advBottomSheetEntity.icon);
    }

    public int hashCode() {
        int m = ((((((((((AdvThemeDto$$ExternalSyntheticBackport0.m(this.id) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isRead)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.endDate)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31) + this.buttonText.hashCode()) * 31;
        String str = this.type;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.typeDataUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.typeDataScreen;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Integer> list = this.typeDataSelectedServices;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str4 = this.titleAlign;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.descriptionAlign;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.image;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.icon;
        return hashCode7 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "AdvBottomSheetEntity(id=" + this.id + ", isRead=" + this.isRead + ", endDate=" + this.endDate + ", title=" + this.title + ", description=" + this.description + ", buttonText=" + this.buttonText + ", type=" + this.type + ", typeDataUrl=" + this.typeDataUrl + ", typeDataScreen=" + this.typeDataScreen + ", typeDataSelectedServices=" + this.typeDataSelectedServices + ", titleAlign=" + this.titleAlign + ", descriptionAlign=" + this.descriptionAlign + ", image=" + this.image + ", icon=" + this.icon + ")";
    }

    public AdvBottomSheetEntity(long j, boolean z, long j2, String title, String description, String buttonText, String str, String str2, String str3, List<Integer> list, String str4, String str5, String str6, String str7) {
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
        this.typeDataUrl = str2;
        this.typeDataScreen = str3;
        this.typeDataSelectedServices = list;
        this.titleAlign = str4;
        this.descriptionAlign = str5;
        this.image = str6;
        this.icon = str7;
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

    public final String getTypeDataUrl() {
        return this.typeDataUrl;
    }

    public final String getTypeDataScreen() {
        return this.typeDataScreen;
    }

    public final List<Integer> getTypeDataSelectedServices() {
        return this.typeDataSelectedServices;
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
}
