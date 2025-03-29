package ru.tattelecom.intercom.feature.login;

import android.os.CountDownTimer;
import androidx.lifecycle.MutableLiveData;
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
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;

/* compiled from: LoginViewModel.kt */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u00002\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020\u001bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00150\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006\""}, d2 = {"Lru/tattelecom/intercom/feature/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "interactor", "Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "(Lru/tattelecom/intercom/domain/interactors/AuthInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event;", "currentTime", "Landroidx/lifecycle/MutableLiveData;", "", "getCurrentTime", "()Landroidx/lifecycle/MutableLiveData;", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "isButtonLoading", "", "kotlin.jvm.PlatformType", "phoneNumber", "", "getPhoneNumber", "timer", "ru/tattelecom/intercom/feature/login/LoginViewModel$timer$1", "Lru/tattelecom/intercom/feature/login/LoginViewModel$timer$1;", "onCleared", "", "onLogInClick", "deviceCode", "onPhoneUpdate", "phone", "startTimer", "Event", "feature-login_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class LoginViewModel extends ViewModel {
    private final Channel<Event> _events;
    private final MutableLiveData<Long> currentTime;
    private final Flow<Event> events;
    private final AuthInteractor interactor;
    private final MutableLiveData<Boolean> isButtonLoading;
    private final MutableLiveData<String> phoneNumber;
    private final LoginViewModel$timer$1 timer;

    /* JADX WARN: Type inference failed for: r3v8, types: [ru.tattelecom.intercom.feature.login.LoginViewModel$timer$1] */
    public LoginViewModel(AuthInteractor interactor) {
        Intrinsics.checkNotNullParameter(interactor, "interactor");
        this.interactor = interactor;
        this.currentTime = new MutableLiveData<>();
        this.phoneNumber = new MutableLiveData<>("");
        this.isButtonLoading = new MutableLiveData<>(false);
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        this.timer = new CountDownTimer() { // from class: ru.tattelecom.intercom.feature.login.LoginViewModel$timer$1
            {
                super(45000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                LoginViewModel.this.getCurrentTime().setValue(Long.valueOf(millisUntilFinished / 1000));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                LoginViewModel.this.getCurrentTime().setValue(0L);
            }
        };
    }

    /* compiled from: LoginViewModel.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/login/LoginViewModel$Event;", "", "()V", "Navigate", "ShowMessage", "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event$Navigate;", "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event$ShowMessage;", "feature-login_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class Event {
        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/login/LoginViewModel$Event$Navigate;", "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event;", "action", "", "(I)V", "getAction", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "feature-login_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Navigate extends Event {
            private final int action;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = navigate.action;
                }
                return navigate.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getAction() {
                return this.action;
            }

            public final Navigate copy(int action) {
                return new Navigate(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Navigate) && this.action == ((Navigate) other).action;
            }

            public int hashCode() {
                return this.action;
            }

            public String toString() {
                return "Navigate(action=" + this.action + ")";
            }

            public Navigate(int i) {
                super(null);
                this.action = i;
            }

            public final int getAction() {
                return this.action;
            }
        }

        private Event() {
        }

        /* compiled from: LoginViewModel.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/login/LoginViewModel$Event$ShowMessage;", "Lru/tattelecom/intercom/feature/login/LoginViewModel$Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-login_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public final MutableLiveData<Long> getCurrentTime() {
        return this.currentTime;
    }

    public final MutableLiveData<String> getPhoneNumber() {
        return this.phoneNumber;
    }

    public final MutableLiveData<Boolean> isButtonLoading() {
        return this.isButtonLoading;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        cancel();
    }

    public final void onPhoneUpdate(String phone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.phoneNumber.setValue(phone);
    }

    public final void onLogInClick(String deviceCode) {
        Intrinsics.checkNotNullParameter(deviceCode, "deviceCode");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new LoginViewModel$onLogInClick$1(this, deviceCode, null), 3, null);
    }

    public final void startTimer() {
        start();
    }
}
