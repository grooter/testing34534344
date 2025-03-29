package ru.tattelecom.intercom.feature.player;

import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.material.slider.Slider;
import java.util.concurrent.TimeUnit;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$14", f = "PlayerActivity.kt", i = {}, l = {745}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerActivity$provideUiChanges$1$14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayerViewModel $this_with;
    int label;
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideUiChanges$1$14(PlayerActivity playerActivity, PlayerViewModel playerViewModel, Continuation<? super PlayerActivity$provideUiChanges$1$14> continuation) {
        super(2, continuation);
        this.this$0 = playerActivity;
        this.$this_with = playerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerActivity$provideUiChanges$1$14(this.this$0, this.$this_with, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerActivity$provideUiChanges$1$14) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: PlayerActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$14$1", f = "PlayerActivity.kt", i = {}, l = {746}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$14$1, reason: invalid class name */
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
                StateFlow<Long> streamTimeInSeconds = this.$this_with.getStreamTimeInSeconds();
                final PlayerActivity playerActivity = this.this$0;
                this.label = 1;
                if (streamTimeInSeconds.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity.provideUiChanges.1.14.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit(((Number) obj2).longValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(long j, Continuation<? super Unit> continuation) {
                        ExoPlayer exoPlayer;
                        PlayerViewModel viewModel;
                        ActivityPlayerBinding binding;
                        boolean z;
                        String withZero;
                        String withZero2;
                        String withZero3;
                        String withZero4;
                        Object boxInt;
                        String withZero5;
                        PlayerViewModel viewModel2;
                        exoPlayer = PlayerActivity.this.streamPlayer;
                        if (exoPlayer != null && exoPlayer.getCurrentPosition() == 0 && j != 0) {
                            viewModel2 = PlayerActivity.this.getViewModel();
                            viewModel2.onArchiveTimeSelected(j);
                        }
                        long j2 = 3600;
                        long j3 = j % j2;
                        long hours = TimeUnit.SECONDS.toHours(j);
                        viewModel = PlayerActivity.this.getViewModel();
                        long longValue = viewModel.getStreamDurationInSeconds().getValue().longValue();
                        long j4 = longValue % j2;
                        long hours2 = TimeUnit.SECONDS.toHours(longValue);
                        binding = PlayerActivity.this.getBinding();
                        PlayerActivity playerActivity2 = PlayerActivity.this;
                        z = playerActivity2.isTimeDragging;
                        if (!z) {
                            try {
                                Slider slider = binding.slMinutes;
                                if (slider != null) {
                                    slider.setValueTo((hours != hours2 || j4 <= 0) ? 3599.0f : j4);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        playerActivity2.provideSliderValue(binding.slSeconds, j);
                        playerActivity2.provideSliderValue(binding.slHour, hours);
                        Slider slider2 = binding.slMinutes;
                        if (hours == hours2 && j3 >= j4) {
                            j3 = j4;
                        }
                        playerActivity2.provideSliderValue(slider2, j3);
                        TextView textView = binding.tvStartMinutesHint;
                        if (textView != null) {
                            withZero5 = playerActivity2.withZero(hours);
                            textView.setText(withZero5 + ":00");
                        }
                        TextView textView2 = binding.tvEndMinutesHint;
                        if (textView2 != null) {
                            withZero4 = playerActivity2.withZero(hours);
                            if (hours == hours2) {
                                boxInt = playerActivity2.withZero(j4 / 60);
                            } else {
                                boxInt = Boxing.boxInt(59);
                            }
                            textView2.setText(withZero4 + ":" + boxInt);
                        }
                        TextView textView3 = binding.tvTime;
                        withZero = playerActivity2.withZero(hours);
                        long j5 = 60;
                        withZero2 = playerActivity2.withZero((j / j5) % j5);
                        withZero3 = playerActivity2.withZero(j % j5);
                        textView3.setText(withZero + ":" + withZero2 + ":" + withZero3);
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
