package ru.tattelecom.intercom.data.local.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity;

/* compiled from: AdvThemeDto.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"toEntity", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignEntity;", "Lru/tattelecom/intercom/data/local/dto/AdvThemeDto;", "advBottomSheetId", "", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AdvThemeDtoKt {
    public static final AdvBottomSheetDesignEntity toEntity(AdvThemeDto advThemeDto, long j) {
        Intrinsics.checkNotNullParameter(advThemeDto, "<this>");
        return new AdvBottomSheetDesignEntity(j, advThemeDto.getTheme(), advThemeDto.getBackgroundColor(), advThemeDto.getButtonTextColor(), advThemeDto.getTitleColor(), advThemeDto.getDescriptionColor(), advThemeDto.getButtonBackgroundColor());
    }
}
