package ru.tattelecom.intercom.data.remote.source;

import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;

/* compiled from: LeadRemote.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u000bJF\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u0086@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/LeadRemote;", "", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getLeaveOrderServices", "Lru/tattelecom/intercom/data/remote/model/responses/LeaveOrderServicesResponse;", "entityScreen", "", NavArg.ENTITY_ID, "", "(Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leaveOrder", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", "phone", "name", "services", "", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadFaceDetectionPhoto", "path", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LeadRemote {
    private final HttpClient client;

    public LeadRemote(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object leaveOrder(java.lang.String r8, java.lang.String r9, java.util.List<java.lang.Integer> r10, java.lang.String r11, java.lang.Long r12, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r13) {
        /*
            r7 = this;
            boolean r0 = r13 instanceof ru.tattelecom.intercom.data.remote.source.LeadRemote$leaveOrder$1
            if (r0 == 0) goto L14
            r0 = r13
            ru.tattelecom.intercom.data.remote.source.LeadRemote$leaveOrder$1 r0 = (ru.tattelecom.intercom.data.remote.source.LeadRemote$leaveOrder$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.LeadRemote$leaveOrder$1 r0 = new ru.tattelecom.intercom.data.remote.source.LeadRemote$leaveOrder$1
            r0.<init>(r7, r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r13)
            goto Lb6
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r13)
            goto L93
        L3a:
            kotlin.ResultKt.throwOnFailure(r13)
            io.ktor.client.HttpClient r13 = r7.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "create"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.leadApi(r2, r5)
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequest r5 = new ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequest
            ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequestData r6 = new ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequestData
            r6.<init>(r11, r12)
            r5.<init>(r8, r9, r10, r6)
            boolean r8 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r8 == 0) goto L62
            r2.setBody(r5)
            r8 = 0
            r2.setBodyType(r8)
            goto L7c
        L62:
            r2.setBody(r5)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequest> r8 = ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequest.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.typeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequest> r10 = ru.tattelecom.intercom.data.remote.model.requests.LeaveOrderRequest.class
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r10)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r10, r8)
            r2.setBodyType(r8)
        L7c:
            io.ktor.http.HttpMethod$Companion r8 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r8 = r8.getPost()
            r2.setMethod(r8)
            io.ktor.client.statement.HttpStatement r8 = new io.ktor.client.statement.HttpStatement
            r8.<init>(r2, r13)
            r0.label = r4
            java.lang.Object r13 = r8.execute(r0)
            if (r13 != r1) goto L93
            return r1
        L93:
            io.ktor.client.statement.HttpResponse r13 = (io.ktor.client.statement.HttpResponse) r13
            io.ktor.client.call.HttpClientCall r8 = r13.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r9 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r9 = kotlin.jvm.internal.Reflection.nullableTypeOf(r9)
            java.lang.reflect.Type r10 = kotlin.reflect.TypesJVMKt.getJavaType(r9)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r11 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)
            io.ktor.util.reflect.TypeInfo r9 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r10, r11, r9)
            r0.label = r3
            java.lang.Object r13 = r8.bodyNullable(r9, r0)
            if (r13 != r1) goto Lb6
            return r1
        Lb6:
            ru.tattelecom.intercom.data.remote.model.StatusResponse r13 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r13
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.LeadRemote.leaveOrder(java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLeaveOrderServices(java.lang.String r7, java.lang.Long r8, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.data.remote.source.LeadRemote$getLeaveOrderServices$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.data.remote.source.LeadRemote$getLeaveOrderServices$1 r0 = (ru.tattelecom.intercom.data.remote.source.LeadRemote$getLeaveOrderServices$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.LeadRemote$getLeaveOrderServices$1 r0 = new ru.tattelecom.intercom.data.remote.source.LeadRemote$getLeaveOrderServices$1
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
            goto L9d
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7a
        L39:
            kotlin.ResultKt.throwOnFailure(r9)
            io.ktor.client.HttpClient r9 = r6.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            java.lang.String r5 = "get"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.leadApi(r2, r5)
            if (r7 == 0) goto L4f
            java.lang.String r5 = "entity_screen"
            io.ktor.client.request.UtilsKt.parameter(r2, r5, r7)
        L4f:
            if (r8 == 0) goto L60
            java.lang.Number r8 = (java.lang.Number) r8
            long r7 = r8.longValue()
            java.lang.String r5 = "entity_id"
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            io.ktor.client.request.UtilsKt.parameter(r2, r5, r7)
        L60:
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            io.ktor.http.HttpMethod$Companion r7 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r7 = r7.getGet()
            r2.setMethod(r7)
            io.ktor.client.statement.HttpStatement r7 = new io.ktor.client.statement.HttpStatement
            r7.<init>(r2, r9)
            r0.label = r4
            java.lang.Object r9 = r7.execute(r0)
            if (r9 != r1) goto L7a
            return r1
        L7a:
            io.ktor.client.statement.HttpResponse r9 = (io.ktor.client.statement.HttpResponse) r9
            io.ktor.client.call.HttpClientCall r7 = r9.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse> r8 = ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse.class
            kotlin.reflect.KType r8 = kotlin.jvm.internal.Reflection.nullableTypeOf(r8)
            java.lang.reflect.Type r9 = kotlin.reflect.TypesJVMKt.getJavaType(r8)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse> r2 = ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r8 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r9, r2, r8)
            r0.label = r3
            java.lang.Object r9 = r7.bodyNullable(r8, r0)
            if (r9 != r1) goto L9d
            return r1
        L9d:
            ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse r9 = (ru.tattelecom.intercom.data.remote.model.responses.LeaveOrderServicesResponse) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.LeadRemote.getLeaveOrderServices(java.lang.String, java.lang.Long, kotlin.coroutines.Continuation):java.lang.Object");
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
    public final java.lang.Object uploadFaceDetectionPhoto(final java.lang.String r13, final java.lang.String r14, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$1
            if (r0 == 0) goto L14
            r0 = r15
            ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$1 r0 = (ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$1 r0 = new ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$1
            r0.<init>(r12, r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3a
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r15)
            goto Lc1
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L9e
        L3a:
            kotlin.ResultKt.throwOnFailure(r15)
            io.ktor.client.HttpClient r15 = r12.client
            io.ktor.client.request.HttpRequestBuilder r2 = new io.ktor.client.request.HttpRequestBuilder
            r2.<init>()
            ru.tattelecom.intercom.data.remote.KtorConfigKt.json(r2)
            java.lang.String r5 = "available-streams"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.subscriberApi(r2, r5)
            io.ktor.client.request.forms.MultiPartFormDataContent r5 = new io.ktor.client.request.forms.MultiPartFormDataContent
            ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$2$1 r6 = new ru.tattelecom.intercom.data.remote.source.LeadRemote$uploadFaceDetectionPhoto$2$1
            r6.<init>()
            kotlin.jvm.functions.Function1 r6 = (kotlin.jvm.functions.Function1) r6
            java.util.List r7 = io.ktor.client.request.forms.FormDslKt.formData(r6)
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            r6 = r5
            r6.<init>(r7, r8, r9, r10, r11)
            boolean r13 = r5 instanceof io.ktor.http.content.OutgoingContent
            if (r13 == 0) goto L6d
            r2.setBody(r5)
            r13 = 0
            r2.setBodyType(r13)
            goto L87
        L6d:
            r2.setBody(r5)
            java.lang.Class<io.ktor.client.request.forms.MultiPartFormDataContent> r13 = io.ktor.client.request.forms.MultiPartFormDataContent.class
            kotlin.reflect.KType r13 = kotlin.jvm.internal.Reflection.typeOf(r13)
            java.lang.reflect.Type r14 = kotlin.reflect.TypesJVMKt.getJavaType(r13)
            java.lang.Class<io.ktor.client.request.forms.MultiPartFormDataContent> r5 = io.ktor.client.request.forms.MultiPartFormDataContent.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r13 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r14, r5, r13)
            r2.setBodyType(r13)
        L87:
            io.ktor.http.HttpMethod$Companion r13 = io.ktor.http.HttpMethod.INSTANCE
            io.ktor.http.HttpMethod r13 = r13.getPost()
            r2.setMethod(r13)
            io.ktor.client.statement.HttpStatement r13 = new io.ktor.client.statement.HttpStatement
            r13.<init>(r2, r15)
            r0.label = r4
            java.lang.Object r15 = r13.execute(r0)
            if (r15 != r1) goto L9e
            return r1
        L9e:
            io.ktor.client.statement.HttpResponse r15 = (io.ktor.client.statement.HttpResponse) r15
            io.ktor.client.call.HttpClientCall r13 = r15.getCall()
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r14 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KType r14 = kotlin.jvm.internal.Reflection.typeOf(r14)
            java.lang.reflect.Type r15 = kotlin.reflect.TypesJVMKt.getJavaType(r14)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.StatusResponse> r2 = ru.tattelecom.intercom.data.remote.model.StatusResponse.class
            kotlin.reflect.KClass r2 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r2)
            io.ktor.util.reflect.TypeInfo r14 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r15, r2, r14)
            r0.label = r3
            java.lang.Object r15 = r13.bodyNullable(r14, r0)
            if (r15 != r1) goto Lc1
            return r1
        Lc1:
            if (r15 == 0) goto Lc6
            ru.tattelecom.intercom.data.remote.model.StatusResponse r15 = (ru.tattelecom.intercom.data.remote.model.StatusResponse) r15
            return r15
        Lc6:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r14 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.StatusResponse"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.LeadRemote.uploadFaceDetectionPhoto(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
