package ru.tattelecom.intercom.feature.office_map.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.feature.office_map.MapHelper;

/* compiled from: HuaweiMapFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$provideUiChanges$1$2", f = "HuaweiMapFragment.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class HuaweiMapFragment$provideUiChanges$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MapViewModel $this_with;
    int label;
    final /* synthetic */ HuaweiMapFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HuaweiMapFragment$provideUiChanges$1$2(MapViewModel mapViewModel, HuaweiMapFragment huaweiMapFragment, Continuation<? super HuaweiMapFragment$provideUiChanges$1$2> continuation) {
        super(2, continuation);
        this.$this_with = mapViewModel;
        this.this$0 = huaweiMapFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HuaweiMapFragment$provideUiChanges$1$2(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HuaweiMapFragment$provideUiChanges$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<List<OfficeService>> servicesList = this.$this_with.getServicesList();
            final HuaweiMapFragment huaweiMapFragment = this.this$0;
            this.label = 1;
            if (servicesList.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$provideUiChanges$1$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<OfficeService>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<OfficeService> list, Continuation<? super Unit> continuation) {
                    OfficeServiceAdapter officeServiceAdapter;
                    OfficeServiceAdapter officeServiceAdapter2;
                    T t;
                    if (list != null) {
                        HuaweiMapFragment huaweiMapFragment2 = HuaweiMapFragment.this;
                        officeServiceAdapter = huaweiMapFragment2.officeServiceAdapter;
                        if (officeServiceAdapter != null) {
                            ArrayList arrayList = new ArrayList();
                            for (String str : MapHelper.INSTANCE.getMainFilterNamesList()) {
                                Iterator<T> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        t = (T) null;
                                        break;
                                    }
                                    t = it.next();
                                    if (Intrinsics.areEqual(((OfficeService) t).getName(), str)) {
                                        break;
                                    }
                                }
                                OfficeService officeService = t;
                                if (officeService != null) {
                                    arrayList.add(officeService);
                                }
                            }
                            officeServiceAdapter2 = huaweiMapFragment2.officeServiceAdapter;
                            if (officeServiceAdapter2 != null) {
                                officeServiceAdapter2.submitList(arrayList);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
