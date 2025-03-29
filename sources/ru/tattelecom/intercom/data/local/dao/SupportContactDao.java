package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.data.local.entity.SupportContactEntity;
import ru.tattelecom.intercom.data.local.entity.SupportWithAuthContactEntity;

/* compiled from: SupportContactDao.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0097@¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\tJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\tJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H§@¢\u0006\u0002\u0010\tJ\u001c\u0010\u000e\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u000f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H§@¢\u0006\u0002\u0010\u0007J\u001c\u0010\u0010\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H\u0097@¢\u0006\u0002\u0010\u0007¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/SupportContactDao;", "", "allUpdate", "", "contacts", "", "Lru/tattelecom/intercom/data/local/entity/SupportContactEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clear", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearContactsWithAuth", "getContact", "getContactsWithAuth", "Lru/tattelecom/intercom/data/local/entity/SupportWithAuthContactEntity;", "insert", "insertContactsWithAuth", "updateContactsWithAuth", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SupportContactDao {
    Object allUpdate(List<SupportContactEntity> list, Continuation<? super Unit> continuation);

    Object clear(Continuation<? super Unit> continuation);

    Object clearContactsWithAuth(Continuation<? super Unit> continuation);

    Object getContact(Continuation<? super List<SupportContactEntity>> continuation);

    Object getContactsWithAuth(Continuation<? super List<SupportWithAuthContactEntity>> continuation);

    Object insert(List<SupportContactEntity> list, Continuation<? super Unit> continuation);

    Object insertContactsWithAuth(List<SupportWithAuthContactEntity> list, Continuation<? super Unit> continuation);

    Object updateContactsWithAuth(List<SupportWithAuthContactEntity> list, Continuation<? super Unit> continuation);

    /* compiled from: SupportContactDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object allUpdate(ru.tattelecom.intercom.data.local.dao.SupportContactDao r5, java.util.List<ru.tattelecom.intercom.data.local.entity.SupportContactEntity> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                boolean r0 = r7 instanceof ru.tattelecom.intercom.data.local.dao.SupportContactDao$allUpdate$1
                if (r0 == 0) goto L14
                r0 = r7
                ru.tattelecom.intercom.data.local.dao.SupportContactDao$allUpdate$1 r0 = (ru.tattelecom.intercom.data.local.dao.SupportContactDao$allUpdate$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                ru.tattelecom.intercom.data.local.dao.SupportContactDao$allUpdate$1 r0 = new ru.tattelecom.intercom.data.local.dao.SupportContactDao$allUpdate$1
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
                goto L60
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
                ru.tattelecom.intercom.data.local.dao.SupportContactDao r5 = (ru.tattelecom.intercom.data.local.dao.SupportContactDao) r5
                kotlin.ResultKt.throwOnFailure(r7)
                goto L52
            L42:
                kotlin.ResultKt.throwOnFailure(r7)
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r4
                java.lang.Object r7 = r5.clear(r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                r7 = 0
                r0.L$0 = r7
                r0.L$1 = r7
                r0.label = r3
                java.lang.Object r5 = r5.insert(r6, r0)
                if (r5 != r1) goto L60
                return r1
            L60:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.SupportContactDao.DefaultImpls.allUpdate(ru.tattelecom.intercom.data.local.dao.SupportContactDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object updateContactsWithAuth(ru.tattelecom.intercom.data.local.dao.SupportContactDao r5, java.util.List<ru.tattelecom.intercom.data.local.entity.SupportWithAuthContactEntity> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                boolean r0 = r7 instanceof ru.tattelecom.intercom.data.local.dao.SupportContactDao$updateContactsWithAuth$1
                if (r0 == 0) goto L14
                r0 = r7
                ru.tattelecom.intercom.data.local.dao.SupportContactDao$updateContactsWithAuth$1 r0 = (ru.tattelecom.intercom.data.local.dao.SupportContactDao$updateContactsWithAuth$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r7 = r0.label
                int r7 = r7 - r2
                r0.label = r7
                goto L19
            L14:
                ru.tattelecom.intercom.data.local.dao.SupportContactDao$updateContactsWithAuth$1 r0 = new ru.tattelecom.intercom.data.local.dao.SupportContactDao$updateContactsWithAuth$1
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
                goto L60
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
                ru.tattelecom.intercom.data.local.dao.SupportContactDao r5 = (ru.tattelecom.intercom.data.local.dao.SupportContactDao) r5
                kotlin.ResultKt.throwOnFailure(r7)
                goto L52
            L42:
                kotlin.ResultKt.throwOnFailure(r7)
                r0.L$0 = r5
                r0.L$1 = r6
                r0.label = r4
                java.lang.Object r7 = r5.clearContactsWithAuth(r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                r7 = 0
                r0.L$0 = r7
                r0.L$1 = r7
                r0.label = r3
                java.lang.Object r5 = r5.insertContactsWithAuth(r6, r0)
                if (r5 != r1) goto L60
                return r1
            L60:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.SupportContactDao.DefaultImpls.updateContactsWithAuth(ru.tattelecom.intercom.data.local.dao.SupportContactDao, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
