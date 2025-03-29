package ru.tattelecom.intercom.feature.player;

import com.huawei.location.lite.common.http.exception.ErrorCode;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$onEndCall$1", f = "PlayerViewModel.kt", i = {1}, l = {385, ErrorCode.HTTP_PAYMENT_REQUIRED}, m = "invokeSuspend", n = {"now"}, s = {"J$0"})
/* loaded from: classes7.dex */
final class PlayerViewModel$onEndCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$onEndCall$1(PlayerViewModel playerViewModel, Continuation<? super PlayerViewModel$onEndCall$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$onEndCall$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$onEndCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Job job;
        Channel channel2;
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            channel = this.this$0._events;
            this.label = 1;
            if (channel.send(PlayerViewModel.Event.EndCall.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.J$0;
                ResultKt.throwOnFailure(obj);
                this.this$0.userInteractor.setLastInAppReviewTimeStamp(j);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        job = this.this$0.endCallJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if ((Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerViewModel.PlayerState.CameraArchive.INSTANCE) || Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerViewModel.PlayerState.IntercomArchive.INSTANCE)) && !Intrinsics.areEqual(this.this$0.isStreamLoading().getValue(), Boxing.boxBoolean(true)) && !Intrinsics.areEqual(this.this$0.getStreamLoadError().getValue(), Boxing.boxBoolean(true))) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.this$0.userInteractor.getLastInAppReviewTimeStamp() >= 86400000) {
                channel2 = this.this$0._events;
                this.J$0 = currentTimeMillis;
                this.label = 2;
                if (channel2.send(PlayerViewModel.Event.ShowInAppReview.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = currentTimeMillis;
                this.this$0.userInteractor.setLastInAppReviewTimeStamp(j);
            }
        }
        return Unit.INSTANCE;
    }
}
