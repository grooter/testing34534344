package ru.tattelecom.intercom.feature.leave_order;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* compiled from: LeaveOrderViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u008a@"}, d2 = {"<anonymous>", "", "phone", "", "name", "services", "", "Lru/tattelecom/intercom/feature/leave_order/Service;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.leave_order.LeaveOrderViewModel$isLeaveOrderAllowed$1", f = "LeaveOrderViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LeaveOrderViewModel$isLeaveOrderAllowed$1 extends SuspendLambda implements Function4<String, String, List<? extends Service>, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    LeaveOrderViewModel$isLeaveOrderAllowed$1(Continuation<? super LeaveOrderViewModel$isLeaveOrderAllowed$1> continuation) {
        super(4, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(String str, String str2, List<? extends Service> list, Continuation<? super Boolean> continuation) {
        return invoke2(str, str2, (List<Service>) list, continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String str, String str2, List<Service> list, Continuation<? super Boolean> continuation) {
        LeaveOrderViewModel$isLeaveOrderAllowed$1 leaveOrderViewModel$isLeaveOrderAllowed$1 = new LeaveOrderViewModel$isLeaveOrderAllowed$1(continuation);
        leaveOrderViewModel$isLeaveOrderAllowed$1.L$0 = str;
        leaveOrderViewModel$isLeaveOrderAllowed$1.L$1 = str2;
        leaveOrderViewModel$isLeaveOrderAllowed$1.L$2 = list;
        return leaveOrderViewModel$isLeaveOrderAllowed$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        List list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str2 = (String) this.L$0;
        return Boxing.boxBoolean((str2.length() <= 0 || str2.length() != 13 || (str = (String) this.L$1) == null || str.length() == 0 || (list = (List) this.L$2) == null || list.isEmpty()) ? false : true);
    }
}
