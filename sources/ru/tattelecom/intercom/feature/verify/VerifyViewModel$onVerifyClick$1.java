package ru.tattelecom.intercom.feature.verify;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: VerifyViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.verify.VerifyViewModel$onVerifyClick$1", f = "VerifyViewModel.kt", i = {}, l = {81, 86, 87, 89, 90, 91, 102, 104, 109}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VerifyViewModel$onVerifyClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $deviceCode;
    final /* synthetic */ int $os;
    int label;
    final /* synthetic */ VerifyViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VerifyViewModel$onVerifyClick$1(VerifyViewModel verifyViewModel, int i, String str, Context context, Continuation<? super VerifyViewModel$onVerifyClick$1> continuation) {
        super(2, continuation);
        this.this$0 = verifyViewModel;
        this.$os = i;
        this.$deviceCode = str;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VerifyViewModel$onVerifyClick$1(this.this$0, this.$os, this.$deviceCode, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VerifyViewModel$onVerifyClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x012e, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) "403", false, 2, (java.lang.Object) null) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015c, code lost:
    
        if (kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) "400", false, 2, (java.lang.Object) null) != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x010d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.verify.VerifyViewModel$onVerifyClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
