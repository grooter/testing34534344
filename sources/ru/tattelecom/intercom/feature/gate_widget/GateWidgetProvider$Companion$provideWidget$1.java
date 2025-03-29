package ru.tattelecom.intercom.feature.gate_widget;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GateWidgetProvider.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.gate_widget.GateWidgetProvider$Companion$provideWidget$1", f = "GateWidgetProvider.kt", i = {1, 1}, l = {39, 53}, m = "invokeSuspend", n = {"gate", "openAppIntent"}, s = {"L$0", "L$1"})
/* loaded from: classes6.dex */
final class GateWidgetProvider$Companion$provideWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ int $progressVisibility;
    final /* synthetic */ int $widgetId;
    Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GateWidgetProvider$Companion$provideWidget$1(int i, Context context, int i2, Continuation<? super GateWidgetProvider$Companion$provideWidget$1> continuation) {
        super(2, continuation);
        this.$widgetId = i;
        this.$context = context;
        this.$progressVisibility = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GateWidgetProvider$Companion$provideWidget$1(this.$widgetId, this.$context, this.$progressVisibility, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GateWidgetProvider$Companion$provideWidget$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x009f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.gate_widget.GateWidgetProvider$Companion$provideWidget$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
