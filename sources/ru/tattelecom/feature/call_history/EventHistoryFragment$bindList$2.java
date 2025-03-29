package ru.tattelecom.feature.call_history;

import android.widget.ProgressBar;
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

/* compiled from: EventHistoryFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$2", f = "EventHistoryFragment.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryFragment$bindList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Boolean> $notLoading;
    int label;
    final /* synthetic */ EventHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryFragment$bindList$2(Flow<Boolean> flow, EventHistoryFragment eventHistoryFragment, Continuation<? super EventHistoryFragment$bindList$2> continuation) {
        super(2, continuation);
        this.$notLoading = flow;
        this.this$0 = eventHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryFragment$bindList$2(this.$notLoading, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryFragment$bindList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<Boolean> flow = this.$notLoading;
            final EventHistoryFragment eventHistoryFragment = this.this$0;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    FragmentEventLogBinding binding;
                    FragmentEventLogBinding binding2;
                    if (z) {
                        binding = EventHistoryFragment.this.getBinding();
                        ProgressBar progress = binding.progress;
                        Intrinsics.checkNotNullExpressionValue(progress, "progress");
                        progress.setVisibility(8);
                        binding2 = EventHistoryFragment.this.getBinding();
                        binding2.swipeRefreshLog.setRefreshing(false);
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
        return Unit.INSTANCE;
    }
}
