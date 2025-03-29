package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StreamRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.StreamRemote", f = "StreamRemote.kt", i = {}, l = {105, 106}, m = "getLive", n = {}, s = {})
/* loaded from: classes5.dex */
final class StreamRemote$getLive$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamRemote$getLive$1(StreamRemote streamRemote, Continuation<? super StreamRemote$getLive$1> continuation) {
        super(continuation);
        this.this$0 = streamRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLive(null, false, this);
    }
}
