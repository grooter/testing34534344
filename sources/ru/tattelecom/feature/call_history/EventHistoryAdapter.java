package ru.tattelecom.feature.call_history;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.paging.PagingDataAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.stfalcon.imageviewer.StfalconImageViewer;
import com.stfalcon.imageviewer.loader.ImageLoader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.feature.call_history.databinding.ItemBannerBinding;
import ru.tattelecom.feature.call_history.databinding.ItemEventBinding;
import ru.tattelecom.intercom.android.resources.blur.GlideBlurTransformation;
import ru.tattelecom.intercom.data.remote.source.paging.EventHistory;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryBanner;
import ru.tattelecom.intercom.data.remote.source.paging.HistoryItem;

/* compiled from: EventHistoryAdapter.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#$BO\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ6\u0010\u001e\u001a\u00020\u0006*\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0014\u0010\u001e\u001a\u00020\u0006*\u00020!2\u0006\u0010 \u001a\u00020\"H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lru/tattelecom/feature/call_history/EventHistoryAdapter;", "Landroidx/paging/PagingDataAdapter;", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onEventClick", "Lkotlin/Function1;", "", "onEventImageClick", "onCloseClick", "Lkotlin/Function0;", "onLeaveOrderClick", "Lru/tattelecom/intercom/data/remote/source/paging/HistoryBanner;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "expandedImageView", "Landroid/widget/ImageView;", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getByPosition", "position", "", "getItemViewType", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onImageLoaded", "image", "", "bind", "Lru/tattelecom/feature/call_history/databinding/ItemBannerBinding;", "item", "Lru/tattelecom/feature/call_history/databinding/ItemEventBinding;", "Lru/tattelecom/intercom/data/remote/source/paging/EventHistory;", "BannerViewHolder", "EventViewHolder", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EventHistoryAdapter extends PagingDataAdapter<HistoryItem, RecyclerView.ViewHolder> {
    private ImageView expandedImageView;
    private final Function0<Unit> onCloseClick;
    private final Function1<HistoryItem, Unit> onEventClick;
    private final Function1<HistoryItem, Unit> onEventImageClick;
    private final Function1<HistoryBanner, Unit> onLeaveOrderClick;
    private final SimpleDateFormat timeFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventHistoryAdapter(Function1<? super HistoryItem, Unit> onEventClick, Function1<? super HistoryItem, Unit> onEventImageClick, Function0<Unit> onCloseClick, Function1<? super HistoryBanner, Unit> onLeaveOrderClick) {
        super(new EventHistoryDiffUtil(), (CoroutineContext) null, (CoroutineContext) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(onEventClick, "onEventClick");
        Intrinsics.checkNotNullParameter(onEventImageClick, "onEventImageClick");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Intrinsics.checkNotNullParameter(onLeaveOrderClick, "onLeaveOrderClick");
        this.onEventClick = onEventClick;
        this.onEventImageClick = onEventImageClick;
        this.onCloseClick = onCloseClick;
        this.onLeaveOrderClick = onLeaveOrderClick;
        this.timeFormatter = new SimpleDateFormat("d MMMM HH:mm", new Locale("RU"));
    }

    /* compiled from: EventHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/feature/call_history/EventHistoryAdapter$BannerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/feature/call_history/databinding/ItemBannerBinding;", "(Lru/tattelecom/feature/call_history/databinding/ItemBannerBinding;)V", "getBinding", "()Lru/tattelecom/feature/call_history/databinding/ItemBannerBinding;", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BannerViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BannerViewHolder(ItemBannerBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemBannerBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: EventHistoryAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/feature/call_history/EventHistoryAdapter$EventViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/feature/call_history/databinding/ItemEventBinding;", "(Lru/tattelecom/feature/call_history/databinding/ItemEventBinding;)V", "getBinding", "()Lru/tattelecom/feature/call_history/databinding/ItemEventBinding;", "feature-call-history_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EventViewHolder extends RecyclerView.ViewHolder {
        private final ItemEventBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventViewHolder(ItemEventBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemEventBinding getBinding() {
            return this.binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        HistoryItem item = getItem(position);
        if (item != null) {
            return item.getType();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        if (viewType != 1) {
            ItemEventBinding inflate = ItemEventBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new EventViewHolder(inflate);
        }
        ItemBannerBinding inflate2 = ItemBannerBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
        return new BannerViewHolder(inflate2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        HistoryItem item = getItem(position);
        if (holder instanceof BannerViewHolder) {
            ItemBannerBinding binding = ((BannerViewHolder) holder).getBinding();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.source.paging.HistoryBanner");
            bind(binding, (HistoryBanner) item, this.onCloseClick, this.onLeaveOrderClick);
        } else if (holder instanceof EventViewHolder) {
            ItemEventBinding binding2 = ((EventViewHolder) holder).getBinding();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type ru.tattelecom.intercom.data.remote.source.paging.EventHistory");
            bind(binding2, (EventHistory) item);
        }
    }

    private final void bind(ItemBannerBinding itemBannerBinding, final HistoryBanner historyBanner, final Function0<Unit> function0, final Function1<? super HistoryBanner, Unit> function1) {
        itemBannerBinding.btnClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventHistoryAdapter.bind$lambda$1(Function0.this, view);
            }
        });
        itemBannerBinding.btnBecomeSubscriber.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventHistoryAdapter.bind$lambda$2(Function1.this, historyBanner, view);
            }
        });
        itemBannerBinding.tvAttentionTitle.setText(historyBanner.getBannerTitle());
        itemBannerBinding.tvAttentionInfo.setText(historyBanner.getBannerInfo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(Function0 onCloseClick, View view) {
        Intrinsics.checkNotNullParameter(onCloseClick, "$onCloseClick");
        onCloseClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2(Function1 onLeaveOrderClick, HistoryBanner item, View view) {
        Intrinsics.checkNotNullParameter(onLeaveOrderClick, "$onLeaveOrderClick");
        Intrinsics.checkNotNullParameter(item, "$item");
        onLeaveOrderClick.invoke(item);
    }

    private final void bind(final ItemEventBinding itemEventBinding, final EventHistory eventHistory) {
        int i;
        itemEventBinding.tvTime.setText(this.timeFormatter.format(new Date(eventHistory.getTime() * 1000)));
        TextView tvTime = itemEventBinding.tvTime;
        Intrinsics.checkNotNullExpressionValue(tvTime, "tvTime");
        tvTime.setVisibility(eventHistory.getStreamIsAvailable() ? 0 : 8);
        itemEventBinding.tvAddress.setText(eventHistory.getAddress());
        itemEventBinding.tvName.setText(eventHistory.getGate());
        TextView textView = itemEventBinding.tvEvent;
        int type = eventHistory.getType();
        if (type == 3) {
            i = R.string.call;
        } else if (type == 4) {
            i = R.string.key;
        } else if (type == 5) {
            i = R.string.code_pass;
        } else {
            i = R.string.call;
        }
        textView.setText(i);
        if (eventHistory.getStreamIsAvailable()) {
            Glide.with(itemEventBinding.getRoot().getContext()).load(Base64.decode(eventHistory.getSnapshot(), 0)).error(R.color.silver).transform(new CenterCrop()).into(itemEventBinding.ivSnapshot);
        } else {
            RequestBuilder error = Glide.with(itemEventBinding.getRoot().getContext()).load(Base64.decode(eventHistory.getSnapshot(), 0)).error(R.color.silver);
            Context context = itemEventBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            error.transform(new CenterCrop(), new GlideBlurTransformation(context, 25, 2)).into(itemEventBinding.ivSnapshot);
        }
        itemEventBinding.cvRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.feature.call_history.EventHistoryAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventHistoryAdapter.bind$lambda$4(EventHistory.this, this, itemEventBinding, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$4(EventHistory item, final EventHistoryAdapter this$0, ItemEventBinding this_bind, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_bind, "$this_bind");
        String streamUrl = item.getStreamUrl();
        if (streamUrl != null && streamUrl.length() != 0) {
            this$0.onEventClick.invoke(item);
        } else if (item.getSnapshot().length() > 0) {
            this$0.onEventImageClick.invoke(item);
            new StfalconImageViewer.Builder(this_bind.getRoot().getContext(), new String[]{item.getSnapshot()}, new ImageLoader() { // from class: ru.tattelecom.feature.call_history.EventHistoryAdapter$$ExternalSyntheticLambda3
                @Override // com.stfalcon.imageviewer.loader.ImageLoader
                public final void loadImage(ImageView imageView, Object obj) {
                    EventHistoryAdapter.bind$lambda$4$lambda$3(EventHistoryAdapter.this, imageView, (String) obj);
                }
            }).withBackgroundColorResource(R.color.app_bar_scrim).withHiddenStatusBar(false).withTransitionFrom(this_bind.ivSnapshot).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$4$lambda$3(EventHistoryAdapter this$0, ImageView imageView, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.expandedImageView = imageView;
        this$0.onImageLoaded(str);
    }

    public final void onImageLoaded(String image) {
        ImageView imageView = this.expandedImageView;
        if (imageView != null) {
            Glide.with(imageView.getContext()).load(Base64.decode(image, 0)).fitCenter().into(imageView);
        }
    }

    public final HistoryItem getByPosition(int position) {
        return getItem(position);
    }
}
