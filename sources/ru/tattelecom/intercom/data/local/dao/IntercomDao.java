package ru.tattelecom.intercom.data.local.dao;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;

/* compiled from: IntercomDao.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\b\u0010\u0007\u001a\u00020\u0003H'J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000bJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H§@¢\u0006\u0002\u0010\u0011J\u001a\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H'J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0013H'J\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0018H§@¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/IntercomDao;", "", "add", "", EntitiesKt.INTERCOMS_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "clear", "getByGateId", "gateId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getById", TtmlNode.ATTR_ID, "getByLogin", FirebaseAnalytics.Event.LOGIN, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observe", "Lkotlinx/coroutines/flow/Flow;", "observeAll", "setCalls", NavArg.INTERCOM_ID, "muted", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFavoriteStatus", "isFavorite", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IntercomDao {
    void add(List<IntercomEntity> intercoms);

    void clear();

    Object getByGateId(int i, Continuation<? super IntercomEntity> continuation);

    Object getById(int i, Continuation<? super IntercomEntity> continuation);

    Object getByLogin(String str, Continuation<? super IntercomEntity> continuation);

    Flow<IntercomEntity> observe(String login);

    Flow<List<IntercomEntity>> observeAll();

    Object setCalls(int i, boolean z, Continuation<? super Unit> continuation);

    Object setFavoriteStatus(int i, boolean z, Continuation<? super Unit> continuation);
}
