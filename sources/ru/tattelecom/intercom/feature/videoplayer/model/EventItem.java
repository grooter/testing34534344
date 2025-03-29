package ru.tattelecom.intercom.feature.videoplayer.model;

import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: EventItem.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001:\u0001%B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003JG\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/EventItem;", "", TtmlNode.ATTR_ID, "", "gateId", "", "type", "startDate", "Ljava/util/Date;", "duration", "", "state", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State;", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/Date;JLru/tattelecom/intercom/feature/videoplayer/model/EventItem$State;)V", "getDuration", "()J", "getGateId", "()I", "getId", "()Ljava/lang/String;", "getStartDate", "()Ljava/util/Date;", "getState", "()Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State;", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "State", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EventItem {
    private final long duration;
    private final int gateId;
    private final String id;
    private final Date startDate;
    private final State state;
    private final String type;

    public static /* synthetic */ EventItem copy$default(EventItem eventItem, String str, int i, String str2, Date date, long j, State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = eventItem.id;
        }
        if ((i2 & 2) != 0) {
            i = eventItem.gateId;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = eventItem.type;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            date = eventItem.startDate;
        }
        Date date2 = date;
        if ((i2 & 16) != 0) {
            j = eventItem.duration;
        }
        long j2 = j;
        if ((i2 & 32) != 0) {
            state = eventItem.state;
        }
        return eventItem.copy(str, i3, str3, date2, j2, state);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGateId() {
        return this.gateId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final Date getStartDate() {
        return this.startDate;
    }

    /* renamed from: component5, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component6, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public final EventItem copy(String id, int gateId, String type, Date startDate, long duration, State state) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        return new EventItem(id, gateId, type, startDate, duration, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EventItem)) {
            return false;
        }
        EventItem eventItem = (EventItem) other;
        return Intrinsics.areEqual(this.id, eventItem.id) && this.gateId == eventItem.gateId && Intrinsics.areEqual(this.type, eventItem.type) && Intrinsics.areEqual(this.startDate, eventItem.startDate) && this.duration == eventItem.duration && Intrinsics.areEqual(this.state, eventItem.state);
    }

    public int hashCode() {
        int hashCode = ((((((((this.id.hashCode() * 31) + this.gateId) * 31) + this.type.hashCode()) * 31) + this.startDate.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.duration)) * 31;
        State state = this.state;
        return hashCode + (state == null ? 0 : state.hashCode());
    }

    public String toString() {
        return "EventItem(id=" + this.id + ", gateId=" + this.gateId + ", type=" + this.type + ", startDate=" + this.startDate + ", duration=" + this.duration + ", state=" + this.state + ")";
    }

    public EventItem(String id, int i, String type, Date startDate, long j, State state) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(startDate, "startDate");
        this.id = id;
        this.gateId = i;
        this.type = type;
        this.startDate = startDate;
        this.duration = j;
        this.state = state;
    }

    public /* synthetic */ EventItem(String str, int i, String str2, Date date, long j, State state, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, date, j, (i2 & 32) != 0 ? null : state);
    }

    public final String getId() {
        return this.id;
    }

    public final int getGateId() {
        return this.gateId;
    }

    public final String getType() {
        return this.type;
    }

    public final Date getStartDate() {
        return this.startDate;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final State getState() {
        return this.state;
    }

    /* compiled from: EventItem.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State;", "", "()V", "Downloading", "Error", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State$Downloading;", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State$Error;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: EventItem.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State$Downloading;", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State;", NotificationCompat.CATEGORY_PROGRESS, "", "(I)V", "getProgress", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Downloading extends State {
            private final int progress;

            public static /* synthetic */ Downloading copy$default(Downloading downloading, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = downloading.progress;
                }
                return downloading.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Downloading copy(int progress) {
                return new Downloading(progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Downloading) && this.progress == ((Downloading) other).progress;
            }

            public int hashCode() {
                return this.progress;
            }

            public String toString() {
                return "Downloading(progress=" + this.progress + ")";
            }

            public Downloading(int i) {
                super(null);
                this.progress = i;
            }

            public final int getProgress() {
                return this.progress;
            }
        }

        private State() {
        }

        /* compiled from: EventItem.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State$Error;", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem$State;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class Error extends State {
            public static final Error INSTANCE = new Error();

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
                return 2047842245;
            }

            public String toString() {
                return "Error";
            }

            private Error() {
                super(null);
            }
        }
    }
}
