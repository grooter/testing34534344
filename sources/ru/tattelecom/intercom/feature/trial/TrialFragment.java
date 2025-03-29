package ru.tattelecom.intercom.feature.trial;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.ViewKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.button.MaterialButton;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.trial.databinding.FragmentTrialBinding;

/* compiled from: TrialFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0016\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/feature/trial/TrialFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/trial/databinding/FragmentTrialBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/trial/databinding/FragmentTrialBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/trial/TrialViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/trial/TrialViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideUiChanges", "registerOnBackPressedCallback", "onBackPressed", "Lkotlin/Function0;", "setUi", "trial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TrialFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TrialFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/trial/databinding/FragmentTrialBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public TrialFragment() {
        super(R.layout.fragment_trial);
        final TrialFragment trialFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(trialFragment, FragmentTrialBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TrialViewModel>() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.trial.TrialViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final TrialViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TrialViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentTrialBinding getBinding() {
        return (FragmentTrialBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TrialViewModel getViewModel() {
        return (TrialViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        String quantityString;
        FragmentTrialBinding binding = getBinding();
        String screen = getViewModel().getScreen();
        int hashCode = screen.hashCode();
        if (hashCode == 460047084) {
            if (screen.equals(NavArg.TrialScreen.TRIAL_START)) {
                registerOnBackPressedCallback(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$setUi$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TrialViewModel viewModel;
                        viewModel = TrialFragment.this.getViewModel();
                        viewModel.reportEvent(127);
                        FragmentActivity activity = TrialFragment.this.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }
                });
                binding.ivBackground.setImageResource(R.drawable.img_trial_start);
                String quantityString2 = getResources().getQuantityString(R.plurals.trial_days, getViewModel().getDaysCount(), Integer.valueOf(getViewModel().getDaysCount()));
                Intrinsics.checkNotNullExpressionValue(quantityString2, "getQuantityString(...)");
                binding.tvTitle.setText(getString(R.string.trial_start_title, quantityString2));
                binding.tvDescription.setText(getString(R.string.trial_start_description));
                ImageView btnClose = binding.btnClose;
                Intrinsics.checkNotNullExpressionValue(btnClose, "btnClose");
                btnClose.setVisibility(8);
                MaterialButton materialButton = binding.btnTrial;
                materialButton.setText(getString(R.string.trial_start));
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TrialFragment.setUi$lambda$12$lambda$1$lambda$0(TrialFragment.this, view);
                    }
                });
                binding.clRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TrialFragment.setUi$lambda$12$lambda$2(TrialFragment.this, view);
                    }
                });
                return;
            }
            return;
        }
        if (hashCode == 1497670117) {
            if (screen.equals(NavArg.TrialScreen.TRIAL_END)) {
                registerOnBackPressedCallback(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$setUi$1$6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        TrialViewModel viewModel;
                        viewModel = TrialFragment.this.getViewModel();
                        viewModel.setTrialEnded();
                    }
                });
                binding.ivBackground.setImageResource(R.drawable.img_trial_start);
                binding.tvTitle.setText(getString(R.string.trial_end_title));
                binding.tvDescription.setText(getString(R.string.trial_end_description));
                final ImageView imageView = binding.btnClose;
                Intrinsics.checkNotNull(imageView);
                imageView.setVisibility(0);
                imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TrialFragment.setUi$lambda$12$lambda$9$lambda$8(TrialFragment.this, imageView, view);
                    }
                });
                final MaterialButton materialButton2 = binding.btnTrial;
                materialButton2.setText(getString(R.string.trial_connect));
                materialButton2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TrialFragment.setUi$lambda$12$lambda$11$lambda$10(TrialFragment.this, materialButton2, view);
                    }
                });
                return;
            }
            return;
        }
        if (hashCode == 1497677650 && screen.equals(NavArg.TrialScreen.TRIAL_MID)) {
            binding.ivBackground.setImageResource(R.drawable.img_trial_mid);
            int daysCount = getViewModel().getDaysCount();
            if (daysCount <= 1) {
                quantityString = getString(R.string.trial_remaining_zero_days);
            } else {
                quantityString = getResources().getQuantityString(R.plurals.trial_remaining_days, daysCount, Integer.valueOf(daysCount));
            }
            Intrinsics.checkNotNullExpressionValue(quantityString, "let(...)");
            binding.tvTitle.setText(getString(R.string.trial_mid_title, quantityString));
            binding.tvDescription.setText(getString(R.string.trial_end_description));
            final ImageView imageView2 = binding.btnClose;
            Intrinsics.checkNotNull(imageView2);
            imageView2.setVisibility(0);
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TrialFragment.setUi$lambda$12$lambda$5$lambda$4(imageView2, view);
                }
            });
            final MaterialButton materialButton3 = binding.btnTrial;
            materialButton3.setText(getString(R.string.trial_connect));
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TrialFragment.setUi$lambda$12$lambda$7$lambda$6(TrialFragment.this, materialButton3, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$12$lambda$1$lambda$0(TrialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().activateTrial();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$12$lambda$2(TrialFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(127);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$12$lambda$5$lambda$4(ImageView this_apply, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ViewKt.findNavController(this_apply).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$12$lambda$7$lambda$6(TrialFragment this$0, MaterialButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.getViewModel().reportEvent(121);
        NavExtKt.navigateSafe$default(ViewKt.findNavController(this_apply), NavGraphDestinations.Action.INSTANCE.getToConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getTrial())), TuplesKt.to(NavArg.ENTITY_ID, Long.valueOf(this$0.getViewModel().getId())), TuplesKt.to(NavArg.REPORT_EVENT_ID, 123)), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$12$lambda$9$lambda$8(TrialFragment this$0, ImageView this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.getViewModel().setTrialEnded();
        ViewKt.findNavController(this_apply).navigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$12$lambda$11$lambda$10(TrialFragment this$0, MaterialButton this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.getViewModel().setTrialEnded();
        this$0.getViewModel().reportEvent(125);
        NavExtKt.navigateSafe$default(ViewKt.findNavController(this_apply), NavGraphDestinations.Action.INSTANCE.getToConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getTrial())), TuplesKt.to(NavArg.ENTITY_ID, Long.valueOf(this$0.getViewModel().getId())), TuplesKt.to(NavArg.REPORT_EVENT_ID, 124)), null, 4, null);
    }

    private final void provideUiChanges() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new TrialFragment$provideUiChanges$1(this, null), 3, null);
    }

    private final void registerOnBackPressedCallback(final Function0<Unit> onBackPressed) {
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment$registerOnBackPressedCallback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                onBackPressed.invoke();
            }
        }, 2, null);
    }
}
