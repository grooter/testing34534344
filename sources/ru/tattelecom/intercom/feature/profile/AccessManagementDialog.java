package ru.tattelecom.intercom.feature.profile;

import android.os.Bundle;
import android.view.View;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.profile.databinding.DialogAccessManagementBinding;

/* compiled from: AccessManagementDialog.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/feature/profile/AccessManagementDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/profile/databinding/DialogAccessManagementBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/profile/databinding/DialogAccessManagementBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "getTheme", "", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AccessManagementDialog extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(AccessManagementDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/profile/databinding/DialogAccessManagementBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    public AccessManagementDialog() {
        super(R.layout.dialog_access_management);
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(this, DialogAccessManagementBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DialogAccessManagementBinding getBinding() {
        return (DialogAccessManagementBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.NoBackgroundBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DialogAccessManagementBinding binding = getBinding();
        binding.tvInviteUser.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.AccessManagementDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccessManagementDialog.onViewCreated$lambda$3$lambda$0(AccessManagementDialog.this, view2);
            }
        });
        binding.tvTemporaryAccess.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.AccessManagementDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccessManagementDialog.onViewCreated$lambda$3$lambda$1(AccessManagementDialog.this, view2);
            }
        });
        binding.tvAddAddress.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.AccessManagementDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AccessManagementDialog.onViewCreated$lambda$3$lambda$2(AccessManagementDialog.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$0(AccessManagementDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToGrantAccess(), null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$1(AccessManagementDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToTemporaryAccess(), null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3$lambda$2(AccessManagementDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToAddAddress(), null, null, 6, null);
    }
}
