package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/ScheduleResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/ScheduleResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class ScheduleResponse$$serializer implements GeneratedSerializer<ScheduleResponse> {
    public static final ScheduleResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ScheduleResponse$$serializer scheduleResponse$$serializer = new ScheduleResponse$$serializer();
        INSTANCE = scheduleResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.ScheduleResponse", scheduleResponse$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, false);
        pluginGeneratedSerialDescriptor.addElement("monday", false);
        pluginGeneratedSerialDescriptor.addElement("tuesday", false);
        pluginGeneratedSerialDescriptor.addElement("wednesday", false);
        pluginGeneratedSerialDescriptor.addElement("thursday", false);
        pluginGeneratedSerialDescriptor.addElement("friday", false);
        pluginGeneratedSerialDescriptor.addElement("saturday", false);
        pluginGeneratedSerialDescriptor.addElement("sunday", false);
        pluginGeneratedSerialDescriptor.addElement("start_h", false);
        pluginGeneratedSerialDescriptor.addElement("start_m", false);
        pluginGeneratedSerialDescriptor.addElement("finish_h", false);
        pluginGeneratedSerialDescriptor.addElement("finish_m", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ScheduleResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ScheduleResponse deserialize(Decoder decoder) {
        Boolean bool;
        Integer num;
        Integer num2;
        int i;
        Integer num3;
        Integer num4;
        Integer num5;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        Integer num6;
        Integer num7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Integer num8 = null;
        if (beginStructure.decodeSequentially()) {
            Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, null);
            Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Boolean bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            Boolean bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            Boolean bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            Boolean bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, null);
            Boolean bool13 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, null);
            Integer num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 8, IntSerializer.INSTANCE, null);
            Integer num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, null);
            Integer num12 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, null);
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 11, IntSerializer.INSTANCE, null);
            num = num12;
            num5 = num11;
            i = 4095;
            num3 = num10;
            bool2 = bool10;
            bool = bool11;
            bool5 = bool9;
            bool4 = bool12;
            bool7 = bool8;
            bool6 = bool13;
            num4 = num9;
        } else {
            boolean z = true;
            int i2 = 0;
            Integer num13 = null;
            Integer num14 = null;
            Integer num15 = null;
            Boolean bool14 = null;
            Boolean bool15 = null;
            Boolean bool16 = null;
            Integer num16 = null;
            bool = null;
            Boolean bool17 = null;
            Boolean bool18 = null;
            Boolean bool19 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        num6 = num13;
                        z = false;
                        num13 = num6;
                    case 0:
                        num6 = num13;
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, num8);
                        i2 |= 1;
                        num13 = num6;
                    case 1:
                        num7 = num8;
                        bool19 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool19);
                        i2 |= 2;
                        num8 = num7;
                    case 2:
                        num7 = num8;
                        bool18 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool18);
                        i2 |= 4;
                        num8 = num7;
                    case 3:
                        num7 = num8;
                        bool17 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool17);
                        i2 |= 8;
                        num8 = num7;
                    case 4:
                        num7 = num8;
                        bool16 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool16);
                        i2 |= 16;
                        num8 = num7;
                    case 5:
                        num7 = num8;
                        bool = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool);
                        i2 |= 32;
                        num8 = num7;
                    case 6:
                        num7 = num8;
                        bool15 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, bool15);
                        i2 |= 64;
                        num8 = num7;
                    case 7:
                        num7 = num8;
                        bool14 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, bool14);
                        i2 |= 128;
                        num8 = num7;
                    case 8:
                        num7 = num8;
                        num15 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 8, IntSerializer.INSTANCE, num15);
                        i2 |= 256;
                        num8 = num7;
                    case 9:
                        num7 = num8;
                        num16 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, num16);
                        i2 |= 512;
                        num8 = num7;
                    case 10:
                        num7 = num8;
                        num14 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, num14);
                        i2 |= 1024;
                        num8 = num7;
                    case 11:
                        num13 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 11, IntSerializer.INSTANCE, num13);
                        i2 |= 2048;
                        num8 = num8;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num14;
            num2 = num13;
            i = i2;
            Boolean bool20 = bool19;
            num3 = num15;
            num4 = num8;
            num5 = num16;
            bool2 = bool16;
            bool3 = bool17;
            bool4 = bool15;
            bool5 = bool18;
            bool6 = bool14;
            bool7 = bool20;
        }
        beginStructure.endStructure(descriptor2);
        return new ScheduleResponse(i, num4, bool7, bool5, bool3, bool2, bool, bool4, bool6, num3, num5, num, num2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ScheduleResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ScheduleResponse.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
