package ru.tattelecom.intercom.domain.model;

import android.graphics.Color;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity;

/* compiled from: AdvBottomSheetDtos.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a$\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"chooseColor", "", "textColor", "", "defaultColor", "toDto", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetEntity;", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignEntity;", "theme", "Lru/tattelecom/intercom/domain/model/DefaultThemeDto;", "domain_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AdvBottomSheetDtosKt {
    public static final AdvBottomSheetDto toDto(Map<AdvBottomSheetEntity, AdvBottomSheetDesignEntity> map, DefaultThemeDto theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        if (map == null || map.isEmpty()) {
            return null;
        }
        AdvBottomSheetEntity advBottomSheetEntity = (AdvBottomSheetEntity) CollectionsKt.first(map.keySet());
        AdvBottomSheetDesignEntity advBottomSheetDesignEntity = (AdvBottomSheetDesignEntity) CollectionsKt.first(map.values());
        return new AdvBottomSheetDto(advBottomSheetEntity.getId(), advBottomSheetEntity.isRead(), advBottomSheetEntity.getTitle(), advBottomSheetEntity.getDescription(), advBottomSheetEntity.getButtonText(), advBottomSheetEntity.getType(), new AdvBottomSheetDataDto(advBottomSheetEntity.getTypeDataUrl(), advBottomSheetEntity.getTypeDataScreen(), advBottomSheetEntity.getTypeDataSelectedServices()), advBottomSheetEntity.getTitleAlign(), advBottomSheetEntity.getDescriptionAlign(), advBottomSheetEntity.getImage(), advBottomSheetEntity.getIcon(), chooseColor(advBottomSheetDesignEntity != null ? advBottomSheetDesignEntity.getBackgroundColor() : null, theme.getBackgroundColor()), chooseColor(advBottomSheetDesignEntity != null ? advBottomSheetDesignEntity.getButtonTextColor() : null, theme.getButtonTextColor()), chooseColor(advBottomSheetDesignEntity != null ? advBottomSheetDesignEntity.getTitleColor() : null, theme.getTitleColor()), chooseColor(advBottomSheetDesignEntity != null ? advBottomSheetDesignEntity.getDescriptionColor() : null, theme.getDescriptionColor()), chooseColor(advBottomSheetDesignEntity != null ? advBottomSheetDesignEntity.getButtonBackgroundColor() : null, theme.getButtonBackgroundColor()));
    }

    private static final int chooseColor(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable unused) {
            return i;
        }
    }
}
