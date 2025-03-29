package ru.tattelecom.intercom.android.resources.navigation;

import androidx.core.os.BundleKt;
import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.DeepLink;

/* compiled from: DeepLinkNavigator.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lru/tattelecom/intercom/android/resources/navigation/DeepLinkNavigator;", "", "()V", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DeepLinkNavigator {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: DeepLinkNavigator.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"Lru/tattelecom/intercom/android/resources/navigation/DeepLinkNavigator$Companion;", "", "()V", "navigate", "", "controller", "Landroidx/navigation/NavController;", "bottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "deepLink", "Lru/tattelecom/intercom/data/local/entity/DeepLink;", "DeepLinkTypes", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: DeepLinkNavigator.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/tattelecom/intercom/android/resources/navigation/DeepLinkNavigator$Companion$DeepLinkTypes;", "", "typeString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTypeString", "()Ljava/lang/String;", "RECEIVED_IMAGE", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class DeepLinkTypes {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ DeepLinkTypes[] $VALUES;
            public static final DeepLinkTypes RECEIVED_IMAGE = new DeepLinkTypes("RECEIVED_IMAGE", 0, "received_image");
            private final String typeString;

            private static final /* synthetic */ DeepLinkTypes[] $values() {
                return new DeepLinkTypes[]{RECEIVED_IMAGE};
            }

            public static EnumEntries<DeepLinkTypes> getEntries() {
                return $ENTRIES;
            }

            public static DeepLinkTypes valueOf(String str) {
                return (DeepLinkTypes) Enum.valueOf(DeepLinkTypes.class, str);
            }

            public static DeepLinkTypes[] values() {
                return (DeepLinkTypes[]) $VALUES.clone();
            }

            private DeepLinkTypes(String str, int i, String str2) {
                this.typeString = str2;
            }

            public final String getTypeString() {
                return this.typeString;
            }

            static {
                DeepLinkTypes[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }
        }

        private Companion() {
        }

        public final void navigate(NavController controller, BottomNavigationView bottomNav, DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(controller, "controller");
            Intrinsics.checkNotNullParameter(bottomNav, "bottomNav");
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            if (Intrinsics.areEqual(deepLink.getType(), DeepLinkTypes.RECEIVED_IMAGE.getTypeString())) {
                bottomNav.setSelectedItemId(NavGraphDestinations.Dest.INSTANCE.getProfile());
                NavExtKt.navigateSafe$default(controller, NavGraphDestinations.Dest.INSTANCE.getProfile(), BundleKt.bundleOf(TuplesKt.to(NavArg.DEEPLINK_CLIP_DATA, deepLink.getClipData())), null, 4, null);
            }
        }
    }
}
