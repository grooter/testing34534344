package ru.tattelecom.intercom.data.remote.model.responses;

import androidx.media3.extractor.text.ttml.TtmlNode;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: ConfigResponses.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0005,-./0BA\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J&\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*HÁ\u0001¢\u0006\u0002\b+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u00061"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "", "seen1", "", "success", "", "data", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;", "subscriber", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;", "trial", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;)V", "getData", "()Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;", "getSubscriber", "()Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrial", "()Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;)Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "Data", "Subscriber", "Trial", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class ConfigResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Data data;
    private final Subscriber subscriber;
    private final Boolean success;
    private final Trial trial;

    public ConfigResponse() {
        this((Boolean) null, (Data) null, (Subscriber) null, (Trial) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConfigResponse copy$default(ConfigResponse configResponse, Boolean bool, Data data, Subscriber subscriber, Trial trial, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = configResponse.success;
        }
        if ((i & 2) != 0) {
            data = configResponse.data;
        }
        if ((i & 4) != 0) {
            subscriber = configResponse.subscriber;
        }
        if ((i & 8) != 0) {
            trial = configResponse.trial;
        }
        return configResponse.copy(bool, data, subscriber, trial);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final Data getData() {
        return this.data;
    }

    /* renamed from: component3, reason: from getter */
    public final Subscriber getSubscriber() {
        return this.subscriber;
    }

    /* renamed from: component4, reason: from getter */
    public final Trial getTrial() {
        return this.trial;
    }

    public final ConfigResponse copy(Boolean success, Data data, Subscriber subscriber, Trial trial) {
        return new ConfigResponse(success, data, subscriber, trial);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigResponse)) {
            return false;
        }
        ConfigResponse configResponse = (ConfigResponse) other;
        return Intrinsics.areEqual(this.success, configResponse.success) && Intrinsics.areEqual(this.data, configResponse.data) && Intrinsics.areEqual(this.subscriber, configResponse.subscriber) && Intrinsics.areEqual(this.trial, configResponse.trial);
    }

    public int hashCode() {
        Boolean bool = this.success;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Data data = this.data;
        int hashCode2 = (hashCode + (data == null ? 0 : data.hashCode())) * 31;
        Subscriber subscriber = this.subscriber;
        int hashCode3 = (hashCode2 + (subscriber == null ? 0 : subscriber.hashCode())) * 31;
        Trial trial = this.trial;
        return hashCode3 + (trial != null ? trial.hashCode() : 0);
    }

    public String toString() {
        return "ConfigResponse(success=" + this.success + ", data=" + this.data + ", subscriber=" + this.subscriber + ", trial=" + this.trial + ")";
    }

    /* compiled from: ConfigResponses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<ConfigResponse> serializer() {
            return ConfigResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ ConfigResponse(int i, Boolean bool, Data data, Subscriber subscriber, Trial trial, SerializationConstructorMarker serializationConstructorMarker) {
        this.success = (i & 1) == 0 ? false : bool;
        if ((i & 2) == 0) {
            this.data = null;
        } else {
            this.data = data;
        }
        if ((i & 4) == 0) {
            this.subscriber = null;
        } else {
            this.subscriber = subscriber;
        }
        if ((i & 8) == 0) {
            this.trial = null;
        } else {
            this.trial = trial;
        }
    }

    public ConfigResponse(Boolean bool, Data data, Subscriber subscriber, Trial trial) {
        this.success = bool;
        this.data = data;
        this.subscriber = subscriber;
        this.trial = trial;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(ConfigResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !Intrinsics.areEqual((Object) self.success, (Object) false)) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.success);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, ConfigResponse$Data$$serializer.INSTANCE, self.data);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.subscriber != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, ConfigResponse$Subscriber$$serializer.INSTANCE, self.subscriber);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && self.trial == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 3, ConfigResponse$Trial$$serializer.INSTANCE, self.trial);
    }

    public /* synthetic */ ConfigResponse(Boolean bool, Data data, Subscriber subscriber, Trial trial, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? null : data, (i & 4) != 0 ? null : subscriber, (i & 8) != 0 ? null : trial);
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final Data getData() {
        return this.data;
    }

    public final Subscriber getSubscriber() {
        return this.subscriber;
    }

    /* compiled from: ConfigResponses.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0002$%B1\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J&\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"HÁ\u0001¢\u0006\u0002\b#R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0013¨\u0006&"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;", "", "seen1", "", "featRemoteLogging", "", "openDoorLockTimeout", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getFeatRemoteLogging$annotations", "()V", "getFeatRemoteLogging", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getOpenDoorLockTimeout$annotations", "getOpenDoorLockTimeout", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Data {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean featRemoteLogging;
        private final String openDoorLockTimeout;

        public Data() {
            this((Boolean) null, (String) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0));
        }

        public static /* synthetic */ Data copy$default(Data data, Boolean bool, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = data.featRemoteLogging;
            }
            if ((i & 2) != 0) {
                str = data.openDoorLockTimeout;
            }
            return data.copy(bool, str);
        }

        @SerialName("feat_remote_logging")
        public static /* synthetic */ void getFeatRemoteLogging$annotations() {
        }

        @SerialName("open_door_lock_timeout")
        public static /* synthetic */ void getOpenDoorLockTimeout$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getFeatRemoteLogging() {
            return this.featRemoteLogging;
        }

        /* renamed from: component2, reason: from getter */
        public final String getOpenDoorLockTimeout() {
            return this.openDoorLockTimeout;
        }

        public final Data copy(Boolean featRemoteLogging, String openDoorLockTimeout) {
            return new Data(featRemoteLogging, openDoorLockTimeout);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Data)) {
                return false;
            }
            Data data = (Data) other;
            return Intrinsics.areEqual(this.featRemoteLogging, data.featRemoteLogging) && Intrinsics.areEqual(this.openDoorLockTimeout, data.openDoorLockTimeout);
        }

        public int hashCode() {
            Boolean bool = this.featRemoteLogging;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            String str = this.openDoorLockTimeout;
            return hashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Data(featRemoteLogging=" + this.featRemoteLogging + ", openDoorLockTimeout=" + this.openDoorLockTimeout + ")";
        }

        /* compiled from: ConfigResponses.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Data;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return ConfigResponse$Data$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Data(int i, @SerialName("feat_remote_logging") Boolean bool, @SerialName("open_door_lock_timeout") String str, SerializationConstructorMarker serializationConstructorMarker) {
            if ((i & 1) == 0) {
                this.featRemoteLogging = null;
            } else {
                this.featRemoteLogging = bool;
            }
            if ((i & 2) == 0) {
                this.openDoorLockTimeout = null;
            } else {
                this.openDoorLockTimeout = str;
            }
        }

        public Data(Boolean bool, String str) {
            this.featRemoteLogging = bool;
            this.openDoorLockTimeout = str;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$data_release(Data self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.featRemoteLogging != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.featRemoteLogging);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.openDoorLockTimeout == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.openDoorLockTimeout);
        }

        public /* synthetic */ Data(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str);
        }

        public final Boolean getFeatRemoteLogging() {
            return this.featRemoteLogging;
        }

        public final String getOpenDoorLockTimeout() {
            return this.openDoorLockTimeout;
        }
    }

    public final Trial getTrial() {
        return this.trial;
    }

    /* compiled from: ConfigResponses.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u00029:Bg\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBM\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0010J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010&\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\bHÆ\u0003Jb\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u00020\bHÖ\u0001J&\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207HÁ\u0001¢\u0006\u0002\b8R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\f\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u001e\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0018¨\u0006;"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;", "", "seen1", "", "firstEnter", "", TtmlNode.ATTR_ID, "signature", "", "firstName", "secondName", "thirdName", "phone", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFirstEnter$annotations", "()V", "getFirstEnter", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFirstName$annotations", "getFirstName", "()Ljava/lang/String;", "fullName", "getFullName", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPhone", "getSecondName$annotations", "getSecondName", "getSignature", "getThirdName$annotations", "getThirdName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Subscriber {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Boolean firstEnter;
        private final String firstName;
        private final Integer id;
        private final String phone;
        private final String secondName;
        private final String signature;
        private final String thirdName;

        public static /* synthetic */ Subscriber copy$default(Subscriber subscriber, Boolean bool, Integer num, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = subscriber.firstEnter;
            }
            if ((i & 2) != 0) {
                num = subscriber.id;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                str = subscriber.signature;
            }
            String str6 = str;
            if ((i & 8) != 0) {
                str2 = subscriber.firstName;
            }
            String str7 = str2;
            if ((i & 16) != 0) {
                str3 = subscriber.secondName;
            }
            String str8 = str3;
            if ((i & 32) != 0) {
                str4 = subscriber.thirdName;
            }
            String str9 = str4;
            if ((i & 64) != 0) {
                str5 = subscriber.phone;
            }
            return subscriber.copy(bool, num2, str6, str7, str8, str9, str5);
        }

        @SerialName("first_enter")
        public static /* synthetic */ void getFirstEnter$annotations() {
        }

        @SerialName("first_name")
        public static /* synthetic */ void getFirstName$annotations() {
        }

        @SerialName("second_name")
        public static /* synthetic */ void getSecondName$annotations() {
        }

        @SerialName("third_name")
        public static /* synthetic */ void getThirdName$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Boolean getFirstEnter() {
            return this.firstEnter;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        /* renamed from: component3, reason: from getter */
        public final String getSignature() {
            return this.signature;
        }

        /* renamed from: component4, reason: from getter */
        public final String getFirstName() {
            return this.firstName;
        }

        /* renamed from: component5, reason: from getter */
        public final String getSecondName() {
            return this.secondName;
        }

        /* renamed from: component6, reason: from getter */
        public final String getThirdName() {
            return this.thirdName;
        }

        /* renamed from: component7, reason: from getter */
        public final String getPhone() {
            return this.phone;
        }

        public final Subscriber copy(Boolean firstEnter, Integer id, String signature, String firstName, String secondName, String thirdName, String phone) {
            return new Subscriber(firstEnter, id, signature, firstName, secondName, thirdName, phone);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Subscriber)) {
                return false;
            }
            Subscriber subscriber = (Subscriber) other;
            return Intrinsics.areEqual(this.firstEnter, subscriber.firstEnter) && Intrinsics.areEqual(this.id, subscriber.id) && Intrinsics.areEqual(this.signature, subscriber.signature) && Intrinsics.areEqual(this.firstName, subscriber.firstName) && Intrinsics.areEqual(this.secondName, subscriber.secondName) && Intrinsics.areEqual(this.thirdName, subscriber.thirdName) && Intrinsics.areEqual(this.phone, subscriber.phone);
        }

        public int hashCode() {
            Boolean bool = this.firstEnter;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Integer num = this.id;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            String str = this.signature;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.firstName;
            int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.secondName;
            int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.thirdName;
            int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.phone;
            return hashCode6 + (str5 != null ? str5.hashCode() : 0);
        }

        public String toString() {
            return "Subscriber(firstEnter=" + this.firstEnter + ", id=" + this.id + ", signature=" + this.signature + ", firstName=" + this.firstName + ", secondName=" + this.secondName + ", thirdName=" + this.thirdName + ", phone=" + this.phone + ")";
        }

        /* compiled from: ConfigResponses.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Subscriber;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Subscriber> serializer() {
                return ConfigResponse$Subscriber$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Subscriber(int i, @SerialName("first_enter") Boolean bool, Integer num, String str, @SerialName("first_name") String str2, @SerialName("second_name") String str3, @SerialName("third_name") String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
            if (126 != (i & 126)) {
                PluginExceptionsKt.throwMissingFieldException(i, 126, ConfigResponse$Subscriber$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.firstEnter = null;
            } else {
                this.firstEnter = bool;
            }
            this.id = num;
            this.signature = str;
            this.firstName = str2;
            this.secondName = str3;
            this.thirdName = str4;
            this.phone = str5;
        }

        public Subscriber(Boolean bool, Integer num, String str, String str2, String str3, String str4, String str5) {
            this.firstEnter = bool;
            this.id = num;
            this.signature = str;
            this.firstName = str2;
            this.secondName = str3;
            this.thirdName = str4;
            this.phone = str5;
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$data_release(Subscriber self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.firstEnter != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.firstEnter);
            }
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.id);
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.signature);
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.firstName);
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.secondName);
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.thirdName);
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.phone);
        }

        public /* synthetic */ Subscriber(Boolean bool, Integer num, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : bool, num, str, str2, str3, str4, str5);
        }

        public final Boolean getFirstEnter() {
            return this.firstEnter;
        }

        public final Integer getId() {
            return this.id;
        }

        public final String getSignature() {
            return this.signature;
        }

        public final String getFirstName() {
            return this.firstName;
        }

        public final String getSecondName() {
            return this.secondName;
        }

        public final String getThirdName() {
            return this.thirdName;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getFullName() {
            String str;
            String str2;
            String str3 = this.firstName;
            if ((str3 == null || str3.length() == 0) && (((str = this.secondName) == null || str.length() == 0) && ((str2 = this.thirdName) == null || str2.length() == 0))) {
                return null;
            }
            return this.firstName + " " + this.secondName + " " + this.thirdName;
        }
    }

    /* compiled from: ConfigResponses.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002*+BG\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB5\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J&\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÁ\u0001¢\u0006\u0002\b)R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0011\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0007\u0010\u0014R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0005\u0010\u0014¨\u0006,"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;", "", "seen1", "", TtmlNode.ATTR_ID, "isAvailable", "", "isActive", "expireDays", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)V", "getExpireDays$annotations", "()V", "getExpireDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "isActive$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isAvailable$annotations", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;", "equals", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Trial {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Integer expireDays;
        private final Integer id;
        private final Boolean isActive;
        private final Boolean isAvailable;

        public Trial() {
            this((Integer) null, (Boolean) null, (Boolean) null, (Integer) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Trial copy$default(Trial trial, Integer num, Boolean bool, Boolean bool2, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                num = trial.id;
            }
            if ((i & 2) != 0) {
                bool = trial.isAvailable;
            }
            if ((i & 4) != 0) {
                bool2 = trial.isActive;
            }
            if ((i & 8) != 0) {
                num2 = trial.expireDays;
            }
            return trial.copy(num, bool, bool2, num2);
        }

        @SerialName("expire_days")
        public static /* synthetic */ void getExpireDays$annotations() {
        }

        @SerialName("is_active")
        public static /* synthetic */ void isActive$annotations() {
        }

        @SerialName("is_available")
        public static /* synthetic */ void isAvailable$annotations() {
        }

        /* renamed from: component1, reason: from getter */
        public final Integer getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getIsAvailable() {
            return this.isAvailable;
        }

        /* renamed from: component3, reason: from getter */
        public final Boolean getIsActive() {
            return this.isActive;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getExpireDays() {
            return this.expireDays;
        }

        public final Trial copy(Integer id, Boolean isAvailable, Boolean isActive, Integer expireDays) {
            return new Trial(id, isAvailable, isActive, expireDays);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Trial)) {
                return false;
            }
            Trial trial = (Trial) other;
            return Intrinsics.areEqual(this.id, trial.id) && Intrinsics.areEqual(this.isAvailable, trial.isAvailable) && Intrinsics.areEqual(this.isActive, trial.isActive) && Intrinsics.areEqual(this.expireDays, trial.expireDays);
        }

        public int hashCode() {
            Integer num = this.id;
            int hashCode = (num == null ? 0 : num.hashCode()) * 31;
            Boolean bool = this.isAvailable;
            int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
            Boolean bool2 = this.isActive;
            int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Integer num2 = this.expireDays;
            return hashCode3 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Trial(id=" + this.id + ", isAvailable=" + this.isAvailable + ", isActive=" + this.isActive + ", expireDays=" + this.expireDays + ")";
        }

        /* compiled from: ConfigResponses.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse$Trial;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Trial> serializer() {
                return ConfigResponse$Trial$$serializer.INSTANCE;
            }
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Trial(int i, Integer num, @SerialName("is_available") Boolean bool, @SerialName("is_active") Boolean bool2, @SerialName("expire_days") Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
            this.id = (i & 1) == 0 ? null : num;
            if ((i & 2) == 0) {
                this.isAvailable = false;
            } else {
                this.isAvailable = bool;
            }
            if ((i & 4) == 0) {
                this.isActive = false;
            } else {
                this.isActive = bool2;
            }
            if ((i & 8) == 0) {
                this.expireDays = 0;
            } else {
                this.expireDays = num2;
            }
        }

        public Trial(Integer num, Boolean bool, Boolean bool2, Integer num2) {
            this.id = num;
            this.isAvailable = bool;
            this.isActive = bool2;
            this.expireDays = num2;
        }

        public final Integer getId() {
            return this.id;
        }

        public /* synthetic */ Trial(Integer num, Boolean bool, Boolean bool2, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : num, (i & 2) != 0 ? false : bool, (i & 4) != 0 ? false : bool2, (i & 8) != 0 ? 0 : num2);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$data_release(Trial self, CompositeEncoder output, SerialDescriptor serialDesc) {
            Integer num;
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || !Intrinsics.areEqual((Object) self.isAvailable, (Object) false)) {
                output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.isAvailable);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 2) || !Intrinsics.areEqual((Object) self.isActive, (Object) false)) {
                output.encodeNullableSerializableElement(serialDesc, 2, BooleanSerializer.INSTANCE, self.isActive);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 3) || (num = self.expireDays) == null || num.intValue() != 0) {
                output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.expireDays);
            }
        }

        public final Boolean isAvailable() {
            return this.isAvailable;
        }

        public final Boolean isActive() {
            return this.isActive;
        }

        public final Integer getExpireDays() {
            return this.expireDays;
        }
    }
}
