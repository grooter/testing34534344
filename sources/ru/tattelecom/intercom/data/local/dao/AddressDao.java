package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.AddressEntity;
import ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: AddressDao.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0007\u001a\u00020\u0003H'J\u0016\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00050\tH'J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006H§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/AddressDao;", "", "add", "", EntitiesKt.ADDRESSES_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/AddressEntity;", "clear", "getAllAsFlow", "Lkotlinx/coroutines/flow/Flow;", "Lru/tattelecom/intercom/data/local/entity/AddressWithIntercomsAndStreams;", "getFirst", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AddressDao {
    void add(List<AddressEntity> addresses);

    void clear();

    Flow<List<AddressWithIntercomsAndStreams>> getAllAsFlow();

    Object getFirst(Continuation<? super AddressEntity> continuation);

    Object observeAll(Continuation<? super List<AddressWithIntercomsAndStreams>> continuation);
}
