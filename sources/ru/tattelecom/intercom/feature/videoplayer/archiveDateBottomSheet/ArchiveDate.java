package ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: ArchiveDateAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDate;", "", TtmlNode.ATTR_ID, "", "text", "", "isSelected", "", "isCheckable", "(ILjava/lang/String;ZZ)V", "getId", "()I", "()Z", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class ArchiveDate {
    private final int id;
    private final boolean isCheckable;
    private final boolean isSelected;
    private final String text;

    public static /* synthetic */ ArchiveDate copy$default(ArchiveDate archiveDate, int i, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = archiveDate.id;
        }
        if ((i2 & 2) != 0) {
            str = archiveDate.text;
        }
        if ((i2 & 4) != 0) {
            z = archiveDate.isSelected;
        }
        if ((i2 & 8) != 0) {
            z2 = archiveDate.isCheckable;
        }
        return archiveDate.copy(i, str, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsCheckable() {
        return this.isCheckable;
    }

    public final ArchiveDate copy(int id, String text, boolean isSelected, boolean isCheckable) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new ArchiveDate(id, text, isSelected, isCheckable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArchiveDate)) {
            return false;
        }
        ArchiveDate archiveDate = (ArchiveDate) other;
        return this.id == archiveDate.id && Intrinsics.areEqual(this.text, archiveDate.text) && this.isSelected == archiveDate.isSelected && this.isCheckable == archiveDate.isCheckable;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.text.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isSelected)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isCheckable);
    }

    public String toString() {
        return "ArchiveDate(id=" + this.id + ", text=" + this.text + ", isSelected=" + this.isSelected + ", isCheckable=" + this.isCheckable + ")";
    }

    public ArchiveDate(int i, String text, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.id = i;
        this.text = text;
        this.isSelected = z;
        this.isCheckable = z2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final boolean isCheckable() {
        return this.isCheckable;
    }
}
