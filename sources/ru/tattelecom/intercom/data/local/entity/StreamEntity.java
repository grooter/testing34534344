package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0016J\u0080\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u000e\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\r\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006,"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/StreamEntity;", "", TtmlNode.ATTR_ID, "", "addressId", "name", "", "liveSource", "snapshotUrl", "archiveSource", "archiveExportSource", "isFlussonic", "", "isSelected", "isFavorite", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;)V", "getAddressId", "()I", "getArchiveExportSource", "()Ljava/lang/String;", "getArchiveSource", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "getLiveSource", "getName", "getSnapshotUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/local/entity/StreamEntity;", "equals", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StreamEntity {
    private final int addressId;
    private final String archiveExportSource;
    private final String archiveSource;
    private final int id;
    private final Boolean isFavorite;
    private final boolean isFlussonic;
    private final Boolean isSelected;
    private final String liveSource;
    private final String name;
    private final String snapshotUrl;

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAddressId() {
        return this.addressId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLiveSource() {
        return this.liveSource;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSnapshotUrl() {
        return this.snapshotUrl;
    }

    /* renamed from: component6, reason: from getter */
    public final String getArchiveSource() {
        return this.archiveSource;
    }

    /* renamed from: component7, reason: from getter */
    public final String getArchiveExportSource() {
        return this.archiveExportSource;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsFlussonic() {
        return this.isFlussonic;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getIsSelected() {
        return this.isSelected;
    }

    public final StreamEntity copy(int id, int addressId, String name, String liveSource, String snapshotUrl, String archiveSource, String archiveExportSource, boolean isFlussonic, Boolean isSelected, Boolean isFavorite) {
        return new StreamEntity(id, addressId, name, liveSource, snapshotUrl, archiveSource, archiveExportSource, isFlussonic, isSelected, isFavorite);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamEntity)) {
            return false;
        }
        StreamEntity streamEntity = (StreamEntity) other;
        return this.id == streamEntity.id && this.addressId == streamEntity.addressId && Intrinsics.areEqual(this.name, streamEntity.name) && Intrinsics.areEqual(this.liveSource, streamEntity.liveSource) && Intrinsics.areEqual(this.snapshotUrl, streamEntity.snapshotUrl) && Intrinsics.areEqual(this.archiveSource, streamEntity.archiveSource) && Intrinsics.areEqual(this.archiveExportSource, streamEntity.archiveExportSource) && this.isFlussonic == streamEntity.isFlussonic && Intrinsics.areEqual(this.isSelected, streamEntity.isSelected) && Intrinsics.areEqual(this.isFavorite, streamEntity.isFavorite);
    }

    public int hashCode() {
        int i = ((this.id * 31) + this.addressId) * 31;
        String str = this.name;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.liveSource;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.snapshotUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.archiveSource;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.archiveExportSource;
        int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isFlussonic)) * 31;
        Boolean bool = this.isSelected;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isFavorite;
        return hashCode6 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "StreamEntity(id=" + this.id + ", addressId=" + this.addressId + ", name=" + this.name + ", liveSource=" + this.liveSource + ", snapshotUrl=" + this.snapshotUrl + ", archiveSource=" + this.archiveSource + ", archiveExportSource=" + this.archiveExportSource + ", isFlussonic=" + this.isFlussonic + ", isSelected=" + this.isSelected + ", isFavorite=" + this.isFavorite + ")";
    }

    public StreamEntity(int i, int i2, String str, String str2, String str3, String str4, String str5, boolean z, Boolean bool, Boolean bool2) {
        this.id = i;
        this.addressId = i2;
        this.name = str;
        this.liveSource = str2;
        this.snapshotUrl = str3;
        this.archiveSource = str4;
        this.archiveExportSource = str5;
        this.isFlussonic = z;
        this.isSelected = bool;
        this.isFavorite = bool2;
    }

    public /* synthetic */ StreamEntity(int i, int i2, String str, String str2, String str3, String str4, String str5, boolean z, Boolean bool, Boolean bool2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, i2, str, str2, str3, str4, str5, z, bool, bool2);
    }

    public final int getId() {
        return this.id;
    }

    public final int getAddressId() {
        return this.addressId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLiveSource() {
        return this.liveSource;
    }

    public final String getSnapshotUrl() {
        return this.snapshotUrl;
    }

    public final String getArchiveSource() {
        return this.archiveSource;
    }

    public final String getArchiveExportSource() {
        return this.archiveExportSource;
    }

    public final boolean isFlussonic() {
        return this.isFlussonic;
    }

    public final Boolean isSelected() {
        return this.isSelected;
    }

    public final Boolean isFavorite() {
        return this.isFavorite;
    }
}
