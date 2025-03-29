package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonPrimitiveSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/AllRemote.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/AllRemote;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class AllRemote$$serializer implements GeneratedSerializer<AllRemote> {
    public static final AllRemote$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        AllRemote$$serializer allRemote$$serializer = new AllRemote$$serializer();
        INSTANCE = allRemote$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.AllRemote", allRemote$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement(CrashHianalyticsData.TIME, true);
        pluginGeneratedSerialDescriptor.addElement("snapshot", true);
        pluginGeneratedSerialDescriptor.addElement("intercom_id", true);
        pluginGeneratedSerialDescriptor.addElement("apartment_id", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AllRemote$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(JsonPrimitiveSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AllRemote deserialize(Decoder decoder) {
        Integer num;
        Integer num2;
        Long l;
        String str;
        JsonPrimitive jsonPrimitive;
        String str2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        JsonPrimitive jsonPrimitive2 = null;
        if (beginStructure.decodeSequentially()) {
            JsonPrimitive jsonPrimitive3 = (JsonPrimitive) beginStructure.decodeNullableSerializableElement(descriptor2, 0, JsonPrimitiveSerializer.INSTANCE, null);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            Long l2 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 2, LongSerializer.INSTANCE, null);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            jsonPrimitive = jsonPrimitive3;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            str = str4;
            num = num3;
            l = l2;
            str2 = str3;
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            String str5 = null;
            Long l3 = null;
            String str6 = null;
            Integer num4 = null;
            Integer num5 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        jsonPrimitive2 = (JsonPrimitive) beginStructure.decodeNullableSerializableElement(descriptor2, 0, JsonPrimitiveSerializer.INSTANCE, jsonPrimitive2);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str5);
                        i3 |= 2;
                    case 2:
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(descriptor2, 2, LongSerializer.INSTANCE, l3);
                        i3 |= 4;
                    case 3:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str6);
                        i3 |= 8;
                    case 4:
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num4);
                        i3 |= 16;
                    case 5:
                        num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, i2, IntSerializer.INSTANCE, num5);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num4;
            num2 = num5;
            l = l3;
            str = str6;
            jsonPrimitive = jsonPrimitive2;
            str2 = str5;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new AllRemote(i, jsonPrimitive, str2, l, str, num, num2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AllRemote value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AllRemote.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
