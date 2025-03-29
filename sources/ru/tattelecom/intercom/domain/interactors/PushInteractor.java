package ru.tattelecom.intercom.domain.interactors;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import ru.tattelecom.intercom.core.AppCoroutineDispatchers;
import ru.tattelecom.intercom.data.prefs.PushPrefsSource;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.data.prefs.model.PushInfo;
import ru.tattelecom.intercom.data.remote.source.PushRemote;
import ru.tattelecom.intercom.domain.workers.SendPushTokenWorker;
import ru.tattelecom.intercom.domain.workers.SetPushTokenStatusWorker;

/* compiled from: PushInteractor.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0013J \u0010\u0016\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/PushInteractor;", "", "prefs", "Lru/tattelecom/intercom/data/prefs/PushPrefsSource;", "remote", "Lru/tattelecom/intercom/data/remote/source/PushRemote;", "dispatchers", "Lru/tattelecom/intercom/core/AppCoroutineDispatchers;", "userPrefs", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "(Lru/tattelecom/intercom/data/prefs/PushPrefsSource;Lru/tattelecom/intercom/data/remote/source/PushRemote;Lru/tattelecom/intercom/core/AppCoroutineDispatchers;Lru/tattelecom/intercom/data/prefs/UserPrefsSource;)V", "deletePushToken", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAndSendPushToken", "", "getPushInfo", "Lru/tattelecom/intercom/data/prefs/model/PushInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPushToken", "", "startSendPushTokenWorker", SendPushTokenWorker.PUSH_TOKEN, "", SendPushTokenWorker.PUSH_SERVICE, "startUpdatePushTokenStatusWorker", SetPushTokenStatusWorker.PUSH_TOKEN_STATUS, "updatePushToken", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePushTokenStatus", "status", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PushInteractor {
    private final AppCoroutineDispatchers dispatchers;
    private final PushPrefsSource prefs;
    private final PushRemote remote;
    private final UserPrefsSource userPrefs;

    public PushInteractor(PushPrefsSource prefs, PushRemote remote, AppCoroutineDispatchers dispatchers, UserPrefsSource userPrefs) {
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(userPrefs, "userPrefs");
        this.prefs = prefs;
        this.remote = remote;
        this.dispatchers = dispatchers;
        this.userPrefs = userPrefs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startUpdatePushTokenStatusWorker(boolean pushTokenStatus, Context context) {
        WorkManager workManager = WorkManager.getInstance(context);
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SetPushTokenStatusWorker.class);
        Data build = new Data.Builder().putBoolean(SetPushTokenStatusWorker.PUSH_TOKEN_STATUS, pushTokenStatus).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        workManager.enqueueUniqueWork("SendingPushToken", existingWorkPolicy, builder.setInputData(build).build());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updatePushTokenStatus(boolean r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushTokenStatus$1
            if (r0 == 0) goto L14
            r0 = r8
            ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushTokenStatus$1 r0 = (ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushTokenStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushTokenStatus$1 r0 = new ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushTokenStatus$1
            r0.<init>(r6, r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            boolean r7 = r0.Z$0
            java.lang.Object r2 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.PushInteractor r2 = (ru.tattelecom.intercom.domain.interactors.PushInteractor) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L52
        L3f:
            kotlin.ResultKt.throwOnFailure(r8)
            ru.tattelecom.intercom.data.prefs.PushPrefsSource r8 = r6.prefs
            r0.L$0 = r6
            r0.Z$0 = r7
            r0.label = r4
            java.lang.Object r8 = r8.getPushInfo(r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            r2 = r6
        L52:
            ru.tattelecom.intercom.data.prefs.model.PushInfo r8 = (ru.tattelecom.intercom.data.prefs.model.PushInfo) r8
            ru.tattelecom.intercom.data.prefs.PushPrefsSource r2 = r2.prefs
            java.lang.String r4 = r8.getPushToken()
            java.lang.String r8 = r8.getPushService()
            ru.tattelecom.intercom.data.prefs.model.PushInfo r5 = new ru.tattelecom.intercom.data.prefs.model.PushInfo
            r5.<init>(r8, r4, r7)
            r7 = 0
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r7 = r2.setPushInfo(r5, r0)
            if (r7 != r1) goto L6f
            return r1
        L6f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.PushInteractor.updatePushTokenStatus(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object updatePushToken$default(PushInteractor pushInteractor, String str, String str2, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return pushInteractor.updatePushToken(str, str2, z, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updatePushToken(java.lang.String r6, java.lang.String r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushToken$1
            if (r0 == 0) goto L14
            r0 = r9
            ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushToken$1 r0 = (ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushToken$1 r0 = new ru.tattelecom.intercom.domain.interactors.PushInteractor$updatePushToken$1
            r0.<init>(r5, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L8e
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            boolean r8 = r0.Z$0
            java.lang.Object r6 = r0.L$2
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.PushInteractor r2 = (ru.tattelecom.intercom.domain.interactors.PushInteractor) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5d
        L48:
            kotlin.ResultKt.throwOnFailure(r9)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.Z$0 = r8
            r0.label = r4
            java.lang.Object r9 = r5.getPushInfo(r0)
            if (r9 != r1) goto L5c
            return r1
        L5c:
            r2 = r5
        L5d:
            ru.tattelecom.intercom.data.prefs.model.PushInfo r9 = (ru.tattelecom.intercom.data.prefs.model.PushInfo) r9
            java.lang.String r4 = r9.getPushToken()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r6)
            if (r4 == 0) goto L77
            java.lang.String r9 = r9.getPushService()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r7)
            if (r9 != 0) goto L74
            goto L77
        L74:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L77:
            ru.tattelecom.intercom.data.prefs.model.PushInfo r9 = new ru.tattelecom.intercom.data.prefs.model.PushInfo
            r9.<init>(r7, r6, r8)
            ru.tattelecom.intercom.data.prefs.PushPrefsSource r6 = r2.prefs
            r7 = 0
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r3
            java.lang.Object r6 = r6.setPushInfo(r9, r0)
            if (r6 != r1) goto L8e
            return r1
        L8e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.PushInteractor.updatePushToken(java.lang.String, java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getPushInfo(Continuation<? super PushInfo> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new PushInteractor$getPushInfo$2(this, null), continuation);
    }

    public final Object sendPushToken(Continuation<? super Boolean> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new PushInteractor$sendPushToken$2(this, null), continuation);
    }

    public final Object deletePushToken(Context context, Continuation<Object> continuation) {
        return BuildersKt.withContext(this.dispatchers.getIo(), new PushInteractor$deletePushToken$2(context, this, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startSendPushTokenWorker(Context context, String pushToken, String pushService) {
        WorkManager workManager = WorkManager.getInstance(context);
        ExistingWorkPolicy existingWorkPolicy = ExistingWorkPolicy.REPLACE;
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(SendPushTokenWorker.class);
        Data build = new Data.Builder().putString(SendPushTokenWorker.PUSH_TOKEN, pushToken).putString(SendPushTokenWorker.PUSH_SERVICE, pushService).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        workManager.enqueueUniqueWork("SendingPushToken", existingWorkPolicy, builder.setInputData(build).build());
    }

    public final Object getAndSendPushToken(Context context, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatchers.getIo(), new PushInteractor$getAndSendPushToken$2(this, context, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
