package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: HomeListFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class HomeListFragment$onViewCreated$9 extends FunctionReferenceImpl implements Function2<Integer, String, Unit> {
    HomeListFragment$onViewCreated$9(Object obj) {
        super(2, obj, HomeViewModel.class, "shareTemporaryCode", "shareTemporaryCode(Ljava/lang/Integer;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
        invoke2(num, str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num, String str) {
        ((HomeViewModel) this.receiver).shareTemporaryCode(num, str);
    }
}
