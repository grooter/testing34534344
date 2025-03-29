package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/PlayerState;", "", "()V", "Camera", "Intercom", "Lru/tattelecom/intercom/feature/videoplayer/PlayerState$Camera;", "Lru/tattelecom/intercom/feature/videoplayer/PlayerState$Intercom;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class PlayerState {
    public /* synthetic */ PlayerState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: VideoPlayerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/PlayerState$Intercom;", "Lru/tattelecom/intercom/feature/videoplayer/PlayerState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Intercom extends PlayerState {
        public static final Intercom INSTANCE = new Intercom();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Intercom)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1908117757;
        }

        public String toString() {
            return "Intercom";
        }

        private Intercom() {
            super(null);
        }
    }

    private PlayerState() {
    }

    /* compiled from: VideoPlayerViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/PlayerState$Camera;", "Lru/tattelecom/intercom/feature/videoplayer/PlayerState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Camera extends PlayerState {
        public static final Camera INSTANCE = new Camera();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Camera)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -489885053;
        }

        public String toString() {
            return "Camera";
        }

        private Camera() {
            super(null);
        }
    }
}
