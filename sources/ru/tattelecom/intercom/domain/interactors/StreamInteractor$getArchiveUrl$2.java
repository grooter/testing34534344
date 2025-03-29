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
import ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse;
import ru.tattelecom.intercom.domain.model.StreamSourceDto;

/* compiled from: StreamInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/domain/model/StreamSourceDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveUrl$2", f = "StreamInteractor.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class StreamInteractor$getArchiveUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StreamSourceDto>, Object> {
    final /* synthetic */ String $archiveSource;
    final /* synthetic */ boolean $isFlussonic;
    final /* synthetic */ String $startTime;
    int label;
    final /* synthetic */ StreamInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamInteractor$getArchiveUrl$2(StreamInteractor streamInteractor, String str, String str2, boolean z, Continuation<? super StreamInteractor$getArchiveUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = streamInteractor;
        this.$archiveSource = str;
        this.$startTime = str2;
        this.$isFlussonic = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamInteractor$getArchiveUrl$2(this.this$0, this.$archiveSource, this.$startTime, this.$isFlussonic, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StreamSourceDto> continuation) {
        return ((StreamInteractor$getArchiveUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        String stopUrl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getRemote().getArchive(this.$archiveSource, this.$startTime, this.$isFlussonic, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ArchiveStreamResponse archiveStreamResponse = (ArchiveStreamResponse) obj;
        StreamSourceDto.AxxonDto axxonDto = null;
        String streamUrl = archiveStreamResponse != null ? archiveStreamResponse.getStreamUrl() : null;
        if (!this.$isFlussonic) {
            long keepAliveSeconds = (archiveStreamResponse != null ? archiveStreamResponse.getKeepAliveSeconds() : 60L) * 1000;
            String str2 = "";
            if (archiveStreamResponse == null || (str = archiveStreamResponse.getKeepAliveUrl()) == null) {
                str = "";
            }
            if (archiveStreamResponse != null && (stopUrl = archiveStreamResponse.getStopUrl()) != null) {
                str2 = stopUrl;
            }
            axxonDto = new StreamSourceDto.AxxonDto(keepAliveSeconds, str, str2);
        }
        return new StreamSourceDto(streamUrl, axxonDto);
    }
}
