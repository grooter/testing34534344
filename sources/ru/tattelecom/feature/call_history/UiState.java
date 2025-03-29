package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.data.remote.source.paging.DataLoadType;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lru/tattelecom/feature/call_history/UiState;", "", "dataLoadType", "Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "lastLoadType", "hasNotScrolledForCurrentSearch", "", "(Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;Z)V", "getDataLoadType", "()Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "getHasNotScrolledForCurrentSearch", "()Z", "getLastLoadType", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UiState {
    private final DataLoadType dataLoadType;
    private final boolean hasNotScrolledForCurrentSearch;
    private final DataLoadType lastLoadType;

    public UiState() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ UiState copy$default(UiState uiState, DataLoadType dataLoadType, DataLoadType dataLoadType2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dataLoadType = uiState.dataLoadType;
        }
        if ((i & 2) != 0) {
            dataLoadType2 = uiState.lastLoadType;
        }
        if ((i & 4) != 0) {
            z = uiState.hasNotScrolledForCurrentSearch;
        }
        return uiState.copy(dataLoadType, dataLoadType2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final DataLoadType getDataLoadType() {
        return this.dataLoadType;
    }

    /* renamed from: component2, reason: from getter */
    public final DataLoadType getLastLoadType() {
        return this.lastLoadType;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasNotScrolledForCurrentSearch() {
        return this.hasNotScrolledForCurrentSearch;
    }

    public final UiState copy(DataLoadType dataLoadType, DataLoadType lastLoadType, boolean hasNotScrolledForCurrentSearch) {
        Intrinsics.checkNotNullParameter(dataLoadType, "dataLoadType");
        Intrinsics.checkNotNullParameter(lastLoadType, "lastLoadType");
        return new UiState(dataLoadType, lastLoadType, hasNotScrolledForCurrentSearch);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UiState)) {
            return false;
        }
        UiState uiState = (UiState) other;
        return this.dataLoadType == uiState.dataLoadType && this.lastLoadType == uiState.lastLoadType && this.hasNotScrolledForCurrentSearch == uiState.hasNotScrolledForCurrentSearch;
    }

    public int hashCode() {
        return (((this.dataLoadType.hashCode() * 31) + this.lastLoadType.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.hasNotScrolledForCurrentSearch);
    }

    public String toString() {
        return "UiState(dataLoadType=" + this.dataLoadType + ", lastLoadType=" + this.lastLoadType + ", hasNotScrolledForCurrentSearch=" + this.hasNotScrolledForCurrentSearch + ")";
    }

    public UiState(DataLoadType dataLoadType, DataLoadType lastLoadType, boolean z) {
        Intrinsics.checkNotNullParameter(dataLoadType, "dataLoadType");
        Intrinsics.checkNotNullParameter(lastLoadType, "lastLoadType");
        this.dataLoadType = dataLoadType;
        this.lastLoadType = lastLoadType;
        this.hasNotScrolledForCurrentSearch = z;
    }

    public /* synthetic */ UiState(DataLoadType dataLoadType, DataLoadType dataLoadType2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DataLoadType.TYPE_ALL : dataLoadType, (i & 2) != 0 ? DataLoadType.TYPE_ALL : dataLoadType2, (i & 4) != 0 ? false : z);
    }

    public final DataLoadType getDataLoadType() {
        return this.dataLoadType;
    }

    public final DataLoadType getLastLoadType() {
        return this.lastLoadType;
    }

    public final boolean getHasNotScrolledForCurrentSearch() {
        return this.hasNotScrolledForCurrentSearch;
    }
}
