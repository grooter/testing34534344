package ru.tattelecom.intercom.feature.call_schedule;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: CallScheduleViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", CrashHianalyticsData.TIME, "Lkotlin/Pair;", "Ljava/util/Calendar;", "days", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel$isSaveScheduleAllowed$1", f = "CallScheduleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallScheduleViewModel$isSaveScheduleAllowed$1 extends SuspendLambda implements Function3<Pair<? extends Calendar, ? extends Calendar>, Boolean[], Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    CallScheduleViewModel$isSaveScheduleAllowed$1(Continuation<? super CallScheduleViewModel$isSaveScheduleAllowed$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Pair<? extends Calendar, ? extends Calendar> pair, Boolean[] boolArr, Continuation<? super Boolean> continuation) {
        CallScheduleViewModel$isSaveScheduleAllowed$1 callScheduleViewModel$isSaveScheduleAllowed$1 = new CallScheduleViewModel$isSaveScheduleAllowed$1(continuation);
        callScheduleViewModel$isSaveScheduleAllowed$1.L$0 = pair;
        callScheduleViewModel$isSaveScheduleAllowed$1.L$1 = boolArr;
        return callScheduleViewModel$isSaveScheduleAllowed$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001d, code lost:
    
        if (kotlin.collections.ArraysKt.contains(r0, kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)) != false) goto L10;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r3) {
        /*
            r2 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r2.label
            if (r0 != 0) goto L26
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.Object r3 = r2.L$0
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r0 = r2.L$1
            java.lang.Boolean[] r0 = (java.lang.Boolean[]) r0
            if (r3 == 0) goto L20
            r3 = 1
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r0 = kotlin.collections.ArraysKt.contains(r0, r1)
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = 0
        L21:
            java.lang.Boolean r3 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r3
        L26:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.call_schedule.CallScheduleViewModel$isSaveScheduleAllowed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
