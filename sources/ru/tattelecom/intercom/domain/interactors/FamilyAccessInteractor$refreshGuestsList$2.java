package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.local.IntercomDatabase;
import ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse;
import ru.tattelecom.intercom.data.remote.source.GuestRemote;

/* compiled from: FamilyAccessInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$refreshGuestsList$2", f = "FamilyAccessInteractor.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FamilyAccessInteractor$refreshGuestsList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FamilyAccessInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FamilyAccessInteractor$refreshGuestsList$2(FamilyAccessInteractor familyAccessInteractor, Continuation<? super FamilyAccessInteractor$refreshGuestsList$2> continuation) {
        super(2, continuation);
        this.this$0 = familyAccessInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyAccessInteractor$refreshGuestsList$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FamilyAccessInteractor$refreshGuestsList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        GuestRemote guestRemote;
        final IntercomDatabase intercomDatabase;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            guestRemote = this.this$0.guestRemote;
            this.label = 1;
            obj = guestRemote.getAll(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        final ApartmentsGuestsResponse apartmentsGuestsResponse = (ApartmentsGuestsResponse) obj;
        intercomDatabase = this.this$0.database;
        final FamilyAccessInteractor familyAccessInteractor = this.this$0;
        intercomDatabase.runInTransaction(new Runnable() { // from class: ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$refreshGuestsList$2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                FamilyAccessInteractor$refreshGuestsList$2.invokeSuspend$lambda$2$lambda$1(IntercomDatabase.this, apartmentsGuestsResponse, familyAccessInteractor);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
    
        r2 = r3.toApartmentGuestsEntities(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void invokeSuspend$lambda$2$lambda$1(ru.tattelecom.intercom.data.local.IntercomDatabase r1, ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse r2, ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r3) {
        /*
            ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao r0 = r1.apartmentGuestsDao()
            r0.clear()
            if (r2 == 0) goto L16
            java.util.List r2 = ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor.access$toApartmentGuestsEntities(r3, r2)
            if (r2 == 0) goto L16
            ru.tattelecom.intercom.data.local.dao.ApartmentGuestsDao r1 = r1.apartmentGuestsDao()
            r1.add(r2)
        L16:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$refreshGuestsList$2.invokeSuspend$lambda$2$lambda$1(ru.tattelecom.intercom.data.local.IntercomDatabase, ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse, ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor):void");
    }
}
