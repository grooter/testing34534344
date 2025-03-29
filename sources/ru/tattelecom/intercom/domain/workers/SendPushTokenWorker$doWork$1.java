package ru.tattelecom.intercom.domain.workers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SendPushTokenWorker.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.workers.SendPushTokenWorker", f = "SendPushTokenWorker.kt", i = {0}, l = {24, 25}, m = "doWork", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class SendPushTokenWorker$doWork$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendPushTokenWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SendPushTokenWorker$doWork$1(SendPushTokenWorker sendPushTokenWorker, Continuation<? super SendPushTokenWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = sendPushTokenWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
