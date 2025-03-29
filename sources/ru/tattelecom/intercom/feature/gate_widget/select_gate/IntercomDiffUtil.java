package ru.tattelecom.intercom.feature.gate_widget.select_gate;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.entity.IntercomEntity;

/* compiled from: GatesAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/gate_widget/select_gate/IntercomDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/data/local/entity/IntercomEntity;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "feature-gate-widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class IntercomDiffUtil extends DiffUtil.ItemCallback<IntercomEntity> {
    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areItemsTheSame(IntercomEntity old, IntercomEntity r3) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(r3, "new");
        return old.getId() == r3.getId();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public boolean areContentsTheSame(IntercomEntity old, IntercomEntity r3) {
        Intrinsics.checkNotNullParameter(old, "old");
        Intrinsics.checkNotNullParameter(r3, "new");
        return Intrinsics.areEqual(old, r3);
    }
}
