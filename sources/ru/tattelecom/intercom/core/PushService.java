package ru.tattelecom.intercom.core;

import com.google.firebase.messaging.FirebaseMessaging;
import kotlin.Metadata;

/* compiled from: PushService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/core/PushService;", "", "()V", FirebaseMessaging.INSTANCE_ID_SCOPE, "", "HMS", "core"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushService {
    public static final String FCM = "fcm";
    public static final String HMS = "hms";
    public static final PushService INSTANCE = new PushService();

    private PushService() {
    }
}
