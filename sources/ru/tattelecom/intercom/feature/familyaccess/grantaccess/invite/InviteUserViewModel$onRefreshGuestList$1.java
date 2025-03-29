package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel;

/* compiled from: InviteUserViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$onRefreshGuestList$1", f = "InviteUserViewModel.kt", i = {}, l = {80, 82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class InviteUserViewModel$onRefreshGuestList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InviteUserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InviteUserViewModel$onRefreshGuestList$1(InviteUserViewModel inviteUserViewModel, Continuation<? super InviteUserViewModel$onRefreshGuestList$1> continuation) {
        super(2, continuation);
        this.this$0 = inviteUserViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InviteUserViewModel$onRefreshGuestList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InviteUserViewModel$onRefreshGuestList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        FamilyAccessInteractor familyAccessInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            channel = this.this$0._events;
            this.label = 2;
            if (channel.send(new InviteUserViewModel.Event.ShowMessage("something_went_wrong"), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            familyAccessInteractor = this.this$0.familyAccessInteractor;
            this.label = 1;
            if (familyAccessInteractor.refreshGuestsList(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
