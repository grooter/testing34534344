package ru.tattelecom.feature.call_history;

import androidx.core.os.BundleKt;
import androidx.navigation.fragment.FragmentKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;

/* compiled from: EventHistoryFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.feature.call_history.EventHistoryFragment$provideUiChanges$2", f = "EventHistoryFragment.kt", i = {}, l = {275}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class EventHistoryFragment$provideUiChanges$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EventHistoryFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventHistoryFragment$provideUiChanges$2(EventHistoryFragment eventHistoryFragment, Continuation<? super EventHistoryFragment$provideUiChanges$2> continuation) {
        super(2, continuation);
        this.this$0 = eventHistoryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventHistoryFragment$provideUiChanges$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventHistoryFragment$provideUiChanges$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        EventHistoryViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            Flow<Triple<String, Long, Integer>> eventOpenVideo = viewModel.getEventOpenVideo();
            final EventHistoryFragment eventHistoryFragment = this.this$0;
            this.label = 1;
            if (eventOpenVideo.collect(new FlowCollector() { // from class: ru.tattelecom.feature.call_history.EventHistoryFragment$provideUiChanges$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Triple<String, Long, Integer>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Triple<String, Long, Integer> triple, Continuation<? super Unit> continuation) {
                    NavExtKt.navigateSafe$default(FragmentKt.findNavController(EventHistoryFragment.this), NavGraphDestinations.Action.INSTANCE.getToPlayer(), BundleKt.bundleOf(TuplesKt.to("videoUrl", triple.getFirst()), TuplesKt.to("callTime", triple.getSecond()), TuplesKt.to(NavArg.EVENT_TYPE, triple.getThird())), null, 4, null);
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
