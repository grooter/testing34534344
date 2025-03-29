package ru.tattelecom.intercom.domain.interactors;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.local.dao.DownloadDAO;
import ru.tattelecom.intercom.data.local.entity.DownloadEntity;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse;
import ru.tattelecom.intercom.data.remote.source.AuthRemote;
import ru.tattelecom.intercom.data.remote.source.ConfigRemote;
import ru.tattelecom.intercom.data.remote.source.LeadRemote;
import ru.tattelecom.intercom.data.remote.source.StreamRemote;
import ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: UserInteractor.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u001c\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0096@¢\u0006\u0002\u0010/J\u0016\u0010*\u001a\u00020+2\u0006\u00100\u001a\u00020.H\u0096@¢\u0006\u0002\u00101J(\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u00107J\u001c\u00102\u001a\u0004\u0018\u00010+2\n\b\u0002\u00108\u001a\u0004\u0018\u00010#H\u0086@¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020+J\u0016\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020.H\u0096@¢\u0006\u0002\u00101J\u000e\u0010=\u001a\u00020+H\u0086@¢\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u0017H\u0016J\"\u0010@\u001a\u0004\u0018\u00010.2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u0010DJ\u0006\u0010E\u001a\u00020BJ$\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010#2\b\u0010I\u001a\u0004\u0018\u00010BH\u0086@¢\u0006\u0002\u0010JJ\u0006\u0010K\u001a\u00020\u0017J\u000e\u0010L\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010>J\b\u0010M\u001a\u0004\u0018\u00010#J\b\u0010N\u001a\u0004\u0018\u00010#J\b\u0010O\u001a\u00020#H\u0016J\u0014\u0010P\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020.\u0018\u00010Q0 J\u0006\u0010R\u001a\u00020\u0017JF\u0010S\u001a\u0004\u0018\u00010T2\u0006\u0010U\u001a\u00020#2\u0006\u0010V\u001a\u00020#2\f\u0010W\u001a\b\u0012\u0004\u0012\u0002050-2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010BH\u0086@¢\u0006\u0002\u0010XJ\u0006\u0010Y\u001a\u00020+J(\u0010Z\u001a\u00020+2\u0006\u00103\u001a\u00020\u00172\u0006\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010#H\u0096@¢\u0006\u0002\u00107J\u001c\u0010Z\u001a\u0004\u0018\u00010+2\n\b\u0002\u00108\u001a\u0004\u0018\u00010#H\u0086@¢\u0006\u0002\u00109JN\u0010[\u001a\u00020+2\u0006\u0010\\\u001a\u00020#2\u0006\u0010]\u001a\u00020#2\u0006\u0010^\u001a\u00020#2\u0006\u0010_\u001a\u00020#2\u0006\u0010`\u001a\u00020#2\u0006\u0010a\u001a\u00020#2\u0006\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u00020#H\u0086@¢\u0006\u0002\u0010dJ\u0006\u0010e\u001a\u00020+J\u0010\u0010f\u001a\u00020+2\u0006\u0010g\u001a\u00020\u0017H\u0016J\u000e\u0010h\u001a\u00020+2\u0006\u0010i\u001a\u00020BJ\u0010\u0010j\u001a\u00020+2\b\u0010k\u001a\u0004\u0018\u00010#J\u0010\u0010l\u001a\u00020+2\b\u0010m\u001a\u0004\u0018\u00010#J\u0016\u0010n\u001a\u00020T2\u0006\u0010o\u001a\u00020#H\u0086@¢\u0006\u0002\u00109R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0018R$\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00170 ¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u0016¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0018R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010#2\b\u0010\u0019\u001a\u0004\u0018\u00010#8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006p"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "Lru/tattelecom/intercom/domain/contracts/PlayerUserInteractor;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "remote", "Lru/tattelecom/intercom/data/remote/source/LeadRemote;", "database", "Lru/tattelecom/intercom/data/local/IntercomDatabase;", "downloadDAO", "Lru/tattelecom/intercom/data/local/dao/DownloadDAO;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "streamRemote", "Lru/tattelecom/intercom/data/remote/source/StreamRemote;", "authRemote", "Lru/tattelecom/intercom/data/remote/source/AuthRemote;", "gateInteractor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "configRemote", "Lru/tattelecom/intercom/data/remote/source/ConfigRemote;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/remote/source/LeadRemote;Lru/tattelecom/intercom/data/local/IntercomDatabase;Lru/tattelecom/intercom/data/local/dao/DownloadDAO;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;Lru/tattelecom/intercom/data/remote/source/StreamRemote;Lru/tattelecom/intercom/data/remote/source/AuthRemote;Lru/tattelecom/intercom/domain/interactors/GateInteractor;Lru/tattelecom/intercom/data/remote/source/ConfigRemote;)V", "isSessionActive", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "value", "isWelcomeScreenShown", "()Z", "setWelcomeScreenShown", "(Z)V", "isWorkInBackgroundEnabled", "isWorkInForegroundEnabled", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "selectedRingtonePath", "", "getSelectedRingtonePath", PushNotificationArg.TECH_LOG_TOKEN, "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "addDownload", "", VideoPlayerViewModel.DOWNLOAD_LIST, "", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download", "(Lru/tattelecom/intercom/domain/model/DownloadDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addStreamToFavorites", "isIntercom", TtmlNode.ATTR_ID, "", "stream", "(ZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", VideoPlayerViewModel.STREAM_URL, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearUserConfig", "deleteDownload", "model", "fetchUserConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDoubleTapHintShownState", "getDownload", "downloadId", "", "urlDescription", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastInAppReviewTimeStamp", "getLeaveOrderServicesList", "Lru/tattelecom/intercom/data/remote/model/responses/LeaveOrderServicesResponse;", "entityScreen", NavArg.ENTITY_ID, "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNotificationPermissionRequestStatus", "getPhotoList", "getRingtone", "getUserState", "getUserToken", "getVideoDownloadsList", "", "isAdmin", "leaveOrder", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "name", "phone", "services", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notificationPermissionRequested", "removeStreamFromFavorites", "sendApplicationVersion", "appVersionName", "appVersionCode", "deviceOsVersion", "deviceApiVersion", "providerName", "deviceName", "connectionType", "batteryLevel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultRingtone", "setDoubleTapHintShownState", "isShown", "setLastInAppReviewTimeStamp", "timeStamp", "setRingtone", "path", "setUserState", "isNewUser", "uploadFaceDetectionPhoto", "photoPath", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserInteractor implements PlayerUserInteractor {
    private final AuthRemote authRemote;
    private final ConfigRemote configRemote;
    private final IntercomDatabase database;
    private final AppCoroutineDispatchers dispatchers;
    private final DownloadDAO downloadDAO;
    private final GateInteractor gateInteractor;
    private final MutableStateFlow<Boolean> isSessionActive;
    private final MutableStateFlow<Boolean> isWorkInBackgroundEnabled;
    private final Flow<Boolean> isWorkInForegroundEnabled;
    private final UserPrefsSource prefs;
    private final LeadRemote remote;
    private final MutableStateFlow<String> selectedRingtonePath;
    private final StreamRemote streamRemote;

    public UserInteractor(UserPrefsSource prefs, LeadRemote remote, IntercomDatabase database, DownloadDAO downloadDAO, AppCoroutineDispatchers dispatchers, StreamRemote streamRemote, AuthRemote authRemote, GateInteractor gateInteractor, ConfigRemote configRemote) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(downloadDAO, "downloadDAO");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(streamRemote, "streamRemote");
        Intrinsics.checkNotNullParameter(authRemote, "authRemote");
        Intrinsics.checkNotNullParameter(gateInteractor, "gateInteractor");
        Intrinsics.checkNotNullParameter(configRemote, "configRemote");
        this.prefs = prefs;
        this.remote = remote;
        this.database = database;
        this.downloadDAO = downloadDAO;
        this.dispatchers = dispatchers;
        this.streamRemote = streamRemote;
        this.authRemote = authRemote;
        this.gateInteractor = gateInteractor;
        this.configRemote = configRemote;
        MutableStateFlow<Boolean> isSessionActive = prefs.isSessionActive();
        this.isSessionActive = isSessionActive;
        this.selectedRingtonePath = prefs.getSelectedRingtonePath();
        this.isWorkInBackgroundEnabled = prefs.isWorkInBackgroundEnabled();
        this.isWorkInForegroundEnabled = FlowKt.flowCombine(isSessionActive, prefs.isWorkInBackgroundEnabled(), new UserInteractor$isWorkInForegroundEnabled$1(null));
    }

    public final MutableStateFlow<Boolean> isSessionActive() {
        return this.isSessionActive;
    }

    public final MutableStateFlow<String> getSelectedRingtonePath() {
        return this.selectedRingtonePath;
    }

    public final MutableStateFlow<Boolean> isWorkInBackgroundEnabled() {
        return this.isWorkInBackgroundEnabled;
    }

    public final String getToken() {
        return this.prefs.getToken();
    }

    public final void setToken(String str) {
        this.prefs.setToken(str);
    }

    public final Flow<Boolean> isWorkInForegroundEnabled() {
        return this.isWorkInForegroundEnabled;
    }

    public final void setRingtone(String path) {
        if (path != null) {
            this.prefs.setRingtonePath(path);
        }
    }

    public final String getRingtone() {
        return this.prefs.getRingtonePath();
    }

    public final void setDefaultRingtone() {
        this.prefs.setDefaultRingtone();
    }

    public final long getLastInAppReviewTimeStamp() {
        return this.prefs.getLastInAppReviewTimeStamp();
    }

    public final void setLastInAppReviewTimeStamp(long timeStamp) {
        this.prefs.setLastInAppReviewTimeStamp(timeStamp);
    }

    public final void setUserState(String isNewUser) {
        this.prefs.setNewUser(isNewUser);
    }

    public final String getUserState() {
        return this.prefs.isNewUser();
    }

    public final boolean isAdmin() {
        return this.prefs.isAdmin();
    }

    public final boolean isWelcomeScreenShown() {
        return this.prefs.isWelcomeScreenShown();
    }

    public final void setWelcomeScreenShown(boolean z) {
        this.prefs.setWelcomeScreenShown(z);
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public Object addDownload(List<DownloadDto> list, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new UserInteractor$addDownload$2(this, list, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public Object addDownload(DownloadDto downloadDto, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new UserInteractor$addDownload$4(this, downloadDto, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public Object deleteDownload(DownloadDto downloadDto, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new UserInteractor$deleteDownload$2(this, downloadDto, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public Object getDownload(long j, String str, Continuation<? super DownloadDto> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new UserInteractor$getDownload$2(str, this, j, null), continuation);
    }

    public final Flow<List<DownloadDto>> getVideoDownloadsList() {
        final Flow<List<DownloadEntity>> observeAll = this.downloadDAO.observeAll();
        return new Flow<List<DownloadDto>>() { // from class: ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1$2", f = "UserInteractor.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r11
                        ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r11 = r0.label
                        int r11 = r11 - r2
                        r0.label = r11
                        goto L19
                    L14:
                        ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1$2$1
                        r0.<init>(r11)
                    L19:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L85
                    L2a:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L32:
                        kotlin.ResultKt.throwOnFailure(r11)
                        kotlinx.coroutines.flow.FlowCollector r11 = r9.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r10 = (java.util.List) r10
                        if (r10 == 0) goto L7b
                        java.lang.Iterable r10 = (java.lang.Iterable) r10
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r4)
                        r2.<init>(r4)
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.Iterator r10 = r10.iterator()
                    L51:
                        boolean r4 = r10.hasNext()
                        if (r4 == 0) goto L72
                        java.lang.Object r4 = r10.next()
                        ru.tattelecom.intercom.data.local.entity.DownloadEntity r4 = (ru.tattelecom.intercom.data.local.entity.DownloadEntity) r4
                        long r5 = r4.getDownloadId()
                        java.lang.String r7 = r4.getUrlDescription()
                        boolean r4 = r4.isIntercomStream()
                        ru.tattelecom.intercom.domain.model.DownloadDto r8 = new ru.tattelecom.intercom.domain.model.DownloadDto
                        r8.<init>(r7, r5, r4)
                        r2.add(r8)
                        goto L51
                    L72:
                        java.util.List r2 = (java.util.List) r2
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.List r10 = kotlin.collections.CollectionsKt.toMutableList(r2)
                        goto L7c
                    L7b:
                        r10 = 0
                    L7c:
                        r0.label = r3
                        java.lang.Object r10 = r11.emit(r10, r0)
                        if (r10 != r1) goto L85
                        return r1
                    L85:
                        kotlin.Unit r10 = kotlin.Unit.INSTANCE
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.UserInteractor$getVideoDownloadsList$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<DownloadDto>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public final Object getLeaveOrderServicesList(String str, Long l, Continuation<? super LeaveOrderServicesResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$getLeaveOrderServicesList$2(this, str, l, null), continuation);
    }

    public final Object leaveOrder(String str, String str2, List<Integer> list, String str3, Long l, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$leaveOrder$2(this, str2, str, list, str3, l, null), continuation);
    }

    public final Object getPhotoList(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new UserInteractor$getPhotoList$2(null), continuation);
    }

    public final Object uploadFaceDetectionPhoto(String str, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$uploadFaceDetectionPhoto$2(str, this, null), continuation);
    }

    public static /* synthetic */ Object addStreamToFavorites$default(UserInteractor userInteractor, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return userInteractor.addStreamToFavorites(str, continuation);
    }

    public final Object addStreamToFavorites(String str, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$addStreamToFavorites$2(str, this, null), continuation);
    }

    public static /* synthetic */ Object removeStreamFromFavorites$default(UserInteractor userInteractor, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return userInteractor.removeStreamFromFavorites(str, continuation);
    }

    public final Object removeStreamFromFavorites(String str, Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$removeStreamFromFavorites$2(str, this, null), continuation);
    }

    public final boolean getNotificationPermissionRequestStatus() {
        return this.prefs.getNotificationPermissionRequestStatus();
    }

    public final void notificationPermissionRequested() {
        this.prefs.setNotificationPermissionRequestStatus(true);
    }

    public final Object sendApplicationVersion(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$sendApplicationVersion$2(this, str, str2, str3, str4, str5, str6, str7, str8, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public Object addStreamToFavorites(boolean z, int i, String str, Continuation<? super Unit> continuation) {
        if (z) {
            Object addToFavorites = this.gateInteractor.addToFavorites(i, continuation);
            return addToFavorites == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addToFavorites : Unit.INSTANCE;
        }
        return addStreamToFavorites(str, continuation);
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public Object removeStreamFromFavorites(boolean z, int i, String str, Continuation<? super Unit> continuation) {
        if (z) {
            Object removeFromFavorites = this.gateInteractor.removeFromFavorites(i, continuation);
            return removeFromFavorites == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? removeFromFavorites : Unit.INSTANCE;
        }
        return removeStreamFromFavorites(str, continuation);
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public String getUserToken() {
        String token = this.prefs.getToken();
        return token == null ? "" : token;
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public boolean getDoubleTapHintShownState() {
        return this.prefs.getDoubleTapHintShown();
    }

    @Override // ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor
    public void setDoubleTapHintShownState(boolean isShown) {
        this.prefs.setDoubleTapHintShown(isShown);
    }

    public final Object fetchUserConfig(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new UserInteractor$fetchUserConfig$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void clearUserConfig() {
        this.prefs.setUserConfig(null);
    }
}
