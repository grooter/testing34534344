package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: GuestRemote.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0086@¢\u0006\u0002\u0010\u0012J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/GuestRemote;", "", "client", "Lio/ktor/client/HttpClient;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "(Lio/ktor/client/HttpClient;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;)V", "delete", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "phone", "", NavArg.VerifyCode.APARTMENT_ID, "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTemporaryCode", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lru/tattelecom/intercom/data/remote/model/ApartmentsGuestsResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "smsCode", "", "(JLjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSms", "setTemporaryCode", "Lru/tattelecom/intercom/data/remote/model/TemporaryCodeResponse;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuestRemote {
    private final HttpClient client;
    private final UserPrefsSource prefs;

    public GuestRemote(HttpClient client, UserPrefsSource prefs) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.client = client;
        this.prefs = prefs;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAll(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.GuestRemote$getAll$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.GuestRemote$getAll$1 r0 = (ru.tattelecom.intercom.data.remote.source.GuestRemote$getAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.GuestRemote$getAll$1 r0 = new ru.tattelecom.intercom.data.remote.source.GuestRemote$getAll$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L82
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5f
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.client.HttpClient r7 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "get-apartment-guests"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r5 = r5.getGet()
            r2.setMethod(r5)
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement
            r5.<init>(r2, r7)
            r0.label = r4
            java.lang.Object r7 = r5.execute(r0)
            if (r7 != r1) goto L5f
            return r1
        L5f:
            io.ktor.client.statement.HttpResponse r7 = (io.ktor.client.statement.HttpResponse) r7
            io.ktor.client.call.HttpClientCall r7 = r7.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse> r2 = ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse> r5 = ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r7 = r7.bodyNullable(r2, r0)
            if (r7 != r1) goto L82
            return r1
        L82:
            ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse r7 = (ru.tattelecom.intercom.data.remote.model.ApartmentsGuestsResponse) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GuestRemote.getAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0103 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object sendSms(java.lang.String r10, int r11, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r12) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GuestRemote.sendSms(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object register(long r21, java.lang.String r23, int r24, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r25) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GuestRemote.register(long, java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object delete(java.lang.String r9, int r10, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ru.tattelecom.intercom.data.remote.source.GuestRemote$delete$1
            if (r0 == 0) goto L14
            r0 = r11
            ru.tattelecom.intercom.data.remote.source.GuestRemote$delete$1 r0 = (ru.tattelecom.intercom.data.remote.source.GuestRemote$delete$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.GuestRemote$delete$1 r0 = new ru.tattelecom.intercom.data.remote.source.GuestRemote$delete$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r11)
            goto Lc1
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9e
        L3a:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.client.HttpClient r11 = r8.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "delete-guest"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.SendGuestSmsRequest r5 = new ru.tattelecom.intercom.data.remote.model.SendGuestSmsRequest
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = r8.prefs
            java.lang.String r6 = r6.getPhoneNumber()
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r7 = r8.prefs
            java.lang.String r7 = r7.getDeviceId()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            r5.<init>(r6, r7, r9, r10)
            boolean r9 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r9 == 0) goto L6d
            r2.setBody(r5)
            r9 = 0
            r2.setBodyType(r9)
            goto L87
        L6d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SendGuestSmsRequest> r9 = ru.tattelecom.intercom.data.remote.model.SendGuestSmsRequest.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.typeOf(r9)
            java.lang.reflect.Type r10 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SendGuestSmsRequest> r5 = ru.tattelecom.intercom.data.remote.model.SendGuestSmsRequest.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r10, r5, r9)
            r2.setBodyType(r9)
        L87:
            io.ktor.http.HttpMethod$Companion r9 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r9 = r9.getPost()
            r2.setMethod(r9)
            io.ktor.client.statement.HttpStatement r9 = new io.ktor.client.statement.HttpStatement
            r9.<init>(r2, r11)
            r0.label = r4
            java.lang.Object r11 = r9.execute(r0)
            if (r11 != r1) goto L9e
            return r1
        L9e:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11
            io.ktor.client.call.HttpClientCall r9 = r11.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r10 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r10 = kotlin.jvm.internal.Reflection.typeOf(r10)
            java.lang.reflect.Type r11 = kotlin.reflect.TypesJVMKt.getJavaType(r10)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r10 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r11, r2, r10)
            r0.label = r3
            java.lang.Object r11 = r9.bodyNullable(r10, r0)
            if (r11 != r1) goto Lc1
            return r1
        Lc1:
            if (r11 == 0) goto Lc6
            ru.tattelecom.intercom.data.remote.model.StatusResponse r11 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r11
            return r11
        Lc6:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GuestRemote.delete(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setTemporaryCode(int r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.GuestRemote$setTemporaryCode$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.GuestRemote$setTemporaryCode$1 r0 = (ru.tattelecom.intercom.data.remote.source.GuestRemote$setTemporaryCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.GuestRemote$setTemporaryCode$1 r0 = new ru.tattelecom.intercom.data.remote.source.GuestRemote$setTemporaryCode$1
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
            goto Lb7
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L94
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "intercom"
            java.lang.String r6 = "set-temporary-code"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.domofonApi(r2, r5, r6)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest r5 = new ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L63
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L7d
        L63:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest> r8 = ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest> r6 = ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r8)
            r2.setBodyType(r8)
        L7d:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L94
            return r1
        L94:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r8 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse> r9 = ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.nullableTypeOf(r9)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse> r4 = ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r9)
            r0.label = r3
            java.lang.Object r9 = r8.bodyNullable(r9, r0)
            if (r9 != r1) goto Lb7
            return r1
        Lb7:
            ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse r9 = (ru.tattelecom.intercom.data.remote.model.TemporaryCodeResponse) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GuestRemote.setTemporaryCode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object deleteTemporaryCode(int r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.GuestRemote$deleteTemporaryCode$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.GuestRemote$deleteTemporaryCode$1 r0 = (ru.tattelecom.intercom.data.remote.source.GuestRemote$deleteTemporaryCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.GuestRemote$deleteTemporaryCode$1 r0 = new ru.tattelecom.intercom.data.remote.source.GuestRemote$deleteTemporaryCode$1
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
            goto Lb7
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L94
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "intercom"
            java.lang.String r6 = "disable-temporary-code"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.domofonApi(r2, r5, r6)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest r5 = new ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L63
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L7d
        L63:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest> r8 = ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest> r6 = ru.tattelecom.intercom.data.remote.model.SendApartmentIdRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r8)
            r2.setBodyType(r8)
        L7d:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L94
            return r1
        L94:
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
            if (r9 != r1) goto Lb7
            return r1
        Lb7:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GuestRemote.deleteTemporaryCode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
