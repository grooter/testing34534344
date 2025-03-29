package ru.tattelecom.intercom.feature.welcome;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: WelcomeViewModel.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/welcome/WelcomeViewModel;", "Landroidx/lifecycle/ViewModel;", "userInteractor", "Lru/tattelecom/intercom/domain/interactors/UserInteractor;", "(Lru/tattelecom/intercom/domain/interactors/UserInteractor;)V", "setScreenShown", "", "welcome_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WelcomeViewModel extends ViewModel {
    private final UserInteractor userInteractor;

    public WelcomeViewModel(UserInteractor userInteractor) {
        Intrinsics.checkNotNullParameter(userInteractor, "userInteractor");
        this.userInteractor = userInteractor;
    }

    public final void setScreenShown() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new WelcomeViewModel$setScreenShown$1(this, null), 3, null);
    }
}
