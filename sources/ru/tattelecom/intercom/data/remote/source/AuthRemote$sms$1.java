package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AuthRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.AuthRemote", f = "AuthRemote.kt", i = {0, 0, 0, 0, 0}, l = {48, 137, TsExtractor.TS_STREAM_TYPE_DTS}, m = "sms", n = {"phone", "code", "deviceOS", "deviceCode", "$this$sms_u24lambda_u242"}, s = {"L$0", "L$1", "L$2", "L$3", "L$6"})
/* loaded from: classes5.dex */
final class AuthRemote$sms$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthRemote$sms$1(AuthRemote authRemote, Continuation<? super AuthRemote$sms$1> continuation) {
        super(continuation);
        this.this$0 = authRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sms(null, null, null, null, this);
    }
}
