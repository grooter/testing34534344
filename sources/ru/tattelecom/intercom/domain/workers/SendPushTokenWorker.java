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
import ru.tattelecom.intercom.domain.interactors.PushInteractor;

/* compiled from: SendPushTokenWorker.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0013R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/domain/workers/SendPushTokenWorker;", "Lorg/koin/core/component/KoinComponent;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "pushInteractor", "Lru/tattelecom/intercom/domain/interactors/PushInteractor;", "getPushInteractor", "()Lru/tattelecom/intercom/domain/interactors/PushInteractor;", "pushInteractor$delegate", "Lkotlin/Lazy;", SendPushTokenWorker.PUSH_SERVICE, "", SendPushTokenWorker.PUSH_TOKEN, "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendPushTokenWorker extends CoroutineWorker implements KoinComponent {
    public static final String PUSH_SERVICE = "pushService";
    public static final String PUSH_TOKEN = "pushToken";

    /* renamed from: pushInteractor$delegate, reason: from kotlin metadata */
    private final Lazy pushInteractor;
    private final String pushService;
    private final String pushToken;

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendPushTokenWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        final SendPushTokenWorker sendPushTokenWorker = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.pushInteractor = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<PushInteractor>() { // from class: ru.tattelecom.intercom.domain.workers.SendPushTokenWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.PushInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final PushInteractor invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(PushInteractor.class), qualifier2, function0);
            }
        });
        this.pushToken = getInputData().getString(PUSH_TOKEN);
        this.pushService = getInputData().getString(PUSH_SERVICE);
    }

    private final PushInteractor getPushInteractor() {
        return (PushInteractor) this.pushInteractor.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof ru.tattelecom.intercom.domain.workers.SendPushTokenWorker$doWork$1
            if (r0 == 0) goto L14
            r0 = r11
            ru.tattelecom.intercom.domain.workers.SendPushTokenWorker$doWork$1 r0 = (ru.tattelecom.intercom.domain.workers.SendPushTokenWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            ru.tattelecom.intercom.domain.workers.SendPushTokenWorker$doWork$1 r0 = new ru.tattelecom.intercom.domain.workers.SendPushTokenWorker$doWork$1
            r0.<init>(r10, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 == r2) goto L35
            if (r1 != r9) goto L2d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L71
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L35:
            java.lang.Object r1 = r0.L$0
            ru.tattelecom.intercom.domain.workers.SendPushTokenWorker r1 = (ru.tattelecom.intercom.domain.workers.SendPushTokenWorker) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L61
        L3d:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = r10.pushToken
            if (r11 == 0) goto L83
            java.lang.String r11 = r10.pushService
            if (r11 == 0) goto L83
            ru.tattelecom.intercom.domain.interactors.PushInteractor r1 = r10.getPushInteractor()
            java.lang.String r11 = r10.pushToken
            java.lang.String r3 = r10.pushService
            r0.L$0 = r10
            r0.label = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r11
            r5 = r0
            java.lang.Object r11 = ru.tattelecom.intercom.domain.interactors.PushInteractor.updatePushToken$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r8) goto L60
            return r8
        L60:
            r1 = r10
        L61:
            ru.tattelecom.intercom.domain.interactors.PushInteractor r11 = r1.getPushInteractor()
            r1 = 0
            r0.L$0 = r1
            r0.label = r9
            java.lang.Object r11 = r11.sendPushToken(r0)
            if (r11 != r8) goto L71
            return r8
        L71:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L83
            androidx.work.ListenableWorker$Result r11 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r0 = "success(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            return r11
        L83:
            androidx.work.ListenableWorker$Result r11 = androidx.work.ListenableWorker.Result.failure()
            java.lang.String r0 = "failure(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.workers.SendPushTokenWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
