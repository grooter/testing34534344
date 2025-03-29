package ru.tattelecom.intercom.feature.leave_order;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LeaveOrderViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/leave_order/Event;", "", "()V", "NavigateToErrorPage", "NavigateToSuccessPage", "ShowMessage", "Lru/tattelecom/intercom/feature/leave_order/Event$NavigateToErrorPage;", "Lru/tattelecom/intercom/feature/leave_order/Event$NavigateToSuccessPage;", "Lru/tattelecom/intercom/feature/leave_order/Event$ShowMessage;", "feature-leave-order_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class Event {
    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: LeaveOrderViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/leave_order/Event$NavigateToErrorPage;", "Lru/tattelecom/intercom/feature/leave_order/Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-leave-order_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NavigateToErrorPage extends Event {
        public static final NavigateToErrorPage INSTANCE = new NavigateToErrorPage();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateToErrorPage)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1904950463;
        }

        public String toString() {
            return "NavigateToErrorPage";
        }

        private NavigateToErrorPage() {
            super(null);
        }
    }

    private Event() {
    }

    /* compiled from: LeaveOrderViewModel.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/leave_order/Event$NavigateToSuccessPage;", "Lru/tattelecom/intercom/feature/leave_order/Event;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-leave-order_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class NavigateToSuccessPage extends Event {
        public static final NavigateToSuccessPage INSTANCE = new NavigateToSuccessPage();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavigateToSuccessPage)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1004912324;
        }

        public String toString() {
            return "NavigateToSuccessPage";
        }

        private NavigateToSuccessPage() {
            super(null);
        }
    }

    /* compiled from: LeaveOrderViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/leave_order/Event$ShowMessage;", "Lru/tattelecom/intercom/feature/leave_order/Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-leave-order_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowMessage extends Event {
        private final String message;

        public static /* synthetic */ ShowMessage copy$default(ShowMessage showMessage, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showMessage.message;
            }
            return showMessage.copy(str);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        public final ShowMessage copy(String message) {
            return new ShowMessage(message);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowMessage) && Intrinsics.areEqual(this.message, ((ShowMessage) other).message);
        }

        public int hashCode() {
            String str = this.message;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "ShowMessage(message=" + this.message + ")";
        }

        public ShowMessage(String str) {
            super(null);
            this.message = str;
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
