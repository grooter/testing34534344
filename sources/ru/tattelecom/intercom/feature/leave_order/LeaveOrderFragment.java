package ru.tattelecom.intercom.feature.leave_order;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.util.LinkedHashMap;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.EditTextPhoneFormatter;
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.feature.leave_order.databinding.FragmentLeaveOrderBinding;

/* compiled from: LeaveOrderFragment.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010 \u001a\u00020\u0015H\u0002J\b\u0010!\u001a\u00020\u0015H\u0003J\b\u0010\"\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Lru/tattelecom/intercom/feature/leave_order/LeaveOrderFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/leave_order/databinding/FragmentLeaveOrderBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/leave_order/databinding/FragmentLeaveOrderBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "supportViewModel", "Lru/tattelecom/intercom/android/resources/SupportViewModel;", "getSupportViewModel", "()Lru/tattelecom/intercom/android/resources/SupportViewModel;", "supportViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lru/tattelecom/intercom/feature/leave_order/LeaveOrderViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/leave_order/LeaveOrderViewModel;", "viewModel$delegate", "navigateToRequestState", "", "bundle", "Landroid/os/Bundle;", "isMainActivity", "", "navOptions", "Landroidx/navigation/NavOptions;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "provideUiChanges", "setUi", "showLeaveRequestDialog", "updateSupportVariables", "feature-leave-order_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LeaveOrderFragment extends DialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(LeaveOrderFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/leave_order/databinding/FragmentLeaveOrderBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: supportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy supportViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public LeaveOrderFragment() {
        super(R.layout.fragment_leave_order);
        final LeaveOrderFragment leaveOrderFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(leaveOrderFragment, FragmentLeaveOrderBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<LeaveOrderViewModel>() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.leave_order.LeaveOrderViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final LeaveOrderViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(LeaveOrderViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        final Function0<Fragment> function04 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.supportViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SupportViewModel>() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$special$$inlined$viewModel$default$4
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
    public final FragmentLeaveOrderBinding getBinding() {
        return (FragmentLeaveOrderBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LeaveOrderViewModel getViewModel() {
        return (LeaveOrderViewModel) this.viewModel.getValue();
    }

    private final SupportViewModel getSupportViewModel() {
        return (SupportViewModel) this.supportViewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        updateSupportVariables();
        setUi();
        provideUiChanges();
    }

    private final void updateSupportVariables() {
        getSupportViewModel().updatePolicy();
    }

    private final void setUi() {
        Window window;
        FragmentLeaveOrderBinding binding = getBinding();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
        Integer previousPage = getViewModel().getPreviousPage();
        int player = NavGraphDestinations.Dest.INSTANCE.getPlayer();
        if (previousPage != null && previousPage.intValue() == player) {
            MaterialToolbar materialToolbar = binding.toolbar;
            materialToolbar.setTitle(getString(R.string.leave_request));
            materialToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
            materialToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LeaveOrderFragment.setUi$lambda$9$lambda$1$lambda$0(LeaveOrderFragment.this, view);
                }
            });
        } else {
            MaterialToolbar materialToolbar2 = binding.toolbar;
            Intrinsics.checkNotNull(materialToolbar2);
            LeaveOrderFragment leaveOrderFragment = this;
            ToolbarKt.setupWithNavController(materialToolbar2, FragmentKt.findNavController(leaveOrderFragment), new AppBarConfiguration.Builder(FragmentKt.findNavController(leaveOrderFragment).getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new LeaveOrderFragment$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$setUi$lambda$9$lambda$3$$inlined$AppBarConfiguration$default$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return false;
                }
            })).build());
            materialToolbar2.setNavigationOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LeaveOrderFragment.setUi$lambda$9$lambda$3$lambda$2(LeaveOrderFragment.this, view);
                }
            });
        }
        final CustomEditTextView customEditTextView = binding.etPhoneNumber;
        CustomEditTextView etPhoneNumber = binding.etPhoneNumber;
        Intrinsics.checkNotNullExpressionValue(etPhoneNumber, "etPhoneNumber");
        customEditTextView.addTextChangedListener(new EditTextPhoneFormatter(etPhoneNumber, "##) ###-##-##"));
        customEditTextView.makeClearableEditText(null, null);
        Intrinsics.checkNotNull(customEditTextView);
        customEditTextView.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$setUi$lambda$9$lambda$5$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                LeaveOrderViewModel viewModel;
                viewModel = LeaveOrderFragment.this.getViewModel();
                viewModel.onPhoneChanged(String.valueOf(customEditTextView.getText()));
            }
        });
        CustomEditTextView customEditTextView2 = binding.etName;
        customEditTextView2.makeClearableEditText(null, null);
        Intrinsics.checkNotNull(customEditTextView2);
        customEditTextView2.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$setUi$lambda$9$lambda$7$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                LeaveOrderViewModel viewModel;
                viewModel = LeaveOrderFragment.this.getViewModel();
                viewModel.onNameChanged(String.valueOf(s));
            }
        });
        binding.btnApply.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LeaveOrderFragment.setUi$lambda$9$lambda$8(LeaveOrderFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$1$lambda$0(LeaveOrderFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$3$lambda$2(LeaveOrderFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$8(LeaveOrderFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showLeaveRequestDialog();
    }

    private final void provideUiChanges() {
        LeaveOrderViewModel viewModel = getViewModel();
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getName(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$1$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        Flow onEach2 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getPhone(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$1$2(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2));
        Flow onEach3 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isLoading(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$1$3(this, null));
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach3, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3));
        Flow onEach4 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isLeaveOrderAllowed(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$1$4(this, null));
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach4, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4));
        Flow onEach5 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$1$5(this, null));
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach5, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5));
        Flow onEach6 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getServicesList(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$1$6(this, null));
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach6, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6));
        Flow onEach7 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(getSupportViewModel().getPolicy(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new LeaveOrderFragment$provideUiChanges$2(this, null));
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach7, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner7));
    }

    static /* synthetic */ void navigateToRequestState$default(LeaveOrderFragment leaveOrderFragment, Bundle bundle, boolean z, NavOptions navOptions, int i, Object obj) {
        if ((i & 4) != 0) {
            navOptions = null;
        }
        leaveOrderFragment.navigateToRequestState(bundle, z, navOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToRequestState(Bundle bundle, boolean isMainActivity, NavOptions navOptions) {
        if (isMainActivity) {
            NavExtKt.navigateSafe(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToRequestState(), bundle, navOptions);
            return;
        }
        bundle.putString(NavArg.Activity.NAME, NavArg.Activity.LEAVE_ORDER);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
        FragmentTransaction beginTransaction = parentFragmentManager.beginTransaction();
        Integer containerId = getViewModel().getContainerId();
        if (containerId != null) {
            beginTransaction.replace(containerId.intValue(), RequestStateFragment.class, bundle);
        }
        beginTransaction.setReorderingAllowed(true);
        beginTransaction.commit();
    }

    private final void showLeaveRequestDialog() {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.sending_request).setMessage(R.string.confirm_sending).setPositiveButton(R.string.send, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LeaveOrderFragment.showLeaveRequestDialog$lambda$14(LeaveOrderFragment.this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLeaveRequestDialog$lambda$14(LeaveOrderFragment this$0, DialogInterface dialogInterface, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LeaveOrderViewModel viewModel = this$0.getViewModel();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Integer previousPage = viewModel.getPreviousPage();
        int profile = NavGraphDestinations.Dest.INSTANCE.getProfile();
        if (previousPage != null && previousPage.intValue() == profile) {
            i2 = 8;
        } else {
            int player = NavGraphDestinations.Dest.INSTANCE.getPlayer();
            int i3 = 13;
            if (previousPage == null || previousPage.intValue() != player) {
                int videoPlayer = NavGraphDestinations.Dest.INSTANCE.getVideoPlayer();
                if (previousPage == null || previousPage.intValue() != videoPlayer) {
                    int home = NavGraphDestinations.Dest.INSTANCE.getHome();
                    if (previousPage != null && previousPage.intValue() == home) {
                        Integer reportEventId = this$0.getViewModel().getReportEventId();
                        i2 = reportEventId != null ? reportEventId.intValue() : 34;
                    } else {
                        int eventLog = NavGraphDestinations.Dest.INSTANCE.getEventLog();
                        i3 = 36;
                        if (previousPage != null && previousPage.intValue() == eventLog) {
                            Integer reportEventId2 = this$0.getViewModel().getReportEventId();
                            if (reportEventId2 != null) {
                                i2 = reportEventId2.intValue();
                            }
                        } else {
                            int homeBottomSheet = NavGraphDestinations.Dest.INSTANCE.getHomeBottomSheet();
                            if (previousPage != null && previousPage.intValue() == homeBottomSheet) {
                                linkedHashMap.put(LogInteractor.ADV_ID, viewModel.getEntityId());
                                i2 = 104;
                            }
                        }
                    }
                }
            }
            i2 = i3;
        }
        viewModel.reportEvent(i2, linkedHashMap);
        viewModel.onLeaveOrder();
    }
}
