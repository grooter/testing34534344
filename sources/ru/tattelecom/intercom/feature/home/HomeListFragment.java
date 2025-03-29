package ru.tattelecom.intercom.feature.home;

import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.feature.home.databinding.FragmentListBinding;

/* compiled from: HomeListFragment.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/home/databinding/FragmentListBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/home/databinding/FragmentListBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "homeListAdapter", "Lru/tattelecom/intercom/feature/home/HomeListAdapter;", "viewModel", "Lru/tattelecom/intercom/feature/home/HomeViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/home/HomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomeListFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HomeListFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/home/databinding/FragmentListBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private HomeListAdapter homeListAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public HomeListFragment() {
        super(R.layout.fragment_list);
        final HomeListFragment homeListFragment = this;
        final Function0<ViewModelStoreOwner> function0 = new Function0<ViewModelStoreOwner>() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                Fragment parentFragment = HomeListFragment.this.getParentFragment();
                Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
                return parentFragment;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HomeViewModel>() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.home.HomeViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final HomeViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(HomeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(homeListFragment, FragmentListBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentListBinding getBinding() {
        return (FragmentListBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ExtensionsKt.registerOnBackPressedCallback(this, new Function1<OnBackPressedCallback, Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$onViewCreated$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback registerOnBackPressedCallback) {
                HomeListAdapter homeListAdapter;
                FragmentActivity activity;
                Intrinsics.checkNotNullParameter(registerOnBackPressedCallback, "$this$registerOnBackPressedCallback");
                homeListAdapter = HomeListFragment.this.homeListAdapter;
                if (homeListAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("homeListAdapter");
                    homeListAdapter = null;
                }
                if (homeListAdapter.closeToolTip() || (activity = HomeListFragment.this.getActivity()) == null) {
                    return;
                }
                activity.finish();
            }
        });
        this.homeListAdapter = new HomeListAdapter(new HomeListFragment$onViewCreated$2(getViewModel()), new HomeListFragment$onViewCreated$3(getViewModel()), new HomeListFragment$onViewCreated$4(getViewModel()), new HomeListFragment$onViewCreated$5(getViewModel()), new HomeListFragment$onViewCreated$6(getViewModel()), new HomeListFragment$onViewCreated$7(getViewModel()), new HomeListFragment$onViewCreated$8(getViewModel()), new HomeListFragment$onViewCreated$9(getViewModel()), new HomeListFragment$onViewCreated$10(getViewModel()), new HomeListFragment$onViewCreated$11(getViewModel()), getViewModel().isToolTipRequires(ConfigInteractor.ToolTips.BTN_GENERATE_CODE), getViewModel().getToolTipMutex(), getViewModel().isToolTipShownFlow(), new Function1<Integer, Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$onViewCreated$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                FragmentListBinding binding;
                binding = HomeListFragment.this.getBinding();
                binding.rvYards.smoothScrollToPosition(i);
            }
        });
        getBinding().swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeListFragment.onViewCreated$lambda$0(HomeListFragment.this);
            }
        });
        RecyclerView recyclerView = getBinding().rvYards;
        HomeListAdapter homeListAdapter = this.homeListAdapter;
        if (homeListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeListAdapter");
            homeListAdapter = null;
        }
        recyclerView.setAdapter(homeListAdapter);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), recyclerView.getResources().getConfiguration().orientation != 1 ? 2 : 1);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$onViewCreated$14$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                HomeListAdapter homeListAdapter2;
                homeListAdapter2 = HomeListFragment.this.homeListAdapter;
                if (homeListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("homeListAdapter");
                    homeListAdapter2 = null;
                }
                if (homeListAdapter2.getViewByPosition(position) instanceof HomeAddress) {
                    return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (!arguments.containsKey(HomeFragmentKt.PAGE_NAME)) {
                arguments = null;
            }
            if (arguments != null) {
                String valueOf = String.valueOf(arguments.getString(HomeFragmentKt.PAGE_NAME));
                int hashCode = valueOf.hashCode();
                if (hashCode != -2105005228) {
                    if (hashCode != 80846521) {
                        if (hashCode == 1019215258 && valueOf.equals(HomeFragmentKt.CAMERAS)) {
                            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new HomeListFragment$onViewCreated$16$1(this, null), 3, null);
                        }
                    } else if (valueOf.equals(HomeFragmentKt.FAVORITES)) {
                        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
                        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new HomeListFragment$onViewCreated$16$3(this, null), 3, null);
                    }
                } else if (valueOf.equals(HomeFragmentKt.INTERCOMS)) {
                    LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
                    Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new HomeListFragment$onViewCreated$16$2(this, null), 3, null);
                }
            }
        }
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new HomeListFragment$onViewCreated$17(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HomeListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomeViewModel.onRefreshAddresses$default(this$0.getViewModel(), null, 1, null);
    }
}
