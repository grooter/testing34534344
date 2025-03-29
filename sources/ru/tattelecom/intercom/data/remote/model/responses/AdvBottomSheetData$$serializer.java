package ru.tattelecom.intercom.data.remote.model.responses;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.push.constant.RemoteMessageConst;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdvResponses.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class AdvBottomSheetData$$serializer implements GeneratedSerializer<AdvBottomSheetData> {
    public static final AdvBottomSheetData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        AdvBottomSheetData$$serializer advBottomSheetData$$serializer = new AdvBottomSheetData$$serializer();
        INSTANCE = advBottomSheetData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetData", advBottomSheetData$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement(TtmlNode.ATTR_ID, false);
        pluginGeneratedSerialDescriptor.addElement("is_read", false);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.END_DATE, false);
        pluginGeneratedSerialDescriptor.addElement("title", false);
        pluginGeneratedSerialDescriptor.addElement("description", false);
        pluginGeneratedSerialDescriptor.addElement("button_text", false);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("type_data", true);
        pluginGeneratedSerialDescriptor.addElement("title_align", true);
        pluginGeneratedSerialDescriptor.addElement("description_align", true);
        pluginGeneratedSerialDescriptor.addElement("image", true);
        pluginGeneratedSerialDescriptor.addElement(RemoteMessageConst.Notification.ICON, true);
        pluginGeneratedSerialDescriptor.addElement("bottom_data", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdvBottomSheetData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdvBottomSheetTypeData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdvBottomSheetBottomData$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AdvBottomSheetData deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        AdvBottomSheetTypeData advBottomSheetTypeData;
        String str5;
        String str6;
        long j;
        long j2;
        boolean z;
        int i;
        AdvBottomSheetBottomData advBottomSheetBottomData;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 10;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 0);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(descriptor2, 2);
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 3);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 5);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            AdvBottomSheetTypeData advBottomSheetTypeData2 = (AdvBottomSheetTypeData) beginStructure.decodeNullableSerializableElement(descriptor2, 7, AdvBottomSheetTypeData$$serializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            advBottomSheetBottomData = (AdvBottomSheetBottomData) beginStructure.decodeNullableSerializableElement(descriptor2, 12, AdvBottomSheetBottomData$$serializer.INSTANCE, null);
            str = str9;
            str8 = str12;
            str3 = str11;
            advBottomSheetTypeData = advBottomSheetTypeData2;
            str4 = str10;
            str6 = decodeStringElement3;
            str5 = decodeStringElement2;
            z = decodeBooleanElement;
            str2 = decodeStringElement;
            j = decodeLongElement2;
            j2 = decodeLongElement;
            i = 8191;
        } else {
            int i3 = 12;
            int i4 = 0;
            String str13 = null;
            AdvBottomSheetBottomData advBottomSheetBottomData2 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            boolean z2 = true;
            long j3 = 0;
            long j4 = 0;
            String str18 = null;
            AdvBottomSheetTypeData advBottomSheetTypeData3 = null;
            String str19 = null;
            String str20 = null;
            boolean z3 = false;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        i2 = 10;
                        i3 = 12;
                    case 0:
                        j4 = beginStructure.decodeLongElement(descriptor2, 0);
                        i4 |= 1;
                        i2 = 10;
                        i3 = 12;
                    case 1:
                        i4 |= 2;
                        z3 = beginStructure.decodeBooleanElement(descriptor2, 1);
                        i2 = 10;
                        i3 = 12;
                    case 2:
                        j3 = beginStructure.decodeLongElement(descriptor2, 2);
                        i4 |= 4;
                        i2 = 10;
                        i3 = 12;
                    case 3:
                        i4 |= 8;
                        str13 = beginStructure.decodeStringElement(descriptor2, 3);
                        i2 = 10;
                        i3 = 12;
                    case 4:
                        str19 = beginStructure.decodeStringElement(descriptor2, 4);
                        i4 |= 16;
                        i2 = 10;
                        i3 = 12;
                    case 5:
                        str20 = beginStructure.decodeStringElement(descriptor2, 5);
                        i4 |= 32;
                        i2 = 10;
                        i3 = 12;
                    case 6:
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str18);
                        i4 |= 64;
                        i2 = 10;
                        i3 = 12;
                    case 7:
                        advBottomSheetTypeData3 = (AdvBottomSheetTypeData) beginStructure.decodeNullableSerializableElement(descriptor2, 7, AdvBottomSheetTypeData$$serializer.INSTANCE, advBottomSheetTypeData3);
                        i4 |= 128;
                        i2 = 10;
                        i3 = 12;
                    case 8:
                        str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str17);
                        i4 |= 256;
                        i2 = 10;
                        i3 = 12;
                    case 9:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str15);
                        i4 |= 512;
                        i3 = 12;
                    case 10:
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str16);
                        i4 |= 1024;
                        i3 = 12;
                    case 11:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str14);
                        i4 |= 2048;
                        i3 = 12;
                    case 12:
                        advBottomSheetBottomData2 = (AdvBottomSheetBottomData) beginStructure.decodeNullableSerializableElement(descriptor2, i3, AdvBottomSheetBottomData$$serializer.INSTANCE, advBottomSheetBottomData2);
                        i4 |= 4096;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str18;
            str2 = str13;
            str3 = str15;
            str4 = str17;
            advBottomSheetTypeData = advBottomSheetTypeData3;
            str5 = str19;
            str6 = str20;
            j = j3;
            j2 = j4;
            z = z3;
            i = i4;
            advBottomSheetBottomData = advBottomSheetBottomData2;
            str7 = str14;
            str8 = str16;
        }
        beginStructure.endStructure(descriptor2);
        return new AdvBottomSheetData(i, j2, z, j, str2, str5, str6, str, advBottomSheetTypeData, str4, str3, str8, str7, advBottomSheetBottomData, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AdvBottomSheetData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AdvBottomSheetData.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
