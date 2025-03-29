package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HomeListAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeItem;", "", "type", "", "key", "", "(ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getType", "()I", "Companion", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class HomeItem {
    public static final int TYPE_ADDRESS = 1;
    public static final int TYPE_READER = 3;
    public static final int TYPE_STREAM = 2;
    private final String key;
    private final int type;

    public HomeItem(int i, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.type = i;
        this.key = key;
    }

    public final int getType() {
        return this.type;
    }

    public String getKey() {
        return this.key;
    }
}
