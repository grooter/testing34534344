package ru.tattelecom.intercom.lib_chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import im.threads.business.UserInfoBuilder;
import im.threads.business.core.UnreadMessagesCountListener;
import im.threads.ui.ChatCenterPushMessageHelper;
import im.threads.ui.ChatStyle;
import im.threads.ui.config.ConfigBuilder;
import im.threads.ui.core.ThreadsLib;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;
import ru.tattelecom.intercom.lib_chat.models.TransportConfig;

/* compiled from: EDNAChat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lru/tattelecom/intercom/lib_chat/EDNAChat;", "", "()V", "Companion", "lib-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EDNAChat {
    public static final String APP_UNREAD_COUNT_BROADCAST = "unread_count_broadcast";
    private static final String CHAT_PREFERENCES = "edna_chat_preferences";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int DEFAULT = 0;
    public static final int FROM_PUSH = 1;
    private static final String MainThemeNotSetException = "Main Theme not set";
    private static final String PREF_DATASTORE_URL = "pref_datastore_url";
    private static final String PREF_SERVER_BASE_URL = "pref_server_base_url";
    private static final String PREF_THREADS_GATE_PROVIDER_UID = "pref_threads_gate_provider_uid";
    private static final String PREF_THREADS_GATE_URL = "pref_threads_gate_url";
    public static final String UNREAD_COUNT_KEY = "unread_cont_key";
    private static String baseUrl;
    private static im.threads.ui.fragments.ChatFragment chat;
    private static ChatCenterPushMessageHelper chatCenterHelper;
    private static ChatStyle commonChatStyle;
    private static ChatStyle darkTheme;
    private static String dataStoreUrl;
    private static ChatStyle lightTheme;
    private static String threadsGateProviderUid;
    private static String threadsGateUrl;
    private static UnreadMessagesCountListener unreadMessagesCountListener;

    /* compiled from: EDNAChat.kt */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u001d\u001a\u00020\u001e2\u0016\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\b\u0010\"\u001a\u0004\u0018\u00010\u0015J\b\u0010#\u001a\u0004\u0018\u00010\u0015J\b\u0010$\u001a\u0004\u0018\u00010\u0015J\u0016\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020!J\u0010\u0010*\u001a\u0004\u0018\u00010\u00112\u0006\u0010+\u001a\u00020\u0007J&\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0016\u0010\u001f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020!\u0018\u00010 J\u000e\u0010/\u001a\u00020!2\u0006\u00100\u001a\u000201J\u001a\u00102\u001a\u00020!2\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000404J\u000e\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0004J\u000e\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\u0015J\u000e\u00109\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0004J\u000e\u0010=\u001a\u00020!2\u0006\u00108\u001a\u00020\u0015J\u000e\u0010>\u001a\u00020!2\u0006\u00108\u001a\u00020\u0015J\u000e\u0010?\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lru/tattelecom/intercom/lib_chat/EDNAChat$Companion;", "", "()V", "APP_UNREAD_COUNT_BROADCAST", "", "CHAT_PREFERENCES", "DEFAULT", "", "FROM_PUSH", "MainThemeNotSetException", "PREF_DATASTORE_URL", "PREF_SERVER_BASE_URL", "PREF_THREADS_GATE_PROVIDER_UID", "PREF_THREADS_GATE_URL", "UNREAD_COUNT_KEY", "baseUrl", "chat", "Lim/threads/ui/fragments/ChatFragment;", "chatCenterHelper", "Lim/threads/ui/ChatCenterPushMessageHelper;", "commonChatStyle", "Lim/threads/ui/ChatStyle;", "darkTheme", "dataStoreUrl", "lightTheme", "threadsGateProviderUid", "threadsGateUrl", "unreadMessagesCountListener", "Lim/threads/business/core/UnreadMessagesCountListener;", "checkNulls", "", "onErrorListener", "Lkotlin/Function1;", "", "getDarkTheme", "getLightTheme", "getMainChatTheme", "initUser", "userInfoBuilder", "Lim/threads/business/UserInfoBuilder;", "forceRegistration", "logoutUser", "newChatInstance", "openWay", "run", "context", "Landroid/content/Context;", "sendImage", "uri", "Landroid/net/Uri;", "sendMessage", "data", "", "setBaseUrl", "value", "setDarkTheme", "chatStyle", "setDataStoreUrl", "setFcmToken", PushNotificationArg.TECH_LOG_TOKEN, "setHmsToken", "setLightTheme", "setMainTheme", "setThreadsGateProviderUid", "setThreadsGateUrl", "setUnreadMessagesCountListener", "lib-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Companion setBaseUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            EDNAChat.baseUrl = value;
            return this;
        }

        public final Companion setDataStoreUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            EDNAChat.dataStoreUrl = value;
            return this;
        }

        public final Companion setThreadsGateUrl(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            EDNAChat.threadsGateUrl = value;
            return this;
        }

        public final Companion setThreadsGateProviderUid(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            EDNAChat.threadsGateProviderUid = value;
            return this;
        }

        public final Companion setUnreadMessagesCountListener(UnreadMessagesCountListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            EDNAChat.unreadMessagesCountListener = value;
            return this;
        }

        private final boolean checkNulls(Function1<? super String, Unit> onErrorListener) {
            String str = EDNAChat.baseUrl;
            if (str == null || str.length() == 0) {
                if (onErrorListener != null) {
                    onErrorListener.invoke("Value of baseUrl should not be null or empty!");
                }
                return false;
            }
            String str2 = EDNAChat.dataStoreUrl;
            if (str2 == null || str2.length() == 0) {
                if (onErrorListener != null) {
                    onErrorListener.invoke("Value of dataStoreUrl should not be null or empty!");
                }
                return false;
            }
            String str3 = EDNAChat.threadsGateUrl;
            if (str3 != null && str3.length() != 0) {
                return true;
            }
            if (onErrorListener != null) {
                onErrorListener.invoke("Value of threadsGateUrl should not be null or empty!");
            }
            return false;
        }

        public final void run(Context context, Function1<? super String, Unit> onErrorListener) throws Exception {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                if (checkNulls(onErrorListener)) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(EDNAChat.CHAT_PREFERENCES, 0);
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences("userPreferences", 0);
                    sharedPreferences.edit().putString(EDNAChat.PREF_SERVER_BASE_URL, EDNAChat.baseUrl).putString(EDNAChat.PREF_DATASTORE_URL, EDNAChat.dataStoreUrl).putString(EDNAChat.PREF_THREADS_GATE_URL, EDNAChat.threadsGateUrl).putString(EDNAChat.PREF_THREADS_GATE_PROVIDER_UID, EDNAChat.threadsGateProviderUid).apply();
                    ConfigBuilder showAttachmentsButton = new ConfigBuilder(context).surveyCompletionDelay(2000).historyLoadingCount(50).isDebugLoggingEnabled(true).showAttachmentsButton();
                    TransportConfig transportConfig = new TransportConfig(EDNAChat.baseUrl, EDNAChat.dataStoreUrl, EDNAChat.threadsGateUrl, EDNAChat.threadsGateProviderUid);
                    showAttachmentsButton.unreadMessagesCountListener(EDNAChat.unreadMessagesCountListener).serverBaseUrl(transportConfig.getBaseUrl()).datastoreUrl(transportConfig.getDatastoreUrl()).threadsGateUrl(transportConfig.getThreadsGateUrl()).threadsGateProviderUid(transportConfig.getThreadsGateProviderUid()).keepSocketActive(true).setNewChatCenterApi().allowUntrustedSSLCertificates(true);
                    ThreadsLib.INSTANCE.init(showAttachmentsButton);
                    ChatCenterPushMessageHelper chatCenterPushMessageHelper = EDNAChat.chatCenterHelper;
                    if (chatCenterPushMessageHelper == null) {
                        chatCenterPushMessageHelper = new ChatCenterPushMessageHelper();
                    }
                    EDNAChat.chatCenterHelper = chatCenterPushMessageHelper;
                    String string = sharedPreferences2.getString(NavArg.DEVICE_ID, null);
                    if (string != null) {
                        ChatCenterPushMessageHelper chatCenterPushMessageHelper2 = EDNAChat.chatCenterHelper;
                        Intrinsics.checkNotNull(chatCenterPushMessageHelper2);
                        chatCenterPushMessageHelper2.setFcmToken(string);
                        ChatCenterPushMessageHelper chatCenterPushMessageHelper3 = EDNAChat.chatCenterHelper;
                        Intrinsics.checkNotNull(chatCenterPushMessageHelper3);
                        chatCenterPushMessageHelper3.setHcmToken(string);
                    }
                }
            } catch (Exception e) {
                if (onErrorListener != null) {
                    onErrorListener.invoke(e.getMessage());
                }
            }
        }

        public final void initUser(UserInfoBuilder userInfoBuilder, boolean forceRegistration) {
            Intrinsics.checkNotNullParameter(userInfoBuilder, "userInfoBuilder");
            if (ThreadsLib.INSTANCE.getInstance().isUserInitialized()) {
                return;
            }
            ThreadsLib.INSTANCE.getInstance().initUser(userInfoBuilder, forceRegistration);
        }

        public final void logoutUser() {
            ThreadsLib.INSTANCE.getInstance().logoutClient();
        }

        public final im.threads.ui.fragments.ChatFragment newChatInstance(int openWay) {
            if (!im.threads.ui.fragments.ChatFragment.INSTANCE.isShown()) {
                EDNAChat.chat = im.threads.ui.fragments.ChatFragment.INSTANCE.newInstance(openWay);
                return EDNAChat.chat;
            }
            return EDNAChat.chat;
        }

        public final void sendImage(Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            ThreadsLib.INSTANCE.getInstance().sendMessage("", uri);
        }

        public final void setMainTheme(ChatStyle chatStyle) {
            Intrinsics.checkNotNullParameter(chatStyle, "chatStyle");
            EDNAChat.commonChatStyle = chatStyle;
        }

        public final ChatStyle getMainChatTheme() {
            return EDNAChat.commonChatStyle;
        }

        public final void setLightTheme(ChatStyle chatStyle) throws Exception {
            Intrinsics.checkNotNullParameter(chatStyle, "chatStyle");
            if (EDNAChat.commonChatStyle != null) {
                EDNAChat.lightTheme = chatStyle;
                ThreadsLib.INSTANCE.getInstance().applyLightTheme(chatStyle);
                return;
            }
            throw new Exception(EDNAChat.MainThemeNotSetException);
        }

        public final ChatStyle getLightTheme() {
            return EDNAChat.lightTheme;
        }

        public final void setDarkTheme(ChatStyle chatStyle) throws Exception {
            Intrinsics.checkNotNullParameter(chatStyle, "chatStyle");
            if (EDNAChat.commonChatStyle != null) {
                EDNAChat.darkTheme = chatStyle;
                ThreadsLib.INSTANCE.getInstance().applyDarkTheme(chatStyle);
                return;
            }
            throw new Exception(EDNAChat.MainThemeNotSetException);
        }

        public final ChatStyle getDarkTheme() {
            return EDNAChat.darkTheme;
        }

        public final void setFcmToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "token");
            ChatCenterPushMessageHelper chatCenterPushMessageHelper = EDNAChat.chatCenterHelper;
            if (chatCenterPushMessageHelper != null) {
                chatCenterPushMessageHelper.setFcmToken(r2);
            }
        }

        public final void setHmsToken(String r2) {
            Intrinsics.checkNotNullParameter(r2, "token");
            ChatCenterPushMessageHelper chatCenterPushMessageHelper = EDNAChat.chatCenterHelper;
            if (chatCenterPushMessageHelper != null) {
                chatCenterPushMessageHelper.setHcmToken(r2);
            }
        }

        public final void sendMessage(Map<String, String> data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ChatCenterPushMessageHelper chatCenterPushMessageHelper = EDNAChat.chatCenterHelper;
            if (chatCenterPushMessageHelper != null) {
                chatCenterPushMessageHelper.process(data);
            }
        }
    }
}
