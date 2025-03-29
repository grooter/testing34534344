package ru.tattelecom.intercom.feature.profile;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.profile.Event;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.profile.ProfileViewModel$checkUserState$1", f = "ProfileViewModel.kt", i = {}, l = {49, 50, 51}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class ProfileViewModel$checkUserState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$checkUserState$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$checkUserState$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileViewModel$checkUserState$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$checkUserState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserInteractor userInteractor;
        Object checkAddresses;
        Channel channel;
        Channel channel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            userInteractor = this.this$0.userInteractor;
            String userState = userInteractor.getUserState();
            if (Intrinsics.areEqual(userState, "false")) {
                channel2 = this.this$0._events;
                this.label = 1;
                if (channel2.send(new Event.Navigate(NavGraphDestinations.Action.INSTANCE.getToAccessManagement()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (Intrinsics.areEqual(userState, "true")) {
                channel = this.this$0._events;
                this.label = 2;
                if (channel.send(new Event.Navigate(NavGraphDestinations.Action.INSTANCE.getToAddAddress()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.label = 3;
                checkAddresses = this.this$0.checkAddresses(this);
                if (checkAddresses == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2 && i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
