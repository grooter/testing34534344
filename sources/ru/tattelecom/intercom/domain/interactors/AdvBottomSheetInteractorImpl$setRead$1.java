package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdvBottomSheetInteractorImpl.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AdvBottomSheetInteractorImpl", f = "AdvBottomSheetInteractorImpl.kt", i = {}, l = {50}, m = "setRead", n = {}, s = {})
/* loaded from: classes5.dex */
final class AdvBottomSheetInteractorImpl$setRead$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvBottomSheetInteractorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvBottomSheetInteractorImpl$setRead$1(AdvBottomSheetInteractorImpl advBottomSheetInteractorImpl, Continuation<? super AdvBottomSheetInteractorImpl$setRead$1> continuation) {
        super(continuation);
        this.this$0 = advBottomSheetInteractorImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setRead(0L, this);
    }
}
