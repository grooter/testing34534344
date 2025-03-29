package ru.tattelecom.feature.call_history;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.feature.call_history.databinding.FragmentEventLogBinding;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;

/* compiled from: EventHistoryFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$provideUiChanges$5", f = "EventHistoryFragment.kt", i = {}, l = {300}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryFragment$provideUiChanges$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EventHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryFragment$provideUiChanges$5(EventHistoryFragment eventHistoryFragment, Continuation<? super EventHistoryFragment$provideUiChanges$5> continuation) {
        super(2, continuation);
        this.this$0 = eventHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryFragment$provideUiChanges$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryFragment$provideUiChanges$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EventHistoryViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            Flow<String> eventShowMessage = viewModel.getEventShowMessage();
            final EventHistoryFragment eventHistoryFragment = this.this$0;
            this.label = 1;
            if (eventShowMessage.collect(new FlowCollector() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$provideUiChanges$5.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    FragmentEventLogBinding binding;
                    binding = EventHistoryFragment.this.getBinding();
                    ConstraintLayout constraintLayout = binding.clRoot;
                    Context requireContext = EventHistoryFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    Snackbar.make(constraintLayout, StringResourceFinderKt.getMessageText(str, requireContext), -1).show();
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
        return Unit.INSTANCE;
    }
}
