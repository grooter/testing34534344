package ru.tattelecom.intercom.feature.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.navigation.fragment.FragmentKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.domain.model.TrialDto;
import ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$5;
import ru.tattelecom.intercom.feature.home.databinding.FragmentHomeBinding;
import ru.tattelecom.intercom.feature.home.model.HomeScreenState;

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$5", f = "HomeFragment.kt", i = {}, l = {ErrorCode.HTTP_REQ_TOO_LONG}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeFragment$provideUiChanges$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$provideUiChanges$5(HomeFragment homeFragment, Continuation<? super HomeFragment$provideUiChanges$5> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$provideUiChanges$5(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$provideUiChanges$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/home/model/HomeScreenState;", "emit", "(Lru/tattelecom/intercom/feature/home/model/HomeScreenState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$5$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ HomeFragment this$0;

        AnonymousClass1(HomeFragment homeFragment) {
            this.this$0 = homeFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((HomeScreenState) obj, (Continuation<? super Unit>) continuation);
        }

        public final Object emit(final HomeScreenState homeScreenState, Continuation<? super Unit> continuation) {
            FragmentHomeBinding binding;
            HomeScreenState.OldUser oldUser;
            TrialDto trialDto;
            String quantityString;
            binding = this.this$0.getBinding();
            final HomeFragment homeFragment = this.this$0;
            if (Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE)) {
                binding.ivState.setImageResource(R.drawable.ic_my_home);
                binding.tvTitle.setText(homeFragment.getString(R.string.while_empty));
                binding.tvMessage.setText(homeFragment.getString(R.string.no_connected_addresses));
            } else if (Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE)) {
                binding.ivState.setImageResource(R.drawable.ic_error);
                binding.tvTitle.setText(homeFragment.getString(R.string.something_went_wrong));
                binding.tvMessage.setText(homeFragment.getString(R.string.try_to_repeat_the_action));
            }
            TextView tvTitle = binding.tvTitle;
            Intrinsics.checkNotNullExpressionValue(tvTitle, "tvTitle");
            tvTitle.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) || Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE) ? 0 : 8);
            TextView tvMessage = binding.tvMessage;
            Intrinsics.checkNotNullExpressionValue(tvMessage, "tvMessage");
            tvMessage.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) || Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE) ? 0 : 8);
            ImageView ivState = binding.ivState;
            Intrinsics.checkNotNullExpressionValue(ivState, "ivState");
            ivState.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) || Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE) ? 0 : 8);
            SwipeRefreshLayout swipeRefresh = binding.swipeRefresh;
            Intrinsics.checkNotNullExpressionValue(swipeRefresh, "swipeRefresh");
            swipeRefresh.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) || Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE) ? 0 : 8);
            MaterialButton btnAddAddress = binding.btnAddAddress;
            Intrinsics.checkNotNullExpressionValue(btnAddAddress, "btnAddAddress");
            btnAddAddress.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) ? 0 : 8);
            TextView tvLeaveRequest = binding.tvLeaveRequest;
            Intrinsics.checkNotNullExpressionValue(tvLeaveRequest, "tvLeaveRequest");
            tvLeaveRequest.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) ? 0 : 8);
            MaterialButton btnLeaveRequest = binding.btnLeaveRequest;
            Intrinsics.checkNotNullExpressionValue(btnLeaveRequest, "btnLeaveRequest");
            btnLeaveRequest.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.NewUser.INSTANCE) ? 0 : 8);
            TabLayout tabLayout = binding.tabLayout;
            Intrinsics.checkNotNullExpressionValue(tabLayout, "tabLayout");
            boolean z = homeScreenState instanceof HomeScreenState.OldUser;
            tabLayout.setVisibility(z ? 0 : 8);
            View divider = binding.divider;
            Intrinsics.checkNotNullExpressionValue(divider, "divider");
            divider.setVisibility(z ? 0 : 8);
            ViewPager2 viewPager = binding.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager, "viewPager");
            viewPager.setVisibility(z ? 0 : 8);
            MaterialCardView cardBanner = binding.cardBanner;
            Intrinsics.checkNotNullExpressionValue(cardBanner, "cardBanner");
            cardBanner.setVisibility(z && ((HomeScreenState.OldUser) homeScreenState).isBannerVisible() ? 0 : 8);
            if (z && (trialDto = (oldUser = (HomeScreenState.OldUser) homeScreenState).getTrialDto()) != null && trialDto.isActive()) {
                ConstraintLayout clTrial = binding.clTrial;
                Intrinsics.checkNotNullExpressionValue(clTrial, "clTrial");
                clTrial.setVisibility(0);
                int remainingDays = oldUser.getTrialDto().getRemainingDays();
                if (remainingDays <= 1) {
                    quantityString = homeFragment.getString(R.string.trial_zero_days);
                } else {
                    quantityString = homeFragment.getResources().getQuantityString(R.plurals.remaining_days, remainingDays, Boxing.boxInt(remainingDays));
                }
                Intrinsics.checkNotNullExpressionValue(quantityString, "let(...)");
                TextView textView = binding.btnTrial;
                textView.setText(quantityString);
                textView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$5$1$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        HomeFragment$provideUiChanges$5.AnonymousClass1.emit$lambda$3$lambda$2$lambda$1(HomeFragment.this, homeScreenState, view);
                    }
                });
                TextView btnTrialExtend = binding.btnTrialExtend;
                Intrinsics.checkNotNullExpressionValue(btnTrialExtend, "btnTrialExtend");
                homeFragment.setTrialAnimation(btnTrialExtend);
            } else {
                ConstraintLayout clTrial2 = binding.clTrial;
                Intrinsics.checkNotNullExpressionValue(clTrial2, "clTrial");
                clTrial2.setVisibility(8);
            }
            MaterialButton btnUpdate = binding.btnUpdate;
            Intrinsics.checkNotNullExpressionValue(btnUpdate, "btnUpdate");
            btnUpdate.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE) ? 0 : 8);
            SupportContactView cvSupport = binding.cvSupport;
            Intrinsics.checkNotNullExpressionValue(cvSupport, "cvSupport");
            cvSupport.setVisibility(Intrinsics.areEqual(homeScreenState, HomeScreenState.Error.INSTANCE) ? 0 : 8);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$3$lambda$2$lambda$1(HomeFragment this$0, HomeScreenState it, View view) {
            HomeViewModel viewModel;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            viewModel = this$0.getViewModel();
            viewModel.reportEvent(119);
            HomeScreenState.OldUser oldUser = (HomeScreenState.OldUser) it;
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToTrial(), BundleKt.bundleOf(TuplesKt.to(NavArg.TrialScreen.TRIAL_ID, Integer.valueOf(oldUser.getTrialDto().getId())), TuplesKt.to("screen", NavArg.TrialScreen.TRIAL_MID), TuplesKt.to(NavArg.TrialScreen.DAYS_COUNT, Integer.valueOf(oldUser.getTrialDto().getRemainingDays()))), null, 4, null);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HomeViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            this.label = 1;
            if (viewModel.getScreenState().collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
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
