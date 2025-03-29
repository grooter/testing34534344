package ru.tattelecom.intercom.feature.home;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.databinding.SnackbarCustomAttentionBinding;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.home.databinding.FragmentHomeBinding;

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0010\u0018\u00002\u00020\u0001:\u0001FB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0003J(\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020\u00172\b\b\u0002\u0010,\u001a\u00020\u00172\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0017H\u0002J\u0012\u0010.\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020(H\u0016J\b\u00102\u001a\u00020(H\u0016J\b\u00103\u001a\u00020(H\u0016J\b\u00104\u001a\u00020(H\u0016J\u001a\u00105\u001a\u00020(2\u0006\u00106\u001a\u0002072\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020(H\u0002J\u001c\u0010;\u001a\u00020(2\b\b\u0001\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020?H\u0003J\u001e\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020\u00172\f\u0010B\u001a\b\u0012\u0004\u0012\u00020(0CH\u0002J\f\u0010D\u001a\u00020(*\u00020EH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u00170\u00170\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000e\u001a\u0004\b$\u0010%¨\u0006G"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/home/databinding/FragmentHomeBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/home/databinding/FragmentHomeBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "chatAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "getChatAlertDialog", "()Landroidx/appcompat/app/AlertDialog;", "chatAlertDialog$delegate", "Lkotlin/Lazy;", "connectionReceiver", "ru/tattelecom/intercom/feature/home/HomeFragment$connectionReceiver$1", "Lru/tattelecom/intercom/feature/home/HomeFragment$connectionReceiver$1;", "jobAnim", "Lkotlinx/coroutines/Job;", "jobAnimTrial", "pageList", "", "", "progressDialog", "Landroid/app/ProgressDialog;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "kotlin.jvm.PlatformType", "supportViewModel", "Lru/tattelecom/intercom/android/resources/SupportViewModel;", "getSupportViewModel", "()Lru/tattelecom/intercom/android/resources/SupportViewModel;", "supportViewModel$delegate", "viewModel", "Lru/tattelecom/intercom/feature/home/HomeViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/home/HomeViewModel;", "viewModel$delegate", "askNotificationPermission", "", "checkApplicationOrientation", "onChatClick", "phone", "formattedPhone", "chatAction", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "provideUiChanges", "sendApplicationVersion", "setUi", "showAttentionCustomSnackBar", "text", "", "withTitle", "", "startPhoneActivity", "phoneNumber", "onComplete", "Lkotlin/Function0;", "setTrialAnimation", "Landroid/widget/TextView;", "HomeAdapter", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomeFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HomeFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/home/databinding/FragmentHomeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: chatAlertDialog$delegate, reason: from kotlin metadata */
    private final Lazy chatAlertDialog;
    private HomeFragment$connectionReceiver$1 connectionReceiver;
    private Job jobAnim;
    private Job jobAnimTrial;
    private List<String> pageList;
    private ProgressDialog progressDialog;
    private final ActivityResultLauncher<String> requestPermissionLauncher;

    /* renamed from: supportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy supportViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX WARN: Type inference failed for: r0v13, types: [ru.tattelecom.intercom.feature.home.HomeFragment$connectionReceiver$1] */
    public HomeFragment() {
        super(R.layout.fragment_home);
        final HomeFragment homeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<HomeViewModel>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$special$$inlined$viewModel$default$2
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
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(homeFragment, FragmentHomeBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function04 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$special$$inlined$viewModel$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Qualifier qualifier2 = null;
        this.supportViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SupportViewModel>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$special$$inlined$viewModel$default$4
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
                Qualifier qualifier3 = qualifier2;
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
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier3, koinScope, (r16 & 64) != 0 ? null : function07);
                return resolveViewModel;
            }
        });
        this.pageList = CollectionsKt.listOf((Object[]) new String[]{HomeFragmentKt.INTERCOMS, HomeFragmentKt.CAMERAS, HomeFragmentKt.FAVORITES});
        this.chatAlertDialog = LazyKt.lazy(new HomeFragment$chatAlertDialog$2(this));
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda11
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HomeFragment.requestPermissionLauncher$lambda$0(HomeFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult;
        this.connectionReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$connectionReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                HomeViewModel viewModel;
                HomeViewModel viewModel2;
                viewModel = HomeFragment.this.getViewModel();
                if (Intrinsics.areEqual((Object) viewModel.isBadConnBannerClosed().getValue(), (Object) false)) {
                    viewModel2 = HomeFragment.this.getViewModel();
                    viewModel2.checkConnection(context);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HomeViewModel getViewModel() {
        return (HomeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentHomeBinding getBinding() {
        return (FragmentHomeBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportViewModel getSupportViewModel() {
        return (SupportViewModel) this.supportViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlertDialog getChatAlertDialog() {
        return (AlertDialog) this.chatAlertDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$0(HomeFragment this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.getViewModel().notificationPermissionRequested();
        } else {
            Toast.makeText(this$0.requireContext(), R.string.request_notification_permission, 0).show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        getViewModel().getAppConfig();
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        checkApplicationOrientation();
        sendApplicationVersion();
        setUi();
        provideUiChanges();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getViewModel().askNotificationPermission();
        if (Build.VERSION.SDK_INT >= 33) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.registerReceiver(this.connectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.registerReceiver(this.connectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    private final void sendApplicationVersion() {
        Context applicationContext;
        Context applicationContext2;
        Context applicationContext3;
        String str = Build.VERSION.RELEASE;
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        FragmentActivity activity = getActivity();
        Object systemService = (activity == null || (applicationContext3 = activity.getApplicationContext()) == null) ? null : applicationContext3.getSystemService("phone");
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        String networkOperatorName = telephonyManager != null ? telephonyManager.getNetworkOperatorName() : null;
        String str2 = networkOperatorName == null ? "unknown" : networkOperatorName;
        String str3 = Build.MANUFACTURER + " " + Build.MODEL;
        FragmentActivity activity2 = getActivity();
        Object systemService2 = (activity2 == null || (applicationContext2 = activity2.getApplicationContext()) == null) ? null : applicationContext2.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService2 instanceof ConnectivityManager ? (ConnectivityManager) systemService2 : null;
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        String typeName = activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : null;
        String str4 = typeName != null ? typeName : "unknown";
        String subtypeName = activeNetworkInfo != null ? activeNetworkInfo.getSubtypeName() : null;
        if (subtypeName == null) {
            subtypeName = "";
        }
        String str5 = str4 + " " + subtypeName;
        FragmentActivity activity3 = getActivity();
        Object systemService3 = (activity3 == null || (applicationContext = activity3.getApplicationContext()) == null) ? null : applicationContext.getSystemService("batterymanager");
        BatteryManager batteryManager = systemService3 instanceof BatteryManager ? (BatteryManager) systemService3 : null;
        String str6 = (batteryManager != null ? Integer.valueOf(batteryManager.getIntProperty(4)) : null) + "%";
        HomeViewModel viewModel = getViewModel();
        Intrinsics.checkNotNull(str);
        viewModel.sendApplicationVersion("1.24.0", BuildConfig.VERSION_CODE, str, valueOf, str2, str3, str5, str6);
    }

    private final void checkApplicationOrientation() {
        if (getResources().getConfiguration().orientation != 1) {
            requireActivity().setRequestedOrientation(1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.connectionReceiver);
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        requireActivity().getViewModelStore().clear();
    }

    private final void setUi() {
        getBinding().swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda12
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                HomeFragment.setUi$lambda$1(HomeFragment.this);
            }
        });
        getSupportViewModel().resetSupportContactsWithAuth();
        ProgressDialog progressDialog = new ProgressDialog(requireContext(), R.style.AppTheme_Dialog);
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda13
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                HomeFragment.setUi$lambda$3$lambda$2(HomeFragment.this, dialogInterface);
            }
        });
        this.progressDialog = progressDialog;
        FragmentHomeBinding binding = getBinding();
        MaterialToolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        HomeFragment homeFragment = this;
        ToolbarKt.setupWithNavController(toolbar, FragmentKt.findNavController(homeFragment), new AppBarConfiguration.Builder(FragmentKt.findNavController(homeFragment).getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new HomeFragment$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$setUi$lambda$10$$inlined$AppBarConfiguration$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).build());
        binding.btnBannerOpen.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.setUi$lambda$10$lambda$4(HomeFragment.this, view);
            }
        });
        binding.btnBannerClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.setUi$lambda$10$lambda$5(HomeFragment.this, view);
            }
        });
        binding.viewPager.setAdapter(new HomeAdapter());
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda2
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                HomeFragment.setUi$lambda$10$lambda$6(HomeFragment.this, tab, i);
            }
        }).attach();
        binding.viewPager.setOffscreenPageLimit(2);
        binding.btnUpdate.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.setUi$lambda$10$lambda$7(HomeFragment.this, view);
            }
        });
        binding.btnAddAddress.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.setUi$lambda$10$lambda$8(HomeFragment.this, view);
            }
        });
        binding.btnLeaveRequest.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.setUi$lambda$10$lambda$9(HomeFragment.this, view);
            }
        });
        binding.cvSupport.setOnChatClickListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$setUi$3$7
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
                HomeFragment.onChatClick$default(HomeFragment.this, null, null, null, 7, null);
            }
        });
        ExtensionsKt.setExitAppActionForBackPressedCallback(homeFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$1(HomeFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomeViewModel.onRefreshAddresses$default(this$0.getViewModel(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$3$lambda$2(HomeFragment this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onInProgressCancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$10$lambda$4(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(115);
        this$0.getViewModel().closeBanner();
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToTutorial(), BundleKt.bundleOf(TuplesKt.to(NavArg.NOT_SEEN_TIPS_ONLY, false)), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$10$lambda$5(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(116);
        this$0.getViewModel().closeBanner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$10$lambda$6(HomeFragment this$0, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(this$0.pageList.get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$10$lambda$7(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HomeViewModel.onRefreshAddresses$default(this$0.getViewModel(), null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$10$lambda$8(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentKt.findNavController(this$0).navigate(NavGraphDestinations.Action.INSTANCE.getToAddAddress());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$10$lambda$9(HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getHome())), TuplesKt.to(NavArg.REPORT_EVENT_ID, 88)), null, 4, null);
    }

    private final void provideUiChanges() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new HomeFragment$provideUiChanges$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new HomeFragment$provideUiChanges$2(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new HomeFragment$provideUiChanges$3(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new HomeFragment$provideUiChanges$4(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), null, null, new HomeFragment$provideUiChanges$5(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), null, null, new HomeFragment$provideUiChanges$6(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner7), null, null, new HomeFragment$provideUiChanges$7(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner8 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner8, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner8), null, null, new HomeFragment$provideUiChanges$8(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner9 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner9, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner9), null, null, new HomeFragment$provideUiChanges$9(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner10 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner10, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner10), null, null, new HomeFragment$provideUiChanges$10(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner11 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner11, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner11), null, null, new HomeFragment$provideUiChanges$11(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner12 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner12, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner12), null, null, new HomeFragment$provideUiChanges$12(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner13 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner13, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner13), null, null, new HomeFragment$provideUiChanges$13(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner14 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner14, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner14), null, null, new HomeFragment$provideUiChanges$14(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner15 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner15, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner15), null, null, new HomeFragment$provideUiChanges$15(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner16 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner16, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner16), null, null, new HomeFragment$provideUiChanges$16(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner17 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner17, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner17), null, null, new HomeFragment$provideUiChanges$17(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setTrialAnimation(TextView textView) {
        Job launch$default;
        Job job = this.jobAnimTrial;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        launch$default = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new HomeFragment$setTrialAnimation$1(this, textView, null), 3, null);
        this.jobAnimTrial = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (!shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS")) {
                this.requestPermissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
            } else {
                new MaterialAlertDialogBuilder(requireContext()).setMessage(R.string.notification_permission_denied).setPositiveButton(R.string.setting, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda6
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        HomeFragment.askNotificationPermission$lambda$11(HomeFragment.this, dialogInterface, i);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda7
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        HomeFragment.askNotificationPermission$lambda$12(HomeFragment.this, dialogInterface, i);
                    }
                }).show();
            }
        } else {
            getViewModel().notificationPermissionRequested();
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new HomeFragment$askNotificationPermission$3(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askNotificationPermission$lambda$11(HomeFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().notificationPermissionRequested();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        FragmentActivity activity = this$0.getActivity();
        intent.setData(Uri.fromParts("package", activity != null ? activity.getPackageName() : null, null));
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void askNotificationPermission$lambda$12(HomeFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().notificationPermissionRequested();
        dialogInterface.cancel();
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeFragment$HomeAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "(Lru/tattelecom/intercom/feature/home/HomeFragment;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class HomeAdapter extends FragmentStateAdapter {
        public HomeAdapter() {
            super(HomeFragment.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return HomeFragment.this.pageList.size();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            HomeListFragment homeListFragment = new HomeListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(HomeFragmentKt.PAGE_NAME, (String) HomeFragment.this.pageList.get(position));
            homeListFragment.setArguments(bundle);
            return homeListFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Job job = this.jobAnim;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    static /* synthetic */ void showAttentionCustomSnackBar$default(HomeFragment homeFragment, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        homeFragment.showAttentionCustomSnackBar(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAttentionCustomSnackBar(int text, boolean withTitle) {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_custom_attention, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarCustomAttentionBinding bind = SnackbarCustomAttentionBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        final Snackbar make = Snackbar.make(getBinding().clParent, "", -2);
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
        bind.tvAttentionInfo.setText(text);
        if (withTitle) {
            bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    HomeFragment.showAttentionCustomSnackBar$lambda$16$lambda$13(Snackbar.this, view3);
                }
            });
            bind.tvAttentionTitle.setVisibility(0);
            bind.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    HomeFragment.showAttentionCustomSnackBar$lambda$16$lambda$14(Snackbar.this, this, view3);
                }
            });
        } else {
            bind.clRoot.setPadding(ExtensionsKt.getDp(16), ExtensionsKt.getDp(12), ExtensionsKt.getDp(16), ExtensionsKt.getDp(12));
            bind.btnClose.setVisibility(8);
            bind.btnBecomeSubscriber.setText(R.string.good);
            bind.tvAttentionTitle.setVisibility(8);
            make.addCallback(new Snackbar.Callback() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$showAttentionCustomSnackBar$1$3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.android.material.snackbar.Snackbar.Callback, com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    HomeViewModel viewModel;
                    viewModel = HomeFragment.this.getViewModel();
                    viewModel.isBadConnBannerClosed().setValue(true);
                    super.onDismissed(transientBottomBar, event);
                }
            });
            bind.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    HomeFragment.showAttentionCustomSnackBar$lambda$16$lambda$15(Snackbar.this, view3);
                }
            });
        }
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$16$lambda$13(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$16$lambda$14(Snackbar snackbar, HomeFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        snackbar.dismiss();
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getHome())), TuplesKt.to(NavArg.REPORT_EVENT_ID, 88)), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$16$lambda$15(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    static /* synthetic */ void onChatClick$default(HomeFragment homeFragment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = SupportViewModel.DEFAULT_PHONE_NUMBER;
        }
        if ((i & 2) != 0) {
            str2 = SupportViewModel.INSTANCE.formatPhoneNumber(SupportViewModel.DEFAULT_PHONE_NUMBER);
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        homeFragment.onChatClick(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChatClick(String phone, String formattedPhone, String chatAction) {
        getViewModel().getChatConfig(phone, formattedPhone, chatAction);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPhoneActivity(String phoneNumber, Function0<Unit> onComplete) {
        try {
            startActivity(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + phoneNumber)));
        } catch (Exception unused) {
        } catch (Throwable th) {
            onComplete.invoke();
            throw th;
        }
        onComplete.invoke();
    }
}
