package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$onSetCallsMutedClick$1", f = "HomeViewModel.kt", i = {}, l = {504}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$onSetCallsMutedClick$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ int $intercomId;
    final /* synthetic */ boolean $mutedNow;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$onSetCallsMutedClick$1(HomeViewModel homeViewModel, int i, boolean z, Continuation<? super HomeViewModel$onSetCallsMutedClick$1> continuation) {
        super(1, continuation);
        this.this$0 = homeViewModel;
        this.$intercomId = i;
        this.$mutedNow = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HomeViewModel$onSetCallsMutedClick$1(this.this$0, this.$intercomId, this.$mutedNow, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((HomeViewModel$onSetCallsMutedClick$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomInteractor intercomInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intercomInteractor = this.this$0.intercomInteractor;
            this.label = 1;
            if (intercomInteractor.setCalls(this.$intercomId, !this.$mutedNow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
