package ru.tattelecom.intercom.feature.office_map.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.data.remote.model.OfficeResponse;
import ru.tattelecom.intercom.data.remote.model.OfficeServices;
import ru.tattelecom.intercom.domain.interactors.OfficeInteractor;
import ru.tattelecom.intercom.feature.office_map.MapHelper;

/* compiled from: MapViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.MapViewModel$fetchOfficeList$1", f = "MapViewModel.kt", i = {}, l = {43, 66}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class MapViewModel$fetchOfficeList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MapViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapViewModel$fetchOfficeList$1(MapViewModel mapViewModel, Continuation<? super MapViewModel$fetchOfficeList$1> continuation) {
        super(2, continuation);
        this.this$0 = mapViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapViewModel$fetchOfficeList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapViewModel$fetchOfficeList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        OfficeInteractor officeInteractor;
        Object observeOfficeList;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        MutableStateFlow mutableStateFlow4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            channel = this.this$0._eventShowMessage;
            this.label = 2;
            if (channel.send(e.getLocalizedMessage(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            officeInteractor = this.this$0.interactor;
            this.label = 1;
            observeOfficeList = officeInteractor.observeOfficeList(this);
            if (observeOfficeList == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            observeOfficeList = obj;
        }
        List list = (List) observeOfficeList;
        if (list != null) {
            mutableStateFlow = this.this$0._officeList;
            mutableStateFlow.setValue(list);
            mutableStateFlow2 = this.this$0._filteredOfficeList;
            mutableStateFlow3 = this.this$0._officeList;
            mutableStateFlow2.setValue(mutableStateFlow3.getValue());
            Set mutableSetOf = SetsKt.mutableSetOf(new OfficeService(-2, MapHelper.INSTANCE.getMainFilterNamesList().get(0), false, this.this$0.getFilters().size(), 4, null), new OfficeService(-1, MapHelper.INSTANCE.getMainFilterNamesList().get(1), false, 0, 12, null));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                List<OfficeServices> services = ((OfficeResponse) it.next()).getServices();
                if (services != null) {
                    ArrayList<OfficeServices> arrayList = new ArrayList();
                    for (Object obj2 : services) {
                        OfficeServices officeServices = (OfficeServices) obj2;
                        if ((officeServices != null ? officeServices.getId() : null) != null && officeServices.getName() != null) {
                            arrayList.add(obj2);
                        }
                    }
                    for (OfficeServices officeServices2 : arrayList) {
                        Intrinsics.checkNotNull(officeServices2);
                        Integer id = officeServices2.getId();
                        Intrinsics.checkNotNull(id);
                        int intValue = id.intValue();
                        String name = officeServices2.getName();
                        Intrinsics.checkNotNull(name);
                        mutableSetOf.add(new OfficeService(intValue, name, false, 0, 8, null));
                    }
                }
            }
            mutableStateFlow4 = this.this$0._servicesList;
            mutableStateFlow4.setValue(CollectionsKt.toList(mutableSetOf));
        }
        return Unit.INSTANCE;
    }
}
