package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: VideoPlayerFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class VideoPlayerFragment$initAdapter$2 extends FunctionReferenceImpl implements Function0<Unit> {
    VideoPlayerFragment$initAdapter$2(Object obj) {
        super(0, obj, VideoPlayerFragment.class, "showConnectServicesBanner", "showConnectServicesBanner()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((VideoPlayerFragment) this.receiver).showConnectServicesBanner();
    }
}
