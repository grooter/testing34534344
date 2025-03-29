package ru.tattelecom.intercom.data.remote.source;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: GuestRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.GuestRemote", f = "GuestRemote.kt", i = {0, 0, 0, 0, 0}, l = {52, 126, 127}, m = "register", n = {"this", "phone", "$this$register_u24lambda_u242", "smsCode", NavArg.VerifyCode.APARTMENT_ID}, s = {"L$0", "L$1", "L$4", "J$0", "I$0"})
/* loaded from: classes5.dex */
final class GuestRemote$register$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuestRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GuestRemote$register$1(GuestRemote guestRemote, Continuation<? super GuestRemote$register$1> continuation) {
        super(continuation);
        this.this$0 = guestRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.register(0L, null, 0, this);
    }
}
