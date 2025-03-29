package ru.tattelecom.intercom.domain.interactors;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;

/* compiled from: PushInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.PushInteractor$getAndSendPushToken$2", f = "PushInteractor.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class PushInteractor$getAndSendPushToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;
    final /* synthetic */ PushInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushInteractor$getAndSendPushToken$2(PushInteractor pushInteractor, Context context, Continuation<? super PushInteractor$getAndSendPushToken$2> continuation) {
        super(2, continuation);
        this.this$0 = pushInteractor;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushInteractor$getAndSendPushToken$2(this.this$0, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PushInteractor$getAndSendPushToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(NonCancellable.INSTANCE, new AnonymousClass1(this.this$0, this.$context, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: PushInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.PushInteractor$getAndSendPushToken$2$1", f = "PushInteractor.kt", i = {}, l = {185, 186}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.domain.interactors.PushInteractor$getAndSendPushToken$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ PushInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PushInteractor pushInteractor, Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = pushInteractor;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x004b  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r5)
                goto L47
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                kotlin.ResultKt.throwOnFailure(r5)
                goto L2f
            L1e:
                kotlin.ResultKt.throwOnFailure(r5)
                ru.tattelecom.intercom.domain.interactors.PushInteractor r5 = r4.this$0
                r1 = r4
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r4.label = r3
                java.lang.Object r5 = ru.tattelecom.intercom.domain.interactors.PushInteractor.access$getPushInfo(r5, r1)
                if (r5 != r0) goto L2f
                return r0
            L2f:
                ru.tattelecom.intercom.data.prefs.model.PushInfo r5 = (ru.tattelecom.intercom.data.prefs.model.PushInfo) r5
                boolean r5 = r5.getPushTokenStatus()
                if (r5 != 0) goto L47
                ru.tattelecom.intercom.domain.interactors.PushInteractor r5 = r4.this$0
                android.content.Context r1 = r4.$context
                r3 = r4
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r4.label = r2
                java.lang.Object r5 = r5.deletePushToken(r1, r3)
                if (r5 != r0) goto L47
                return r0
            L47:
                android.content.Context r5 = r4.$context
                if (r5 == 0) goto Laf
                com.google.android.gms.common.GoogleApiAvailability r5 = com.google.android.gms.common.GoogleApiAvailability.getInstance()
                android.content.Context r0 = r4.$context
                int r5 = r5.isGooglePlayServicesAvailable(r0)
                if (r5 != 0) goto L6c
                com.google.firebase.messaging.FirebaseMessaging r5 = com.google.firebase.messaging.FirebaseMessaging.getInstance()
                com.google.android.gms.tasks.Task r5 = r5.getToken()
                ru.tattelecom.intercom.domain.interactors.PushInteractor r0 = r4.this$0
                android.content.Context r1 = r4.$context
                ru.tattelecom.intercom.domain.interactors.PushInteractor$getAndSendPushToken$2$1$$ExternalSyntheticLambda0 r2 = new ru.tattelecom.intercom.domain.interactors.PushInteractor$getAndSendPushToken$2$1$$ExternalSyntheticLambda0
                r2.<init>()
                r5.addOnCompleteListener(r2)
                goto Laf
            L6c:
                com.huawei.hms.api.HuaweiApiAvailability r5 = com.huawei.hms.api.HuaweiApiAvailability.getInstance()
                android.content.Context r0 = r4.$context
                int r5 = r5.isHuaweiMobileServicesAvailable(r0)
                if (r5 != 0) goto Laf
                android.content.Context r5 = r4.$context     // Catch: com.huawei.hms.common.ApiException -> Lab
                com.huawei.hms.aaid.HmsInstanceId r5 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r5)     // Catch: com.huawei.hms.common.ApiException -> Lab
                com.huawei.agconnect.AGConnectOptionsBuilder r0 = new com.huawei.agconnect.AGConnectOptionsBuilder     // Catch: com.huawei.hms.common.ApiException -> Lab
                r0.<init>()     // Catch: com.huawei.hms.common.ApiException -> Lab
                android.content.Context r1 = r4.$context     // Catch: com.huawei.hms.common.ApiException -> Lab
                com.huawei.agconnect.AGConnectOptions r0 = r0.build(r1)     // Catch: com.huawei.hms.common.ApiException -> Lab
                java.lang.String r1 = "client/app_id"
                java.lang.String r0 = r0.getString(r1)     // Catch: com.huawei.hms.common.ApiException -> Lab
                java.lang.String r1 = "HCM"
                java.lang.String r5 = r5.getToken(r0, r1)     // Catch: com.huawei.hms.common.ApiException -> Lab
                r0 = r5
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: com.huawei.hms.common.ApiException -> Lab
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: com.huawei.hms.common.ApiException -> Lab
                if (r0 != 0) goto Laf
                ru.tattelecom.intercom.domain.interactors.PushInteractor r0 = r4.this$0     // Catch: com.huawei.hms.common.ApiException -> Lab
                android.content.Context r1 = r4.$context     // Catch: com.huawei.hms.common.ApiException -> Lab
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch: com.huawei.hms.common.ApiException -> Lab
                java.lang.String r2 = "hms"
                ru.tattelecom.intercom.domain.interactors.PushInteractor.access$startSendPushTokenWorker(r0, r1, r5, r2)     // Catch: com.huawei.hms.common.ApiException -> Lab
                goto Laf
            Lab:
                r5 = move-exception
                r5.printStackTrace()
            Laf:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.PushInteractor$getAndSendPushToken$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(PushInteractor pushInteractor, Context context, Task task) {
            if (task.isSuccessful()) {
                String str = (String) task.getResult();
                Intrinsics.checkNotNull(str);
                pushInteractor.startSendPushTokenWorker(context, str, "fcm");
            }
        }
    }
}
