package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.contracts.AdvBottomSheetInteractor;

/* compiled from: HomeBottomSheetViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeBottomSheetViewModel$setAdvRead$1", f = "HomeBottomSheetViewModel.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeBottomSheetViewModel$setAdvRead$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $id;
    int label;
    final /* synthetic */ HomeBottomSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeBottomSheetViewModel$setAdvRead$1(HomeBottomSheetViewModel homeBottomSheetViewModel, long j, Continuation<? super HomeBottomSheetViewModel$setAdvRead$1> continuation) {
        super(2, continuation);
        this.this$0 = homeBottomSheetViewModel;
        this.$id = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeBottomSheetViewModel$setAdvRead$1(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeBottomSheetViewModel$setAdvRead$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AdvBottomSheetInteractor advBottomSheetInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            advBottomSheetInteractor = this.this$0.advInteractor;
            this.label = 1;
            if (advBottomSheetInteractor.setRead(this.$id, this) == coroutine_suspended) {
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
