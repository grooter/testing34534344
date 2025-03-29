package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GateRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.GateRemote", f = "GateRemote.kt", i = {}, l = {62, 63}, m = "setFavorite", n = {}, s = {})
/* loaded from: classes5.dex */
final class GateRemote$setFavorite$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GateRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GateRemote$setFavorite$1(GateRemote gateRemote, Continuation<? super GateRemote$setFavorite$1> continuation) {
        super(continuation);
        this.this$0 = gateRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setFavorite(null, false, this);
    }
}
