package ru.tattelecom.intercom.domain.workers;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;

/* compiled from: UnlockGateWorker.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/domain/workers/UnlockGateWorker;", "Landroidx/work/CoroutineWorker;", "Lorg/koin/core/component/KoinComponent;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "lockGateInteractor", "Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "getLockGateInteractor", "()Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "lockGateInteractor$delegate", "Lkotlin/Lazy;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UnlockGateWorker extends CoroutineWorker implements KoinComponent {

    /* renamed from: lockGateInteractor$delegate, reason: from kotlin metadata */
    private final Lazy lockGateInteractor;

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnlockGateWorker(Context appContext, WorkerParameters workerParams) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        final UnlockGateWorker unlockGateWorker = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.lockGateInteractor = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<LockGateInteractor>() { // from class: ru.tattelecom.intercom.domain.workers.UnlockGateWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.LockGateInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final LockGateInteractor invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(LockGateInteractor.class), qualifier2, function0);
            }
        });
    }

    private final LockGateInteractor getLockGateInteractor() {
        return (LockGateInteractor) this.lockGateInteractor.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.tattelecom.intercom.domain.workers.UnlockGateWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r5
            ru.tattelecom.intercom.domain.workers.UnlockGateWorker$doWork$1 r0 = (ru.tattelecom.intercom.domain.workers.UnlockGateWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            ru.tattelecom.intercom.domain.workers.UnlockGateWorker$doWork$1 r0 = new ru.tattelecom.intercom.domain.workers.UnlockGateWorker$doWork$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L4a
            goto L42
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.tattelecom.intercom.domain.interactors.LockGateInteractor r5 = r4.getLockGateInteractor()     // Catch: java.lang.Throwable -> L4a
            r0.label = r3     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r5 = r5.deleteOld(r0)     // Catch: java.lang.Throwable -> L4a
            if (r5 != r1) goto L42
            return r1
        L42:
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.success()     // Catch: java.lang.Throwable -> L4a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: java.lang.Throwable -> L4a
            goto L51
        L4a:
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.failure()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
        L51:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.workers.UnlockGateWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
