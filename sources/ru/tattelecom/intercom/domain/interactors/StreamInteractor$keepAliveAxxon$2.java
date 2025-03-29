package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.model.StreamSourceDto;

/* compiled from: StreamInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.StreamInteractor$keepAliveAxxon$2", f = "StreamInteractor.kt", i = {}, l = {115, 117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class StreamInteractor$keepAliveAxxon$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StreamSourceDto.AxxonDto $axxonDto;
    int label;
    final /* synthetic */ StreamInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamInteractor$keepAliveAxxon$2(StreamSourceDto.AxxonDto axxonDto, StreamInteractor streamInteractor, Continuation<? super StreamInteractor$keepAliveAxxon$2> continuation) {
        super(2, continuation);
        this.$axxonDto = axxonDto;
        this.this$0 = streamInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamInteractor$keepAliveAxxon$2(this.$axxonDto, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StreamInteractor$keepAliveAxxon$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004e -> B:10:0x0025). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            r3 = 2
            if (r1 == 0) goto L1e
            if (r1 == r2) goto L1a
            if (r1 != r3) goto L12
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L25
            goto L25
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L39
        L1e:
            kotlin.ResultKt.throwOnFailure(r9)
            ru.tattelecom.intercom.domain.model.StreamSourceDto$AxxonDto r9 = r8.$axxonDto
            if (r9 == 0) goto L51
        L25:
            ru.tattelecom.intercom.domain.model.StreamSourceDto$AxxonDto r9 = r8.$axxonDto
            long r4 = r9.getKeepAliveMs()
            long r6 = (long) r3
            long r4 = r4 / r6
            r9 = r8
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r4, r9)
            if (r9 != r0) goto L39
            return r0
        L39:
            ru.tattelecom.intercom.domain.interactors.StreamInteractor r9 = r8.this$0     // Catch: java.lang.Exception -> L25
            ru.tattelecom.intercom.data.remote.source.StreamRemote r9 = r9.getRemote()     // Catch: java.lang.Exception -> L25
            ru.tattelecom.intercom.domain.model.StreamSourceDto$AxxonDto r1 = r8.$axxonDto     // Catch: java.lang.Exception -> L25
            java.lang.String r1 = r1.getKeepAliveUrl()     // Catch: java.lang.Exception -> L25
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Exception -> L25
            r8.label = r3     // Catch: java.lang.Exception -> L25
            java.lang.Object r9 = r9.keepAliveAxxon(r1, r4)     // Catch: java.lang.Exception -> L25
            if (r9 != r0) goto L25
            return r0
        L51:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.StreamInteractor$keepAliveAxxon$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
