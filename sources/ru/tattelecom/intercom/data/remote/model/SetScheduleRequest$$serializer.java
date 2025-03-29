package ru.tattelecom.intercom.data.remote.model;

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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/SetScheduleRequest.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/SetScheduleRequest;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class SetScheduleRequest$$serializer implements GeneratedSerializer<SetScheduleRequest> {
    public static final SetScheduleRequest$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        SetScheduleRequest$$serializer setScheduleRequest$$serializer = new SetScheduleRequest$$serializer();
        INSTANCE = setScheduleRequest$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.SetScheduleRequest", setScheduleRequest$$serializer, 14);
        pluginGeneratedSerialDescriptor.addElement("phone", false);
        pluginGeneratedSerialDescriptor.addElement("device_code", false);
        pluginGeneratedSerialDescriptor.addElement("intercom_id", false);
        pluginGeneratedSerialDescriptor.addElement("start_h", false);
        pluginGeneratedSerialDescriptor.addElement("start_m", false);
        pluginGeneratedSerialDescriptor.addElement("finish_h", false);
        pluginGeneratedSerialDescriptor.addElement("finish_m", false);
        pluginGeneratedSerialDescriptor.addElement("monday", false);
        pluginGeneratedSerialDescriptor.addElement("tuesday", false);
        pluginGeneratedSerialDescriptor.addElement("wednesday", false);
        pluginGeneratedSerialDescriptor.addElement("thursday", false);
        pluginGeneratedSerialDescriptor.addElement("friday", false);
        pluginGeneratedSerialDescriptor.addElement("saturday", false);
        pluginGeneratedSerialDescriptor.addElement("sunday", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SetScheduleRequest$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SetScheduleRequest deserialize(Decoder decoder) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str;
        int i2;
        String str2;
        boolean z6;
        int i3;
        boolean z7;
        int i4;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i7 = 11;
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 2);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 3);
            int decodeIntElement3 = beginStructure.decodeIntElement(descriptor2, 4);
            int decodeIntElement4 = beginStructure.decodeIntElement(descriptor2, 5);
            int decodeIntElement5 = beginStructure.decodeIntElement(descriptor2, 6);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 7);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(descriptor2, 8);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(descriptor2, 9);
            boolean decodeBooleanElement4 = beginStructure.decodeBooleanElement(descriptor2, 10);
            i = 16383;
            str2 = str4;
            str = str5;
            i2 = decodeIntElement;
            z4 = beginStructure.decodeBooleanElement(descriptor2, 11);
            z5 = decodeBooleanElement4;
            z6 = decodeBooleanElement3;
            z7 = decodeBooleanElement;
            i5 = decodeIntElement5;
            i6 = decodeIntElement4;
            i3 = decodeIntElement2;
            z = decodeBooleanElement2;
            i4 = decodeIntElement3;
            z2 = beginStructure.decodeBooleanElement(descriptor2, 12);
            z3 = beginStructure.decodeBooleanElement(descriptor2, 13);
        } else {
            int i8 = 13;
            int i9 = 0;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            z = false;
            int i13 = 0;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = true;
            int i14 = 0;
            String str6 = null;
            while (z14) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z14 = false;
                        i7 = 11;
                    case 0:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str3);
                        i14 |= 1;
                        i8 = 13;
                        i7 = 11;
                    case 1:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str6);
                        i14 |= 2;
                        i8 = 13;
                        i7 = 11;
                    case 2:
                        i9 = beginStructure.decodeIntElement(descriptor2, 2);
                        i14 |= 4;
                        i8 = 13;
                    case 3:
                        i12 = beginStructure.decodeIntElement(descriptor2, 3);
                        i14 |= 8;
                    case 4:
                        i13 = beginStructure.decodeIntElement(descriptor2, 4);
                        i14 |= 16;
                    case 5:
                        i11 = beginStructure.decodeIntElement(descriptor2, 5);
                        i14 |= 32;
                    case 6:
                        i10 = beginStructure.decodeIntElement(descriptor2, 6);
                        i14 |= 64;
                    case 7:
                        z11 = beginStructure.decodeBooleanElement(descriptor2, 7);
                        i14 |= 128;
                    case 8:
                        z = beginStructure.decodeBooleanElement(descriptor2, 8);
                        i14 |= 256;
                    case 9:
                        z10 = beginStructure.decodeBooleanElement(descriptor2, 9);
                        i14 |= 512;
                    case 10:
                        z9 = beginStructure.decodeBooleanElement(descriptor2, 10);
                        i14 |= 1024;
                    case 11:
                        z8 = beginStructure.decodeBooleanElement(descriptor2, i7);
                        i14 |= 2048;
                    case 12:
                        z12 = beginStructure.decodeBooleanElement(descriptor2, 12);
                        i14 |= 4096;
                    case 13:
                        z13 = beginStructure.decodeBooleanElement(descriptor2, i8);
                        i14 |= 8192;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i14;
            z2 = z12;
            z3 = z13;
            z4 = z8;
            z5 = z9;
            str = str6;
            i2 = i9;
            str2 = str3;
            int i15 = i13;
            z6 = z10;
            i3 = i12;
            z7 = z11;
            i4 = i15;
            int i16 = i11;
            i5 = i10;
            i6 = i16;
        }
        beginStructure.endStructure(descriptor2);
        return new SetScheduleRequest(i, str2, str, i2, i3, i4, i6, i5, z7, z, z6, z5, z4, z2, z3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SetScheduleRequest value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        SetScheduleRequest.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
