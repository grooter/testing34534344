package ru.tattelecom.intercom.android.resources.customview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import ru.tattelecom.intercom.android.resources.databinding.TooltipLayoutBinding;

/* compiled from: Tooltip.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0002\"#B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0019\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010J\u001a\u0010 \u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010J\u001a\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/Tooltip;", "", "builder", "Lru/tattelecom/intercom/android/resources/customview/Tooltip$TooltipBuilder;", "(Lru/tattelecom/intercom/android/resources/customview/Tooltip$TooltipBuilder;)V", "()V", "_binding", "Lru/tattelecom/intercom/android/resources/databinding/TooltipLayoutBinding;", "binding", "getBinding", "()Lru/tattelecom/intercom/android/resources/databinding/TooltipLayoutBinding;", "mAlignment", "Lru/tattelecom/intercom/android/resources/customview/Tooltip$Alignment;", "mAnchorView", "Landroid/view/View;", "mArrowGravity", "", "mGravity", "mPopupWindow", "Landroid/widget/PopupWindow;", "mText", "", "onCloseListener", "Lkotlin/Function0;", "", "dismiss", "getContentView", "isShowing", "", "showAtBottom", "xOffset", "yOffset", "showAtCenter", "showAtTop", "Alignment", "TooltipBuilder", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Tooltip {
    private TooltipLayoutBinding _binding;
    private Alignment mAlignment;
    private View mAnchorView;
    private int mArrowGravity;
    private int mGravity;
    private PopupWindow mPopupWindow;
    private String mText;
    private Function0<Unit> onCloseListener;

    /* compiled from: Tooltip.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Alignment.values().length];
            try {
                iArr[Alignment.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Alignment.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ Tooltip(TooltipBuilder tooltipBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(tooltipBuilder);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/Tooltip$Alignment;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Alignment {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Alignment[] $VALUES;
        public static final Alignment TOP = new Alignment("TOP", 0);
        public static final Alignment BOTTOM = new Alignment("BOTTOM", 1);

        private static final /* synthetic */ Alignment[] $values() {
            return new Alignment[]{TOP, BOTTOM};
        }

        public static EnumEntries<Alignment> getEntries() {
            return $ENTRIES;
        }

        public static Alignment valueOf(String str) {
            return (Alignment) Enum.valueOf(Alignment.class, str);
        }

        public static Alignment[] values() {
            return (Alignment[]) $VALUES.clone();
        }

        private Alignment(String str, int i) {
        }

        static {
            Alignment[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    public Tooltip() {
        this.mAlignment = Alignment.BOTTOM;
        this.mGravity = GravityCompat.START;
        this.mArrowGravity = GravityCompat.START;
        this.mText = "";
        this.onCloseListener = new Function0<Unit>() { // from class: ru.tattelecom.intercom.android.resources.customview.Tooltip$onCloseListener$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        };
    }

    private Tooltip(TooltipBuilder tooltipBuilder) {
        this();
        this.mAnchorView = tooltipBuilder.getAnchorView();
        this.mText = tooltipBuilder.get_mText();
        this.mAlignment = tooltipBuilder.get_mAlignment();
        this.mGravity = tooltipBuilder.get_mGravity();
        this.mArrowGravity = tooltipBuilder.get_mArrowGravity();
        this.onCloseListener = tooltipBuilder.getOnCloseListener();
        this.mPopupWindow = new PopupWindow(tooltipBuilder.getMContext());
        this._binding = getContentView(tooltipBuilder);
        PopupWindow popupWindow = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow);
        popupWindow.setWidth((tooltipBuilder.getMContext().getResources().getDisplayMetrics().widthPixels / 3) * 2);
        PopupWindow popupWindow2 = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow2);
        popupWindow2.setHeight(-2);
        PopupWindow popupWindow3 = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow3);
        popupWindow3.setContentView(getBinding().getRoot());
        PopupWindow popupWindow4 = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow4);
        popupWindow4.setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow popupWindow5 = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow5);
        popupWindow5.setOutsideTouchable(tooltipBuilder.get_isOutsideTouchable());
        PopupWindow popupWindow6 = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow6);
        popupWindow6.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ru.tattelecom.intercom.android.resources.customview.Tooltip$$ExternalSyntheticLambda0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                Tooltip._init_$lambda$0(Tooltip.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(Tooltip this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onCloseListener.invoke();
    }

    /* compiled from: Tooltip.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010'\u001a\u00020(J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0013\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010+\u001a\u00020\u00062\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\nHÖ\u0001J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0006J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\bJ\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u000e\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\nJ\u0014\u00104\u001a\u00020\u00002\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\rJ\t\u00108\u001a\u00020\rHÖ\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b \u0010\u001aR\u0011\u0010!\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8F¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u00069"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/Tooltip$TooltipBuilder;", "", "anchorView", "Landroid/view/View;", "(Landroid/view/View;)V", "_isOutsideTouchable", "", "_mAlignment", "Lru/tattelecom/intercom/android/resources/customview/Tooltip$Alignment;", "_mArrowGravity", "", "_mGravity", "_mText", "", "_onCloseListener", "Lkotlin/Function0;", "", "getAnchorView", "()Landroid/view/View;", "isOutsideTouchable", "()Z", "mAlignment", "getMAlignment", "()Lru/tattelecom/intercom/android/resources/customview/Tooltip$Alignment;", "mArrowGravity", "getMArrowGravity", "()I", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mGravity", "getMGravity", "mText", "getMText", "()Ljava/lang/String;", "onCloseListener", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "build", "Lru/tattelecom/intercom/android/resources/customview/Tooltip;", "component1", "copy", "equals", "other", "hashCode", "isTouchable", "setAlignment", "alignment", "setArrowGravity", "gravity", "setGravity", "setOnCloseListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setText", "textString", "toString", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class TooltipBuilder {
        private boolean _isOutsideTouchable;
        private Alignment _mAlignment;
        private int _mArrowGravity;
        private int _mGravity;
        private String _mText;
        private Function0<Unit> _onCloseListener;
        private final View anchorView;
        private final Context mContext;

        public static /* synthetic */ TooltipBuilder copy$default(TooltipBuilder tooltipBuilder, View view, int i, Object obj) {
            if ((i & 1) != 0) {
                view = tooltipBuilder.anchorView;
            }
            return tooltipBuilder.copy(view);
        }

        /* renamed from: component1, reason: from getter */
        public final View getAnchorView() {
            return this.anchorView;
        }

        public final TooltipBuilder copy(View anchorView) {
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            return new TooltipBuilder(anchorView);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TooltipBuilder) && Intrinsics.areEqual(this.anchorView, ((TooltipBuilder) other).anchorView);
        }

        public int hashCode() {
            return this.anchorView.hashCode();
        }

        public String toString() {
            return "TooltipBuilder(anchorView=" + this.anchorView + ")";
        }

        public TooltipBuilder(View anchorView) {
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            this.anchorView = anchorView;
            Context context = anchorView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.mContext = context;
            this._mText = "";
            this._onCloseListener = new Function0<Unit>() { // from class: ru.tattelecom.intercom.android.resources.customview.Tooltip$TooltipBuilder$_onCloseListener$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
            this._mAlignment = Alignment.BOTTOM;
            this._mGravity = GravityCompat.START;
            this._mArrowGravity = GravityCompat.START;
            this._isOutsideTouchable = true;
        }

        public final View getAnchorView() {
            return this.anchorView;
        }

        public final Context getMContext() {
            return this.mContext;
        }

        /* renamed from: getMText, reason: from getter */
        public final String get_mText() {
            return this._mText;
        }

        public final TooltipBuilder setText(String textString) {
            Intrinsics.checkNotNullParameter(textString, "textString");
            this._mText = textString;
            return this;
        }

        public final Function0<Unit> getOnCloseListener() {
            return this._onCloseListener;
        }

        public final TooltipBuilder setOnCloseListener(Function0<Unit> listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this._onCloseListener = listener;
            return this;
        }

        /* renamed from: getMAlignment, reason: from getter */
        public final Alignment get_mAlignment() {
            return this._mAlignment;
        }

        public final TooltipBuilder setAlignment(Alignment alignment) {
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            this._mAlignment = alignment;
            return this;
        }

        /* renamed from: getMGravity, reason: from getter */
        public final int get_mGravity() {
            return this._mGravity;
        }

        public final TooltipBuilder setGravity(int gravity) {
            this._mGravity = gravity;
            return this;
        }

        /* renamed from: getMArrowGravity, reason: from getter */
        public final int get_mArrowGravity() {
            return this._mArrowGravity;
        }

        public final TooltipBuilder setArrowGravity(int gravity) {
            this._mArrowGravity = gravity;
            return this;
        }

        /* renamed from: isOutsideTouchable, reason: from getter */
        public final boolean get_isOutsideTouchable() {
            return this._isOutsideTouchable;
        }

        public final TooltipBuilder isOutsideTouchable(boolean isTouchable) {
            this._isOutsideTouchable = isTouchable;
            return this;
        }

        public final Tooltip build() {
            return new Tooltip(this, null);
        }
    }

    private final TooltipLayoutBinding getBinding() {
        TooltipLayoutBinding tooltipLayoutBinding = this._binding;
        Intrinsics.checkNotNull(tooltipLayoutBinding);
        return tooltipLayoutBinding;
    }

    private final TooltipLayoutBinding getContentView(TooltipBuilder builder) {
        ImageView ivArrowBottom;
        Object systemService = builder.getMContext().getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        TooltipLayoutBinding inflate = TooltipLayoutBinding.inflate((LayoutInflater) systemService, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.tvText.setText(this.mText);
        int i = WhenMappings.$EnumSwitchMapping$0[this.mAlignment.ordinal()];
        if (i == 1) {
            ivArrowBottom = inflate.ivArrowBottom;
            Intrinsics.checkNotNullExpressionValue(ivArrowBottom, "ivArrowBottom");
            ImageView ivArrowTop = inflate.ivArrowTop;
            Intrinsics.checkNotNullExpressionValue(ivArrowTop, "ivArrowTop");
            ivArrowTop.setVisibility(8);
            ivArrowBottom.setVisibility(0);
        } else if (i == 2) {
            ivArrowBottom = inflate.ivArrowTop;
            Intrinsics.checkNotNullExpressionValue(ivArrowBottom, "ivArrowTop");
            ImageView ivArrowBottom2 = inflate.ivArrowBottom;
            Intrinsics.checkNotNullExpressionValue(ivArrowBottom2, "ivArrowBottom");
            ivArrowBottom2.setVisibility(8);
            ivArrowBottom.setVisibility(0);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        ViewGroup.LayoutParams layoutParams = ivArrowBottom.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        layoutParams2.gravity = this.mArrowGravity;
        ivArrowBottom.setLayoutParams(layoutParams2);
        inflate.ivClose.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.customview.Tooltip$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tooltip.getContentView$lambda$1(Tooltip.this, view);
            }
        });
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getContentView$lambda$1(Tooltip this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    public static /* synthetic */ void showAtBottom$default(Tooltip tooltip, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        tooltip.showAtBottom(i, i2);
    }

    public final void showAtBottom(int xOffset, int yOffset) {
        CompletableJob Job$default;
        CoroutineName coroutineName = new CoroutineName("ToolTipCoroutine");
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineName.plus(Job$default)), Dispatchers.getMain(), null, new Tooltip$showAtBottom$1(this, xOffset, yOffset, null), 2, null);
    }

    public static /* synthetic */ void showAtTop$default(Tooltip tooltip, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        tooltip.showAtTop(i, i2);
    }

    public final void showAtTop(int xOffset, int yOffset) {
        CompletableJob Job$default;
        CoroutineName coroutineName = new CoroutineName("ToolTipCoroutine_WOffSet");
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineName.plus(Job$default)), Dispatchers.getMain(), null, new Tooltip$showAtTop$1(this, xOffset, yOffset, null), 2, null);
    }

    public static /* synthetic */ void showAtCenter$default(Tooltip tooltip, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        tooltip.showAtCenter(i, i2);
    }

    public final void showAtCenter(int xOffset, int yOffset) {
        CompletableJob Job$default;
        CoroutineName coroutineName = new CoroutineName("ToolTipCoroutine_Center");
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(coroutineName.plus(Job$default)), Dispatchers.getMain(), null, new Tooltip$showAtCenter$1(this, xOffset, yOffset, null), 2, null);
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.mPopupWindow;
        Intrinsics.checkNotNull(popupWindow);
        return popupWindow.isShowing();
    }

    public final void dismiss() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
