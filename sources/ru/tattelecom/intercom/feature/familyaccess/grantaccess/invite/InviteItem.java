package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import kotlin.Metadata;

/* compiled from: GuestsAdapter.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteItem;", "", "type", "", "(I)V", "getType", "()I", "Companion", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public class InviteItem {
    public static final int TYPE_APARTMENT = 1;
    public static final int TYPE_GUEST = 0;
    private final int type;

    public InviteItem(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }
}
