package ru.tattelecom.intercom.domain.interactors;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.dao.GateEventDao;
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.entity.GateEventEntity;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.source.GateRemote;
import ru.tattelecom.intercom.domain.model.GateEventDto;

/* compiled from: GateInteractor.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0018\u0010!\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0018\u0010\"\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00130\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010%\u001a\u0004\u0018\u00010\u001a2\u0006\u0010&\u001a\u00020'H\u0086@¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u0018\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u001e\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0086@¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u00101\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001aR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "remote", "Lru/tattelecom/intercom/data/remote/source/GateRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "intercomDao", "Lru/tattelecom/intercom/data/local/dao/IntercomDao;", "gateEventDao", "Lru/tattelecom/intercom/data/local/dao/GateEventDao;", "lockGateInteractor", "Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/remote/source/GateRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;Lru/tattelecom/intercom/data/local/dao/IntercomDao;Lru/tattelecom/intercom/data/local/dao/GateEventDao;Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;)V", "dateFormatter", "Ljava/text/SimpleDateFormat;", "gates", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "getGates", "()Lkotlinx/coroutines/flow/Flow;", "addToFavorites", "", "gateId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bindWidgetIdToGateId", "widgetId", "clearOldEvents", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByWidgetId", "getEmergencyCode", "getEmergencyCodeByGateId", "getEventsFlow", "Lru/tattelecom/intercom/domain/model/GateEventDto;", "getGateId", NavArg.INTERCOM_LOGIN, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "", "openDoor", "refreshEvents", "date", "", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFromFavorites", "unbindWidgetId", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GateInteractor {
    private final SimpleDateFormat dateFormatter;
    private final AppCoroutineDispatchers dispatchers;
    private final GateEventDao gateEventDao;
    private final Flow<List<IntercomEntity>> gates;
    private final IntercomDao intercomDao;
    private final LockGateInteractor lockGateInteractor;
    private final UserPrefsSource prefs;
    private final GateRemote remote;

    public GateInteractor(UserPrefsSource prefs, GateRemote remote, AppCoroutineDispatchers dispatchers, IntercomDao intercomDao, GateEventDao gateEventDao, LockGateInteractor lockGateInteractor) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(intercomDao, "intercomDao");
        Intrinsics.checkNotNullParameter(gateEventDao, "gateEventDao");
        Intrinsics.checkNotNullParameter(lockGateInteractor, "lockGateInteractor");
        this.prefs = prefs;
        this.remote = remote;
        this.dispatchers = dispatchers;
        this.intercomDao = intercomDao;
        this.gateEventDao = gateEventDao;
        this.lockGateInteractor = lockGateInteractor;
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd", new Locale("RU", "ru"));
        this.gates = intercomDao.observeAll();
    }

    public final Object open(int i, Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new GateInteractor$open$2(this, i, null), continuation);
    }

    public final Flow<List<IntercomEntity>> getGates() {
        return this.gates;
    }

    public final Object addToFavorites(int i, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new GateInteractor$addToFavorites$2(this, i, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object removeFromFavorites(int i, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new GateInteractor$removeFromFavorites$2(this, i, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getGateId(String str, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new GateInteractor$getGateId$2(this, str, null), continuation);
    }

    public final void bindWidgetIdToGateId(int widgetId, int gateId) {
        this.prefs.bindWidgetIdToGateId(widgetId, gateId);
    }

    public final Object getByWidgetId(int i, Continuation<? super IntercomEntity> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new GateInteractor$getByWidgetId$2(this, i, null), continuation);
    }

    public final void unbindWidgetId(int widgetId) {
        this.prefs.unbindWidgetId(widgetId);
    }

    public final Object getEmergencyCode(int i, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new GateInteractor$getEmergencyCode$2(this, i, null), continuation);
    }

    public final Object openDoor(int i, Continuation<? super Boolean> continuation) {
        return open(i, continuation);
    }

    public final Flow<List<GateEventDto>> getEventsFlow(int gateId) {
        final Flow<List<GateEventEntity>> asFlow = this.gateEventDao.getAsFlow(gateId);
        return (Flow) new Flow<List<? extends GateEventDto>>() { // from class: ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1$2", f = "GateInteractor.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r14, kotlin.coroutines.Continuation r15) {
                    /*
                        r13 = this;
                        boolean r0 = r15 instanceof ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r15
                        ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r15 = r0.label
                        int r15 = r15 - r2
                        r0.label = r15
                        goto L19
                    L14:
                        ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1$2$1
                        r0.<init>(r15)
                    L19:
                        java.lang.Object r15 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r15)
                        goto L89
                    L2a:
                        java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                        java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
                        r14.<init>(r15)
                        throw r14
                    L32:
                        kotlin.ResultKt.throwOnFailure(r15)
                        kotlinx.coroutines.flow.FlowCollector r15 = r13.$this_unsafeFlow
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.util.List r14 = (java.util.List) r14
                        java.lang.Iterable r14 = (java.lang.Iterable) r14
                        java.util.ArrayList r2 = new java.util.ArrayList
                        r4 = 10
                        int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r14, r4)
                        r2.<init>(r4)
                        java.util.Collection r2 = (java.util.Collection) r2
                        java.util.Iterator r14 = r14.iterator()
                    L4f:
                        boolean r4 = r14.hasNext()
                        if (r4 == 0) goto L7e
                        java.lang.Object r4 = r14.next()
                        ru.tattelecom.intercom.data.local.entity.GateEventEntity r4 = (ru.tattelecom.intercom.data.local.entity.GateEventEntity) r4
                        ru.tattelecom.intercom.domain.model.GateEventDto r12 = new ru.tattelecom.intercom.domain.model.GateEventDto
                        java.lang.String r6 = r4.getId()
                        int r7 = r4.getGateId()
                        java.lang.String r8 = r4.getType()
                        java.util.Date r9 = new java.util.Date
                        long r10 = r4.getStartDate()
                        r9.<init>(r10)
                        long r10 = r4.getDuration()
                        r5 = r12
                        r5.<init>(r6, r7, r8, r9, r10)
                        r2.add(r12)
                        goto L4f
                    L7e:
                        java.util.List r2 = (java.util.List) r2
                        r0.label = r3
                        java.lang.Object r14 = r15.emit(r2, r0)
                        if (r14 != r1) goto L89
                        return r1
                    L89:
                        kotlin.Unit r14 = kotlin.Unit.INSTANCE
                        return r14
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.GateInteractor$getEventsFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends GateEventDto>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[LOOP:0: B:23:0x00ae->B:25:0x00b4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object refreshEvents(int r20, long r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.GateInteractor.refreshEvents(int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getEmergencyCodeByGateId(int i, Continuation<? super Integer> continuation) {
        return getEmergencyCode(i, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object clearOldEvents(Continuation<? super Unit> continuation) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(7, -8);
        Object clearOld = this.gateEventDao.clearOld(calendar.getTimeInMillis(), continuation);
        return clearOld == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clearOld : Unit.INSTANCE;
    }
}
