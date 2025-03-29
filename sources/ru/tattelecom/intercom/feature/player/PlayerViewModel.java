package ru.tattelecom.intercom.feature.player;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.commons.compress.archivers.tar.TarConstants;
import ru.tattelecom.intercom.android.resources.ConnectionChecker;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.data.local.entity.LockGateEntity;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.StreamInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.call.CallState;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001:\u0004¢\u0001£\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u0010s\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0013J\u0010\u0010v\u001a\u00020t2\b\u0010w\u001a\u0004\u0018\u00010xJ&\u0010y\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010z\u001a\u00020 2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010|J\u0006\u0010}\u001a\u00020\u0019J\u000e\u0010~\u001a\u00020t2\u0006\u0010\u007f\u001a\u00020 J\u0011\u0010\u0080\u0001\u001a\u00020t2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0010\u0010\u0083\u0001\u001a\u00020t2\u0007\u0010\u0084\u0001\u001a\u00020$J\u0007\u0010\u0085\u0001\u001a\u00020tJ\u0007\u0010\u0086\u0001\u001a\u00020tJ\u0007\u0010\u0087\u0001\u001a\u00020tJ\u0010\u0010\u0088\u0001\u001a\u00020t2\u0007\u0010\u0089\u0001\u001a\u00020\u0019J\u0010\u0010\u008a\u0001\u001a\u00020t2\u0007\u0010\u008b\u0001\u001a\u00020\u0019J\u0007\u0010\u008c\u0001\u001a\u00020tJ\u0010\u0010\u008d\u0001\u001a\u00020t2\u0007\u0010\u008e\u0001\u001a\u00020\u0019J\u0007\u0010\u008f\u0001\u001a\u00020tJ\u0007\u0010\u0090\u0001\u001a\u00020tJ\u0007\u0010\u0091\u0001\u001a\u00020tJ\u0018\u0010\u0092\u0001\u001a\u00020t2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010 ¢\u0006\u0003\u0010\u0094\u0001J\u0014\u0010\u0095\u0001\u001a\u00020t2\t\b\u0002\u0010\u0096\u0001\u001a\u00020 H\u0002J%\u0010\u0097\u0001\u001a\u00020t2\u0007\u0010\u0096\u0001\u001a\u00020 2\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0003\u0010\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u00020t2\u0006\u0010u\u001a\u00020\u0013J\u0010\u0010\u009b\u0001\u001a\u00020t2\u0007\u0010\u009c\u0001\u001a\u00020$J\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0003\u0010\u009e\u0001J\u0019\u0010\u009f\u0001\u001a\u00020t2\u0007\u0010 \u0001\u001a\u00020 2\u0007\u0010¡\u0001\u001a\u00020$R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00190#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&R \u0010'\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010,\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020100¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R#\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020$0#00¢\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00160:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00190@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0012\u0010C\u001a\u0004\u0018\u00010$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010DR\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020\u001b0@¢\u0006\b\n\u0000\u001a\u0004\bF\u0010BR\u0012\u0010G\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010DR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010H\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\bI\u0010.R\u001f\u0010J\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010\u00190\u001900¢\u0006\b\n\u0000\u001a\u0004\bJ\u00104R\u0011\u0010L\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u0019\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001900¢\u0006\b\n\u0000\u001a\u0004\bN\u00104R\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$00¢\u0006\b\n\u0000\u001a\u0004\bO\u00104R\u001f\u0010P\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010\u00190\u001900¢\u0006\b\n\u0000\u001a\u0004\bP\u00104R\u001f\u0010Q\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010\u00190\u001900¢\u0006\b\n\u0000\u001a\u0004\bQ\u00104R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00190S¢\u0006\b\n\u0000\u001a\u0004\bR\u0010TR\u001f\u0010U\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010\u00190\u001900¢\u0006\b\n\u0000\u001a\u0004\bU\u00104R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00190@¢\u0006\b\n\u0000\u001a\u0004\bW\u0010BR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190S¢\u0006\b\n\u0000\u001a\u0004\bY\u0010TR\u0010\u0010Z\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010[\u001a\b\u0012\u0004\u0012\u00020\\00¢\u0006\b\n\u0000\u001a\u0004\b]\u00104R\u0017\u0010^\u001a\b\u0012\u0004\u0012\u00020$00¢\u0006\b\n\u0000\u001a\u0004\b_\u00104R\u001a\u0010`\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u001a\u0010e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010M\"\u0004\bg\u0010hR\u0017\u0010i\u001a\b\u0012\u0004\u0012\u00020 0S¢\u0006\b\n\u0000\u001a\u0004\bj\u0010TR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010k\u001a\u0010\u0012\f\u0012\n K*\u0004\u0018\u00010\u00190\u001900¢\u0006\b\n\u0000\u001a\u0004\bl\u00104R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020 0S¢\u0006\b\n\u0000\u001a\u0004\bn\u0010TR\u0019\u0010o\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001600¢\u0006\b\n\u0000\u001a\u0004\bp\u00104R\u0011\u0010q\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\br\u0010.R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006¤\u0001"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "streamInteractor", "Lru/tattelecom/intercom/domain/interactors/StreamInteractor;", "intercomInteractor", "Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "gateInteractor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "lockGateInteractor", "Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/UserInteractor;Lru/tattelecom/intercom/domain/interactors/StreamInteractor;Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/domain/interactors/GateInteractor;Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;)V", "_downloadList", "", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "_downloadUrl", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_eventShowErrorSnack", "Lkotlinx/coroutines/channels/Channel;", "", "_events", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "_isStreamPaused", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_prepareProgressIsVisible", "_streamDurationInSeconds", "", "_streamTimeInSeconds", "buildingServices", "Lkotlin/Pair;", "", "callTime", "Ljava/lang/Long;", "cameraArchive", "cameraArchiveExportSource", "cameraArchiveSource", "cameraArchiveTimeFormatter", "Ljava/text/SimpleDateFormat;", "cameraLiveSource", "getCameraLiveSource", "()Ljava/lang/String;", "days", "Landroidx/lifecycle/MutableLiveData;", "", "Ljava/util/Date;", "getDays", "()Landroidx/lifecycle/MutableLiveData;", "description", "getDescription", "downloadSettings", "getDownloadSettings", "downloadUrl", "Lkotlinx/coroutines/flow/SharedFlow;", "getDownloadUrl", "()Lkotlinx/coroutines/flow/SharedFlow;", "endCallJob", "Lkotlinx/coroutines/Job;", "eventShowErrorSnack", "Lkotlinx/coroutines/flow/Flow;", "getEventShowErrorSnack", "()Lkotlinx/coroutines/flow/Flow;", NavArg.EVENT_TYPE, "Ljava/lang/Integer;", "events", "getEvents", "gateId", NavArg.INTERCOM_LOGIN, "getIntercomLogin", "isBadConnBannerClosed", "kotlin.jvm.PlatformType", "isFlussonic", "()Z", "isMicEnabled", "isOpenDoorError", VideoPlayerViewModel.IS_OPEN_DOOR_LOADING, "isStreamLoading", "isStreamPaused", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isVideoZoomed", "lockStatusIntercom", "getLockStatusIntercom", "prepareProgressIsVisible", "getPrepareProgressIsVisible", "refreshPlayerTimeJob", "screenState", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "getScreenState", "selectedDay", "getSelectedDay", "streamArchiveService", "getStreamArchiveService", "()I", "setStreamArchiveService", "(I)V", "streamDownloadService", "getStreamDownloadService", "setStreamDownloadService", "(Z)V", "streamDurationInSeconds", "getStreamDurationInSeconds", "streamLoadError", "getStreamLoadError", "streamTimeInSeconds", "getStreamTimeInSeconds", VideoPlayerViewModel.STREAM_URL, "getStreamUrl", PushNotificationArg.TECH_LOG_TOKEN, "getToken", "addDownload", "", "model", "checkConnection", "context", "Landroid/content/Context;", "getDownload", "downloadId", "urlDescription", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAdmin", "onArchiveTimeSelected", "timeInSeconds", "onCallStateChanged", "state", "Lru/tattelecom/intercom/feature/call/CallState;", "onDayClick", FirebaseAnalytics.Param.INDEX, "onEndCall", "onMicClick", "onOpenGateClick", "onPinchToZoomGesture", "isZoomed", "onSipVideoLoaded", "isLoaded", "onStreamError", "onStreamLoading", "isLoading", "onStreamPause", "onStreamPauseResume", "onStreamRefresh", "onStreamTimeReceived", "timeInMillis", "(Ljava/lang/Long;)V", "provideCameraStream", "additionalTimeInSeconds", "provideIntercomStream", "startTimeInSeconds", "(JLjava/lang/Long;)V", "removeDownload", "reportEvent", "buttonId", "selectedDayInSeconds", "()Ljava/lang/Long;", "setDownloadVideoOptions", "startTime", "duration", "Event", "PlayerState", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PlayerViewModel extends ViewModel {
    private List<DownloadDto> _downloadList;
    private final MutableSharedFlow<String> _downloadUrl;
    private final Channel<Boolean> _eventShowErrorSnack;
    private final Channel<Event> _events;
    private final MutableStateFlow<Boolean> _isStreamPaused;
    private final MutableStateFlow<Boolean> _prepareProgressIsVisible;
    private final MutableStateFlow<Long> _streamDurationInSeconds;
    private final MutableStateFlow<Long> _streamTimeInSeconds;
    private final Pair<Integer, Boolean> buildingServices;
    private final Long callTime;
    private final Pair<String, String> cameraArchive;
    private final String cameraArchiveExportSource;
    private final String cameraArchiveSource;
    private final SimpleDateFormat cameraArchiveTimeFormatter;
    private final String cameraLiveSource;
    private final MutableLiveData<List<Date>> days;
    private final String description;
    private final MutableLiveData<Pair<Long, Integer>> downloadSettings;
    private final SharedFlow<String> downloadUrl;
    private Job endCallJob;
    private final Flow<Boolean> eventShowErrorSnack;
    private final Integer eventType;
    private final Flow<Event> events;
    private Integer gateId;
    private final GateInteractor gateInteractor;
    private final IntercomInteractor intercomInteractor;
    private final String intercomLogin;
    private final MutableLiveData<Boolean> isBadConnBannerClosed;
    private final boolean isFlussonic;
    private final MutableLiveData<Boolean> isMicEnabled;
    private final MutableLiveData<Integer> isOpenDoorError;
    private final MutableLiveData<Boolean> isOpenDoorLoading;
    private final MutableLiveData<Boolean> isStreamLoading;
    private final StateFlow<Boolean> isStreamPaused;
    private final MutableLiveData<Boolean> isVideoZoomed;
    private final LockGateInteractor lockGateInteractor;
    private final Flow<Boolean> lockStatusIntercom;
    private final LogInteractor logInteractor;
    private final StateFlow<Boolean> prepareProgressIsVisible;
    private Job refreshPlayerTimeJob;
    private final MutableLiveData<PlayerState> screenState;
    private final MutableLiveData<Integer> selectedDay;
    private int streamArchiveService;
    private boolean streamDownloadService;
    private final StateFlow<Long> streamDurationInSeconds;
    private final StreamInteractor streamInteractor;
    private final MutableLiveData<Boolean> streamLoadError;
    private final StateFlow<Long> streamTimeInSeconds;
    private final MutableLiveData<String> streamUrl;
    private final String token;
    private final UserInteractor userInteractor;

    public PlayerViewModel(SavedStateHandle handle, UserInteractor userInteractor, StreamInteractor streamInteractor, IntercomInteractor intercomInteractor, LogInteractor logInteractor, GateInteractor gateInteractor, LockGateInteractor lockGateInteractor) {
        PlayerState.CameraArchive cameraArchive;
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(streamInteractor, "streamInteractor");
        Intrinsics.checkNotNullParameter(intercomInteractor, "intercomInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(gateInteractor, "gateInteractor");
        Intrinsics.checkNotNullParameter(lockGateInteractor, "lockGateInteractor");
        this.userInteractor = userInteractor;
        this.streamInteractor = streamInteractor;
        this.intercomInteractor = intercomInteractor;
        this.logInteractor = logInteractor;
        this.gateInteractor = gateInteractor;
        this.lockGateInteractor = lockGateInteractor;
        Long l = (Long) handle.get("callTime");
        this.callTime = l;
        Integer num = (Integer) handle.get(NavArg.EVENT_TYPE);
        this.eventType = num;
        String str = (String) handle.get("cameraLiveSource");
        this.cameraLiveSource = str;
        Pair<String, String> pair = (Pair) handle.get("cameraArchiveSource");
        this.cameraArchive = pair;
        String first = pair != null ? pair.getFirst() : null;
        this.cameraArchiveSource = first;
        this.cameraArchiveExportSource = pair != null ? pair.getSecond() : null;
        this.description = (String) handle.get("streamDescription");
        Boolean bool = (Boolean) handle.get("isFlussonic");
        this.isFlussonic = bool != null ? bool.booleanValue() : false;
        String str2 = (String) handle.get(NavArg.INTERCOM_LOGIN);
        this.intercomLogin = str2;
        Integer num2 = (Integer) handle.get("gateId");
        this.gateId = num2;
        if (num2 == null && str2 != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$1$1(this, str2, null), 3, null);
        }
        MutableLiveData<String> liveData = handle.getLiveData("videoUrl");
        this.streamUrl = liveData;
        Pair<Integer, Boolean> pair2 = (Pair) handle.get("buildingServices");
        pair2 = pair2 == null ? new Pair<>(2, false) : pair2;
        this.buildingServices = pair2;
        this.streamArchiveService = pair2.getFirst().intValue();
        this.streamDownloadService = pair2.getSecond().booleanValue();
        final Flow<List<LockGateEntity>> statusLockGate = lockGateInteractor.statusLockGate();
        this.lockStatusIntercom = new Flow<Boolean>() { // from class: ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ PlayerViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1$2", f = "PlayerViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, PlayerViewModel playerViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = playerViewModel;
                }

                /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
                
                    if (r7.checkDateLock(r2.getDate()) == false) goto L28;
                 */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r8
                        ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r8 = r0.label
                        int r8 = r8 - r2
                        r0.label = r8
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L19:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L8a
                    L2a:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L32:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r8 = r6.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r7 = (java.util.List) r7
                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                        java.util.Iterator r7 = r7.iterator()
                    L42:
                        boolean r2 = r7.hasNext()
                        if (r2 == 0) goto L63
                        java.lang.Object r2 = r7.next()
                        r4 = r2
                        ru.tattelecom.intercom.data.local.entity.LockGateEntity r4 = (ru.tattelecom.intercom.data.local.entity.LockGateEntity) r4
                        int r4 = r4.getGateId()
                        ru.tattelecom.intercom.feature.player.PlayerViewModel r5 = r6.this$0
                        java.lang.Integer r5 = ru.tattelecom.intercom.feature.player.PlayerViewModel.access$getGateId$p(r5)
                        if (r5 != 0) goto L5c
                        goto L42
                    L5c:
                        int r5 = r5.intValue()
                        if (r4 != r5) goto L42
                        goto L64
                    L63:
                        r2 = 0
                    L64:
                        ru.tattelecom.intercom.data.local.entity.LockGateEntity r2 = (ru.tattelecom.intercom.data.local.entity.LockGateEntity) r2
                        if (r2 == 0) goto L78
                        ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0
                        ru.tattelecom.intercom.domain.interactors.LockGateInteractor r7 = ru.tattelecom.intercom.feature.player.PlayerViewModel.access$getLockGateInteractor$p(r7)
                        long r4 = r2.getDate()
                        boolean r7 = r7.checkDateLock(r4)
                        if (r7 != 0) goto L7a
                    L78:
                        if (r2 != 0) goto L7c
                    L7a:
                        r7 = r3
                        goto L7d
                    L7c:
                        r7 = 0
                    L7d:
                        java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
                        r0.label = r3
                        java.lang.Object r7 = r8.emit(r7, r0)
                        if (r7 != r1) goto L8a
                        return r1
                    L8a:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.player.PlayerViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Boolean> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        String token = userInteractor.getToken();
        this.token = token == null ? "" : token;
        MutableLiveData<PlayerState> mutableLiveData = new MutableLiveData<>();
        this.screenState = mutableLiveData;
        this.days = new MutableLiveData<>();
        this.selectedDay = new MutableLiveData<>();
        this.isMicEnabled = new MutableLiveData<>(null);
        this.isVideoZoomed = new MutableLiveData<>(false);
        this.isOpenDoorLoading = new MutableLiveData<>(false);
        this.isOpenDoorError = new MutableLiveData<>(null);
        this.isStreamLoading = new MutableLiveData<>(true);
        this.streamLoadError = new MutableLiveData<>(false);
        this.isBadConnBannerClosed = new MutableLiveData<>(false);
        MutableStateFlow<Long> MutableStateFlow = StateFlowKt.MutableStateFlow(82800L);
        this._streamDurationInSeconds = MutableStateFlow;
        this.streamDurationInSeconds = MutableStateFlow;
        MutableStateFlow<Long> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0L);
        this._streamTimeInSeconds = MutableStateFlow2;
        this.streamTimeInSeconds = MutableStateFlow2;
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._isStreamPaused = MutableStateFlow3;
        this.isStreamPaused = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(null);
        this._prepareProgressIsVisible = MutableStateFlow4;
        this.prepareProgressIsVisible = MutableStateFlow4;
        MutableSharedFlow<String> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._downloadUrl = MutableSharedFlow$default;
        this.downloadUrl = MutableSharedFlow$default;
        this._downloadList = new ArrayList();
        this.downloadSettings = new MutableLiveData<>();
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        Channel<Boolean> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowErrorSnack = Channel$default2;
        this.eventShowErrorSnack = FlowKt.receiveAsFlow(Channel$default2);
        this.cameraArchiveTimeFormatter = new SimpleDateFormat("yyyyMMdd'T'HHmmss", new Locale("RU"));
        if (liveData.getValue() == null && first == null && str == null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
            cameraArchive = PlayerState.Call.INSTANCE;
        } else if (str2 != null || first != null || str != null) {
            ArrayList arrayList = new ArrayList();
            Calendar calendar = Calendar.getInstance();
            for (int i = 1; i < 8; i++) {
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                Date time = calendar.getTime();
                Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
                arrayList.add(time);
                calendar.add(5, -1);
            }
            this.days.setValue(arrayList);
            this.selectedDay.setValue(7);
            if (this.intercomLogin != null) {
                cameraArchive = PlayerState.IntercomArchive.INSTANCE;
            } else {
                provideCameraStream$default(this, 0L, 1, null);
                cameraArchive = PlayerState.CameraArchive.INSTANCE;
            }
        } else {
            if ((num != null && num.intValue() == 3) || ((num != null && num.intValue() == 4) || (num != null && num.intValue() == 5))) {
                if (l != null) {
                    provideIntercomStream(25L, Long.valueOf(l.longValue() - 10));
                }
                MutableStateFlow.setValue(30L);
            }
            cameraArchive = PlayerState.CallArchive.INSTANCE;
        }
        mutableLiveData.setValue(cameraArchive);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass5(null), 3, null);
    }

    /* compiled from: PlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "", "()V", "Call", "CallArchive", "CameraArchive", "IntercomArchive", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$Call;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$CallArchive;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$CameraArchive;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$IntercomArchive;", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class PlayerState {
        public /* synthetic */ PlayerState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$Call;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Call extends PlayerState {
            public static final Call INSTANCE = new Call();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Call)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1556930490;
            }

            public String toString() {
                return "Call";
            }

            private Call() {
                super(null);
            }
        }

        private PlayerState() {
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$CallArchive;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CallArchive extends PlayerState {
            public static final CallArchive INSTANCE = new CallArchive();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CallArchive)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1321427556;
            }

            public String toString() {
                return "CallArchive";
            }

            private CallArchive() {
                super(null);
            }
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$CameraArchive;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CameraArchive extends PlayerState {
            public static final CameraArchive INSTANCE = new CameraArchive();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CameraArchive)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1061859083;
            }

            public String toString() {
                return "CameraArchive";
            }

            private CameraArchive() {
                super(null);
            }
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState$IntercomArchive;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class IntercomArchive extends PlayerState {
            public static final IntercomArchive INSTANCE = new IntercomArchive();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IntercomArchive)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 289181429;
            }

            public String toString() {
                return "IntercomArchive";
            }

            private IntercomArchive() {
                super(null);
            }
        }
    }

    /* compiled from: PlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "", "()V", "EndCall", "RefreshTime", "SeekTo", "ShowInAppReview", "ShowMessage", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$EndCall;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$RefreshTime;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$SeekTo;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$ShowInAppReview;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$ShowMessage;", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$RefreshTime;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class RefreshTime extends Event {
            public static final RefreshTime INSTANCE = new RefreshTime();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshTime)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1696452426;
            }

            public String toString() {
                return "RefreshTime";
            }

            private RefreshTime() {
                super(null);
            }
        }

        private Event() {
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$EndCall;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class EndCall extends Event {
            public static final EndCall INSTANCE = new EndCall();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EndCall)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2900517;
            }

            public String toString() {
                return "EndCall";
            }

            private EndCall() {
                super(null);
            }
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$ShowInAppReview;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowInAppReview extends Event {
            public static final ShowInAppReview INSTANCE = new ShowInAppReview();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowInAppReview)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2087359481;
            }

            public String toString() {
                return "ShowInAppReview";
            }

            private ShowInAppReview() {
                super(null);
            }
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$SeekTo;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", CrashHianalyticsData.TIME, "", "(J)V", "getTime", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class SeekTo extends Event {
            private final long time;

            public static /* synthetic */ SeekTo copy$default(SeekTo seekTo, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = seekTo.time;
                }
                return seekTo.copy(j);
            }

            /* renamed from: component1, reason: from getter */
            public final long getTime() {
                return this.time;
            }

            public final SeekTo copy(long time) {
                return new SeekTo(time);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SeekTo) && this.time == ((SeekTo) other).time;
            }

            public int hashCode() {
                return AdvThemeDto$$ExternalSyntheticBackport0.m(this.time);
            }

            public String toString() {
                return "SeekTo(time=" + this.time + ")";
            }

            public SeekTo(long j) {
                super(null);
                this.time = j;
            }

            public final long getTime() {
                return this.time;
            }
        }

        /* compiled from: PlayerViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event$ShowMessage;", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-player_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowMessage extends Event {
            private final String message;

            public static /* synthetic */ ShowMessage copy$default(ShowMessage showMessage, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showMessage.message;
                }
                return showMessage.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final ShowMessage copy(String message) {
                return new ShowMessage(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowMessage) && Intrinsics.areEqual(this.message, ((ShowMessage) other).message);
            }

            public int hashCode() {
                String str = this.message;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ShowMessage(message=" + this.message + ")";
            }

            public ShowMessage(String str) {
                super(null);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    public final String getCameraLiveSource() {
        return this.cameraLiveSource;
    }

    public final String getDescription() {
        return this.description;
    }

    /* renamed from: isFlussonic, reason: from getter */
    public final boolean getIsFlussonic() {
        return this.isFlussonic;
    }

    public final String getIntercomLogin() {
        return this.intercomLogin;
    }

    public final MutableLiveData<String> getStreamUrl() {
        return this.streamUrl;
    }

    public final int getStreamArchiveService() {
        return this.streamArchiveService;
    }

    public final void setStreamArchiveService(int i) {
        this.streamArchiveService = i;
    }

    public final boolean getStreamDownloadService() {
        return this.streamDownloadService;
    }

    public final void setStreamDownloadService(boolean z) {
        this.streamDownloadService = z;
    }

    public final Flow<Boolean> getLockStatusIntercom() {
        return this.lockStatusIntercom;
    }

    public final String getToken() {
        return this.token;
    }

    public final MutableLiveData<PlayerState> getScreenState() {
        return this.screenState;
    }

    public final MutableLiveData<List<Date>> getDays() {
        return this.days;
    }

    public final MutableLiveData<Integer> getSelectedDay() {
        return this.selectedDay;
    }

    public final MutableLiveData<Boolean> isMicEnabled() {
        return this.isMicEnabled;
    }

    public final MutableLiveData<Boolean> isVideoZoomed() {
        return this.isVideoZoomed;
    }

    public final MutableLiveData<Boolean> isOpenDoorLoading() {
        return this.isOpenDoorLoading;
    }

    public final MutableLiveData<Integer> isOpenDoorError() {
        return this.isOpenDoorError;
    }

    public final MutableLiveData<Boolean> isStreamLoading() {
        return this.isStreamLoading;
    }

    public final MutableLiveData<Boolean> getStreamLoadError() {
        return this.streamLoadError;
    }

    public final MutableLiveData<Boolean> isBadConnBannerClosed() {
        return this.isBadConnBannerClosed;
    }

    public final StateFlow<Long> getStreamDurationInSeconds() {
        return this.streamDurationInSeconds;
    }

    public final StateFlow<Long> getStreamTimeInSeconds() {
        return this.streamTimeInSeconds;
    }

    public final StateFlow<Boolean> isStreamPaused() {
        return this.isStreamPaused;
    }

    public final StateFlow<Boolean> getPrepareProgressIsVisible() {
        return this.prepareProgressIsVisible;
    }

    public final SharedFlow<String> getDownloadUrl() {
        return this.downloadUrl;
    }

    public final MutableLiveData<Pair<Long, Integer>> getDownloadSettings() {
        return this.downloadSettings;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    public final Flow<Boolean> getEventShowErrorSnack() {
        return this.eventShowErrorSnack;
    }

    /* compiled from: PlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$2", f = "PlayerViewModel.kt", i = {}, l = {TarConstants.PREFIXLEN}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.player.PlayerViewModel$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayerViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<String> observeStreamUrl = PlayerViewModel.this.intercomInteractor.observeStreamUrl(PlayerViewModel.this.getIntercomLogin());
                final PlayerViewModel playerViewModel = PlayerViewModel.this;
                this.label = 1;
                if (observeStreamUrl.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.player.PlayerViewModel.2.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        PlayerViewModel.this.getStreamUrl().setValue(str);
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: PlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$5", f = "PlayerViewModel.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.player.PlayerViewModel$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass5(Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PlayerViewModel.this.new AnonymousClass5(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<List<DownloadDto>> videoDownloadsList = PlayerViewModel.this.userInteractor.getVideoDownloadsList();
                final PlayerViewModel playerViewModel = PlayerViewModel.this;
                this.label = 1;
                if (videoDownloadsList.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.player.PlayerViewModel.5.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<DownloadDto>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<DownloadDto> list, Continuation<? super Unit> continuation) {
                        if (list != null) {
                            PlayerViewModel.this._downloadList = list;
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkConnection(Context context) {
        try {
            if (ConnectionChecker.INSTANCE.checkConnection(context)) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$checkConnection$1(this, null), 3, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void onCallStateChanged(CallState state) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(state, CallState.Accepted.INSTANCE) && Intrinsics.areEqual(this.screenState.getValue(), PlayerState.IntercomArchive.INSTANCE)) {
            launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$onCallStateChanged$1(this, null), 3, null);
            this.endCallJob = launch$default;
        }
    }

    public final void onSipVideoLoaded(boolean isLoaded) {
        if (isLoaded) {
            this.streamUrl.setValue(null);
            this.isStreamLoading.setValue(false);
            this.streamLoadError.setValue(false);
        }
    }

    public final void onDayClick(int index) {
        long seconds;
        this.selectedDay.setValue(Integer.valueOf(index));
        this.isStreamLoading.setValue(true);
        this.streamLoadError.setValue(false);
        this._isStreamPaused.setValue(false);
        this._streamTimeInSeconds.setValue(0L);
        MutableStateFlow<Long> mutableStateFlow = this._streamDurationInSeconds;
        if (index != 6) {
            seconds = TimeUnit.HOURS.toSeconds(24L) - 1;
        } else {
            seconds = TimeUnit.MILLISECONDS.toSeconds(((Calendar.getInstance().getTimeInMillis() + r12.get(15)) + r12.get(16)) % TimeUnit.HOURS.toMillis(24L));
        }
        mutableStateFlow.setValue(Long.valueOf(seconds));
        PlayerState value = this.screenState.getValue();
        if (Intrinsics.areEqual(value, PlayerState.IntercomArchive.INSTANCE)) {
            provideIntercomStream$default(this, 86400L, null, 2, null);
        } else if (Intrinsics.areEqual(value, PlayerState.CameraArchive.INSTANCE)) {
            provideCameraStream$default(this, 0L, 1, null);
        }
    }

    static /* synthetic */ void provideIntercomStream$default(PlayerViewModel playerViewModel, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = playerViewModel.selectedDayInSeconds();
        }
        playerViewModel.provideIntercomStream(j, l);
    }

    private final void provideIntercomStream(long additionalTimeInSeconds, Long startTimeInSeconds) {
        String str;
        String value = this.streamUrl.getValue();
        String substringBeforeLast$default = value != null ? StringsKt.substringBeforeLast$default(value, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null) : null;
        String value2 = this.streamUrl.getValue();
        String substringAfterLast$default = value2 != null ? StringsKt.substringAfterLast$default(value2, "?", (String) null, 2, (Object) null) : null;
        if (startTimeInSeconds != null) {
            str = "archive-" + startTimeInSeconds + "-" + additionalTimeInSeconds + ".fmp4.m3u8?";
        } else {
            str = "mpegts?";
        }
        this.streamUrl.setValue(substringBeforeLast$default + RemoteSettings.FORWARD_SLASH_STRING + str + substringAfterLast$default);
    }

    static /* synthetic */ void provideCameraStream$default(PlayerViewModel playerViewModel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        playerViewModel.provideCameraStream(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void provideCameraStream(long additionalTimeInSeconds) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$provideCameraStream$1(this, additionalTimeInSeconds, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Long selectedDayInSeconds() {
        List<Date> value = this.days.getValue();
        Integer value2 = this.selectedDay.getValue();
        if (value == null || value2 == null || value2.intValue() == 7) {
            return null;
        }
        return Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(value.get(6 - value2.intValue()).getTime()));
    }

    public final void onOpenGateClick() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$onOpenGateClick$1(this, null), 3, null);
    }

    public final boolean isAdmin() {
        return this.userInteractor.isAdmin();
    }

    public final void onPinchToZoomGesture(boolean isZoomed) {
        this.isVideoZoomed.setValue(Boolean.valueOf(isZoomed));
    }

    public final void onEndCall() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$onEndCall$1(this, null), 3, null);
    }

    public final void onMicClick() {
        this.isMicEnabled.setValue(this.isMicEnabled.getValue() == null ? true : Boolean.valueOf(!r0.booleanValue()));
    }

    public final void onStreamLoading(boolean isLoading) {
        Job launch$default;
        this.isStreamLoading.setValue(Boolean.valueOf(isLoading));
        if (Intrinsics.areEqual(this.screenState.getValue(), PlayerState.IntercomArchive.INSTANCE) || Intrinsics.areEqual(this.screenState.getValue(), PlayerState.CallArchive.INSTANCE) || (Intrinsics.areEqual(this.screenState.getValue(), PlayerState.CameraArchive.INSTANCE) && this.isFlussonic)) {
            if (!isLoading) {
                launch$default = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$onStreamLoading$1(this, null), 3, null);
                this.refreshPlayerTimeJob = launch$default;
            } else {
                Job job = this.refreshPlayerTimeJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
            }
        }
    }

    public final void onStreamError() {
        this.isStreamLoading.setValue(false);
        this.streamLoadError.setValue(true);
    }

    public final void onStreamTimeReceived(Long timeInMillis) {
        Integer value = this.selectedDay.getValue();
        if ((value != null && value.intValue() == 7) || timeInMillis == null) {
            return;
        }
        this._streamTimeInSeconds.setValue(Long.valueOf(timeInMillis.longValue() / 1000));
    }

    public final void onStreamRefresh() {
        MutableLiveData<String> mutableLiveData = this.streamUrl;
        mutableLiveData.setValue(mutableLiveData.getValue());
        this.streamLoadError.setValue(false);
    }

    public final void onStreamPause() {
        this._isStreamPaused.setValue(true);
    }

    public final void onStreamPauseResume() {
        this._isStreamPaused.setValue(Boolean.valueOf(!this.isStreamPaused.getValue().booleanValue()));
    }

    public final void onArchiveTimeSelected(long timeInSeconds) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$onArchiveTimeSelected$1(this, timeInSeconds, null), 3, null);
    }

    public final void setDownloadVideoOptions(long startTime, int duration) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$setDownloadVideoOptions$1(this, startTime, duration, null), 3, null);
    }

    public final void addDownload(DownloadDto model) {
        Intrinsics.checkNotNullParameter(model, "model");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$addDownload$1(this, model, null), 3, null);
    }

    public final void removeDownload(DownloadDto model) {
        Intrinsics.checkNotNullParameter(model, "model");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new PlayerViewModel$removeDownload$1(this, model, null), 3, null);
    }

    public static /* synthetic */ Object getDownload$default(PlayerViewModel playerViewModel, long j, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return playerViewModel.getDownload(j, str, continuation);
    }

    public final Object getDownload(long j, String str, Continuation<? super DownloadDto> continuation) {
        return this.userInteractor.getDownload(j, str, continuation);
    }

    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }
}
