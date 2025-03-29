package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentInviteUserBinding;

/* compiled from: InviteUserFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$provideUiChanges$1$1", f = "InviteUserFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class InviteUserFragment$provideUiChanges$1$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ InviteUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InviteUserFragment$provideUiChanges$1$1(InviteUserFragment inviteUserFragment, Continuation<? super InviteUserFragment$provideUiChanges$1$1> continuation) {
        super(2, continuation);
        this.this$0 = inviteUserFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InviteUserFragment$provideUiChanges$1$1 inviteUserFragment$provideUiChanges$1$1 = new InviteUserFragment$provideUiChanges$1$1(this.this$0, continuation);
        inviteUserFragment$provideUiChanges$1$1.Z$0 = ((Boolean) obj).booleanValue();
        return inviteUserFragment$provideUiChanges$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((InviteUserFragment$provideUiChanges$1$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentInviteUserBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final boolean z = this.Z$0;
        binding = this.this$0.getBinding();
        final MaterialButton materialButton = binding.btnContinue;
        materialButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserFragment$provideUiChanges$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MaterialButton.this.setEnabled(z);
            }
        }, 50L);
        return Unit.INSTANCE;
    }
}
