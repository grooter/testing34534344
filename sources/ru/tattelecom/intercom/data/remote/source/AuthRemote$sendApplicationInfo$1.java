package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.ts.TsExtractor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: AuthRemote.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.data.remote.source.AuthRemote", f = "AuthRemote.kt", i = {}, l = {137, TsExtractor.TS_STREAM_TYPE_DTS}, m = "sendApplicationInfo", n = {}, s = {})
/* loaded from: classes5.dex */
final class AuthRemote$sendApplicationInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthRemote this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AuthRemote$sendApplicationInfo$1(AuthRemote authRemote, Continuation<? super AuthRemote$sendApplicationInfo$1> continuation) {
        super(continuation);
        this.this$0 = authRemote;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendApplicationInfo(null, null, null, null, null, null, null, null, this);
    }
}
