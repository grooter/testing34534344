package ru.tattelecom.intercom.feature.home;

import androidx.core.view.GravityCompat;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.customview.Tooltip;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.feature.home.databinding.ItemStreamBinding;

/* compiled from: HomeListAdapter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeListAdapter$bind$4", f = "HomeListAdapter.kt", i = {0}, l = {394}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class HomeListAdapter$bind$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isToolTipRequires;
    final /* synthetic */ Function1<ConfigInteractor.ToolTips, Unit> $onCloseToolTip;
    final /* synthetic */ int $position;
    final /* synthetic */ Function1<Integer, Unit> $scrollToPosition;
    final /* synthetic */ ItemStreamBinding $this_bind;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    final /* synthetic */ HomeListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeListAdapter$bind$4(HomeListAdapter homeListAdapter, boolean z, Function1<? super Integer, Unit> function1, int i, ItemStreamBinding itemStreamBinding, Function1<? super ConfigInteractor.ToolTips, Unit> function12, Continuation<? super HomeListAdapter$bind$4> continuation) {
        super(2, continuation);
        this.this$0 = homeListAdapter;
        this.$isToolTipRequires = z;
        this.$scrollToPosition = function1;
        this.$position = i;
        this.$this_bind = itemStreamBinding;
        this.$onCloseToolTip = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeListAdapter$bind$4(this.this$0, this.$isToolTipRequires, this.$scrollToPosition, this.$position, this.$this_bind, this.$onCloseToolTip, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeListAdapter$bind$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        boolean z;
        HomeListAdapter homeListAdapter;
        Function1<Integer, Unit> function1;
        ItemStreamBinding itemStreamBinding;
        final Function1<ConfigInteractor.ToolTips, Unit> function12;
        int i;
        Tooltip tooltip;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Tooltip tooltip2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.toolTipMutex;
            z = this.$isToolTipRequires;
            homeListAdapter = this.this$0;
            function1 = this.$scrollToPosition;
            int i3 = this.$position;
            itemStreamBinding = this.$this_bind;
            function12 = this.$onCloseToolTip;
            this.L$0 = mutex;
            this.L$1 = homeListAdapter;
            this.L$2 = function1;
            this.L$3 = itemStreamBinding;
            this.L$4 = function12;
            this.Z$0 = z;
            this.I$0 = i3;
            this.label = 1;
            if (mutex.lock(null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = i3;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            z = this.Z$0;
            function12 = (Function1) this.L$4;
            itemStreamBinding = (ItemStreamBinding) this.L$3;
            function1 = (Function1) this.L$2;
            homeListAdapter = (HomeListAdapter) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (z) {
            try {
                tooltip = homeListAdapter.tooltip;
                if (tooltip == null) {
                    mutableStateFlow = homeListAdapter.isToolTipShownFlow;
                    if (!((Boolean) mutableStateFlow.getValue()).booleanValue()) {
                        mutableStateFlow2 = homeListAdapter.isToolTipShownFlow;
                        mutableStateFlow2.setValue(Boxing.boxBoolean(true));
                        if (function1 != null) {
                            function1.invoke(Boxing.boxInt(i));
                        }
                        MaterialButton btnGenerateTemporaryCode = itemStreamBinding.btnGenerateTemporaryCode;
                        Intrinsics.checkNotNullExpressionValue(btnGenerateTemporaryCode, "btnGenerateTemporaryCode");
                        Tooltip.TooltipBuilder tooltipBuilder = new Tooltip.TooltipBuilder(btnGenerateTemporaryCode);
                        String string = itemStreamBinding.getRoot().getContext().getResources().getString(R.string.tooltip_generate_code);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        homeListAdapter.tooltip = tooltipBuilder.setText(string).setAlignment(Tooltip.Alignment.TOP).setGravity(GravityCompat.START).setArrowGravity(GravityCompat.START).isOutsideTouchable(true).setOnCloseListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$bind$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                function12.invoke(ConfigInteractor.ToolTips.BTN_GENERATE_CODE);
                            }
                        }).build();
                        tooltip2 = homeListAdapter.tooltip;
                        Intrinsics.checkNotNull(tooltip2);
                        Tooltip.showAtTop$default(tooltip2, 0, ExtensionsKt.getDp(-24), 1, null);
                    }
                }
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
        Unit unit = Unit.INSTANCE;
        mutex.unlock(null);
        return Unit.INSTANCE;
    }
}
