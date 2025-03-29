package ru.tattelecom.intercom.domain.interactors;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.local.entity.AddressEntity;
import ru.tattelecom.intercom.data.local.entity.AddressWithIntercomsAndStreams;
import ru.tattelecom.intercom.data.local.entity.ApartmentEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.data.local.entity.ScheduleEntity;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.model.ApartmentResponse;
import ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse;
import ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse;
import ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse;
import ru.tattelecom.intercom.data.remote.model.BuildingResponse;
import ru.tattelecom.intercom.data.remote.model.Guest;
import ru.tattelecom.intercom.data.remote.model.IntercomResponse;
import ru.tattelecom.intercom.data.remote.model.ReaderResponse;
import ru.tattelecom.intercom.data.remote.model.ScheduleResponse;
import ru.tattelecom.intercom.data.remote.model.Services;
import ru.tattelecom.intercom.data.remote.source.IntercomRemote;
import ru.tattelecom.intercom.data.remote.source.ReaderRemote;
import ru.tattelecom.intercom.data.remote.source.StreamRemote;

/* compiled from: AddressInteractor.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00110\u0010J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0011*\u00020 H\u0002J\u0014\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0011*\u00020!H\u0002J\u0014\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0011*\u00020\"H\u0002J\u0014\u0010#\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u0011*\u00020 H\u0002J\u0014\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011*\u00020 H\u0002J\u0014\u0010&\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\u0011*\u00020 H\u0002J\u0014\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0011*\u00020 H\u0002J\u0014\u0010(\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u0011*\u00020!H\u0002J\u0014\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\u0011*\u00020 H\u0002J\u0014\u0010,\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\u0011*\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lru/tattelecom/intercom/domain/interactors/AddressInteractor;", "", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "database", "Lru/tattelecom/intercom/data/local/IntercomDatabase;", "streamRemote", "Lru/tattelecom/intercom/data/remote/source/StreamRemote;", "intercomRemote", "Lru/tattelecom/intercom/data/remote/source/IntercomRemote;", "readerRemote", "Lru/tattelecom/intercom/data/remote/source/ReaderRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/local/IntercomDatabase;Lru/tattelecom/intercom/data/remote/source/StreamRemote;Lru/tattelecom/intercom/data/remote/source/IntercomRemote;Lru/tattelecom/intercom/data/remote/source/ReaderRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "getAddressesAsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/tattelecom/intercom/data/local/entity/AddressWithIntercomsAndStreams;", "getApartmentServices", "Lru/tattelecom/intercom/data/local/entity/ApartmentServicesEntity;", NavArg.VerifyCode.APARTMENT_ID, "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBuildingServices", LogWriteConstants.BUILDING_ID, "observeAddresses", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshAll", "", "toAddressEntities", "Lru/tattelecom/intercom/data/local/entity/AddressEntity;", "Lru/tattelecom/intercom/data/remote/model/AvailableIntercomsResponse;", "Lru/tattelecom/intercom/data/remote/model/AvailableReadersResponse;", "Lru/tattelecom/intercom/data/remote/model/AvailableStreamsResponse;", "toApartmentEntities", "Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "toApartmentServicesEntities", "toApartmentTemporaryCodeEntities", "Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;", "toIntercomEntities", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "toScheduleEntities", "Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "toStreamEntities", "Lru/tattelecom/intercom/data/local/entity/StreamEntity;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddressInteractor {
    private final IntercomDatabase database;
    private final AppCoroutineDispatchers dispatchers;
    private final IntercomRemote intercomRemote;
    private final UserPrefsSource prefs;
    private final ReaderRemote readerRemote;
    private final StreamRemote streamRemote;

    public AddressInteractor(UserPrefsSource prefs, IntercomDatabase database, StreamRemote streamRemote, IntercomRemote intercomRemote, ReaderRemote readerRemote, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(streamRemote, "streamRemote");
        Intrinsics.checkNotNullParameter(intercomRemote, "intercomRemote");
        Intrinsics.checkNotNullParameter(readerRemote, "readerRemote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.prefs = prefs;
        this.database = database;
        this.streamRemote = streamRemote;
        this.intercomRemote = intercomRemote;
        this.readerRemote = readerRemote;
        this.dispatchers = dispatchers;
    }

    public final Object observeAddresses(Continuation<? super List<AddressWithIntercomsAndStreams>> continuation) {
        return this.database.addressDao().observeAll(continuation);
    }

    public final Flow<List<AddressWithIntercomsAndStreams>> getAddressesAsFlow() {
        return this.database.addressDao().getAllAsFlow();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getBuildingServices(java.lang.Integer r5, kotlin.coroutines.Continuation<? super java.util.List<ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.tattelecom.intercom.domain.interactors.AddressInteractor$getBuildingServices$1
            if (r0 == 0) goto L14
            r0 = r6
            ru.tattelecom.intercom.domain.interactors.AddressInteractor$getBuildingServices$1 r0 = (ru.tattelecom.intercom.domain.interactors.AddressInteractor$getBuildingServices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.AddressInteractor$getBuildingServices$1 r0 = new ru.tattelecom.intercom.domain.interactors.AddressInteractor$getBuildingServices$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.tattelecom.intercom.data.local.IntercomDatabase r6 = r4.database
            ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao r6 = r6.apartmentServicesDao()
            r0.label = r3
            java.lang.Object r6 = r6.getByBuildingId(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L4c
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L4c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.AddressInteractor.getBuildingServices(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getApartmentServices(java.lang.Integer r5, kotlin.coroutines.Continuation<? super java.util.List<ru.tattelecom.intercom.data.local.entity.ApartmentServicesEntity>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof ru.tattelecom.intercom.domain.interactors.AddressInteractor$getApartmentServices$1
            if (r0 == 0) goto L14
            r0 = r6
            ru.tattelecom.intercom.domain.interactors.AddressInteractor$getApartmentServices$1 r0 = (ru.tattelecom.intercom.domain.interactors.AddressInteractor$getApartmentServices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.AddressInteractor$getApartmentServices$1 r0 = new ru.tattelecom.intercom.domain.interactors.AddressInteractor$getApartmentServices$1
            r0.<init>(r4, r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L44
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r6)
            ru.tattelecom.intercom.data.local.IntercomDatabase r6 = r4.database
            ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao r6 = r6.apartmentServicesDao()
            r0.label = r3
            java.lang.Object r6 = r6.getByApartmentId(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L4c
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
        L4c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.AddressInteractor.getApartmentServices(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object refreshAll(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new AddressInteractor$refreshAll$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AddressEntity> toAddressEntities(AvailableIntercomsResponse availableIntercomsResponse) {
        Sequence asSequence;
        Sequence mapNotNull;
        Sequence flattenSequenceOfIterable;
        Sequence filter;
        Sequence map;
        Sequence distinct;
        Map<String, List<IntercomResponse>> addresses = availableIntercomsResponse.getAddresses();
        if (addresses == null || (asSequence = MapsKt.asSequence(addresses)) == null || (mapNotNull = SequencesKt.mapNotNull(asSequence, new Function1<Map.Entry<? extends String, ? extends List<? extends IntercomResponse>>, List<? extends IntercomResponse>>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toAddressEntities$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends IntercomResponse> invoke(Map.Entry<? extends String, ? extends List<? extends IntercomResponse>> entry) {
                return invoke2((Map.Entry<String, ? extends List<IntercomResponse>>) entry);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<IntercomResponse> invoke2(Map.Entry<String, ? extends List<IntercomResponse>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getValue();
            }
        })) == null || (flattenSequenceOfIterable = SequencesKt.flattenSequenceOfIterable(mapNotNull)) == null || (filter = SequencesKt.filter(flattenSequenceOfIterable, new Function1<IntercomResponse, Boolean>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toAddressEntities$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(IntercomResponse intercomResponse) {
                return Boolean.valueOf((intercomResponse != null ? intercomResponse.getAddressId() : null) != null);
            }
        })) == null || (map = SequencesKt.map(filter, new Function1<IntercomResponse, AddressEntity>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toAddressEntities$3
            @Override // kotlin.jvm.functions.Function1
            public final AddressEntity invoke(IntercomResponse intercomResponse) {
                Integer addressId = intercomResponse != null ? intercomResponse.getAddressId() : null;
                Intrinsics.checkNotNull(addressId);
                return new AddressEntity(addressId.intValue(), intercomResponse.getAddress());
            }
        })) == null || (distinct = SequencesKt.distinct(map)) == null) {
            return null;
        }
        return SequencesKt.toList(distinct);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AddressEntity> toAddressEntities(AvailableReadersResponse availableReadersResponse) {
        Sequence asSequence;
        Sequence mapNotNull;
        Sequence flattenSequenceOfIterable;
        Sequence filter;
        Sequence map;
        Sequence distinct;
        Map<String, List<ReaderResponse>> addresses = availableReadersResponse.getAddresses();
        if (addresses == null || (asSequence = MapsKt.asSequence(addresses)) == null || (mapNotNull = SequencesKt.mapNotNull(asSequence, new Function1<Map.Entry<? extends String, ? extends List<? extends ReaderResponse>>, List<? extends ReaderResponse>>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toAddressEntities$4
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends ReaderResponse> invoke(Map.Entry<? extends String, ? extends List<? extends ReaderResponse>> entry) {
                return invoke2((Map.Entry<String, ? extends List<ReaderResponse>>) entry);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<ReaderResponse> invoke2(Map.Entry<String, ? extends List<ReaderResponse>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getValue();
            }
        })) == null || (flattenSequenceOfIterable = SequencesKt.flattenSequenceOfIterable(mapNotNull)) == null || (filter = SequencesKt.filter(flattenSequenceOfIterable, new Function1<ReaderResponse, Boolean>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toAddressEntities$5
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ReaderResponse readerResponse) {
                return Boolean.valueOf((readerResponse != null ? readerResponse.getAddressId() : null) != null);
            }
        })) == null || (map = SequencesKt.map(filter, new Function1<ReaderResponse, AddressEntity>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toAddressEntities$6
            @Override // kotlin.jvm.functions.Function1
            public final AddressEntity invoke(ReaderResponse readerResponse) {
                Integer addressId = readerResponse != null ? readerResponse.getAddressId() : null;
                Intrinsics.checkNotNull(addressId);
                return new AddressEntity(addressId.intValue(), readerResponse.getAddress());
            }
        })) == null || (distinct = SequencesKt.distinct(map)) == null) {
            return null;
        }
        return SequencesKt.toList(distinct);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<AddressEntity> toAddressEntities(AvailableStreamsResponse availableStreamsResponse) {
        List<BuildingResponse> buildings = availableStreamsResponse.getBuildings();
        if (buildings == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : buildings) {
            BuildingResponse buildingResponse = (BuildingResponse) obj;
            if ((buildingResponse != null ? buildingResponse.getId() : null) != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<BuildingResponse> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (BuildingResponse buildingResponse2 : arrayList2) {
            Integer id = buildingResponse2 != null ? buildingResponse2.getId() : null;
            Intrinsics.checkNotNull(id);
            arrayList3.add(new AddressEntity(id.intValue(), buildingResponse2.getAddress()));
        }
        return CollectionsKt.distinct(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013d A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<ru.tattelecom.intercom.data.local.entity.StreamEntity> toStreamEntities(ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse r21) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.AddressInteractor.toStreamEntities(ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<IntercomEntity> toIntercomEntities(AvailableIntercomsResponse availableIntercomsResponse) {
        Map<String, List<IntercomResponse>> addresses;
        if (availableIntercomsResponse.getAddresses() != null && (addresses = availableIntercomsResponse.getAddresses()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, List<IntercomResponse>>> it = addresses.entrySet().iterator();
            while (it.hasNext()) {
                List<IntercomResponse> value = it.next().getValue();
                if (value != null) {
                    arrayList.add(value);
                }
            }
            List flatten = CollectionsKt.flatten(arrayList);
            if (flatten != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : flatten) {
                    IntercomResponse intercomResponse = (IntercomResponse) obj;
                    if ((intercomResponse != null ? intercomResponse.getId() : null) != null && intercomResponse.getAddressId() != null) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList<IntercomResponse> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (IntercomResponse intercomResponse2 : arrayList3) {
                    Integer id = intercomResponse2 != null ? intercomResponse2.getId() : null;
                    Intrinsics.checkNotNull(id);
                    int intValue = id.intValue();
                    Integer addressId = intercomResponse2.getAddressId();
                    Intrinsics.checkNotNull(addressId);
                    int intValue2 = addressId.intValue();
                    String login = intercomResponse2.getLogin();
                    String name = intercomResponse2.getName();
                    Integer gateId = intercomResponse2.getGateId();
                    String gateName = intercomResponse2.getGateName();
                    Integer gateTypeId = intercomResponse2.getGateTypeId();
                    String streamUrlMpeg = intercomResponse2.getStreamUrlMpeg();
                    if (streamUrlMpeg == null) {
                        streamUrlMpeg = intercomResponse2.getStreamUrl();
                    }
                    String str = streamUrlMpeg;
                    String base64Preview = intercomResponse2.getBase64Preview();
                    boolean z = true;
                    boolean areEqual = Intrinsics.areEqual((Object) intercomResponse2.isMuted(), (Object) true);
                    Integer intercomEmergencyCode = intercomResponse2.getIntercomEmergencyCode();
                    Integer intercomEmergencyCodeUpdateTime = intercomResponse2.getIntercomEmergencyCodeUpdateTime();
                    Integer intercomTemporaryCode = intercomResponse2.getIntercomTemporaryCode();
                    Integer isFavorite = intercomResponse2.isFavorite();
                    if (isFavorite == null || isFavorite.intValue() != 1) {
                        z = false;
                    }
                    arrayList4.add(new IntercomEntity(intValue, intValue2, login, name, gateId, gateName, gateTypeId, str, base64Preview, areEqual, intercomEmergencyCode, intercomEmergencyCodeUpdateTime, intercomTemporaryCode, Boolean.valueOf(z), intercomResponse2.isExit()));
                }
                return arrayList4;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<IntercomEntity> toIntercomEntities(AvailableReadersResponse availableReadersResponse) {
        Map<String, List<ReaderResponse>> addresses;
        if (availableReadersResponse.getAddresses() != null && (addresses = availableReadersResponse.getAddresses()) != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, List<ReaderResponse>>> it = addresses.entrySet().iterator();
            while (it.hasNext()) {
                List<ReaderResponse> value = it.next().getValue();
                if (value != null) {
                    arrayList.add(value);
                }
            }
            List flatten = CollectionsKt.flatten(arrayList);
            if (flatten != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : flatten) {
                    ReaderResponse readerResponse = (ReaderResponse) obj;
                    if ((readerResponse != null ? readerResponse.getId() : null) != null && readerResponse.getAddressId() != null) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList<ReaderResponse> arrayList3 = arrayList2;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                for (ReaderResponse readerResponse2 : arrayList3) {
                    Integer id = readerResponse2 != null ? readerResponse2.getId() : null;
                    Intrinsics.checkNotNull(id);
                    int intValue = id.intValue();
                    Integer addressId = readerResponse2.getAddressId();
                    Intrinsics.checkNotNull(addressId);
                    arrayList4.add(new IntercomEntity(intValue, addressId.intValue(), null, null, readerResponse2.getGateId(), readerResponse2.getGateName(), readerResponse2.getGateTypeId(), null, null, true, null, null, null, Boolean.valueOf(Intrinsics.areEqual((Object) readerResponse2.isFavorite(), (Object) true)), true));
                }
                return arrayList4;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ApartmentEntity> toApartmentEntities(AvailableIntercomsResponse availableIntercomsResponse) {
        ArrayList arrayList;
        List<ApartmentResponse> apartments = availableIntercomsResponse.getApartments();
        if (apartments == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : apartments) {
            if (((ApartmentResponse) obj).getId() != null) {
                arrayList2.add(obj);
            }
        }
        ArrayList<ApartmentResponse> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        for (ApartmentResponse apartmentResponse : arrayList3) {
            Integer id = apartmentResponse.getId();
            Intrinsics.checkNotNull(id);
            int intValue = id.intValue();
            Integer buildingId = apartmentResponse.getBuildingId();
            String address = apartmentResponse.getAddress();
            List<Guest> guests = apartmentResponse.getGuests();
            if (guests != null) {
                ArrayList arrayList5 = new ArrayList();
                Iterator<T> it = guests.iterator();
                while (it.hasNext()) {
                    String phone = ((Guest) it.next()).getPhone();
                    if (phone != null) {
                        arrayList5.add(phone);
                    }
                }
                arrayList = arrayList5;
            } else {
                arrayList = null;
            }
            arrayList4.add(new ApartmentEntity(intValue, buildingId, address, arrayList, apartmentResponse.getRemainingInvites(), apartmentResponse.getIntercomTemporaryCode()));
        }
        return arrayList4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ApartmentTemporaryCodeEntity> toApartmentTemporaryCodeEntities(AvailableIntercomsResponse availableIntercomsResponse) {
        List<ApartmentResponse> apartments = availableIntercomsResponse.getApartments();
        if (apartments == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : apartments) {
            if (((ApartmentResponse) obj).getId() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList<ApartmentResponse> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (ApartmentResponse apartmentResponse : arrayList2) {
            Integer id = apartmentResponse.getId();
            Intrinsics.checkNotNull(id);
            arrayList3.add(new ApartmentTemporaryCodeEntity(id.intValue(), apartmentResponse.getAddress(), apartmentResponse.getIntercomTemporaryCode()));
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ApartmentServicesEntity> toApartmentServicesEntities(AvailableIntercomsResponse availableIntercomsResponse) {
        ArrayList arrayList;
        List<ApartmentResponse> apartments = availableIntercomsResponse.getApartments();
        if (apartments == null) {
            return null;
        }
        ArrayList<ApartmentResponse> arrayList2 = new ArrayList();
        for (Object obj : apartments) {
            if (((ApartmentResponse) obj).getId() != null) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (ApartmentResponse apartmentResponse : arrayList2) {
            List<Services> services = apartmentResponse.getServices();
            if (services != null) {
                List<Services> list = services;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (Services services2 : list) {
                    Integer id = services2.getId();
                    Intrinsics.checkNotNull(id);
                    int intValue = id.intValue();
                    Integer buildingId = apartmentResponse.getBuildingId();
                    Intrinsics.checkNotNull(buildingId);
                    int intValue2 = buildingId.intValue();
                    Integer id2 = apartmentResponse.getId();
                    Intrinsics.checkNotNull(id2);
                    arrayList4.add(new ApartmentServicesEntity(intValue, intValue2, id2.intValue(), services2.getName(), services2.getActive()));
                }
                arrayList = arrayList4;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                arrayList3.add(arrayList);
            }
        }
        return CollectionsKt.flatten(arrayList3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ScheduleEntity> toScheduleEntities(AvailableIntercomsResponse availableIntercomsResponse) {
        Sequence asSequence;
        Sequence mapNotNull;
        Sequence flattenSequenceOfIterable;
        Sequence filter;
        Sequence mapNotNull2;
        Sequence flattenSequenceOfIterable2;
        Map<String, List<IntercomResponse>> addresses = availableIntercomsResponse.getAddresses();
        if (addresses == null || (asSequence = MapsKt.asSequence(addresses)) == null || (mapNotNull = SequencesKt.mapNotNull(asSequence, new Function1<Map.Entry<? extends String, ? extends List<? extends IntercomResponse>>, List<? extends IntercomResponse>>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toScheduleEntities$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends IntercomResponse> invoke(Map.Entry<? extends String, ? extends List<? extends IntercomResponse>> entry) {
                return invoke2((Map.Entry<String, ? extends List<IntercomResponse>>) entry);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<IntercomResponse> invoke2(Map.Entry<String, ? extends List<IntercomResponse>> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getValue();
            }
        })) == null || (flattenSequenceOfIterable = SequencesKt.flattenSequenceOfIterable(mapNotNull)) == null || (filter = SequencesKt.filter(flattenSequenceOfIterable, new Function1<IntercomResponse, Boolean>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toScheduleEntities$2
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(IntercomResponse intercomResponse) {
                return Boolean.valueOf((intercomResponse != null ? intercomResponse.getId() : null) != null);
            }
        })) == null || (mapNotNull2 = SequencesKt.mapNotNull(filter, new Function1<IntercomResponse, List<? extends ScheduleEntity>>() { // from class: ru.tattelecom.intercom.domain.interactors.AddressInteractor$toScheduleEntities$3
            @Override // kotlin.jvm.functions.Function1
            public final List<ScheduleEntity> invoke(IntercomResponse intercomResponse) {
                List<ScheduleResponse> schedules;
                if (intercomResponse == null || (schedules = intercomResponse.getSchedules()) == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : schedules) {
                    if (((ScheduleResponse) obj).getId() != null) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                for (Iterator it = arrayList2.iterator(); it.hasNext(); it = it) {
                    ScheduleResponse scheduleResponse = (ScheduleResponse) it.next();
                    Integer id = scheduleResponse.getId();
                    Intrinsics.checkNotNull(id);
                    int intValue = id.intValue();
                    Integer id2 = intercomResponse.getId();
                    Intrinsics.checkNotNull(id2);
                    arrayList3 = arrayList3;
                    arrayList3.add(new ScheduleEntity(intValue, id2.intValue(), scheduleResponse.getStartHour(), scheduleResponse.getStartMinute(), scheduleResponse.getFinishHour(), scheduleResponse.getFinishMinute(), Intrinsics.areEqual((Object) scheduleResponse.getMonday(), (Object) true), Intrinsics.areEqual((Object) scheduleResponse.getTuesday(), (Object) true), Intrinsics.areEqual((Object) scheduleResponse.getWednesday(), (Object) true), Intrinsics.areEqual((Object) scheduleResponse.getThursday(), (Object) true), Intrinsics.areEqual((Object) scheduleResponse.getFriday(), (Object) true), Intrinsics.areEqual((Object) scheduleResponse.getSaturday(), (Object) true), Intrinsics.areEqual((Object) scheduleResponse.getSunday(), (Object) true)));
                }
                return arrayList3;
            }
        })) == null || (flattenSequenceOfIterable2 = SequencesKt.flattenSequenceOfIterable(mapNotNull2)) == null) {
            return null;
        }
        return SequencesKt.toList(flattenSequenceOfIterable2);
    }
}
