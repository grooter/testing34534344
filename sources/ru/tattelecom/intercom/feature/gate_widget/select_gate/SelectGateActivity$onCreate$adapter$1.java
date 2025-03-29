package ru.tattelecom.intercom.feature.gate_widget.select_gate;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: SelectGateActivity.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class SelectGateActivity$onCreate$adapter$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    SelectGateActivity$onCreate$adapter$1(Object obj) {
        super(1, obj, SelectGateViewModel.class, "bindWidgetToGate", "bindWidgetToGate(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((SelectGateViewModel) this.receiver).bindWidgetToGate(i);
    }
}
