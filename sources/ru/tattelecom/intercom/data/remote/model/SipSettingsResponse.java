package ru.tattelecom.intercom.data.remote.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002()B=\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J2\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014¨\u0006*"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SipSettingsResponse;", "", "seen1", "", FirebaseAnalytics.Event.LOGIN, "", "password", "regExpire", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getLogin$annotations", "()V", "getLogin", "()Ljava/lang/String;", "getPassword$annotations", "getPassword", "getRegExpire$annotations", "getRegExpire", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/SipSettingsResponse;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class SipSettingsResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String login;
    private final String password;
    private final Integer regExpire;

    public SipSettingsResponse() {
        this((String) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SipSettingsResponse copy$default(SipSettingsResponse sipSettingsResponse, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sipSettingsResponse.login;
        }
        if ((i & 2) != 0) {
            str2 = sipSettingsResponse.password;
        }
        if ((i & 4) != 0) {
            num = sipSettingsResponse.regExpire;
        }
        return sipSettingsResponse.copy(str, str2, num);
    }

    @SerialName("sip_login")
    public static /* synthetic */ void getLogin$annotations() {
    }

    @SerialName("sip_password")
    public static /* synthetic */ void getPassword$annotations() {
    }

    @SerialName("reg_expire_time")
    public static /* synthetic */ void getRegExpire$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPassword() {
        return this.password;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getRegExpire() {
        return this.regExpire;
    }

    public final SipSettingsResponse copy(String login, String password, Integer regExpire) {
        return new SipSettingsResponse(login, password, regExpire);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SipSettingsResponse)) {
            return false;
        }
        SipSettingsResponse sipSettingsResponse = (SipSettingsResponse) other;
        return Intrinsics.areEqual(this.login, sipSettingsResponse.login) && Intrinsics.areEqual(this.password, sipSettingsResponse.password) && Intrinsics.areEqual(this.regExpire, sipSettingsResponse.regExpire);
    }

    public int hashCode() {
        String str = this.login;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.password;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.regExpire;
        return hashCode2 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "SipSettingsResponse(login=" + this.login + ", password=" + this.password + ", regExpire=" + this.regExpire + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/SipSettingsResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/SipSettingsResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<SipSettingsResponse> serializer() {
            return SipSettingsResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ SipSettingsResponse(int i, @SerialName("sip_login") String str, @SerialName("sip_password") String str2, @SerialName("reg_expire_time") Integer num, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.login = null;
        } else {
            this.login = str;
        }
        if ((i & 2) == 0) {
            this.password = null;
        } else {
            this.password = str2;
        }
        if ((i & 4) == 0) {
            this.regExpire = null;
        } else {
            this.regExpire = num;
        }
    }

    public SipSettingsResponse(String str, String str2, Integer num) {
        this.login = str;
        this.password = str2;
        this.regExpire = num;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(SipSettingsResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.login != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.login);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.password != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.password);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.regExpire == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.regExpire);
    }

    public /* synthetic */ SipSettingsResponse(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : num);
    }

    public final String getLogin() {
        return this.login;
    }

    public final String getPassword() {
        return this.password;
    }

    public final Integer getRegExpire() {
        return this.regExpire;
    }
}
