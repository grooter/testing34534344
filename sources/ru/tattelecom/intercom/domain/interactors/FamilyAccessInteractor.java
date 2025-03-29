package ru.tattelecom.intercom.domain.interactors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.local.dao.ApartmentDao;
import ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao;
import ru.tattelecom.intercom.data.local.entity.ApartmentEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentGuestsEntity;
import ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity;
import ru.tattelecom.intercom.data.remote.model.ApartmentGuestsResponse;
import ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse;
import ru.tattelecom.intercom.data.remote.model.Guest;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.source.GuestRemote;

/* compiled from: FamilyAccessInteractor.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0086@¢\u0006\u0002\u0010!J\u0014\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001d0#J\u000e\u0010%\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\u001eJ\u001e\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010(J&\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010,J\u0014\u0010-\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u001d*\u00020.H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/FamilyAccessInteractor;", "", "guestRemote", "Lru/tattelecom/intercom/data/remote/source/GuestRemote;", "apartmentDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentDao;", "apartmentGuestsDao", "Lru/tattelecom/intercom/data/local/dao/ApartmentGuestsDao;", "database", "Lru/tattelecom/intercom/data/local/IntercomDatabase;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/remote/source/GuestRemote;Lru/tattelecom/intercom/data/local/dao/ApartmentDao;Lru/tattelecom/intercom/data/local/dao/ApartmentGuestsDao;Lru/tattelecom/intercom/data/local/IntercomDatabase;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "addTemporaryCode", "", "apartment", "Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;", "(Lru/tattelecom/intercom/data/local/entity/ApartmentTemporaryCodeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteGuest", NavArg.VerifyCode.APARTMENT_ID, "", "phone", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTemporaryCode", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateTemporaryCode", "getApartmentTemporaryCodes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getApartmentsById", "Lru/tattelecom/intercom/data/local/entity/ApartmentEntity;", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeApartments", "Lkotlinx/coroutines/flow/Flow;", "Lru/tattelecom/intercom/data/local/entity/ApartmentGuestsEntity;", "refreshGuestsList", "sendVerifyCode", NavArg.VerifyCode.GUEST_PHONE, "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyCode", "code", "", "(JLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toApartmentGuestsEntities", "Lru/tattelecom/intercom/data/remote/model/ApartmentsGuestsResponse;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FamilyAccessInteractor {
    private final ApartmentDao apartmentDao;
    private final ApartmentGuestsDao apartmentGuestsDao;
    private final IntercomDatabase database;
    private final AppCoroutineDispatchers dispatchers;
    private final GuestRemote guestRemote;

    public FamilyAccessInteractor(GuestRemote guestRemote, ApartmentDao apartmentDao, ApartmentGuestsDao apartmentGuestsDao, IntercomDatabase database, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(guestRemote, "guestRemote");
        Intrinsics.checkNotNullParameter(apartmentDao, "apartmentDao");
        Intrinsics.checkNotNullParameter(apartmentGuestsDao, "apartmentGuestsDao");
        Intrinsics.checkNotNullParameter(database, "database");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.guestRemote = guestRemote;
        this.apartmentDao = apartmentDao;
        this.apartmentGuestsDao = apartmentGuestsDao;
        this.database = database;
        this.dispatchers = dispatchers;
    }

    public final Flow<List<ApartmentGuestsEntity>> observeApartments() {
        return this.apartmentGuestsDao.observeAll();
    }

    public final Object getApartmentTemporaryCodes(Continuation<? super List<ApartmentTemporaryCodeEntity>> continuation) {
        return this.apartmentDao.observeAllTemporaryCodes(continuation);
    }

    public final Object sendVerifyCode(String str, int i, Continuation<? super Unit> continuation) {
        Object sendSms = this.guestRemote.sendSms(str, i, continuation);
        return sendSms == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendSms : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object verifyCode(long r10, java.lang.String r12, int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r9 = this;
            boolean r0 = r14 instanceof ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$verifyCode$1
            if (r0 == 0) goto L14
            r0 = r14
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$verifyCode$1 r0 = (ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$verifyCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$verifyCode$1 r0 = new ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$verifyCode$1
            r0.<init>(r9, r14)
        L19:
            java.lang.Object r14 = r0.result
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 == r2) goto L35
            if (r1 != r8) goto L2d
            kotlin.ResultKt.throwOnFailure(r14)
            goto L5e
        L2d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L35:
            java.lang.Object r10 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r10 = (ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor) r10
            kotlin.ResultKt.throwOnFailure(r14)
            goto L52
        L3d:
            kotlin.ResultKt.throwOnFailure(r14)
            ru.tattelecom.intercom.data.remote.source.GuestRemote r1 = r9.guestRemote
            r0.L$0 = r9
            r0.label = r2
            r2 = r10
            r4 = r12
            r5 = r13
            r6 = r0
            java.lang.Object r10 = r1.register(r2, r4, r5, r6)
            if (r10 != r7) goto L51
            return r7
        L51:
            r10 = r9
        L52:
            r11 = 0
            r0.L$0 = r11
            r0.label = r8
            java.lang.Object r10 = r10.refreshGuestsList(r0)
            if (r10 != r7) goto L5e
            return r7
        L5e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor.verifyCode(long, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0059 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteGuest(int r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$deleteGuest$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$deleteGuest$1 r0 = (ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$deleteGuest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$deleteGuest$1 r0 = new ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$deleteGuest$1
            r0.<init>(r5, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L5a
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r6 = (ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor) r6
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4e
        L3d:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.tattelecom.intercom.data.remote.source.GuestRemote r8 = r5.guestRemote
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r8.delete(r7, r6, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            r6 = r5
        L4e:
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r6.refreshGuestsList(r0)
            if (r6 != r1) goto L5a
            return r1
        L5a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor.deleteGuest(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object refreshGuestsList(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new FamilyAccessInteractor$refreshGuestsList$2(this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ApartmentGuestsEntity> toApartmentGuestsEntities(ApartmentsGuestsResponse apartmentsGuestsResponse) {
        List filterNotNull;
        List<ApartmentGuestsResponse> apartments = apartmentsGuestsResponse.getApartments();
        if (apartments == null || (filterNotNull = CollectionsKt.filterNotNull(apartments)) == null) {
            return null;
        }
        List<ApartmentGuestsResponse> list = filterNotNull;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ApartmentGuestsResponse apartmentGuestsResponse : list) {
            int id = apartmentGuestsResponse.getId();
            String address = apartmentGuestsResponse.getAddress();
            List<Guest> guests = apartmentGuestsResponse.getGuests();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = guests.iterator();
            while (it.hasNext()) {
                String phone = ((Guest) it.next()).getPhone();
                if (phone != null) {
                    arrayList2.add(phone);
                }
            }
            ArrayList arrayList3 = arrayList2;
            int remainingInvites = apartmentGuestsResponse.getRemainingInvites();
            Boolean isMaster = apartmentGuestsResponse.isMaster();
            arrayList.add(new ApartmentGuestsEntity(id, address, arrayList3, remainingInvites, isMaster != null ? isMaster.booleanValue() : false));
        }
        return arrayList;
    }

    public final Object generateTemporaryCode(int i, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new FamilyAccessInteractor$generateTemporaryCode$2(this, i, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object addTemporaryCode(ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$addTemporaryCode$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$addTemporaryCode$1 r0 = (ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$addTemporaryCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$addTemporaryCode$1 r0 = new ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$addTemporaryCode$1
            r0.<init>(r5, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6c
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            java.lang.Object r6 = r0.L$1
            ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity r6 = (ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity) r6
            java.lang.Object r2 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r2 = (ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L54
        L41:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r7 = r5.apartmentDao
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.addTemporaryCode(r6, r0)
            if (r7 != r1) goto L53
            return r1
        L53:
            r2 = r5
        L54:
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r7 = r2.apartmentDao
            int r2 = r6.getApartmentId()
            java.lang.Integer r6 = r6.getTemporaryCode()
            r4 = 0
            r0.L$0 = r4
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r6 = r7.updateTemporaryCode(r2, r6, r0)
            if (r6 != r1) goto L6c
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor.addTemporaryCode(ru.tattelecom.intercom.data.local.entity.ApartmentTemporaryCodeEntity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object deleteTemporaryCode(int i, Continuation<? super StatusResponse> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new FamilyAccessInteractor$deleteTemporaryCode$2(this, i, null), continuation);
    }

    public final Object getApartmentsById(Integer num, Continuation<? super ApartmentEntity> continuation) {
        return this.database.apartmentDao().getApartmentsById(num, continuation);
    }
}
