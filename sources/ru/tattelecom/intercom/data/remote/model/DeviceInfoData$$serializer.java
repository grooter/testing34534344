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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Requests.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/remote/model/DeviceInfoData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/remote/model/DeviceInfoData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class DeviceInfoData$$serializer implements GeneratedSerializer<DeviceInfoData> {
    public static final DeviceInfoData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        DeviceInfoData$$serializer deviceInfoData$$serializer = new DeviceInfoData$$serializer();
        INSTANCE = deviceInfoData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.remote.model.DeviceInfoData", deviceInfoData$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("api_version", false);
        pluginGeneratedSerialDescriptor.addElement("app_version_code", false);
        pluginGeneratedSerialDescriptor.addElement("sent_at", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceInfoData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DeviceInfoData deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            str = str5;
            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            str2 = str6;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            String str7 = null;
            String str8 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str4);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str7);
                    i2 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str8);
                    i2 |= 4;
                }
            }
            i = i2;
            str = str4;
            str2 = str7;
            str3 = str8;
        }
        beginStructure.endStructure(descriptor2);
        return new DeviceInfoData(i, str, str2, str3, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DeviceInfoData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceInfoData.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
