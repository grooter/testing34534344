package ru.tattelecom.intercom.feature.home;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;
import org.koin.java.KoinJavaComponent;
import ru.tattelecom.intercom.android.resources.customview.Tooltip;
import ru.tattelecom.intercom.data.prefs.UserPrefsSource;
import ru.tattelecom.intercom.domain.interactors.ConfigInteractor;
import ru.tattelecom.intercom.feature.home.databinding.ItemAddressBinding;
import ru.tattelecom.intercom.feature.home.databinding.ItemReaderBinding;
import ru.tattelecom.intercom.feature.home.databinding.ItemStreamBinding;

/* compiled from: HomeListAdapter.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00039:;B\u0097\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u0012\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u001c\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u001a\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c\u0012\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\u0010\u001eJ\u0006\u0010'\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\nH\u0016J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\nJ\u0018\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\nH\u0016J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\nH\u0016J\"\u00101\u001a\u00020\u0007*\u0002022\u0006\u00103\u001a\u00020\u00062\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002JF\u00101\u001a\u00020\u0007*\u0002052\u0006\u00106\u001a\u00020\r2\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\u0082\u0002\u00101\u001a\u00020\u0007*\u0002072\u0006\u00108\u001a\u00020\r2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u00052\u001c\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\t2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u00052\u001c\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\t2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0018\u001a\u00020\u00112\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\nH\u0002R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lru/tattelecom/intercom/feature/home/HomeItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onAddressClick", "Lkotlin/Function1;", "Lru/tattelecom/intercom/feature/home/HomeAddress;", "", "onOpenGateClick", "Lkotlin/Function2;", "", "", "onStreamClick", "Lru/tattelecom/intercom/feature/home/HomeStream;", "onDisableDoNotDisturbClick", "Lkotlin/Function0;", "onSetCallsMutedClick", "", "onSetCallsScheduleClick", "onGenerateTemporaryCodeClick", "onShareTemporaryCodeClick", "onFavoritesClick", "onCloseToolTip", "Lru/tattelecom/intercom/domain/interactors/ConfigInteractor$ToolTips;", "isToolTipRequires", "toolTipMutex", "Lkotlinx/coroutines/sync/Mutex;", "isToolTipShownFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "scrollToPosition", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlinx/coroutines/sync/Mutex;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlin/jvm/functions/Function1;)V", "prefsSource", "Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "getPrefsSource", "()Lru/tattelecom/intercom/data/prefs/UserPrefsSource;", "prefsSource$delegate", "Lkotlin/Lazy;", "tooltip", "Lru/tattelecom/intercom/android/resources/customview/Tooltip;", "closeToolTip", "getItemViewType", "position", "getViewByPosition", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "bind", "Lru/tattelecom/intercom/feature/home/databinding/ItemAddressBinding;", "address", "onClick", "Lru/tattelecom/intercom/feature/home/databinding/ItemReaderBinding;", "gate", "Lru/tattelecom/intercom/feature/home/databinding/ItemStreamBinding;", "stream", "AddressViewHolder", "ReaderViewHolder", "StreamViewHolder", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomeListAdapter extends ListAdapter<HomeItem, RecyclerView.ViewHolder> {
    private final boolean isToolTipRequires;
    private final MutableStateFlow<Boolean> isToolTipShownFlow;
    private final Function1<HomeAddress, Unit> onAddressClick;
    private final Function1<ConfigInteractor.ToolTips, Unit> onCloseToolTip;
    private final Function0<Unit> onDisableDoNotDisturbClick;
    private final Function1<HomeStream, Unit> onFavoritesClick;
    private final Function1<HomeStream, Unit> onGenerateTemporaryCodeClick;
    private final Function2<Integer, String, Unit> onOpenGateClick;
    private final Function2<Integer, Boolean, Unit> onSetCallsMutedClick;
    private final Function1<Integer, Unit> onSetCallsScheduleClick;
    private final Function2<Integer, String, Unit> onShareTemporaryCodeClick;
    private final Function1<HomeStream, Unit> onStreamClick;

    /* renamed from: prefsSource$delegate, reason: from kotlin metadata */
    private final Lazy prefsSource;
    private final Function1<Integer, Unit> scrollToPosition;
    private final Mutex toolTipMutex;
    private Tooltip tooltip;

    public /* synthetic */ HomeListAdapter(Function1 function1, Function2 function2, Function1 function12, Function0 function0, Function2 function22, Function1 function13, Function1 function14, Function2 function23, Function1 function15, Function1 function16, boolean z, Mutex mutex, MutableStateFlow mutableStateFlow, Function1 function17, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, function2, function12, function0, function22, function13, function14, function23, function15, function16, z, mutex, mutableStateFlow, (i & 8192) != 0 ? null : function17);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HomeListAdapter(Function1<? super HomeAddress, Unit> onAddressClick, Function2<? super Integer, ? super String, Unit> onOpenGateClick, Function1<? super HomeStream, Unit> onStreamClick, Function0<Unit> onDisableDoNotDisturbClick, Function2<? super Integer, ? super Boolean, Unit> onSetCallsMutedClick, Function1<? super Integer, Unit> onSetCallsScheduleClick, Function1<? super HomeStream, Unit> onGenerateTemporaryCodeClick, Function2<? super Integer, ? super String, Unit> onShareTemporaryCodeClick, Function1<? super HomeStream, Unit> onFavoritesClick, Function1<? super ConfigInteractor.ToolTips, Unit> onCloseToolTip, boolean z, Mutex toolTipMutex, MutableStateFlow<Boolean> isToolTipShownFlow, Function1<? super Integer, Unit> function1) {
        super(new HomeDiffUtil());
        Intrinsics.checkNotNullParameter(onAddressClick, "onAddressClick");
        Intrinsics.checkNotNullParameter(onOpenGateClick, "onOpenGateClick");
        Intrinsics.checkNotNullParameter(onStreamClick, "onStreamClick");
        Intrinsics.checkNotNullParameter(onDisableDoNotDisturbClick, "onDisableDoNotDisturbClick");
        Intrinsics.checkNotNullParameter(onSetCallsMutedClick, "onSetCallsMutedClick");
        Intrinsics.checkNotNullParameter(onSetCallsScheduleClick, "onSetCallsScheduleClick");
        Intrinsics.checkNotNullParameter(onGenerateTemporaryCodeClick, "onGenerateTemporaryCodeClick");
        Intrinsics.checkNotNullParameter(onShareTemporaryCodeClick, "onShareTemporaryCodeClick");
        Intrinsics.checkNotNullParameter(onFavoritesClick, "onFavoritesClick");
        Intrinsics.checkNotNullParameter(onCloseToolTip, "onCloseToolTip");
        Intrinsics.checkNotNullParameter(toolTipMutex, "toolTipMutex");
        Intrinsics.checkNotNullParameter(isToolTipShownFlow, "isToolTipShownFlow");
        this.onAddressClick = onAddressClick;
        this.onOpenGateClick = onOpenGateClick;
        this.onStreamClick = onStreamClick;
        this.onDisableDoNotDisturbClick = onDisableDoNotDisturbClick;
        this.onSetCallsMutedClick = onSetCallsMutedClick;
        this.onSetCallsScheduleClick = onSetCallsScheduleClick;
        this.onGenerateTemporaryCodeClick = onGenerateTemporaryCodeClick;
        this.onShareTemporaryCodeClick = onShareTemporaryCodeClick;
        this.onFavoritesClick = onFavoritesClick;
        this.onCloseToolTip = onCloseToolTip;
        this.isToolTipRequires = z;
        this.toolTipMutex = toolTipMutex;
        this.isToolTipShownFlow = isToolTipShownFlow;
        this.scrollToPosition = function1;
        this.prefsSource = KoinJavaComponent.inject$default(UserPrefsSource.class, null, null, 6, null);
    }

    private final UserPrefsSource getPrefsSource() {
        return (UserPrefsSource) this.prefsSource.getValue();
    }

    public final boolean closeToolTip() {
        Tooltip tooltip = this.tooltip;
        if (tooltip == null || !tooltip.isShowing()) {
            return false;
        }
        Tooltip tooltip2 = this.tooltip;
        if (tooltip2 != null) {
            tooltip2.dismiss();
        }
        return true;
    }

    /* compiled from: HomeListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeListAdapter$AddressViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/home/databinding/ItemAddressBinding;", "(Lru/tattelecom/intercom/feature/home/databinding/ItemAddressBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/home/databinding/ItemAddressBinding;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AddressViewHolder extends RecyclerView.ViewHolder {
        private final ItemAddressBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddressViewHolder(ItemAddressBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemAddressBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: HomeListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeListAdapter$StreamViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/home/databinding/ItemStreamBinding;", "(Lru/tattelecom/intercom/feature/home/databinding/ItemStreamBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/home/databinding/ItemStreamBinding;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StreamViewHolder extends RecyclerView.ViewHolder {
        private final ItemStreamBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StreamViewHolder(ItemStreamBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemStreamBinding getBinding() {
            return this.binding;
        }
    }

    /* compiled from: HomeListAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeListAdapter$ReaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lru/tattelecom/intercom/feature/home/databinding/ItemReaderBinding;", "(Lru/tattelecom/intercom/feature/home/databinding/ItemReaderBinding;)V", "getBinding", "()Lru/tattelecom/intercom/feature/home/databinding/ItemReaderBinding;", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ReaderViewHolder extends RecyclerView.ViewHolder {
        private final ItemReaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReaderViewHolder(ItemReaderBinding binding) {
            super(binding.getRoot());
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.binding = binding;
        }

        public final ItemReaderBinding getBinding() {
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
            ItemAddressBinding inflate = ItemAddressBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new AddressViewHolder(inflate);
        }
        if (viewType != 3) {
            ItemStreamBinding inflate2 = ItemStreamBinding.inflate(from, parent, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
            return new StreamViewHolder(inflate2);
        }
        ItemReaderBinding inflate3 = ItemReaderBinding.inflate(from, parent, false);
        Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
        return new ReaderViewHolder(inflate3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final HomeItem item = getItem(position);
        if (holder instanceof AddressViewHolder) {
            ItemAddressBinding binding = ((AddressViewHolder) holder).getBinding();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeAddress");
            bind(binding, (HomeAddress) item, new Function0<Unit>() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$onBindViewHolder$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function1 function1;
                    function1 = HomeListAdapter.this.onAddressClick;
                    HomeItem item2 = item;
                    Intrinsics.checkNotNullExpressionValue(item2, "$item");
                    function1.invoke(item2);
                }
            });
        } else if (holder instanceof StreamViewHolder) {
            ItemStreamBinding binding2 = ((StreamViewHolder) holder).getBinding();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeStream");
            bind(binding2, (HomeStream) item, this.onStreamClick, this.onOpenGateClick, this.onDisableDoNotDisturbClick, this.onSetCallsMutedClick, this.onSetCallsScheduleClick, this.onGenerateTemporaryCodeClick, this.onShareTemporaryCodeClick, this.onFavoritesClick, this.onCloseToolTip, this.isToolTipRequires, this.scrollToPosition, position);
        } else if (holder instanceof ReaderViewHolder) {
            ItemReaderBinding binding3 = ((ReaderViewHolder) holder).getBinding();
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type ru.tattelecom.intercom.feature.home.HomeStream");
            bind(binding3, (HomeStream) item, this.onOpenGateClick, this.onFavoritesClick);
        }
    }

    public final HomeItem getViewByPosition(int position) {
        HomeItem item = getItem(position);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(...)");
        return item;
    }

    private final void bind(final ItemAddressBinding itemAddressBinding, final HomeAddress homeAddress, final Function0<Unit> function0) {
        itemAddressBinding.tvAddress.setText(homeAddress.getTitle());
        itemAddressBinding.ivArrow.setRotation(homeAddress.isCollapsed() ? 0.0f : 90.0f);
        itemAddressBinding.llAddress.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$2(Function0.this, itemAddressBinding, homeAddress, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$2(Function0 onClick, ItemAddressBinding this_bind, HomeAddress address, View view) {
        Intrinsics.checkNotNullParameter(onClick, "$onClick");
        Intrinsics.checkNotNullParameter(this_bind, "$this_bind");
        Intrinsics.checkNotNullParameter(address, "$address");
        onClick.invoke();
        this_bind.ivArrow.setRotation(address.isCollapsed() ? 0.0f : 90.0f);
    }

    private final void bind(final ItemStreamBinding itemStreamBinding, final HomeStream homeStream, final Function1<? super HomeStream, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2, final Function0<Unit> function0, final Function2<? super Integer, ? super Boolean, Unit> function22, final Function1<? super Integer, Unit> function12, final Function1<? super HomeStream, Unit> function13, final Function2<? super Integer, ? super String, Unit> function23, final Function1<? super HomeStream, Unit> function14, Function1<? super ConfigInteractor.ToolTips, Unit> function15, boolean z, Function1<? super Integer, Unit> function16, int i) {
        Drawable drawable;
        ImageView btnNotification = itemStreamBinding.btnNotification;
        Intrinsics.checkNotNullExpressionValue(btnNotification, "btnNotification");
        btnNotification.setVisibility(homeStream.isIntercom() ? 0 : 8);
        ImageView imageView = itemStreamBinding.btnNotification;
        if (homeStream.getCallsMuted()) {
            drawable = ContextCompat.getDrawable(itemStreamBinding.getRoot().getContext(), R.drawable.ic_notification_off);
        } else {
            drawable = ContextCompat.getDrawable(itemStreamBinding.getRoot().getContext(), R.drawable.ic_notification);
        }
        imageView.setImageDrawable(drawable);
        FloatingActionButton floatingActionButton = itemStreamBinding.btnOpenDoor;
        Intrinsics.checkNotNull(floatingActionButton);
        floatingActionButton.setVisibility(homeStream.isIntercom() ? 0 : 8);
        floatingActionButton.setEnabled(!homeStream.isOpenDoorLoading() && homeStream.getOpenDoorIsEnable());
        ProgressBar progressIntercomOpening = itemStreamBinding.progressIntercomOpening;
        Intrinsics.checkNotNullExpressionValue(progressIntercomOpening, "progressIntercomOpening");
        progressIntercomOpening.setVisibility(homeStream.isOpenDoorLoading() ? 0 : 8);
        ProgressBar progressCodeLoading = itemStreamBinding.progressCodeLoading;
        Intrinsics.checkNotNullExpressionValue(progressCodeLoading, "progressCodeLoading");
        progressCodeLoading.setVisibility(homeStream.isTemporaryCodeLoading() ? 0 : 8);
        MaterialButton materialButton = itemStreamBinding.btnGenerateTemporaryCode;
        Intrinsics.checkNotNull(materialButton);
        materialButton.setVisibility(homeStream.isIntercom() ? 0 : 8);
        materialButton.setEnabled(!homeStream.isTemporaryCodeLoading() && homeStream.getTemporaryCode() == null);
        if (homeStream.isTemporaryCodeLoading()) {
            itemStreamBinding.btnGenerateTemporaryCode.setText(R.string.empty_string);
            TextView tvTimeCode = itemStreamBinding.tvTimeCode;
            Intrinsics.checkNotNullExpressionValue(tvTimeCode, "tvTimeCode");
            tvTimeCode.setVisibility(8);
            ImageButton btnShareCode = itemStreamBinding.btnShareCode;
            Intrinsics.checkNotNullExpressionValue(btnShareCode, "btnShareCode");
            btnShareCode.setVisibility(8);
            ProgressBar progressCodeLoading2 = itemStreamBinding.progressCodeLoading;
            Intrinsics.checkNotNullExpressionValue(progressCodeLoading2, "progressCodeLoading");
            progressCodeLoading2.setVisibility(0);
        } else {
            ProgressBar progressCodeLoading3 = itemStreamBinding.progressCodeLoading;
            Intrinsics.checkNotNullExpressionValue(progressCodeLoading3, "progressCodeLoading");
            progressCodeLoading3.setVisibility(8);
            if (homeStream.getTemporaryCode() == null) {
                itemStreamBinding.btnGenerateTemporaryCode.setText(R.string.generate_code);
                TextView tvTimeCode2 = itemStreamBinding.tvTimeCode;
                Intrinsics.checkNotNullExpressionValue(tvTimeCode2, "tvTimeCode");
                tvTimeCode2.setVisibility(8);
                ImageButton btnShareCode2 = itemStreamBinding.btnShareCode;
                Intrinsics.checkNotNullExpressionValue(btnShareCode2, "btnShareCode");
                btnShareCode2.setVisibility(8);
            } else {
                itemStreamBinding.btnGenerateTemporaryCode.setText(R.string.empty_string);
                TextView tvTimeCode3 = itemStreamBinding.tvTimeCode;
                Intrinsics.checkNotNullExpressionValue(tvTimeCode3, "tvTimeCode");
                tvTimeCode3.setVisibility(0);
                ImageButton btnShareCode3 = itemStreamBinding.btnShareCode;
                Intrinsics.checkNotNullExpressionValue(btnShareCode3, "btnShareCode");
                btnShareCode3.setVisibility(0);
            }
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$5$lambda$4(Function1.this, homeStream, view);
            }
        });
        BuildersKt__BuildersKt.runBlocking$default(null, new HomeListAdapter$bind$4(this, z, function16, i, itemStreamBinding, function15, null), 1, null);
        itemStreamBinding.tvTimeCode.setText(String.valueOf(homeStream.getTemporaryCode()));
        itemStreamBinding.btnShareCode.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$6(Function2.this, homeStream, view);
            }
        });
        RequestManager with = Glide.with(itemStreamBinding.getRoot().getContext());
        String preview = homeStream.getPreview();
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        String token = getPrefsSource().getToken();
        if (token == null) {
            token = "";
        }
        with.load((Object) new GlideUrl(preview, builder.addHeader("access-token", token).build())).error(R.drawable.ic_no_video).centerCrop().into(itemStreamBinding.ivSnapshot);
        itemStreamBinding.tvDescription.setText(homeStream.getGateName());
        itemStreamBinding.clFavorite.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$7(Function1.this, homeStream, view);
            }
        });
        ImageView ivHeart = itemStreamBinding.ivHeart;
        Intrinsics.checkNotNullExpressionValue(ivHeart, "ivHeart");
        ivHeart.setVisibility(!homeStream.isFavorite() ? 0 : 8);
        ImageView ivHeartSelected = itemStreamBinding.ivHeartSelected;
        Intrinsics.checkNotNullExpressionValue(ivHeartSelected, "ivHeartSelected");
        ivHeartSelected.setVisibility(homeStream.isFavorite() ? 0 : 8);
        itemStreamBinding.cvStream.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$8(Function1.this, homeStream, view);
            }
        });
        if (homeStream.isIntercom()) {
            itemStreamBinding.btnOpenDoor.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeListAdapter.bind$lambda$9(Function2.this, homeStream, view);
                }
            });
            itemStreamBinding.btnNotification.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeListAdapter.bind$lambda$15(HomeListAdapter.this, itemStreamBinding, function0, homeStream, function22, function12, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$5$lambda$4(Function1 onGenerateTemporaryCodeClick, HomeStream stream, View view) {
        Intrinsics.checkNotNullParameter(onGenerateTemporaryCodeClick, "$onGenerateTemporaryCodeClick");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        onGenerateTemporaryCodeClick.invoke(stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$6(Function2 onShareTemporaryCodeClick, HomeStream stream, View view) {
        Intrinsics.checkNotNullParameter(onShareTemporaryCodeClick, "$onShareTemporaryCodeClick");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        Integer temporaryCode = stream.getTemporaryCode();
        String address = stream.getAddress();
        if (address == null) {
            address = "";
        }
        onShareTemporaryCodeClick.invoke(temporaryCode, address);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$7(Function1 onFavoritesClick, HomeStream stream, View view) {
        Intrinsics.checkNotNullParameter(onFavoritesClick, "$onFavoritesClick");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        onFavoritesClick.invoke(stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$8(Function1 onStreamClick, HomeStream stream, View view) {
        Intrinsics.checkNotNullParameter(onStreamClick, "$onStreamClick");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        onStreamClick.invoke(stream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$9(Function2 onOpenGateClick, HomeStream stream, View view) {
        Intrinsics.checkNotNullParameter(onOpenGateClick, "$onOpenGateClick");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        onOpenGateClick.invoke(stream.getGateId(), stream.getLogin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$15(HomeListAdapter this$0, final ItemStreamBinding this_bind, final Function0 onDisableDoNotDisturbClick, final HomeStream stream, final Function2 onSetCallsMutedClick, final Function1 onSetCallsScheduleClick, View view) {
        int i;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_bind, "$this_bind");
        Intrinsics.checkNotNullParameter(onDisableDoNotDisturbClick, "$onDisableDoNotDisturbClick");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        Intrinsics.checkNotNullParameter(onSetCallsMutedClick, "$onSetCallsMutedClick");
        Intrinsics.checkNotNullParameter(onSetCallsScheduleClick, "$onSetCallsScheduleClick");
        if (this$0.getPrefsSource().getCallsMuted()) {
            new AlertDialog.Builder(this_bind.getRoot().getContext()).setTitle(R.string.calls_are_turned_off).setMessage(R.string.disable_do_not_disturb).setPositiveButton(R.string.apply, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    HomeListAdapter.bind$lambda$15$lambda$10(Function0.this, dialogInterface, i2);
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda10
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            }).create().show();
            return;
        }
        PopupMenu popupMenu = new PopupMenu(this_bind.getRoot().getContext(), view);
        Menu menu = popupMenu.getMenu();
        if (stream.getCallsMuted()) {
            i = R.string.turn_on_notifications;
        } else {
            i = R.string.turn_off_notification;
        }
        menu.add(1, 1, 0, i);
        menu.add(1, 2, 0, R.string.setup_notification);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda11
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean bind$lambda$15$lambda$14$lambda$13;
                bind$lambda$15$lambda$14$lambda$13 = HomeListAdapter.bind$lambda$15$lambda$14$lambda$13(ItemStreamBinding.this, stream, onSetCallsMutedClick, onSetCallsScheduleClick, menuItem);
                return bind$lambda$15$lambda$14$lambda$13;
            }
        });
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$15$lambda$10(Function0 onDisableDoNotDisturbClick, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(onDisableDoNotDisturbClick, "$onDisableDoNotDisturbClick");
        onDisableDoNotDisturbClick.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean bind$lambda$15$lambda$14$lambda$13(ItemStreamBinding this_bind, HomeStream stream, Function2 onSetCallsMutedClick, Function1 onSetCallsScheduleClick, MenuItem menuItem) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(this_bind, "$this_bind");
        Intrinsics.checkNotNullParameter(stream, "$stream");
        Intrinsics.checkNotNullParameter(onSetCallsMutedClick, "$onSetCallsMutedClick");
        Intrinsics.checkNotNullParameter(onSetCallsScheduleClick, "$onSetCallsScheduleClick");
        int itemId = menuItem.getItemId();
        if (itemId == 1) {
            ImageView imageView = this_bind.btnNotification;
            if (stream.getCallsMuted()) {
                drawable = ContextCompat.getDrawable(this_bind.getRoot().getContext(), R.drawable.ic_notification);
            } else {
                drawable = ContextCompat.getDrawable(this_bind.getRoot().getContext(), R.drawable.ic_notification_off);
            }
            imageView.setImageDrawable(drawable);
            onSetCallsMutedClick.invoke(Integer.valueOf(stream.getId()), Boolean.valueOf(stream.getCallsMuted()));
        } else if (itemId == 2) {
            onSetCallsScheduleClick.invoke(Integer.valueOf(stream.getId()));
        }
        return true;
    }

    private final void bind(ItemReaderBinding itemReaderBinding, final HomeStream homeStream, final Function2<? super Integer, ? super String, Unit> function2, final Function1<? super HomeStream, Unit> function1) {
        FloatingActionButton floatingActionButton = itemReaderBinding.btnOpenDoor;
        Intrinsics.checkNotNull(floatingActionButton);
        floatingActionButton.setVisibility(homeStream.getType() == 3 ? 0 : 8);
        floatingActionButton.setEnabled(!homeStream.isOpenDoorLoading() && homeStream.getOpenDoorIsEnable());
        floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$17$lambda$16(Function2.this, homeStream, view);
            }
        });
        ProgressBar progressIntercomOpening = itemReaderBinding.progressIntercomOpening;
        Intrinsics.checkNotNullExpressionValue(progressIntercomOpening, "progressIntercomOpening");
        progressIntercomOpening.setVisibility(homeStream.isOpenDoorLoading() ? 0 : 8);
        itemReaderBinding.tvDescription.setText(homeStream.getGateName());
        itemReaderBinding.clFavorite.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.home.HomeListAdapter$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeListAdapter.bind$lambda$18(Function1.this, homeStream, view);
            }
        });
        ImageView ivHeart = itemReaderBinding.ivHeart;
        Intrinsics.checkNotNullExpressionValue(ivHeart, "ivHeart");
        ivHeart.setVisibility(!homeStream.isFavorite() ? 0 : 8);
        ImageView ivHeartSelected = itemReaderBinding.ivHeartSelected;
        Intrinsics.checkNotNullExpressionValue(ivHeartSelected, "ivHeartSelected");
        ivHeartSelected.setVisibility(homeStream.isFavorite() ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$17$lambda$16(Function2 onOpenGateClick, HomeStream gate, View view) {
        Intrinsics.checkNotNullParameter(onOpenGateClick, "$onOpenGateClick");
        Intrinsics.checkNotNullParameter(gate, "$gate");
        onOpenGateClick.invoke(gate.getGateId(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$18(Function1 onFavoritesClick, HomeStream gate, View view) {
        Intrinsics.checkNotNullParameter(onFavoritesClick, "$onFavoritesClick");
        Intrinsics.checkNotNullParameter(gate, "$gate");
        onFavoritesClick.invoke(gate);
    }
}
