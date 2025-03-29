package ru.tattelecom.feature.call_history;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryBanner;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$navigateToConnectServices$1", f = "EventHistoryViewModel.kt", i = {}, l = {241, 244}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryViewModel$navigateToConnectServices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HistoryBanner $item;
    int label;
    final /* synthetic */ EventHistoryViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryViewModel$navigateToConnectServices$1(HistoryBanner historyBanner, EventHistoryViewModel eventHistoryViewModel, Continuation<? super EventHistoryViewModel$navigateToConnectServices$1> continuation) {
        super(2, continuation);
        this.$item = historyBanner;
        this.this$0 = eventHistoryViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryViewModel$navigateToConnectServices$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryViewModel$navigateToConnectServices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Channel channel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int bannerType = this.$item.getBannerType();
            if (bannerType == 4) {
                this.this$0.reportEvent(59);
                channel = this.this$0._eventNavigateToConnectService;
                this.label = 1;
                if (channel.send(Boxing.boxInt(61), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (bannerType == 5) {
                channel2 = this.this$0._eventNavigateToConnectService;
                this.label = 2;
                if (channel2.send(Boxing.boxInt(61), this) == coroutine_suspended) {
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
