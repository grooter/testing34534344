package ru.tattelecom.intercom.data.local;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* compiled from: IntercomDatabase.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/data/local/IntListConverter;", "", "()V", "fromIntList", "", "data", "", "", "toIntList", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntListConverter {
    public final String fromIntList(List<Integer> data) {
        Json.Companion companion = Json.INSTANCE;
        KSerializer<Object> serializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return companion.encodeToString(serializer, data);
    }

    public final List<Integer> toIntList(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Json.Companion companion = Json.INSTANCE;
        KSerializer<Object> serializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.nullableTypeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE))));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (List) companion.decodeFromString(serializer, data);
    }
}
