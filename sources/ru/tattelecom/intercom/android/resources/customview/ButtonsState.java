package ru.tattelecom.intercom.android.resources.customview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SwipeController.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/ButtonsState;", "", "(Ljava/lang/String;I)V", "GONE", "RIGHT_VISIBLE", "NOT_VISIBLE", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ButtonsState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ButtonsState[] $VALUES;
    public static final ButtonsState GONE = new ButtonsState("GONE", 0);
    public static final ButtonsState RIGHT_VISIBLE = new ButtonsState("RIGHT_VISIBLE", 1);
    public static final ButtonsState NOT_VISIBLE = new ButtonsState("NOT_VISIBLE", 2);

    private static final /* synthetic */ ButtonsState[] $values() {
        return new ButtonsState[]{GONE, RIGHT_VISIBLE, NOT_VISIBLE};
    }

    public static EnumEntries<ButtonsState> getEntries() {
        return $ENTRIES;
    }

    public static ButtonsState valueOf(String str) {
        return (ButtonsState) Enum.valueOf(ButtonsState.class, str);
    }

    public static ButtonsState[] values() {
        return (ButtonsState[]) $VALUES.clone();
    }

    private ButtonsState(String str, int i) {
    }

    static {
        ButtonsState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
