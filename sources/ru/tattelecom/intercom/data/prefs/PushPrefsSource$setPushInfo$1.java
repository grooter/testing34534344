package ru.tattelecom.intercom.data.prefs;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PushPrefsSource.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.prefs.PushPrefsSource", f = "PushPrefsSource.kt", i = {0, 0, 0}, l = {58}, m = "setPushInfo", n = {"this", "pushInfo", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
final class PushPrefsSource$setPushInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushPrefsSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushPrefsSource$setPushInfo$1(PushPrefsSource pushPrefsSource, Continuation<? super PushPrefsSource$setPushInfo$1> continuation) {
        super(continuation);
        this.this$0 = pushPrefsSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setPushInfo(null, this);
    }
}
