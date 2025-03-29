package ru.tattelecom.intercom.feature.home;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.domain.model.TrialDto;
import ru.tattelecom.intercom.feature.home.model.HomeScreenState;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", EntitiesKt.ADDRESSES_TABLE, "", "Lru/tattelecom/intercom/feature/home/HomeItem;", "isError", "", "isBannerVisible", "isLoading", "trialFlow", "Lru/tattelecom/intercom/domain/model/TrialDto;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$screenState$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$screenState$1 extends SuspendLambda implements Function6<List<? extends HomeItem>, Boolean, Boolean, Boolean, TrialDto, Continuation<? super HomeScreenState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$screenState$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$screenState$1> continuation) {
        super(6, continuation);
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(List<? extends HomeItem> list, Boolean bool, Boolean bool2, Boolean bool3, TrialDto trialDto, Continuation<? super HomeScreenState> continuation) {
        return invoke(list, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), trialDto, continuation);
    }

    public final Object invoke(List<? extends HomeItem> list, boolean z, boolean z2, boolean z3, TrialDto trialDto, Continuation<? super HomeScreenState> continuation) {
        HomeViewModel$screenState$1 homeViewModel$screenState$1 = new HomeViewModel$screenState$1(this.this$0, continuation);
        homeViewModel$screenState$1.L$0 = list;
        homeViewModel$screenState$1.Z$0 = z;
        homeViewModel$screenState$1.Z$1 = z2;
        homeViewModel$screenState$1.Z$2 = z3;
        homeViewModel$screenState$1.L$1 = trialDto;
        return homeViewModel$screenState$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserInteractor userInteractor;
        UserInteractor userInteractor2;
        List list;
        UserInteractor userInteractor3;
        UserInteractor userInteractor4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list2 = (List) this.L$0;
        boolean z = this.Z$0;
        boolean z2 = this.Z$1;
        boolean z3 = this.Z$2;
        TrialDto trialDto = (TrialDto) this.L$1;
        if (z && list2 == null) {
            userInteractor4 = this.this$0.userInteractor;
            userInteractor4.setUserState(null);
            return HomeScreenState.Error.INSTANCE;
        }
        if (z3 && ((list = list2) == null || list.isEmpty())) {
            userInteractor3 = this.this$0.userInteractor;
            userInteractor3.setUserState("true");
            return HomeScreenState.FirstOpen.INSTANCE;
        }
        List list3 = list2;
        if (list3 == null || list3.isEmpty()) {
            userInteractor = this.this$0.userInteractor;
            userInteractor.setUserState("true");
            return HomeScreenState.NewUser.INSTANCE;
        }
        userInteractor2 = this.this$0.userInteractor;
        userInteractor2.setUserState("false");
        return new HomeScreenState.OldUser(z2 && !trialDto.isActive(), trialDto);
    }
}
