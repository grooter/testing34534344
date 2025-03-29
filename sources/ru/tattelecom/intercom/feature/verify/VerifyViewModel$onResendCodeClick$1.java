package ru.tattelecom.intercom.feature.verify;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.feature.verify.VerifyViewModel;

/* compiled from: VerifyViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.verify.VerifyViewModel$onResendCodeClick$1", f = "VerifyViewModel.kt", i = {}, l = {122, 127, 128}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VerifyViewModel$onResendCodeClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceCode;
    int label;
    final /* synthetic */ VerifyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VerifyViewModel$onResendCodeClick$1(VerifyViewModel verifyViewModel, String str, Continuation<? super VerifyViewModel$onResendCodeClick$1> continuation) {
        super(2, continuation);
        this.this$0 = verifyViewModel;
        this.$deviceCode = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VerifyViewModel$onResendCodeClick$1(this.this$0, this.$deviceCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VerifyViewModel$onResendCodeClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Channel channel2;
        String substringBefore$default;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        AuthInteractor authInteractor;
        VerifyViewModel$timer$1 verifyViewModel$timer$1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            String message = e.getMessage();
            Integer num = null;
            if (message != null && (substringBefore$default = StringsKt.substringBefore$default(message, ":", (String) null, 2, (Object) null)) != null) {
                num = StringsKt.toIntOrNull(substringBefore$default);
            }
            if (num != null && num.intValue() == 429) {
                channel2 = this.this$0._events;
                this.label = 2;
                if (channel2.send(new VerifyViewModel.Event.ShowMessage("too_many_requests"), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                channel = this.this$0._events;
                this.label = 3;
                if (channel.send(new VerifyViewModel.Event.ShowMessage("something_went_wrong"), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData2 = this.this$0.isResendCodeButtonLoading;
            mutableLiveData2.setValue(Boxing.boxBoolean(true));
            authInteractor = this.this$0.authInteractor;
            this.label = 1;
            if (AuthInteractor.auth$default(authInteractor, null, this.$deviceCode, this, 1, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableLiveData = this.this$0.isResendCodeButtonLoading;
                mutableLiveData.setValue(Boxing.boxBoolean(false));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        verifyViewModel$timer$1 = this.this$0.timer;
        verifyViewModel$timer$1.start();
        mutableLiveData = this.this$0.isResendCodeButtonLoading;
        mutableLiveData.setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
