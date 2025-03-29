package ru.tattelecom.intercom.android.resources.basefragments;

import android.content.ComponentCallbacks;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.core.qualifier.Qualifier;
import ru.tattelecom.intercom.android.resources.R;
import ru.tattelecom.intercom.android.resources.SupportViewModel;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;
import ru.tattelecom.intercom.android.resources.databinding.FragmentRequestStateBinding;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.android.resources.navigation.NavGraphDestinations;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: RequestStateFragment.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!H\u0002J\u001a\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u001c\u0010+\u001a\u00020\u001f2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!H\u0002J\u001e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020!2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001f0/H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lru/tattelecom/intercom/android/resources/basefragments/RequestStateFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/android/resources/databinding/FragmentRequestStateBinding;", "getBinding", "()Lru/tattelecom/intercom/android/resources/databinding/FragmentRequestStateBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "chatAlertDialog", "Landroidx/appcompat/app/AlertDialog;", "getChatAlertDialog", "()Landroidx/appcompat/app/AlertDialog;", "chatAlertDialog$delegate", "Lkotlin/Lazy;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "getLogInteractor", "()Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "logInteractor$delegate", "supportViewModel", "Lru/tattelecom/intercom/android/resources/SupportViewModel;", "getSupportViewModel", "()Lru/tattelecom/intercom/android/resources/SupportViewModel;", "supportViewModel$delegate", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "getUserInteractor", "()Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "userInteractor$delegate", "onChatClick", "", "state", "", "phone", "formattedPhone", "chatAction", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "report", "showAlert", "startPhoneActivity", "phoneNumber", "onComplete", "Lkotlin/Function0;", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RequestStateFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(RequestStateFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/android/resources/databinding/FragmentRequestStateBinding;", 0))};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;

    /* renamed from: chatAlertDialog$delegate, reason: from kotlin metadata */
    private final Lazy chatAlertDialog;

    /* renamed from: logInteractor$delegate, reason: from kotlin metadata */
    private final Lazy logInteractor;

    /* renamed from: supportViewModel$delegate, reason: from kotlin metadata */
    private final Lazy supportViewModel;

    /* renamed from: userInteractor$delegate, reason: from kotlin metadata */
    private final Lazy userInteractor;

    public RequestStateFragment() {
        super(R.layout.fragment_request_state);
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(this, FragmentRequestStateBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
        final RequestStateFragment requestStateFragment = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.logInteractor = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<LogInteractor>() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.LogInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final LogInteractor invoke() {
                ComponentCallbacks componentCallbacks = requestStateFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(LogInteractor.class), qualifier, b);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.supportViewModel = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SupportViewModel>() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.android.resources.SupportViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final SupportViewModel invoke() {
                ComponentCallbacks componentCallbacks = requestStateFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SupportViewModel.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.userInteractor = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<UserInteractor>() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, ru.tattelecom.intercom.domain.interactors.UserInteractor] */
            @Override // kotlin.jvm.functions.Function0
            public final UserInteractor invoke() {
                ComponentCallbacks componentCallbacks = requestStateFragment;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UserInteractor.class), b4, b5);
            }
        });
        this.chatAlertDialog = LazyKt.lazy(new RequestStateFragment$chatAlertDialog$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentRequestStateBinding getBinding() {
        return (FragmentRequestStateBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    private final LogInteractor getLogInteractor() {
        return (LogInteractor) this.logInteractor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SupportViewModel getSupportViewModel() {
        return (SupportViewModel) this.supportViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UserInteractor getUserInteractor() {
        return (UserInteractor) this.userInteractor.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlertDialog getChatAlertDialog() {
        return (AlertDialog) this.chatAlertDialog.getValue();
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [T, java.lang.String] */
    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        getSupportViewModel().resetSupportContactsWithAuth();
        FragmentRequestStateBinding binding = getBinding();
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (!arguments.containsKey(RequestStateFragmentKt.REQUEST_STATE)) {
                arguments = null;
            }
            if (arguments != null) {
                objectRef.element = arguments.getString(RequestStateFragmentKt.REQUEST_STATE);
                if (Intrinsics.areEqual(objectRef.element, "success")) {
                    binding.ivState.setImageResource(R.drawable.ic_success);
                    binding.tvTitle.setText(arguments.getString("title"));
                    binding.tvMessage.setText(arguments.getString("message"));
                    SupportContactView cvSupport = binding.cvSupport;
                    Intrinsics.checkNotNullExpressionValue(cvSupport, "cvSupport");
                    cvSupport.setVisibility(8);
                    binding.btnContinue.setText(getString(R.string.great));
                } else {
                    binding.ivState.setImageResource(R.drawable.ic_error);
                    binding.tvTitle.setText(getString(R.string.something_went_wrong));
                    binding.tvMessage.setText(getString(R.string.try_to_repeat_the_action));
                    SupportContactView cvSupport2 = binding.cvSupport;
                    Intrinsics.checkNotNullExpressionValue(cvSupport2, "cvSupport");
                    cvSupport2.setVisibility(0);
                    binding.btnContinue.setText(getString(R.string.good));
                }
            }
        }
        binding.btnContinue.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                RequestStateFragment.onViewCreated$lambda$3$lambda$2(RequestStateFragment.this, objectRef, view2);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new RequestStateFragment$onViewCreated$1$4(this, binding, objectRef, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onViewCreated$lambda$3$lambda$2(RequestStateFragment this$0, Ref.ObjectRef state, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        Bundle arguments = this$0.getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString(NavArg.Activity.NAME) : null, NavArg.Activity.LEAVE_ORDER)) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        this$0.report((String) state.element);
        FragmentKt.findNavController(this$0).navigateUp();
    }

    static /* synthetic */ void onChatClick$default(RequestStateFragment requestStateFragment, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "error";
        }
        if ((i & 2) != 0) {
            str2 = SupportViewModel.DEFAULT_PHONE_NUMBER;
        }
        if ((i & 4) != 0) {
            str3 = SupportViewModel.INSTANCE.formatPhoneNumber(SupportViewModel.DEFAULT_PHONE_NUMBER);
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        requestStateFragment.onChatClick(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onChatClick(String state, String phone, String formattedPhone, String chatAction) {
        report(state);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new RequestStateFragment$onChatClick$1(chatAction, this, phone, formattedPhone, null), 3, null);
    }

    static /* synthetic */ void showAlert$default(RequestStateFragment requestStateFragment, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = SupportViewModel.DEFAULT_PHONE_NUMBER;
        }
        if ((i & 2) != 0) {
            str2 = SupportViewModel.INSTANCE.formatPhoneNumber(SupportViewModel.DEFAULT_PHONE_NUMBER);
        }
        requestStateFragment.showAlert(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAlert(final String phone, String formattedPhone) {
        if (getChatAlertDialog().isShowing()) {
            return;
        }
        try {
            SpannableString spannableString = new SpannableString(getResources().getString(R.string.chat_unavailable_message_no_link, formattedPhone));
            ClickableSpan clickableSpan = new ClickableSpan() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$showAlert$clickSpan$1
                @Override // android.text.style.ClickableSpan
                public void onClick(View widget) {
                    Intrinsics.checkNotNullParameter(widget, "widget");
                    RequestStateFragment requestStateFragment = RequestStateFragment.this;
                    String str = phone;
                    final RequestStateFragment requestStateFragment2 = RequestStateFragment.this;
                    requestStateFragment.startPhoneActivity(str, new Function0<Unit>() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$showAlert$clickSpan$1$onClick$1
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
                            chatAlertDialog = RequestStateFragment.this.getChatAlertDialog();
                            chatAlertDialog.dismiss();
                        }
                    });
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    Intrinsics.checkNotNullParameter(textPaint, "textPaint");
                    textPaint.setUnderlineText(true);
                }
            };
            String string = getResources().getString(R.string.chat_unavailable_message_no_link, formattedPhone);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int indexOf$default = StringsKt.indexOf$default((CharSequence) string, formattedPhone, 0, false, 6, (Object) null);
            spannableString.setSpan(clickableSpan, indexOf$default, formattedPhone.length() + indexOf$default, 33);
            getChatAlertDialog().show();
            TextView textView = (TextView) getChatAlertDialog().findViewById(android.R.id.message);
            if (textView != null) {
                textView.setText(spannableString, TextView.BufferType.SPANNABLE);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
            Button button = (Button) getChatAlertDialog().findViewById(android.R.id.button1);
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RequestStateFragment.showAlert$lambda$6$lambda$5(RequestStateFragment.this, phone, view);
                    }
                });
            }
        } catch (Exception unused) {
            getChatAlertDialog().show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAlert$lambda$6$lambda$5(final RequestStateFragment this$0, String phone, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(phone, "$phone");
        this$0.startPhoneActivity(phone, new Function0<Unit>() { // from class: ru.tattelecom.intercom.android.resources.basefragments.RequestStateFragment$showAlert$2$1$1
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
                chatAlertDialog = RequestStateFragment.this.getChatAlertDialog();
                chatAlertDialog.dismiss();
            }
        });
    }

    private final void report(String state) {
        NavDestination destination;
        NavBackStackEntry previousBackStackEntry = FragmentKt.findNavController(this).getPreviousBackStackEntry();
        Integer valueOf = (previousBackStackEntry == null || (destination = previousBackStackEntry.getDestination()) == null) ? null : Integer.valueOf(destination.getId());
        if (Intrinsics.areEqual(state, "success")) {
            int inviteUser = NavGraphDestinations.Dest.INSTANCE.getInviteUser();
            if (valueOf != null && valueOf.intValue() == inviteUser) {
                LogInteractor.reportEvent$default(getLogInteractor(), 70, null, 2, null);
                return;
            }
            int scanQrCode = NavGraphDestinations.Dest.INSTANCE.getScanQrCode();
            if (valueOf != null && valueOf.intValue() == scanQrCode) {
                LogInteractor.reportEvent$default(getLogInteractor(), 75, null, 2, null);
                return;
            }
            return;
        }
        int connectServices = NavGraphDestinations.Dest.INSTANCE.getConnectServices();
        if (valueOf != null && valueOf.intValue() == connectServices) {
            LogInteractor.reportEvent$default(getLogInteractor(), 49, null, 2, null);
            return;
        }
        int generateQrCode = NavGraphDestinations.Dest.INSTANCE.getGenerateQrCode();
        if (valueOf != null && valueOf.intValue() == generateQrCode) {
            LogInteractor.reportEvent$default(getLogInteractor(), 72, null, 2, null);
            return;
        }
        int inviteUser2 = NavGraphDestinations.Dest.INSTANCE.getInviteUser();
        if (valueOf != null && valueOf.intValue() == inviteUser2) {
            LogInteractor.reportEvent$default(getLogInteractor(), 73, null, 2, null);
            return;
        }
        int scanQrCode2 = NavGraphDestinations.Dest.INSTANCE.getScanQrCode();
        if (valueOf != null && valueOf.intValue() == scanQrCode2) {
            LogInteractor.reportEvent$default(getLogInteractor(), 74, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPhoneActivity(String phoneNumber, Function0<Unit> onComplete) {
        try {
            startActivity(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + phoneNumber)));
        } catch (Exception unused) {
        } catch (Throwable th) {
            onComplete.invoke();
            throw th;
        }
        onComplete.invoke();
    }
}
