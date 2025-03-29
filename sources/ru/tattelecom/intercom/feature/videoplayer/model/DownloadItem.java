package ru.tattelecom.intercom.feature.videoplayer.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadItem.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem;", "Landroid/os/Parcelable;", "eventId", "", "url", "state", "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State;", "(Ljava/lang/String;Ljava/lang/String;Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State;)V", "getEventId", "()Ljava/lang/String;", "getState", "()Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State;", "getUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "State", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class DownloadItem implements Parcelable {
    public static final Parcelable.Creator<DownloadItem> CREATOR = new Creator();
    private final String eventId;
    private final State state;
    private final String url;

    /* compiled from: DownloadItem.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DownloadItem> {
        @Override // android.os.Parcelable.Creator
        public final DownloadItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DownloadItem(parcel.readString(), parcel.readString(), (State) parcel.readParcelable(DownloadItem.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final DownloadItem[] newArray(int i) {
            return new DownloadItem[i];
        }
    }

    public static /* synthetic */ DownloadItem copy$default(DownloadItem downloadItem, String str, String str2, State state, int i, Object obj) {
        if ((i & 1) != 0) {
            str = downloadItem.eventId;
        }
        if ((i & 2) != 0) {
            str2 = downloadItem.url;
        }
        if ((i & 4) != 0) {
            state = downloadItem.state;
        }
        return downloadItem.copy(str, str2, state);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component3, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public final DownloadItem copy(String eventId, String url, State state) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(state, "state");
        return new DownloadItem(eventId, url, state);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DownloadItem)) {
            return false;
        }
        DownloadItem downloadItem = (DownloadItem) other;
        return Intrinsics.areEqual(this.eventId, downloadItem.eventId) && Intrinsics.areEqual(this.url, downloadItem.url) && Intrinsics.areEqual(this.state, downloadItem.state);
    }

    public int hashCode() {
        return (((this.eventId.hashCode() * 31) + this.url.hashCode()) * 31) + this.state.hashCode();
    }

    public String toString() {
        return "DownloadItem(eventId=" + this.eventId + ", url=" + this.url + ", state=" + this.state + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.eventId);
        parcel.writeString(this.url);
        parcel.writeParcelable(this.state, flags);
    }

    public DownloadItem(String eventId, String url, State state) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(state, "state");
        this.eventId = eventId;
        this.url = url;
        this.state = state;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final State getState() {
        return this.state;
    }

    /* compiled from: DownloadItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State;", "Landroid/os/Parcelable;", "()V", "Error", "InProgress", "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State$Error;", "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State$InProgress;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State implements Parcelable {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }

        /* compiled from: DownloadItem.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State$InProgress;", "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State;", NotificationCompat.CATEGORY_PROGRESS, "", "(I)V", "getProgress", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class InProgress extends State {
            public static final Parcelable.Creator<InProgress> CREATOR = new Creator();
            private final int progress;

            /* compiled from: DownloadItem.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<InProgress> {
                @Override // android.os.Parcelable.Creator
                public final InProgress createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new InProgress(parcel.readInt());
                }

                @Override // android.os.Parcelable.Creator
                public final InProgress[] newArray(int i) {
                    return new InProgress[i];
                }
            }

            public static /* synthetic */ InProgress copy$default(InProgress inProgress, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = inProgress.progress;
                }
                return inProgress.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final InProgress copy(int progress) {
                return new InProgress(progress);
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof InProgress) && this.progress == ((InProgress) other).progress;
            }

            public int hashCode() {
                return this.progress;
            }

            public String toString() {
                return "InProgress(progress=" + this.progress + ")";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.progress);
            }

            public InProgress(int i) {
                super(null);
                this.progress = i;
            }

            public final int getProgress() {
                return this.progress;
            }
        }

        /* compiled from: DownloadItem.kt */
        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\t\u001a\u00020\u0004HÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004HÖ\u0001¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State$Error;", "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem$State;", "()V", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            public static final Error INSTANCE = new Error();
            public static final Parcelable.Creator<Error> CREATOR = new Creator();

            /* compiled from: DownloadItem.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            public static final class Creator implements Parcelable.Creator<Error> {
                @Override // android.os.Parcelable.Creator
                public final Error createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    parcel.readInt();
                    return Error.INSTANCE;
                }

                @Override // android.os.Parcelable.Creator
                public final Error[] newArray(int i) {
                    return new Error[i];
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1932872029;
            }

            public String toString() {
                return "Error";
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int flags) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(1);
            }

            private Error() {
                super(null);
            }
        }
    }
}
