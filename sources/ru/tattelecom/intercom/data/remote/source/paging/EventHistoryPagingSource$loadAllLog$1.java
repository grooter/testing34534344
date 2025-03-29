package ru.tattelecom.intercom.data.remote.source.paging;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource", f = "EventHistoryPagingSource.kt", i = {0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4}, l = {101, 462, 114, 117, 120}, m = "loadAllLog", n = {"this", "page", "this", "pageCount", "page", "this", "pageCount", "keyEntities", "codePassEntities", "page", "this", "pageCount", "codePassEntities", EntitiesKt.CALLS_TABLE, "page", "pageCount", EntitiesKt.CALLS_TABLE, UserMetadata.KEYDATA_FILENAME, "page"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "I$0"})
/* loaded from: classes5.dex */
final class EventHistoryPagingSource$loadAllLog$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistoryPagingSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryPagingSource$loadAllLog$1(EventHistoryPagingSource eventHistoryPagingSource, Continuation<? super EventHistoryPagingSource$loadAllLog$1> continuation) {
        super(continuation);
        this.this$0 = eventHistoryPagingSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object loadAllLog;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        loadAllLog = this.this$0.loadAllLog(null, this);
        return loadAllLog;
    }
}
