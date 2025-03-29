package ru.tattelecom.intercom.feature.verify;

import android.content.Context;
import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.domain.interactors.PushInteractor;

/* compiled from: VerifyViewModel.kt */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001)\u0018\u00002\u00020\u0001:\u00017B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010+\u001a\u00020\u000fJ\b\u0010,\u001a\u0004\u0018\u00010\u0016J\b\u0010-\u001a\u00020.H\u0014J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u0016J \u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010\u00160\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010!\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010%0%0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010&\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010%0%0\u0015¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u001c\u0010'\u001a\u0010\u0012\f\u0012\n \u0017*\u0004\u0018\u00010%0%0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*¨\u00068"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "authInteractor", "Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "pushInteractor", "Lru/tattelecom/intercom/domain/interactors/PushInteractor;", "familyAccessInteractor", "Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/AuthInteractor;Lru/tattelecom/intercom/domain/interactors/PushInteractor;Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", NavArg.VerifyCode.APARTMENT_ID, "", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "attemptsLeft", "code", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getCode", "()Landroidx/lifecycle/MutableLiveData;", "currentTime", "", "getCurrentTime", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", NavArg.VerifyCode.GUEST_PHONE, "getGuestPhone", "()Ljava/lang/String;", "isButtonLoading", "", "isCodeValid", "isResendCodeButtonLoading", "timer", "ru/tattelecom/intercom/feature/verify/VerifyViewModel$timer$1", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$timer$1;", "getAttemptsLeft", "getPhoneNumber", "onCleared", "", "onCodeEnter", "text", "onResendCodeClick", "deviceCode", "onVerifyClick", "os", "context", "Landroid/content/Context;", "Event", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VerifyViewModel extends ViewModel {
    private final Channel<Event> _events;
    private final Integer apartmentId;
    private int attemptsLeft;
    private final AuthInteractor authInteractor;
    private final MutableLiveData<String> code;
    private final MutableLiveData<Long> currentTime;
    private final Flow<Event> events;
    private final FamilyAccessInteractor familyAccessInteractor;
    private final String guestPhone;
    private final MutableLiveData<Boolean> isButtonLoading;
    private final MutableLiveData<Boolean> isCodeValid;
    private final MutableLiveData<Boolean> isResendCodeButtonLoading;
    private final PushInteractor pushInteractor;
    private final VerifyViewModel$timer$1 timer;

    /* JADX WARN: Type inference failed for: r2v13, types: [ru.tattelecom.intercom.feature.verify.VerifyViewModel$timer$1] */
    public VerifyViewModel(SavedStateHandle handle, AuthInteractor authInteractor, PushInteractor pushInteractor, FamilyAccessInteractor familyAccessInteractor) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(authInteractor, "authInteractor");
        Intrinsics.checkNotNullParameter(pushInteractor, "pushInteractor");
        Intrinsics.checkNotNullParameter(familyAccessInteractor, "familyAccessInteractor");
        this.authInteractor = authInteractor;
        this.pushInteractor = pushInteractor;
        this.familyAccessInteractor = familyAccessInteractor;
        this.apartmentId = (Integer) handle.get(NavArg.VerifyCode.APARTMENT_ID);
        this.guestPhone = (String) handle.get(NavArg.VerifyCode.GUEST_PHONE);
        this.code = new MutableLiveData<>("");
        this.currentTime = new MutableLiveData<>();
        this.isButtonLoading = new MutableLiveData<>(false);
        this.isResendCodeButtonLoading = new MutableLiveData<>(false);
        this.isCodeValid = new MutableLiveData<>(false);
        this.attemptsLeft = 3;
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        ?? r2 = new CountDownTimer() { // from class: ru.tattelecom.intercom.feature.verify.VerifyViewModel$timer$1
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                VerifyViewModel.this.getCurrentTime().setValue(Long.valueOf(millisUntilFinished / 1000));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                VerifyViewModel.this.getCurrentTime().setValue(0L);
            }
        };
        this.timer = r2;
        r2.start();
    }

    /* compiled from: VerifyViewModel.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", "", "()V", "NavigateToGrantAccess", "NavigateToHome", "NavigateToLogin", "ShowMessage", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$NavigateToGrantAccess;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$NavigateToHome;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$NavigateToLogin;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$ShowMessage;", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$NavigateToHome;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NavigateToHome extends Event {
            public static final NavigateToHome INSTANCE = new NavigateToHome();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigateToHome)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 2011663753;
            }

            public String toString() {
                return "NavigateToHome";
            }

            private NavigateToHome() {
                super(null);
            }
        }

        private Event() {
        }

        /* compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$NavigateToLogin;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NavigateToLogin extends Event {
            public static final NavigateToLogin INSTANCE = new NavigateToLogin();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigateToLogin)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2059244545;
            }

            public String toString() {
                return "NavigateToLogin";
            }

            private NavigateToLogin() {
                super(null);
            }
        }

        /* compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$NavigateToGrantAccess;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", "success", "", "(Z)V", "getSuccess", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class NavigateToGrantAccess extends Event {
            private final boolean success;

            public static /* synthetic */ NavigateToGrantAccess copy$default(NavigateToGrantAccess navigateToGrantAccess, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = navigateToGrantAccess.success;
                }
                return navigateToGrantAccess.copy(z);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getSuccess() {
                return this.success;
            }

            public final NavigateToGrantAccess copy(boolean success) {
                return new NavigateToGrantAccess(success);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToGrantAccess) && this.success == ((NavigateToGrantAccess) other).success;
            }

            public int hashCode() {
                return AdvThemeDto$$ExternalSyntheticBackport0.m(this.success);
            }

            public String toString() {
                return "NavigateToGrantAccess(success=" + this.success + ")";
            }

            public NavigateToGrantAccess(boolean z) {
                super(null);
                this.success = z;
            }

            public final boolean getSuccess() {
                return this.success;
            }
        }

        /* compiled from: VerifyViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event$ShowMessage;", "Lru/tattelecom/intercom/feature/verify/VerifyViewModel$Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-verify_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final Integer getApartmentId() {
        return this.apartmentId;
    }

    public final String getGuestPhone() {
        return this.guestPhone;
    }

    public final MutableLiveData<String> getCode() {
        return this.code;
    }

    public final MutableLiveData<Long> getCurrentTime() {
        return this.currentTime;
    }

    public final MutableLiveData<Boolean> isCodeValid() {
        return this.isCodeValid;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        cancel();
    }

    public final void onCodeEnter(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.code.setValue(text);
    }

    public final String getPhoneNumber() {
        return this.authInteractor.getPhone();
    }

    public final int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    public final void onVerifyClick(int os, String deviceCode, Context context) {
        Intrinsics.checkNotNullParameter(deviceCode, "deviceCode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VerifyViewModel$onVerifyClick$1(this, os, deviceCode, context, null), 3, null);
    }

    public final void onResendCodeClick(String deviceCode) {
        Intrinsics.checkNotNullParameter(deviceCode, "deviceCode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new VerifyViewModel$onResendCodeClick$1(this, deviceCode, null), 3, null);
    }
}
