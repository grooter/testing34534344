package ru.tattelecom.intercom.feature.profile;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
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
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;
import ru.tattelecom.intercom.android.resources.navigation.NavExtKt;
import ru.tattelecom.intercom.feature.profile.Event;

/* compiled from: ProfileFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/profile/Event;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.profile.ProfileFragment$provideUiChanges$1$2", f = "ProfileFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class ProfileFragment$provideUiChanges$1$2 extends SuspendLambda implements Function2<Event, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ProfileFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileFragment$provideUiChanges$1$2(ProfileFragment profileFragment, Continuation<? super ProfileFragment$provideUiChanges$1$2> continuation) {
        super(2, continuation);
        this.this$0 = profileFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileFragment$provideUiChanges$1$2 profileFragment$provideUiChanges$1$2 = new ProfileFragment$provideUiChanges$1$2(this.this$0, continuation);
        profileFragment$provideUiChanges$1$2.L$0 = obj;
        return profileFragment$provideUiChanges$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Event event, Continuation<? super Unit> continuation) {
        return ((ProfileFragment$provideUiChanges$1$2) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AlertDialog chatAlertDialog;
        AlertDialog chatAlertDialog2;
        AlertDialog chatAlertDialog3;
        AlertDialog chatAlertDialog4;
        AlertDialog chatAlertDialog5;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final Event event = (Event) this.L$0;
        if (event instanceof Event.Navigate) {
            NavExtKt.navigateSafe$default(FragmentKt.findNavController(this.this$0), ((Event.Navigate) event).getAction(), this.this$0.getArguments(), null, 4, null);
        } else if (event instanceof Event.ShowMessage) {
            Context requireContext = this.this$0.requireContext();
            String message = ((Event.ShowMessage) event).getMessage();
            Context requireContext2 = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(message, requireContext2), 1).show();
        } else if (event instanceof Event.ShowChatAlert) {
            chatAlertDialog = this.this$0.getChatAlertDialog();
            if (!chatAlertDialog.isShowing()) {
                try {
                    SpannableString spannableString = new SpannableString(this.this$0.getResources().getString(R.string.chat_unavailable_message_no_link, ((Event.ShowChatAlert) event).getFormattedPhone()));
                    final ProfileFragment profileFragment = this.this$0;
                    ClickableSpan clickableSpan = new ClickableSpan() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$provideUiChanges$1$2$clickSpan$1
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            Intrinsics.checkNotNullParameter(widget, "widget");
                            ProfileFragment profileFragment2 = ProfileFragment.this;
                            String phone = ((Event.ShowChatAlert) event).getPhone();
                            final ProfileFragment profileFragment3 = ProfileFragment.this;
                            profileFragment2.startPhoneActivity(phone, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$provideUiChanges$1$2$clickSpan$1$onClick$1
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
                                    chatAlertDialog6 = ProfileFragment.this.getChatAlertDialog();
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
                    String string = this.this$0.getResources().getString(R.string.chat_unavailable_message_no_link, ((Event.ShowChatAlert) event).getFormattedPhone());
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    int indexOf$default = StringsKt.indexOf$default((CharSequence) string, ((Event.ShowChatAlert) event).getFormattedPhone(), 0, false, 6, (Object) null);
                    spannableString.setSpan(clickableSpan, indexOf$default, ((Event.ShowChatAlert) event).getFormattedPhone().length() + indexOf$default, 33);
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
                        final ProfileFragment profileFragment2 = this.this$0;
                        button.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$provideUiChanges$1$2$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ProfileFragment$provideUiChanges$1$2.invokeSuspend$lambda$2$lambda$1(ProfileFragment.this, event, view);
                            }
                        });
                    }
                } catch (Exception unused) {
                    chatAlertDialog2 = this.this$0.getChatAlertDialog();
                    chatAlertDialog2.show();
                }
            }
        }
        Bundle arguments = this.this$0.getArguments();
        if (arguments != null) {
            arguments.clear();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$2$lambda$1(final ProfileFragment profileFragment, Event event, View view) {
        profileFragment.startPhoneActivity(((Event.ShowChatAlert) event).getPhone(), new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.profile.ProfileFragment$provideUiChanges$1$2$2$1$1
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
                chatAlertDialog = ProfileFragment.this.getChatAlertDialog();
                chatAlertDialog.dismiss();
            }
        });
    }
}
