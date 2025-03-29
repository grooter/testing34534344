package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.data.remote.source.paging.EventHistory;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$onEventSelected$1", f = "EventHistoryViewModel.kt", i = {}, l = {158, 163}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryViewModel$onEventSelected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoryItem $item;
    int label;
    final /* synthetic */ EventHistoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryViewModel$onEventSelected$1(HistoryItem historyItem, EventHistoryViewModel eventHistoryViewModel, Continuation<? super EventHistoryViewModel$onEventSelected$1> continuation) {
        super(2, continuation);
        this.$item = historyItem;
        this.this$0 = eventHistoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryViewModel$onEventSelected$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryViewModel$onEventSelected$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Channel channel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HistoryItem historyItem = this.$item;
            if ((historyItem instanceof EventHistory) && ((EventHistory) historyItem).getStreamIsAvailable()) {
                int type = this.$item.getType();
                if (type == 3) {
                    this.this$0.reportEvent(19);
                } else if (type == 4) {
                    this.this$0.reportEvent(57);
                } else if (type == 5) {
                    this.this$0.reportEvent(89);
                }
                channel2 = this.this$0._eventOpenVideo;
                String streamUrl = ((EventHistory) this.$item).getStreamUrl();
                Intrinsics.checkNotNull(streamUrl);
                this.label = 1;
                if (channel2.send(new Triple(streamUrl, Boxing.boxLong(this.$item.getTime()), Boxing.boxInt(this.$item.getType())), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (this.$item.getType() == 4) {
                    this.this$0.reportEvent(62);
                }
                channel = this.this$0._eventShowSnack;
                this.label = 2;
                if (channel.send(EventHistoryViewModelKt.VIEW_SNACKBAR, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
