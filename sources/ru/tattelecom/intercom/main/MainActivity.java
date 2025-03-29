package ru.tattelecom.intercom.main;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.ActivityNavigatorDestinationBuilder;
import androidx.navigation.AnimBuilder;
import androidx.navigation.NavActionBuilder;
import androidx.navigation.NavArgumentBuilder;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavOptionsBuilder;
import androidx.navigation.NavType;
import androidx.navigation.PopUpToBuilder;
import androidx.navigation.fragment.DialogFragmentNavigator;
import androidx.navigation.fragment.DialogFragmentNavigatorDestinationBuilder;
import androidx.navigation.fragment.FragmentNavigator;
import androidx.navigation.fragment.FragmentNavigatorDestinationBuilder;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.BottomNavigationViewKt;
import androidx.profileinstaller.ProfileVerifier;
import by.kirich1409.viewbindingdelegate.ReflectionActivityViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.appupdate.AppUpdateOptions;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.location.base.activity.constant.ActivityRecognitionConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.feature.call_history.EventHistoryFragment;
import ru.tattelecom.intercom.R;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment;
import ru.tattelecom.intercom.android.resources.customview.Tooltip;
import ru.tattelecom.intercom.android.resources.navigation.DeepLinkNavigator;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.DeepLink;
import ru.tattelecom.intercom.databinding.ActivityMainBinding;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.feature.call.CallService;
import ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog;
import ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog;
import ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.AddAddressContainerFragment;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.registration.RegistrationFragment;
import ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.GrantAccessContainerFragment;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.QRCodeFragment;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment;
import ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment;
import ru.tattelecom.intercom.feature.home.HomeBottomSheetDialog;
import ru.tattelecom.intercom.feature.home.HomeFragment;
import ru.tattelecom.intercom.feature.home.error_screen.IntercomErrorDialogFragment;
import ru.tattelecom.intercom.feature.intercom_emergency_code.IntercomEmergencyCodeDialogFragment;
import ru.tattelecom.intercom.feature.leave_order.LeaveOrderFragment;
import ru.tattelecom.intercom.feature.login.LoginFragment;
import ru.tattelecom.intercom.feature.office_map.filter.FilterFragment;
import ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment;
import ru.tattelecom.intercom.feature.office_map.main.MapFragment;
import ru.tattelecom.intercom.feature.player.PlayerActivity;
import ru.tattelecom.intercom.feature.profile.AccessManagementDialog;
import ru.tattelecom.intercom.feature.profile.ProfileFragment;
import ru.tattelecom.intercom.feature.profile_details.ProfileDetailsFragment;
import ru.tattelecom.intercom.feature.trial.TrialFragment;
import ru.tattelecom.intercom.feature.tutorial.TutorialFragment;
import ru.tattelecom.intercom.feature.verify.VerifyFragment;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog;
import ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog;
import ru.tattelecom.intercom.feature.welcome.WelcomeFragment;
import ru.tattelecom.intercom.lib_chat.ChatFragment;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020#H\u0016J\u0012\u0010,\u001a\u00020#2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020#H\u0014J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u000fH\u0014J\u0010\u00102\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0014J\b\u00103\u001a\u00020#H\u0014J\u0010\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020.H\u0014J\b\u00106\u001a\u00020#H\u0014J\b\u00107\u001a\u00020#H\u0014J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020#H\u0002J$\u0010;\u001a\u00020#*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0002J\f\u0010A\u001a\u00020#*\u00020BH\u0002J\f\u0010C\u001a\u00020\u0011*\u00020%H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006D"}, d2 = {"Lru/tattelecom/intercom/main/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "binding", "Lru/tattelecom/intercom/databinding/ActivityMainBinding;", "getBinding", "()Lru/tattelecom/intercom/databinding/ActivityMainBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "callServiceConnection", "ru/tattelecom/intercom/main/MainActivity$callServiceConnection$1", "Lru/tattelecom/intercom/main/MainActivity$callServiceConnection$1;", "callServiceIntent", "Landroid/content/Intent;", "canDispatch", "", "getCanDispatch", "()Z", "setCanDispatch", "(Z)V", "installStateUpdatedListener", "Lcom/google/android/play/core/install/InstallStateUpdatedListener;", "mainNavController", "Landroidx/navigation/NavController;", "tooltip", "Lru/tattelecom/intercom/android/resources/customview/Tooltip;", "viewModel", "Lru/tattelecom/intercom/main/MainViewModel;", "getViewModel", "()Lru/tattelecom/intercom/main/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "checkForGooglePlayUpdates", "checkForUpdates", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "setBottomNavigation", "setNavigationGraph", "showInstallSnackbarAndUnregisterListener", "addButton", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", TtmlNode.ATTR_ID, "", "title", "iconId", "animate", "Landroidx/navigation/NavOptionsBuilder;", "hasGooglePlayServices", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MainActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(MainActivity.class, "binding", "getBinding()Lru/tattelecom/intercom/databinding/ActivityMainBinding;", 0))};
    private AppUpdateManager appUpdateManager;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private final MainActivity$callServiceConnection$1 callServiceConnection;
    private Intent callServiceIntent;
    private boolean canDispatch;
    private final InstallStateUpdatedListener installStateUpdatedListener;
    private NavController mainNavController;
    private Tooltip tooltip;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setBottomNavigation$lambda$35$lambda$34$lambda$33(View view) {
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ru.tattelecom.intercom.main.MainActivity$callServiceConnection$1] */
    public MainActivity() {
        super(R.layout.activity_main);
        final MainActivity mainActivity = this;
        this.binding = ReflectionActivityViewBindings.viewBindingActivity(mainActivity, ActivityMainBinding.class, R.id.cl_root, UtilsKt.emptyVbCallback());
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        final byte b2 = 0 == true ? 1 : 0;
        this.viewModel = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MainViewModel>() { // from class: ru.tattelecom.intercom.main.MainActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.main.MainViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final MainViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                ComponentActivity componentActivity = ComponentActivity.this;
                Qualifier qualifier2 = qualifier;
                Function0 function0 = b;
                Function0 function02 = b2;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function0 == null || (defaultViewModelCreationExtras = (CreationExtras) function0.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(MainViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function02);
                return resolveViewModel;
            }
        });
        this.canDispatch = true;
        this.callServiceConnection = new ServiceConnection() { // from class: ru.tattelecom.intercom.main.MainActivity$callServiceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                MainViewModel viewModel;
                viewModel = MainActivity.this.getViewModel();
                FlowKt.launchIn(FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isWorkInForegroundEnabled(), MainActivity.this.getLifecycle(), Lifecycle.State.STARTED), new MainActivity$callServiceConnection$1$onServiceConnected$1(MainActivity.this, null)), LifecycleOwnerKt.getLifecycleScope(MainActivity.this));
            }
        };
        this.installStateUpdatedListener = new InstallStateUpdatedListener() { // from class: ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda6
            @Override // com.google.android.play.core.listener.StateUpdatedListener
            public final void onStateUpdate(InstallState installState) {
                MainActivity.installStateUpdatedListener$lambda$0(MainActivity.this, installState);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ActivityMainBinding getBinding() {
        return (ActivityMainBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MainViewModel getViewModel() {
        return (MainViewModel) this.viewModel.getValue();
    }

    public final boolean getCanDispatch() {
        return this.canDispatch;
    }

    public final void setCanDispatch(boolean z) {
        this.canDispatch = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void installStateUpdatedListener$lambda$0(MainActivity this$0, InstallState state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "state");
        if (state.installStatus() == 11) {
            this$0.showInstallSnackbarAndUnregisterListener();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Resources resources2;
        Configuration configuration = new Configuration((newBase == null || (resources2 = newBase.getResources()) == null) ? null : resources2.getConfiguration());
        configuration.fontScale = 1.0f;
        if (newBase != null && (resources = newBase.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            configuration.densityDpi = (int) (((int) displayMetrics.xdpi) * 1.2d);
        }
        applyOverrideConfiguration(configuration);
        super.attachBaseContext(newBase);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity mainActivity = this;
        this.appUpdateManager = AppUpdateManagerFactory.create(mainActivity);
        setNavigationGraph();
        setBottomNavigation();
        checkForUpdates();
        getViewModel().checkPushToken(getApplicationContext());
        this.callServiceIntent = new Intent(mainActivity, (Class<?>) CallService.class);
        MainActivity mainActivity2 = this;
        FlowKt.launchIn(FlowKt.onEach(FlowExtKt.flowWithLifecycle(getViewModel().isSessionActive(), getLifecycle(), Lifecycle.State.STARTED), new MainActivity$onCreate$1(this, null)), LifecycleOwnerKt.getLifecycleScope(mainActivity2));
        getSupportFragmentManager().setFragmentResultListener("DISPATCHER_SETTINGS", mainActivity2, new FragmentResultListener() { // from class: ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda5
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                MainActivity.onCreate$lambda$2(MainActivity.this, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(MainActivity this$0, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this$0.canDispatch = bundle.getBoolean("canDispatch", true);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        Intent intent = this.callServiceIntent;
        if (intent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callServiceIntent");
            intent = null;
        }
        bindService(intent, this.callServiceConnection, 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0 != null ? r0.getAction() : null, "android.intent.action.SEND_MULTIPLE") != false) goto L16;
     */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onResume() {
        /*
            r3 = this;
            super.onResume()
            ru.tattelecom.intercom.main.MainViewModel r0 = r3.getViewModel()
            kotlinx.coroutines.flow.MutableStateFlow r0 = r0.isSessionActive()
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L4f
            android.content.Intent r0 = r3.getIntent()
            r1 = 0
            if (r0 == 0) goto L23
            java.lang.String r0 = r0.getAction()
            goto L24
        L23:
            r0 = r1
        L24:
            java.lang.String r2 = "android.intent.action.SEND"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 != 0) goto L40
            android.content.Intent r0 = r3.getIntent()
            if (r0 == 0) goto L37
            java.lang.String r0 = r0.getAction()
            goto L38
        L37:
            r0 = r1
        L38:
            java.lang.String r2 = "android.intent.action.SEND_MULTIPLE"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L4f
        L40:
            android.content.Intent r0 = r3.getIntent()
            java.lang.String r2 = "getIntent(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r3.onNewIntent(r0)
            r3.setIntent(r1)
        L4f:
            com.google.android.play.core.appupdate.AppUpdateManager r0 = r3.appUpdateManager
            if (r0 == 0) goto L66
            com.google.android.gms.tasks.Task r1 = r0.getAppUpdateInfo()
            ru.tattelecom.intercom.main.MainActivity$onResume$1$1 r2 = new ru.tattelecom.intercom.main.MainActivity$onResume$1$1
            r2.<init>()
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda1 r0 = new ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda1
            r0.<init>()
            r1.addOnSuccessListener(r0)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.main.MainActivity.onResume():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$4$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null && this.canDispatch) {
            Object systemService = getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            View currentFocus = getCurrentFocus();
            Intrinsics.checkNotNull(currentFocus);
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        unbindService(this.callServiceConnection);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        try {
            AppUpdateManager appUpdateManager = this.appUpdateManager;
            if (appUpdateManager != null) {
                appUpdateManager.unregisterListener(this.installStateUpdatedListener);
            }
        } catch (Exception unused) {
        }
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new MainActivity$onDestroy$1(this, null), 3, null);
    }

    private final void setNavigationGraph() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.nav_host);
        Intrinsics.checkNotNull(findFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        final NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
        NavController navController = navHostFragment.getNavController();
        this.mainNavController = navController;
        NavController navController2 = null;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainNavController");
            navController = null;
        }
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostFragment.getNavController().get_navigatorProvider(), NavGraphDestinations.INSTANCE.getId(), NavGraphDestinations.Dest.INSTANCE.getHome());
        navGraphBuilder.action(NavGraphDestinations.Action.INSTANCE.getToLogIn(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getLogIn());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                        navOptions.popUpTo(NavGraphDestinations.INSTANCE.getId(), new Function1<PopUpToBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity.setNavigationGraph.1.1.1.1.1
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PopUpToBuilder popUpTo) {
                                Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                invoke2(popUpToBuilder);
                                return Unit.INSTANCE;
                            }
                        });
                    }
                });
            }
        });
        navGraphBuilder.action(NavGraphDestinations.Action.INSTANCE.getToTutorial(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getTutorial());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        navGraphBuilder.action(NavGraphDestinations.Action.INSTANCE.getToProfile(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getProfile());
            }
        });
        navGraphBuilder.action(NavGraphDestinations.Action.INSTANCE.getToHome(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getHome());
            }
        });
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getLogIn(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(LoginFragment.class));
        fragmentNavigatorDestinationBuilder.setLabel(navHostFragment.getString(R.string.welcome));
        fragmentNavigatorDestinationBuilder.action(NavGraphDestinations.Action.INSTANCE.getToRegistration(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$5$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getRegistration());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$5$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder.action(NavGraphDestinations.Action.INSTANCE.getToVerify(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$5$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getVerify());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$5$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder2 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getRegistration(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(RegistrationFragment.class));
        fragmentNavigatorDestinationBuilder2.setLabel(navHostFragment.getString(R.string.registration));
        fragmentNavigatorDestinationBuilder2.action(NavGraphDestinations.Action.INSTANCE.getToVerify(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$6$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getVerify());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$6$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder2.action(NavGraphDestinations.Action.INSTANCE.getToProfile(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$6$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                ActivityMainBinding binding;
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getProfile());
                binding = MainActivity.this.getBinding();
                BottomNavigationView bottomNav = binding.bottomNav;
                Intrinsics.checkNotNullExpressionValue(bottomNav, "bottomNav");
                bottomNav.setVisibility(0);
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$6$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit2 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder2);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder3 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getVerify(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(VerifyFragment.class));
        fragmentNavigatorDestinationBuilder3.setLabel(navHostFragment.getString(R.string.enter_sms_code));
        fragmentNavigatorDestinationBuilder3.action(NavGraphDestinations.Action.INSTANCE.getToHome(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$7$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                ActivityMainBinding binding;
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getHome());
                binding = MainActivity.this.getBinding();
                BottomNavigationView bottomNav = binding.bottomNav;
                Intrinsics.checkNotNullExpressionValue(bottomNav, "bottomNav");
                bottomNav.setVisibility(0);
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$7$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                        navOptions.popUpTo(NavGraphDestinations.Dest.INSTANCE.getLogIn(), new Function1<PopUpToBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity.setNavigationGraph.1.1.7.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                invoke2(popUpToBuilder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PopUpToBuilder popUpTo) {
                                Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                popUpTo.setInclusive(true);
                            }
                        });
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder3.action(NavGraphDestinations.Action.INSTANCE.getToGrantAccess(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$7$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getGrantAccess());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$7$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                        navOptions.popUpTo(NavGraphDestinations.Dest.INSTANCE.getGrantAccess(), new Function1<PopUpToBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity.setNavigationGraph.1.1.7.2.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                invoke2(popUpToBuilder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PopUpToBuilder popUpTo) {
                                Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                popUpTo.setInclusive(true);
                            }
                        });
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder3.action(NavGraphDestinations.Action.INSTANCE.getToLogIn(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$7$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getLogIn());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$7$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                        navOptions.popUpTo(NavGraphDestinations.Dest.INSTANCE.getLogIn(), new Function1<PopUpToBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity.setNavigationGraph.1.1.7.3.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(PopUpToBuilder popUpToBuilder) {
                                invoke2(popUpToBuilder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(PopUpToBuilder popUpTo) {
                                Intrinsics.checkNotNullParameter(popUpTo, "$this$popUpTo");
                                popUpTo.setInclusive(true);
                            }
                        });
                    }
                });
            }
        });
        Unit unit3 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder3);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder4 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getHome(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(HomeFragment.class));
        fragmentNavigatorDestinationBuilder4.setLabel(navHostFragment.getString(R.string.my_home));
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToTrial(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getTrial());
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToAddAddress(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getAddAddress());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToWelcomeScreen(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getWelcomeScreen());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$4.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToPlayer(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getPlayer());
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToCallsSchedule(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$6
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getCallsSchedule());
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToIntercomEmergencyCode(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getIntercomEmergencyCode());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$7.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToIntercomError(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getIntercomError());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$8.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToTemporaryAccess(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getTemporaryAccess());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$9.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToHomeBottomSheet(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$10
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getHomeBottomSheet());
            }
        });
        fragmentNavigatorDestinationBuilder4.action(NavGraphDestinations.Action.INSTANCE.getToVideoPlayer(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$11
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getVideoPlayer());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$8$11.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit4 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder4);
        navGraphBuilder.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getWelcomeScreen(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(WelcomeFragment.class)));
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getIntercomEmergencyCode(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(IntercomEmergencyCodeDialogFragment.class)));
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getIntercomError(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(IntercomErrorDialogFragment.class)));
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getHomeBottomSheet(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(HomeBottomSheetDialog.class));
        dialogFragmentNavigatorDestinationBuilder.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$9$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
            }
        });
        Unit unit5 = Unit.INSTANCE;
        navGraphBuilder.destination(dialogFragmentNavigatorDestinationBuilder);
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getSelectPlaybackSpeed(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(SpeedPlaybackDialog.class)));
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder5 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getInviteUser(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(InviteUserFragment.class));
        fragmentNavigatorDestinationBuilder5.setLabel(navHostFragment.getString(R.string.new_user_adding));
        Unit unit6 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder5);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder6 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getAddAddress(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(AddAddressContainerFragment.class));
        fragmentNavigatorDestinationBuilder6.setLabel(navHostFragment.getString(R.string.add_address));
        fragmentNavigatorDestinationBuilder6.action(NavGraphDestinations.Action.INSTANCE.getToRequestState(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$11$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getRequestState());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$11$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder6.action(NavGraphDestinations.Action.INSTANCE.getToScanQrCode(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$11$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getScanQrCode());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$11$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit7 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder6);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder7 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getGrantAccess(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(GrantAccessContainerFragment.class));
        fragmentNavigatorDestinationBuilder7.setLabel(navHostFragment.getString(R.string.new_user));
        fragmentNavigatorDestinationBuilder7.action(NavGraphDestinations.Action.INSTANCE.getToRequestState(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$12$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getRequestState());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$12$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder7.action(NavGraphDestinations.Action.INSTANCE.getToVerify(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$12$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getVerify());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$12$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder7.action(NavGraphDestinations.Action.INSTANCE.getToQrCode(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$12$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getQrCode());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$12$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit8 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder7);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder8 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getQrCode(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(QRCodeFragment.class));
        fragmentNavigatorDestinationBuilder8.action(NavGraphDestinations.Action.INSTANCE.getToGrantAccess(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$13$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getGrantAccess());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$13$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit9 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder8);
        navGraphBuilder.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getGenerateQrCode(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(GenerateQRCodeFragment.class)));
        navGraphBuilder.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getScanQrCode(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(ScanQRCodeFragment.class)));
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder9 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getOfficeMap(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(MapFragment.class));
        fragmentNavigatorDestinationBuilder9.setLabel(navHostFragment.getString(R.string.office_map));
        fragmentNavigatorDestinationBuilder9.action(NavGraphDestinations.Action.INSTANCE.getToOfficeMapFilter(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$14$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getOfficeMapFilter());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$14$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit10 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder9);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder10 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getOfficeMapHuawei(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(HuaweiMapFragment.class));
        fragmentNavigatorDestinationBuilder10.setLabel(navHostFragment.getString(R.string.office_map));
        fragmentNavigatorDestinationBuilder10.action(NavGraphDestinations.Action.INSTANCE.getToOfficeMapFilter(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$15$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getOfficeMapFilter());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$15$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit11 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder10);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder11 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getProfile(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(ProfileFragment.class));
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToAccessManagement(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getAccessManagement());
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToAddAddress(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getAddAddress());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToCallSettings(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getCallSettings());
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToProfileDetails(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getProfileDetails());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$4.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToOfficeMap(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$5
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getOfficeMap());
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToOfficeMapHuawei(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$6
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getOfficeMapHuawei());
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$7.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder11.action(NavGraphDestinations.Action.INSTANCE.getToChat(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getChat());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$16$8.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit12 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder11);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder12 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getProfileDetails(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(ProfileDetailsFragment.class));
        fragmentNavigatorDestinationBuilder12.setLabel(navHostFragment.getString(R.string.profile));
        fragmentNavigatorDestinationBuilder12.action(NavGraphDestinations.Action.INSTANCE.getToFaceDetect(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$17$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getFaceDetect());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$17$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit13 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder12);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder13 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getTemporaryAccess(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(TemporaryCodeFragment.class));
        fragmentNavigatorDestinationBuilder13.setLabel(navHostFragment.getString(R.string.temporary_access));
        fragmentNavigatorDestinationBuilder13.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$18$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$18$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit14 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder13);
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder2 = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getAccessManagement(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(AccessManagementDialog.class));
        dialogFragmentNavigatorDestinationBuilder2.action(NavGraphDestinations.Action.INSTANCE.getToGrantAccess(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$19$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getGrantAccess());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$19$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        dialogFragmentNavigatorDestinationBuilder2.action(NavGraphDestinations.Action.INSTANCE.getToTemporaryAccess(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$19$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getTemporaryAccess());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$19$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        dialogFragmentNavigatorDestinationBuilder2.action(NavGraphDestinations.Action.INSTANCE.getToAddAddress(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$19$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getAddAddress());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$19$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit15 = Unit.INSTANCE;
        navGraphBuilder.destination(dialogFragmentNavigatorDestinationBuilder2);
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getOfficeMapFilter(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(FilterFragment.class)));
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getDownload(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(DownloadDialog.class)));
        navGraphBuilder.destination(new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getCallSettings(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(CallSettingsDialog.class)));
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder14 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getConnectServices(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(LeaveOrderFragment.class));
        fragmentNavigatorDestinationBuilder14.setLabel(navHostFragment.getString(R.string.leave_request));
        fragmentNavigatorDestinationBuilder14.action(NavGraphDestinations.Action.INSTANCE.getToRequestState(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$20$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getRequestState());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$20$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit16 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder14);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder15 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getTrial(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(TrialFragment.class));
        fragmentNavigatorDestinationBuilder15.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$21$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$21$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit17 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder15);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder16 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getRequestState(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(RequestStateFragment.class));
        fragmentNavigatorDestinationBuilder16.action(NavGraphDestinations.Action.INSTANCE.getToChat(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$22$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getChat());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$22$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit18 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder16);
        ActivityNavigatorDestinationBuilder activityNavigatorDestinationBuilder = new ActivityNavigatorDestinationBuilder((ActivityNavigator) navGraphBuilder.getProvider().getNavigator(ActivityNavigator.class), NavGraphDestinations.Dest.INSTANCE.getPlayer());
        activityNavigatorDestinationBuilder.setActivityClass(Reflection.getOrCreateKotlinClass(PlayerActivity.class));
        Unit unit19 = Unit.INSTANCE;
        navGraphBuilder.destination(activityNavigatorDestinationBuilder);
        DialogFragmentNavigatorDestinationBuilder dialogFragmentNavigatorDestinationBuilder3 = new DialogFragmentNavigatorDestinationBuilder((DialogFragmentNavigator) navGraphBuilder.getProvider().getNavigator(DialogFragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getCallsSchedule(), (KClass<? extends DialogFragment>) Reflection.getOrCreateKotlinClass(CallScheduleDialog.class));
        dialogFragmentNavigatorDestinationBuilder3.argument(NavArg.INTERCOM_ID, new Function1<NavArgumentBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$24$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavArgumentBuilder navArgumentBuilder) {
                invoke2(navArgumentBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavArgumentBuilder argument) {
                Intrinsics.checkNotNullParameter(argument, "$this$argument");
                argument.setType(NavType.IntType);
            }
        });
        Unit unit20 = Unit.INSTANCE;
        navGraphBuilder.destination(dialogFragmentNavigatorDestinationBuilder3);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder17 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getVideoPlayer(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(VideoPlayerFragment.class));
        fragmentNavigatorDestinationBuilder17.action(NavGraphDestinations.Action.INSTANCE.getToSelectPlaybackSpeed(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getSelectPlaybackSpeed());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder17.action(NavGraphDestinations.Action.INSTANCE.getToIntercomEmergencyCode(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getIntercomEmergencyCode());
            }
        });
        fragmentNavigatorDestinationBuilder17.action(NavGraphDestinations.Action.INSTANCE.getToDownload(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getDownload());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$3.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder17.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$25$4.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit21 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder17);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder18 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getEventLog(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(EventHistoryFragment.class));
        fragmentNavigatorDestinationBuilder18.setLabel(navHostFragment.getString(R.string.event_log));
        fragmentNavigatorDestinationBuilder18.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$26$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$26$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        fragmentNavigatorDestinationBuilder18.action(NavGraphDestinations.Action.INSTANCE.getToPlayer(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$26$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getPlayer());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$26$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit22 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder18);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder19 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getTutorial(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(TutorialFragment.class));
        fragmentNavigatorDestinationBuilder19.action(NavGraphDestinations.Action.INSTANCE.getToConnectServices(), new Function1<NavActionBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$27$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NavActionBuilder navActionBuilder) {
                invoke2(navActionBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NavActionBuilder action) {
                Intrinsics.checkNotNullParameter(action, "$this$action");
                action.setDestinationId(NavGraphDestinations.Dest.INSTANCE.getConnectServices());
                final MainActivity mainActivity = MainActivity.this;
                action.navOptions(new Function1<NavOptionsBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$1$27$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NavOptionsBuilder navOptionsBuilder) {
                        invoke2(navOptionsBuilder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(NavOptionsBuilder navOptions) {
                        Intrinsics.checkNotNullParameter(navOptions, "$this$navOptions");
                        MainActivity.this.animate(navOptions);
                    }
                });
            }
        });
        Unit unit23 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder19);
        FragmentNavigatorDestinationBuilder fragmentNavigatorDestinationBuilder20 = new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getFaceDetect(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(FaceDetectFragment.class));
        fragmentNavigatorDestinationBuilder20.setLabel(navHostFragment.getString(R.string.face_detect));
        Unit unit24 = Unit.INSTANCE;
        navGraphBuilder.destination(fragmentNavigatorDestinationBuilder20);
        navGraphBuilder.destination(new FragmentNavigatorDestinationBuilder((FragmentNavigator) navGraphBuilder.getProvider().getNavigator(FragmentNavigator.class), NavGraphDestinations.Dest.INSTANCE.getChat(), (KClass<? extends Fragment>) Reflection.getOrCreateKotlinClass(ChatFragment.class)));
        Unit unit25 = Unit.INSTANCE;
        navController.setGraph(navGraphBuilder.build());
        final BottomNavigationView bottomNavigationView = getBinding().bottomNav;
        Intrinsics.checkNotNull(bottomNavigationView);
        BottomNavigationView bottomNavigationView2 = bottomNavigationView;
        NavController navController3 = this.mainNavController;
        if (navController3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainNavController");
            navController3 = null;
        }
        BottomNavigationViewKt.setupWithNavController(bottomNavigationView2, navController3);
        NavController navController4 = this.mainNavController;
        if (navController4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainNavController");
        } else {
            navController2 = navController4;
        }
        navController2.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda0
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController5, NavDestination navDestination, Bundle bundle) {
                MainActivity.setNavigationGraph$lambda$32$lambda$31$lambda$30(BottomNavigationView.this, this, navHostFragment, navController5, navDestination, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setNavigationGraph$lambda$32$lambda$31$lambda$30(BottomNavigationView this_apply, final MainActivity this$0, NavHostFragment this_with, NavController navController, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        BottomNavigationView bottomNavigationView = this_apply;
        int id = destination.getId();
        bottomNavigationView.setVisibility(id == NavGraphDestinations.Dest.INSTANCE.getHome() || id == NavGraphDestinations.Dest.INSTANCE.getProfile() || id == NavGraphDestinations.Dest.INSTANCE.getEventLog() || id == NavGraphDestinations.Dest.INSTANCE.getCallSettings() || id == NavGraphDestinations.Dest.INSTANCE.getHomeBottomSheet() || id == NavGraphDestinations.Dest.INSTANCE.getAccessManagement() ? 0 : 8);
        if (destination.getId() == NavGraphDestinations.Dest.INSTANCE.getEventLog() && this$0.getViewModel().isToolTipRequires(ConfigInteractor.ToolTips.BTN_JOURNAL)) {
            View findViewById = this_apply.findViewById(NavGraphDestinations.Dest.INSTANCE.getEventLog());
            Intrinsics.checkNotNull(findViewById);
            Tooltip.TooltipBuilder tooltipBuilder = new Tooltip.TooltipBuilder(findViewById);
            String string = this_with.getString(R.string.tooltip_journal);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Tooltip build = tooltipBuilder.setText(string).setAlignment(Tooltip.Alignment.TOP).setGravity(17).setArrowGravity(17).isOutsideTouchable(true).setOnCloseListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$setNavigationGraph$1$2$1$1
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
                    MainViewModel viewModel;
                    viewModel = MainActivity.this.getViewModel();
                    viewModel.setToolTipSeen(ConfigInteractor.ToolTips.BTN_JOURNAL);
                }
            }).build();
            this$0.tooltip = build;
            Intrinsics.checkNotNull(build);
            Tooltip.showAtCenter$default(build, 0, ExtensionsKt.getDp(-28), 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animate(NavOptionsBuilder navOptionsBuilder) {
        navOptionsBuilder.anim(new Function1<AnimBuilder, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$animate$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AnimBuilder animBuilder) {
                invoke2(animBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AnimBuilder anim) {
                Intrinsics.checkNotNullParameter(anim, "$this$anim");
                anim.setEnter(R.anim.nav_default_enter_anim);
                anim.setExit(R.anim.nav_default_exit_anim);
                anim.setPopEnter(R.anim.nav_default_pop_enter_anim);
                anim.setPopExit(R.anim.nav_default_pop_exit_anim);
            }
        });
    }

    private final void setBottomNavigation() {
        BottomNavigationView bottomNavigationView = getBinding().bottomNav;
        Intrinsics.checkNotNull(bottomNavigationView);
        addButton(bottomNavigationView, NavGraphDestinations.Dest.INSTANCE.getHome(), R.string.my_home, R.drawable.ic_home);
        addButton(bottomNavigationView, NavGraphDestinations.Dest.INSTANCE.getEventLog(), R.string.log, R.drawable.ic_book);
        addButton(bottomNavigationView, NavGraphDestinations.Dest.INSTANCE.getProfile(), R.string.profile, R.drawable.ic_profile);
        Menu menu = bottomNavigationView.getMenu();
        Intrinsics.checkNotNullExpressionValue(menu, "getMenu(...)");
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            bottomNavigationView.findViewById(menu.getItem(i).getItemId()).setOnLongClickListener(new View.OnLongClickListener() { // from class: ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean bottomNavigation$lambda$35$lambda$34$lambda$33;
                    bottomNavigation$lambda$35$lambda$34$lambda$33 = MainActivity.setBottomNavigation$lambda$35$lambda$34$lambda$33(view);
                    return bottomNavigation$lambda$35$lambda$34$lambda$33;
                }
            });
        }
    }

    private final void addButton(BottomNavigationView bottomNavigationView, int i, int i2, int i3) {
        bottomNavigationView.getMenu().add(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, i, 0, i2).setIcon(AppCompatResources.getDrawable(bottomNavigationView.getContext(), i3));
    }

    private final void checkForUpdates() {
        if (hasGooglePlayServices(this)) {
            checkForGooglePlayUpdates();
        }
    }

    private final void checkForGooglePlayUpdates() {
        final AppUpdateManager appUpdateManager = this.appUpdateManager;
        if (appUpdateManager != null) {
            Task<AppUpdateInfo> appUpdateInfo = appUpdateManager.getAppUpdateInfo();
            final Function1<AppUpdateInfo, Unit> function1 = new Function1<AppUpdateInfo, Unit>() { // from class: ru.tattelecom.intercom.main.MainActivity$checkForGooglePlayUpdates$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AppUpdateInfo appUpdateInfo2) {
                    invoke2(appUpdateInfo2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AppUpdateInfo appUpdateInfo2) {
                    InstallStateUpdatedListener installStateUpdatedListener;
                    boolean z = appUpdateInfo2.updateAvailability() == 2;
                    boolean isUpdateTypeAllowed = appUpdateInfo2.isUpdateTypeAllowed(0);
                    if (z && isUpdateTypeAllowed) {
                        try {
                            AppUpdateManager appUpdateManager2 = AppUpdateManager.this;
                            installStateUpdatedListener = this.installStateUpdatedListener;
                            appUpdateManager2.registerListener(installStateUpdatedListener);
                            AppUpdateManager.this.startUpdateFlowForResult(appUpdateInfo2, this, AppUpdateOptions.newBuilder(0).build(), 1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (appUpdateInfo2.installStatus() == 11) {
                        this.showInstallSnackbarAndUnregisterListener();
                    }
                }
            };
            appUpdateInfo.addOnSuccessListener(new OnSuccessListener() { // from class: ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda4
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    MainActivity.checkForGooglePlayUpdates$lambda$38$lambda$37(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkForGooglePlayUpdates$lambda$38$lambda$37(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Tooltip tooltip = this.tooltip;
        if (tooltip != null) {
            tooltip.dismiss();
        }
        super.onBackPressed();
    }

    private final boolean hasGooglePlayServices(Context context) {
        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance(...)");
        return googleApiAvailability.isGooglePlayServicesAvailable(context) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showInstallSnackbarAndUnregisterListener() {
        try {
            AppUpdateManager appUpdateManager = this.appUpdateManager;
            if (appUpdateManager != null) {
                appUpdateManager.unregisterListener(this.installStateUpdatedListener);
            }
        } catch (Exception unused) {
        }
        Snackbar.make(getBinding().clRoot, "Обновление загружено", ActivityRecognitionConstants.DEFAULT_DETECTION_INTERVAL_MILLIS).setAction("Установить", new View.OnClickListener() { // from class: ru.tattelecom.intercom.main.MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.showInstallSnackbarAndUnregisterListener$lambda$39(MainActivity.this, view);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInstallSnackbarAndUnregisterListener$lambda$39(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppUpdateManager appUpdateManager = this$0.appUpdateManager;
        if (appUpdateManager != null) {
            appUpdateManager.completeUpdate();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putStringArray(MainViewModel.CONSUMED_INTENTS, (String[]) getViewModel().getConsumedIntents().toArray(new String[0]));
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        String[] stringArray = savedInstanceState.getStringArray(MainViewModel.CONSUMED_INTENTS);
        if (stringArray != null) {
            CollectionsKt.addAll(getViewModel().getConsumedIntents(), stringArray);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (intent.getClipData() == null || getViewModel().getConsumedIntents().contains(intent.toString())) {
            return;
        }
        List<String> consumedIntents = getViewModel().getConsumedIntents();
        String intent2 = intent.toString();
        Intrinsics.checkNotNullExpressionValue(intent2, "toString(...)");
        consumedIntents.add(intent2);
        DeepLink deepLink = new DeepLink(DeepLinkNavigator.Companion.DeepLinkTypes.RECEIVED_IMAGE.getTypeString(), intent.getClipData());
        DeepLinkNavigator.Companion companion = DeepLinkNavigator.INSTANCE;
        NavController navController = this.mainNavController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainNavController");
            navController = null;
        }
        BottomNavigationView bottomNav = getBinding().bottomNav;
        Intrinsics.checkNotNullExpressionValue(bottomNav, "bottomNav");
        companion.navigate(navController, bottomNav, deepLink);
    }
}
