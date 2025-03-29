package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: TemporaryCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$onRefreshTemporaryCodes$1", f = "TemporaryCodeViewModel.kt", i = {}, l = {52, 56, 56, 56}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class TemporaryCodeViewModel$onRefreshTemporaryCodes$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableStateFlow<Boolean> $loading;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TemporaryCodeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TemporaryCodeViewModel$onRefreshTemporaryCodes$1(MutableStateFlow<Boolean> mutableStateFlow, TemporaryCodeViewModel temporaryCodeViewModel, Continuation<? super TemporaryCodeViewModel$onRefreshTemporaryCodes$1> continuation) {
        super(2, continuation);
        this.$loading = mutableStateFlow;
        this.this$0 = temporaryCodeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemporaryCodeViewModel$onRefreshTemporaryCodes$1(this.$loading, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemporaryCodeViewModel$onRefreshTemporaryCodes$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b8, code lost:
    
        if (r9 != null) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        r0.setValue(r6);
        r8.$loading.setValue(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bd, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        r6 = r8.this$0.toTemporaryCodeList(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0082, code lost:
    
        if (r9 == null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlin.coroutines.Continuation] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeViewModel$onRefreshTemporaryCodes$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
