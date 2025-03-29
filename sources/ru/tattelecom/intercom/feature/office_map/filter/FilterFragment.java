package ru.tattelecom.intercom.feature.office_map.filter;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.Chip;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
import ru.tattelecom.intercom.feature.office_map.R;
import ru.tattelecom.intercom.feature.office_map.databinding.FragmentFilterBinding;
import ru.tattelecom.intercom.feature.office_map.main.MapViewModel;
import ru.tattelecom.intercom.feature.office_map.main.OfficeService;

/* compiled from: FilterFragment.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/filter/FilterFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/office_map/databinding/FragmentFilterBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/office_map/databinding/FragmentFilterBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/office_map/main/MapViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/office_map/main/MapViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Landroid/view/View;", "renderServices", "setupFullHeight", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "updateButtons", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FilterFragment extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FilterFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/office_map/databinding/FragmentFilterBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public FilterFragment() {
        super(R.layout.fragment_filter);
        final FilterFragment filterFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(filterFragment, FragmentFilterBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<ViewModelStoreOwner> function0 = new Function0<ViewModelStoreOwner>() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                Fragment parentFragment = FilterFragment.this.getParentFragment();
                Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
                return parentFragment;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<MapViewModel>() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.office_map.main.MapViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final MapViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MapViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentFilterBinding getBinding() {
        return (FragmentFilterBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final MapViewModel getViewModel() {
        return (MapViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.NoBackgroundBottomSheetDialogTheme;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "onCreateDialog(...)");
        onCreateDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                FilterFragment.onCreateDialog$lambda$0(FilterFragment.this, dialogInterface);
            }
        });
        return onCreateDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0(FilterFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        this$0.setupFullHeight((BottomSheetDialog) dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentFilterBinding binding = getBinding();
        binding.btnClean.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FilterFragment.onViewCreated$lambda$4$lambda$1(FilterFragment.this, view2);
            }
        });
        binding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FilterFragment.onViewCreated$lambda$4$lambda$2(FilterFragment.this, view2);
            }
        });
        binding.btnShow.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FilterFragment.onViewCreated$lambda$4$lambda$3(FilterFragment.this, view2);
            }
        });
        updateButtons();
        renderServices();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$1(FilterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().cgServices.clearCheck();
        this$0.getViewModel().clearFilters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$2(FilterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4$lambda$3(FilterFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().updateFilter();
        this$0.dismiss();
    }

    private final void renderServices() {
        List<OfficeService> value = getViewModel().getServicesList().getValue();
        if (value != null) {
            for (final OfficeService officeService : value) {
                if (officeService.getId() != -2) {
                    Chip chip = new Chip(requireContext());
                    chip.setText(officeService.getName());
                    chip.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.chip_text_black));
                    chip.setChipBackgroundColor(ContextCompat.getColorStateList(requireContext(), R.color.chip_bg));
                    chip.setCheckable(true);
                    chip.setCheckedIconVisible(false);
                    chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.office_map.filter.FilterFragment$$ExternalSyntheticLambda4
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            FilterFragment.renderServices$lambda$8$lambda$6$lambda$5(FilterFragment.this, officeService, compoundButton, z);
                        }
                    });
                    if (!getViewModel().getFilters().isEmpty()) {
                        Set<String> filters = getViewModel().getFilters();
                        if (!(filters instanceof Collection) || !filters.isEmpty()) {
                            Iterator<T> it = filters.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (Intrinsics.areEqual((String) it.next(), officeService.getName())) {
                                        chip.setChecked(true);
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    getBinding().cgServices.addView(chip);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void renderServices$lambda$8$lambda$6$lambda$5(FilterFragment this$0, OfficeService service, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(service, "$service");
        this$0.getViewModel().onFilterItemClicked(service.getName(), z);
        this$0.updateButtons();
    }

    private final void updateButtons() {
        getBinding().checkedCountButtonTextView.setText(String.valueOf(getViewModel().getCurrentOfficesListCount()));
        getBinding().btnClean.setEnabled(getViewModel().getCurrentFilters().size() > 0);
    }

    private final void setupFullHeight(BottomSheetDialog bottomSheetDialog) {
        FrameLayout frameLayout = (FrameLayout) bottomSheetDialog.findViewById(R.id.design_bottom_sheet);
        Intrinsics.checkNotNull(frameLayout);
        BottomSheetBehavior from = BottomSheetBehavior.from(frameLayout);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        int i = getResources().getDisplayMetrics().heightPixels - 100;
        if (layoutParams != null) {
            layoutParams.height = i;
        }
        frameLayout.setLayoutParams(layoutParams);
        from.setState(3);
        from.setSkipCollapsed(true);
    }
}
