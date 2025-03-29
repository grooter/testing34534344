package ru.tattelecom.intercom.data.remote.model;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: Responses.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bA\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 e2\u00020\u0001:\u0002deBó\u0001\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cBÛ\u0001\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u001dJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010E\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010M\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u00106J\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010P\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003Jì\u0001\u0010V\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010WJ\u0013\u0010X\u001a\u00020\u00142\b\u0010Y\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\t\u0010[\u001a\u00020\nHÖ\u0001J&\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00002\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bHÁ\u0001¢\u0006\u0002\bcR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010$R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b(\u0010\u001f\u001a\u0004\b)\u0010$R\u001e\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!R \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b,\u0010\u001f\u001a\u0004\b-\u0010$R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b.\u0010$R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b/\u0010\u001f\u001a\u0004\b0\u0010$R \u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b1\u0010\u001f\u001a\u0004\b2\u0010$R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b3\u0010\u001f\u001a\u0004\b4\u0010$R \u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b5\u0010\u001f\u001a\u0004\b\u0019\u00106R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010%\u0012\u0004\b8\u0010\u001f\u001a\u0004\b\u0018\u0010$R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u00107\u0012\u0004\b9\u0010\u001f\u001a\u0004\b\u0013\u00106R\u001e\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001f\u001a\u0004\b;\u0010!R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001f\u001a\u0004\b=\u0010!R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b@\u0010\u001f\u001a\u0004\bA\u0010!R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bB\u0010\u001f\u001a\u0004\bC\u0010!¨\u0006f"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/IntercomResponse;", "", "seen1", "", TtmlNode.ATTR_ID, EntitiesKt.SCHEDULES_TABLE, "", "Lru/tattelecom/intercom/data/remote/model/ScheduleResponse;", "addressId", FirebaseAnalytics.Event.LOGIN, "", "name", "gateId", "gateName", "gateTypeId", "address", VideoPlayerViewModel.STREAM_URL, "streamUrlMpeg", "base64Preview", "isMuted", "", NavArg.INTERCOM_EMERGENCY_CODE, "intercomEmergencyCodeUpdateTime", "intercomTemporaryCode", "isFavorite", "isExit", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getAddress$annotations", "()V", "getAddress", "()Ljava/lang/String;", "getAddressId$annotations", "getAddressId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBase64Preview$annotations", "getBase64Preview", "getGateId$annotations", "getGateId", "getGateName$annotations", "getGateName", "getGateTypeId$annotations", "getGateTypeId", "getId", "getIntercomEmergencyCode$annotations", "getIntercomEmergencyCode", "getIntercomEmergencyCodeUpdateTime$annotations", "getIntercomEmergencyCodeUpdateTime", "getIntercomTemporaryCode$annotations", "getIntercomTemporaryCode", "isExit$annotations", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isFavorite$annotations", "isMuted$annotations", "getLogin$annotations", "getLogin", "getName$annotations", "getName", "getSchedules", "()Ljava/util/List;", "getStreamUrl$annotations", "getStreamUrl", "getStreamUrlMpeg$annotations", "getStreamUrlMpeg", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/remote/model/IntercomResponse;", "equals", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$data_release", "$serializer", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes5.dex */
public final /* data */ class IntercomResponse {
    private final String address;
    private final Integer addressId;
    private final String base64Preview;
    private final Integer gateId;
    private final String gateName;
    private final Integer gateTypeId;
    private final Integer id;
    private final Integer intercomEmergencyCode;
    private final Integer intercomEmergencyCodeUpdateTime;
    private final Integer intercomTemporaryCode;
    private final Boolean isExit;
    private final Integer isFavorite;
    private final Boolean isMuted;
    private final String login;
    private final String name;
    private final List<ScheduleResponse> schedules;
    private final String streamUrl;
    private final String streamUrlMpeg;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, new ArrayListSerializer(ScheduleResponse$$serializer.INSTANCE), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    @SerialName("building_address")
    public static /* synthetic */ void getAddress$annotations() {
    }

    @SerialName("building_id")
    public static /* synthetic */ void getAddressId$annotations() {
    }

    @SerialName("jpeg_preview")
    public static /* synthetic */ void getBase64Preview$annotations() {
    }

    @SerialName("gate_id")
    public static /* synthetic */ void getGateId$annotations() {
    }

    @SerialName("gate_name")
    public static /* synthetic */ void getGateName$annotations() {
    }

    @SerialName("gate_type_id")
    public static /* synthetic */ void getGateTypeId$annotations() {
    }

    @SerialName("door_code")
    public static /* synthetic */ void getIntercomEmergencyCode$annotations() {
    }

    @SerialName("door_code_updated_at")
    public static /* synthetic */ void getIntercomEmergencyCodeUpdateTime$annotations() {
    }

    @SerialName("temporary_code")
    public static /* synthetic */ void getIntercomTemporaryCode$annotations() {
    }

    @SerialName("sip_login")
    public static /* synthetic */ void getLogin$annotations() {
    }

    @SerialName("intercom_name")
    public static /* synthetic */ void getName$annotations() {
    }

    @SerialName("stream_url")
    public static /* synthetic */ void getStreamUrl$annotations() {
    }

    @SerialName("stream_url_mpeg")
    public static /* synthetic */ void getStreamUrlMpeg$annotations() {
    }

    @SerialName("is_exit")
    public static /* synthetic */ void isExit$annotations() {
    }

    @SerialName("is_favorite")
    public static /* synthetic */ void isFavorite$annotations() {
    }

    @SerialName("mute")
    public static /* synthetic */ void isMuted$annotations() {
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final String getStreamUrlMpeg() {
        return this.streamUrlMpeg;
    }

    /* renamed from: component12, reason: from getter */
    public final String getBase64Preview() {
        return this.base64Preview;
    }

    /* renamed from: component13, reason: from getter */
    public final Boolean getIsMuted() {
        return this.isMuted;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getIntercomEmergencyCode() {
        return this.intercomEmergencyCode;
    }

    /* renamed from: component15, reason: from getter */
    public final Integer getIntercomEmergencyCodeUpdateTime() {
        return this.intercomEmergencyCodeUpdateTime;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }

    /* renamed from: component17, reason: from getter */
    public final Integer getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component18, reason: from getter */
    public final Boolean getIsExit() {
        return this.isExit;
    }

    public final List<ScheduleResponse> component2() {
        return this.schedules;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getAddressId() {
        return this.addressId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getGateId() {
        return this.gateId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getGateName() {
        return this.gateName;
    }

    /* renamed from: component8, reason: from getter */
    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    public final IntercomResponse copy(Integer id, List<ScheduleResponse> schedules, Integer addressId, String login, String name, Integer gateId, String gateName, Integer gateTypeId, String address, String streamUrl, String streamUrlMpeg, String base64Preview, Boolean isMuted, Integer intercomEmergencyCode, Integer intercomEmergencyCodeUpdateTime, Integer intercomTemporaryCode, Integer isFavorite, Boolean isExit) {
        return new IntercomResponse(id, schedules, addressId, login, name, gateId, gateName, gateTypeId, address, streamUrl, streamUrlMpeg, base64Preview, isMuted, intercomEmergencyCode, intercomEmergencyCodeUpdateTime, intercomTemporaryCode, isFavorite, isExit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntercomResponse)) {
            return false;
        }
        IntercomResponse intercomResponse = (IntercomResponse) other;
        return Intrinsics.areEqual(this.id, intercomResponse.id) && Intrinsics.areEqual(this.schedules, intercomResponse.schedules) && Intrinsics.areEqual(this.addressId, intercomResponse.addressId) && Intrinsics.areEqual(this.login, intercomResponse.login) && Intrinsics.areEqual(this.name, intercomResponse.name) && Intrinsics.areEqual(this.gateId, intercomResponse.gateId) && Intrinsics.areEqual(this.gateName, intercomResponse.gateName) && Intrinsics.areEqual(this.gateTypeId, intercomResponse.gateTypeId) && Intrinsics.areEqual(this.address, intercomResponse.address) && Intrinsics.areEqual(this.streamUrl, intercomResponse.streamUrl) && Intrinsics.areEqual(this.streamUrlMpeg, intercomResponse.streamUrlMpeg) && Intrinsics.areEqual(this.base64Preview, intercomResponse.base64Preview) && Intrinsics.areEqual(this.isMuted, intercomResponse.isMuted) && Intrinsics.areEqual(this.intercomEmergencyCode, intercomResponse.intercomEmergencyCode) && Intrinsics.areEqual(this.intercomEmergencyCodeUpdateTime, intercomResponse.intercomEmergencyCodeUpdateTime) && Intrinsics.areEqual(this.intercomTemporaryCode, intercomResponse.intercomTemporaryCode) && Intrinsics.areEqual(this.isFavorite, intercomResponse.isFavorite) && Intrinsics.areEqual(this.isExit, intercomResponse.isExit);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<ScheduleResponse> list = this.schedules;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.addressId;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.login;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.gateId;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.gateName;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num4 = this.gateTypeId;
        int hashCode8 = (hashCode7 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str4 = this.address;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.streamUrl;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.streamUrlMpeg;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.base64Preview;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.isMuted;
        int hashCode13 = (hashCode12 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num5 = this.intercomEmergencyCode;
        int hashCode14 = (hashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.intercomEmergencyCodeUpdateTime;
        int hashCode15 = (hashCode14 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.intercomTemporaryCode;
        int hashCode16 = (hashCode15 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.isFavorite;
        int hashCode17 = (hashCode16 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Boolean bool2 = this.isExit;
        return hashCode17 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "IntercomResponse(id=" + this.id + ", schedules=" + this.schedules + ", addressId=" + this.addressId + ", login=" + this.login + ", name=" + this.name + ", gateId=" + this.gateId + ", gateName=" + this.gateName + ", gateTypeId=" + this.gateTypeId + ", address=" + this.address + ", streamUrl=" + this.streamUrl + ", streamUrlMpeg=" + this.streamUrlMpeg + ", base64Preview=" + this.base64Preview + ", isMuted=" + this.isMuted + ", intercomEmergencyCode=" + this.intercomEmergencyCode + ", intercomEmergencyCodeUpdateTime=" + this.intercomEmergencyCodeUpdateTime + ", intercomTemporaryCode=" + this.intercomTemporaryCode + ", isFavorite=" + this.isFavorite + ", isExit=" + this.isExit + ")";
    }

    /* compiled from: Responses.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/data/remote/model/IntercomResponse$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lru/tattelecom/intercom/data/remote/model/IntercomResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<IntercomResponse> serializer() {
            return IntercomResponse$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ IntercomResponse(int i, Integer num, List list, @SerialName("building_id") Integer num2, @SerialName("sip_login") String str, @SerialName("intercom_name") String str2, @SerialName("gate_id") Integer num3, @SerialName("gate_name") String str3, @SerialName("gate_type_id") Integer num4, @SerialName("building_address") String str4, @SerialName("stream_url") String str5, @SerialName("stream_url_mpeg") String str6, @SerialName("jpeg_preview") String str7, @SerialName("mute") Boolean bool, @SerialName("door_code") Integer num5, @SerialName("door_code_updated_at") Integer num6, @SerialName("temporary_code") Integer num7, @SerialName("is_favorite") Integer num8, @SerialName("is_exit") Boolean bool2, SerializationConstructorMarker serializationConstructorMarker) {
        if (4103 != (i & 4103)) {
            PluginExceptionsKt.throwMissingFieldException(i, 4103, IntercomResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.id = num;
        this.schedules = list;
        this.addressId = num2;
        if ((i & 8) == 0) {
            this.login = null;
        } else {
            this.login = str;
        }
        if ((i & 16) == 0) {
            this.name = null;
        } else {
            this.name = str2;
        }
        if ((i & 32) == 0) {
            this.gateId = null;
        } else {
            this.gateId = num3;
        }
        if ((i & 64) == 0) {
            this.gateName = null;
        } else {
            this.gateName = str3;
        }
        if ((i & 128) == 0) {
            this.gateTypeId = null;
        } else {
            this.gateTypeId = num4;
        }
        if ((i & 256) == 0) {
            this.address = null;
        } else {
            this.address = str4;
        }
        if ((i & 512) == 0) {
            this.streamUrl = null;
        } else {
            this.streamUrl = str5;
        }
        if ((i & 1024) == 0) {
            this.streamUrlMpeg = null;
        } else {
            this.streamUrlMpeg = str6;
        }
        if ((i & 2048) == 0) {
            this.base64Preview = null;
        } else {
            this.base64Preview = str7;
        }
        this.isMuted = bool;
        if ((i & 8192) == 0) {
            this.intercomEmergencyCode = null;
        } else {
            this.intercomEmergencyCode = num5;
        }
        if ((i & 16384) == 0) {
            this.intercomEmergencyCodeUpdateTime = null;
        } else {
            this.intercomEmergencyCodeUpdateTime = num6;
        }
        if ((32768 & i) == 0) {
            this.intercomTemporaryCode = null;
        } else {
            this.intercomTemporaryCode = num7;
        }
        if ((65536 & i) == 0) {
            this.isFavorite = null;
        } else {
            this.isFavorite = num8;
        }
        if ((i & 131072) == 0) {
            this.isExit = null;
        } else {
            this.isExit = bool2;
        }
    }

    public IntercomResponse(Integer num, List<ScheduleResponse> list, Integer num2, String str, String str2, Integer num3, String str3, Integer num4, String str4, String str5, String str6, String str7, Boolean bool, Integer num5, Integer num6, Integer num7, Integer num8, Boolean bool2) {
        this.id = num;
        this.schedules = list;
        this.addressId = num2;
        this.login = str;
        this.name = str2;
        this.gateId = num3;
        this.gateName = str3;
        this.gateTypeId = num4;
        this.address = str4;
        this.streamUrl = str5;
        this.streamUrlMpeg = str6;
        this.base64Preview = str7;
        this.isMuted = bool;
        this.intercomEmergencyCode = num5;
        this.intercomEmergencyCodeUpdateTime = num6;
        this.intercomTemporaryCode = num7;
        this.isFavorite = num8;
        this.isExit = bool2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$data_release(IntercomResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, kSerializerArr[1], self.schedules);
        output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.addressId);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.login != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.login);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.name != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.name);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.gateId != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, IntSerializer.INSTANCE, self.gateId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.gateName != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.gateName);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.gateTypeId != null) {
            output.encodeNullableSerializableElement(serialDesc, 7, IntSerializer.INSTANCE, self.gateTypeId);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.address != null) {
            output.encodeNullableSerializableElement(serialDesc, 8, StringSerializer.INSTANCE, self.address);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || self.streamUrl != null) {
            output.encodeNullableSerializableElement(serialDesc, 9, StringSerializer.INSTANCE, self.streamUrl);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 10) || self.streamUrlMpeg != null) {
            output.encodeNullableSerializableElement(serialDesc, 10, StringSerializer.INSTANCE, self.streamUrlMpeg);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 11) || self.base64Preview != null) {
            output.encodeNullableSerializableElement(serialDesc, 11, StringSerializer.INSTANCE, self.base64Preview);
        }
        output.encodeNullableSerializableElement(serialDesc, 12, BooleanSerializer.INSTANCE, self.isMuted);
        if (output.shouldEncodeElementDefault(serialDesc, 13) || self.intercomEmergencyCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 13, IntSerializer.INSTANCE, self.intercomEmergencyCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 14) || self.intercomEmergencyCodeUpdateTime != null) {
            output.encodeNullableSerializableElement(serialDesc, 14, IntSerializer.INSTANCE, self.intercomEmergencyCodeUpdateTime);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 15) || self.intercomTemporaryCode != null) {
            output.encodeNullableSerializableElement(serialDesc, 15, IntSerializer.INSTANCE, self.intercomTemporaryCode);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 16) || self.isFavorite != null) {
            output.encodeNullableSerializableElement(serialDesc, 16, IntSerializer.INSTANCE, self.isFavorite);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 17) && self.isExit == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 17, BooleanSerializer.INSTANCE, self.isExit);
    }

    public /* synthetic */ IntercomResponse(Integer num, List list, Integer num2, String str, String str2, Integer num3, String str3, Integer num4, String str4, String str5, String str6, String str7, Boolean bool, Integer num5, Integer num6, Integer num7, Integer num8, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, list, num2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : num3, (i & 64) != 0 ? null : str3, (i & 128) != 0 ? null : num4, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, bool, (i & 8192) != 0 ? null : num5, (i & 16384) != 0 ? null : num6, (32768 & i) != 0 ? null : num7, (65536 & i) != 0 ? null : num8, (i & 131072) != 0 ? null : bool2);
    }

    public final Integer getId() {
        return this.id;
    }

    public final List<ScheduleResponse> getSchedules() {
        return this.schedules;
    }

    public final Integer getAddressId() {
        return this.addressId;
    }

    public final String getLogin() {
        return this.login;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getGateId() {
        return this.gateId;
    }

    public final String getGateName() {
        return this.gateName;
    }

    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final String getStreamUrlMpeg() {
        return this.streamUrlMpeg;
    }

    public final String getBase64Preview() {
        return this.base64Preview;
    }

    public final Boolean isMuted() {
        return this.isMuted;
    }

    public final Integer getIntercomEmergencyCode() {
        return this.intercomEmergencyCode;
    }

    public final Integer getIntercomEmergencyCodeUpdateTime() {
        return this.intercomEmergencyCodeUpdateTime;
    }

    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }

    public final Integer isFavorite() {
        return this.isFavorite;
    }

    public final Boolean isExit() {
        return this.isExit;
    }
}
