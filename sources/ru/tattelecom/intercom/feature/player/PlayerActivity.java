package ru.tattelecom.intercom.feature.player;

import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.WindowCompat;
import androidx.lifecycle.FlowExtKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import by.kirich1409.viewbindingdelegate.ReflectionActivityViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.Slider;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.linphone.mediastream.video.capture.CaptureTextureView;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.databinding.SnackbarCustomAttentionBinding;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.helper.ApartmentServiceName;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.call.CallService;
import ru.tattelecom.intercom.feature.call.CallState;
import ru.tattelecom.intercom.feature.call.SipManager;
import ru.tattelecom.intercom.feature.intercom_emergency_code.IntercomEmergencyCodeDialogFragment;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;
import ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding;
import ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0005*\u0004\u0010\u0013\"%\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020 H\u0003J\b\u0010>\u001a\u00020 H\u0002J\u0012\u0010?\u001a\u0002092\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\b\u0010B\u001a\u00020 H\u0002J\u0012\u0010C\u001a\u00020 2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0017\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020IH\u0003¢\u0006\u0002\u0010JJ\u0010\u0010K\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0003J\b\u0010L\u001a\u000209H\u0016J\b\u0010M\u001a\u000209H\u0002J\u0012\u0010N\u001a\u0002092\b\u0010O\u001a\u0004\u0018\u00010PH\u0015J\b\u0010Q\u001a\u000209H\u0014J\u000e\u0010R\u001a\u0002092\u0006\u0010H\u001a\u00020IJ\b\u0010S\u001a\u000209H\u0015J\b\u0010T\u001a\u000209H\u0014J\u0010\u0010U\u001a\u00020 2\u0006\u0010V\u001a\u00020EH\u0016J\b\u0010W\u001a\u000209H\u0002J\b\u0010X\u001a\u000209H\u0002J\b\u0010Y\u001a\u000209H\u0002J\u0010\u0010Z\u001a\u0002092\u0006\u0010V\u001a\u00020[H\u0002J\u001a\u0010\\\u001a\u0002092\b\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020IH\u0002J\b\u0010`\u001a\u000209H\u0003J\u0010\u0010a\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0002J\u0010\u0010b\u001a\u0002092\u0006\u0010c\u001a\u00020dH\u0002J\b\u0010e\u001a\u000209H\u0002J\u0010\u0010f\u001a\u0002092\u0006\u0010g\u001a\u00020 H\u0002J\b\u0010h\u001a\u000209H\u0002J\u0017\u0010i\u001a\u0002092\b\u0010j\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0002\u0010kJ\u0017\u0010l\u001a\u0002092\b\u0010j\u001a\u0004\u0018\u00010 H\u0003¢\u0006\u0002\u0010kJ+\u0010m\u001a\u0002092\b\b\u0001\u0010n\u001a\u00020G2\u0006\u0010o\u001a\u00020\f2\n\b\u0002\u0010p\u001a\u0004\u0018\u00010 H\u0003¢\u0006\u0002\u0010qJ\u0012\u0010r\u001a\u0002092\b\b\u0001\u0010n\u001a\u00020GH\u0003J \u0010s\u001a\u0002092\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010uH\u0002J\b\u0010v\u001a\u000209H\u0002J\b\u0010w\u001a\u00020\fH\u0002J\u0010\u0010x\u001a\u00020\f2\u0006\u0010y\u001a\u00020IH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R(\u0010'\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f (*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u001c\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lru/tattelecom/intercom/feature/player/databinding/ActivityPlayerBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/player/databinding/ActivityPlayerBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "callPermissionsResultReceiver", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "callService", "Lru/tattelecom/intercom/feature/call/CallService;", "callServiceConnection", "ru/tattelecom/intercom/feature/player/PlayerActivity$callServiceConnection$1", "Lru/tattelecom/intercom/feature/player/PlayerActivity$callServiceConnection$1;", "connectionReceiver", "ru/tattelecom/intercom/feature/player/PlayerActivity$connectionReceiver$1", "Lru/tattelecom/intercom/feature/player/PlayerActivity$connectionReceiver$1;", "dateFormatter", "Ljava/text/SimpleDateFormat;", "downloadManager", "Landroid/app/DownloadManager;", "getDownloadManager", "()Landroid/app/DownloadManager;", "downloadManager$delegate", "Lkotlin/Lazy;", "hardwareManager", "Lru/tattelecom/intercom/feature/player/HardwareManager;", "isTimeDragging", "", "mReceiver", "ru/tattelecom/intercom/feature/player/PlayerActivity$mReceiver$1", "Lru/tattelecom/intercom/feature/player/PlayerActivity$mReceiver$1;", "observer", "ru/tattelecom/intercom/feature/player/PlayerActivity$observer$1", "Lru/tattelecom/intercom/feature/player/PlayerActivity$observer$1;", "requestPermissionLauncher", "kotlin.jvm.PlatformType", "reviewInfo", "Lcom/google/android/play/core/review/ReviewInfo;", "reviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "streamPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "url", "urlDescription", "viewModel", "Lru/tattelecom/intercom/feature/player/PlayerViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/player/PlayerViewModel;", "viewModel$delegate", "zoomGestureDetector", "Landroid/view/ScaleGestureDetector;", "archiveDaysSetOnClickListener", "", "state", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "askReadExternalStoragePermission", "askReadMediaVideoPermission", "askWriteExternalStoragePermission", "attachBaseContext", "newBase", "Landroid/content/Context;", "currentOrientationLandscape", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getDMStatus", "", "downloadId", "", "(J)Ljava/lang/Integer;", "getDownloadProgress", "onBackPressed", "onClickRequestPermission", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDownloadComplete", "onStart", "onStop", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "pickDownloadState", "provideCallChanges", "provideDefaultUi", "provideEvent", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "provideSliderValue", "slider", "Lcom/google/android/material/slider/Slider;", "value", "provideUiChanges", "registerContentObserver", "removeDownload", "model", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "setDownloadButtonClickListener", "setDownloadingStatus", "status", "setOpenActivityOnLockScreen", "setSipVideoCrop", "isZoomed", "(Ljava/lang/Boolean;)V", "setStreamCrop", "showAttentionCustomSnackBar", "text", "serviceName", "isIntercomStream", "(ILjava/lang/String;Ljava/lang/Boolean;)V", "showErrorSnackBar", "startVideoDialogFragment", "key", "", "stopDownload", "videoDescription", "withZero", "number", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PlayerActivity extends AppCompatActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PlayerActivity.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/player/databinding/ActivityPlayerBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private ActivityResultLauncher<String[]> callPermissionsResultReceiver;
    private CallService callService;
    private final PlayerActivity$callServiceConnection$1 callServiceConnection;
    private PlayerActivity$connectionReceiver$1 connectionReceiver;
    private final SimpleDateFormat dateFormatter;

    /* renamed from: downloadManager$delegate, reason: from kotlin metadata */
    private final Lazy downloadManager;
    private HardwareManager hardwareManager;
    private boolean isTimeDragging;
    private final PlayerActivity$mReceiver$1 mReceiver;
    private final PlayerActivity$observer$1 observer;
    private final ActivityResultLauncher<String[]> requestPermissionLauncher;
    private ReviewInfo reviewInfo;
    private ReviewManager reviewManager;
    private ExoPlayer streamPlayer;
    private String url;
    private String urlDescription;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private ScaleGestureDetector zoomGestureDetector;

    /* JADX WARN: Type inference failed for: r0v10, types: [ru.tattelecom.intercom.feature.player.PlayerActivity$connectionReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v16, types: [ru.tattelecom.intercom.feature.player.PlayerActivity$mReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v9, types: [ru.tattelecom.intercom.feature.player.PlayerActivity$callServiceConnection$1] */
    /* JADX WARN: Type inference failed for: r1v8, types: [ru.tattelecom.intercom.feature.player.PlayerActivity$observer$1] */
    public PlayerActivity() {
        super(R.layout.activity_player);
        final PlayerActivity playerActivity = this;
        this.binding = ReflectionActivityViewBindings.viewBindingActivity(playerActivity, ActivityPlayerBinding.class, R.id.fl_root, UtilsKt.emptyVbCallback());
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        final byte b2 = 0 == true ? 1 : 0;
        this.viewModel = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<PlayerViewModel>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.feature.player.PlayerViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final PlayerViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                ComponentActivity componentActivity = ComponentActivity.this;
                Qualifier qualifier2 = qualifier;
                Function0 function0 = b;
                Function0 function02 = b2;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function0 == null || (defaultViewModelCreationExtras = (CreationExtras) function0.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(componentActivity);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(PlayerViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function02);
                return resolveViewModel;
            }
        });
        this.dateFormatter = new SimpleDateFormat("d, EE", new Locale("RU"));
        this.downloadManager = LazyKt.lazy(new Function0<DownloadManager>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$downloadManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DownloadManager invoke() {
                Object systemService = PlayerActivity.this.getSystemService("download");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
                return (DownloadManager) systemService;
            }
        });
        this.urlDescription = "";
        this.url = "";
        this.callServiceConnection = new ServiceConnection() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$callServiceConnection$1
            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                CallService callService;
                PlayerActivity playerActivity2 = PlayerActivity.this;
                Intrinsics.checkNotNull(service, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.call.CallService.CallBinder");
                playerActivity2.callService = ((CallService.CallBinder) service).getThis$0();
                callService = PlayerActivity.this.callService;
                if (callService != null) {
                    callService.stopRinging();
                }
                PlayerActivity.this.provideCallChanges();
            }
        };
        this.connectionReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$connectionReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                PlayerViewModel viewModel;
                PlayerViewModel viewModel2;
                viewModel = PlayerActivity.this.getViewModel();
                if (Intrinsics.areEqual((Object) viewModel.isBadConnBannerClosed().getValue(), (Object) false)) {
                    viewModel2 = PlayerActivity.this.getViewModel();
                    viewModel2.checkConnection(PlayerActivity.this);
                }
            }
        };
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda26
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlayerActivity.requestPermissionLauncher$lambda$3(PlayerActivity.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult;
        final Handler handler = new Handler(Looper.getMainLooper());
        this.observer = new ContentObserver(handler) { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$observer$1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange, Uri uri) {
                super.onChange(selfChange, uri);
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(PlayerActivity.this), null, null, new PlayerActivity$observer$1$onChange$1(PlayerActivity.this, null), 3, null);
            }
        };
        this.mReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$mReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                PlayerActivity.this.onDownloadComplete(intent.getLongExtra("extra_download_id", -1L));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ActivityPlayerBinding getBinding() {
        return (ActivityPlayerBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayerViewModel getViewModel() {
        return (PlayerViewModel) this.viewModel.getValue();
    }

    private final DownloadManager getDownloadManager() {
        return (DownloadManager) this.downloadManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$3(final PlayerActivity this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = map.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                z = false;
            }
        }
        if (z) {
            this$0.setDownloadButtonClickListener();
        } else {
            new MaterialAlertDialogBuilder(this$0).setMessage((CharSequence) "Разрешите доступ к хранилищу для возможности скачивания").setPositiveButton((CharSequence) "Настройки", new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda29
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    PlayerActivity.requestPermissionLauncher$lambda$3$lambda$1(PlayerActivity.this, dialogInterface, i);
                }
            }).setNegativeButton((CharSequence) "Отмена", new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda30
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$3$lambda$1(PlayerActivity this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this$0.getPackageName(), null));
        this$0.startActivity(intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PlayerActivity$onCreate$1(this, null), 3, null);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda27
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PlayerActivity.onCreate$lambda$5(PlayerActivity.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.callPermissionsResultReceiver = registerForActivityResult;
        PlayerActivity playerActivity = this;
        ReviewManager create = ReviewManagerFactory.create(playerActivity);
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        create.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda28
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                PlayerActivity.onCreate$lambda$7$lambda$6(PlayerActivity.this, task);
            }
        });
        this.reviewManager = create;
        this.hardwareManager = new HardwareManager(this, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$onCreate$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                ActivityPlayerBinding binding;
                binding = PlayerActivity.this.getBinding();
                binding.btnOpenIntercom.setClickable(!z);
                binding.btnFullscreen.setClickable(!z);
                binding.btnEndCall.setClickable(!z);
                binding.btnMic.setClickable(!z);
            }
        });
        this.zoomGestureDetector = new ScaleGestureDetector(playerActivity, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$onCreate$5
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                PlayerViewModel viewModel;
                Intrinsics.checkNotNullParameter(detector, "detector");
                float scaleFactor = detector.getScaleFactor();
                viewModel = PlayerActivity.this.getViewModel();
                viewModel.onPinchToZoomGesture(scaleFactor > 1.0f);
                return true;
            }
        });
        ExoPlayer build = new ExoPlayer.Builder(playerActivity).setRenderersFactory(new DefaultRenderersFactory(playerActivity).setEnableDecoderFallback(true)).build();
        build.setPlayWhenReady(true);
        build.addListener(new Player.Listener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$onCreate$6$1
            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAudioAttributesChanged(AudioAttributes audioAttributes) {
                Player.Listener.CC.$default$onAudioAttributesChanged(this, audioAttributes);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAudioSessionIdChanged(int i) {
                Player.Listener.CC.$default$onAudioSessionIdChanged(this, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
                Player.Listener.CC.$default$onAvailableCommandsChanged(this, commands);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onCues(CueGroup cueGroup) {
                Player.Listener.CC.$default$onCues(this, cueGroup);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onCues(List list) {
                Player.Listener.CC.$default$onCues(this, list);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
                Player.Listener.CC.$default$onDeviceInfoChanged(this, deviceInfo);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onDeviceVolumeChanged(int i, boolean z) {
                Player.Listener.CC.$default$onDeviceVolumeChanged(this, i, z);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onEvents(Player player, Player.Events events) {
                Player.Listener.CC.$default$onEvents(this, player, events);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onIsLoadingChanged(boolean z) {
                Player.Listener.CC.$default$onIsLoadingChanged(this, z);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onIsPlayingChanged(boolean z) {
                Player.Listener.CC.$default$onIsPlayingChanged(this, z);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onLoadingChanged(boolean z) {
                Player.Listener.CC.$default$onLoadingChanged(this, z);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMaxSeekToPreviousPositionChanged(long j) {
                Player.Listener.CC.$default$onMaxSeekToPreviousPositionChanged(this, j);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i) {
                Player.Listener.CC.$default$onMediaItemTransition(this, mediaItem, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
                Player.Listener.CC.$default$onMediaMetadataChanged(this, mediaMetadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onMetadata(androidx.media3.common.Metadata metadata) {
                Player.Listener.CC.$default$onMetadata(this, metadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayWhenReadyChanged(boolean z, int i) {
                Player.Listener.CC.$default$onPlayWhenReadyChanged(this, z, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
                Player.Listener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
                Player.Listener.CC.$default$onPlayerErrorChanged(this, playbackException);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
                Player.Listener.CC.$default$onPlayerStateChanged(this, z, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
                Player.Listener.CC.$default$onPlaylistMetadataChanged(this, mediaMetadata);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPositionDiscontinuity(int i) {
                Player.Listener.CC.$default$onPositionDiscontinuity(this, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
                Player.Listener.CC.$default$onPositionDiscontinuity(this, positionInfo, positionInfo2, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onRenderedFirstFrame() {
                Player.Listener.CC.$default$onRenderedFirstFrame(this);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onRepeatModeChanged(int i) {
                Player.Listener.CC.$default$onRepeatModeChanged(this, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSeekBackIncrementChanged(long j) {
                Player.Listener.CC.$default$onSeekBackIncrementChanged(this, j);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSeekForwardIncrementChanged(long j) {
                Player.Listener.CC.$default$onSeekForwardIncrementChanged(this, j);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
                Player.Listener.CC.$default$onShuffleModeEnabledChanged(this, z);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z) {
                Player.Listener.CC.$default$onSkipSilenceEnabledChanged(this, z);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
                Player.Listener.CC.$default$onSurfaceSizeChanged(this, i, i2);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTimelineChanged(Timeline timeline, int i) {
                Player.Listener.CC.$default$onTimelineChanged(this, timeline, i);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
                Player.Listener.CC.$default$onTrackSelectionParametersChanged(this, trackSelectionParameters);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onTracksChanged(Tracks tracks) {
                Player.Listener.CC.$default$onTracksChanged(this, tracks);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
                Player.Listener.CC.$default$onVideoSizeChanged(this, videoSize);
            }

            @Override // androidx.media3.common.Player.Listener
            public /* synthetic */ void onVolumeChanged(float f) {
                Player.Listener.CC.$default$onVolumeChanged(this, f);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlaybackStateChanged(int state) {
                PlayerViewModel viewModel;
                Player.Listener.CC.$default$onPlaybackStateChanged(this, state);
                viewModel = PlayerActivity.this.getViewModel();
                viewModel.onStreamLoading(state == 2);
            }

            @Override // androidx.media3.common.Player.Listener
            public void onPlayerError(PlaybackException error) {
                CallService callService;
                PlayerViewModel viewModel;
                SipManager sipManager;
                MutableStateFlow<Boolean> isVideoLoaded;
                Intrinsics.checkNotNullParameter(error, "error");
                Player.Listener.CC.$default$onPlayerError(this, error);
                callService = PlayerActivity.this.callService;
                if (callService == null || (sipManager = callService.getSipManager()) == null || (isVideoLoaded = sipManager.isVideoLoaded()) == null || !isVideoLoaded.getValue().booleanValue()) {
                    viewModel = PlayerActivity.this.getViewModel();
                    viewModel.onStreamError();
                }
            }
        });
        this.streamPlayer = build;
        String value = getViewModel().getStreamUrl().getValue();
        if (value == null) {
            value = getViewModel().getCameraLiveSource();
        }
        if (value == null) {
            value = "";
        }
        this.urlDescription = value;
        provideDefaultUi();
        provideUiChanges();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(PlayerActivity this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean bool = (Boolean) map.get("android.permission.RECORD_AUDIO");
        if (bool == null || !bool.booleanValue()) {
            return;
        }
        this$0.getViewModel().onMicClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$6(PlayerActivity this$0, Task request) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "request");
        if (request.isSuccessful()) {
            this$0.reviewInfo = (ReviewInfo) request.getResult();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        PlayerActivity playerActivity = this;
        bindService(new Intent(playerActivity, (Class<?>) CallService.class), this.callServiceConnection, 1);
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
            registerReceiver(this.connectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 4);
        } else {
            registerReceiver(this.mReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            registerReceiver(this.connectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        if (Intrinsics.areEqual((Object) getViewModel().isBadConnBannerClosed().getValue(), (Object) false)) {
            getViewModel().checkConnection(playerActivity);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            Object systemService = getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            View currentFocus = getCurrentFocus();
            Intrinsics.checkNotNull(currentFocus);
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        unbindService(this.callServiceConnection);
        unregisterReceiver(this.mReceiver);
        unregisterReceiver(this.connectionReceiver);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        HardwareManager hardwareManager = this.hardwareManager;
        if (hardwareManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hardwareManager");
            hardwareManager = null;
        }
        hardwareManager.stop();
        ExoPlayer exoPlayer = this.streamPlayer;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
        getContentResolver().unregisterContentObserver(this.observer);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        getViewModel().onEndCall();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ScaleGestureDetector scaleGestureDetector = this.zoomGestureDetector;
        if (scaleGestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zoomGestureDetector");
            scaleGestureDetector = null;
        }
        scaleGestureDetector.onTouchEvent(event);
        return true;
    }

    private final void provideDefaultUi() {
        int i;
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        final ActivityPlayerBinding binding = getBinding();
        binding.hsDays.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets provideDefaultUi$lambda$28$lambda$9;
                provideDefaultUi$lambda$28$lambda$9 = PlayerActivity.provideDefaultUi$lambda$28$lambda$9(PlayerActivity.this, view, windowInsets);
                return provideDefaultUi$lambda$28$lambda$9;
            }
        });
        final ImageView imageView = binding.btnFullscreen;
        if (currentOrientationLandscape()) {
            i = R.drawable.ic_fullscreen_exit;
        } else {
            i = R.drawable.ic_fullscreen;
        }
        imageView.setImageResource(i);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerActivity.provideDefaultUi$lambda$28$lambda$12$lambda$10(PlayerActivity.this, view);
            }
        });
        imageView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda18
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets provideDefaultUi$lambda$28$lambda$12$lambda$11;
                provideDefaultUi$lambda$28$lambda$12$lambda$11 = PlayerActivity.provideDefaultUi$lambda$28$lambda$12$lambda$11(imageView, view, windowInsets);
                return provideDefaultUi$lambda$28$lambda$12$lambda$11;
            }
        });
        binding.clPlayerControls.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda19
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets provideDefaultUi$lambda$28$lambda$13;
                provideDefaultUi$lambda$28$lambda$13 = PlayerActivity.provideDefaultUi$lambda$28$lambda$13(PlayerActivity.this, view, windowInsets);
                return provideDefaultUi$lambda$28$lambda$13;
            }
        });
        binding.clCallButtons.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda20
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets provideDefaultUi$lambda$28$lambda$14;
                provideDefaultUi$lambda$28$lambda$14 = PlayerActivity.provideDefaultUi$lambda$28$lambda$14(PlayerActivity.this, view, windowInsets);
                return provideDefaultUi$lambda$28$lambda$14;
            }
        });
        binding.btnRefreshStream.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda21
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerActivity.provideDefaultUi$lambda$28$lambda$15(PlayerActivity.this, view);
            }
        });
        binding.btnMic.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerActivity.provideDefaultUi$lambda$28$lambda$16(PlayerActivity.this, view);
            }
        });
        Slider.OnSliderTouchListener onSliderTouchListener = new Slider.OnSliderTouchListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideDefaultUi$1$timeSliderTouchListener$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStartTrackingTouch(Slider slider) {
                Intrinsics.checkNotNullParameter(slider, "slider");
                PlayerActivity.this.isTimeDragging = true;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStopTrackingTouch(Slider slider) {
                PlayerViewModel viewModel;
                Intrinsics.checkNotNullParameter(slider, "slider");
                PlayerActivity.this.isTimeDragging = false;
                viewModel = PlayerActivity.this.getViewModel();
                TimeUnit timeUnit = TimeUnit.HOURS;
                Slider slider2 = binding.slHour;
                long seconds = timeUnit.toSeconds(slider2 != null ? (long) slider2.getValue() : 0L);
                Slider slider3 = binding.slMinutes;
                viewModel.onArchiveTimeSelected(seconds + (slider3 != null ? (long) slider3.getValue() : 0L));
            }
        };
        Slider slider = binding.slHour;
        if (slider != null) {
            slider.addOnSliderTouchListener(onSliderTouchListener);
            slider.setLabelFormatter(new LabelFormatter() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda23
                @Override // com.google.android.material.slider.LabelFormatter
                public final String getFormattedValue(float f) {
                    String provideDefaultUi$lambda$28$lambda$18$lambda$17;
                    provideDefaultUi$lambda$28$lambda$18$lambda$17 = PlayerActivity.provideDefaultUi$lambda$28$lambda$18$lambda$17(f);
                    return provideDefaultUi$lambda$28$lambda$18$lambda$17;
                }
            });
        }
        Slider slider2 = binding.slMinutes;
        if (slider2 != null) {
            slider2.addOnSliderTouchListener(onSliderTouchListener);
            slider2.setLabelFormatter(new LabelFormatter() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda24
                @Override // com.google.android.material.slider.LabelFormatter
                public final String getFormattedValue(float f) {
                    String provideDefaultUi$lambda$28$lambda$20$lambda$19;
                    provideDefaultUi$lambda$28$lambda$20$lambda$19 = PlayerActivity.provideDefaultUi$lambda$28$lambda$20$lambda$19(PlayerActivity.this, f);
                    return provideDefaultUi$lambda$28$lambda$20$lambda$19;
                }
            });
        }
        Slider slider3 = binding.slSeconds;
        slider3.addOnSliderTouchListener(new Slider.OnSliderTouchListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideDefaultUi$1$9$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStartTrackingTouch(Slider slider4) {
                Intrinsics.checkNotNullParameter(slider4, "slider");
                PlayerActivity.this.isTimeDragging = true;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.slider.BaseOnSliderTouchListener
            public void onStopTrackingTouch(Slider slider4) {
                PlayerViewModel viewModel;
                Intrinsics.checkNotNullParameter(slider4, "slider");
                PlayerActivity.this.isTimeDragging = false;
                viewModel = PlayerActivity.this.getViewModel();
                viewModel.onArchiveTimeSelected((long) slider4.getValue());
            }
        });
        slider3.setLabelFormatter(new LabelFormatter() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda25
            @Override // com.google.android.material.slider.LabelFormatter
            public final String getFormattedValue(float f) {
                String provideDefaultUi$lambda$28$lambda$22$lambda$21;
                provideDefaultUi$lambda$28$lambda$22$lambda$21 = PlayerActivity.provideDefaultUi$lambda$28$lambda$22$lambda$21(PlayerActivity.this, f);
                return provideDefaultUi$lambda$28$lambda$22$lambda$21;
            }
        });
        ImageView imageView2 = binding.btnToolbarBack;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerActivity.provideDefaultUi$lambda$28$lambda$23(PlayerActivity.this, view);
                }
            });
        }
        MaterialButton materialButton = binding.btnCancel;
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerActivity.provideDefaultUi$lambda$28$lambda$24(PlayerActivity.this, view);
                }
            });
        }
        binding.btnPlay.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerActivity.provideDefaultUi$lambda$28$lambda$25(PlayerActivity.this, view);
            }
        });
        binding.btnRewind.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerActivity.provideDefaultUi$lambda$28$lambda$26(PlayerActivity.this, view);
            }
        });
        binding.btnForward.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayerActivity.provideDefaultUi$lambda$28$lambda$27(PlayerActivity.this, view);
            }
        });
        binding.vvStream.setPlayer(this.streamPlayer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets provideDefaultUi$lambda$28$lambda$9(PlayerActivity this$0, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        if (this$0.getResources().getConfiguration().orientation == 2) {
            view.setPadding(insets.getSystemWindowInsetLeft(), insets.getSystemWindowInsetTop(), insets.getSystemWindowInsetRight(), view.getPaddingBottom());
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$12$lambda$10(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setRequestedOrientation(this$0.currentOrientationLandscape() ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets provideDefaultUi$lambda$28$lambda$12$lambda$11(ImageView this_apply, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = this_apply.getResources().getConfiguration().orientation;
        if (i == 1) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.getSystemWindowInsetBottom());
        } else if (i == 2) {
            int systemWindowInsetBottom = insets.getSystemWindowInsetBottom();
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), insets.getSystemWindowInsetRight(), systemWindowInsetBottom);
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets provideDefaultUi$lambda$28$lambda$13(PlayerActivity this$0, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = this$0.getResources().getConfiguration().orientation;
        if (i == 1) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.getSystemWindowInsetBottom());
        } else if (i == 2) {
            int systemWindowInsetBottom = insets.getSystemWindowInsetBottom();
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), insets.getSystemWindowInsetRight(), systemWindowInsetBottom);
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets provideDefaultUi$lambda$28$lambda$14(PlayerActivity this$0, View view, WindowInsets insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        int i = this$0.getResources().getConfiguration().orientation;
        if (i == 1) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), insets.getSystemWindowInsetBottom());
        } else if (i == 2) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), insets.getSystemWindowInsetRight(), view.getPaddingBottom());
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$15(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onStreamRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$16(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityResultLauncher<String[]> activityResultLauncher = this$0.callPermissionsResultReceiver;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("callPermissionsResultReceiver");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(new String[]{"android.permission.RECORD_AUDIO"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String provideDefaultUi$lambda$28$lambda$18$lambda$17(float f) {
        return ((int) f) + " ч";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String provideDefaultUi$lambda$28$lambda$20$lambda$19(PlayerActivity this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long j = 60;
        float f2 = 60;
        return this$0.withZero((this$0.getViewModel().getStreamTimeInSeconds().getValue().longValue() / j) / j) + ":" + this$0.withZero((long) ((f / f2) % f2)) + ":" + this$0.withZero((long) (f % f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String provideDefaultUi$lambda$28$lambda$22$lambda$21(PlayerActivity this$0, float f) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float f2 = 60;
        float f3 = f / f2;
        return this$0.withZero((long) (f3 / f2)) + ":" + this$0.withZero((long) (f3 % f2)) + ":" + this$0.withZero((long) (f % f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$23(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$24(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.stopDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$25(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onStreamPauseResume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$26(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayerViewModel viewModel = this$0.getViewModel();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ExoPlayer exoPlayer = this$0.streamPlayer;
        viewModel.onArchiveTimeSelected(timeUnit.toSeconds(exoPlayer != null ? exoPlayer.getCurrentPosition() : 0L) - 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDefaultUi$lambda$28$lambda$27(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PlayerViewModel viewModel = this$0.getViewModel();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ExoPlayer exoPlayer = this$0.streamPlayer;
        viewModel.onArchiveTimeSelected(timeUnit.toSeconds(exoPlayer != null ? exoPlayer.getCurrentPosition() : 0L) + 10);
    }

    private final void provideUiChanges() {
        PlayerViewModel viewModel = getViewModel();
        PlayerActivity playerActivity = this;
        viewModel.getScreenState().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new PlayerActivity$provideUiChanges$1$1(this, viewModel)));
        viewModel.isMicEnabled().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$2
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
                ActivityPlayerBinding binding;
                CallService callService;
                SipManager sipManager;
                binding = PlayerActivity.this.getBinding();
                binding.btnMic.setImageResource(Intrinsics.areEqual((Object) bool, (Object) true) ? R.drawable.ic_mic_enabled : R.drawable.ic_mic_disabled);
                callService = PlayerActivity.this.callService;
                if (callService == null || (sipManager = callService.getSipManager()) == null) {
                    return;
                }
                sipManager.isMicEnabled(Intrinsics.areEqual((Object) bool, (Object) true));
            }
        }));
        viewModel.isOpenDoorLoading().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$3
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
                ActivityPlayerBinding binding;
                binding = PlayerActivity.this.getBinding();
                ProgressBar progressIntercomOpening = binding.progressIntercomOpening;
                Intrinsics.checkNotNullExpressionValue(progressIntercomOpening, "progressIntercomOpening");
                ProgressBar progressBar = progressIntercomOpening;
                Intrinsics.checkNotNull(bool);
                progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
                binding.btnOpenIntercom.setClickable(!bool.booleanValue());
                binding.btnOpenIntercom.setAlpha(bool.booleanValue() ? 0.5f : 1.0f);
            }
        }));
        viewModel.isOpenDoorError().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                if (num != null) {
                    PlayerActivity playerActivity2 = PlayerActivity.this;
                    int intValue = num.intValue();
                    IntercomEmergencyCodeDialogFragment intercomEmergencyCodeDialogFragment = new IntercomEmergencyCodeDialogFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(NavArg.INTERCOM_EMERGENCY_CODE, intValue);
                    intercomEmergencyCodeDialogFragment.setArguments(bundle);
                    intercomEmergencyCodeDialogFragment.show(playerActivity2.getSupportFragmentManager(), (String) null);
                }
            }
        }));
        viewModel.getSelectedDay().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
            
                if (kotlin.jvm.internal.Intrinsics.areEqual(r9.getScreenState().getValue(), ru.tattelecom.intercom.feature.player.PlayerViewModel.PlayerState.IntercomArchive.INSTANCE) != false) goto L34;
             */
            /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
            /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(java.lang.Integer r9) {
                /*
                    r8 = this;
                    ru.tattelecom.intercom.feature.player.PlayerActivity r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.this
                    ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getBinding(r0)
                    ru.tattelecom.intercom.feature.player.PlayerActivity r1 = ru.tattelecom.intercom.feature.player.PlayerActivity.this
                    com.google.android.material.chip.ChipGroup r2 = r0.cgDays
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                    int r3 = r9.intValue()
                    android.view.View r2 = r2.getChildAt(r3)
                    com.google.android.material.chip.Chip r2 = (com.google.android.material.chip.Chip) r2
                    r3 = 1
                    if (r2 != 0) goto L1b
                    goto L1e
                L1b:
                    r2.setChecked(r3)
                L1e:
                    androidx.constraintlayout.widget.ConstraintLayout r2 = r0.clPlayerControls
                    java.lang.String r4 = "clPlayerControls"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
                    android.view.View r2 = (android.view.View) r2
                    int r4 = r9.intValue()
                    r5 = 7
                    r6 = 0
                    if (r4 == r5) goto L31
                    r4 = r3
                    goto L32
                L31:
                    r4 = r6
                L32:
                    r7 = 8
                    if (r4 == 0) goto L38
                    r4 = r6
                    goto L39
                L38:
                    r4 = r7
                L39:
                    r2.setVisibility(r4)
                    android.widget.ImageView r2 = r0.btnToolbarDownload
                    if (r2 != 0) goto L41
                    goto L61
                L41:
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                    android.view.View r2 = (android.view.View) r2
                    android.widget.LinearLayout r4 = r0.llDownloadProgress
                    if (r4 == 0) goto L58
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                    android.view.View r4 = (android.view.View) r4
                    int r4 = r4.getVisibility()
                    if (r4 != 0) goto L56
                    goto L58
                L56:
                    r4 = r3
                    goto L59
                L58:
                    r4 = r6
                L59:
                    if (r4 == 0) goto L5d
                    r4 = r6
                    goto L5e
                L5d:
                    r4 = r7
                L5e:
                    r2.setVisibility(r4)
                L61:
                    androidx.constraintlayout.widget.ConstraintLayout r0 = r0.clCallButtons
                    java.lang.String r2 = "clCallButtons"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                    android.view.View r0 = (android.view.View) r0
                    int r9 = r9.intValue()
                    if (r9 != r5) goto L85
                    ru.tattelecom.intercom.feature.player.PlayerViewModel r9 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getViewModel(r1)
                    androidx.lifecycle.MutableLiveData r9 = r9.getScreenState()
                    java.lang.Object r9 = r9.getValue()
                    ru.tattelecom.intercom.feature.player.PlayerViewModel$PlayerState$IntercomArchive r1 = ru.tattelecom.intercom.feature.player.PlayerViewModel.PlayerState.IntercomArchive.INSTANCE
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r1)
                    if (r9 == 0) goto L85
                    goto L86
                L85:
                    r3 = r6
                L86:
                    if (r3 == 0) goto L89
                    goto L8a
                L89:
                    r6 = r7
                L8a:
                    r0.setVisibility(r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$5.invoke2(java.lang.Integer):void");
            }
        }));
        viewModel.getStreamUrl().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r0 = r1.this$0.streamPlayer;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(java.lang.String r2) {
                /*
                    r1 = this;
                    if (r2 == 0) goto L14
                    ru.tattelecom.intercom.feature.player.PlayerActivity r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.this
                    androidx.media3.exoplayer.ExoPlayer r0 = ru.tattelecom.intercom.feature.player.PlayerActivity.access$getStreamPlayer$p(r0)
                    if (r0 == 0) goto L14
                    androidx.media3.common.MediaItem r2 = androidx.media3.common.MediaItem.fromUri(r2)
                    r0.setMediaItem(r2)
                    r0.prepare()
                L14:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$6.invoke2(java.lang.String):void");
            }
        }));
        viewModel.isStreamLoading().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$7
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
                ActivityPlayerBinding binding;
                binding = PlayerActivity.this.getBinding();
                ProgressBar progressVideoLoading = binding.progressVideoLoading;
                Intrinsics.checkNotNullExpressionValue(progressVideoLoading, "progressVideoLoading");
                ProgressBar progressBar = progressVideoLoading;
                Intrinsics.checkNotNull(bool);
                progressBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }));
        viewModel.getStreamLoadError().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$8
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
                ActivityPlayerBinding binding;
                binding = PlayerActivity.this.getBinding();
                LinearLayout llVideoError = binding.llVideoError;
                Intrinsics.checkNotNullExpressionValue(llVideoError, "llVideoError");
                LinearLayout linearLayout = llVideoError;
                Intrinsics.checkNotNull(bool);
                linearLayout.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        }));
        viewModel.isVideoZoomed().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$9
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
                CallService callService;
                SipManager sipManager;
                MutableStateFlow<Boolean> isVideoLoaded;
                PlayerActivity.this.getBinding();
                PlayerActivity playerActivity2 = PlayerActivity.this;
                callService = playerActivity2.callService;
                if (callService == null || (sipManager = callService.getSipManager()) == null || (isVideoLoaded = sipManager.isVideoLoaded()) == null || !isVideoLoaded.getValue().booleanValue()) {
                    playerActivity2.setStreamCrop(bool);
                } else {
                    playerActivity2.setSipVideoCrop(bool);
                }
            }
        }));
        viewModel.getDownloadSettings().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new Function1<Pair<? extends Long, ? extends Integer>, Unit>() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Long, ? extends Integer> pair) {
                invoke2((Pair<Long, Integer>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<Long, Integer> pair) {
                PlayerViewModel viewModel2;
                viewModel2 = PlayerActivity.this.getViewModel();
                viewModel2.setDownloadVideoOptions(pair.getFirst().longValue(), pair.getSecond().intValue());
            }
        }));
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(playerActivity), null, null, new PlayerActivity$provideUiChanges$1$11(this, viewModel, null), 3, null);
        viewModel.getDays().observe(playerActivity, new PlayerActivity$sam$androidx_lifecycle_Observer$0(new PlayerActivity$provideUiChanges$1$12(this)));
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(playerActivity), null, null, new PlayerActivity$provideUiChanges$1$13(this, viewModel, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(playerActivity), null, null, new PlayerActivity$provideUiChanges$1$14(this, viewModel, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(playerActivity), null, null, new PlayerActivity$provideUiChanges$1$15(this, viewModel, null), 3, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(playerActivity), null, null, new PlayerActivity$provideUiChanges$1$16(this, viewModel, null), 3, null);
        Flow<PlayerViewModel.Event> events = viewModel.getEvents();
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
        FlowKt.launchIn(FlowKt.onEach(FlowExtKt.flowWithLifecycle(events, lifecycle, Lifecycle.State.STARTED), new PlayerActivity$provideUiChanges$1$17(this, null)), LifecycleOwnerKt.getLifecycleScope(playerActivity));
        Flow<Boolean> eventShowErrorSnack = viewModel.getEventShowErrorSnack();
        Lifecycle lifecycle2 = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "<get-lifecycle>(...)");
        FlowKt.launchIn(FlowKt.onEach(FlowExtKt.flowWithLifecycle(eventShowErrorSnack, lifecycle2, Lifecycle.State.STARTED), new PlayerActivity$provideUiChanges$1$18(this, null)), LifecycleOwnerKt.getLifecycleScope(playerActivity));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideCallChanges() {
        SipManager sipManager;
        MutableStateFlow<Boolean> isVideoLoaded;
        Flow onEach;
        SipManager sipManager2;
        MutableStateFlow<CallState> callState;
        Flow onEach2;
        SipManager sipManager3;
        CallService callService = this.callService;
        if (callService != null && (sipManager3 = callService.getSipManager()) != null) {
            CaptureTextureView tvSipVideo = getBinding().tvSipVideo;
            Intrinsics.checkNotNullExpressionValue(tvSipVideo, "tvSipVideo");
            CaptureTextureView tvSipPreview = getBinding().tvSipPreview;
            Intrinsics.checkNotNullExpressionValue(tvSipPreview, "tvSipPreview");
            sipManager3.setVideoWindow(tvSipVideo, tvSipPreview);
        }
        CallService callService2 = this.callService;
        if (callService2 != null && (sipManager2 = callService2.getSipManager()) != null && (callState = sipManager2.getCallState()) != null) {
            Lifecycle lifecycle = getLifecycle();
            Intrinsics.checkNotNullExpressionValue(lifecycle, "<get-lifecycle>(...)");
            Flow flowWithLifecycle = FlowExtKt.flowWithLifecycle(callState, lifecycle, Lifecycle.State.STARTED);
            if (flowWithLifecycle != null && (onEach2 = FlowKt.onEach(flowWithLifecycle, new PlayerActivity$provideCallChanges$1(this, null))) != null) {
                FlowKt.launchIn(onEach2, LifecycleOwnerKt.getLifecycleScope(this));
            }
        }
        CallService callService3 = this.callService;
        if (callService3 == null || (sipManager = callService3.getSipManager()) == null || (isVideoLoaded = sipManager.isVideoLoaded()) == null) {
            return;
        }
        Lifecycle lifecycle2 = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle2, "<get-lifecycle>(...)");
        Flow flowWithLifecycle2 = FlowExtKt.flowWithLifecycle(isVideoLoaded, lifecycle2, Lifecycle.State.STARTED);
        if (flowWithLifecycle2 == null || (onEach = FlowKt.onEach(flowWithLifecycle2, new PlayerActivity$provideCallChanges$2(this, null))) == null) {
            return;
        }
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(PlayerViewModel.Event event) {
        SipManager sipManager;
        if (Intrinsics.areEqual(event, PlayerViewModel.Event.EndCall.INSTANCE)) {
            CallService callService = this.callService;
            if (callService != null) {
                callService.stopRinging();
            }
            CallService callService2 = this.callService;
            if (callService2 == null || (sipManager = callService2.getSipManager()) == null) {
                return;
            }
            sipManager.endCall();
            return;
        }
        ReviewManager reviewManager = null;
        if (Intrinsics.areEqual(event, PlayerViewModel.Event.RefreshTime.INSTANCE)) {
            if (this.isTimeDragging) {
                return;
            }
            PlayerViewModel viewModel = getViewModel();
            ExoPlayer exoPlayer = this.streamPlayer;
            viewModel.onStreamTimeReceived(exoPlayer != null ? Long.valueOf(exoPlayer.getCurrentPosition()) : null);
            return;
        }
        if (event instanceof PlayerViewModel.Event.SeekTo) {
            ExoPlayer exoPlayer2 = this.streamPlayer;
            if (exoPlayer2 != null) {
                exoPlayer2.seekTo(((PlayerViewModel.Event.SeekTo) event).getTime());
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(event, PlayerViewModel.Event.ShowInAppReview.INSTANCE)) {
            ReviewInfo reviewInfo = this.reviewInfo;
            if (reviewInfo != null) {
                ReviewManager reviewManager2 = this.reviewManager;
                if (reviewManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("reviewManager");
                } else {
                    reviewManager = reviewManager2;
                }
                reviewManager.launchReviewFlow(this, reviewInfo);
                return;
            }
            return;
        }
        if (event instanceof PlayerViewModel.Event.ShowMessage) {
            PlayerViewModel.Event.ShowMessage showMessage = (PlayerViewModel.Event.ShowMessage) event;
            String message = showMessage.getMessage();
            if (message != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "downloadError", false, 2, (Object) null)) {
                startVideoDialogFragment("state", "error");
            } else {
                Snackbar.make(getBinding().flRoot, StringResourceFinderKt.getMessageText(showMessage.getMessage(), this), -1).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String withZero(long number) {
        if (number / 10 != 0) {
            return String.valueOf(number);
        }
        return SessionDescription.SUPPORTED_SDP_VERSION + number;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideSliderValue(Slider slider, long value) {
        Float valueOf = slider != null ? Float.valueOf(slider.getValueFrom()) : null;
        Float valueOf2 = slider != null ? Float.valueOf(slider.getValueTo()) : null;
        if (valueOf == null || valueOf2 == null) {
            return;
        }
        float f = value;
        try {
            if (f < valueOf.floatValue()) {
                f = valueOf.floatValue();
            } else if (f > valueOf2.floatValue()) {
                f = valueOf2.floatValue();
            }
            slider.setValue(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStreamCrop(Boolean isZoomed) {
        if (isZoomed != null) {
            getBinding().vvStream.setResizeMode(isZoomed.booleanValue() ? 4 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSipVideoCrop(Boolean isZoomed) {
        SipManager sipManager;
        if (isZoomed != null) {
            boolean booleanValue = isZoomed.booleanValue();
            CallService callService = this.callService;
            if (callService == null || (sipManager = callService.getSipManager()) == null) {
                return;
            }
            boolean currentOrientationLandscape = currentOrientationLandscape();
            CaptureTextureView tvSipVideo = getBinding().tvSipVideo;
            Intrinsics.checkNotNullExpressionValue(tvSipVideo, "tvSipVideo");
            sipManager.setVideoCrop(currentOrientationLandscape, booleanValue, tvSipVideo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setOpenActivityOnLockScreen() {
        if (Build.VERSION.SDK_INT >= 27) {
            setTurnScreenOn(true);
            setShowWhenLocked(true);
        } else {
            getWindow().addFlags(2621569);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = getSystemService("keyguard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
            ((KeyguardManager) systemService).requestDismissKeyguard(this, null);
            return;
        }
        getWindow().addFlags(4194304);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean currentOrientationLandscape() {
        return getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClickRequestPermission() {
        if (Build.VERSION.SDK_INT > 32) {
            if (askReadMediaVideoPermission()) {
                setDownloadButtonClickListener();
                return;
            } else {
                this.requestPermissionLauncher.launch(new String[]{"android.permission.READ_MEDIA_VIDEO"});
                return;
            }
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (askReadExternalStoragePermission() && askWriteExternalStoragePermission()) {
                setDownloadButtonClickListener();
                return;
            } else {
                this.requestPermissionLauncher.launch(new String[]{PermissionUtil.READ_EXTERNAL_PERMISSION, PermissionUtil.WRITE_EXTERNAL_PERMISSION});
                return;
            }
        }
        if (askReadExternalStoragePermission()) {
            setDownloadButtonClickListener();
        } else {
            this.requestPermissionLauncher.launch(new String[]{PermissionUtil.READ_EXTERNAL_PERMISSION});
        }
    }

    private final boolean askReadExternalStoragePermission() {
        return ContextCompat.checkSelfPermission(this, PermissionUtil.READ_EXTERNAL_PERMISSION) == 0;
    }

    private final boolean askReadMediaVideoPermission() {
        return ContextCompat.checkSelfPermission(this, "android.permission.READ_MEDIA_VIDEO") == 0;
    }

    private final boolean askWriteExternalStoragePermission() {
        return ContextCompat.checkSelfPermission(this, PermissionUtil.WRITE_EXTERNAL_PERMISSION) == 0;
    }

    private final void setDownloadButtonClickListener() {
        boolean areEqual = Intrinsics.areEqual(getViewModel().getScreenState().getValue(), PlayerViewModel.PlayerState.IntercomArchive.INSTANCE);
        getViewModel().reportEvent(areEqual ? 37 : 41);
        String videoDescription = videoDescription();
        DownloadManager.Request destinationInExternalPublicDir = new DownloadManager.Request(Uri.parse(this.url)).addRequestHeader("access-token", getViewModel().getToken()).setTitle(videoDescription).setDescription("Загрузка").setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, File.separator + "Мой дом" + File.separator + videoDescription);
        destinationInExternalPublicDir.setNotificationVisibility(1);
        long enqueue = getDownloadManager().enqueue(destinationInExternalPublicDir);
        getViewModel().addDownload(new DownloadDto(this.urlDescription, enqueue, areEqual));
        setDownloadingStatus(true);
        registerContentObserver(enqueue);
    }

    private final String videoDescription() {
        return "Мой дом " + new SimpleDateFormat("HH-mm-ss", new Locale("ru", "RU")).format(Long.valueOf(new Date().getTime())) + ".mp4";
    }

    private final void stopDownload() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PlayerActivity$stopDownload$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pickDownloadState() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PlayerActivity$pickDownloadState$1(this, null), 3, null);
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
    public final void setDownloadingStatus(boolean status) {
        ImageView imageView;
        LinearLayout linearLayout = getBinding().llDownloadProgress;
        if (linearLayout != null) {
            linearLayout.setVisibility(status ? 0 : 8);
        }
        Integer value = getViewModel().getSelectedDay().getValue();
        if ((value != null && value.intValue() == 7) || (imageView = getBinding().btnToolbarDownload) == null) {
            return;
        }
        imageView.setVisibility(status ? 8 : 0);
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
                    int i3 = (int) ((i * 100) / i2);
                    ProgressBar progressBar = getBinding().pbDownload;
                    if (progressBar != null) {
                        progressBar.setProgress(i3);
                    }
                    TextView textView = getBinding().tvDownloadProgress;
                    if (textView != null) {
                        textView.setText(i3 + "%");
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } finally {
        }
    }

    public final void onDownloadComplete(long downloadId) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new PlayerActivity$onDownloadComplete$1(this, downloadId, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeDownload(DownloadDto model) {
        getViewModel().removeDownload(model);
        getDownloadManager().remove(model.getDownloadId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerContentObserver(long downloadId) {
        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads/" + downloadId), false, this.observer);
    }

    static /* synthetic */ void startVideoDialogFragment$default(PlayerActivity playerActivity, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            obj = null;
        }
        playerActivity.startVideoDialogFragment(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startVideoDialogFragment(String key, Object value) {
        VideoDownloadDialogFragment videoDownloadDialogFragment = new VideoDownloadDialogFragment();
        if (key == null || value == null) {
            return;
        }
        Bundle bundle = new Bundle();
        if (value instanceof String) {
            bundle.putString(key, (String) value);
        } else if (value instanceof Integer) {
            bundle.putInt(key, ((Number) value).intValue());
        }
        videoDownloadDialogFragment.setArguments(bundle);
        videoDownloadDialogFragment.show(getSupportFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void archiveDaysSetOnClickListener(PlayerViewModel.PlayerState state) {
        final int i = 0;
        if (Intrinsics.areEqual(state, PlayerViewModel.PlayerState.IntercomArchive.INSTANCE)) {
            ChipGroup cgDays = getBinding().cgDays;
            Intrinsics.checkNotNullExpressionValue(cgDays, "cgDays");
            final int i2 = 0;
            for (View view : ViewGroupKt.getChildren(cgDays)) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view2 = view;
                if ((getViewModel().getStreamArchiveService() == 7 || getViewModel().getStreamArchiveService() == 2) && i2 > 4) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    ((Chip) view2).setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            PlayerActivity.archiveDaysSetOnClickListener$lambda$42$lambda$36(PlayerActivity.this, i2, view3);
                        }
                    });
                } else if (getViewModel().getStreamArchiveService() == 7 && i2 <= 4) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    ((Chip) view2).setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            PlayerActivity.archiveDaysSetOnClickListener$lambda$42$lambda$37(PlayerActivity.this, i2, view3);
                        }
                    });
                } else if (getViewModel().getStreamArchiveService() == 2 && i2 <= 4) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    Chip chip = (Chip) view2;
                    chip.setCheckable(false);
                    chip.setAlpha(0.5f);
                    chip.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            PlayerActivity.archiveDaysSetOnClickListener$lambda$42$lambda$39$lambda$38(PlayerActivity.this, view3);
                        }
                    });
                } else {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    Chip chip2 = (Chip) view2;
                    if (i2 < 7) {
                        chip2.setVisibility(8);
                    }
                    chip2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda9
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            PlayerActivity.archiveDaysSetOnClickListener$lambda$42$lambda$41$lambda$40(PlayerActivity.this, i2, view3);
                        }
                    });
                }
                i2 = i3;
            }
            return;
        }
        ChipGroup cgDays2 = getBinding().cgDays;
        Intrinsics.checkNotNullExpressionValue(cgDays2, "cgDays");
        for (View view3 : ViewGroupKt.getChildren(cgDays2)) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view4 = view3;
            Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            ((Chip) view4).setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    PlayerActivity.archiveDaysSetOnClickListener$lambda$44$lambda$43(PlayerActivity.this, i, view5);
                }
            });
            i = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$42$lambda$36(PlayerActivity this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(9);
        this$0.getViewModel().onDayClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$42$lambda$37(PlayerActivity this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(11);
        this$0.getViewModel().onDayClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$42$lambda$39$lambda$38(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().reportEvent(10);
        showAttentionCustomSnackBar$default(this$0, R.string.need_internet_subscription, ApartmentServiceName.STREAM_ARCHIVE_7DAYS, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$42$lambda$41$lambda$40(PlayerActivity this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$44$lambda$43(PlayerActivity this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayClick(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showErrorSnackBar(int text) {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_custom_attention, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarCustomAttentionBinding bind = SnackbarCustomAttentionBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        final Snackbar make = Snackbar.make(getBinding().flRoot, "", -2);
        Intrinsics.checkNotNullExpressionValue(make, "make(...)");
        View view = make.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        View view2 = make.getView();
        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            layoutParams2.topMargin = getResources().getDimensionPixelSize(identifier) + ExtensionsKt.getDp(8);
        }
        layoutParams2.gravity = 48;
        view2.setLayoutParams(layoutParams2);
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(inflate, 0);
        make.getView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bg_rounded_dialog_16dp, null));
        bind.clRoot.setPadding(ExtensionsKt.getDp(16), ExtensionsKt.getDp(12), ExtensionsKt.getDp(16), ExtensionsKt.getDp(12));
        bind.tvAttentionInfo.setText(text);
        bind.btnBecomeSubscriber.setText(R.string.good);
        bind.btnClose.setVisibility(8);
        bind.tvAttentionTitle.setVisibility(8);
        bind.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlayerActivity.showErrorSnackBar$lambda$46$lambda$45(Snackbar.this, view3);
            }
        });
        make.addCallback(new Snackbar.Callback() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$showErrorSnackBar$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.snackbar.Snackbar.Callback, com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onDismissed(Snackbar transientBottomBar, int event) {
                PlayerViewModel viewModel;
                viewModel = PlayerActivity.this.getViewModel();
                viewModel.isBadConnBannerClosed().setValue(true);
                super.onDismissed(transientBottomBar, event);
            }
        });
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showErrorSnackBar$lambda$46$lambda$45(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        Resources resources;
        DisplayMetrics displayMetrics;
        Resources resources2;
        Configuration configuration = new Configuration((newBase == null || (resources2 = newBase.getResources()) == null) ? null : resources2.getConfiguration());
        configuration.fontScale = 1.0f;
        if (newBase != null && (resources = newBase.getResources()) != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            configuration.densityDpi = (int) (((int) displayMetrics.xdpi) * 1.2d);
        }
        applyOverrideConfiguration(configuration);
        super.attachBaseContext(newBase);
    }

    static /* synthetic */ void showAttentionCustomSnackBar$default(PlayerActivity playerActivity, int i, String str, Boolean bool, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bool = null;
        }
        playerActivity.showAttentionCustomSnackBar(i, str, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAttentionCustomSnackBar(int text, final String serviceName, final Boolean isIntercomStream) {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_custom_attention, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarCustomAttentionBinding bind = SnackbarCustomAttentionBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        final Snackbar make = Snackbar.make(getBinding().flRoot, "", -2);
        Intrinsics.checkNotNullExpressionValue(make, "make(...)");
        View view = make.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        View view2 = make.getView();
        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            layoutParams2.topMargin = getResources().getDimensionPixelSize(identifier) + 16;
        }
        layoutParams2.gravity = 48;
        view2.setLayoutParams(layoutParams2);
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(inflate, 0);
        make.getView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bg_rounded_dialog_16dp, null));
        bind.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda31
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlayerActivity.showAttentionCustomSnackBar$lambda$50$lambda$48(Snackbar.this, view3);
            }
        });
        bind.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PlayerActivity.showAttentionCustomSnackBar$lambda$50$lambda$49(serviceName, this, isIntercomStream, make, view3);
            }
        });
        bind.tvAttentionInfo.setText(text);
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$50$lambda$48(Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        snackbar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAttentionCustomSnackBar$lambda$50$lambda$49(String serviceName, PlayerActivity this$0, Boolean bool, Snackbar snackbar, View view) {
        Intrinsics.checkNotNullParameter(serviceName, "$serviceName");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(snackbar, "$snackbar");
        if (Intrinsics.areEqual(serviceName, ApartmentServiceName.STREAM_ARCHIVE_7DAYS)) {
            this$0.getViewModel().reportEvent(12);
        } else if (Intrinsics.areEqual(serviceName, ApartmentServiceName.VIDEO_DOWNLOAD_ABILITY) && Intrinsics.areEqual((Object) bool, (Object) true)) {
            this$0.getViewModel().reportEvent(39);
        }
        Intent intent = new Intent(this$0, (Class<?>) LeaveOrderActivity.class);
        intent.putExtra("previousPage", NavGraphDestinations.Dest.INSTANCE.getPlayer());
        this$0.startActivity(intent);
        snackbar.dismiss();
    }
}
