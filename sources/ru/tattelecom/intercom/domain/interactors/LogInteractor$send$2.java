package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LogInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.LogInteractor$send$2", f = "LogInteractor.kt", i = {}, l = {27, 27, 28}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class LogInteractor$send$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sendLogsToken;
    Object L$0;
    int label;
    final /* synthetic */ LogInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LogInteractor$send$2(LogInteractor logInteractor, String str, Continuation<? super LogInteractor$send$2> continuation) {
        super(2, continuation);
        this.this$0 = logInteractor;
        this.$sendLogsToken = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogInteractor$send$2(this.this$0, this.$sendLogsToken, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogInteractor$send$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0084 A[Catch: Exception -> 0x0022, TRY_LEAVE, TryCatch #0 {Exception -> 0x0022, blocks: (B:7:0x0011, B:13:0x001e, B:14:0x0074, B:16:0x0084, B:20:0x0028, B:21:0x0061, B:28:0x0047), top: B:2:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2c
            if (r1 == r4) goto L24
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L22
            goto L99
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L22
            goto L74
        L22:
            r10 = move-exception
            goto L96
        L24:
            java.lang.Object r1 = r9.L$0
            ru.tattelecom.intercom.data.remote.source.LogRemote r1 = (ru.tattelecom.intercom.data.remote.source.LogRemote) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L22
            goto L61
        L2c:
            kotlin.ResultKt.throwOnFailure(r10)
            ru.tattelecom.intercom.domain.interactors.LogInteractor r10 = r9.this$0
            boolean r10 = r10.featRemoteLogging()
            if (r10 == 0) goto L99
            ru.tattelecom.intercom.domain.interactors.LogInteractor r10 = r9.this$0
            ru.tattelecom.intercom.data.local.dao.RemoteLogsDao r10 = ru.tattelecom.intercom.domain.interactors.LogInteractor.access$getLogsDao$p(r10)
            long r5 = r10.getLogsCount()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L99
            ru.tattelecom.intercom.domain.interactors.LogInteractor r10 = r9.this$0     // Catch: java.lang.Exception -> L22
            ru.tattelecom.intercom.data.remote.source.LogRemote r1 = ru.tattelecom.intercom.domain.interactors.LogInteractor.access$getLogsRemote$p(r10)     // Catch: java.lang.Exception -> L22
            ru.tattelecom.intercom.domain.interactors.LogInteractor r10 = r9.this$0     // Catch: java.lang.Exception -> L22
            ru.tattelecom.intercom.data.local.dao.RemoteLogsDao r10 = ru.tattelecom.intercom.domain.interactors.LogInteractor.access$getLogsDao$p(r10)     // Catch: java.lang.Exception -> L22
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Exception -> L22
            r9.L$0 = r1     // Catch: java.lang.Exception -> L22
            r9.label = r4     // Catch: java.lang.Exception -> L22
            java.lang.Object r10 = r10.getAllLogs(r5)     // Catch: java.lang.Exception -> L22
            if (r10 != r0) goto L61
            return r0
        L61:
            java.util.List r10 = (java.util.List) r10     // Catch: java.lang.Exception -> L22
            java.lang.String r5 = r9.$sendLogsToken     // Catch: java.lang.Exception -> L22
            r6 = r9
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L22
            r7 = 0
            r9.L$0 = r7     // Catch: java.lang.Exception -> L22
            r9.label = r3     // Catch: java.lang.Exception -> L22
            java.lang.Object r10 = r1.send(r10, r5, r6)     // Catch: java.lang.Exception -> L22
            if (r10 != r0) goto L74
            return r0
        L74:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r10 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r10     // Catch: java.lang.Exception -> L22
            java.lang.Boolean r10 = r10.isSuccess()     // Catch: java.lang.Exception -> L22
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Exception -> L22
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)     // Catch: java.lang.Exception -> L22
            if (r10 == 0) goto L99
            ru.tattelecom.intercom.domain.interactors.LogInteractor r10 = r9.this$0     // Catch: java.lang.Exception -> L22
            ru.tattelecom.intercom.data.local.dao.RemoteLogsDao r10 = ru.tattelecom.intercom.domain.interactors.LogInteractor.access$getLogsDao$p(r10)     // Catch: java.lang.Exception -> L22
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L22
            r9.label = r2     // Catch: java.lang.Exception -> L22
            java.lang.Object r10 = r10.clear(r1)     // Catch: java.lang.Exception -> L22
            if (r10 != r0) goto L99
            return r0
        L96:
            r10.printStackTrace()
        L99:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.LogInteractor$send$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
