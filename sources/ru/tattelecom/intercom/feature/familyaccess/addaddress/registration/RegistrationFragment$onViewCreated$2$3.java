package ru.tattelecom.intercom.feature.familyaccess.addaddress.registration;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationViewModel;

/* compiled from: RegistrationFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/familyaccess/addaddress/registration/RegistrationViewModel$Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$onViewCreated$2$3", f = "RegistrationFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class RegistrationFragment$onViewCreated$2$3 extends SuspendLambda implements Function2<RegistrationViewModel.Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RegistrationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RegistrationFragment$onViewCreated$2$3(RegistrationFragment registrationFragment, Continuation<? super RegistrationFragment$onViewCreated$2$3> continuation) {
        super(2, continuation);
        this.this$0 = registrationFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RegistrationFragment$onViewCreated$2$3 registrationFragment$onViewCreated$2$3 = new RegistrationFragment$onViewCreated$2$3(this.this$0, continuation);
        registrationFragment$onViewCreated$2$3.L$0 = obj;
        return registrationFragment$onViewCreated$2$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(RegistrationViewModel.Event event, Continuation<? super Unit> continuation) {
        return ((RegistrationFragment$onViewCreated$2$3) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.this$0.provideEvent((RegistrationViewModel.Event) this.L$0);
        return Unit.INSTANCE;
    }
}
