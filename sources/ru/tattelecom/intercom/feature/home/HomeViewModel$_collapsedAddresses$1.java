package ru.tattelecom.intercom.feature.home;

import androidx.lifecycle.ViewModelKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Lru/tattelecom/intercom/feature/home/HomeItem;", EntitiesKt.ADDRESSES_TABLE, "collapsedAddressIds", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$_collapsedAddresses$1", f = "HomeViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$_collapsedAddresses$1 extends SuspendLambda implements Function3<List<? extends HomeItem>, List<? extends Integer>, Continuation<? super List<? extends HomeItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$_collapsedAddresses$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$_collapsedAddresses$1> continuation) {
        super(3, continuation);
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends HomeItem> list, List<? extends Integer> list2, Continuation<? super List<? extends HomeItem>> continuation) {
        return invoke2(list, (List<Integer>) list2, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<? extends HomeItem> list, List<Integer> list2, Continuation<? super List<? extends HomeItem>> continuation) {
        HomeViewModel$_collapsedAddresses$1 homeViewModel$_collapsedAddresses$1 = new HomeViewModel$_collapsedAddresses$1(this.this$0, continuation);
        homeViewModel$_collapsedAddresses$1.L$0 = list;
        homeViewModel$_collapsedAddresses$1.L$1 = list2;
        return homeViewModel$_collapsedAddresses$1.invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lru/tattelecom/intercom/feature/home/HomeItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$_collapsedAddresses$1$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeViewModel$_collapsedAddresses$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends HomeItem>>, Object> {
        final /* synthetic */ List<HomeItem> $addresses;
        final /* synthetic */ List<Integer> $collapsedAddressIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(List<? extends HomeItem> list, List<Integer> list2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$addresses = list;
            this.$collapsedAddressIds = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$addresses, this.$collapsedAddressIds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends HomeItem>> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            List mutableList;
            HomeStream copy;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<HomeItem> list = this.$addresses;
            if (list == null || (mutableList = CollectionsKt.toMutableList((Collection) list)) == null) {
                return null;
            }
            Iterator<T> it = this.$collapsedAddressIds.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                Iterator it2 = mutableList.iterator();
                int i = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        i = -1;
                        break;
                    }
                    HomeItem homeItem = (HomeItem) it2.next();
                    if ((homeItem instanceof HomeAddress) && ((HomeAddress) homeItem).getId() == intValue) {
                        break;
                    }
                    i++;
                }
                int size = mutableList.size();
                while (i < size) {
                    if (i >= 0) {
                        if (mutableList.get(i) instanceof HomeStream) {
                            Object obj2 = mutableList.get(i);
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeStream");
                            copy = r8.copy((r41 & 1) != 0 ? r8.isIntercom : false, (r41 & 2) != 0 ? r8.id : 0, (r41 & 4) != 0 ? r8.url : null, (r41 & 8) != 0 ? r8.preview : null, (r41 & 16) != 0 ? r8.name : null, (r41 & 32) != 0 ? r8.address : null, (r41 & 64) != 0 ? r8.gateId : null, (r41 & 128) != 0 ? r8.gateName : null, (r41 & 256) != 0 ? r8.gateTypeId : null, (r41 & 512) != 0 ? r8.login : null, (r41 & 1024) != 0 ? r8.callsMuted : false, (r41 & 2048) != 0 ? r8.archive : null, (r41 & 4096) != 0 ? r8.archiveExport : null, (r41 & 8192) != 0 ? r8.isFlussonic : false, (r41 & 16384) != 0 ? r8.archiveDaysAvailable : 0, (r41 & 32768) != 0 ? r8.temporaryCode : null, (r41 & 65536) != 0 ? r8.isOpenDoorLoading : false, (r41 & 131072) != 0 ? r8.isTemporaryCodeLoading : false, (r41 & 262144) != 0 ? r8.buildingId : 0, (r41 & 524288) != 0 ? r8.isCollapsed : true, (r41 & 1048576) != 0 ? r8.isFavorite : false, (r41 & 2097152) != 0 ? r8.openDoorIsEnable : false, (r41 & 4194304) != 0 ? ((HomeStream) obj2).isExit : false);
                            mutableList.set(i, copy);
                        } else if (mutableList.get(i) instanceof HomeAddress) {
                            Object obj3 = mutableList.get(i);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeAddress");
                            if (((HomeAddress) obj3).getId() == intValue) {
                                Object obj4 = mutableList.get(i);
                                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeAddress");
                                HomeAddress homeAddress = (HomeAddress) obj4;
                                Intrinsics.checkNotNull(mutableList.get(i), "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeAddress");
                                mutableList.set(i, HomeAddress.copy$default(homeAddress, 0, null, !((HomeAddress) r6).isCollapsed(), 3, null));
                            }
                        }
                    }
                    i++;
                }
            }
            return CollectionsKt.toList(mutableList);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            List list2 = (List) this.L$1;
            this.L$0 = null;
            this.label = 1;
            obj = BuildersKt.withContext(ViewModelKt.getViewModelScope(this.this$0).getCoroutineContext(), new AnonymousClass1(list, list2, null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
