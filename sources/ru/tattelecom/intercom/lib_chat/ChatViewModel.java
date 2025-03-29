package ru.tattelecom.intercom.lib_chat;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse;

/* compiled from: ChatViewModel.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/lib_chat/ChatViewModel;", "Landroidx/lifecycle/ViewModel;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;)V", PushNotificationArg.TECH_LOG_TOKEN, "", "getToken", "()Ljava/lang/String;", "userConfig", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "getUserConfig", "()Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "feature-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ChatViewModel extends ViewModel {
    private final String token;
    private final ConfigResponse userConfig;

    public ChatViewModel(UserPrefsSource prefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.userConfig = prefs.getUserConfig();
        this.token = prefs.getToken();
    }

    public final ConfigResponse getUserConfig() {
        return this.userConfig;
    }

    public final String getToken() {
        return this.token;
    }
}
