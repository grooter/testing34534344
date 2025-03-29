package ru.tattelecom.intercom.android.resources.timerangepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.R;

/* compiled from: TimeSliderRangePicker.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020 H\u0002J\u0010\u0010Y\u001a\u00020 2\u0006\u0010Z\u001a\u00020 H\u0002J\"\u0010[\u001a\u00020V2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\\\u001a\u00020VH\u0002J\u0010\u0010]\u001a\u00020V2\u0006\u0010^\u001a\u00020_H\u0014J(\u0010`\u001a\u00020V2\u0006\u0010a\u001a\u00020\u00072\u0006\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0007H\u0014J\u0010\u0010e\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020gH\u0016J\u000e\u0010h\u001a\u00020V2\u0006\u0010i\u001a\u00020\u0007J\u000e\u0010j\u001a\u00020V2\u0006\u0010k\u001a\u00020\u0007J\u000e\u0010l\u001a\u00020V2\u0006\u0010m\u001a\u00020\u0007J\u000e\u0010n\u001a\u00020V2\u0006\u0010o\u001a\u00020 J\u000e\u0010p\u001a\u00020V2\u0006\u0010k\u001a\u00020\u0007J\u0010\u0010q\u001a\u00020V2\b\u0010r\u001a\u0004\u0018\u00010+J\u000e\u0010s\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0010J\u0010\u0010t\u001a\u00020V2\b\u0010u\u001a\u0004\u0018\u000102J\u0010\u0010v\u001a\u00020V2\b\u0010u\u001a\u0004\u0018\u000106J\u000e\u0010w\u001a\u00020V2\u0006\u0010x\u001a\u00020\u0007J\u000e\u0010y\u001a\u00020V2\u0006\u0010z\u001a\u00020 J\u000e\u0010{\u001a\u00020V2\u0006\u0010k\u001a\u00020\u0007J\u0010\u0010|\u001a\u00020V2\b\u0010r\u001a\u0004\u0018\u00010+J\u000e\u0010}\u001a\u00020V2\u0006\u0010W\u001a\u00020\u0010J\u000e\u0010~\u001a\u00020V2\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u007f\u001a\u00020V2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0011\u0010\u0080\u0001\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0010H\u0002J\u0013\u0010\u0081\u0001\u001a\u00030\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020 H\u0002J\u0007\u0010\u0084\u0001\u001a\u00020VJ\u001b\u0010\u0085\u0001\u001a\u00020V2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u0007H\u0002J%\u0010\u0085\u0001\u001a\u00020V2\u0007\u0010\u0086\u0001\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u00072\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u0019R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R\u000e\u0010A\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0013R$\u0010G\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R\u000e\u0010J\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010O\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0017\"\u0004\bQ\u0010\u0019R\u001a\u0010R\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0017\"\u0004\bT\u0010\u0019¨\u0006\u008b\u0001"}, d2 = {"Lru/tattelecom/intercom/android/resources/timerangepicker/TimeSliderRangePicker;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arcColorAM", "arcColorPM", "arcRect", "Landroid/graphics/Rect;", "arcRectF", "Landroid/graphics/RectF;", "<set-?>", "Ljava/util/Calendar;", TtmlNode.END, "getEnd", "()Ljava/util/Calendar;", "thumbSize", "endThumbSize", "getEndThumbSize", "()I", "setEndThumbSize", "(I)V", "isThumbsDisabled", "", "longTickLen", "getLongTickLen", "setLongTickLen", "mAngleEnd", "", "mAngleStart", "mArcColor", "mArcDashSize", "mBorderColor", "mBorderThickness", "mCircleCenterX", "mCircleCenterY", "mCircleRadius", "mEndThumbColor", "mEndThumbImage", "Landroid/graphics/drawable/Drawable;", "mEndThumbSize", "mIsThumbEndSelected", "mIsThumbSelected", "mLinePaint", "Landroid/graphics/Paint;", "mListener", "Lru/tattelecom/intercom/android/resources/timerangepicker/OnSliderRangeMovedListener;", "mPadding", "mPaint", "mPressedListener", "Lru/tattelecom/intercom/android/resources/timerangepicker/OnSliderPressedListener;", "mStartThumbColor", "mStartThumbImage", "mStartThumbSize", "mThumbEndX", "mThumbEndY", "mThumbStartX", "mThumbStartY", "medTickLen", "getMedTickLen", "setMedTickLen", "oldX", "oldY", "paint", "rect", TtmlNode.START, "getStart", "startThumbSize", "getStartThumbSize", "setStartThumbSize", "textPaint", "thumbEndImageAM", "thumbEndImagePM", "thumbImageAM", "thumbImagePM", "tickColor", "getTickColor", "setTickColor", "tickLen", "getTickLen", "setTickLen", "degreesToTime", "", CrashHianalyticsData.TIME, "degrees", "fromDrawingAngle", "angleInDegrees", "init", "notifyChanges", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", CmcdData.Factory.STREAMING_FORMAT_HLS, "oldw", "oldh", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "setArcDashSize", "value", "setBorderColor", "color", "setBorderThickness", "circleBorderThickness", "setEndAngle", "angle", "setEndThumbColor", "setEndThumbImage", "drawable", "setEndTime", "setOnChangeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnPressedListener", "setPadding", "padding", "setStartAngle", "startAngle", "setStartThumbColor", "setStartThumbImage", "setStartTime", "setThumbSize", "setTime", "timeToDegrees", "toDrawingAngle", "", "angleInRadians", "updateArcColor", "updateSliderState", "touchX", "touchY", "thumb", "Lru/tattelecom/intercom/android/resources/timerangepicker/Thumb;", "Companion", "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeSliderRangePicker extends View {
    private static final int THUMB_SIZE_NOT_DEFINED = -1;
    private int arcColorAM;
    private int arcColorPM;
    private final Rect arcRect;
    private final RectF arcRectF;
    private Calendar end;
    private final boolean isThumbsDisabled;
    private int longTickLen;
    private double mAngleEnd;
    private double mAngleStart;
    private int mArcColor;
    private int mArcDashSize;
    private int mBorderColor;
    private int mBorderThickness;
    private int mCircleCenterX;
    private int mCircleCenterY;
    private int mCircleRadius;
    private int mEndThumbColor;
    private Drawable mEndThumbImage;
    private int mEndThumbSize;
    private boolean mIsThumbEndSelected;
    private boolean mIsThumbSelected;
    private final Paint mLinePaint;
    private OnSliderRangeMovedListener mListener;
    private int mPadding;
    private final Paint mPaint;
    private OnSliderPressedListener mPressedListener;
    private int mStartThumbColor;
    private Drawable mStartThumbImage;
    private int mStartThumbSize;
    private int mThumbEndX;
    private int mThumbEndY;
    private int mThumbStartX;
    private int mThumbStartY;
    private int medTickLen;
    private int oldX;
    private int oldY;
    private final Paint paint;
    private final Rect rect;
    private Calendar start;
    private final Paint textPaint;
    private Drawable thumbEndImageAM;
    private Drawable thumbEndImagePM;
    private Drawable thumbImageAM;
    private Drawable thumbImagePM;
    private int tickColor;
    private int tickLen;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeSliderRangePicker(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeSliderRangePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TimeSliderRangePicker(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeSliderRangePicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPaint = new Paint();
        this.mLinePaint = new Paint();
        this.arcRectF = new RectF();
        this.arcRect = new Rect();
        this.paint = new Paint();
        this.textPaint = new Paint(1);
        this.rect = new Rect();
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
        this.start = calendar;
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar2, "getInstance(...)");
        this.end = calendar2;
        this.tickLen = 10;
        this.medTickLen = 20;
        this.longTickLen = 20;
        this.tickColor = 13421772;
        init(context, attributeSet, i);
    }

    public final Calendar getStart() {
        return this.start;
    }

    public final Calendar getEnd() {
        return this.end;
    }

    public final int getTickLen() {
        return this.tickLen;
    }

    public final void setTickLen(int i) {
        this.tickLen = i;
    }

    public final int getMedTickLen() {
        return this.medTickLen;
    }

    public final void setMedTickLen(int i) {
        this.medTickLen = i;
    }

    public final int getLongTickLen() {
        return this.longTickLen;
    }

    public final void setLongTickLen(int i) {
        this.longTickLen = i;
    }

    public final int getTickColor() {
        return this.tickColor;
    }

    public final void setTickColor(int i) {
        this.tickColor = i;
    }

    private final void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.TimeSliderRangePicker, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TimeSliderRangePicker_thumb_size, 50);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TimeSliderRangePicker_start_thumb_size, -1);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TimeSliderRangePicker_end_thumb_size, -1);
        int color = obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_start_thumb_color, -7829368);
        int color2 = obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_end_thumb_color, -7829368);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TimeSliderRangePicker_border_thickness, 20);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TimeSliderRangePicker_arc_dash_size, 60);
        this.arcColorAM = obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_arc_color_am, 0);
        this.arcColorPM = obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_arc_color_pm, 0);
        int color3 = obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_border_color, SupportMenu.CATEGORY_MASK);
        this.thumbImageAM = obtainStyledAttributes.getDrawable(R.styleable.TimeSliderRangePicker_start_thumb_image_am);
        this.thumbEndImageAM = obtainStyledAttributes.getDrawable(R.styleable.TimeSliderRangePicker_end_thumb_image_am);
        this.thumbImagePM = obtainStyledAttributes.getDrawable(R.styleable.TimeSliderRangePicker_start_thumb_image_pm);
        this.thumbEndImagePM = obtainStyledAttributes.getDrawable(R.styleable.TimeSliderRangePicker_end_thumb_image_pm);
        this.start.set(11, 3);
        this.start.set(12, 0);
        this.end.set(11, 6);
        this.end.set(12, 0);
        setStartAngle(timeToDegrees(this.start));
        setEndAngle(timeToDegrees(this.end));
        setBorderThickness(dimensionPixelSize4);
        setBorderColor(color3);
        setThumbSize(dimensionPixelSize);
        setStartThumbSize(dimensionPixelSize2);
        setEndThumbSize(dimensionPixelSize3);
        setStartThumbImage(this.thumbImageAM);
        setEndThumbImage(this.thumbEndImageAM);
        setStartThumbColor(color);
        setEndThumbColor(color2);
        updateArcColor();
        setArcDashSize(dimensionPixelSize5);
        this.textPaint.setColor(obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_text_interval_color, ViewCompat.MEASURED_STATE_MASK));
        this.paint.setColor(obtainStyledAttributes.getColor(R.styleable.TimeSliderRangePicker_text_interval_color, ViewCompat.MEASURED_STATE_MASK));
        setPadding((((((getPaddingLeft() + getPaddingRight()) + getPaddingBottom()) + getPaddingTop()) + getPaddingEnd()) + getPaddingStart()) / 6);
        obtainStyledAttributes.recycle();
        isInEditMode();
    }

    public final void setTime(Calendar start, Calendar end) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        this.start = start;
        this.end = end;
        this.mAngleStart = fromDrawingAngle(timeToDegrees(start));
        this.mAngleEnd = fromDrawingAngle(timeToDegrees(end));
        updateArcColor();
        invalidate();
        notifyChanges();
    }

    public final void setStartTime(Calendar time) {
        Intrinsics.checkNotNullParameter(time, "time");
        this.mAngleStart = fromDrawingAngle(timeToDegrees(time));
        updateArcColor();
        invalidate();
    }

    public final void setEndTime(Calendar time) {
        Intrinsics.checkNotNullParameter(time, "time");
        this.mAngleEnd = fromDrawingAngle(timeToDegrees(time));
        updateArcColor();
        invalidate();
    }

    public final void setStartAngle(double startAngle) {
        this.mAngleStart = fromDrawingAngle(startAngle);
    }

    public final void setEndAngle(double angle) {
        this.mAngleEnd = fromDrawingAngle(angle);
    }

    public final void setThumbSize(int thumbSize) {
        setStartThumbSize(thumbSize);
        setEndThumbSize(thumbSize);
    }

    /* renamed from: getStartThumbSize, reason: from getter */
    public final int getMStartThumbSize() {
        return this.mStartThumbSize;
    }

    public final void setStartThumbSize(int i) {
        if (i == -1) {
            return;
        }
        this.mStartThumbSize = i;
    }

    /* renamed from: getEndThumbSize, reason: from getter */
    public final int getMEndThumbSize() {
        return this.mEndThumbSize;
    }

    public final void setEndThumbSize(int i) {
        if (i == -1) {
            return;
        }
        this.mEndThumbSize = i;
    }

    public final void setBorderThickness(int circleBorderThickness) {
        this.mBorderThickness = circleBorderThickness;
    }

    public final void setBorderColor(int color) {
        this.mBorderColor = color;
    }

    public final void setStartThumbImage(Drawable drawable) {
        this.mStartThumbImage = drawable;
    }

    public final void setEndThumbImage(Drawable drawable) {
        this.mEndThumbImage = drawable;
    }

    public final void setStartThumbColor(int color) {
        this.mStartThumbColor = color;
    }

    public final void setEndThumbColor(int color) {
        this.mEndThumbColor = color;
    }

    public final void setPadding(int padding) {
        this.mPadding = padding;
    }

    public final void updateArcColor() {
        if (this.start.get(9) == 0) {
            this.mArcColor = this.arcColorAM;
            this.mStartThumbImage = this.thumbImageAM;
            this.mEndThumbImage = this.thumbEndImageAM;
        } else {
            this.mArcColor = this.arcColorPM;
            this.mStartThumbImage = this.thumbImagePM;
            this.mEndThumbImage = this.thumbEndImagePM;
        }
    }

    public final void setArcDashSize(int value) {
        this.mArcDashSize = value;
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int i = w > h ? h : w;
        int i2 = ((w - i) / 2) + i;
        int i3 = ((h - i) / 2) + i;
        this.mCircleCenterX = (i2 / 2) + ((w - i2) / 2);
        this.mCircleCenterY = (i3 / 2) + ((h - i3) / 2);
        this.mCircleRadius = ((i / 2) - (this.mBorderThickness / 2)) - this.mPadding;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        double d;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        int i3 = 2;
        double d2 = (this.mCircleRadius - (this.mBorderThickness / 2)) - 10.0d;
        double d3 = this.mCircleCenterX;
        double d4 = this.mCircleCenterY;
        Paint paint = this.paint;
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        paint.setStrokeWidth(DimensionsKt.dip(r2, 1));
        Paint paint2 = this.textPaint;
        Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
        paint2.setTextSize(DimensionsKt.dip(r2, 12));
        int i4 = 1;
        while (i4 < 25) {
            if (i4 % 2 == 0) {
                double d5 = 1.5707963267948966d - (((i4 / 24.0d) * 2.0d) * 3.141592653589793d);
                double cos = Math.cos(d5);
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                float dip = (float) ((cos * (d2 - DimensionsKt.dip(r3, i3))) + d3);
                double sin = Math.sin(d5);
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                float dip2 = (float) (d4 - (sin * (d2 - DimensionsKt.dip(r1, i3))));
                i2 = i4;
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                d = d2;
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                canvas.drawLine(dip, dip2, (float) ((Math.cos(d5) * ((d2 - this.medTickLen) - DimensionsKt.dip(r1, i3))) + d3), (float) (d4 - (Math.sin(d5) * ((d - this.medTickLen) - DimensionsKt.dip(r1, 2)))), this.paint);
                StringBuilder sb = new StringBuilder();
                sb.append(i2);
                String sb2 = sb.toString();
                this.textPaint.getTextBounds(sb2, 0, sb2.length(), this.rect);
                int width = this.rect.width();
                float height = this.rect.height();
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                int cos2 = (int) ((Math.cos(d5) * ((d - this.longTickLen) - DimensionsKt.dip(r6, 16))) + d3);
                double sin2 = Math.sin(d5);
                double d6 = d - this.longTickLen;
                Intrinsics.checkNotNullExpressionValue(getContext(), "getContext(...)");
                canvas2 = canvas;
                canvas2.drawText(sb2, cos2 - (width / 2), ((int) (d4 - (sin2 * (d6 - DimensionsKt.dip(r7, 16))))) + (height / 3), this.textPaint);
            } else {
                i2 = i4;
                d = d2;
            }
            i4 = i2 + 1;
            d2 = d;
            i3 = 2;
        }
        this.mPaint.setColor(this.mBorderColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mBorderThickness);
        this.mPaint.setAntiAlias(true);
        canvas2.drawCircle(this.mCircleCenterX, this.mCircleCenterY, this.mCircleRadius, this.mPaint);
        this.mThumbStartX = (int) (this.mCircleCenterX + (this.mCircleRadius * Math.cos(this.mAngleStart)));
        this.mThumbStartY = (int) (this.mCircleCenterY - (this.mCircleRadius * Math.sin(this.mAngleStart)));
        this.mThumbEndX = (int) (this.mCircleCenterX + (this.mCircleRadius * Math.cos(this.mAngleEnd)));
        this.mThumbEndY = (int) (this.mCircleCenterY - (this.mCircleRadius * Math.sin(this.mAngleEnd)));
        Paint paint3 = this.mLinePaint;
        int i5 = this.mArcColor;
        int i6 = SupportMenu.CATEGORY_MASK;
        if (i5 == 0) {
            i5 = -65536;
        }
        paint3.setColor(i5);
        this.mLinePaint.setStyle(Paint.Style.STROKE);
        this.mLinePaint.setStrokeWidth(this.mArcDashSize);
        this.mLinePaint.setAntiAlias(true);
        this.mLinePaint.setTextSize(50.0f);
        Rect rect = this.arcRect;
        int i7 = this.mCircleCenterX;
        int i8 = this.mCircleRadius;
        int i9 = this.mCircleCenterY;
        rect.set(i7 - i8, i9 + i8, i7 + i8, i9 - i8);
        this.arcRectF.set(this.arcRect);
        this.arcRectF.sort();
        float drawingAngle = toDrawingAngle(this.mAngleStart);
        float drawingAngle2 = toDrawingAngle(this.mAngleEnd);
        if (drawingAngle != drawingAngle2) {
            float f = 360;
            canvas.drawArc(this.arcRectF, drawingAngle, ((drawingAngle2 + f) - drawingAngle) % f, false, this.mLinePaint);
        }
        this.mPaint.setStyle(Paint.Style.FILL);
        Paint paint4 = this.mPaint;
        int i10 = this.mArcColor;
        if (i10 == 0) {
            i10 = -65536;
        }
        paint4.setColor(i10);
        canvas2.drawCircle(this.mThumbStartX, this.mThumbStartY, this.mArcDashSize / 2, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        Paint paint5 = this.mPaint;
        int i11 = this.mArcColor;
        if (i11 != 0) {
            i6 = i11;
        }
        paint5.setColor(i6);
        canvas2.drawCircle(this.mThumbEndX, this.mThumbEndY, this.mArcDashSize / 2, this.mPaint);
        int mStartThumbSize = getMStartThumbSize();
        Drawable drawable = this.mStartThumbImage;
        if (drawable != null) {
            Intrinsics.checkNotNull(drawable);
            int i12 = this.mThumbStartX;
            int i13 = mStartThumbSize / 2;
            int i14 = this.mThumbStartY;
            drawable.setBounds(i12 - i13, i14 - i13, i12 + i13, i14 + i13);
            Drawable drawable2 = this.mStartThumbImage;
            Intrinsics.checkNotNull(drawable2);
            drawable2.draw(canvas2);
            i = 2;
        } else {
            this.mPaint.setColor(this.mStartThumbColor);
            this.mPaint.setStyle(Paint.Style.FILL);
            i = 2;
            canvas2.drawCircle(this.mThumbStartX, this.mThumbStartY, mStartThumbSize / 2, this.mPaint);
        }
        int mEndThumbSize = getMEndThumbSize();
        Drawable drawable3 = this.mEndThumbImage;
        if (drawable3 != null) {
            Intrinsics.checkNotNull(drawable3);
            int i15 = this.mThumbEndX;
            int i16 = mEndThumbSize / i;
            int i17 = this.mThumbEndY;
            drawable3.setBounds(i15 - i16, i17 - i16, i15 + i16, i17 + i16);
            Drawable drawable4 = this.mEndThumbImage;
            Intrinsics.checkNotNull(drawable4);
            drawable4.draw(canvas2);
            return;
        }
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mEndThumbColor);
        canvas2.drawCircle(this.mThumbEndX, this.mThumbEndY, mEndThumbSize / 2, this.mPaint);
    }

    private final void updateSliderState(int touchX, int touchY) {
        int i = touchX - this.mCircleCenterX;
        int i2 = this.mCircleCenterY - touchY;
        double d = i;
        double d2 = 2;
        double acos = Math.acos(d / Math.sqrt(Math.pow(d, d2) + Math.pow(i2, d2)));
        if (i2 < 0) {
            acos = -acos;
        }
        int i3 = this.oldX - this.mCircleCenterX;
        int i4 = this.mCircleCenterY - this.oldY;
        double d3 = i3;
        double acos2 = Math.acos(d3 / Math.sqrt(Math.pow(d3, d2) + Math.pow(i4, d2)));
        if (i4 < 0) {
            acos2 = -acos2;
        }
        double d4 = acos - acos2;
        double d5 = this.mAngleStart;
        double d6 = this.mAngleEnd;
        this.mAngleStart = d5 + d4;
        this.mAngleEnd = d6 + d4;
        degreesToTime(this.start, toDrawingAngle(r0));
        degreesToTime(this.end, toDrawingAngle(this.mAngleEnd));
        this.oldX = touchX;
        this.oldY = touchY;
        notifyChanges();
    }

    private final void updateSliderState(int touchX, int touchY, Thumb thumb) {
        int i = touchX - this.mCircleCenterX;
        int i2 = this.mCircleCenterY - touchY;
        double d = i;
        double d2 = 2;
        double acos = Math.acos(d / Math.sqrt(Math.pow(d, d2) + Math.pow(i2, d2)));
        if (i2 < 0) {
            acos = -acos;
        }
        if (thumb == Thumb.START) {
            this.mAngleStart = acos;
            degreesToTime(this.start, toDrawingAngle(acos));
        } else {
            this.mAngleEnd = acos;
            degreesToTime(this.end, toDrawingAngle(acos));
        }
        notifyChanges();
    }

    private final void notifyChanges() {
        OnSliderRangeMovedListener onSliderRangeMovedListener = this.mListener;
        if (onSliderRangeMovedListener != null) {
            Intrinsics.checkNotNull(onSliderRangeMovedListener);
            onSliderRangeMovedListener.onChange(this.start, this.end);
        }
    }

    private final float toDrawingAngle(double angleInRadians) {
        double degrees = Math.toDegrees(angleInRadians);
        return (float) (angleInRadians > 0.0d ? 360 - degrees : -degrees);
    }

    private final double fromDrawingAngle(double angleInDegrees) {
        return -Math.toRadians(angleInDegrees);
    }

    private final double timeToDegrees(Calendar time) {
        double d = time.get(11);
        return ((d <= 0.0d || d >= 6.0d) ? (d * 15) - 90 : (d * 15) + 270) + ((time.get(12) / 60.0d) * 15.0d);
    }

    private final void degreesToTime(Calendar time, double degrees) {
        time.set(11, (int) ((degrees <= 270.0d || degrees >= 360.0d) ? (degrees / 15) + 6 : (degrees - 270) / 15));
        int i = ((int) ((degrees * 60) / 15)) % 60;
        time.set(12, i >= 10 ? (10 - (i % 10)) + i : 10);
    }

    public final void setOnChangeListener(OnSliderRangeMovedListener listener) {
        this.mListener = listener;
    }

    public final void setOnPressedListener(OnSliderPressedListener listener) {
        this.mPressedListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c3  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            int r0 = r8.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L65
            if (r0 == r2) goto L55
            r1 = 2
            if (r0 == r1) goto L14
            goto Lc9
        L14:
            boolean r0 = r7.mIsThumbSelected
            if (r0 == 0) goto L2d
            boolean r0 = r7.isThumbsDisabled
            if (r0 != 0) goto L2d
            float r0 = r8.getX()
            int r0 = (int) r0
            float r8 = r8.getY()
            int r8 = (int) r8
            ru.tattelecom.intercom.android.resources.timerangepicker.Thumb r1 = ru.tattelecom.intercom.android.resources.timerangepicker.Thumb.START
            r7.updateSliderState(r0, r8, r1)
            goto Lc9
        L2d:
            boolean r0 = r7.mIsThumbEndSelected
            if (r0 == 0) goto L46
            boolean r0 = r7.isThumbsDisabled
            if (r0 != 0) goto L46
            float r0 = r8.getX()
            int r0 = (int) r0
            float r8 = r8.getY()
            int r8 = (int) r8
            ru.tattelecom.intercom.android.resources.timerangepicker.Thumb r1 = ru.tattelecom.intercom.android.resources.timerangepicker.Thumb.END
            r7.updateSliderState(r0, r8, r1)
            goto Lc9
        L46:
            float r0 = r8.getX()
            int r0 = (int) r0
            float r8 = r8.getY()
            int r8 = (int) r8
            r7.updateSliderState(r0, r8)
            goto Lc9
        L55:
            ru.tattelecom.intercom.android.resources.timerangepicker.OnSliderPressedListener r8 = r7.mPressedListener
            if (r8 == 0) goto L5f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.onPressStateChanged(r1)
        L5f:
            r7.mIsThumbSelected = r1
            r7.mIsThumbEndSelected = r1
            goto Lc9
        L65:
            float r0 = r8.getX()
            int r0 = (int) r0
            float r8 = r8.getY()
            int r8 = (int) r8
            int r3 = r7.getMStartThumbSize()
            int r4 = r7.mThumbStartX
            int r5 = r4 + r3
            if (r0 >= r5) goto L87
            int r4 = r4 - r3
            if (r0 <= r4) goto L87
            int r4 = r7.mThumbStartY
            int r5 = r4 + r3
            if (r8 >= r5) goto L87
            int r4 = r4 - r3
            if (r8 <= r4) goto L87
            r3 = r2
            goto L88
        L87:
            r3 = r1
        L88:
            int r4 = r7.getMEndThumbSize()
            int r5 = r7.mThumbEndX
            int r6 = r5 + r4
            if (r0 >= r6) goto L9f
            int r5 = r5 - r4
            if (r0 <= r5) goto L9f
            int r5 = r7.mThumbEndY
            int r6 = r5 + r4
            if (r8 >= r6) goto L9f
            int r5 = r5 - r4
            if (r8 <= r5) goto L9f
            r1 = r2
        L9f:
            if (r3 == 0) goto Lad
            boolean r3 = r7.isThumbsDisabled
            if (r3 != 0) goto Lad
            r7.mIsThumbSelected = r2
            ru.tattelecom.intercom.android.resources.timerangepicker.Thumb r1 = ru.tattelecom.intercom.android.resources.timerangepicker.Thumb.START
            r7.updateSliderState(r0, r8, r1)
            goto Lbf
        Lad:
            if (r1 == 0) goto Lbb
            boolean r1 = r7.isThumbsDisabled
            if (r1 != 0) goto Lbb
            r7.mIsThumbEndSelected = r2
            ru.tattelecom.intercom.android.resources.timerangepicker.Thumb r1 = ru.tattelecom.intercom.android.resources.timerangepicker.Thumb.END
            r7.updateSliderState(r0, r8, r1)
            goto Lbf
        Lbb:
            r7.oldX = r0
            r7.oldY = r8
        Lbf:
            ru.tattelecom.intercom.android.resources.timerangepicker.OnSliderPressedListener r8 = r7.mPressedListener
            if (r8 == 0) goto Lc9
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r8.onPressStateChanged(r2)
        Lc9:
            r7.invalidate()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.android.resources.timerangepicker.TimeSliderRangePicker.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
