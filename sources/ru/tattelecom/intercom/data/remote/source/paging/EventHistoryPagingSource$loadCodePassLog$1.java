package ru.tattelecom.intercom.data.remote.source.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource", f = "EventHistoryPagingSource.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3}, l = {226, 228, 462, 238}, m = "loadCodePassLog", n = {"this", "page", "this", "page", "this", "response", "page", "this", "pageCount", "page"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* loaded from: classes5.dex */
final class EventHistoryPagingSource$loadCodePassLog$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistoryPagingSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryPagingSource$loadCodePassLog$1(EventHistoryPagingSource eventHistoryPagingSource, Continuation<? super EventHistoryPagingSource$loadCodePassLog$1> continuation) {
        super(continuation);
        this.this$0 = eventHistoryPagingSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadCodePassLog;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadCodePassLog = this.this$0.loadCodePassLog(null, this);
        return loadCodePassLog;
    }
}
