package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: VideoPlayerFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class VideoPlayerFragment$initAdapter$1 extends FunctionReferenceImpl implements Function2<Long, Boolean, Unit> {
    VideoPlayerFragment$initAdapter$1(Object obj) {
        super(2, obj, VideoPlayerViewModel.class, "onArchiveTimeSelected", "onArchiveTimeSelected(JZ)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
        invoke(l.longValue(), bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long j, boolean z) {
        ((VideoPlayerViewModel) this.receiver).onArchiveTimeSelected(j, z);
    }
}
