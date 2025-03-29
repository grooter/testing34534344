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
import ru.tattelecom.intercom.data.remote.model.StreamLiveResponse;
import ru.tattelecom.intercom.domain.model.StreamSourceDto;

/* compiled from: StreamInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/domain/model/StreamSourceDto;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.StreamInteractor$getLiveUrl$2", f = "StreamInteractor.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class StreamInteractor$getLiveUrl$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super StreamSourceDto>, Object> {
    final /* synthetic */ boolean $isFlussonic;
    final /* synthetic */ String $liveSource;
    int label;
    final /* synthetic */ StreamInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamInteractor$getLiveUrl$2(StreamInteractor streamInteractor, String str, boolean z, Continuation<? super StreamInteractor$getLiveUrl$2> continuation) {
        super(2, continuation);
        this.this$0 = streamInteractor;
        this.$liveSource = str;
        this.$isFlussonic = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StreamInteractor$getLiveUrl$2(this.this$0, this.$liveSource, this.$isFlussonic, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super StreamSourceDto> continuation) {
        return ((StreamInteractor$getLiveUrl$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        StreamSourceDto streamSourceDto;
        String str;
        String stopUrl;
        Long keepAliveSeconds;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getRemote().getLive(this.$liveSource, this.$isFlussonic, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        StreamLiveResponse streamLiveResponse = (StreamLiveResponse) obj;
        if (this.$isFlussonic) {
            streamSourceDto = new StreamSourceDto(streamLiveResponse != null ? streamLiveResponse.getStreamUrlMpeg() : null, null, 2, null);
        } else {
            String streamUrl = streamLiveResponse != null ? streamLiveResponse.getStreamUrl() : null;
            long longValue = ((streamLiveResponse == null || (keepAliveSeconds = streamLiveResponse.getKeepAliveSeconds()) == null) ? 60L : keepAliveSeconds.longValue()) * 1000;
            String str2 = "";
            if (streamLiveResponse == null || (str = streamLiveResponse.getKeepAliveUrl()) == null) {
                str = "";
            }
            if (streamLiveResponse != null && (stopUrl = streamLiveResponse.getStopUrl()) != null) {
                str2 = stopUrl;
            }
            streamSourceDto = new StreamSourceDto(streamUrl, new StreamSourceDto.AxxonDto(longValue, str, str2));
        }
        return streamSourceDto;
    }
}
