package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: EventHistoryRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.EventHistoryRemote", f = "EventHistoryRemote.kt", i = {}, l = {126, 127}, m = "removeKeyLogFromUser", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryRemote$removeKeyLogFromUser$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventHistoryRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryRemote$removeKeyLogFromUser$1(EventHistoryRemote eventHistoryRemote, Continuation<? super EventHistoryRemote$removeKeyLogFromUser$1> continuation) {
        super(continuation);
        this.this$0 = eventHistoryRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeKeyLogFromUser(null, this);
    }
}
