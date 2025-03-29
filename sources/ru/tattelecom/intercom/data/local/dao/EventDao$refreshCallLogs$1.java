package ru.tattelecom.intercom.data.local.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: EventDao.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.local.dao.EventDao$DefaultImpls", f = "EventDao.kt", i = {0, 0}, l = {23, 24}, m = "refreshCallLogs", n = {"$this", EntitiesKt.CALLS_TABLE}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
final class EventDao$refreshCallLogs$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    EventDao$refreshCallLogs$1(Continuation<? super EventDao$refreshCallLogs$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return EventDao.DefaultImpls.refreshCallLogs(null, null, this);
    }
}
