package ru.tattelecom.intercom.lib_chat.models;

import com.google.android.gms.fido.u2f.api.common.SignResponseData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;

/* compiled from: UserInfo.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0002:;Bg\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003Jc\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0003HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001J&\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208HÁ\u0001¢\u0006\u0002\b9R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015¨\u0006<"}, d2 = {"Lru/tattelecom/intercom/lib_chat/models/UserInfo;", "", "seen1", "", "userId", "", "authToken", "authSchema", SignResponseData.JSON_RESPONSE_DATA_CLIENT_DATA, "clientIdSignature", "userName", "appMarker", "clientIdEncrypted", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAppMarker", "()Ljava/lang/String;", "setAppMarker", "(Ljava/lang/String;)V", "getAuthSchema", "setAuthSchema", "getAuthToken", "setAuthToken", "getClientData", "setClientData", "getClientIdEncrypted", "()Z", "setClientIdEncrypted", "(Z)V", "getClientIdSignature", "setClientIdSignature", "getUserId", "getUserName", "setUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lib_chat_release", "$serializer", "Companion", "lib-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes8.dex */
public final /* data */ class UserInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String appMarker;
    private String authSchema;
    private String authToken;
    private String clientData;
    private boolean clientIdEncrypted;
    private String clientIdSignature;
    private final String userId;
    private String userName;

    /* renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAuthToken() {
        return this.authToken;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAuthSchema() {
        return this.authSchema;
    }

    /* renamed from: component4, reason: from getter */
    public final String getClientData() {
        return this.clientData;
    }

    /* renamed from: component5, reason: from getter */
    public final String getClientIdSignature() {
        return this.clientIdSignature;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAppMarker() {
        return this.appMarker;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getClientIdEncrypted() {
        return this.clientIdEncrypted;
    }

    public final UserInfo copy(String userId, String authToken, String authSchema, String clientData, String clientIdSignature, String userName, String appMarker, boolean clientIdEncrypted) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(clientIdSignature, "clientIdSignature");
        return new UserInfo(userId, authToken, authSchema, clientData, clientIdSignature, userName, appMarker, clientIdEncrypted);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.userId, userInfo.userId) && Intrinsics.areEqual(this.authToken, userInfo.authToken) && Intrinsics.areEqual(this.authSchema, userInfo.authSchema) && Intrinsics.areEqual(this.clientData, userInfo.clientData) && Intrinsics.areEqual(this.clientIdSignature, userInfo.clientIdSignature) && Intrinsics.areEqual(this.userName, userInfo.userName) && Intrinsics.areEqual(this.appMarker, userInfo.appMarker) && this.clientIdEncrypted == userInfo.clientIdEncrypted;
    }

    public int hashCode() {
        int hashCode = this.userId.hashCode() * 31;
        String str = this.authToken;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.authSchema;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.clientData;
        int hashCode4 = (((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.clientIdSignature.hashCode()) * 31;
        String str4 = this.userName;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.appMarker;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.clientIdEncrypted);
    }

    public String toString() {
        return "UserInfo(userId=" + this.userId + ", authToken=" + this.authToken + ", authSchema=" + this.authSchema + ", clientData=" + this.clientData + ", clientIdSignature=" + this.clientIdSignature + ", userName=" + this.userName + ", appMarker=" + this.appMarker + ", clientIdEncrypted=" + this.clientIdEncrypted + ")";
    }

    /* compiled from: UserInfo.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/lib_chat/models/UserInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/lib_chat/models/UserInfo;", "lib-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<UserInfo> serializer() {
            return UserInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ UserInfo(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i, 127, UserInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.userId = str;
        this.authToken = str2;
        this.authSchema = str3;
        this.clientData = str4;
        this.clientIdSignature = str5;
        this.userName = str6;
        this.appMarker = str7;
        if ((i & 128) == 0) {
            this.clientIdEncrypted = false;
        } else {
            this.clientIdEncrypted = z;
        }
    }

    public UserInfo(String userId, String str, String str2, String str3, String clientIdSignature, String str4, String str5, boolean z) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(clientIdSignature, "clientIdSignature");
        this.userId = userId;
        this.authToken = str;
        this.authSchema = str2;
        this.clientData = str3;
        this.clientIdSignature = clientIdSignature;
        this.userName = str4;
        this.appMarker = str5;
        this.clientIdEncrypted = z;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$lib_chat_release(UserInfo self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.userId);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.authToken);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.authSchema);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.clientData);
        output.encodeStringElement(serialDesc, 4, self.clientIdSignature);
        output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.userName);
        output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.appMarker);
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.clientIdEncrypted) {
            output.encodeBooleanElement(serialDesc, 7, self.clientIdEncrypted);
        }
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, (i & 128) != 0 ? false : z);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getAuthToken() {
        return this.authToken;
    }

    public final void setAuthToken(String str) {
        this.authToken = str;
    }

    public final String getAuthSchema() {
        return this.authSchema;
    }

    public final void setAuthSchema(String str) {
        this.authSchema = str;
    }

    public final String getClientData() {
        return this.clientData;
    }

    public final void setClientData(String str) {
        this.clientData = str;
    }

    public final String getClientIdSignature() {
        return this.clientIdSignature;
    }

    public final void setClientIdSignature(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.clientIdSignature = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        this.userName = str;
    }

    public final String getAppMarker() {
        return this.appMarker;
    }

    public final void setAppMarker(String str) {
        this.appMarker = str;
    }

    public final boolean getClientIdEncrypted() {
        return this.clientIdEncrypted;
    }

    public final void setClientIdEncrypted(boolean z) {
        this.clientIdEncrypted = z;
    }
}
