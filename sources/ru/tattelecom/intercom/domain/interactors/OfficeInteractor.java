package ru.tattelecom.intercom.domain.interactors;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.remote.model.OfficeResponse;
import ru.tattelecom.intercom.data.remote.source.OfficeMapRemote;

/* compiled from: OfficeInteractor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/OfficeInteractor;", "", "remote", "Lru/tattelecom/intercom/data/remote/source/OfficeMapRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/remote/source/OfficeMapRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "observeOfficeList", "", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OfficeInteractor {
    private final AppCoroutineDispatchers dispatchers;
    private final OfficeMapRemote remote;

    public OfficeInteractor(OfficeMapRemote remote, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.remote = remote;
        this.dispatchers = dispatchers;
    }

    public final Object observeOfficeList(Continuation<? super List<OfficeResponse>> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new OfficeInteractor$observeOfficeList$2(this, null), continuation);
    }
}
