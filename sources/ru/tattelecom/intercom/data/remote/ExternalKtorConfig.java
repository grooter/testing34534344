package ru.tattelecom.intercom.data.remote;

import com.google.firebase.sessions.settings.RemoteSettings;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientKt;
import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.plugins.HttpCallValidator;
import io.ktor.client.plugins.HttpCallValidatorKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.serialization.kotlinx.json.JsonSupportKt;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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

/* compiled from: ExternalKtorConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/data/remote/ExternalKtorConfig;", "", "()V", "client", "Lio/ktor/client/HttpClient;", "getClient", "()Lio/ktor/client/HttpClient;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExternalKtorConfig {
    private final HttpClient client = HttpClientKt.HttpClient(OkHttp.INSTANCE.create(new Function1<OkHttpConfig, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OkHttpConfig okHttpConfig) {
            invoke2(okHttpConfig);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OkHttpConfig create) {
            Intrinsics.checkNotNullParameter(create, "$this$create");
            create.config(new Function1<OkHttpClient.Builder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$1.1
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
    }), new Function1<HttpClientConfig<?>, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
            invoke2(httpClientConfig);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HttpClientConfig<?> HttpClient) {
            Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
            HttpClient.setExpectSuccess(false);
            HttpClient.install(HttpTimeout.INSTANCE, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                    invoke2(httpTimeoutCapabilityConfiguration);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    install.setSocketTimeoutMillis(10000L);
                }
            });
            HttpClient.install(ContentNegotiation.INSTANCE, new Function1<ContentNegotiation.Config, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2.2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentNegotiation.Config config) {
                    invoke2(config);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContentNegotiation.Config install) {
                    Intrinsics.checkNotNullParameter(install, "$this$install");
                    JsonSupportKt.json$default(install, JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig.client.2.2.1
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
            HttpCallValidatorKt.HttpResponseValidator(HttpClient, new Function1<HttpCallValidator.Config, Unit>() { // from class: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2.4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpCallValidator.Config config) {
                    invoke2(config);
                    return Unit.INSTANCE;
                }

                /* compiled from: ExternalKtorConfig.kt */
                @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2$4$1", f = "ExternalKtorConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2$4$1, reason: invalid class name */
                static final class AnonymousClass1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
                    /* synthetic */ Object L$0;
                    int label;

                    AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(httpResponse, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        HttpResponse httpResponse = (HttpResponse) this.L$0;
                        if (!HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                            throw new IllegalStateException(Boxing.boxInt(httpResponse.getStatus().getValue()).toString());
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpCallValidator.Config HttpResponseValidator) {
                    Intrinsics.checkNotNullParameter(HttpResponseValidator, "$this$HttpResponseValidator");
                    HttpResponseValidator.validateResponse(new AnonymousClass1(null));
                    HttpResponseValidator.handleResponseExceptionWithRequest(new AnonymousClass2(null));
                }

                /* compiled from: ExternalKtorConfig.kt */
                @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "exception", "", "request", "Lio/ktor/client/request/HttpRequest;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2$4$2", f = "ExternalKtorConfig.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: ru.tattelecom.intercom.data.remote.ExternalKtorConfig$client$2$4$2, reason: invalid class name */
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
                                str = th.getLocalizedMessage() + " " + StringsKt.replace$default(StringsKt.replace$default(httpRequest.getUrl().getEncodedPath(), RemoteSettings.FORWARD_SLASH_STRING, "_", false, 4, (Object) null), "-", "_", false, 4, (Object) null);
                            }
                        }
                        throw new IllegalStateException(str.toString());
                    }
                }
            });
        }
    });

    public final HttpClient getClient() {
        return this.client;
    }
}
