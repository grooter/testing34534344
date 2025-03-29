package ru.tattelecom.intercom.feature.home;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;
import ru.tattelecom.intercom.domain.model.SupportContactDto;
import ru.tattelecom.intercom.domain.model.SupportDtosKt;
import ru.tattelecom.intercom.feature.home.databinding.FragmentHomeBinding;

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$1", f = "HomeFragment.kt", i = {}, l = {283}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeFragment$provideUiChanges$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$provideUiChanges$1(HomeFragment homeFragment, Continuation<? super HomeFragment$provideUiChanges$1> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$provideUiChanges$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$provideUiChanges$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$1$1", f = "HomeFragment.kt", i = {}, l = {284}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HomeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HomeFragment homeFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = homeFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SupportViewModel supportViewModel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                supportViewModel = this.this$0.getSupportViewModel();
                StateFlow<SupportContactDto> supportContacts = supportViewModel.getSupportContacts();
                final HomeFragment homeFragment = this.this$0;
                this.label = 1;
                if (supportContacts.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment.provideUiChanges.1.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((SupportContactDto) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(SupportContactDto supportContactDto, Continuation<? super Unit> continuation) {
                        FragmentHomeBinding binding;
                        SupportViewModel supportViewModel2;
                        final String str;
                        SupportViewModel supportViewModel3;
                        SupportViewModel supportViewModel4;
                        Boolean isEnabled;
                        if (supportContactDto != null) {
                            final HomeFragment homeFragment2 = HomeFragment.this;
                            binding = homeFragment2.getBinding();
                            SupportContactView supportContactView = binding.cvSupport;
                            supportViewModel2 = homeFragment2.getSupportViewModel();
                            String string = homeFragment2.getString(R.string.contact_support);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            String title = supportViewModel2.getTitle(supportContactDto, string);
                            SupportContactDto.Item contact = SupportDtosKt.getContact(supportContactDto.getContacts(), SupportContactDto.Type.CALL_PHONE);
                            if (contact == null || (str = contact.getValue()) == null) {
                                str = SupportViewModel.DEFAULT_PHONE_NUMBER;
                            }
                            final String formatPhoneNumber = SupportViewModel.INSTANCE.formatPhoneNumber(str);
                            SupportContactDto.Item contact2 = SupportDtosKt.getContact(supportContactDto.getContacts(), SupportContactDto.Type.CHAT);
                            boolean booleanValue = (contact2 == null || (isEnabled = contact2.isEnabled()) == null) ? false : isEnabled.booleanValue();
                            final String value = contact2 != null ? contact2.getValue() : null;
                            supportViewModel3 = homeFragment2.getSupportViewModel();
                            String telegramContact = supportViewModel3.getTelegramContact(supportContactDto);
                            supportViewModel4 = homeFragment2.getSupportViewModel();
                            supportContactView.setParams(title, booleanValue, telegramContact, supportViewModel4.getCallContact(supportContactDto));
                            supportContactView.setOnChatClickListener(new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$1$1$1$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                    HomeFragment.this.onChatClick(str, formatPhoneNumber, value);
                                }
                            });
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
