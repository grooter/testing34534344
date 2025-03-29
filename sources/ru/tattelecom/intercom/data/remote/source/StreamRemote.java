package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import io.ktor.client.request.BuildersWithUrlKt;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpStatement;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.remote.ExternalKtorConfig;

/* compiled from: StreamRemote.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u001a2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\u001cJ\"\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lru/tattelecom/intercom/data/remote/source/StreamRemote;", "", "client", "Lio/ktor/client/HttpClient;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "externalKtorConfig", "Lru/tattelecom/intercom/data/remote/ExternalKtorConfig;", "(Lio/ktor/client/HttpClient;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lru/tattelecom/intercom/data/remote/ExternalKtorConfig;)V", "archiveDownloadStart", "Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStartResponse;", "source", "", "type", "startTime", "duration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lru/tattelecom/intercom/data/remote/model/AvailableStreamsResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArchive", "Lru/tattelecom/intercom/data/remote/model/ArchiveStreamResponse;", "isFlussonic", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArchiveDownloadStatus", "Lru/tattelecom/intercom/data/remote/model/ArchiveDownloadStatusResponse;", "location", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLive", "Lru/tattelecom/intercom/data/remote/model/StreamLiveResponse;", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keepAliveAxxon", "", "keepAliveUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFavorite", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "stream", "isFavorite", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StreamRemote {
    private final HttpClient client;
    private final ExternalKtorConfig externalKtorConfig;
    private final UserPrefsSource prefs;

    public StreamRemote(HttpClient client, UserPrefsSource prefs, ExternalKtorConfig externalKtorConfig) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(externalKtorConfig, "externalKtorConfig");
        this.client = client;
        this.prefs = prefs;
        this.externalKtorConfig = externalKtorConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAll(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.data.remote.source.StreamRemote$getAll$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getAll$1 r0 = (ru.tattelecom.intercom.data.remote.source.StreamRemote$getAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getAll$1 r0 = new ru.tattelecom.intercom.data.remote.source.StreamRemote$getAll$1
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
            goto L98
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L75
        L39:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.client.HttpClient r8 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "available-streams"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r5 = r7.prefs
            java.lang.String r5 = r5.getPhoneNumber()
            java.lang.String r6 = "phone"
            io.ktor.client.request.UtilsKt.parameter(r2, r6, r5)
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r5 = r7.prefs
            java.lang.String r5 = r5.getDeviceId()
            java.lang.String r6 = "device_code"
            io.ktor.client.request.UtilsKt.parameter(r2, r6, r5)
            io.ktor.http.HttpMethod$Companion r5 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r5 = r5.getGet()
            r2.setMethod(r5)
            io.ktor.client.statement.HttpStatement r5 = new io.ktor.client.statement.HttpStatement
            r5.<init>(r2, r8)
            r0.label = r4
            java.lang.Object r8 = r5.execute(r0)
            if (r8 != r1) goto L75
            return r1
        L75:
            io.ktor.client.statement.HttpResponse r8 = (io.ktor.client.statement.HttpResponse) r8
            io.ktor.client.call.HttpClientCall r8 = r8.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse> r2 = ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse> r5 = ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r8 = r8.bodyNullable(r2, r0)
            if (r8 != r1) goto L98
            return r1
        L98:
            ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse r8 = (ru.tattelecom.intercom.data.remote.model.AvailableStreamsResponse) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.StreamRemote.getAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLive(java.lang.String r7, boolean r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StreamLiveResponse> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.StreamRemote$getLive$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getLive$1 r0 = (ru.tattelecom.intercom.data.remote.source.StreamRemote$getLive$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getLive$1 r0 = new ru.tattelecom.intercom.data.remote.source.StreamRemote$getLive$1
            r0.<init>(r6, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L39
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L87
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L64
        L39:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "live"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.streamApi(r2, r5, r8)
            java.lang.String r8 = "source"
            io.ktor.client.request.UtilsKt.parameter(r2, r8, r7)
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getGet()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r7.execute(r0)
            if (r9 != r1) goto L64
            return r1
        L64:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r7 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StreamLiveResponse> r8 = ru.tattelecom.intercom.data.remote.model.StreamLiveResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.nullableTypeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StreamLiveResponse> r2 = ru.tattelecom.intercom.data.remote.model.StreamLiveResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r2, r8)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r8, r0)
            if (r9 != r1) goto L87
            return r1
        L87:
            ru.tattelecom.intercom.data.remote.model.StreamLiveResponse r9 = (ru.tattelecom.intercom.data.remote.model.StreamLiveResponse) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.StreamRemote.getLive(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getArchive(java.lang.String r7, java.lang.String r8, boolean r9, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse> r10) {
        /*
            r6 = this;
            boolean r0 = r10 instanceof ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchive$1
            if (r0 == 0) goto L14
            r0 = r10
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchive$1 r0 = (ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchive$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchive$1 r0 = new ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchive$1
            r0.<init>(r6, r10)
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
            goto L8f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L6c
        L39:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.HttpClient r10 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "archive-stream"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.streamApi(r2, r5, r9)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            java.lang.String r9 = "source"
            io.ktor.client.request.UtilsKt.parameter(r2, r9, r7)
            java.lang.String r7 = "starttime"
            io.ktor.client.request.UtilsKt.parameter(r2, r7, r8)
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getGet()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r10)
            r0.label = r4
            java.lang.Object r10 = r7.execute(r0)
            if (r10 != r1) goto L6c
            return r1
        L6c:
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            io.ktor.client.call.HttpClientCall r7 = r10.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse> r8 = ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.nullableTypeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse> r10 = ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse.class
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r10)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r10, r8)
            r0.label = r3
            java.lang.Object r10 = r7.bodyNullable(r8, r0)
            if (r10 != r1) goto L8f
            return r1
        L8f:
            ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse r10 = (ru.tattelecom.intercom.data.remote.model.ArchiveStreamResponse) r10
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.StreamRemote.getArchive(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object archiveDownloadStart(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof ru.tattelecom.intercom.data.remote.source.StreamRemote$archiveDownloadStart$1
            if (r0 == 0) goto L14
            r0 = r11
            ru.tattelecom.intercom.data.remote.source.StreamRemote$archiveDownloadStart$1 r0 = (ru.tattelecom.intercom.data.remote.source.StreamRemote$archiveDownloadStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.StreamRemote$archiveDownloadStart$1 r0 = new ru.tattelecom.intercom.data.remote.source.StreamRemote$archiveDownloadStart$1
            r0.<init>(r6, r11)
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
            goto Lb1
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L8e
        L3a:
            kotlin.ResultKt.throwOnFailure(r11)
            io.ktor.client.HttpClient r11 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "archive-export-start"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.safeyardExtendedApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartRequest r5 = new ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartRequest
            r5.<init>(r7, r8, r9, r10)
            boolean r7 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r7 == 0) goto L5d
            r2.setBody(r5)
            r7 = 0
            r2.setBodyType(r7)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartRequest> r7 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartRequest.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r8 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartRequest> r9 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartRequest.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            io.ktor.util.reflect.TypeInfo r7 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r8, r9, r7)
            r2.setBodyType(r7)
        L77:
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getPost()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r11)
            r0.label = r4
            java.lang.Object r11 = r7.execute(r0)
            if (r11 != r1) goto L8e
            return r1
        L8e:
            io.ktor.client.statement.HttpResponse r11 = (io.ktor.client.statement.HttpResponse) r11
            io.ktor.client.call.HttpClientCall r7 = r11.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse> r8 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse> r10 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse.class
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r10)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r10, r8)
            r0.label = r3
            java.lang.Object r11 = r7.bodyNullable(r8, r0)
            if (r11 != r1) goto Lb1
            return r1
        Lb1:
            if (r11 == 0) goto Lb6
            ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse r11 = (ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse) r11
            return r11
        Lb6:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStartResponse"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.StreamRemote.archiveDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object getArchiveDownloadStatus(java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchiveDownloadStatus$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchiveDownloadStatus$1 r0 = (ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchiveDownloadStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchiveDownloadStatus$1 r0 = new ru.tattelecom.intercom.data.remote.source.StreamRemote$getArchiveDownloadStatus$1
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
            java.lang.String r5 = "archive-export-status"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.safeyardExtendedApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusRequest r5 = new ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusRequest
            r5.<init>(r7, r8)
            boolean r7 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r7 == 0) goto L5d
            r2.setBody(r5)
            r7 = 0
            r2.setBodyType(r7)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusRequest> r7 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusRequest.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r8 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusRequest> r5 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusRequest.class
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
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse> r8 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r2, r8)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r8, r0)
            if (r9 != r1) goto Lb1
            return r1
        Lb1:
            if (r9 == 0) goto Lb6
            ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse) r9
            return r9
        Lb6:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.StreamRemote.getArchiveDownloadStatus(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object setFavorite(java.lang.String r7, boolean r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.StreamRemote$setFavorite$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.StreamRemote$setFavorite$1 r0 = (ru.tattelecom.intercom.data.remote.source.StreamRemote$setFavorite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.StreamRemote$setFavorite$1 r0 = new ru.tattelecom.intercom.data.remote.source.StreamRemote$setFavorite$1
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
            java.lang.String r5 = "set-favorite-stream"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.FavoriteStreamRequest r5 = new ru.tattelecom.intercom.data.remote.model.FavoriteStreamRequest
            r5.<init>(r7, r8)
            boolean r7 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r7 == 0) goto L5d
            r2.setBody(r5)
            r7 = 0
            r2.setBodyType(r7)
            goto L77
        L5d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.FavoriteStreamRequest> r7 = ru.tattelecom.intercom.data.remote.model.FavoriteStreamRequest.class
            kotlin.reflect.KType r7 = kotlin.jvm.internal.Reflection.typeOf(r7)
            java.lang.reflect.Type r8 = kotlin.reflect.TypesJVMKt.getJavaType(r7)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.FavoriteStreamRequest> r5 = ru.tattelecom.intercom.data.remote.model.FavoriteStreamRequest.class
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
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r2, r8)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r8, r0)
            if (r9 != r1) goto Lb1
            return r1
        Lb1:
            if (r9 == 0) goto Lb6
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        Lb6:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r8 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.StreamRemote.setFavorite(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object keepAliveAxxon(String str, Continuation<? super Unit> continuation) {
        HttpClient client = this.externalKtorConfig.getClient();
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        BuildersWithUrlKt.url(httpRequestBuilder, URLUtilsKt.URLBuilder(str).build());
        httpRequestBuilder.setMethod(HttpMethod.INSTANCE.getGet());
        Object execute = new HttpStatement(httpRequestBuilder, client).execute(continuation);
        return execute == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? execute : Unit.INSTANCE;
    }
}
