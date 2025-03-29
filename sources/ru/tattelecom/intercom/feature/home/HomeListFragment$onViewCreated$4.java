package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$4 extends FunctionReferenceImpl implements Function1<HomeStream, Unit> {
    HomeListFragment$onViewCreated$4(Object obj) {
        super(1, obj, HomeViewModel.class, "onStreamClick", "onStreamClick(Lru/tattelecom/intercom/feature/home/HomeStream;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HomeStream homeStream) {
        invoke2(homeStream);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HomeStream p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((HomeViewModel) this.receiver).onStreamClick(p0);
    }
}
