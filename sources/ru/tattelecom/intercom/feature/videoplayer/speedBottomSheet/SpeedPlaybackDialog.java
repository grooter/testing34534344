package ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
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
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.databinding.DialogSpeedPlaybackBinding;

/* compiled from: SpeedPlaybackDialog.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/speedBottomSheet/SpeedPlaybackDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSpeedPlaybackBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSpeedPlaybackBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "sharedViewModel", "Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "getSharedViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "speedPlaybackAdapter", "Lru/tattelecom/intercom/feature/videoplayer/speedBottomSheet/SpeedPlaybackAdapter;", "getTheme", "", "onStart", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SpeedPlaybackDialog extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(SpeedPlaybackDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogSpeedPlaybackBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;
    private SpeedPlaybackAdapter speedPlaybackAdapter;

    public SpeedPlaybackDialog() {
        super(R.layout.dialog_speed_playback);
        final SpeedPlaybackDialog speedPlaybackDialog = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(speedPlaybackDialog, DialogSpeedPlaybackBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog$special$$inlined$activityViewModel$default$1
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
        this.sharedViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<VideoPlayerViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog$special$$inlined$activityViewModel$default$2
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
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final DialogSpeedPlaybackBinding getBinding() {
        return (DialogSpeedPlaybackBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoPlayerViewModel getSharedViewModel() {
        return (VideoPlayerViewModel) this.sharedViewModel.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.PlayerBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.speedPlaybackAdapter = new SpeedPlaybackAdapter(new SpeedPlaybackDialog$onViewCreated$1(getSharedViewModel()));
        RecyclerView recyclerView = getBinding().rvSpeedList;
        SpeedPlaybackAdapter speedPlaybackAdapter = this.speedPlaybackAdapter;
        if (speedPlaybackAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedPlaybackAdapter");
            speedPlaybackAdapter = null;
        }
        recyclerView.setAdapter(speedPlaybackAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 1));
        getBinding().btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SpeedPlaybackDialog.onViewCreated$lambda$1(SpeedPlaybackDialog.this, view2);
            }
        });
        SpeedPlaybackAdapter speedPlaybackAdapter2 = this.speedPlaybackAdapter;
        if (speedPlaybackAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speedPlaybackAdapter");
            speedPlaybackAdapter2 = null;
        }
        speedPlaybackAdapter2.submitList(getSharedViewModel().getSpeedPlaybackValues());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new SpeedPlaybackDialog$onViewCreated$4(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(SpeedPlaybackDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
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
