package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.remote.source.AuthRemote;

/* compiled from: UserInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.UserInteractor$sendApplicationVersion$2", f = "UserInteractor.kt", i = {}, l = {201}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class UserInteractor$sendApplicationVersion$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appVersionCode;
    final /* synthetic */ String $appVersionName;
    final /* synthetic */ String $batteryLevel;
    final /* synthetic */ String $connectionType;
    final /* synthetic */ String $deviceApiVersion;
    final /* synthetic */ String $deviceName;
    final /* synthetic */ String $deviceOsVersion;
    final /* synthetic */ String $providerName;
    int label;
    final /* synthetic */ UserInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserInteractor$sendApplicationVersion$2(UserInteractor userInteractor, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation<? super UserInteractor$sendApplicationVersion$2> continuation) {
        super(2, continuation);
        this.this$0 = userInteractor;
        this.$appVersionName = str;
        this.$appVersionCode = str2;
        this.$deviceOsVersion = str3;
        this.$deviceApiVersion = str4;
        this.$providerName = str5;
        this.$deviceName = str6;
        this.$connectionType = str7;
        this.$batteryLevel = str8;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInteractor$sendApplicationVersion$2(this.this$0, this.$appVersionName, this.$appVersionCode, this.$deviceOsVersion, this.$deviceApiVersion, this.$providerName, this.$deviceName, this.$connectionType, this.$batteryLevel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserInteractor$sendApplicationVersion$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AuthRemote authRemote;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String token = this.this$0.getToken();
            if (token != null && token.length() != 0) {
                authRemote = this.this$0.authRemote;
                this.label = 1;
                if (authRemote.sendApplicationInfo(this.$appVersionName, this.$appVersionCode, this.$deviceOsVersion, this.$deviceApiVersion, this.$providerName, this.$deviceName, this.$connectionType, this.$batteryLevel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
