package ru.tattelecom.intercom.feature.videoplayer;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/SpeedPlayback;", "Landroid/os/Parcelable;", "text", "", "value", "", "isSelected", "", "(Ljava/lang/String;FZ)V", "()Z", "setSelected", "(Z)V", "getText", "()Ljava/lang/String;", "getValue", "()F", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class SpeedPlayback implements Parcelable {
    public static final Parcelable.Creator<SpeedPlayback> CREATOR = new Creator();
    private boolean isSelected;
    private final String text;
    private final float value;

    /* compiled from: VideoPlayerViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpeedPlayback> {
        @Override // android.os.Parcelable.Creator
        public final SpeedPlayback createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SpeedPlayback(parcel.readString(), parcel.readFloat(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public final SpeedPlayback[] newArray(int i) {
            return new SpeedPlayback[i];
        }
    }

    public static /* synthetic */ SpeedPlayback copy$default(SpeedPlayback speedPlayback, String str, float f, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = speedPlayback.text;
        }
        if ((i & 2) != 0) {
            f = speedPlayback.value;
        }
        if ((i & 4) != 0) {
            z = speedPlayback.isSelected;
        }
        return speedPlayback.copy(str, f, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component2, reason: from getter */
    public final float getValue() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final SpeedPlayback copy(String text, float value, boolean isSelected) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new SpeedPlayback(text, value, isSelected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SpeedPlayback)) {
            return false;
        }
        SpeedPlayback speedPlayback = (SpeedPlayback) other;
        return Intrinsics.areEqual(this.text, speedPlayback.text) && Float.compare(this.value, speedPlayback.value) == 0 && this.isSelected == speedPlayback.isSelected;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + Float.floatToIntBits(this.value)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isSelected);
    }

    public String toString() {
        return "SpeedPlayback(text=" + this.text + ", value=" + this.value + ", isSelected=" + this.isSelected + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.text);
        parcel.writeFloat(this.value);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public SpeedPlayback(String text, float f, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.value = f;
        this.isSelected = z;
    }

    public final String getText() {
        return this.text;
    }

    public final float getValue() {
        return this.value;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
