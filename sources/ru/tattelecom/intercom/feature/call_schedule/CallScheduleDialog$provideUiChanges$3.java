package ru.tattelecom.intercom.feature.call_schedule;

import com.google.android.material.chip.Chip;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.feature.call_schedule.databinding.DialogCallScheduleBinding;

/* compiled from: CallScheduleDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$3", f = "CallScheduleDialog.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleDialog$provideUiChanges$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallScheduleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallScheduleDialog$provideUiChanges$3(CallScheduleDialog callScheduleDialog, Continuation<? super CallScheduleDialog$provideUiChanges$3> continuation) {
        super(2, continuation);
        this.this$0 = callScheduleDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallScheduleDialog$provideUiChanges$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallScheduleDialog$provideUiChanges$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CallScheduleViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            StateFlow<Boolean[]> days = viewModel.getDays();
            final CallScheduleDialog callScheduleDialog = this.this$0;
            this.label = 1;
            if (days.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$3.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Boolean[]) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Boolean[] boolArr, Continuation<? super Unit> continuation) {
                    DialogCallScheduleBinding binding;
                    binding = CallScheduleDialog.this.getBinding();
                    Chip chip = binding.chMonday;
                    if (chip.isChecked() != boolArr[0].booleanValue()) {
                        chip.setChecked(boolArr[0].booleanValue());
                    }
                    Chip chip2 = binding.chTuesday;
                    if (chip2.isChecked() != boolArr[1].booleanValue()) {
                        chip2.setChecked(boolArr[1].booleanValue());
                    }
                    Chip chip3 = binding.chWednesday;
                    if (chip3.isChecked() != boolArr[2].booleanValue()) {
                        chip3.setChecked(boolArr[2].booleanValue());
                    }
                    Chip chip4 = binding.chThursday;
                    if (chip4.isChecked() != boolArr[3].booleanValue()) {
                        chip4.setChecked(boolArr[3].booleanValue());
                    }
                    Chip chip5 = binding.chFriday;
                    if (chip5.isChecked() != boolArr[4].booleanValue()) {
                        chip5.setChecked(boolArr[4].booleanValue());
                    }
                    Chip chip6 = binding.chSaturday;
                    if (chip6.isChecked() != boolArr[5].booleanValue()) {
                        chip6.setChecked(boolArr[5].booleanValue());
                    }
                    Chip chip7 = binding.chSunday;
                    if (chip7.isChecked() != boolArr[6].booleanValue()) {
                        chip7.setChecked(boolArr[6].booleanValue());
                    }
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
