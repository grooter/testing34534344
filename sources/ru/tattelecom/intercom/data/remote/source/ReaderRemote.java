package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReaderRemote.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/ReaderRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getAll", "Lru/tattelecom/intercom/data/remote/model/AvailableReadersResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReaderRemote {
    private final HttpClient client;

    public ReaderRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAll(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.ReaderRemote$getAll$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.ReaderRemote$getAll$1 r0 = (ru.tattelecom.intercom.data.remote.source.ReaderRemote$getAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.ReaderRemote$getAll$1 r0 = new ru.tattelecom.intercom.data.remote.source.ReaderRemote$getAll$1
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
            java.lang.String r5 = "available-readers"
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
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse> r2 = ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse> r5 = ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r7 = r7.bodyNullable(r2, r0)
            if (r7 != r1) goto L82
            return r1
        L82:
            ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse r7 = (ru.tattelecom.intercom.data.remote.model.AvailableReadersResponse) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.ReaderRemote.getAll(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
