package ru.tattelecom.intercom.feature.familyaccess.addaddress.registration;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RegistrationViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationViewModel$onRegisterClick$1", f = "RegistrationViewModel.kt", i = {1}, l = {38, 43, 49, 52}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class RegistrationViewModel$onRegisterClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ RegistrationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RegistrationViewModel$onRegisterClick$1(RegistrationViewModel registrationViewModel, Continuation<? super RegistrationViewModel$onRegisterClick$1> continuation) {
        super(2, continuation);
        this.this$0 = registrationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RegistrationViewModel$onRegisterClick$1 registrationViewModel$onRegisterClick$1 = new RegistrationViewModel$onRegisterClick$1(this.this$0, continuation);
        registrationViewModel$onRegisterClick$1.L$0 = obj;
        return registrationViewModel$onRegisterClick$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RegistrationViewModel$onRegisterClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ae A[RETURN] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationViewModel$onRegisterClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
