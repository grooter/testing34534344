package ru.tattelecom.intercom.data.prefs;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TutorialPrefsSource.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/data/prefs/Tip;", "", "name", "", "imageResId", "", "(Ljava/lang/String;I)V", "getImageResId", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Tip {
    private final int imageResId;
    private final String name;

    public static /* synthetic */ Tip copy$default(Tip tip, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tip.name;
        }
        if ((i2 & 2) != 0) {
            i = tip.imageResId;
        }
        return tip.copy(str, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final int getImageResId() {
        return this.imageResId;
    }

    public final Tip copy(String name, int imageResId) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Tip(name, imageResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tip)) {
            return false;
        }
        Tip tip = (Tip) other;
        return Intrinsics.areEqual(this.name, tip.name) && this.imageResId == tip.imageResId;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.imageResId;
    }

    public String toString() {
        return "Tip(name=" + this.name + ", imageResId=" + this.imageResId + ")";
    }

    public Tip(String name, int i) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.imageResId = i;
    }

    public final String getName() {
        return this.name;
    }

    public final int getImageResId() {
        return this.imageResId;
    }
}
