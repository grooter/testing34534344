package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LeadRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.LeadRemote", f = "LeadRemote.kt", i = {}, l = {88, 89}, m = "getLeaveOrderServices", n = {}, s = {})
/* loaded from: classes5.dex */
final class LeadRemote$getLeaveOrderServices$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LeadRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LeadRemote$getLeaveOrderServices$1(LeadRemote leadRemote, Continuation<? super LeadRemote$getLeaveOrderServices$1> continuation) {
        super(continuation);
        this.this$0 = leadRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLeaveOrderServices(null, null, this);
    }
}
