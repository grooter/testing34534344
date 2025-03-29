package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$5 extends FunctionReferenceImpl implements Function0<Unit> {
    HomeListFragment$onViewCreated$5(Object obj) {
        super(0, obj, HomeViewModel.class, "onDisableDoNotDisturbClick", "onDisableDoNotDisturbClick()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((HomeViewModel) this.receiver).onDisableDoNotDisturbClick();
    }
}
