package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SupportRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.SupportRemote", f = "SupportRemote.kt", i = {}, l = {37, 38}, m = "getPolicy", n = {}, s = {})
/* loaded from: classes5.dex */
final class SupportRemote$getPolicy$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SupportRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SupportRemote$getPolicy$1(SupportRemote supportRemote, Continuation<? super SupportRemote$getPolicy$1> continuation) {
        super(continuation);
        this.this$0 = supportRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getPolicy(this);
    }
}
