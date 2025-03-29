package ru.tattelecom.intercom.feature.call_schedule;

import com.google.android.material.button.MaterialButton;
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
import ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$4;
import ru.tattelecom.intercom.feature.call_schedule.databinding.DialogCallScheduleBinding;

/* compiled from: CallScheduleDialog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$4", f = "CallScheduleDialog.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleDialog$provideUiChanges$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CallScheduleDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallScheduleDialog$provideUiChanges$4(CallScheduleDialog callScheduleDialog, Continuation<? super CallScheduleDialog$provideUiChanges$4> continuation) {
        super(2, continuation);
        this.this$0 = callScheduleDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallScheduleDialog$provideUiChanges$4(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallScheduleDialog$provideUiChanges$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: CallScheduleDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "emit", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$4$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ CallScheduleDialog this$0;

        AnonymousClass1(CallScheduleDialog callScheduleDialog) {
            this.this$0 = callScheduleDialog;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
        }

        public final Object emit(final boolean z, Continuation<? super Unit> continuation) {
            DialogCallScheduleBinding binding;
            binding = this.this$0.getBinding();
            final MaterialButton materialButton = binding.btnSave;
            materialButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$provideUiChanges$4$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CallScheduleDialog$provideUiChanges$4.AnonymousClass1.emit$lambda$1$lambda$0(MaterialButton.this, z);
                }
            }, 50L);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$1$lambda$0(MaterialButton this_apply, boolean z) {
            Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
            this_apply.setEnabled(z);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CallScheduleViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            this.label = 1;
            if (viewModel.isSaveScheduleAllowed().collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
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
