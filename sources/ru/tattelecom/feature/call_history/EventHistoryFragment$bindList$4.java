package ru.tattelecom.feature.call_history;

import androidx.paging.PagingData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.apache.commons.compress.archivers.tar.TarConstants;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$4", f = "EventHistoryFragment.kt", i = {}, l = {TarConstants.XSTAR_MAGIC_OFFSET}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryFragment$bindList$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<PagingData<HistoryItem>> $pagingData;
    int label;
    final /* synthetic */ EventHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryFragment$bindList$4(Flow<PagingData<HistoryItem>> flow, EventHistoryFragment eventHistoryFragment, Continuation<? super EventHistoryFragment$bindList$4> continuation) {
        super(2, continuation);
        this.$pagingData = flow;
        this.this$0 = eventHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryFragment$bindList$4(this.$pagingData, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryFragment$bindList$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: EventHistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$4$1, reason: invalid class name */
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<PagingData<HistoryItem>, Continuation<? super Unit>, Object>, SuspendFunction {
        AnonymousClass1(Object obj) {
            super(2, obj, EventHistoryAdapter.class, "submitData", "submitData(Landroidx/paging/PagingData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(PagingData<HistoryItem> pagingData, Continuation<? super Unit> continuation) {
            return ((EventHistoryAdapter) this.receiver).submitData(pagingData, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EventHistoryAdapter eventHistoryAdapter;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<PagingData<HistoryItem>> flow = this.$pagingData;
            eventHistoryAdapter = this.this$0.callHistoryAdapter;
            if (eventHistoryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
                eventHistoryAdapter = null;
            }
            this.label = 1;
            if (FlowKt.collectLatest(flow, new AnonymousClass1(eventHistoryAdapter), this) == coroutine_suspended) {
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
