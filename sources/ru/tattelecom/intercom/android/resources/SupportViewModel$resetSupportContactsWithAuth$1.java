package ru.tattelecom.intercom.android.resources;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.SupportInteractor;

/* compiled from: SupportViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.android.resources.SupportViewModel$resetSupportContactsWithAuth$1", f = "SupportViewModel.kt", i = {}, l = {48, 48}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class SupportViewModel$resetSupportContactsWithAuth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ SupportViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SupportViewModel$resetSupportContactsWithAuth$1(SupportViewModel supportViewModel, Continuation<? super SupportViewModel$resetSupportContactsWithAuth$1> continuation) {
        super(2, continuation);
        this.this$0 = supportViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SupportViewModel$resetSupportContactsWithAuth$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SupportViewModel$resetSupportContactsWithAuth$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableStateFlow mutableStateFlow3;
        SupportInteractor supportInteractor;
        MutableStateFlow mutableStateFlow4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._isLoading;
                mutableStateFlow2.setValue(Boxing.boxBoolean(true));
                mutableStateFlow3 = this.this$0._supportContacts;
                supportInteractor = this.this$0.supportInteractor;
                this.L$0 = mutableStateFlow3;
                this.label = 1;
                obj = supportInteractor.getContactsWithAuth(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow4 = this.this$0._isLoading;
                    mutableStateFlow4.setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                mutableStateFlow3 = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.L$0 = null;
            this.label = 2;
            if (mutableStateFlow3.emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableStateFlow4 = this.this$0._isLoading;
            mutableStateFlow4.setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            mutableStateFlow = this.this$0._isLoading;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
            throw th;
        }
    }
}
