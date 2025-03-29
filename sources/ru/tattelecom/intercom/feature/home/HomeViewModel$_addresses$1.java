package ru.tattelecom.intercom.feature.home;

import java.util.ArrayList;
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
import kotlin.jvm.functions.Function5;
import ru.tattelecom.intercom.data.local.entity.LockGateEntity;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Lru/tattelecom/intercom/feature/home/HomeItem;", "address", "status", "Lru/tattelecom/intercom/data/local/entity/LockGateEntity;", "isLoadingId", "", "isTempCodeLoadingId"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$_addresses$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$_addresses$1 extends SuspendLambda implements Function5<List<? extends HomeItem>, List<? extends LockGateEntity>, List<? extends Integer>, List<? extends Integer>, Continuation<? super List<? extends HomeItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$_addresses$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$_addresses$1> continuation) {
        super(5, continuation);
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(List<? extends HomeItem> list, List<? extends LockGateEntity> list2, List<? extends Integer> list3, List<? extends Integer> list4, Continuation<? super List<? extends HomeItem>> continuation) {
        return invoke2(list, (List<LockGateEntity>) list2, (List<Integer>) list3, (List<Integer>) list4, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<? extends HomeItem> list, List<LockGateEntity> list2, List<Integer> list3, List<Integer> list4, Continuation<? super List<? extends HomeItem>> continuation) {
        HomeViewModel$_addresses$1 homeViewModel$_addresses$1 = new HomeViewModel$_addresses$1(this.this$0, continuation);
        homeViewModel$_addresses$1.L$0 = list;
        homeViewModel$_addresses$1.L$1 = list2;
        homeViewModel$_addresses$1.L$2 = list3;
        homeViewModel$_addresses$1.L$3 = list4;
        return homeViewModel$_addresses$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        boolean z;
        Object obj3;
        Object obj4;
        HomeStream copy;
        LockGateInteractor lockGateInteractor;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        List list2 = (List) this.L$1;
        List list3 = (List) this.L$2;
        List list4 = (List) this.L$3;
        if (list == null) {
            return null;
        }
        List<HomeItem> list5 = list;
        HomeViewModel homeViewModel = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
        for (HomeStream homeStream : list5) {
            if (homeStream instanceof HomeStream) {
                HomeStream homeStream2 = (HomeStream) homeStream;
                if (homeStream2.getGateId() != null) {
                    Iterator it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        int gateId = ((LockGateEntity) obj2).getGateId();
                        Integer gateId2 = homeStream2.getGateId();
                        if (gateId2 != null && gateId == gateId2.intValue()) {
                            break;
                        }
                    }
                    LockGateEntity lockGateEntity = (LockGateEntity) obj2;
                    if (lockGateEntity != null) {
                        lockGateInteractor = homeViewModel.lockGateInteractor;
                        z = lockGateInteractor.checkDateLock(lockGateEntity.getDate());
                    } else {
                        z = true;
                    }
                    Iterator it2 = list3.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj3 = null;
                            break;
                        }
                        obj3 = it2.next();
                        int intValue = ((Number) obj3).intValue();
                        Integer gateId3 = homeStream2.getGateId();
                        if (gateId3 != null && intValue == gateId3.intValue()) {
                            break;
                        }
                    }
                    boolean z2 = obj3 != null;
                    Iterator it3 = list4.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj4 = null;
                            break;
                        }
                        obj4 = it3.next();
                        int intValue2 = ((Number) obj4).intValue();
                        Integer gateId4 = homeStream2.getGateId();
                        if (gateId4 != null && intValue2 == gateId4.intValue()) {
                            break;
                        }
                    }
                    copy = homeStream2.copy((r41 & 1) != 0 ? homeStream2.isIntercom : false, (r41 & 2) != 0 ? homeStream2.id : 0, (r41 & 4) != 0 ? homeStream2.url : null, (r41 & 8) != 0 ? homeStream2.preview : null, (r41 & 16) != 0 ? homeStream2.name : null, (r41 & 32) != 0 ? homeStream2.address : null, (r41 & 64) != 0 ? homeStream2.gateId : null, (r41 & 128) != 0 ? homeStream2.gateName : null, (r41 & 256) != 0 ? homeStream2.gateTypeId : null, (r41 & 512) != 0 ? homeStream2.login : null, (r41 & 1024) != 0 ? homeStream2.callsMuted : false, (r41 & 2048) != 0 ? homeStream2.archive : null, (r41 & 4096) != 0 ? homeStream2.archiveExport : null, (r41 & 8192) != 0 ? homeStream2.isFlussonic : false, (r41 & 16384) != 0 ? homeStream2.archiveDaysAvailable : 0, (r41 & 32768) != 0 ? homeStream2.temporaryCode : null, (r41 & 65536) != 0 ? homeStream2.isOpenDoorLoading : z2, (r41 & 131072) != 0 ? homeStream2.isTemporaryCodeLoading : obj4 != null, (r41 & 262144) != 0 ? homeStream2.buildingId : 0, (r41 & 524288) != 0 ? homeStream2.isCollapsed : false, (r41 & 1048576) != 0 ? homeStream2.isFavorite : false, (r41 & 2097152) != 0 ? homeStream2.openDoorIsEnable : z, (r41 & 4194304) != 0 ? homeStream2.isExit : false);
                    homeStream = copy;
                }
            }
            arrayList.add(homeStream);
        }
        return arrayList;
    }
}
