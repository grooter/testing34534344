package ru.tattelecom.intercom.feature.familyaccess.addaddress.registration;

import android.text.Editable;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentRegistrationBinding;

/* compiled from: RegistrationFragment.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class RegistrationFragment$onViewCreated$2$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ RegistrationFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RegistrationFragment$onViewCreated$2$1(RegistrationFragment registrationFragment) {
        super(1);
        this.this$0 = registrationFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final String str) {
        FragmentRegistrationBinding binding;
        binding = this.this$0.getBinding();
        CustomEditTextView customEditTextView = binding.etLogin;
        Editable text = customEditTextView.getText();
        if (!Intrinsics.areEqual(text != null ? text.toString() : null, str)) {
            customEditTextView.setText(str);
        }
        final MaterialButton materialButton = binding.btnRegister;
        materialButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$onViewCreated$2$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                RegistrationFragment$onViewCreated$2$1.invoke$lambda$3$lambda$2$lambda$1(MaterialButton.this, str);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$3$lambda$2$lambda$1(MaterialButton this_apply, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        String str2 = str;
        this_apply.setEnabled((str2 == null || str2.length() == 0 || str.length() <= 7) ? false : true);
    }
}
