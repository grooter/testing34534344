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
import ru.tattelecom.intercom.data.remote.model.QRCodeResponse;
import ru.tattelecom.intercom.data.remote.source.AuthRemote;

/* compiled from: AuthInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AuthInteractor$getQrCode$2", f = "AuthInteractor.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class AuthInteractor$getQrCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $apartmentId;
    int label;
    final /* synthetic */ AuthInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthInteractor$getQrCode$2(AuthInteractor authInteractor, int i, Continuation<? super AuthInteractor$getQrCode$2> continuation) {
        super(2, continuation);
        this.this$0 = authInteractor;
        this.$apartmentId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthInteractor$getQrCode$2(this.this$0, this.$apartmentId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((AuthInteractor$getQrCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AuthRemote authRemote;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            authRemote = this.this$0.remote;
            this.label = 1;
            obj = authRemote.getQRCode(this.$apartmentId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return ((QRCodeResponse) obj).getQrToken();
    }
}
