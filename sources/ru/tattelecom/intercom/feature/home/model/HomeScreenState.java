package ru.tattelecom.intercom.feature.home.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.domain.model.TrialDto;

/* compiled from: HomeScreenState.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "", "()V", "Error", "FirstOpen", "NewUser", "OldUser", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState$Error;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState$FirstOpen;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState$NewUser;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState$OldUser;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class HomeScreenState {
    public /* synthetic */ HomeScreenState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HomeScreenState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeScreenState$FirstOpen;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class FirstOpen extends HomeScreenState {
        public static final FirstOpen INSTANCE = new FirstOpen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FirstOpen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 835464588;
        }

        public String toString() {
            return "FirstOpen";
        }

        private FirstOpen() {
            super(null);
        }
    }

    private HomeScreenState() {
    }

    /* compiled from: HomeScreenState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeScreenState$NewUser;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NewUser extends HomeScreenState {
        public static final NewUser INSTANCE = new NewUser();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NewUser)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1135363709;
        }

        public String toString() {
            return "NewUser";
        }

        private NewUser() {
            super(null);
        }
    }

    /* compiled from: HomeScreenState.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeScreenState$OldUser;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "isBannerVisible", "", "trialDto", "Lru/tattelecom/intercom/domain/model/TrialDto;", "(ZLru/tattelecom/intercom/domain/model/TrialDto;)V", "()Z", "getTrialDto", "()Lru/tattelecom/intercom/domain/model/TrialDto;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OldUser extends HomeScreenState {
        private final boolean isBannerVisible;
        private final TrialDto trialDto;

        public static /* synthetic */ OldUser copy$default(OldUser oldUser, boolean z, TrialDto trialDto, int i, Object obj) {
            if ((i & 1) != 0) {
                z = oldUser.isBannerVisible;
            }
            if ((i & 2) != 0) {
                trialDto = oldUser.trialDto;
            }
            return oldUser.copy(z, trialDto);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsBannerVisible() {
            return this.isBannerVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final TrialDto getTrialDto() {
            return this.trialDto;
        }

        public final OldUser copy(boolean isBannerVisible, TrialDto trialDto) {
            return new OldUser(isBannerVisible, trialDto);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OldUser)) {
                return false;
            }
            OldUser oldUser = (OldUser) other;
            return this.isBannerVisible == oldUser.isBannerVisible && Intrinsics.areEqual(this.trialDto, oldUser.trialDto);
        }

        public int hashCode() {
            int m = AdvThemeDto$$ExternalSyntheticBackport0.m(this.isBannerVisible) * 31;
            TrialDto trialDto = this.trialDto;
            return m + (trialDto == null ? 0 : trialDto.hashCode());
        }

        public String toString() {
            return "OldUser(isBannerVisible=" + this.isBannerVisible + ", trialDto=" + this.trialDto + ")";
        }

        public /* synthetic */ OldUser(boolean z, TrialDto trialDto, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : trialDto);
        }

        public final boolean isBannerVisible() {
            return this.isBannerVisible;
        }

        public final TrialDto getTrialDto() {
            return this.trialDto;
        }

        public OldUser(boolean z, TrialDto trialDto) {
            super(null);
            this.isBannerVisible = z;
            this.trialDto = trialDto;
        }
    }

    /* compiled from: HomeScreenState.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeScreenState$Error;", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Error extends HomeScreenState {
        public static final Error INSTANCE = new Error();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Error)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -2053672070;
        }

        public String toString() {
            return "Error";
        }

        private Error() {
            super(null);
        }
    }
}
