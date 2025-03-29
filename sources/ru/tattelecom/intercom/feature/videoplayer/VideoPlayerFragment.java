package ru.tattelecom.intercom.feature.videoplayer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.Settings;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
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
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.FragmentKt;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.ToolbarKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.customview.Tooltip;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.videoplayer.PlayerState;
import ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet.ArchiveDateBottomSheet;
import ru.tattelecom.intercom.feature.videoplayer.databinding.FragmentVideoPlayerBinding;
import ru.tattelecom.intercom.feature.videoplayer.databinding.SnackbarPlayerCustomBinding;
import ru.tattelecom.intercom.feature.videoplayer.databinding.SnackbarPlayerMessageBinding;
import ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadDialog;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel;
import ru.tattelecom.intercom.feature.videoplayer.extensions.ExtensionsKt;
import ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureDetector;
import ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem;
import ru.tattelecom.intercom.feature.videoplayer.model.EventItem;
import ru.tattelecom.intercom.feature.videoplayer.model.PlayerEvent;
import ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackDialog;
import ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar;
import ru.tattelecom.intercom.feature.videoplayer.timelineView.VideoTimeBar;

/* compiled from: VideoPlayerFragment.kt */
@Metadata(d1 = {"\u0000\u0082\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0002\u000e\u0015\u0018\u0000 ´\u00012\u00020\u0001:\u0002´\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020,H\u0002J\b\u0010G\u001a\u00020,H\u0003J\b\u0010H\u001a\u00020,H\u0002J\u001a\u0010I\u001a\u00020,2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010L\u001a\u00020,H\u0002J\u0010\u0010M\u001a\u00020#2\u0006\u0010N\u001a\u00020KH\u0002J\b\u0010O\u001a\u00020KH\u0002J\u0010\u0010P\u001a\u00020C2\u0006\u0010J\u001a\u00020KH\u0003J\b\u0010Q\u001a\u00020CH\u0002J\b\u0010R\u001a\u00020CH\u0002J\b\u0010S\u001a\u00020,H\u0002J\b\u0010T\u001a\u00020CH\u0002J\b\u0010U\u001a\u00020CH\u0002J\b\u0010V\u001a\u00020CH\u0002J\b\u0010W\u001a\u00020CH\u0002J\b\u0010X\u001a\u00020CH\u0003J\b\u0010Y\u001a\u00020CH\u0002J\b\u0010Z\u001a\u00020CH\u0016J\b\u0010[\u001a\u00020CH\u0002J\b\u0010\\\u001a\u00020CH\u0016J\b\u0010]\u001a\u00020CH\u0016J\u0010\u0010^\u001a\u00020C2\u0006\u0010_\u001a\u00020`H\u0016J\u0010\u0010a\u001a\u00020C2\u0006\u0010b\u001a\u00020cH\u0007J\b\u0010d\u001a\u00020CH\u0016J\b\u0010e\u001a\u00020CH\u0016J\u001a\u0010f\u001a\u00020C2\u0006\u0010g\u001a\u00020h2\b\u0010i\u001a\u0004\u0018\u00010`H\u0016J\u0012\u0010j\u001a\u00020C2\b\u0010i\u001a\u0004\u0018\u00010`H\u0016J\u001e\u0010k\u001a\u00020C2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020n0m2\u0006\u0010o\u001a\u00020cH\u0002J\u0010\u0010p\u001a\u00020C2\u0006\u0010q\u001a\u00020KH\u0002J\u0016\u0010r\u001a\u00020C2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020n0mH\u0002J\u0010\u0010t\u001a\u00020C2\u0006\u0010u\u001a\u00020vH\u0002J\u0010\u0010w\u001a\u00020C2\u0006\u0010x\u001a\u00020,H\u0002J\u0010\u0010y\u001a\u00020C2\u0006\u0010z\u001a\u00020,H\u0002J%\u0010{\u001a\u00020C2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0002\u0010~J\u0012\u0010\u007f\u001a\u00020C2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0002J\u0014\u0010\u0082\u0001\u001a\u00020C2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010EH\u0002J\t\u0010\u0084\u0001\u001a\u00020CH\u0002J\u0012\u0010\u0085\u0001\u001a\u00020C2\u0007\u0010\u0086\u0001\u001a\u00020,H\u0002J\u0011\u0010\u0087\u0001\u001a\u00020C2\u0006\u0010J\u001a\u00020KH\u0002J\t\u0010\u0088\u0001\u001a\u00020CH\u0002J\t\u0010\u0089\u0001\u001a\u00020CH\u0002J\t\u0010\u008a\u0001\u001a\u00020CH\u0003J\t\u0010\u008b\u0001\u001a\u00020CH\u0002J\t\u0010\u008c\u0001\u001a\u00020CH\u0002J\t\u0010\u008d\u0001\u001a\u00020CH\u0003J\t\u0010\u008e\u0001\u001a\u00020CH\u0003J\u0013\u0010\u008f\u0001\u001a\u00020C2\b\u0010i\u001a\u0004\u0018\u00010`H\u0002J\u001b\u0010\u0090\u0001\u001a\u00020C2\u0007\u0010\u0091\u0001\u001a\u00020,2\u0007\u0010\u0092\u0001\u001a\u00020KH\u0002J\u0012\u0010\u0093\u0001\u001a\u00020C2\u0007\u0010\u0094\u0001\u001a\u00020hH\u0002J\t\u0010\u0095\u0001\u001a\u00020CH\u0002J\u0012\u0010\u0096\u0001\u001a\u00020C2\u0007\u0010u\u001a\u00030\u0097\u0001H\u0003J\u0012\u0010\u0098\u0001\u001a\u00020C2\u0007\u0010u\u001a\u00030\u0099\u0001H\u0003J\t\u0010\u009a\u0001\u001a\u00020CH\u0002J#\u0010\u009b\u0001\u001a\u00020C2\u0007\u0010\u009c\u0001\u001a\u00020#2\u0007\u0010\u009d\u0001\u001a\u00020#2\u0006\u0010N\u001a\u00020KH\u0002J\"\u0010\u009e\u0001\u001a\u00020C2\u0017\u0010\u009f\u0001\u001a\u0012\u0012\u0007\u0012\u0005\u0018\u00010¡\u0001\u0012\u0004\u0012\u00020C0 \u0001H\u0003J!\u0010¢\u0001\u001a\u00020C2\u0006\u0010N\u001a\u00020K2\u0007\u0010£\u0001\u001a\u00020K2\u0007\u0010\u009d\u0001\u001a\u00020#J<\u0010¤\u0001\u001a\u00020C\"\u0005\b\u0000\u0010¥\u0001*\n\u0012\u0005\u0012\u0003H¥\u00010¦\u00012\u0007\u0010D\u001a\u00030§\u00012\u0015\u0010¨\u0001\u001a\u0010\u0012\u0005\u0012\u0003H¥\u0001\u0012\u0004\u0012\u00020C0 \u0001H\u0002J\u0016\u0010©\u0001\u001a\u00020C*\u00020\u00042\u0007\u0010\u0092\u0001\u001a\u00020KH\u0002J\r\u0010ª\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010«\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010¬\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010\u00ad\u0001\u001a\u00020C*\u00020\u0004H\u0003J\r\u0010®\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010¯\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010°\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010±\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010²\u0001\u001a\u00020C*\u00020\u0004H\u0002J\r\u0010³\u0001\u001a\u00020C*\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010 \u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020# $*\n\u0012\u0004\u0012\u00020#\u0018\u00010\"0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R(\u00104\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020# $*\n\u0012\u0004\u0012\u00020#\u0018\u00010\"0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u00105\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u001d\u001a\u0004\b7\u00108R\u0010\u0010:\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010\u001d\u001a\u0004\b=\u0010>R\u000e\u0010@\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006µ\u0001"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/FragmentVideoPlayerBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/FragmentVideoPlayerBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "chipDateFormatter", "Ljava/text/SimpleDateFormat;", "chipToolTip", "Lru/tattelecom/intercom/android/resources/customview/Tooltip;", "connectionReceiver", "ru/tattelecom/intercom/feature/videoplayer/VideoPlayerFragment$connectionReceiver$1", "Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerFragment$connectionReceiver$1;", "controlHandler", "Landroid/os/Handler;", "controlRunnable", "Ljava/lang/Runnable;", "cursorListener", "ru/tattelecom/intercom/feature/videoplayer/VideoPlayerFragment$cursorListener$1", "Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerFragment$cursorListener$1;", "dateFormatter", "downloadManager", "Landroid/app/DownloadManager;", "getDownloadManager", "()Landroid/app/DownloadManager;", "downloadManager$delegate", "Lkotlin/Lazy;", "downloadReceiver", "Landroid/content/BroadcastReceiver;", "eventPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "eventsAdapter", "Lru/tattelecom/intercom/feature/videoplayer/EventsAdapter;", "gestureDetector", "Lru/tattelecom/intercom/feature/videoplayer/gestures/VideoPlayerGestureDetector;", "isForcedOrientation", "isForcedOrientationKey", "isTimeDragging", "", "observerList", "", "Lru/tattelecom/intercom/feature/videoplayer/DownloadObserver;", "orientationEventListener", "Landroid/view/OrientationEventListener;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "requestPermissionLauncher", "sharedViewModel", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "getSharedViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "sharedViewModel$delegate", "timeBarToolTip", "viewModel", "Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "getViewModel", "()Lru/tattelecom/intercom/feature/videoplayer/VideoPlayerViewModel;", "viewModel$delegate", "zoomHandler", "zoomRunnable", "archiveDaysSetOnClickListener", "", "state", "Lru/tattelecom/intercom/feature/videoplayer/PlayerState;", "askReadExternalStoragePermission", "askReadMediaVideoPermission", "askWriteExternalStoragePermission", "checkDownloadStatus", "downloadId", "", "isFirstCheck", "generateVideoDescription", "startTime", "getCurrentDayStartTime", "getDownloadProgress", "initAdapter", "initSensor", "isOrientationLandscape", "keepControlButtons", "keepScaleFactorView", "maybeDisableRewindButtons", "maybeShowDoubleTapBanner", "onBackPressed", "onClickRequestPermission", "onDestroyView", "onDownloadClick", "onPause", "onResume", "onSaveInstanceState", "outState", "Landroid/os/Bundle;", "onScreenRotate", "orientation", "", "onStart", "onStop", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "onViewStateRestored", "provideChipState", "days", "", "Ljava/util/Date;", "dayId", "provideCursorTime", CrashHianalyticsData.TIME, "provideDayList", VideoPlayerViewModel.DAY_LIST, "provideEvent", NotificationCompat.CATEGORY_EVENT, "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "provideFavoriteButton", "isFavorite", "provideMenuState", "isVisible", "provideOpenDoorButton", VideoPlayerViewModel.IS_OPEN_DOOR_LOADING, "isOpenDoorEnabled", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "providePlayerZoom", "scaleValue", "", "provideScreenState", "playerState", "provideUiChanges", "registerConnectionChecker", "turnOn", "registerContentObserver", "registerDownloadObserversOrCompleteDownloads", "registerOnBackPressedCallback", "registerReceivers", "setDownloadButtonClickListener", "setupMenu", "setupPlayer", "setupPlayerControls", "setupScreen", "setupTimeline", "recreate", "timeInMs", "showArchiveToolTip", "child", "showConnectServicesBanner", "showCustomSnackBar", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowCustomSnackBar;", "showMessageSnackBar", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowMessageSnackBar;", "showTimelineToolTip", "startDownload", "url", "eventId", "takeScreenshot", "callback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "tryToStartDownload", "duration", "collectOnLifecycle", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/SharedFlow;", "Landroidx/lifecycle/Lifecycle$State;", "lambda", "scrollCursorTo", "setupDownloadButton", "setupFastForwardButton", "setupFavoriteButton", "setupFullScreenButton", "setupPlayButton", "setupPlaybackSpeedButton", "setupRefreshButton", "setupRewindButton", "setupScreenshotButton", "setupVolumeButton", "Companion", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoPlayerFragment extends Fragment {
    private static final long CONTROL_HIDE_DELAY = 3000;
    private static final String LAND = "LAND";
    private static final String PORTRAIT = "PORTRAIT";
    private static final long ZOOM_HIDE_DELAY = 3000;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private final SimpleDateFormat chipDateFormatter;
    private Tooltip chipToolTip;
    private VideoPlayerFragment$connectionReceiver$1 connectionReceiver;
    private final Handler controlHandler;
    private final Runnable controlRunnable;
    private final VideoPlayerFragment$cursorListener$1 cursorListener;
    private final SimpleDateFormat dateFormatter;

    /* renamed from: downloadManager$delegate, reason: from kotlin metadata */
    private final Lazy downloadManager;
    private final BroadcastReceiver downloadReceiver;
    private final ActivityResultLauncher<String[]> eventPermissionLauncher;
    private EventsAdapter eventsAdapter;
    private VideoPlayerGestureDetector gestureDetector;
    private String isForcedOrientation;
    private String isForcedOrientationKey;
    private boolean isTimeDragging;
    private final List<DownloadObserver> observerList;
    private OrientationEventListener orientationEventListener;
    private ExoPlayer player;
    private final ActivityResultLauncher<String[]> requestPermissionLauncher;

    /* renamed from: sharedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy sharedViewModel;
    private Tooltip timeBarToolTip;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private final Handler zoomHandler;
    private final Runnable zoomRunnable;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(VideoPlayerFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/videoplayer/databinding/FragmentVideoPlayerBinding;", 0))};

    /* JADX WARN: Type inference failed for: r0v16, types: [ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$connectionReceiver$1] */
    /* JADX WARN: Type inference failed for: r0v23, types: [ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$cursorListener$1] */
    public VideoPlayerFragment() {
        super(R.layout.fragment_video_player);
        final VideoPlayerFragment videoPlayerFragment = this;
        final Function0<FragmentActivity> function0 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$special$$inlined$activityViewModel$default$1
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
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<VideoPlayerViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$special$$inlined$activityViewModel$default$2
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
        final Function0<FragmentActivity> function04 = new Function0<FragmentActivity>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$special$$inlined$activityViewModel$default$3
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
        this.sharedViewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<DownloadViewModel>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$special$$inlined$activityViewModel$default$4
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
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(videoPlayerFragment, FragmentVideoPlayerBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        this.dateFormatter = new SimpleDateFormat("EE, d MMM", new Locale("RU"));
        this.chipDateFormatter = new SimpleDateFormat("EE, dd.MM", new Locale("RU"));
        this.observerList = new ArrayList();
        this.isForcedOrientationKey = "isForcedOrientationKey";
        this.downloadManager = LazyKt.lazy(new Function0<DownloadManager>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$downloadManager$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DownloadManager invoke() {
                Object systemService = VideoPlayerFragment.this.requireContext().getSystemService("download");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.DownloadManager");
                return (DownloadManager) systemService;
            }
        });
        this.controlHandler = new Handler(Looper.getMainLooper());
        this.controlRunnable = new Runnable() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayerFragment.controlRunnable$lambda$0(VideoPlayerFragment.this);
            }
        };
        this.zoomHandler = new Handler(Looper.getMainLooper());
        this.zoomRunnable = new Runnable() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                VideoPlayerFragment.zoomRunnable$lambda$1(VideoPlayerFragment.this);
            }
        };
        this.connectionReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$connectionReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                VideoPlayerViewModel viewModel;
                VideoPlayerViewModel viewModel2;
                viewModel = VideoPlayerFragment.this.getViewModel();
                if (Intrinsics.areEqual((Object) viewModel.isBadConnBannerClosed().getValue(), (Object) false)) {
                    viewModel2 = VideoPlayerFragment.this.getViewModel();
                    viewModel2.checkVpnConnection(context);
                }
            }
        };
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda14
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                VideoPlayerFragment.requestPermissionLauncher$lambda$5(VideoPlayerFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.requestPermissionLauncher = registerForActivityResult;
        ActivityResultLauncher<String[]> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda15
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                VideoPlayerFragment.eventPermissionLauncher$lambda$9(VideoPlayerFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "registerForActivityResult(...)");
        this.eventPermissionLauncher = registerForActivityResult2;
        this.cursorListener = new ScalableScaleBar.OnCursorListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$cursorListener$1
            @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.OnCursorListener
            public void onStart(long cursorValue) {
                boolean isOrientationLandscape;
                ExoPlayer exoPlayer;
                FragmentVideoPlayerBinding binding;
                VideoPlayerViewModel viewModel;
                FragmentVideoPlayerBinding binding2;
                isOrientationLandscape = VideoPlayerFragment.this.isOrientationLandscape();
                if (isOrientationLandscape) {
                    VideoPlayerFragment.this.keepControlButtons();
                }
                VideoPlayerFragment.this.isTimeDragging = true;
                exoPlayer = VideoPlayerFragment.this.player;
                if (exoPlayer != null) {
                    exoPlayer.pause();
                }
                binding = VideoPlayerFragment.this.getBinding();
                TextView textView = binding.tvCursorTime;
                viewModel = VideoPlayerFragment.this.getViewModel();
                textView.setText(viewModel.convertTimeToPattern(cursorValue));
                binding2 = VideoPlayerFragment.this.getBinding();
                TextView tvCursorTime = binding2.tvCursorTime;
                Intrinsics.checkNotNullExpressionValue(tvCursorTime, "tvCursorTime");
                tvCursorTime.setVisibility(0);
            }

            @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.OnCursorListener
            public void onMoving(long cursorValue) {
                boolean isOrientationLandscape;
                FragmentVideoPlayerBinding binding;
                VideoPlayerViewModel viewModel;
                isOrientationLandscape = VideoPlayerFragment.this.isOrientationLandscape();
                if (isOrientationLandscape) {
                    VideoPlayerFragment.this.keepControlButtons();
                }
                binding = VideoPlayerFragment.this.getBinding();
                TextView textView = binding.tvCursorTime;
                viewModel = VideoPlayerFragment.this.getViewModel();
                textView.setText(viewModel.convertTimeToPattern(cursorValue));
            }

            @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.OnCursorListener
            public void onEnd(long cursorValue) {
                boolean isOrientationLandscape;
                ExoPlayer exoPlayer;
                VideoPlayerViewModel viewModel;
                FragmentVideoPlayerBinding binding;
                VideoPlayerViewModel viewModel2;
                VideoPlayerViewModel viewModel3;
                VideoPlayerViewModel viewModel4;
                FragmentVideoPlayerBinding binding2;
                FragmentVideoPlayerBinding binding3;
                VideoPlayerViewModel viewModel5;
                VideoPlayerViewModel viewModel6;
                isOrientationLandscape = VideoPlayerFragment.this.isOrientationLandscape();
                if (isOrientationLandscape) {
                    VideoPlayerFragment.this.keepControlButtons();
                }
                exoPlayer = VideoPlayerFragment.this.player;
                if (exoPlayer != null) {
                    exoPlayer.prepare();
                }
                VideoPlayerFragment.this.isTimeDragging = false;
                viewModel = VideoPlayerFragment.this.getViewModel();
                Integer value = viewModel.getSelectedDayId().getValue();
                VideoPlayerFragment videoPlayerFragment2 = VideoPlayerFragment.this;
                int intValue = value.intValue();
                Calendar calendar = Calendar.getInstance();
                if ((intValue == -1 || intValue == 6) && cursorValue >= calendar.getTimeInMillis() - 5000) {
                    binding = videoPlayerFragment2.getBinding();
                    TextView textView = binding.tvCursorTime;
                    viewModel2 = videoPlayerFragment2.getViewModel();
                    textView.setText(viewModel2.convertTimeToPattern(Calendar.getInstance().getTimeInMillis()));
                    viewModel3 = videoPlayerFragment2.getViewModel();
                    viewModel3.onDayClick(-1);
                } else {
                    binding3 = videoPlayerFragment2.getBinding();
                    TextView textView2 = binding3.tvCursorTime;
                    viewModel5 = videoPlayerFragment2.getViewModel();
                    textView2.setText(viewModel5.convertTimeToPattern(cursorValue));
                    viewModel6 = videoPlayerFragment2.getViewModel();
                    VideoPlayerViewModel.onArchiveTimeSelected$default(viewModel6, cursorValue, false, 2, null);
                }
                VideoPlayerFragment.this.maybeDisableRewindButtons();
                viewModel4 = VideoPlayerFragment.this.getViewModel();
                if (viewModel4.isMenuShown().getValue().booleanValue()) {
                    return;
                }
                binding2 = VideoPlayerFragment.this.getBinding();
                TextView tvCursorTime = binding2.tvCursorTime;
                Intrinsics.checkNotNullExpressionValue(tvCursorTime, "tvCursorTime");
                tvCursorTime.setVisibility(8);
            }
        };
        this.downloadReceiver = new BroadcastReceiver() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$downloadReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                List list;
                List list2;
                ContentResolver contentResolver;
                Long valueOf = intent != null ? Long.valueOf(intent.getLongExtra("extra_download_id", -1L)) : null;
                if (valueOf == null || !VideoPlayerFragment.checkDownloadStatus$default(VideoPlayerFragment.this, valueOf.longValue(), false, 2, null)) {
                    return;
                }
                try {
                    list = VideoPlayerFragment.this.observerList;
                    ArrayList<DownloadObserver> arrayList = new ArrayList();
                    for (Object obj : list) {
                        long downloadId = ((DownloadObserver) obj).getDownloadId();
                        if (valueOf != null && downloadId == valueOf.longValue()) {
                            arrayList.add(obj);
                        }
                    }
                    VideoPlayerFragment videoPlayerFragment2 = VideoPlayerFragment.this;
                    for (DownloadObserver downloadObserver : arrayList) {
                        FragmentActivity activity = videoPlayerFragment2.getActivity();
                        if (activity != null && (contentResolver = activity.getContentResolver()) != null) {
                            contentResolver.unregisterContentObserver(downloadObserver);
                        }
                        list2 = videoPlayerFragment2.observerList;
                        list2.remove(downloadObserver);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoPlayerViewModel getViewModel() {
        return (VideoPlayerViewModel) this.viewModel.getValue();
    }

    private final DownloadViewModel getSharedViewModel() {
        return (DownloadViewModel) this.sharedViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final FragmentVideoPlayerBinding getBinding() {
        return (FragmentVideoPlayerBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final DownloadManager getDownloadManager() {
        return (DownloadManager) this.downloadManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void controlRunnable$lambda$0(VideoPlayerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().changeMenuState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zoomRunnable$lambda$1(VideoPlayerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getBinding().tvScaleFactor.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$5(final VideoPlayerFragment this$0, Map map) {
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
            new MaterialAlertDialogBuilder(this$0.requireContext()).setMessage(R.string.download_need_permission).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda36
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    VideoPlayerFragment.requestPermissionLauncher$lambda$5$lambda$3(VideoPlayerFragment.this, dialogInterface, i);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda37
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermissionLauncher$lambda$5$lambda$3(VideoPlayerFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context context = this$0.getContext();
        intent.setData(Uri.fromParts("package", context != null ? context.getPackageName() : null, null));
        this$0.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eventPermissionLauncher$lambda$9(final VideoPlayerFragment this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator it = map.entrySet().iterator();
        boolean z = true;
        while (it.hasNext()) {
            if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        new MaterialAlertDialogBuilder(this$0.requireContext()).setMessage(R.string.download_need_permission).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda33
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VideoPlayerFragment.eventPermissionLauncher$lambda$9$lambda$7(VideoPlayerFragment.this, dialogInterface, i);
            }
        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda34
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eventPermissionLauncher$lambda$9$lambda$7(VideoPlayerFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        Context context = this$0.getContext();
        intent.setData(Uri.fromParts("package", context != null ? context.getPackageName() : null, null));
        this$0.startActivity(intent);
    }

    private final void registerOnBackPressedCallback() {
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, this, false, new Function1<OnBackPressedCallback, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$registerOnBackPressedCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback addCallback) {
                Tooltip tooltip;
                Tooltip tooltip2;
                Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
                tooltip = VideoPlayerFragment.this.chipToolTip;
                if (tooltip != null) {
                    tooltip.dismiss();
                }
                tooltip2 = VideoPlayerFragment.this.timeBarToolTip;
                if (tooltip2 != null) {
                    tooltip2.dismiss();
                }
                VideoPlayerFragment.this.onBackPressed();
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackPressed() {
        requireActivity().setRequestedOrientation(1);
        if (isOrientationLandscape()) {
            return;
        }
        requireActivity().getViewModelStore().clear();
        FragmentKt.findNavController(this).navigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        registerReceivers();
        registerDownloadObserversOrCompleteDownloads();
        initAdapter();
        initSensor();
        registerOnBackPressedCallback();
        setupScreen(savedInstanceState);
        setupPlayer();
        setupPlayerControls();
        setupMenu();
        setupTimeline(true, Calendar.getInstance().getTimeInMillis());
        getViewModel().changeMenuState(true);
        keepControlButtons();
        provideUiChanges();
        showTimelineToolTip();
    }

    private final void registerDownloadObserversOrCompleteDownloads() {
        Iterator<T> it = getViewModel().getDownloadListFlow().getValue().iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(getViewModel()), null, null, new VideoPlayerFragment$registerDownloadObserversOrCompleteDownloads$1$1(this, (DownloadItem) it.next(), null), 3, null);
        }
    }

    private final void registerReceivers() {
        if (Build.VERSION.SDK_INT >= 33) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.registerReceiver(this.downloadReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
                return;
            }
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.registerReceiver(this.downloadReceiver, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(this.isForcedOrientationKey, this.isForcedOrientation);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        String string;
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState == null || (string = savedInstanceState.getString(this.isForcedOrientationKey)) == null) {
            return;
        }
        this.isForcedOrientation = string;
    }

    private final void maybeShowDoubleTapBanner() {
        if (isOrientationLandscape()) {
            getViewModel().maybeShowDoubleTapBanner();
        }
    }

    private final void registerConnectionChecker(boolean turnOn) {
        try {
            if (turnOn) {
                if (Build.VERSION.SDK_INT >= 33) {
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.registerReceiver(this.connectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 2);
                    }
                } else {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.registerReceiver(this.connectionReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    }
                }
            } else {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.unregisterReceiver(this.connectionReceiver);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void initAdapter() {
        this.eventsAdapter = new EventsAdapter(getViewModel().getStreamArchiveService() == 7, new VideoPlayerFragment$initAdapter$1(getViewModel()), new VideoPlayerFragment$initAdapter$2(this), new VideoPlayerFragment$initAdapter$3(this));
        RecyclerView recyclerView = getBinding().rvEvents;
        if (recyclerView != null) {
            EventsAdapter eventsAdapter = this.eventsAdapter;
            if (eventsAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eventsAdapter");
                eventsAdapter = null;
            }
            recyclerView.setAdapter(eventsAdapter);
            recyclerView.setLayoutManager(new EventsLinearLayoutManager(recyclerView.getContext(), 1, false, getViewModel().getStreamArchiveService() == 7));
        }
    }

    private final void initSensor() {
        final Context context = getContext();
        this.orientationEventListener = new OrientationEventListener(context) { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$initSensor$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int orientation) {
                VideoPlayerFragment.this.onScreenRotate(orientation);
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        OrientationEventListener orientationEventListener2 = null;
        if (orientationEventListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationEventListener");
            orientationEventListener = null;
        }
        if (orientationEventListener.canDetectOrientation()) {
            OrientationEventListener orientationEventListener3 = this.orientationEventListener;
            if (orientationEventListener3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationEventListener");
            } else {
                orientationEventListener2 = orientationEventListener3;
            }
            orientationEventListener2.enable();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        OrientationEventListener orientationEventListener = this.orientationEventListener;
        if (orientationEventListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationEventListener");
            orientationEventListener = null;
        }
        orientationEventListener.disable();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r3 = r3.getInsetsController();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ac, code lost:
    
        r3 = r3.getInsetsController();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setupScreen(android.os.Bundle r3) {
        /*
            r2 = this;
            if (r3 == 0) goto Lc
            java.lang.String r0 = r2.isForcedOrientationKey
            java.lang.String r3 = r3.getString(r0)
            if (r3 == 0) goto Lc
            r2.isForcedOrientation = r3
        Lc:
            boolean r3 = r2.isOrientationLandscape()
            r0 = 1024(0x400, float:1.435E-42)
            r1 = 0
            if (r3 == 0) goto L74
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L24
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto L24
            r3.setFlags(r0, r0)
        L24:
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 30
            if (r3 < r0) goto L5c
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L3a
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto L3a
            android.view.WindowInsetsController r1 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r3)
        L3a:
            if (r1 != 0) goto L3d
            goto L41
        L3d:
            r3 = 2
            ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r1, r3)
        L41:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto Ld1
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto Ld1
            android.view.WindowInsetsController r3 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r3)
            if (r3 == 0) goto Ld1
            int r0 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m()
            ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m$1(r3, r0)
            goto Ld1
        L5c:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L6c
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto L6c
            android.view.View r1 = r3.getDecorView()
        L6c:
            if (r1 != 0) goto L6f
            goto Ld1
        L6f:
            r3 = 4
            r1.setSystemUiVisibility(r3)
            goto Ld1
        L74:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L83
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto L83
            r3.clearFlags(r0)
        L83:
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 31
            if (r3 < r0) goto Lba
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto L99
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto L99
            android.view.WindowInsetsController r1 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r3)
        L99:
            if (r1 != 0) goto L9c
            goto La0
        L9c:
            r3 = 1
            ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r1, r3)
        La0:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto Ld1
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto Ld1
            android.view.WindowInsetsController r3 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m(r3)
            if (r3 == 0) goto Ld1
            int r0 = ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m()
            ru.tattelecom.intercom.App$$ExternalSyntheticApiModelOutline0.m$2(r3, r0)
            goto Ld1
        Lba:
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            if (r3 == 0) goto Lca
            android.view.Window r3 = r3.getWindow()
            if (r3 == 0) goto Lca
            android.view.View r1 = r3.getDecorView()
        Lca:
            if (r1 != 0) goto Lcd
            goto Ld1
        Lcd:
            r3 = 0
            r1.setSystemUiVisibility(r3)
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.setupScreen(android.os.Bundle):void");
    }

    private final void setupPlayer() {
        Context context = getContext();
        if (context != null) {
            ExoPlayer build = new ExoPlayer.Builder(context).setRenderersFactory(new DefaultRenderersFactory(context).setEnableDecoderFallback(true)).build();
            build.setPlayWhenReady(true);
            build.addListener(new Player.Listener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayer$1$1$1
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
                    VideoPlayerViewModel viewModel;
                    VideoPlayerViewModel viewModel2;
                    VideoPlayerViewModel viewModel3;
                    VideoPlayerViewModel viewModel4;
                    VideoPlayerViewModel viewModel5;
                    Player.Listener.CC.$default$onPlaybackStateChanged(this, state);
                    if (state == 3) {
                        viewModel4 = VideoPlayerFragment.this.getViewModel();
                        Long value = viewModel4.getVideoLoadStartTime().getValue();
                        if (value != null) {
                            VideoPlayerFragment videoPlayerFragment = VideoPlayerFragment.this;
                            long longValue = value.longValue();
                            if (longValue != 0) {
                                long timeInMillis = Calendar.getInstance().getTimeInMillis() - longValue;
                                viewModel5 = videoPlayerFragment.getViewModel();
                                viewModel5.reportVideoLoadedEvent(timeInMillis);
                            }
                        }
                    }
                    viewModel = VideoPlayerFragment.this.getViewModel();
                    viewModel.onStreamLoading(state == 2);
                    if (state == 4) {
                        viewModel2 = VideoPlayerFragment.this.getViewModel();
                        if (viewModel2.getSelectedDayId().getValue().intValue() == 6) {
                            viewModel3 = VideoPlayerFragment.this.getViewModel();
                            viewModel3.onDayClick(-1);
                        }
                    }
                }

                @Override // androidx.media3.common.Player.Listener
                public void onPlayerError(PlaybackException error) {
                    VideoPlayerViewModel viewModel;
                    Intrinsics.checkNotNullParameter(error, "error");
                    Player.Listener.CC.$default$onPlayerError(this, error);
                    viewModel = VideoPlayerFragment.this.getViewModel();
                    viewModel.onVideoPlayerError();
                }
            });
            this.player = build;
            getBinding().playerView.setPlayer(this.player);
            AspectRatioFrameLayout aspectRatioFrameLayout = getBinding().playerViewContainer;
            if (aspectRatioFrameLayout != null) {
                aspectRatioFrameLayout.setAspectRatio(1.7777778f);
            }
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.addListener(new Player.Listener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayer$2
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
                public /* synthetic */ void onPlaybackStateChanged(int i) {
                    Player.Listener.CC.$default$onPlaybackStateChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
                    Player.Listener.CC.$default$onPlaybackSuppressionReasonChanged(this, i);
                }

                @Override // androidx.media3.common.Player.Listener
                public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
                    Player.Listener.CC.$default$onPlayerError(this, playbackException);
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
                public void onIsPlayingChanged(boolean isPlaying) {
                    FragmentVideoPlayerBinding binding;
                    boolean isOrientationLandscape;
                    int i;
                    binding = VideoPlayerFragment.this.getBinding();
                    ImageView imageView = binding.btnPlayerStart;
                    isOrientationLandscape = VideoPlayerFragment.this.isOrientationLandscape();
                    if (isOrientationLandscape) {
                        i = isPlaying ? R.drawable.ic_pause_player : R.drawable.ic_start_player;
                    } else {
                        i = isPlaying ? R.drawable.ic_pause_24 : R.drawable.ic_play_24;
                    }
                    imageView.setImageResource(i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupTimeline(boolean recreate, long timeInMs) {
        FragmentVideoPlayerBinding binding = getBinding();
        if (recreate) {
            binding.timeBar.setMode(VideoTimeBar.MODE_UNIT_1_HOUR);
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeInMs);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
        long timeInMillis2 = calendar.getTimeInMillis();
        VideoTimeBar videoTimeBar = binding.timeBar;
        videoTimeBar.setRange(timeInMillis, timeInMillis2);
        videoTimeBar.setOnCursorListener(this.cursorListener);
        videoTimeBar.setCursorValue(timeInMs);
        binding.tvCursorTime.setText(getViewModel().convertTimeToPattern(timeInMs));
    }

    private final void setupPlayerControls() {
        final FragmentVideoPlayerBinding binding = getBinding();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        Function0<Boolean> function0 = new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayerControls$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                VideoPlayerViewModel viewModel;
                viewModel = VideoPlayerFragment.this.getViewModel();
                ConstraintLayout clControl = binding.clControl;
                Intrinsics.checkNotNullExpressionValue(clControl, "clControl");
                viewModel.changeMenuState(!(clControl.getVisibility() == 0));
                return true;
            }
        };
        PlayerView playerView = getBinding().playerView;
        Intrinsics.checkNotNullExpressionValue(playerView, "playerView");
        TextView tvScaleFactor = getBinding().tvScaleFactor;
        Intrinsics.checkNotNullExpressionValue(tvScaleFactor, "tvScaleFactor");
        this.gestureDetector = new VideoPlayerGestureDetector(requireContext, function0, playerView, tvScaleFactor, new Function1<Float, String>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayerControls$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Float f) {
                return invoke(f.floatValue());
            }

            public final String invoke(float f) {
                String string = VideoPlayerFragment.this.getString(R.string.scale_factor, Float.valueOf(f));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
        }, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayerControls$1$3
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
                VideoPlayerFragment.this.keepScaleFactorView();
            }
        }, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayerControls$1$4
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
                VideoPlayerViewModel viewModel;
                VideoPlayerViewModel viewModel2;
                viewModel = VideoPlayerFragment.this.getViewModel();
                viewModel.changeMenuState(false);
                viewModel2 = VideoPlayerFragment.this.getViewModel();
                viewModel2.setDoubleTapHintShown();
            }
        });
        binding.flPlayerView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda19
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = VideoPlayerFragment.setupPlayerControls$lambda$21$lambda$19(VideoPlayerFragment.this, binding, view, motionEvent);
                return z;
            }
        });
        DoubleTapView doubleTapView = binding.doubleTapView;
        doubleTapView.setPerformListener(new DoubleTapView.PerformListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupPlayerControls$1$6$1
            @Override // ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView.PerformListener
            public void onAnimationStart() {
            }

            @Override // ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView.PerformListener
            public void onAnimationEnd(long seconds) {
                VideoPlayerFragment videoPlayerFragment = VideoPlayerFragment.this;
                FragmentVideoPlayerBinding fragmentVideoPlayerBinding = binding;
                videoPlayerFragment.scrollCursorTo(fragmentVideoPlayerBinding, fragmentVideoPlayerBinding.timeBar.getMCursorValue() + (seconds * 1000));
            }
        });
        doubleTapView.setSeekSeconds(10);
        VideoPlayerGestureDetector videoPlayerGestureDetector = this.gestureDetector;
        if (videoPlayerGestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            videoPlayerGestureDetector = null;
        }
        DoubleTapView doubleTapView2 = binding.doubleTapView;
        Intrinsics.checkNotNullExpressionValue(doubleTapView2, "doubleTapView");
        videoPlayerGestureDetector.setController(doubleTapView2);
        setupVolumeButton(binding);
        setupPlaybackSpeedButton(binding);
        setupPlayButton(binding);
        setupFastForwardButton(binding);
        setupRewindButton(binding);
        setupFullScreenButton(binding);
        setupScreenshotButton(binding);
        setupFavoriteButton(binding);
        setupDownloadButton(binding);
        setupRefreshButton(binding);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupPlayerControls$lambda$21$lambda$19(VideoPlayerFragment this$0, FragmentVideoPlayerBinding this_apply, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        VideoPlayerGestureDetector videoPlayerGestureDetector = this$0.gestureDetector;
        if (videoPlayerGestureDetector == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gestureDetector");
            videoPlayerGestureDetector = null;
        }
        Intrinsics.checkNotNull(view);
        Intrinsics.checkNotNull(motionEvent);
        if (videoPlayerGestureDetector.handleTouchEvents(view, motionEvent)) {
            return true;
        }
        return this_apply.doubleTapView.onTouchEvent(motionEvent);
    }

    private final void setupVolumeButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        fragmentVideoPlayerBinding.btnVolume.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda26
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupVolumeButton$lambda$23(VideoPlayerFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupVolumeButton$lambda$23(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.keepControlButtons();
        ExoPlayer exoPlayer = this$0.player;
        if (exoPlayer != null) {
            if (exoPlayer.getVolume() == 0.0f) {
                this$0.getViewModel().setVolume(1.0f);
            } else {
                this$0.getViewModel().setVolume(0.0f);
            }
        }
    }

    private final void setupPlaybackSpeedButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        fragmentVideoPlayerBinding.btnPlaybackSpeed.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda35
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupPlaybackSpeedButton$lambda$24(VideoPlayerFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPlaybackSpeedButton$lambda$24(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.keepControlButtons();
        new SpeedPlaybackDialog().show(this$0.getChildFragmentManager(), "playback_speed");
    }

    private final void setupPlayButton(final FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        keepControlButtons();
        fragmentVideoPlayerBinding.btnPlayerStart.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupPlayButton$lambda$25(FragmentVideoPlayerBinding.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupPlayButton$lambda$25(FragmentVideoPlayerBinding this_setupPlayButton, VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this_setupPlayButton, "$this_setupPlayButton");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Player player = this_setupPlayButton.playerView.getPlayer();
        if (Intrinsics.areEqual((Object) (player != null ? Boolean.valueOf(player.isPlaying()) : null), (Object) true)) {
            Player player2 = this_setupPlayButton.playerView.getPlayer();
            if (player2 != null) {
                player2.pause();
            }
            this$0.getViewModel().setIsLive(false);
            this$0.getBinding().chipLive.setSelected(false);
            this$0.getBinding().chipLive.setChecked(false);
            this$0.getBinding().chipLive.setClickable(true);
            return;
        }
        Player player3 = this_setupPlayButton.playerView.getPlayer();
        if (player3 != null) {
            player3.play();
        }
    }

    private final void setupRewindButton(final FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        keepControlButtons();
        fragmentVideoPlayerBinding.btnRewind.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupRewindButton$lambda$26(VideoPlayerFragment.this, fragmentVideoPlayerBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRewindButton$lambda$26(VideoPlayerFragment this$0, FragmentVideoPlayerBinding this_setupRewindButton, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_setupRewindButton, "$this_setupRewindButton");
        if (Intrinsics.areEqual(this$0.getViewModel().getScreenState().getValue(), PlayerState.Intercom.INSTANCE)) {
            if (this$0.getViewModel().getStreamArchiveService() == 7) {
                this$0.getViewModel().onEventRewind(this_setupRewindButton.timeBar.getMCursorValue(), false);
                return;
            } else {
                this$0.showConnectServicesBanner();
                return;
            }
        }
        this$0.scrollCursorTo(this_setupRewindButton, this_setupRewindButton.timeBar.getMCursorValue() - 10000);
    }

    private final void setupFastForwardButton(final FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        keepControlButtons();
        fragmentVideoPlayerBinding.btnFastForward.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda25
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupFastForwardButton$lambda$27(VideoPlayerFragment.this, fragmentVideoPlayerBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFastForwardButton$lambda$27(VideoPlayerFragment this$0, FragmentVideoPlayerBinding this_setupFastForwardButton, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_setupFastForwardButton, "$this_setupFastForwardButton");
        if (Intrinsics.areEqual(this$0.getViewModel().getScreenState().getValue(), PlayerState.Intercom.INSTANCE)) {
            if (this$0.getViewModel().getStreamArchiveService() == 7) {
                this$0.getViewModel().onEventRewind(this_setupFastForwardButton.timeBar.getMCursorValue(), true);
                return;
            } else {
                this$0.showConnectServicesBanner();
                return;
            }
        }
        this$0.scrollCursorTo(this_setupFastForwardButton, this_setupFastForwardButton.timeBar.getMCursorValue() + 10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollCursorTo(FragmentVideoPlayerBinding fragmentVideoPlayerBinding, long j) {
        VideoTimeBar videoTimeBar = fragmentVideoPlayerBinding.timeBar;
        if (j <= fragmentVideoPlayerBinding.timeBar.getStartTime()) {
            j = fragmentVideoPlayerBinding.timeBar.getStartTime();
        } else if (j >= fragmentVideoPlayerBinding.timeBar.getEndTime()) {
            j = fragmentVideoPlayerBinding.timeBar.getEndTime();
        }
        videoTimeBar.scrollCursorTo(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConnectServicesBanner() {
        getViewModel().sendEvent(new PlayerEvent.ShowCustomSnackBar(Integer.valueOf(R.string.title_only_for_abonents), GravityCompat.START, Integer.valueOf(R.string.msg_need_internet_subscription), GravityCompat.START, Integer.valueOf(R.string.button_leave_order), GravityCompat.START, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$showConnectServicesBanner$1
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
                VideoPlayerViewModel viewModel;
                VideoPlayerViewModel viewModel2;
                VideoPlayerViewModel viewModel3;
                viewModel = VideoPlayerFragment.this.getViewModel();
                VideoPlayerViewModel.reportEvent$default(viewModel, 12, null, 2, null);
                viewModel2 = VideoPlayerFragment.this.getViewModel();
                Integer leaveOrderDestination = viewModel2.getLeaveOrderDestination();
                if (leaveOrderDestination != null) {
                    VideoPlayerFragment videoPlayerFragment = VideoPlayerFragment.this;
                    int intValue = leaveOrderDestination.intValue();
                    NavController findNavController = FragmentKt.findNavController(videoPlayerFragment);
                    viewModel3 = videoPlayerFragment.getViewModel();
                    NavExtKt.navigateSafe$default(findNavController, intValue, BundleKt.bundleOf(TuplesKt.to("previousPage", viewModel3.getVideoPlayerDestination())), null, 4, null);
                }
            }
        }, true, -2));
    }

    private final void setupFullScreenButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        fragmentVideoPlayerBinding.btnFullscreen.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda38
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupFullScreenButton$lambda$28(VideoPlayerFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFullScreenButton$lambda$28(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.keepControlButtons();
        if (this$0.isOrientationLandscape()) {
            this$0.isForcedOrientation = PORTRAIT;
            FragmentActivity activity = this$0.getActivity();
            if (activity == null) {
                return;
            }
            activity.setRequestedOrientation(1);
            return;
        }
        this$0.isForcedOrientation = LAND;
        FragmentActivity activity2 = this$0.getActivity();
        if (activity2 == null) {
            return;
        }
        activity2.setRequestedOrientation(0);
    }

    private final void setupScreenshotButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        fragmentVideoPlayerBinding.btnScreenshot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupScreenshotButton$lambda$29(VideoPlayerFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupScreenshotButton$lambda$29(final VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.keepControlButtons();
        VideoPlayerViewModel.reportEvent$default(this$0.getViewModel(), 105, null, 2, null);
        this$0.takeScreenshot(new Function1<Bitmap, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupScreenshotButton$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                VideoPlayerViewModel viewModel;
                if (bitmap != null) {
                    viewModel = VideoPlayerFragment.this.getViewModel();
                    Context context = VideoPlayerFragment.this.getContext();
                    viewModel.saveScreenshot(context != null ? context.getApplicationContext() : null, bitmap);
                }
            }
        });
    }

    private final void setupFavoriteButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        MaterialButton materialButton = fragmentVideoPlayerBinding.btnFavorite;
        if (materialButton != null) {
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayerFragment.setupFavoriteButton$lambda$30(VideoPlayerFragment.this, view);
                }
            });
        }
        ImageView imageView = fragmentVideoPlayerBinding.ivFavorite;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda21
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayerFragment.setupFavoriteButton$lambda$31(VideoPlayerFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFavoriteButton$lambda$30(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().changeFavoriteStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupFavoriteButton$lambda$31(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.keepControlButtons();
        this$0.getViewModel().changeFavoriteStatus();
    }

    private final void setupDownloadButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        ImageView imageView = fragmentVideoPlayerBinding.btnDownload;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda31
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayerFragment.setupDownloadButton$lambda$32(VideoPlayerFragment.this, view);
                }
            });
        }
        ImageView imageView2 = fragmentVideoPlayerBinding.ivDownload;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda32
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayerFragment.setupDownloadButton$lambda$33(VideoPlayerFragment.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDownloadButton$lambda$32(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onDownloadClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupDownloadButton$lambda$33(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.keepControlButtons();
        this$0.onDownloadClick();
    }

    private final void setupRefreshButton(FragmentVideoPlayerBinding fragmentVideoPlayerBinding) {
        fragmentVideoPlayerBinding.btnRefreshStream.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.setupRefreshButton$lambda$34(VideoPlayerFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupRefreshButton$lambda$34(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onVideoRefresh();
    }

    private final void onDownloadClick() {
        if (getViewModel().getStreamDownloadService()) {
            onClickRequestPermission();
            VideoPlayerViewModel.reportEvent$default(getViewModel(), Intrinsics.areEqual(getViewModel().getScreenState().getValue(), PlayerState.Intercom.INSTANCE) ? 37 : 41, null, 2, null);
        } else {
            if (Intrinsics.areEqual(getViewModel().getScreenState().getValue(), PlayerState.Intercom.INSTANCE)) {
                VideoPlayerViewModel.reportEvent$default(getViewModel(), 38, null, 2, null);
            }
            showConnectServicesBanner();
        }
    }

    private final void provideUiChanges() {
        getViewModel().getScrollEventId().observe(getViewLifecycleOwner(), new VideoPlayerFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$1
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
                VideoPlayerViewModel viewModel;
                EventsAdapter eventsAdapter;
                FragmentVideoPlayerBinding binding;
                FragmentVideoPlayerBinding binding2;
                viewModel = VideoPlayerFragment.this.getViewModel();
                if (viewModel.getStreamArchiveService() != 7 || num == null) {
                    return;
                }
                eventsAdapter = VideoPlayerFragment.this.eventsAdapter;
                if (eventsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventsAdapter");
                    eventsAdapter = null;
                }
                if (new IntRange(0, eventsAdapter.getItemCount()).contains(num.intValue())) {
                    try {
                        binding = VideoPlayerFragment.this.getBinding();
                        RecyclerView recyclerView = binding.rvEvents;
                        if (recyclerView == null || recyclerView.getScrollState() != 0) {
                            return;
                        }
                        binding2 = VideoPlayerFragment.this.getBinding();
                        RecyclerView recyclerView2 = binding2.rvEvents;
                        if (recyclerView2 != null) {
                            recyclerView2.scrollToPosition(num.intValue());
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }));
        getViewModel().getStreamUrl().observe(getViewLifecycleOwner(), new VideoPlayerFragment$sam$androidx_lifecycle_Observer$0(new Function1<String, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r1 = (r0 = r5.this$0).player;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke2(java.lang.String r6) {
                /*
                    r5 = this;
                    if (r6 == 0) goto L5a
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment r0 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.this
                    androidx.media3.exoplayer.ExoPlayer r1 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getPlayer$p(r0)
                    if (r1 == 0) goto L5a
                    androidx.media3.common.MediaItem r6 = androidx.media3.common.MediaItem.fromUri(r6)
                    r1.setMediaItem(r6)
                    r1.prepare()
                    r6 = 1
                    r1.setPlayWhenReady(r6)
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r2 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getViewModel(r0)
                    boolean r2 = r2.getIsPlayerTimeSeeked()
                    if (r2 != 0) goto L5a
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r2 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getViewModel(r0)
                    r2.setPlayerTimeSeeked(r6)
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r6 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getViewModel(r0)
                    java.lang.Long r6 = r6.getPlayerTime()
                    if (r6 == 0) goto L5a
                    java.lang.Number r6 = (java.lang.Number) r6
                    long r2 = r6.longValue()
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r6 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getViewModel(r0)
                    kotlinx.coroutines.flow.StateFlow r6 = r6.getScreenState()
                    java.lang.Object r6 = r6.getValue()
                    ru.tattelecom.intercom.feature.videoplayer.PlayerState$Camera r4 = ru.tattelecom.intercom.feature.videoplayer.PlayerState.Camera.INSTANCE
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r4)
                    if (r6 == 0) goto L57
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r6 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getViewModel(r0)
                    boolean r6 = r6.getIsFlussonic()
                    if (r6 == 0) goto L5a
                L57:
                    r1.seekTo(r2)
                L5a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$2.invoke2(java.lang.String):void");
            }
        }));
        collectOnLifecycle(getViewModel().getDays(), Lifecycle.State.STARTED, new Function1<List<? extends Date>, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Date> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends Date> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                VideoPlayerFragment.this.provideDayList(it);
            }
        });
        StateFlow<List<EventItem>> currentDayGateEvents$videoplayer_release = getViewModel().getCurrentDayGateEvents$videoplayer_release();
        if (currentDayGateEvents$videoplayer_release != null) {
            collectOnLifecycle(currentDayGateEvents$videoplayer_release, Lifecycle.State.STARTED, new Function1<List<? extends EventItem>, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends EventItem> list) {
                    invoke2((List<EventItem>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<EventItem> eventList) {
                    FragmentVideoPlayerBinding binding;
                    FragmentVideoPlayerBinding binding2;
                    EventsAdapter eventsAdapter;
                    FragmentVideoPlayerBinding binding3;
                    FragmentVideoPlayerBinding binding4;
                    FragmentVideoPlayerBinding binding5;
                    Intrinsics.checkNotNullParameter(eventList, "eventList");
                    if (eventList.isEmpty()) {
                        binding4 = VideoPlayerFragment.this.getBinding();
                        TextView textView = binding4.tvEventsEmpty;
                        if (textView != null) {
                            textView.setVisibility(0);
                        }
                        binding5 = VideoPlayerFragment.this.getBinding();
                        RecyclerView recyclerView = binding5.rvEvents;
                        if (recyclerView != null) {
                            recyclerView.setVisibility(8);
                        }
                    } else {
                        binding = VideoPlayerFragment.this.getBinding();
                        TextView textView2 = binding.tvEventsEmpty;
                        if (textView2 != null) {
                            textView2.setVisibility(8);
                        }
                        binding2 = VideoPlayerFragment.this.getBinding();
                        RecyclerView recyclerView2 = binding2.rvEvents;
                        if (recyclerView2 != null) {
                            recyclerView2.setVisibility(0);
                        }
                        eventsAdapter = VideoPlayerFragment.this.eventsAdapter;
                        if (eventsAdapter == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("eventsAdapter");
                            eventsAdapter = null;
                        }
                        eventsAdapter.submitList(eventList);
                        binding3 = VideoPlayerFragment.this.getBinding();
                        VideoTimeBar videoTimeBar = binding3.timeBar;
                        List<EventItem> list = eventList;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((EventItem) it.next()).getStartDate().getTime()));
                        }
                        videoTimeBar.setEventList(arrayList);
                    }
                    VideoPlayerFragment.this.maybeDisableRewindButtons();
                }
            });
        }
        collectOnLifecycle(getViewModel().getScreenState(), Lifecycle.State.STARTED, new Function1<PlayerState, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerState playerState) {
                invoke2(playerState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerState playerState) {
                VideoPlayerFragment.this.provideScreenState(playerState);
            }
        });
        collectOnLifecycle(getViewModel().getEvents(), Lifecycle.State.STARTED, new Function1<PlayerEvent, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PlayerEvent playerEvent) {
                invoke2(playerEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PlayerEvent playerEvent) {
                if (playerEvent != null) {
                    VideoPlayerFragment.this.provideEvent(playerEvent);
                }
            }
        });
        collectOnLifecycle(getViewModel().getTimelineUpdateEvent(), Lifecycle.State.STARTED, new Function1<Unit, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$7
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit it) {
                boolean z;
                VideoPlayerViewModel viewModel;
                ExoPlayer exoPlayer;
                Intrinsics.checkNotNullParameter(it, "it");
                z = VideoPlayerFragment.this.isTimeDragging;
                if (z) {
                    return;
                }
                viewModel = VideoPlayerFragment.this.getViewModel();
                exoPlayer = VideoPlayerFragment.this.player;
                viewModel.onStreamTimeReceived(exoPlayer != null ? Long.valueOf(exoPlayer.getCurrentPosition()) : null);
            }
        });
        collectOnLifecycle(getViewModel().getPlaybackSpeed(), Lifecycle.State.STARTED, new Function1<SpeedPlayback, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeedPlayback speedPlayback) {
                invoke2(speedPlayback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SpeedPlayback playbackSpeed) {
                ExoPlayer exoPlayer;
                Intrinsics.checkNotNullParameter(playbackSpeed, "playbackSpeed");
                exoPlayer = VideoPlayerFragment.this.player;
                if (exoPlayer != null) {
                    exoPlayer.setPlaybackSpeed(playbackSpeed.getValue());
                }
            }
        });
        collectOnLifecycle(getViewModel().isFavorite(), Lifecycle.State.STARTED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$9
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                VideoPlayerFragment.this.provideFavoriteButton(z);
            }
        });
        collectOnLifecycle(getViewModel().isOpenDoorLoading(), Lifecycle.State.STARTED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$10
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                VideoPlayerFragment.provideOpenDoorButton$default(VideoPlayerFragment.this, Boolean.valueOf(z), null, 2, null);
            }
        });
        StateFlow<Boolean> isOpenDoorEnabled = getViewModel().isOpenDoorEnabled();
        if (isOpenDoorEnabled != null) {
            collectOnLifecycle(isOpenDoorEnabled, Lifecycle.State.CREATED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    VideoPlayerFragment.provideOpenDoorButton$default(VideoPlayerFragment.this, null, Boolean.valueOf(z), 1, null);
                }
            });
        }
        collectOnLifecycle(getViewModel().isStreamLoading(), Lifecycle.State.STARTED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FragmentVideoPlayerBinding binding;
                binding = VideoPlayerFragment.this.getBinding();
                ProgressBar progressView = binding.progressView;
                Intrinsics.checkNotNullExpressionValue(progressView, "progressView");
                progressView.setVisibility(z ? 0 : 8);
            }
        });
        collectOnLifecycle(getViewModel().getSelectedDayId(), Lifecycle.State.STARTED, new Function1<Integer, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$13
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                VideoPlayerViewModel viewModel;
                FragmentVideoPlayerBinding binding;
                FragmentVideoPlayerBinding binding2;
                FragmentVideoPlayerBinding binding3;
                FragmentVideoPlayerBinding binding4;
                VideoPlayerViewModel viewModel2;
                VideoPlayerViewModel viewModel3;
                VideoPlayerFragment videoPlayerFragment = VideoPlayerFragment.this;
                viewModel = videoPlayerFragment.getViewModel();
                videoPlayerFragment.provideChipState(viewModel.getDays().getValue(), i);
                if (i == -1) {
                    binding3 = VideoPlayerFragment.this.getBinding();
                    binding3.btnPlaybackSpeed.setAlpha(0.48f);
                    binding4 = VideoPlayerFragment.this.getBinding();
                    binding4.btnPlaybackSpeed.setEnabled(false);
                    viewModel2 = VideoPlayerFragment.this.getViewModel();
                    viewModel3 = VideoPlayerFragment.this.getViewModel();
                    viewModel2.onSpeedClick(viewModel3.getSpeedPlaybackValues().get(1));
                    return;
                }
                binding = VideoPlayerFragment.this.getBinding();
                binding.btnPlaybackSpeed.setAlpha(1.0f);
                binding2 = VideoPlayerFragment.this.getBinding();
                binding2.btnPlaybackSpeed.setEnabled(true);
            }
        });
        collectOnLifecycle(getViewModel().getDayStartTime(), Lifecycle.State.STARTED, new Function1<Long, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$14
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                VideoPlayerFragment.this.setupTimeline(false, l != null ? l.longValue() : Calendar.getInstance().getTimeInMillis());
            }
        });
        collectOnLifecycle(getViewModel().getStreamTime(), Lifecycle.State.STARTED, new Function1<Long, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$15
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke(l.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j) {
                VideoPlayerFragment.this.provideCursorTime(j);
                VideoPlayerFragment.this.maybeDisableRewindButtons();
            }
        });
        collectOnLifecycle(getViewModel().isMenuShown(), Lifecycle.State.STARTED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$16
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                FragmentVideoPlayerBinding binding;
                VideoPlayerFragment.this.provideMenuState(z);
                binding = VideoPlayerFragment.this.getBinding();
                TextView tvCursorTime = binding.tvCursorTime;
                Intrinsics.checkNotNullExpressionValue(tvCursorTime, "tvCursorTime");
                tvCursorTime.setVisibility(z ? 0 : 8);
            }
        });
        collectOnLifecycle(getViewModel().getScale(), Lifecycle.State.STARTED, new Function1<Float, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$17
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                VideoPlayerFragment.this.providePlayerZoom(f);
            }
        });
        collectOnLifecycle(getViewModel().isVideoError(), Lifecycle.State.STARTED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$18
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
                FragmentVideoPlayerBinding binding;
                FragmentVideoPlayerBinding binding2;
                if (bool != null) {
                    VideoPlayerFragment videoPlayerFragment = VideoPlayerFragment.this;
                    bool.booleanValue();
                    binding = videoPlayerFragment.getBinding();
                    LinearLayout llVideoError = binding.llVideoError;
                    Intrinsics.checkNotNullExpressionValue(llVideoError, "llVideoError");
                    llVideoError.setVisibility(bool.booleanValue() ? 0 : 8);
                    binding2 = videoPlayerFragment.getBinding();
                    binding2.flPlayerView.setClickable(!bool.booleanValue());
                }
            }
        });
        collectOnLifecycle(getViewModel().isLive(), Lifecycle.State.STARTED, new Function1<Boolean, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$19
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0047, code lost:
            
                if (kotlin.jvm.internal.Intrinsics.areEqual(r5.getScreenState().getValue(), ru.tattelecom.intercom.feature.videoplayer.PlayerState.Camera.INSTANCE) == false) goto L11;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void invoke(boolean r5) {
                /*
                    r4 = this;
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment r0 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.this
                    ru.tattelecom.intercom.feature.videoplayer.gestures.VideoPlayerGestureDetector r0 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getGestureDetector$p(r0)
                    if (r0 != 0) goto Le
                    java.lang.String r0 = "gestureDetector"
                    kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                    r0 = 0
                Le:
                    r0.setLive(r5)
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment r0 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.this
                    ru.tattelecom.intercom.feature.videoplayer.databinding.FragmentVideoPlayerBinding r0 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getBinding(r0)
                    com.google.android.material.floatingactionbutton.FloatingActionButton r0 = r0.btnOpenDoor
                    java.lang.String r1 = "btnOpenDoor"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                    android.view.View r0 = (android.view.View) r0
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment r1 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.this
                    boolean r1 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$isOrientationLandscape(r1)
                    r2 = 1
                    r1 = r1 ^ r2
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment r3 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.this
                    boolean r3 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$isOrientationLandscape(r3)
                    r5 = r5 & r3
                    r5 = r5 | r1
                    r1 = 0
                    if (r5 == 0) goto L4a
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment r5 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.this
                    ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r5 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.access$getViewModel(r5)
                    kotlinx.coroutines.flow.StateFlow r5 = r5.getScreenState()
                    java.lang.Object r5 = r5.getValue()
                    ru.tattelecom.intercom.feature.videoplayer.PlayerState$Camera r3 = ru.tattelecom.intercom.feature.videoplayer.PlayerState.Camera.INSTANCE
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r3)
                    if (r5 != 0) goto L4a
                    goto L4b
                L4a:
                    r2 = r1
                L4b:
                    if (r2 == 0) goto L4e
                    goto L50
                L4e:
                    r1 = 8
                L50:
                    r0.setVisibility(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$19.invoke(boolean):void");
            }
        });
        collectOnLifecycle(getViewModel().getPlayerVolume(), Lifecycle.State.STARTED, new Function1<Float, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideUiChanges$20
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f) {
                invoke(f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f) {
                ExoPlayer exoPlayer;
                FragmentVideoPlayerBinding binding;
                exoPlayer = VideoPlayerFragment.this.player;
                if (exoPlayer != null) {
                    exoPlayer.setVolume(f);
                }
                binding = VideoPlayerFragment.this.getBinding();
                binding.btnVolume.setImageResource(f == 0.0f ? R.drawable.ic_volume_muted : R.drawable.ic_volume_player);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideCursorTime(long time) {
        Long value = getViewModel().getDayStartTime().getValue();
        getBinding().timeBar.setCursorValue((value != null ? value.longValue() : Calendar.getInstance().getTimeInMillis()) + time);
        getBinding().tvCursorTime.setText(getViewModel().convertTimeToPattern(getBinding().timeBar.getMCursorValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeDisableRewindButtons() {
        List<EventItem> value;
        if (!Intrinsics.areEqual(getViewModel().getScreenState().getValue(), PlayerState.Intercom.INSTANCE)) {
            getBinding().btnRewind.setEnabled(getBinding().timeBar.getMCursorValue() - ((long) 1000) > getCurrentDayStartTime());
            getBinding().btnFastForward.setEnabled(getBinding().timeBar.getMCursorValue() + ((long) 10000) < Calendar.getInstance().getTimeInMillis());
            return;
        }
        StateFlow<List<EventItem>> currentDayGateEvents$videoplayer_release = getViewModel().getCurrentDayGateEvents$videoplayer_release();
        if (currentDayGateEvents$videoplayer_release == null || (value = currentDayGateEvents$videoplayer_release.getValue()) == null) {
            return;
        }
        if (!value.isEmpty()) {
            getBinding().btnRewind.setEnabled(((EventItem) CollectionsKt.last((List) value)).getStartDate().getTime() < getBinding().timeBar.getMCursorValue() - ((long) 5000));
            getBinding().btnFastForward.setEnabled(((EventItem) CollectionsKt.first((List) value)).getStartDate().getTime() > getBinding().timeBar.getMCursorValue());
        } else {
            getBinding().btnRewind.setEnabled(false);
            getBinding().btnFastForward.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideFavoriteButton(boolean isFavorite) {
        Menu menu;
        int i;
        int i2;
        int i3;
        int i4;
        MaterialButton materialButton = getBinding().btnFavorite;
        if (materialButton != null) {
            Context requireContext = requireContext();
            if (isFavorite) {
                i2 = R.drawable.ic_video_player_unfavorite;
            } else {
                i2 = R.drawable.ic_video_player_favorite;
            }
            materialButton.setIcon(ContextCompat.getDrawable(requireContext, i2));
            Context requireContext2 = requireContext();
            if (isFavorite) {
                i3 = R.color.red;
            } else {
                i3 = R.color.septenary;
            }
            materialButton.setIconTint(ContextCompat.getColorStateList(requireContext2, i3));
            if (isFavorite) {
                i4 = R.string.remove_from_favorites;
            } else {
                i4 = R.string.add_to_favorites;
            }
            materialButton.setText(i4);
        }
        ImageView imageView = getBinding().ivFavorite;
        if (imageView != null) {
            if (isFavorite) {
                i = R.drawable.ic_video_player_unfavorite;
            } else {
                i = R.drawable.ic_video_player_favorite;
            }
            imageView.setImageResource(i);
        }
        MaterialToolbar materialToolbar = getBinding().toolbar;
        if (materialToolbar == null || (menu = materialToolbar.getMenu()) == null) {
            return;
        }
        try {
            menu.findItem(R.id.actionAddFavorite).setVisible(!isFavorite);
            menu.findItem(R.id.actionRemoveFavorite).setVisible(isFavorite);
        } catch (Exception unused) {
        }
    }

    private final void setupMenu() {
        final MaterialToolbar materialToolbar = getBinding().toolbar;
        if (materialToolbar != null) {
            materialToolbar.addMenuProvider(new MenuProvider() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$setupMenu$1$1
                @Override // androidx.core.view.MenuProvider
                public /* synthetic */ void onMenuClosed(Menu menu) {
                    MenuProvider.CC.$default$onMenuClosed(this, menu);
                }

                @Override // androidx.core.view.MenuProvider
                public /* synthetic */ void onPrepareMenu(Menu menu) {
                    MenuProvider.CC.$default$onPrepareMenu(this, menu);
                }

                @Override // androidx.core.view.MenuProvider
                public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
                    Intrinsics.checkNotNullParameter(menu, "menu");
                    Intrinsics.checkNotNullParameter(menuInflater, "menuInflater");
                    menuInflater.inflate(R.menu.menu_video_player, menu);
                    if (menu instanceof MenuBuilder) {
                        MenuBuilder menuBuilder = (MenuBuilder) menu;
                        menuBuilder.setOptionalIconsVisible(true);
                        Iterator<MenuItemImpl> it = menuBuilder.getVisibleItems().iterator();
                        while (it.hasNext()) {
                            MenuItemImpl next = it.next();
                            int applyDimension = (int) TypedValue.applyDimension(1, 4.0f, MaterialToolbar.this.getResources().getDisplayMetrics());
                            if (next.getIcon() != null) {
                                next.setIcon(new InsetDrawable(next.getIcon(), applyDimension, 0, applyDimension, 0));
                            }
                        }
                    }
                }

                @Override // androidx.core.view.MenuProvider
                public boolean onMenuItemSelected(MenuItem menuItem) {
                    VideoPlayerViewModel viewModel;
                    VideoPlayerViewModel viewModel2;
                    Intrinsics.checkNotNullParameter(menuItem, "menuItem");
                    int itemId = menuItem.getItemId();
                    if (itemId == R.id.actionAddFavorite) {
                        viewModel2 = this.getViewModel();
                        viewModel2.changeFavoriteStatus();
                        return true;
                    }
                    if (itemId != R.id.actionRemoveFavorite) {
                        return false;
                    }
                    viewModel = this.getViewModel();
                    viewModel.changeFavoriteStatus();
                    return true;
                }
            }, getViewLifecycleOwner(), Lifecycle.State.CREATED);
        }
    }

    static /* synthetic */ void provideOpenDoorButton$default(VideoPlayerFragment videoPlayerFragment, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        videoPlayerFragment.provideOpenDoorButton(bool, bool2);
    }

    private final void provideOpenDoorButton(Boolean isOpenDoorLoading, Boolean isOpenDoorEnabled) {
        FragmentVideoPlayerBinding binding = getBinding();
        if (isOpenDoorEnabled != null) {
            binding.btnOpenDoor.setEnabled(isOpenDoorEnabled.booleanValue());
        }
        if (isOpenDoorLoading == null || !isOpenDoorLoading.booleanValue()) {
            return;
        }
        binding.btnOpenDoor.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideDayList(List<? extends Date> dayList) {
        FragmentVideoPlayerBinding binding = getBinding();
        ChipGroup chipGroup = binding.cgDays;
        if (chipGroup != null) {
            Intrinsics.checkNotNull(chipGroup);
            int i = 0;
            for (View view : ViewGroupKt.getChildren(chipGroup)) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                View view2 = view;
                int childCount = (chipGroup.getChildCount() - 1) - i;
                if (childCount >= 0 && childCount < dayList.size()) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    Chip chip = (Chip) view2;
                    String format = this.chipDateFormatter.format(dayList.get(childCount));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    if (format.length() > 0) {
                        char upperCase = Character.toUpperCase(format.charAt(0));
                        Character.valueOf(upperCase).getClass();
                        String substring = format.substring(1);
                        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                        format = upperCase + substring;
                    }
                    chip.setText(format);
                }
                i = i2;
            }
        }
        Chip chip2 = binding.chipDate;
        if (chip2 != null) {
            int intValue = getViewModel().getSelectedDayId().getValue().intValue();
            List<Date> value = getViewModel().getDays().getValue();
            String format2 = this.dateFormatter.format((intValue < 0 || intValue >= 7) ? value.get(0) : value.get((value.size() - 1) - intValue));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            if (format2.length() > 0) {
                char upperCase2 = Character.toUpperCase(format2.charAt(0));
                Character.valueOf(upperCase2).getClass();
                String substring2 = format2.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                format2 = upperCase2 + substring2;
            }
            chip2.setText(StringsKt.removeSuffix(format2, (CharSequence) "."));
            chip2.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda17
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    VideoPlayerFragment.provideDayList$lambda$53$lambda$50$lambda$49(VideoPlayerFragment.this, view3);
                }
            });
        }
        final HorizontalScrollView horizontalScrollView = binding.hsDays;
        if (horizontalScrollView != null) {
            horizontalScrollView.post(new Runnable() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    VideoPlayerFragment.provideDayList$lambda$53$lambda$52$lambda$51(horizontalScrollView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDayList$lambda$53$lambda$50$lambda$49(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new ArchiveDateBottomSheet().show(this$0.getChildFragmentManager(), "archive_date");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideDayList$lambda$53$lambda$52$lambda$51(HorizontalScrollView this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.fullScroll(66);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideMenuState(final boolean isVisible) {
        final FragmentVideoPlayerBinding binding = getBinding();
        ViewPropertyAnimator animate = binding.clControl.animate();
        if (isVisible) {
            ConstraintLayout clControl = binding.clControl;
            Intrinsics.checkNotNullExpressionValue(clControl, "clControl");
            clControl.setVisibility(0);
        }
        animate.setDuration(300L);
        animate.alpha(!isVisible ? 0.0f : 1.0f);
        animate.setListener(new AnimatorListenerAdapter() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideMenuState$1$1$1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                FragmentVideoPlayerBinding.this.clControl.clearAnimation();
                if (isVisible) {
                    return;
                }
                ConstraintLayout clControl2 = FragmentVideoPlayerBinding.this.clControl;
                Intrinsics.checkNotNullExpressionValue(clControl2, "clControl");
                clControl2.setVisibility(8);
            }
        });
        keepControlButtons();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void providePlayerZoom(float scaleValue) {
        PlayerView playerView = getBinding().playerView;
        playerView.setScaleX(scaleValue);
        playerView.setScaleY(scaleValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideChipState(List<? extends Date> days, int dayId) {
        Date date;
        FragmentVideoPlayerBinding binding = getBinding();
        if (dayId >= 0 && dayId < 7) {
            date = days.get((days.size() - 1) - dayId);
        } else {
            date = days.get(0);
        }
        Chip chip = binding.chipDate;
        if (chip != null) {
            String format = this.dateFormatter.format(date);
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            if (format.length() > 0) {
                char upperCase = Character.toUpperCase(format.charAt(0));
                Character.valueOf(upperCase).getClass();
                String substring = format.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                format = upperCase + substring;
            }
            chip.setText(StringsKt.removeSuffix(format, (CharSequence) "."));
        }
        ChipGroup chipGroup = binding.cgDays;
        if (chipGroup != null) {
            Intrinsics.checkNotNull(chipGroup);
            for (View view : ViewGroupKt.getChildren(chipGroup)) {
                Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                Chip chip2 = (Chip) view;
                chip2.setChecked(false);
                chip2.setSelected(false);
            }
            chipGroup.clearCheck();
        }
        Chip chip3 = binding.chipLive;
        chip3.setChecked(false);
        chip3.setSelected(false);
        if (dayId >= 0 && dayId < 7) {
            ChipGroup chipGroup2 = binding.cgDays;
            Chip chip4 = (Chip) (chipGroup2 != null ? chipGroup2.getChildAt(dayId) : null);
            if (chip4 != null) {
                chip4.setChecked(true);
                chip4.setSelected(true);
            }
            binding.chipLive.setClickable(true);
            return;
        }
        if (dayId == -1) {
            ChipGroup chipGroup3 = binding.cgDays;
            Chip chip5 = (Chip) (chipGroup3 != null ? chipGroup3.getChildAt(6) : null);
            if (chip5 != null) {
                chip5.setChecked(true);
                chip5.setSelected(true);
            }
            Chip chip6 = binding.chipLive;
            chip6.setSelected(getViewModel().isLive().getValue().booleanValue());
            chip6.setChecked(getViewModel().isLive().getValue().booleanValue());
            chip6.setClickable(!getViewModel().isLive().getValue().booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideScreenState(PlayerState playerState) {
        FragmentVideoPlayerBinding binding = getBinding();
        MaterialToolbar materialToolbar = binding.toolbar;
        if (materialToolbar != null) {
            Intrinsics.checkNotNull(materialToolbar);
            VideoPlayerFragment videoPlayerFragment = this;
            ToolbarKt.setupWithNavController(materialToolbar, FragmentKt.findNavController(videoPlayerFragment), new AppBarConfiguration.Builder(FragmentKt.findNavController(videoPlayerFragment).getGraph()).setOpenableLayout(null).setFallbackOnNavigateUpListener(new VideoPlayerFragment$inlined$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0(new Function0<Boolean>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$provideScreenState$lambda$70$lambda$67$$inlined$AppBarConfiguration$default$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return false;
                }
            })).build());
            materialToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda22
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayerFragment.provideScreenState$lambda$70$lambda$67$lambda$66(VideoPlayerFragment.this, view);
                }
            });
            materialToolbar.setTitle(getViewModel().getStreamDescription());
        }
        if (Intrinsics.areEqual(playerState, PlayerState.Intercom.INSTANCE)) {
            archiveDaysSetOnClickListener(PlayerState.Intercom.INSTANCE);
            FloatingActionButton floatingActionButton = binding.btnOpenDoor;
            floatingActionButton.setVisibility(0);
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda23
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoPlayerFragment.provideScreenState$lambda$70$lambda$69$lambda$68(VideoPlayerFragment.this, view);
                }
            });
            if (getViewModel().getStreamArchiveService() != 7) {
                binding.timeBar.setEventsVisibility(false);
                if (isOrientationLandscape()) {
                    binding.btnFastForward.setVisibility(8);
                    binding.btnRewind.setVisibility(8);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(playerState, PlayerState.Camera.INSTANCE)) {
            archiveDaysSetOnClickListener(PlayerState.Camera.INSTANCE);
            binding.btnOpenDoor.setVisibility(8);
            binding.btnPlaybackSpeed.setVisibility(8);
            if (isOrientationLandscape()) {
                binding.btnFastForward.setVisibility(8);
                binding.btnRewind.setVisibility(8);
            } else {
                binding.btnFastForward.setImageResource(R.drawable.ic_fast_forward_24);
                binding.btnRewind.setImageResource(R.drawable.ic_rewind_back_24);
            }
            if (!getViewModel().getIsFlussonic()) {
                binding.btnVolume.setVisibility(8);
            }
            RecyclerView recyclerView = binding.rvEvents;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            TextView textView = binding.tvEvents;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = binding.tvEventsEmpty;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            binding.timeBar.setEventsVisibility(false);
            return;
        }
        FragmentKt.findNavController(this).popBackStack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideScreenState$lambda$70$lambda$67$lambda$66(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void provideScreenState$lambda$70$lambda$69$lambda$68(VideoPlayerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().openDoor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideEvent(PlayerEvent event) {
        if (event instanceof PlayerEvent.ShowCustomSnackBar) {
            showCustomSnackBar((PlayerEvent.ShowCustomSnackBar) event);
            return;
        }
        if (event instanceof PlayerEvent.ShowMessageSnackBar) {
            showMessageSnackBar((PlayerEvent.ShowMessageSnackBar) event);
            return;
        }
        if (event instanceof PlayerEvent.ShowSnackbar) {
            Snackbar.make(getBinding().clRoot, getString(((PlayerEvent.ShowSnackbar) event).getText()), -1).show();
            return;
        }
        if (event instanceof PlayerEvent.ShowEmergencyCode) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this), NavGraphDestinations.Action.INSTANCE.getToIntercomEmergencyCode(), BundleKt.bundleOf(TuplesKt.to(NavArg.INTERCOM_EMERGENCY_CODE, Integer.valueOf(((PlayerEvent.ShowEmergencyCode) event).getCode()))), null, 4, null);
        } else if (event instanceof PlayerEvent.StartDownload) {
            PlayerEvent.StartDownload startDownload = (PlayerEvent.StartDownload) event;
            startDownload(startDownload.getUrl(), startDownload.getEventId(), startDownload.getStartTime());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        registerConnectionChecker(true);
        maybeShowDoubleTapBanner();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        registerConnectionChecker(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ContentResolver contentResolver;
        super.onDestroyView();
        for (DownloadObserver downloadObserver : this.observerList) {
            try {
                FragmentActivity activity = getActivity();
                if (activity != null && (contentResolver = activity.getContentResolver()) != null) {
                    contentResolver.unregisterContentObserver(downloadObserver);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.controlHandler.removeCallbacks(this.controlRunnable);
        this.zoomHandler.removeCallbacks(this.zoomRunnable);
        try {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.unregisterReceiver(this.downloadReceiver);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.release();
        }
    }

    private final void archiveDaysSetOnClickListener(PlayerState state) {
        Sequence<View> children;
        Sequence<View> children2;
        getBinding().chipLive.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VideoPlayerFragment.archiveDaysSetOnClickListener$lambda$72(VideoPlayerFragment.this, view);
            }
        });
        final int i = 0;
        if (Intrinsics.areEqual(state, PlayerState.Intercom.INSTANCE)) {
            ChipGroup chipGroup = getBinding().cgDays;
            if (chipGroup == null || (children2 = ViewGroupKt.getChildren(chipGroup)) == null) {
                return;
            }
            final int i2 = 0;
            for (View view : children2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final View view2 = view;
                if (i2 > 4) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    ((Chip) view2).setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda8
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            VideoPlayerFragment.archiveDaysSetOnClickListener$lambda$77$lambda$73(VideoPlayerFragment.this, i2, view3);
                        }
                    });
                } else if (getViewModel().getStreamArchiveService() == 2) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    Chip chip = (Chip) view2;
                    chip.setCheckable(false);
                    chip.setAlpha(0.5f);
                    chip.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda9
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            VideoPlayerFragment.archiveDaysSetOnClickListener$lambda$77$lambda$75$lambda$74(VideoPlayerFragment.this, view2, view3);
                        }
                    });
                } else if (getViewModel().getStreamArchiveService() == 7) {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    ((Chip) view2).setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda10
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view3) {
                            VideoPlayerFragment.archiveDaysSetOnClickListener$lambda$77$lambda$76(VideoPlayerFragment.this, i2, view2, view3);
                        }
                    });
                } else {
                    Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
                    ((Chip) view2).setVisibility(8);
                }
                i2 = i3;
            }
            return;
        }
        ChipGroup chipGroup2 = getBinding().cgDays;
        if (chipGroup2 == null || (children = ViewGroupKt.getChildren(chipGroup2)) == null) {
            return;
        }
        for (View view3 : children) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            View view4 = view3;
            Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            ((Chip) view4).setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    VideoPlayerFragment.archiveDaysSetOnClickListener$lambda$79$lambda$78(VideoPlayerFragment.this, i, view5);
                }
            });
            i = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$72(VideoPlayerFragment this$0, View view) {
        ExoPlayer exoPlayer;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoPlayerViewModel.reportEvent$default(this$0.getViewModel(), 107, null, 2, null);
        this$0.getViewModel().onDayClick(-1);
        ExoPlayer exoPlayer2 = this$0.player;
        if (exoPlayer2 != null && !exoPlayer2.isPlaying() && (exoPlayer = this$0.player) != null) {
            exoPlayer.play();
        }
        this$0.getBinding().chipLive.setClickable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$77$lambda$73(VideoPlayerFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoPlayerViewModel.reportEvent$default(this$0.getViewModel(), 9, null, 2, null);
        this$0.getViewModel().onDayClick(i);
        ChipGroup chipGroup = this$0.getBinding().cgDays;
        Intrinsics.checkNotNull(chipGroup);
        View childAt = chipGroup.getChildAt(i);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        this$0.showArchiveToolTip(childAt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$77$lambda$75$lambda$74(VideoPlayerFragment this$0, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        VideoPlayerViewModel.reportEvent$default(this$0.getViewModel(), 10, null, 2, null);
        this$0.showConnectServicesBanner();
        this$0.showArchiveToolTip(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$77$lambda$76(VideoPlayerFragment this$0, int i, View view, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        VideoPlayerViewModel.reportEvent$default(this$0.getViewModel(), 11, null, 2, null);
        this$0.getViewModel().onDayClick(i);
        this$0.showArchiveToolTip(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void archiveDaysSetOnClickListener$lambda$79$lambda$78(VideoPlayerFragment this$0, int i, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewModel().onDayClick(i);
        ChipGroup chipGroup = this$0.getBinding().cgDays;
        Intrinsics.checkNotNull(chipGroup);
        View childAt = chipGroup.getChildAt(i);
        Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
        this$0.showArchiveToolTip(childAt);
    }

    private final void onClickRequestPermission() {
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

    private final void setDownloadButtonClickListener() {
        DownloadViewModel sharedViewModel = getSharedViewModel();
        String value = getViewModel().getStreamUrl().getValue();
        DownloadViewModel.VideoType videoType = Intrinsics.areEqual(getViewModel().getScreenState().getValue(), PlayerState.Intercom.INSTANCE) ? DownloadViewModel.VideoType.Intercom : DownloadViewModel.VideoType.Camera;
        String videoUrl = getViewModel().getVideoUrl();
        if (videoUrl == null && (videoUrl = getViewModel().getCameraLiveSource()) == null) {
            videoUrl = "";
        }
        String userToken = getViewModel().getUserToken();
        Long value2 = getViewModel().getDayStartTime().getValue();
        sharedViewModel.openDownloadDialog(value, videoType, videoUrl, userToken, (value2 != null ? value2.longValue() : Calendar.getInstance().getTimeInMillis()) + getViewModel().getStreamTime().getValue().longValue(), getViewModel().getSelectedDayId().getValue().intValue() == -1, CollectionsKt.reversed(getViewModel().getDays().getValue()), getViewModel().getSelectedDayId().getValue());
        new DownloadDialog().show(getChildFragmentManager(), "download");
    }

    private final boolean askReadMediaVideoPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_MEDIA_VIDEO") == 0;
    }

    private final boolean askReadExternalStoragePermission() {
        return ContextCompat.checkSelfPermission(requireContext(), PermissionUtil.READ_EXTERNAL_PERMISSION) == 0;
    }

    private final boolean askWriteExternalStoragePermission() {
        return ContextCompat.checkSelfPermission(requireContext(), PermissionUtil.WRITE_EXTERNAL_PERMISSION) == 0;
    }

    private final void takeScreenshot(final Function1<? super Bitmap, Unit> callback) {
        if (Build.VERSION.SDK_INT < 24) {
            View videoSurfaceView = getBinding().playerView.getVideoSurfaceView();
            callback.invoke(videoSurfaceView != null ? ViewKt.drawToBitmap$default(videoSurfaceView, null, 1, null) : null);
            return;
        }
        View videoSurfaceView2 = getBinding().playerView.getVideoSurfaceView();
        Intrinsics.checkNotNull(videoSurfaceView2, "null cannot be cast to non-null type android.view.SurfaceView");
        SurfaceView surfaceView = (SurfaceView) videoSurfaceView2;
        final Bitmap createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        try {
            final HandlerThread handlerThread = new HandlerThread("PixelCopier");
            handlerThread.start();
            PixelCopy.request(surfaceView, createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda27
                @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                public final void onPixelCopyFinished(int i) {
                    VideoPlayerFragment.takeScreenshot$lambda$80(Function1.this, createBitmap, handlerThread, i);
                }
            }, new Handler(handlerThread.getLooper()));
        } catch (Exception unused) {
            callback.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takeScreenshot$lambda$80(Function1 callback, Bitmap bitmap, HandlerThread handlerThread, int i) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(handlerThread, "$handlerThread");
        if (i == 0) {
            callback.invoke(bitmap);
        }
        handlerThread.quitSafely();
    }

    private final void showCustomSnackBar(PlayerEvent.ShowCustomSnackBar event) {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_player_custom, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarPlayerCustomBinding bind = SnackbarPlayerCustomBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        final Snackbar make = Snackbar.make(getBinding().clRoot, "", event.getDuration());
        Intrinsics.checkNotNullExpressionValue(make, "make(...)");
        View view = make.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        View view2 = make.getView();
        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = 49;
        view2.setLayoutParams(layoutParams2);
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(inflate, 0);
        make.getView().setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.bg_rounded_dialog_16dp, null));
        TextView textView = bind.tvSnackTitle;
        Integer titleText = event.getTitleText();
        if (titleText != null) {
            textView.setText(titleText.intValue());
            textView.setVisibility(0);
        }
        textView.setGravity(event.getTitleGravity());
        TextView textView2 = bind.tvSnackInfo;
        Integer messageText = event.getMessageText();
        if (messageText != null) {
            textView2.setText(messageText.intValue());
            textView2.setVisibility(0);
        }
        textView2.setGravity(event.getMessageGravity());
        TextView textView3 = bind.tvSnackButton;
        Integer buttonText = event.getButtonText();
        if (buttonText != null) {
            textView3.setText(buttonText.intValue());
            textView3.setVisibility(0);
        }
        final Function0<Unit> buttonCallback = event.getButtonCallback();
        if (buttonCallback != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda28
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    VideoPlayerFragment.showCustomSnackBar$lambda$91$lambda$88$lambda$87$lambda$86(Function0.this, make, view3);
                }
            });
        }
        ImageView imageView = bind.btnClose;
        Intrinsics.checkNotNull(imageView);
        imageView.setVisibility(event.getCloseButtonVisibility() ? 0 : 8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$$ExternalSyntheticLambda29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                VideoPlayerFragment.showCustomSnackBar$lambda$91$lambda$90$lambda$89(Snackbar.this, view3);
            }
        });
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomSnackBar$lambda$91$lambda$88$lambda$87$lambda$86(Function0 buttonCallback, Snackbar snackBar, View view) {
        Intrinsics.checkNotNullParameter(buttonCallback, "$buttonCallback");
        Intrinsics.checkNotNullParameter(snackBar, "$snackBar");
        buttonCallback.invoke();
        snackBar.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showCustomSnackBar$lambda$91$lambda$90$lambda$89(Snackbar snackBar, View view) {
        Intrinsics.checkNotNullParameter(snackBar, "$snackBar");
        snackBar.dismiss();
    }

    private final void showMessageSnackBar(PlayerEvent.ShowMessageSnackBar event) {
        View inflate = getLayoutInflater().inflate(R.layout.snackbar_player_message, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        SnackbarPlayerMessageBinding bind = SnackbarPlayerMessageBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        Snackbar make = Snackbar.make(getBinding().clRoot, "", event.getDuration());
        Intrinsics.checkNotNullExpressionValue(make, "make(...)");
        make.getView().setBackgroundColor(0);
        View view = make.getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.google.android.material.snackbar.Snackbar.SnackbarLayout");
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) view;
        View view2 = make.getView();
        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = 49;
        view2.setLayoutParams(layoutParams2);
        snackbarLayout.setPadding(0, 0, 0, 0);
        snackbarLayout.addView(inflate, 0);
        TextView textView = bind.tvSnackTitle;
        Integer text = event.getText();
        if (text != null) {
            textView.setText(text.intValue());
            textView.setVisibility(0);
        }
        textView.setGravity(event.getGravity());
        make.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void keepScaleFactorView() {
        this.zoomHandler.removeCallbacks(this.zoomRunnable);
        this.zoomHandler.postDelayed(this.zoomRunnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void keepControlButtons() {
        this.controlHandler.removeCallbacks(this.controlRunnable);
        this.controlHandler.postDelayed(this.controlRunnable, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isOrientationLandscape() {
        return getResources().getConfiguration().orientation == 2;
    }

    public final void onScreenRotate(int orientation) {
        String str;
        String str2;
        String str3;
        if (Settings.System.getInt(requireContext().getContentResolver(), "accelerometer_rotation", 0) != 1) {
            this.isForcedOrientation = null;
            return;
        }
        boolean z = 245 <= orientation && orientation < 296;
        boolean z2 = 65 <= orientation && orientation < 116;
        boolean z3 = (orientation >= 0 && orientation < 26) || (335 <= orientation && orientation < 361);
        if (z) {
            if (requireActivity().getRequestedOrientation() == 0 || ((str3 = this.isForcedOrientation) != null && str3.length() != 0)) {
                if (Intrinsics.areEqual(LAND, this.isForcedOrientation)) {
                    this.isForcedOrientation = null;
                    return;
                }
                return;
            }
            requireActivity().setRequestedOrientation(0);
            return;
        }
        if (z2) {
            if (requireActivity().getRequestedOrientation() == 8 || ((str2 = this.isForcedOrientation) != null && str2.length() != 0)) {
                if (Intrinsics.areEqual(LAND, this.isForcedOrientation)) {
                    this.isForcedOrientation = null;
                    return;
                }
                return;
            }
            requireActivity().setRequestedOrientation(8);
            return;
        }
        if (z3) {
            if (requireActivity().getRequestedOrientation() != 1 && ((str = this.isForcedOrientation) == null || str.length() == 0)) {
                requireActivity().setRequestedOrientation(1);
            } else if (Intrinsics.areEqual(PORTRAIT, this.isForcedOrientation)) {
                this.isForcedOrientation = null;
            }
        }
    }

    private final void startDownload(String url, String eventId, long startTime) {
        String generateVideoDescription = generateVideoDescription(startTime);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.addRequestHeader("access-token", getViewModel().getUserToken());
        request.setTitle(generateVideoDescription);
        request.setDescription("Загрузка");
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "Мой дом" + File.separator + generateVideoDescription);
        request.setNotificationVisibility(1);
        long enqueue = getDownloadManager().enqueue(request);
        getViewModel().saveDownload(new DownloadDto(eventId, enqueue, true));
        registerContentObserver(enqueue);
    }

    private final String generateVideoDescription(long startTime) {
        return "Событие " + new SimpleDateFormat("d.MM HH.mm.ss", new Locale("ru", "RU")).format(Long.valueOf(startTime)) + ".mp4";
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
                    getViewModel().changeDownloadState(downloadId, (int) ((i * 100) / i2));
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(query, null);
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerContentObserver(final long downloadId) {
        ContentResolver contentResolver;
        Uri parse = Uri.parse("content://downloads/my_downloads/" + downloadId);
        try {
            DownloadObserver downloadObserver = new DownloadObserver(downloadId, new Function1<Long, Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$registerContentObserver$observer$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                    invoke(l.longValue());
                    return Unit.INSTANCE;
                }

                /* compiled from: VideoPlayerFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$registerContentObserver$observer$1$1", f = "VideoPlayerFragment.kt", i = {}, l = {1550, 1552}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$registerContentObserver$observer$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ long $downloadId;
                    int label;
                    final /* synthetic */ VideoPlayerFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(VideoPlayerFragment videoPlayerFragment, long j, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.this$0 = videoPlayerFragment;
                        this.$downloadId = j;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.this$0, this.$downloadId, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        VideoPlayerViewModel viewModel;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            viewModel = this.this$0.getViewModel();
                            this.label = 1;
                            obj = VideoPlayerViewModel.getDownload$default(viewModel, this.$downloadId, null, this, 2, null);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                if (i != 2) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        DownloadDto downloadDto = (DownloadDto) obj;
                        if (downloadDto != null) {
                            this.label = 2;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new C01271(this.this$0, downloadDto, null), this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }

                    /* compiled from: VideoPlayerFragment.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$registerContentObserver$observer$1$1$1", f = "VideoPlayerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$registerContentObserver$observer$1$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DownloadDto $model;
                        int label;
                        final /* synthetic */ VideoPlayerFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C01271(VideoPlayerFragment videoPlayerFragment, DownloadDto downloadDto, Continuation<? super C01271> continuation) {
                            super(2, continuation);
                            this.this$0 = videoPlayerFragment;
                            this.$model = downloadDto;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C01271(this.this$0, this.$model, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C01271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.this$0.getDownloadProgress(this.$model.getDownloadId());
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                public final void invoke(long j) {
                    VideoPlayerViewModel viewModel;
                    viewModel = VideoPlayerFragment.this.getViewModel();
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(viewModel), null, null, new AnonymousClass1(VideoPlayerFragment.this, downloadId, null), 3, null);
                }
            }, new Handler(Looper.getMainLooper()));
            this.observerList.add(downloadObserver);
            FragmentActivity activity = getActivity();
            if (activity == null || (contentResolver = activity.getContentResolver()) == null) {
                return;
            }
            contentResolver.registerContentObserver(parse, false, downloadObserver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final long getCurrentDayStartTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(getBinding().timeBar.getMCursorValue()));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private final void showTimelineToolTip() {
        if (getViewModel().isToolTipRequires(ConfigInteractor.ToolTips.TIMELINE)) {
            VideoTimeBar timeBar = getBinding().timeBar;
            Intrinsics.checkNotNullExpressionValue(timeBar, "timeBar");
            Tooltip.TooltipBuilder tooltipBuilder = new Tooltip.TooltipBuilder(timeBar);
            String string = getString(R.string.tooltip_timeline);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Tooltip build = tooltipBuilder.setText(string).setAlignment(Tooltip.Alignment.TOP).setGravity(17).isOutsideTouchable(true).setOnCloseListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$showTimelineToolTip$1
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
                    VideoPlayerViewModel viewModel;
                    viewModel = VideoPlayerFragment.this.getViewModel();
                    viewModel.onCloseToolTip(ConfigInteractor.ToolTips.TIMELINE);
                }
            }).build();
            this.timeBarToolTip = build;
            Intrinsics.checkNotNull(build);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            int dpToPx = ExtensionsKt.dpToPx(16, resources);
            Resources resources2 = getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            build.showAtTop(dpToPx, ExtensionsKt.dpToPx(-12, resources2));
        }
    }

    private final <T> void collectOnLifecycle(SharedFlow<? extends T> sharedFlow, Lifecycle.State state, Function1<? super T, Unit> function1) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new VideoPlayerFragment$collectOnLifecycle$1(this, state, sharedFlow, function1, null), 3, null);
    }

    static /* synthetic */ boolean checkDownloadStatus$default(VideoPlayerFragment videoPlayerFragment, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return videoPlayerFragment.checkDownloadStatus(j, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003a, code lost:
    
        if (r7 != 16) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean checkDownloadStatus(long r5, boolean r7) {
        /*
            r4 = this;
            android.app.DownloadManager$Query r0 = new android.app.DownloadManager$Query
            r0.<init>()
            r1 = 1
            long[] r2 = new long[r1]
            r3 = 0
            r2[r3] = r5
            android.app.DownloadManager$Query r0 = r0.setFilterById(r2)
            android.app.DownloadManager r2 = r4.getDownloadManager()
            android.database.Cursor r0 = r2.query(r0)
            java.lang.String r2 = "query(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r2 = r0.moveToFirst()
            if (r2 == 0) goto L4f
            java.lang.String r7 = "status"
            int r7 = r0.getColumnIndex(r7)
            int r7 = r0.getInt(r7)
            if (r7 == r1) goto L4d
            r0 = 2
            if (r7 == r0) goto L4d
            r0 = 4
            if (r7 == r0) goto L45
            r0 = 8
            if (r7 == r0) goto L3d
            r0 = 16
            if (r7 == r0) goto L45
            goto L4d
        L3d:
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r7 = r4.getViewModel()
            r7.setDownloadCompleted(r5)
            goto L58
        L45:
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r7 = r4.getViewModel()
            r7.setDownloadError(r5)
            goto L58
        L4d:
            r1 = r3
            goto L58
        L4f:
            if (r7 == 0) goto L58
            ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r7 = r4.getViewModel()
            r7.setDownloadCompleted(r5)
        L58:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment.checkDownloadStatus(long, boolean):boolean");
    }

    public final void tryToStartDownload(long startTime, long duration, String eventId) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        if (Build.VERSION.SDK_INT > 32) {
            if (askReadMediaVideoPermission()) {
                getViewModel().tryToAddDownload(startTime, duration, eventId);
                return;
            } else {
                this.eventPermissionLauncher.launch(new String[]{"android.permission.READ_MEDIA_VIDEO"});
                return;
            }
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (askReadExternalStoragePermission() && askWriteExternalStoragePermission()) {
                getViewModel().tryToAddDownload(startTime, duration, eventId);
                return;
            } else {
                this.eventPermissionLauncher.launch(new String[]{PermissionUtil.READ_EXTERNAL_PERMISSION, PermissionUtil.WRITE_EXTERNAL_PERMISSION});
                return;
            }
        }
        if (askReadExternalStoragePermission()) {
            getViewModel().tryToAddDownload(startTime, duration, eventId);
        } else {
            this.eventPermissionLauncher.launch(new String[]{PermissionUtil.READ_EXTERNAL_PERMISSION});
        }
    }

    private final void showArchiveToolTip(View child) {
        if (getViewModel().isToolTipRequires(ConfigInteractor.ToolTips.ARCHIVE)) {
            Tooltip.TooltipBuilder tooltipBuilder = new Tooltip.TooltipBuilder(child);
            String string = getString(R.string.tooltip_archive);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Tooltip build = tooltipBuilder.setText(string).setAlignment(Tooltip.Alignment.BOTTOM).setGravity(GravityCompat.END).setArrowGravity(GravityCompat.START).isOutsideTouchable(true).setOnCloseListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerFragment$showArchiveToolTip$1
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
                    VideoPlayerViewModel viewModel;
                    viewModel = VideoPlayerFragment.this.getViewModel();
                    viewModel.onCloseToolTip(ConfigInteractor.ToolTips.ARCHIVE);
                }
            }).build();
            this.chipToolTip = build;
            Intrinsics.checkNotNull(build);
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            Tooltip.showAtBottom$default(build, 0, ExtensionsKt.dpToPx(-8, resources), 1, null);
        }
    }
}
