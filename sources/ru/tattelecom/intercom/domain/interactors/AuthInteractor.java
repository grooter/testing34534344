package ru.tattelecom.intercom.domain.interactors;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.source.AuthRemote;

/* compiled from: AuthInteractor.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ$\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0016\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0019\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ(\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "remote", "Lru/tattelecom/intercom/data/remote/source/AuthRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/remote/source/AuthRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "addApartmentByQRToken", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "apartmentQrToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth", "phone", "deviceCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceId", "getPhone", "getQrCode", NavArg.VerifyCode.APARTMENT_ID, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerAnotherApartment", FirebaseAnalytics.Event.LOGIN, "sms", "", "code", "os", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthInteractor {
    private final AppCoroutineDispatchers dispatchers;
    private final UserPrefsSource prefs;
    private final AuthRemote remote;

    public AuthInteractor(UserPrefsSource prefs, AuthRemote remote, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.prefs = prefs;
        this.remote = remote;
        this.dispatchers = dispatchers;
    }

    public final String getDeviceId() {
        return this.prefs.getDeviceId();
    }

    public final String getPhone() {
        return this.prefs.getPhoneNumber();
    }

    public final Object registerAnotherApartment(String str, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new AuthInteractor$registerAnotherApartment$2(this, str, null), continuation);
    }

    public static /* synthetic */ Object auth$default(AuthInteractor authInteractor, String str, String str2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return authInteractor.auth(str, str2, continuation);
    }

    public final Object auth(String str, String str2, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new AuthInteractor$auth$2(str, this, str2, null), continuation);
    }

    public final Object sms(String str, int i, String str2, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new AuthInteractor$sms$2(this, str, i, str2, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object getQrCode(int i, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new AuthInteractor$getQrCode$2(this, i, null), continuation);
    }

    public final Object addApartmentByQRToken(String str, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new AuthInteractor$addApartmentByQRToken$2(this, str, null), continuation);
    }
}
