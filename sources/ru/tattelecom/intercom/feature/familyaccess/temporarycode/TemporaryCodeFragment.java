package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.databinding.SnackbarCustomAttentionBinding;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentTemporaryCodeBinding;

/* compiled from: TemporaryCodeFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0012\u0010\u0019\u001a\u00020\u00122\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0003J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentTemporaryCodeBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentTemporaryCodeBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "temporaryCodeAdapter", "Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeAdapter;", "viewModel", "Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideUiChanges", "setUi", "showAttentionCustomSnackBar", "text", "", "showErrorDialog", "error", "", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TemporaryCodeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TemporaryCodeFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentTemporaryCodeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private TemporaryCodeAdapter temporaryCodeAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public TemporaryCodeFragment() {
        super(R.layout.fragment_temporary_code);
        final TemporaryCodeFragment temporaryCodeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TemporaryCodeViewModel>() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final TemporaryCodeViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TemporaryCodeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(temporaryCodeFragment, FragmentTemporaryCodeBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TemporaryCodeViewModel getViewModel() {
        return (TemporaryCodeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentTemporaryCodeBinding getBinding() {
        return (FragmentTemporaryCodeBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        this.temporaryCodeAdapter = new TemporaryCodeAdapter(new TemporaryCodeFragment$setUi$1(getViewModel()), new TemporaryCodeFragment$setUi$2(getViewModel()), new TemporaryCodeFragment$setUi$3(getViewModel()), new TemporaryCodeFragment$setUi$4(getViewModel()));
        FragmentTemporaryCodeBinding binding = getBinding();
        MaterialToolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        TemporaryCodeAdapter temporaryCodeAdapter = null;
        ToolbarKt.setupWithNavController$default(toolbar, FragmentKt.findNavController(this), null, 2, null);
        RecyclerView recyclerView = binding.rvTemporaryCodes;
        TemporaryCodeAdapter temporaryCodeAdapter2 = this.temporaryCodeAdapter;
        if (temporaryCodeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("temporaryCodeAdapter");
        } else {
            temporaryCodeAdapter = temporaryCodeAdapter2;
        }
        recyclerView.setAdapter(temporaryCodeAdapter);
        binding.swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                TemporaryCodeFragment.setUi$lambda$1$lambda$0(TemporaryCodeFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$1$lambda$0(TemporaryCodeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TemporaryCodeViewModel.onRefreshTemporaryCodes$default(this$0.getViewModel(), null, 1, null);
    }

    private final void provideUiChanges() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new TemporaryCodeFragment$provideUiChanges$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new TemporaryCodeFragment$provideUiChanges$2(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new TemporaryCodeFragment$provideUiChanges$3(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new TemporaryCodeFragment$provideUiChanges$4(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), null, null, new TemporaryCodeFragment$provideUiChanges$5(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorDialog(String error) {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(Intrinsics.areEqual(error, TemporaryCodeViewModelKt.DELETE_ERROR) ? R.string.error_while_deleting_code : R.string.error_while_generating_code).setMessage(Intrinsics.areEqual(error, TemporaryCodeViewModelKt.DELETE_ERROR) ? R.string.error_while_deleting_code_message : R.string.error_while_generating_code_message).setNeutralButton(R.string.good, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAttentionCustomSnackBar(int text) {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_custom_attention, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarCustomAttentionBinding bind = SnackbarCustomAttentionBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        final Snackbar make = Snackbar.make(getBinding().clRoot, "", -2);
        Intrinsics.checkNotNullExpressionValue(make, "make(...)");
        View view = make.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        View view2 = make.getView();
        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = 48;
        view2.setLayoutParams(layoutParams2);
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(inflate, 0);
        make.getView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bg_rounded_dialog_16dp, null));
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TemporaryCodeFragment.showAttentionCustomSnackBar$lambda$5$lambda$3(Snackbar.this, view3);
            }
        });
        bind.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TemporaryCodeFragment.showAttentionCustomSnackBar$lambda$5$lambda$4(Snackbar.this, this, view3);
            }
        });
        bind.tvAttentionInfo.setText(text);
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$5$lambda$3(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$5$lambda$4(Snackbar snackbar, TemporaryCodeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        snackbar.dismiss();
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Dest.INSTANCE.getConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getTemporaryAccess()))), null, 4, null);
    }
}
