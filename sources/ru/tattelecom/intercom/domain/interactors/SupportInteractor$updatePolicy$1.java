package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SupportInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.SupportInteractor", f = "SupportInteractor.kt", i = {0}, l = {25}, m = "updatePolicy", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class SupportInteractor$updatePolicy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SupportInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SupportInteractor$updatePolicy$1(SupportInteractor supportInteractor, Continuation<? super SupportInteractor$updatePolicy$1> continuation) {
        super(continuation);
        this.this$0 = supportInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePolicy(this);
    }
}
