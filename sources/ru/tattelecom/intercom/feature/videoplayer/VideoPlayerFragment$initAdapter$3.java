package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class VideoPlayerFragment$initAdapter$3 extends FunctionReferenceImpl implements Function3<Long, Long, String, Unit> {
    VideoPlayerFragment$initAdapter$3(Object obj) {
        super(3, obj, VideoPlayerFragment.class, "tryToStartDownload", "tryToStartDownload(JJLjava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, String str) {
        invoke(l.longValue(), l2.longValue(), str);
        return Unit.INSTANCE;
    }

    public final void invoke(long j, long j2, String p2) {
        Intrinsics.checkNotNullParameter(p2, "p2");
        ((VideoPlayerFragment) this.receiver).tryToStartDownload(j, j2, p2);
    }
}
