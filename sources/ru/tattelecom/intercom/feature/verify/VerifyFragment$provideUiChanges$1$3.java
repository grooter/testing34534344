package ru.tattelecom.intercom.feature.verify;

import com.google.android.material.button.MaterialButton;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import ru.tattelecom.intercom.feature.verify.databinding.FragmentVerifyBinding;

/* compiled from: VerifyFragment.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Long;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
final class VerifyFragment$provideUiChanges$1$3 extends Lambda implements Function1<Long, Unit> {
    final /* synthetic */ VerifyFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VerifyFragment$provideUiChanges$1$3(VerifyFragment verifyFragment) {
        super(1);
        this.this$0 = verifyFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke2(l);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Long l) {
        FragmentVerifyBinding binding;
        String str;
        binding = this.this$0.getBinding();
        final MaterialButton materialButton = binding.btnResendCode;
        VerifyFragment verifyFragment = this.this$0;
        materialButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$provideUiChanges$1$3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                VerifyFragment$provideUiChanges$1$3.invoke$lambda$1$lambda$0(MaterialButton.this, l);
            }
        }, 50L);
        if (l != null && l.longValue() == 0) {
            str = verifyFragment.getString(R.string.resend_code);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = verifyFragment.getString(R.string.resend_code_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{l}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str = format;
        }
        materialButton.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(MaterialButton this_apply, Long l) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setEnabled(l != null && l.longValue() == 0);
    }
}
