package ru.tattelecom.intercom.feature.trial.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TrialEvent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/trial/model/TrialEvent;", "", "()V", "CloseScreen", "ShowSnack", "Lru/tattelecom/intercom/feature/trial/model/TrialEvent$CloseScreen;", "Lru/tattelecom/intercom/feature/trial/model/TrialEvent$ShowSnack;", "trial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class TrialEvent {
    public /* synthetic */ TrialEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: TrialEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/trial/model/TrialEvent$CloseScreen;", "Lru/tattelecom/intercom/feature/trial/model/TrialEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "trial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class CloseScreen extends TrialEvent {
        public static final CloseScreen INSTANCE = new CloseScreen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CloseScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 933915013;
        }

        public String toString() {
            return "CloseScreen";
        }

        private CloseScreen() {
            super(null);
        }
    }

    private TrialEvent() {
    }

    /* compiled from: TrialEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/trial/model/TrialEvent$ShowSnack;", "Lru/tattelecom/intercom/feature/trial/model/TrialEvent;", "message", "", "(I)V", "getMessage", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "trial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowSnack extends TrialEvent {
        private final int message;

        public static /* synthetic */ ShowSnack copy$default(ShowSnack showSnack, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = showSnack.message;
            }
            return showSnack.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getMessage() {
            return this.message;
        }

        public final ShowSnack copy(int message) {
            return new ShowSnack(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowSnack) && this.message == ((ShowSnack) other).message;
        }

        public int hashCode() {
            return this.message;
        }

        public String toString() {
            return "ShowSnack(message=" + this.message + ")";
        }

        public ShowSnack(int i) {
            super(null);
            this.message = i;
        }

        public final int getMessage() {
            return this.message;
        }
    }
}
