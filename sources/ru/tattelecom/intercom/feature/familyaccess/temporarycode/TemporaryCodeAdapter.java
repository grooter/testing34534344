package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.tattelecom.intercom.feature.familyaccess.R;
import ru.tattelecom.intercom.feature.familyaccess.databinding.ItemTemporaryCodeBinding;

/* compiled from: TemporaryCodeAdapter.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001a\u001bB_\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00060\n¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bH\u0016Jn\u0010\u0015\u001a\u00020\u0006*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u001c\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00060\nH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeItem;", "Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeAdapter$ViewHolder;", "onGenerateCode", "Lkotlin/Function1;", "", "onRegenerateClick", "onRemoveCode", "onShareCode", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemTemporaryCodeBinding;", "item", "onRemoveClick", "onGenerateClick", "TemporaryCodeItemDiffUtil", "ViewHolder", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TemporaryCodeAdapter extends ListAdapter<TemporaryCodeItem, ViewHolder> {
    private final Function1<TemporaryCodeItem, Unit> onGenerateCode;
    private final Function1<TemporaryCodeItem, Unit> onRegenerateClick;
    private final Function1<TemporaryCodeItem, Unit> onRemoveCode;
    private final Function2<Integer, String, Unit> onShareCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TemporaryCodeAdapter(Function1<? super TemporaryCodeItem, Unit> onGenerateCode, Function1<? super TemporaryCodeItem, Unit> onRegenerateClick, Function1<? super TemporaryCodeItem, Unit> onRemoveCode, Function2<? super Integer, ? super String, Unit> onShareCode) {
        super(new TemporaryCodeItemDiffUtil());
        Intrinsics.checkNotNullParameter(onGenerateCode, "onGenerateCode");
        Intrinsics.checkNotNullParameter(onRegenerateClick, "onRegenerateClick");
        Intrinsics.checkNotNullParameter(onRemoveCode, "onRemoveCode");
        Intrinsics.checkNotNullParameter(onShareCode, "onShareCode");
        this.onGenerateCode = onGenerateCode;
        this.onRegenerateClick = onRegenerateClick;
        this.onRemoveCode = onRemoveCode;
        this.onShareCode = onShareCode;
    }

    /* compiled from: TemporaryCodeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemTemporaryCodeBinding;", "(Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemTemporaryCodeBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemTemporaryCodeBinding;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemTemporaryCodeBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemTemporaryCodeBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemTemporaryCodeBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemTemporaryCodeBinding inflate = ItemTemporaryCodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemTemporaryCodeBinding binding = holder.getBinding();
        TemporaryCodeItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bind(binding, item, this.onRemoveCode, this.onGenerateCode, this.onRegenerateClick, this.onShareCode);
    }

    private final void bind(ItemTemporaryCodeBinding itemTemporaryCodeBinding, final TemporaryCodeItem temporaryCodeItem, final Function1<? super TemporaryCodeItem, Unit> function1, final Function1<? super TemporaryCodeItem, Unit> function12, final Function1<? super TemporaryCodeItem, Unit> function13, final Function2<? super Integer, ? super String, Unit> function2) {
        if (temporaryCodeItem.isTemporaryCodeLoading()) {
            itemTemporaryCodeBinding.btnGenerateCode.setText(R.string.empty_string);
            itemTemporaryCodeBinding.btnGenerateCode.setEnabled(false);
            TextView tvTimeCode = itemTemporaryCodeBinding.tvTimeCode;
            Intrinsics.checkNotNullExpressionValue(tvTimeCode, "tvTimeCode");
            tvTimeCode.setVisibility(8);
            ImageButton btnShareCode = itemTemporaryCodeBinding.btnShareCode;
            Intrinsics.checkNotNullExpressionValue(btnShareCode, "btnShareCode");
            btnShareCode.setVisibility(8);
            ProgressBar progress = itemTemporaryCodeBinding.progress;
            Intrinsics.checkNotNullExpressionValue(progress, "progress");
            progress.setVisibility(0);
        } else {
            ProgressBar progress2 = itemTemporaryCodeBinding.progress;
            Intrinsics.checkNotNullExpressionValue(progress2, "progress");
            progress2.setVisibility(8);
            if (temporaryCodeItem.getTemporaryCode() == null) {
                itemTemporaryCodeBinding.btnGenerateCode.setText(R.string.generate);
                itemTemporaryCodeBinding.btnGenerateCode.setEnabled(true);
                TextView tvTimeCode2 = itemTemporaryCodeBinding.tvTimeCode;
                Intrinsics.checkNotNullExpressionValue(tvTimeCode2, "tvTimeCode");
                tvTimeCode2.setVisibility(8);
                ImageButton btnShareCode2 = itemTemporaryCodeBinding.btnShareCode;
                Intrinsics.checkNotNullExpressionValue(btnShareCode2, "btnShareCode");
                btnShareCode2.setVisibility(8);
            } else {
                itemTemporaryCodeBinding.btnGenerateCode.setText(R.string.empty_string);
                itemTemporaryCodeBinding.btnGenerateCode.setEnabled(false);
                TextView tvTimeCode3 = itemTemporaryCodeBinding.tvTimeCode;
                Intrinsics.checkNotNullExpressionValue(tvTimeCode3, "tvTimeCode");
                tvTimeCode3.setVisibility(0);
                ImageButton btnShareCode3 = itemTemporaryCodeBinding.btnShareCode;
                Intrinsics.checkNotNullExpressionValue(btnShareCode3, "btnShareCode");
                btnShareCode3.setVisibility(0);
            }
        }
        ImageButton btnRegenerateCode = itemTemporaryCodeBinding.btnRegenerateCode;
        Intrinsics.checkNotNullExpressionValue(btnRegenerateCode, "btnRegenerateCode");
        btnRegenerateCode.setVisibility(temporaryCodeItem.getTemporaryCode() != null ? 0 : 8);
        ImageButton btnDeleteCode = itemTemporaryCodeBinding.btnDeleteCode;
        Intrinsics.checkNotNullExpressionValue(btnDeleteCode, "btnDeleteCode");
        btnDeleteCode.setVisibility(temporaryCodeItem.getTemporaryCode() != null ? 0 : 8);
        itemTemporaryCodeBinding.tvAddress.setText(temporaryCodeItem.getAddress());
        itemTemporaryCodeBinding.tvTimeCode.setText(String.valueOf(temporaryCodeItem.getTemporaryCode()));
        itemTemporaryCodeBinding.btnGenerateCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemporaryCodeAdapter.bind$lambda$0(Function1.this, temporaryCodeItem, view);
            }
        });
        itemTemporaryCodeBinding.btnRegenerateCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemporaryCodeAdapter.bind$lambda$1(Function1.this, temporaryCodeItem, view);
            }
        });
        itemTemporaryCodeBinding.btnShareCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemporaryCodeAdapter.bind$lambda$2(Function2.this, temporaryCodeItem, view);
            }
        });
        itemTemporaryCodeBinding.btnDeleteCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TemporaryCodeAdapter.bind$lambda$3(Function1.this, temporaryCodeItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(Function1 onGenerateClick, TemporaryCodeItem item, View view) {
        Intrinsics.checkNotNullParameter(onGenerateClick, "$onGenerateClick");
        Intrinsics.checkNotNullParameter(item, "$item");
        onGenerateClick.invoke(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(Function1 onRegenerateClick, TemporaryCodeItem item, View view) {
        Intrinsics.checkNotNullParameter(onRegenerateClick, "$onRegenerateClick");
        Intrinsics.checkNotNullParameter(item, "$item");
        onRegenerateClick.invoke(item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2(Function2 onShareCode, TemporaryCodeItem item, View view) {
        Intrinsics.checkNotNullParameter(onShareCode, "$onShareCode");
        Intrinsics.checkNotNullParameter(item, "$item");
        Integer temporaryCode = item.getTemporaryCode();
        String address = item.getAddress();
        onShareCode.invoke(temporaryCode, address != null ? StringsKt.substringBeforeLast$default(address, ", кв", (String) null, 2, (Object) null) : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$3(Function1 onRemoveClick, TemporaryCodeItem item, View view) {
        Intrinsics.checkNotNullParameter(onRemoveClick, "$onRemoveClick");
        Intrinsics.checkNotNullParameter(item, "$item");
        onRemoveClick.invoke(item);
    }

    /* compiled from: TemporaryCodeAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeAdapter$TemporaryCodeItemDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/feature/familyaccess/temporarycode/TemporaryCodeItem;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TemporaryCodeItemDiffUtil extends DiffUtil.ItemCallback<TemporaryCodeItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(TemporaryCodeItem old, TemporaryCodeItem r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return old.getApartmentId() == r3.getApartmentId();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(TemporaryCodeItem old, TemporaryCodeItem r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old, r3);
        }
    }
}
