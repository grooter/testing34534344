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
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.source.AuthRemote;

/* compiled from: AuthInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AuthInteractor$auth$2", f = "AuthInteractor.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class AuthInteractor$auth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StatusResponse>, Object> {
    final /* synthetic */ String $deviceCode;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ AuthInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthInteractor$auth$2(String str, AuthInteractor authInteractor, String str2, Continuation<? super AuthInteractor$auth$2> continuation) {
        super(2, continuation);
        this.$phone = str;
        this.this$0 = authInteractor;
        this.$deviceCode = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AuthInteractor$auth$2(this.$phone, this.this$0, this.$deviceCode, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StatusResponse> continuation) {
        return ((AuthInteractor$auth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AuthRemote authRemote;
        UserPrefsSource userPrefsSource;
        UserPrefsSource userPrefsSource2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$phone;
            if (str != null) {
                userPrefsSource2 = this.this$0.prefs;
                userPrefsSource2.setPhoneNumber(str);
            }
            authRemote = this.this$0.remote;
            userPrefsSource = this.this$0.prefs;
            this.label = 1;
            obj = authRemote.auth(userPrefsSource.getPhoneNumber(), this.$deviceCode, this);
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
