package ru.tattelecom.intercom.data.local.entity;

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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.notifications.PushNotificationArg;

/* compiled from: RemoteLogEntity.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"ru/tattelecom/intercom/data/local/entity/RemoteLogMessage.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lru/tattelecom/intercom/data/local/entity/RemoteLogMessage;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes5.dex */
public final class RemoteLogMessage$$serializer implements GeneratedSerializer<RemoteLogMessage> {
    public static final RemoteLogMessage$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        RemoteLogMessage$$serializer remoteLogMessage$$serializer = new RemoteLogMessage$$serializer();
        INSTANCE = remoteLogMessage$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("ru.tattelecom.intercom.data.local.entity.RemoteLogMessage", remoteLogMessage$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement(PushNotificationArg.CATEGORY, true);
        pluginGeneratedSerialDescriptor.addElement("priority", true);
        pluginGeneratedSerialDescriptor.addElement("original_priority", true);
        pluginGeneratedSerialDescriptor.addElement("notification_title", true);
        pluginGeneratedSerialDescriptor.addElement("notification_body", true);
        pluginGeneratedSerialDescriptor.addElement("data_title", true);
        pluginGeneratedSerialDescriptor.addElement("data_body", true);
        pluginGeneratedSerialDescriptor.addElement("data_url", true);
        pluginGeneratedSerialDescriptor.addElement("sip_uuid", true);
        pluginGeneratedSerialDescriptor.addElement(PushNotificationArg.SIP_ADDRESS, true);
        pluginGeneratedSerialDescriptor.addElement(PushNotificationArg.SIP_PORT, true);
        pluginGeneratedSerialDescriptor.addElement(PushNotificationArg.SIP_TRANSPORT, true);
        pluginGeneratedSerialDescriptor.addElement("sip_registration_state", true);
        pluginGeneratedSerialDescriptor.addElement("sip_registration_message", true);
        pluginGeneratedSerialDescriptor.addElement("device_id", true);
        pluginGeneratedSerialDescriptor.addElement("call_id", true);
        pluginGeneratedSerialDescriptor.addElement("message", true);
        pluginGeneratedSerialDescriptor.addElement("exception", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RemoteLogMessage$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RemoteLogMessage deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        int i;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            String str26 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String str27 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            String str28 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            String str29 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str30 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String str31 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            String str32 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            String str33 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            String str34 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            String str35 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            String str36 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str37 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            String str38 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            String str39 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            String str40 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            String str41 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            String str42 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, null);
            str13 = str31;
            str5 = str42;
            str6 = str41;
            str16 = str40;
            str = str39;
            str12 = str30;
            str9 = str34;
            str17 = str36;
            str8 = str35;
            str10 = str33;
            str7 = str26;
            str14 = str28;
            str18 = str27;
            str19 = str38;
            str2 = str37;
            i = 524287;
            str11 = str32;
            str15 = str29;
        } else {
            boolean z = true;
            String str43 = null;
            String str44 = null;
            String str45 = null;
            String str46 = null;
            String str47 = null;
            String str48 = null;
            String str49 = null;
            String str50 = null;
            String str51 = null;
            String str52 = null;
            String str53 = null;
            String str54 = null;
            String str55 = null;
            String str56 = null;
            String str57 = null;
            String str58 = null;
            String str59 = null;
            String str60 = null;
            int i2 = 0;
            String str61 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        str20 = str61;
                        str21 = str43;
                        str22 = str60;
                        str23 = str46;
                        z = false;
                        str61 = str20;
                        str43 = str21;
                        str46 = str23;
                        str60 = str22;
                    case 0:
                        str20 = str61;
                        str21 = str43;
                        String str62 = str60;
                        str23 = str46;
                        str22 = str62;
                        str54 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str54);
                        i2 |= 1;
                        str61 = str20;
                        str43 = str21;
                        str46 = str23;
                        str60 = str22;
                    case 1:
                        i2 |= 2;
                        str61 = str61;
                        str46 = str46;
                        str60 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str60);
                        str43 = str43;
                    case 2:
                        i2 |= 4;
                        str43 = str43;
                        str46 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str46);
                        str61 = str61;
                    case 3:
                        str24 = str61;
                        str25 = str46;
                        str45 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str45);
                        i2 |= 8;
                        str61 = str24;
                        str46 = str25;
                    case 4:
                        str24 = str61;
                        str25 = str46;
                        str53 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str53);
                        i2 |= 16;
                        str61 = str24;
                        str46 = str25;
                    case 5:
                        str24 = str61;
                        str25 = str46;
                        str43 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str43);
                        i2 |= 32;
                        str61 = str24;
                        str46 = str25;
                    case 6:
                        str24 = str61;
                        str25 = str46;
                        str52 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str52);
                        i2 |= 64;
                        str61 = str24;
                        str46 = str25;
                    case 7:
                        str24 = str61;
                        str25 = str46;
                        str51 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str51);
                        i2 |= 128;
                        str61 = str24;
                        str46 = str25;
                    case 8:
                        str24 = str61;
                        str25 = str46;
                        str50 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str50);
                        i2 |= 256;
                        str61 = str24;
                        str46 = str25;
                    case 9:
                        str24 = str61;
                        str25 = str46;
                        str44 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str44);
                        i2 |= 512;
                        str61 = str24;
                        str46 = str25;
                    case 10:
                        str24 = str61;
                        str25 = str46;
                        str49 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str49);
                        i2 |= 1024;
                        str61 = str24;
                        str46 = str25;
                    case 11:
                        str24 = str61;
                        str25 = str46;
                        str48 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str48);
                        i2 |= 2048;
                        str61 = str24;
                        str46 = str25;
                    case 12:
                        str24 = str61;
                        str25 = str46;
                        str47 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str47);
                        i2 |= 4096;
                        str61 = str24;
                        str46 = str25;
                    case 13:
                        str25 = str46;
                        str55 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str55);
                        i2 |= 8192;
                        str61 = str61;
                        str56 = str56;
                        str46 = str25;
                    case 14:
                        str25 = str46;
                        str56 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str56);
                        i2 |= 16384;
                        str61 = str61;
                        str57 = str57;
                        str46 = str25;
                    case 15:
                        str25 = str46;
                        str57 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str57);
                        i2 |= 32768;
                        str61 = str61;
                        str58 = str58;
                        str46 = str25;
                    case 16:
                        str25 = str46;
                        str58 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, str58);
                        i2 |= 65536;
                        str61 = str61;
                        str59 = str59;
                        str46 = str25;
                    case 17:
                        str25 = str46;
                        str24 = str61;
                        str59 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, str59);
                        i2 |= 131072;
                        str61 = str24;
                        str46 = str25;
                    case 18:
                        str61 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 18, StringSerializer.INSTANCE, str61);
                        i2 |= 262144;
                        str46 = str46;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str63 = str61;
            String str64 = str54;
            str = str55;
            str2 = str48;
            str3 = str63;
            str4 = str59;
            str5 = str58;
            str6 = str57;
            str7 = str64;
            str8 = str44;
            str9 = str50;
            str10 = str51;
            str11 = str52;
            str12 = str53;
            str13 = str43;
            str14 = str46;
            str15 = str45;
            str16 = str56;
            str17 = str49;
            str18 = str60;
            str19 = str47;
            i = i2;
        }
        beginStructure.endStructure(descriptor2);
        return new RemoteLogMessage(i, str7, str18, str14, str15, str12, str13, str11, str10, str9, str8, str17, str2, str19, str, str16, str6, str5, str4, str3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RemoteLogMessage value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        RemoteLogMessage.write$Self$data_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
