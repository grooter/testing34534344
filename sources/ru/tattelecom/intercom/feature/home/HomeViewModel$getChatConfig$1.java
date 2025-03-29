package ru.tattelecom.intercom.feature.home;

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
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;
import ru.tattelecom.intercom.feature.home.model.OpenChatEvent;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$getChatConfig$1", f = "HomeViewModel.kt", i = {}, l = {640, 642, 643, 646}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$getChatConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatAction;
    final /* synthetic */ String $formattedPhone;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$getChatConfig$1(String str, HomeViewModel homeViewModel, String str2, String str3, Continuation<? super HomeViewModel$getChatConfig$1> continuation) {
        super(2, continuation);
        this.$chatAction = str;
        this.this$0 = homeViewModel;
        this.$phone = str2;
        this.$formattedPhone = str3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getChatConfig$1(this.$chatAction, this.this$0, this.$phone, this.$formattedPhone, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$getChatConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        UserInteractor userInteractor;
        Channel channel2;
        Channel channel3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception unused) {
            channel = this.this$0._eventOpenChat;
            this.label = 4;
            if (channel.send(new OpenChatEvent(false, this.$phone, this.$formattedPhone), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (Intrinsics.areEqual(this.$chatAction, SupportViewModel.ChatAction.OPEN_MODAL)) {
                channel2 = this.this$0._eventOpenChat;
                this.label = 1;
                if (channel2.send(new OpenChatEvent(false, this.$phone, this.$formattedPhone), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (Intrinsics.areEqual(this.$chatAction, SupportViewModel.ChatAction.OPEN_CHAT)) {
                userInteractor = this.this$0.userInteractor;
                this.label = 2;
                if (userInteractor.fetchUserConfig(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
            } else if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
        channel3 = this.this$0._eventOpenChat;
        this.label = 3;
        if (channel3.send(new OpenChatEvent(true, this.$phone, this.$formattedPhone), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
