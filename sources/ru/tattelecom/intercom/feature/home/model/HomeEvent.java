package ru.tattelecom.intercom.feature.home.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: HomeEvent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeEvent;", "", "()V", "OpenTrialScreen", "OpenWelcomeScreen", "Lru/tattelecom/intercom/feature/home/model/HomeEvent$OpenTrialScreen;", "Lru/tattelecom/intercom/feature/home/model/HomeEvent$OpenWelcomeScreen;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class HomeEvent {
    public /* synthetic */ HomeEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: HomeEvent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeEvent$OpenWelcomeScreen;", "Lru/tattelecom/intercom/feature/home/model/HomeEvent;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OpenWelcomeScreen extends HomeEvent {
        public static final OpenWelcomeScreen INSTANCE = new OpenWelcomeScreen();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenWelcomeScreen)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 1446180555;
        }

        public String toString() {
            return "OpenWelcomeScreen";
        }

        private OpenWelcomeScreen() {
            super(null);
        }
    }

    private HomeEvent() {
    }

    /* compiled from: HomeEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ.\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/feature/home/model/HomeEvent$OpenTrialScreen;", "Lru/tattelecom/intercom/feature/home/model/HomeEvent;", TtmlNode.ATTR_ID, "", "screen", "", NavArg.TrialScreen.DAYS_COUNT, "(ILjava/lang/String;Ljava/lang/Integer;)V", "getDaysCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()I", "getScreen", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Integer;)Lru/tattelecom/intercom/feature/home/model/HomeEvent$OpenTrialScreen;", "equals", "", "other", "", "hashCode", "toString", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class OpenTrialScreen extends HomeEvent {
        private final Integer daysCount;
        private final int id;
        private final String screen;

        public static /* synthetic */ OpenTrialScreen copy$default(OpenTrialScreen openTrialScreen, int i, String str, Integer num, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = openTrialScreen.id;
            }
            if ((i2 & 2) != 0) {
                str = openTrialScreen.screen;
            }
            if ((i2 & 4) != 0) {
                num = openTrialScreen.daysCount;
            }
            return openTrialScreen.copy(i, str, num);
        }

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getScreen() {
            return this.screen;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getDaysCount() {
            return this.daysCount;
        }

        public final OpenTrialScreen copy(int id, String screen, Integer daysCount) {
            Intrinsics.checkNotNullParameter(screen, "screen");
            return new OpenTrialScreen(id, screen, daysCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenTrialScreen)) {
                return false;
            }
            OpenTrialScreen openTrialScreen = (OpenTrialScreen) other;
            return this.id == openTrialScreen.id && Intrinsics.areEqual(this.screen, openTrialScreen.screen) && Intrinsics.areEqual(this.daysCount, openTrialScreen.daysCount);
        }

        public int hashCode() {
            int hashCode = ((this.id * 31) + this.screen.hashCode()) * 31;
            Integer num = this.daysCount;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "OpenTrialScreen(id=" + this.id + ", screen=" + this.screen + ", daysCount=" + this.daysCount + ")";
        }

        public final int getId() {
            return this.id;
        }

        public final String getScreen() {
            return this.screen;
        }

        public /* synthetic */ OpenTrialScreen(int i, String str, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i, str, (i2 & 4) != 0 ? 0 : num);
        }

        public final Integer getDaysCount() {
            return this.daysCount;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenTrialScreen(int i, String screen, Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(screen, "screen");
            this.id = i;
            this.screen = screen;
            this.daysCount = num;
        }
    }
}
