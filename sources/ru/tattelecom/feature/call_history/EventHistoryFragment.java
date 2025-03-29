package ru.tattelecom.feature.call_history;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.paging.CombinedLoadStates;
import androidx.paging.LoadState;
import androidx.paging.PagingData;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.feature.call_history.UiAction;
import ru.tattelecom.feature.call_history.databinding.FragmentEventLogBinding;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.customview.SwipeController;
import ru.tattelecom.intercom.android.resources.customview.SwipeControllerActions;
import ru.tattelecom.intercom.android.resources.databinding.SnackbarCustomAttentionBinding;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.remote.source.paging.DataLoadType;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryFragment.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\u0018\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001aH\u0002J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0003J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0002JB\u00100\u001a\u00020\u001a*\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(06052\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u001a08H\u0002JB\u0010:\u001a\u00020\u001a*\u00020\u00042\f\u00101\u001a\b\u0012\u0004\u0012\u000203022\u0012\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(06052\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u001a08H\u0002J\f\u0010=\u001a\u00020\u001a*\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006>"}, d2 = {"Lru/tattelecom/feature/call_history/EventHistoryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/feature/call_history/databinding/FragmentEventLogBinding;", "getBinding", "()Lru/tattelecom/feature/call_history/databinding/FragmentEventLogBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "callHistoryAdapter", "Lru/tattelecom/feature/call_history/EventHistoryAdapter;", "itemDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "onFilterItemClickListener", "Landroid/view/View$OnClickListener;", "swipeController", "Lru/tattelecom/intercom/android/resources/customview/SwipeController;", "viewModel", "Lru/tattelecom/feature/call_history/EventHistoryViewModel;", "getViewModel", "()Lru/tattelecom/feature/call_history/EventHistoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "clearSwipeController", "", "closeBanner", "navigateToConnectService", "eventId", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openBanner", "provideUiChanges", "removeEvent", "item", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "fromEveryone", "", "setUi", "showAttentionCustomSnackBar", "state", "", "showRemoveEventDialog", "bindList", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lru/tattelecom/feature/call_history/UiState;", "pagingData", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "onScrollChanged", "Lkotlin/Function1;", "Lru/tattelecom/feature/call_history/UiAction$Scroll;", "bindState", "uiActions", "Lru/tattelecom/feature/call_history/UiAction;", "updateRepoListFromInput", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EventHistoryFragment.class, "binding", "getBinding()Lru/tattelecom/feature/call_history/databinding/FragmentEventLogBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private EventHistoryAdapter callHistoryAdapter;
    private RecyclerView.ItemDecoration itemDecoration;
    private ItemTouchHelper itemTouchHelper;
    private final View.OnClickListener onFilterItemClickListener;
    private SwipeController swipeController;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: EventHistoryFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataLoadType.values().length];
            try {
                iArr[DataLoadType.TYPE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataLoadType.TYPE_CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataLoadType.TYPE_KEY_PASSES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataLoadType.TYPE_CODE_PASSES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EventHistoryFragment() {
        super(R.layout.fragment_event_log);
        final EventHistoryFragment eventHistoryFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<EventHistoryViewModel>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.feature.call_history.EventHistoryViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final EventHistoryViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(EventHistoryViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(eventHistoryFragment, FragmentEventLogBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        this.onFilterItemClickListener = new View.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventHistoryFragment.onFilterItemClickListener$lambda$7(EventHistoryFragment.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventHistoryViewModel getViewModel() {
        return (EventHistoryViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentEventLogBinding getBinding() {
        return (FragmentEventLogBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
        getViewModel().reportEvent(18);
        ExtensionsKt.setExitAppActionForBackPressedCallback(this);
    }

    private final void setUi() {
        FragmentEventLogBinding binding = getBinding();
        binding.toolbar.setTitle(getString(R.string.event_log));
        bindState(binding, getViewModel().getState(), getViewModel().getPagingDataFlow(), getViewModel().getAccept());
        SwipeController swipeController = null;
        if (!getViewModel().checkUserAccount()) {
            clearSwipeController();
            EventHistoryAdapter eventHistoryAdapter = this.callHistoryAdapter;
            if (eventHistoryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
                eventHistoryAdapter = null;
            }
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            eventHistoryAdapter.submitData(lifecycle, PagingData.INSTANCE.empty());
            ProgressBar progress = getBinding().progress;
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            progress.setVisibility(0);
            getViewModel().setBannerClosed(false);
            getViewModel().setFilterEventType(DataLoadType.TYPE_ALL);
            updateRepoListFromInput(getBinding());
            getBinding().tvEmptyLogMessage.setText(R.string.no_event_log);
        }
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getFilterEventType().ordinal()];
        if (i == 1) {
            binding.btnAllHistory.setSelected(true);
            getBinding().tvEmptyLogMessage.setText(R.string.no_event_log);
        } else if (i == 2) {
            binding.btnCallHistory.setSelected(true);
            getBinding().tvEmptyLogMessage.setText(R.string.no_call_log);
        } else if (i == 3) {
            binding.btnKeyHistory.setSelected(true);
            getBinding().tvEmptyLogMessage.setText(R.string.no_key_log);
        } else if (i == 4) {
            binding.btnCodePassHistory.setSelected(true);
            getBinding().tvEmptyLogMessage.setText(R.string.no_code_pass_log);
        }
        LinearLayout llFilter = binding.llFilter;
        Intrinsics.checkNotNullExpressionValue(llFilter, "llFilter");
        LinearLayout linearLayout = llFilter;
        int childCount = linearLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            linearLayout.getChildAt(i2).setOnClickListener(this.onFilterItemClickListener);
        }
        RecyclerView recyclerView = binding.rvEventLog;
        SwipeControllerActions swipeControllerActions = new SwipeControllerActions() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$setUi$1$2$1
            @Override // ru.tattelecom.intercom.android.resources.customview.SwipeControllerActions
            public void onClicked(int position) {
                EventHistoryAdapter eventHistoryAdapter2;
                EventHistoryViewModel viewModel;
                eventHistoryAdapter2 = EventHistoryFragment.this.callHistoryAdapter;
                if (eventHistoryAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
                    eventHistoryAdapter2 = null;
                }
                HistoryItem byPosition = eventHistoryAdapter2.getByPosition(position);
                if (byPosition != null) {
                    viewModel = EventHistoryFragment.this.getViewModel();
                    viewModel.showRemoveEventDialog(byPosition);
                }
            }
        };
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.swipeController = new SwipeController(swipeControllerActions, requireContext);
        SwipeController swipeController2 = this.swipeController;
        if (swipeController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("swipeController");
        } else {
            swipeController = swipeController2;
        }
        this.itemTouchHelper = new ItemTouchHelper(swipeController);
        this.itemDecoration = new RecyclerView.ItemDecoration() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$setUi$1$2$2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                SwipeController swipeController3;
                Intrinsics.checkNotNullParameter(c, "c");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                swipeController3 = EventHistoryFragment.this.swipeController;
                if (swipeController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("swipeController");
                    swipeController3 = null;
                }
                SwipeController.onDraw$default(swipeController3, c, null, 2, null);
            }
        };
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(binding.rvEventLog);
        }
        RecyclerView.ItemDecoration itemDecoration = this.itemDecoration;
        if (itemDecoration != null) {
            binding.rvEventLog.addItemDecoration(itemDecoration);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireContext(), recyclerView.getResources().getConfiguration().orientation == 1 ? 1 : 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$setUi$1$2$4$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return 1;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        binding.swipeRefreshLog.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda0
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                EventHistoryFragment.setUi$lambda$5$lambda$4(EventHistoryFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$5$lambda$4(EventHistoryFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EventHistoryAdapter eventHistoryAdapter = this$0.callHistoryAdapter;
        if (eventHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
            eventHistoryAdapter = null;
        }
        eventHistoryAdapter.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFilterItemClickListener$lambda$7(EventHistoryFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinearLayout llFilter = this$0.getBinding().llFilter;
        Intrinsics.checkNotNullExpressionValue(llFilter, "llFilter");
        LinearLayout linearLayout = llFilter;
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            childAt.setSelected(Intrinsics.areEqual(childAt, view));
        }
        EventHistoryAdapter eventHistoryAdapter = null;
        if (Intrinsics.areEqual(view, this$0.getBinding().btnAllHistory)) {
            if (this$0.getViewModel().getFilterEventType() != DataLoadType.TYPE_ALL) {
                this$0.clearSwipeController();
                EventHistoryAdapter eventHistoryAdapter2 = this$0.callHistoryAdapter;
                if (eventHistoryAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
                } else {
                    eventHistoryAdapter = eventHistoryAdapter2;
                }
                Lifecycle lifecycle = this$0.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
                eventHistoryAdapter.submitData(lifecycle, PagingData.INSTANCE.empty());
                ProgressBar progress = this$0.getBinding().progress;
                Intrinsics.checkNotNullExpressionValue(progress, "progress");
                progress.setVisibility(0);
                this$0.getViewModel().setFilterEventType(DataLoadType.TYPE_ALL);
                this$0.updateRepoListFromInput(this$0.getBinding());
                this$0.getBinding().tvEmptyLogMessage.setText(R.string.no_event_log);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(view, this$0.getBinding().btnCallHistory)) {
            if (this$0.getViewModel().getFilterEventType() != DataLoadType.TYPE_CALLS) {
                this$0.clearSwipeController();
                EventHistoryAdapter eventHistoryAdapter3 = this$0.callHistoryAdapter;
                if (eventHistoryAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
                } else {
                    eventHistoryAdapter = eventHistoryAdapter3;
                }
                Lifecycle lifecycle2 = this$0.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle2, "<get-lifecycle>(...)");
                eventHistoryAdapter.submitData(lifecycle2, PagingData.INSTANCE.empty());
                this$0.openBanner();
                ProgressBar progress2 = this$0.getBinding().progress;
                Intrinsics.checkNotNullExpressionValue(progress2, "progress");
                progress2.setVisibility(0);
                this$0.getViewModel().setFilterEventType(DataLoadType.TYPE_CALLS);
                this$0.updateRepoListFromInput(this$0.getBinding());
                this$0.getBinding().tvEmptyLogMessage.setText(R.string.no_call_log);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(view, this$0.getBinding().btnKeyHistory)) {
            if (this$0.getViewModel().getFilterEventType() != DataLoadType.TYPE_KEY_PASSES) {
                this$0.clearSwipeController();
                EventHistoryAdapter eventHistoryAdapter4 = this$0.callHistoryAdapter;
                if (eventHistoryAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
                } else {
                    eventHistoryAdapter = eventHistoryAdapter4;
                }
                Lifecycle lifecycle3 = this$0.getLifecycle();
                Intrinsics.checkNotNullExpressionValue(lifecycle3, "<get-lifecycle>(...)");
                eventHistoryAdapter.submitData(lifecycle3, PagingData.INSTANCE.empty());
                this$0.openBanner();
                this$0.getViewModel().reportEvent(58);
                this$0.getViewModel().setFilterEventType(DataLoadType.TYPE_KEY_PASSES);
                this$0.updateRepoListFromInput(this$0.getBinding());
                this$0.getBinding().tvEmptyLogMessage.setText(R.string.no_key_log);
                ProgressBar progress3 = this$0.getBinding().progress;
                Intrinsics.checkNotNullExpressionValue(progress3, "progress");
                progress3.setVisibility(0);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(view, this$0.getBinding().btnCodePassHistory) || this$0.getViewModel().getFilterEventType() == DataLoadType.TYPE_CODE_PASSES) {
            return;
        }
        this$0.clearSwipeController();
        EventHistoryAdapter eventHistoryAdapter5 = this$0.callHistoryAdapter;
        if (eventHistoryAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
        } else {
            eventHistoryAdapter = eventHistoryAdapter5;
        }
        Lifecycle lifecycle4 = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle4, "<get-lifecycle>(...)");
        eventHistoryAdapter.submitData(lifecycle4, PagingData.INSTANCE.empty());
        this$0.openBanner();
        this$0.getViewModel().setFilterEventType(DataLoadType.TYPE_CODE_PASSES);
        this$0.updateRepoListFromInput(this$0.getBinding());
        this$0.getBinding().tvEmptyLogMessage.setText(R.string.no_code_pass_log);
        ProgressBar progress4 = this$0.getBinding().progress;
        Intrinsics.checkNotNullExpressionValue(progress4, "progress");
        progress4.setVisibility(0);
    }

    private final void clearSwipeController() {
        RecyclerView recyclerView = getBinding().rvEventLog;
        clearSwipeController$lambda$8$touch(recyclerView, 0);
        clearSwipeController$lambda$8$touch(recyclerView, 1);
    }

    private static final void clearSwipeController$lambda$8$touch(RecyclerView recyclerView, int i) {
        recyclerView.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 100, i, 0.0f, 0.0f, 0));
    }

    private final void provideUiChanges() {
        EventHistoryAdapter eventHistoryAdapter = this.callHistoryAdapter;
        if (eventHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
            eventHistoryAdapter = null;
        }
        eventHistoryAdapter.addLoadStateListener(new Function1<CombinedLoadStates, Unit>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$provideUiChanges$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CombinedLoadStates combinedLoadStates) {
                invoke2(combinedLoadStates);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
            
                if (r0.getType() == 1) goto L23;
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00cb, code lost:
            
                if (r0.getType() == 1) goto L44;
             */
            /* JADX WARN: Code restructure failed: missing block: B:62:0x0129, code lost:
            
                if (r0.getType() == 1) goto L62;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(androidx.paging.CombinedLoadStates r9) {
                /*
                    Method dump skipped, instructions count: 438
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryFragment$provideUiChanges$1.invoke2(androidx.paging.CombinedLoadStates):void");
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new EventHistoryFragment$provideUiChanges$2(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new EventHistoryFragment$provideUiChanges$3(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new EventHistoryFragment$provideUiChanges$4(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new EventHistoryFragment$provideUiChanges$5(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), null, null, new EventHistoryFragment$provideUiChanges$6(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), null, null, new EventHistoryFragment$provideUiChanges$7(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRemoveEventDialog(final HistoryItem item) {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.confirm_call_deletion_title).setMessage(R.string.confirm_event_deletion_text).setPositiveButton(R.string.delete_from_me, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventHistoryFragment.showRemoveEventDialog$lambda$9(HistoryItem.this, this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.delete_from_everyone, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventHistoryFragment.showRemoveEventDialog$lambda$10(HistoryItem.this, this, dialogInterface, i);
            }
        }).setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda6
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                EventHistoryFragment.showRemoveEventDialog$lambda$11(HistoryItem.this, this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoveEventDialog$lambda$9(HistoryItem item, EventHistoryFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int type = item.getType();
        if (type == 3) {
            this$0.getViewModel().reportEvent(51);
        } else if (type == 4) {
            this$0.getViewModel().reportEvent(65);
        }
        this$0.removeEvent(item, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoveEventDialog$lambda$10(HistoryItem item, EventHistoryFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int type = item.getType();
        if (type == 3) {
            this$0.getViewModel().reportEvent(52);
        } else if (type == 4) {
            this$0.getViewModel().reportEvent(66);
        }
        this$0.removeEvent(item, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoveEventDialog$lambda$11(HistoryItem item, EventHistoryFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int type = item.getType();
        if (type == 3) {
            this$0.getViewModel().reportEvent(53);
        } else if (type == 4) {
            this$0.getViewModel().reportEvent(67);
        }
        dialogInterface.dismiss();
    }

    private final void removeEvent(HistoryItem item, boolean fromEveryone) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(getViewModel()), null, null, new EventHistoryFragment$removeEvent$1(this, item, fromEveryone, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToConnectService(int eventId) {
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getEventLog())), TuplesKt.to(NavArg.REPORT_EVENT_ID, Integer.valueOf(eventId))), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAttentionCustomSnackBar(final String state) {
        int i;
        if (Intrinsics.areEqual(state, EventHistoryViewModelKt.DELETE_SNACKBAR)) {
            getViewModel().reportEvent(54);
            i = R.string.need_internet_subscription;
        } else {
            i = R.string.need_internet_subscription;
        }
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
        make.getView().setBackground(getResources().getDrawable(R.drawable.bg_rounded_dialog_16dp, null));
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                EventHistoryFragment.showAttentionCustomSnackBar$lambda$14$lambda$12(Snackbar.this, view3);
            }
        });
        bind.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                EventHistoryFragment.showAttentionCustomSnackBar$lambda$14$lambda$13(state, this, make, view3);
            }
        });
        bind.tvAttentionInfo.setText(i);
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$14$lambda$12(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$14$lambda$13(String state, EventHistoryFragment this$0, Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(state, "$state");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        if (Intrinsics.areEqual(state, EventHistoryViewModelKt.DELETE_SNACKBAR)) {
            this$0.getViewModel().reportEvent(55);
            this$0.navigateToConnectService(56);
        } else {
            this$0.getViewModel().reportEvent(63);
            this$0.navigateToConnectService(64);
        }
        snackbar.dismiss();
    }

    private final void bindState(FragmentEventLogBinding fragmentEventLogBinding, StateFlow<UiState> stateFlow, Flow<PagingData<HistoryItem>> flow, Function1<? super UiAction, Unit> function1) {
        this.callHistoryAdapter = new EventHistoryAdapter(new EventHistoryFragment$bindState$1(getViewModel()), new EventHistoryFragment$bindState$2(getViewModel()), new EventHistoryFragment$bindState$3(this), new EventHistoryFragment$bindState$4(getViewModel()));
        RecyclerView recyclerView = fragmentEventLogBinding.rvEventLog;
        EventHistoryAdapter eventHistoryAdapter = this.callHistoryAdapter;
        if (eventHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
            eventHistoryAdapter = null;
        }
        recyclerView.setAdapter(eventHistoryAdapter);
        bindList(fragmentEventLogBinding, stateFlow, flow, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeBanner() {
        getViewModel().closeBanner();
        updateRepoListFromInput(getBinding());
    }

    private final void openBanner() {
        getViewModel().setBannerClosed(false);
    }

    private final void updateRepoListFromInput(FragmentEventLogBinding fragmentEventLogBinding) {
        fragmentEventLogBinding.rvEventLog.scrollToPosition(0);
        getViewModel().getAccept().invoke(new UiAction.SwitchLoadType(getViewModel().getFilterEventType(), getViewModel().getIsBannerClosed()));
    }

    private final void bindList(FragmentEventLogBinding fragmentEventLogBinding, final StateFlow<UiState> stateFlow, Flow<PagingData<HistoryItem>> flow, final Function1<? super UiAction.Scroll, Unit> function1) {
        fragmentEventLogBinding.rvEventLog.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                if (dy != 0) {
                    function1.invoke(new UiAction.Scroll(stateFlow.getValue().getDataLoadType()));
                }
            }
        });
        EventHistoryAdapter eventHistoryAdapter = this.callHistoryAdapter;
        if (eventHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
            eventHistoryAdapter = null;
        }
        final Flow distinctUntilChangedBy = FlowKt.distinctUntilChangedBy(eventHistoryAdapter.getLoadStateFlow(), new Function1<CombinedLoadStates, LoadState>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$notLoading$1
            @Override // kotlin.jvm.functions.Function1
            public final LoadState invoke(CombinedLoadStates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSource().getRefresh();
            }
        });
        Flow<Boolean> flow2 = new Flow<Boolean>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1$2", f = "EventHistoryFragment.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1$2$1 r0 = (ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1$2$1 r0 = new ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L65
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        androidx.paging.CombinedLoadStates r5 = (androidx.paging.CombinedLoadStates) r5
                        androidx.paging.LoadStates r2 = r5.getSource()
                        androidx.paging.LoadState r2 = r2.getRefresh()
                        boolean r2 = r2 instanceof androidx.paging.LoadState.NotLoading
                        if (r2 != 0) goto L57
                        androidx.paging.LoadStates r5 = r5.getSource()
                        androidx.paging.LoadState r5 = r5.getRefresh()
                        boolean r5 = r5 instanceof androidx.paging.LoadState.Error
                        if (r5 == 0) goto L55
                        goto L57
                    L55:
                        r5 = 0
                        goto L58
                    L57:
                        r5 = r3
                    L58:
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L65
                        return r1
                    L65:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new EventHistoryFragment$bindList$2(flow2, this, null), 3, null);
        EventHistoryAdapter eventHistoryAdapter2 = this.callHistoryAdapter;
        if (eventHistoryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callHistoryAdapter");
            eventHistoryAdapter2 = null;
        }
        Flow distinctUntilChangedBy2 = FlowKt.distinctUntilChangedBy(eventHistoryAdapter2.getLoadStateFlow(), new Function1<CombinedLoadStates, LoadState>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$loading$1
            @Override // kotlin.jvm.functions.Function1
            public final LoadState invoke(CombinedLoadStates it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSource().getRefresh();
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new EventHistoryFragment$bindList$3(distinctUntilChangedBy2, this, fragmentEventLogBinding, null), 3, null);
        final StateFlow<UiState> stateFlow2 = stateFlow;
        Flow combine = FlowKt.combine(flow2, FlowKt.distinctUntilChanged(new Flow<Boolean>() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2$2", f = "EventHistoryFragment.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2$2$1 r0 = (ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2$2$1 r0 = new ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4d
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        ru.tattelecom.feature.call_history.UiState r5 = (ru.tattelecom.feature.call_history.UiState) r5
                        boolean r5 = r5.getHasNotScrolledForCurrentSearch()
                        java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4d
                        return r1
                    L4d:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryFragment$bindList$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), EventHistoryFragment$bindList$shouldScrollToTop$1.INSTANCE);
        EventHistoryFragment eventHistoryFragment = this;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(eventHistoryFragment), null, null, new EventHistoryFragment$bindList$4(flow, this, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(eventHistoryFragment), null, null, new EventHistoryFragment$bindList$5(combine, fragmentEventLogBinding, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object bindList$and(boolean z, boolean z2, Continuation continuation) {
        return Boxing.boxBoolean(z & z2);
    }
}
