package ru.tattelecom.intercom.data.remote.source.paging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: EventHistoryPagingSource.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "", "(Ljava/lang/String;I)V", "TYPE_ALL", "TYPE_CALLS", "TYPE_KEY_PASSES", "TYPE_CODE_PASSES", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DataLoadType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DataLoadType[] $VALUES;
    public static final DataLoadType TYPE_ALL = new DataLoadType("TYPE_ALL", 0);
    public static final DataLoadType TYPE_CALLS = new DataLoadType("TYPE_CALLS", 1);
    public static final DataLoadType TYPE_KEY_PASSES = new DataLoadType("TYPE_KEY_PASSES", 2);
    public static final DataLoadType TYPE_CODE_PASSES = new DataLoadType("TYPE_CODE_PASSES", 3);

    private static final /* synthetic */ DataLoadType[] $values() {
        return new DataLoadType[]{TYPE_ALL, TYPE_CALLS, TYPE_KEY_PASSES, TYPE_CODE_PASSES};
    }

    public static EnumEntries<DataLoadType> getEntries() {
        return $ENTRIES;
    }

    public static DataLoadType valueOf(String str) {
        return (DataLoadType) Enum.valueOf(DataLoadType.class, str);
    }

    public static DataLoadType[] values() {
        return (DataLoadType[]) $VALUES.clone();
    }

    private DataLoadType(String str, int i) {
    }

    static {
        DataLoadType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
