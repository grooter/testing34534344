package ru.tattelecom.intercom.feature.gate_widget;

import android.app.Notification;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;

/* compiled from: OpenGateWorker.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\u0017R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/OpenGateWorker;", "Lorg/koin/core/component/KoinComponent;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "interactor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "getInteractor", "()Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "interactor$delegate", "Lkotlin/Lazy;", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForegroundNotification", "Landroid/app/Notification;", "showMessage", "", "message", "", "(Ljava/lang/String;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class OpenGateWorker extends CoroutineWorker implements KoinComponent {

    /* renamed from: interactor$delegate, reason: from kotlin metadata */
    private final Lazy interactor;

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenGateWorker(Context context, WorkerParameters workerParams) {
        super(context, workerParams);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        final OpenGateWorker openGateWorker = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.interactor = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<GateInteractor>() { // from class: ru.tattelecom.intercom.feature.gate_widget.OpenGateWorker$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.GateInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final GateInteractor invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), qualifier2, function0);
            }
        });
    }

    private final GateInteractor getInteractor() {
        return (GateInteractor) this.interactor.getValue();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(4:5|6|7|8))|68|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0060, code lost:
    
        r10 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ff A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r10) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.gate_widget.OpenGateWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Notification getForegroundNotification() {
        Context applicationContext = getApplicationContext();
        Notification build = new NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.open_gate_notification_channel_id)).setPriority(-1).setContentTitle(applicationContext.getString(R.string.gate_opening)).setContentText(applicationContext.getString(R.string.please_wait)).setSmallIcon(R.drawable.ic_statusbar_icon).build();
        Intrinsics.checkNotNullExpressionValue(build, "with(...)");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object showMessage(String str, Context context, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new OpenGateWorker$showMessage$2(context, str, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
