package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: GateRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.GateRemote", f = "GateRemote.kt", i = {0, 0}, l = {23, 62, 63}, m = TtmlNode.TEXT_EMPHASIS_MARK_OPEN, n = {"gateId", "$this$open_u24lambda_u240"}, s = {"L$0", "L$3"})
/* loaded from: classes5.dex */
final class GateRemote$open$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GateRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GateRemote$open$1(GateRemote gateRemote, Continuation<? super GateRemote$open$1> continuation) {
        super(continuation);
        this.this$0 = gateRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.open(null, this);
    }
}
