package ru.tattelecom.intercom.feature.home.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: OpenChatEvent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/OpenChatEvent;", "", "state", "", "phone", "", "formattedPhone", "(ZLjava/lang/String;Ljava/lang/String;)V", "getFormattedPhone", "()Ljava/lang/String;", "getPhone", "getState", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class OpenChatEvent {
    private final String formattedPhone;
    private final String phone;
    private final boolean state;

    public static /* synthetic */ OpenChatEvent copy$default(OpenChatEvent openChatEvent, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = openChatEvent.state;
        }
        if ((i & 2) != 0) {
            str = openChatEvent.phone;
        }
        if ((i & 4) != 0) {
            str2 = openChatEvent.formattedPhone;
        }
        return openChatEvent.copy(z, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getState() {
        return this.state;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFormattedPhone() {
        return this.formattedPhone;
    }

    public final OpenChatEvent copy(boolean state, String phone, String formattedPhone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(formattedPhone, "formattedPhone");
        return new OpenChatEvent(state, phone, formattedPhone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpenChatEvent)) {
            return false;
        }
        OpenChatEvent openChatEvent = (OpenChatEvent) other;
        return this.state == openChatEvent.state && Intrinsics.areEqual(this.phone, openChatEvent.phone) && Intrinsics.areEqual(this.formattedPhone, openChatEvent.formattedPhone);
    }

    public int hashCode() {
        return (((AdvThemeDto$$ExternalSyntheticBackport0.m(this.state) * 31) + this.phone.hashCode()) * 31) + this.formattedPhone.hashCode();
    }

    public String toString() {
        return "OpenChatEvent(state=" + this.state + ", phone=" + this.phone + ", formattedPhone=" + this.formattedPhone + ")";
    }

    public OpenChatEvent(boolean z, String phone, String formattedPhone) {
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(formattedPhone, "formattedPhone");
        this.state = z;
        this.phone = phone;
        this.formattedPhone = formattedPhone;
    }

    public final boolean getState() {
        return this.state;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getFormattedPhone() {
        return this.formattedPhone;
    }
}
