package ru.tattelecom.intercom.domain.interactors;

import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.remote.model.CallImageResponse;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.source.EventHistoryRemote;
import ru.tattelecom.intercom.data.remote.source.paging.DataLoadType;
import ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryInteractor.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J0\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010$J\u001e\u0010%\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020#2\u0006\u0010 \u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/EventHistoryInteractor;", "", "remote", "Lru/tattelecom/intercom/data/remote/source/EventHistoryRemote;", "eventDao", "Lru/tattelecom/intercom/data/local/dao/EventDao;", "apartmentDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentDao;", "apartmentServicesDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentServicesDao;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/remote/source/EventHistoryRemote;Lru/tattelecom/intercom/data/local/dao/EventDao;Lru/tattelecom/intercom/data/local/dao/ApartmentDao;Lru/tattelecom/intercom/data/local/dao/ApartmentServicesDao;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "getImage", "Lru/tattelecom/intercom/data/remote/model/CallImageResponse;", "callId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchResultStream", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "dataLoadType", "Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "isBannerClosed", "", "onExceptionListener", "Lkotlin/Function0;", "", "removeCallLog", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", TtmlNode.ATTR_ID, "fromEveryone", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCodePassLog", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeKeyLog", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryInteractor {
    private final ApartmentDao apartmentDao;
    private final ApartmentServicesDao apartmentServicesDao;
    private final AppCoroutineDispatchers dispatchers;
    private final EventDao eventDao;
    private final EventHistoryRemote remote;

    public EventHistoryInteractor(EventHistoryRemote remote, EventDao eventDao, ApartmentDao apartmentDao, ApartmentServicesDao apartmentServicesDao, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(eventDao, "eventDao");
        Intrinsics.checkNotNullParameter(apartmentDao, "apartmentDao");
        Intrinsics.checkNotNullParameter(apartmentServicesDao, "apartmentServicesDao");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.remote = remote;
        this.eventDao = eventDao;
        this.apartmentDao = apartmentDao;
        this.apartmentServicesDao = apartmentServicesDao;
        this.dispatchers = dispatchers;
    }

    public final Object getImage(int i, Continuation<? super CallImageResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new EventHistoryInteractor$getImage$2(this, i, null), continuation);
    }

    public final Object removeCallLog(int i, boolean z, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new EventHistoryInteractor$removeCallLog$2(z, this, i, null), continuation);
    }

    public final Object removeKeyLog(String str, boolean z, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new EventHistoryInteractor$removeKeyLog$2(z, this, str, null), continuation);
    }

    public final Object removeCodePassLog(String str, boolean z, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new EventHistoryInteractor$removeCodePassLog$2(z, this, str, null), continuation);
    }

    public final Flow<PagingData<HistoryItem>> getSearchResultStream(final DataLoadType dataLoadType, final boolean isBannerClosed, final Function0<Unit> onExceptionListener) {
        Intrinsics.checkNotNullParameter(dataLoadType, "dataLoadType");
        Intrinsics.checkNotNullParameter(onExceptionListener, "onExceptionListener");
        return new Pager(new PagingConfig(10, 0, false, 10, 0, 0, 50, null), null, new Function0<PagingSource<Integer, HistoryItem>>() { // from class: ru.tattelecom.intercom.domain.interactors.EventHistoryInteractor$getSearchResultStream$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PagingSource<Integer, HistoryItem> invoke() {
                EventHistoryRemote eventHistoryRemote;
                EventDao eventDao;
                ApartmentDao apartmentDao;
                ApartmentServicesDao apartmentServicesDao;
                eventHistoryRemote = EventHistoryInteractor.this.remote;
                eventDao = EventHistoryInteractor.this.eventDao;
                apartmentDao = EventHistoryInteractor.this.apartmentDao;
                apartmentServicesDao = EventHistoryInteractor.this.apartmentServicesDao;
                return new EventHistoryPagingSource(eventHistoryRemote, eventDao, apartmentDao, apartmentServicesDao, dataLoadType, isBannerClosed, onExceptionListener);
            }
        }, 2, null).getFlow();
    }
}
