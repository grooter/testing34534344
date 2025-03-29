package ru.tattelecom.intercom.data.local.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: AdvEntities.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AdvBottomSheetDesignTheme {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AdvBottomSheetDesignTheme[] $VALUES;
    public static final AdvBottomSheetDesignTheme LIGHT = new AdvBottomSheetDesignTheme("LIGHT", 0);
    public static final AdvBottomSheetDesignTheme DARK = new AdvBottomSheetDesignTheme("DARK", 1);

    private static final /* synthetic */ AdvBottomSheetDesignTheme[] $values() {
        return new AdvBottomSheetDesignTheme[]{LIGHT, DARK};
    }

    public static EnumEntries<AdvBottomSheetDesignTheme> getEntries() {
        return $ENTRIES;
    }

    public static AdvBottomSheetDesignTheme valueOf(String str) {
        return (AdvBottomSheetDesignTheme) Enum.valueOf(AdvBottomSheetDesignTheme.class, str);
    }

    public static AdvBottomSheetDesignTheme[] values() {
        return (AdvBottomSheetDesignTheme[]) $VALUES.clone();
    }

    private AdvBottomSheetDesignTheme(String str, int i) {
    }

    static {
        AdvBottomSheetDesignTheme[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
