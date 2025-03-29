package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$sendApplicationVersion$1", f = "HomeViewModel.kt", i = {}, l = {621}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$sendApplicationVersion$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appVersionCode;
    final /* synthetic */ String $appVersionName;
    final /* synthetic */ String $batteryLevel;
    final /* synthetic */ String $connectionType;
    final /* synthetic */ String $deviceApiVersion;
    final /* synthetic */ String $deviceName;
    final /* synthetic */ String $deviceOsVersion;
    final /* synthetic */ String $providerName;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$sendApplicationVersion$1(HomeViewModel homeViewModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Continuation<? super HomeViewModel$sendApplicationVersion$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
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
        return new HomeViewModel$sendApplicationVersion$1(this.this$0, this.$appVersionName, this.$appVersionCode, this.$deviceOsVersion, this.$deviceApiVersion, this.$providerName, this.$deviceName, this.$connectionType, this.$batteryLevel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$sendApplicationVersion$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserInteractor userInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                userInteractor = this.this$0.userInteractor;
                this.label = 1;
                if (userInteractor.sendApplicationVersion(this.$appVersionName, this.$appVersionCode, this.$deviceOsVersion, this.$deviceApiVersion, this.$providerName, this.$deviceName, this.$connectionType, this.$batteryLevel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        } catch (Exception unused) {
        }
        return Unit.INSTANCE;
    }
}
