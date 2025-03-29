package ru.tattelecom.intercom.feature.home.error_screen;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.feature.home.R;
import ru.tattelecom.intercom.feature.home.databinding.DialogIntercomErrorBinding;

/* compiled from: IntercomErrorDialogFragment.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/home/error_screen/IntercomErrorDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/home/databinding/DialogIntercomErrorBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/home/databinding/DialogIntercomErrorBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/home/error_screen/IntercomErrorViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/home/error_screen/IntercomErrorViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setUi", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class IntercomErrorDialogFragment extends DialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(IntercomErrorDialogFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/home/databinding/DialogIntercomErrorBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public IntercomErrorDialogFragment() {
        super(R.layout.dialog_intercom_error);
        final IntercomErrorDialogFragment intercomErrorDialogFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(intercomErrorDialogFragment, DialogIntercomErrorBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorDialogFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<IntercomErrorViewModel>() { // from class: ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorDialogFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final IntercomErrorViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(IntercomErrorViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DialogIntercomErrorBinding getBinding() {
        return (DialogIntercomErrorBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final IntercomErrorViewModel getViewModel() {
        return (IntercomErrorViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Window window;
        Window window2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Dialog dialog = getDialog();
        WindowManager.LayoutParams layoutParams = null;
        WindowManager.LayoutParams attributes = (dialog == null || (window2 = dialog.getWindow()) == null) ? null : window2.getAttributes();
        if (attributes != null) {
            attributes.width = -1;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        setUi();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.AppTheme_RoundedCornersDialog;
    }

    private final void setUi() {
        DialogIntercomErrorBinding binding = getBinding();
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntercomErrorDialogFragment.setUi$lambda$2$lambda$0(IntercomErrorDialogFragment.this, view);
            }
        });
        Integer errorCode = getViewModel().getErrorCode();
        if ((errorCode != null && errorCode.intValue() == 0) || getViewModel().getErrorCode() == null) {
            binding.tvEmergencyCodeTitle.setText(requireContext().getString(R.string.error_exclamation_mark));
            binding.tvEmergencyCodeText.setText(requireContext().getString(R.string.something_went_wrong));
        }
        binding.btnReportIssue.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IntercomErrorDialogFragment.setUi$lambda$2$lambda$1(IntercomErrorDialogFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$2$lambda$0(IntercomErrorDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$2$lambda$1(IntercomErrorDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startActivity(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:+78432222222")));
    }
}
