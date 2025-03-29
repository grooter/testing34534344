package ru.tattelecom.intercom.data.local.entity;

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
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/local/entity/ScheduleEntity.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/local/entity/ScheduleEntity;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class ScheduleEntity$$serializer implements GeneratedSerializer<ScheduleEntity> {
    public static final ScheduleEntity$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ScheduleEntity$$serializer scheduleEntity$$serializer = new ScheduleEntity$$serializer();
        INSTANCE = scheduleEntity$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.local.entity.ScheduleEntity", scheduleEntity$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, false);
        pluginGeneratedSerialDescriptor.addElement(NavArg.INTERCOM_ID, false);
        pluginGeneratedSerialDescriptor.addElement("startHour", false);
        pluginGeneratedSerialDescriptor.addElement("startMinute", false);
        pluginGeneratedSerialDescriptor.addElement("finishHour", false);
        pluginGeneratedSerialDescriptor.addElement("finishMinute", false);
        pluginGeneratedSerialDescriptor.addElement("monday", false);
        pluginGeneratedSerialDescriptor.addElement("tuesday", false);
        pluginGeneratedSerialDescriptor.addElement("wednesday", false);
        pluginGeneratedSerialDescriptor.addElement("thursday", false);
        pluginGeneratedSerialDescriptor.addElement("friday", false);
        pluginGeneratedSerialDescriptor.addElement("saturday", false);
        pluginGeneratedSerialDescriptor.addElement("sunday", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ScheduleEntity$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ScheduleEntity deserialize(Decoder decoder) {
        boolean z;
        Integer num;
        int i;
        Integer num2;
        boolean z2;
        int i2;
        int i3;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Integer num3;
        Integer num4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 1);
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, null);
            Integer num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            Integer num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 6);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(descriptor2, 7);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(descriptor2, 8);
            boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(descriptor2, 9);
            boolean decodeBooleanElement5 = beginStructure.decodeBooleanElement(descriptor2, 10);
            num = num8;
            z3 = beginStructure.decodeBooleanElement(descriptor2, 11);
            z5 = decodeBooleanElement5;
            z = decodeBooleanElement4;
            z4 = decodeBooleanElement2;
            z2 = decodeBooleanElement;
            z6 = decodeBooleanElement3;
            z7 = beginStructure.decodeBooleanElement(descriptor2, 12);
            num2 = num7;
            i = 8191;
            i3 = decodeIntElement;
            num3 = num6;
            num4 = num5;
            i2 = decodeIntElement2;
        } else {
            int i4 = 12;
            Integer num9 = null;
            Integer num10 = null;
            boolean z8 = true;
            int i5 = 0;
            boolean z9 = false;
            boolean z10 = false;
            z = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = false;
            int i6 = 0;
            Integer num11 = null;
            int i7 = 0;
            Integer num12 = null;
            while (z8) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z8 = false;
                    case 0:
                        i5 |= 1;
                        i7 = beginStructure.decodeIntElement(descriptor2, 0);
                        i4 = 12;
                    case 1:
                        i6 = beginStructure.decodeIntElement(descriptor2, 1);
                        i5 |= 2;
                        i4 = 12;
                    case 2:
                        num12 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num12);
                        i5 |= 4;
                        i4 = 12;
                    case 3:
                        num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, num11);
                        i5 |= 8;
                        i4 = 12;
                    case 4:
                        num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num10);
                        i5 |= 16;
                        i4 = 12;
                    case 5:
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num9);
                        i5 |= 32;
                        i4 = 12;
                    case 6:
                        z12 = beginStructure.decodeBooleanElement(descriptor2, 6);
                        i5 |= 64;
                    case 7:
                        z11 = beginStructure.decodeBooleanElement(descriptor2, 7);
                        i5 |= 128;
                    case 8:
                        z13 = beginStructure.decodeBooleanElement(descriptor2, 8);
                        i5 |= 256;
                    case 9:
                        z = beginStructure.decodeBooleanElement(descriptor2, 9);
                        i5 |= 512;
                    case 10:
                        z10 = beginStructure.decodeBooleanElement(descriptor2, 10);
                        i5 |= 1024;
                    case 11:
                        z9 = beginStructure.decodeBooleanElement(descriptor2, 11);
                        i5 |= 2048;
                    case 12:
                        z14 = beginStructure.decodeBooleanElement(descriptor2, i4);
                        i5 |= 4096;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num9;
            i = i5;
            num2 = num10;
            z2 = z12;
            i2 = i6;
            i3 = i7;
            z3 = z9;
            z4 = z11;
            z5 = z10;
            z6 = z13;
            z7 = z14;
            Integer num13 = num12;
            num3 = num11;
            num4 = num13;
        }
        beginStructure.endStructure(descriptor2);
        return new ScheduleEntity(i, i3, i2, num4, num3, num2, num, z2, z4, z6, z, z5, z3, z7, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ScheduleEntity value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ScheduleEntity.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
