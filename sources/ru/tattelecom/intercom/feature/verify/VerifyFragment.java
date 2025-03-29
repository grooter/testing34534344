package ru.tattelecom.intercom.feature.verify;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.gms.auth.api.phone.SmsRetriever;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Status;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.sms.ReadSmsManager;
import com.huawei.hms.support.sms.common.ReadSmsConstant;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.customview.CustomCodeEditText;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.verify.VerifyViewModel;
import ru.tattelecom.intercom.feature.verify.databinding.FragmentVerifyBinding;

/* compiled from: VerifyFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002\n\r\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u001a\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010\u00162\b\u0010'\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u001bH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u00061"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/verify/databinding/FragmentVerifyBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/verify/databinding/FragmentVerifyBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "googleSmsVerificationReceiver", "ru/tattelecom/intercom/feature/verify/VerifyFragment$googleSmsVerificationReceiver$1", "Lru/tattelecom/intercom/feature/verify/VerifyFragment$googleSmsVerificationReceiver$1;", "hmsSmsVerificationReceiver", "ru/tattelecom/intercom/feature/verify/VerifyFragment$hmsSmsVerificationReceiver$1", "Lru/tattelecom/intercom/feature/verify/VerifyFragment$hmsSmsVerificationReceiver$1;", "viewModel", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/verify/VerifyViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "formatPhoneNumber", "", "phoneNumber", "getAvailableServices", "", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "parseAndSetOneTimeCode", "message", "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", "provideUiChanges", "setUi", "showDialog", FirebaseAnalytics.Param.DESTINATION, "startSmsRetriever", "Companion", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public class VerifyFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(VerifyFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/verify/databinding/FragmentVerifyBinding;", 0))};
    private static final int SMS_CONSENT_REQUEST = 2;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private final VerifyFragment$googleSmsVerificationReceiver$1 googleSmsVerificationReceiver;
    private final VerifyFragment$hmsSmsVerificationReceiver$1 hmsSmsVerificationReceiver;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX WARN: Type inference failed for: r0v6, types: [ru.tattelecom.intercom.feature.verify.VerifyFragment$googleSmsVerificationReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v7, types: [ru.tattelecom.intercom.feature.verify.VerifyFragment$hmsSmsVerificationReceiver$1] */
    public VerifyFragment() {
        super(R.layout.fragment_verify);
        final VerifyFragment verifyFragment = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(verifyFragment, FragmentVerifyBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<VerifyViewModel>() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.verify.VerifyViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final VerifyViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VerifyViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.googleSmsVerificationReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$googleSmsVerificationReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Status status;
                Object parcelable;
                Object parcelable2;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (Intrinsics.areEqual(SmsRetriever.SMS_RETRIEVED_ACTION, intent.getAction())) {
                    Bundle extras = intent.getExtras();
                    Intent intent2 = null;
                    if (Build.VERSION.SDK_INT >= 33) {
                        if (extras != null) {
                            parcelable2 = extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_STATUS", Status.class);
                            status = (Status) parcelable2;
                        }
                        status = null;
                    } else {
                        if (extras != null) {
                            status = (Status) extras.getParcelable("com.google.android.gms.auth.api.phone.EXTRA_STATUS");
                        }
                        status = null;
                    }
                    Integer valueOf = status != null ? Integer.valueOf(status.getStatusCode()) : null;
                    if (valueOf != null && valueOf.intValue() == 0) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            if (extras != null) {
                                parcelable = extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT, Intent.class);
                                intent2 = (Intent) parcelable;
                            }
                        } else if (extras != null) {
                            intent2 = (Intent) extras.getParcelable(SmsRetriever.EXTRA_CONSENT_INTENT);
                        }
                        if (intent2 != null) {
                            try {
                                VerifyFragment.this.startActivityForResult(intent2, 2);
                            } catch (ActivityNotFoundException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.hmsSmsVerificationReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$hmsSmsVerificationReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                com.huawei.hms.support.api.client.Status status;
                String string;
                Object parcelable;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable = extras.getParcelable(ReadSmsConstant.EXTRA_STATUS, com.huawei.hms.support.api.client.Status.class);
                        status = (com.huawei.hms.support.api.client.Status) parcelable;
                    } else {
                        status = (com.huawei.hms.support.api.client.Status) extras.getParcelable(ReadSmsConstant.EXTRA_STATUS);
                    }
                    if (status == null || status.getStatusCode() != 0 || !extras.containsKey(ReadSmsConstant.EXTRA_SMS_MESSAGE) || (string = extras.getString(ReadSmsConstant.EXTRA_SMS_MESSAGE)) == null) {
                        return;
                    }
                    VerifyFragment.this.parseAndSetOneTimeCode(string);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentVerifyBinding getBinding() {
        return (FragmentVerifyBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VerifyViewModel getViewModel() {
        return (VerifyViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (Build.VERSION.SDK_INT >= 28) {
            startSmsRetriever();
        }
        setUi();
        provideUiChanges();
    }

    private final void startSmsRetriever() {
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireContext()) == 0) {
            SmsRetriever.getClient(requireContext()).startSmsUserConsent("TATTELECOM");
            SmsRetriever.getClient(requireContext()).startSmsUserConsent("Letai");
            IntentFilter intentFilter = new IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION);
            if (Build.VERSION.SDK_INT >= 33) {
                requireActivity().registerReceiver(this.googleSmsVerificationReceiver, intentFilter, SmsRetriever.SEND_PERMISSION, null, 2);
                return;
            } else {
                requireActivity().registerReceiver(this.googleSmsVerificationReceiver, intentFilter, SmsRetriever.SEND_PERMISSION, null);
                return;
            }
        }
        if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getContext()) == 0) {
            if (ContextCompat.checkSelfPermission(requireContext(), "android.permission.SEND_SMS") != 0) {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.SEND_SMS"}, 3);
            }
            ReadSmsManager.startConsent(requireActivity(), null);
            com.huawei.hms.framework.common.ContextCompat.registerReceiver(requireActivity(), this.hmsSmsVerificationReceiver, new IntentFilter(ReadSmsConstant.READ_SMS_BROADCAST_ACTION));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(requireContext()) == 0) {
                    requireActivity().unregisterReceiver(this.googleSmsVerificationReceiver);
                } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(getContext()) != 0) {
                } else {
                    com.huawei.hms.framework.common.ContextCompat.unregisterReceiver(requireContext(), this.hmsSmsVerificationReceiver);
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (Build.VERSION.SDK_INT < 28 || requestCode != 2 || resultCode != -1 || data == null) {
            return;
        }
        parseAndSetOneTimeCode(data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String parseAndSetOneTimeCode(String message) {
        Pattern compile = Pattern.compile("\\d{6}");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        if (message == null) {
            return null;
        }
        Matcher matcher = compile.matcher(message);
        if (matcher.find()) {
            getBinding().etCode.setText(matcher.group(0));
        }
        return matcher.group(0);
    }

    private final void setUi() {
        String str;
        Window window;
        FragmentVerifyBinding binding = getBinding();
        MaterialToolbar toolbar = binding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        VerifyFragment verifyFragment = this;
        ToolbarKt.setupWithNavController(toolbar, FragmentKt.findNavController(verifyFragment), new AppBarConfiguration.Builder(FragmentKt.findNavController(verifyFragment).getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new VerifyFragment$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$setUi$lambda$3$$inlined$AppBarConfiguration$default$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return false;
            }
        })).build());
        TextView textView = binding.tvHint;
        if (getViewModel().getApartmentId() != null && getViewModel().getGuestPhone() != null) {
            str = getString(R.string.to_confirm_registration_need_to_enter_code);
        } else {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = getString(R.string.enter_code_hint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{formatPhoneNumber(getViewModel().getPhoneNumber())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str = format;
        }
        textView.setText(str);
        CustomCodeEditText etCode = binding.etCode;
        Intrinsics.checkNotNullExpressionValue(etCode, "etCode");
        etCode.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$setUi$lambda$3$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                VerifyViewModel viewModel;
                viewModel = VerifyFragment.this.getViewModel();
                viewModel.onCodeEnter(String.valueOf(s));
            }
        });
        if (binding.etCode.requestFocus()) {
            FragmentActivity activity = getActivity();
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).showSoftInput(binding.etCode, 1);
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                window.setSoftInputMode(5);
            }
        }
        binding.btnResendCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyFragment.setUi$lambda$3$lambda$2(VerifyFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$3$lambda$2(VerifyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onResendCodeClick(ExtensionsKt.getDeviceCode(this$0));
    }

    private final void provideUiChanges() {
        VerifyViewModel viewModel = getViewModel();
        viewModel.getCode().observe(getViewLifecycleOwner(), new VerifyFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$provideUiChanges$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                FragmentVerifyBinding binding;
                VerifyViewModel viewModel2;
                int availableServices;
                VerifyViewModel viewModel3;
                binding = VerifyFragment.this.getBinding();
                VerifyFragment verifyFragment = VerifyFragment.this;
                if (!Intrinsics.areEqual(String.valueOf(binding.etCode.getText()), str)) {
                    binding.etCode.setText(str);
                }
                if (str.length() < 6) {
                    viewModel3 = verifyFragment.getViewModel();
                    viewModel3.isCodeValid().setValue(true);
                } else if (str.length() == 6) {
                    viewModel2 = verifyFragment.getViewModel();
                    availableServices = verifyFragment.getAvailableServices();
                    String deviceCode = ExtensionsKt.getDeviceCode(verifyFragment);
                    Context context = verifyFragment.getContext();
                    viewModel2.onVerifyClick(availableServices, deviceCode, context != null ? context.getApplicationContext() : null);
                }
            }
        }));
        viewModel.isCodeValid().observe(getViewLifecycleOwner(), new VerifyFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$provideUiChanges$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                FragmentVerifyBinding binding;
                VerifyViewModel viewModel2;
                String string;
                binding = VerifyFragment.this.getBinding();
                VerifyFragment verifyFragment = VerifyFragment.this;
                if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                    binding.etCode.setTag("");
                    binding.etCode.invalidate();
                    TextView tvErrorCode = binding.tvErrorCode;
                    Intrinsics.checkNotNullExpressionValue(tvErrorCode, "tvErrorCode");
                    tvErrorCode.setVisibility(8);
                    return;
                }
                if (Intrinsics.areEqual((Object) bool, (Object) false)) {
                    binding.etCode.setTag("error");
                    binding.etCode.invalidate();
                    binding.tvErrorCode.setText(verifyFragment.getString(R.string.incorrect_code));
                    TextView tvErrorCode2 = binding.tvErrorCode;
                    Intrinsics.checkNotNullExpressionValue(tvErrorCode2, "tvErrorCode");
                    tvErrorCode2.setVisibility(0);
                    TextView textView = binding.tvAttemptsLeft;
                    viewModel2 = verifyFragment.getViewModel();
                    int attemptsLeft = viewModel2.getAttemptsLeft();
                    if (attemptsLeft == 1) {
                        string = verifyFragment.getString(R.string.attempts_left_one);
                    } else if (attemptsLeft == 2) {
                        string = verifyFragment.getString(R.string.attempts_left_two);
                    } else {
                        string = verifyFragment.getString(R.string.attempts_left_zero);
                    }
                    textView.setText(string);
                    TextView tvAttemptsLeft = binding.tvAttemptsLeft;
                    Intrinsics.checkNotNullExpressionValue(tvAttemptsLeft, "tvAttemptsLeft");
                    tvAttemptsLeft.setVisibility(0);
                    return;
                }
                binding.tvErrorCode.setText(verifyFragment.getString(R.string.error));
                TextView tvErrorCode3 = binding.tvErrorCode;
                Intrinsics.checkNotNullExpressionValue(tvErrorCode3, "tvErrorCode");
                tvErrorCode3.setVisibility(0);
            }
        }));
        viewModel.getCurrentTime().observe(getViewLifecycleOwner(), new VerifyFragment$sam$androidx_lifecycle_Observer$0(new VerifyFragment$provideUiChanges$1$3(this)));
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new VerifyFragment$provideUiChanges$1$4(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(VerifyViewModel.Event event) {
        if (Intrinsics.areEqual(event, VerifyViewModel.Event.NavigateToHome.INSTANCE)) {
            Context context = getContext();
            InputMethodManager inputMethodManager = (InputMethodManager) (context != null ? context.getSystemService("input_method") : null);
            if (inputMethodManager != null) {
                View view = getView();
                inputMethodManager.hideSoftInputFromWindow(view != null ? view.getWindowToken() : null, 0);
            }
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToHome(), null, null, 6, null);
            return;
        }
        if (Intrinsics.areEqual(event, VerifyViewModel.Event.NavigateToLogin.INSTANCE)) {
            Context context2 = getContext();
            InputMethodManager inputMethodManager2 = (InputMethodManager) (context2 != null ? context2.getSystemService("input_method") : null);
            if (inputMethodManager2 != null) {
                View view2 = getView();
                inputMethodManager2.hideSoftInputFromWindow(view2 != null ? view2.getWindowToken() : null, 0);
            }
            showDialog(NavGraphDestinations.Action.INSTANCE.getToLogIn());
            return;
        }
        if (event instanceof VerifyViewModel.Event.NavigateToGrantAccess) {
            Context context3 = getContext();
            InputMethodManager inputMethodManager3 = (InputMethodManager) (context3 != null ? context3.getSystemService("input_method") : null);
            if (inputMethodManager3 != null) {
                View view3 = getView();
                inputMethodManager3.hideSoftInputFromWindow(view3 != null ? view3.getWindowToken() : null, 0);
            }
            if (((VerifyViewModel.Event.NavigateToGrantAccess) event).getSuccess()) {
                NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToGrantAccess(), null, null, 6, null);
                return;
            } else {
                showDialog(NavGraphDestinations.Action.INSTANCE.getToGrantAccess());
                return;
            }
        }
        if (event instanceof VerifyViewModel.Event.ShowMessage) {
            Context requireContext = requireContext();
            String message = ((VerifyViewModel.Event.ShowMessage) event).getMessage();
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
    }

    private final void showDialog(final int destination) {
        new MaterialAlertDialogBuilder(requireContext()).setTitle(R.string.number_of_attempts_exceeded).setMessage(R.string.return_to_auth_screen).setPositiveButton(R.string.good, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ru.tattelecom.intercom.feature.verify.VerifyFragment$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                VerifyFragment.showDialog$lambda$6(VerifyFragment.this, destination, dialogInterface);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$6(VerifyFragment this$0, int i, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), i, BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getVerify()))), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAvailableServices() {
        return (new GoogleApiAvailability().isGooglePlayServicesAvailable(requireContext()) != 0 && HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(requireContext()) == 0) ? 3 : 1;
    }

    private final String formatPhoneNumber(String phoneNumber) {
        Regex regex = new Regex("(\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})");
        String str = phoneNumber;
        if (str != null && str.length() != 0) {
            return regex.replace(str, "+$1 ($2) $3-$4-$5");
        }
        return "";
    }
}
