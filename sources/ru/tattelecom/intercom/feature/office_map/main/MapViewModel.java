package ru.tattelecom.intercom.feature.office_map.main;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.maps.model.Marker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.data.remote.model.OfficeResponse;
import ru.tattelecom.intercom.data.remote.model.OfficeSchedule;
import ru.tattelecom.intercom.data.remote.model.OfficeServices;
import ru.tattelecom.intercom.domain.interactors.OfficeInteractor;
import ru.tattelecom.intercom.feature.office_map.MapHelper;

/* compiled from: MapViewModel.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020QJ\u0006\u0010S\u001a\u00020\"J\u001e\u0010T\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u0001082\f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0UH\u0002J\u0010\u0010V\u001a\u0004\u0018\u00010\r2\u0006\u0010W\u001a\u00020\"J\u0016\u0010X\u001a\u00020Q2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010Z\u001a\u00020\u0007J\u0010\u0010[\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020\rH\u0002J\u000e\u0010]\u001a\u00020Q2\u0006\u0010^\u001a\u00020\u0010J\u0006\u0010_\u001a\u00020QJ\u0010\u0010`\u001a\u00020Q2\u0006\u0010a\u001a\u00020\"H\u0002J\b\u0010b\u001a\u00020QH\u0002J\u0010\u0010c\u001a\u00020Q2\u0006\u0010d\u001a\u00020\tH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001e\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070/¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0019\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0/¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R \u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\"\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010908X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010?08X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\u001a\u0010H\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010C\"\u0004\bI\u0010ER\u001f\u0010J\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0K¢\u0006\b\n\u0000\u001a\u0004\bL\u0010MR\u001f\u0010N\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f0K¢\u0006\b\n\u0000\u001a\u0004\bO\u0010M¨\u0006e"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/main/MapViewModel;", "Landroidx/lifecycle/ViewModel;", "interactor", "Lru/tattelecom/intercom/domain/interactors/OfficeInteractor;", "(Lru/tattelecom/intercom/domain/interactors/OfficeInteractor;)V", "_eventOpenFilterPage", "Lkotlinx/coroutines/channels/Channel;", "", "_eventShowMessage", "", "_filteredOfficeList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "_officeList", "_servicesList", "Lru/tattelecom/intercom/feature/office_map/main/OfficeService;", "currentFilters", "", "getCurrentFilters", "()Ljava/util/Set;", "setCurrentFilters", "(Ljava/util/Set;)V", "currentLat", "", "getCurrentLat", "()Ljava/lang/Double;", "setCurrentLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "currentLng", "getCurrentLng", "setCurrentLng", "currentSelectedMarker", "", "getCurrentSelectedMarker", "()Ljava/lang/Integer;", "setCurrentSelectedMarker", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "currentZoom", "", "getCurrentZoom", "()F", "setCurrentZoom", "(F)V", "eventOpenFilterPage", "Lkotlinx/coroutines/flow/Flow;", "getEventOpenFilterPage", "()Lkotlinx/coroutines/flow/Flow;", "eventShowMessage", "getEventShowMessage", "filters", "getFilters", "setFilters", "googleMarkers", "", "Lcom/google/android/gms/maps/model/Marker;", "getGoogleMarkers", "()Ljava/util/List;", "setGoogleMarkers", "(Ljava/util/List;)V", "huaweiMarkers", "Lcom/huawei/hms/maps/model/Marker;", "getHuaweiMarkers", "setHuaweiMarkers", "isFirstOpen", "()Z", "setFirstOpen", "(Z)V", "isLocationPermissionGranted", "setLocationPermissionGranted", "isMapReady", "setMapReady", "officeList", "Lkotlinx/coroutines/flow/StateFlow;", "getOfficeList", "()Lkotlinx/coroutines/flow/StateFlow;", "servicesList", "getServicesList", "clearFilters", "", "fetchOfficeList", "getCurrentOfficesListCount", "getFilteredOfficeList", "", "getOfficeById", "officeId", "onFilterItemClicked", "name", "isSelected", "onOpenFilter", "office", "onServiceItemClick", "officeService", "updateFilter", "updateFirstItem", "count", "updateOfficesList", "updateServicesList", "officeServiceName", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class MapViewModel extends ViewModel {
    private final Channel<Boolean> _eventOpenFilterPage;
    private final Channel<String> _eventShowMessage;
    private final MutableStateFlow<List<OfficeResponse>> _filteredOfficeList;
    private final MutableStateFlow<List<OfficeResponse>> _officeList;
    private final MutableStateFlow<List<OfficeService>> _servicesList;
    private Set<String> currentFilters;
    private Double currentLat;
    private Double currentLng;
    private Integer currentSelectedMarker;
    private float currentZoom;
    private final Flow<Boolean> eventOpenFilterPage;
    private final Flow<String> eventShowMessage;
    private Set<String> filters;
    private List<Marker> googleMarkers;
    private List<com.huawei.hms.maps.model.Marker> huaweiMarkers;
    private final OfficeInteractor interactor;
    private boolean isFirstOpen;
    private boolean isLocationPermissionGranted;
    private boolean isMapReady;
    private final StateFlow<List<OfficeResponse>> officeList;
    private final StateFlow<List<OfficeService>> servicesList;

    public MapViewModel(OfficeInteractor interactor) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.interactor = interactor;
        this.currentZoom = 14.0f;
        this.googleMarkers = new ArrayList();
        this.huaweiMarkers = new ArrayList();
        this.isFirstOpen = true;
        this.filters = new LinkedHashSet();
        this.currentFilters = new LinkedHashSet();
        this._officeList = StateFlowKt.MutableStateFlow(null);
        MutableStateFlow<List<OfficeResponse>> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._filteredOfficeList = MutableStateFlow;
        this.officeList = MutableStateFlow;
        Channel<String> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowMessage = Channel$default;
        this.eventShowMessage = FlowKt.receiveAsFlow(Channel$default);
        MutableStateFlow<List<OfficeService>> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._servicesList = MutableStateFlow2;
        this.servicesList = MutableStateFlow2;
        Channel<Boolean> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventOpenFilterPage = Channel$default2;
        this.eventOpenFilterPage = FlowKt.receiveAsFlow(Channel$default2);
    }

    public final Double getCurrentLat() {
        return this.currentLat;
    }

    public final void setCurrentLat(Double d) {
        this.currentLat = d;
    }

    public final Double getCurrentLng() {
        return this.currentLng;
    }

    public final void setCurrentLng(Double d) {
        this.currentLng = d;
    }

    public final Integer getCurrentSelectedMarker() {
        return this.currentSelectedMarker;
    }

    public final void setCurrentSelectedMarker(Integer num) {
        this.currentSelectedMarker = num;
    }

    public final float getCurrentZoom() {
        return this.currentZoom;
    }

    public final void setCurrentZoom(float f) {
        this.currentZoom = f;
    }

    /* renamed from: isMapReady, reason: from getter */
    public final boolean getIsMapReady() {
        return this.isMapReady;
    }

    public final void setMapReady(boolean z) {
        this.isMapReady = z;
    }

    /* renamed from: isLocationPermissionGranted, reason: from getter */
    public final boolean getIsLocationPermissionGranted() {
        return this.isLocationPermissionGranted;
    }

    public final void setLocationPermissionGranted(boolean z) {
        this.isLocationPermissionGranted = z;
    }

    public final List<Marker> getGoogleMarkers() {
        return this.googleMarkers;
    }

    public final void setGoogleMarkers(List<Marker> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.googleMarkers = list;
    }

    public final List<com.huawei.hms.maps.model.Marker> getHuaweiMarkers() {
        return this.huaweiMarkers;
    }

    public final void setHuaweiMarkers(List<com.huawei.hms.maps.model.Marker> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.huaweiMarkers = list;
    }

    /* renamed from: isFirstOpen, reason: from getter */
    public final boolean getIsFirstOpen() {
        return this.isFirstOpen;
    }

    public final void setFirstOpen(boolean z) {
        this.isFirstOpen = z;
    }

    public final Set<String> getFilters() {
        return this.filters;
    }

    public final void setFilters(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.filters = set;
    }

    public final Set<String> getCurrentFilters() {
        return this.currentFilters;
    }

    public final void setCurrentFilters(Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.currentFilters = set;
    }

    public final StateFlow<List<OfficeResponse>> getOfficeList() {
        return this.officeList;
    }

    public final Flow<String> getEventShowMessage() {
        return this.eventShowMessage;
    }

    public final StateFlow<List<OfficeService>> getServicesList() {
        return this.servicesList;
    }

    public final Flow<Boolean> getEventOpenFilterPage() {
        return this.eventOpenFilterPage;
    }

    public final void fetchOfficeList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MapViewModel$fetchOfficeList$1(this, null), 3, null);
    }

    public final OfficeResponse getOfficeById(int officeId) {
        List<OfficeResponse> value = this._officeList.getValue();
        Object obj = null;
        if (value == null) {
            return null;
        }
        Iterator<T> it = value.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Integer id = ((OfficeResponse) next).getId();
            if (id != null && id.intValue() == officeId) {
                obj = next;
                break;
            }
        }
        return (OfficeResponse) obj;
    }

    public final void onServiceItemClick(OfficeService officeService) {
        Intrinsics.checkNotNullParameter(officeService, "officeService");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new MapViewModel$onServiceItemClick$1(officeService, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFirstItem(int count) {
        OfficeService officeService;
        List<OfficeService> value = this.servicesList.getValue();
        if (value == null || (officeService = value.get(0)) == null) {
            return;
        }
        OfficeService copy$default = OfficeService.copy$default(officeService, 0, null, false, count, 7, null);
        MutableStateFlow<List<OfficeService>> mutableStateFlow = this._servicesList;
        List<OfficeService> value2 = mutableStateFlow.getValue();
        mutableStateFlow.setValue(value2 != null ? ExtensionsKt.mapButReplace(value2, officeService, copy$default) : null);
    }

    public final void updateFilter() {
        Set minus;
        if (this.currentFilters.size() > this.filters.size()) {
            minus = SetsKt.minus((Set) this.currentFilters, (Iterable) this.filters);
        } else {
            minus = SetsKt.minus((Set) this.filters, (Iterable) this.currentFilters);
        }
        Iterator it = CollectionsKt.toSet(minus).iterator();
        while (it.hasNext()) {
            updateServicesList((String) it.next());
        }
        this.filters.addAll(this.currentFilters);
        this.currentFilters.clear();
        updateOfficesList();
        updateFirstItem(this.filters.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateServicesList(String officeServiceName) {
        Object obj;
        List<OfficeService> value = this._servicesList.getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.areEqual(((OfficeService) obj).getName(), officeServiceName)) {
                        break;
                    }
                }
            }
            OfficeService officeService = (OfficeService) obj;
            if (officeService != null) {
                if (officeService.isSelected()) {
                    this.filters.remove(officeService.getName());
                } else {
                    this.filters.add(officeService.getName());
                }
                OfficeService copy$default = OfficeService.copy$default(officeService, 0, null, !officeService.isSelected(), 0, 11, null);
                MutableStateFlow<List<OfficeService>> mutableStateFlow = this._servicesList;
                List<OfficeService> value2 = mutableStateFlow.getValue();
                mutableStateFlow.setValue(value2 != null ? ExtensionsKt.mapButReplace(value2, officeService, copy$default) : null);
            }
        }
    }

    public final int getCurrentOfficesListCount() {
        List<OfficeResponse> filteredOfficeList = getFilteredOfficeList(this.currentFilters);
        if (filteredOfficeList != null) {
            return filteredOfficeList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateOfficesList() {
        if (this.filters.isEmpty()) {
            this._filteredOfficeList.setValue(this._officeList.getValue());
        } else {
            this._filteredOfficeList.setValue(getFilteredOfficeList(this.filters));
        }
    }

    private final List<OfficeResponse> getFilteredOfficeList(Set<String> filters) {
        List<OfficeResponse> value = this._officeList.getValue();
        if (value == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            OfficeResponse officeResponse = (OfficeResponse) obj;
            Iterator it = CollectionsKt.toSet(filters).iterator();
            while (true) {
                if (it.hasNext()) {
                    String str = (String) it.next();
                    if (Intrinsics.areEqual(str, MapHelper.INSTANCE.getMainFilterNamesList().get(1))) {
                        if (!onOpenFilter(officeResponse)) {
                            break;
                        }
                    } else {
                        List<OfficeServices> services = officeResponse.getServices();
                        if (services != null) {
                            List<OfficeServices> list = services;
                            if (!(list instanceof Collection) || !list.isEmpty()) {
                                for (OfficeServices officeServices : list) {
                                    if (Intrinsics.areEqual(officeServices != null ? officeServices.getName() : null, str)) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    arrayList.add(obj);
                    break;
                }
            }
        }
        return CollectionsKt.toMutableList((Collection) arrayList);
    }

    private final boolean onOpenFilter(OfficeResponse office) {
        OfficeSchedule workSunday;
        Integer close;
        Integer open;
        int i = Calendar.getInstance().get(7);
        if (i == 1) {
            workSunday = office.getWorkSunday();
        } else if (i == 7) {
            workSunday = office.getWorkSaturday();
        } else {
            workSunday = office.getWorkWeekday();
        }
        int i2 = Calendar.getInstance().get(11);
        return ((workSunday == null || (open = workSunday.getOpen()) == null) ? 0 : open.intValue()) <= i2 && i2 < ((workSunday == null || (close = workSunday.getClose()) == null) ? 0 : close.intValue());
    }

    public final void onFilterItemClicked(String name, boolean isSelected) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (isSelected) {
            this.currentFilters.add(name);
        } else {
            this.currentFilters.remove(name);
        }
    }

    public final void clearFilters() {
        ArrayList arrayList;
        this.filters.clear();
        this.currentFilters.clear();
        MutableStateFlow<List<OfficeService>> mutableStateFlow = this._servicesList;
        List<OfficeService> value = mutableStateFlow.getValue();
        if (value != null) {
            List<OfficeService> list = value;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (OfficeService officeService : list) {
                if (officeService.isSelected()) {
                    officeService = OfficeService.copy$default(officeService, 0, null, false, 0, 11, null);
                }
                arrayList2.add(officeService);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        mutableStateFlow.setValue(arrayList);
        updateOfficesList();
        updateFirstItem(this.filters.size());
    }
}
