package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GuestsAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/ApartmentItem;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteItem;", TtmlNode.ATTR_ID, "", "title", "", "(ILjava/lang/String;)V", "getId", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class ApartmentItem extends InviteItem {
    private final int id;
    private final String title;

    public static /* synthetic */ ApartmentItem copy$default(ApartmentItem apartmentItem, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = apartmentItem.id;
        }
        if ((i2 & 2) != 0) {
            str = apartmentItem.title;
        }
        return apartmentItem.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final ApartmentItem copy(int id, String title) {
        return new ApartmentItem(id, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApartmentItem)) {
            return false;
        }
        ApartmentItem apartmentItem = (ApartmentItem) other;
        return this.id == apartmentItem.id && Intrinsics.areEqual(this.title, apartmentItem.title);
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.title;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ApartmentItem(id=" + this.id + ", title=" + this.title + ")";
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public ApartmentItem(int i, String str) {
        super(1);
        this.id = i;
        this.title = str;
    }
}
