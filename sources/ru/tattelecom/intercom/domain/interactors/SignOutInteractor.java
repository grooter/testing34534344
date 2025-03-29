package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.prefs.RemoteConfigPrefsSource;
import ru.tattelecom.intercom.data.prefs.SupportPrefsSource;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: SignOutInteractor.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/SignOutInteractor;", "", "database", "Lru/tattelecom/intercom/data/local/IntercomDatabase;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "configPrefsSource", "Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;", "supportPrefsSource", "Lru/tattelecom/intercom/data/prefs/SupportPrefsSource;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/local/IntercomDatabase;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/prefs/RemoteConfigPrefsSource;Lru/tattelecom/intercom/data/prefs/SupportPrefsSource;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "signOut", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SignOutInteractor {
    private final RemoteConfigPrefsSource configPrefsSource;
    private final IntercomDatabase database;
    private final AppCoroutineDispatchers dispatchers;
    private final UserPrefsSource prefs;
    private final SupportPrefsSource supportPrefsSource;

    public SignOutInteractor(IntercomDatabase database, UserPrefsSource prefs, RemoteConfigPrefsSource configPrefsSource, SupportPrefsSource supportPrefsSource, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(configPrefsSource, "configPrefsSource");
        Intrinsics.checkNotNullParameter(supportPrefsSource, "supportPrefsSource");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.database = database;
        this.prefs = prefs;
        this.configPrefsSource = configPrefsSource;
        this.supportPrefsSource = supportPrefsSource;
        this.dispatchers = dispatchers;
    }

    public final Object signOut(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new SignOutInteractor$signOut$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
