package ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.feature.videoplayer.PlayerState;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.databinding.DialogArchiveDateBinding;

/* compiled from: ArchiveDateBottomSheet.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDateBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "archiveAdapter", "Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDateAdapter;", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogArchiveDateBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogArchiveDateBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "dateFormatter", "Ljava/text/SimpleDateFormat;", "viewModel", "Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getTheme", "", "onDayClick", "", TtmlNode.ATTR_ID, "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ArchiveDateBottomSheet extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ArchiveDateBottomSheet.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogArchiveDateBinding;", 0))};
    private ArchiveDateAdapter archiveAdapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private final SimpleDateFormat dateFormatter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public ArchiveDateBottomSheet() {
        super(R.layout.dialog_archive_date);
        final ArchiveDateBottomSheet archiveDateBottomSheet = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(archiveDateBottomSheet, DialogArchiveDateBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet.ArchiveDateBottomSheet$special$$inlined$activityViewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<VideoPlayerViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet.ArchiveDateBottomSheet$special$$inlined$activityViewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final VideoPlayerViewModel invoke() {
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoPlayerViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.dateFormatter = new SimpleDateFormat("EE, d MMMM", new Locale("RU"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DialogArchiveDateBinding getBinding() {
        return (DialogArchiveDateBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final VideoPlayerViewModel getViewModel() {
        return (VideoPlayerViewModel) this.viewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.PlayerBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().tvTitle.setText(getString(R.string.archive));
        getBinding().btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet.ArchiveDateBottomSheet$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ArchiveDateBottomSheet.onViewCreated$lambda$0(ArchiveDateBottomSheet.this, view2);
            }
        });
        this.archiveAdapter = new ArchiveDateAdapter(new ArchiveDateBottomSheet$onViewCreated$2(this));
        RecyclerView recyclerView = getBinding().rvDays;
        ArchiveDateAdapter archiveDateAdapter = this.archiveAdapter;
        ArchiveDateAdapter archiveDateAdapter2 = null;
        if (archiveDateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveAdapter");
            archiveDateAdapter = null;
        }
        recyclerView.setAdapter(archiveDateAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        List<Date> value = getViewModel().getDays().getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        int i = 0;
        for (Object obj : value) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int intValue = getViewModel().getSelectedDayId().getValue().intValue();
            int size = (getViewModel().getDays().getValue().size() - i) - 1;
            String format = this.dateFormatter.format((Date) obj);
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            if (format.length() > 0) {
                char upperCase = Character.toUpperCase(format.charAt(0));
                String substring = format.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                format = upperCase + substring;
            }
            arrayList.add(new ArchiveDate(size, StringsKt.removeSuffix(format, (CharSequence) "."), size == intValue || (intValue == -1 && size == 6), (size <= 4 && getViewModel().getStreamArchiveService() == 7) || size > 4 || Intrinsics.areEqual(getViewModel().getScreenState().getValue(), PlayerState.Camera.INSTANCE)));
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        ArchiveDateAdapter archiveDateAdapter3 = this.archiveAdapter;
        if (archiveDateAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("archiveAdapter");
        } else {
            archiveDateAdapter2 = archiveDateAdapter3;
        }
        archiveDateAdapter2.submitList(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(ArchiveDateBottomSheet this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onDayClick(int id) {
        getViewModel().onDayClick(id);
        dismiss();
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
