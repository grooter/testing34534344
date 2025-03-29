package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfigRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.ConfigRemote", f = "ConfigRemote.kt", i = {}, l = {51, 52}, m = "startTrial", n = {}, s = {})
/* loaded from: classes5.dex */
final class ConfigRemote$startTrial$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConfigRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigRemote$startTrial$1(ConfigRemote configRemote, Continuation<? super ConfigRemote$startTrial$1> continuation) {
        super(continuation);
        this.this$0 = configRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.startTrial(0, this);
    }
}
