package ru.tattelecom.intercom.data.remote.source.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource", f = "EventHistoryPagingSource.kt", i = {0, 0, 1}, l = {392, 394}, m = "getCallEvents", n = {"this", "callEntities", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes5.dex */
final class EventHistoryPagingSource$getCallEvents$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistoryPagingSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryPagingSource$getCallEvents$1(EventHistoryPagingSource eventHistoryPagingSource, Continuation<? super EventHistoryPagingSource$getCallEvents$1> continuation) {
        super(continuation);
        this.this$0 = eventHistoryPagingSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object callEvents;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        callEvents = this.this$0.getCallEvents(null, this);
        return callEvents;
    }
}
