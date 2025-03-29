package ru.tattelecom.intercom.domain.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;

/* compiled from: AdvBottomSheetDtos.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lru/tattelecom/intercom/domain/model/DefaultThemeDto;", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "buttonTextColor", "titleColor", "descriptionColor", "buttonBackgroundColor", "(IIIII)V", "getBackgroundColor", "()I", "getButtonBackgroundColor", "getButtonTextColor", "getDescriptionColor", "getTitleColor", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DefaultThemeDto {
    private final int backgroundColor;
    private final int buttonBackgroundColor;
    private final int buttonTextColor;
    private final int descriptionColor;
    private final int titleColor;

    public static /* synthetic */ DefaultThemeDto copy$default(DefaultThemeDto defaultThemeDto, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = defaultThemeDto.backgroundColor;
        }
        if ((i6 & 2) != 0) {
            i2 = defaultThemeDto.buttonTextColor;
        }
        int i7 = i2;
        if ((i6 & 4) != 0) {
            i3 = defaultThemeDto.titleColor;
        }
        int i8 = i3;
        if ((i6 & 8) != 0) {
            i4 = defaultThemeDto.descriptionColor;
        }
        int i9 = i4;
        if ((i6 & 16) != 0) {
            i5 = defaultThemeDto.buttonBackgroundColor;
        }
        return defaultThemeDto.copy(i, i7, i8, i9, i5);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component2, reason: from getter */
    public final int getButtonTextColor() {
        return this.buttonTextColor;
    }

    /* renamed from: component3, reason: from getter */
    public final int getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDescriptionColor() {
        return this.descriptionColor;
    }

    /* renamed from: component5, reason: from getter */
    public final int getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }

    public final DefaultThemeDto copy(int backgroundColor, int buttonTextColor, int titleColor, int descriptionColor, int buttonBackgroundColor) {
        return new DefaultThemeDto(backgroundColor, buttonTextColor, titleColor, descriptionColor, buttonBackgroundColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultThemeDto)) {
            return false;
        }
        DefaultThemeDto defaultThemeDto = (DefaultThemeDto) other;
        return this.backgroundColor == defaultThemeDto.backgroundColor && this.buttonTextColor == defaultThemeDto.buttonTextColor && this.titleColor == defaultThemeDto.titleColor && this.descriptionColor == defaultThemeDto.descriptionColor && this.buttonBackgroundColor == defaultThemeDto.buttonBackgroundColor;
    }

    public int hashCode() {
        return (((((((this.backgroundColor * 31) + this.buttonTextColor) * 31) + this.titleColor) * 31) + this.descriptionColor) * 31) + this.buttonBackgroundColor;
    }

    public String toString() {
        return "DefaultThemeDto(backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ")";
    }

    public DefaultThemeDto(int i, int i2, int i3, int i4, int i5) {
        this.backgroundColor = i;
        this.buttonTextColor = i2;
        this.titleColor = i3;
        this.descriptionColor = i4;
        this.buttonBackgroundColor = i5;
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
