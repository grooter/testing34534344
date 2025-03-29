package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class EventHistoryFragment$bindState$1 extends FunctionReferenceImpl implements Function1<HistoryItem, Unit> {
    EventHistoryFragment$bindState$1(Object obj) {
        super(1, obj, EventHistoryViewModel.class, "onEventSelected", "onEventSelected(Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HistoryItem historyItem) {
        invoke2(historyItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HistoryItem p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((EventHistoryViewModel) this.receiver).onEventSelected(p0);
    }
}
