package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LockGateInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.LockGateInteractor", f = "LockGateInteractor.kt", i = {0}, l = {30}, m = "deleteOld", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class LockGateInteractor$deleteOld$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LockGateInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockGateInteractor$deleteOld$1(LockGateInteractor lockGateInteractor, Continuation<? super LockGateInteractor$deleteOld$1> continuation) {
        super(continuation);
        this.this$0 = lockGateInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deleteOld(this);
    }
}
