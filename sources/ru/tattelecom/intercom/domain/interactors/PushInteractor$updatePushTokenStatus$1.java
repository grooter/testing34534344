package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PushInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.PushInteractor", f = "PushInteractor.kt", i = {0, 0}, l = {57, 59}, m = "updatePushTokenStatus", n = {"this", "status"}, s = {"L$0", "Z$0"})
/* loaded from: classes5.dex */
final class PushInteractor$updatePushTokenStatus$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushInteractor$updatePushTokenStatus$1(PushInteractor pushInteractor, Continuation<? super PushInteractor$updatePushTokenStatus$1> continuation) {
        super(continuation);
        this.this$0 = pushInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePushTokenStatus(false, this);
    }
}
