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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 12\u00020\u0001:\u000201BO\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rBA\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012JJ\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J&\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.HÁ\u0001¢\u0006\u0002\b/R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R \u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0013\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a¨\u00062"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/PassRemote;", "", "seen1", "", TtmlNode.ATTR_ID, "", CrashHianalyticsData.TIME, "", "snapshot", NavArg.INTERCOM_ID, NavArg.VerifyCode.APARTMENT_ID, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getApartmentId$annotations", "()V", "getApartmentId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "()Ljava/lang/String;", "getIntercomId$annotations", "getIntercomId", "getSnapshot", "getTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lru/tattelecom/intercom/data/remote/model/PassRemote;", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class PassRemote {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer apartmentId;
    private final String id;
    private final Integer intercomId;
    private final String snapshot;
    private final Long time;

    public PassRemote() {
        this((String) null, (Long) null, (String) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PassRemote copy$default(PassRemote passRemote, String str, Long l, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = passRemote.id;
        }
        if ((i & 2) != 0) {
            l = passRemote.time;
        }
        Long l2 = l;
        if ((i & 4) != 0) {
            str2 = passRemote.snapshot;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            num = passRemote.intercomId;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = passRemote.apartmentId;
        }
        return passRemote.copy(str, l2, str3, num3, num2);
    }

    @SerialName("apartment_id")
    public static /* synthetic */ void getApartmentId$annotations() {
    }

    @SerialName("intercom_id")
    public static /* synthetic */ void getIntercomId$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
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

    public final PassRemote copy(String id, Long time, String snapshot, Integer intercomId, Integer apartmentId) {
        return new PassRemote(id, time, snapshot, intercomId, apartmentId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PassRemote)) {
            return false;
        }
        PassRemote passRemote = (PassRemote) other;
        return Intrinsics.areEqual(this.id, passRemote.id) && Intrinsics.areEqual(this.time, passRemote.time) && Intrinsics.areEqual(this.snapshot, passRemote.snapshot) && Intrinsics.areEqual(this.intercomId, passRemote.intercomId) && Intrinsics.areEqual(this.apartmentId, passRemote.apartmentId);
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.time;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.snapshot;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.intercomId;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.apartmentId;
        return hashCode4 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "PassRemote(id=" + this.id + ", time=" + this.time + ", snapshot=" + this.snapshot + ", intercomId=" + this.intercomId + ", apartmentId=" + this.apartmentId + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/PassRemote$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/PassRemote;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<PassRemote> serializer() {
            return PassRemote$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PassRemote(int i, String str, Long l, String str2, @SerialName("intercom_id") Integer num, @SerialName("apartment_id") Integer num2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.id = null;
        } else {
            this.id = str;
        }
        if ((i & 2) == 0) {
            this.time = null;
        } else {
            this.time = l;
        }
        if ((i & 4) == 0) {
            this.snapshot = null;
        } else {
            this.snapshot = str2;
        }
        if ((i & 8) == 0) {
            this.intercomId = null;
        } else {
            this.intercomId = num;
        }
        if ((i & 16) == 0) {
            this.apartmentId = null;
        } else {
            this.apartmentId = num2;
        }
    }

    public PassRemote(String str, Long l, String str2, Integer num, Integer num2) {
        this.id = str;
        this.time = l;
        this.snapshot = str2;
        this.intercomId = num;
        this.apartmentId = num2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(PassRemote self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.id != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.id);
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

    public /* synthetic */ PassRemote(String str, Long l, String str2, Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : num2);
    }

    public final String getId() {
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
