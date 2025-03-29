package ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet;

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
import ru.tattelecom.intercom.feature.videoplayer.SpeedPlayback;
import ru.tattelecom.intercom.feature.videoplayer.databinding.ItemCheckableBinding;

/* compiled from: SpeedPlaybackAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0013\u0014B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u00020\u0006*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/speedBottomSheet/SpeedPlaybackAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/videoplayer/SpeedPlayback;", "Lru/tattelecom/intercom/feature/videoplayer/speedBottomSheet/SpeedPlaybackAdapter$ViewHolder;", "onSpeedClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;", "item", "SpeedPlaybackDiffUtil", "ViewHolder", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SpeedPlaybackAdapter extends ListAdapter<SpeedPlayback, ViewHolder> {
    private final Function1<SpeedPlayback, Unit> onSpeedClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpeedPlaybackAdapter(Function1<? super SpeedPlayback, Unit> onSpeedClick) {
        super(new SpeedPlaybackDiffUtil());
        Intrinsics.checkNotNullParameter(onSpeedClick, "onSpeedClick");
        this.onSpeedClick = onSpeedClick;
    }

    /* compiled from: SpeedPlaybackAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/speedBottomSheet/SpeedPlaybackAdapter$SpeedPlaybackDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/feature/videoplayer/SpeedPlayback;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SpeedPlaybackDiffUtil extends DiffUtil.ItemCallback<SpeedPlayback> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(SpeedPlayback old, SpeedPlayback r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return old.getValue() == r3.getValue();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(SpeedPlayback old, SpeedPlayback r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old, r3);
        }
    }

    /* compiled from: SpeedPlaybackAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/speedBottomSheet/SpeedPlaybackAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;", "(Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemCheckableBinding;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
        SpeedPlayback item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bind(binding, item);
    }

    private final void bind(ItemCheckableBinding itemCheckableBinding, final SpeedPlayback speedPlayback) {
        itemCheckableBinding.tvText.setText(speedPlayback.getText());
        ImageView isChecked = itemCheckableBinding.isChecked;
        Intrinsics.checkNotNullExpressionValue(isChecked, "isChecked");
        isChecked.setVisibility(speedPlayback.isSelected() ? 0 : 8);
        itemCheckableBinding.clRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.speedBottomSheet.SpeedPlaybackAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SpeedPlaybackAdapter.bind$lambda$1(SpeedPlaybackAdapter.this, speedPlayback, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(SpeedPlaybackAdapter this$0, SpeedPlayback item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onSpeedClick.invoke(SpeedPlayback.copy$default(item, null, 0.0f, true, 3, null));
    }
}
