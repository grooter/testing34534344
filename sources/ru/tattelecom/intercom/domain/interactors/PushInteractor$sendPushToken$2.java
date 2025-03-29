package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PushInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.PushInteractor$sendPushToken$2", f = "PushInteractor.kt", i = {}, l = {102, 109}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class PushInteractor$sendPushToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ PushInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushInteractor$sendPushToken$2(PushInteractor pushInteractor, Continuation<? super PushInteractor$sendPushToken$2> continuation) {
        super(2, continuation);
        this.this$0 = pushInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushInteractor$sendPushToken$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((PushInteractor$sendPushToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x009b  */
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
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L20
            if (r1 == r4) goto L1c
            if (r1 != r2) goto L14
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L98
            goto L95
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1c:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L31
        L20:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.tattelecom.intercom.domain.interactors.PushInteractor r8 = r7.this$0
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r4
            java.lang.Object r8 = ru.tattelecom.intercom.domain.interactors.PushInteractor.access$getPushInfo(r8, r1)
            if (r8 != r0) goto L31
            return r0
        L31:
            ru.tattelecom.intercom.data.prefs.model.PushInfo r8 = (ru.tattelecom.intercom.data.prefs.model.PushInfo) r8
            java.lang.String r1 = r8.getPushService()
            if (r1 == 0) goto Lb0
            ru.tattelecom.intercom.domain.interactors.PushInteractor r5 = r7.this$0
            java.lang.String r8 = r8.getPushToken()
            if (r8 == 0) goto Lb0
            r6 = r1
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto Lb0
            r6 = r8
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            int r6 = r6.length()
            if (r6 <= 0) goto L55
            r6 = r4
            goto L56
        L55:
            r6 = r3
        L56:
            if (r6 == 0) goto Lb0
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = ru.tattelecom.intercom.domain.interactors.PushInteractor.access$getUserPrefs$p(r5)
            java.lang.String r6 = r6.getPhoneNumber()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L6d
            int r6 = r6.length()
            if (r6 != 0) goto L6b
            goto L6d
        L6b:
            r6 = r3
            goto L6e
        L6d:
            r6 = r4
        L6e:
            if (r6 != 0) goto Lb0
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = ru.tattelecom.intercom.domain.interactors.PushInteractor.access$getUserPrefs$p(r5)
            java.lang.String r6 = r6.getToken()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L85
            int r6 = r6.length()
            if (r6 != 0) goto L83
            goto L85
        L83:
            r6 = r3
            goto L86
        L85:
            r6 = r4
        L86:
            if (r6 != 0) goto Lb0
            ru.tattelecom.intercom.data.remote.source.PushRemote r5 = ru.tattelecom.intercom.domain.interactors.PushInteractor.access$getRemote$p(r5)     // Catch: java.lang.Exception -> L98
            r7.label = r2     // Catch: java.lang.Exception -> L98
            java.lang.Object r8 = r5.updatePushToken(r1, r8, r7)     // Catch: java.lang.Exception -> L98
            if (r8 != r0) goto L95
            return r0
        L95:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r8 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r8     // Catch: java.lang.Exception -> L98
            goto L99
        L98:
            r8 = 0
        L99:
            if (r8 == 0) goto La8
            java.lang.Boolean r8 = r8.isSuccess()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            goto La9
        La8:
            r8 = r3
        La9:
            if (r8 == 0) goto Lb0
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        Lb0:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.PushInteractor$sendPushToken$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
