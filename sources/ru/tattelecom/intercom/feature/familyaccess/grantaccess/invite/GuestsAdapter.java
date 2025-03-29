package ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite;

import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.familyaccess.databinding.ItemApartmentBinding;
import ru.tattelecom.intercom.feature.familyaccess.databinding.ItemGuestBinding;

/* compiled from: GuestsAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0014\u0010\u0010\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0015H\u0002¨\u0006\u0019"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "getByPosition", "position", "", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemApartmentBinding;", "item", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/ApartmentItem;", "Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemGuestBinding;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestItem;", "ApartmentViewHolder", "GuestViewHolder", "InviteItemDiffUtil", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GuestsAdapter extends ListAdapter<InviteItem, RecyclerView.ViewHolder> {
    public GuestsAdapter() {
        super(new InviteItemDiffUtil());
    }

    /* compiled from: GuestsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestsAdapter$ApartmentViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemApartmentBinding;", "(Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemApartmentBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemApartmentBinding;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class ApartmentViewHolder extends RecyclerView.ViewHolder {
        private final ItemApartmentBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ApartmentViewHolder(ItemApartmentBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemApartmentBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: GuestsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestsAdapter$GuestViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemGuestBinding;", "(Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemGuestBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/familyaccess/databinding/ItemGuestBinding;", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class GuestViewHolder extends RecyclerView.ViewHolder {
        private final ItemGuestBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuestViewHolder(ItemGuestBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemGuestBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            ItemApartmentBinding inflate = ItemApartmentBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new ApartmentViewHolder(inflate);
        }
        ItemGuestBinding inflate2 = ItemGuestBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new GuestViewHolder(inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof ApartmentViewHolder) {
            ItemApartmentBinding binding = ((ApartmentViewHolder) holder).getBinding();
            InviteItem item = getItem(position);
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.ApartmentItem");
            bind(binding, (ApartmentItem) item);
            return;
        }
        if (holder instanceof GuestViewHolder) {
            ItemGuestBinding binding2 = ((GuestViewHolder) holder).getBinding();
            InviteItem item2 = getItem(position);
            Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.familyaccess.grantaccess.invite.GuestItem");
            bind(binding2, (GuestItem) item2);
        }
    }

    private final void bind(ItemApartmentBinding itemApartmentBinding, ApartmentItem apartmentItem) {
        itemApartmentBinding.tvApartment.setText(apartmentItem.getTitle());
    }

    private final void bind(ItemGuestBinding itemGuestBinding, GuestItem guestItem) {
        itemGuestBinding.tvPhone.setText(PhoneNumberUtils.formatNumber(guestItem.getPhone(), "RU"));
    }

    public final InviteItem getByPosition(int position) {
        InviteItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        return item;
    }

    /* compiled from: GuestsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/GuestsAdapter$InviteItemDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/feature/familyaccess/grantaccess/invite/InviteItem;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "feature-family-access_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class InviteItemDiffUtil extends DiffUtil.ItemCallback<InviteItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(InviteItem old, InviteItem r6) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r6, "new");
            if ((old instanceof GuestItem) && (r6 instanceof GuestItem)) {
                GuestItem guestItem = (GuestItem) old;
                GuestItem guestItem2 = (GuestItem) r6;
                if (Intrinsics.areEqual(guestItem.getPhone(), guestItem2.getPhone()) && guestItem.getApartmentId() == guestItem2.getApartmentId()) {
                    return true;
                }
            } else if ((old instanceof ApartmentItem) && (r6 instanceof ApartmentItem) && ((ApartmentItem) old).getId() == ((ApartmentItem) r6).getId()) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(InviteItem old, InviteItem r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            if ((old instanceof ApartmentItem) && (r3 instanceof ApartmentItem)) {
                return Intrinsics.areEqual((ApartmentItem) old, (ApartmentItem) r3);
            }
            if ((old instanceof GuestItem) && (r3 instanceof GuestItem)) {
                return Intrinsics.areEqual((GuestItem) old, (GuestItem) r3);
            }
            return false;
        }
    }
}
