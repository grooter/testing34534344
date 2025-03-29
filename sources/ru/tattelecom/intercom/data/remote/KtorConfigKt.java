package ru.tattelecom.intercom.data.remote;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.huawei.hms.feature.dynamic.b;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.ContentType;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import io.ktor.http.URLParserKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.BuildConfig;

/* compiled from: KtorConfig.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\n\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0007*\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010\f\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u001a\u0010\u000e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u001a\"\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0007*\u00020\b\u001a\u0012\u0010\u0015\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\u0016\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\u0017\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\u0018\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u001a\u0010\u0019\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\u001a\u001a\u0010\u001d\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0002\u001a\u0012\u0010\u001e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002\"\u0019\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u001f"}, d2 = {"v2paths", "", "", "getV2paths", "()[Ljava/lang/String;", "[Ljava/lang/String;", "adv", "", "Lio/ktor/client/request/HttpRequestBuilder;", "path", "allLogApi", "authApi", "callLogApi", "codePassLogApi", "domofonApi", "apiName", "domofonApiWithVersion", "apiVersion", "", "gateApi", "json", "keyPassLogApi", "leadApi", "logApi", "safeyardExtendedApi", "streamApi", "isFlussonic", "", "subscriberApi", "supportApi", "trialApi", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KtorConfigKt {
    private static final String[] v2paths = {"add-apartment-by-qr-code", "archive-export-start", "archive-export-status", "archive-stream", "auth", "available-readers", "available-streams", "create", "create-qr-code", "delete-for-user", "delete-for-all-users", "disable-temporary-code", "events", "get", "get-adv-bottom-sheet", "get-apartment-guests", "get-temporary-code", "get-config", FirebaseAnalytics.Param.INDEX, "live", "open-door", LogWriteConstants.LOG_TYPE, "read-adv-bottom-sheet", "register-another-apartment", "set-device-version", "set-favorite-intercom", "set-favorite-stream", "set-favorite-gate", "set-temporary-code", "sms", TtmlNode.START, "update-push-token"};

    public static final void json(HttpRequestBuilder httpRequestBuilder) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        HttpMessagePropertiesKt.contentType(httpRequestBuilder, ContentType.Application.INSTANCE.getJson());
    }

    public static final void subscriberApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "subscriber", path);
    }

    public static final void supportApi(HttpRequestBuilder httpRequestBuilder, int i, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApiWithVersion(httpRequestBuilder, i, "support", path);
    }

    public static final void allLogApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "all-log", path);
    }

    public static final void callLogApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "call-log", path);
    }

    public static final void keyPassLogApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "key-pass-log", path);
    }

    public static final void codePassLogApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "code-pass-log", path);
    }

    public static final void trialApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "trial-period", path);
    }

    public static final void safeyardExtendedApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "safeyard-export-extended", path);
    }

    public static final void adv(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "adv", path);
    }

    public static final void streamApi(HttpRequestBuilder httpRequestBuilder, String path, boolean z) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, (z ? "flussonic" : "axxon").concat("-stream"), path);
    }

    public static final void logApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "remote-log", path);
    }

    public static final void leadApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "lead", path);
    }

    public static final void gateApi(HttpRequestBuilder httpRequestBuilder, String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        domofonApi(httpRequestBuilder, "gate", path);
    }

    public static final String[] getV2paths() {
        return v2paths;
    }

    public static final void domofonApi(HttpRequestBuilder httpRequestBuilder, final String apiName, final String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(path, "path");
        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfigKt$domofonApi$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                invoke2(uRLBuilder, uRLBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(URLBuilder url, URLBuilder it) {
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                URLParserKt.takeFrom(url, BuildConfig.ENDPOINT);
                String str = ArraysKt.contains(KtorConfigKt.getV2paths(), path) ? b.t : "v1";
                URLBuilderKt.setEncodedPath(url, RemoteSettings.FORWARD_SLASH_STRING + str + RemoteSettings.FORWARD_SLASH_STRING + apiName + RemoteSettings.FORWARD_SLASH_STRING + path);
            }
        });
    }

    public static final void domofonApiWithVersion(HttpRequestBuilder httpRequestBuilder, final int i, final String apiName, final String path) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(path, "path");
        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfigKt$domofonApiWithVersion$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                invoke2(uRLBuilder, uRLBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(URLBuilder url, URLBuilder it) {
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                URLParserKt.takeFrom(url, BuildConfig.ENDPOINT);
                URLBuilderKt.setEncodedPath(url, "/v" + i + RemoteSettings.FORWARD_SLASH_STRING + apiName + RemoteSettings.FORWARD_SLASH_STRING + path);
            }
        });
    }

    public static /* synthetic */ void authApi$default(HttpRequestBuilder httpRequestBuilder, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        authApi(httpRequestBuilder, str);
    }

    public static final void authApi(HttpRequestBuilder httpRequestBuilder, final String str) {
        Intrinsics.checkNotNullParameter(httpRequestBuilder, "<this>");
        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfigKt$authApi$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                invoke2(uRLBuilder, uRLBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(URLBuilder url, URLBuilder it) {
                String str2;
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                URLParserKt.takeFrom(url, BuildConfig.ENDPOINT);
                String str3 = str;
                if (str3 != null) {
                    str2 = RemoteSettings.FORWARD_SLASH_STRING + str3;
                } else {
                    str2 = "";
                }
                URLBuilderKt.setEncodedPath(url, "/v2/auth" + str2);
            }
        });
    }
}
