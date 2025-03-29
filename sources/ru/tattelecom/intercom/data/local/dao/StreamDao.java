package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.StreamEntity;

/* compiled from: StreamDao.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0007\u001a\u00020\u0003H'J\u001e\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/StreamDao;", "", "add", "", EntitiesKt.STREAM_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/StreamEntity;", "clear", "setFavoriteStatus", "stream", "", "isFavorite", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface StreamDao {
    void add(List<StreamEntity> streams);

    void clear();

    Object setFavoriteStatus(String str, boolean z, Continuation<? super Unit> continuation);
}
