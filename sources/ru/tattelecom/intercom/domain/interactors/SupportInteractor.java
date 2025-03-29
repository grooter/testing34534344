package ru.tattelecom.intercom.domain.interactors;

import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.data.local.dao.SupportContactDao;
import ru.tattelecom.intercom.data.prefs.SupportPrefsSource;
import ru.tattelecom.intercom.data.remote.source.SupportRemote;

/* compiled from: SupportInteractor.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000fJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011J\u000e\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/domain/interactors/SupportInteractor;", "", "dao", "Lru/tattelecom/intercom/data/local/dao/SupportContactDao;", "remote", "Lru/tattelecom/intercom/data/remote/source/SupportRemote;", "prefs", "Lru/tattelecom/intercom/data/prefs/SupportPrefsSource;", "(Lru/tattelecom/intercom/data/local/dao/SupportContactDao;Lru/tattelecom/intercom/data/remote/source/SupportRemote;Lru/tattelecom/intercom/data/prefs/SupportPrefsSource;)V", "getContacts", "Lru/tattelecom/intercom/domain/model/SupportContactDto;", AttributionReporter.APP_VERSION, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContactsWithAuth", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPolicyFlow", "Lkotlinx/coroutines/flow/StateFlow;", "updatePolicy", "", "Companion", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SupportInteractor {
    private static final long INTERVAL = 60000;
    private final SupportContactDao dao;
    private final SupportPrefsSource prefs;
    private final SupportRemote remote;

    public SupportInteractor(SupportContactDao dao, SupportRemote remote, SupportPrefsSource prefs) {
        Intrinsics.checkNotNullParameter(dao, "dao");
        Intrinsics.checkNotNullParameter(remote, "remote");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.dao = dao;
        this.remote = remote;
        this.prefs = prefs;
    }

    public final StateFlow<String> getPolicyFlow() {
        return FlowKt.asStateFlow(this.prefs.getPolicyFlow());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(8:5|6|7|(1:(2:10|11)(2:19|20))(3:21|22|(1:24)(1:25))|12|(1:14)|16|17))|28|6|7|(0)(0)|12|(0)|16|17) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0055, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        android.util.Log.e("GET_POLICY", r5.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[Catch: Exception -> 0x0055, TRY_LEAVE, TryCatch #0 {Exception -> 0x0055, blocks: (B:11:0x002a, B:12:0x0047, B:14:0x004f, B:22:0x0039), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updatePolicy(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof ru.tattelecom.intercom.domain.interactors.SupportInteractor$updatePolicy$1
            if (r0 == 0) goto L14
            r0 = r5
            ru.tattelecom.intercom.domain.interactors.SupportInteractor$updatePolicy$1 r0 = (ru.tattelecom.intercom.domain.interactors.SupportInteractor$updatePolicy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            ru.tattelecom.intercom.domain.interactors.SupportInteractor$updatePolicy$1 r0 = new ru.tattelecom.intercom.domain.interactors.SupportInteractor$updatePolicy$1
            r0.<init>(r4, r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            ru.tattelecom.intercom.domain.interactors.SupportInteractor r0 = (ru.tattelecom.intercom.domain.interactors.SupportInteractor) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L55
            goto L47
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            ru.tattelecom.intercom.data.remote.source.SupportRemote r5 = r4.remote     // Catch: java.lang.Exception -> L55
            r0.L$0 = r4     // Catch: java.lang.Exception -> L55
            r0.label = r3     // Catch: java.lang.Exception -> L55
            java.lang.Object r5 = r5.getPolicy(r0)     // Catch: java.lang.Exception -> L55
            if (r5 != r1) goto L46
            return r1
        L46:
            r0 = r4
        L47:
            ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse r5 = (ru.tattelecom.intercom.data.remote.model.responses.PolicyResponse) r5     // Catch: java.lang.Exception -> L55
            java.lang.String r5 = r5.getUrl()     // Catch: java.lang.Exception -> L55
            if (r5 == 0) goto L5f
            ru.tattelecom.intercom.data.prefs.SupportPrefsSource r0 = r0.prefs     // Catch: java.lang.Exception -> L55
            r0.setPolicy(r5)     // Catch: java.lang.Exception -> L55
            goto L5f
        L55:
            r5 = move-exception
            java.lang.String r0 = "GET_POLICY"
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
        L5f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.SupportInteractor.updatePolicy(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(1:(5:12|13|(1:15)|16|17)(2:19|20))(7:21|22|23|24|(1:26)|27|(1:29)(5:30|13|(0)|16|17)))(2:32|33))(8:38|39|40|(1:42)|43|(5:48|24|(0)|27|(0)(0))|49|(1:51)(1:52))|34|(1:36)(6:37|23|24|(0)|27|(0)(0))))|58|6|7|(0)(0)|34|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0061, code lost:
    
        r13 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getContacts(java.lang.String r13, kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.domain.model.SupportContactDto> r14) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.SupportInteractor.getContacts(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(1:(5:12|13|(1:15)|16|17)(2:19|20))(7:21|22|23|24|(1:26)|27|(1:29)(5:30|13|(0)|16|17)))(2:32|33))(8:38|39|40|(1:42)|43|(5:48|24|(0)|27|(0)(0))|49|(1:51)(1:52))|34|(1:36)(6:37|23|24|(0)|27|(0)(0))))|58|6|7|(0)(0)|34|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0061, code lost:
    
        r13 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getContactsWithAuth(kotlin.coroutines.Continuation<? super ru.tattelecom.intercom.domain.model.SupportContactDto> r13) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.domain.interactors.SupportInteractor.getContactsWithAuth(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
