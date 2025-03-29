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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/ApartmentResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/ApartmentResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class ApartmentResponse$$serializer implements GeneratedSerializer<ApartmentResponse> {
    public static final ApartmentResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ApartmentResponse$$serializer apartmentResponse$$serializer = new ApartmentResponse$$serializer();
        INSTANCE = apartmentResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.ApartmentResponse", apartmentResponse$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, false);
        pluginGeneratedSerialDescriptor.addElement("address", false);
        pluginGeneratedSerialDescriptor.addElement("guests", true);
        pluginGeneratedSerialDescriptor.addElement("services", true);
        pluginGeneratedSerialDescriptor.addElement("remaining_invites", false);
        pluginGeneratedSerialDescriptor.addElement("building_id", false);
        pluginGeneratedSerialDescriptor.addElement("door_code", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ApartmentResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = ApartmentResponse.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ApartmentResponse deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        List list;
        List list2;
        Integer num;
        Integer num2;
        Integer num3;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = ApartmentResponse.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        Integer num4 = null;
        if (beginStructure.decodeSequentially()) {
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, null);
            String str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            List list4 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            Integer num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            Integer num7 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            list2 = list4;
            num4 = num5;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 6, IntSerializer.INSTANCE, null);
            num3 = num7;
            num = num6;
            i = 127;
            list = list3;
            str = str2;
        } else {
            boolean z = true;
            int i4 = 0;
            Integer num8 = null;
            Integer num9 = null;
            str = null;
            list = null;
            list2 = null;
            num = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 5;
                    case 0:
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, num4);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                    case 1:
                        str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str);
                        i4 |= 2;
                        i2 = 6;
                        i3 = 5;
                    case 2:
                        list = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], list);
                        i4 |= 4;
                        i2 = 6;
                    case 3:
                        list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 3, kSerializerArr[3], list2);
                        i4 |= 8;
                    case 4:
                        num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num);
                        i4 |= 16;
                    case 5:
                        num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, i3, IntSerializer.INSTANCE, num9);
                        i4 |= 32;
                    case 6:
                        num8 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, i2, IntSerializer.INSTANCE, num8);
                        i4 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num2 = num8;
            num3 = num9;
            i = i4;
        }
        beginStructure.endStructure(descriptor2);
        return new ApartmentResponse(i, num4, str, list, list2, num, num3, num2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ApartmentResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ApartmentResponse.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
