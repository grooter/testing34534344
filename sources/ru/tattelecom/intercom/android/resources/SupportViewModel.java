package ru.tattelecom.intercom.android.resources;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.huawei.hms.push.AttributionReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import ru.tattelecom.intercom.domain.interactors.SupportInteractor;
import ru.tattelecom.intercom.domain.model.SupportContactDto;
import ru.tattelecom.intercom.domain.model.SupportDtosKt;

/* compiled from: SupportViewModel.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0002 !B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0017\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/tattelecom/intercom/android/resources/SupportViewModel;", "Landroidx/lifecycle/ViewModel;", "supportInteractor", "Lru/tattelecom/intercom/domain/interactors/SupportInteractor;", "(Lru/tattelecom/intercom/domain/interactors/SupportInteractor;)V", "_isLoading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_supportContacts", "Lru/tattelecom/intercom/domain/model/SupportContactDto;", "isChatClicked", "()Z", "setChatClicked", "(Z)V", "isLoading", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "policy", "", "getPolicy", "supportContacts", "getSupportContacts", "getCallContact", "contactsDto", "getTelegramContact", "getTitle", "default", "resetSupportContacts", "", AttributionReporter.APP_VERSION, "resetSupportContactsWithAuth", "updatePolicy", "ChatAction", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SupportViewModel extends ViewModel {
    public static final String DEFAULT_PHONE_NUMBER = "+78432222222";
    private final MutableStateFlow<Boolean> _isLoading;
    private final MutableStateFlow<SupportContactDto> _supportContacts;
    private boolean isChatClicked;
    private final StateFlow<Boolean> isLoading;
    private final StateFlow<String> policy;
    private final StateFlow<SupportContactDto> supportContacts;
    private final SupportInteractor supportInteractor;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex regex = new Regex("\\+(\\d)(\\d{3})(\\d{3})(\\d{2})(\\d{2})");

    public SupportViewModel(SupportInteractor supportInteractor) {
        Intrinsics.checkNotNullParameter(supportInteractor, "supportInteractor");
        this.supportInteractor = supportInteractor;
        MutableStateFlow<SupportContactDto> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._supportContacts = MutableStateFlow;
        this.supportContacts = FlowKt.asStateFlow(MutableStateFlow);
        this.policy = supportInteractor.getPolicyFlow();
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(null);
        this._isLoading = MutableStateFlow2;
        this.isLoading = FlowKt.asStateFlow(MutableStateFlow2);
    }

    public final StateFlow<SupportContactDto> getSupportContacts() {
        return this.supportContacts;
    }

    public final StateFlow<String> getPolicy() {
        return this.policy;
    }

    public final StateFlow<Boolean> isLoading() {
        return this.isLoading;
    }

    /* renamed from: isChatClicked, reason: from getter */
    public final boolean getIsChatClicked() {
        return this.isChatClicked;
    }

    public final void setChatClicked(boolean z) {
        this.isChatClicked = z;
    }

    public final void updatePolicy() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SupportViewModel$updatePolicy$1(this, null), 3, null);
    }

    public final void resetSupportContacts(String appVersion) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SupportViewModel$resetSupportContacts$1(this, appVersion, null), 3, null);
    }

    public final void resetSupportContactsWithAuth() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SupportViewModel$resetSupportContactsWithAuth$1(this, null), 3, null);
    }

    public final String getTitle(SupportContactDto contactsDto, String r3) {
        Intrinsics.checkNotNullParameter(contactsDto, "contactsDto");
        Intrinsics.checkNotNullParameter(r3, "default");
        return (contactsDto.isError() && StringsKt.isBlank(contactsDto.getTitle()) && contactsDto.getContacts().isEmpty()) ? r3 : contactsDto.getTitle();
    }

    public final String getCallContact(SupportContactDto contactsDto) {
        Boolean isEnabled;
        Intrinsics.checkNotNullParameter(contactsDto, "contactsDto");
        if (contactsDto.isError() && contactsDto.getContacts().isEmpty()) {
            return DEFAULT_PHONE_NUMBER;
        }
        SupportContactDto.Item contact = SupportDtosKt.getContact(contactsDto.getContacts(), SupportContactDto.Type.CALL_PHONE);
        if (!((contact == null || (isEnabled = contact.isEnabled()) == null) ? false : isEnabled.booleanValue()) || contact == null) {
            return null;
        }
        return contact.getValue();
    }

    public final String getTelegramContact(SupportContactDto contactsDto) {
        Intrinsics.checkNotNullParameter(contactsDto, "contactsDto");
        SupportContactDto.Item contact = SupportDtosKt.getContact(contactsDto.getContacts(), SupportContactDto.Type.TELEGRAM);
        boolean z = true;
        if (contact != null ? Intrinsics.areEqual((Object) contact.isEnabled(), (Object) true) : false) {
            String value = contact.getValue();
            if (value != null && !StringsKt.isBlank(value)) {
                z = false;
            }
            if (!z) {
                return contact.getValue();
            }
        }
        return null;
    }

    /* compiled from: SupportViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/android/resources/SupportViewModel$Companion;", "", "()V", "DEFAULT_PHONE_NUMBER", "", "regex", "Lkotlin/text/Regex;", "formatPhoneNumber", "phoneNumber", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String formatPhoneNumber$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = SupportViewModel.DEFAULT_PHONE_NUMBER;
            }
            return companion.formatPhoneNumber(str);
        }

        public final String formatPhoneNumber(String phoneNumber) {
            Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
            return SupportViewModel.regex.replace(phoneNumber, "+$1 ($2) $3-$4-$5");
        }
    }

    /* compiled from: SupportViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lru/tattelecom/intercom/android/resources/SupportViewModel$ChatAction;", "", "()V", "OPEN_CHAT", "", "OPEN_MODAL", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ChatAction {
        public static final ChatAction INSTANCE = new ChatAction();
        public static final String OPEN_CHAT = "open-chat";
        public static final String OPEN_MODAL = "open-modal";

        private ChatAction() {
        }
    }
}
