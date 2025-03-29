package ru.tattelecom.intercom.feature.home;

import android.content.res.Resources;
import android.util.Base64;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.navigation.fragment.FragmentKt;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.domain.model.AdvBottomSheetDto;
import ru.tattelecom.intercom.domain.model.DefaultThemeDto;
import ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2;
import ru.tattelecom.intercom.feature.home.databinding.FragmentHomeBinding;

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2", f = "HomeFragment.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeFragment$provideUiChanges$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$provideUiChanges$2(HomeFragment homeFragment, Continuation<? super HomeFragment$provideUiChanges$2> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$provideUiChanges$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$provideUiChanges$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2$1", f = "HomeFragment.kt", i = {}, l = {354, 368}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeFragment homeFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = homeFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AdvBottomSheetDesignTheme advBottomSheetDesignTheme;
            Job launch$default;
            HomeViewModel viewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                if ((this.this$0.getResources().getConfiguration().uiMode & 48) == 32) {
                    advBottomSheetDesignTheme = AdvBottomSheetDesignTheme.DARK;
                } else {
                    advBottomSheetDesignTheme = AdvBottomSheetDesignTheme.LIGHT;
                }
                Resources.Theme theme = this.this$0.requireActivity().getTheme();
                final Animation loadAnimation = AnimationUtils.loadAnimation(this.this$0.requireContext(), R.anim.anim_ic_bottom_sheet);
                final HomeFragment homeFragment = this.this$0;
                loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment.provideUiChanges.2.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        Job launch$default2;
                        HomeFragment homeFragment2 = HomeFragment.this;
                        launch$default2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new HomeFragment$provideUiChanges$2$1$1$onAnimationEnd$1(HomeFragment.this, loadAnimation, null), 3, null);
                        homeFragment2.jobAnim = launch$default2;
                    }
                });
                HomeFragment homeFragment2 = this.this$0;
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.this$0, loadAnimation, null), 3, null);
                homeFragment2.jobAnim = launch$default;
                viewModel = this.this$0.getViewModel();
                this.label = 1;
                obj = viewModel.getAdvBottomSheet(advBottomSheetDesignTheme, new DefaultThemeDto(this.this$0.getResources().getColor(R.color.octavus, theme), this.this$0.getResources().getColor(R.color.octavus, theme), this.this$0.getResources().getColor(R.color.bottom_sheet_text_color, theme), this.this$0.getResources().getColor(R.color.bottom_sheet_text_color, theme), this.this$0.getResources().getColor(R.color.bottom_sheet_bottom_color, theme)), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (((Flow) obj).collect(new AnonymousClass3(this.this$0), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* compiled from: HomeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2$1$2", f = "HomeFragment.kt", i = {}, l = {351}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Animation $animationIcon;
            int label;
            final /* synthetic */ HomeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(HomeFragment homeFragment, Animation animation, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = homeFragment;
                this.$animationIcon = animation;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$animationIcon, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FragmentHomeBinding binding;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                binding = this.this$0.getBinding();
                binding.ivAdvIcon.startAnimation(this.$animationIcon);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: HomeFragment.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "advDto", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "emit", "(Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2$1$3, reason: invalid class name */
        static final class AnonymousClass3<T> implements FlowCollector {
            final /* synthetic */ HomeFragment this$0;

            AnonymousClass3(HomeFragment homeFragment) {
                this.this$0 = homeFragment;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((AdvBottomSheetDto) obj, (Continuation<? super Unit>) continuation);
            }

            public final Object emit(final AdvBottomSheetDto advBottomSheetDto, Continuation<? super Unit> continuation) {
                FragmentHomeBinding binding;
                String icon;
                binding = this.this$0.getBinding();
                final HomeFragment homeFragment = this.this$0;
                if (advBottomSheetDto != null && (icon = advBottomSheetDto.getIcon()) != null) {
                    ImageView ivAdvIcon = binding.ivAdvIcon;
                    Intrinsics.checkNotNullExpressionValue(ivAdvIcon, "ivAdvIcon");
                    ivAdvIcon.setVisibility(0);
                    Glide.with(homeFragment.requireContext()).load(Base64.decode(icon, 0)).into(binding.ivAdvIcon);
                    binding.ivAdvIcon.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$2$1$3$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HomeFragment$provideUiChanges$2.AnonymousClass1.AnonymousClass3.emit$lambda$2$lambda$1$lambda$0(HomeFragment.this, advBottomSheetDto, view);
                        }
                    });
                    if (!advBottomSheetDto.isRead()) {
                        NavExtKt.navigateSafe$default(FragmentKt.findNavController(homeFragment), NavGraphDestinations.Action.INSTANCE.getToHomeBottomSheet(), null, null, 6, null);
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void emit$lambda$2$lambda$1$lambda$0(HomeFragment this$0, AdvBottomSheetDto advBottomSheetDto, View view) {
                HomeViewModel viewModel;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                viewModel = this$0.getViewModel();
                viewModel.reportEventAdv(102, advBottomSheetDto.getId());
                NavExtKt.navigateSafe$default(FragmentKt.findNavController(this$0), NavGraphDestinations.Action.INSTANCE.getToHomeBottomSheet(), null, null, 6, null);
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
