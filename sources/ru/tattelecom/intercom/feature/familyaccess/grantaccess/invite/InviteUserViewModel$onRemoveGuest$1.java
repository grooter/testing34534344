package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import androidx.media3.extractor.ts.TsExtractor;
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
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.InviteUserViewModel$onRemoveGuest$1", f = "InviteUserViewModel.kt", i = {}, l = {132, 133, TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class InviteUserViewModel$onRemoveGuest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $apartmentId;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ InviteUserViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InviteUserViewModel$onRemoveGuest$1(InviteUserViewModel inviteUserViewModel, int i, String str, Continuation<? super InviteUserViewModel$onRemoveGuest$1> continuation) {
        super(2, continuation);
        this.this$0 = inviteUserViewModel;
        this.$apartmentId = i;
        this.$phone = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InviteUserViewModel$onRemoveGuest$1(this.this$0, this.$apartmentId, this.$phone, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InviteUserViewModel$onRemoveGuest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        FamilyAccessInteractor familyAccessInteractor;
        Channel channel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            channel = this.this$0._events;
            this.label = 3;
            if (channel.send(new InviteUserViewModel.Event.ShowMessage("something_went_wrong"), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            familyAccessInteractor = this.this$0.familyAccessInteractor;
            this.label = 1;
            if (familyAccessInteractor.deleteGuest(this.$apartmentId, this.$phone, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        channel2 = this.this$0._events;
        this.label = 2;
        if (channel2.send(new InviteUserViewModel.Event.ShowMessage("success"), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
