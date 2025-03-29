package ru.tattelecom.intercom.feature.videoplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.videoplayer.databinding.ItemPlayerEventBinding;
import ru.tattelecom.intercom.feature.videoplayer.model.EventItem;

/* compiled from: EventsAdapter.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u0012\u001e\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cH\u0016J\u0014\u0010\"\u001a\u00020\t*\u00020#2\u0006\u0010$\u001a\u00020\u0002H\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R)\u0010\f\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/EventsAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isEventsAvailable", "", "onEventClick", "Lkotlin/Function2;", "", "", "onDisabledClick", "Lkotlin/Function0;", "startDownload", "Lkotlin/Function3;", "", "(ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)V", "dateFormatter", "Ljava/text/SimpleDateFormat;", "()Z", "getOnDisabledClick", "()Lkotlin/jvm/functions/Function0;", "getOnEventClick", "()Lkotlin/jvm/functions/Function2;", "getStartDownload", "()Lkotlin/jvm/functions/Function3;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "Lru/tattelecom/intercom/feature/videoplayer/EventsAdapter$EventViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemPlayerEventBinding;", "item", "EventDiffUtil", "EventViewHolder", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class EventsAdapter extends ListAdapter<EventItem, RecyclerView.ViewHolder> {
    private final SimpleDateFormat dateFormatter;
    private final boolean isEventsAvailable;
    private final Function0<Unit> onDisabledClick;
    private final Function2<Long, Boolean, Unit> onEventClick;
    private final Function3<Long, Long, String, Unit> startDownload;

    /* renamed from: isEventsAvailable, reason: from getter */
    public final boolean getIsEventsAvailable() {
        return this.isEventsAvailable;
    }

    public final Function2<Long, Boolean, Unit> getOnEventClick() {
        return this.onEventClick;
    }

    public final Function0<Unit> getOnDisabledClick() {
        return this.onDisabledClick;
    }

    public final Function3<Long, Long, String, Unit> getStartDownload() {
        return this.startDownload;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EventsAdapter(boolean z, Function2<? super Long, ? super Boolean, Unit> onEventClick, Function0<Unit> onDisabledClick, Function3<? super Long, ? super Long, ? super String, Unit> startDownload) {
        super(new EventDiffUtil());
        Intrinsics.checkNotNullParameter(onEventClick, "onEventClick");
        Intrinsics.checkNotNullParameter(onDisabledClick, "onDisabledClick");
        Intrinsics.checkNotNullParameter(startDownload, "startDownload");
        this.isEventsAvailable = z;
        this.onEventClick = onEventClick;
        this.onDisabledClick = onDisabledClick;
        this.startDownload = startDownload;
        this.dateFormatter = new SimpleDateFormat("HH:mm:ss", new Locale("RU"));
    }

    /* compiled from: EventsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/EventsAdapter$EventViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemPlayerEventBinding;", "(Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemPlayerEventBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/videoplayer/databinding/ItemPlayerEventBinding;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EventViewHolder extends RecyclerView.ViewHolder {
        private final ItemPlayerEventBinding binding;

        public final ItemPlayerEventBinding getBinding() {
            return this.binding;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventViewHolder(ItemPlayerEventBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        ItemPlayerEventBinding inflate = ItemPlayerEventBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new EventViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        EventItem item = getItem(position);
        if (holder instanceof EventViewHolder) {
            ItemPlayerEventBinding binding = ((EventViewHolder) holder).getBinding();
            Intrinsics.checkNotNull(item);
            bind(binding, item);
        }
    }

    private final void bind(ItemPlayerEventBinding itemPlayerEventBinding, final EventItem eventItem) {
        itemPlayerEventBinding.ivEventIcon.setVisibility(0);
        itemPlayerEventBinding.tvTime.setText(this.dateFormatter.format(eventItem.getStartDate()));
        if (this.isEventsAvailable) {
            itemPlayerEventBinding.llEvent.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.EventsAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventsAdapter.bind$lambda$1(EventsAdapter.this, eventItem, view);
                }
            });
            itemPlayerEventBinding.btnDownload.setEnabled(true);
            itemPlayerEventBinding.flDownload.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.EventsAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    EventsAdapter.bind$lambda$2(EventItem.this, this, view);
                }
            });
            EventItem.State state = eventItem.getState();
            if (state instanceof EventItem.State.Downloading) {
                ImageView btnDownload = itemPlayerEventBinding.btnDownload;
                Intrinsics.checkNotNullExpressionValue(btnDownload, "btnDownload");
                btnDownload.setVisibility(8);
                ImageView btnRefresh = itemPlayerEventBinding.btnRefresh;
                Intrinsics.checkNotNullExpressionValue(btnRefresh, "btnRefresh");
                btnRefresh.setVisibility(8);
                CircularProgressIndicator progress = itemPlayerEventBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress, "progress");
                progress.setVisibility(0);
                itemPlayerEventBinding.progress.setProgress(((EventItem.State.Downloading) eventItem.getState()).getProgress());
                return;
            }
            if (state instanceof EventItem.State.Error) {
                ImageView btnDownload2 = itemPlayerEventBinding.btnDownload;
                Intrinsics.checkNotNullExpressionValue(btnDownload2, "btnDownload");
                btnDownload2.setVisibility(8);
                ImageView btnRefresh2 = itemPlayerEventBinding.btnRefresh;
                Intrinsics.checkNotNullExpressionValue(btnRefresh2, "btnRefresh");
                btnRefresh2.setVisibility(0);
                CircularProgressIndicator progress2 = itemPlayerEventBinding.progress;
                Intrinsics.checkNotNullExpressionValue(progress2, "progress");
                progress2.setVisibility(8);
                return;
            }
            ImageView btnDownload3 = itemPlayerEventBinding.btnDownload;
            Intrinsics.checkNotNullExpressionValue(btnDownload3, "btnDownload");
            btnDownload3.setVisibility(0);
            ImageView btnRefresh3 = itemPlayerEventBinding.btnRefresh;
            Intrinsics.checkNotNullExpressionValue(btnRefresh3, "btnRefresh");
            btnRefresh3.setVisibility(8);
            CircularProgressIndicator progress3 = itemPlayerEventBinding.progress;
            Intrinsics.checkNotNullExpressionValue(progress3, "progress");
            progress3.setVisibility(8);
            return;
        }
        itemPlayerEventBinding.clRoot.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.videoplayer.EventsAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventsAdapter.bind$lambda$3(EventsAdapter.this, view);
            }
        });
        itemPlayerEventBinding.btnDownload.setEnabled(false);
        itemPlayerEventBinding.ivEventIcon.setEnabled(false);
        itemPlayerEventBinding.tvTime.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(EventsAdapter this$0, EventItem item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.onEventClick.invoke(Long.valueOf(item.getStartDate().getTime()), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2(EventItem item, EventsAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item.getState() == null || (item.getState() instanceof EventItem.State.Error)) {
            this$0.startDownload.invoke(Long.valueOf(item.getStartDate().getTime()), Long.valueOf(item.getDuration()), item.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$3(EventsAdapter this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onDisabledClick.invoke();
    }

    /* compiled from: EventsAdapter.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/EventsAdapter$EventDiffUtil;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem;", "()V", "areContentsTheSame", "", "old", "new", "areItemsTheSame", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class EventDiffUtil extends DiffUtil.ItemCallback<EventItem> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areItemsTheSame(EventItem old, EventItem r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old.getId(), r3.getId());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public boolean areContentsTheSame(EventItem old, EventItem r3) {
            Intrinsics.checkNotNullParameter(old, "old");
            Intrinsics.checkNotNullParameter(r3, "new");
            return Intrinsics.areEqual(old, r3);
        }
    }
}
