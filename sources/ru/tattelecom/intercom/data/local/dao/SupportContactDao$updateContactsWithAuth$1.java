package ru.tattelecom.intercom.data.local.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao;

/* compiled from: SupportContactDao.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.local.dao.SupportContactDao$DefaultImpls", f = "SupportContactDao.kt", i = {0, 0}, l = {42, 43}, m = "updateContactsWithAuth", n = {"$this", "contacts"}, s = {"L$0", "L$1"})
/* loaded from: classes5.dex */
final class SupportContactDao$updateContactsWithAuth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    SupportContactDao$updateContactsWithAuth$1(Continuation<? super SupportContactDao$updateContactsWithAuth$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SupportContactDao.DefaultImpls.updateContactsWithAuth(null, null, this);
    }
}
