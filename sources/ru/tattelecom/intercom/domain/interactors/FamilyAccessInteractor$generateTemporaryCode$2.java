package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FamilyAccessInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$generateTemporaryCode$2", f = "FamilyAccessInteractor.kt", i = {}, l = {70, 71}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class FamilyAccessInteractor$generateTemporaryCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $apartmentId;
    int label;
    final /* synthetic */ FamilyAccessInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FamilyAccessInteractor$generateTemporaryCode$2(FamilyAccessInteractor familyAccessInteractor, int i, Continuation<? super FamilyAccessInteractor$generateTemporaryCode$2> continuation) {
        super(2, continuation);
        this.this$0 = familyAccessInteractor;
        this.$apartmentId = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FamilyAccessInteractor$generateTemporaryCode$2(this.this$0, this.$apartmentId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((FamilyAccessInteractor$generateTemporaryCode$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0047  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r6)
            goto L43
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L2f
        L1e:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r3
            r3 = 300(0x12c, double:1.48E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r3, r6)
            if (r6 != r0) goto L2f
            return r0
        L2f:
            ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor r6 = r5.this$0
            ru.tattelecom.intercom.data.remote.source.GuestRemote r6 = ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor.access$getGuestRemote$p(r6)
            int r1 = r5.$apartmentId
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.label = r2
            java.lang.Object r6 = r6.setTemporaryCode(r1, r3)
            if (r6 != r0) goto L43
            return r0
        L43:
            ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse r6 = (ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse) r6
            if (r6 == 0) goto L4c
            java.lang.Integer r6 = r6.getIntercomTemporaryCode()
            goto L4d
        L4c:
            r6 = 0
        L4d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor$generateTemporaryCode$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
