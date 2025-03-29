package ru.tattelecom.intercom.data.remote.source;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: AuthRemote.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\tJP\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u001eJ6\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/AuthRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "addApartmentByQRToken", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "apartmentQrToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "auth", "phone", "deviceCode", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQRCode", "Lru/tattelecom/intercom/data/remote/model/QRCodeResponse;", NavArg.VerifyCode.APARTMENT_ID, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerAnotherApartment", FirebaseAnalytics.Event.LOGIN, "sendApplicationInfo", "appVersionName", "appVersionCode", "deviceOsVersion", "deviceApiVersion", "providerName", "deviceName", "connectionType", "batteryLevel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sms", "Lru/tattelecom/intercom/data/remote/model/SmsConfirmResponse;", "code", "deviceOS", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthRemote {
    private final HttpClient client;

    public AuthRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ca A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object auth(java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r11) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AuthRemote.auth(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object registerAnotherApartment(java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.AuthRemote$registerAnotherApartment$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.AuthRemote$registerAnotherApartment$1 r0 = (ru.tattelecom.intercom.data.remote.source.AuthRemote$registerAnotherApartment$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.AuthRemote$registerAnotherApartment$1 r0 = new ru.tattelecom.intercom.data.remote.source.AuthRemote$registerAnotherApartment$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb1
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8e
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "register-another-apartment"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.RegistrationAdditionalApartmentRequest r5 = new ru.tattelecom.intercom.data.remote.model.RegistrationAdditionalApartmentRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.RegistrationAdditionalApartmentRequest> r8 = ru.tattelecom.intercom.data.remote.model.RegistrationAdditionalApartmentRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.RegistrationAdditionalApartmentRequest> r6 = ru.tattelecom.intercom.data.remote.model.RegistrationAdditionalApartmentRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r8)
            r2.setBodyType(r8)
        L77:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L8e
            return r1
        L8e:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r8 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r9 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.nullableTypeOf(r9)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r4 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r9)
            r0.label = r3
            java.lang.Object r9 = r8.bodyNullable(r9, r0)
            if (r9 != r1) goto Lb1
            return r1
        Lb1:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AuthRemote.registerAnotherApartment(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sms(java.lang.String r8, java.lang.String r9, java.lang.Integer r10, java.lang.String r11, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.SmsConfirmResponse> r12) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AuthRemote.sms(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendApplicationInfo(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r25) {
        /*
            r16 = this;
            r0 = r16
            r1 = r25
            boolean r2 = r1 instanceof ru.tattelecom.intercom.data.remote.source.AuthRemote$sendApplicationInfo$1
            if (r2 == 0) goto L18
            r2 = r1
            ru.tattelecom.intercom.data.remote.source.AuthRemote$sendApplicationInfo$1 r2 = (ru.tattelecom.intercom.data.remote.source.AuthRemote$sendApplicationInfo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L1d
        L18:
            ru.tattelecom.intercom.data.remote.source.AuthRemote$sendApplicationInfo$1 r2 = new ru.tattelecom.intercom.data.remote.source.AuthRemote$sendApplicationInfo$1
            r2.<init>(r0, r1)
        L1d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L3f
            if (r4 == r6) goto L3a
            if (r4 != r5) goto L32
            kotlin.ResultKt.throwOnFailure(r1)
            goto Le5
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            kotlin.ResultKt.throwOnFailure(r1)
            goto Lc2
        L3f:
            kotlin.ResultKt.throwOnFailure(r1)
            io.ktor.client.HttpClient r1 = r0.client
            io.ktor.client.request.HttpRequestBuilder r4 = new io.ktor.client.request.HttpRequestBuilder
            r4.<init>()
            java.lang.String r7 = "set-device-version"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r4, r7)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r4)
            ru.tattelecom.intercom.data.remote.model.DeviceInfoRequest r7 = new ru.tattelecom.intercom.data.remote.model.DeviceInfoRequest
            ru.tattelecom.intercom.data.remote.model.DeviceInfoData r11 = new ru.tattelecom.intercom.data.remote.model.DeviceInfoData
            java.text.SimpleDateFormat r8 = new java.text.SimpleDateFormat
            java.util.Locale r9 = new java.util.Locale
            java.lang.String r10 = "ru"
            java.lang.String r12 = "RU"
            r9.<init>(r10, r12)
            java.lang.String r10 = "dd/M/yyyy hh:mm:ss.SSS"
            r8.<init>(r10, r9)
            java.util.Date r9 = new java.util.Date
            r9.<init>()
            java.lang.String r8 = r8.format(r9)
            r9 = r18
            r10 = r20
            r11.<init>(r10, r9, r8)
            r8 = r7
            r9 = r19
            r10 = r17
            r12 = r21
            r13 = r22
            r14 = r23
            r15 = r24
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            boolean r8 = r7 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L91
            r4.setBody(r7)
            r7 = 0
            r4.setBodyType(r7)
            goto Lab
        L91:
            r4.setBody(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeviceInfoRequest> r7 = ru.tattelecom.intercom.data.remote.model.DeviceInfoRequest.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r8 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeviceInfoRequest> r9 = ru.tattelecom.intercom.data.remote.model.DeviceInfoRequest.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r8, r9, r7)
            r4.setBodyType(r7)
        Lab:
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getPost()
            r4.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r4, r1)
            r2.label = r6
            java.lang.Object r1 = r7.execute(r2)
            if (r1 != r3) goto Lc2
            return r3
        Lc2:
            io.ktor.client.statement.HttpResponse r1 = (io.ktor.client.statement.HttpResponse) r1
            io.ktor.client.call.HttpClientCall r1 = r1.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r4 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r4 = kotlin.jvm.internal.Reflection.nullableTypeOf(r4)
            java.lang.reflect.Type r6 = kotlin.reflect.TypesJVMKt.getJavaType(r4)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r7 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            io.ktor.util.reflect.TypeInfo r4 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r6, r7, r4)
            r2.label = r5
            java.lang.Object r1 = r1.bodyNullable(r4, r2)
            if (r1 != r3) goto Le5
            return r3
        Le5:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r1 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AuthRemote.sendApplicationInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getQRCode(int r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.QRCodeResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.AuthRemote$getQRCode$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.AuthRemote$getQRCode$1 r0 = (ru.tattelecom.intercom.data.remote.source.AuthRemote$getQRCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.AuthRemote$getQRCode$1 r0 = new ru.tattelecom.intercom.data.remote.source.AuthRemote$getQRCode$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb1
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8e
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "create-qr-code"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.QRCodeRequest r5 = new ru.tattelecom.intercom.data.remote.model.QRCodeRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.QRCodeRequest> r8 = ru.tattelecom.intercom.data.remote.model.QRCodeRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.QRCodeRequest> r6 = ru.tattelecom.intercom.data.remote.model.QRCodeRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r8)
            r2.setBodyType(r8)
        L77:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L8e
            return r1
        L8e:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r8 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.QRCodeResponse> r9 = ru.tattelecom.intercom.data.remote.model.QRCodeResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.typeOf(r9)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.QRCodeResponse> r4 = ru.tattelecom.intercom.data.remote.model.QRCodeResponse.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r9)
            r0.label = r3
            java.lang.Object r9 = r8.bodyNullable(r9, r0)
            if (r9 != r1) goto Lb1
            return r1
        Lb1:
            if (r9 == 0) goto Lb6
            ru.tattelecom.intercom.data.remote.model.QRCodeResponse r9 = (ru.tattelecom.intercom.data.remote.model.QRCodeResponse) r9
            return r9
        Lb6:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.QRCodeResponse"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AuthRemote.getQRCode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object addApartmentByQRToken(java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.AuthRemote$addApartmentByQRToken$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.AuthRemote$addApartmentByQRToken$1 r0 = (ru.tattelecom.intercom.data.remote.source.AuthRemote$addApartmentByQRToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.AuthRemote$addApartmentByQRToken$1 r0 = new ru.tattelecom.intercom.data.remote.source.AuthRemote$addApartmentByQRToken$1
            r0.<init>(r7, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb1
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8e
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "add-apartment-by-qr-code"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.ApartmentQrTokenRequest r5 = new ru.tattelecom.intercom.data.remote.model.ApartmentQrTokenRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ApartmentQrTokenRequest> r8 = ru.tattelecom.intercom.data.remote.model.ApartmentQrTokenRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ApartmentQrTokenRequest> r6 = ru.tattelecom.intercom.data.remote.model.ApartmentQrTokenRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r8)
            r2.setBodyType(r8)
        L77:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L8e
            return r1
        L8e:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r8 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r9 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.typeOf(r9)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r4 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r9)
            r0.label = r3
            java.lang.Object r9 = r8.bodyNullable(r9, r0)
            if (r9 != r1) goto Lb1
            return r1
        Lb1:
            if (r9 == 0) goto Lb6
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        Lb6:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AuthRemote.addApartmentByQRToken(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
