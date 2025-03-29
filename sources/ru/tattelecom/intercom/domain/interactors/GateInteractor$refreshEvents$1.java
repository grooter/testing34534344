package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GateInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.GateInteractor", f = "GateInteractor.kt", i = {0, 0, 0, 1, 1}, l = {112, 116, 119}, m = "refreshEvents", n = {"this", "gateId", "date", "this", "gateId"}, s = {"L$0", "I$0", "J$0", "L$0", "I$0"})
/* loaded from: classes5.dex */
final class GateInteractor$refreshEvents$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GateInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GateInteractor$refreshEvents$1(GateInteractor gateInteractor, Continuation<? super GateInteractor$refreshEvents$1> continuation) {
        super(continuation);
        this.this$0 = gateInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshEvents(0, 0L, this);
    }
}
