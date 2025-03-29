package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$6 extends FunctionReferenceImpl implements Function2<Integer, Boolean, Unit> {
    HomeListFragment$onViewCreated$6(Object obj) {
        super(2, obj, HomeViewModel.class, "onSetCallsMutedClick", "onSetCallsMutedClick(IZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool) {
        invoke(num.intValue(), bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, boolean z) {
        ((HomeViewModel) this.receiver).onSetCallsMutedClick(i, z);
    }
}
