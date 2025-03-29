package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LockGateInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.LockGateInteractor", f = "LockGateInteractor.kt", i = {0}, l = {39}, m = "checkLockGateByWidgetId", n = {"gateId"}, s = {"I$0"})
/* loaded from: classes5.dex */
final class LockGateInteractor$checkLockGateByWidgetId$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LockGateInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockGateInteractor$checkLockGateByWidgetId$1(LockGateInteractor lockGateInteractor, Continuation<? super LockGateInteractor$checkLockGateByWidgetId$1> continuation) {
        super(continuation);
        this.this$0 = lockGateInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkLockGateByWidgetId(0, this);
    }
}
