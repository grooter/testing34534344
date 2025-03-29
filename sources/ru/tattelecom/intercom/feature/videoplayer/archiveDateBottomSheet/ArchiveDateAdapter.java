package ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.databinding.ItemCheckableBinding;

/* compiled from: ArchiveDateAdapter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u0014\u0010\u0010\u001a\u00020\u0007*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDateAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDate;", "Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDateAdapter$ViewHolder;", "onDayClick", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;", "item", "ArchiveDateDiffUtil", "ViewHolder", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class ArchiveDateAdapter extends ListAdapter<ArchiveDate, ViewHolder> {
    private final Function1<Integer, Unit> onDayClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ArchiveDateAdapter(Function1<? super Integer, Unit> onDayClick) {
        super(new ArchiveDateDiffUtil());
        Intrinsics.checkNotNullParameter(onDayClick, "onDayClick");
        this.onDayClick = onDayClick;
    }

    /* compiled from: ArchiveDateAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDateAdapter$ArchiveDateDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDate;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ArchiveDateDiffUtil extends DiffUtil.ItemCallback<ArchiveDate> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(ArchiveDate old, ArchiveDate r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old.getText(), r3.getText());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(ArchiveDate old, ArchiveDate r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old, r3);
        }
    }

    /* compiled from: ArchiveDateAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/archiveDateBottomSheet/ArchiveDateAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;", "(Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemCheckableBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemCheckableBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemCheckableBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemCheckableBinding inflate = ItemCheckableBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemCheckableBinding binding = holder.getBinding();
        ArchiveDate item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bind(binding, item);
    }

    private final void bind(ItemCheckableBinding itemCheckableBinding, final ArchiveDate archiveDate) {
        itemCheckableBinding.tvText.setText(archiveDate.getText());
        ImageView isChecked = itemCheckableBinding.isChecked;
        Intrinsics.checkNotNullExpressionValue(isChecked, "isChecked");
        isChecked.setVisibility(archiveDate.isSelected() ? 0 : 8);
        if (archiveDate.isCheckable()) {
            itemCheckableBinding.clRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet.ArchiveDateAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ArchiveDateAdapter.bind$lambda$1(ArchiveDateAdapter.this, archiveDate, view);
                }
            });
        } else {
            itemCheckableBinding.clRoot.setAlpha(0.48f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(ArchiveDateAdapter this$0, ArchiveDate item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onDayClick.invoke(Integer.valueOf(item.getId()));
    }
}
