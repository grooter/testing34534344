package ru.tattelecom.intercom.feature.face_detect;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
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
import ru.tattelecom.intercom.feature.face_detect.databinding.FragmentFaceDetectBinding;

/* compiled from: FaceDetectFragment.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u001dH\u0002J\b\u0010$\u001a\u00020\u001dH\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0011 \u000e*\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u00100\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/feature/face_detect/FaceDetectFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/face_detect/databinding/FragmentFaceDetectBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/face_detect/databinding/FragmentFaceDetectBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "facePhotographAdapter", "Lru/tattelecom/intercom/feature/face_detect/FacePhotographAdapter;", "makePhotoLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "requestPermissionLauncher", "", "", "viewModel", "Lru/tattelecom/intercom/feature/face_detect/FaceDetectViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/face_detect/FaceDetectViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hasWriteStoragePermission", "", "context", "Landroid/content/Context;", "onClickRequestPermission", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideUi", "setUi", "startCamera", "feature-face-detect_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class FaceDetectFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FaceDetectFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/face_detect/databinding/FragmentFaceDetectBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private FacePhotographAdapter facePhotographAdapter;
    private ActivityResultLauncher<Intent> makePhotoLauncher;
    private final ActivityResultLauncher<String[]> requestPermissionLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public FaceDetectFragment() {
        super(R.layout.fragment_face_detect);
        final FaceDetectFragment faceDetectFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(faceDetectFragment, FragmentFaceDetectBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<FaceDetectViewModel>() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final FaceDetectViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(FaceDetectViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FaceDetectFragment.makePhotoLauncher$lambda$0(FaceDetectFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.makePhotoLauncher = registerForActivityResult;
        ActivityResultLauncher<String[]> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$$ExternalSyntheticLambda3
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FaceDetectFragment.requestPermissionLauncher$lambda$5(FaceDetectFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentFaceDetectBinding getBinding() {
        return (FragmentFaceDetectBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final FaceDetectViewModel getViewModel() {
        return (FaceDetectViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void makePhotoLauncher$lambda$0(FaceDetectFragment this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (activityResult.getResultCode() == -1) {
            this$0.getViewModel().onTakePhoto();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$5(final FaceDetectFragment this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = map.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                z = false;
            }
        }
        final Context context = this$0.getContext();
        if (context != null) {
            if (z) {
                this$0.startCamera(context);
            } else {
                new MaterialAlertDialogBuilder(context).setMessage((CharSequence) "Разрешите доступ к камере и к хранилищу для возможности сделать фото").setPositiveButton((CharSequence) "Настройки", new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$$ExternalSyntheticLambda0
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FaceDetectFragment.requestPermissionLauncher$lambda$5$lambda$4$lambda$2(context, this$0, dialogInterface, i);
                    }
                }).setNegativeButton((CharSequence) "Отмена", new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$5$lambda$4$lambda$2(Context context, FaceDetectFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        this$0.startActivity(intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUi();
    }

    private final void setUi() {
        this.facePhotographAdapter = new FacePhotographAdapter(new FaceDetectFragment$setUi$1(getViewModel()));
        FragmentFaceDetectBinding binding = getBinding();
        RecyclerView recyclerView = binding.rvPhotos;
        FacePhotographAdapter facePhotographAdapter = this.facePhotographAdapter;
        if (facePhotographAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facePhotographAdapter");
            facePhotographAdapter = null;
        }
        recyclerView.setAdapter(facePhotographAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        Toolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        FaceDetectFragment faceDetectFragment = this;
        ToolbarKt.setupWithNavController(toolbar, FragmentKt.findNavController(faceDetectFragment), new AppBarConfiguration.Builder(FragmentKt.findNavController(faceDetectFragment).getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new FaceDetectFragment$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$setUi$lambda$9$$inlined$AppBarConfiguration$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).build());
        binding.btnAddPhoto.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FaceDetectFragment.setUi$lambda$9$lambda$8(FaceDetectFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$8(FaceDetectFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context != null) {
            this$0.onClickRequestPermission(context);
        }
    }

    private final void provideUi() {
        FaceDetectViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new FaceDetectFragment$provideUi$1$1(viewModel, this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new FaceDetectFragment$provideUi$1$2(viewModel, this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new FaceDetectFragment$provideUi$1$3(viewModel, this, null), 3, null);
    }

    private final void startCamera(Context context) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File createImageFile = getViewModel().createImageFile();
        if (createImageFile != null) {
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", createImageFile);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
            intent.putExtra("output", uriForFile);
            this.makePhotoLauncher.launch(intent);
        }
    }

    private final void onClickRequestPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, PermissionUtil.READ_EXTERNAL_PERMISSION) == 0 && hasWriteStoragePermission(context) && ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0) {
            startCamera(context);
        } else {
            this.requestPermissionLauncher.launch(new String[]{PermissionUtil.READ_EXTERNAL_PERMISSION, "android.permission.CAMERA"});
        }
    }

    private final boolean hasWriteStoragePermission(Context context) {
        return Build.VERSION.SDK_INT >= 29 || ContextCompat.checkSelfPermission(context, PermissionUtil.WRITE_EXTERNAL_PERMISSION) == 0;
    }
}
