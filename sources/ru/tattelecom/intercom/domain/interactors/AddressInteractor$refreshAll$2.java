package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AddressInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.AddressInteractor$refreshAll$2", f = "AddressInteractor.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3}, l = {55, 56, 57, 58}, m = "invokeSuspend", n = {"intercomsRequest", "streamsRequest", "readerRequest", "streamsRequest", "readerRequest", "sipSettingsResponse", "readerRequest", "sipSettingsResponse", "intercomsResponse", "sipSettingsResponse", "intercomsResponse", "streamsResponse"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* loaded from: classes5.dex */
final class AddressInteractor$refreshAll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AddressInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddressInteractor$refreshAll$2(AddressInteractor addressInteractor, Continuation<? super AddressInteractor$refreshAll$2> continuation) {
        super(2, continuation);
        this.this$0 = addressInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AddressInteractor$refreshAll$2 addressInteractor$refreshAll$2 = new AddressInteractor$refreshAll$2(this.this$0, continuation);
        addressInteractor$refreshAll$2.L$0 = obj;
        return addressInteractor$refreshAll$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddressInteractor$refreshAll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0102  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.AddressInteractor$refreshAll$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
    
        r6 = r4.toAddressEntities(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
    
        r6 = r4.toApartmentEntities(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        r6 = r4.toApartmentTemporaryCodeEntities(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007e, code lost:
    
        r6 = r4.toApartmentServicesEntities(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0094, code lost:
    
        r5 = r4.toScheduleEntities(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
    
        r3 = r4.toStreamEntities(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0033, code lost:
    
        r0 = r4.toAddressEntities(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0042, code lost:
    
        r0 = r4.toAddressEntities(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void invokeSuspend$lambda$11$lambda$10(ru.tattelecom.intercom.data.local.IntercomDatabase r2, ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse r3, ru.tattelecom.intercom.domain.interactors.AddressInteractor r4, ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse r5, ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse r6, java.util.List r7) {
        /*
            ru.tattelecom.intercom.data.local.dao.ScheduleDao r0 = r2.scheduleDao()
            r0.clear()
            ru.tattelecom.intercom.data.local.dao.IntercomDao r0 = r2.intercomDao()
            r0.clear()
            ru.tattelecom.intercom.data.local.dao.StreamDao r0 = r2.streamDao()
            r0.clear()
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r0 = r2.apartmentDao()
            r0.clear()
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r0 = r2.apartmentDao()
            r0.clearTemporaryCodes()
            ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao r0 = r2.apartmentServicesDao()
            r0.clear()
            ru.tattelecom.intercom.data.local.dao.AddressDao r0 = r2.addressDao()
            r0.clear()
            if (r3 == 0) goto L40
            java.util.List r0 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toAddressEntities(r4, r3)
            if (r0 == 0) goto L40
            ru.tattelecom.intercom.data.local.dao.AddressDao r1 = r2.addressDao()
            r1.add(r0)
        L40:
            if (r5 == 0) goto L4f
            java.util.List r0 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toAddressEntities(r4, r5)
            if (r0 == 0) goto L4f
            ru.tattelecom.intercom.data.local.dao.AddressDao r1 = r2.addressDao()
            r1.add(r0)
        L4f:
            if (r6 == 0) goto L5e
            java.util.List r6 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toAddressEntities(r4, r6)
            if (r6 == 0) goto L5e
            ru.tattelecom.intercom.data.local.dao.AddressDao r0 = r2.addressDao()
            r0.add(r6)
        L5e:
            if (r5 == 0) goto L6d
            java.util.List r6 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toApartmentEntities(r4, r5)
            if (r6 == 0) goto L6d
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r0 = r2.apartmentDao()
            r0.add(r6)
        L6d:
            if (r5 == 0) goto L7c
            java.util.List r6 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toApartmentTemporaryCodeEntities(r4, r5)
            if (r6 == 0) goto L7c
            ru.tattelecom.intercom.data.local.dao.ApartmentDao r0 = r2.apartmentDao()
            r0.addTemporaryCodes(r6)
        L7c:
            if (r5 == 0) goto L8b
            java.util.List r6 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toApartmentServicesEntities(r4, r5)
            if (r6 == 0) goto L8b
            ru.tattelecom.intercom.data.local.dao.ApartmentServicesDao r0 = r2.apartmentServicesDao()
            r0.add(r6)
        L8b:
            ru.tattelecom.intercom.data.local.dao.IntercomDao r6 = r2.intercomDao()
            r6.add(r7)
            if (r5 == 0) goto La1
            java.util.List r5 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toScheduleEntities(r4, r5)
            if (r5 == 0) goto La1
            ru.tattelecom.intercom.data.local.dao.ScheduleDao r6 = r2.scheduleDao()
            r6.add(r5)
        La1:
            if (r3 == 0) goto Lb0
            java.util.List r3 = ru.tattelecom.intercom.domain.interactors.AddressInteractor.access$toStreamEntities(r4, r3)
            if (r3 == 0) goto Lb0
            ru.tattelecom.intercom.data.local.dao.StreamDao r2 = r2.streamDao()
            r2.add(r3)
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.AddressInteractor$refreshAll$2.invokeSuspend$lambda$11$lambda$10(ru.tattelecom.intercom.data.local.IntercomDatabase, ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse, ru.tattelecom.intercom.domain.interactors.AddressInteractor, ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse, ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse, java.util.List):void");
    }
}
