package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OfficeMapRemote.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/OfficeMapRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getAll", "", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OfficeMapRemote {
    private final HttpClient client;

    public OfficeMapRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAll(kotlin.coroutines.Continuation<? super java.util.List<ru.tattelecom.intercom.data.remote.model.OfficeResponse>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.data.remote.source.OfficeMapRemote$getAll$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.data.remote.source.OfficeMapRemote$getAll$1 r0 = (ru.tattelecom.intercom.data.remote.source.OfficeMapRemote$getAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.OfficeMapRemote$getAll$1 r0 = new ru.tattelecom.intercom.data.remote.source.OfficeMapRemote$getAll$1
            r0.<init>(r7, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L90
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L61
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.HttpClient r8 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "sales-offices"
            java.lang.String r6 = "index"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.domofonApi(r2, r5, r6)
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r5 = r5.getGet()
            r2.setMethod(r5)
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement
            r5.<init>(r2, r8)
            r0.label = r4
            java.lang.Object r8 = r5.execute(r0)
            if (r8 != r1) goto L61
            return r1
        L61:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            io.ktor.client.call.HttpClientCall r8 = r8.getCall()
            java.lang.Class<java.util.List> r2 = java.util.List.class
            kotlin.reflect.KTypeProjection$Companion r4 = kotlin.reflect.KTypeProjection.INSTANCE
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.OfficeResponse> r5 = ru.tattelecom.intercom.data.remote.model.OfficeResponse.class
            kotlin.reflect.KType r5 = kotlin.jvm.internal.Reflection.typeOf(r5)
            kotlin.reflect.KTypeProjection r4 = r4.invariant(r5)
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2, r4)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<java.util.List> r5 = java.util.List.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r8 = r8.bodyNullable(r2, r0)
            if (r8 != r1) goto L90
            return r1
        L90:
            java.util.List r8 = (java.util.List) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.OfficeMapRemote.getAll(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
