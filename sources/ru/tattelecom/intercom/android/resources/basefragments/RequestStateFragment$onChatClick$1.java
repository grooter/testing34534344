package ru.tattelecom.intercom.android.resources.basefragments;

import androidx.navigation.fragment.FragmentKt;
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
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: RequestStateFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$onChatClick$1", f = "RequestStateFragment.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class RequestStateFragment$onChatClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatAction;
    final /* synthetic */ String $formattedPhone;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ RequestStateFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RequestStateFragment$onChatClick$1(String str, RequestStateFragment requestStateFragment, String str2, String str3, Continuation<? super RequestStateFragment$onChatClick$1> continuation) {
        super(2, continuation);
        this.$chatAction = str;
        this.this$0 = requestStateFragment;
        this.$phone = str2;
        this.$formattedPhone = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RequestStateFragment$onChatClick$1(this.$chatAction, this.this$0, this.$phone, this.$formattedPhone, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RequestStateFragment$onChatClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        UserInteractor userInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            this.this$0.showAlert(this.$phone, this.$formattedPhone);
            e.printStackTrace();
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.$chatAction, SupportViewModel.ChatAction.OPEN_MODAL)) {
                this.this$0.showAlert(this.$phone, this.$formattedPhone);
            } else if (Intrinsics.areEqual(this.$chatAction, SupportViewModel.ChatAction.OPEN_CHAT)) {
                userInteractor = this.this$0.getUserInteractor();
                this.label = 1;
                if (userInteractor.fetchUserConfig(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        NavExtKt.navigateSafe$default(FragmentKt.findNavController(this.this$0), NavGraphDestinations.Action.INSTANCE.getToChat(), null, null, 6, null);
        return Unit.INSTANCE;
    }
}
