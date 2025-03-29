package ru.tattelecom.feature.call_history;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.remote.source.paging.EventHistory;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryBanner;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/feature/call_history/EventHistoryDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryDiffUtil extends DiffUtil.ItemCallback<HistoryItem> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(HistoryItem old, HistoryItem r4) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(r4, "new");
        return old.getType() == r4.getType() && Intrinsics.areEqual(old.getId(), r4.getId());
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(HistoryItem old, HistoryItem r3) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(r3, "new");
        if ((old instanceof EventHistory) && (r3 instanceof EventHistory)) {
            return Intrinsics.areEqual((EventHistory) old, (EventHistory) r3);
        }
        if ((old instanceof HistoryBanner) && (r3 instanceof HistoryBanner)) {
            return Intrinsics.areEqual((HistoryBanner) old, (HistoryBanner) r3);
        }
        return false;
    }
}
