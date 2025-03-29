package ru.tattelecom.intercom.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.R;

/* compiled from: TutorialPrefsSource.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0002J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002J\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lru/tattelecom/intercom/data/prefs/TutorialPrefsSource;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "clearOldTips", "", "getAllTips", "", "", "", "getTips", "", "Lru/tattelecom/intercom/data/prefs/Tip;", "notSeenOnly", "hasNotViewedTips", "onTipViewed", "name", "provideTip", "saveTip", "isSeen", "setAllTipsViewed", "viewed", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TutorialPrefsSource {
    private static final String[] TIP_NAMES = {"img_onboarding_20_1", "img_onboarding_20_2", "img_onboarding_20_3"};
    private static final String TUTORIAL_PREFERENCES = "tutorialPreferencesV14";
    private final Context context;
    private final SharedPreferences prefs;

    public TutorialPrefsSource(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.prefs = context.getSharedPreferences(TUTORIAL_PREFERENCES, 0);
        clearOldTips();
        for (String str : TIP_NAMES) {
            provideTip(str);
        }
    }

    private final void clearOldTips() {
        for (Map.Entry<String, Boolean> entry : getAllTips().entrySet()) {
            if (!ArraysKt.contains(TIP_NAMES, entry.getKey())) {
                this.prefs.edit().remove(entry.getKey()).apply();
            }
        }
    }

    public final boolean hasNotViewedTips() {
        return getAllTips().containsValue(false);
    }

    public final List<Tip> getTips(boolean notSeenOnly) {
        Map<String, Boolean> map;
        int i;
        if (!notSeenOnly) {
            map = getAllTips();
        } else {
            Map<String, Boolean> allTips = getAllTips();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Boolean> entry : allTips.entrySet()) {
                if (!entry.getValue().booleanValue()) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            map = linkedHashMap;
        }
        List<Pair> sortedWith = CollectionsKt.sortedWith(MapsKt.toList(map), new Comparator() { // from class: ru.tattelecom.intercom.data.prefs.TutorialPrefsSource$getTips$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((String) ((Pair) t).getFirst(), (String) ((Pair) t2).getFirst());
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (Pair pair : sortedWith) {
            String str = (String) pair.getFirst();
            try {
                i = this.context.getResources().getIdentifier((String) pair.getFirst(), "drawable", this.context.getPackageName());
            } catch (Exception unused) {
                i = R.drawable.ic_tip_unknown;
            }
            arrayList.add(new Tip(str, i));
        }
        return arrayList;
    }

    public final void onTipViewed(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        saveTip(name, true);
    }

    private final Map<String, Boolean> getAllTips() {
        Map all = this.prefs.getAll();
        Intrinsics.checkNotNull(all, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Boolean>");
        return all;
    }

    private final void provideTip(String name) {
        saveTip(name, this.prefs.getBoolean(name, false));
    }

    private final void saveTip(String name, boolean isSeen) {
        this.prefs.edit().putBoolean(name, isSeen).apply();
    }

    public final void setAllTipsViewed(boolean viewed) {
        for (String str : TIP_NAMES) {
            saveTip(str, viewed);
        }
    }
}
