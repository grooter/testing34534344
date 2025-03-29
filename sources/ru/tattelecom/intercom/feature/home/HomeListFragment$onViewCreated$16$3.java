package ru.tattelecom.intercom.feature.home;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.List;
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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.feature.home.databinding.FragmentListBinding;

/* compiled from: HomeListFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeListFragment$onViewCreated$16$3", f = "HomeListFragment.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeListFragment$onViewCreated$16$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeListFragment$onViewCreated$16$3(HomeListFragment homeListFragment, Continuation<? super HomeListFragment$onViewCreated$16$3> continuation) {
        super(2, continuation);
        this.this$0 = homeListFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeListFragment$onViewCreated$16$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeListFragment$onViewCreated$16$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HomeViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            Flow<List<HomeItem>> favoritesList = viewModel.getFavoritesList();
            final HomeListFragment homeListFragment = this.this$0;
            this.label = 1;
            if (favoritesList.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.home.HomeListFragment$onViewCreated$16$3.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((List<? extends HomeItem>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(List<? extends HomeItem> list, Continuation<? super Unit> continuation) {
                    HomeListAdapter homeListAdapter;
                    FragmentListBinding binding;
                    FragmentListBinding binding2;
                    homeListAdapter = HomeListFragment.this.homeListAdapter;
                    if (homeListAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("homeListAdapter");
                        homeListAdapter = null;
                    }
                    homeListAdapter.submitList(list);
                    binding = HomeListFragment.this.getBinding();
                    ConstraintLayout clEmpty = binding.clEmpty;
                    Intrinsics.checkNotNullExpressionValue(clEmpty, "clEmpty");
                    List<? extends HomeItem> list2 = list;
                    clEmpty.setVisibility(list2 == null || list2.isEmpty() ? 0 : 8);
                    binding2 = HomeListFragment.this.getBinding();
                    binding2.textView2.setText(HomeListFragment.this.getString(R.string.empty_favorites));
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
