package ru.tattelecom.intercom.android.resources.customview;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomCodeEditText.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 32\u00020\u0001:\u00013B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0014J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0014J(\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0014J\u0012\u00100\u001a\u00020\u001e2\b\u00101\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u00102\u001a\u00020\u001eH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lru/tattelecom/intercom/android/resources/customview/CustomCodeEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cellHeight", "", "cellPath", "Landroid/graphics/Path;", "cellWidth", "cellsCount", "errorStrokePaint", "Landroid/graphics/Paint;", "errorStrokePath", "fieldPaint", "fieldRect", "Landroid/graphics/RectF;", "mClickListener", "Landroid/view/View$OnClickListener;", "nightStrokePaint", "radiusArr", "", "space", "strokePaint", "strokeWidth", "addRoundRectPath", "", "xStart", "path", "drawTexts", "canvas", "Landroid/graphics/Canvas;", "initCellPath", "initErrorStrokePath", "initPaints", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", CmcdData.Factory.STREAMING_FORMAT_HLS, "oldw", "oldh", "setOnClickListener", CmcdData.Factory.STREAM_TYPE_LIVE, "updateViewSizes", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomCodeEditText extends AppCompatEditText {
    public static final float CELL_CORNER_RADIUS = 4.0f;
    public static final float DESIRED_CELL_HEIGHT = 46.0f;
    public static final float DESIRED_CELL_WIDTH = 34.0f;
    public static final float SPACE_BETWEEN_CELLS = 12.0f;
    public static final String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private float cellHeight;
    private Path cellPath;
    private float cellWidth;
    private int cellsCount;
    private Paint errorStrokePaint;
    private Path errorStrokePath;
    private Paint fieldPaint;
    private final RectF fieldRect;
    private View.OnClickListener mClickListener;
    private Paint nightStrokePaint;
    private final float[] radiusArr;
    private float space;
    private Paint strokePaint;
    private float strokeWidth;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCodeEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ CustomCodeEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.strokeWidth = 1.0f;
        this.radiusArr = new float[]{4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f, 4.0f};
        this.fieldRect = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.space = getResources().getDisplayMetrics().density * 12.0f;
        this.cellsCount = attributeSet != null ? attributeSet.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", 4) : 4;
        setBackgroundResource(0);
        initPaints();
        super.setCustomSelectionActionModeCallback(new ActionMode.Callback() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomCodeEditText.1
            @Override // android.view.ActionMode.Callback
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override // android.view.ActionMode.Callback
            public void onDestroyActionMode(ActionMode mode) {
            }

            @Override // android.view.ActionMode.Callback
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
        });
        super.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.android.resources.customview.CustomCodeEditText$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CustomCodeEditText._init_$lambda$0(CustomCodeEditText.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(CustomCodeEditText this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Editable text = this$0.getText();
        Intrinsics.checkNotNull(text);
        this$0.setSelection(text.length());
        View.OnClickListener onClickListener = this$0.mClickListener;
        if (onClickListener != null) {
            Intrinsics.checkNotNull(onClickListener);
            onClickListener.onClick(view);
        }
    }

    private final void initPaints() {
        Paint paint = new Paint();
        this.strokePaint = paint;
        paint.setColor(ContextCompat.getColor(getContext(), ru.tattelecom.intercom.android.resources.R.color.septenary));
        Paint paint2 = this.strokePaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            paint2 = null;
        }
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint4 = this.strokePaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
            paint4 = null;
        }
        paint4.setStrokeWidth(getResources().getDisplayMetrics().density * this.strokeWidth);
        Paint paint5 = new Paint();
        this.nightStrokePaint = paint5;
        paint5.setColor(ContextCompat.getColor(getContext(), ru.tattelecom.intercom.android.resources.R.color.night_cell_stroke));
        Paint paint6 = this.nightStrokePaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nightStrokePaint");
            paint6 = null;
        }
        paint6.setStyle(Paint.Style.STROKE);
        Paint paint7 = this.nightStrokePaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nightStrokePaint");
            paint7 = null;
        }
        paint7.setStrokeWidth(getResources().getDisplayMetrics().density * this.strokeWidth);
        Paint paint8 = new Paint();
        this.errorStrokePaint = paint8;
        paint8.setColor(ContextCompat.getColor(getContext(), ru.tattelecom.intercom.android.resources.R.color.error));
        Paint paint9 = this.errorStrokePaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorStrokePaint");
            paint9 = null;
        }
        paint9.setStyle(Paint.Style.STROKE);
        Paint paint10 = this.errorStrokePaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorStrokePaint");
        } else {
            paint3 = paint10;
        }
        paint3.setStrokeWidth(getResources().getDisplayMetrics().density * this.strokeWidth);
        Paint paint11 = new Paint();
        this.fieldPaint = paint11;
        paint11.setColor(ContextCompat.getColor(getContext(), ru.tattelecom.intercom.android.resources.R.color.code_cell_bg));
        getPaint().setColor(ContextCompat.getColor(getContext(), ru.tattelecom.intercom.android.resources.R.color.primary));
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener l) {
        this.mClickListener = l;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight();
        int suggestedMinimumHeight = getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom();
        int i = (int) (getResources().getDisplayMetrics().density * 34.0f);
        int i2 = (int) (getResources().getDisplayMetrics().density * 46.0f);
        int i3 = this.cellsCount;
        float f = this.space;
        setMeasuredDimension(AppCompatEditText.resolveSize(Math.max(suggestedMinimumWidth, ((i3 * (i + ((int) f))) - ((int) f)) + getPaddingLeft() + getPaddingRight()), widthMeasureSpec), AppCompatEditText.resolveSize(Math.max(suggestedMinimumHeight, i2 + getPaddingTop() + getPaddingBottom()), heightMeasureSpec));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        updateViewSizes();
        initCellPath();
        initErrorStrokePath();
    }

    private final void updateViewSizes() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingLeft()) - getPaddingRight();
        float f = getResources().getDisplayMetrics().density * 34.0f;
        float f2 = getResources().getDisplayMetrics().density * 46.0f;
        float f3 = width;
        this.cellWidth = Math.min((f3 - ((r4 - 1) * this.space)) / this.cellsCount, f);
        float f4 = height;
        float min = Math.min(f4, f2);
        this.cellHeight = min;
        float f5 = (this.cellWidth * this.cellsCount) + (this.space * (r4 - 1));
        float f6 = 2;
        this.fieldRect.left = getPaddingLeft() + ((f3 - f5) / f6);
        this.fieldRect.top = getPaddingTop() + ((f4 - min) / f6);
        RectF rectF = this.fieldRect;
        rectF.right = rectF.left + f5;
        RectF rectF2 = this.fieldRect;
        rectF2.bottom = rectF2.top + min;
    }

    private final void initCellPath() {
        this.cellPath = new Path();
        float f = this.fieldRect.left;
        int i = this.cellsCount;
        for (int i2 = 0; i2 < i; i2++) {
            Path path = this.cellPath;
            if (path == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cellPath");
                path = null;
            }
            addRoundRectPath(f, path);
            f += this.cellWidth + this.space;
        }
    }

    private final void initErrorStrokePath() {
        this.errorStrokePath = new Path();
        float f = this.fieldRect.left;
        int i = this.cellsCount;
        for (int i2 = 0; i2 < i; i2++) {
            Path path = this.errorStrokePath;
            if (path == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorStrokePath");
                path = null;
            }
            addRoundRectPath(f, path);
            f += this.cellWidth + this.space;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Path path = this.cellPath;
        Paint paint = null;
        if (path == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cellPath");
            path = null;
        }
        Paint paint2 = this.fieldPaint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fieldPaint");
            paint2 = null;
        }
        canvas.drawPath(path, paint2);
        Path path2 = this.cellPath;
        if (path2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cellPath");
            path2 = null;
        }
        Paint paint3 = this.nightStrokePaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nightStrokePaint");
            paint3 = null;
        }
        canvas.drawPath(path2, paint3);
        drawTexts(canvas);
        if (Intrinsics.areEqual(getTag(), "error")) {
            Path path3 = this.errorStrokePath;
            if (path3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorStrokePath");
                path3 = null;
            }
            Paint paint4 = this.errorStrokePaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorStrokePaint");
            } else {
                paint = paint4;
            }
            canvas.drawPath(path3, paint);
        }
    }

    private final void drawTexts(Canvas canvas) {
        Editable text = getText();
        if (text == null || text.length() == 0) {
            return;
        }
        float f = this.fieldRect.left;
        Editable text2 = getText();
        Intrinsics.checkNotNull(text2);
        int length = text2.length();
        float[] fArr = new float[length];
        getPaint().getTextWidths(getText(), 0, length, fArr);
        int i = this.cellsCount;
        for (int i2 = 0; i2 < i; i2++) {
            Path path = new Path();
            if (length > i2) {
                addRoundRectPath(f, path);
                if (!Intrinsics.areEqual(getTag(), "error")) {
                    Paint paint = this.strokePaint;
                    if (paint == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("strokePaint");
                        paint = null;
                    }
                    canvas.drawPath(path, paint);
                }
                Editable text3 = getText();
                Intrinsics.checkNotNull(text3);
                float f2 = 2;
                canvas.drawText(text3, i2, i2 + 1, f + ((this.cellWidth - fArr[0]) / f2), ((this.fieldRect.bottom + this.fieldRect.top) / f2) + (getTextSize() / 3), getPaint());
            }
            f += this.cellWidth + this.space;
        }
    }

    private final void addRoundRectPath(float xStart, Path path) {
        path.addRoundRect(new RectF(xStart, this.fieldRect.top, this.cellWidth + xStart, this.fieldRect.bottom), this.radiusArr, Path.Direction.CW);
    }
}
