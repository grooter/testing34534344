package ru.tattelecom.intercom.domain.interactors;

import com.google.firebase.sessions.settings.RemoteSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.remote.source.StreamRemote;
import ru.tattelecom.intercom.domain.model.StreamSourceDto;

/* compiled from: StreamInteractor.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0012J(\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u001e\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\u001eJ \u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0086@¢\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/StreamInteractor;", "", "remote", "Lru/tattelecom/intercom/data/remote/source/StreamRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "(Lru/tattelecom/intercom/data/remote/source/StreamRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;)V", "getRemote", "()Lru/tattelecom/intercom/data/remote/source/StreamRemote;", "getArchiveDownloadLocation", "", "source", "type", "startTime", "duration", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArchiveDownloadUrl", "location", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArchiveStreamDownloadUrl", "Lru/tattelecom/intercom/domain/model/StreamDownloadStatus;", "getArchiveUrl", "Lru/tattelecom/intercom/domain/model/StreamSourceDto;", "archiveSource", "isFlussonic", "", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIntercomDownloadUrl", "url", "", "", "getLiveUrl", "liveSource", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keepAliveAxxon", "", "axxonDto", "Lru/tattelecom/intercom/domain/model/StreamSourceDto$AxxonDto;", "(Lru/tattelecom/intercom/domain/model/StreamSourceDto$AxxonDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StreamInteractor {
    private final AppCoroutineDispatchers dispatchers;
    private final StreamRemote remote;

    public StreamInteractor(StreamRemote remote, AppCoroutineDispatchers dispatchers) {
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        this.remote = remote;
        this.dispatchers = dispatchers;
    }

    public final StreamRemote getRemote() {
        return this.remote;
    }

    public final Object getLiveUrl(String str, boolean z, Continuation<? super StreamSourceDto> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new StreamInteractor$getLiveUrl$2(this, str, z, null), continuation);
    }

    public final Object getArchiveUrl(String str, String str2, boolean z, Continuation<? super StreamSourceDto> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new StreamInteractor$getArchiveUrl$2(this, str, str2, z, null), continuation);
    }

    public final Object getArchiveDownloadLocation(String str, String str2, String str3, String str4, Continuation<? super String> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new StreamInteractor$getArchiveDownloadLocation$2(this, str, str2, str3, str4, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0089 -> B:11:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getArchiveDownloadUrl(java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$1
            if (r0 == 0) goto L14
            r0 = r11
            ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$1 r0 = (ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$1 r0 = new ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$1
            r0.<init>(r8, r11)
        L19:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L54
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.StreamInteractor r2 = (ru.tattelecom.intercom.domain.interactors.StreamInteractor) r2
            kotlin.ResultKt.throwOnFailure(r11)
        L38:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L8c
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L44:
            java.lang.Object r9 = r0.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.StreamInteractor r2 = (ru.tattelecom.intercom.domain.interactors.StreamInteractor) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6d
        L54:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r8
        L58:
            r0.L$0 = r11
            r0.L$1 = r9
            r0.L$2 = r10
            r0.label = r4
            r5 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r2 != r1) goto L69
            return r1
        L69:
            r2 = r11
            r7 = r10
            r10 = r9
            r9 = r7
        L6d:
            ru.tattelecom.intercom.core.AppCoroutineDispatchers r11 = r2.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r11 = r11.getIo()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$2 r5 = new ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveDownloadUrl$2
            r6 = 0
            r5.<init>(r2, r10, r9, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r5, r0)
            if (r11 != r1) goto L38
            return r1
        L8c:
            ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse r11 = (ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse) r11
            java.lang.String r11 = r11.getUrl()
            java.lang.String r5 = ""
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r5)
            if (r5 != 0) goto L9b
            return r11
        L9b:
            r11 = r2
            goto L58
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.StreamInteractor.getArchiveDownloadUrl(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getIntercomDownloadUrl(String url, long startTime, int duration) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.substringBeforeLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null) + RemoteSettings.FORWARD_SLASH_STRING + ("archive-" + startTime + "-" + duration + ".mp4?") + StringsKt.substringAfterLast$default(url, "?", (String) null, 2, (Object) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getArchiveStreamDownloadUrl(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.domain.model.StreamDownloadStatus> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveStreamDownloadUrl$1
            if (r0 == 0) goto L14
            r0 = r7
            ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveStreamDownloadUrl$1 r0 = (ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveStreamDownloadUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveStreamDownloadUrl$1 r0 = new ru.tattelecom.intercom.domain.interactors.StreamInteractor$getArchiveStreamDownloadUrl$1
            r0.<init>(r4, r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L40
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.tattelecom.intercom.data.remote.source.StreamRemote r7 = r4.remote
            r0.label = r3
            java.lang.Object r7 = r7.getArchiveDownloadStatus(r5, r6, r0)
            if (r7 != r1) goto L40
            return r1
        L40:
            ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse r7 = (ru.tattelecom.intercom.data.remote.model.ArchiveDownloadStatusResponse) r7
            ru.tattelecom.intercom.domain.model.StreamDownloadStatus r5 = new ru.tattelecom.intercom.domain.model.StreamDownloadStatus
            double r0 = r7.getLoading()
            java.lang.String r6 = r7.getUrl()
            r5.<init>(r0, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.StreamInteractor.getArchiveStreamDownloadUrl(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object keepAliveAxxon(StreamSourceDto.AxxonDto axxonDto, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new StreamInteractor$keepAliveAxxon$2(axxonDto, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
