package ru.tattelecom.intercom.feature.login;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.login.LoginViewModel;

/* compiled from: LoginFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.login.LoginFragment$provideUiChanges$1$3", f = "LoginFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LoginFragment$provideUiChanges$1$3 extends SuspendLambda implements Function2<LoginViewModel.Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LoginFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoginFragment$provideUiChanges$1$3(LoginFragment loginFragment, Continuation<? super LoginFragment$provideUiChanges$1$3> continuation) {
        super(2, continuation);
        this.this$0 = loginFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LoginFragment$provideUiChanges$1$3 loginFragment$provideUiChanges$1$3 = new LoginFragment$provideUiChanges$1$3(this.this$0, continuation);
        loginFragment$provideUiChanges$1$3.L$0 = obj;
        return loginFragment$provideUiChanges$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LoginViewModel.Event event, Continuation<? super Unit> continuation) {
        return ((LoginFragment$provideUiChanges$1$3) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.provideEvent((LoginViewModel.Event) this.L$0);
        return Unit.INSTANCE;
    }
}
