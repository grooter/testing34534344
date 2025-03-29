package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* compiled from: EventHistoryFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
/* synthetic */ class EventHistoryFragment$bindList$shouldScrollToTop$1 extends AdaptedFunctionReference implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object>, SuspendFunction {
    public static final EventHistoryFragment$bindList$shouldScrollToTop$1 INSTANCE = new EventHistoryFragment$bindList$shouldScrollToTop$1();

    EventHistoryFragment$bindList$shouldScrollToTop$1() {
        super(3, Boolean.TYPE, "and", "and(Z)Z", 4);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Boolean bool2, Continuation<? super Boolean> continuation) {
        return invoke(bool.booleanValue(), bool2.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, boolean z2, Continuation<? super Boolean> continuation) {
        Object bindList$and;
        bindList$and = EventHistoryFragment.bindList$and(z, z2, continuation);
        return bindList$and;
    }
}
