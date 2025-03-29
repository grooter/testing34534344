package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TemporaryCodeFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class TemporaryCodeFragment$setUi$3 extends FunctionReferenceImpl implements Function1<TemporaryCodeItem, Unit> {
    TemporaryCodeFragment$setUi$3(Object obj) {
        super(1, obj, TemporaryCodeViewModel.class, "deleteCode", "deleteCode(Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TemporaryCodeItem temporaryCodeItem) {
        invoke2(temporaryCodeItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TemporaryCodeItem p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((TemporaryCodeViewModel) this.receiver).deleteCode(p0);
    }
}
