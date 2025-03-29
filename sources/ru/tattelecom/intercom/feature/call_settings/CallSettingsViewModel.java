package ru.tattelecom.intercom.feature.call_settings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
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
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: CallSettingsViewModel.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rJ\u000e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\tR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0018R\u0019\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lru/tattelecom/intercom/feature/call_settings/CallSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "intercomInteractor", "Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "(Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;Lru/tattelecom/intercom/domain/interactors/UserInteractor;)V", "_eventReturnOldRingtone", "Lkotlinx/coroutines/channels/Channel;", "", "_eventShowMessage", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "eventReturnOldRingtone", "Lkotlinx/coroutines/flow/Flow;", "getEventReturnOldRingtone", "()Lkotlinx/coroutines/flow/Flow;", "eventShowMessage", "getEventShowMessage", "isDoNotDisturbEnabled", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedRingtonePath", "getSelectedRingtonePath", "onDoNotDisturbClick", "", "isEnabled", "onError", "text", "onRingtoneSelectDenied", "onRingtoneSelected", "path", "feature-call-settings_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallSettingsViewModel extends ViewModel {
    private final Channel<String> _eventReturnOldRingtone;
    private final Channel<String> _eventShowMessage;
    private final MutableStateFlow<Boolean> _isLoading;
    private final Flow<String> eventReturnOldRingtone;
    private final Flow<String> eventShowMessage;
    private final IntercomInteractor intercomInteractor;
    private final MutableStateFlow<Boolean> isDoNotDisturbEnabled;
    private final StateFlow<Boolean> isLoading;
    private final MutableStateFlow<String> selectedRingtonePath;
    private final UserInteractor userInteractor;

    public CallSettingsViewModel(IntercomInteractor intercomInteractor, UserInteractor userInteractor) {
        Intrinsics.checkNotNullParameter(intercomInteractor, "intercomInteractor");
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        this.intercomInteractor = intercomInteractor;
        this.userInteractor = userInteractor;
        this.isDoNotDisturbEnabled = intercomInteractor.isDoNotDisturbEnabled();
        this.selectedRingtonePath = userInteractor.getSelectedRingtonePath();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
        Channel<String> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowMessage = Channel$default;
        this.eventShowMessage = FlowKt.receiveAsFlow(Channel$default);
        Channel<String> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventReturnOldRingtone = Channel$default2;
        this.eventReturnOldRingtone = FlowKt.receiveAsFlow(Channel$default2);
    }

    public final MutableStateFlow<Boolean> isDoNotDisturbEnabled() {
        return this.isDoNotDisturbEnabled;
    }

    public final MutableStateFlow<String> getSelectedRingtonePath() {
        return this.selectedRingtonePath;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final Flow<String> getEventShowMessage() {
        return this.eventShowMessage;
    }

    public final Flow<String> getEventReturnOldRingtone() {
        return this.eventReturnOldRingtone;
    }

    public final void onDoNotDisturbClick(boolean isEnabled) {
        if (this._isLoading.getValue().booleanValue()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallSettingsViewModel$onDoNotDisturbClick$1(this, isEnabled, null), 3, null);
    }

    public final void onRingtoneSelected(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.userInteractor.setRingtone(path);
    }

    public final void onRingtoneSelectDenied() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallSettingsViewModel$onRingtoneSelectDenied$1(this, null), 3, null);
    }

    public final void onError(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallSettingsViewModel$onError$1(this, text, null), 3, null);
    }
}
