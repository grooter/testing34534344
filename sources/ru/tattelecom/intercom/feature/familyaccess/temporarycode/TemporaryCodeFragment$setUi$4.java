package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: TemporaryCodeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class TemporaryCodeFragment$setUi$4 extends FunctionReferenceImpl implements Function2<Integer, String, Unit> {
    TemporaryCodeFragment$setUi$4(Object obj) {
        super(2, obj, TemporaryCodeViewModel.class, "shareCode", "shareCode(Ljava/lang/Integer;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
        invoke2(num, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num, String str) {
        ((TemporaryCodeViewModel) this.receiver).shareCode(num, str);
    }
}
