package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ConfigInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.ConfigInteractor", f = "ConfigInteractor.kt", i = {0}, l = {95}, m = "getConfig", n = {"this"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class ConfigInteractor$getConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConfigInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigInteractor$getConfig$1(ConfigInteractor configInteractor, Continuation<? super ConfigInteractor$getConfig$1> continuation) {
        super(continuation);
        this.this$0 = configInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getConfig(this);
    }
}
