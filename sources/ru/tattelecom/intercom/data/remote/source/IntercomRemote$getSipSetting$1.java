package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: IntercomRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.IntercomRemote", f = "IntercomRemote.kt", i = {}, l = {91, 92}, m = "getSipSetting", n = {}, s = {})
/* loaded from: classes5.dex */
final class IntercomRemote$getSipSetting$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IntercomRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntercomRemote$getSipSetting$1(IntercomRemote intercomRemote, Continuation<? super IntercomRemote$getSipSetting$1> continuation) {
        super(continuation);
        this.this$0 = intercomRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getSipSetting(this);
    }
}
