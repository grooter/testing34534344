package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SupportInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.SupportInteractor", f = "SupportInteractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 2}, l = {69, 71, 84}, m = "getContactsWithAuth", n = {"this", "currentDate", "isError", "this", "currentDate", "response", "isError", "isError"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "I$0", "I$0"})
/* loaded from: classes5.dex */
final class SupportInteractor$getContactsWithAuth$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SupportInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SupportInteractor$getContactsWithAuth$1(SupportInteractor supportInteractor, Continuation<? super SupportInteractor$getContactsWithAuth$1> continuation) {
        super(continuation);
        this.this$0 = supportInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getContactsWithAuth(this);
    }
}
