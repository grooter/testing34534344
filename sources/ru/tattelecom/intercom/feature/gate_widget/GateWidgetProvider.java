package ru.tattelecom.intercom.feature.gate_widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.huawei.hms.support.api.entity.core.CommonCode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.domain.interactors.LockGateInteractor;

/* compiled from: GateWidgetProvider.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/GateWidgetProvider;", "Landroid/appwidget/AppWidgetProvider;", "()V", "onDeleted", "", "context", "Landroid/content/Context;", "appWidgetIds", "", "onReceive", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "Companion", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GateWidgetProvider extends AppWidgetProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final Lazy<GateInteractor> interactor$delegate;
    private static final Lazy<LockGateInteractor> lockGateInteractor$delegate;

    /* compiled from: GateWidgetProvider.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/GateWidgetProvider$Companion;", "Lorg/koin/core/component/KoinComponent;", "()V", "interactor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "getInteractor", "()Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "interactor$delegate", "Lkotlin/Lazy;", "lockGateInteractor", "Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "getLockGateInteractor", "()Lru/tattelecom/intercom/domain/interactors/LockGateInteractor;", "lockGateInteractor$delegate", "provideWidget", "", "context", "Landroid/content/Context;", "widgetId", "", "progressVisibility", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements KoinComponent {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // org.koin.core.component.KoinComponent
        public Koin getKoin() {
            return KoinComponent.DefaultImpls.getKoin(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final GateInteractor getInteractor() {
            return (GateInteractor) GateWidgetProvider.interactor$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final LockGateInteractor getLockGateInteractor() {
            return (LockGateInteractor) GateWidgetProvider.lockGateInteractor$delegate.getValue();
        }

        public static /* synthetic */ void provideWidget$default(Companion companion, Context context, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i2 = 8;
            }
            companion.provideWidget(context, i, i2);
        }

        public final void provideWidget(Context context, int widgetId, int progressVisibility) {
            Intrinsics.checkNotNullParameter(context, "context");
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new GateWidgetProvider$Companion$provideWidget$1(widgetId, context, progressVisibility, null), 3, null);
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        final Companion companion2 = companion;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final byte b = 0 == true ? 1 : 0;
        final byte b2 = 0 == true ? 1 : 0;
        interactor$delegate = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<GateInteractor>() { // from class: ru.tattelecom.intercom.feature.gate_widget.GateWidgetProvider$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.GateInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final GateInteractor invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = b;
                Function0<? extends ParametersHolder> function0 = b2;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(GateInteractor.class), qualifier, function0);
            }
        });
        final Companion companion3 = companion;
        LazyThreadSafetyMode defaultLazyMode2 = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final byte b3 = 0 == true ? 1 : 0;
        final byte b4 = 0 == true ? 1 : 0;
        lockGateInteractor$delegate = LazyKt.lazy(defaultLazyMode2, (Function0) new Function0<LockGateInteractor>() { // from class: ru.tattelecom.intercom.feature.gate_widget.GateWidgetProvider$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.LockGateInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final LockGateInteractor invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier = b3;
                Function0<? extends ParametersHolder> function0 = b4;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(LockGateInteractor.class), qualifier, function0);
            }
        });
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "ru.tattelecom.intercom.OPEN_GATE") || context == null) {
            return;
        }
        int intExtra = intent.getIntExtra("appWidgetId", 0);
        int intExtra2 = intent.getIntExtra("gateId", 0);
        WorkManager workManager = WorkManager.getInstance(context);
        String str = "Gate with id " + intExtra2 + " opening";
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.KEEP;
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(OpenGateWorker.class);
        Data build = new Data.Builder().putInt("appWidgetId", intExtra).putInt("gateId", intExtra2).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        workManager.enqueueUniqueWork(str, existingWorkPolicy, builder.setInputData(build).build());
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        if (context == null || appWidgetIds == null) {
            return;
        }
        for (int i : appWidgetIds) {
            Companion.provideWidget$default(INSTANCE, context, i, 0, 4, null);
        }
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] appWidgetIds) {
        if (appWidgetIds != null) {
            for (int i : appWidgetIds) {
                INSTANCE.getInteractor().unbindWidgetId(i);
            }
        }
    }
}
