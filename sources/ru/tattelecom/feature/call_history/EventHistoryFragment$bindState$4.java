package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryBanner;

/* compiled from: EventHistoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class EventHistoryFragment$bindState$4 extends FunctionReferenceImpl implements Function1<HistoryBanner, Unit> {
    EventHistoryFragment$bindState$4(Object obj) {
        super(1, obj, EventHistoryViewModel.class, "navigateToConnectServices", "navigateToConnectServices(Lru/tattelecom/intercom/data/remote/source/paging/HistoryBanner;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HistoryBanner historyBanner) {
        invoke2(historyBanner);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HistoryBanner p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((EventHistoryViewModel) this.receiver).navigateToConnectServices(p0);
    }
}
