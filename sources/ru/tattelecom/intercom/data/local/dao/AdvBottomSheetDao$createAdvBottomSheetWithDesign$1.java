package ru.tattelecom.intercom.data.local.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao;

/* compiled from: AdvBottomSheetDao.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao$DefaultImpls", f = "AdvBottomSheetDao.kt", i = {0, 0, 1, 1}, l = {43, 45}, m = "createAdvBottomSheetWithDesign", n = {"$this", "design", "$this", "advId"}, s = {"L$0", "L$1", "L$0", "J$0"})
/* loaded from: classes5.dex */
final class AdvBottomSheetDao$createAdvBottomSheetWithDesign$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    AdvBottomSheetDao$createAdvBottomSheetWithDesign$1(Continuation<? super AdvBottomSheetDao$createAdvBottomSheetWithDesign$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AdvBottomSheetDao.DefaultImpls.createAdvBottomSheetWithDesign(null, null, null, this);
    }
}
