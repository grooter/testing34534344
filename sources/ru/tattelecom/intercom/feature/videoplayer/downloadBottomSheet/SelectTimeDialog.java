package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.timepicker.TimeModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.databinding.DialogSelectTimeBinding;

/* compiled from: SelectTimeDialog.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectTimeDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSelectTimeBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSelectTimeBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "viewModel", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onStart", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SelectTimeDialog extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SelectTimeDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSelectTimeBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public SelectTimeDialog() {
        super(R.layout.dialog_select_time);
        final SelectTimeDialog selectTimeDialog = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(selectTimeDialog, DialogSelectTimeBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectTimeDialog$special$$inlined$activityViewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FragmentActivity invoke() {
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return requireActivity;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DownloadViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectTimeDialog$special$$inlined$activityViewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final DownloadViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DialogSelectTimeBinding getBinding() {
        return (DialogSelectTimeBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final DownloadViewModel getViewModel() {
        return (DownloadViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.PlayerBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final DialogSelectTimeBinding binding = getBinding();
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectTimeDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectTimeDialog.onViewCreated$lambda$6$lambda$0(SelectTimeDialog.this, view2);
            }
        });
        binding.btnOk.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectTimeDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectTimeDialog.onViewCreated$lambda$6$lambda$1(SelectTimeDialog.this, binding, view2);
            }
        });
        Calendar calendar = Calendar.getInstance();
        Date value = getViewModel().getSelectedStartTime().getValue();
        calendar.setTimeInMillis(value != null ? value.getTime() : 0L);
        calendar.setTimeZone(TimeZone.getTimeZone("UTC+3"));
        int i = calendar.get(11);
        DownloadViewModel viewModel = getViewModel();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 24; i2++) {
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i2)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            arrayList.add(format);
        }
        viewModel.setHoursList(arrayList);
        binding.pickerHours.setData(getViewModel().getHoursList());
        binding.pickerHours.setSelectedItemPosition(i, false);
        int i3 = calendar.get(12);
        DownloadViewModel viewModel2 = getViewModel();
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < 60; i4++) {
            String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i4)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            arrayList2.add(format2);
        }
        viewModel2.setMinutesList(arrayList2);
        binding.pickerMinutes.setData(getViewModel().getMinutesList());
        binding.pickerMinutes.setSelectedItemPosition(i3, false);
        int i5 = calendar.get(13);
        DownloadViewModel viewModel3 = getViewModel();
        ArrayList arrayList3 = new ArrayList();
        for (int i6 = 0; i6 < 60; i6++) {
            String format3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(i6)}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            arrayList3.add(format3);
        }
        viewModel3.setSecondsList(arrayList3);
        binding.pickerSeconds.setData(getViewModel().getSecondsList());
        binding.pickerSeconds.setSelectedItemPosition(i5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$0(SelectTimeDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$6$lambda$1(SelectTimeDialog this$0, DialogSelectTimeBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        String str = (String) CollectionsKt.getOrNull(this$0.getViewModel().getHoursList(), this_apply.pickerHours.getCurrentItemPosition());
        String str2 = SessionDescription.SUPPORTED_SDP_VERSION;
        if (str == null) {
            str = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        long parseLong = Long.parseLong(str);
        String str3 = (String) CollectionsKt.getOrNull(this$0.getViewModel().getMinutesList(), this_apply.pickerMinutes.getCurrentItemPosition());
        if (str3 == null) {
            str3 = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        long parseLong2 = Long.parseLong(str3);
        String str4 = (String) CollectionsKt.getOrNull(this$0.getViewModel().getSecondsList(), this_apply.pickerSeconds.getCurrentItemPosition());
        if (str4 != null) {
            str2 = str4;
        }
        long j = 60;
        this$0.getViewModel().selectStartTime(new Date(((parseLong * j * j) + (parseLong2 * j) + Long.parseLong(str2)) * 1000));
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = getView();
        Object parent = view != null ? view.getParent() : null;
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        BottomSheetBehavior from = BottomSheetBehavior.from((View) parent);
        Intrinsics.checkNotNullExpressionValue(from, "from(...)");
        from.setState(3);
    }
}
