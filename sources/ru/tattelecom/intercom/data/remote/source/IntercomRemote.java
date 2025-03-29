package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: IntercomRemote.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0002\u0010\u000eJ \u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0018JL\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\n2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\u001fH\u0086@¢\u0006\u0002\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/IntercomRemote;", "", "client", "Lio/ktor/client/HttpClient;", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "(Lio/ktor/client/HttpClient;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;)V", "deleteSchedule", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "scheduleId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "Lru/tattelecom/intercom/data/remote/model/AvailableIntercomsResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSipSetting", "Lru/tattelecom/intercom/data/remote/model/SipSettingsResponse;", "setCalls", NavArg.INTERCOM_ID, "muted", "", "(Ljava/lang/Integer;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDoNotDisturb", "isEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSchedule", "Lru/tattelecom/intercom/data/remote/model/SetScheduleResponse;", "startTime", "Lkotlin/Pair;", "finishTime", "days", "", "(ILkotlin/Pair;Lkotlin/Pair;[Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntercomRemote {
    private final HttpClient client;
    private final UserPrefsSource prefs;

    public IntercomRemote(HttpClient client, UserPrefsSource prefs) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.client = client;
        this.prefs = prefs;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getSipSetting(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.SipSettingsResponse> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.data.remote.source.IntercomRemote$getSipSetting$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$getSipSetting$1 r0 = (ru.tattelecom.intercom.data.remote.source.IntercomRemote$getSipSetting$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$getSipSetting$1 r0 = new ru.tattelecom.intercom.data.remote.source.IntercomRemote$getSipSetting$1
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
            java.lang.String r5 = "sip-credentials"
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
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SipSettingsResponse> r2 = ru.tattelecom.intercom.data.remote.model.SipSettingsResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SipSettingsResponse> r5 = ru.tattelecom.intercom.data.remote.model.SipSettingsResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r8 = r8.bodyNullable(r2, r0)
            if (r8 != r1) goto L98
            return r1
        L98:
            ru.tattelecom.intercom.data.remote.model.SipSettingsResponse r8 = (ru.tattelecom.intercom.data.remote.model.SipSettingsResponse) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.IntercomRemote.getSipSetting(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAll(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.data.remote.source.IntercomRemote$getAll$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$getAll$1 r0 = (ru.tattelecom.intercom.data.remote.source.IntercomRemote$getAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$getAll$1 r0 = new ru.tattelecom.intercom.data.remote.source.IntercomRemote$getAll$1
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
            java.lang.String r5 = "available-intercoms"
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
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse> r2 = ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.nullableTypeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse> r5 = ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r8 = r8.bodyNullable(r2, r0)
            if (r8 != r1) goto L98
            return r1
        L98:
            ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse r8 = (ru.tattelecom.intercom.data.remote.model.AvailableIntercomsResponse) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.IntercomRemote.getAll(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setCalls(java.lang.Integer r8, boolean r9, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof ru.tattelecom.intercom.data.remote.source.IntercomRemote$setCalls$1
            if (r0 == 0) goto L14
            r0 = r10
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$setCalls$1 r0 = (ru.tattelecom.intercom.data.remote.source.IntercomRemote$setCalls$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$setCalls$1 r0 = new ru.tattelecom.intercom.data.remote.source.IntercomRemote$setCalls$1
            r0.<init>(r7, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc2
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9f
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.HttpClient r10 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            if (r9 == 0) goto L49
            java.lang.String r9 = "disable-intercom-calls"
            goto L4b
        L49:
            java.lang.String r9 = "enable-intercom-calls"
        L4b:
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r9)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.SetIntercomCallsRequest r9 = new ru.tattelecom.intercom.data.remote.model.SetIntercomCallsRequest
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r5 = r7.prefs
            java.lang.String r5 = r5.getPhoneNumber()
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = r7.prefs
            java.lang.String r6 = r6.getDeviceId()
            r9.<init>(r5, r6, r8)
            boolean r8 = r9 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L6e
            r2.setBody(r9)
            r8 = 0
            r2.setBodyType(r8)
            goto L88
        L6e:
            r2.setBody(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SetIntercomCallsRequest> r8 = ru.tattelecom.intercom.data.remote.model.SetIntercomCallsRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SetIntercomCallsRequest> r5 = ru.tattelecom.intercom.data.remote.model.SetIntercomCallsRequest.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r5, r8)
            r2.setBodyType(r8)
        L88:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r10)
            r0.label = r4
            java.lang.Object r10 = r8.execute(r0)
            if (r10 != r1) goto L9f
            return r1
        L9f:
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            io.ktor.client.call.HttpClientCall r8 = r10.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r9 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.typeOf(r9)
            java.lang.reflect.Type r10 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r10, r2, r9)
            r0.label = r3
            java.lang.Object r10 = r8.bodyNullable(r9, r0)
            if (r10 != r1) goto Lc2
            return r1
        Lc2:
            if (r10 == 0) goto Lc7
            ru.tattelecom.intercom.data.remote.model.StatusResponse r10 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r10
            return r10
        Lc7:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.IntercomRemote.setCalls(java.lang.Integer, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setDoNotDisturb(boolean r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.IntercomRemote$setDoNotDisturb$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$setDoNotDisturb$1 r0 = (ru.tattelecom.intercom.data.remote.source.IntercomRemote$setDoNotDisturb$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$setDoNotDisturb$1 r0 = new ru.tattelecom.intercom.data.remote.source.IntercomRemote$setDoNotDisturb$1
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
            goto Lc2
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L9f
        L3a:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            if (r8 == 0) goto L49
            java.lang.String r8 = "disable-calls"
            goto L4b
        L49:
            java.lang.String r8 = "enable-calls"
        L4b:
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r8)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.SetDoNotDisturbRequest r8 = new ru.tattelecom.intercom.data.remote.model.SetDoNotDisturbRequest
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r5 = r7.prefs
            java.lang.String r5 = r5.getPhoneNumber()
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = r7.prefs
            java.lang.String r6 = r6.getDeviceId()
            r8.<init>(r5, r6)
            boolean r5 = r8 instanceof io.ktor.http.content.OutgoingContent
            if (r5 == 0) goto L6e
            r2.setBody(r8)
            r8 = 0
            r2.setBodyType(r8)
            goto L88
        L6e:
            r2.setBody(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SetDoNotDisturbRequest> r8 = ru.tattelecom.intercom.data.remote.model.SetDoNotDisturbRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.SetDoNotDisturbRequest> r6 = ru.tattelecom.intercom.data.remote.model.SetDoNotDisturbRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r8)
            r2.setBodyType(r8)
        L88:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r8.execute(r0)
            if (r9 != r1) goto L9f
            return r1
        L9f:
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
            if (r9 != r1) goto Lc2
            return r1
        Lc2:
            if (r9 == 0) goto Lc7
            ru.tattelecom.intercom.data.remote.model.StatusResponse r9 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r9
            return r9
        Lc7:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r9 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.IntercomRemote.setDoNotDisturb(boolean, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object deleteSchedule(int r9, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof ru.tattelecom.intercom.data.remote.source.IntercomRemote$deleteSchedule$1
            if (r0 == 0) goto L14
            r0 = r10
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$deleteSchedule$1 r0 = (ru.tattelecom.intercom.data.remote.source.IntercomRemote$deleteSchedule$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.IntercomRemote$deleteSchedule$1 r0 = new ru.tattelecom.intercom.data.remote.source.IntercomRemote$deleteSchedule$1
            r0.<init>(r8, r10)
        L19:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r10)
            goto Lc1
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L9e
        L3a:
            kotlin.ResultKt.throwOnFailure(r10)
            io.ktor.client.HttpClient r10 = r8.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "delete-schedule"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.DeleteScheduleRequest r5 = new ru.tattelecom.intercom.data.remote.model.DeleteScheduleRequest
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r6 = r8.prefs
            java.lang.String r6 = r6.getPhoneNumber()
            ru.tattelecom.intercom.data.prefs.UserPrefsSource r7 = r8.prefs
            java.lang.String r7 = r7.getDeviceId()
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            r5.<init>(r6, r7, r9)
            boolean r9 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r9 == 0) goto L6d
            r2.setBody(r5)
            r9 = 0
            r2.setBodyType(r9)
            goto L87
        L6d:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteScheduleRequest> r9 = ru.tattelecom.intercom.data.remote.model.DeleteScheduleRequest.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.typeOf(r9)
            java.lang.reflect.Type r5 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.DeleteScheduleRequest> r6 = ru.tattelecom.intercom.data.remote.model.DeleteScheduleRequest.class
            kotlin.reflect.KClass r6 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r6)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r5, r6, r9)
            r2.setBodyType(r9)
        L87:
            io.ktor.http.HttpMethod$Companion r9 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r9 = r9.getPost()
            r2.setMethod(r9)
            io.ktor.client.statement.HttpStatement r9 = new io.ktor.client.statement.HttpStatement
            r9.<init>(r2, r10)
            r0.label = r4
            java.lang.Object r10 = r9.execute(r0)
            if (r10 != r1) goto L9e
            return r1
        L9e:
            io.ktor.client.statement.HttpResponse r10 = (io.ktor.client.statement.HttpResponse) r10
            io.ktor.client.call.HttpClientCall r9 = r10.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r10 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r10 = kotlin.jvm.internal.Reflection.typeOf(r10)
            java.lang.reflect.Type r2 = kotlin.reflect.TypesJVMKt.getJavaType(r10)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r4 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r4 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r4)
            io.ktor.util.reflect.TypeInfo r10 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r2, r4, r10)
            r0.label = r3
            java.lang.Object r10 = r9.bodyNullable(r10, r0)
            if (r10 != r1) goto Lc1
            return r1
        Lc1:
            if (r10 == 0) goto Lc6
            ru.tattelecom.intercom.data.remote.model.StatusResponse r10 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r10
            return r10
        Lc6:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.IntercomRemote.deleteSchedule(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setSchedule(int r24, kotlin.Pair<java.lang.Integer, java.lang.Integer> r25, kotlin.Pair<java.lang.Integer, java.lang.Integer> r26, java.lang.Boolean[] r27, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.SetScheduleResponse> r28) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.IntercomRemote.setSchedule(int, kotlin.Pair, kotlin.Pair, java.lang.Boolean[], kotlin.coroutines.Continuation):java.lang.Object");
    }
}
