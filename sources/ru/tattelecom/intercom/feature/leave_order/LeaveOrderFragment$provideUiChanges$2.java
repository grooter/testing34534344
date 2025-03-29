package ru.tattelecom.intercom.feature.leave_order;

import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.leave_order.databinding.FragmentLeaveOrderBinding;

/* compiled from: LeaveOrderFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "policy", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$provideUiChanges$2", f = "LeaveOrderFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LeaveOrderFragment$provideUiChanges$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LeaveOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LeaveOrderFragment$provideUiChanges$2(LeaveOrderFragment leaveOrderFragment, Continuation<? super LeaveOrderFragment$provideUiChanges$2> continuation) {
        super(2, continuation);
        this.this$0 = leaveOrderFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LeaveOrderFragment$provideUiChanges$2 leaveOrderFragment$provideUiChanges$2 = new LeaveOrderFragment$provideUiChanges$2(this.this$0, continuation);
        leaveOrderFragment$provideUiChanges$2.L$0 = obj;
        return leaveOrderFragment$provideUiChanges$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((LeaveOrderFragment$provideUiChanges$2) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentLeaveOrderBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            binding = this.this$0.getBinding();
            TextView textView = binding.tvPrivacyPolicy;
            textView.setText(HtmlCompat.fromHtml("Нажимая &#171;Отправить&#187;, Вы даете свое согласие <br/><a href=\"" + str + "\">на обработку персональных данных</a>", 0));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
