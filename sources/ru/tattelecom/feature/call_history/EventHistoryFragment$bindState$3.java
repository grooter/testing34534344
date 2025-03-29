package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: EventHistoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class EventHistoryFragment$bindState$3 extends FunctionReferenceImpl implements Function0<Unit> {
    EventHistoryFragment$bindState$3(Object obj) {
        super(0, obj, EventHistoryFragment.class, "closeBanner", "closeBanner()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((EventHistoryFragment) this.receiver).closeBanner();
    }
}
