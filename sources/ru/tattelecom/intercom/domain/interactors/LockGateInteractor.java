package ru.tattelecom.intercom.domain.interactors;

import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.data.local.dao.LockGateDao;
import ru.tattelecom.intercom.data.local.entity.LockGateEntity;
import ru.tattelecom.intercom.data.prefs.RemoteConfigPrefsSource;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.domain.model.LockGateStatusDto;
import ru.tattelecom.intercom.domain.workers.UnlockGateWorker;

/* compiled from: LockGateInteractor.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00192\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "", "lockGateDao", "Lru/tattelecom/intercom/data/local/dao/LockGateDao;", "configPrefs", "Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;", "context", "Landroid/content/Context;", "userPrefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "(Lru/tattelecom/intercom/data/local/dao/LockGateDao;Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;Landroid/content/Context;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;)V", "addLockGate", "", "gateId", "", "checkDateLock", "", "dateLock", "", "checkLockGateByWidgetId", "widgetId", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOld", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGateLockStatusById", "Lkotlinx/coroutines/flow/Flow;", "Lru/tattelecom/intercom/domain/model/LockGateStatusDto;", "lockGate", "statusLockGate", "", "Lru/tattelecom/intercom/data/local/entity/LockGateEntity;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LockGateInteractor {
    private final RemoteConfigPrefsSource configPrefs;
    private final Context context;
    private final LockGateDao lockGateDao;
    private final UserPrefsSource userPrefsSource;

    public LockGateInteractor(LockGateDao lockGateDao, RemoteConfigPrefsSource configPrefs, Context context, UserPrefsSource userPrefsSource) {
        Intrinsics.checkNotNullParameter(lockGateDao, "lockGateDao");
        Intrinsics.checkNotNullParameter(configPrefs, "configPrefs");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userPrefsSource, "userPrefsSource");
        this.lockGateDao = lockGateDao;
        this.configPrefs = configPrefs;
        this.context = context;
        this.userPrefsSource = userPrefsSource;
    }

    public final Flow<List<LockGateEntity>> statusLockGate() {
        return this.lockGateDao.getAll();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteOld(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.domain.interactors.LockGateInteractor$deleteOld$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.domain.interactors.LockGateInteractor$deleteOld$1 r0 = (ru.tattelecom.intercom.domain.interactors.LockGateInteractor$deleteOld$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.LockGateInteractor$deleteOld$1 r0 = new ru.tattelecom.intercom.domain.interactors.LockGateInteractor$deleteOld$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.LockGateInteractor r0 = (ru.tattelecom.intercom.domain.interactors.LockGateInteractor) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L59
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = "UTC"
            java.util.TimeZone r7 = java.util.TimeZone.getTimeZone(r7)
            java.util.Calendar r7 = java.util.Calendar.getInstance(r7)
            java.util.Date r7 = r7.getTime()
            long r4 = r7.getTime()
            ru.tattelecom.intercom.data.local.dao.LockGateDao r7 = r6.lockGateDao
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r7.deleteByDate(r4, r0)
            if (r7 != r1) goto L58
            return r1
        L58:
            r0 = r6
        L59:
            android.content.Intent r7 = new android.content.Intent
            r7.<init>()
            android.content.Context r1 = r0.context
            java.lang.String r2 = "ru.tattelecom.intercom.feature.gate_widget.broadcast.UpdateWidgetsBroadcastReceiver"
            r7.setClassName(r1, r2)
            android.content.Context r0 = r0.context
            r0.sendBroadcast(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.LockGateInteractor.deleteOld(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkLockGateByWidgetId(int r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.tattelecom.intercom.domain.interactors.LockGateInteractor$checkLockGateByWidgetId$1
            if (r0 == 0) goto L14
            r0 = r6
            ru.tattelecom.intercom.domain.interactors.LockGateInteractor$checkLockGateByWidgetId$1 r0 = (ru.tattelecom.intercom.domain.interactors.LockGateInteractor$checkLockGateByWidgetId$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.LockGateInteractor$checkLockGateByWidgetId$1 r0 = new ru.tattelecom.intercom.domain.interactors.LockGateInteractor$checkLockGateByWidgetId$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r5 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4a
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = r4.userPrefsSource
            int r5 = r6.getGateIdByWidgetId(r5)
            ru.tattelecom.intercom.data.local.dao.LockGateDao r6 = r4.lockGateDao
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.getUnlockGateId(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.util.List r6 = (java.util.List) r6
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            boolean r5 = r6.contains(r5)
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.LockGateInteractor.checkLockGateByWidgetId(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean checkDateLock(long dateLock) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.add(13, this.configPrefs.getLockGateTimeout());
        return dateLock >= calendar.getTime().getTime();
    }

    public final void addLockGate(int gateId) {
        lockGate(gateId);
    }

    private final void lockGate(int gateId) {
        if (this.configPrefs.getLockGateTimeout() <= 0) {
            return;
        }
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.add(13, this.configPrefs.getLockGateTimeout());
        this.lockGateDao.insert(new LockGateEntity(gateId, calendar.getTime().getTime()));
        WorkManager.getInstance(this.context).enqueue(new OneTimeWorkRequest.Builder(UnlockGateWorker.class).setInitialDelay(this.configPrefs.getLockGateTimeout(), TimeUnit.SECONDS).build());
        Intent intent = new Intent();
        intent.setClassName(this.context, "ru.tattelecom.intercom.feature.gate_widget.broadcast.UpdateWidgetsBroadcastReceiver");
        this.context.sendBroadcast(intent);
    }

    public final Flow<LockGateStatusDto> getGateLockStatusById(int gateId) {
        final Flow<LockGateEntity> byId = this.lockGateDao.getById(gateId);
        return new Flow<LockGateStatusDto>() { // from class: ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1$2", f = "LockGateInteractor.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1$2$1, reason: invalid class name */
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
                        boolean r0 = r9 instanceof ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r9
                        ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r9 = r0.label
                        int r9 = r9 - r2
                        r0.label = r9
                        goto L19
                    L14:
                        ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L19:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r9)
                        goto L56
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
                        ru.tattelecom.intercom.data.local.entity.LockGateEntity r8 = (ru.tattelecom.intercom.data.local.entity.LockGateEntity) r8
                        if (r8 == 0) goto L4c
                        ru.tattelecom.intercom.domain.model.LockGateStatusDto r2 = new ru.tattelecom.intercom.domain.model.LockGateStatusDto
                        int r4 = r8.getGateId()
                        long r5 = r8.getDate()
                        r2.<init>(r4, r5)
                        goto L4d
                    L4c:
                        r2 = 0
                    L4d:
                        r0.label = r3
                        java.lang.Object r8 = r9.emit(r2, r0)
                        if (r8 != r1) goto L56
                        return r1
                    L56:
                        kotlin.Unit r8 = kotlin.Unit.INSTANCE
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.LockGateInteractor$getGateLockStatusById$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super LockGateStatusDto> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
    }
}
