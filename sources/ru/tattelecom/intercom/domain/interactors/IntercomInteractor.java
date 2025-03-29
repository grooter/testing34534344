package ru.tattelecom.intercom.domain.interactors;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.dao.IntercomDao;
import ru.tattelecom.intercom.data.local.dao.ScheduleDao;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.data.local.entity.ScheduleEntity;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.source.IntercomRemote;

/* compiled from: IntercomInteractor.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001d2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010(JV\u0010)\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\u00142\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00110.H\u0086@¢\u0006\u0002\u0010/J\b\u00100\u001a\u0004\u0018\u00010\u0016J\b\u00101\u001a\u0004\u0018\u00010\u0016J\r\u00102\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u00103R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "remote", "Lru/tattelecom/intercom/data/remote/source/IntercomRemote;", "intercomDao", "Lru/tattelecom/intercom/data/local/dao/IntercomDao;", "scheduleDao", "Lru/tattelecom/intercom/data/local/dao/ScheduleDao;", "addressInteractor", "Lru/tattelecom/intercom/domain/interactors/AddressInteractor;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/remote/source/IntercomRemote;Lru/tattelecom/intercom/data/local/dao/IntercomDao;Lru/tattelecom/intercom/data/local/dao/ScheduleDao;Lru/tattelecom/intercom/domain/interactors/AddressInteractor;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "isDoNotDisturbEnabled", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "getEmergencyCodeByIntercomLogin", "", NavArg.INTERCOM_LOGIN, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSchedule", "Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", TtmlNode.ATTR_ID, "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeStreamUrl", "Lkotlinx/coroutines/flow/Flow;", "refreshAddressesIfNotExist", "", "resetSchedule", "scheduleId", "setCalls", NavArg.INTERCOM_ID, "muted", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDoNotDisturb", "isEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSchedule", "startTime", "Lkotlin/Pair;", "finishTime", "days", "", "(ILjava/lang/Integer;Lkotlin/Pair;Lkotlin/Pair;[Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sipSettingsLogin", "sipSettingsPassword", "sipSettingsRegExpire", "()Ljava/lang/Integer;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntercomInteractor {
    private final AddressInteractor addressInteractor;
    private final AppCoroutineDispatchers dispatchers;
    private final IntercomDao intercomDao;
    private final MutableStateFlow<Boolean> isDoNotDisturbEnabled;
    private final UserPrefsSource prefs;
    private final IntercomRemote remote;
    private final ScheduleDao scheduleDao;

    public IntercomInteractor(UserPrefsSource prefs, IntercomRemote remote, IntercomDao intercomDao, ScheduleDao scheduleDao, AddressInteractor addressInteractor, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(intercomDao, "intercomDao");
        Intrinsics.checkNotNullParameter(scheduleDao, "scheduleDao");
        Intrinsics.checkNotNullParameter(addressInteractor, "addressInteractor");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.prefs = prefs;
        this.remote = remote;
        this.intercomDao = intercomDao;
        this.scheduleDao = scheduleDao;
        this.addressInteractor = addressInteractor;
        this.dispatchers = dispatchers;
        this.isDoNotDisturbEnabled = prefs.isCallsMuted();
    }

    public final Object getSchedule(int i, Continuation<? super ScheduleEntity> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$getSchedule$2(this, i, null), continuation);
    }

    public final MutableStateFlow<Boolean> isDoNotDisturbEnabled() {
        return this.isDoNotDisturbEnabled;
    }

    public final String sipSettingsLogin() {
        return this.prefs.getSipSettingsLogin();
    }

    public final String sipSettingsPassword() {
        return this.prefs.getSipSettingsPassword();
    }

    public final Integer sipSettingsRegExpire() {
        return this.prefs.getSipSettingsRegExpire();
    }

    public final Object refreshAddressesIfNotExist(String str, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$refreshAddressesIfNotExist$2(this, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object setCalls(int i, boolean z, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$setCalls$2(this, i, z, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object setDoNotDisturb(boolean z, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$setDoNotDisturb$2(this, z, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object setSchedule(int i, Integer num, Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2, Boolean[] boolArr, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$setSchedule$2(num, this, i, pair, pair2, boolArr, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object resetSchedule(int i, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$resetSchedule$2(this, i, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Flow<String> observeStreamUrl(String intercomLogin) {
        final Flow<IntercomEntity> observe = this.intercomDao.observe(intercomLogin);
        return new Flow<String>() { // from class: ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1$2", f = "IntercomInteractor.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1$2$1, reason: invalid class name */
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
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 - r2
                        r0.label = r6
                        goto L19
                    L14:
                        ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4d
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
                        ru.tattelecom.intercom.data.local.entity.IntercomEntity r5 = (ru.tattelecom.intercom.data.local.entity.IntercomEntity) r5
                        if (r5 == 0) goto L43
                        java.lang.String r5 = r5.getStreamUrl()
                        goto L44
                    L43:
                        r5 = 0
                    L44:
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4d
                        return r1
                    L4d:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.IntercomInteractor$observeStreamUrl$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super String> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }

    public final Object getEmergencyCodeByIntercomLogin(String str, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new IntercomInteractor$getEmergencyCodeByIntercomLogin$2(this, str, null), continuation);
    }
}
