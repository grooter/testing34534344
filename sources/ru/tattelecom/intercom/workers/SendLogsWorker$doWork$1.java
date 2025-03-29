package ru.tattelecom.intercom.workers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SendLogsWorker.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.workers.SendLogsWorker", f = "SendLogsWorker.kt", i = {}, l = {22}, m = "doWork", n = {}, s = {})
/* loaded from: classes8.dex */
final class SendLogsWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendLogsWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SendLogsWorker$doWork$1(SendLogsWorker sendLogsWorker, Continuation<? super SendLogsWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = sendLogsWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
