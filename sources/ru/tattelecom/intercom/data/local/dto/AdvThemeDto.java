package ru.tattelecom.intercom.data.local.dto;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetBottomData;
import ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetBottomDataItem;
import ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetData;
import ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse;

/* compiled from: AdvThemeDto.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003JY\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/data/local/dto/AdvThemeDto;", "", "advBottomSheetId", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "", "buttonTextColor", "titleColor", "descriptionColor", "buttonBackgroundColor", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;)V", "getAdvBottomSheetId", "()J", "getBackgroundColor", "()Ljava/lang/String;", "getButtonBackgroundColor", "getButtonTextColor", "getDescriptionColor", "getTheme", "()Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "getTitleColor", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class AdvThemeDto {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getButtonTextColor() {
        return this.buttonTextColor;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTitleColor() {
        return this.titleColor;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDescriptionColor() {
        return this.descriptionColor;
    }

    /* renamed from: component6, reason: from getter */
    public final String getButtonBackgroundColor() {
        return this.buttonBackgroundColor;
    }

    /* renamed from: component7, reason: from getter */
    public final AdvBottomSheetDesignTheme getTheme() {
        return this.theme;
    }

    public final AdvThemeDto copy(long advBottomSheetId, String backgroundColor, String buttonTextColor, String titleColor, String descriptionColor, String buttonBackgroundColor, AdvBottomSheetDesignTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        return new AdvThemeDto(advBottomSheetId, backgroundColor, buttonTextColor, titleColor, descriptionColor, buttonBackgroundColor, theme);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdvThemeDto)) {
            return false;
        }
        AdvThemeDto advThemeDto = (AdvThemeDto) other;
        return this.advBottomSheetId == advThemeDto.advBottomSheetId && Intrinsics.areEqual(this.backgroundColor, advThemeDto.backgroundColor) && Intrinsics.areEqual(this.buttonTextColor, advThemeDto.buttonTextColor) && Intrinsics.areEqual(this.titleColor, advThemeDto.titleColor) && Intrinsics.areEqual(this.descriptionColor, advThemeDto.descriptionColor) && Intrinsics.areEqual(this.buttonBackgroundColor, advThemeDto.buttonBackgroundColor) && this.theme == advThemeDto.theme;
    }

    public int hashCode() {
        int m = AdvThemeDto$$ExternalSyntheticBackport0.m(this.advBottomSheetId) * 31;
        String str = this.backgroundColor;
        int hashCode = (m + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.buttonTextColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleColor;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.descriptionColor;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buttonBackgroundColor;
        return ((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.theme.hashCode();
    }

    public String toString() {
        return "AdvThemeDto(advBottomSheetId=" + this.advBottomSheetId + ", backgroundColor=" + this.backgroundColor + ", buttonTextColor=" + this.buttonTextColor + ", titleColor=" + this.titleColor + ", descriptionColor=" + this.descriptionColor + ", buttonBackgroundColor=" + this.buttonBackgroundColor + ", theme=" + this.theme + ")";
    }

    public AdvThemeDto(long j, String str, String str2, String str3, String str4, String str5, AdvBottomSheetDesignTheme theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.advBottomSheetId = j;
        this.backgroundColor = str;
        this.buttonTextColor = str2;
        this.titleColor = str3;
        this.descriptionColor = str4;
        this.buttonBackgroundColor = str5;
        this.theme = theme;
    }

    public final long getAdvBottomSheetId() {
        return this.advBottomSheetId;
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

    public final AdvBottomSheetDesignTheme getTheme() {
        return this.theme;
    }

    /* compiled from: AdvThemeDto.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lru/tattelecom/intercom/data/local/dto/AdvThemeDto$Companion;", "", "()V", "toAdvTheme", "Lru/tattelecom/intercom/data/local/dto/AdvThemeDto;", "advBottomSheetBottomDataItem", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetBottomDataItem;", "advBottomSheetId", "", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "toAdvThemeList", "", "advBottomSheetResponse", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final AdvThemeDto toAdvTheme(AdvBottomSheetBottomDataItem advBottomSheetBottomDataItem, long advBottomSheetId, AdvBottomSheetDesignTheme theme) {
            return new AdvThemeDto(advBottomSheetId, advBottomSheetBottomDataItem.getBackgroundColor(), advBottomSheetBottomDataItem.getButtonTextColor(), advBottomSheetBottomDataItem.getTitleColor(), advBottomSheetBottomDataItem.getDescriptionColor(), advBottomSheetBottomDataItem.getButtonBackgroundColor(), theme);
        }

        public final List<AdvThemeDto> toAdvThemeList(AdvBottomSheetResponse advBottomSheetResponse) {
            AdvBottomSheetBottomDataItem dark;
            AdvBottomSheetBottomDataItem light;
            Intrinsics.checkNotNullParameter(advBottomSheetResponse, "advBottomSheetResponse");
            AdvBottomSheetData advData = advBottomSheetResponse.getAdvData();
            if (advData == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            AdvBottomSheetBottomData bottomData = advData.getBottomData();
            if (bottomData != null && (light = bottomData.getLight()) != null) {
                arrayList.add(AdvThemeDto.INSTANCE.toAdvTheme(light, advData.getId(), AdvBottomSheetDesignTheme.LIGHT));
            }
            AdvBottomSheetBottomData bottomData2 = advData.getBottomData();
            if (bottomData2 == null || (dark = bottomData2.getDark()) == null) {
                return arrayList;
            }
            arrayList.add(AdvThemeDto.INSTANCE.toAdvTheme(dark, advData.getId(), AdvBottomSheetDesignTheme.DARK));
            return arrayList;
        }
    }
}
