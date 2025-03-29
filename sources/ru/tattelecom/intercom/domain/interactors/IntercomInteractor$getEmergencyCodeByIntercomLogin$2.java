package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: IntercomInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.IntercomInteractor$getEmergencyCodeByIntercomLogin$2", f = "IntercomInteractor.kt", i = {0}, l = {74, 77}, m = "invokeSuspend", n = {"dateInSecond"}, s = {"J$0"})
/* loaded from: classes5.dex */
final class IntercomInteractor$getEmergencyCodeByIntercomLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ String $intercomLogin;
    long J$0;
    int label;
    final /* synthetic */ IntercomInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntercomInteractor$getEmergencyCodeByIntercomLogin$2(IntercomInteractor intercomInteractor, String str, Continuation<? super IntercomInteractor$getEmergencyCodeByIntercomLogin$2> continuation) {
        super(2, continuation);
        this.this$0 = intercomInteractor;
        this.$intercomLogin = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomInteractor$getEmergencyCodeByIntercomLogin$2(this.this$0, this.$intercomLogin, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((IntercomInteractor$getEmergencyCodeByIntercomLogin$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0085 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0080  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7c
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            long r3 = r7.J$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L48
        L20:
            kotlin.ResultKt.throwOnFailure(r8)
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            long r4 = r1.getTimeInMillis()
            long r4 = r8.toSeconds(r4)
            ru.tattelecom.intercom.domain.interactors.IntercomInteractor r8 = r7.this$0
            ru.tattelecom.intercom.data.local.dao.IntercomDao r8 = ru.tattelecom.intercom.domain.interactors.IntercomInteractor.access$getIntercomDao$p(r8)
            java.lang.String r1 = r7.$intercomLogin
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.J$0 = r4
            r7.label = r3
            java.lang.Object r8 = r8.getByLogin(r1, r6)
            if (r8 != r0) goto L47
            return r0
        L47:
            r3 = r4
        L48:
            ru.tattelecom.intercom.data.local.entity.IntercomEntity r8 = (ru.tattelecom.intercom.data.local.entity.IntercomEntity) r8
            r1 = 0
            if (r8 == 0) goto L58
            java.lang.Integer r8 = r8.getIntercomEmergencyCodeUpdateTime()
            if (r8 == 0) goto L58
            int r8 = r8.intValue()
            goto L59
        L58:
            r8 = r1
        L59:
            long r5 = (long) r8
            long r3 = r3 - r5
            r8 = 86400(0x15180, float:1.21072E-40)
            long r5 = (long) r8
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 <= 0) goto L68
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            goto L86
        L68:
            ru.tattelecom.intercom.domain.interactors.IntercomInteractor r8 = r7.this$0
            ru.tattelecom.intercom.data.local.dao.IntercomDao r8 = ru.tattelecom.intercom.domain.interactors.IntercomInteractor.access$getIntercomDao$p(r8)
            java.lang.String r1 = r7.$intercomLogin
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.label = r2
            java.lang.Object r8 = r8.getByLogin(r1, r3)
            if (r8 != r0) goto L7c
            return r0
        L7c:
            ru.tattelecom.intercom.data.local.entity.IntercomEntity r8 = (ru.tattelecom.intercom.data.local.entity.IntercomEntity) r8
            if (r8 == 0) goto L85
            java.lang.Integer r8 = r8.getIntercomEmergencyCode()
            goto L86
        L85:
            r8 = 0
        L86:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.IntercomInteractor$getEmergencyCodeByIntercomLogin$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
