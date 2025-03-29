package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel", f = "EventHistoryViewModel.kt", i = {0, 1, 2, 3}, l = {208, 214, 220, 225, 227}, m = "removeEvent", n = {"this", "this", "this", "this"}, s = {"L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes5.dex */
final class EventHistoryViewModel$removeEvent$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryViewModel$removeEvent$1(EventHistoryViewModel eventHistoryViewModel, Continuation<? super EventHistoryViewModel$removeEvent$1> continuation) {
        super(continuation);
        this.this$0 = eventHistoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeEvent(null, false, this);
    }
}
