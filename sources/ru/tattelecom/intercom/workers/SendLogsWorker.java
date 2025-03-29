package ru.tattelecom.intercom.workers;

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
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;

/* compiled from: SendLogsWorker.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/workers/SendLogsWorker;", "Lorg/koin/core/component/KoinComponent;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "getLogInteractor", "()Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "logInteractor$delegate", "Lkotlin/Lazy;", NavArg.SEND_LOGS_TOKEN, "", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SendLogsWorker extends CoroutineWorker implements KoinComponent {

    /* renamed from: logInteractor$delegate, reason: from kotlin metadata */
    private final Lazy logInteractor;
    private final String sendLogsToken;

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendLogsWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        String string = getInputData().getString(NavArg.SEND_LOGS_TOKEN);
        this.sendLogsToken = string == null ? "" : string;
        final SendLogsWorker sendLogsWorker = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.logInteractor = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<LogInteractor>() { // from class: ru.tattelecom.intercom.workers.SendLogsWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.LogInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final LogInteractor invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(LogInteractor.class), qualifier2, function0);
            }
        });
    }

    private final LogInteractor getLogInteractor() {
        return (LogInteractor) this.logInteractor.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.tattelecom.intercom.workers.SendLogsWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r5
            ru.tattelecom.intercom.workers.SendLogsWorker$doWork$1 r0 = (ru.tattelecom.intercom.workers.SendLogsWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            ru.tattelecom.intercom.workers.SendLogsWorker$doWork$1 r0 = new ru.tattelecom.intercom.workers.SendLogsWorker$doWork$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.tattelecom.intercom.domain.interactors.LogInteractor r5 = r4.getLogInteractor()
            java.lang.String r2 = r4.sendLogsToken
            r0.label = r3
            java.lang.Object r5 = r5.send(r2, r0)
            if (r5 != r1) goto L44
            return r1
        L44:
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r0 = "success(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.workers.SendLogsWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
