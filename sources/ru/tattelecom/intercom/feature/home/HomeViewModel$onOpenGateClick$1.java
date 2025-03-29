package ru.tattelecom.intercom.feature.home;

import com.huawei.location.lite.common.http.exception.ErrorCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$onOpenGateClick$1", f = "HomeViewModel.kt", i = {}, l = {396, 397, ErrorCode.HTTP_PAYMENT_REQUIRED, 401, ErrorCode.HTTP_BAD_METHOD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeViewModel$onOpenGateClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $gateId;
    final /* synthetic */ String $intercomLogin;
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$onOpenGateClick$1(Integer num, String str, HomeViewModel homeViewModel, Continuation<? super HomeViewModel$onOpenGateClick$1> continuation) {
        super(2, continuation);
        this.$gateId = num;
        this.$intercomLogin = str;
        this.this$0 = homeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$onOpenGateClick$1(this.$gateId, this.$intercomLogin, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$onOpenGateClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00eb, code lost:
    
        if (r11 == null) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0085, code lost:
    
        r0 = r10.this$0;
        r11.intValue();
        r0.setGateLoading(false, r11.intValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0083, code lost:
    
        if (r11 != null) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$onOpenGateClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
