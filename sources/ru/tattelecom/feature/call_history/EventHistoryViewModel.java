package ru.tattelecom.feature.call_history;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.paging.CachedPagingDataKt;
import androidx.paging.PagingData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.feature.call_history.UiAction;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.data.remote.source.paging.DataLoadType;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryBanner;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;
import ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: EventHistoryViewModel.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010>\u001a\u000203J\u0006\u0010?\u001a\u00020\u0019J\u000e\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020BJ\u000e\u0010C\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0014J\u000e\u0010D\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0014J\u001e\u0010E\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u00142\u0006\u0010F\u001a\u000203H\u0086@¢\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u000eJ\u000e\u0010J\u001a\u00020\u00192\u0006\u0010A\u001a\u00020\u0014J$\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0014080!2\u0006\u0010L\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0002R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R)\u0010$\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00100!¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0!¢\u0006\b\n\u0000\u001a\u0004\b'\u0010#R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140!¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0!¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00104\"\u0004\b5\u00106R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0014080!¢\u0006\b\n\u0000\u001a\u0004\b9\u0010#R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u001d¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u001fR\u0010\u0010=\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lru/tattelecom/feature/call_history/EventHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "eventHistoryInteractor", "Lru/tattelecom/intercom/domain/interactors/EventHistoryInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "(Lru/tattelecom/intercom/domain/interactors/EventHistoryInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/domain/interactors/UserInteractor;)V", "_callImage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_eventNavigateToConnectService", "Lkotlinx/coroutines/channels/Channel;", "", "_eventOpenVideo", "Lkotlin/Triple;", "", "_eventShowMessage", "_eventShowRemoveDialog", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "_eventShowSnack", "accept", "Lkotlin/Function1;", "Lru/tattelecom/feature/call_history/UiAction;", "", "getAccept", "()Lkotlin/jvm/functions/Function1;", "callImage", "Lkotlinx/coroutines/flow/StateFlow;", "getCallImage", "()Lkotlinx/coroutines/flow/StateFlow;", "eventNavigateToConnectService", "Lkotlinx/coroutines/flow/Flow;", "getEventNavigateToConnectService", "()Lkotlinx/coroutines/flow/Flow;", "eventOpenVideo", "getEventOpenVideo", "eventShowMessage", "getEventShowMessage", "eventShowRemoveDialog", "getEventShowRemoveDialog", "eventShowSnack", "getEventShowSnack", "filterEventType", "Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "getFilterEventType", "()Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "setFilterEventType", "(Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;)V", "isBannerClosed", "", "()Z", "setBannerClosed", "(Z)V", "pagingDataFlow", "Landroidx/paging/PagingData;", "getPagingDataFlow", "state", "Lru/tattelecom/feature/call_history/UiState;", "getState", PushNotificationArg.TECH_LOG_TOKEN, "checkUserAccount", "closeBanner", "navigateToConnectServices", "item", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryBanner;", "onEventImageSelected", "onEventSelected", "removeEvent", "fromEveryone", "(Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportEvent", "buttonId", "showRemoveEventDialog", "switchDataType", "loadType", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryViewModel extends ViewModel {
    private final MutableStateFlow<String> _callImage;
    private final Channel<Integer> _eventNavigateToConnectService;
    private final Channel<Triple<String, Long, Integer>> _eventOpenVideo;
    private final Channel<String> _eventShowMessage;
    private final Channel<HistoryItem> _eventShowRemoveDialog;
    private final Channel<String> _eventShowSnack;
    private final Function1<UiAction, Unit> accept;
    private final StateFlow<String> callImage;
    private final EventHistoryInteractor eventHistoryInteractor;
    private final Flow<Integer> eventNavigateToConnectService;
    private final Flow<Triple<String, Long, Integer>> eventOpenVideo;
    private final Flow<String> eventShowMessage;
    private final Flow<HistoryItem> eventShowRemoveDialog;
    private final Flow<String> eventShowSnack;
    private DataLoadType filterEventType;
    private boolean isBannerClosed;
    private final LogInteractor logInteractor;
    private final Flow<PagingData<HistoryItem>> pagingDataFlow;
    private final StateFlow<UiState> state;
    private String token;
    private final UserInteractor userInteractor;

    public EventHistoryViewModel(EventHistoryInteractor eventHistoryInteractor, LogInteractor logInteractor, UserInteractor userInteractor) {
        Intrinsics.checkNotNullParameter(eventHistoryInteractor, "eventHistoryInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        this.eventHistoryInteractor = eventHistoryInteractor;
        this.logInteractor = logInteractor;
        this.userInteractor = userInteractor;
        this.filterEventType = DataLoadType.TYPE_ALL;
        this.token = userInteractor.getToken();
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._callImage = MutableStateFlow;
        this.callImage = MutableStateFlow;
        Channel<String> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowMessage = Channel$default;
        this.eventShowMessage = FlowKt.receiveAsFlow(Channel$default);
        Channel<Triple<String, Long, Integer>> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventOpenVideo = Channel$default2;
        this.eventOpenVideo = FlowKt.receiveAsFlow(Channel$default2);
        Channel<Integer> Channel$default3 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventNavigateToConnectService = Channel$default3;
        this.eventNavigateToConnectService = FlowKt.receiveAsFlow(Channel$default3);
        Channel<HistoryItem> Channel$default4 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowRemoveDialog = Channel$default4;
        this.eventShowRemoveDialog = FlowKt.receiveAsFlow(Channel$default4);
        Channel<String> Channel$default5 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowSnack = Channel$default5;
        this.eventShowSnack = FlowKt.receiveAsFlow(Channel$default5);
        DataLoadType dataLoadType = DataLoadType.TYPE_ALL;
        final MutableSharedFlow MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        final MutableSharedFlow mutableSharedFlow = MutableSharedFlow$default;
        Flow onStart = FlowKt.onStart(FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1$2", f = "EventHistoryViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1$2$1 r0 = (ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1$2$1 r0 = new ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        boolean r2 = r5 instanceof ru.tattelecom.feature.call_history.UiAction.SwitchLoadType
                        if (r2 == 0) goto L47
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), new EventHistoryViewModel$searches$1(dataLoadType, this, null));
        EventHistoryViewModel eventHistoryViewModel = this;
        Flow onStart2 = FlowKt.onStart(FlowKt.shareIn(FlowKt.distinctUntilChanged(new Flow<Object>() { // from class: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2$2", f = "EventHistoryViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
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
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2$2$1 r0 = (ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2$2$1 r0 = new ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L47
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        boolean r2 = r5 instanceof ru.tattelecom.feature.call_history.UiAction.Scroll
                        if (r2 == 0) goto L47
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L47
                        return r1
                    L47:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$filterIsInstance$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }), ViewModelKt.getViewModelScope(eventHistoryViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), 1), new EventHistoryViewModel$queriesScrolled$1(dataLoadType, null));
        this.pagingDataFlow = CachedPagingDataKt.cachedIn(FlowKt.transformLatest(onStart, new EventHistoryViewModel$special$$inlined$flatMapLatest$1(null, this)), ViewModelKt.getViewModelScope(eventHistoryViewModel));
        final Flow combine = FlowKt.combine(onStart, onStart2, AnonymousClass3.INSTANCE);
        this.state = FlowKt.stateIn(new Flow<UiState>() { // from class: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1$2", f = "EventHistoryViewModel.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r9
                        ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1$2$1 r0 = (ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r9 = r0.label
                        int r9 = r9 - r2
                        r0.label = r9
                        goto L19
                    L14:
                        ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1$2$1 r0 = new ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L19:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L6b
                    L2a:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L32:
                        kotlin.ResultKt.throwOnFailure(r9)
                        kotlinx.coroutines.flow.FlowCollector r9 = r7.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        kotlin.Pair r8 = (kotlin.Pair) r8
                        java.lang.Object r2 = r8.component1()
                        ru.tattelecom.feature.call_history.UiAction$SwitchLoadType r2 = (ru.tattelecom.feature.call_history.UiAction.SwitchLoadType) r2
                        java.lang.Object r8 = r8.component2()
                        ru.tattelecom.feature.call_history.UiAction$Scroll r8 = (ru.tattelecom.feature.call_history.UiAction.Scroll) r8
                        ru.tattelecom.feature.call_history.UiState r4 = new ru.tattelecom.feature.call_history.UiState
                        ru.tattelecom.intercom.data.remote.source.paging.DataLoadType r5 = r2.getLoadType()
                        ru.tattelecom.intercom.data.remote.source.paging.DataLoadType r6 = r8.getCurrentType()
                        ru.tattelecom.intercom.data.remote.source.paging.DataLoadType r2 = r2.getLoadType()
                        ru.tattelecom.intercom.data.remote.source.paging.DataLoadType r8 = r8.getCurrentType()
                        if (r2 == r8) goto L5e
                        r8 = r3
                        goto L5f
                    L5e:
                        r8 = 0
                    L5f:
                        r4.<init>(r5, r6, r8)
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r4, r0)
                        if (r8 != r1) goto L6b
                        return r1
                    L6b:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super UiState> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        }, ViewModelKt.getViewModelScope(eventHistoryViewModel), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.INSTANCE, 5000L, 0L, 2, null), new UiState(null, null, false, 7, null));
        this.accept = new Function1<UiAction, Unit>() { // from class: ru.tattelecom.feature.call_history.EventHistoryViewModel.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* compiled from: EventHistoryViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$5$1", f = "EventHistoryViewModel.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$5$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ UiAction $action;
                final /* synthetic */ MutableSharedFlow<UiAction> $actionStateFlow;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableSharedFlow<UiAction> mutableSharedFlow, UiAction uiAction, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$actionStateFlow = mutableSharedFlow;
                    this.$action = uiAction;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$actionStateFlow, this.$action, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        if (this.$actionStateFlow.emit(this.$action, this) == coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UiAction uiAction) {
                invoke2(uiAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UiAction action) {
                Intrinsics.checkNotNullParameter(action, "action");
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(EventHistoryViewModel.this), null, null, new AnonymousClass1(MutableSharedFlow$default, action, null), 3, null);
            }
        };
    }

    public final DataLoadType getFilterEventType() {
        return this.filterEventType;
    }

    public final void setFilterEventType(DataLoadType dataLoadType) {
        Intrinsics.checkNotNullParameter(dataLoadType, "<set-?>");
        this.filterEventType = dataLoadType;
    }

    /* renamed from: isBannerClosed, reason: from getter */
    public final boolean getIsBannerClosed() {
        return this.isBannerClosed;
    }

    public final void setBannerClosed(boolean z) {
        this.isBannerClosed = z;
    }

    public final StateFlow<String> getCallImage() {
        return this.callImage;
    }

    public final Flow<String> getEventShowMessage() {
        return this.eventShowMessage;
    }

    public final Flow<Triple<String, Long, Integer>> getEventOpenVideo() {
        return this.eventOpenVideo;
    }

    public final Flow<Integer> getEventNavigateToConnectService() {
        return this.eventNavigateToConnectService;
    }

    public final Flow<HistoryItem> getEventShowRemoveDialog() {
        return this.eventShowRemoveDialog;
    }

    public final Flow<String> getEventShowSnack() {
        return this.eventShowSnack;
    }

    public final Flow<PagingData<HistoryItem>> getPagingDataFlow() {
        return this.pagingDataFlow;
    }

    public final StateFlow<UiState> getState() {
        return this.state;
    }

    public final Function1<UiAction, Unit> getAccept() {
        return this.accept;
    }

    /* compiled from: EventHistoryViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$3, reason: invalid class name */
    /* synthetic */ class AnonymousClass3 extends AdaptedFunctionReference implements Function3<UiAction.SwitchLoadType, UiAction.Scroll, Continuation<? super Pair<? extends UiAction.SwitchLoadType, ? extends UiAction.Scroll>>, Object>, SuspendFunction {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(3, Pair.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 4);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(UiAction.SwitchLoadType switchLoadType, UiAction.Scroll scroll, Continuation<? super Pair<? extends UiAction.SwitchLoadType, ? extends UiAction.Scroll>> continuation) {
            return invoke2(switchLoadType, scroll, (Continuation<? super Pair<UiAction.SwitchLoadType, UiAction.Scroll>>) continuation);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(UiAction.SwitchLoadType switchLoadType, UiAction.Scroll scroll, Continuation<? super Pair<UiAction.SwitchLoadType, UiAction.Scroll>> continuation) {
            return EventHistoryViewModel._init_$lambda$1(switchLoadType, scroll, continuation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object _init_$lambda$1(UiAction.SwitchLoadType switchLoadType, UiAction.Scroll scroll, Continuation continuation) {
        return new Pair(switchLoadType, scroll);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<PagingData<HistoryItem>> switchDataType(DataLoadType loadType, boolean isBannerClosed) {
        return this.eventHistoryInteractor.getSearchResultStream(loadType, isBannerClosed, new Function0<Unit>() { // from class: ru.tattelecom.feature.call_history.EventHistoryViewModel$switchDataType$1
            {
                super(0);
            }

            /* compiled from: EventHistoryViewModel.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryViewModel$switchDataType$1$1", f = "EventHistoryViewModel.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: ru.tattelecom.feature.call_history.EventHistoryViewModel$switchDataType$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ EventHistoryViewModel this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(EventHistoryViewModel eventHistoryViewModel, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = eventHistoryViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Channel channel;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        channel = this.this$0._eventShowMessage;
                        this.label = 1;
                        if (channel.send("something_went_wrong", this) == coroutine_suspended) {
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

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(EventHistoryViewModel.this), null, null, new AnonymousClass1(EventHistoryViewModel.this, null), 3, null);
            }
        });
    }

    public final void onEventSelected(HistoryItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EventHistoryViewModel$onEventSelected$1(item, this, null), 3, null);
    }

    public final void onEventImageSelected(HistoryItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getType() == 3) {
            reportEvent(19);
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EventHistoryViewModel$onEventImageSelected$1(this, item, null), 3, null);
    }

    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }

    public final void showRemoveEventDialog(HistoryItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EventHistoryViewModel$showRemoveEventDialog$1(item, this, null), 3, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(6:5|6|7|(1:(4:22|23|24|(1:26))(1:(1:(1:14)(2:18|19))(2:20|21)))(2:27|(6:29|30|(1:(1:(2:35|(1:37)))(2:38|(1:40)))(2:41|(1:43))|34|24|(0)))|15|16))|49|6|7|(0)(0)|15|16|(1:(0))) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Type inference failed for: r9v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object removeEvent(ru.tattelecom.intercom.data.remote.source.paging.HistoryItem r9, boolean r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ru.tattelecom.feature.call_history.EventHistoryViewModel$removeEvent$1
            if (r0 == 0) goto L14
            r0 = r11
            ru.tattelecom.feature.call_history.EventHistoryViewModel$removeEvent$1 r0 = (ru.tattelecom.feature.call_history.EventHistoryViewModel$removeEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            ru.tattelecom.feature.call_history.EventHistoryViewModel$removeEvent$1 r0 = new ru.tattelecom.feature.call_history.EventHistoryViewModel$removeEvent$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 1
            if (r2 == 0) goto L50
            if (r2 == r7) goto L48
            if (r2 == r3) goto L48
            if (r2 == r6) goto L48
            if (r2 == r5) goto L3f
            if (r2 != r4) goto L37
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lba
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3f:
            java.lang.Object r9 = r0.L$0
            ru.tattelecom.feature.call_history.EventHistoryViewModel r9 = (ru.tattelecom.feature.call_history.EventHistoryViewModel) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> Laa
            goto Lba
        L48:
            java.lang.Object r9 = r0.L$0
            ru.tattelecom.feature.call_history.EventHistoryViewModel r9 = (ru.tattelecom.feature.call_history.EventHistoryViewModel) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch: java.lang.Exception -> Laa
            goto L9a
        L50:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r9 instanceof ru.tattelecom.intercom.data.remote.source.paging.EventHistory
            if (r11 == 0) goto Lba
            int r11 = r9.getType()     // Catch: java.lang.Exception -> La9
            if (r11 == r6) goto L85
            if (r11 == r5) goto L74
            if (r11 == r4) goto L63
        L61:
            r9 = r8
            goto L9a
        L63:
            ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor r11 = r8.eventHistoryInteractor     // Catch: java.lang.Exception -> La9
            java.lang.String r9 = r9.getId()     // Catch: java.lang.Exception -> La9
            r0.L$0 = r8     // Catch: java.lang.Exception -> La9
            r0.label = r6     // Catch: java.lang.Exception -> La9
            java.lang.Object r9 = r11.removeCodePassLog(r9, r10, r0)     // Catch: java.lang.Exception -> La9
            if (r9 != r1) goto L61
            return r1
        L74:
            ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor r11 = r8.eventHistoryInteractor     // Catch: java.lang.Exception -> La9
            java.lang.String r9 = r9.getId()     // Catch: java.lang.Exception -> La9
            r0.L$0 = r8     // Catch: java.lang.Exception -> La9
            r0.label = r3     // Catch: java.lang.Exception -> La9
            java.lang.Object r9 = r11.removeKeyLog(r9, r10, r0)     // Catch: java.lang.Exception -> La9
            if (r9 != r1) goto L61
            return r1
        L85:
            ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor r11 = r8.eventHistoryInteractor     // Catch: java.lang.Exception -> La9
            java.lang.String r9 = r9.getId()     // Catch: java.lang.Exception -> La9
            int r9 = java.lang.Integer.parseInt(r9)     // Catch: java.lang.Exception -> La9
            r0.L$0 = r8     // Catch: java.lang.Exception -> La9
            r0.label = r7     // Catch: java.lang.Exception -> La9
            java.lang.Object r9 = r11.removeCallLog(r9, r10, r0)     // Catch: java.lang.Exception -> La9
            if (r9 != r1) goto L61
            return r1
        L9a:
            kotlinx.coroutines.channels.Channel<java.lang.String> r10 = r9._eventShowMessage     // Catch: java.lang.Exception -> Laa
            java.lang.String r11 = "success"
            r0.L$0 = r9     // Catch: java.lang.Exception -> Laa
            r0.label = r5     // Catch: java.lang.Exception -> Laa
            java.lang.Object r9 = r10.send(r11, r0)     // Catch: java.lang.Exception -> Laa
            if (r9 != r1) goto Lba
            return r1
        La9:
            r9 = r8
        Laa:
            kotlinx.coroutines.channels.Channel<java.lang.String> r9 = r9._eventShowMessage
            r10 = 0
            r0.L$0 = r10
            r0.label = r4
            java.lang.String r10 = "something_went_wrong"
            java.lang.Object r9 = r9.send(r10, r0)
            if (r9 != r1) goto Lba
            return r1
        Lba:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.feature.call_history.EventHistoryViewModel.removeEvent(ru.tattelecom.intercom.data.remote.source.paging.HistoryItem, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void closeBanner() {
        this.isBannerClosed = true;
    }

    public final void navigateToConnectServices(HistoryBanner item) {
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EventHistoryViewModel$navigateToConnectServices$1(item, this, null), 3, null);
    }

    public final boolean checkUserAccount() {
        if (Intrinsics.areEqual(this.token, this.userInteractor.getToken())) {
            return true;
        }
        this.token = this.userInteractor.getToken();
        return false;
    }
}
