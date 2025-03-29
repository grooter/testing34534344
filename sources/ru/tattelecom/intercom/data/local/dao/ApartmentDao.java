package ru.tattelecom.intercom.data.local.dao;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.ApartmentEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: ApartmentDao.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H'J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H'J\b\u0010\r\u001a\u00020\u0003H'J\b\u0010\u000e\u001a\u00020\u0003H'J\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H§@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0016H'J\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0010J \u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u0013H§@¢\u0006\u0002\u0010\u001b¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/ApartmentDao;", "", "add", "", EntitiesKt.APARTMENTS_TABLE, "", "Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "addTemporaryCode", "apartmentCode", "Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;", "(Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addTemporaryCodes", "apartmentCodes", "clear", "clearTemporaryCodes", "getAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApartmentsById", NavArg.VerifyCode.APARTMENT_ID, "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "observeAllTemporaryCodes", "updateTemporaryCode", TtmlNode.ATTR_ID, "intercomTemporaryCode", "(ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface ApartmentDao {
    void add(List<ApartmentEntity> apartments);

    Object addTemporaryCode(ApartmentTemporaryCodeEntity apartmentTemporaryCodeEntity, Continuation<? super Unit> continuation);

    void addTemporaryCodes(List<ApartmentTemporaryCodeEntity> apartmentCodes);

    void clear();

    void clearTemporaryCodes();

    Object getAll(Continuation<? super List<ApartmentEntity>> continuation);

    Object getApartmentsById(Integer num, Continuation<? super ApartmentEntity> continuation);

    Flow<List<ApartmentEntity>> observeAll();

    Object observeAllTemporaryCodes(Continuation<? super List<ApartmentTemporaryCodeEntity>> continuation);

    Object updateTemporaryCode(int i, Integer num, Continuation<? super Unit> continuation);
}
