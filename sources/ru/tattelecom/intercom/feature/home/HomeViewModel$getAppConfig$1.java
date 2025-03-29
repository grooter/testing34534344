package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.domain.model.ConfigDto;
import ru.tattelecom.intercom.feature.home.model.HomeEvent;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$getAppConfig$1", f = "HomeViewModel.kt", i = {}, l = {241, 243, 248, 257}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$getAppConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$getAppConfig$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$getAppConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getAppConfig$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$getAppConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserInteractor userInteractor;
        ConfigInteractor configInteractor;
        ConfigInteractor configInteractor2;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        UserInteractor userInteractor2;
        MutableSharedFlow mutableSharedFlow3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            userInteractor = this.this$0.userInteractor;
            String token = userInteractor.getToken();
            if (token != null && token.length() != 0) {
                configInteractor = this.this$0.configInteractor;
                this.label = 1;
                obj = configInteractor.getConfig(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i != 2 && i != 3 && i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        ConfigDto configDto = (ConfigDto) obj;
        if (Intrinsics.areEqual(configDto.isFirstEnter(), Boxing.boxBoolean(true))) {
            userInteractor2 = this.this$0.userInteractor;
            if (!userInteractor2.isWelcomeScreenShown()) {
                mutableSharedFlow3 = this.this$0._events;
                this.label = 2;
                if (mutableSharedFlow3.emit(HomeEvent.OpenWelcomeScreen.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        ConfigDto.Trial trial = configDto.getTrial();
        if (trial != null) {
            HomeViewModel homeViewModel = this.this$0;
            if (Intrinsics.areEqual(trial.isAvailable(), Boxing.boxBoolean(true))) {
                if (trial.getId() != null && trial.getExpireDays() != null) {
                    mutableSharedFlow2 = homeViewModel._events;
                    Integer id = trial.getId();
                    Intrinsics.checkNotNull(id);
                    int intValue = id.intValue();
                    Integer expireDays = trial.getExpireDays();
                    Intrinsics.checkNotNull(expireDays);
                    HomeEvent.OpenTrialScreen openTrialScreen = new HomeEvent.OpenTrialScreen(intValue, NavArg.TrialScreen.TRIAL_START, expireDays);
                    this.label = 3;
                    if (mutableSharedFlow2.emit(openTrialScreen, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (Intrinsics.areEqual(trial.isActive(), Boxing.boxBoolean(false))) {
                configInteractor2 = homeViewModel.configInteractor;
                if (configInteractor2.isTrialActivated()) {
                    mutableSharedFlow = homeViewModel._events;
                    HomeEvent.OpenTrialScreen openTrialScreen2 = new HomeEvent.OpenTrialScreen(-1, NavArg.TrialScreen.TRIAL_END, Boxing.boxInt(0));
                    this.label = 4;
                    if (mutableSharedFlow.emit(openTrialScreen2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }
}
