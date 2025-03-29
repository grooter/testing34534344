package ru.tattelecom.intercom.data.helper;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import ru.tattelecom.intercom.data.local.entity.RemoteLogMessage;

/* compiled from: Extensions.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toJson", "", "Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtensionsKt {
    public static final String toJson(RemoteLogMessage remoteLogMessage) {
        Intrinsics.checkNotNullParameter(remoteLogMessage, "<this>");
        Json.Companion companion = Json.INSTANCE;
        KSerializer<Object> serializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(RemoteLogMessage.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return companion.encodeToString(serializer, remoteLogMessage);
    }
}
