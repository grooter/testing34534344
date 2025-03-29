package ru.tattelecom.intercom.data.remote.source;

import androidx.media3.extractor.text.ttml.TtmlNode;
import io.ktor.client.HttpClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.remote.contracts.AdvRemote;

/* compiled from: AdvRemoteImpl.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/AdvRemoteImpl;", "Lru/tattelecom/intercom/data/remote/contracts/AdvRemote;", "client", "Lio/ktor/client/HttpClient;", "(Lio/ktor/client/HttpClient;)V", "getAdvBottomSheet", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAdvIsRead", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", TtmlNode.ATTR_ID, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AdvRemoteImpl implements AdvRemote {
    private final HttpClient client;

    public AdvRemoteImpl(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // ru.tattelecom.intercom.data.remote.contracts.AdvRemote
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object getAdvBottomSheet(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl$getAdvBottomSheet$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl$getAdvBottomSheet$1 r0 = (ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl$getAdvBottomSheet$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl$getAdvBottomSheet$1 r0 = new ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl$getAdvBottomSheet$1
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
            java.lang.String r5 = "get-adv-bottom-sheet"
            ru.tattelecom.intercom.data.remote.KtorConfigKt.adv(r2, r5)
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
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse> r2 = ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse.class
            kotlin.reflect.KType r2 = kotlin.jvm.internal.Reflection.typeOf(r2)
            java.lang.reflect.Type r4 = kotlin.reflect.TypesJVMKt.getJavaType(r2)
            java.lang.Class<ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse> r5 = ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r5)
            io.ktor.util.reflect.TypeInfo r2 = io.ktor.util.reflect.TypeInfoJvmKt.typeInfoImpl(r4, r5, r2)
            r0.label = r3
            java.lang.Object r7 = r7.bodyNullable(r2, r0)
            if (r7 != r1) goto L85
            return r1
        L85:
            if (r7 == 0) goto L8a
            ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse r7 = (ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse) r7
            return r7
        L8a:
            java.lang.NullPointerException r7 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl.getAdvBottomSheet(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // ru.tattelecom.intercom.data.remote.contracts.AdvRemote
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object setAdvIsRead(long r10, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.data.remote.model.StatusResponse> r12) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.source.AdvRemoteImpl.setAdvIsRead(long, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
