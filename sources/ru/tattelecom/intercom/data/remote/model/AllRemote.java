package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002()BY\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBM\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010J&\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&HÁ\u0001¢\u0006\u0002\b'R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0015\u0012\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001b¨\u0006*"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/AllRemote;", "", "seen1", "", TtmlNode.ATTR_ID, "Lkotlinx/serialization/json/JsonPrimitive;", "type", "", CrashHianalyticsData.TIME, "", "snapshot", NavArg.INTERCOM_ID, NavArg.VerifyCode.APARTMENT_ID, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getApartmentId$annotations", "()V", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Lkotlinx/serialization/json/JsonPrimitive;", "getIntercomId$annotations", "getIntercomId", "getSnapshot", "()Ljava/lang/String;", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getType", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final class AllRemote {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apartmentId;
    private final JsonPrimitive id;
    private final Integer intercomId;
    private final String snapshot;
    private final Long time;
    private final String type;

    public AllRemote() {
        this((JsonPrimitive) null, (String) null, (Long) null, (String) null, (Integer) null, (Integer) null, 63, (DefaultConstructorMarker) null);
    }

    @SerialName("apartment_id")
    public static /* synthetic */ void getApartmentId$annotations() {
    }

    @SerialName("intercom_id")
    public static /* synthetic */ void getIntercomId$annotations() {
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/AllRemote$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/AllRemote;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AllRemote> serializer() {
            return AllRemote$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AllRemote(int i, JsonPrimitive jsonPrimitive, String str, Long l, String str2, @SerialName("intercom_id") Integer num, @SerialName("apartment_id") Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = jsonPrimitive;
        }
        if ((i & 2) == 0) {
            this.type = null;
        } else {
            this.type = str;
        }
        if ((i & 4) == 0) {
            this.time = null;
        } else {
            this.time = l;
        }
        if ((i & 8) == 0) {
            this.snapshot = null;
        } else {
            this.snapshot = str2;
        }
        if ((i & 16) == 0) {
            this.intercomId = null;
        } else {
            this.intercomId = num;
        }
        if ((i & 32) == 0) {
            this.apartmentId = null;
        } else {
            this.apartmentId = num2;
        }
    }

    public AllRemote(JsonPrimitive jsonPrimitive, String str, Long l, String str2, Integer num, Integer num2) {
        this.id = jsonPrimitive;
        this.type = str;
        this.time = l;
        this.snapshot = str2;
        this.intercomId = num;
        this.apartmentId = num2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(AllRemote self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, JsonPrimitiveSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.type != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, StringSerializer.INSTANCE, self.type);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.time != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, LongSerializer.INSTANCE, self.time);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.snapshot != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.snapshot);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.intercomId != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.intercomId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.apartmentId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.apartmentId);
    }

    public /* synthetic */ AllRemote(JsonPrimitive jsonPrimitive, String str, Long l, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : jsonPrimitive, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : num2);
    }

    public final JsonPrimitive getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final Long getTime() {
        return this.time;
    }

    public final String getSnapshot() {
        return this.snapshot;
    }

    public final Integer getIntercomId() {
        return this.intercomId;
    }

    public final Integer getApartmentId() {
        return this.apartmentId;
    }
}
