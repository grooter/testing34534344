package ru.tattelecom.intercom.feature.call_schedule;

import android.widget.ProgressBar;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.feature.call_schedule.databinding.DialogCallScheduleBinding;

/* compiled from: CallScheduleDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$5", f = "CallScheduleDialog.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleDialog$provideUiChanges$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallScheduleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallScheduleDialog$provideUiChanges$5(CallScheduleDialog callScheduleDialog, Continuation<? super CallScheduleDialog$provideUiChanges$5> continuation) {
        super(2, continuation);
        this.this$0 = callScheduleDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallScheduleDialog$provideUiChanges$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallScheduleDialog$provideUiChanges$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CallScheduleViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            StateFlow<Boolean> isLoading = viewModel.isLoading();
            final CallScheduleDialog callScheduleDialog = this.this$0;
            this.label = 1;
            if (isLoading.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$5.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                    DialogCallScheduleBinding binding;
                    binding = CallScheduleDialog.this.getBinding();
                    ProgressBar pbSave = binding.pbSave;
                    Intrinsics.checkNotNullExpressionValue(pbSave, "pbSave");
                    pbSave.setVisibility(z ? 0 : 8);
                    binding.btnSave.setEnabled(!z);
                    binding.btnReset.setEnabled(!z);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
