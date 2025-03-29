package ru.tattelecom.intercom.feature.home;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u008a@"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "favoriteFlow", "", "Lru/tattelecom/intercom/feature/home/HomeItem;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$favoriteListIsEmpty$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$favoriteListIsEmpty$1 extends SuspendLambda implements Function3<Boolean, List<? extends HomeItem>, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    HomeViewModel$favoriteListIsEmpty$1(Continuation<? super HomeViewModel$favoriteListIsEmpty$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Boolean bool, List<? extends HomeItem> list, Continuation<? super Boolean> continuation) {
        HomeViewModel$favoriteListIsEmpty$1 homeViewModel$favoriteListIsEmpty$1 = new HomeViewModel$favoriteListIsEmpty$1(continuation);
        homeViewModel$favoriteListIsEmpty$1.L$0 = list;
        return homeViewModel$favoriteListIsEmpty$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        if (list != null) {
            return Boxing.boxBoolean(list.isEmpty());
        }
        return null;
    }
}
