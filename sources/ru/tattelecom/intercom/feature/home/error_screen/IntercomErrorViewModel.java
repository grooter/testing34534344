package ru.tattelecom.intercom.feature.home.error_screen;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntercomErrorViewModel.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lru/tattelecom/intercom/feature/home/error_screen/IntercomErrorViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "errorCode", "", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class IntercomErrorViewModel extends ViewModel {
    private final Integer errorCode;

    public IntercomErrorViewModel(SavedStateHandle handle) {
        Intrinsics.checkNotNullParameter(handle, "handle");
        this.errorCode = (Integer) handle.get("errorCode");
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }
}
