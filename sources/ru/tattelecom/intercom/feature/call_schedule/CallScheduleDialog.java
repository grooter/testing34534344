package ru.tattelecom.intercom.feature.call_schedule;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
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
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.timerangepicker.OnSliderRangeMovedListener;
import ru.tattelecom.intercom.feature.call_schedule.databinding.DialogCallScheduleBinding;

/* compiled from: CallScheduleDialog.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lru/tattelecom/intercom/feature/call_schedule/CallScheduleDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/call_schedule/databinding/DialogCallScheduleBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/call_schedule/databinding/DialogCallScheduleBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "timeFormatter", "Ljava/text/SimpleDateFormat;", "viewModel", "Lru/tattelecom/intercom/feature/call_schedule/CallScheduleViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/call_schedule/CallScheduleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "provideUiChanges", "setUi", "feature-call-schedule_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallScheduleDialog extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(CallScheduleDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/call_schedule/databinding/DialogCallScheduleBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private final SimpleDateFormat timeFormatter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public CallScheduleDialog() {
        final CallScheduleDialog callScheduleDialog = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(callScheduleDialog, DialogCallScheduleBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<CallScheduleViewModel>() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final CallScheduleViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CallScheduleViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.timeFormatter = new SimpleDateFormat("HH:mm", Locale.getDefault());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final DialogCallScheduleBinding getBinding() {
        return (DialogCallScheduleBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CallScheduleViewModel getViewModel() {
        return (CallScheduleViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.NoBackgroundBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.dialog_call_schedule, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideUiChanges();
    }

    private final void setUi() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            ExtensionsKt.setExpandedState(dialog, false);
        }
        DialogCallScheduleBinding binding = getBinding();
        binding.timePicker.setOnChangeListener(new OnSliderRangeMovedListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$setUi$1$1
            @Override // ru.tattelecom.intercom.android.resources.timerangepicker.OnSliderRangeMovedListener
            public void onChange(Calendar start, Calendar end) {
                CallScheduleViewModel viewModel;
                if (start != null) {
                    CallScheduleDialog callScheduleDialog = CallScheduleDialog.this;
                    if (end != null) {
                        viewModel = callScheduleDialog.getViewModel();
                        viewModel.onTimeChanged(start, end);
                    }
                }
            }
        });
        binding.chMonday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$0(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.chTuesday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$1(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.chWednesday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$2(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.chThursday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$3(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.chFriday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$4(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.chSaturday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$5(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.chSunday.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CallScheduleDialog.setUi$lambda$9$lambda$6(CallScheduleDialog.this, compoundButton, z);
            }
        });
        binding.btnSave.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallScheduleDialog.setUi$lambda$9$lambda$7(CallScheduleDialog.this, view);
            }
        });
        binding.btnReset.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.call_schedule.CallScheduleDialog$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CallScheduleDialog.setUi$lambda$9$lambda$8(CallScheduleDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$0(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(0, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$1(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(1, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$2(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(2, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$3(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(3, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$4(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(4, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$5(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(5, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$6(CallScheduleDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayChanged(6, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$7(CallScheduleDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onSave();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$9$lambda$8(CallScheduleDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onReset();
    }

    private final void provideUiChanges() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new CallScheduleDialog$provideUiChanges$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new CallScheduleDialog$provideUiChanges$2(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new CallScheduleDialog$provideUiChanges$3(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new CallScheduleDialog$provideUiChanges$4(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), null, null, new CallScheduleDialog$provideUiChanges$5(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner6), null, null, new CallScheduleDialog$provideUiChanges$6(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner7, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner7), null, null, new CallScheduleDialog$provideUiChanges$7(this, null), 3, null);
    }
}
