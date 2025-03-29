package ru.tattelecom.intercom.feature.familyaccess.addaddress.registration;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavOptions;
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
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragmentKt;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationViewModel;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentRegistrationBinding;

/* compiled from: RegistrationFragment.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/addaddress/registration/RegistrationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentRegistrationBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentRegistrationBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/familyaccess/addaddress/registration/RegistrationViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/familyaccess/addaddress/registration/RegistrationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/familyaccess/addaddress/registration/RegistrationViewModel$Event;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RegistrationFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(RegistrationFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentRegistrationBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public RegistrationFragment() {
        super(R.layout.fragment_registration);
        final RegistrationFragment registrationFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(registrationFragment, FragmentRegistrationBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<RegistrationViewModel>() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final RegistrationViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RegistrationViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentRegistrationBinding getBinding() {
        return (FragmentRegistrationBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RegistrationViewModel getViewModel() {
        return (RegistrationViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentRegistrationBinding binding = getBinding();
        CustomEditTextView customEditTextView = binding.etLogin;
        customEditTextView.makeClearableEditText(null, null);
        Intrinsics.checkNotNull(customEditTextView);
        customEditTextView.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$onViewCreated$lambda$3$lambda$1$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                RegistrationViewModel viewModel;
                viewModel = RegistrationFragment.this.getViewModel();
                viewModel.onLoginEnter(String.valueOf(s));
            }
        });
        binding.btnRegister.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RegistrationFragment.onViewCreated$lambda$3$lambda$2(RegistrationFragment.this, view2);
            }
        });
        RegistrationViewModel viewModel = getViewModel();
        viewModel.getLogin().observe(getViewLifecycleOwner(), new RegistrationFragment$sam$androidx_lifecycle_Observer$0(new RegistrationFragment$onViewCreated$2$1(this)));
        viewModel.isButtonLoading().observe(getViewLifecycleOwner(), new RegistrationFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$onViewCreated$2$2
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
                FragmentRegistrationBinding binding2;
                binding2 = RegistrationFragment.this.getBinding();
                MaterialButton materialButton = binding2.btnRegister;
                RegistrationFragment registrationFragment = RegistrationFragment.this;
                Intrinsics.checkNotNull(bool);
                boolean booleanValue = bool.booleanValue();
                Intrinsics.checkNotNull(materialButton);
                if (booleanValue) {
                    ExtensionsKt.showProgress(materialButton);
                    return;
                }
                String string = registrationFragment.getString(R.string.send);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtensionsKt.hideProgressAllCaps(materialButton, string);
            }
        }));
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new RegistrationFragment$onViewCreated$2$3(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(RegistrationFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onRegisterClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(RegistrationViewModel.Event event) {
        if (event instanceof RegistrationViewModel.Event.NavigateToErrorPage) {
            Integer errorCode = ((RegistrationViewModel.Event.NavigateToErrorPage) event).getErrorCode();
            if ((errorCode != null && errorCode.intValue() == 10) || (errorCode != null && errorCode.intValue() == 11)) {
                new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.invalid_reg_login).setMessage(R.string.invalid_reg_login_message).setPositiveButton(R.string.good, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
                return;
            } else if (errorCode != null && errorCode.intValue() == 12) {
                new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.reg_login_already_used).setMessage(R.string.reg_login_already_used_message).setPositiveButton(R.string.good, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
                return;
            } else {
                NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToRequestState(), BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "error")), null, 4, null);
                return;
            }
        }
        if (Intrinsics.areEqual(event, RegistrationViewModel.Event.NavigateToSuccessPage.INSTANCE)) {
            NavExtKt.navigateSafe(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToRequestState(), BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "success"), TuplesKt.to("title", getString(R.string.address_added_title)), TuplesKt.to("message", getString(R.string.address_added_message))), NavOptions.Builder.setPopUpTo$default(new NavOptions.Builder(), NavGraphDestinations.Dest.INSTANCE.getAddAddress(), true, false, 4, (Object) null).build());
            return;
        }
        if (event instanceof RegistrationViewModel.Event.ShowMessage) {
            Context requireContext = requireContext();
            String message = ((RegistrationViewModel.Event.ShowMessage) event).getMessage();
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
    }
}
