package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: AdvEntities.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignEntity;", "", "advBottomSheetId", "", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "buttonTextColor", "titleColor", "descriptionColor", "buttonBackgroundColor", "(JLru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdvBottomSheetId", "()J", "getBackgroundColor", "()Ljava/lang/String;", "getButtonBackgroundColor", "getButtonTextColor", "getDescriptionColor", "getTheme", "()Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "getTitleColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdvBottomSheetDesignEntity {
    private final long advBottomSheetId;
    private final String backgroundColor;
    private final String buttonBackgroundColor;
    private final String buttonTextColor;
    private final String descriptionColor;
    private final AdvBottomSheetDesignTheme theme;
    private final String titleColor;

    /* renamed from: component1, reason: from getter */
    public final long getAdvBottomSheetId() {
        return this.advBottomSheetId;
    }

    /* renamed from: component2, reason: from getter */
    public final AdvBottomSheetDesignTheme getTheme() {
        return this.theme;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component4, reason: from getter */
    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDescriptionColor() {
        return this.descriptionColor;
    }

    /* renamed from: component7, reason: from getter */
    public final String getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }

    public final AdvBottomSheetDesignEntity copy(long advBottomSheetId, AdvBottomSheetDesignTheme theme, String backgroundColor, String buttonTextColor, String titleColor, String descriptionColor, String buttonBackgroundColor) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        return new AdvBottomSheetDesignEntity(advBottomSheetId, theme, backgroundColor, buttonTextColor, titleColor, descriptionColor, buttonBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvBottomSheetDesignEntity)) {
            return false;
        }
        AdvBottomSheetDesignEntity advBottomSheetDesignEntity = (AdvBottomSheetDesignEntity) other;
        return this.advBottomSheetId == advBottomSheetDesignEntity.advBottomSheetId && this.theme == advBottomSheetDesignEntity.theme && Intrinsics.areEqual(this.backgroundColor, advBottomSheetDesignEntity.backgroundColor) && Intrinsics.areEqual(this.buttonTextColor, advBottomSheetDesignEntity.buttonTextColor) && Intrinsics.areEqual(this.titleColor, advBottomSheetDesignEntity.titleColor) && Intrinsics.areEqual(this.descriptionColor, advBottomSheetDesignEntity.descriptionColor) && Intrinsics.areEqual(this.buttonBackgroundColor, advBottomSheetDesignEntity.buttonBackgroundColor);
    }

    public int hashCode() {
        int m = ((AdvThemeDto$$ExternalSyntheticBackport0.m(this.advBottomSheetId) * 31) + this.theme.hashCode()) * 31;
        String str = this.backgroundColor;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
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
        return "AdvBottomSheetDesignEntity(advBottomSheetId=" + this.advBottomSheetId + ", theme=" + this.theme + ", backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ")";
    }

    public AdvBottomSheetDesignEntity(long j, AdvBottomSheetDesignTheme theme, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.advBottomSheetId = j;
        this.theme = theme;
        this.backgroundColor = str;
        this.buttonTextColor = str2;
        this.titleColor = str3;
        this.descriptionColor = str4;
        this.buttonBackgroundColor = str5;
    }

    public final long getAdvBottomSheetId() {
        return this.advBottomSheetId;
    }

    public final AdvBottomSheetDesignTheme getTheme() {
        return this.theme;
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
