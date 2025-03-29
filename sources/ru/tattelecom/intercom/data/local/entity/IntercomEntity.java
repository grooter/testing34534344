package ru.tattelecom.intercom.data.local.entity;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto$$ExternalSyntheticBackport0;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: Entities.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b>\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0014J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010=\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010/J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010B\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\"J\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0006HÆ\u0003J¼\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010GJ\u0013\u0010H\u001a\u00020\u000e2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\u0003HÖ\u0001J\t\u0010K\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b(\u0010\"\"\u0004\b)\u0010$R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010\u0018R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010\"R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b-\u0010\"R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b.\u0010\"R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00100\u001a\u0004\b\u0013\u0010/R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00100\u001a\u0004\b\u0012\u0010/R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u0010\u001cR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001c¨\u0006L"}, d2 = {"Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "", TtmlNode.ATTR_ID, "", "addressId", FirebaseAnalytics.Event.LOGIN, "", "name", "gateId", "gateName", "gateTypeId", VideoPlayerViewModel.STREAM_URL, "base64Preview", "callsMuted", "", NavArg.INTERCOM_EMERGENCY_CODE, "intercomEmergencyCodeUpdateTime", "intercomTemporaryCode", "isFavorite", "isExit", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAddressId", "()I", "setAddressId", "(I)V", "getBase64Preview", "()Ljava/lang/String;", "setBase64Preview", "(Ljava/lang/String;)V", "getCallsMuted", "()Z", "setCallsMuted", "(Z)V", "getGateId", "()Ljava/lang/Integer;", "setGateId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGateName", "setGateName", "getGateTypeId", "setGateTypeId", "getId", "setId", "getIntercomEmergencyCode", "getIntercomEmergencyCodeUpdateTime", "getIntercomTemporaryCode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogin", "setLogin", "getName", "setName", "getStreamUrl", "setStreamUrl", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "equals", "other", "hashCode", "toString", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class IntercomEntity {
    private int addressId;
    private String base64Preview;
    private boolean callsMuted;
    private Integer gateId;
    private String gateName;
    private Integer gateTypeId;
    private int id;
    private final Integer intercomEmergencyCode;
    private final Integer intercomEmergencyCodeUpdateTime;
    private final Integer intercomTemporaryCode;
    private final Boolean isExit;
    private final Boolean isFavorite;
    private String login;
    private String name;
    private String streamUrl;

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getCallsMuted() {
        return this.callsMuted;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getIntercomEmergencyCode() {
        return this.intercomEmergencyCode;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getIntercomEmergencyCodeUpdateTime() {
        return this.intercomEmergencyCodeUpdateTime;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getIntercomTemporaryCode() {
        return this.intercomTemporaryCode;
    }

    /* renamed from: component14, reason: from getter */
    public final Boolean getIsFavorite() {
        return this.isFavorite;
    }

    /* renamed from: component15, reason: from getter */
    public final Boolean getIsExit() {
        return this.isExit;
    }

    /* renamed from: component2, reason: from getter */
    public final int getAddressId() {
        return this.addressId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLogin() {
        return this.login;
    }

    /* renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getGateId() {
        return this.gateId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getGateName() {
        return this.gateName;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStreamUrl() {
        return this.streamUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getBase64Preview() {
        return this.base64Preview;
    }

    public final IntercomEntity copy(int id, int addressId, String login, String name, Integer gateId, String gateName, Integer gateTypeId, String streamUrl, String base64Preview, boolean callsMuted, Integer intercomEmergencyCode, Integer intercomEmergencyCodeUpdateTime, Integer intercomTemporaryCode, Boolean isFavorite, Boolean isExit) {
        return new IntercomEntity(id, addressId, login, name, gateId, gateName, gateTypeId, streamUrl, base64Preview, callsMuted, intercomEmergencyCode, intercomEmergencyCodeUpdateTime, intercomTemporaryCode, isFavorite, isExit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntercomEntity)) {
            return false;
        }
        IntercomEntity intercomEntity = (IntercomEntity) other;
        return this.id == intercomEntity.id && this.addressId == intercomEntity.addressId && Intrinsics.areEqual(this.login, intercomEntity.login) && Intrinsics.areEqual(this.name, intercomEntity.name) && Intrinsics.areEqual(this.gateId, intercomEntity.gateId) && Intrinsics.areEqual(this.gateName, intercomEntity.gateName) && Intrinsics.areEqual(this.gateTypeId, intercomEntity.gateTypeId) && Intrinsics.areEqual(this.streamUrl, intercomEntity.streamUrl) && Intrinsics.areEqual(this.base64Preview, intercomEntity.base64Preview) && this.callsMuted == intercomEntity.callsMuted && Intrinsics.areEqual(this.intercomEmergencyCode, intercomEntity.intercomEmergencyCode) && Intrinsics.areEqual(this.intercomEmergencyCodeUpdateTime, intercomEntity.intercomEmergencyCodeUpdateTime) && Intrinsics.areEqual(this.intercomTemporaryCode, intercomEntity.intercomTemporaryCode) && Intrinsics.areEqual(this.isFavorite, intercomEntity.isFavorite) && Intrinsics.areEqual(this.isExit, intercomEntity.isExit);
    }

    public int hashCode() {
        int i = ((this.id * 31) + this.addressId) * 31;
        String str = this.login;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.gateId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.gateName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.gateTypeId;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str4 = this.streamUrl;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.base64Preview;
        int hashCode7 = (((hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31) + AdvThemeDto$$ExternalSyntheticBackport0.m(this.callsMuted)) * 31;
        Integer num3 = this.intercomEmergencyCode;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.intercomEmergencyCodeUpdateTime;
        int hashCode9 = (hashCode8 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.intercomTemporaryCode;
        int hashCode10 = (hashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Boolean bool = this.isFavorite;
        int hashCode11 = (hashCode10 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isExit;
        return hashCode11 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public String toString() {
        return "IntercomEntity(id=" + this.id + ", addressId=" + this.addressId + ", login=" + this.login + ", name=" + this.name + ", gateId=" + this.gateId + ", gateName=" + this.gateName + ", gateTypeId=" + this.gateTypeId + ", streamUrl=" + this.streamUrl + ", base64Preview=" + this.base64Preview + ", callsMuted=" + this.callsMuted + ", intercomEmergencyCode=" + this.intercomEmergencyCode + ", intercomEmergencyCodeUpdateTime=" + this.intercomEmergencyCodeUpdateTime + ", intercomTemporaryCode=" + this.intercomTemporaryCode + ", isFavorite=" + this.isFavorite + ", isExit=" + this.isExit + ")";
    }

    public IntercomEntity(int i, int i2, String str, String str2, Integer num, String str3, Integer num2, String str4, String str5, boolean z, Integer num3, Integer num4, Integer num5, Boolean bool, Boolean bool2) {
        this.id = i;
        this.addressId = i2;
        this.login = str;
        this.name = str2;
        this.gateId = num;
        this.gateName = str3;
        this.gateTypeId = num2;
        this.streamUrl = str4;
        this.base64Preview = str5;
        this.callsMuted = z;
        this.intercomEmergencyCode = num3;
        this.intercomEmergencyCodeUpdateTime = num4;
        this.intercomTemporaryCode = num5;
        this.isFavorite = bool;
        this.isExit = bool2;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getAddressId() {
        return this.addressId;
    }

    public final void setAddressId(int i) {
        this.addressId = i;
    }

    public final String getLogin() {
        return this.login;
    }

    public final void setLogin(String str) {
        this.login = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Integer getGateId() {
        return this.gateId;
    }

    public final void setGateId(Integer num) {
        this.gateId = num;
    }

    public final String getGateName() {
        return this.gateName;
    }

    public final void setGateName(String str) {
        this.gateName = str;
    }

    public final Integer getGateTypeId() {
        return this.gateTypeId;
    }

    public final void setGateTypeId(Integer num) {
        this.gateTypeId = num;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final void setStreamUrl(String str) {
        this.streamUrl = str;
    }

    public final String getBase64Preview() {
        return this.base64Preview;
    }

    public final void setBase64Preview(String str) {
        this.base64Preview = str;
    }

    public final boolean getCallsMuted() {
        return this.callsMuted;
    }

    public final void setCallsMuted(boolean z) {
        this.callsMuted = z;
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

    public final Boolean isFavorite() {
        return this.isFavorite;
    }

    public final Boolean isExit() {
        return this.isExit;
    }
}
