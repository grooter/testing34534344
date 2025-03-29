package ru.tattelecom.intercom.feature.leave_order;

import android.text.Editable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.feature.leave_order.databinding.FragmentLeaveOrderBinding;

/* compiled from: LeaveOrderFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$provideUiChanges$1$2", f = "LeaveOrderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LeaveOrderFragment$provideUiChanges$1$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LeaveOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LeaveOrderFragment$provideUiChanges$1$2(LeaveOrderFragment leaveOrderFragment, Continuation<? super LeaveOrderFragment$provideUiChanges$1$2> continuation) {
        super(2, continuation);
        this.this$0 = leaveOrderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LeaveOrderFragment$provideUiChanges$1$2 leaveOrderFragment$provideUiChanges$1$2 = new LeaveOrderFragment$provideUiChanges$1$2(this.this$0, continuation);
        leaveOrderFragment$provideUiChanges$1$2.L$0 = obj;
        return leaveOrderFragment$provideUiChanges$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((LeaveOrderFragment$provideUiChanges$1$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentLeaveOrderBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            binding = this.this$0.getBinding();
            CustomEditTextView customEditTextView = binding.etPhoneNumber;
            if (!Intrinsics.areEqual(String.valueOf(customEditTextView.getText()), str)) {
                customEditTextView.setText(str);
                Editable text = customEditTextView.getText();
                if (text != null) {
                    customEditTextView.setSelection(text.length());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
