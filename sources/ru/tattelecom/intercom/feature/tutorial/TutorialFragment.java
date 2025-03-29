package ru.tattelecom.intercom.feature.tutorial;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.feature.tutorial.databinding.FragmentTutorialBinding;

/* compiled from: TutorialFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/feature/tutorial/TutorialFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/tutorial/databinding/FragmentTutorialBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/tutorial/databinding/FragmentTutorialBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "tipsAdapter", "Lru/tattelecom/intercom/feature/tutorial/TipsAdapter;", "viewModel", "Lru/tattelecom/intercom/feature/tutorial/TutorialViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/tutorial/TutorialViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onStop", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideUiChanges", "setUi", "feature-tutorial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TutorialFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(TutorialFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/tutorial/databinding/FragmentTutorialBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private TipsAdapter tipsAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public TutorialFragment() {
        super(R.layout.fragment_tutorial);
        final TutorialFragment tutorialFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(tutorialFragment, FragmentTutorialBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<TutorialViewModel>() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.tutorial.TutorialViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final TutorialViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(TutorialViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentTutorialBinding getBinding() {
        return (FragmentTutorialBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TutorialViewModel getViewModel() {
        return (TutorialViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        getViewModel().readAllTips();
        super.onStop();
    }

    private final void setUi() {
        OnBackPressedDispatcher onBackPressedDispatcher;
        TipsAdapter tipsAdapter = new TipsAdapter();
        tipsAdapter.submitList(getViewModel().getTips());
        this.tipsAdapter = tipsAdapter;
        FragmentTutorialBinding binding = getBinding();
        ViewPager2 viewPager2 = binding.vpTips;
        TipsAdapter tipsAdapter2 = this.tipsAdapter;
        if (tipsAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipsAdapter");
            tipsAdapter2 = null;
        }
        viewPager2.setAdapter(tipsAdapter2);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$setUi$2$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int position) {
                TutorialViewModel viewModel;
                super.onPageSelected(position);
                viewModel = TutorialFragment.this.getViewModel();
                viewModel.onTipChanged(position);
            }
        });
        new TabLayoutMediator(binding.tlTips, binding.vpTips, new TabLayoutMediator.TabConfigurationStrategy() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$$ExternalSyntheticLambda0
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                Intrinsics.checkNotNullParameter(tab, "<anonymous parameter 0>");
            }
        }).attach();
        binding.tlTips.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$setUi$2$3
            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
                TutorialViewModel viewModel;
                int i;
                if (tab != null) {
                    TutorialFragment tutorialFragment = TutorialFragment.this;
                    TabLayout.TabView tabView = tab.view;
                    Context requireContext = tutorialFragment.requireContext();
                    int position = tab.getPosition();
                    viewModel = tutorialFragment.getViewModel();
                    if (position > viewModel.getCurrentTipPosition().getValue().intValue()) {
                        i = R.drawable.ic_dot_default;
                    } else {
                        i = R.drawable.ic_dot_viewed;
                    }
                    tabView.setBackground(AppCompatResources.getDrawable(requireContext, i));
                }
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab != null) {
                    tab.view.setBackground(AppCompatResources.getDrawable(TutorialFragment.this.requireContext(), R.drawable.ic_dot_selected));
                }
            }
        });
        FragmentActivity activity = getActivity();
        if (activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$setUi$3
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                TutorialViewModel viewModel;
                viewModel = TutorialFragment.this.getViewModel();
                viewModel.onBackPressed();
            }
        });
    }

    private final void provideUiChanges() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new TutorialFragment$provideUiChanges$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new TutorialFragment$provideUiChanges$2(this, null), 3, null);
    }
}
