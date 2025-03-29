package ru.tattelecom.intercom.feature.home;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: HomeListAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeAddress;", "Lru/tattelecom/intercom/feature/home/HomeItem;", TtmlNode.ATTR_ID, "", "title", "", "isCollapsed", "", "(ILjava/lang/String;Z)V", "getId", "()I", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class HomeAddress extends HomeItem {
    private final int id;
    private final boolean isCollapsed;
    private final String title;

    public static /* synthetic */ HomeAddress copy$default(HomeAddress homeAddress, int i, String str, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = homeAddress.id;
        }
        if ((i2 & 2) != 0) {
            str = homeAddress.title;
        }
        if ((i2 & 4) != 0) {
            z = homeAddress.isCollapsed;
        }
        return homeAddress.copy(i, str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsCollapsed() {
        return this.isCollapsed;
    }

    public final HomeAddress copy(int id, String title, boolean isCollapsed) {
        return new HomeAddress(id, title, isCollapsed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HomeAddress)) {
            return false;
        }
        HomeAddress homeAddress = (HomeAddress) other;
        return this.id == homeAddress.id && Intrinsics.areEqual(this.title, homeAddress.title) && this.isCollapsed == homeAddress.isCollapsed;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.title;
        return ((i + (str == null ? 0 : str.hashCode())) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isCollapsed);
    }

    public String toString() {
        return "HomeAddress(id=" + this.id + ", title=" + this.title + ", isCollapsed=" + this.isCollapsed + ")";
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCollapsed() {
        return this.isCollapsed;
    }

    public HomeAddress(int i, String str, boolean z) {
        super(1, String.valueOf(i));
        this.id = i;
        this.title = str;
        this.isCollapsed = z;
    }
}
