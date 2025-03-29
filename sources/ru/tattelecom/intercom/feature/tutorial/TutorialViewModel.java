package ru.tattelecom.intercom.feature.tutorial;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
import ru.tattelecom.intercom.data.prefs.Tip;
import ru.tattelecom.intercom.data.prefs.TutorialPrefsSource;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;

/* compiled from: TutorialViewModel.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u001eJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u000bJ\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018*\b\u0012\u0004\u0012\u00020%0\u0018H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/feature/tutorial/TutorialViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "prefs", "Lru/tattelecom/intercom/data/prefs/TutorialPrefsSource;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/data/prefs/TutorialPrefsSource;)V", "_currentTipPosition", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_eventCloseScreen", "Lkotlinx/coroutines/channels/Channel;", "", "currentTipPosition", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentTipPosition", "()Lkotlinx/coroutines/flow/StateFlow;", "eventCloseScreen", "Lkotlinx/coroutines/flow/Flow;", "getEventCloseScreen", "()Lkotlinx/coroutines/flow/Flow;", "tips", "", "Lru/tattelecom/intercom/feature/tutorial/TipDto;", "getTips", "()Ljava/util/List;", "isCurrentTipLast", "onBackPressed", "", "onTipChanged", "position", "readAllTips", "reportEvent", "eventId", "toTipDtoList", "Lru/tattelecom/intercom/data/prefs/Tip;", "feature-tutorial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TutorialViewModel extends ViewModel {
    private final MutableStateFlow<Integer> _currentTipPosition;
    private final Channel<Boolean> _eventCloseScreen;
    private final StateFlow<Integer> currentTipPosition;
    private final Flow<Boolean> eventCloseScreen;
    private final LogInteractor logInteractor;
    private final TutorialPrefsSource prefs;
    private final List<TipDto> tips;

    public TutorialViewModel(SavedStateHandle handle, LogInteractor logInteractor, TutorialPrefsSource prefs) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.logInteractor = logInteractor;
        this.prefs = prefs;
        Boolean bool = (Boolean) handle.get(NavArg.NOT_SEEN_TIPS_ONLY);
        this.tips = toTipDtoList(prefs.getTips(bool != null ? bool.booleanValue() : false));
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(0);
        this._currentTipPosition = MutableStateFlow;
        this.currentTipPosition = MutableStateFlow;
        Channel<Boolean> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventCloseScreen = Channel$default;
        this.eventCloseScreen = FlowKt.receiveAsFlow(Channel$default);
    }

    public final List<TipDto> getTips() {
        return this.tips;
    }

    private final List<TipDto> toTipDtoList(List<Tip> list) {
        int i;
        List<Tip> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        final int i2 = 0;
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Tip tip = (Tip) obj;
            String name = tip.getName();
            int imageResId = tip.getImageResId();
            if (i2 == 2) {
                i = R.string.tutorial_end;
            } else {
                i = R.string.tutorial_continue;
            }
            arrayList.add(new TipDto(name, imageResId, i, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialViewModel$toTipDtoList$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    int i4 = i2;
                    if (i4 == 2) {
                        this.reportEvent(35);
                        this.onBackPressed();
                    } else {
                        this.onTipChanged(i4 + 1);
                    }
                }
            }));
            i2 = i3;
        }
        return arrayList;
    }

    public final StateFlow<Integer> getCurrentTipPosition() {
        return this.currentTipPosition;
    }

    public final Flow<Boolean> getEventCloseScreen() {
        return this.eventCloseScreen;
    }

    public final void onTipChanged(int position) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TutorialViewModel$onTipChanged$1(this, position, null), 3, null);
        if (this._currentTipPosition.getValue().intValue() != position) {
            this._currentTipPosition.setValue(Integer.valueOf(position));
        }
    }

    public final void reportEvent(int eventId) {
        LogInteractor.reportEvent$default(this.logInteractor, eventId, null, 2, null);
    }

    public final void onBackPressed() {
        readAllTips();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TutorialViewModel$onBackPressed$1(this, null), 3, null);
    }

    public final void readAllTips() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TutorialViewModel$readAllTips$1(this, null), 3, null);
    }

    public final boolean isCurrentTipLast() {
        return this._currentTipPosition.getValue().intValue() == this.tips.size() - 1;
    }
}
