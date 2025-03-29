package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EventHistoryRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.EventHistoryRemote", f = "EventHistoryRemote.kt", i = {0, 0, 0}, l = {61, 109, 110}, m = "getImage", n = {"this", "$this$getImage_u24lambda_u244", "callId"}, s = {"L$0", "L$3", "I$0"})
/* loaded from: classes5.dex */
final class EventHistoryRemote$getImage$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistoryRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryRemote$getImage$1(EventHistoryRemote eventHistoryRemote, Continuation<? super EventHistoryRemote$getImage$1> continuation) {
        super(continuation);
        this.this$0 = eventHistoryRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getImage(0, this);
    }
}
