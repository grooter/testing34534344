package ru.tattelecom.intercom.data.remote;

import android.app.Application;
import androidx.work.WorkRequest;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.huawei.hms.feature.dynamic.f.e;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.auth.Auth;
import io.ktor.client.plugins.auth.AuthProvider;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import okhttp3.OkHttpClient;
import ru.tattelecom.intercom.data.R;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;

/* compiled from: KtorConfig.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001c\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005¢\u0006\u0002\u0010\bJ\u0014\u0010\u000e\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/tattelecom/intercom/data/remote/KtorConfig;", "", "prefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "onSessionEnd", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lru/tattelecom/intercom/data/prefs/UserPrefsSource;Lkotlin/jvm/functions/Function1;)V", "client", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "Lkotlin/jvm/functions/Function1;", "provideSslSocketFactory", "Lokhttp3/OkHttpClient$Builder;", "app", "Landroid/app/Application;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KtorConfig {
    private final HttpClient client;
    private final Function1<Continuation<? super Unit>, Object> onSessionEnd;
    private final UserPrefsSource prefs;

    /* JADX WARN: Multi-variable type inference failed */
    public KtorConfig(UserPrefsSource prefs, Function1<? super Continuation<? super Unit>, ? extends Object> onSessionEnd) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(onSessionEnd, "onSessionEnd");
        this.prefs = prefs;
        this.onSessionEnd = onSessionEnd;
        this.client = HttpClientKt.HttpClient(OkHttp.INSTANCE.create(new Function1<OkHttpConfig, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OkHttpConfig okHttpConfig) {
                invoke2(okHttpConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OkHttpConfig create) {
                Intrinsics.checkNotNullParameter(create, "$this$create");
                create.config(new Function1<OkHttpClient.Builder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(OkHttpClient.Builder builder) {
                        invoke2(builder);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(OkHttpClient.Builder config) {
                        Intrinsics.checkNotNullParameter(config, "$this$config");
                        config.retryOnConnectionFailure(true);
                        config.connectTimeout(5L, TimeUnit.SECONDS);
                    }
                });
            }
        }), new Function1<HttpClientConfig<?>, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                invoke2(httpClientConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpClientConfig<?> HttpClient) {
                Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                HttpClient.setExpectSuccess(false);
                HttpClient.install(HttpTimeout.INSTANCE, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                        invoke2(httpTimeoutCapabilityConfiguration);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        install.setSocketTimeoutMillis(Long.valueOf(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS));
                    }
                });
                HttpClient.install(ContentNegotiation.INSTANCE, new Function1<ContentNegotiation.Config, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ContentNegotiation.Config install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        JsonSupportKt.json$default(install, JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig.client.2.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                                invoke2(jsonBuilder);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(JsonBuilder Json) {
                                Intrinsics.checkNotNullParameter(Json, "$this$Json");
                                Json.setIgnoreUnknownKeys(true);
                            }
                        }, 1, null), null, 2, null);
                    }
                });
                Auth.Companion companion = Auth.INSTANCE;
                final KtorConfig ktorConfig = KtorConfig.this;
                HttpClient.install(companion, new Function1<Auth, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$2.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Auth auth) {
                        invoke2(auth);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Auth install) {
                        Intrinsics.checkNotNullParameter(install, "$this$install");
                        List<AuthProvider> providers = install.getProviders();
                        final KtorConfig ktorConfig2 = KtorConfig.this;
                        providers.add(new AuthProvider() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig.client.2.3.1
                            private final boolean sendWithoutRequest = true;

                            @Override // io.ktor.client.plugins.auth.AuthProvider
                            public boolean isApplicable(HttpAuthHeader auth) {
                                Intrinsics.checkNotNullParameter(auth, "auth");
                                return true;
                            }

                            @Override // io.ktor.client.plugins.auth.AuthProvider
                            public Object refreshToken(HttpResponse httpResponse, Continuation<? super Boolean> continuation) {
                                return AuthProvider.DefaultImpls.refreshToken(this, httpResponse, continuation);
                            }

                            @Override // io.ktor.client.plugins.auth.AuthProvider
                            public boolean sendWithoutRequest(HttpRequestBuilder httpRequestBuilder) {
                                return AuthProvider.DefaultImpls.sendWithoutRequest(this, httpRequestBuilder);
                            }

                            @Override // io.ktor.client.plugins.auth.AuthProvider
                            public boolean getSendWithoutRequest() {
                                return this.sendWithoutRequest;
                            }

                            @Override // io.ktor.client.plugins.auth.AuthProvider
                            public Object addRequestHeaders(HttpRequestBuilder httpRequestBuilder, HttpAuthHeader httpAuthHeader, Continuation<? super Unit> continuation) {
                                UserPrefsSource userPrefsSource;
                                userPrefsSource = KtorConfig.this.prefs;
                                String token = userPrefsSource.getToken();
                                if (token != null) {
                                    httpRequestBuilder.getHeaders().set("access-token", token);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    }
                });
                final KtorConfig ktorConfig2 = KtorConfig.this;
                HttpCallValidatorKt.HttpResponseValidator(HttpClient, new Function1<HttpCallValidator.Config, Unit>() { // from class: ru.tattelecom.intercom.data.remote.KtorConfig$client$2.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(HttpCallValidator.Config config) {
                        invoke2(config);
                        return Unit.INSTANCE;
                    }

                    /* compiled from: KtorConfig.kt */
                    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.tattelecom.intercom.data.remote.KtorConfig$client$2$5$1", f = "KtorConfig.kt", i = {1}, l = {121, 333}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
                    /* renamed from: ru.tattelecom.intercom.data.remote.KtorConfig$client$2$5$1, reason: invalid class name */
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                        /* synthetic */ Object L$0;
                        int label;
                        final /* synthetic */ KtorConfig this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(KtorConfig ktorConfig, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = ktorConfig;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0104  */
                        /* JADX WARN: Removed duplicated region for block: B:7:0x0071  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
                            /*
                                Method dump skipped, instructions count: 298
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.remote.KtorConfig$client$2.AnonymousClass5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(HttpCallValidator.Config HttpResponseValidator) {
                        Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
                        HttpResponseValidator.validateResponse(new AnonymousClass1(KtorConfig.this, null));
                        HttpResponseValidator.handleResponseExceptionWithRequest(new AnonymousClass2(null));
                    }

                    /* compiled from: KtorConfig.kt */
                    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "exception", "", "request", "Lio/ktor/client/request/HttpRequest;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "ru.tattelecom.intercom.data.remote.KtorConfig$client$2$5$2", f = "KtorConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: ru.tattelecom.intercom.data.remote.KtorConfig$client$2$5$2, reason: invalid class name */
                    static final class AnonymousClass2 extends SuspendLambda implements Function3<Throwable, HttpRequest, Continuation<? super Unit>, Object> {
                        /* synthetic */ Object L$0;
                        /* synthetic */ Object L$1;
                        int label;

                        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                            super(3, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Throwable th, HttpRequest httpRequest, Continuation<? super Unit> continuation) {
                            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
                            anonymousClass2.L$0 = th;
                            anonymousClass2.L$1 = httpRequest;
                            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            String str;
                            IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            Throwable th = (Throwable) this.L$0;
                            HttpRequest httpRequest = (HttpRequest) this.L$1;
                            if (th instanceof SocketTimeoutException) {
                                str = "time_out";
                            } else if (th instanceof IllegalStateException) {
                                str = th.getMessage();
                                if (str == null) {
                                    str = "no_message";
                                }
                            } else {
                                if (th instanceof UnknownHostException ? true : th instanceof ConnectException) {
                                    str = "no_connection";
                                } else {
                                    str = th.getLocalizedMessage() + " " + StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(httpRequest.getUrl().getEncodedPath(), "/v1/", "", false, 4, (Object) null), "/v2/", "", false, 4, (Object) null), RemoteSettings.FORWARD_SLASH_STRING, "_", false, 4, (Object) null), "-", "_", false, 4, (Object) null);
                                }
                            }
                            throw new IllegalStateException(str.toString());
                        }
                    }
                });
            }
        });
    }

    public final HttpClient getClient() {
        return this.client;
    }

    private final void provideSslSocketFactory(OkHttpClient.Builder builder, Application application) {
        Collection<? extends Certificate> generateCertificates = CertificateFactory.getInstance(e.b).generateCertificates(application.getResources().openRawResource(R.raw.certificate2));
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        Intrinsics.checkNotNull(generateCertificates);
        int i = 0;
        for (Object obj : generateCertificates) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            keyStore.setCertificateEntry(String.valueOf(i2), (Certificate) obj);
            i = i2;
        }
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager trustManager = trustManagerFactory.getTrustManagers()[0];
        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
        sSLContext.init(null, new X509TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        Intrinsics.checkNotNull(socketFactory);
        builder.sslSocketFactory(socketFactory, x509TrustManager);
    }
}
