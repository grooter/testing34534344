package ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.zxing.Result;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* compiled from: ScanQRCodeFragment.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0016J\u001a\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0011H\u0002J\b\u0010$\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/addaddress/scanqrcode/ScanQRCodeFragment;", "Landroidx/fragment/app/Fragment;", "Lme/dm7/barcodescanner/zxing/ZXingScannerView$ResultHandler;", "()V", "mScannerView", "Lme/dm7/barcodescanner/zxing/ZXingScannerView;", "requestPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "viewModel", "Lru/tattelecom/intercom/feature/familyaccess/addaddress/scanqrcode/ScanQRCodeViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/familyaccess/addaddress/scanqrcode/ScanQRCodeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleResult", "", "result", "Lcom/google/zxing/Result;", "onClickRequestPermission", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "onViewCreated", "view", "provideUiChanges", "setUi", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ScanQRCodeFragment extends Fragment implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private final ActivityResultLauncher<String> requestPermissionLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public ScanQRCodeFragment() {
        final ScanQRCodeFragment scanQRCodeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ScanQRCodeViewModel>() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final ScanQRCodeViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ScanQRCodeViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment$$ExternalSyntheticLambda2
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ScanQRCodeFragment.requestPermissionLauncher$lambda$3(ScanQRCodeFragment.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult;
    }

    private final ScanQRCodeViewModel getViewModel() {
        return (ScanQRCodeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$3(final ScanQRCodeFragment this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Context context = this$0.getContext();
        if (context == null || bool.booleanValue()) {
            return;
        }
        new MaterialAlertDialogBuilder(context).setMessage(R.string.allow_access_to_the_camera).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ScanQRCodeFragment.requestPermissionLauncher$lambda$3$lambda$2$lambda$0(context, this$0, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.addaddress.scanqrcode.ScanQRCodeFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ScanQRCodeFragment.requestPermissionLauncher$lambda$3$lambda$2$lambda$1(ScanQRCodeFragment.this, dialogInterface, i);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$3$lambda$2$lambda$0(Context context, ScanQRCodeFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$3$lambda$2$lambda$1(ScanQRCodeFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.cancel();
        FragmentKt.findNavController(this$0).navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_scan_qr_code, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        View findViewById = inflate.findViewById(R.id.contentFrame);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ZXingScannerView zXingScannerView = new ZXingScannerView(getActivity());
        this.mScannerView = zXingScannerView;
        ((ViewGroup) findViewById).addView(zXingScannerView);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        onClickRequestPermission(requireContext);
    }

    private final void provideUiChanges() {
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(getViewModel().getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new ScanQRCodeFragment$provideUiChanges$1$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ZXingScannerView zXingScannerView = this.mScannerView;
        ZXingScannerView zXingScannerView2 = null;
        if (zXingScannerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScannerView");
            zXingScannerView = null;
        }
        zXingScannerView.setResultHandler(this);
        ZXingScannerView zXingScannerView3 = this.mScannerView;
        if (zXingScannerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScannerView");
        } else {
            zXingScannerView2 = zXingScannerView3;
        }
        zXingScannerView2.startCamera();
    }

    @Override // me.dm7.barcodescanner.zxing.ZXingScannerView.ResultHandler
    public void handleResult(Result result) {
        getViewModel().sendApartmentQRToken(result != null ? result.getText() : null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ZXingScannerView zXingScannerView = this.mScannerView;
        if (zXingScannerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mScannerView");
            zXingScannerView = null;
        }
        zXingScannerView.stopCamera();
    }

    private final void onClickRequestPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") != 0) {
            this.requestPermissionLauncher.launch("android.permission.CAMERA");
        }
    }
}
