package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AdvRemoteImpl.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl", f = "AdvRemoteImpl.kt", i = {0, 0}, l = {26, 54, 55}, m = "setAdvIsRead", n = {"$this$setAdvIsRead_u24lambda_u241", TtmlNode.ATTR_ID}, s = {"L$2", "J$0"})
/* loaded from: classes5.dex */
final class AdvRemoteImpl$setAdvIsRead$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AdvRemoteImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvRemoteImpl$setAdvIsRead$1(AdvRemoteImpl advRemoteImpl, Continuation<? super AdvRemoteImpl$setAdvIsRead$1> continuation) {
        super(continuation);
        this.this$0 = advRemoteImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setAdvIsRead(0L, this);
    }
}
