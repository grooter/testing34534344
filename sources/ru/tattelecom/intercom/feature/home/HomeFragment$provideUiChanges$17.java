package ru.tattelecom.intercom.feature.home;

import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.fragment.FragmentKt;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17;
import ru.tattelecom.intercom.feature.home.model.OpenChatEvent;

/* compiled from: HomeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17", f = "HomeFragment.kt", i = {}, l = {628}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class HomeFragment$provideUiChanges$17 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HomeFragment$provideUiChanges$17(HomeFragment homeFragment, Continuation<? super HomeFragment$provideUiChanges$17> continuation) {
        super(2, continuation);
        this.this$0 = homeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeFragment$provideUiChanges$17(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeFragment$provideUiChanges$17) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: HomeFragment.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/home/model/OpenChatEvent;", "emit", "(Lru/tattelecom/intercom/feature/home/model/OpenChatEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17$1, reason: invalid class name */
    static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ HomeFragment this$0;

        AnonymousClass1(HomeFragment homeFragment) {
            this.this$0 = homeFragment;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
            return emit((OpenChatEvent) obj, (Continuation<? super Unit>) continuation);
        }

        public final Object emit(final OpenChatEvent openChatEvent, Continuation<? super Unit> continuation) {
            AlertDialog chatAlertDialog;
            AlertDialog chatAlertDialog2;
            AlertDialog chatAlertDialog3;
            AlertDialog chatAlertDialog4;
            AlertDialog chatAlertDialog5;
            if (openChatEvent.getState()) {
                NavExtKt.navigateSafe$default(FragmentKt.findNavController(this.this$0), NavGraphDestinations.Dest.INSTANCE.getChat(), null, null, 6, null);
            } else {
                chatAlertDialog = this.this$0.getChatAlertDialog();
                if (!chatAlertDialog.isShowing()) {
                    try {
                        SpannableString spannableString = new SpannableString(this.this$0.getResources().getString(R.string.chat_unavailable_message_no_link, openChatEvent.getFormattedPhone()));
                        final HomeFragment homeFragment = this.this$0;
                        ClickableSpan clickableSpan = new ClickableSpan() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17$1$clickSpan$1
                            @Override // android.text.style.ClickableSpan
                            public void onClick(View widget) {
                                Intrinsics.checkNotNullParameter(widget, "widget");
                                HomeFragment homeFragment2 = HomeFragment.this;
                                String phone = openChatEvent.getPhone();
                                final HomeFragment homeFragment3 = HomeFragment.this;
                                homeFragment2.startPhoneActivity(phone, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17$1$clickSpan$1$onClick$1
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
                                        AlertDialog chatAlertDialog6;
                                        chatAlertDialog6 = HomeFragment.this.getChatAlertDialog();
                                        chatAlertDialog6.dismiss();
                                    }
                                });
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public void updateDrawState(TextPaint textPaint) {
                                Intrinsics.checkNotNullParameter(textPaint, "textPaint");
                                textPaint.setUnderlineText(true);
                            }
                        };
                        String string = this.this$0.getResources().getString(R.string.chat_unavailable_message_no_link, openChatEvent.getFormattedPhone());
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        int indexOf$default = StringsKt.indexOf$default((CharSequence) string, openChatEvent.getFormattedPhone(), 0, false, 6, (Object) null);
                        spannableString.setSpan(clickableSpan, indexOf$default, openChatEvent.getFormattedPhone().length() + indexOf$default, 33);
                        chatAlertDialog3 = this.this$0.getChatAlertDialog();
                        chatAlertDialog3.show();
                        chatAlertDialog4 = this.this$0.getChatAlertDialog();
                        TextView textView = (TextView) chatAlertDialog4.findViewById(android.R.id.message);
                        if (textView != null) {
                            textView.setText(spannableString, TextView.BufferType.SPANNABLE);
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                        }
                        chatAlertDialog5 = this.this$0.getChatAlertDialog();
                        Button button = (Button) chatAlertDialog5.findViewById(android.R.id.button1);
                        if (button != null) {
                            final HomeFragment homeFragment2 = this.this$0;
                            button.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17$1$$ExternalSyntheticLambda0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    HomeFragment$provideUiChanges$17.AnonymousClass1.emit$lambda$2$lambda$1(HomeFragment.this, openChatEvent, view);
                                }
                            });
                        }
                    } catch (Exception unused) {
                        chatAlertDialog2 = this.this$0.getChatAlertDialog();
                        chatAlertDialog2.show();
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void emit$lambda$2$lambda$1(final HomeFragment this$0, OpenChatEvent it, View view) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(it, "$it");
            this$0.startPhoneActivity(it.getPhone(), new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeFragment$provideUiChanges$17$1$2$1$1
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
                    AlertDialog chatAlertDialog;
                    chatAlertDialog = HomeFragment.this.getChatAlertDialog();
                    chatAlertDialog.dismiss();
                }
            });
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
            if (viewModel.getEventOpenChat().collect(new AnonymousClass1(this.this$0), this) == coroutine_suspended) {
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
