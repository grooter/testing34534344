package ru.tattelecom.intercom.feature.call;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;

/* compiled from: CallService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call.CallService$login$1", f = "CallService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallService$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    final /* synthetic */ String $networkType;
    int label;
    final /* synthetic */ CallService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallService$login$1(CallService callService, Intent intent, String str, Continuation<? super CallService$login$1> continuation) {
        super(2, continuation);
        this.this$0 = callService;
        this.$intent = intent;
        this.$networkType = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallService$login$1(this.this$0, this.$intent, this.$networkType, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallService$login$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomInteractor intercomInteractor;
        IntercomInteractor intercomInteractor2;
        IntercomInteractor intercomInteractor3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                intercomInteractor = this.this$0.getIntercomInteractor();
                String sipSettingsLogin = intercomInteractor.sipSettingsLogin();
                if (sipSettingsLogin != null) {
                    CallService callService = this.this$0;
                    Intent intent = this.$intent;
                    String str = this.$networkType;
                    SipManager sipManager = callService.getSipManager();
                    if (sipManager != null) {
                        intercomInteractor2 = callService.getIntercomInteractor();
                        String sipSettingsPassword = intercomInteractor2.sipSettingsPassword();
                        intercomInteractor3 = callService.getIntercomInteractor();
                        sipManager.login(sipSettingsLogin, sipSettingsPassword, intercomInteractor3.sipSettingsRegExpire(), intent.getStringExtra("uuid"), intent.getStringExtra(NavArg.SIP_ADDRESS), intent.getStringExtra(NavArg.SIP_PORT), intent.getStringExtra(NavArg.SIP_TRANSPORT), intent.getStringExtra("callId"), intent.getStringExtra(NavArg.DEVICE_ID), str);
                    }
                    SipManager sipManager2 = callService.getSipManager();
                    if (sipManager2 != null) {
                        sipManager2.startTimer();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
