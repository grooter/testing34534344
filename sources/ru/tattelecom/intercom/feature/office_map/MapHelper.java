package ru.tattelecom.intercom.feature.office_map;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: MapHelper.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/MapHelper;", "", "()V", "FILTER_BTN_ID", "", "OPEN_CLOSE_FILTER_ID", "mainFilterNamesList", "", "", "getMainFilterNamesList", "()Ljava/util/List;", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MapHelper {
    public static final int FILTER_BTN_ID = -2;
    public static final int OPEN_CLOSE_FILTER_ID = -1;
    public static final MapHelper INSTANCE = new MapHelper();
    private static final List<String> mainFilterNamesList = CollectionsKt.listOf((Object[]) new String[]{"Фильтры", "Сейчас открыто", "Домофонные ключи", "Подключение услуг", "Замена СИМ-карты"});

    private MapHelper() {
    }

    public final List<String> getMainFilterNamesList() {
        return mainFilterNamesList;
    }
}
