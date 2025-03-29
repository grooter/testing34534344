package ru.tattelecom.intercom.feature.call_schedule;

import androidx.media3.extractor.ts.TsExtractor;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.apache.commons.compress.archivers.tar.TarConstants;

/* compiled from: CallScheduleViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel$launch$1", f = "CallScheduleViewModel.kt", i = {}, l = {TarConstants.PREFIXLEN_XSTAR, 132, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleViewModel$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $function;
    int label;
    final /* synthetic */ CallScheduleViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    CallScheduleViewModel$launch$1(CallScheduleViewModel callScheduleViewModel, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super CallScheduleViewModel$launch$1> continuation) {
        super(2, continuation);
        this.this$0 = callScheduleViewModel;
        this.$function = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallScheduleViewModel$launch$1(this.this$0, this.$function, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallScheduleViewModel$launch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        MutableSharedFlow mutableSharedFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                mutableSharedFlow = this.this$0._eventShowMessage;
                this.label = 3;
                if (mutableSharedFlow.emit(e.getLocalizedMessage(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._isLoading;
                mutableStateFlow2.setValue(Boxing.boxBoolean(true));
                Function1<Continuation<? super Unit>, Object> function1 = this.$function;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            mutableSharedFlow2 = this.this$0._eventCloseDialog;
            this.label = 2;
            if (mutableSharedFlow2.emit(Boxing.boxBoolean(true), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } finally {
            mutableStateFlow = this.this$0._isLoading;
            mutableStateFlow.setValue(Boxing.boxBoolean(false));
        }
    }
}
