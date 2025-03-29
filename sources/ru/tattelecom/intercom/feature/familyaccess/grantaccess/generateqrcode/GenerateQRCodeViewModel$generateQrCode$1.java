package ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeViewModel;

/* compiled from: GenerateQRCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeViewModel$generateQrCode$1", f = "GenerateQRCodeViewModel.kt", i = {}, l = {57, 57, 60}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GenerateQRCodeViewModel$generateQrCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GenerateQRCodeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GenerateQRCodeViewModel$generateQrCode$1(GenerateQRCodeViewModel generateQRCodeViewModel, Continuation<? super GenerateQRCodeViewModel$generateQrCode$1> continuation) {
        super(2, continuation);
        this.this$0 = generateQRCodeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GenerateQRCodeViewModel$generateQrCode$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GenerateQRCodeViewModel$generateQrCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        StateFlow stateFlow;
        Channel channel2;
        AuthInteractor authInteractor;
        Channel channel3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            channel = this.this$0._events;
            this.L$0 = null;
            this.label = 3;
            if (channel.send(GenerateQRCodeViewModel.Event.NavigateToErrorPage.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.reportEvent(71);
            stateFlow = this.this$0.selectedApartmentId;
            Integer num = (Integer) stateFlow.getValue();
            if (num != null) {
                GenerateQRCodeViewModel generateQRCodeViewModel = this.this$0;
                int intValue = num.intValue();
                channel2 = generateQRCodeViewModel._events;
                authInteractor = generateQRCodeViewModel.authInteractor;
                this.L$0 = channel2;
                this.label = 1;
                obj = authInteractor.getQrCode(intValue, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channel3 = channel2;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        channel3 = (Channel) this.L$0;
        ResultKt.throwOnFailure(obj);
        GenerateQRCodeViewModel.Event.Navigate navigate = new GenerateQRCodeViewModel.Event.Navigate((String) obj);
        this.L$0 = null;
        this.label = 2;
        if (channel3.send(navigate, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
