package ru.tattelecom.intercom.android.resources.timerangepicker;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Thumb.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/android/resources/timerangepicker/Thumb;", "", "(Ljava/lang/String;I)V", "START", "END", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Thumb {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Thumb[] $VALUES;
    public static final Thumb START = new Thumb("START", 0);
    public static final Thumb END = new Thumb("END", 1);

    private static final /* synthetic */ Thumb[] $values() {
        return new Thumb[]{START, END};
    }

    public static EnumEntries<Thumb> getEntries() {
        return $ENTRIES;
    }

    public static Thumb valueOf(String str) {
        return (Thumb) Enum.valueOf(Thumb.class, str);
    }

    public static Thumb[] values() {
        return (Thumb[]) $VALUES.clone();
    }

    private Thumb(String str, int i) {
    }

    static {
        Thumb[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
