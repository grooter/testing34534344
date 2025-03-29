package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.FamilyAccessInteractor;
import ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel;

/* compiled from: InviteUserViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$onContinueClicked$1", f = "InviteUserViewModel.kt", i = {}, l = {91, 95, 97, 99}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class InviteUserViewModel$onContinueClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InviteUserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InviteUserViewModel$onContinueClicked$1(InviteUserViewModel inviteUserViewModel, Continuation<? super InviteUserViewModel$onContinueClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = inviteUserViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InviteUserViewModel$onContinueClicked$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InviteUserViewModel$onContinueClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        MutableStateFlow mutableStateFlow;
        String str;
        Channel channel2;
        MutableStateFlow mutableStateFlow2;
        FamilyAccessInteractor familyAccessInteractor;
        Channel channel3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            channel = this.this$0._events;
            this.label = 4;
            if (channel.send(InviteUserViewModel.Event.NavigateToErrorPage.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InviteUserViewModel inviteUserViewModel = this.this$0;
            mutableStateFlow = inviteUserViewModel.phoneNumber;
            String str2 = (String) mutableStateFlow.getValue();
            if (str2 != null) {
                str = new Regex("[^0-9]").replace(str2, "");
            } else {
                str = null;
            }
            inviteUserViewModel.setCleanedNumber("79" + str);
            if (this.this$0.getSelectedApartmentId() != null) {
                mutableStateFlow2 = this.this$0.phoneNumber;
                CharSequence charSequence = (CharSequence) mutableStateFlow2.getValue();
                if (charSequence != null && charSequence.length() != 0) {
                    Integer selectedApartmentId = this.this$0.getSelectedApartmentId();
                    if (selectedApartmentId != null) {
                        InviteUserViewModel inviteUserViewModel2 = this.this$0;
                        int intValue = selectedApartmentId.intValue();
                        familyAccessInteractor = inviteUserViewModel2.familyAccessInteractor;
                        String cleanedNumber = inviteUserViewModel2.getCleanedNumber();
                        this.label = 2;
                        if (familyAccessInteractor.sendVerifyCode(cleanedNumber, intValue, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            }
            channel2 = this.this$0._events;
            this.label = 1;
            if (channel2.send(new InviteUserViewModel.Event.ShowMessage("fill_in_all_fields"), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
        channel3 = this.this$0._events;
        this.label = 3;
        if (channel3.send(InviteUserViewModel.Event.NavigateToCodeVerification.INSTANCE, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
