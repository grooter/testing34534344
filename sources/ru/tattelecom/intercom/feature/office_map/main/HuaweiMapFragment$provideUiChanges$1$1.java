package ru.tattelecom.intercom.feature.office_map.main;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.data.remote.model.OfficeResponse;

/* compiled from: HuaweiMapFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$provideUiChanges$1$1", f = "HuaweiMapFragment.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class HuaweiMapFragment$provideUiChanges$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MapViewModel $this_with;
    int label;
    final /* synthetic */ HuaweiMapFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HuaweiMapFragment$provideUiChanges$1$1(MapViewModel mapViewModel, HuaweiMapFragment huaweiMapFragment, Continuation<? super HuaweiMapFragment$provideUiChanges$1$1> continuation) {
        super(2, continuation);
        this.$this_with = mapViewModel;
        this.this$0 = huaweiMapFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HuaweiMapFragment$provideUiChanges$1$1(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HuaweiMapFragment$provideUiChanges$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StateFlow<List<OfficeResponse>> officeList = this.$this_with.getOfficeList();
            final HuaweiMapFragment huaweiMapFragment = this.this$0;
            this.label = 1;
            if (officeList.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$provideUiChanges$1$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<OfficeResponse>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<OfficeResponse> list, Continuation<? super Unit> continuation) {
                    if (list != null) {
                        HuaweiMapFragment.this.renderOffices(list);
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
