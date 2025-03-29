package ru.tattelecom.intercom.feature.office_map.main;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ResolvableApiException;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationServices;
import com.huawei.hms.location.LocationSettingsRequest;
import com.huawei.hms.location.LocationSettingsResponse;
import com.huawei.hms.location.SettingsClient;
import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.SupportMapFragment;
import com.huawei.hms.maps.UiSettings;
import com.huawei.hms.maps.model.BitmapDescriptor;
import com.huawei.hms.maps.model.BitmapDescriptorFactory;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.Marker;
import com.huawei.hms.maps.model.MarkerOptions;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.data.remote.model.OfficeLatlong;
import ru.tattelecom.intercom.data.remote.model.OfficeResponse;
import ru.tattelecom.intercom.data.remote.model.OfficeSchedule;
import ru.tattelecom.intercom.feature.office_map.R;
import ru.tattelecom.intercom.feature.office_map.databinding.FragmentHuaweiMapBinding;

/* compiled from: HuaweiMapFragment.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001c\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020$H\u0002J(\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020\t2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\u0010\u00100\u001a\u0002012\u0006\u0010!\u001a\u00020\"H\u0002J\b\u00102\u001a\u00020,H\u0002J\u0012\u00103\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u0014H\u0016J\u0010\u00108\u001a\u0002012\u0006\u00109\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020,H\u0002J\u001a\u0010@\u001a\u00020,2\u0010\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010C\u0018\u00010BH\u0002J\b\u0010D\u001a\u00020,H\u0002J\b\u0010E\u001a\u00020,H\u0002R(\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\t \n*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00180\u00180\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006F"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/main/HuaweiMapFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/huawei/hms/maps/HuaweiMap$OnMarkerClickListener;", "Landroid/view/View$OnClickListener;", "Lcom/huawei/hms/maps/OnMapReadyCallback;", "()V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "binding", "Lru/tattelecom/intercom/feature/office_map/databinding/FragmentHuaweiMapBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/office_map/databinding/FragmentHuaweiMapBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "fusedLocationClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "mMap", "Lcom/huawei/hms/maps/HuaweiMap;", "officeServiceAdapter", "Lru/tattelecom/intercom/feature/office_map/main/OfficeServiceAdapter;", "resolutionForResult", "Landroidx/activity/result/IntentSenderRequest;", "viewModel", "Lru/tattelecom/intercom/feature/office_map/main/MapViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/office_map/main/MapViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bitmapDescriptorFromVector", "Lcom/huawei/hms/maps/model/BitmapDescriptor;", "context", "Landroid/content/Context;", "vectorDrawableResourceId", "", "calculateDistance", "", "lat", "lng", "currentLat", "currentLng", "getLastKnownLocation", "", "getStatus", "schedule", "Lru/tattelecom/intercom/data/remote/model/OfficeSchedule;", "isLocationEnabled", "", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onMapReady", "huaweiMap", "onMarkerClick", "marker", "Lcom/huawei/hms/maps/model/Marker;", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "provideUiChanges", "renderOffices", "officeList", "", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "requestLocationSwitchOn", "setUi", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class HuaweiMapFragment extends Fragment implements HuaweiMap.OnMarkerClickListener, View.OnClickListener, OnMapReadyCallback {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HuaweiMapFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/office_map/databinding/FragmentHuaweiMapBinding;", 0))};
    private final ActivityResultLauncher<String[]> activityResultLauncher;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private FusedLocationProviderClient fusedLocationClient;
    private HuaweiMap mMap;
    private OfficeServiceAdapter officeServiceAdapter;
    private final ActivityResultLauncher<IntentSenderRequest> resolutionForResult;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public HuaweiMapFragment() {
        super(R.layout.fragment_huawei_map);
        final HuaweiMapFragment huaweiMapFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(huaweiMapFragment, FragmentHuaweiMapBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<MapViewModel>() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$special$$inlined$viewModel$default$2
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
        ActivityResultLauncher<IntentSenderRequest> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartIntentSenderForResult(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HuaweiMapFragment.resolutionForResult$lambda$0(HuaweiMapFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.resolutionForResult = registerForActivityResult;
        ActivityResultLauncher<String[]> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                HuaweiMapFragment.activityResultLauncher$lambda$4(HuaweiMapFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.activityResultLauncher = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentHuaweiMapBinding getBinding() {
        return (FragmentHuaweiMapBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MapViewModel getViewModel() {
        return (MapViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resolutionForResult$lambda$0(HuaweiMapFragment this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.fusedLocationClient = LocationServices.getFusedLocationProviderClient(this$0.requireContext());
            this$0.getLastKnownLocation();
            HuaweiMap huaweiMap = this$0.mMap;
            if (huaweiMap != null) {
                huaweiMap.setMyLocationEnabled(true);
            }
            this$0.getBinding().btnLocation.setImageDrawable(ContextCompat.getDrawable(this$0.requireContext(), R.drawable.ic_location));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activityResultLauncher$lambda$4(final HuaweiMapFragment this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Iterator it = map.entrySet().iterator();
            boolean z = true;
            while (it.hasNext()) {
                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    z = false;
                }
            }
            if (z) {
                this$0.getViewModel().setLocationPermissionGranted(true);
                Fragment findFragmentById = this$0.getChildFragmentManager().findFragmentById(R.id.huawei_map);
                Intrinsics.checkNotNull(findFragmentById, "null cannot be cast to non-null type com.huawei.hms.maps.SupportMapFragment");
                ((SupportMapFragment) findFragmentById).getMapAsync(this$0);
                return;
            }
            Fragment findFragmentById2 = this$0.getChildFragmentManager().findFragmentById(R.id.huawei_map);
            Intrinsics.checkNotNull(findFragmentById2, "null cannot be cast to non-null type com.huawei.hms.maps.SupportMapFragment");
            ((SupportMapFragment) findFragmentById2).getMapAsync(this$0);
            if (this$0.getViewModel().getIsFirstOpen() || this$0.getViewModel().getIsLocationPermissionGranted()) {
                return;
            }
            new MaterialAlertDialogBuilder(this$0.requireContext()).setMessage(R.string.request_map_permission).setPositiveButton(R.string.setting, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda16
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    HuaweiMapFragment.activityResultLauncher$lambda$4$lambda$2(HuaweiMapFragment.this, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this$0.requireContext(), this$0.getString(R.string.cant_resolve_map), 0).show();
            this$0.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void activityResultLauncher$lambda$4$lambda$2(HuaweiMapFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        FragmentActivity activity = this$0.getActivity();
        intent.setData(Uri.fromParts("package", activity != null ? activity.getPackageName() : null, null));
        this$0.startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        this.officeServiceAdapter = new OfficeServiceAdapter(new HuaweiMapFragment$setUi$1(getViewModel()));
        final FragmentHuaweiMapBinding binding = getBinding();
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        HuaweiMapFragment huaweiMapFragment = this;
        ToolbarKt.setupWithNavController(toolbar, FragmentKt.findNavController(huaweiMapFragment), new AppBarConfiguration.Builder(FragmentKt.findNavController(huaweiMapFragment).getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new HuaweiMapFragment$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$setUi$lambda$8$$inlined$AppBarConfiguration$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).build());
        binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuaweiMapFragment.setUi$lambda$8$lambda$5(HuaweiMapFragment.this, view);
            }
        });
        RecyclerView recyclerView = binding.rvFilter;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 0, false));
        recyclerView.setAdapter(this.officeServiceAdapter);
        binding.btnLocation.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuaweiMapFragment.setUi$lambda$8$lambda$7(HuaweiMapFragment.this, view);
            }
        });
        binding.btnRoute.setOnClickListener(this);
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireContext());
        ExtensionsKt.registerOnBackPressedCallback(huaweiMapFragment, new Function1<OnBackPressedCallback, Unit>() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$setUi$2$4
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
                Intrinsics.checkNotNullParameter(registerOnBackPressedCallback, "$this$registerOnBackPressedCallback");
                HuaweiMapFragment.this.onBackPressed();
            }
        });
        binding.motionLayout.setTransitionListener(new MotionLayout.TransitionListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$setUi$2$transitionListener$1
            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionStarted(MotionLayout p0, int p1, int p2) {
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionTrigger(MotionLayout p0, int p1, boolean p2, float p3) {
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionChange(MotionLayout p0, int startId, int endId, float progress) {
                Window window = HuaweiMapFragment.this.requireActivity().getWindow();
                Object evaluate = new ArgbEvaluator().evaluate(progress, Integer.valueOf(ContextCompat.getColor(HuaweiMapFragment.this.requireContext(), R.color.app_bar_scrim)), Integer.valueOf(ContextCompat.getColor(HuaweiMapFragment.this.requireContext(), R.color.bottom_sheet_shadow)));
                Intrinsics.checkNotNull(evaluate, "null cannot be cast to non-null type kotlin.Int");
                window.setStatusBarColor(((Integer) evaluate).intValue());
                if (progress > 0.1f) {
                    binding.tvAddress.setMaxLines(Integer.MAX_VALUE);
                } else {
                    binding.tvAddress.setMaxLines(2);
                }
            }

            @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
            public void onTransitionCompleted(MotionLayout p0, int currentId) {
                if (currentId == R.id.end) {
                    View shadow = binding.shadow;
                    Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
                    shadow.setVisibility(0);
                    HuaweiMapFragment.this.requireActivity().getWindow().setStatusBarColor(ContextCompat.getColor(HuaweiMapFragment.this.requireContext(), R.color.bottom_sheet_shadow));
                    return;
                }
                View shadow2 = binding.shadow;
                Intrinsics.checkNotNullExpressionValue(shadow2, "shadow");
                shadow2.setVisibility(8);
                HuaweiMapFragment.this.requireActivity().getWindow().setStatusBarColor(ContextCompat.getColor(HuaweiMapFragment.this.requireContext(), R.color.app_bar_scrim));
            }
        });
        this.activityResultLauncher.launch(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$5(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$7(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLastKnownLocation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackPressed() {
        Object obj;
        ConstraintLayout bottomSheet = getBinding().bottomSheet;
        Intrinsics.checkNotNullExpressionValue(bottomSheet, "bottomSheet");
        if (bottomSheet.getVisibility() == 0) {
            View shadow = getBinding().shadow;
            Intrinsics.checkNotNullExpressionValue(shadow, "shadow");
            shadow.setVisibility(8);
            requireActivity().getWindow().setStatusBarColor(ContextCompat.getColor(requireContext(), R.color.modal_bg));
            ConstraintLayout bottomSheet2 = getBinding().bottomSheet;
            Intrinsics.checkNotNullExpressionValue(bottomSheet2, "bottomSheet");
            bottomSheet2.setVisibility(8);
            getBinding().motionLayout.setProgress(0.0f);
            if (getViewModel().getCurrentSelectedMarker() != null) {
                Iterator<T> it = getViewModel().getHuaweiMarkers().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    Marker marker = (Marker) next;
                    if (Intrinsics.areEqual(marker != null ? marker.getTag() : null, getViewModel().getCurrentSelectedMarker())) {
                        obj = next;
                        break;
                    }
                }
                Marker marker2 = (Marker) obj;
                if (marker2 != null) {
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    marker2.setIcon(bitmapDescriptorFromVector(requireContext, R.drawable.ic_point_default));
                    return;
                }
                return;
            }
            return;
        }
        FragmentKt.findNavController(this).navigateUp();
    }

    private final void provideUiChanges() {
        MapViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new HuaweiMapFragment$provideUiChanges$1$1(viewModel, this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new HuaweiMapFragment$provideUiChanges$1$2(viewModel, this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new HuaweiMapFragment$provideUiChanges$1$3(this, null), 3, null);
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEventShowMessage(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new HuaweiMapFragment$provideUiChanges$1$4(this, null));
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4));
    }

    @Override // com.huawei.hms.maps.OnMapReadyCallback
    public void onMapReady(HuaweiMap huaweiMap) {
        UiSettings uiSettings;
        Intrinsics.checkNotNullParameter(huaweiMap, "huaweiMap");
        this.mMap = huaweiMap;
        UiSettings uiSettings2 = huaweiMap != null ? huaweiMap.getUiSettings() : null;
        if (uiSettings2 != null) {
            uiSettings2.setMyLocationButtonEnabled(false);
        }
        HuaweiMap huaweiMap2 = this.mMap;
        UiSettings uiSettings3 = huaweiMap2 != null ? huaweiMap2.getUiSettings() : null;
        if (uiSettings3 != null) {
            uiSettings3.setZoomControlsEnabled(false);
        }
        HuaweiMap huaweiMap3 = this.mMap;
        UiSettings uiSettings4 = huaweiMap3 != null ? huaweiMap3.getUiSettings() : null;
        if (uiSettings4 != null) {
            uiSettings4.setCompassEnabled(false);
        }
        HuaweiMap huaweiMap4 = this.mMap;
        if (huaweiMap4 != null) {
            huaweiMap4.setOnMarkerClickListener(this);
        }
        getViewModel().setMapReady(true);
        if (getViewModel().getIsFirstOpen()) {
            getViewModel().setFirstOpen(false);
            if (getViewModel().getIsLocationPermissionGranted()) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                if (!isLocationEnabled(requireContext)) {
                    HuaweiMap huaweiMap5 = this.mMap;
                    if (huaweiMap5 != null) {
                        huaweiMap5.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(55.787838d, 49.123274d), 14.0f));
                    }
                    getViewModel().fetchOfficeList();
                    getBinding().btnLocation.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HuaweiMapFragment.onMapReady$lambda$11(HuaweiMapFragment.this, view);
                        }
                    });
                } else {
                    getLastKnownLocation();
                    HuaweiMap huaweiMap6 = this.mMap;
                    if (huaweiMap6 != null) {
                        huaweiMap6.setMyLocationEnabled(true);
                    }
                    HuaweiMap huaweiMap7 = this.mMap;
                    uiSettings = huaweiMap7 != null ? huaweiMap7.getUiSettings() : null;
                    if (uiSettings != null) {
                        uiSettings.setMyLocationButtonEnabled(false);
                    }
                    getBinding().btnLocation.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_location));
                }
            } else {
                getBinding().btnLocation.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_location_disabled));
                getBinding().btnLocation.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HuaweiMapFragment.onMapReady$lambda$12(HuaweiMapFragment.this, view);
                    }
                });
                getViewModel().fetchOfficeList();
                HuaweiMap huaweiMap8 = this.mMap;
                if (huaweiMap8 != null) {
                    huaweiMap8.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(55.787838d, 49.123274d), 14.0f));
                }
            }
        } else if (getViewModel().getIsLocationPermissionGranted()) {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            if (!isLocationEnabled(requireContext2)) {
                requestLocationSwitchOn();
            } else {
                getLastKnownLocation();
                HuaweiMap huaweiMap9 = this.mMap;
                if (huaweiMap9 != null) {
                    huaweiMap9.setMyLocationEnabled(true);
                }
                HuaweiMap huaweiMap10 = this.mMap;
                uiSettings = huaweiMap10 != null ? huaweiMap10.getUiSettings() : null;
                if (uiSettings != null) {
                    uiSettings.setMyLocationButtonEnabled(false);
                }
                getBinding().btnLocation.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_location));
            }
        } else {
            getBinding().btnLocation.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_location_disabled));
            getViewModel().fetchOfficeList();
            getBinding().btnLocation.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HuaweiMapFragment.onMapReady$lambda$13(HuaweiMapFragment.this, view);
                }
            });
        }
        HuaweiMap huaweiMap11 = this.mMap;
        if (huaweiMap11 != null) {
            huaweiMap11.setOnMapClickListener(new HuaweiMap.OnMapClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda11
                @Override // com.huawei.hms.maps.HuaweiMap.OnMapClickListener
                public final void onMapClick(LatLng latLng) {
                    HuaweiMapFragment.onMapReady$lambda$15(HuaweiMapFragment.this, latLng);
                }
            });
        }
        FragmentHuaweiMapBinding binding = getBinding();
        binding.btnZoomPlus.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuaweiMapFragment.onMapReady$lambda$18$lambda$16(HuaweiMapFragment.this, view);
            }
        });
        binding.btnZoomMinus.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HuaweiMapFragment.onMapReady$lambda$18$lambda$17(HuaweiMapFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$11(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requestLocationSwitchOn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$12(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activityResultLauncher.launch(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$13(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.activityResultLauncher.launch(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$15(HuaweiMapFragment this$0, LatLng latLng) {
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ConstraintLayout bottomSheet = this$0.getBinding().bottomSheet;
        Intrinsics.checkNotNullExpressionValue(bottomSheet, "bottomSheet");
        if (bottomSheet.getVisibility() == 0) {
            ConstraintLayout bottomSheet2 = this$0.getBinding().bottomSheet;
            Intrinsics.checkNotNullExpressionValue(bottomSheet2, "bottomSheet");
            bottomSheet2.setVisibility(8);
        }
        if (this$0.getViewModel().getCurrentSelectedMarker() != null) {
            Iterator<T> it = this$0.getViewModel().getHuaweiMarkers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                Marker marker = (Marker) obj;
                if (Intrinsics.areEqual(marker != null ? marker.getTag() : null, this$0.getViewModel().getCurrentSelectedMarker())) {
                    break;
                }
            }
            Marker marker2 = (Marker) obj;
            if (marker2 != null) {
                Context requireContext = this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                marker2.setIcon(this$0.bitmapDescriptorFromVector(requireContext, R.drawable.ic_point_default));
            }
            this$0.getViewModel().setCurrentSelectedMarker(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$18$lambda$16(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MapViewModel viewModel = this$0.getViewModel();
        viewModel.setCurrentZoom(viewModel.getCurrentZoom() + 1.0f);
        HuaweiMap huaweiMap = this$0.mMap;
        if (huaweiMap != null) {
            huaweiMap.animateCamera(CameraUpdateFactory.zoomBy(1.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMapReady$lambda$18$lambda$17(HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MapViewModel viewModel = this$0.getViewModel();
        viewModel.setCurrentZoom(viewModel.getCurrentZoom() - 1.0f);
        HuaweiMap huaweiMap = this$0.mMap;
        if (huaweiMap != null) {
            huaweiMap.animateCamera(CameraUpdateFactory.zoomBy(-1.0f));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0291  */
    @Override // com.huawei.hms.maps.HuaweiMap.OnMarkerClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onMarkerClick(com.huawei.hms.maps.model.Marker r18) {
        /*
            Method dump skipped, instructions count: 904
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment.onMarkerClick(com.huawei.hms.maps.model.Marker):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMarkerClick$lambda$24$lambda$23$lambda$22(FragmentHuaweiMapBinding this_apply, HuaweiMapFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + ((Object) this_apply.btnPhoneNumber.getText())));
        this$0.startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Object obj;
        Iterator<T> it = getViewModel().getGoogleMarkers().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            com.google.android.gms.maps.model.Marker marker = (com.google.android.gms.maps.model.Marker) obj;
            if (Intrinsics.areEqual(getViewModel().getCurrentSelectedMarker(), marker != null ? marker.getTag() : null)) {
                break;
            }
        }
        com.google.android.gms.maps.model.Marker marker2 = (com.google.android.gms.maps.model.Marker) obj;
        com.google.android.gms.maps.model.LatLng position = marker2 != null ? marker2.getPosition() : null;
        startActivity(new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("geo:0,0?q=" + (position != null ? Double.valueOf(position.latitude) : null) + LogWriteConstants.SPLIT + (position != null ? Double.valueOf(position.longitude) : null) + " (Таттелеком)")));
    }

    private final void getLastKnownLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient != null) {
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda14
                @Override // com.huawei.hmf.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    HuaweiMapFragment.getLastKnownLocation$lambda$27$lambda$26(HuaweiMapFragment.this, (Location) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getLastKnownLocation$lambda$27$lambda$26(HuaweiMapFragment this$0, Location location) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (location != null) {
            this$0.getViewModel().setCurrentLat(Double.valueOf(location.getLatitude()));
            this$0.getViewModel().setCurrentLng(Double.valueOf(location.getLongitude()));
            this$0.getViewModel().fetchOfficeList();
            HuaweiMap huaweiMap = this$0.mMap;
            if (huaweiMap != null) {
                huaweiMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 14.0f));
                return;
            }
            return;
        }
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (!this$0.isLocationEnabled(requireContext)) {
            this$0.requestLocationSwitchOn();
        }
        this$0.getViewModel().fetchOfficeList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, com.huawei.hms.location.SettingsClient] */
    private final void requestLocationSwitchOn() {
        LocationRequest create = LocationRequest.create();
        create.setInterval(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US);
        create.setFastestInterval(50000L);
        create.setPriority(104);
        LocationSettingsRequest.Builder addLocationRequest = new LocationSettingsRequest.Builder().addLocationRequest(create);
        addLocationRequest.setAlwaysShow(false);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = LocationServices.getSettingsClient((Activity) requireActivity());
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        Task<LocationSettingsResponse> checkLocationSettings = ((SettingsClient) t).checkLocationSettings(addLocationRequest.build());
        Intrinsics.checkNotNullExpressionValue(checkLocationSettings, "checkLocationSettings(...)");
        checkLocationSettings.addOnSuccessListener(new OnSuccessListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda6
            @Override // com.huawei.hmf.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                HuaweiMapFragment.requestLocationSwitchOn$lambda$29(Ref.ObjectRef.this, this, (LocationSettingsResponse) obj);
            }
        });
        checkLocationSettings.addOnFailureListener(new OnFailureListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.HuaweiMapFragment$$ExternalSyntheticLambda7
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                HuaweiMapFragment.requestLocationSwitchOn$lambda$30(Ref.ObjectRef.this, this, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestLocationSwitchOn$lambda$29(Ref.ObjectRef client, HuaweiMapFragment this$0, LocationSettingsResponse locationSettingsResponse) {
        Intrinsics.checkNotNullParameter(client, "$client");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        client.element = null;
        this$0.getLastKnownLocation();
        HuaweiMap huaweiMap = this$0.mMap;
        if (huaweiMap != null) {
            huaweiMap.setMyLocationEnabled(true);
        }
        HuaweiMap huaweiMap2 = this$0.mMap;
        UiSettings uiSettings = huaweiMap2 != null ? huaweiMap2.getUiSettings() : null;
        if (uiSettings != null) {
            uiSettings.setMyLocationButtonEnabled(false);
        }
        this$0.getBinding().btnLocation.setImageDrawable(ContextCompat.getDrawable(this$0.requireContext(), R.drawable.ic_location));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestLocationSwitchOn$lambda$30(Ref.ObjectRef client, HuaweiMapFragment this$0, Exception exc) {
        Intrinsics.checkNotNullParameter(client, "$client");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        client.element = null;
        if (exc instanceof ResolvableApiException) {
            PendingIntent resolution = ((ResolvableApiException) exc).getResolution();
            Intrinsics.checkNotNullExpressionValue(resolution, "getResolution(...)");
            this$0.resolutionForResult.launch(new IntentSenderRequest.Builder(resolution).build());
        }
    }

    private final boolean isLocationEnabled(Context context) {
        boolean isLocationEnabled;
        if (Build.VERSION.SDK_INT < 28) {
            return Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0;
        }
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        isLocationEnabled = ((LocationManager) systemService).isLocationEnabled();
        return isLocationEnabled;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderOffices(List<OfficeResponse> officeList) {
        Marker addMarker;
        Double d;
        Double lat;
        HuaweiMap huaweiMap = this.mMap;
        if (huaweiMap != null) {
            if (huaweiMap != null) {
                huaweiMap.clear();
            }
            getViewModel().getHuaweiMarkers().clear();
            if (officeList != null) {
                for (OfficeResponse officeResponse : officeList) {
                    if (officeResponse != null) {
                        OfficeLatlong latlong = officeResponse.getLatlong();
                        double d2 = 0.0d;
                        double doubleValue = (latlong == null || (lat = latlong.getLat()) == null) ? 0.0d : lat.doubleValue();
                        OfficeLatlong latlong2 = officeResponse.getLatlong();
                        if (latlong2 != null && (d = latlong2.getLong()) != null) {
                            d2 = d.doubleValue();
                        }
                        MarkerOptions position = new MarkerOptions().position(new LatLng(doubleValue, d2));
                        if (getViewModel().getCurrentSelectedMarker() != null && Intrinsics.areEqual(getViewModel().getCurrentSelectedMarker(), officeResponse.getId())) {
                            Context requireContext = requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                            position.icon(bitmapDescriptorFromVector(requireContext, R.drawable.ic_point_active));
                            HuaweiMap huaweiMap2 = this.mMap;
                            addMarker = huaweiMap2 != null ? huaweiMap2.addMarker(position) : null;
                            if (addMarker != null) {
                                addMarker.setTag(officeResponse.getId());
                            }
                            getViewModel().setCurrentSelectedMarker(officeResponse.getId());
                            getViewModel().getHuaweiMarkers().add(addMarker);
                        } else {
                            Context requireContext2 = requireContext();
                            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                            position.icon(bitmapDescriptorFromVector(requireContext2, R.drawable.ic_point_default));
                            HuaweiMap huaweiMap3 = this.mMap;
                            addMarker = huaweiMap3 != null ? huaweiMap3.addMarker(position) : null;
                            if (addMarker != null) {
                                addMarker.setTag(officeResponse.getId());
                            }
                            getViewModel().getHuaweiMarkers().add(addMarker);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorDrawableResourceId) {
        Drawable drawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        Intrinsics.checkNotNull(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        drawable.draw(new Canvas(createBitmap));
        return BitmapDescriptorFactory.fromBitmap(createBitmap);
    }

    private final double calculateDistance(double lat, double lng, double currentLat, double currentLng) {
        Location location = new Location("");
        location.setLatitude(lat);
        location.setLongitude(lng);
        Location location2 = new Location("");
        location2.setLatitude(currentLat);
        location2.setLongitude(currentLng);
        return location.distanceTo(location2) / 1000;
    }

    private final String getStatus(OfficeSchedule schedule) {
        int i = Calendar.getInstance().get(11);
        if ((schedule != null ? schedule.getOpen() : null) != null && schedule.getClose() != null) {
            Integer open = schedule.getOpen();
            Intrinsics.checkNotNull(open);
            int intValue = open.intValue();
            Integer close = schedule.getClose();
            Intrinsics.checkNotNull(close);
            if (i <= close.intValue() && intValue <= i) {
                getBinding().tvOpenStatus.setTextColor(ContextCompat.getColor(requireContext(), R.color.green));
                return "Открыто до " + schedule.getCloseText();
            }
            getBinding().tvOpenStatus.setTextColor(ContextCompat.getColor(requireContext(), R.color.red));
            return "Закрыто";
        }
        return "";
    }
}
