package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
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
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.videoplayer.PlayerState;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.databinding.DialogDownloadBinding;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadEvent;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.SelectItemDialog;
import ru.tattelecom.intercom.feature.videoplayer.model.PlayerEvent;

/* compiled from: DownloadDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002\u0015\u0018\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0017\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0003¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u00020'2\u0006\u0010#\u001a\u00020$H\u0003J\b\u0010(\u001a\u00020\"H\u0016J\b\u0010)\u001a\u00020'H\u0016J\u000e\u0010*\u001a\u00020'2\u0006\u0010#\u001a\u00020$J\b\u0010+\u001a\u00020'H\u0017J\u001a\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020'2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020'H\u0002J\b\u00105\u001a\u00020'H\u0002J\u0010\u00106\u001a\u00020'2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020'H\u0002J\u0010\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020'H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001c\u0010\u001d¨\u0006>"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogDownloadBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogDownloadBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "downloadManager", "Landroid/app/DownloadManager;", "getDownloadManager", "()Landroid/app/DownloadManager;", "downloadManager$delegate", "Lkotlin/Lazy;", "downloadViewModel", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "getDownloadViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "downloadViewModel$delegate", "mReceiver", "ru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadDialog$mReceiver$1", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadDialog$mReceiver$1;", "observer", "ru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadDialog$observer$1", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadDialog$observer$1;", "videoPlayerViewModel", "Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "getVideoPlayerViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "videoPlayerViewModel$delegate", "generateVideoDescription", "", "getDMStatus", "", "downloadId", "", "(J)Ljava/lang/Integer;", "getDownloadProgress", "", "getTheme", "onDestroy", "onDownloadComplete", "onStart", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "provideScreenState", "provideUiChanges", "registerContentObserver", "removeDownload", "model", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "setUi", "startDownload", "url", "stopDownload", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DownloadDialog extends BottomSheetDialogFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DownloadDialog.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/videoplayer/databinding/DialogDownloadBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: downloadManager$delegate, reason: from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: downloadViewModel$delegate, reason: from kotlin metadata */
    private final Lazy downloadViewModel;
    private final DownloadDialog$mReceiver$1 mReceiver;
    private final DownloadDialog$observer$1 observer;

    /* renamed from: videoPlayerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy videoPlayerViewModel;

    /* JADX WARN: Type inference failed for: r0v7, types: [ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$mReceiver$1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$observer$1] */
    public DownloadDialog() {
        super(R.layout.dialog_download);
        final DownloadDialog downloadDialog = this;
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(downloadDialog, DialogDownloadBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$special$$inlined$activityViewModel$default$1
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
        this.downloadViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DownloadViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$special$$inlined$activityViewModel$default$2
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
        final Function0<FragmentActivity> function04 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$special$$inlined$activityViewModel$default$3
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
        this.videoPlayerViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<VideoPlayerViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$special$$inlined$activityViewModel$default$4
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
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(VideoPlayerViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function07);
                return resolveViewModel;
            }
        });
        this.downloadManager = LazyKt.lazy(new Function0<DownloadManager>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$downloadManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DownloadManager invoke() {
                FragmentActivity activity = DownloadDialog.this.getActivity();
                Object systemService = activity != null ? activity.getSystemService("download") : null;
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
                return (DownloadManager) systemService;
            }
        });
        this.mReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$mReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                DownloadDialog.this.onDownloadComplete(intent.getLongExtra("extra_download_id", -1L));
            }
        };
        final Handler handler = new Handler(Looper.getMainLooper());
        this.observer = new ContentObserver(handler) { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$observer$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                LifecycleCoroutineScope lifecycleScope;
                super.onChange(selfChange, uri);
                FragmentActivity activity = DownloadDialog.this.getActivity();
                if (activity == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(activity)) == null) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new DownloadDialog$observer$1$onChange$1(DownloadDialog.this, null), 3, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final DialogDownloadBinding getBinding() {
        return (DialogDownloadBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DownloadViewModel getDownloadViewModel() {
        return (DownloadViewModel) this.downloadViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoPlayerViewModel getVideoPlayerViewModel() {
        return (VideoPlayerViewModel) this.videoPlayerViewModel.getValue();
    }

    private final DownloadManager getDownloadManager() {
        return (DownloadManager) this.downloadManager.getValue();
    }

    @Override // androidx.fragment.app.DialogFragment
    public int getTheme() {
        return R.style.PlayerBottomSheetDialogTheme;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUi();
        provideScreenState();
        provideUiChanges();
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
        if (Build.VERSION.SDK_INT >= 33) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    private final void setUi() {
        DialogDownloadBinding binding = getBinding();
        List<String> value = getDownloadViewModel().getArchiveDayNames().getValue();
        if (!value.isEmpty()) {
            binding.tvSelectDate.setText(value.get(getDownloadViewModel().getSelectedDayId().getValue().intValue()));
        }
        if (!getDownloadViewModel().getArchiveDayNames().getValue().isEmpty()) {
            binding.tvSelectDate.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadDialog.setUi$lambda$6$lambda$1(DownloadDialog.this, view);
                }
            });
        }
        binding.tvSelectStartTime.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadDialog.setUi$lambda$6$lambda$2(DownloadDialog.this, view);
            }
        });
        binding.tvSelectDuration.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadDialog.setUi$lambda$6$lambda$3(DownloadDialog.this, view);
            }
        });
        binding.btnDownload.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadDialog.setUi$lambda$6$lambda$4(DownloadDialog.this, view);
            }
        });
        binding.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadDialog.setUi$lambda$6$lambda$5(DownloadDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$1(DownloadDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectItemDialog.INSTANCE.create(SelectItemDialog.Types.DATE.getType(), this$0.getDownloadViewModel().getArchiveDayNames().getValue(), this$0.getDownloadViewModel().getSelectedDayId().getValue()).show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$2(DownloadDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new SelectTimeDialog().show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$3(DownloadDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SelectItemDialog.INSTANCE.create(SelectItemDialog.Types.DURATION.getType(), this$0.getDownloadViewModel().getDurationlist(), this$0.getDownloadViewModel().getSelectedDurationId().getValue()).show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$4(DownloadDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this$0.getDownloadViewModel().getArchiveDays().getValue().get(this$0.getDownloadViewModel().getSelectedDayId().getValue().intValue()).getTime());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Date value = this$0.getDownloadViewModel().getSelectedStartTime().getValue();
        Intrinsics.checkNotNull(value);
        long seconds2 = timeUnit.toSeconds(value.getTime());
        this$0.getDownloadViewModel().setDownloadVideoOptions(seconds + seconds2, (this$0.getDownloadViewModel().getSelectedDurationId().getValue().intValue() + 1) * 60, Intrinsics.areEqual(this$0.getVideoPlayerViewModel().getScreenState().getValue(), PlayerState.Camera.INSTANCE) && !this$0.getVideoPlayerViewModel().getIsFlussonic(), this$0.getVideoPlayerViewModel().getCameraExportSource());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUi$lambda$6$lambda$5(DownloadDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stopDownload();
    }

    private final void provideScreenState() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new DownloadDialog$provideScreenState$1(this, null), 3, null);
    }

    private final void provideUiChanges() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new DownloadDialog$provideUiChanges$1(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new DownloadDialog$provideUiChanges$2(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new DownloadDialog$provideUiChanges$3(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new DownloadDialog$provideUiChanges$4(this, null), 3, null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), null, null, new DownloadDialog$provideUiChanges$5(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(DownloadEvent event) {
        if (event instanceof DownloadEvent.ChangeProgress) {
            DialogDownloadBinding binding = getBinding();
            DownloadEvent.ChangeProgress changeProgress = (DownloadEvent.ChangeProgress) event;
            binding.pbDownload.setProgress(changeProgress.getPercentage());
            binding.tvDownloadProgress.setText(getResources().getString(R.string.video_download_percentage, Integer.valueOf(changeProgress.getPercentage())));
            return;
        }
        if (event instanceof DownloadEvent.Error) {
            getVideoPlayerViewModel().sendEvent(new PlayerEvent.ShowCustomSnackBar(null, 0, Integer.valueOf(R.string.msg_download_error), GravityCompat.START, Integer.valueOf(R.string.button_repeat), GravityCompat.START, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$provideEvent$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:4:0x0091, code lost:
                
                    if (r0.getIsFlussonic() == false) goto L8;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2() {
                    /*
                        r12 = this;
                        java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r1 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r1 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getDownloadViewModel(r1)
                        kotlinx.coroutines.flow.StateFlow r1 = r1.getArchiveDays()
                        java.lang.Object r1 = r1.getValue()
                        java.util.List r1 = (java.util.List) r1
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r2 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r2 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getDownloadViewModel(r2)
                        kotlinx.coroutines.flow.StateFlow r2 = r2.getSelectedDayId()
                        java.lang.Object r2 = r2.getValue()
                        java.lang.Number r2 = (java.lang.Number) r2
                        int r2 = r2.intValue()
                        java.lang.Object r1 = r1.get(r2)
                        java.util.Date r1 = (java.util.Date) r1
                        long r1 = r1.getTime()
                        long r0 = r0.toSeconds(r1)
                        java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r3 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r3 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getDownloadViewModel(r3)
                        kotlinx.coroutines.flow.StateFlow r3 = r3.getSelectedStartTime()
                        java.lang.Object r3 = r3.getValue()
                        kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                        java.util.Date r3 = (java.util.Date) r3
                        long r3 = r3.getTime()
                        long r2 = r2.toSeconds(r3)
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r4 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r4 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getDownloadViewModel(r4)
                        kotlinx.coroutines.flow.StateFlow r4 = r4.getSelectedDurationId()
                        java.lang.Object r4 = r4.getValue()
                        java.lang.Number r4 = (java.lang.Number) r4
                        int r4 = r4.intValue()
                        r5 = 1
                        int r4 = r4 + r5
                        int r9 = r4 * 60
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r4 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r6 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getDownloadViewModel(r4)
                        long r7 = r0 + r2
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r0 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r0 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getVideoPlayerViewModel(r0)
                        kotlinx.coroutines.flow.StateFlow r0 = r0.getScreenState()
                        java.lang.Object r0 = r0.getValue()
                        ru.tattelecom.intercom.feature.videoplayer.PlayerState$Camera r1 = ru.tattelecom.intercom.feature.videoplayer.PlayerState.Camera.INSTANCE
                        boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
                        if (r0 == 0) goto L94
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r0 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r0 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getVideoPlayerViewModel(r0)
                        boolean r0 = r0.getIsFlussonic()
                        if (r0 != 0) goto L94
                        goto L95
                    L94:
                        r5 = 0
                    L95:
                        r10 = r5
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog r0 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.this
                        ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r0 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog.access$getVideoPlayerViewModel(r0)
                        java.lang.String r11 = r0.getCameraExportSource()
                        r6.setDownloadVideoOptions(r7, r9, r10, r11)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog$provideEvent$2.invoke2():void");
                }
            }, false, 0, 387, null));
            return;
        }
        if (Intrinsics.areEqual(event, DownloadEvent.DownloadStarted.INSTANCE)) {
            getVideoPlayerViewModel().sendEvent(new PlayerEvent.ShowSnackbar(R.string.video_download_progress_title, 0, 2, null));
            dismiss();
        } else if (Intrinsics.areEqual(event, DownloadEvent.DownloadComplete.INSTANCE)) {
            getVideoPlayerViewModel().sendEvent(new PlayerEvent.ShowSnackbar(R.string.video_download_completed, 0, 2, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startDownload(String url) {
        boolean areEqual = Intrinsics.areEqual(getDownloadViewModel().getVideoType(), DownloadViewModel.VideoType.Intercom.getType());
        String generateVideoDescription = generateVideoDescription();
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        String token = getDownloadViewModel().getToken();
        if (token != null) {
            request.addRequestHeader("access-token", token);
        }
        request.setTitle(generateVideoDescription);
        request.setDescription("Загрузка");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Мой дом" + File.separator + generateVideoDescription);
        request.setNotificationVisibility(1);
        long enqueue = getDownloadManager().enqueue(request);
        DownloadViewModel downloadViewModel = getDownloadViewModel();
        String urlDescription = getDownloadViewModel().getUrlDescription();
        Intrinsics.checkNotNull(urlDescription);
        downloadViewModel.addDownload(new DownloadDto(urlDescription, enqueue, areEqual));
        registerContentObserver(enqueue);
    }

    private final void stopDownload() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new DownloadDialog$stopDownload$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeDownload(DownloadDto model) {
        getDownloadViewModel().removeDownload(model);
        getDownloadManager().remove(model.getDownloadId());
    }

    private final String generateVideoDescription() {
        return "Мой дом " + new SimpleDateFormat("d-MM-HH-mm-ss", new Locale("ru", "RU")).format(Long.valueOf(new Date().getTime())) + ".mp4";
    }

    private final void registerContentObserver(long downloadId) {
        ContentResolver contentResolver;
        Uri parse = Uri.parse("content://downloads/my_downloads/" + downloadId);
        Context context = getContext();
        if (context == null || (contentResolver = context.getContentResolver()) == null) {
            return;
        }
        contentResolver.registerContentObserver(parse, false, this.observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Integer getDMStatus(long downloadId) {
        Cursor query = getDownloadManager().query(new DownloadManager.Query().setFilterById(downloadId));
        try {
            Cursor cursor = query;
            Integer valueOf = (cursor.getCount() <= 0 || !cursor.moveToFirst()) ? null : Integer.valueOf(cursor.getInt(cursor.getColumnIndex("status")));
            CloseableKt.closeFinally(query, null);
            return valueOf;
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getDownloadProgress(long downloadId) {
        Cursor query = getDownloadManager().query(new DownloadManager.Query().setFilterById(downloadId));
        try {
            Cursor cursor = query;
            if (cursor.getCount() > 0 && cursor.moveToFirst()) {
                int i = cursor.getInt(cursor.getColumnIndex("bytes_so_far"));
                int i2 = cursor.getInt(cursor.getColumnIndex("total_size"));
                if (i2 != 0) {
                    getDownloadViewModel().sendEvent(new DownloadEvent.ChangeProgress((int) ((i * 100) / i2)));
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } finally {
        }
    }

    public final void onDownloadComplete(long downloadId) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new DownloadDialog$onDownloadComplete$1(this, downloadId, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ContentResolver contentResolver;
        super.onDestroy();
        Context context = getContext();
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            contentResolver.unregisterContentObserver(this.observer);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(this.mReceiver);
        }
    }
}
