package ru.tattelecom.intercom.feature.office_map.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.office_map.R;
import ru.tattelecom.intercom.feature.office_map.databinding.ItemFilterMapBinding;

/* compiled from: OfficeServiceAdapter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u00020\u0006*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/main/OfficeServiceAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/office_map/main/OfficeService;", "Lru/tattelecom/intercom/feature/office_map/main/OfficeServiceAdapter$ViewHolder;", "onClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/office_map/databinding/ItemFilterMapBinding;", "item", "ViewHolder", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class OfficeServiceAdapter extends ListAdapter<OfficeService, ViewHolder> {
    private final Function1<OfficeService, Unit> onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public OfficeServiceAdapter(Function1<? super OfficeService, Unit> onClick) {
        super(new OfficeServiceDiffUtil());
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClick = onClick;
    }

    /* compiled from: OfficeServiceAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/office_map/main/OfficeServiceAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/office_map/databinding/ItemFilterMapBinding;", "(Lru/tattelecom/intercom/feature/office_map/databinding/ItemFilterMapBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/office_map/databinding/ItemFilterMapBinding;", "feature-office-map_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemFilterMapBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemFilterMapBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemFilterMapBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemFilterMapBinding inflate = ItemFilterMapBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ItemFilterMapBinding binding = holder.getBinding();
        OfficeService item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        bind(binding, item);
    }

    private final void bind(ItemFilterMapBinding itemFilterMapBinding, final OfficeService officeService) {
        ImageView iconFilter = itemFilterMapBinding.iconFilter;
        Intrinsics.checkNotNullExpressionValue(iconFilter, "iconFilter");
        iconFilter.setVisibility(officeService.getId() == -2 ? 0 : 8);
        itemFilterMapBinding.filterName.setText(officeService.getName());
        if (officeService.isSelected()) {
            itemFilterMapBinding.filterName.setTextColor(ContextCompat.getColor(itemFilterMapBinding.getRoot().getContext(), R.color.septenary));
        } else {
            itemFilterMapBinding.filterName.setTextColor(ContextCompat.getColor(itemFilterMapBinding.getRoot().getContext(), R.color.primary));
        }
        if (officeService.getSelectedCount() > 0) {
            TextView counter = itemFilterMapBinding.counter;
            Intrinsics.checkNotNullExpressionValue(counter, "counter");
            counter.setVisibility(0);
            itemFilterMapBinding.counter.setText(String.valueOf(officeService.getSelectedCount()));
        } else {
            TextView counter2 = itemFilterMapBinding.counter;
            Intrinsics.checkNotNullExpressionValue(counter2, "counter");
            counter2.setVisibility(8);
        }
        itemFilterMapBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.office_map.main.OfficeServiceAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OfficeServiceAdapter.bind$lambda$0(OfficeServiceAdapter.this, officeService, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$0(OfficeServiceAdapter this$0, OfficeService item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onClick.invoke(item);
    }
}
