package ru.tattelecom.intercom.feature.call;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SipManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallState;", "", "()V", "Accepted", "Ended", "Incoming", "NoCall", "Released", "Lru/tattelecom/intercom/feature/call/CallState$Accepted;", "Lru/tattelecom/intercom/feature/call/CallState$Ended;", "Lru/tattelecom/intercom/feature/call/CallState$Incoming;", "Lru/tattelecom/intercom/feature/call/CallState$NoCall;", "Lru/tattelecom/intercom/feature/call/CallState$Released;", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class CallState {
    public /* synthetic */ CallState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: SipManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallState$NoCall;", "Lru/tattelecom/intercom/feature/call/CallState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NoCall extends CallState {
        public static final NoCall INSTANCE = new NoCall();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NoCall)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1552031300;
        }

        public String toString() {
            return "NoCall";
        }

        private NoCall() {
            super(null);
        }
    }

    private CallState() {
    }

    /* compiled from: SipManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallState$Incoming;", "Lru/tattelecom/intercom/feature/call/CallState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Incoming extends CallState {
        public static final Incoming INSTANCE = new Incoming();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Incoming)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1230955805;
        }

        public String toString() {
            return "Incoming";
        }

        private Incoming() {
            super(null);
        }
    }

    /* compiled from: SipManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallState$Accepted;", "Lru/tattelecom/intercom/feature/call/CallState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Accepted extends CallState {
        public static final Accepted INSTANCE = new Accepted();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Accepted)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 824689252;
        }

        public String toString() {
            return "Accepted";
        }

        private Accepted() {
            super(null);
        }
    }

    /* compiled from: SipManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallState$Released;", "Lru/tattelecom/intercom/feature/call/CallState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Released extends CallState {
        public static final Released INSTANCE = new Released();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Released)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1875051526;
        }

        public String toString() {
            return "Released";
        }

        private Released() {
            super(null);
        }
    }

    /* compiled from: SipManager.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/call/CallState$Ended;", "Lru/tattelecom/intercom/feature/call/CallState;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-call_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Ended extends CallState {
        public static final Ended INSTANCE = new Ended();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Ended)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1327098141;
        }

        public String toString() {
            return "Ended";
        }

        private Ended() {
            super(null);
        }
    }
}
