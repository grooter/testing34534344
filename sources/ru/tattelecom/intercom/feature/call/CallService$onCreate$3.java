package ru.tattelecom.intercom.feature.call;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: CallService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call.CallService$onCreate$3", f = "CallService.kt", i = {}, l = {175}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallService$onCreate$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallService$onCreate$3(CallService callService, Continuation<? super CallService$onCreate$3> continuation) {
        super(2, continuation);
        this.this$0 = callService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallService$onCreate$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallService$onCreate$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow<Boolean> isRegistered;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SipManager sipManager = this.this$0.getSipManager();
            if (sipManager == null || (isRegistered = sipManager.isRegistered()) == null) {
                return Unit.INSTANCE;
            }
            final CallService callService = this.this$0;
            this.label = 1;
            if (isRegistered.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.call.CallService$onCreate$3.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    boolean z2;
                    UserInteractor userInteractor;
                    z2 = CallService.this.isInForeground;
                    if (z2 && ActivityCompat.checkSelfPermission(CallService.this, "android.permission.POST_NOTIFICATIONS") == 0) {
                        NotificationManagerCompat from = NotificationManagerCompat.from(CallService.this);
                        CallService callService2 = CallService.this;
                        CallService callService3 = callService2;
                        userInteractor = callService2.getUserInteractor();
                        from.notify(2, NotificationsKt.getSyncNotification(callService3, userInteractor.isWorkInBackgroundEnabled().getValue().booleanValue(), Boxing.boxBoolean(z)));
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
