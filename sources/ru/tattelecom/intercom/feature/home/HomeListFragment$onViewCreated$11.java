package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$11 extends FunctionReferenceImpl implements Function1<ConfigInteractor.ToolTips, Unit> {
    HomeListFragment$onViewCreated$11(Object obj) {
        super(1, obj, HomeViewModel.class, "onCloseToolTip", "onCloseToolTip(Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ConfigInteractor.ToolTips toolTips) {
        invoke2(toolTips);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ConfigInteractor.ToolTips p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((HomeViewModel) this.receiver).onCloseToolTip(p0);
    }
}
