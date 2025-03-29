package ru.tattelecom.intercom.domain.interactors;

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
import ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse;
import ru.tattelecom.intercom.data.remote.source.LeadRemote;

/* compiled from: UserInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/remote/model/responses/LeaveOrderServicesResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.UserInteractor$getLeaveOrderServicesList$2", f = "UserInteractor.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_E_AC3}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class UserInteractor$getLeaveOrderServicesList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LeaveOrderServicesResponse>, Object> {
    final /* synthetic */ Long $entityId;
    final /* synthetic */ String $entityScreen;
    int label;
    final /* synthetic */ UserInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserInteractor$getLeaveOrderServicesList$2(UserInteractor userInteractor, String str, Long l, Continuation<? super UserInteractor$getLeaveOrderServicesList$2> continuation) {
        super(2, continuation);
        this.this$0 = userInteractor;
        this.$entityScreen = str;
        this.$entityId = l;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInteractor$getLeaveOrderServicesList$2(this.this$0, this.$entityScreen, this.$entityId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LeaveOrderServicesResponse> continuation) {
        return ((UserInteractor$getLeaveOrderServicesList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            obj = leadRemote.getLeaveOrderServices(this.$entityScreen, this.$entityId, this);
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
