package ru.tattelecom.intercom.feature.gate_widget.select_gate;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;
import ru.tattelecom.intercom.domain.interactors.GateInteractor;
import ru.tattelecom.intercom.feature.gate_widget.R;

/* compiled from: SelectGateViewModel.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/select_gate/SelectGateViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "gateInteractor", "Lru/tattelecom/intercom/domain/interactors/GateInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/GateInteractor;)V", "_eventFinishGateSelecting", "Lkotlinx/coroutines/channels/Channel;", "", "_eventProvideWidgetInfo", "eventFinishGateSelecting", "Lkotlinx/coroutines/flow/Flow;", "getEventFinishGateSelecting", "()Lkotlinx/coroutines/flow/Flow;", "eventProvideWidgetInfo", "getEventProvideWidgetInfo", "gates", "", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "getGates", "widgetId", "bindWidgetToGate", "", "gateId", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SelectGateViewModel extends ViewModel {
    private final Channel<Integer> _eventFinishGateSelecting;
    private final Channel<Integer> _eventProvideWidgetInfo;
    private final Flow<Integer> eventFinishGateSelecting;
    private final Flow<Integer> eventProvideWidgetInfo;
    private final GateInteractor gateInteractor;
    private final Flow<List<IntercomEntity>> gates;
    private final int widgetId;

    public SelectGateViewModel(SavedStateHandle handle, GateInteractor gateInteractor) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(gateInteractor, "gateInteractor");
        this.gateInteractor = gateInteractor;
        Integer num = (Integer) handle.get("appWidgetId");
        int intValue = num != null ? num.intValue() : 0;
        this.widgetId = intValue;
        Channel<Integer> Channel$default = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventFinishGateSelecting = Channel$default;
        this.eventFinishGateSelecting = FlowKt.receiveAsFlow(Channel$default);
        Channel<Integer> Channel$default2 = ChannelKt.Channel$default(-2, null, null, 6, null);
        this._eventProvideWidgetInfo = Channel$default2;
        this.eventProvideWidgetInfo = FlowKt.receiveAsFlow(Channel$default2);
        final Flow<List<IntercomEntity>> gates = gateInteractor.getGates();
        this.gates = (Flow) new Flow<List<? extends IntercomEntity>>() { // from class: ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ SelectGateViewModel this$0;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2", f = "SelectGateViewModel.kt", i = {0, 0}, l = {221, 219}, m = "emit", n = {"this", "it"}, s = {"L$0", "L$2"})
                /* renamed from: ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, SelectGateViewModel selectGateViewModel) {
                    this.$this_unsafeFlow = flowCollector;
                    this.this$0 = selectGateViewModel;
                }

                /* JADX WARN: Removed duplicated region for block: B:22:0x008f  */
                /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x00b0 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                    /*
                        r6 = this;
                        boolean r0 = r8 instanceof ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r8
                        ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2$1 r0 = (ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r8 = r0.label
                        int r8 = r8 - r2
                        r0.label = r8
                        goto L19
                    L14:
                        ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2$1 r0 = new ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2$1
                        r0.<init>(r8)
                    L19:
                        java.lang.Object r8 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L46
                        if (r2 == r4) goto L36
                        if (r2 != r3) goto L2e
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto Lb1
                    L2e:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L36:
                        java.lang.Object r7 = r0.L$2
                        java.util.List r7 = (java.util.List) r7
                        java.lang.Object r2 = r0.L$1
                        kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                        java.lang.Object r5 = r0.L$0
                        ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1$2 r5 = (ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1.AnonymousClass2) r5
                        kotlin.ResultKt.throwOnFailure(r8)
                        goto L79
                    L46:
                        kotlin.ResultKt.throwOnFailure(r8)
                        kotlinx.coroutines.flow.FlowCollector r2 = r6.$this_unsafeFlow
                        r8 = r0
                        kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                        java.util.List r7 = (java.util.List) r7
                        r8 = r7
                        java.util.Collection r8 = (java.util.Collection) r8
                        if (r8 == 0) goto L5e
                        boolean r8 = r8.isEmpty()
                        if (r8 == 0) goto L5c
                        goto L5e
                    L5c:
                        r5 = r6
                        goto L79
                    L5e:
                        ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel r8 = r6.this$0
                        kotlinx.coroutines.channels.Channel r8 = ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel.access$get_eventFinishGateSelecting$p(r8)
                        int r5 = ru.tattelecom.intercom.feature.gate_widget.R.string.no_gates
                        java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                        r0.L$0 = r6
                        r0.L$1 = r2
                        r0.L$2 = r7
                        r0.label = r4
                        java.lang.Object r8 = r8.send(r5, r0)
                        if (r8 != r1) goto L5c
                        return r1
                    L79:
                        if (r7 == 0) goto La1
                        int r8 = r7.size()
                        if (r8 != r4) goto La1
                        ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel r8 = r5.this$0
                        java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r7)
                        ru.tattelecom.intercom.data.local.entity.IntercomEntity r4 = (ru.tattelecom.intercom.data.local.entity.IntercomEntity) r4
                        java.lang.Integer r4 = r4.getGateId()
                        if (r4 == 0) goto L94
                        int r4 = r4.intValue()
                        goto L9e
                    L94:
                        java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r7)
                        ru.tattelecom.intercom.data.local.entity.IntercomEntity r4 = (ru.tattelecom.intercom.data.local.entity.IntercomEntity) r4
                        int r4 = r4.getId()
                    L9e:
                        r8.bindWidgetToGate(r4)
                    La1:
                        r8 = 0
                        r0.L$0 = r8
                        r0.L$1 = r8
                        r0.L$2 = r8
                        r0.label = r3
                        java.lang.Object r7 = r2.emit(r7, r0)
                        if (r7 != r1) goto Lb1
                        return r1
                    Lb1:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends IntercomEntity>> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        };
        if (intValue == 0) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    public final Flow<Integer> getEventFinishGateSelecting() {
        return this.eventFinishGateSelecting;
    }

    public final Flow<Integer> getEventProvideWidgetInfo() {
        return this.eventProvideWidgetInfo;
    }

    public final Flow<List<IntercomEntity>> getGates() {
        return this.gates;
    }

    /* compiled from: SelectGateViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$1", f = "SelectGateViewModel.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.gate_widget.select_gate.SelectGateViewModel$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SelectGateViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (SelectGateViewModel.this._eventFinishGateSelecting.send(Boxing.boxInt(R.string.widget_create_error), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void bindWidgetToGate(int gateId) {
        this.gateInteractor.bindWidgetIdToGateId(this.widgetId, gateId);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SelectGateViewModel$bindWidgetToGate$1(this, null), 3, null);
    }
}
