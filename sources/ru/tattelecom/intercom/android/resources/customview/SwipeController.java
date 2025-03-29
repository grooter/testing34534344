package ru.tattelecom.intercom.android.resources.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.feature.dynamic.e.c;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.R;

/* compiled from: SwipeController.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u0000 .2\u00020\u0001:\u0001.B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\fH\u0016J@\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000eH\u0016J\u001a\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00162\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ \u0010%\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0016J\u0018\u0010'\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0018\u0010)\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u000eH\u0002J8\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000eH\u0003J@\u0010,\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000eH\u0003J8\u0010-\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000eH\u0003R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/SwipeController;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "buttonsActions", "Lru/tattelecom/intercom/android/resources/customview/SwipeControllerActions;", "context", "Landroid/content/Context;", "(Lru/tattelecom/intercom/android/resources/customview/SwipeControllerActions;Landroid/content/Context;)V", "buttonInstance", "Landroid/graphics/RectF;", "buttonShowedState", "Lru/tattelecom/intercom/android/resources/customview/ButtonsState;", "currentItemViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "swipeBack", "", "convertToAbsoluteDirection", "", "flags", "layoutDirection", "drawButtons", "", "canvas", "Landroid/graphics/Canvas;", "viewHolder", "drawIcon", "button", "getMovementFlags", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onChildDraw", "dX", "", "dY", "actionState", "isCurrentlyActive", "onDraw", c.f200a, "onMove", "target", "onSwiped", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "setItemsClickable", "isClickable", "setTouchDownListener", "setTouchListener", "setTouchUpListener", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SwipeController extends ItemTouchHelper.Callback {
    private static final float BUTTON_CORNER = 10.0f;
    private static final float BUTTON_WIDTH = 56.0f;
    private static final int DESIRE_ICON_SIZE = 24;
    private static final int PADDING = 16;
    private RectF buttonInstance;
    private ButtonsState buttonShowedState;
    private SwipeControllerActions buttonsActions;
    private final Context context;
    private RecyclerView.ViewHolder currentItemViewHolder;
    private boolean swipeBack;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchUpListener$lambda$4$lambda$2(View view, MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
    }

    public SwipeController(SwipeControllerActions swipeControllerActions, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.buttonsActions = swipeControllerActions;
        this.context = context;
        this.buttonShowedState = ButtonsState.GONE;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return viewHolder.getItemViewType() == 1 ? ItemTouchHelper.Callback.makeMovementFlags(0, 0) : ItemTouchHelper.Callback.makeMovementFlags(0, 4);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int convertToAbsoluteDirection(int flags, int layoutDirection) {
        if (this.swipeBack) {
            this.swipeBack = this.buttonShowedState != ButtonsState.GONE;
            return 0;
        }
        return super.convertToAbsoluteDirection(flags, layoutDirection);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onChildDraw(android.graphics.Canvas r9, androidx.recyclerview.widget.RecyclerView r10, androidx.recyclerview.widget.RecyclerView.ViewHolder r11, float r12, float r13, int r14, boolean r15) {
        /*
            r8 = this;
            java.lang.String r0 = "canvas"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "recyclerView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "viewHolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 1
            if (r14 != r0) goto L40
            ru.tattelecom.intercom.android.resources.customview.ButtonsState r0 = r8.buttonShowedState
            ru.tattelecom.intercom.android.resources.customview.ButtonsState r1 = ru.tattelecom.intercom.android.resources.customview.ButtonsState.GONE
            if (r0 == r1) goto L3d
            ru.tattelecom.intercom.android.resources.customview.ButtonsState r0 = r8.buttonShowedState
            ru.tattelecom.intercom.android.resources.customview.ButtonsState r1 = ru.tattelecom.intercom.android.resources.customview.ButtonsState.RIGHT_VISIBLE
            if (r0 != r1) goto L31
            android.content.Context r0 = r8.context
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            r1 = -1033895936(0xffffffffc2600000, float:-56.0)
            float r0 = r0 * r1
            float r12 = java.lang.Math.min(r12, r0)
        L31:
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            super.onChildDraw(r1, r2, r3, r4, r5, r6, r7)
            goto L41
        L3d:
            r8.setTouchListener(r9, r10, r11, r12, r13, r14, r15)
        L40:
            r4 = r12
        L41:
            ru.tattelecom.intercom.android.resources.customview.ButtonsState r12 = r8.buttonShowedState
            ru.tattelecom.intercom.android.resources.customview.ButtonsState r0 = ru.tattelecom.intercom.android.resources.customview.ButtonsState.GONE
            if (r12 != r0) goto L51
            r0 = r8
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r13
            r6 = r14
            r7 = r15
            super.onChildDraw(r1, r2, r3, r4, r5, r6, r7)
        L51:
            r8.currentItemViewHolder = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.android.resources.customview.SwipeController.onChildDraw(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$ViewHolder, float, float, int, boolean):void");
    }

    private final void setTouchListener(final Canvas canvas, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float dX, final float dY, final int actionState, final boolean isCurrentlyActive) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SwipeController$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touchListener$lambda$0;
                touchListener$lambda$0 = SwipeController.setTouchListener$lambda$0(SwipeController.this, dX, canvas, recyclerView, viewHolder, dY, actionState, isCurrentlyActive, view, motionEvent);
                return touchListener$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchListener$lambda$0(SwipeController this$0, float f, Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2, int i, boolean z, View view, MotionEvent motionEvent) {
        ButtonsState buttonsState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(canvas, "$canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        boolean z2 = true;
        if (motionEvent.getAction() != 3 && motionEvent.getAction() != 1) {
            z2 = false;
        }
        this$0.swipeBack = z2;
        if (z2) {
            if (f < this$0.context.getResources().getDisplayMetrics().density * (-56.0f)) {
                buttonsState = ButtonsState.RIGHT_VISIBLE;
            } else {
                buttonsState = ButtonsState.NOT_VISIBLE;
            }
            this$0.buttonShowedState = buttonsState;
            if (buttonsState != ButtonsState.GONE) {
                this$0.setTouchDownListener(canvas, recyclerView, viewHolder, f2, i, z);
                this$0.setItemsClickable(recyclerView, false);
            }
        }
        return false;
    }

    private final void setTouchDownListener(final Canvas canvas, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float dY, final int actionState, final boolean isCurrentlyActive) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SwipeController$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touchDownListener$lambda$1;
                touchDownListener$lambda$1 = SwipeController.setTouchDownListener$lambda$1(SwipeController.this, canvas, recyclerView, viewHolder, dY, actionState, isCurrentlyActive, view, motionEvent);
                return touchDownListener$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchDownListener$lambda$1(SwipeController this$0, Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, int i, boolean z, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(canvas, "$canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        this$0.setTouchUpListener(canvas, recyclerView, viewHolder, f, i, z);
        return false;
    }

    private final void setTouchUpListener(final Canvas canvas, final RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, final float dY, final int actionState, final boolean isCurrentlyActive) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SwipeController$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean touchUpListener$lambda$4;
                touchUpListener$lambda$4 = SwipeController.setTouchUpListener$lambda$4(SwipeController.this, canvas, recyclerView, viewHolder, dY, actionState, isCurrentlyActive, view, motionEvent);
                return touchUpListener$lambda$4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchUpListener$lambda$4(SwipeController this$0, Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, int i, boolean z, View view, MotionEvent motionEvent) {
        SwipeControllerActions swipeControllerActions;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(canvas, "$canvas");
        Intrinsics.checkNotNullParameter(recyclerView, "$recyclerView");
        Intrinsics.checkNotNullParameter(viewHolder, "$viewHolder");
        if (motionEvent.getAction() == 1) {
            super.onChildDraw(canvas, recyclerView, viewHolder, 0.0f, f, i, z);
            recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: ru.tattelecom.intercom.android.resources.customview.SwipeController$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent2) {
                    boolean touchUpListener$lambda$4$lambda$2;
                    touchUpListener$lambda$4$lambda$2 = SwipeController.setTouchUpListener$lambda$4$lambda$2(view2, motionEvent2);
                    return touchUpListener$lambda$4$lambda$2;
                }
            });
            this$0.setItemsClickable(recyclerView, true);
            this$0.swipeBack = false;
            RectF rectF = this$0.buttonInstance;
            if (rectF != null && rectF.contains(motionEvent.getX(), motionEvent.getY()) && this$0.buttonShowedState == ButtonsState.RIGHT_VISIBLE && (swipeControllerActions = this$0.buttonsActions) != null) {
                swipeControllerActions.onClicked(viewHolder.getAbsoluteAdapterPosition());
            }
            this$0.buttonShowedState = ButtonsState.GONE;
            this$0.currentItemViewHolder = null;
        }
        return false;
    }

    private final void setItemsClickable(RecyclerView recyclerView, boolean isClickable) {
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount; i++) {
            recyclerView.getChildAt(i).setClickable(isClickable);
        }
    }

    private final void drawButtons(Canvas canvas, RecyclerView.ViewHolder viewHolder) {
        View itemView = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        Paint paint = new Paint();
        RectF rectF = new RectF(itemView.getLeft(), itemView.getTop(), itemView.getRight(), itemView.getBottom());
        RectF rectF2 = new RectF((itemView.getRight() - BUTTON_WIDTH) - ((this.context.getResources().getDisplayMetrics().density * 16) * 2), itemView.getTop(), itemView.getRight(), itemView.getBottom());
        paint.setColor(ContextCompat.getColor(this.context, R.color.red));
        canvas.drawRoundRect(rectF, this.context.getResources().getDisplayMetrics().density * BUTTON_CORNER, this.context.getResources().getDisplayMetrics().density * BUTTON_CORNER, paint);
        drawIcon(canvas, rectF2);
        this.buttonInstance = null;
        if (this.buttonShowedState == ButtonsState.RIGHT_VISIBLE) {
            this.buttonInstance = rectF2;
        }
    }

    private final void drawIcon(Canvas canvas, RectF button) {
        Drawable drawable = ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.ic_trash, null);
        int i = ((int) this.context.getResources().getDisplayMetrics().density) * 24;
        if (drawable != null) {
            int i2 = i / 2;
            drawable.setBounds(((int) button.centerX()) - i2, ((int) button.centerY()) - i2, ((int) button.centerX()) + i2, ((int) button.centerY()) + i2);
        }
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    public static /* synthetic */ void onDraw$default(SwipeController swipeController, Canvas canvas, RecyclerView recyclerView, int i, Object obj) {
        if ((i & 2) != 0) {
            recyclerView = null;
        }
        swipeController.onDraw(canvas, recyclerView);
    }

    public final void onDraw(Canvas c, RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(c, "c");
        RecyclerView.ViewHolder viewHolder = this.currentItemViewHolder;
        if (viewHolder != null) {
            if (this.buttonShowedState != ButtonsState.NOT_VISIBLE) {
                drawButtons(c, viewHolder);
            } else {
                if (this.buttonShowedState != ButtonsState.NOT_VISIBLE || recyclerView == null) {
                    return;
                }
                clearView(recyclerView, viewHolder);
            }
        }
    }
}
