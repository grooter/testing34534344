package ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;

/* compiled from: GenerateQRCodeViewModel.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001&B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000eJ\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u000eH\u0002J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u000eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "familyAccessInteractor", "Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;", "authInteractor", "Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "(Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;Lru/tattelecom/intercom/domain/interactors/AuthInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event;", "_selectedApartmentId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", EntitiesKt.APARTMENTS_TABLE, "Landroidx/lifecycle/LiveData;", "", "Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "getApartments", "()Landroidx/lifecycle/LiveData;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "isContinueButtonAllowed", "", "remainingInvites", "selectedApartmentId", "Lkotlinx/coroutines/flow/StateFlow;", "generateQrCode", "", "isSelectedApartment", NavArg.VerifyCode.APARTMENT_ID, "reportEvent", "buttonId", "setRemainingInvites", "count", "Event", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GenerateQRCodeViewModel extends ViewModel {
    private final Channel<Event> _events;
    private final MutableStateFlow<Integer> _selectedApartmentId;
    private final LiveData<List<ApartmentGuestsEntity>> apartments;
    private final AuthInteractor authInteractor;
    private final Flow<Event> events;
    private final Flow<Boolean> isContinueButtonAllowed;
    private final LogInteractor logInteractor;
    private final MutableStateFlow<Integer> remainingInvites;
    private final StateFlow<Integer> selectedApartmentId;

    public GenerateQRCodeViewModel(FamilyAccessInteractor familyAccessInteractor, AuthInteractor authInteractor, LogInteractor logInteractor) {
        Intrinsics.checkNotNullParameter(familyAccessInteractor, "familyAccessInteractor");
        Intrinsics.checkNotNullParameter(authInteractor, "authInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        this.authInteractor = authInteractor;
        this.logInteractor = logInteractor;
        this.apartments = FlowLiveDataConversions.asLiveData$default(familyAccessInteractor.observeApartments(), ViewModelKt.getViewModelScope(this).getCoroutineContext(), 0L, 2, (Object) null);
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._selectedApartmentId = MutableStateFlow;
        MutableStateFlow<Integer> mutableStateFlow = MutableStateFlow;
        this.selectedApartmentId = mutableStateFlow;
        MutableStateFlow<Integer> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0);
        this.remainingInvites = MutableStateFlow2;
        this.isContinueButtonAllowed = FlowKt.flowCombine(mutableStateFlow, MutableStateFlow2, new GenerateQRCodeViewModel$isContinueButtonAllowed$1(null));
    }

    /* compiled from: GenerateQRCodeViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event;", "", "()V", "Navigate", "NavigateToErrorPage", "ShowMessage", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event$Navigate;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event$NavigateToErrorPage;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event$ShowMessage;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: GenerateQRCodeViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event$Navigate;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event;", NavArg.QR_CODE_DATA, "", "(Ljava/lang/String;)V", "getQrCodeData", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Navigate extends Event {
            private final String qrCodeData;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = navigate.qrCodeData;
                }
                return navigate.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getQrCodeData() {
                return this.qrCodeData;
            }

            public final Navigate copy(String qrCodeData) {
                Intrinsics.checkNotNullParameter(qrCodeData, "qrCodeData");
                return new Navigate(qrCodeData);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Navigate) && Intrinsics.areEqual(this.qrCodeData, ((Navigate) other).qrCodeData);
            }

            public int hashCode() {
                return this.qrCodeData.hashCode();
            }

            public String toString() {
                return "Navigate(qrCodeData=" + this.qrCodeData + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Navigate(String qrCodeData) {
                super(null);
                Intrinsics.checkNotNullParameter(qrCodeData, "qrCodeData");
                this.qrCodeData = qrCodeData;
            }

            public final String getQrCodeData() {
                return this.qrCodeData;
            }
        }

        private Event() {
        }

        /* compiled from: GenerateQRCodeViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event$NavigateToErrorPage;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NavigateToErrorPage extends Event {
            public static final NavigateToErrorPage INSTANCE = new NavigateToErrorPage();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigateToErrorPage)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2097276635;
            }

            public String toString() {
                return "NavigateToErrorPage";
            }

            private NavigateToErrorPage() {
                super(null);
            }
        }

        /* compiled from: GenerateQRCodeViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event$ShowMessage;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/generateqrcode/GenerateQRCodeViewModel$Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class ShowMessage extends Event {
            private final String message;

            public static /* synthetic */ ShowMessage copy$default(ShowMessage showMessage, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = showMessage.message;
                }
                return showMessage.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final ShowMessage copy(String message) {
                return new ShowMessage(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowMessage) && Intrinsics.areEqual(this.message, ((ShowMessage) other).message);
            }

            public int hashCode() {
                String str = this.message;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "ShowMessage(message=" + this.message + ")";
            }

            public ShowMessage(String str) {
                super(null);
                this.message = str;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    public final LiveData<List<ApartmentGuestsEntity>> getApartments() {
        return this.apartments;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    public final Flow<Boolean> isContinueButtonAllowed() {
        return this.isContinueButtonAllowed;
    }

    public final void setRemainingInvites(int count) {
        this.remainingInvites.setValue(Integer.valueOf(count));
    }

    public final void isSelectedApartment(int apartmentId) {
        this._selectedApartmentId.setValue(Integer.valueOf(apartmentId));
    }

    public final void generateQrCode() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new GenerateQRCodeViewModel$generateQrCode$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }
}
