package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.data.local.entity.CallEntity;
import ru.tattelecom.intercom.data.local.entity.CallWithIntercomAndApartment;
import ru.tattelecom.intercom.data.local.entity.CodePassLogEntity;
import ru.tattelecom.intercom.data.local.entity.CodePassLogWithIntercomAndApartment;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.data.local.entity.KeyLogEntity;
import ru.tattelecom.intercom.data.local.entity.KeyLogsWithIntercomAndApartment;

/* compiled from: EventDao.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H§@¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u000fJ$\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0005H§@¢\u0006\u0002\u0010\u0007J$\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H§@¢\u0006\u0002\u0010\u0007J$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00170\u0005H§@¢\u0006\u0002\u0010\u0007J\u001e\u0010\u001a\u001a\u00020\u00032\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0097@¢\u0006\u0002\u0010\u0007J\u001e\u0010\u001c\u001a\u00020\u00032\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0005H\u0097@¢\u0006\u0002\u0010\u0007¨\u0006\u001d"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/EventDao;", "", "addCallLog", "", "callLogs", "", "Lru/tattelecom/intercom/data/local/entity/CallEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addCodePassLog", "codePassLogs", "Lru/tattelecom/intercom/data/local/entity/CodePassLogEntity;", "addKeyLog", "keyLogs", "Lru/tattelecom/intercom/data/local/entity/KeyLogEntity;", "clearCallLogs", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearKeyLogs", "getCallLogs", "Lru/tattelecom/intercom/data/local/entity/CallWithIntercomAndApartment;", "ids", "", "getCodePassLogs", "Lru/tattelecom/intercom/data/local/entity/CodePassLogWithIntercomAndApartment;", "", "getKeyLogs", "Lru/tattelecom/intercom/data/local/entity/KeyLogsWithIntercomAndApartment;", "refreshCallLogs", EntitiesKt.CALLS_TABLE, "refreshKeyLogs", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface EventDao {
    Object addCallLog(List<CallEntity> list, Continuation<? super Unit> continuation);

    Object addCodePassLog(List<CodePassLogEntity> list, Continuation<? super Unit> continuation);

    Object addKeyLog(List<KeyLogEntity> list, Continuation<? super Unit> continuation);

    Object clearCallLogs(Continuation<? super Unit> continuation);

    Object clearKeyLogs(Continuation<? super Unit> continuation);

    Object getCallLogs(List<Integer> list, Continuation<? super List<CallWithIntercomAndApartment>> continuation);

    Object getCodePassLogs(List<String> list, Continuation<? super List<CodePassLogWithIntercomAndApartment>> continuation);

    Object getKeyLogs(List<String> list, Continuation<? super List<KeyLogsWithIntercomAndApartment>> continuation);

    Object refreshCallLogs(List<CallEntity> list, Continuation<? super Unit> continuation);

    Object refreshKeyLogs(List<KeyLogEntity> list, Continuation<? super Unit> continuation);

    /* compiled from: EventDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object refreshCallLogs(ru.tattelecom.intercom.data.local.dao.EventDao r5, java.util.List<ru.tattelecom.intercom.data.local.entity.CallEntity> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                boolean r0 = r7 instanceof ru.tattelecom.intercom.data.local.dao.EventDao$refreshCallLogs$1
                if (r0 == 0) goto L14
                r0 = r7
                ru.tattelecom.intercom.data.local.dao.EventDao$refreshCallLogs$1 r0 = (ru.tattelecom.intercom.data.local.dao.EventDao$refreshCallLogs$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                ru.tattelecom.intercom.data.local.dao.EventDao$refreshCallLogs$1 r0 = new ru.tattelecom.intercom.data.local.dao.EventDao$refreshCallLogs$1
                r0.<init>(r7)
            L19:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L42
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r7)
                goto L62
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                java.lang.Object r5 = r0.L$1
                r6 = r5
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r5 = r0.L$0
                ru.tattelecom.intercom.data.local.dao.EventDao r5 = (ru.tattelecom.intercom.data.local.dao.EventDao) r5
                kotlin.ResultKt.throwOnFailure(r7)
                goto L52
            L42:
                kotlin.ResultKt.throwOnFailure(r7)
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r4
                java.lang.Object r7 = r5.clearCallLogs(r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                if (r6 == 0) goto L62
                r7 = 0
                r0.L$0 = r7
                r0.L$1 = r7
                r0.label = r3
                java.lang.Object r5 = r5.addCallLog(r6, r0)
                if (r5 != r1) goto L62
                return r1
            L62:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.EventDao.DefaultImpls.refreshCallLogs(ru.tattelecom.intercom.data.local.dao.EventDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object refreshKeyLogs(ru.tattelecom.intercom.data.local.dao.EventDao r5, java.util.List<ru.tattelecom.intercom.data.local.entity.KeyLogEntity> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                boolean r0 = r7 instanceof ru.tattelecom.intercom.data.local.dao.EventDao$refreshKeyLogs$1
                if (r0 == 0) goto L14
                r0 = r7
                ru.tattelecom.intercom.data.local.dao.EventDao$refreshKeyLogs$1 r0 = (ru.tattelecom.intercom.data.local.dao.EventDao$refreshKeyLogs$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                ru.tattelecom.intercom.data.local.dao.EventDao$refreshKeyLogs$1 r0 = new ru.tattelecom.intercom.data.local.dao.EventDao$refreshKeyLogs$1
                r0.<init>(r7)
            L19:
                java.lang.Object r7 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L42
                if (r2 == r4) goto L35
                if (r2 != r3) goto L2d
                kotlin.ResultKt.throwOnFailure(r7)
                goto L62
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                java.lang.Object r5 = r0.L$1
                r6 = r5
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r5 = r0.L$0
                ru.tattelecom.intercom.data.local.dao.EventDao r5 = (ru.tattelecom.intercom.data.local.dao.EventDao) r5
                kotlin.ResultKt.throwOnFailure(r7)
                goto L52
            L42:
                kotlin.ResultKt.throwOnFailure(r7)
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r4
                java.lang.Object r7 = r5.clearKeyLogs(r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                if (r6 == 0) goto L62
                r7 = 0
                r0.L$0 = r7
                r0.L$1 = r7
                r0.label = r3
                java.lang.Object r5 = r5.addKeyLog(r6, r0)
                if (r5 != r1) goto L62
                return r1
            L62:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.EventDao.DefaultImpls.refreshKeyLogs(ru.tattelecom.intercom.data.local.dao.EventDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
