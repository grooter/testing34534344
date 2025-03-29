package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.feature.call_history.UiAction;
import ru.tattelecom.intercom.data.remote.source.paging.DataLoadType;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lru/tattelecom/feature/call_history/UiAction$Scroll;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$queriesScrolled$1", f = "EventHistoryViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryViewModel$queriesScrolled$1 extends SuspendLambda implements Function2<FlowCollector<? super UiAction.Scroll>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataLoadType $lastQueryScrolled;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryViewModel$queriesScrolled$1(DataLoadType dataLoadType, Continuation<? super EventHistoryViewModel$queriesScrolled$1> continuation) {
        super(2, continuation);
        this.$lastQueryScrolled = dataLoadType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventHistoryViewModel$queriesScrolled$1 eventHistoryViewModel$queriesScrolled$1 = new EventHistoryViewModel$queriesScrolled$1(this.$lastQueryScrolled, continuation);
        eventHistoryViewModel$queriesScrolled$1.L$0 = obj;
        return eventHistoryViewModel$queriesScrolled$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super UiAction.Scroll> flowCollector, Continuation<? super Unit> continuation) {
        return ((EventHistoryViewModel$queriesScrolled$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(new UiAction.Scroll(this.$lastQueryScrolled), this) == coroutine_suspended) {
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
