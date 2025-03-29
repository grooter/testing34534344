package ru.tattelecom.intercom.data.remote.source;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.KtorConfigKt;

/* compiled from: EventHistoryRemote.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/EventHistoryRemote;", "", "client", "Lio/ktor/client/HttpClient;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "(Lio/ktor/client/HttpClient;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;)V", "getAllLog", "Lio/ktor/client/statement/HttpResponse;", "page", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCallLog", "getCodePassLog", "getImage", "Lru/tattelecom/intercom/data/remote/model/CallImageResponse;", "callId", "getKeyPassLog", "removeCallLogFromEveryone", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "callLogId", "removeCallLogFromUser", "removeCodePassLogFromEveryone", "codePassLogId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeCodePassLogFromUser", "removeKeyLogFromEveryone", "keyLogId", "removeKeyLogFromUser", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryRemote {
    private final HttpClient client;
    private final UserPrefsSource prefs;

    public EventHistoryRemote(HttpClient client, UserPrefsSource prefs) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.client = client;
        this.prefs = prefs;
    }

    public final Object getAllLog(int i, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        KtorConfigKt.allLogApi(httpRequestBuilder, FirebaseAnalytics.Param.INDEX);
        KtorConfigKt.json(httpRequestBuilder);
        UtilsKt.parameter(httpRequestBuilder, "page", Boxing.boxInt(i));
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object getCallLog(int i, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        KtorConfigKt.callLogApi(httpRequestBuilder, FirebaseAnalytics.Param.INDEX);
        KtorConfigKt.json(httpRequestBuilder);
        UtilsKt.parameter(httpRequestBuilder, "page", Boxing.boxInt(i));
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object getKeyPassLog(int i, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        KtorConfigKt.keyPassLogApi(httpRequestBuilder, FirebaseAnalytics.Param.INDEX);
        KtorConfigKt.json(httpRequestBuilder);
        UtilsKt.parameter(httpRequestBuilder, "page", Boxing.boxInt(i));
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    public final Object getCodePassLog(int i, Continuation<? super HttpResponse> continuation) {
        HttpClient httpClient = this.client;
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        KtorConfigKt.codePassLogApi(httpRequestBuilder, FirebaseAnalytics.Param.INDEX);
        KtorConfigKt.json(httpRequestBuilder);
        UtilsKt.parameter(httpRequestBuilder, "page", Boxing.boxInt(i));
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        return new HttpStatement(httpRequestBuilder, httpClient).execute(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00de A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getImage(int r10, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.CallImageResponse> r11) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.getImage(int, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object removeCallLogFromUser(int r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromUser$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromUser$1 r0 = (ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromUser$1 r0 = new ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromUser$1
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
            java.lang.String r5 = "delete-for-user"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.callLogApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest> r8 = ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.removeCallLogFromUser(int, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object removeKeyLogFromUser(java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromUser$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromUser$1 r0 = (ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromUser$1 r0 = new ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromUser$1
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
            java.lang.String r5 = "delete-for-user"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.keyPassLogApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest> r8 = ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.removeKeyLogFromUser(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object removeCodePassLogFromUser(java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromUser$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromUser$1 r0 = (ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromUser$1 r0 = new ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromUser$1
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
            java.lang.String r5 = "delete-for-user"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.codePassLogApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest> r8 = ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.removeCodePassLogFromUser(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object removeCallLogFromEveryone(int r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromEveryone$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromEveryone$1 r0 = (ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromEveryone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromEveryone$1 r0 = new ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCallLogFromEveryone$1
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
            java.lang.String r5 = "delete-for-all-users"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.callLogApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest> r8 = ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteCallLogRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.removeCallLogFromEveryone(int, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object removeKeyLogFromEveryone(java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromEveryone$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromEveryone$1 r0 = (ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromEveryone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromEveryone$1 r0 = new ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeKeyLogFromEveryone$1
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
            java.lang.String r5 = "delete-for-all-users"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.keyPassLogApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest> r8 = ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteKeyLogRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.removeKeyLogFromEveryone(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object removeCodePassLogFromEveryone(java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromEveryone$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromEveryone$1 r0 = (ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromEveryone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromEveryone$1 r0 = new ru.tattelecom.intercom.data.remote.source.EventHistoryRemote$removeCodePassLogFromEveryone$1
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
            java.lang.String r5 = "delete-for-all-users"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.codePassLogApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest
            r5.<init>(r8)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L5d
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest> r8 = ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteCodePassLogRequest.class
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
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.EventHistoryRemote.removeCodePassLogFromEveryone(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
