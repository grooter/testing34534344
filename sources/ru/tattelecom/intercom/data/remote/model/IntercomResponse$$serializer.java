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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/IntercomResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/IntercomResponse;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class IntercomResponse$$serializer implements GeneratedSerializer<IntercomResponse> {
    public static final IntercomResponse$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        IntercomResponse$$serializer intercomResponse$$serializer = new IntercomResponse$$serializer();
        INSTANCE = intercomResponse$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.IntercomResponse", intercomResponse$$serializer, 18);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, false);
        pluginGeneratedSerialDescriptor.addElement(EntitiesKt.SCHEDULES_TABLE, false);
        pluginGeneratedSerialDescriptor.addElement("building_id", false);
        pluginGeneratedSerialDescriptor.addElement("sip_login", true);
        pluginGeneratedSerialDescriptor.addElement("intercom_name", true);
        pluginGeneratedSerialDescriptor.addElement("gate_id", true);
        pluginGeneratedSerialDescriptor.addElement("gate_name", true);
        pluginGeneratedSerialDescriptor.addElement("gate_type_id", true);
        pluginGeneratedSerialDescriptor.addElement("building_address", true);
        pluginGeneratedSerialDescriptor.addElement("stream_url", true);
        pluginGeneratedSerialDescriptor.addElement("stream_url_mpeg", true);
        pluginGeneratedSerialDescriptor.addElement("jpeg_preview", true);
        pluginGeneratedSerialDescriptor.addElement("mute", false);
        pluginGeneratedSerialDescriptor.addElement("door_code", true);
        pluginGeneratedSerialDescriptor.addElement("door_code_updated_at", true);
        pluginGeneratedSerialDescriptor.addElement("temporary_code", true);
        pluginGeneratedSerialDescriptor.addElement("is_favorite", true);
        pluginGeneratedSerialDescriptor.addElement("is_exit", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IntercomResponse$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = IntercomResponse.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[1]), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public IntercomResponse deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        int i;
        Boolean bool;
        String str2;
        Boolean bool2;
        Integer num;
        Integer num2;
        Integer num3;
        Integer num4;
        String str3;
        Integer num5;
        Integer num6;
        String str4;
        Integer num7;
        String str5;
        List list;
        String str6;
        Integer num8;
        String str7;
        KSerializer[] kSerializerArr2;
        Boolean bool3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = IntercomResponse.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Integer num9 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, null);
            List list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            Integer num10 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            Integer num11 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            Integer num12 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 7, IntSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 12, BooleanSerializer.INSTANCE, null);
            Integer num13 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 13, IntSerializer.INSTANCE, null);
            Integer num14 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 14, IntSerializer.INSTANCE, null);
            Integer num15 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 15, IntSerializer.INSTANCE, null);
            num5 = num11;
            i = 262143;
            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 16, IntSerializer.INSTANCE, null);
            str = str9;
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 17, BooleanSerializer.INSTANCE, null);
            str7 = str14;
            num2 = num15;
            num3 = num14;
            num4 = num13;
            bool = bool4;
            str4 = str11;
            str6 = str8;
            str3 = str12;
            num7 = num12;
            str5 = str10;
            list = list2;
            num6 = num9;
            num8 = num10;
            str2 = str13;
        } else {
            boolean z = true;
            String str15 = null;
            Integer num16 = null;
            String str16 = null;
            Integer num17 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            Integer num18 = null;
            String str20 = null;
            str = null;
            Integer num19 = null;
            Boolean bool5 = null;
            Integer num20 = null;
            Integer num21 = null;
            Integer num22 = null;
            Integer num23 = null;
            List list3 = null;
            i = 0;
            Boolean bool6 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        kSerializerArr = kSerializerArr;
                        num19 = num19;
                    case 0:
                        i |= 1;
                        list3 = list3;
                        kSerializerArr = kSerializerArr;
                        num19 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, num19);
                        bool6 = bool6;
                    case 1:
                        kSerializerArr2 = kSerializerArr;
                        list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr2[1], list3);
                        i |= 2;
                        bool6 = bool6;
                        bool5 = bool5;
                        kSerializerArr = kSerializerArr2;
                    case 2:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        num17 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num17);
                        i |= 4;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 3:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str16);
                        i |= 8;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 4:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str);
                        i |= 16;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 5:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        num16 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num16);
                        i |= 32;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 6:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str20);
                        i |= 64;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 7:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        num18 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 7, IntSerializer.INSTANCE, num18);
                        i |= 128;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 8:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str19);
                        i |= 256;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 9:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str15);
                        i |= 512;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 10:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str18);
                        i |= 1024;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 11:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str17);
                        i |= 2048;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 12:
                        kSerializerArr2 = kSerializerArr;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 12, BooleanSerializer.INSTANCE, bool5);
                        i |= 4096;
                        bool6 = bool6;
                        num20 = num20;
                        kSerializerArr = kSerializerArr2;
                    case 13:
                        kSerializerArr2 = kSerializerArr;
                        num20 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 13, IntSerializer.INSTANCE, num20);
                        i |= 8192;
                        bool6 = bool6;
                        num21 = num21;
                        kSerializerArr = kSerializerArr2;
                    case 14:
                        kSerializerArr2 = kSerializerArr;
                        num21 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 14, IntSerializer.INSTANCE, num21);
                        i |= 16384;
                        bool6 = bool6;
                        num22 = num22;
                        kSerializerArr = kSerializerArr2;
                    case 15:
                        kSerializerArr2 = kSerializerArr;
                        num22 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 15, IntSerializer.INSTANCE, num22);
                        i |= 32768;
                        bool6 = bool6;
                        num23 = num23;
                        kSerializerArr = kSerializerArr2;
                    case 16:
                        kSerializerArr2 = kSerializerArr;
                        bool3 = bool6;
                        num23 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 16, IntSerializer.INSTANCE, num23);
                        i |= 65536;
                        bool6 = bool3;
                        kSerializerArr = kSerializerArr2;
                    case 17:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 17, BooleanSerializer.INSTANCE, bool6);
                        i |= 131072;
                        kSerializerArr = kSerializerArr;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bool = bool5;
            str2 = str18;
            bool2 = bool6;
            num = num23;
            num2 = num22;
            num3 = num21;
            num4 = num20;
            str3 = str15;
            num5 = num16;
            num6 = num19;
            str4 = str19;
            num7 = num18;
            str5 = str20;
            list = list3;
            str6 = str16;
            num8 = num17;
            str7 = str17;
        }
        beginStructure.endStructure(descriptor2);
        return new IntercomResponse(i, num6, list, num8, str6, str, num5, str5, num7, str4, str3, str2, str7, bool, num4, num3, num2, num, bool2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, IntercomResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        IntercomResponse.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
