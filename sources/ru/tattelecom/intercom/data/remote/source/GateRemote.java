package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.text.ttml.TtmlNode;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GateRemote.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086@¢\u0006\u0002\u0010\u000eJ \u0010\u000f\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/GateRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getTimelineEvents", "Lru/tattelecom/intercom/data/remote/model/responses/PlayerGateEventsResponse;", "gateId", "", "date", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", TtmlNode.TEXT_EMPHASIS_MARK_OPEN, "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFavorite", "isFavorite", "", "(Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GateRemote {
    private final HttpClient client;

    public GateRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object open(java.lang.Integer r10, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r11) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GateRemote.open(java.lang.Integer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setFavorite(java.lang.Integer r7, boolean r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.GateRemote$setFavorite$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.GateRemote$setFavorite$1 r0 = (ru.tattelecom.intercom.data.remote.source.GateRemote$setFavorite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.GateRemote$setFavorite$1 r0 = new ru.tattelecom.intercom.data.remote.source.GateRemote$setFavorite$1
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
            goto Lb5
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L92
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "set-favorite-gate"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.FavoriteGateRequest r5 = new ru.tattelecom.intercom.data.remote.model.FavoriteGateRequest
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            r5.<init>(r7, r8)
            boolean r7 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r7 == 0) goto L61
            r2.setBody(r5)
            r7 = 0
            r2.setBodyType(r7)
            goto L7b
        L61:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.FavoriteGateRequest> r7 = ru.tattelecom.intercom.data.remote.model.FavoriteGateRequest.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r8 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.FavoriteGateRequest> r5 = ru.tattelecom.intercom.data.remote.model.FavoriteGateRequest.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r8, r5, r7)
            r2.setBodyType(r7)
        L7b:
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getPost()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r7.execute(r0)
            if (r9 != r1) goto L92
            return r1
        L92:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r7 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r8 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r2, r8)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r8, r0)
            if (r9 != r1) goto Lb5
            return r1
        Lb5:
            if (r9 == 0) goto Lba
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        Lba:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GateRemote.setFavorite(java.lang.Integer, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getTimelineEvents(int r8, java.lang.String r9, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ru.tattelecom.intercom.data.remote.source.GateRemote$getTimelineEvents$1
            if (r0 == 0) goto L14
            r0 = r10
            ru.tattelecom.intercom.data.remote.source.GateRemote$getTimelineEvents$1 r0 = (ru.tattelecom.intercom.data.remote.source.GateRemote$getTimelineEvents$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.GateRemote$getTimelineEvents$1 r0 = new ru.tattelecom.intercom.data.remote.source.GateRemote$getTimelineEvents$1
            r0.<init>(r7, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r10)
            goto L95
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L72
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.HttpClient r10 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "timeline"
            java.lang.String r6 = "events"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.domofonApi(r2, r5, r6)
            java.lang.String r5 = "gate_id"
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            io.ktor.client.request.UtilsKt.parameter(r2, r5, r8)
            java.lang.String r8 = "date"
            io.ktor.client.request.UtilsKt.parameter(r2, r8, r9)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getGet()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r10)
            r0.label = r4
            java.lang.Object r10 = r8.execute(r0)
            if (r10 != r1) goto L72
            return r1
        L72:
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            io.ktor.client.call.HttpClientCall r8 = r10.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse> r9 = ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.nullableTypeOf(r9)
            java.lang.reflect.Type r10 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse> r2 = ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r10, r2, r9)
            r0.label = r3
            java.lang.Object r10 = r8.bodyNullable(r9, r0)
            if (r10 != r1) goto L95
            return r1
        L95:
            ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse r10 = (ru.tattelecom.intercom.data.remote.model.responses.PlayerGateEventsResponse) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.GateRemote.getTimelineEvents(int, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
