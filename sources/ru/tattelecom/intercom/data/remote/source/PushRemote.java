package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.domain.workers.SendPushTokenWorker;

/* compiled from: PushRemote.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/PushRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "updatePushToken", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", SendPushTokenWorker.PUSH_SERVICE, "", SendPushTokenWorker.PUSH_TOKEN, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushRemote {
    private final HttpClient client;

    public PushRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updatePushToken(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.PushRemote$updatePushToken$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.PushRemote$updatePushToken$1 r0 = (ru.tattelecom.intercom.data.remote.source.PushRemote$updatePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.PushRemote$updatePushToken$1 r0 = new ru.tattelecom.intercom.data.remote.source.PushRemote$updatePushToken$1
            r0.<init>(r6, r9)
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
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8e
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "update-push-token"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.UpdatePushTokenRequest r5 = new ru.tattelecom.intercom.data.remote.model.UpdatePushTokenRequest
            r5.<init>(r7, r8)
            boolean r7 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r7 == 0) goto L5d
            r2.setBody(r5)
            r7 = 0
            r2.setBodyType(r7)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.UpdatePushTokenRequest> r7 = ru.tattelecom.intercom.data.remote.model.UpdatePushTokenRequest.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r8 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.UpdatePushTokenRequest> r5 = ru.tattelecom.intercom.data.remote.model.UpdatePushTokenRequest.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r8, r5, r7)
            r2.setBodyType(r7)
        L77:
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getPost()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r7.execute(r0)
            if (r9 != r1) goto L8e
            return r1
        L8e:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r7 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r8 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.nullableTypeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r2, r8)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r8, r0)
            if (r9 != r1) goto Lb1
            return r1
        Lb1:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.PushRemote.updatePushToken(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
