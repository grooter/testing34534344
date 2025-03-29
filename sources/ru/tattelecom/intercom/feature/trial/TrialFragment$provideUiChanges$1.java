package ru.tattelecom.intercom.feature.trial;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.media3.extractor.ts.TsExtractor;
import androidx.navigation.fragment.FragmentKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.feature.trial.databinding.FragmentTrialBinding;
import ru.tattelecom.intercom.feature.trial.model.TrialEvent;

/* compiled from: TrialFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1", f = "TrialFragment.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DTS_HD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class TrialFragment$provideUiChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TrialFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrialFragment$provideUiChanges$1(TrialFragment trialFragment, Continuation<? super TrialFragment$provideUiChanges$1> continuation) {
        super(2, continuation);
        this.this$0 = trialFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrialFragment$provideUiChanges$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrialFragment$provideUiChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: TrialFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1$1", f = "TrialFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TrialFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TrialFragment trialFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = trialFragment;
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

        /* compiled from: TrialFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1$1$1", f = "TrialFragment.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C01231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TrialFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01231(TrialFragment trialFragment, Continuation<? super C01231> continuation) {
                super(2, continuation);
                this.this$0 = trialFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01231(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                TrialViewModel viewModel;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    viewModel = this.this$0.getViewModel();
                    StateFlow<Boolean> isLoading = viewModel.isLoading();
                    final TrialFragment trialFragment = this.this$0;
                    this.label = 1;
                    if (isLoading.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment.provideUiChanges.1.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                            FragmentTrialBinding binding;
                            TrialViewModel viewModel2;
                            String string;
                            FragmentTrialBinding binding2;
                            binding = TrialFragment.this.getBinding();
                            MaterialButton materialButton = binding.btnTrial;
                            TrialFragment trialFragment2 = TrialFragment.this;
                            Intrinsics.checkNotNull(materialButton);
                            if (z) {
                                ExtensionsKt.showProgress(materialButton);
                            } else {
                                viewModel2 = trialFragment2.getViewModel();
                                String screen = viewModel2.getScreen();
                                int hashCode = screen.hashCode();
                                if (hashCode == 460047084) {
                                    if (screen.equals(NavArg.TrialScreen.TRIAL_START)) {
                                        string = trialFragment2.getString(R.string.trial_start);
                                        Intrinsics.checkNotNull(string);
                                        ExtensionsKt.hideProgress(materialButton, string);
                                    }
                                    string = trialFragment2.getString(R.string.trial_connect);
                                    Intrinsics.checkNotNull(string);
                                    ExtensionsKt.hideProgress(materialButton, string);
                                } else if (hashCode != 1497670117) {
                                    if (hashCode == 1497677650 && screen.equals(NavArg.TrialScreen.TRIAL_MID)) {
                                        string = trialFragment2.getString(R.string.trial_connect);
                                        Intrinsics.checkNotNull(string);
                                        ExtensionsKt.hideProgress(materialButton, string);
                                    }
                                    string = trialFragment2.getString(R.string.trial_connect);
                                    Intrinsics.checkNotNull(string);
                                    ExtensionsKt.hideProgress(materialButton, string);
                                } else {
                                    if (screen.equals(NavArg.TrialScreen.TRIAL_END)) {
                                        string = trialFragment2.getString(R.string.trial_connect);
                                        Intrinsics.checkNotNull(string);
                                        ExtensionsKt.hideProgress(materialButton, string);
                                    }
                                    string = trialFragment2.getString(R.string.trial_connect);
                                    Intrinsics.checkNotNull(string);
                                    ExtensionsKt.hideProgress(materialButton, string);
                                }
                            }
                            binding2 = TrialFragment.this.getBinding();
                            binding2.btnTrial.setEnabled(!z);
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
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01231(this.this$0, null), 3, null);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.this$0, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* compiled from: TrialFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1$1$2", f = "TrialFragment.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: ru.tattelecom.intercom.feature.trial.TrialFragment$provideUiChanges$1$1$2, reason: invalid class name */
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ TrialFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(TrialFragment trialFragment, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = trialFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                TrialViewModel viewModel;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    viewModel = this.this$0.getViewModel();
                    Flow<TrialEvent> events = viewModel.getEvents();
                    final TrialFragment trialFragment = this.this$0;
                    this.label = 1;
                    if (events.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.trial.TrialFragment.provideUiChanges.1.1.2.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((TrialEvent) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(TrialEvent trialEvent, Continuation<? super Unit> continuation) {
                            FragmentTrialBinding binding;
                            if (Intrinsics.areEqual(trialEvent, TrialEvent.CloseScreen.INSTANCE)) {
                                FragmentKt.findNavController(TrialFragment.this).navigateUp();
                            } else if (trialEvent instanceof TrialEvent.ShowSnack) {
                                try {
                                    binding = TrialFragment.this.getBinding();
                                    Snackbar.make(binding.getRoot(), ((TrialEvent.ShowSnack) trialEvent).getMessage(), -1).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
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
                return Unit.INSTANCE;
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
