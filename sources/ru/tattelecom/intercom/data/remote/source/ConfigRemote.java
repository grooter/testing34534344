package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.text.ttml.TtmlNode;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigRemote.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/ConfigRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getConfig", "Lru/tattelecom/intercom/data/remote/model/responses/ConfigResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTrial", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", TtmlNode.ATTR_ID, "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfigRemote {
    private final HttpClient client;

    public ConfigRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getConfig(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.ConfigRemote$getConfig$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.ConfigRemote$getConfig$1 r0 = (ru.tattelecom.intercom.data.remote.source.ConfigRemote$getConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.ConfigRemote$getConfig$1 r0 = new ru.tattelecom.intercom.data.remote.source.ConfigRemote$getConfig$1
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
            java.lang.String r5 = "get-config"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r5 = r5.getGet()
            r2.setMethod(r5)
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement
            r5.<init>(r2, r7)
            r0.label = r4
            java.lang.Object r7 = r5.execute(r0)
            if (r7 != r1) goto L62
            return r1
        L62:
            io.ktor.client.statement.HttpResponse r7 = (io.ktor.client.statement.HttpResponse) r7
            io.ktor.client.call.HttpClientCall r7 = r7.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse> r2 = ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse> r5 = ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r7 = r7.bodyNullable(r2, r0)
            if (r7 != r1) goto L85
            return r1
        L85:
            ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse r7 = (ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.ConfigRemote.getConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startTrial(int r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.ConfigRemote$startTrial$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.ConfigRemote$startTrial$1 r0 = (ru.tattelecom.intercom.data.remote.source.ConfigRemote$startTrial$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.ConfigRemote$startTrial$1 r0 = new ru.tattelecom.intercom.data.remote.source.ConfigRemote$startTrial$1
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
            java.lang.String r5 = "start"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.trialApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.requests.StartTrialRequest r5 = new ru.tattelecom.intercom.data.remote.model.requests.StartTrialRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.requests.StartTrialRequest> r8 = ru.tattelecom.intercom.data.remote.model.requests.StartTrialRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.requests.StartTrialRequest> r6 = ru.tattelecom.intercom.data.remote.model.requests.StartTrialRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.ConfigRemote.startTrial(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
