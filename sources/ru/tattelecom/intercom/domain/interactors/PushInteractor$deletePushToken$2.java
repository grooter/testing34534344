package ru.tattelecom.intercom.domain.interactors;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.huawei.agconnect.AGConnectOptionsBuilder;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.feature.dynamic.e.e;
import com.huawei.hms.push.HmsMessaging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PushInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.PushInteractor$deletePushToken$2", f = "PushInteractor.kt", i = {2}, l = {132, 152, 154}, m = "invokeSuspend", n = {e.f202a}, s = {"L$0"})
/* loaded from: classes5.dex */
final class PushInteractor$deletePushToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;
    final /* synthetic */ PushInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PushInteractor$deletePushToken$2(Context context, PushInteractor pushInteractor, Continuation<? super PushInteractor$deletePushToken$2> continuation) {
        super(2, continuation);
        this.$context = context;
        this.this$0 = pushInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushInteractor$deletePushToken$2(this.$context, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((PushInteractor$deletePushToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ApiException apiException;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (ApiException e) {
            this.L$0 = e;
            this.label = 3;
            if (this.this$0.updatePushTokenStatus(false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            apiException = e;
        }
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            apiException = (ApiException) this.L$0;
            ResultKt.throwOnFailure(obj);
            apiException.printStackTrace();
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$context == null) {
            this.label = 1;
            if (this.this$0.updatePushTokenStatus(false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this.$context) == 0) {
            Task<Void> deleteToken = FirebaseMessaging.getInstance().deleteToken();
            Intrinsics.checkNotNullExpressionValue(deleteToken, "deleteToken(...)");
            final PushInteractor pushInteractor = this.this$0;
            final Context context = this.$context;
            final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: ru.tattelecom.intercom.domain.interactors.PushInteractor$deletePushToken$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r3) {
                    PushInteractor.this.startUpdatePushTokenStatusWorker(true, context);
                }
            };
            Task<Void> addOnSuccessListener = deleteToken.addOnSuccessListener(new OnSuccessListener() { // from class: ru.tattelecom.intercom.domain.interactors.PushInteractor$deletePushToken$2$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    Function1.this.invoke(obj2);
                }
            });
            final PushInteractor pushInteractor2 = this.this$0;
            final Context context2 = this.$context;
            Task<Void> addOnCanceledListener = addOnSuccessListener.addOnCanceledListener(new OnCanceledListener() { // from class: ru.tattelecom.intercom.domain.interactors.PushInteractor$deletePushToken$2$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnCanceledListener
                public final void onCanceled() {
                    PushInteractor.access$startUpdatePushTokenStatusWorker(PushInteractor.this, false, context2);
                }
            });
            final PushInteractor pushInteractor3 = this.this$0;
            final Context context3 = this.$context;
            Task<Void> addOnFailureListener = addOnCanceledListener.addOnFailureListener(new OnFailureListener() { // from class: ru.tattelecom.intercom.domain.interactors.PushInteractor$deletePushToken$2$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    PushInteractor.access$startUpdatePushTokenStatusWorker(PushInteractor.this, false, context3);
                }
            });
            Intrinsics.checkNotNull(addOnFailureListener);
            return addOnFailureListener;
        }
        if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.$context) == 0) {
            HmsInstanceId.getInstance(this.$context).deleteToken(new AGConnectOptionsBuilder().build(this.$context).getString("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
            this.label = 2;
            if (this.this$0.updatePushTokenStatus(true, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
