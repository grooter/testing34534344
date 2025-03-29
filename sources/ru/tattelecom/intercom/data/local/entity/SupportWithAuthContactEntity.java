package ru.tattelecom.intercom.data.local.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;

/* compiled from: SupportEntities.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ<\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\u0006\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/SupportWithAuthContactEntity;", "", "name", "", "description", "value", "isEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDescription", "()Ljava/lang/String;", "isEnabled$annotations", "()V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getName", "getValue", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/local/entity/SupportWithAuthContactEntity;", "equals", "other", "hashCode", "", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SupportWithAuthContactEntity {
    private final String description;
    private final Boolean isEnabled;
    private final String name;
    private final String value;

    public static /* synthetic */ SupportWithAuthContactEntity copy$default(SupportWithAuthContactEntity supportWithAuthContactEntity, String str, String str2, String str3, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = supportWithAuthContactEntity.name;
        }
        if ((i & 2) != 0) {
            str2 = supportWithAuthContactEntity.description;
        }
        if ((i & 4) != 0) {
            str3 = supportWithAuthContactEntity.value;
        }
        if ((i & 8) != 0) {
            bool = supportWithAuthContactEntity.isEnabled;
        }
        return supportWithAuthContactEntity.copy(str, str2, str3, bool);
    }

    @SerialName("is_enabled")
    public static /* synthetic */ void isEnabled$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getIsEnabled() {
        return this.isEnabled;
    }

    public final SupportWithAuthContactEntity copy(String name, String description, String value, Boolean isEnabled) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SupportWithAuthContactEntity(name, description, value, isEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SupportWithAuthContactEntity)) {
            return false;
        }
        SupportWithAuthContactEntity supportWithAuthContactEntity = (SupportWithAuthContactEntity) other;
        return Intrinsics.areEqual(this.name, supportWithAuthContactEntity.name) && Intrinsics.areEqual(this.description, supportWithAuthContactEntity.description) && Intrinsics.areEqual(this.value, supportWithAuthContactEntity.value) && Intrinsics.areEqual(this.isEnabled, supportWithAuthContactEntity.isEnabled);
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.description;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isEnabled;
        return hashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "SupportWithAuthContactEntity(name=" + this.name + ", description=" + this.description + ", value=" + this.value + ", isEnabled=" + this.isEnabled + ")";
    }

    public SupportWithAuthContactEntity(String name, String str, String str2, Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.description = str;
        this.value = str2;
        this.isEnabled = bool;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getValue() {
        return this.value;
    }

    public final Boolean isEnabled() {
        return this.isEnabled;
    }
}
