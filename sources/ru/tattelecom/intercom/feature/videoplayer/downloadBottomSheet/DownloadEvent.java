package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadViewModel.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "", "()V", "ChangeProgress", "DownloadComplete", "DownloadStarted", "Error", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$ChangeProgress;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$DownloadComplete;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$DownloadStarted;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$Error;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class DownloadEvent {
    public /* synthetic */ DownloadEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: DownloadViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$ChangeProgress;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "percentage", "", "(I)V", "getPercentage", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChangeProgress extends DownloadEvent {
        private final int percentage;

        public static /* synthetic */ ChangeProgress copy$default(ChangeProgress changeProgress, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = changeProgress.percentage;
            }
            return changeProgress.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getPercentage() {
            return this.percentage;
        }

        public final ChangeProgress copy(int percentage) {
            return new ChangeProgress(percentage);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChangeProgress) && this.percentage == ((ChangeProgress) other).percentage;
        }

        public int hashCode() {
            return this.percentage;
        }

        public String toString() {
            return "ChangeProgress(percentage=" + this.percentage + ")";
        }

        public ChangeProgress(int i) {
            super(null);
            this.percentage = i;
        }

        public final int getPercentage() {
            return this.percentage;
        }
    }

    private DownloadEvent() {
    }

    /* compiled from: DownloadViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$Error;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Error extends DownloadEvent {
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            return error.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final Error copy(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            return new Error(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Error) && Intrinsics.areEqual(this.message, ((Error) other).message);
        }

        public int hashCode() {
            return this.message.hashCode();
        }

        public String toString() {
            return "Error(message=" + this.message + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(String message) {
            super(null);
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: DownloadViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$DownloadStarted;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DownloadStarted extends DownloadEvent {
        public static final DownloadStarted INSTANCE = new DownloadStarted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadStarted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1137031205;
        }

        public String toString() {
            return "DownloadStarted";
        }

        private DownloadStarted() {
            super(null);
        }
    }

    /* compiled from: DownloadViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent$DownloadComplete;", "Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/DownloadEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DownloadComplete extends DownloadEvent {
        public static final DownloadComplete INSTANCE = new DownloadComplete();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DownloadComplete)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1490490655;
        }

        public String toString() {
            return "DownloadComplete";
        }

        private DownloadComplete() {
            super(null);
        }
    }
}
