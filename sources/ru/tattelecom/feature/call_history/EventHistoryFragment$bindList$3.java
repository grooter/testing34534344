package ru.tattelecom.feature.call_history;

import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
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
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$3", f = "EventHistoryFragment.kt", i = {}, l = {478}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryFragment$bindList$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<CombinedLoadStates> $loading;
    final /* synthetic */ FragmentEventLogBinding $this_bindList;
    int label;
    final /* synthetic */ EventHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryFragment$bindList$3(Flow<CombinedLoadStates> flow, EventHistoryFragment eventHistoryFragment, FragmentEventLogBinding fragmentEventLogBinding, Continuation<? super EventHistoryFragment$bindList$3> continuation) {
        super(2, continuation);
        this.$loading = flow;
        this.this$0 = eventHistoryFragment;
        this.$this_bindList = fragmentEventLogBinding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryFragment$bindList$3(this.$loading, this.this$0, this.$this_bindList, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryFragment$bindList$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<CombinedLoadStates> flow = this.$loading;
            final EventHistoryFragment eventHistoryFragment = this.this$0;
            final FragmentEventLogBinding fragmentEventLogBinding = this.$this_bindList;
            this.label = 1;
            if (flow.collect(new FlowCollector() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$3.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((CombinedLoadStates) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(CombinedLoadStates combinedLoadStates, Continuation<? super Unit> continuation) {
                    ItemTouchHelper itemTouchHelper;
                    RecyclerView.ItemDecoration itemDecoration;
                    ItemTouchHelper itemTouchHelper2;
                    RecyclerView.ItemDecoration itemDecoration2;
                    if (Intrinsics.areEqual(combinedLoadStates.getSource().getRefresh(), LoadState.Loading.INSTANCE)) {
                        itemTouchHelper2 = EventHistoryFragment.this.itemTouchHelper;
                        if (itemTouchHelper2 != null) {
                            itemTouchHelper2.attachToRecyclerView(null);
                        }
                        itemDecoration2 = EventHistoryFragment.this.itemDecoration;
                        if (itemDecoration2 != null) {
                            fragmentEventLogBinding.rvEventLog.removeItemDecoration(itemDecoration2);
                        }
                    } else {
                        itemTouchHelper = EventHistoryFragment.this.itemTouchHelper;
                        if (itemTouchHelper != null) {
                            itemTouchHelper.attachToRecyclerView(fragmentEventLogBinding.rvEventLog);
                        }
                        itemDecoration = EventHistoryFragment.this.itemDecoration;
                        if (itemDecoration != null) {
                            fragmentEventLogBinding.rvEventLog.addItemDecoration(itemDecoration);
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
        return Unit.INSTANCE;
    }
}
