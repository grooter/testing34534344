package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel;

/* compiled from: InviteUserFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteUserViewModel$Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$provideUiChanges$1$4", f = "InviteUserFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class InviteUserFragment$provideUiChanges$1$4 extends SuspendLambda implements Function2<InviteUserViewModel.Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InviteUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InviteUserFragment$provideUiChanges$1$4(InviteUserFragment inviteUserFragment, Continuation<? super InviteUserFragment$provideUiChanges$1$4> continuation) {
        super(2, continuation);
        this.this$0 = inviteUserFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InviteUserFragment$provideUiChanges$1$4 inviteUserFragment$provideUiChanges$1$4 = new InviteUserFragment$provideUiChanges$1$4(this.this$0, continuation);
        inviteUserFragment$provideUiChanges$1$4.L$0 = obj;
        return inviteUserFragment$provideUiChanges$1$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(InviteUserViewModel.Event event, Continuation<? super Unit> continuation) {
        return ((InviteUserFragment$provideUiChanges$1$4) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.provideEvent((InviteUserViewModel.Event) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
