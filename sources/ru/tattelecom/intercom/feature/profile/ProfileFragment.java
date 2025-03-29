package ru.tattelecom.intercom.feature.profile;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
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
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.profile.databinding.FragmentProfileBinding;

/* compiled from: ProfileFragment.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001a0*H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017¨\u0006+"}, d2 = {"Lru/tattelecom/intercom/feature/profile/ProfileFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/profile/databinding/FragmentProfileBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/profile/databinding/FragmentProfileBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "chatAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "getChatAlertDialog", "()Landroidx/appcompat/app/AlertDialog;", "chatAlertDialog$delegate", "Lkotlin/Lazy;", "supportViewModel", "Lru/tattelecom/intercom/android/resources/SupportViewModel;", "getSupportViewModel", "()Lru/tattelecom/intercom/android/resources/SupportViewModel;", "supportViewModel$delegate", "viewModel", "Lru/tattelecom/intercom/feature/profile/ProfileViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/profile/ProfileViewModel;", "viewModel$delegate", "onChatClick", "", "phone", "", "formattedPhone", "chatAction", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideUiChanges", "setUi", "showLogOutDialog", "startPhoneActivity", "phoneNumber", "onComplete", "Lkotlin/Function0;", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ProfileFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ProfileFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/profile/databinding/FragmentProfileBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: chatAlertDialog$delegate, reason: from kotlin metadata */
    private final Lazy chatAlertDialog;

    /* renamed from: supportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy supportViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public ProfileFragment() {
        super(R.layout.fragment_profile);
        final ProfileFragment profileFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ProfileViewModel>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.profile.ProfileViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final ProfileViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ProfileViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(profileFragment, FragmentProfileBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function04 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$special$$inlined$viewModel$default$3
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
        this.supportViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SupportViewModel>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$special$$inlined$viewModel$default$4
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
        this.chatAlertDialog = LazyKt.lazy(new ProfileFragment$chatAlertDialog$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getViewModel() {
        return (ProfileViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentProfileBinding getBinding() {
        return (FragmentProfileBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportViewModel getSupportViewModel() {
        return (SupportViewModel) this.supportViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlertDialog getChatAlertDialog() {
        return (AlertDialog) this.chatAlertDialog.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        getSupportViewModel().resetSupportContactsWithAuth();
        FragmentProfileBinding binding = getBinding();
        Context context = getContext();
        if (context != null) {
            binding.tvAppVersion.setText(getResources().getString(R.string.app_version, context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName));
        }
        binding.toolbar.setTitle(getViewModel().formattedPhoneNumber());
        binding.tvLogOut.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$1(ProfileFragment.this, view);
            }
        });
        binding.tvAbout.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$2(ProfileFragment.this, view);
            }
        });
        binding.btnProfileDetails.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$3(ProfileFragment.this, view);
            }
        });
        binding.tvOfficeMap.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$4(ProfileFragment.this, view);
            }
        });
        binding.tvAccessManagement.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$5(ProfileFragment.this, view);
            }
        });
        binding.tvCallSettings.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$6(ProfileFragment.this, view);
            }
        });
        binding.btnMoreServices.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUi$lambda$8$lambda$7(ProfileFragment.this, view);
            }
        });
        binding.cvSupport.setOnChatClickListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$setUi$1$9
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
                ProfileFragment.onChatClick$default(ProfileFragment.this, null, null, null, 7, null);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new ProfileFragment$setUi$1$10(this, binding, null), 3, null);
        Bundle arguments = getArguments();
        if ((arguments != null ? (ClipData) arguments.getParcelable(NavArg.DEEPLINK_CLIP_DATA) : null) != null) {
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new ProfileFragment$setUi$1$11(this, binding, null), 3, null);
        }
        ExtensionsKt.setExitAppActionForBackPressedCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$1(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showLogOutDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$2(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToTutorial(), null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$3(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToProfileDetails(), null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$4(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(45);
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this$0.requireContext()) == 0) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToOfficeMap(), null, null, 6, null);
        } else {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToOfficeMapHuawei(), null, null, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$5(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().checkUserState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$6(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToCallSettings(), null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$8$lambda$7(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(7);
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToConnectServices(), BundleKt.bundleOf(TuplesKt.to("previousPage", Integer.valueOf(NavGraphDestinations.Dest.INSTANCE.getProfile()))), null, 4, null);
    }

    private final void provideUiChanges() {
        ProfileViewModel viewModel = getViewModel();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new ProfileFragment$provideUiChanges$1$1(viewModel, this, null), 3, null);
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new ProfileFragment$provideUiChanges$1$2(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2));
    }

    static /* synthetic */ void onChatClick$default(ProfileFragment profileFragment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = SupportViewModel.DEFAULT_PHONE_NUMBER;
        }
        if ((i & 2) != 0) {
            str2 = SupportViewModel.INSTANCE.formatPhoneNumber(SupportViewModel.DEFAULT_PHONE_NUMBER);
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        profileFragment.onChatClick(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChatClick(String phone, String formattedPhone, String chatAction) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(getViewModel()), null, null, new ProfileFragment$onChatClick$1(this, phone, formattedPhone, chatAction, null), 3, null);
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

    private final void showLogOutDialog() {
        new MaterialAlertDialogBuilder(requireContext(), R.style.CustomAlertDialog).setTitle(R.string.log_out_title).setMessage(R.string.log_out_confirmation).setPositiveButton(R.string.log_out, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                ProfileFragment.showLogOutDialog$lambda$11(ProfileFragment.this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLogOutDialog$lambda$11(ProfileFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onSignOutClick();
        ProfileViewModel viewModel = this$0.getViewModel();
        Context context = this$0.getContext();
        viewModel.deletePushToken(context != null ? context.getApplicationContext() : null);
    }
}
