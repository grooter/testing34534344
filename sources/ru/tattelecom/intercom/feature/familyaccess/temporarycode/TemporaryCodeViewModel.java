package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.data.helper.ApartmentServiceName;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity;
import ru.tattelecom.intercom.domain.interactors.AddressInteractor;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;

/* compiled from: TemporaryCodeViewModel.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fJ\u000e\u0010*\u001a\u00020(2\u0006\u0010)\u001a\u00020\fJ\u0016\u0010+\u001a\u00020(2\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\nJ\u000e\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020\fJ\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0010H\u0002J\u001f\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u00010\u00102\b\u00102\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u00103J\u0012\u00104\u001a\u00020\u0015*\b\u0012\u0004\u0012\u0002050\u000bH\u0002J\u0018\u00106\u001a\b\u0012\u0004\u0012\u00020\f0\u000b*\b\u0012\u0004\u0012\u0002070\u000bH\u0002R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R'\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00150%¢\u0006\b\n\u0000\u001a\u0004\b$\u0010&R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "addressInteractor", "Lru/tattelecom/intercom/domain/interactors/AddressInteractor;", "familyAccessInteractor", "Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "(Lru/tattelecom/intercom/domain/interactors/AddressInteractor;Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;)V", "_apartmentsTemporaryCode", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeItem;", "_eventShareCode", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlin/Pair;", "", "", "_eventShowErrorDialog", "Lkotlinx/coroutines/channels/Channel;", "_eventShowSnack", "", "_isRefreshing", "apartmentsTemporaryCode", "getApartmentsTemporaryCode", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "eventShareCode", "Lkotlinx/coroutines/flow/SharedFlow;", "getEventShareCode", "()Lkotlinx/coroutines/flow/SharedFlow;", "eventShowErrorDialog", "Lkotlinx/coroutines/flow/Flow;", "getEventShowErrorDialog", "()Lkotlinx/coroutines/flow/Flow;", "eventShowSnack", "getEventShowSnack", "isRefreshing", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "deleteCode", "", "apartment", "generateCode", "onRefreshTemporaryCodes", "loading", "regenerateCode", "reportEvent", "buttonId", "shareCode", "temporaryCode", "buildingInfo", "(Ljava/lang/Integer;Ljava/lang/String;)V", "toTemporaryCodeAvailable", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "toTemporaryCodeList", "Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TemporaryCodeViewModel extends ViewModel {
    private final MutableStateFlow<List<TemporaryCodeItem>> _apartmentsTemporaryCode;
    private final MutableSharedFlow<Pair<Integer, String>> _eventShareCode;
    private final Channel<String> _eventShowErrorDialog;
    private final Channel<Boolean> _eventShowSnack;
    private final MutableStateFlow<Boolean> _isRefreshing;
    private final AddressInteractor addressInteractor;
    private final MutableStateFlow<List<TemporaryCodeItem>> apartmentsTemporaryCode;
    private final SharedFlow<Pair<Integer, String>> eventShareCode;
    private final Flow<String> eventShowErrorDialog;
    private final Flow<Boolean> eventShowSnack;
    private final FamilyAccessInteractor familyAccessInteractor;
    private final StateFlow<Boolean> isRefreshing;
    private final LogInteractor logInteractor;

    public TemporaryCodeViewModel(AddressInteractor addressInteractor, FamilyAccessInteractor familyAccessInteractor, LogInteractor logInteractor) {
        Intrinsics.checkNotNullParameter(addressInteractor, "addressInteractor");
        Intrinsics.checkNotNullParameter(familyAccessInteractor, "familyAccessInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        this.addressInteractor = addressInteractor;
        this.familyAccessInteractor = familyAccessInteractor;
        this.logInteractor = logInteractor;
        MutableStateFlow<List<TemporaryCodeItem>> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._apartmentsTemporaryCode = MutableStateFlow;
        this.apartmentsTemporaryCode = MutableStateFlow;
        MutableSharedFlow<Pair<Integer, String>> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._eventShareCode = MutableSharedFlow$default;
        this.eventShareCode = MutableSharedFlow$default;
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._isRefreshing = MutableStateFlow2;
        this.isRefreshing = MutableStateFlow2;
        Channel<String> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowErrorDialog = Channel$default;
        this.eventShowErrorDialog = FlowKt.receiveAsFlow(Channel$default);
        Channel<Boolean> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventShowSnack = Channel$default2;
        this.eventShowSnack = FlowKt.receiveAsFlow(Channel$default2);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final MutableStateFlow<List<TemporaryCodeItem>> getApartmentsTemporaryCode() {
        return this.apartmentsTemporaryCode;
    }

    public final SharedFlow<Pair<Integer, String>> getEventShareCode() {
        return this.eventShareCode;
    }

    public final StateFlow<Boolean> isRefreshing() {
        return this.isRefreshing;
    }

    public final Flow<String> getEventShowErrorDialog() {
        return this.eventShowErrorDialog;
    }

    public final Flow<Boolean> getEventShowSnack() {
        return this.eventShowSnack;
    }

    /* compiled from: TemporaryCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$1", f = "TemporaryCodeViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TemporaryCodeViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MutableStateFlow mutableStateFlow2 = TemporaryCodeViewModel.this._apartmentsTemporaryCode;
                this.L$0 = mutableStateFlow2;
                this.label = 1;
                Object apartmentTemporaryCodes = TemporaryCodeViewModel.this.familyAccessInteractor.getApartmentTemporaryCodes(this);
                if (apartmentTemporaryCodes == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableStateFlow = mutableStateFlow2;
                obj = apartmentTemporaryCodes;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutableStateFlow = (MutableStateFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            List list = (List) obj;
            mutableStateFlow.setValue(list != null ? TemporaryCodeViewModel.this.toTemporaryCodeList(list) : null);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void onRefreshTemporaryCodes$default(TemporaryCodeViewModel temporaryCodeViewModel, MutableStateFlow mutableStateFlow, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableStateFlow = temporaryCodeViewModel._isRefreshing;
        }
        temporaryCodeViewModel.onRefreshTemporaryCodes(mutableStateFlow);
    }

    public final void onRefreshTemporaryCodes(MutableStateFlow<Boolean> loading) {
        Intrinsics.checkNotNullParameter(loading, "loading");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TemporaryCodeViewModel$onRefreshTemporaryCodes$1(loading, this, null), 3, null);
    }

    public final void deleteCode(TemporaryCodeItem apartment) {
        Intrinsics.checkNotNullParameter(apartment, "apartment");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TemporaryCodeViewModel$deleteCode$1(this, apartment, null), 3, null);
    }

    public final void regenerateCode(TemporaryCodeItem apartment) {
        Intrinsics.checkNotNullParameter(apartment, "apartment");
        generateCode(apartment);
    }

    public final void generateCode(TemporaryCodeItem apartment) {
        Intrinsics.checkNotNullParameter(apartment, "apartment");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TemporaryCodeViewModel$generateCode$1(this, apartment, null), 3, null);
    }

    public final void shareCode(Integer temporaryCode, String buildingInfo) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new TemporaryCodeViewModel$shareCode$1(this, temporaryCode, buildingInfo, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<TemporaryCodeItem> toTemporaryCodeList(List<ApartmentTemporaryCodeEntity> list) {
        List<ApartmentTemporaryCodeEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ApartmentTemporaryCodeEntity apartmentTemporaryCodeEntity : list2) {
            arrayList.add(new TemporaryCodeItem(apartmentTemporaryCodeEntity.getApartmentId(), apartmentTemporaryCodeEntity.getAddress(), apartmentTemporaryCodeEntity.getTemporaryCode(), false));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean toTemporaryCodeAvailable(List<ApartmentServicesEntity> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ApartmentServicesEntity apartmentServicesEntity = (ApartmentServicesEntity) obj;
            if (Intrinsics.areEqual(apartmentServicesEntity.getName(), ApartmentServiceName.TEMPORARY_CODE) && Intrinsics.areEqual((Object) apartmentServicesEntity.getActive(), (Object) true)) {
                break;
            }
        }
        return obj != null;
    }
}
