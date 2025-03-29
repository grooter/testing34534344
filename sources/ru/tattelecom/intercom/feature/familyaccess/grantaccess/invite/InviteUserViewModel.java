package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import android.os.CountDownTimer;
import android.telephony.PhoneNumberUtils;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;

/* compiled from: InviteUserViewModel.kt */
@Metadata(d1 = {"\u0000s\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r*\u0001-\u0018\u00002\u00020\u0001:\u0001>B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ\b\u00101\u001a\u000202H\u0014J\u0006\u00103\u001a\u000202J\u000e\u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u000fJ\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u000fJ\b\u00108\u001a\u000202H\u0002J\u0016\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020%2\u0006\u00107\u001a\u00020\u000fJ\u000e\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020%J\u0006\u0010=\u001a\u000202R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\rR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001a¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006?"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel;", "Landroidx/lifecycle/ViewModel;", "familyAccessInteractor", "Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;", "(Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;", EntitiesKt.APARTMENTS_TABLE, "Landroidx/lifecycle/LiveData;", "", "Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "getApartments", "()Landroidx/lifecycle/LiveData;", "cleanedNumber", "", "getCleanedNumber", "()Ljava/lang/String;", "setCleanedNumber", "(Ljava/lang/String;)V", "currentTime", "Landroidx/lifecycle/MutableLiveData;", "", "getCurrentTime", "()Landroidx/lifecycle/MutableLiveData;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "guests", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteItem;", "getGuests", "isContinueButtonAllowed", "", "phoneNumber", "Lkotlinx/coroutines/flow/MutableStateFlow;", "remainingInvites", "", "selectedApartmentId", "getSelectedApartmentId", "()Ljava/lang/Integer;", "setSelectedApartmentId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "timer", "ru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$timer$1", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$timer$1;", "cleanContactNumber", "number", "onCleared", "", "onContinueClicked", "onError", "message", "onPhoneUpdate", "phone", "onRefreshGuestList", "onRemoveGuest", NavArg.VerifyCode.APARTMENT_ID, "setRemainingInvites", "count", "startTimer", "Event", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InviteUserViewModel extends ViewModel {
    private final Channel<Event> _events;
    private final LiveData<List<ApartmentGuestsEntity>> apartments;
    private String cleanedNumber;
    private final MutableLiveData<Long> currentTime;
    private final Flow<Event> events;
    private final FamilyAccessInteractor familyAccessInteractor;
    private final LiveData<List<InviteItem>> guests;
    private final Flow<Boolean> isContinueButtonAllowed;
    private final MutableStateFlow<String> phoneNumber;
    private final MutableStateFlow<Integer> remainingInvites;
    private Integer selectedApartmentId;
    private final InviteUserViewModel$timer$1 timer;

    /* JADX WARN: Type inference failed for: r8v15, types: [ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$timer$1] */
    public InviteUserViewModel(FamilyAccessInteractor familyAccessInteractor) {
        Intrinsics.checkNotNullParameter(familyAccessInteractor, "familyAccessInteractor");
        this.familyAccessInteractor = familyAccessInteractor;
        LiveData<List<ApartmentGuestsEntity>> asLiveData$default = FlowLiveDataConversions.asLiveData$default(familyAccessInteractor.observeApartments(), ViewModelKt.getViewModelScope(this).getCoroutineContext(), 0L, 2, (Object) null);
        this.apartments = asLiveData$default;
        this.guests = Transformations.map(asLiveData$default, new Function1<List<ApartmentGuestsEntity>, List<InviteItem>>() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$guests$1
            @Override // kotlin.jvm.functions.Function1
            public final List<InviteItem> invoke(List<ApartmentGuestsEntity> list) {
                List plus;
                if (list == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (ApartmentGuestsEntity apartmentGuestsEntity : list) {
                    if (apartmentGuestsEntity.getGuestPhones().isEmpty()) {
                        plus = CollectionsKt.emptyList();
                    } else {
                        List listOf = CollectionsKt.listOf(new ApartmentItem(apartmentGuestsEntity.getId(), apartmentGuestsEntity.getAddress()));
                        List<String> guestPhones = apartmentGuestsEntity.getGuestPhones();
                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(guestPhones, 10));
                        Iterator<T> it = guestPhones.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new GuestItem(apartmentGuestsEntity.getId(), (String) it.next(), apartmentGuestsEntity.isMaster()));
                        }
                        plus = CollectionsKt.plus((Collection) listOf, (Iterable) arrayList2);
                    }
                    CollectionsKt.addAll(arrayList, plus);
                }
                return arrayList;
            }
        });
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        this.currentTime = new MutableLiveData<>();
        this.cleanedNumber = "";
        MutableStateFlow<String> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.phoneNumber = MutableStateFlow;
        MutableStateFlow<Integer> MutableStateFlow2 = StateFlowKt.MutableStateFlow(0);
        this.remainingInvites = MutableStateFlow2;
        this.isContinueButtonAllowed = FlowKt.flowCombine(MutableStateFlow, MutableStateFlow2, new InviteUserViewModel$isContinueButtonAllowed$1(null));
        this.timer = new CountDownTimer() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$timer$1
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                InviteUserViewModel.this.getCurrentTime().setValue(Long.valueOf(millisUntilFinished / 1000));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                InviteUserViewModel.this.getCurrentTime().setValue(0L);
            }
        };
        onRefreshGuestList();
    }

    /* compiled from: InviteUserViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;", "", "()V", "NavigateToCodeVerification", "NavigateToErrorPage", "ShowMessage", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event$NavigateToCodeVerification;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event$NavigateToErrorPage;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event$ShowMessage;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: InviteUserViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event$NavigateToErrorPage;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
                return -1230895814;
            }

            public String toString() {
                return "NavigateToErrorPage";
            }

            private NavigateToErrorPage() {
                super(null);
            }
        }

        private Event() {
        }

        /* compiled from: InviteUserViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event$NavigateToCodeVerification;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NavigateToCodeVerification extends Event {
            public static final NavigateToCodeVerification INSTANCE = new NavigateToCodeVerification();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigateToCodeVerification)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -342379835;
            }

            public String toString() {
                return "NavigateToCodeVerification";
            }

            private NavigateToCodeVerification() {
                super(null);
            }
        }

        /* compiled from: InviteUserViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event$ShowMessage;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final LiveData<List<InviteItem>> getGuests() {
        return this.guests;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    public final MutableLiveData<Long> getCurrentTime() {
        return this.currentTime;
    }

    public final Integer getSelectedApartmentId() {
        return this.selectedApartmentId;
    }

    public final void setSelectedApartmentId(Integer num) {
        this.selectedApartmentId = num;
    }

    public final String getCleanedNumber() {
        return this.cleanedNumber;
    }

    public final void setCleanedNumber(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cleanedNumber = str;
    }

    public final Flow<Boolean> isContinueButtonAllowed() {
        return this.isContinueButtonAllowed;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        cancel();
    }

    private final void onRefreshGuestList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InviteUserViewModel$onRefreshGuestList$1(this, null), 3, null);
    }

    public final void onContinueClicked() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InviteUserViewModel$onContinueClicked$1(this, null), 3, null);
    }

    public final String cleanContactNumber(String number) {
        Intrinsics.checkNotNullParameter(number, "number");
        StringBuilder sb = new StringBuilder(new Regex("[^0-9]").replace(number, ""));
        if (sb.charAt(0) == '7' || sb.charAt(0) == '8') {
            sb.deleteCharAt(0);
        }
        String formatNumber = PhoneNumberUtils.formatNumber(sb.toString(), "RU");
        Intrinsics.checkNotNullExpressionValue(formatNumber, "formatNumber(...)");
        return formatNumber;
    }

    public final void onError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InviteUserViewModel$onError$1(this, message, null), 3, null);
    }

    public final void onRemoveGuest(int apartmentId, String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new InviteUserViewModel$onRemoveGuest$1(this, apartmentId, phone, null), 3, null);
    }

    public final void onPhoneUpdate(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.phoneNumber.setValue(phone);
    }

    public final void setRemainingInvites(int count) {
        this.remainingInvites.setValue(Integer.valueOf(count));
    }

    public final void startTimer() {
        start();
    }
}
