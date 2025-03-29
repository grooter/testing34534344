package ru.tattelecom.intercom.domain.workers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SetPushTokenStatusWorker.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.workers.SetPushTokenStatusWorker", f = "SetPushTokenStatusWorker.kt", i = {}, l = {22}, m = "doWork", n = {}, s = {})
/* loaded from: classes5.dex */
final class SetPushTokenStatusWorker$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SetPushTokenStatusWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SetPushTokenStatusWorker$doWork$1(SetPushTokenStatusWorker setPushTokenStatusWorker, Continuation<? super SetPushTokenStatusWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = setPushTokenStatusWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
