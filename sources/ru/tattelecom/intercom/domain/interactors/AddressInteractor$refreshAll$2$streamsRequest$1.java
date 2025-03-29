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
import ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse;
import ru.tattelecom.intercom.data.remote.source.StreamRemote;

/* compiled from: AddressInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/remote/model/AvailableStreamsResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AddressInteractor$refreshAll$2$streamsRequest$1", f = "AddressInteractor.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class AddressInteractor$refreshAll$2$streamsRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AvailableStreamsResponse>, Object> {
    int label;
    final /* synthetic */ AddressInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddressInteractor$refreshAll$2$streamsRequest$1(AddressInteractor addressInteractor, Continuation<? super AddressInteractor$refreshAll$2$streamsRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = addressInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddressInteractor$refreshAll$2$streamsRequest$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AvailableStreamsResponse> continuation) {
        return ((AddressInteractor$refreshAll$2$streamsRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StreamRemote streamRemote;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            streamRemote = this.this$0.streamRemote;
            this.label = 1;
            obj = streamRemote.getAll(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
