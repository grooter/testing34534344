package ru.tattelecom.intercom.feature.home;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$launchCancellableJob$1", f = "HomeViewModel.kt", i = {}, l = {518, 523}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$launchCancellableJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $job;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeViewModel$launchCancellableJob$1(HomeViewModel homeViewModel, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super HomeViewModel$launchCancellableJob$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$job = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$launchCancellableJob$1(this.this$0, this.$job, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$launchCancellableJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (CancellationException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                String message = e2.getMessage();
                if (message != null && !StringsKt.contains$default((CharSequence) message, (CharSequence) "job_canceled", false, 2, (Object) null)) {
                    channel = this.this$0._eventShowMessage;
                    this.label = 2;
                    if (channel.send("something_went_wrong", this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._isInProgress;
                mutableStateFlow2.setValue(Boxing.boxBoolean(true));
                Function1<Continuation<? super Unit>, Object> function1 = this.$job;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        } finally {
            mutableStateFlow = this.this$0._isInProgress;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
        }
    }
}
