package ru.tattelecom.intercom.feature.leave_order;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServices;
import ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.leave_order.Event;

/* compiled from: LeaveOrderViewModel.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010#\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0012H\u0002J\u0017\u0010;\u001a\u00020\u00122\b\u0010<\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u00162\u0006\u0010A\u001a\u00020\u0010J\u0006\u0010B\u001a\u00020?J\u000e\u0010C\u001a\u00020?2\u0006\u0010D\u001a\u00020\u0012J\u000e\u0010E\u001a\u00020?2\u0006\u0010D\u001a\u00020\u0012J(\u0010F\u001a\u00020?2\u0006\u0010G\u001a\u00020\u00192\u0018\b\u0002\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010J\u0018\u00010IR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100#¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00100(¢\u0006\b\n\u0000\u001a\u0004\b'\u0010)R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120(¢\u0006\b\n\u0000\u001a\u0004\b+\u0010)R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120(¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010/\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b0\u0010\u001bR\u0015\u00101\u001a\u0004\u0018\u00010\u0019¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b2\u0010\u001bR\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\u001604¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001f\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150(¢\u0006\b\n\u0000\u001a\u0004\b8\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lru/tattelecom/intercom/feature/leave_order/LeaveOrderViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "authInteractor", "Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/UserInteractor;Lru/tattelecom/intercom/domain/interactors/AuthInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/leave_order/Event;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_name", "", "_phone", "_selectedServicesList", "", "Lru/tattelecom/intercom/feature/leave_order/Service;", "_servicesList", NavArg.Activity.CONTAINER_ID, "", "getContainerId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", NavArg.ENTITY_ID, "", "getEntityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "isLeaveOrderAllowed", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "name", "getName", "phone", "getPhone", "preselectedServices", "previousPage", "getPreviousPage", NavArg.REPORT_EVENT_ID, "getReportEventId", NavArg.SELECTED_SERVICES, "", "getSelectedServices", "()Ljava/util/Set;", "servicesList", "getServicesList", "formatPhone", "number", "getEntityScreenString", "prevPage", "(Ljava/lang/Integer;)Ljava/lang/String;", "onChipClicked", "", "chip", "isChecked", "onLeaveOrder", "onNameChanged", "value", "onPhoneChanged", "reportEvent", "buttonId", "params", "", "", "feature-leave-order_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LeaveOrderViewModel extends ViewModel {
    private final Channel<Event> _events;
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<String> _name;
    private final MutableStateFlow<String> _phone;
    private final MutableStateFlow<List<Service>> _selectedServicesList;
    private final MutableStateFlow<List<Service>> _servicesList;
    private final Integer containerId;
    private final Long entityId;
    private final Flow<Event> events;
    private final Flow<Boolean> isLeaveOrderAllowed;
    private final StateFlow<Boolean> isLoading;
    private final LogInteractor logInteractor;
    private final StateFlow<String> name;
    private final StateFlow<String> phone;
    private final List<Integer> preselectedServices;
    private final Integer previousPage;
    private final Integer reportEventId;
    private final Set<Service> selectedServices;
    private final StateFlow<List<Service>> servicesList;
    private final UserInteractor userInteractor;

    public LeaveOrderViewModel(SavedStateHandle handle, UserInteractor userInteractor, AuthInteractor authInteractor, LogInteractor logInteractor) {
        String drop;
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(authInteractor, "authInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        this.userInteractor = userInteractor;
        this.logInteractor = logInteractor;
        this.previousPage = (Integer) handle.get("previousPage");
        this.containerId = (Integer) handle.get(NavArg.Activity.CONTAINER_ID);
        this.entityId = (Long) handle.get(NavArg.ENTITY_ID);
        this.reportEventId = (Integer) handle.get(NavArg.REPORT_EVENT_ID);
        this.preselectedServices = (List) handle.get(NavArg.SELECTED_SERVICES);
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._name = MutableStateFlow;
        this.name = MutableStateFlow;
        String phone = authInteractor.getPhone();
        MutableStateFlow<String> MutableStateFlow2 = StateFlowKt.MutableStateFlow(formatPhone((phone == null || (drop = StringsKt.drop(phone, 2)) == null) ? "" : drop));
        this._phone = MutableStateFlow2;
        this.phone = MutableStateFlow2;
        MutableStateFlow<List<Service>> MutableStateFlow3 = StateFlowKt.MutableStateFlow(null);
        this._servicesList = MutableStateFlow3;
        this.servicesList = MutableStateFlow3;
        MutableStateFlow<List<Service>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._selectedServicesList = MutableStateFlow4;
        this.selectedServices = new LinkedHashSet();
        MutableStateFlow<Boolean> MutableStateFlow5 = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow5;
        this.isLoading = MutableStateFlow5;
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        this.isLeaveOrderAllowed = FlowKt.combine(MutableStateFlow2, MutableStateFlow, MutableStateFlow4, new LeaveOrderViewModel$isLeaveOrderAllowed$1(null));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final Integer getPreviousPage() {
        return this.previousPage;
    }

    public final Integer getContainerId() {
        return this.containerId;
    }

    public final Long getEntityId() {
        return this.entityId;
    }

    public final Integer getReportEventId() {
        return this.reportEventId;
    }

    public final StateFlow<String> getName() {
        return this.name;
    }

    public final StateFlow<String> getPhone() {
        return this.phone;
    }

    public final StateFlow<List<Service>> getServicesList() {
        return this.servicesList;
    }

    public final Set<Service> getSelectedServices() {
        return this.selectedServices;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    public final Flow<Boolean> isLeaveOrderAllowed() {
        return this.isLeaveOrderAllowed;
    }

    /* compiled from: LeaveOrderViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderViewModel$1", f = "LeaveOrderViewModel.kt", i = {}, l = {69, 93}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.leave_order.LeaveOrderViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LeaveOrderViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            Service service;
            Object obj2;
            String name;
            String name2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (Exception unused) {
                this.label = 2;
                if (LeaveOrderViewModel.this._events.send(new Event.ShowMessage("something_went_wrong"), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UserInteractor userInteractor = LeaveOrderViewModel.this.userInteractor;
                LeaveOrderViewModel leaveOrderViewModel = LeaveOrderViewModel.this;
                this.label = 1;
                obj = userInteractor.getLeaveOrderServicesList(leaveOrderViewModel.getEntityScreenString(leaveOrderViewModel.getPreviousPage()), LeaveOrderViewModel.this.getEntityId(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            LeaveOrderServicesResponse leaveOrderServicesResponse = (LeaveOrderServicesResponse) obj;
            List<LeaveOrderServices> services = leaveOrderServicesResponse != null ? leaveOrderServicesResponse.getServices() : null;
            if (services != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : services) {
                    LeaveOrderServices leaveOrderServices = (LeaveOrderServices) obj3;
                    if (leaveOrderServices.getId() != null && (name2 = leaveOrderServices.getName()) != null && name2.length() != 0) {
                        arrayList2.add(obj3);
                    }
                }
                ArrayList<LeaveOrderServices> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (LeaveOrderServices leaveOrderServices2 : arrayList3) {
                    Integer id = leaveOrderServices2.getId();
                    Intrinsics.checkNotNull(id);
                    arrayList4.add(new Service(id.intValue(), leaveOrderServices2.getName()));
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            ArrayList arrayList5 = new ArrayList();
            if (services != null) {
                ArrayList arrayList6 = new ArrayList();
                for (Object obj4 : services) {
                    LeaveOrderServices leaveOrderServices3 = (LeaveOrderServices) obj4;
                    if (Intrinsics.areEqual(leaveOrderServices3.isSelected(), Boxing.boxBoolean(true)) && leaveOrderServices3.getId() != null && (name = leaveOrderServices3.getName()) != null && name.length() != 0) {
                        arrayList6.add(obj4);
                    }
                }
                ArrayList<LeaveOrderServices> arrayList7 = arrayList6;
                ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
                for (LeaveOrderServices leaveOrderServices4 : arrayList7) {
                    Integer id2 = leaveOrderServices4.getId();
                    Intrinsics.checkNotNull(id2);
                    arrayList8.add(new Service(id2.intValue(), leaveOrderServices4.getName()));
                }
                arrayList5.addAll(arrayList8);
            }
            List list = LeaveOrderViewModel.this.preselectedServices;
            if (list != null) {
                ArrayList arrayList9 = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            if (intValue == ((Service) obj2).getId()) {
                                break;
                            }
                        }
                        service = (Service) obj2;
                    } else {
                        service = null;
                    }
                    if (service != null) {
                        arrayList9.add(service);
                    }
                }
                arrayList5.addAll(arrayList9);
            }
            MutableStateFlow mutableStateFlow = LeaveOrderViewModel.this._selectedServicesList;
            List distinct = CollectionsKt.distinct(arrayList5);
            LeaveOrderViewModel.this.getSelectedServices().addAll(distinct);
            mutableStateFlow.setValue(distinct);
            LeaveOrderViewModel.this._servicesList.setValue(arrayList);
            return Unit.INSTANCE;
        }
    }

    public final void onNameChanged(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._name.setValue(value);
    }

    public final void onPhoneChanged(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this._phone.setValue(value);
    }

    public final void onLeaveOrder() {
        ArrayList arrayList;
        String str;
        ArrayList arrayList2;
        String value = this._name.getValue();
        String str2 = "79" + new Regex("[^0-9]").replace(this._phone.getValue(), "");
        List<Service> value2 = this._selectedServicesList.getValue();
        if (value2 != null) {
            List<Service> list = value2;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(Integer.valueOf(((Service) it.next()).getId()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        if (str2.length() <= 0 || (str = value) == null || str.length() == 0 || (arrayList2 = arrayList) == null || arrayList2.isEmpty()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new LeaveOrderViewModel$onLeaveOrder$1(this, value, str2, arrayList, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getEntityScreenString(Integer prevPage) {
        int profile = NavGraphDestinations.Dest.INSTANCE.getProfile();
        if (prevPage != null && prevPage.intValue() == profile) {
            return "profile";
        }
        int player = NavGraphDestinations.Dest.INSTANCE.getPlayer();
        if (prevPage == null || prevPage.intValue() != player) {
            int videoPlayer = NavGraphDestinations.Dest.INSTANCE.getVideoPlayer();
            if (prevPage == null || prevPage.intValue() != videoPlayer) {
                int home = NavGraphDestinations.Dest.INSTANCE.getHome();
                if (prevPage != null && prevPage.intValue() == home) {
                    return "home";
                }
                int eventLog = NavGraphDestinations.Dest.INSTANCE.getEventLog();
                if (prevPage != null && prevPage.intValue() == eventLog) {
                    return "event_history";
                }
                int homeBottomSheet = NavGraphDestinations.Dest.INSTANCE.getHomeBottomSheet();
                if (prevPage != null && prevPage.intValue() == homeBottomSheet) {
                    return EntitiesKt.ADV_BOTTOM_SHEET;
                }
                int temporaryAccess = NavGraphDestinations.Dest.INSTANCE.getTemporaryAccess();
                if (prevPage != null && prevPage.intValue() == temporaryAccess) {
                    return "temporary_access";
                }
                return (prevPage != null && prevPage.intValue() == NavGraphDestinations.Dest.INSTANCE.getTrial()) ? "trial_period" : "unknown";
            }
        }
        return "player";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void reportEvent$default(LeaveOrderViewModel leaveOrderViewModel, int i, Map map, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        leaveOrderViewModel.reportEvent(i, map);
    }

    public final void reportEvent(int buttonId, Map<String, ? extends Object> params) {
        this.logInteractor.reportEvent(buttonId, params);
    }

    private final String formatPhone(String number) {
        StringBuilder sb = new StringBuilder(number);
        int length = number.length();
        int i = 0;
        for (int i2 = 0; i2 < r2.length(); i2++) {
            if (r2.charAt(i2) == '#') {
                i++;
            }
        }
        if (length == i) {
            for (int i3 = 0; i3 < 13; i3++) {
                char charAt = "##) ###-##-##".charAt(i3);
                if (charAt != '#' && charAt != sb.charAt(i3)) {
                    sb.insert(i3, charAt);
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    public final void onChipClicked(Service chip, boolean isChecked) {
        Intrinsics.checkNotNullParameter(chip, "chip");
        if (isChecked) {
            this.selectedServices.add(chip);
        } else {
            this.selectedServices.remove(chip);
        }
        this._selectedServicesList.setValue(CollectionsKt.toList(this.selectedServices));
    }
}
