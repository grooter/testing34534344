package ru.tattelecom.intercom.feature.home;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: HomeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeViewModel$generateTemporaryCodeButtonClick$1", f = "HomeViewModel.kt", i = {2}, l = {464, 466, 470, 472, 479, 484}, m = "invokeSuspend", n = {"availableApartment"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class HomeViewModel$generateTemporaryCodeButtonClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HomeStream $stream;
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeViewModel$generateTemporaryCodeButtonClick$1(HomeViewModel homeViewModel, HomeStream homeStream, Continuation<? super HomeViewModel$generateTemporaryCodeButtonClick$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
        this.$stream = homeStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$generateTemporaryCodeButtonClick$1(this.this$0, this.$stream, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$generateTemporaryCodeButtonClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0138, code lost:
    
        if (r10 != null) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00de A[Catch: all -> 0x001e, Exception -> 0x011b, TRY_LEAVE, TryCatch #0 {Exception -> 0x011b, blocks: (B:14:0x0021, B:18:0x002a, B:19:0x00da, B:21:0x00de, B:27:0x00ae, B:29:0x00b6, B:30:0x00c1), top: B:2:0x0009, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ae A[Catch: all -> 0x001e, Exception -> 0x011b, TRY_ENTER, TryCatch #0 {Exception -> 0x011b, blocks: (B:14:0x0021, B:18:0x002a, B:19:0x00da, B:21:0x00de, B:27:0x00ae, B:29:0x00b6, B:30:0x00c1), top: B:2:0x0009, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008d A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.home.HomeViewModel$generateTemporaryCodeButtonClick$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
