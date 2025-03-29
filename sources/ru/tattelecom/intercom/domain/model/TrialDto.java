package ru.tattelecom.intercom.domain.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: ConfigDtos.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/domain/model/TrialDto;", "", TtmlNode.ATTR_ID, "", "isActive", "", "remainingDays", "(IZI)V", "getId", "()I", "()Z", "getRemainingDays", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class TrialDto {
    private final int id;
    private final boolean isActive;
    private final int remainingDays;

    public static /* synthetic */ TrialDto copy$default(TrialDto trialDto, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = trialDto.id;
        }
        if ((i3 & 2) != 0) {
            z = trialDto.isActive;
        }
        if ((i3 & 4) != 0) {
            i2 = trialDto.remainingDays;
        }
        return trialDto.copy(i, z, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRemainingDays() {
        return this.remainingDays;
    }

    public final TrialDto copy(int id, boolean isActive, int remainingDays) {
        return new TrialDto(id, isActive, remainingDays);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrialDto)) {
            return false;
        }
        TrialDto trialDto = (TrialDto) other;
        return this.id == trialDto.id && this.isActive == trialDto.isActive && this.remainingDays == trialDto.remainingDays;
    }

    public int hashCode() {
        return (((this.id * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isActive)) * 31) + this.remainingDays;
    }

    public String toString() {
        return "TrialDto(id=" + this.id + ", isActive=" + this.isActive + ", remainingDays=" + this.remainingDays + ")";
    }

    public TrialDto(int i, boolean z, int i2) {
        this.id = i;
        this.isActive = z;
        this.remainingDays = i2;
    }

    public /* synthetic */ TrialDto(int i, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, (i3 & 4) != 0 ? 0 : i2);
    }

    public final int getId() {
        return this.id;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final int getRemainingDays() {
        return this.remainingDays;
    }
}
