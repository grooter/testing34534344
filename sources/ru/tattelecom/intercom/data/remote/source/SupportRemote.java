package ru.tattelecom.intercom.data.remote.source;

import com.huawei.hms.push.AttributionReporter;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SupportRemote.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0007J\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/SupportRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "contactsWithAuth", "Lru/tattelecom/intercom/data/remote/model/responses/TtkPhonesResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPolicy", "Lru/tattelecom/intercom/data/remote/model/responses/PolicyResponse;", "ttkPhones", AttributionReporter.APP_VERSION, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SupportRemote {
    private final HttpClient client;

    public SupportRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0089 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object ttkPhones(java.lang.String r7, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.data.remote.source.SupportRemote$ttkPhones$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.data.remote.source.SupportRemote$ttkPhones$1 r0 = (ru.tattelecom.intercom.data.remote.source.SupportRemote$ttkPhones$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.SupportRemote$ttkPhones$1 r0 = new ru.tattelecom.intercom.data.remote.source.SupportRemote$ttkPhones$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L39
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L8a
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L67
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.HttpClient r8 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "index"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.supportApi(r2, r4, r5)
            java.lang.String r5 = "device_app_version"
            io.ktor.client.request.UtilsKt.parameter(r2, r5, r7)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getGet()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r8)
            r0.label = r3
            java.lang.Object r8 = r7.execute(r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            io.ktor.client.call.HttpClientCall r7 = r8.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse> r8 = ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse> r3 = ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r3, r8)
            r0.label = r4
            java.lang.Object r8 = r7.bodyNullable(r8, r0)
            if (r8 != r1) goto L8a
            return r1
        L8a:
            if (r8 == 0) goto L8f
            ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse r8 = (ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse) r8
            return r8
        L8f:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.SupportRemote.ttkPhones(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object contactsWithAuth(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.SupportRemote$contactsWithAuth$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.SupportRemote$contactsWithAuth$1 r0 = (ru.tattelecom.intercom.data.remote.source.SupportRemote$contactsWithAuth$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.SupportRemote$contactsWithAuth$1 r0 = new ru.tattelecom.intercom.data.remote.source.SupportRemote$contactsWithAuth$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L39
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L85
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.client.HttpClient r7 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "get"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.supportApi(r2, r4, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r5 = r5.getGet()
            r2.setMethod(r5)
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement
            r5.<init>(r2, r7)
            r0.label = r3
            java.lang.Object r7 = r5.execute(r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            io.ktor.client.statement.HttpResponse r7 = (io.ktor.client.statement.HttpResponse) r7
            io.ktor.client.call.HttpClientCall r7 = r7.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse> r2 = ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r2)
            java.lang.reflect.Type r3 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse> r5 = ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r3, r5, r2)
            r0.label = r4
            java.lang.Object r7 = r7.bodyNullable(r2, r0)
            if (r7 != r1) goto L85
            return r1
        L85:
            if (r7 == 0) goto L8a
            ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse r7 = (ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse) r7
            return r7
        L8a:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.responses.TtkPhonesResponse"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.SupportRemote.contactsWithAuth(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getPolicy(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.SupportRemote$getPolicy$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.SupportRemote$getPolicy$1 r0 = (ru.tattelecom.intercom.data.remote.source.SupportRemote$getPolicy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.SupportRemote$getPolicy$1 r0 = new ru.tattelecom.intercom.data.remote.source.SupportRemote$getPolicy$1
            r0.<init>(r6, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L39
            if (r2 == r3) goto L35
            if (r2 != r4) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L85
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L62
        L39:
            kotlin.ResultKt.throwOnFailure(r7)
            io.ktor.client.HttpClient r7 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "policy"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.supportApi(r2, r4, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r5 = r5.getGet()
            r2.setMethod(r5)
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement
            r5.<init>(r2, r7)
            r0.label = r3
            java.lang.Object r7 = r5.execute(r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            io.ktor.client.statement.HttpResponse r7 = (io.ktor.client.statement.HttpResponse) r7
            io.ktor.client.call.HttpClientCall r7 = r7.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse> r2 = ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r2)
            java.lang.reflect.Type r3 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse> r5 = ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r3, r5, r2)
            r0.label = r4
            java.lang.Object r7 = r7.bodyNullable(r2, r0)
            if (r7 != r1) goto L85
            return r1
        L85:
            if (r7 == 0) goto L8a
            ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse r7 = (ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse) r7
            return r7
        L8a:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.SupportRemote.getPolicy(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
