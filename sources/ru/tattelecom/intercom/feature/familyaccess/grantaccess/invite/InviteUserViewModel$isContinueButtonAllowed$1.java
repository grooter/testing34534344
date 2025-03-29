package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: InviteUserViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "phone", "", "invites", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$isContinueButtonAllowed$1", f = "InviteUserViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class InviteUserViewModel$isContinueButtonAllowed$1 extends SuspendLambda implements Function3<String, Integer, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    InviteUserViewModel$isContinueButtonAllowed$1(Continuation<? super InviteUserViewModel$isContinueButtonAllowed$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(String str, Integer num, Continuation<? super Boolean> continuation) {
        return invoke(str, num.intValue(), continuation);
    }

    public final Object invoke(String str, int i, Continuation<? super Boolean> continuation) {
        InviteUserViewModel$isContinueButtonAllowed$1 inviteUserViewModel$isContinueButtonAllowed$1 = new InviteUserViewModel$isContinueButtonAllowed$1(continuation);
        inviteUserViewModel$isContinueButtonAllowed$1.L$0 = str;
        inviteUserViewModel$isContinueButtonAllowed$1.I$0 = i;
        return inviteUserViewModel$isContinueButtonAllowed$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) this.L$0;
        String str2 = str;
        return Boxing.boxBoolean(str2 != null && str2.length() != 0 && str.length() == 13 && this.I$0 > 0);
    }
}
