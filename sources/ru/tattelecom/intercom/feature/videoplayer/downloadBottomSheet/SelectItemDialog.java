package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import ru.tattelecom.intercom.feature.videoplayer.databinding.DialogSelectItemBinding;

/* compiled from: SelectItemDialog.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSelectItemBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSelectItemBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "sharedViewModel", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "getSharedViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemViewModel;", "viewModel$delegate", "getTheme", "", "onStart", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "Types", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SelectItemDialog extends BottomSheetDialogFragment {
    public static final String ARG_LIST = "list";
    public static final String ARG_POS = "selected_position";
    public static final String ARG_TYPE = "type";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SelectItemDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSelectItemBinding;", 0))};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public SelectItemDialog() {
        super(R.layout.dialog_select_item);
        final SelectItemDialog selectItemDialog = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(selectItemDialog, DialogSelectItemBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog$special$$inlined$viewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<SelectItemViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final SelectItemViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(SelectItemViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        final Function0<FragmentActivity> function04 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog$special$$inlined$activityViewModel$default$1
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
        this.sharedViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DownloadViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog$special$$inlined$activityViewModel$default$2
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function07);
                return resolveViewModel;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DialogSelectItemBinding getBinding() {
        return (DialogSelectItemBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final SelectItemViewModel getViewModel() {
        return (SelectItemViewModel) this.viewModel.getValue();
    }

    private final DownloadViewModel getSharedViewModel() {
        return (DownloadViewModel) this.sharedViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.PlayerBottomSheetDialogTheme;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SelectItemDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemDialog$Types;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "DURATION", "DATE", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Types {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Types[] $VALUES;
        private final String type;
        public static final Types DURATION = new Types("DURATION", 0, "duration");
        public static final Types DATE = new Types("DATE", 1, "date");

        private static final /* synthetic */ Types[] $values() {
            return new Types[]{DURATION, DATE};
        }

        public static EnumEntries<Types> getEntries() {
            return $ENTRIES;
        }

        public static Types valueOf(String str) {
            return (Types) Enum.valueOf(Types.class, str);
        }

        public static Types[] values() {
            return (Types[]) $VALUES.clone();
        }

        private Types(String str, int i, String str2) {
            this.type = str2;
        }

        public final String getType() {
            return this.type;
        }

        static {
            Types[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: SelectItemDialog.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemDialog$Companion;", "", "()V", "ARG_LIST", "", "ARG_POS", "ARG_TYPE", "create", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemDialog;", "type", SelectItemDialog.ARG_LIST, "", "selectedPosition", "", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;)Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemDialog;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SelectItemDialog create$default(Companion companion, String str, List list, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((i & 4) != 0) {
                num = null;
            }
            return companion.create(str, list, num);
        }

        public final SelectItemDialog create(String type, List<String> list, Integer selectedPosition) {
            Intrinsics.checkNotNullParameter(type, "type");
            SelectItemDialog selectItemDialog = new SelectItemDialog();
            selectItemDialog.setArguments(BundleKt.bundleOf(TuplesKt.to("type", type), TuplesKt.to(SelectItemDialog.ARG_LIST, list), TuplesKt.to(SelectItemDialog.ARG_POS, selectedPosition)));
            return selectItemDialog;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final DialogSelectItemBinding binding = getBinding();
        String type = getViewModel().getType();
        if (Intrinsics.areEqual(type, Types.DURATION.getType())) {
            binding.tvTitle.setText(getString(R.string.download_video_duration));
        } else if (Intrinsics.areEqual(type, Types.DATE.getType())) {
            binding.tvTitle.setText(getString(R.string.camera_archive));
        }
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectItemDialog.onViewCreated$lambda$2$lambda$0(SelectItemDialog.this, view2);
            }
        });
        binding.btnOk.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SelectItemDialog.onViewCreated$lambda$2$lambda$1(SelectItemDialog.this, binding, view2);
            }
        });
        binding.picker.setData(getViewModel().getList());
        binding.picker.setSelectedItemPosition(getViewModel().getSelectedId(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$0(SelectItemDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(SelectItemDialog this$0, DialogSelectItemBinding this_apply, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        String type = this$0.getViewModel().getType();
        if (Intrinsics.areEqual(type, Types.DURATION.getType())) {
            this$0.getSharedViewModel().selectDurationId(this_apply.picker.getCurrentItemPosition());
        } else if (Intrinsics.areEqual(type, Types.DATE.getType())) {
            this$0.getSharedViewModel().selectDayId(this_apply.picker.getCurrentItemPosition());
        }
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
