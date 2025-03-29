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
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.prefs.RemoteConfigPrefsSource;
import ru.tattelecom.intercom.data.prefs.SupportPrefsSource;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: SignOutInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.SignOutInteractor$signOut$2", f = "SignOutInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SignOutInteractor$signOut$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SignOutInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SignOutInteractor$signOut$2(SignOutInteractor signOutInteractor, Continuation<? super SignOutInteractor$signOut$2> continuation) {
        super(2, continuation);
        this.this$0 = signOutInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignOutInteractor$signOut$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignOutInteractor$signOut$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomDatabase intercomDatabase;
        UserPrefsSource userPrefsSource;
        RemoteConfigPrefsSource remoteConfigPrefsSource;
        SupportPrefsSource supportPrefsSource;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            intercomDatabase = this.this$0.database;
            intercomDatabase.clearAllTables();
            userPrefsSource = this.this$0.prefs;
            userPrefsSource.clear();
            remoteConfigPrefsSource = this.this$0.configPrefsSource;
            remoteConfigPrefsSource.clear();
            supportPrefsSource = this.this$0.supportPrefsSource;
            supportPrefsSource.clear();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
