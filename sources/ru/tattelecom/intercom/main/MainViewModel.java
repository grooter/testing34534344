package ru.tattelecom.intercom.main;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.interactors.PushInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: MainViewModel.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "pushInteractor", "Lru/tattelecom/intercom/domain/interactors/PushInteractor;", "configInteractor", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;", "(Lru/tattelecom/intercom/domain/interactors/UserInteractor;Lru/tattelecom/intercom/domain/interactors/PushInteractor;Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;)V", MainViewModel.CONSUMED_INTENTS, "", "", "getConsumedIntents", "()Ljava/util/List;", "isSessionActive", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isWorkInForegroundEnabled", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "checkPushToken", "", "context", "Landroid/content/Context;", "isToolTipRequires", "toolTip", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;", "setToolTipSeen", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MainViewModel extends ViewModel {
    public static final String CONSUMED_INTENTS = "consumedIntents";
    private final ConfigInteractor configInteractor;
    private final List<String> consumedIntents;
    private final MutableStateFlow<Boolean> isSessionActive;
    private final Flow<Boolean> isWorkInForegroundEnabled;
    private final PushInteractor pushInteractor;

    public MainViewModel(UserInteractor userInteractor, PushInteractor pushInteractor, ConfigInteractor configInteractor) {
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(pushInteractor, "pushInteractor");
        Intrinsics.checkNotNullParameter(configInteractor, "configInteractor");
        this.pushInteractor = pushInteractor;
        this.configInteractor = configInteractor;
        this.isSessionActive = userInteractor.isSessionActive();
        this.isWorkInForegroundEnabled = userInteractor.isWorkInForegroundEnabled();
        this.consumedIntents = new ArrayList();
    }

    public final MutableStateFlow<Boolean> isSessionActive() {
        return this.isSessionActive;
    }

    public final Flow<Boolean> isWorkInForegroundEnabled() {
        return this.isWorkInForegroundEnabled;
    }

    public final List<String> getConsumedIntents() {
        return this.consumedIntents;
    }

    public final void checkPushToken(Context context) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MainViewModel$checkPushToken$1(this, context, null), 3, null);
    }

    public final void setToolTipSeen(ConfigInteractor.ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        this.configInteractor.setToolTipSeen(toolTip);
    }

    public final boolean isToolTipRequires(ConfigInteractor.ToolTips toolTip) {
        Intrinsics.checkNotNullParameter(toolTip, "toolTip");
        return this.configInteractor.isToolTipRequires(toolTip);
    }
}
