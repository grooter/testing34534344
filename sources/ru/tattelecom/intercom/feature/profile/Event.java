package ru.tattelecom.intercom.feature.profile;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/profile/Event;", "", "()V", "Navigate", "ShowChatAlert", "ShowMessage", "Lru/tattelecom/intercom/feature/profile/Event$Navigate;", "Lru/tattelecom/intercom/feature/profile/Event$ShowChatAlert;", "Lru/tattelecom/intercom/feature/profile/Event$ShowMessage;", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public abstract class Event {
    public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: ProfileViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/profile/Event$Navigate;", "Lru/tattelecom/intercom/feature/profile/Event;", "action", "", "(I)V", "getAction", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Navigate extends Event {
        private final int action;

        public static /* synthetic */ Navigate copy$default(Navigate navigate, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = navigate.action;
            }
            return navigate.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getAction() {
            return this.action;
        }

        public final Navigate copy(int action) {
            return new Navigate(action);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Navigate) && this.action == ((Navigate) other).action;
        }

        public int hashCode() {
            return this.action;
        }

        public String toString() {
            return "Navigate(action=" + this.action + ")";
        }

        public Navigate(int i) {
            super(null);
            this.action = i;
        }

        public final int getAction() {
            return this.action;
        }
    }

    private Event() {
    }

    /* compiled from: ProfileViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/profile/Event$ShowMessage;", "Lru/tattelecom/intercom/feature/profile/Event;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    /* compiled from: ProfileViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/feature/profile/Event$ShowChatAlert;", "Lru/tattelecom/intercom/feature/profile/Event;", "phone", "", "formattedPhone", "(Ljava/lang/String;Ljava/lang/String;)V", "getFormattedPhone", "()Ljava/lang/String;", "getPhone", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "feature-profile_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowChatAlert extends Event {
        private final String formattedPhone;
        private final String phone;

        public static /* synthetic */ ShowChatAlert copy$default(ShowChatAlert showChatAlert, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = showChatAlert.phone;
            }
            if ((i & 2) != 0) {
                str2 = showChatAlert.formattedPhone;
            }
            return showChatAlert.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        /* renamed from: component2, reason: from getter */
        public final String getFormattedPhone() {
            return this.formattedPhone;
        }

        public final ShowChatAlert copy(String phone, String formattedPhone) {
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(formattedPhone, "formattedPhone");
            return new ShowChatAlert(phone, formattedPhone);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowChatAlert)) {
                return false;
            }
            ShowChatAlert showChatAlert = (ShowChatAlert) other;
            return Intrinsics.areEqual(this.phone, showChatAlert.phone) && Intrinsics.areEqual(this.formattedPhone, showChatAlert.formattedPhone);
        }

        public int hashCode() {
            return (this.phone.hashCode() * 31) + this.formattedPhone.hashCode();
        }

        public String toString() {
            return "ShowChatAlert(phone=" + this.phone + ", formattedPhone=" + this.formattedPhone + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowChatAlert(String phone, String formattedPhone) {
            super(null);
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(formattedPhone, "formattedPhone");
            this.phone = phone;
            this.formattedPhone = formattedPhone;
        }

        public final String getFormattedPhone() {
            return this.formattedPhone;
        }

        public final String getPhone() {
            return this.phone;
        }
    }
}
