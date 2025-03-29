package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/OfficeResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class OfficeResponse$$serializer implements GeneratedSerializer<OfficeResponse> {
    public static final OfficeResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        OfficeResponse$$serializer officeResponse$$serializer = new OfficeResponse$$serializer();
        INSTANCE = officeResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.OfficeResponse", officeResponse$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, false);
        pluginGeneratedSerialDescriptor.addElement("address", true);
        pluginGeneratedSerialDescriptor.addElement("latlong", true);
        pluginGeneratedSerialDescriptor.addElement("services", true);
        pluginGeneratedSerialDescriptor.addElement("work_weekday", true);
        pluginGeneratedSerialDescriptor.addElement("work_saturday", true);
        pluginGeneratedSerialDescriptor.addElement("work_sunday", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("contacts", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private OfficeResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = OfficeResponse.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(OfficeLatlong$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(OfficeSchedule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(OfficeSchedule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(OfficeSchedule$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[8])};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public OfficeResponse deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        List list;
        OfficeLatlong officeLatlong;
        String str;
        int i;
        OfficeSchedule officeSchedule;
        Integer num;
        OfficeSchedule officeSchedule2;
        String str2;
        OfficeSchedule officeSchedule3;
        List list2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = OfficeResponse.$childSerializers;
        int i2 = 7;
        int i3 = 8;
        Integer num2 = null;
        if (beginStructure.decodeSequentially()) {
            Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, null);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            OfficeLatlong officeLatlong2 = (OfficeLatlong) beginStructure.decodeNullableSerializableElement(descriptor2, 2, OfficeLatlong$$serializer.INSTANCE, null);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            OfficeSchedule officeSchedule4 = (OfficeSchedule) beginStructure.decodeNullableSerializableElement(descriptor2, 4, OfficeSchedule$$serializer.INSTANCE, null);
            OfficeSchedule officeSchedule5 = (OfficeSchedule) beginStructure.decodeNullableSerializableElement(descriptor2, 5, OfficeSchedule$$serializer.INSTANCE, null);
            OfficeSchedule officeSchedule6 = (OfficeSchedule) beginStructure.decodeNullableSerializableElement(descriptor2, 6, OfficeSchedule$$serializer.INSTANCE, null);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            str = str4;
            officeSchedule2 = officeSchedule6;
            officeSchedule = officeSchedule5;
            officeSchedule3 = officeSchedule4;
            i = 511;
            officeLatlong = officeLatlong2;
            num = num3;
            list2 = list3;
            str2 = str3;
        } else {
            boolean z = true;
            int i4 = 0;
            List list4 = null;
            String str5 = null;
            OfficeSchedule officeSchedule7 = null;
            OfficeSchedule officeSchedule8 = null;
            OfficeSchedule officeSchedule9 = null;
            List list5 = null;
            String str6 = null;
            OfficeLatlong officeLatlong3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 8;
                    case 0:
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, num2);
                        i4 |= 1;
                        i2 = 7;
                        i3 = 8;
                    case 1:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str6);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 8;
                    case 2:
                        officeLatlong3 = (OfficeLatlong) beginStructure.decodeNullableSerializableElement(descriptor2, 2, OfficeLatlong$$serializer.INSTANCE, officeLatlong3);
                        i4 |= 4;
                        i2 = 7;
                        i3 = 8;
                    case 3:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], list5);
                        i4 |= 8;
                        i2 = 7;
                    case 4:
                        officeSchedule9 = (OfficeSchedule) beginStructure.decodeNullableSerializableElement(descriptor2, 4, OfficeSchedule$$serializer.INSTANCE, officeSchedule9);
                        i4 |= 16;
                        i2 = 7;
                    case 5:
                        officeSchedule7 = (OfficeSchedule) beginStructure.decodeNullableSerializableElement(descriptor2, 5, OfficeSchedule$$serializer.INSTANCE, officeSchedule7);
                        i4 |= 32;
                        i2 = 7;
                    case 6:
                        officeSchedule8 = (OfficeSchedule) beginStructure.decodeNullableSerializableElement(descriptor2, 6, OfficeSchedule$$serializer.INSTANCE, officeSchedule8);
                        i4 |= 64;
                        i2 = 7;
                    case 7:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str5);
                        i4 |= 128;
                    case 8:
                        list4 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i3], list4);
                        i4 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list4;
            officeLatlong = officeLatlong3;
            str = str5;
            i = i4;
            Integer num4 = num2;
            officeSchedule = officeSchedule7;
            num = num4;
            String str7 = str6;
            officeSchedule2 = officeSchedule8;
            str2 = str7;
            List list6 = list5;
            officeSchedule3 = officeSchedule9;
            list2 = list6;
        }
        beginStructure.endStructure(descriptor2);
        return new OfficeResponse(i, num, str2, officeLatlong, list2, officeSchedule3, officeSchedule, officeSchedule2, str, list, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, OfficeResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        OfficeResponse.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
