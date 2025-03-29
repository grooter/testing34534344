package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$2 extends FunctionReferenceImpl implements Function1<HomeAddress, Unit> {
    HomeListFragment$onViewCreated$2(Object obj) {
        super(1, obj, HomeViewModel.class, "onAddressClick", "onAddressClick(Lru/tattelecom/intercom/feature/home/HomeAddress;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HomeAddress homeAddress) {
        invoke2(homeAddress);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HomeAddress p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((HomeViewModel) this.receiver).onAddressClick(p0);
    }
}
