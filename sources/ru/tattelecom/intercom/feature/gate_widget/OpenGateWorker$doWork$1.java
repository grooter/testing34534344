package ru.tattelecom.intercom.feature.gate_widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: OpenGateWorker.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.gate_widget.OpenGateWorker", f = "OpenGateWorker.kt", i = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5}, l = {45, 48, 55, 63, 64, 67}, m = "doWork", n = {"this", "$this$doWork_u24lambda_u240", "gateId", "widgetId", "this", "$this$doWork_u24lambda_u240", "gateId", "widgetId", "this", "$this$doWork_u24lambda_u240", "widgetId", "this", "$this$doWork_u24lambda_u240", "widgetId", "$this$doWork_u24lambda_u240", "widgetId"}, s = {"L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "L$0", "I$0"})
/* loaded from: classes6.dex */
final class OpenGateWorker$doWork$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenGateWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OpenGateWorker$doWork$1(OpenGateWorker openGateWorker, Continuation<? super OpenGateWorker$doWork$1> continuation) {
        super(continuation);
        this.this$0 = openGateWorker;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.doWork(this);
    }
}
