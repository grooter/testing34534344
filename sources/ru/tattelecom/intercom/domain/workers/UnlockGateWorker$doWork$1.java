package ru.tattelecom.intercom.domain.workers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UnlockGateWorker.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.workers.UnlockGateWorker", f = "UnlockGateWorker.kt", i = {}, l = {17}, m = "doWork", n = {}, s = {})
/* loaded from: classes5.dex */
final class UnlockGateWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UnlockGateWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnlockGateWorker$doWork$1(UnlockGateWorker unlockGateWorker, Continuation<? super UnlockGateWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = unlockGateWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
