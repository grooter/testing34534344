package ru.tattelecom.intercom.lib_chat;

import android.content.ClipData;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.fragment.FragmentKt;
import by.kirich1409.viewbindingdelegate.CreateMethod;
import by.kirich1409.viewbindingdelegate.ReflectionFragmentViewBindings;
import by.kirich1409.viewbindingdelegate.ViewBindingProperty;
import by.kirich1409.viewbindingdelegate.internal.UtilsKt;
import im.threads.business.UserInfoBuilder;
import im.threads.business.markdown.MarkdownConfig;
import im.threads.ui.ChatStyle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.json.JSONObject;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;
import ru.tattelecom.intercom.android.resources.ExtensionsKt;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.data.BuildConfig;
import ru.tattelecom.intercom.data.remote.model.responses.ConfigResponse;
import ru.tattelecom.intercom.feature.chat.R;
import ru.tattelecom.intercom.feature.chat.databinding.FragmentChatBinding;
import ru.tattelecom.intercom.lib_chat.EDNAChat;

/* compiled from: ChatFragment.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/lib_chat/ChatFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lru/tattelecom/intercom/feature/chat/databinding/FragmentChatBinding;", "getBinding", "()Lru/tattelecom/intercom/feature/chat/databinding/FragmentChatBinding;", "binding$delegate", "Lby/kirich1409/viewbindingdelegate/ViewBindingProperty;", "chat", "Lim/threads/ui/fragments/ChatFragment;", "viewModel", "Lru/tattelecom/intercom/lib_chat/ChatViewModel;", "getViewModel", "()Lru/tattelecom/intercom/lib_chat/ChatViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "applyDarkTheme", "", "applyLightTheme", "applyThemes", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onViewCreated", "view", "Landroid/view/View;", "Companion", "feature-chat_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ChatFragment extends Fragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(ChatFragment.class, "binding", "getBinding()Lru/tattelecom/intercom/feature/chat/databinding/FragmentChatBinding;", 0))};
    private static final String ROBOTO_BOLD_FONT_PATH = "fonts/roboto-bold.ttf";
    private static final String ROBOTO_LIGHT_FONT_PATH = "fonts/roboto-light.ttf";
    private static final String ROBOTO_REGULAR_FONT_PATH = "fonts/roboto-regular.ttf";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final ViewBindingProperty binding;
    private im.threads.ui.fragments.ChatFragment chat;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public ChatFragment() {
        super(R.layout.fragment_chat);
        final ChatFragment chatFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: ru.tattelecom.intercom.lib_chat.ChatFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Qualifier qualifier = null;
        final Function0 function02 = null;
        final Function0 function03 = null;
        this.viewModel = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ChatViewModel>() { // from class: ru.tattelecom.intercom.lib_chat.ChatFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v5, types: [androidx.lifecycle.ViewModel, ru.tattelecom.intercom.lib_chat.ChatViewModel] */
            @Override // kotlin.jvm.functions.Function0
            public final ChatViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ?? resolveViewModel;
                Fragment fragment = Fragment.this;
                Qualifier qualifier2 = qualifier;
                Function0 function04 = function0;
                Function0 function05 = function02;
                Function0 function06 = function03;
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function04.invoke()).getViewModelStore();
                if (function05 == null || (defaultViewModelCreationExtras = (CreationExtras) function05.invoke()) == null) {
                    defaultViewModelCreationExtras = fragment.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(fragment);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ChatViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                resolveViewModel = GetViewModelKt.resolveViewModel(orCreateKotlinClass, viewModelStore, (r16 & 4) != 0 ? null : null, creationExtras, (r16 & 16) != 0 ? null : qualifier2, koinScope, (r16 & 64) != 0 ? null : function06);
                return resolveViewModel;
            }
        });
        this.binding = ReflectionFragmentViewBindings.viewBindingFragment(chatFragment, FragmentChatBinding.class, CreateMethod.BIND, UtilsKt.emptyVbCallback());
    }

    private final ChatViewModel getViewModel() {
        return (ChatViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FragmentChatBinding getBinding() {
        return (FragmentChatBinding) this.binding.getValue(this, $$delegatedProperties[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().getSupportFragmentManager().setFragmentResult("DISPATCHER_SETTINGS", BundleKt.bundleOf(TuplesKt.to("canDispatch", false)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ExtensionsKt.registerOnBackPressedCallback(this, new Function1<OnBackPressedCallback, Unit>() { // from class: ru.tattelecom.intercom.lib_chat.ChatFragment$onViewCreated$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OnBackPressedCallback onBackPressedCallback) {
                invoke2(onBackPressedCallback);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OnBackPressedCallback registerOnBackPressedCallback) {
                im.threads.ui.fragments.ChatFragment chatFragment;
                Intrinsics.checkNotNullParameter(registerOnBackPressedCallback, "$this$registerOnBackPressedCallback");
                chatFragment = ChatFragment.this.chat;
                if (chatFragment == null || !chatFragment.onBackPressed()) {
                    return;
                }
                FragmentKt.findNavController(ChatFragment.this).navigateUp();
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        ClipData clipData;
        ConfigResponse.Subscriber subscriber;
        ConfigResponse.Subscriber subscriber2;
        ConfigResponse.Subscriber subscriber3;
        ConfigResponse.Subscriber subscriber4;
        ConfigResponse.Subscriber subscriber5;
        super.onResume();
        JSONObject jSONObject = new JSONObject();
        ConfigResponse userConfig = getViewModel().getUserConfig();
        String str = null;
        JSONObject put = jSONObject.put("name", (userConfig == null || (subscriber5 = userConfig.getSubscriber()) == null) ? null : subscriber5.getFullName());
        ConfigResponse userConfig2 = getViewModel().getUserConfig();
        put.put("phone", (userConfig2 == null || (subscriber4 = userConfig2.getSubscriber()) == null) ? null : subscriber4.getPhone());
        EDNAChat.Companion companion = EDNAChat.INSTANCE;
        ConfigResponse userConfig3 = getViewModel().getUserConfig();
        UserInfoBuilder userInfoBuilder = new UserInfoBuilder(String.valueOf((userConfig3 == null || (subscriber3 = userConfig3.getSubscriber()) == null) ? null : subscriber3.getId()));
        ConfigResponse userConfig4 = getViewModel().getUserConfig();
        UserInfoBuilder appMarker = userInfoBuilder.setUserName((userConfig4 == null || (subscriber2 = userConfig4.getSubscriber()) == null) ? null : subscriber2.getFullName()).setAppMarker(BuildConfig.EDNA_THREADS_APP_MARKER);
        ConfigResponse userConfig5 = getViewModel().getUserConfig();
        if (userConfig5 != null && (subscriber = userConfig5.getSubscriber()) != null) {
            str = subscriber.getSignature();
        }
        companion.initUser(UserInfoBuilder.setAuthData$default(appMarker.setClientIdSignature(str), getViewModel().getToken(), null, null, 4, null).setClientData(jSONObject.toString()), false);
        Bundle arguments = getArguments();
        if (arguments != null && (clipData = (ClipData) arguments.getParcelable(NavArg.DEEPLINK_CLIP_DATA)) != null) {
            int itemCount = clipData.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                EDNAChat.Companion companion2 = EDNAChat.INSTANCE;
                Uri uri = clipData.getItemAt(i).getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "getUri(...)");
                companion2.sendImage(uri);
            }
            Bundle arguments2 = getArguments();
            if (arguments2 != null) {
                arguments2.clear();
            }
        }
        if (this.chat == null) {
            applyThemes();
            this.chat = EDNAChat.INSTANCE.newChatInstance(0);
        }
        im.threads.ui.fragments.ChatFragment chatFragment = this.chat;
        if (chatFragment != null) {
            getChildFragmentManager().beginTransaction().replace(getBinding().chatFragmentContainer.getId(), chatFragment).commit();
        }
    }

    private final void applyThemes() {
        EDNAChat.Companion companion = EDNAChat.INSTANCE;
        ChatStyle chatStyle = new ChatStyle();
        chatStyle.setDefaultFontBold(ROBOTO_BOLD_FONT_PATH);
        chatStyle.setDefaultFontLight(ROBOTO_LIGHT_FONT_PATH);
        chatStyle.setDefaultFontRegular(ROBOTO_REGULAR_FONT_PATH);
        chatStyle.setScrollChatToEndIfUserTyping(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.scroll_chat_to_end_if_user_typing));
        MarkdownConfig markdownConfig = new MarkdownConfig();
        markdownConfig.setLinkUnderlined(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.is_link_underlined));
        markdownConfig.setListItemColor(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.tertiary));
        chatStyle.setChatSubtitleShowConsultOrgUnit(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.chat_subtitle_show_consult_org_unit));
        chatStyle.setIncomingMarkdownConfiguration(markdownConfig);
        chatStyle.setOutgoingMarkdownConfiguration(markdownConfig);
        chatStyle.setVisibleChatTitleShadow(ru.tattelecom.intercom.android.resources.R.bool.chat_title_shadow_is_visible);
        chatStyle.setShowConsultSearching(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.show_consult_searching));
        chatStyle.setVoiceMessageEnabled(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.voice_message_enabled));
        chatStyle.showChatBackButton(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.show_chat_back_button));
        chatStyle.setIngoingPadding(ru.tattelecom.intercom.android.resources.R.dimen.incomingBubblePaddingLeft, ru.tattelecom.intercom.android.resources.R.dimen.incomingBubblePaddingTop, ru.tattelecom.intercom.android.resources.R.dimen.incomingBubblePaddingRight, ru.tattelecom.intercom.android.resources.R.dimen.incomingBubblePaddingBottom);
        chatStyle.setOutgoingPadding(ru.tattelecom.intercom.android.resources.R.dimen.outgoingBubblePaddingLeft, ru.tattelecom.intercom.android.resources.R.dimen.outgoingBubblePaddingTop, ru.tattelecom.intercom.android.resources.R.dimen.outgoingBubblePaddingRight, ru.tattelecom.intercom.android.resources.R.dimen.outgoingBubblePaddingBottom);
        chatStyle.setIncomingImageBordersSize(ru.tattelecom.intercom.android.resources.R.dimen.incomingImageLeftBorderSize, ru.tattelecom.intercom.android.resources.R.dimen.incomingImageTopBorderSize, ru.tattelecom.intercom.android.resources.R.dimen.incomingImageRightBorderSize, ru.tattelecom.intercom.android.resources.R.dimen.incomingImageBottomBorderSize);
        chatStyle.setOutgoingImageBordersSize(ru.tattelecom.intercom.android.resources.R.dimen.outgoingImageLeftBorderSize, ru.tattelecom.intercom.android.resources.R.dimen.outgoingImageTopBorderSize, ru.tattelecom.intercom.android.resources.R.dimen.outgoingImageRightBorderSize, ru.tattelecom.intercom.android.resources.R.dimen.outgoingImageBottomBorderSize);
        chatStyle.setIncomingImageMask(ru.tattelecom.intercom.android.resources.R.drawable.incoming_image_mask);
        chatStyle.setOutgoingImageMask(ru.tattelecom.intercom.android.resources.R.drawable.outgoing_image_mask);
        chatStyle.setIncomingBubbleMask(ru.tattelecom.intercom.android.resources.R.drawable.incoming_bubble);
        chatStyle.setIncomingMessageBubbleColor(ru.tattelecom.intercom.android.resources.R.color.octavus);
        chatStyle.incomingMessageBubbleBackground = ru.tattelecom.intercom.android.resources.R.drawable.incoming_bubble;
        chatStyle.setIncomingQuoteViewStyle(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.septima), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary));
        chatStyle.quoteBackgroundResId = ru.tattelecom.intercom.android.resources.R.drawable.reply_background;
        chatStyle.setOutgoingBubbleMask(ru.tattelecom.intercom.android.resources.R.drawable.outgoing_bubble);
        chatStyle.setOutgoingMessageBubbleColor(ru.tattelecom.intercom.android.resources.R.color.septenary);
        chatStyle.outgoingMessageBubbleBackground = ru.tattelecom.intercom.android.resources.R.drawable.outgoing_bubble;
        chatStyle.setOutgoingQuoteViewStyle(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.quinary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary));
        chatStyle.setCanShowSpecialistInfo(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.can_show_specialist_info));
        chatStyle.setInputEnabledDuringQuickReplies(getResources().getBoolean(ru.tattelecom.intercom.android.resources.R.bool.input_enabled_during_quick_replies));
        chatStyle.setFixedChatTitle(ru.tattelecom.intercom.android.resources.R.bool.chat_title_fixed);
        chatStyle.setVisibleChatSubtitle(ru.tattelecom.intercom.android.resources.R.bool.is_chat_subtitle_visible);
        chatStyle.searchEnabled = ru.tattelecom.intercom.android.resources.R.bool.is_search_enabled;
        companion.setMainTheme(chatStyle);
        applyLightTheme();
        applyDarkTheme();
    }

    private final void applyLightTheme() {
        EDNAChat.Companion companion = EDNAChat.INSTANCE;
        ChatStyle mainChatTheme = companion.getMainChatTheme();
        if (mainChatTheme != null) {
            mainChatTheme.welcomeScreenLogoResId = ru.tattelecom.intercom.android.resources.R.drawable.ic_messages_56;
            mainChatTheme.welcomeScreenLogoHeight = ru.tattelecom.intercom.android.resources.R.dimen.height_56;
            mainChatTheme.welcomeScreenLogoWidth = ru.tattelecom.intercom.android.resources.R.dimen.height_56;
            mainChatTheme.welcomeScreenTitleTextResId = ru.tattelecom.intercom.android.resources.R.string.chat_welcome_title;
            mainChatTheme.welcomeScreenTitleTextColorResId = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.welcomeScreenTitleSizeInSp = ru.tattelecom.intercom.android.resources.R.dimen.text_size_20;
            mainChatTheme.welcomeScreenSubtitleTextResId = ru.tattelecom.intercom.android.resources.R.string.chat_welcome_subtitle;
            mainChatTheme.welcomeScreenSubtitleTextColorResId = ru.tattelecom.intercom.android.resources.R.color.secondary;
            mainChatTheme.welcomeScreenSubtitleSizeInSp = ru.tattelecom.intercom.android.resources.R.dimen.text_size_15;
            mainChatTheme.enableLinkPreview();
            mainChatTheme.setChatTitleStyle(ru.tattelecom.intercom.android.resources.R.string.chat_support, ru.tattelecom.intercom.android.resources.R.string.empty_string, ru.tattelecom.intercom.android.resources.R.color.octavus, ru.tattelecom.intercom.android.resources.R.color.octavus, ru.tattelecom.intercom.android.resources.R.color.primary, ru.tattelecom.intercom.android.resources.R.color.octavus, ru.tattelecom.intercom.android.resources.R.bool.window_status_bar_light, ru.tattelecom.intercom.android.resources.R.color.primary, ru.tattelecom.intercom.android.resources.R.color.tertiary, true);
            mainChatTheme.setChatToolbarPopUpMenuIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_more_vertical);
            mainChatTheme.setChatToolbarReplyIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_reply_24);
            mainChatTheme.setChatToolbarInverseIconTintResId(ru.tattelecom.intercom.android.resources.R.color.octavus);
            mainChatTheme.chatToolbarTextColorResId = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.chatToolbarContentCopyIconResId = ru.tattelecom.intercom.android.resources.R.drawable.ic_copy_24;
            mainChatTheme.setChatBackgroundColor(ru.tattelecom.intercom.android.resources.R.color.septima);
            mainChatTheme.setChatBodyIconsTint(ru.tattelecom.intercom.android.resources.R.color.primary);
            mainChatTheme.setChatErrorScreenStyle(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_error_56), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.dimen.text_size_15), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.secondary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.dimen.text_size_15), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.octavus), ColorStateList.valueOf(getResources().getColor(ru.tattelecom.intercom.android.resources.R.color.button_bg_primary_states, null)), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.string.retry));
            mainChatTheme.setChatHighlightingColor(ru.tattelecom.intercom.android.resources.R.color.quinary);
            mainChatTheme.setScrollDownButtonStyle(ru.tattelecom.intercom.android.resources.R.drawable.ic_arrow_down_24, ru.tattelecom.intercom.android.resources.R.drawable.bg_round, ru.tattelecom.intercom.android.resources.R.dimen.margin_32, ru.tattelecom.intercom.android.resources.R.dimen.margin_32, ru.tattelecom.intercom.android.resources.R.dimen.margin_12, ru.tattelecom.intercom.android.resources.R.dimen.margin_4, ru.tattelecom.intercom.android.resources.R.color.red, ru.tattelecom.intercom.android.resources.R.color.octavus);
            mainChatTheme.setSystemMessageStyle(ROBOTO_REGULAR_FONT_PATH, Integer.valueOf(ru.tattelecom.intercom.android.resources.R.dimen.text_size_17), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.secondary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.dimen.margin_16), 17, Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary));
            mainChatTheme.chatSystemMessageTextColor = ru.tattelecom.intercom.android.resources.R.color.secondary;
            mainChatTheme.setOutgoingMessageTextColor(ru.tattelecom.intercom.android.resources.R.color.octavus);
            mainChatTheme.setOutgoingImageTimeBackgroundColor(ru.tattelecom.intercom.android.resources.R.color.color_overlay_primary_alpha);
            mainChatTheme.setOutgoingMessageTimeColor(ru.tattelecom.intercom.android.resources.R.color.octavus);
            mainChatTheme.outgoingDelimitersColor = ru.tattelecom.intercom.android.resources.R.color.octavus;
            mainChatTheme.setIncomingMessageTextColor(ru.tattelecom.intercom.android.resources.R.color.primary);
            mainChatTheme.setIncomingImageTimeBackgroundColor(ru.tattelecom.intercom.android.resources.R.color.color_overlay_primary_alpha);
            mainChatTheme.setIncomingMessageTimeColor(ru.tattelecom.intercom.android.resources.R.color.tertiary);
            mainChatTheme.incomingDelimitersColor = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.setMessageSendingResources(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_clock_16), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.octavus));
            mainChatTheme.setMessageSentResources(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_check_16), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.octavus));
            mainChatTheme.setMessageDeliveredResources(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_check_16), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.octavus));
            mainChatTheme.setMessageReadResources(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_double_check_16), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.octavus));
            mainChatTheme.messageNotSentErrorImageColor = ru.tattelecom.intercom.android.resources.R.color.red;
            mainChatTheme.messageNotSentBubbleBackgroundColor = ru.tattelecom.intercom.android.resources.R.color.septenary;
            mainChatTheme.setMessageFailedResources(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_error_circle_filled_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.red));
            mainChatTheme.setIncomingMessageLoaderColorResId(ru.tattelecom.intercom.android.resources.R.color.tertiary);
            mainChatTheme.setOutgoingMessageLoaderColorResId(ru.tattelecom.intercom.android.resources.R.color.tertiary);
            mainChatTheme.setIncomingMessageLinkColor(ru.tattelecom.intercom.android.resources.R.color.septenary);
            mainChatTheme.setOutgoingMessageLinkColor(ru.tattelecom.intercom.android.resources.R.color.octavus);
            mainChatTheme.setSendMessageIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_send_24);
            mainChatTheme.setAttachmentIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_attach_24);
            mainChatTheme.setSearchBarText(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.tertiary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.string.message_search_hint), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary));
            mainChatTheme.setSearchLoaderColorTint(ru.tattelecom.intercom.android.resources.R.color.tertiary);
            mainChatTheme.setSearchClearIconDrawable(ru.tattelecom.intercom.android.resources.R.drawable.ic_clear_circle_20);
            mainChatTheme.setSearchClearIconColor(ru.tattelecom.intercom.android.resources.R.color.tertiary);
            mainChatTheme.setSearchResultsDateTextColor(ru.tattelecom.intercom.android.resources.R.color.tertiary);
            mainChatTheme.setSearchResultsDividerColor(ru.tattelecom.intercom.android.resources.R.color.color_separator_primary_alpha);
            mainChatTheme.setSearchResultsRightArrow(null, null);
            mainChatTheme.setSearchResultsTextColors(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.primary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.secondary));
            mainChatTheme.setSearchResultsNoItemsElements(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_search_56), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.string.no_search_results), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.secondary));
            mainChatTheme.setConsultSearchingProgressColor(ru.tattelecom.intercom.android.resources.R.color.secondary);
            mainChatTheme.setAttachmentBottomSheetButtonTintResId(ru.tattelecom.intercom.android.resources.R.color.octavus);
            mainChatTheme.setAttachmentCameraIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_camera_24);
            mainChatTheme.setAttachmentGalleryIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_gallery_24);
            mainChatTheme.setAttachmentFileIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_file_24);
            mainChatTheme.setAttachmentSendIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_send_24);
            mainChatTheme.setSurveyStyle(Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_star_unselected_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_star_selected_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_star_unselected_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_star_selected_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_star_unselected_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.drawable.ic_star_selected_24), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.septenary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.tertiary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.tertiary), Integer.valueOf(ru.tattelecom.intercom.android.resources.R.color.tertiary));
            mainChatTheme.surveyFinalColorFilterResId = ru.tattelecom.intercom.android.resources.R.color.octavus;
            mainChatTheme.setLoaderTintResId(ru.tattelecom.intercom.android.resources.R.color.quaternary);
            mainChatTheme.emptyStateBackgroundColorResId = ru.tattelecom.intercom.android.resources.R.color.septima;
            mainChatTheme.emptyStateProgressBarColorResId = ru.tattelecom.intercom.android.resources.R.color.quaternary;
            mainChatTheme.emptyStateHintColorResId = ru.tattelecom.intercom.android.resources.R.color.secondary;
            mainChatTheme.setSwipeRefreshColors(ru.tattelecom.intercom.android.resources.R.array.swipe_refresh_colors);
            mainChatTheme.fileBrowserDialogStyleResId = ru.tattelecom.intercom.android.resources.R.style.CustomAlertDialog;
            mainChatTheme.setDownloadButtonTintResId(ru.tattelecom.intercom.android.resources.R.color.septenary);
            mainChatTheme.setDownloadButtonBackgroundTintResId(ru.tattelecom.intercom.android.resources.R.color.septima);
            mainChatTheme.setCompletedIconResId(ru.tattelecom.intercom.android.resources.R.drawable.ic_file_16);
            mainChatTheme.defaultOperatorAvatar = ru.tattelecom.intercom.android.resources.R.drawable.ic_operator_user_36;
            mainChatTheme.inputBackground = ru.tattelecom.intercom.android.resources.R.color.octavus;
            mainChatTheme.inputIconTintResId = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.chatMessageInputColor = ru.tattelecom.intercom.android.resources.R.color.octavus;
            mainChatTheme.inputHint = ru.tattelecom.intercom.android.resources.R.string.enter_message;
            mainChatTheme.inputTextColor = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.chatMessageInputHintTextColor = ru.tattelecom.intercom.android.resources.R.color.tertiary;
            mainChatTheme.imagesScreenBackgroundColor = ru.tattelecom.intercom.android.resources.R.color.septima;
            mainChatTheme.quickReplyTextColor = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.quickReplyButtonBackground = ru.tattelecom.intercom.android.resources.R.color.octavus;
            mainChatTheme.notificationQuickReplyMessageBackgroundColor = ru.tattelecom.intercom.android.resources.R.color.octavus;
            mainChatTheme.notificationQuickReplyMessageTextColor = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.quoteAttachmentIconResId = ru.tattelecom.intercom.android.resources.R.drawable.ic_reply_24;
            mainChatTheme.quoteClearIconResId = ru.tattelecom.intercom.android.resources.R.drawable.ic_close;
            mainChatTheme.quoteHeaderTextColor = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.quoteTextTextColor = ru.tattelecom.intercom.android.resources.R.color.primary;
            mainChatTheme.scheduleMessageIconResId = ru.tattelecom.intercom.android.resources.R.drawable.ic_chat_disabled_48;
            mainChatTheme.scheduleMessageTextColorResId = ru.tattelecom.intercom.android.resources.R.color.primary;
            companion.setLightTheme(mainChatTheme);
        }
    }

    private final void applyDarkTheme() {
        ChatStyle lightTheme = EDNAChat.INSTANCE.getLightTheme();
        if (lightTheme != null) {
            EDNAChat.INSTANCE.setDarkTheme(lightTheme);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        requireActivity().getSupportFragmentManager().setFragmentResult("DISPATCHER_SETTINGS", BundleKt.bundleOf(TuplesKt.to("canDispatch", true)));
    }
}
