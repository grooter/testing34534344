package ru.tattelecom.intercom.lib_chat.models;

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

/* compiled from: TransportConfig.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%BA\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/lib_chat/models/TransportConfig;", "", "seen1", "", "baseUrl", "", "datastoreUrl", "threadsGateUrl", "threadsGateProviderUid", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getDatastoreUrl", "getThreadsGateProviderUid", "getThreadsGateUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$lib_chat_release", "$serializer", "Companion", "lib-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes8.dex */
public final /* data */ class TransportConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String baseUrl;
    private final String datastoreUrl;
    private final String threadsGateProviderUid;
    private final String threadsGateUrl;

    public static /* synthetic */ TransportConfig copy$default(TransportConfig transportConfig, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = transportConfig.baseUrl;
        }
        if ((i & 2) != 0) {
            str2 = transportConfig.datastoreUrl;
        }
        if ((i & 4) != 0) {
            str3 = transportConfig.threadsGateUrl;
        }
        if ((i & 8) != 0) {
            str4 = transportConfig.threadsGateProviderUid;
        }
        return transportConfig.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDatastoreUrl() {
        return this.datastoreUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getThreadsGateUrl() {
        return this.threadsGateUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final String getThreadsGateProviderUid() {
        return this.threadsGateProviderUid;
    }

    public final TransportConfig copy(String baseUrl, String datastoreUrl, String threadsGateUrl, String threadsGateProviderUid) {
        return new TransportConfig(baseUrl, datastoreUrl, threadsGateUrl, threadsGateProviderUid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportConfig)) {
            return false;
        }
        TransportConfig transportConfig = (TransportConfig) other;
        return Intrinsics.areEqual(this.baseUrl, transportConfig.baseUrl) && Intrinsics.areEqual(this.datastoreUrl, transportConfig.datastoreUrl) && Intrinsics.areEqual(this.threadsGateUrl, transportConfig.threadsGateUrl) && Intrinsics.areEqual(this.threadsGateProviderUid, transportConfig.threadsGateProviderUid);
    }

    public int hashCode() {
        String str = this.baseUrl;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.datastoreUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.threadsGateUrl;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.threadsGateProviderUid;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TransportConfig(baseUrl=" + this.baseUrl + ", datastoreUrl=" + this.datastoreUrl + ", threadsGateUrl=" + this.threadsGateUrl + ", threadsGateProviderUid=" + this.threadsGateProviderUid + ")";
    }

    /* compiled from: TransportConfig.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/lib_chat/models/TransportConfig$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/lib_chat/models/TransportConfig;", "lib-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<TransportConfig> serializer() {
            return TransportConfig$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ TransportConfig(int i, String str, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, TransportConfig$$serializer.INSTANCE.getDescriptor());
        }
        this.baseUrl = str;
        this.datastoreUrl = str2;
        this.threadsGateUrl = str3;
        this.threadsGateProviderUid = str4;
    }

    public TransportConfig(String str, String str2, String str3, String str4) {
        this.baseUrl = str;
        this.datastoreUrl = str2;
        this.threadsGateUrl = str3;
        this.threadsGateProviderUid = str4;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$lib_chat_release(TransportConfig self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.baseUrl);
        output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.datastoreUrl);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.threadsGateUrl);
        output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.threadsGateProviderUid);
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final String getDatastoreUrl() {
        return this.datastoreUrl;
    }

    public final String getThreadsGateUrl() {
        return this.threadsGateUrl;
    }

    public final String getThreadsGateProviderUid() {
        return this.threadsGateProviderUid;
    }
}
