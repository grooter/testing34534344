package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SelectItemViewModel.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/downloadBottomSheet/SelectItemViewModel;", "Landroidx/lifecycle/ViewModel;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", SelectItemDialog.ARG_LIST, "", "", "getList", "()Ljava/util/List;", "selectedId", "", "getSelectedId", "()I", "type", "getType", "()Ljava/lang/String;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SelectItemViewModel extends ViewModel {
    private final List<String> list;
    private final int selectedId;
    private final String type;

    public SelectItemViewModel(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        this.list = (List) savedStateHandle.get(SelectItemDialog.ARG_LIST);
        this.type = (String) savedStateHandle.get("type");
        Integer num = (Integer) savedStateHandle.get(SelectItemDialog.ARG_POS);
        this.selectedId = num != null ? num.intValue() : 0;
    }

    public final List<String> getList() {
        return this.list;
    }

    public final String getType() {
        return this.type;
    }

    public final int getSelectedId() {
        return this.selectedId;
    }
}
