package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BO\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\bHÖ\u0001J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÁ\u0001¢\u0006\u0002\b/R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u00062"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/CallRemote;", "", "seen1", "", TtmlNode.ATTR_ID, CrashHianalyticsData.TIME, "", "snapshot", "", NavArg.INTERCOM_ID, NavArg.VerifyCode.APARTMENT_ID, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getApartmentId$annotations", "()V", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getIntercomId$annotations", "getIntercomId", "getSnapshot", "()Ljava/lang/String;", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/CallRemote;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class CallRemote {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apartmentId;
    private final Integer id;
    private final Integer intercomId;
    private final String snapshot;
    private final Long time;

    public CallRemote() {
        this((Integer) null, (Long) null, (String) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CallRemote copy$default(CallRemote callRemote, Integer num, Long l, String str, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = callRemote.id;
        }
        if ((i & 2) != 0) {
            l = callRemote.time;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str = callRemote.snapshot;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            num2 = callRemote.intercomId;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            num3 = callRemote.apartmentId;
        }
        return callRemote.copy(num, l2, str2, num4, num3);
    }

    @SerialName("apartment_id")
    public static /* synthetic */ void getApartmentId$annotations() {
    }

    @SerialName("intercom_id")
    public static /* synthetic */ void getIntercomId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getTime() {
        return this.time;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSnapshot() {
        return this.snapshot;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getIntercomId() {
        return this.intercomId;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getApartmentId() {
        return this.apartmentId;
    }

    public final CallRemote copy(Integer id, Long time, String snapshot, Integer intercomId, Integer apartmentId) {
        return new CallRemote(id, time, snapshot, intercomId, apartmentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallRemote)) {
            return false;
        }
        CallRemote callRemote = (CallRemote) other;
        return Intrinsics.areEqual(this.id, callRemote.id) && Intrinsics.areEqual(this.time, callRemote.time) && Intrinsics.areEqual(this.snapshot, callRemote.snapshot) && Intrinsics.areEqual(this.intercomId, callRemote.intercomId) && Intrinsics.areEqual(this.apartmentId, callRemote.apartmentId);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Long l = this.time;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.snapshot;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.intercomId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.apartmentId;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        return "CallRemote(id=" + this.id + ", time=" + this.time + ", snapshot=" + this.snapshot + ", intercomId=" + this.intercomId + ", apartmentId=" + this.apartmentId + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/CallRemote$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/CallRemote;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<CallRemote> serializer() {
            return CallRemote$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ CallRemote(int i, Integer num, Long l, String str, @SerialName("intercom_id") Integer num2, @SerialName("apartment_id") Integer num3, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = num;
        }
        if ((i & 2) == 0) {
            this.time = null;
        } else {
            this.time = l;
        }
        if ((i & 4) == 0) {
            this.snapshot = null;
        } else {
            this.snapshot = str;
        }
        if ((i & 8) == 0) {
            this.intercomId = null;
        } else {
            this.intercomId = num2;
        }
        if ((i & 16) == 0) {
            this.apartmentId = null;
        } else {
            this.apartmentId = num3;
        }
    }

    public CallRemote(Integer num, Long l, String str, Integer num2, Integer num3) {
        this.id = num;
        this.time = l;
        this.snapshot = str;
        this.intercomId = num2;
        this.apartmentId = num3;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(CallRemote self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.time != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, LongSerializer.INSTANCE, self.time);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.snapshot != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.snapshot);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.intercomId != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.intercomId);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.apartmentId == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.apartmentId);
    }

    public /* synthetic */ CallRemote(Integer num, Long l, String str, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? null : num3);
    }

    public final Integer getId() {
        return this.id;
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
