package ru.tattelecom.intercom.feature.call_schedule;

import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
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
import ru.tattelecom.intercom.android.resources.timerangepicker.TimeSliderRangePicker;
import ru.tattelecom.intercom.feature.call_schedule.databinding.DialogCallScheduleBinding;

/* compiled from: CallScheduleDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$2", f = "CallScheduleDialog.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleDialog$provideUiChanges$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallScheduleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallScheduleDialog$provideUiChanges$2(CallScheduleDialog callScheduleDialog, Continuation<? super CallScheduleDialog$provideUiChanges$2> continuation) {
        super(2, continuation);
        this.this$0 = callScheduleDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallScheduleDialog$provideUiChanges$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallScheduleDialog$provideUiChanges$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CallScheduleViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            StateFlow<Pair<Calendar, Calendar>> time = viewModel.getTime();
            final CallScheduleDialog callScheduleDialog = this.this$0;
            this.label = 1;
            if (time.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Pair<? extends Calendar, ? extends Calendar>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Pair<? extends Calendar, ? extends Calendar> pair, Continuation<? super Unit> continuation) {
                    DialogCallScheduleBinding binding;
                    SimpleDateFormat simpleDateFormat;
                    SimpleDateFormat simpleDateFormat2;
                    if (pair != null) {
                        CallScheduleDialog callScheduleDialog2 = CallScheduleDialog.this;
                        binding = callScheduleDialog2.getBinding();
                        TextView textView = binding.tvFromTime;
                        simpleDateFormat = callScheduleDialog2.timeFormatter;
                        textView.setText(simpleDateFormat.format(pair.getFirst().getTime()));
                        TextView textView2 = binding.tvToTime;
                        simpleDateFormat2 = callScheduleDialog2.timeFormatter;
                        textView2.setText(simpleDateFormat2.format(pair.getSecond().getTime()));
                        TimeSliderRangePicker timeSliderRangePicker = binding.timePicker;
                        if (!Intrinsics.areEqual(timeSliderRangePicker.getStart(), pair.getFirst()) && !Intrinsics.areEqual(timeSliderRangePicker.getEnd(), pair.getSecond())) {
                            timeSliderRangePicker.setTime(pair.getFirst(), pair.getSecond());
                        }
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
