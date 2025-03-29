package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TemporaryCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$generateCode$1", f = "TemporaryCodeViewModel.kt", i = {}, l = {93, 100, 102, 113, 110, 113, 113, 116}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class TemporaryCodeViewModel$generateCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TemporaryCodeItem $apartment;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TemporaryCodeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TemporaryCodeViewModel$generateCode$1(TemporaryCodeViewModel temporaryCodeViewModel, TemporaryCodeItem temporaryCodeItem, Continuation<? super TemporaryCodeViewModel$generateCode$1> continuation) {
        super(2, continuation);
        this.this$0 = temporaryCodeViewModel;
        this.$apartment = temporaryCodeItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemporaryCodeViewModel$generateCode$1(this.this$0, this.$apartment, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemporaryCodeViewModel$generateCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0155, code lost:
    
        if (r12 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0115, code lost:
    
        r0.setValue(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x010f, code lost:
    
        r3 = r11.this$0.toTemporaryCodeList(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x010d, code lost:
    
        if (r12 == null) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c5 A[Catch: all -> 0x0046, Exception -> 0x011a, TRY_LEAVE, TryCatch #0 {Exception -> 0x011a, blocks: (B:29:0x003c, B:34:0x0041, B:35:0x00c1, B:37:0x00c5, B:43:0x007e, B:45:0x0092, B:46:0x00a5), top: B:2:0x0008, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007e A[Catch: all -> 0x0046, Exception -> 0x011a, TRY_ENTER, TryCatch #0 {Exception -> 0x011a, blocks: (B:29:0x003c, B:34:0x0041, B:35:0x00c1, B:37:0x00c5, B:43:0x007e, B:45:0x0092, B:46:0x00a5), top: B:2:0x0008, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0185  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$generateCode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
