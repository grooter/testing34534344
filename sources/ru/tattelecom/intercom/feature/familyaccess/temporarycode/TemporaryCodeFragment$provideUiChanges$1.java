package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import android.widget.TextView;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentTemporaryCodeBinding;

/* compiled from: TemporaryCodeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$provideUiChanges$1", f = "TemporaryCodeFragment.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class TemporaryCodeFragment$provideUiChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TemporaryCodeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TemporaryCodeFragment$provideUiChanges$1(TemporaryCodeFragment temporaryCodeFragment, Continuation<? super TemporaryCodeFragment$provideUiChanges$1> continuation) {
        super(2, continuation);
        this.this$0 = temporaryCodeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemporaryCodeFragment$provideUiChanges$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemporaryCodeFragment$provideUiChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TemporaryCodeViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            MutableStateFlow<List<TemporaryCodeItem>> apartmentsTemporaryCode = viewModel.getApartmentsTemporaryCode();
            final TemporaryCodeFragment temporaryCodeFragment = this.this$0;
            this.label = 1;
            if (apartmentsTemporaryCode.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$provideUiChanges$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<TemporaryCodeItem>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<TemporaryCodeItem> list, Continuation<? super Unit> continuation) {
                    TemporaryCodeAdapter temporaryCodeAdapter;
                    FragmentTemporaryCodeBinding binding;
                    temporaryCodeAdapter = TemporaryCodeFragment.this.temporaryCodeAdapter;
                    if (temporaryCodeAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("temporaryCodeAdapter");
                        temporaryCodeAdapter = null;
                    }
                    temporaryCodeAdapter.submitList(list);
                    binding = TemporaryCodeFragment.this.getBinding();
                    TextView tvEmpty = binding.tvEmpty;
                    Intrinsics.checkNotNullExpressionValue(tvEmpty, "tvEmpty");
                    List<TemporaryCodeItem> list2 = list;
                    tvEmpty.setVisibility(list2 == null || list2.isEmpty() ? 0 : 8);
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
