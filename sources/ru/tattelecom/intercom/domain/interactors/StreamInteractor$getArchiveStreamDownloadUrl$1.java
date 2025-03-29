package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: StreamInteractor.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.StreamInteractor", f = "StreamInteractor.kt", i = {}, l = {100}, m = "getArchiveStreamDownloadUrl", n = {}, s = {})
/* loaded from: classes5.dex */
final class StreamInteractor$getArchiveStreamDownloadUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ StreamInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreamInteractor$getArchiveStreamDownloadUrl$1(StreamInteractor streamInteractor, Continuation<? super StreamInteractor$getArchiveStreamDownloadUrl$1> continuation) {
        super(continuation);
        this.this$0 = streamInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getArchiveStreamDownloadUrl(null, null, this);
    }
}
