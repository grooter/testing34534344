package ru.tattelecom.intercom.feature.call;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.huawei.hms.support.api.entity.core.CommonCode;
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
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: Receivers.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/call/RebootReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/component/KoinComponent;", "()V", "prefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "getPrefsSource", "()Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "prefsSource$delegate", "Lkotlin/Lazy;", "onReceive", "", "context", "Landroid/content/Context;", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RebootReceiver extends BroadcastReceiver implements KoinComponent {

    /* renamed from: prefsSource$delegate, reason: from kotlin metadata */
    private final Lazy prefsSource;

    public RebootReceiver() {
        final RebootReceiver rebootReceiver = this;
        LazyThreadSafetyMode defaultLazyMode = KoinPlatformTools.INSTANCE.defaultLazyMode();
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.prefsSource = LazyKt.lazy(defaultLazyMode, (Function0) new Function0<UserPrefsSource>() { // from class: ru.tattelecom.intercom.feature.call.RebootReceiver$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, ru.tattelecom.intercom.data.prefs.UserPrefsSource] */
            @Override // kotlin.jvm.functions.Function0
            public final UserPrefsSource invoke() {
                Scope rootScope;
                KoinComponent koinComponent = KoinComponent.this;
                Qualifier qualifier2 = qualifier;
                Function0<? extends ParametersHolder> function0 = b;
                if (koinComponent instanceof KoinScopeComponent) {
                    rootScope = ((KoinScopeComponent) koinComponent).getScope();
                } else {
                    rootScope = koinComponent.getKoin().getScopeRegistry().getRootScope();
                }
                return rootScope.get(Reflection.getOrCreateKotlinClass(UserPrefsSource.class), qualifier2, function0);
            }
        });
    }

    @Override // org.koin.core.component.KoinComponent
    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    private final UserPrefsSource getPrefsSource() {
        return (UserPrefsSource) this.prefsSource.getValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.BOOT_COMPLETED") && getPrefsSource().getWorkInBackgroundEnabled() && getPrefsSource().getToken() != null) {
            ContextCompat.startForegroundService(context, new Intent(context, (Class<?>) CallService.class));
        }
    }
}
