package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HomeViewModel.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel", f = "HomeViewModel.kt", i = {0}, l = {369}, m = "getBuildingServices", n = {"this"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class HomeViewModel$getBuildingServices$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$getBuildingServices$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$getBuildingServices$1> continuation) {
        super(continuation);
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object buildingServices;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        buildingServices = this.this$0.getBuildingServices(0, this);
        return buildingServices;
    }
}
