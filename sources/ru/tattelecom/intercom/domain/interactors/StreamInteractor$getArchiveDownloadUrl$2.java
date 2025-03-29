package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse;

/* compiled from: StreamInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStatusResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$2", f = "StreamInteractor.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class StreamInteractor$getArchiveDownloadUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ArchiveDownloadStatusResponse>, Object> {
    final /* synthetic */ String $location;
    final /* synthetic */ String $source;
    int label;
    final /* synthetic */ StreamInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamInteractor$getArchiveDownloadUrl$2(StreamInteractor streamInteractor, String str, String str2, Continuation<? super StreamInteractor$getArchiveDownloadUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = streamInteractor;
        this.$source = str;
        this.$location = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamInteractor$getArchiveDownloadUrl$2(this.this$0, this.$source, this.$location, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ArchiveDownloadStatusResponse> continuation) {
        return ((StreamInteractor$getArchiveDownloadUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getRemote().getArchiveDownloadStatus(this.$source, this.$location, this);
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
