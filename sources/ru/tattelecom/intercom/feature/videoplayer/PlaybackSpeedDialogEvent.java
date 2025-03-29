package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/PlaybackSpeedDialogEvent;", "", "()V", "Close", "Lru/tattelecom/intercom/feature/videoplayer/PlaybackSpeedDialogEvent$Close;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class PlaybackSpeedDialogEvent {
    public /* synthetic */ PlaybackSpeedDialogEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: VideoPlayerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/PlaybackSpeedDialogEvent$Close;", "Lru/tattelecom/intercom/feature/videoplayer/PlaybackSpeedDialogEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Close extends PlaybackSpeedDialogEvent {
        public static final Close INSTANCE = new Close();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Close)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 968807248;
        }

        public String toString() {
            return "Close";
        }

        private Close() {
            super(null);
        }
    }

    private PlaybackSpeedDialogEvent() {
    }
}
