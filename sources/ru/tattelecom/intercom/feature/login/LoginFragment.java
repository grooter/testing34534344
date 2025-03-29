package ru.tattelecom.intercom.feature.login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.EditTextPhoneFormatter;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.login.LoginViewModel;
import ru.tattelecom.intercom.feature.login.databinding.FragmentLoginBinding;
import ru.tattelecom.intercom.lib_chat.EDNAChat;

/* compiled from: LoginFragment.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0003J\u001a\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\b\u0010\u001f\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lru/tattelecom/intercom/feature/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/login/databinding/FragmentLoginBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/login/databinding/FragmentLoginBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "supportViewModel", "Lru/tattelecom/intercom/android/resources/SupportViewModel;", "getSupportViewModel", "()Lru/tattelecom/intercom/android/resources/SupportViewModel;", "supportViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lru/tattelecom/intercom/feature/login/LoginViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/login/LoginViewModel;", "viewModel$delegate", "checkApplicationOrientation", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event;", "provideUiChanges", "setUi", "startTimer", "updateSupportVariables", "feature-login_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoginFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LoginFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/login/databinding/FragmentLoginBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: supportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy supportViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public LoginFragment() {
        super(R.layout.fragment_login);
        final LoginFragment loginFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(loginFragment, FragmentLoginBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<LoginViewModel>() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.login.LoginViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final LoginViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                Fragment fragment = Fragment.this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LoginViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        final Function0<Fragment> function04 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.supportViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SupportViewModel>() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$special$$inlined$viewModel$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.android.resources.SupportViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final SupportViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                Fragment fragment = Fragment.this;
                Qualifier qualifier2 = qualifier;
                Function0 function05 = function04;
                Function0 function06 = function02;
                Function0 function07 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function05.invoke()).getViewModelStore();
                if (function06 == null || (defaultViewModelCreationExtras = (CreationExtras) function06.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SupportViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function07);
                return resolveViewModel;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentLoginBinding getBinding() {
        return (FragmentLoginBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoginViewModel getViewModel() {
        return (LoginViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportViewModel getSupportViewModel() {
        return (SupportViewModel) this.supportViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        checkApplicationOrientation();
        EDNAChat.INSTANCE.logoutUser();
        updateSupportVariables();
        setUi();
        provideUiChanges();
        startTimer();
    }

    private final void updateSupportVariables() {
        Context context = getContext();
        if (context != null) {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            SupportViewModel supportViewModel = getSupportViewModel();
            String versionName = packageInfo.versionName;
            Intrinsics.checkNotNullExpressionValue(versionName, "versionName");
            supportViewModel.resetSupportContacts(versionName);
        }
        getSupportViewModel().updatePolicy();
    }

    private final void checkApplicationOrientation() {
        if (getResources().getConfiguration().orientation != 1) {
            requireActivity().setRequestedOrientation(1);
        }
    }

    private final void startTimer() {
        Bundle arguments = getArguments();
        Integer valueOf = arguments != null ? Integer.valueOf(arguments.getInt("previousPage")) : null;
        int verify = NavGraphDestinations.Dest.INSTANCE.getVerify();
        if (valueOf != null && valueOf.intValue() == verify) {
            getViewModel().startTimer();
        }
    }

    private final void setUi() {
        FragmentActivity activity;
        Window window;
        FragmentLoginBinding binding = getBinding();
        final CustomEditTextView customEditTextView = binding.etPhoneNumber;
        CustomEditTextView etPhoneNumber = binding.etPhoneNumber;
        Intrinsics.checkNotNullExpressionValue(etPhoneNumber, "etPhoneNumber");
        customEditTextView.addTextChangedListener(new EditTextPhoneFormatter(etPhoneNumber, "##) ###-##-##"));
        customEditTextView.makeClearableEditText(null, null);
        Intrinsics.checkNotNull(customEditTextView);
        customEditTextView.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$setUi$lambda$6$lambda$2$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                LoginViewModel viewModel;
                viewModel = LoginFragment.this.getViewModel();
                viewModel.onPhoneUpdate(String.valueOf(customEditTextView.getText()));
            }
        });
        if (customEditTextView.requestFocus() && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(5);
        }
        binding.btnLogIn.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginFragment.setUi$lambda$6$lambda$5(LoginFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$5(final LoginFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getViewModel().getCurrentTime().getValue() != null) {
            Long value = this$0.getViewModel().getCurrentTime().getValue();
            Intrinsics.checkNotNull(value);
            if (value.longValue() > 0) {
                final AlertDialog show = new MaterialAlertDialogBuilder(this$0.requireContext()).setTitle(R.string.requests_exceeded).setMessage((CharSequence) this$0.getString(R.string.please_try_again_in_45_seconds, this$0.getViewModel().getCurrentTime().getValue())).setPositiveButton(R.string.good, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$$ExternalSyntheticLambda2
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        LoginFragment.setUi$lambda$6$lambda$5$lambda$4(LoginFragment.this, dialogInterface);
                    }
                }).show();
                this$0.getViewModel().getCurrentTime().observe(this$0.getViewLifecycleOwner(), new LoginFragment$sam$androidx_lifecycle_Observer$0(new Function1<Long, Unit>() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$setUi$1$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke2(l);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Long l) {
                        if (l != null && l.longValue() == 0) {
                            AlertDialog.this.cancel();
                        }
                        AlertDialog.this.setMessage(this$0.getString(R.string.please_try_again_in_45_seconds, l));
                    }
                }));
                return;
            }
        }
        this$0.getViewModel().onLogInClick(ExtensionsKt.getDeviceCode(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$5$lambda$4(LoginFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().getCurrentTime().removeObservers(this$0.getViewLifecycleOwner());
    }

    private final void provideUiChanges() {
        LoginViewModel viewModel = getViewModel();
        viewModel.getPhoneNumber().observe(getViewLifecycleOwner(), new LoginFragment$sam$androidx_lifecycle_Observer$0(new LoginFragment$provideUiChanges$1$1(this)));
        viewModel.isButtonLoading().observe(getViewLifecycleOwner(), new LoginFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.login.LoginFragment$provideUiChanges$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                FragmentLoginBinding binding;
                binding = LoginFragment.this.getBinding();
                MaterialButton materialButton = binding.btnLogIn;
                LoginFragment loginFragment = LoginFragment.this;
                Intrinsics.checkNotNull(bool);
                boolean booleanValue = bool.booleanValue();
                Intrinsics.checkNotNull(materialButton);
                if (booleanValue) {
                    ExtensionsKt.showProgress(materialButton);
                    return;
                }
                String string = loginFragment.getString(R.string.continue_);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtensionsKt.hideProgress(materialButton, string);
            }
        }));
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LoginFragment$provideUiChanges$1$3(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new LoginFragment$provideUiChanges$1$4(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new LoginFragment$provideUiChanges$1$5(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(LoginViewModel.Event event) {
        if (event instanceof LoginViewModel.Event.Navigate) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), ((LoginViewModel.Event.Navigate) event).getAction(), null, null, 6, null);
            return;
        }
        if (event instanceof LoginViewModel.Event.ShowMessage) {
            Context requireContext = requireContext();
            String message = ((LoginViewModel.Event.ShowMessage) event).getMessage();
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
    }
}
