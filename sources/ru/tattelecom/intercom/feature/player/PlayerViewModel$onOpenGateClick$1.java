package ru.tattelecom.intercom.feature.player;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$onOpenGateClick$1", f = "PlayerViewModel.kt", i = {}, l = {362, 363, 367}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerViewModel$onOpenGateClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$onOpenGateClick$1(PlayerViewModel playerViewModel, Continuation<? super PlayerViewModel$onOpenGateClick$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$onOpenGateClick$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$onOpenGateClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0075 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2e
            if (r1 == r4) goto L2a
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r0 = r6.L$0
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L27
            goto Lae
        L1b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L23:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            goto L76
        L27:
            r7 = move-exception
            goto Lbd
        L2a:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            goto L5b
        L2e:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            androidx.lifecycle.MutableLiveData r7 = r7.isOpenDoorLoading()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            r7.setValue(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            java.lang.Integer r7 = ru.tattelecom.intercom.feature.player.PlayerViewModel.access$getGateId$p(r7)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            if (r7 == 0) goto L5d
            ru.tattelecom.intercom.feature.player.PlayerViewModel r1 = r6.this$0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            java.lang.Number r7 = (java.lang.Number) r7     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            ru.tattelecom.intercom.domain.interactors.GateInteractor r1 = ru.tattelecom.intercom.feature.player.PlayerViewModel.access$getGateInteractor$p(r1)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            r6.label = r4     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            java.lang.Object r7 = r1.open(r7, r6)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            if (r7 != r0) goto L5b
            return r0
        L5b:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
        L5d:
            ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            kotlinx.coroutines.channels.Channel r7 = ru.tattelecom.intercom.feature.player.PlayerViewModel.access$get_events$p(r7)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            ru.tattelecom.intercom.feature.player.PlayerViewModel$Event$ShowMessage r1 = new ru.tattelecom.intercom.feature.player.PlayerViewModel$Event$ShowMessage     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            java.lang.String r4 = "door_opened"
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            r6.label = r3     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            java.lang.Object r7 = r7.send(r1, r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L84
            if (r7 != r0) goto L76
            return r0
        L76:
            ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0
            androidx.lifecycle.MutableLiveData r7 = r7.isOpenDoorLoading()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r7.setValue(r0)
            goto Lba
        L84:
            ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L27
            java.lang.String r7 = r7.getIntercomLogin()     // Catch: java.lang.Throwable -> L27
            if (r7 == 0) goto L76
            ru.tattelecom.intercom.feature.player.PlayerViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L27
            androidx.lifecycle.MutableLiveData r7 = r7.isOpenDoorError()     // Catch: java.lang.Throwable -> L27
            ru.tattelecom.intercom.feature.player.PlayerViewModel r1 = r6.this$0     // Catch: java.lang.Throwable -> L27
            ru.tattelecom.intercom.domain.interactors.IntercomInteractor r1 = ru.tattelecom.intercom.feature.player.PlayerViewModel.access$getIntercomInteractor$p(r1)     // Catch: java.lang.Throwable -> L27
            ru.tattelecom.intercom.feature.player.PlayerViewModel r3 = r6.this$0     // Catch: java.lang.Throwable -> L27
            java.lang.String r3 = r3.getIntercomLogin()     // Catch: java.lang.Throwable -> L27
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L27
            r6.L$0 = r7     // Catch: java.lang.Throwable -> L27
            r6.label = r2     // Catch: java.lang.Throwable -> L27
            java.lang.Object r1 = r1.getEmergencyCodeByIntercomLogin(r3, r4)     // Catch: java.lang.Throwable -> L27
            if (r1 != r0) goto Lac
            return r0
        Lac:
            r0 = r7
            r7 = r1
        Lae:
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Throwable -> L27
            if (r7 != 0) goto Lb6
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)     // Catch: java.lang.Throwable -> L27
        Lb6:
            r0.setValue(r7)     // Catch: java.lang.Throwable -> L27
            goto L76
        Lba:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        Lbd:
            ru.tattelecom.intercom.feature.player.PlayerViewModel r0 = r6.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.isOpenDoorLoading()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r0.setValue(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.player.PlayerViewModel$onOpenGateClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
