package ru.tattelecom.intercom.domain.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigDtos.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001cB+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J<\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lru/tattelecom/intercom/domain/model/ConfigDto;", "", "featRemoteLogging", "", "openDoorLockTimeout", "", "isFirstEnter", "trial", "Lru/tattelecom/intercom/domain/model/ConfigDto$Trial;", "(Ljava/lang/Boolean;ILjava/lang/Boolean;Lru/tattelecom/intercom/domain/model/ConfigDto$Trial;)V", "getFeatRemoteLogging", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOpenDoorLockTimeout", "()I", "getTrial", "()Lru/tattelecom/intercom/domain/model/ConfigDto$Trial;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;ILjava/lang/Boolean;Lru/tattelecom/intercom/domain/model/ConfigDto$Trial;)Lru/tattelecom/intercom/domain/model/ConfigDto;", "equals", "other", "hashCode", "toString", "", "Trial", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfigDto {
    private final Boolean featRemoteLogging;
    private final Boolean isFirstEnter;
    private final int openDoorLockTimeout;
    private final Trial trial;

    public static /* synthetic */ ConfigDto copy$default(ConfigDto configDto, Boolean bool, int i, Boolean bool2, Trial trial, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = configDto.featRemoteLogging;
        }
        if ((i2 & 2) != 0) {
            i = configDto.openDoorLockTimeout;
        }
        if ((i2 & 4) != 0) {
            bool2 = configDto.isFirstEnter;
        }
        if ((i2 & 8) != 0) {
            trial = configDto.trial;
        }
        return configDto.copy(bool, i, bool2, trial);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getFeatRemoteLogging() {
        return this.featRemoteLogging;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOpenDoorLockTimeout() {
        return this.openDoorLockTimeout;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsFirstEnter() {
        return this.isFirstEnter;
    }

    /* renamed from: component4, reason: from getter */
    public final Trial getTrial() {
        return this.trial;
    }

    public final ConfigDto copy(Boolean featRemoteLogging, int openDoorLockTimeout, Boolean isFirstEnter, Trial trial) {
        return new ConfigDto(featRemoteLogging, openDoorLockTimeout, isFirstEnter, trial);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigDto)) {
            return false;
        }
        ConfigDto configDto = (ConfigDto) other;
        return Intrinsics.areEqual(this.featRemoteLogging, configDto.featRemoteLogging) && this.openDoorLockTimeout == configDto.openDoorLockTimeout && Intrinsics.areEqual(this.isFirstEnter, configDto.isFirstEnter) && Intrinsics.areEqual(this.trial, configDto.trial);
    }

    public int hashCode() {
        Boolean bool = this.featRemoteLogging;
        int hashCode = (((bool == null ? 0 : bool.hashCode()) * 31) + this.openDoorLockTimeout) * 31;
        Boolean bool2 = this.isFirstEnter;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Trial trial = this.trial;
        return hashCode2 + (trial != null ? trial.hashCode() : 0);
    }

    public String toString() {
        return "ConfigDto(featRemoteLogging=" + this.featRemoteLogging + ", openDoorLockTimeout=" + this.openDoorLockTimeout + ", isFirstEnter=" + this.isFirstEnter + ", trial=" + this.trial + ")";
    }

    public ConfigDto(Boolean bool, int i, Boolean bool2, Trial trial) {
        this.featRemoteLogging = bool;
        this.openDoorLockTimeout = i;
        this.isFirstEnter = bool2;
        this.trial = trial;
    }

    public final Boolean getFeatRemoteLogging() {
        return this.featRemoteLogging;
    }

    public final int getOpenDoorLockTimeout() {
        return this.openDoorLockTimeout;
    }

    public final Boolean isFirstEnter() {
        return this.isFirstEnter;
    }

    public final Trial getTrial() {
        return this.trial;
    }

    /* compiled from: ConfigDtos.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0006\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0004\u0010\r¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/domain/model/ConfigDto$Trial;", "", TtmlNode.ATTR_ID, "", "isAvailable", "", "isActive", "expireDays", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getExpireDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lru/tattelecom/intercom/domain/model/ConfigDto$Trial;", "equals", "other", "hashCode", "toString", "", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Trial {
        private final Integer expireDays;
        private final Integer id;
        private final Boolean isActive;
        private final Boolean isAvailable;

        public Trial() {
            this(null, null, null, null, 15, null);
        }

        public static /* synthetic */ Trial copy$default(Trial trial, Integer num, Boolean bool, Boolean bool2, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = trial.id;
            }
            if ((i & 2) != 0) {
                bool = trial.isAvailable;
            }
            if ((i & 4) != 0) {
                bool2 = trial.isActive;
            }
            if ((i & 8) != 0) {
                num2 = trial.expireDays;
            }
            return trial.copy(num, bool, bool2, num2);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getIsAvailable() {
            return this.isAvailable;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getIsActive() {
            return this.isActive;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getExpireDays() {
            return this.expireDays;
        }

        public final Trial copy(Integer id, Boolean isAvailable, Boolean isActive, Integer expireDays) {
            return new Trial(id, isAvailable, isActive, expireDays);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trial)) {
                return false;
            }
            Trial trial = (Trial) other;
            return Intrinsics.areEqual(this.id, trial.id) && Intrinsics.areEqual(this.isAvailable, trial.isAvailable) && Intrinsics.areEqual(this.isActive, trial.isActive) && Intrinsics.areEqual(this.expireDays, trial.expireDays);
        }

        public int hashCode() {
            Integer num = this.id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.isAvailable;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isActive;
            int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Integer num2 = this.expireDays;
            return hashCode3 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Trial(id=" + this.id + ", isAvailable=" + this.isAvailable + ", isActive=" + this.isActive + ", expireDays=" + this.expireDays + ")";
        }

        public Trial(Integer num, Boolean bool, Boolean bool2, Integer num2) {
            this.id = num;
            this.isAvailable = bool;
            this.isActive = bool2;
            this.expireDays = num2;
        }

        public final Integer getId() {
            return this.id;
        }

        public /* synthetic */ Trial(Integer num, Boolean bool, Boolean bool2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? false : bool2, (i & 8) != 0 ? 0 : num2);
        }

        public final Boolean isAvailable() {
            return this.isAvailable;
        }

        public final Boolean isActive() {
            return this.isActive;
        }

        public final Integer getExpireDays() {
            return this.expireDays;
        }
    }
}
