package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$7 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    HomeListFragment$onViewCreated$7(Object obj) {
        super(1, obj, HomeViewModel.class, "onSetCallsScheduleClick", "onSetCallsScheduleClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((HomeViewModel) this.receiver).onSetCallsScheduleClick(i);
    }
}
