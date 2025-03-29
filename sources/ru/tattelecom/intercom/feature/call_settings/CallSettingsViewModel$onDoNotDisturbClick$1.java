package ru.tattelecom.intercom.feature.call_settings;

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
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;

/* compiled from: CallSettingsViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_settings.CallSettingsViewModel$onDoNotDisturbClick$1", f = "CallSettingsViewModel.kt", i = {}, l = {38, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallSettingsViewModel$onDoNotDisturbClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isEnabled;
    int label;
    final /* synthetic */ CallSettingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallSettingsViewModel$onDoNotDisturbClick$1(CallSettingsViewModel callSettingsViewModel, boolean z, Continuation<? super CallSettingsViewModel$onDoNotDisturbClick$1> continuation) {
        super(2, continuation);
        this.this$0 = callSettingsViewModel;
        this.$isEnabled = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallSettingsViewModel$onDoNotDisturbClick$1(this.this$0, this.$isEnabled, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallSettingsViewModel$onDoNotDisturbClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Channel channel;
        MutableStateFlow mutableStateFlow2;
        IntercomInteractor intercomInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                channel = this.this$0._eventShowMessage;
                this.label = 2;
                if (channel.send(e.getMessage(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._isLoading;
                mutableStateFlow2.setValue(Boxing.boxBoolean(true));
                intercomInteractor = this.this$0.intercomInteractor;
                this.label = 1;
                if (intercomInteractor.setDoNotDisturb(!this.$isEnabled, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } finally {
            mutableStateFlow = this.this$0._isLoading;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
        }
    }
}
