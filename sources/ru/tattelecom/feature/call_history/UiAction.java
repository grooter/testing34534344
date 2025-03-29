package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.data.remote.source.paging.DataLoadType;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/feature/call_history/UiAction;", "", "()V", "Scroll", "SwitchLoadType", "Lru/tattelecom/feature/call_history/UiAction$Scroll;", "Lru/tattelecom/feature/call_history/UiAction$SwitchLoadType;", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class UiAction {
    public /* synthetic */ UiAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: EventHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lru/tattelecom/feature/call_history/UiAction$SwitchLoadType;", "Lru/tattelecom/feature/call_history/UiAction;", "loadType", "Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "isBannerClosed", "", "(Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;Z)V", "()Z", "getLoadType", "()Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class SwitchLoadType extends UiAction {
        private final boolean isBannerClosed;
        private final DataLoadType loadType;

        public static /* synthetic */ SwitchLoadType copy$default(SwitchLoadType switchLoadType, DataLoadType dataLoadType, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                dataLoadType = switchLoadType.loadType;
            }
            if ((i & 2) != 0) {
                z = switchLoadType.isBannerClosed;
            }
            return switchLoadType.copy(dataLoadType, z);
        }

        /* renamed from: component1, reason: from getter */
        public final DataLoadType getLoadType() {
            return this.loadType;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsBannerClosed() {
            return this.isBannerClosed;
        }

        public final SwitchLoadType copy(DataLoadType loadType, boolean isBannerClosed) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            return new SwitchLoadType(loadType, isBannerClosed);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SwitchLoadType)) {
                return false;
            }
            SwitchLoadType switchLoadType = (SwitchLoadType) other;
            return this.loadType == switchLoadType.loadType && this.isBannerClosed == switchLoadType.isBannerClosed;
        }

        public int hashCode() {
            return (this.loadType.hashCode() * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.isBannerClosed);
        }

        public String toString() {
            return "SwitchLoadType(loadType=" + this.loadType + ", isBannerClosed=" + this.isBannerClosed + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SwitchLoadType(DataLoadType loadType, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            this.loadType = loadType;
            this.isBannerClosed = z;
        }

        public final DataLoadType getLoadType() {
            return this.loadType;
        }

        public final boolean isBannerClosed() {
            return this.isBannerClosed;
        }
    }

    private UiAction() {
    }

    /* compiled from: EventHistoryViewModel.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/tattelecom/feature/call_history/UiAction$Scroll;", "Lru/tattelecom/feature/call_history/UiAction;", "currentType", "Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "(Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;)V", "getCurrentType", "()Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Scroll extends UiAction {
        private final DataLoadType currentType;

        public static /* synthetic */ Scroll copy$default(Scroll scroll, DataLoadType dataLoadType, int i, Object obj) {
            if ((i & 1) != 0) {
                dataLoadType = scroll.currentType;
            }
            return scroll.copy(dataLoadType);
        }

        /* renamed from: component1, reason: from getter */
        public final DataLoadType getCurrentType() {
            return this.currentType;
        }

        public final Scroll copy(DataLoadType currentType) {
            Intrinsics.checkNotNullParameter(currentType, "currentType");
            return new Scroll(currentType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Scroll) && this.currentType == ((Scroll) other).currentType;
        }

        public int hashCode() {
            return this.currentType.hashCode();
        }

        public String toString() {
            return "Scroll(currentType=" + this.currentType + ")";
        }

        public final DataLoadType getCurrentType() {
            return this.currentType;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Scroll(DataLoadType currentType) {
            super(null);
            Intrinsics.checkNotNullParameter(currentType, "currentType");
            this.currentType = currentType;
        }
    }
}
