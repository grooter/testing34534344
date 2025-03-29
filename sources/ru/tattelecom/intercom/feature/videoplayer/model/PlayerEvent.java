package ru.tattelecom.intercom.feature.videoplayer.model;

import androidx.core.view.GravityCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: PlayerEvent.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "", "()V", "ShowCustomSnackBar", "ShowEmergencyCode", "ShowMessageSnackBar", "ShowSnackbar", "StartDownload", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowCustomSnackBar;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowEmergencyCode;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowMessageSnackBar;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowSnackbar;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$StartDownload;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class PlayerEvent {
    public /* synthetic */ PlayerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: PlayerEvent.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jv\u0010'\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001d\u0010\u0015¨\u0006/"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowCustomSnackBar;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "titleText", "", "titleGravity", "messageText", "messageGravity", "buttonText", "buttonGravity", "buttonCallback", "Lkotlin/Function0;", "", "closeButtonVisibility", "", "duration", "(Ljava/lang/Integer;ILjava/lang/Integer;ILjava/lang/Integer;ILkotlin/jvm/functions/Function0;ZI)V", "getButtonCallback", "()Lkotlin/jvm/functions/Function0;", "getButtonGravity", "()I", "getButtonText", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCloseButtonVisibility", "()Z", "getDuration", "getMessageGravity", "getMessageText", "getTitleGravity", "getTitleText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;ILjava/lang/Integer;ILjava/lang/Integer;ILkotlin/jvm/functions/Function0;ZI)Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowCustomSnackBar;", "equals", "other", "", "hashCode", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowCustomSnackBar extends PlayerEvent {
        private final Function0<Unit> buttonCallback;
        private final int buttonGravity;
        private final Integer buttonText;
        private final boolean closeButtonVisibility;
        private final int duration;
        private final int messageGravity;
        private final Integer messageText;
        private final int titleGravity;
        private final Integer titleText;

        public ShowCustomSnackBar() {
            this(null, 0, null, 0, null, 0, null, false, 0, 511, null);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getTitleText() {
            return this.titleText;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTitleGravity() {
            return this.titleGravity;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getMessageText() {
            return this.messageText;
        }

        /* renamed from: component4, reason: from getter */
        public final int getMessageGravity() {
            return this.messageGravity;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getButtonText() {
            return this.buttonText;
        }

        /* renamed from: component6, reason: from getter */
        public final int getButtonGravity() {
            return this.buttonGravity;
        }

        public final Function0<Unit> component7() {
            return this.buttonCallback;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getCloseButtonVisibility() {
            return this.closeButtonVisibility;
        }

        /* renamed from: component9, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        public final ShowCustomSnackBar copy(Integer titleText, int titleGravity, Integer messageText, int messageGravity, Integer buttonText, int buttonGravity, Function0<Unit> buttonCallback, boolean closeButtonVisibility, int duration) {
            return new ShowCustomSnackBar(titleText, titleGravity, messageText, messageGravity, buttonText, buttonGravity, buttonCallback, closeButtonVisibility, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowCustomSnackBar)) {
                return false;
            }
            ShowCustomSnackBar showCustomSnackBar = (ShowCustomSnackBar) other;
            return Intrinsics.areEqual(this.titleText, showCustomSnackBar.titleText) && this.titleGravity == showCustomSnackBar.titleGravity && Intrinsics.areEqual(this.messageText, showCustomSnackBar.messageText) && this.messageGravity == showCustomSnackBar.messageGravity && Intrinsics.areEqual(this.buttonText, showCustomSnackBar.buttonText) && this.buttonGravity == showCustomSnackBar.buttonGravity && Intrinsics.areEqual(this.buttonCallback, showCustomSnackBar.buttonCallback) && this.closeButtonVisibility == showCustomSnackBar.closeButtonVisibility && this.duration == showCustomSnackBar.duration;
        }

        public int hashCode() {
            Integer num = this.titleText;
            int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.titleGravity) * 31;
            Integer num2 = this.messageText;
            int hashCode2 = (((hashCode + (num2 == null ? 0 : num2.hashCode())) * 31) + this.messageGravity) * 31;
            Integer num3 = this.buttonText;
            int hashCode3 = (((hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31) + this.buttonGravity) * 31;
            Function0<Unit> function0 = this.buttonCallback;
            return ((((hashCode3 + (function0 != null ? function0.hashCode() : 0)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.closeButtonVisibility)) * 31) + this.duration;
        }

        public String toString() {
            return "ShowCustomSnackBar(titleText=" + this.titleText + ", titleGravity=" + this.titleGravity + ", messageText=" + this.messageText + ", messageGravity=" + this.messageGravity + ", buttonText=" + this.buttonText + ", buttonGravity=" + this.buttonGravity + ", buttonCallback=" + this.buttonCallback + ", closeButtonVisibility=" + this.closeButtonVisibility + ", duration=" + this.duration + ")";
        }

        public /* synthetic */ ShowCustomSnackBar(Integer num, int i, Integer num2, int i2, Integer num3, int i3, Function0 function0, boolean z, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : num, (i5 & 2) != 0 ? 8388611 : i, (i5 & 4) != 0 ? null : num2, (i5 & 8) != 0 ? 8388611 : i2, (i5 & 16) != 0 ? null : num3, (i5 & 32) == 0 ? i3 : GravityCompat.START, (i5 & 64) == 0 ? function0 : null, (i5 & 128) != 0 ? false : z, (i5 & 256) != 0 ? 5000 : i4);
        }

        public final Integer getTitleText() {
            return this.titleText;
        }

        public final int getTitleGravity() {
            return this.titleGravity;
        }

        public final Integer getMessageText() {
            return this.messageText;
        }

        public final int getMessageGravity() {
            return this.messageGravity;
        }

        public final Integer getButtonText() {
            return this.buttonText;
        }

        public final int getButtonGravity() {
            return this.buttonGravity;
        }

        public final Function0<Unit> getButtonCallback() {
            return this.buttonCallback;
        }

        public final boolean getCloseButtonVisibility() {
            return this.closeButtonVisibility;
        }

        public final int getDuration() {
            return this.duration;
        }

        public ShowCustomSnackBar(Integer num, int i, Integer num2, int i2, Integer num3, int i3, Function0<Unit> function0, boolean z, int i4) {
            super(null);
            this.titleText = num;
            this.titleGravity = i;
            this.messageText = num2;
            this.messageGravity = i2;
            this.buttonText = num3;
            this.buttonGravity = i3;
            this.buttonCallback = function0;
            this.closeButtonVisibility = z;
            this.duration = i4;
        }
    }

    private PlayerEvent() {
    }

    /* compiled from: PlayerEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J.\u0010\u0010\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowMessageSnackBar;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "text", "", "gravity", "duration", "(Ljava/lang/Integer;II)V", "getDuration", "()I", "getGravity", "getText", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;II)Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowMessageSnackBar;", "equals", "", "other", "", "hashCode", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowMessageSnackBar extends PlayerEvent {
        private final int duration;
        private final int gravity;
        private final Integer text;

        public ShowMessageSnackBar() {
            this(null, 0, 0, 7, null);
        }

        public static /* synthetic */ ShowMessageSnackBar copy$default(ShowMessageSnackBar showMessageSnackBar, Integer num, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                num = showMessageSnackBar.text;
            }
            if ((i3 & 2) != 0) {
                i = showMessageSnackBar.gravity;
            }
            if ((i3 & 4) != 0) {
                i2 = showMessageSnackBar.duration;
            }
            return showMessageSnackBar.copy(num, i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final int getGravity() {
            return this.gravity;
        }

        /* renamed from: component3, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        public final ShowMessageSnackBar copy(Integer text, int gravity, int duration) {
            return new ShowMessageSnackBar(text, gravity, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowMessageSnackBar)) {
                return false;
            }
            ShowMessageSnackBar showMessageSnackBar = (ShowMessageSnackBar) other;
            return Intrinsics.areEqual(this.text, showMessageSnackBar.text) && this.gravity == showMessageSnackBar.gravity && this.duration == showMessageSnackBar.duration;
        }

        public int hashCode() {
            Integer num = this.text;
            return ((((num == null ? 0 : num.hashCode()) * 31) + this.gravity) * 31) + this.duration;
        }

        public String toString() {
            return "ShowMessageSnackBar(text=" + this.text + ", gravity=" + this.gravity + ", duration=" + this.duration + ")";
        }

        public /* synthetic */ ShowMessageSnackBar(Integer num, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? GravityCompat.START : i, (i3 & 4) != 0 ? 5000 : i2);
        }

        public final Integer getText() {
            return this.text;
        }

        public final int getGravity() {
            return this.gravity;
        }

        public final int getDuration() {
            return this.duration;
        }

        public ShowMessageSnackBar(Integer num, int i, int i2) {
            super(null);
            this.text = num;
            this.gravity = i;
            this.duration = i2;
        }
    }

    /* compiled from: PlayerEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowSnackbar;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "text", "", "duration", "(II)V", "getDuration", "()I", "getText", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowSnackbar extends PlayerEvent {
        private final int duration;
        private final int text;

        public static /* synthetic */ ShowSnackbar copy$default(ShowSnackbar showSnackbar, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = showSnackbar.text;
            }
            if ((i3 & 2) != 0) {
                i2 = showSnackbar.duration;
            }
            return showSnackbar.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getText() {
            return this.text;
        }

        /* renamed from: component2, reason: from getter */
        public final int getDuration() {
            return this.duration;
        }

        public final ShowSnackbar copy(int text, int duration) {
            return new ShowSnackbar(text, duration);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowSnackbar)) {
                return false;
            }
            ShowSnackbar showSnackbar = (ShowSnackbar) other;
            return this.text == showSnackbar.text && this.duration == showSnackbar.duration;
        }

        public int hashCode() {
            return (this.text * 31) + this.duration;
        }

        public String toString() {
            return "ShowSnackbar(text=" + this.text + ", duration=" + this.duration + ")";
        }

        public /* synthetic */ ShowSnackbar(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i3 & 2) != 0 ? -1 : i2);
        }

        public final int getText() {
            return this.text;
        }

        public final int getDuration() {
            return this.duration;
        }

        public ShowSnackbar(int i, int i2) {
            super(null);
            this.text = i;
            this.duration = i2;
        }
    }

    /* compiled from: PlayerEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$ShowEmergencyCode;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "code", "", "(I)V", "getCode", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ShowEmergencyCode extends PlayerEvent {
        private final int code;

        public static /* synthetic */ ShowEmergencyCode copy$default(ShowEmergencyCode showEmergencyCode, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = showEmergencyCode.code;
            }
            return showEmergencyCode.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public final ShowEmergencyCode copy(int code) {
            return new ShowEmergencyCode(code);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShowEmergencyCode) && this.code == ((ShowEmergencyCode) other).code;
        }

        public int hashCode() {
            return this.code;
        }

        public String toString() {
            return "ShowEmergencyCode(code=" + this.code + ")";
        }

        public ShowEmergencyCode(int i) {
            super(null);
            this.code = i;
        }

        public final int getCode() {
            return this.code;
        }
    }

    /* compiled from: PlayerEvent.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent$StartDownload;", "Lru/tattelecom/intercom/feature/videoplayer/model/PlayerEvent;", "url", "", "eventId", "startTime", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getEventId", "()Ljava/lang/String;", "getStartTime", "()J", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StartDownload extends PlayerEvent {
        private final String eventId;
        private final long startTime;
        private final String url;

        public static /* synthetic */ StartDownload copy$default(StartDownload startDownload, String str, String str2, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = startDownload.url;
            }
            if ((i & 2) != 0) {
                str2 = startDownload.eventId;
            }
            if ((i & 4) != 0) {
                j = startDownload.startTime;
            }
            return startDownload.copy(str, str2, j);
        }

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final String getEventId() {
            return this.eventId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getStartTime() {
            return this.startTime;
        }

        public final StartDownload copy(String url, String eventId, long startTime) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            return new StartDownload(url, eventId, startTime);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StartDownload)) {
                return false;
            }
            StartDownload startDownload = (StartDownload) other;
            return Intrinsics.areEqual(this.url, startDownload.url) && Intrinsics.areEqual(this.eventId, startDownload.eventId) && this.startTime == startDownload.startTime;
        }

        public int hashCode() {
            return (((this.url.hashCode() * 31) + this.eventId.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.startTime);
        }

        public String toString() {
            return "StartDownload(url=" + this.url + ", eventId=" + this.eventId + ", startTime=" + this.startTime + ")";
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getEventId() {
            return this.eventId;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartDownload(String url, String eventId, long j) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            this.url = url;
            this.eventId = eventId;
            this.startTime = j;
        }
    }
}
