package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.EditTextPhoneFormatter;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragmentKt;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.android.resources.customview.SwipeController;
import ru.tattelecom.intercom.android.resources.customview.SwipeControllerActions;
import ru.tattelecom.intercom.android.resources.databinding.SnackbarCustomAttentionBinding;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentInviteUserBinding;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel;

/* compiled from: InviteUserFragment.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0014\u0010 \u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010\"H\u0003J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u001aH\u0002J\b\u0010'\u001a\u00020\u001aH\u0003J\u0016\u0010(\u001a\u00020\u001a2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\b\u0010,\u001a\u00020\u001aH\u0003J\u0018\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0010H\u0002J\b\u00101\u001a\u00020\u001aH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u00062"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentInviteUserBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentInviteUserBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "guestsAdapter", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestsAdapter;", "pickContactLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "readContactPermissionLauncher", "", "", "swipeController", "Lru/tattelecom/intercom/android/resources/customview/SwipeController;", "viewModel", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "provideContactPhone", "contactUri", "Landroid/net/Uri;", "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;", "provideUiChanges", "setUi", "setupApartmentsDropDown", EntitiesKt.APARTMENTS_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "showAttentionCustomSnackBar", "showRemoveEventDialog", NavArg.VerifyCode.APARTMENT_ID, "", "phone", "startTimer", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InviteUserFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(InviteUserFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/familyaccess/databinding/FragmentInviteUserBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private GuestsAdapter guestsAdapter;
    private ActivityResultLauncher<Void> pickContactLauncher;
    private ActivityResultLauncher<String[]> readContactPermissionLauncher;
    private SwipeController swipeController;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public InviteUserFragment() {
        super(R.layout.fragment_invite_user);
        final InviteUserFragment inviteUserFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<InviteUserViewModel>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final InviteUserViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(InviteUserViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(inviteUserFragment, FragmentInviteUserBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InviteUserViewModel getViewModel() {
        return (InviteUserViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentInviteUserBinding getBinding() {
        return (FragmentInviteUserBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda5
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InviteUserFragment.onCreate$lambda$1(InviteUserFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.readContactPermissionLauncher = registerForActivityResult;
        ActivityResultLauncher<Void> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.PickContact(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                InviteUserFragment.onCreate$lambda$3(InviteUserFragment.this, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.pickContactLauncher = registerForActivityResult2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(InviteUserFragment this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) map.get("android.permission.READ_CONTACTS");
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        ActivityResultLauncher<Void> activityResultLauncher = this$0.pickContactLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pickContactLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(InviteUserFragment this$0, Uri uri) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String provideContactPhone = this$0.provideContactPhone(uri);
        if (provideContactPhone == null || provideContactPhone.length() == 0) {
            InviteUserViewModel viewModel = this$0.getViewModel();
            String string = this$0.getString(R.string.get_contact_number_error);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            viewModel.onError(string);
        }
        CustomEditTextView customEditTextView = this$0.getBinding().etPhoneNumber;
        customEditTextView.setText(provideContactPhone);
        Editable text = customEditTextView.getText();
        customEditTextView.setSelection(text != null ? text.length() : 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
        startTimer();
    }

    private final void startTimer() {
        Bundle arguments;
        Fragment parentFragment = getParentFragment();
        Integer valueOf = (parentFragment == null || (arguments = parentFragment.getArguments()) == null) ? null : Integer.valueOf(arguments.getInt("previousPage"));
        int verify = NavGraphDestinations.Dest.INSTANCE.getVerify();
        if (valueOf != null && valueOf.intValue() == verify) {
            getViewModel().startTimer();
        }
    }

    private final void setUi() {
        this.guestsAdapter = new GuestsAdapter();
        FragmentInviteUserBinding binding = getBinding();
        final CustomEditTextView customEditTextView = binding.etPhoneNumber;
        CustomEditTextView etPhoneNumber = binding.etPhoneNumber;
        Intrinsics.checkNotNullExpressionValue(etPhoneNumber, "etPhoneNumber");
        customEditTextView.addTextChangedListener(new EditTextPhoneFormatter(etPhoneNumber, "##) ###-##-##"));
        SwipeController swipeController = null;
        customEditTextView.makeClearableEditText(null, null);
        Intrinsics.checkNotNull(customEditTextView);
        customEditTextView.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$setUi$lambda$11$lambda$5$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                InviteUserViewModel viewModel;
                viewModel = InviteUserFragment.this.getViewModel();
                viewModel.onPhoneUpdate(String.valueOf(customEditTextView.getText()));
            }
        });
        binding.btnOpenContacts.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteUserFragment.setUi$lambda$11$lambda$6(InviteUserFragment.this, view);
            }
        });
        binding.btnContinue.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteUserFragment.setUi$lambda$11$lambda$9(InviteUserFragment.this, view);
            }
        });
        RecyclerView recyclerView = binding.rvGuests;
        GuestsAdapter guestsAdapter = this.guestsAdapter;
        if (guestsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guestsAdapter");
            guestsAdapter = null;
        }
        recyclerView.setAdapter(guestsAdapter);
        SwipeControllerActions swipeControllerActions = new SwipeControllerActions() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$setUi$1$4$1
            @Override // ru.tattelecom.intercom.android.resources.customview.SwipeControllerActions
            public void onClicked(int position) {
                GuestsAdapter guestsAdapter2;
                guestsAdapter2 = InviteUserFragment.this.guestsAdapter;
                if (guestsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guestsAdapter");
                    guestsAdapter2 = null;
                }
                InviteItem byPosition = guestsAdapter2.getByPosition(position);
                boolean z = byPosition instanceof GuestItem;
                if (z) {
                    GuestItem guestItem = (GuestItem) byPosition;
                    if (guestItem.isMaster()) {
                        InviteUserFragment.this.showRemoveEventDialog(guestItem.getApartmentId(), guestItem.getPhone());
                        return;
                    }
                }
                if (z) {
                    InviteUserFragment.this.showAttentionCustomSnackBar();
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
        new ItemTouchHelper(swipeController).attachToRecyclerView(binding.rvGuests);
        binding.rvGuests.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$setUi$1$4$2
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                SwipeController swipeController3;
                Intrinsics.checkNotNullParameter(c, "c");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                swipeController3 = InviteUserFragment.this.swipeController;
                if (swipeController3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("swipeController");
                    swipeController3 = null;
                }
                swipeController3.onDraw(c, parent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$11$lambda$6(InviteUserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityResultLauncher<String[]> activityResultLauncher = this$0.readContactPermissionLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("readContactPermissionLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(new String[]{"android.permission.READ_CONTACTS"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$11$lambda$9(InviteUserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Long value = this$0.getViewModel().getCurrentTime().getValue();
        if (value != null && value.longValue() > 0) {
            new MaterialAlertDialogBuilder(this$0.requireContext()).setTitle(R.string.requests_exceeded).setMessage((CharSequence) this$0.getString(R.string.please_try_again_in_45_seconds, value)).setPositiveButton(R.string.good, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).show();
        } else {
            this$0.getViewModel().onContinueClicked();
        }
    }

    private final void provideUiChanges() {
        InviteUserViewModel viewModel = getViewModel();
        Flow onEach = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.isContinueButtonAllowed(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new InviteUserFragment$provideUiChanges$1$1(this, null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        viewModel.getApartments().observe(getViewLifecycleOwner(), new InviteUserFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends ApartmentGuestsEntity>, Unit>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$provideUiChanges$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApartmentGuestsEntity> list) {
                invoke2((List<ApartmentGuestsEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApartmentGuestsEntity> list) {
                if (list != null) {
                    InviteUserFragment.this.setupApartmentsDropDown(list);
                }
            }
        }));
        viewModel.getGuests().observe(getViewLifecycleOwner(), new InviteUserFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends InviteItem>, Unit>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$provideUiChanges$1$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends InviteItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends InviteItem> list) {
                GuestsAdapter guestsAdapter;
                guestsAdapter = InviteUserFragment.this.guestsAdapter;
                if (guestsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guestsAdapter");
                    guestsAdapter = null;
                }
                guestsAdapter.submitList(list);
            }
        }));
        Flow onEach2 = FlowKt.onEach(FlowExtKt.flowWithLifecycle(viewModel.getEvents(), getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED), new InviteUserFragment$provideUiChanges$1$4(this, null));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(InviteUserViewModel.Event event) {
        if (Intrinsics.areEqual(event, InviteUserViewModel.Event.NavigateToErrorPage.INSTANCE)) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToRequestState(), BundleKt.bundleOf(TuplesKt.to(RequestStateFragmentKt.REQUEST_STATE, "error")), null, 4, null);
            return;
        }
        if (Intrinsics.areEqual(event, InviteUserViewModel.Event.NavigateToCodeVerification.INSTANCE)) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToVerify(), BundleKt.bundleOf(TuplesKt.to(NavArg.VerifyCode.APARTMENT_ID, getViewModel().getSelectedApartmentId()), TuplesKt.to(NavArg.VerifyCode.GUEST_PHONE, getViewModel().getCleanedNumber())), null, 4, null);
            return;
        }
        if (event instanceof InviteUserViewModel.Event.ShowMessage) {
            Context requireContext = requireContext();
            String message = ((InviteUserViewModel.Event.ShowMessage) event).getMessage();
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupApartmentsDropDown(final List<ApartmentGuestsEntity> apartments) {
        Object obj;
        List<ApartmentGuestsEntity> list = apartments;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ApartmentGuestsEntity) it.next()).getAddress());
        }
        ArrayList arrayList2 = arrayList;
        final ArrayAdapter arrayAdapter = new ArrayAdapter(requireActivity(), R.layout.item_dropdown_apartment, R.id.tv_apartment, arrayList2);
        final FragmentInviteUserBinding binding = getBinding();
        binding.etApartment.setAdapter(arrayAdapter);
        Editable text = binding.etApartment.getText();
        if (text != null && text.length() != 0) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (Intrinsics.areEqual(((ApartmentGuestsEntity) obj).getAddress(), binding.etApartment.getText().toString())) {
                        break;
                    }
                }
            }
            ApartmentGuestsEntity apartmentGuestsEntity = (ApartmentGuestsEntity) obj;
            if (apartmentGuestsEntity != null) {
                TextView textView = binding.tvApartment;
                String string = requireContext().getString(R.string.invited_user_count);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(apartmentGuestsEntity.getGuestPhones().size()), Integer.valueOf(apartmentGuestsEntity.getRemainingInvites())}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
        }
        binding.etApartment.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteUserFragment.setupApartmentsDropDown$lambda$18$lambda$15(InviteUserFragment.this, view);
            }
        });
        AppCompatAutoCompleteTextView etApartment = binding.etApartment;
        Intrinsics.checkNotNullExpressionValue(etApartment, "etApartment");
        etApartment.addTextChangedListener(new TextWatcher() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$setupApartmentsDropDown$lambda$18$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence text2, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence text2, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                InviteUserViewModel viewModel;
                InviteUserViewModel viewModel2;
                int position = arrayAdapter.getPosition(s != null ? s.toString() : null);
                if (position == -1) {
                    binding.tvApartment.setText(this.getString(R.string.address_for_sharing));
                    return;
                }
                ApartmentGuestsEntity apartmentGuestsEntity2 = (ApartmentGuestsEntity) apartments.get(position);
                TextView textView2 = binding.tvApartment;
                String string2 = this.requireContext().getString(R.string.invited_user_count);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(apartmentGuestsEntity2.getGuestPhones().size()), Integer.valueOf(apartmentGuestsEntity2.getRemainingInvites())}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                textView2.setText(format2);
                int remainingInvites = apartmentGuestsEntity2.getRemainingInvites();
                viewModel = this.getViewModel();
                viewModel.setRemainingInvites(remainingInvites);
                viewModel2 = this.getViewModel();
                viewModel2.setSelectedApartmentId(Integer.valueOf(apartmentGuestsEntity2.getId()));
            }
        });
        if (arrayList2.size() == 1) {
            binding.etApartment.setText((CharSequence) arrayAdapter.getItem(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupApartmentsDropDown$lambda$18$lambda$15(InviteUserFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().etApartment.showDropDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showRemoveEventDialog(final int apartmentId, final String phone) {
        new MaterialAlertDialogBuilder(requireContext()).setTitle((CharSequence) "Вы уверены?").setMessage((CharSequence) "Вы действительно хотите удалить данного пользователя?").setPositiveButton((CharSequence) "Удалить", new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                InviteUserFragment.showRemoveEventDialog$lambda$19(InviteUserFragment.this, apartmentId, phone, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRemoveEventDialog$lambda$19(InviteUserFragment this$0, int i, String phone, DialogInterface dialogInterface, int i2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(phone, "$phone");
        this$0.getViewModel().onRemoveGuest(i, phone);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAttentionCustomSnackBar() {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_custom_attention, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarCustomAttentionBinding bind = SnackbarCustomAttentionBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        final Snackbar make = Snackbar.make(getBinding().nscRoot, "", 4000);
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
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                InviteUserFragment.showAttentionCustomSnackBar$lambda$22$lambda$21(Snackbar.this, view3);
            }
        });
        TextView btnBecomeSubscriber = bind.btnBecomeSubscriber;
        Intrinsics.checkNotNullExpressionValue(btnBecomeSubscriber, "btnBecomeSubscriber");
        btnBecomeSubscriber.setVisibility(8);
        bind.tvAttentionTitle.setText(R.string.delete_not_available);
        bind.tvAttentionInfo.setText(R.string.deleting_users_available_to_the_master);
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$22$lambda$21(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    private final String provideContactPhone(Uri contactUri) {
        Cursor query;
        Cursor query2;
        if (contactUri == null || (query = requireContext().getContentResolver().query(contactUri, new String[]{"_id", "has_phone_number"}, null, null, null)) == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(query.getColumnIndex("_id"));
        int i = query.getInt(query.getColumnIndex("has_phone_number"));
        query.close();
        if (string == null || i <= 0 || (query2 = requireContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", new String[]{string}, null)) == null || !query2.moveToFirst()) {
            return null;
        }
        String string2 = query2.getString(query2.getColumnIndex("data1"));
        query2.close();
        InviteUserViewModel viewModel = getViewModel();
        Intrinsics.checkNotNull(string2);
        return viewModel.cleanContactNumber(string2);
    }
}
