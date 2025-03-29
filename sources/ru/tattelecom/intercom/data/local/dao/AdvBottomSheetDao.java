package ru.tattelecom.intercom.data.local.dao;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.dto.AdvThemeDto;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity;

/* compiled from: AdvBottomSheetDao.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0003H'J(\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0097@¢\u0006\u0002\u0010\u000bJ.\u0010\f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/AdvBottomSheetDao;", "", "clearAdvBottomSheet", "", "clearAdvBottomSheetDesign", "createAdvBottomSheetWithDesign", "adv", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetEntity;", "design", "", "Lru/tattelecom/intercom/data/local/dto/AdvThemeDto;", "(Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetEntity;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAdvBottomSheet", "Lkotlinx/coroutines/flow/Flow;", "", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignEntity;", "date", "", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "insertAdvBottomSheet", "entity", "(Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAdvBottomSheetDesign", "(Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AdvBottomSheetDao {
    void clearAdvBottomSheet();

    void clearAdvBottomSheetDesign();

    Object createAdvBottomSheetWithDesign(AdvBottomSheetEntity advBottomSheetEntity, List<AdvThemeDto> list, Continuation<? super Unit> continuation);

    Flow<Map<AdvBottomSheetEntity, AdvBottomSheetDesignEntity>> getAdvBottomSheet(long date, AdvBottomSheetDesignTheme theme);

    Object insertAdvBottomSheet(AdvBottomSheetEntity advBottomSheetEntity, Continuation<? super Long> continuation);

    Object insertAdvBottomSheetDesign(AdvBottomSheetDesignEntity advBottomSheetDesignEntity, Continuation<? super Unit> continuation);

    /* compiled from: AdvBottomSheetDao.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Removed duplicated region for block: B:14:0x007b  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object createAdvBottomSheetWithDesign(ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao r6, ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity r7, java.util.List<ru.tattelecom.intercom.data.local.dto.AdvThemeDto> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                boolean r0 = r9 instanceof ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao$createAdvBottomSheetWithDesign$1
                if (r0 == 0) goto L14
                r0 = r9
                ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao$createAdvBottomSheetWithDesign$1 r0 = (ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao$createAdvBottomSheetWithDesign$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L19
            L14:
                ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao$createAdvBottomSheetWithDesign$1 r0 = new ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao$createAdvBottomSheetWithDesign$1
                r0.<init>(r9)
            L19:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L4c
                if (r2 == r4) goto L3f
                if (r2 != r3) goto L37
                long r6 = r0.J$0
                java.lang.Object r8 = r0.L$1
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r2 = r0.L$0
                ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao r2 = (ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao) r2
                kotlin.ResultKt.throwOnFailure(r9)
                goto L75
            L37:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3f:
                java.lang.Object r6 = r0.L$1
                r8 = r6
                java.util.List r8 = (java.util.List) r8
                java.lang.Object r6 = r0.L$0
                ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao r6 = (ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao) r6
                kotlin.ResultKt.throwOnFailure(r9)
                goto L64
            L4c:
                kotlin.ResultKt.throwOnFailure(r9)
                r6.clearAdvBottomSheetDesign()
                r6.clearAdvBottomSheet()
                if (r7 == 0) goto L94
                r0.L$0 = r6
                r0.L$1 = r8
                r0.label = r4
                java.lang.Object r9 = r6.insertAdvBottomSheet(r7, r0)
                if (r9 != r1) goto L64
                return r1
            L64:
                java.lang.Number r9 = (java.lang.Number) r9
                long r4 = r9.longValue()
                if (r8 == 0) goto L94
                java.lang.Iterable r8 = (java.lang.Iterable) r8
                java.util.Iterator r7 = r8.iterator()
                r2 = r6
                r8 = r7
                r6 = r4
            L75:
                boolean r9 = r8.hasNext()
                if (r9 == 0) goto L94
                java.lang.Object r9 = r8.next()
                ru.tattelecom.intercom.data.local.dto.AdvThemeDto r9 = (ru.tattelecom.intercom.data.local.dto.AdvThemeDto) r9
                ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignEntity r9 = ru.tattelecom.intercom.data.local.dto.AdvThemeDtoKt.toEntity(r9, r6)
                r0.L$0 = r2
                r0.L$1 = r8
                r0.J$0 = r6
                r0.label = r3
                java.lang.Object r9 = r2.insertAdvBottomSheetDesign(r9, r0)
                if (r9 != r1) goto L75
                return r1
            L94:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao.DefaultImpls.createAdvBottomSheetWithDesign(ru.tattelecom.intercom.data.local.dao.AdvBottomSheetDao, ru.tattelecom.intercom.data.local.entity.AdvBottomSheetEntity, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }
}
