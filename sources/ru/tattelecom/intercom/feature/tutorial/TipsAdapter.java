package ru.tattelecom.intercom.feature.tutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.tutorial.databinding.ItemTipBinding;

/* compiled from: TipsAdapter.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0002¨\u0006\u0013"}, d2 = {"Lru/tattelecom/intercom/feature/tutorial/TipsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/tutorial/TipDto;", "Lru/tattelecom/intercom/feature/tutorial/TipsAdapter$ViewHolder;", "()V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/tutorial/databinding/ItemTipBinding;", "item", "TipDiffUtil", "ViewHolder", "feature-tutorial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TipsAdapter extends ListAdapter<TipDto, ViewHolder> {
    public TipsAdapter() {
        super(new TipDiffUtil());
    }

    /* compiled from: TipsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/tutorial/TipsAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/tutorial/databinding/ItemTipBinding;", "(Lru/tattelecom/intercom/feature/tutorial/databinding/ItemTipBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/tutorial/databinding/ItemTipBinding;", "feature-tutorial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemTipBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemTipBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemTipBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTipBinding inflate = ItemTipBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemTipBinding binding = holder.getBinding();
        TipDto item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bind(binding, item);
    }

    private final void bind(ItemTipBinding itemTipBinding, final TipDto tipDto) {
        try {
            Glide.with(itemTipBinding.getRoot().getContext()).load(Integer.valueOf(tipDto.getImageResId())).fitCenter().into(itemTipBinding.ivImage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        itemTipBinding.btnContinue.setText(itemTipBinding.getRoot().getContext().getString(tipDto.getButtonText()));
        itemTipBinding.btnContinue.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.tutorial.TipsAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TipsAdapter.bind$lambda$0(TipDto.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(TipDto item, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        item.getButtonCallback().invoke();
    }

    /* compiled from: TipsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/tutorial/TipsAdapter$TipDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/feature/tutorial/TipDto;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "feature-tutorial_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TipDiffUtil extends DiffUtil.ItemCallback<TipDto> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(TipDto old, TipDto r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old, r3);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(TipDto old, TipDto r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old.getName(), r3.getName());
        }
    }
}
