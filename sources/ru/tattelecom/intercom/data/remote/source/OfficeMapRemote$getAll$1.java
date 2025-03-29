package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: OfficeMapRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.OfficeMapRemote", f = "OfficeMapRemote.kt", i = {}, l = {18, 19}, m = "getAll", n = {}, s = {})
/* loaded from: classes5.dex */
final class OfficeMapRemote$getAll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeMapRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfficeMapRemote$getAll$1(OfficeMapRemote officeMapRemote, Continuation<? super OfficeMapRemote$getAll$1> continuation) {
        super(continuation);
        this.this$0 = officeMapRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAll(this);
    }
}
