package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.domain.contracts.PlayerUserInteractor;
import ru.tattelecom.intercom.domain.interactors.StreamInteractor;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.ScreenState;

/* compiled from: DownloadViewModel.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u0000 k2\u00020\u0001:\u0002klB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u000bJ\u000e\u0010M\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0013J\u000e\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u0018J&\u0010Q\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010R\u001a\u00020S2\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010TJW\u0010U\u001a\u00020K2\b\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010G\u001a\u00020V2\u0006\u0010D\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020S2\u0006\u0010X\u001a\u00020Y2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010[J\u000e\u0010\\\u001a\u00020K2\u0006\u0010]\u001a\u00020\u000bJ\u000e\u0010^\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0015J\u000e\u0010`\u001a\u00020K2\u0006\u0010_\u001a\u00020\u0015J\u000e\u0010a\u001a\u00020K2\u0006\u0010P\u001a\u00020\u0018J\u000e\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020\u0010J\u0016\u0010d\u001a\u00020K2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00180\u001bH\u0002J(\u0010f\u001a\u00020K2\u0006\u0010g\u001a\u00020S2\u0006\u0010h\u001a\u00020\u00152\u0006\u0010i\u001a\u00020Y2\b\u0010j\u001a\u0004\u0018\u00010\u000eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u001b0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100#¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R \u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010.R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010(\"\u0004\b1\u0010.R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130\u001a¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001dR \u00104\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010.R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001dR\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00150\u001a¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001dR\u0019\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010?\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010D\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010A\"\u0004\bI\u0010C¨\u0006m"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel;", "Landroidx/lifecycle/ViewModel;", "userInteractor", "Lru/tattelecom/intercom/domain/contracts/PlayerUserInteractor;", "streamInteractor", "Lru/tattelecom/intercom/domain/interactors/StreamInteractor;", "savedState", "Landroidx/lifecycle/SavedStateHandle;", "(Lru/tattelecom/intercom/domain/contracts/PlayerUserInteractor;Lru/tattelecom/intercom/domain/interactors/StreamInteractor;Landroidx/lifecycle/SavedStateHandle;)V", "_downloadList", "", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "_downloadUrl", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "_events", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "_screenState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/ScreenState;", "_selectedDayId", "", "_selectedDurationId", "_selectedStartTime", "Ljava/util/Date;", "archiveDayNames", "Lkotlinx/coroutines/flow/StateFlow;", "", "getArchiveDayNames", "()Lkotlinx/coroutines/flow/StateFlow;", DownloadViewModel.ARCHIVE_DAYS, "getArchiveDays", "dateFormatter", "Ljava/text/SimpleDateFormat;", "downloadUrl", "Lkotlinx/coroutines/flow/SharedFlow;", "getDownloadUrl", "()Lkotlinx/coroutines/flow/SharedFlow;", "durationlist", "getDurationlist", "()Ljava/util/List;", "events", "getEvents", "hoursList", "getHoursList", "setHoursList", "(Ljava/util/List;)V", "minutesList", "getMinutesList", "setMinutesList", "screenState", "getScreenState", "secondsList", "getSecondsList", "setSecondsList", VideoPlayerViewModel.SELECTED_DAY_ID, "getSelectedDayId", "selectedDurationId", "getSelectedDurationId", "selectedStartTime", "getSelectedStartTime", VideoPlayerViewModel.STREAM_URL, "timeFormatter", PushNotificationArg.TECH_LOG_TOKEN, "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "urlDescription", "getUrlDescription", "setUrlDescription", "videoType", "getVideoType", "setVideoType", "addDownload", "", "downloadDto", "changeState", "state", "convertTimeToPattern", CrashHianalyticsData.TIME, "getDownload", "downloadId", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openDownloadDialog", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel$VideoType;", "currentTime", VideoPlayerViewModel.IS_LIVE, "", "days", "(Ljava/lang/String;Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel$VideoType;Ljava/lang/String;Ljava/lang/String;JZLjava/util/List;Ljava/lang/Integer;)V", "removeDownload", "model", "selectDayId", TtmlNode.ATTR_ID, "selectDurationId", "selectStartTime", "sendEvent", NotificationCompat.CATEGORY_EVENT, "setArchiveDays", SelectItemDialog.ARG_LIST, "setDownloadVideoOptions", "startTime", "duration", "isAxxon", "cameraArchiveExportSource", "Companion", "VideoType", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DownloadViewModel extends ViewModel {
    private static final String ARCHIVE_DAYS = "archiveDays";
    private List<DownloadDto> _downloadList;
    private final MutableSharedFlow<String> _downloadUrl;
    private final MutableSharedFlow<DownloadEvent> _events;
    private final MutableStateFlow<ScreenState> _screenState;
    private final MutableStateFlow<Integer> _selectedDayId;
    private final MutableStateFlow<Integer> _selectedDurationId;
    private final MutableStateFlow<Date> _selectedStartTime;
    private final StateFlow<List<String>> archiveDayNames;
    private final StateFlow<List<Date>> archiveDays;
    private final SimpleDateFormat dateFormatter;
    private final SharedFlow<String> downloadUrl;
    private final List<String> durationlist;
    private final SharedFlow<DownloadEvent> events;
    private List<String> hoursList;
    private List<String> minutesList;
    private final SavedStateHandle savedState;
    private final StateFlow<ScreenState> screenState;
    private List<String> secondsList;
    private final StateFlow<Integer> selectedDayId;
    private final StateFlow<Integer> selectedDurationId;
    private final StateFlow<Date> selectedStartTime;
    private final StreamInteractor streamInteractor;
    private String streamUrl;
    private final SimpleDateFormat timeFormatter;
    private String token;
    private String urlDescription;
    private final PlayerUserInteractor userInteractor;
    private String videoType;

    public DownloadViewModel(PlayerUserInteractor userInteractor, StreamInteractor streamInteractor, SavedStateHandle savedState) {
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(streamInteractor, "streamInteractor");
        Intrinsics.checkNotNullParameter(savedState, "savedState");
        this.userInteractor = userInteractor;
        this.streamInteractor = streamInteractor;
        this.savedState = savedState;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", new Locale("RU", "ru"));
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC+3"));
        this.timeFormatter = simpleDateFormat;
        this.dateFormatter = new SimpleDateFormat("EE, d MMM", new Locale("RU"));
        StateFlow<List<Date>> stateFlow = savedState.getStateFlow(ARCHIVE_DAYS, CollectionsKt.emptyList());
        this.archiveDays = stateFlow;
        MutableStateFlow<ScreenState> MutableStateFlow = StateFlowKt.MutableStateFlow(ScreenState.VideoDownloadSettings.INSTANCE);
        this._screenState = MutableStateFlow;
        this.screenState = FlowKt.asStateFlow(MutableStateFlow);
        MutableSharedFlow<DownloadEvent> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._events = MutableSharedFlow$default;
        this.events = FlowKt.asSharedFlow(MutableSharedFlow$default);
        final StateFlow<List<Date>> stateFlow2 = stateFlow;
        this.archiveDayNames = FlowKt.stateIn(new Flow<List<? extends String>>() { // from class: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ DownloadViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1$2", f = "DownloadViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(FlowCollector flowCollector, DownloadViewModel downloadViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = downloadViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r13, kotlin.coroutines.Continuation r14) {
                    /*
                        r12 = this;
                        boolean r0 = r14 instanceof ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r14
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r14 = r0.label
                        int r14 = r14 - r2
                        r0.label = r14
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r14)
                    L19:
                        java.lang.Object r14 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L33
                        if (r2 != r3) goto L2b
                        kotlin.ResultKt.throwOnFailure(r14)
                        goto Le2
                    L2b:
                        java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                        java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                        r13.<init>(r14)
                        throw r13
                    L33:
                        kotlin.ResultKt.throwOnFailure(r14)
                        kotlinx.coroutines.flow.FlowCollector r14 = r12.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r13 = (java.util.List) r13
                        r2 = r13
                        java.lang.Iterable r2 = (java.lang.Iterable) r2
                        java.util.ArrayList r4 = new java.util.ArrayList
                        r5 = 10
                        int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r5)
                        r4.<init>(r5)
                        java.util.Collection r4 = (java.util.Collection) r4
                        java.util.Iterator r2 = r2.iterator()
                        r5 = 0
                        r6 = r5
                    L53:
                        boolean r7 = r2.hasNext()
                        if (r7 == 0) goto Ld7
                        java.lang.Object r7 = r2.next()
                        int r8 = r6 + 1
                        if (r6 >= 0) goto L64
                        kotlin.collections.CollectionsKt.throwIndexOverflow()
                    L64:
                        java.util.Date r7 = (java.util.Date) r7
                        int r9 = r13.size()
                        int r9 = r9 - r3
                        java.lang.String r10 = "."
                        java.lang.String r11 = "format(...)"
                        if (r6 != r9) goto L93
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r6 = r12.this$0
                        java.text.SimpleDateFormat r6 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel.access$getDateFormatter$p(r6)
                        java.lang.String r6 = r6.format(r7)
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
                        java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                        java.lang.String r6 = kotlin.text.StringsKt.removeSuffix(r6, r10)
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder
                        java.lang.String r9 = "Сегодня, "
                        r7.<init>(r9)
                        r7.append(r6)
                        java.lang.String r6 = r7.toString()
                        goto Ld1
                    L93:
                        ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel r6 = r12.this$0
                        java.text.SimpleDateFormat r6 = ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel.access$getDateFormatter$p(r6)
                        java.lang.String r6 = r6.format(r7)
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r11)
                        r7 = r6
                        java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                        int r7 = r7.length()
                        if (r7 <= 0) goto Lcb
                        char r7 = r6.charAt(r5)
                        char r7 = (char) r7
                        char r7 = java.lang.Character.toUpperCase(r7)
                        java.lang.String r6 = r6.substring(r3)
                        java.lang.String r9 = "substring(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)
                        java.lang.StringBuilder r9 = new java.lang.StringBuilder
                        r9.<init>()
                        char r7 = (char) r7
                        r9.append(r7)
                        r9.append(r6)
                        java.lang.String r6 = r9.toString()
                    Lcb:
                        java.lang.CharSequence r10 = (java.lang.CharSequence) r10
                        java.lang.String r6 = kotlin.text.StringsKt.removeSuffix(r6, r10)
                    Ld1:
                        r4.add(r6)
                        r6 = r8
                        goto L53
                    Ld7:
                        java.util.List r4 = (java.util.List) r4
                        r0.label = r3
                        java.lang.Object r13 = r14.emit(r4, r0)
                        if (r13 != r1) goto Le2
                        return r1
                    Le2:
                        kotlin.Unit r13 = kotlin.Unit.INSTANCE
                        return r13
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends String>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(this), SharingStarted.INSTANCE.getEagerly(), CollectionsKt.emptyList());
        this.hoursList = CollectionsKt.emptyList();
        this.minutesList = CollectionsKt.emptyList();
        this.secondsList = CollectionsKt.emptyList();
        this._downloadList = new ArrayList();
        this.durationlist = CollectionsKt.listOf((Object[]) new String[]{"1 минута", "2 минуты", "3 минуты", "4 минуты", "5 минут", "6 минут", "7 минут", "8 минут", "9 минут", "10 минут"});
        MutableSharedFlow<String> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._downloadUrl = MutableSharedFlow$default2;
        this.downloadUrl = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        MutableStateFlow<Integer> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0);
        this._selectedDayId = MutableStateFlow2;
        this.selectedDayId = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Date> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._selectedStartTime = MutableStateFlow3;
        this.selectedStartTime = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<Integer> MutableStateFlow4 = StateFlowKt.MutableStateFlow(0);
        this._selectedDurationId = MutableStateFlow4;
        this.selectedDurationId = FlowKt.asStateFlow(MutableStateFlow4);
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public final void setVideoType(String str) {
        this.videoType = str;
    }

    public final String getUrlDescription() {
        return this.urlDescription;
    }

    public final void setUrlDescription(String str) {
        this.urlDescription = str;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final StateFlow<List<Date>> getArchiveDays() {
        return this.archiveDays;
    }

    private final void setArchiveDays(List<? extends Date> list) {
        this.savedState.set(ARCHIVE_DAYS, list);
    }

    public final StateFlow<ScreenState> getScreenState() {
        return this.screenState;
    }

    public final SharedFlow<DownloadEvent> getEvents() {
        return this.events;
    }

    public final void changeState(ScreenState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        MutableStateFlow<ScreenState> mutableStateFlow = this._screenState;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), state)) {
        }
    }

    public final void sendEvent(DownloadEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DownloadViewModel$sendEvent$1(this, event, null), 3, null);
    }

    public final StateFlow<List<String>> getArchiveDayNames() {
        return this.archiveDayNames;
    }

    public final List<String> getHoursList() {
        return this.hoursList;
    }

    public final void setHoursList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.hoursList = list;
    }

    public final List<String> getMinutesList() {
        return this.minutesList;
    }

    public final void setMinutesList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.minutesList = list;
    }

    public final List<String> getSecondsList() {
        return this.secondsList;
    }

    public final void setSecondsList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.secondsList = list;
    }

    public final List<String> getDurationlist() {
        return this.durationlist;
    }

    public final String convertTimeToPattern(Date time) {
        Intrinsics.checkNotNullParameter(time, "time");
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC+3"));
        calendar.setTimeInMillis(time.getTime());
        String format = this.timeFormatter.format(calendar.getTime());
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: DownloadViewModel.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadViewModel$VideoType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "Camera", "Intercom", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class VideoType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ VideoType[] $VALUES;
        public static final VideoType Camera = new VideoType("Camera", 0, "camera");
        public static final VideoType Intercom = new VideoType("Intercom", 1, "intercom");
        private final String type;

        private static final /* synthetic */ VideoType[] $values() {
            return new VideoType[]{Camera, Intercom};
        }

        public static EnumEntries<VideoType> getEntries() {
            return $ENTRIES;
        }

        public static VideoType valueOf(String str) {
            return (VideoType) Enum.valueOf(VideoType.class, str);
        }

        public static VideoType[] values() {
            return (VideoType[]) $VALUES.clone();
        }

        private VideoType(String str, int i, String str2) {
            this.type = str2;
        }

        public final String getType() {
            return this.type;
        }

        static {
            VideoType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public final SharedFlow<String> getDownloadUrl() {
        return this.downloadUrl;
    }

    public final StateFlow<Integer> getSelectedDayId() {
        return this.selectedDayId;
    }

    public final void selectDayId(int id) {
        Integer value;
        MutableStateFlow<Integer> mutableStateFlow = this._selectedDayId;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(id)));
    }

    public final void openDownloadDialog(String streamUrl, VideoType videoType, String urlDescription, String token, long currentTime, boolean isLive, List<? extends Date> days, Integer selectedDayId) {
        Integer value;
        Intrinsics.checkNotNullParameter(videoType, "videoType");
        Intrinsics.checkNotNullParameter(urlDescription, "urlDescription");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(days, "days");
        this.streamUrl = streamUrl;
        this.videoType = videoType.getType();
        this.urlDescription = urlDescription;
        this.token = token;
        setArchiveDays(days);
        int intValue = ((selectedDayId != null && selectedDayId.intValue() == -1) || selectedDayId == null) ? 6 : selectedDayId.intValue();
        MutableStateFlow<Integer> mutableStateFlow = this._selectedDayId;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(intValue)));
        selectStartTime(!isLive ? new Date(currentTime - days.get(intValue).getTime()) : new Date(0L));
    }

    public final StateFlow<Date> getSelectedStartTime() {
        return this.selectedStartTime;
    }

    public final void selectStartTime(Date time) {
        Intrinsics.checkNotNullParameter(time, "time");
        MutableStateFlow<Date> mutableStateFlow = this._selectedStartTime;
        while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), time)) {
        }
    }

    public final StateFlow<Integer> getSelectedDurationId() {
        return this.selectedDurationId;
    }

    public final void selectDurationId(int id) {
        Integer value;
        MutableStateFlow<Integer> mutableStateFlow = this._selectedDurationId;
        do {
            value = mutableStateFlow.getValue();
            value.intValue();
        } while (!mutableStateFlow.compareAndSet(value, Integer.valueOf(id)));
    }

    public final void setDownloadVideoOptions(long startTime, int duration, boolean isAxxon, String cameraArchiveExportSource) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DownloadViewModel$setDownloadVideoOptions$1(this, isAxxon, startTime, cameraArchiveExportSource, duration, null), 3, null);
    }

    public final void addDownload(DownloadDto downloadDto) {
        Intrinsics.checkNotNullParameter(downloadDto, "downloadDto");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DownloadViewModel$addDownload$1(this, downloadDto, null), 3, null);
    }

    public static /* synthetic */ Object getDownload$default(DownloadViewModel downloadViewModel, long j, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return downloadViewModel.getDownload(j, str, continuation);
    }

    public final Object getDownload(long j, String str, Continuation<? super DownloadDto> continuation) {
        return this.userInteractor.getDownload(j, str, continuation);
    }

    public final void removeDownload(DownloadDto model) {
        Intrinsics.checkNotNullParameter(model, "model");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new DownloadViewModel$removeDownload$1(this, model, null), 3, null);
    }
}
