package ru.tattelecom.intercom.data.remote.model.requests;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.data.local.entity.RemoteLogMessage;
import ru.tattelecom.intercom.data.local.entity.RemoteLogMessage$$serializer;

/* compiled from: LogRequests.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002+,BI\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J&\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÁ\u0001¢\u0006\u0002\b*R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013¨\u0006-"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/requests/LogRequest;", "", "seen1", "", "message", "Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;", RemoteMessageConst.Notification.TAG, "", "date", "", FirebaseAnalytics.Param.LEVEL, "type", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILru/tattelecom/intercom/data/local/entity/RemoteLogMessage;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getDate", "()J", "getLevel", "()Ljava/lang/String;", "getMessage", "()Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;", "getTag", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class LogRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long date;
    private final String level;
    private final RemoteLogMessage message;
    private final String tag;
    private final String type;

    public static /* synthetic */ LogRequest copy$default(LogRequest logRequest, RemoteLogMessage remoteLogMessage, String str, long j, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            remoteLogMessage = logRequest.message;
        }
        if ((i & 2) != 0) {
            str = logRequest.tag;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            j = logRequest.date;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str2 = logRequest.level;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = logRequest.type;
        }
        return logRequest.copy(remoteLogMessage, str4, j2, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final RemoteLogMessage getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* renamed from: component3, reason: from getter */
    public final long getDate() {
        return this.date;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLevel() {
        return this.level;
    }

    /* renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final LogRequest copy(RemoteLogMessage message, String tag, long date, String level, String type) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(type, "type");
        return new LogRequest(message, tag, date, level, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) other;
        return Intrinsics.areEqual(this.message, logRequest.message) && Intrinsics.areEqual(this.tag, logRequest.tag) && this.date == logRequest.date && Intrinsics.areEqual(this.level, logRequest.level) && Intrinsics.areEqual(this.type, logRequest.type);
    }

    public int hashCode() {
        return (((((((this.message.hashCode() * 31) + this.tag.hashCode()) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.date)) * 31) + this.level.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "LogRequest(message=" + this.message + ", tag=" + this.tag + ", date=" + this.date + ", level=" + this.level + ", type=" + this.type + ")";
    }

    /* compiled from: LogRequests.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/requests/LogRequest$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/requests/LogRequest;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<LogRequest> serializer() {
            return LogRequest$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ LogRequest(int i, RemoteLogMessage remoteLogMessage, String str, long j, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, LogRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.message = remoteLogMessage;
        this.tag = str;
        this.date = j;
        this.level = str2;
        this.type = str3;
    }

    public LogRequest(RemoteLogMessage message, String tag, long j, String level, String type) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(type, "type");
        this.message = message;
        this.tag = tag;
        this.date = j;
        this.level = level;
        this.type = type;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(LogRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, RemoteLogMessage$$serializer.INSTANCE, self.message);
        output.encodeStringElement(serialDesc, 1, self.tag);
        output.encodeLongElement(serialDesc, 2, self.date);
        output.encodeStringElement(serialDesc, 3, self.level);
        output.encodeStringElement(serialDesc, 4, self.type);
    }

    public final RemoteLogMessage getMessage() {
        return this.message;
    }

    public final String getTag() {
        return this.tag;
    }

    public final long getDate() {
        return this.date;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getType() {
        return this.type;
    }
}
