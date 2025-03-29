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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lru/tattelecom/feature/call_history/UiAction$SwitchLoadType;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$searches$1", f = "EventHistoryViewModel.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryViewModel$searches$1 extends SuspendLambda implements Function2<FlowCollector<? super UiAction.SwitchLoadType>, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataLoadType $lastQueryScrolled;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EventHistoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryViewModel$searches$1(DataLoadType dataLoadType, EventHistoryViewModel eventHistoryViewModel, Continuation<? super EventHistoryViewModel$searches$1> continuation) {
        super(2, continuation);
        this.$lastQueryScrolled = dataLoadType;
        this.this$0 = eventHistoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EventHistoryViewModel$searches$1 eventHistoryViewModel$searches$1 = new EventHistoryViewModel$searches$1(this.$lastQueryScrolled, this.this$0, continuation);
        eventHistoryViewModel$searches$1.L$0 = obj;
        return eventHistoryViewModel$searches$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super UiAction.SwitchLoadType> flowCollector, Continuation<? super Unit> continuation) {
        return ((EventHistoryViewModel$searches$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(new UiAction.SwitchLoadType(this.$lastQueryScrolled, this.this$0.getIsBannerClosed()), this) == coroutine_suspended) {
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
