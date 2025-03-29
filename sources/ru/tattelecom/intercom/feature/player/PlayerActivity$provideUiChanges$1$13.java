package ru.tattelecom.intercom.feature.player;

import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.google.android.material.slider.Slider;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$13", f = "PlayerActivity.kt", i = {}, l = {720}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerActivity$provideUiChanges$1$13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayerViewModel $this_with;
    int label;
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideUiChanges$1$13(PlayerActivity playerActivity, PlayerViewModel playerViewModel, Continuation<? super PlayerActivity$provideUiChanges$1$13> continuation) {
        super(2, continuation);
        this.this$0 = playerActivity;
        this.$this_with = playerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerActivity$provideUiChanges$1$13(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerActivity$provideUiChanges$1$13) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: PlayerActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$13$1", f = "PlayerActivity.kt", i = {}, l = {721}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$13$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PlayerViewModel $this_with;
        int label;
        final /* synthetic */ PlayerActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(PlayerViewModel playerViewModel, PlayerActivity playerActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_with = playerViewModel;
            this.this$0 = playerActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_with, this.this$0, continuation);
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
                StateFlow<Long> streamDurationInSeconds = this.$this_with.getStreamDurationInSeconds();
                final PlayerActivity playerActivity = this.this$0;
                this.label = 1;
                if (streamDurationInSeconds.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity.provideUiChanges.1.13.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Number) obj2).longValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(long j, Continuation<? super Unit> continuation) {
                        ActivityPlayerBinding binding;
                        long hours = TimeUnit.SECONDS.toHours(j);
                        if (hours == 24) {
                            hours--;
                        }
                        binding = PlayerActivity.this.getBinding();
                        if (hours > 0) {
                            try {
                                Slider slider = binding.slHour;
                                if (slider != null) {
                                    slider.setValueTo(hours);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (j > 0) {
                            binding.slSeconds.setValueTo(j);
                        }
                        TextView textView = binding.tvEndHoursHint;
                        if (textView != null) {
                            textView.setText(hours + " ч");
                        }
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
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(this.this$0, Lifecycle.State.STARTED, new AnonymousClass1(this.$this_with, this.this$0, null), this) == coroutine_suspended) {
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
