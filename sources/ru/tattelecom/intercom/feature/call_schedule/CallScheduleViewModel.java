package ru.tattelecom.intercom.feature.call_schedule;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.IntercomInteractor;

/* compiled from: CallScheduleViewModel.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J+\u0010)\u001a\u00020*2\u001c\u0010+\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0-\u0012\u0006\u0012\u0004\u0018\u00010.0,H\u0002¢\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020\nJ\u0006\u00103\u001a\u00020*J\u0006\u00104\u001a\u00020*J\u0016\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0014J-\u00108\u001a\n 9*\u0004\u0018\u00010\u00140\u00142\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010<R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010$R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R%\u0010'\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00130\u0016¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0018¨\u0006="}, d2 = {"Lru/tattelecom/intercom/feature/call_schedule/CallScheduleViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "interactor", "Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/IntercomInteractor;)V", "_days", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "_eventCloseDialog", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_eventShowMessage", "", "_isLoading", "_scheduleId", "", "_time", "Lkotlin/Pair;", "Ljava/util/Calendar;", "days", "Lkotlinx/coroutines/flow/StateFlow;", "getDays", "()Lkotlinx/coroutines/flow/StateFlow;", "eventCloseDialog", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventCloseDialog", "()Lkotlinx/coroutines/flow/SharedFlow;", "eventShowMessage", "getEventShowMessage", NavArg.INTERCOM_ID, "Ljava/lang/Integer;", "isLoading", "isSaveScheduleAllowed", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "scheduleId", "getScheduleId", CrashHianalyticsData.TIME, "getTime", "launch", "", "function", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "onDayChanged", "position", "selected", "onReset", "onSave", "onTimeChanged", TtmlNode.START, "finish", "provideTime", "kotlin.jvm.PlatformType", "hour", "minute", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/util/Calendar;", "feature-call-schedule_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CallScheduleViewModel extends ViewModel {
    private final MutableStateFlow<Boolean[]> _days;
    private final MutableSharedFlow<Boolean> _eventCloseDialog;
    private final MutableSharedFlow<String> _eventShowMessage;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<Integer> _scheduleId;
    private final MutableStateFlow<Pair<Calendar, Calendar>> _time;
    private final StateFlow<Boolean[]> days;
    private final SharedFlow<Boolean> eventCloseDialog;
    private final SharedFlow<String> eventShowMessage;
    private final IntercomInteractor interactor;
    private final Integer intercomId;
    private final StateFlow<Boolean> isLoading;
    private final Flow<Boolean> isSaveScheduleAllowed;
    private final StateFlow<Integer> scheduleId;
    private final StateFlow<Pair<Calendar, Calendar>> time;

    public CallScheduleViewModel(SavedStateHandle handle, IntercomInteractor interactor) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.interactor = interactor;
        Integer num = (Integer) handle.get(NavArg.INTERCOM_ID);
        this.intercomId = num;
        if (num != null) {
            num.intValue();
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallScheduleViewModel$1$1(this, null), 3, null);
        }
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._scheduleId = MutableStateFlow;
        this.scheduleId = MutableStateFlow;
        MutableStateFlow<Pair<Calendar, Calendar>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(TuplesKt.to(provideTime$default(this, null, null, 3, null), provideTime$default(this, null, null, 3, null)));
        this._time = MutableStateFlow2;
        this.time = MutableStateFlow2;
        MutableStateFlow<Boolean[]> MutableStateFlow3 = StateFlowKt.MutableStateFlow(new Boolean[]{false, false, false, false, false, false, false});
        this._days = MutableStateFlow3;
        this.days = MutableStateFlow3;
        MutableStateFlow<Boolean> MutableStateFlow4 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow4;
        this.isLoading = MutableStateFlow4;
        MutableSharedFlow<Boolean> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventCloseDialog = MutableSharedFlow$default;
        this.eventCloseDialog = FlowKt.asSharedFlow(MutableSharedFlow$default);
        MutableSharedFlow<String> MutableSharedFlow$default2 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventShowMessage = MutableSharedFlow$default2;
        this.eventShowMessage = FlowKt.asSharedFlow(MutableSharedFlow$default2);
        this.isSaveScheduleAllowed = FlowKt.flowCombine(MutableStateFlow2, MutableStateFlow3, new CallScheduleViewModel$isSaveScheduleAllowed$1(null));
    }

    public final StateFlow<Integer> getScheduleId() {
        return this.scheduleId;
    }

    public final StateFlow<Pair<Calendar, Calendar>> getTime() {
        return this.time;
    }

    public final StateFlow<Boolean[]> getDays() {
        return this.days;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final SharedFlow<Boolean> getEventCloseDialog() {
        return this.eventCloseDialog;
    }

    public final SharedFlow<String> getEventShowMessage() {
        return this.eventShowMessage;
    }

    public final Flow<Boolean> isSaveScheduleAllowed() {
        return this.isSaveScheduleAllowed;
    }

    public final void onTimeChanged(Calendar start, Calendar finish) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(finish, "finish");
        MutableStateFlow<Pair<Calendar, Calendar>> mutableStateFlow = this._time;
        mutableStateFlow.setValue(null);
        mutableStateFlow.setValue(TuplesKt.to(start, finish));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDayChanged(int position, boolean selected) {
        MutableStateFlow<Boolean[]> mutableStateFlow = this._days;
        Object clone = ((Object[]) mutableStateFlow.getValue()).clone();
        ((Boolean[]) clone)[position] = Boolean.valueOf(selected);
        mutableStateFlow.setValue(clone);
    }

    public final void onSave() {
        Pair<Calendar, Calendar> value = this._time.getValue();
        Calendar first = value != null ? value.getFirst() : null;
        Pair<Calendar, Calendar> value2 = this._time.getValue();
        Calendar second = value2 != null ? value2.getSecond() : null;
        Boolean[] value3 = this._days.getValue();
        if (this.intercomId == null || first == null || second == null || !ArraysKt.contains((boolean[]) value3, true)) {
            return;
        }
        launch(new CallScheduleViewModel$onSave$1(this, first, second, value3, null));
    }

    public final void onReset() {
        Integer value = this.scheduleId.getValue();
        if (value != null) {
            launch(new CallScheduleViewModel$onReset$1$1(this, value.intValue(), null));
        }
    }

    private final void launch(Function1<? super Continuation<? super Unit>, ? extends Object> function) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new CallScheduleViewModel$launch$1(this, function, null), 3, null);
    }

    static /* synthetic */ Calendar provideTime$default(CallScheduleViewModel callScheduleViewModel, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return callScheduleViewModel.provideTime(num, num2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Calendar provideTime(Integer hour, Integer minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, hour != null ? hour.intValue() : 0);
        calendar.set(12, minute != null ? minute.intValue() : 0);
        return calendar;
    }
}
