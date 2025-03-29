package ru.tattelecom.intercom.feature.trial;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.feature.trial.model.TrialEvent;

/* compiled from: TrialViewModel.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0010J\u0006\u0010$\u001a\u00020!R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lru/tattelecom/intercom/feature/trial/TrialViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "configInteractor", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/ConfigInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/trial/model/TrialEvent;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", NavArg.TrialScreen.DAYS_COUNT, "", "getDaysCount", "()I", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", TtmlNode.ATTR_ID, "getId", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "screen", "", "getScreen", "()Ljava/lang/String;", "activateTrial", "", "reportEvent", "buttonId", "setTrialEnded", "trial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class TrialViewModel extends ViewModel {
    private final Channel<TrialEvent> _events;
    private final MutableStateFlow<Boolean> _isLoading;
    private final ConfigInteractor configInteractor;
    private final int daysCount;
    private final Flow<TrialEvent> events;
    private final int id;
    private final StateFlow<Boolean> isLoading;
    private final LogInteractor logInteractor;
    private final String screen;

    public TrialViewModel(SavedStateHandle savedStateHandle, ConfigInteractor configInteractor, LogInteractor logInteractor) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(configInteractor, "configInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        this.configInteractor = configInteractor;
        this.logInteractor = logInteractor;
        Integer num = (Integer) savedStateHandle.get(NavArg.TrialScreen.TRIAL_ID);
        this.id = num != null ? num.intValue() : 0;
        String str = (String) savedStateHandle.get("screen");
        this.screen = str == null ? NavArg.TrialScreen.TRIAL_END : str;
        Integer num2 = (Integer) savedStateHandle.get(NavArg.TrialScreen.DAYS_COUNT);
        this.daysCount = num2 != null ? num2.intValue() : 0;
        Channel<TrialEvent> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final int getId() {
        return this.id;
    }

    public final String getScreen() {
        return this.screen;
    }

    public final int getDaysCount() {
        return this.daysCount;
    }

    public final Flow<TrialEvent> getEvents() {
        return this.events;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final void activateTrial() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TrialViewModel$activateTrial$1(this, null), 3, null);
    }

    public final void setTrialEnded() {
        this.configInteractor.setTrialActivated(false);
    }

    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }
}
