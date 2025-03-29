package ru.tattelecom.intercom.feature.office_map.main;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: OfficeServiceAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/main/OfficeService;", "", TtmlNode.ATTR_ID, "", "name", "", "isSelected", "", "selectedCount", "(ILjava/lang/String;ZI)V", "getId", "()I", "()Z", "setSelected", "(Z)V", "getName", "()Ljava/lang/String;", "getSelectedCount", "setSelectedCount", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final /* data */ class OfficeService {
    private final int id;
    private boolean isSelected;
    private final String name;
    private int selectedCount;

    public static /* synthetic */ OfficeService copy$default(OfficeService officeService, int i, String str, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = officeService.id;
        }
        if ((i3 & 2) != 0) {
            str = officeService.name;
        }
        if ((i3 & 4) != 0) {
            z = officeService.isSelected;
        }
        if ((i3 & 8) != 0) {
            i2 = officeService.selectedCount;
        }
        return officeService.copy(i, str, z, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSelectedCount() {
        return this.selectedCount;
    }

    public final OfficeService copy(int id, String name, boolean isSelected, int selectedCount) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new OfficeService(id, name, isSelected, selectedCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfficeService)) {
            return false;
        }
        OfficeService officeService = (OfficeService) other;
        return this.id == officeService.id && Intrinsics.areEqual(this.name, officeService.name) && this.isSelected == officeService.isSelected && this.selectedCount == officeService.selectedCount;
    }

    public int hashCode() {
        return (((((this.id * 31) + this.name.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isSelected)) * 31) + this.selectedCount;
    }

    public String toString() {
        return "OfficeService(id=" + this.id + ", name=" + this.name + ", isSelected=" + this.isSelected + ", selectedCount=" + this.selectedCount + ")";
    }

    public OfficeService(int i, String name, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i;
        this.name = name;
        this.isSelected = z;
        this.selectedCount = i2;
    }

    public /* synthetic */ OfficeService(int i, String str, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? 0 : i2);
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final int getSelectedCount() {
        return this.selectedCount;
    }

    public final void setSelectedCount(int i) {
        this.selectedCount = i;
    }
}
