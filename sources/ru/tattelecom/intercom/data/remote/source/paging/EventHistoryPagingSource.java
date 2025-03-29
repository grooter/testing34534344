package ru.tattelecom.intercom.data.remote.source.paging;

import androidx.core.app.NotificationCompat;
import androidx.paging.PagingSource;
import androidx.paging.PagingState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonPrimitive;
import ru.tattelecom.intercom.data.helper.ApartmentServiceName;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao;
import ru.tattelecom.intercom.data.local.dao.EventDao;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;
import ru.tattelecom.intercom.data.local.entity.CallEntity;
import ru.tattelecom.intercom.data.local.entity.CodePassLogEntity;
import ru.tattelecom.intercom.data.local.entity.KeyLogEntity;
import ru.tattelecom.intercom.data.remote.model.AllRemote;
import ru.tattelecom.intercom.data.remote.model.CallRemote;
import ru.tattelecom.intercom.data.remote.model.EventHistoryResponse;
import ru.tattelecom.intercom.data.remote.model.PassRemote;
import ru.tattelecom.intercom.data.remote.source.EventHistoryRemote;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019BC\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018H\u0082@¢\u0006\u0002\u0010\u001bJ$\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0018H\u0082@¢\u0006\u0002\u0010\u001bJ$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0018H\u0082@¢\u0006\u0002\u0010\u001bJ#\u0010\"\u001a\u0004\u0018\u00010\u00022\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030$H\u0016¢\u0006\u0002\u0010%J(\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0096@¢\u0006\u0002\u0010*J(\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0082@¢\u0006\u0002\u0010*J(\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0082@¢\u0006\u0002\u0010*J(\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0082@¢\u0006\u0002\u0010*J(\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00020)H\u0082@¢\u0006\u0002\u0010*J\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018*\u0004\u0018\u000100H\u0002J\u0016\u00101\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0018*\u0004\u0018\u000100H\u0002J\u0016\u00102\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0018*\u0004\u0018\u000100H\u0002J\u0016\u00103\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0018*\u0004\u0018\u000100H\u0002J\u0016\u00104\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u0018*\u0004\u0018\u000100H\u0002J\u0012\u00105\u001a\u00020\u000f*\b\u0012\u0004\u0012\u0002060\u0018H\u0002J\u0012\u00107\u001a\u00020\u000f*\b\u0012\u0004\u0012\u0002060\u0018H\u0002J\u0016\u00108\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0018*\u0004\u0018\u000100H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/paging/EventHistoryPagingSource;", "Landroidx/paging/PagingSource;", "", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "eventHistoryRemote", "Lru/tattelecom/intercom/data/remote/source/EventHistoryRemote;", "eventDao", "Lru/tattelecom/intercom/data/local/dao/EventDao;", "apartmentDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentDao;", "apartmentServicesDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentServicesDao;", "dataLoadType", "Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;", "isBannerClosed", "", "onExceptionListener", "Lkotlin/Function0;", "", "(Lru/tattelecom/intercom/data/remote/source/EventHistoryRemote;Lru/tattelecom/intercom/data/local/dao/EventDao;Lru/tattelecom/intercom/data/local/dao/ApartmentDao;Lru/tattelecom/intercom/data/local/dao/ApartmentServicesDao;Lru/tattelecom/intercom/data/remote/source/paging/DataLoadType;ZLkotlin/jvm/functions/Function0;)V", "isInternetServiceConnected", "checkInternet", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCallEvents", "", "callEntities", "Lru/tattelecom/intercom/data/local/entity/CallEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCodePassEvents", "codePassEntities", "Lru/tattelecom/intercom/data/local/entity/CodePassLogEntity;", "getKeyEvents", "keyEntities", "Lru/tattelecom/intercom/data/local/entity/KeyLogEntity;", "getRefreshKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;)Ljava/lang/Integer;", "load", "Landroidx/paging/PagingSource$LoadResult;", "params", "Landroidx/paging/PagingSource$LoadParams;", "(Landroidx/paging/PagingSource$LoadParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadAllLog", "loadCallLog", "loadCodePassLog", "loadKeyLog", "getCallEntities", "Lru/tattelecom/intercom/data/remote/model/EventHistoryResponse;", "getCallEntitiesFromAllLog", "getCodePassEntitiesFromAllLog", "getKeyEntities", "getKeyEntitiesFromAllLog", "isAbilityEventRemove", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", "isAbilityViewKeyLog", "toCodePassEntities", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryPagingSource extends PagingSource<Integer, HistoryItem> {
    public static final String CURRENT_PAGE = "x-pagination-current-page";
    public static final int NETWORK_PAGE_SIZE = 10;
    public static final String PAGE_COUNT = "x-pagination-page-count";
    public static final String PER_PAGE = "x-pagination-per-page";
    public static final int STARTING_PAGE_INDEX = 1;
    public static final String TOTAL_COUNT = "x-pagination-total-count";
    private final ApartmentDao apartmentDao;
    private final ApartmentServicesDao apartmentServicesDao;
    private final DataLoadType dataLoadType;
    private final EventDao eventDao;
    private final EventHistoryRemote eventHistoryRemote;
    private final boolean isBannerClosed;
    private boolean isInternetServiceConnected;
    private final Function0<Unit> onExceptionListener;

    /* compiled from: EventHistoryPagingSource.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DataLoadType.values().length];
            try {
                iArr[DataLoadType.TYPE_ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DataLoadType.TYPE_CALLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DataLoadType.TYPE_KEY_PASSES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DataLoadType.TYPE_CODE_PASSES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public EventHistoryPagingSource(EventHistoryRemote eventHistoryRemote, EventDao eventDao, ApartmentDao apartmentDao, ApartmentServicesDao apartmentServicesDao, DataLoadType dataLoadType, boolean z, Function0<Unit> onExceptionListener) {
        Intrinsics.checkNotNullParameter(eventHistoryRemote, "eventHistoryRemote");
        Intrinsics.checkNotNullParameter(eventDao, "eventDao");
        Intrinsics.checkNotNullParameter(apartmentDao, "apartmentDao");
        Intrinsics.checkNotNullParameter(apartmentServicesDao, "apartmentServicesDao");
        Intrinsics.checkNotNullParameter(dataLoadType, "dataLoadType");
        Intrinsics.checkNotNullParameter(onExceptionListener, "onExceptionListener");
        this.eventHistoryRemote = eventHistoryRemote;
        this.eventDao = eventDao;
        this.apartmentDao = apartmentDao;
        this.apartmentServicesDao = apartmentServicesDao;
        this.dataLoadType = dataLoadType;
        this.isBannerClosed = z;
        this.onExceptionListener = onExceptionListener;
        this.isInternetServiceConnected = true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.paging.PagingSource
    public Integer getRefreshKey(PagingState<Integer, HistoryItem> state) {
        Integer nextKey;
        Integer valueOf;
        Integer prevKey;
        Intrinsics.checkNotNullParameter(state, "state");
        Integer anchorPosition = state.getAnchorPosition();
        if (anchorPosition == null) {
            return null;
        }
        int intValue = anchorPosition.intValue();
        PagingSource.LoadResult.Page<Integer, HistoryItem> closestPageToPosition = state.closestPageToPosition(intValue);
        if (closestPageToPosition == null || (prevKey = closestPageToPosition.getPrevKey()) == null) {
            PagingSource.LoadResult.Page<Integer, HistoryItem> closestPageToPosition2 = state.closestPageToPosition(intValue);
            if (closestPageToPosition2 == null || (nextKey = closestPageToPosition2.getNextKey()) == null) {
                return null;
            }
            valueOf = Integer.valueOf(nextKey.intValue() - 1);
        } else {
            valueOf = Integer.valueOf(prevKey.intValue() + 1);
        }
        return valueOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v9 */
    @Override // androidx.paging.PagingSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object load(androidx.paging.PagingSource.LoadParams<java.lang.Integer> r8, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r9) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.load(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0134 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadAllLog(androidx.paging.PagingSource.LoadParams<java.lang.Integer> r18, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r19) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.loadAllLog(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadCallLog(androidx.paging.PagingSource.LoadParams<java.lang.Integer> r12, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.loadCallLog(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadKeyLog(androidx.paging.PagingSource.LoadParams<java.lang.Integer> r21, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r22) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.loadKeyLog(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadCodePassLog(androidx.paging.PagingSource.LoadParams<java.lang.Integer> r21, kotlin.coroutines.Continuation<? super androidx.paging.PagingSource.LoadResult<java.lang.Integer, ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r22) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.loadCodePassLog(androidx.paging.PagingSource$LoadParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0080 -> B:11:0x0083). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkInternet(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource$checkInternet$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource$checkInternet$1 r0 = (ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource$checkInternet$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource$checkInternet$1 r0 = new ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource$checkInternet$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.L$0
            ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource r4 = (ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L83
        L35:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3d:
            java.lang.Object r2 = r0.L$0
            ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource r2 = (ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L45:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r7 = r6.apartmentDao
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.getAll(r0)
            if (r7 != r1) goto L55
            return r1
        L55:
            r2 = r6
        L56:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L91
            java.util.Iterator r7 = r7.iterator()
            r4 = r2
            r2 = r7
        L60:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L91
            java.lang.Object r7 = r2.next()
            ru.tattelecom.intercom.data.local.entity.ApartmentEntity r7 = (ru.tattelecom.intercom.data.local.entity.ApartmentEntity) r7
            ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao r5 = r4.apartmentServicesDao
            int r7 = r7.getId()
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r7 = r5.getByApartmentId(r7, r0)
            if (r7 != r1) goto L83
            return r1
        L83:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L60
            boolean r7 = r4.isAbilityViewKeyLog(r7)
            if (r7 != 0) goto L60
            r7 = 0
            r4.isInternetServiceConnected = r7
            goto L60
        L91:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.checkInternet(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final List<CallEntity> getCallEntitiesFromAllLog(EventHistoryResponse eventHistoryResponse) {
        List<AllRemote> data;
        String content;
        if (eventHistoryResponse == null || (data = eventHistoryResponse.getData()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            AllRemote allRemote = (AllRemote) obj;
            if (allRemote.getId() != null && Intrinsics.areEqual(allRemote.getType(), NotificationCompat.CATEGORY_CALL) && allRemote.getIntercomId() != null && allRemote.getApartmentId() != null && allRemote.getTime() != null && StringsKt.toIntOrNull(allRemote.getId().getContent()) != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<AllRemote> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (AllRemote allRemote2 : arrayList2) {
            JsonPrimitive id = allRemote2.getId();
            Integer valueOf = (id == null || (content = id.getContent()) == null) ? null : Integer.valueOf(Integer.parseInt(content));
            Intrinsics.checkNotNull(valueOf);
            int intValue = valueOf.intValue();
            Integer intercomId = allRemote2.getIntercomId();
            Intrinsics.checkNotNull(intercomId);
            int intValue2 = intercomId.intValue();
            Integer apartmentId = allRemote2.getApartmentId();
            Intrinsics.checkNotNull(apartmentId);
            int intValue3 = apartmentId.intValue();
            Long time = allRemote2.getTime();
            Intrinsics.checkNotNull(time);
            long longValue = time.longValue();
            String snapshot = allRemote2.getSnapshot();
            if (snapshot == null) {
                snapshot = "";
            }
            arrayList3.add(new CallEntity(intValue, intValue2, intValue3, longValue, snapshot));
        }
        return arrayList3;
    }

    private final List<KeyLogEntity> getKeyEntitiesFromAllLog(EventHistoryResponse eventHistoryResponse) {
        List<AllRemote> data;
        if (eventHistoryResponse == null || (data = eventHistoryResponse.getData()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            AllRemote allRemote = (AllRemote) obj;
            if (allRemote.getId() != null && allRemote.getIntercomId() != null && Intrinsics.areEqual(allRemote.getType(), "key_pass") && allRemote.getApartmentId() != null && allRemote.getTime() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<AllRemote> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (AllRemote allRemote2 : arrayList2) {
            JsonPrimitive id = allRemote2.getId();
            String valueOf = String.valueOf(id != null ? id.getContent() : null);
            Integer intercomId = allRemote2.getIntercomId();
            Intrinsics.checkNotNull(intercomId);
            int intValue = intercomId.intValue();
            Integer apartmentId = allRemote2.getApartmentId();
            Intrinsics.checkNotNull(apartmentId);
            int intValue2 = apartmentId.intValue();
            Long time = allRemote2.getTime();
            Intrinsics.checkNotNull(time);
            long longValue = time.longValue();
            String snapshot = allRemote2.getSnapshot();
            if (snapshot == null) {
                snapshot = "";
            }
            arrayList3.add(new KeyLogEntity(valueOf, intValue, intValue2, longValue, snapshot));
        }
        return arrayList3;
    }

    private final List<CodePassLogEntity> getCodePassEntitiesFromAllLog(EventHistoryResponse eventHistoryResponse) {
        List<AllRemote> data;
        if (eventHistoryResponse == null || (data = eventHistoryResponse.getData()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : data) {
            AllRemote allRemote = (AllRemote) obj;
            if (allRemote.getId() != null && allRemote.getIntercomId() != null && Intrinsics.areEqual(allRemote.getType(), "code_pass") && allRemote.getApartmentId() != null && allRemote.getTime() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<AllRemote> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (AllRemote allRemote2 : arrayList2) {
            JsonPrimitive id = allRemote2.getId();
            String valueOf = String.valueOf(id != null ? id.getContent() : null);
            Integer intercomId = allRemote2.getIntercomId();
            Intrinsics.checkNotNull(intercomId);
            int intValue = intercomId.intValue();
            Integer apartmentId = allRemote2.getApartmentId();
            Intrinsics.checkNotNull(apartmentId);
            int intValue2 = apartmentId.intValue();
            Long time = allRemote2.getTime();
            Intrinsics.checkNotNull(time);
            long longValue = time.longValue();
            String snapshot = allRemote2.getSnapshot();
            if (snapshot == null) {
                snapshot = "";
            }
            arrayList3.add(new CodePassLogEntity(valueOf, intValue, intValue2, longValue, snapshot));
        }
        return arrayList3;
    }

    private final List<CallEntity> getCallEntities(EventHistoryResponse eventHistoryResponse) {
        List<CallRemote> calls;
        if (eventHistoryResponse == null || (calls = eventHistoryResponse.getCalls()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : calls) {
            CallRemote callRemote = (CallRemote) obj;
            if (callRemote.getId() != null && callRemote.getIntercomId() != null && callRemote.getApartmentId() != null && callRemote.getTime() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<CallRemote> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (CallRemote callRemote2 : arrayList2) {
            Integer id = callRemote2.getId();
            Intrinsics.checkNotNull(id);
            int intValue = id.intValue();
            Integer intercomId = callRemote2.getIntercomId();
            Intrinsics.checkNotNull(intercomId);
            int intValue2 = intercomId.intValue();
            Integer apartmentId = callRemote2.getApartmentId();
            Intrinsics.checkNotNull(apartmentId);
            int intValue3 = apartmentId.intValue();
            Long time = callRemote2.getTime();
            Intrinsics.checkNotNull(time);
            long longValue = time.longValue();
            String snapshot = callRemote2.getSnapshot();
            if (snapshot == null) {
                snapshot = "";
            }
            arrayList3.add(new CallEntity(intValue, intValue2, intValue3, longValue, snapshot));
        }
        return arrayList3;
    }

    private final List<KeyLogEntity> getKeyEntities(EventHistoryResponse eventHistoryResponse) {
        List<PassRemote> passes;
        if (eventHistoryResponse == null || (passes = eventHistoryResponse.getPasses()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : passes) {
            PassRemote passRemote = (PassRemote) obj;
            if (passRemote.getId() != null && passRemote.getIntercomId() != null && passRemote.getApartmentId() != null && passRemote.getTime() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<PassRemote> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (PassRemote passRemote2 : arrayList2) {
            String id = passRemote2.getId();
            Intrinsics.checkNotNull(id);
            Integer intercomId = passRemote2.getIntercomId();
            Intrinsics.checkNotNull(intercomId);
            int intValue = intercomId.intValue();
            Integer apartmentId = passRemote2.getApartmentId();
            Intrinsics.checkNotNull(apartmentId);
            int intValue2 = apartmentId.intValue();
            Long time = passRemote2.getTime();
            Intrinsics.checkNotNull(time);
            long longValue = time.longValue();
            String snapshot = passRemote2.getSnapshot();
            if (snapshot == null) {
                snapshot = "";
            }
            arrayList3.add(new KeyLogEntity(id, intValue, intValue2, longValue, snapshot));
        }
        return arrayList3;
    }

    private final List<CodePassLogEntity> toCodePassEntities(EventHistoryResponse eventHistoryResponse) {
        List<PassRemote> passes;
        if (eventHistoryResponse == null || (passes = eventHistoryResponse.getPasses()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : passes) {
            PassRemote passRemote = (PassRemote) obj;
            if (passRemote.getId() != null && passRemote.getIntercomId() != null && passRemote.getApartmentId() != null && passRemote.getTime() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<PassRemote> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (PassRemote passRemote2 : arrayList2) {
            String id = passRemote2.getId();
            Intrinsics.checkNotNull(id);
            Integer intercomId = passRemote2.getIntercomId();
            Intrinsics.checkNotNull(intercomId);
            int intValue = intercomId.intValue();
            Integer apartmentId = passRemote2.getApartmentId();
            Intrinsics.checkNotNull(apartmentId);
            int intValue2 = apartmentId.intValue();
            Long time = passRemote2.getTime();
            Intrinsics.checkNotNull(time);
            long longValue = time.longValue();
            String snapshot = passRemote2.getSnapshot();
            if (snapshot == null) {
                snapshot = "";
            }
            arrayList3.add(new CodePassLogEntity(id, intValue, intValue2, longValue, snapshot));
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0078 A[LOOP:1: B:44:0x0072->B:46:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getCallEvents(java.util.List<ru.tattelecom.intercom.data.local.entity.CallEntity> r22, kotlin.coroutines.Continuation<? super java.util.List<? extends ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r23) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.getCallEvents(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0078 A[LOOP:1: B:48:0x0072->B:50:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getKeyEvents(java.util.List<ru.tattelecom.intercom.data.local.entity.KeyLogEntity> r22, kotlin.coroutines.Continuation<? super java.util.List<? extends ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r23) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.getKeyEvents(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0078 A[LOOP:1: B:48:0x0072->B:50:0x0078, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getCodePassEvents(java.util.List<ru.tattelecom.intercom.data.local.entity.CodePassLogEntity> r22, kotlin.coroutines.Continuation<? super java.util.List<? extends ru.tattelecom.intercom.data.remote.source.paging.HistoryItem>> r23) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.paging.EventHistoryPagingSource.getCodePassEvents(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isAbilityViewKeyLog(List<ApartmentServicesEntity> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ApartmentServicesEntity apartmentServicesEntity = (ApartmentServicesEntity) obj;
            if (Intrinsics.areEqual(apartmentServicesEntity.getName(), ApartmentServiceName.KEY_LOG_HISTORY) && Intrinsics.areEqual((Object) apartmentServicesEntity.getActive(), (Object) true)) {
                break;
            }
        }
        return obj != null;
    }

    private final boolean isAbilityEventRemove(List<ApartmentServicesEntity> list) {
        Object obj;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            ApartmentServicesEntity apartmentServicesEntity = (ApartmentServicesEntity) obj;
            if (Intrinsics.areEqual(apartmentServicesEntity.getName(), ApartmentServiceName.REMOVE_CALL_ABILITY) && Intrinsics.areEqual((Object) apartmentServicesEntity.getActive(), (Object) true)) {
                break;
            }
        }
        return obj != null;
    }
}
