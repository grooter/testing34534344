package ru.tattelecom.intercom.feature.intercom_emergency_code;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.navigation.NavArg;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;

/* compiled from: IntercomEmergencyCodeViewModel.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/tattelecom/intercom/feature/intercom_emergency_code/IntercomEmergencyCodeViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "(Landroidx/lifecycle/SavedStateHandle;Lru/tattelecom/intercom/domain/interactors/LogInteractor;)V", NavArg.INTERCOM_EMERGENCY_CODE, "", "getIntercomEmergencyCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "reportEvent", "", "buttonId", "feature-intercom-emergency-code_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class IntercomEmergencyCodeViewModel extends ViewModel {
    private final Integer intercomEmergencyCode;
    private final LogInteractor logInteractor;

    public IntercomEmergencyCodeViewModel(SavedStateHandle handle, LogInteractor logInteractor) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        this.logInteractor = logInteractor;
        this.intercomEmergencyCode = (Integer) handle.get(NavArg.INTERCOM_EMERGENCY_CODE);
    }

    public final Integer getIntercomEmergencyCode() {
        return this.intercomEmergencyCode;
    }

    public final void reportEvent(int buttonId) {
        LogInteractor.reportEvent$default(this.logInteractor, buttonId, null, 2, null);
    }
}
