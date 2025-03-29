package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.tattelecom.intercom.domain.workers.SendPushTokenWorker;
import ru.tattelecom.intercom.domain.workers.SetPushTokenStatusWorker;

/* compiled from: PushInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.PushInteractor", f = "PushInteractor.kt", i = {0, 0, 0, 0}, l = {77, 85}, m = "updatePushToken", n = {"this", SendPushTokenWorker.PUSH_TOKEN, SendPushTokenWorker.PUSH_SERVICE, SetPushTokenStatusWorker.PUSH_TOKEN_STATUS}, s = {"L$0", "L$1", "L$2", "Z$0"})
/* loaded from: classes5.dex */
final class PushInteractor$updatePushToken$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PushInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushInteractor$updatePushToken$1(PushInteractor pushInteractor, Continuation<? super PushInteractor$updatePushToken$1> continuation) {
        super(continuation);
        this.this$0 = pushInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePushToken(null, null, false, this);
    }
}
