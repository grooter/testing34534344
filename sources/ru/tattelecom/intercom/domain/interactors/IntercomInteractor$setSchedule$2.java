package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IntercomInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.IntercomInteractor$setSchedule$2", f = "IntercomInteractor.kt", i = {}, l = {55, 56, 57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class IntercomInteractor$setSchedule$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Boolean[] $days;
    final /* synthetic */ Pair<Integer, Integer> $finishTime;
    final /* synthetic */ int $intercomId;
    final /* synthetic */ Integer $scheduleId;
    final /* synthetic */ Pair<Integer, Integer> $startTime;
    int label;
    final /* synthetic */ IntercomInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntercomInteractor$setSchedule$2(Integer num, IntercomInteractor intercomInteractor, int i, Pair<Integer, Integer> pair, Pair<Integer, Integer> pair2, Boolean[] boolArr, Continuation<? super IntercomInteractor$setSchedule$2> continuation) {
        super(2, continuation);
        this.$scheduleId = num;
        this.this$0 = intercomInteractor;
        this.$intercomId = i;
        this.$startTime = pair;
        this.$finishTime = pair2;
        this.$days = boolArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomInteractor$setSchedule$2(this.$scheduleId, this.this$0, this.$intercomId, this.$startTime, this.$finishTime, this.$days, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntercomInteractor$setSchedule$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6f
        L15:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1d:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L5d
        L21:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L41
        L25:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.Integer r11 = r10.$scheduleId
            if (r11 == 0) goto L43
            ru.tattelecom.intercom.domain.interactors.IntercomInteractor r1 = r10.this$0
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            ru.tattelecom.intercom.data.remote.source.IntercomRemote r1 = ru.tattelecom.intercom.domain.interactors.IntercomInteractor.access$getRemote$p(r1)
            r10.label = r4
            java.lang.Object r11 = r1.deleteSchedule(r11, r10)
            if (r11 != r0) goto L41
            return r0
        L41:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r11 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r11
        L43:
            ru.tattelecom.intercom.domain.interactors.IntercomInteractor r11 = r10.this$0
            ru.tattelecom.intercom.data.remote.source.IntercomRemote r4 = ru.tattelecom.intercom.domain.interactors.IntercomInteractor.access$getRemote$p(r11)
            int r5 = r10.$intercomId
            kotlin.Pair<java.lang.Integer, java.lang.Integer> r6 = r10.$startTime
            kotlin.Pair<java.lang.Integer, java.lang.Integer> r7 = r10.$finishTime
            java.lang.Boolean[] r8 = r10.$days
            r9 = r10
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r10.label = r3
            java.lang.Object r11 = r4.setSchedule(r5, r6, r7, r8, r9)
            if (r11 != r0) goto L5d
            return r0
        L5d:
            ru.tattelecom.intercom.domain.interactors.IntercomInteractor r11 = r10.this$0
            ru.tattelecom.intercom.domain.interactors.AddressInteractor r11 = ru.tattelecom.intercom.domain.interactors.IntercomInteractor.access$getAddressInteractor$p(r11)
            r1 = r10
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r10.label = r2
            java.lang.Object r11 = r11.refreshAll(r1)
            if (r11 != r0) goto L6f
            return r0
        L6f:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.IntercomInteractor$setSchedule$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
