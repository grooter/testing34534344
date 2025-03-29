package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PushRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.PushRemote", f = "PushRemote.kt", i = {}, l = {46, 47}, m = "updatePushToken", n = {}, s = {})
/* loaded from: classes5.dex */
final class PushRemote$updatePushToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushRemote$updatePushToken$1(PushRemote pushRemote, Continuation<? super PushRemote$updatePushToken$1> continuation) {
        super(continuation);
        this.this$0 = pushRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePushToken(null, null, this);
    }
}
