package ru.tattelecom.intercom.domain.interactors;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.source.LeadRemote;

/* compiled from: UserInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.UserInteractor$leaveOrder$2", f = "UserInteractor.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class UserInteractor$leaveOrder$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StatusResponse>, Object> {
    final /* synthetic */ Long $entityId;
    final /* synthetic */ String $entityScreen;
    final /* synthetic */ String $name;
    final /* synthetic */ String $phone;
    final /* synthetic */ List<Integer> $services;
    int label;
    final /* synthetic */ UserInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserInteractor$leaveOrder$2(UserInteractor userInteractor, String str, String str2, List<Integer> list, String str3, Long l, Continuation<? super UserInteractor$leaveOrder$2> continuation) {
        super(2, continuation);
        this.this$0 = userInteractor;
        this.$phone = str;
        this.$name = str2;
        this.$services = list;
        this.$entityScreen = str3;
        this.$entityId = l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInteractor$leaveOrder$2(this.this$0, this.$phone, this.$name, this.$services, this.$entityScreen, this.$entityId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StatusResponse> continuation) {
        return ((UserInteractor$leaveOrder$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LeadRemote leadRemote;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            leadRemote = this.this$0.remote;
            this.label = 1;
            obj = leadRemote.leaveOrder(this.$phone, this.$name, this.$services, this.$entityScreen, this.$entityId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
