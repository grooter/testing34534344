package ru.tattelecom.intercom.feature.profile_details;

import android.telephony.PhoneNumberUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.domain.interactors.AuthInteractor;

/* compiled from: ProfileDetailsViewModel.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lru/tattelecom/intercom/feature/profile_details/ProfileDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "authInteractor", "Lru/tattelecom/intercom/domain/interactors/AuthInteractor;", "(Lru/tattelecom/intercom/domain/interactors/AuthInteractor;)V", "_phoneNumberLD", "Landroidx/lifecycle/MutableLiveData;", "", "phoneNumberLD", "getPhoneNumberLD", "()Landroidx/lifecycle/MutableLiveData;", "getPhoneNumber", "", "feature-profile-details_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ProfileDetailsViewModel extends ViewModel {
    private final MutableLiveData<String> _phoneNumberLD;
    private final AuthInteractor authInteractor;
    private final MutableLiveData<String> phoneNumberLD;

    public ProfileDetailsViewModel(AuthInteractor authInteractor) {
        Intrinsics.checkNotNullParameter(authInteractor, "authInteractor");
        this.authInteractor = authInteractor;
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._phoneNumberLD = mutableLiveData;
        this.phoneNumberLD = mutableLiveData;
        getPhoneNumber();
    }

    public final MutableLiveData<String> getPhoneNumberLD() {
        return this.phoneNumberLD;
    }

    private final void getPhoneNumber() {
        String phone = this.authInteractor.getPhone();
        this._phoneNumberLD.setValue(phone == null ? "" : PhoneNumberUtils.formatNumber(phone, "RU"));
    }
}
