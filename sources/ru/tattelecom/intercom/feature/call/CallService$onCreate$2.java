package ru.tattelecom.intercom.feature.call;

import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.call.CallState;

/* compiled from: CallService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call.CallService$onCreate$2", f = "CallService.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallService$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallService$onCreate$2(CallService callService, Continuation<? super CallService$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = callService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallService$onCreate$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallService$onCreate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow<CallState> callState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SipManager sipManager = this.this$0.getSipManager();
            if (sipManager == null || (callState = sipManager.getCallState()) == null) {
                return Unit.INSTANCE;
            }
            final CallService callService = this.this$0;
            this.label = 1;
            if (callState.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.call.CallService$onCreate$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((CallState) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(CallState callState2, Continuation<? super Unit> continuation) {
                    UserInteractor userInteractor;
                    UserInteractor userInteractor2;
                    if (!Intrinsics.areEqual(callState2, CallState.NoCall.INSTANCE)) {
                        if (Intrinsics.areEqual(callState2, CallState.Incoming.INSTANCE)) {
                            CallService.this.startRinging();
                        } else if (Intrinsics.areEqual(callState2, CallState.Accepted.INSTANCE)) {
                            CallService.this.stopRinging();
                        } else if (Intrinsics.areEqual(callState2, CallState.Ended.INSTANCE)) {
                            CallService.this.stopRinging();
                            userInteractor2 = CallService.this.getUserInteractor();
                            if (!userInteractor2.isWorkInBackgroundEnabled().getValue().booleanValue()) {
                                CallService.this.stopSelf();
                            }
                        } else if (Intrinsics.areEqual(callState2, CallState.Released.INSTANCE)) {
                            CallService.this.stopRinging();
                            userInteractor = CallService.this.getUserInteractor();
                            if (!userInteractor.isWorkInBackgroundEnabled().getValue().booleanValue()) {
                                CallService.this.stopSelf();
                            }
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
        throw new KotlinNothingValueException();
    }
}
