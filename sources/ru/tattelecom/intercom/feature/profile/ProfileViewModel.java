package ru.tattelecom.intercom.feature.profile;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
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
import ru.tattelecom.intercom.domain.interactors.AddressInteractor;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.PushInteractor;
import ru.tattelecom.intercom.domain.interactors.SignOutInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001e\u001a\u00020\u001fH\u0082@¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$J\b\u0010%\u001a\u0004\u0018\u00010\u001dJ(\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u001dH\u0086@¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020\u001fJ\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020.R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/tattelecom/intercom/feature/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "authInteractor", "Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "pushInteractor", "Lru/tattelecom/intercom/domain/interactors/PushInteractor;", "signOutInteractor", "Lru/tattelecom/intercom/domain/interactors/SignOutInteractor;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "addressInteractor", "Lru/tattelecom/intercom/domain/interactors/AddressInteractor;", "(Lru/tattelecom/intercom/domain/interactors/UserInteractor;Lru/tattelecom/intercom/domain/interactors/AuthInteractor;Lru/tattelecom/intercom/domain/interactors/PushInteractor;Lru/tattelecom/intercom/domain/interactors/SignOutInteractor;Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/domain/interactors/AddressInteractor;)V", "_events", "Lkotlinx/coroutines/channels/Channel;", "Lru/tattelecom/intercom/feature/profile/Event;", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "events", "Lkotlinx/coroutines/flow/Flow;", "getEvents", "()Lkotlinx/coroutines/flow/Flow;", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "number", "", "checkAddresses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkUserState", "deletePushToken", "context", "Landroid/content/Context;", "formattedPhoneNumber", "getUserConfig", "phone", "formattedPhone", "chatAction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSignOutClick", "reportEvent", "buttonId", "", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ProfileViewModel extends ViewModel {
    private final Channel<Event> _events;
    private final MutableStateFlow<Boolean> _isLoading;
    private final AddressInteractor addressInteractor;
    private final Flow<Event> events;
    private final StateFlow<Boolean> isLoading;
    private final LogInteractor logInteractor;
    private final String number;
    private final PushInteractor pushInteractor;
    private final SignOutInteractor signOutInteractor;
    private final UserInteractor userInteractor;

    public ProfileViewModel(UserInteractor userInteractor, AuthInteractor authInteractor, PushInteractor pushInteractor, SignOutInteractor signOutInteractor, LogInteractor logInteractor, AddressInteractor addressInteractor) {
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        Intrinsics.checkNotNullParameter(authInteractor, "authInteractor");
        Intrinsics.checkNotNullParameter(pushInteractor, "pushInteractor");
        Intrinsics.checkNotNullParameter(signOutInteractor, "signOutInteractor");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(addressInteractor, "addressInteractor");
        this.userInteractor = userInteractor;
        this.pushInteractor = pushInteractor;
        this.signOutInteractor = signOutInteractor;
        this.logInteractor = logInteractor;
        this.addressInteractor = addressInteractor;
        Channel<Event> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._events = Channel$default;
        this.events = FlowKt.receiveAsFlow(Channel$default);
        this.number = authInteractor.getPhone();
        MutableStateFlow<Boolean> MutableStateFlow = StateFlowKt.MutableStateFlow(false);
        this._isLoading = MutableStateFlow;
        this.isLoading = MutableStateFlow;
    }

    public final Flow<Event> getEvents() {
        return this.events;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final void checkUserState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$checkUserState$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(2:3|(4:5|6|7|8))|124|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0096, code lost:
    
        r15 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0179 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x02a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0294 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0156 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x014a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkAddresses(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.profile.ProfileViewModel.checkAddresses(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String formattedPhoneNumber() {
        String str = this.number;
        return str == null ? "" : PhoneNumberUtils.formatNumber(str, "RU");
    }

    public final void onSignOutClick() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$onSignOutClick$1(this, null), 3, null);
    }

    public final void deletePushToken(Context context) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$deletePushToken$1(this, context, null), 3, null);
    }

    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(2:3|(6:5|6|7|(2:(1:(1:(1:(2:13|14)(2:18|19))(1:20))(4:22|23|24|(1:26)))(1:27)|21)(4:28|29|30|(2:32|(1:34))(2:35|(2:37|(1:39)(3:40|24|(0)))))|15|16))|48|6|7|(0)(0)|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0071, code lost:
    
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0072, code lost:
    
        r7 = r10;
        r10 = r9;
        r9 = r12;
        r12 = r11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUserConfig(java.lang.String r9, java.lang.String r10, java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.profile.ProfileViewModel.getUserConfig(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
