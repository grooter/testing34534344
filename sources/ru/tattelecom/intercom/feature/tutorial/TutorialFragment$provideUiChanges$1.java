package ru.tattelecom.intercom.feature.tutorial;

import android.view.View;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.feature.tutorial.TutorialFragment$provideUiChanges$1;
import ru.tattelecom.intercom.feature.tutorial.databinding.FragmentTutorialBinding;

/* compiled from: TutorialFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.tutorial.TutorialFragment$provideUiChanges$1", f = "TutorialFragment.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class TutorialFragment$provideUiChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TutorialFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TutorialFragment$provideUiChanges$1(TutorialFragment tutorialFragment, Continuation<? super TutorialFragment$provideUiChanges$1> continuation) {
        super(2, continuation);
        this.this$0 = tutorialFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TutorialFragment$provideUiChanges$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TutorialFragment$provideUiChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: TutorialFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "currentTipPosition", "", "emit", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$provideUiChanges$1$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ TutorialFragment this$0;

        AnonymousClass1(TutorialFragment tutorialFragment) {
            this.this$0 = tutorialFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit(((Number) obj).intValue(), (Continuation<? super Unit>) continuation);
        }

        public final Object emit(final int i, Continuation<? super Unit> continuation) {
            FragmentTutorialBinding binding;
            binding = this.this$0.getBinding();
            final TutorialFragment tutorialFragment = this.this$0;
            binding.vpTips.setCurrentItem(i, true);
            binding.ibClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.tutorial.TutorialFragment$provideUiChanges$1$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TutorialFragment$provideUiChanges$1.AnonymousClass1.emit$lambda$1$lambda$0(i, tutorialFragment, view);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$1$lambda$0(int i, TutorialFragment this$0, View view) {
            TutorialViewModel viewModel;
            TutorialViewModel viewModel2;
            TutorialViewModel viewModel3;
            TutorialViewModel viewModel4;
            TutorialViewModel viewModel5;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (i == 0) {
                viewModel = this$0.getViewModel();
                viewModel.reportEvent(90);
            } else if (i == 1) {
                viewModel3 = this$0.getViewModel();
                viewModel3.reportEvent(91);
            } else if (i == 2) {
                viewModel4 = this$0.getViewModel();
                viewModel4.reportEvent(92);
            } else if (i == 3) {
                viewModel5 = this$0.getViewModel();
                viewModel5.reportEvent(108);
            }
            viewModel2 = this$0.getViewModel();
            viewModel2.onBackPressed();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TutorialViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            this.label = 1;
            if (viewModel.getCurrentTipPosition().collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
