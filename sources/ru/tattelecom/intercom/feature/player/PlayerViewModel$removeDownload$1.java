package ru.tattelecom.intercom.feature.player;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.model.DownloadDto;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$removeDownload$1", f = "PlayerViewModel.kt", i = {}, l = {537}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerViewModel$removeDownload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DownloadDto $model;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$removeDownload$1(PlayerViewModel playerViewModel, DownloadDto downloadDto, Continuation<? super PlayerViewModel$removeDownload$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
        this.$model = downloadDto;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$removeDownload$1(this.this$0, this.$model, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$removeDownload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.userInteractor.deleteDownload(this.$model, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
