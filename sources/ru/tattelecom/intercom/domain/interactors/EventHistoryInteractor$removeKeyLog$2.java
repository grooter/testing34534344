package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.source.EventHistoryRemote;

/* compiled from: EventHistoryInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor$removeKeyLog$2", f = "EventHistoryInteractor.kt", i = {}, l = {38, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryInteractor$removeKeyLog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StatusResponse>, Object> {
    final /* synthetic */ boolean $fromEveryone;
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ EventHistoryInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryInteractor$removeKeyLog$2(boolean z, EventHistoryInteractor eventHistoryInteractor, String str, Continuation<? super EventHistoryInteractor$removeKeyLog$2> continuation) {
        super(2, continuation);
        this.$fromEveryone = z;
        this.this$0 = eventHistoryInteractor;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryInteractor$removeKeyLog$2(this.$fromEveryone, this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StatusResponse> continuation) {
        return ((EventHistoryInteractor$removeKeyLog$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EventHistoryRemote eventHistoryRemote;
        EventHistoryRemote eventHistoryRemote2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return (StatusResponse) obj;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (StatusResponse) obj;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$fromEveryone) {
            eventHistoryRemote2 = this.this$0.remote;
            this.label = 1;
            obj = eventHistoryRemote2.removeKeyLogFromEveryone(this.$id, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (StatusResponse) obj;
        }
        eventHistoryRemote = this.this$0.remote;
        this.label = 2;
        obj = eventHistoryRemote.removeKeyLogFromUser(this.$id, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (StatusResponse) obj;
    }
}
