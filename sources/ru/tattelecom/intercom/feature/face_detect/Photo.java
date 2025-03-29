package ru.tattelecom.intercom.feature.face_detect;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacePhotographAdapter.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/feature/face_detect/Photo;", "", TtmlNode.ATTR_ID, "", "photo", "", "(ILjava/lang/String;)V", "getId", "()I", "getPhoto", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "feature-face-detect_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Photo {
    private final int id;
    private final String photo;

    public static /* synthetic */ Photo copy$default(Photo photo, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = photo.id;
        }
        if ((i2 & 2) != 0) {
            str = photo.photo;
        }
        return photo.copy(i, str);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhoto() {
        return this.photo;
    }

    public final Photo copy(int id, String photo) {
        Intrinsics.checkNotNullParameter(photo, "photo");
        return new Photo(id, photo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Photo)) {
            return false;
        }
        Photo photo = (Photo) other;
        return this.id == photo.id && Intrinsics.areEqual(this.photo, photo.photo);
    }

    public int hashCode() {
        return (this.id * 31) + this.photo.hashCode();
    }

    public String toString() {
        return "Photo(id=" + this.id + ", photo=" + this.photo + ")";
    }

    public Photo(int i, String photo) {
        Intrinsics.checkNotNullParameter(photo, "photo");
        this.id = i;
        this.photo = photo;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPhoto() {
        return this.photo;
    }
}
