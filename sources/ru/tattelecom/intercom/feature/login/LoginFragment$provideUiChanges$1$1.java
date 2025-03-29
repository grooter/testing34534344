package ru.tattelecom.intercom.feature.login;

import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.tattelecom.intercom.feature.login.databinding.FragmentLoginBinding;

/* compiled from: LoginFragment.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
final class LoginFragment$provideUiChanges$1$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ LoginFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoginFragment$provideUiChanges$1$1(LoginFragment loginFragment) {
        super(1);
        this.this$0 = loginFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final String str) {
        FragmentLoginBinding binding;
        binding = this.this$0.getBinding();
        final MaterialButton materialButton = binding.btnLogIn;
        materialButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$provideUiChanges$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LoginFragment$provideUiChanges$1$1.invoke$lambda$1$lambda$0(MaterialButton.this, str);
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(MaterialButton this_apply, String str) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setEnabled(str.length() == 13);
    }
}
