package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdvBottomSheetInteractorImpl.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AdvBottomSheetInteractorImpl", f = "AdvBottomSheetInteractorImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {28, 31, 35}, m = "updateAdv", n = {"this", "theme", "defaultTheme", "this", "theme", "defaultTheme"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
final class AdvBottomSheetInteractorImpl$updateAdv$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvBottomSheetInteractorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvBottomSheetInteractorImpl$updateAdv$1(AdvBottomSheetInteractorImpl advBottomSheetInteractorImpl, Continuation<? super AdvBottomSheetInteractorImpl$updateAdv$1> continuation) {
        super(continuation);
        this.this$0 = advBottomSheetInteractorImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateAdv(null, null, this);
    }
}
