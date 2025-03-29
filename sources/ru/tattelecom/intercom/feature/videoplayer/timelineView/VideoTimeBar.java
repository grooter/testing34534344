package ru.tattelecom.intercom.feature.videoplayer.timelineView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.extensions.ExtensionsKt;
import ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar;

/* compiled from: VideoTimeBar.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002=>B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000eH\u0014J\u0018\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0016J \u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020#H\u0014J\u0018\u0010+\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0016J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H\u0016J \u0010-\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u000eH\u0016J\u0012\u0010/\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\u001e\u00100\u001a\u00020&2\f\u00101\u001a\b\u0018\u000102R\u00020\u00012\u0006\u00103\u001a\u00020\u000eH\u0014J\u0010\u00104\u001a\u00020&2\b\b\u0001\u00105\u001a\u00020\u0014J\u001a\u00104\u001a\u00020&2\b\b\u0001\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\u0010H\u0002J\u0018\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020#2\u0006\u0010:\u001a\u00020#H\u0016J\u0010\u0010;\u001a\u00020&2\u0006\u0010<\u001a\u00020\u000eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u00148\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/VideoTimeBar;", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar;", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$TickMarkStrategy;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "colorScaleBackground", "", "cursorBackgroundColor", "cursorDateFormat", "Ljava/text/SimpleDateFormat;", "cursorValueSize", "", "isTimeVisible", "", "mColorCursorPaint", "Landroid/graphics/Paint;", "mMode", "", "getMMode$annotations", "()V", "mTickPaint", "mTriangleHeight", "mTrianglePath", "Landroid/graphics/Path;", "simpleDateFormat", "tickValueBoundOffsetH", "tickValueColor", "tickValueSize", "calcContentHeight", "baselinePositionProportion", "disPlay", "scaleValue", "", "keyScale", "drawCursor", "", "canvas", "Landroid/graphics/Canvas;", "cursorPosition", "cursorValue", "getColor", "getScaleValue", "getSize", "maxScaleValueSize", "onEndTickDraw", "onScale", "info", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$ScaleMode;", "unitPixel", "setMode", "mode", "m", "setScaleRatio", "setRange", TtmlNode.START, TtmlNode.END, "updateMode", "screenSpanValue", "Companion", "Mode", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class VideoTimeBar extends ScalableScaleBar implements ScalableScaleBar.TickMarkStrategy {
    public static final String MODE_UNIT_10_MIN = "scale unit 10 minute";
    public static final long MODE_UNIT_10_MIN_VALUE = 600000;
    public static final String MODE_UNIT_1_HOUR = "scale unit 1 hour";
    public static final long MODE_UNIT_1_HOUR_VALUE = 3600000;
    public static final String MODE_UNIT_1_MIN = "scale unit 1 minute";
    public static final long MODE_UNIT_1_MIN_VALUE = 60000;
    private final int colorScaleBackground;
    private final int cursorBackgroundColor;
    private SimpleDateFormat cursorDateFormat;
    private final float cursorValueSize;
    private boolean isTimeVisible;
    private final Paint mColorCursorPaint;
    private String mMode;
    private final Paint mTickPaint;
    private final float mTriangleHeight;
    private final Path mTrianglePath;
    private final SimpleDateFormat simpleDateFormat;
    private float tickValueBoundOffsetH;
    private final int tickValueColor;
    private final float tickValueSize;

    /* compiled from: VideoTimeBar.kt */
    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0086\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/VideoTimeBar$Mode;", "", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public @interface Mode {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VideoTimeBar(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Mode
    private static /* synthetic */ void getMMode$annotations() {
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.TickMarkStrategy
    public boolean disPlay(long scaleValue, boolean keyScale) {
        return keyScale;
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar
    protected void onEndTickDraw(Canvas canvas) {
    }

    public /* synthetic */ VideoTimeBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoTimeBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMode = MODE_UNIT_1_MIN;
        this.mTriangleHeight = 10.0f;
        this.mTrianglePath = new Path();
        this.isTimeVisible = true;
        this.simpleDateFormat = new SimpleDateFormat("HH:mm", new Locale("RU", "ru"));
        this.tickValueBoundOffsetH = 20.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VideoTimeBar);
        int color = obtainStyledAttributes.getColor(R.styleable.VideoTimeBar_tickValueColor, ViewCompat.MEASURED_STATE_MASK);
        this.tickValueColor = color;
        int i = R.styleable.VideoTimeBar_tickValueSize;
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes.getResources(), "getResources(...)");
        float dimension = obtainStyledAttributes.getDimension(i, ExtensionsKt.dpToPx(8, r2));
        this.tickValueSize = dimension;
        this.cursorBackgroundColor = obtainStyledAttributes.getColor(R.styleable.VideoTimeBar_cursorBackgroundColor, SupportMenu.CATEGORY_MASK);
        int i2 = R.styleable.VideoTimeBar_cursorValueSize;
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes.getResources(), "getResources(...)");
        this.cursorValueSize = obtainStyledAttributes.getDimension(i2, ExtensionsKt.dpToPx(8, r7));
        this.colorScaleBackground = obtainStyledAttributes.getColor(R.styleable.VideoTimeBar_colorScaleBackground, -1);
        this.isTimeVisible = obtainStyledAttributes.getBoolean(R.styleable.VideoTimeBar_isTimeVisible, true);
        obtainStyledAttributes.recycle();
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        this.tickValueBoundOffsetH = ExtensionsKt.dpToPx(6, r9);
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(dimension);
        paint.setStrokeWidth(1.0f);
        paint.setDither(true);
        this.mTickPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setDither(true);
        this.mColorCursorPaint = paint2;
        setBackgroundColor(0);
        setTickMarkStrategy(this);
        this.cursorDateFormat = new SimpleDateFormat("HH:mm:ss", new Locale("RU", "ru"));
    }

    public final void setMode(@Mode String mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        setMode(mode, true);
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar
    public void setRange(long r1, long r3) {
        super.setRange(r1, r3);
        String str = this.mMode;
        if (str != MODE_UNIT_10_MIN) {
            setMode(str, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setMode(@ru.tattelecom.intercom.feature.videoplayer.timelineView.VideoTimeBar.Mode java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = r4.mMode
            if (r0 != r5) goto L5
            return
        L5:
            int r0 = r5.hashCode()
            r1 = -1411689559(0xffffffffabdb53a9, float:-1.5584106E-12)
            if (r0 == r1) goto L3e
            r1 = -1244068679(0xffffffffb5d904b9, float:-1.6169134E-6)
            r2 = 600000(0x927c0, double:2.964394E-318)
            if (r0 == r1) goto L2c
            r1 = 1793843503(0x6aebe12f, float:1.4258048E26)
            if (r0 != r1) goto L61
            java.lang.String r0 = "scale unit 10 minute"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L61
            r4.mMode = r5
            r0 = 100000(0x186a0, double:4.94066E-319)
            r4.updateScaleInfo(r2, r0)
            goto L50
        L2c:
            java.lang.String r0 = "scale unit 1 hour"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L61
            r4.mMode = r5
            r0 = 3600000(0x36ee80, double:1.7786363E-317)
            r4.updateScaleInfo(r0, r2)
            r2 = r0
            goto L50
        L3e:
            java.lang.String r0 = "scale unit 1 minute"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L61
            r4.mMode = r5
            r0 = 10000(0x2710, double:4.9407E-320)
            r2 = 60000(0xea60, double:2.9644E-319)
            r4.updateScaleInfo(r2, r0)
        L50:
            if (r6 == 0) goto L60
            long r5 = r4.getMinScreenSpanValue()
            float r5 = (float) r5
            r6 = 1072064102(0x3fe66666, float:1.8)
            float r5 = r5 * r6
            float r6 = (float) r2
            float r5 = r5 / r6
            r4.setScaleRatio(r5)
        L60:
            return
        L61:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "not support mode: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.timelineView.VideoTimeBar.setMode(java.lang.String, boolean):void");
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.TickMarkStrategy
    public String getScaleValue(long scaleValue, boolean keyScale) {
        String format = this.simpleDateFormat.format(Long.valueOf(scaleValue));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.TickMarkStrategy
    public int getColor(long scaleValue, boolean keyScale) {
        return this.tickValueColor;
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar.TickMarkStrategy
    public float getSize(long scaleValue, boolean keyScale, float maxScaleValueSize) {
        return this.tickValueSize;
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar
    protected int calcContentHeight(float baselinePositionProportion) {
        int calcContentHeight = super.calcContentHeight(baselinePositionProportion);
        this.mColorCursorPaint.setTextSize(this.cursorValueSize);
        Paint.FontMetrics fontMetrics = this.mColorCursorPaint.getFontMetrics();
        return RangesKt.coerceAtLeast(calcContentHeight, (int) (((getKeyTickHeight() + (((int) ((Math.ceil(fontMetrics.bottom - fontMetrics.top) + this.mTriangleHeight) + this.tickValueBoundOffsetH)) + 5)) / baselinePositionProportion) + 0.5f));
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar
    protected void onScale(ScalableScaleBar.ScaleMode info, float unitPixel) {
        updateMode(getWidth() / unitPixel);
    }

    private final void updateMode(float screenSpanValue) {
        if (screenSpanValue > 3600000.0f) {
            setMode(MODE_UNIT_1_HOUR, false);
        } else if (screenSpanValue > 600000.0f) {
            setMode(MODE_UNIT_10_MIN, false);
        } else {
            setMode(MODE_UNIT_1_MIN, false);
        }
    }

    @Override // ru.tattelecom.intercom.feature.videoplayer.timelineView.ScalableScaleBar
    protected void drawCursor(Canvas canvas, float cursorPosition, long cursorValue) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.drawCursor(canvas, cursorPosition, cursorValue);
        if (this.isTimeVisible) {
            float baselinePosition = getBaselinePosition() - getKeyTickHeight();
            float f = baselinePosition - this.mTriangleHeight;
            Path path = this.mTrianglePath;
            path.moveTo(cursorPosition, baselinePosition);
            path.lineTo(cursorPosition - 3.5f, f);
            path.lineTo(3.5f + cursorPosition, f);
            path.close();
            this.mTickPaint.setColor(this.cursorBackgroundColor);
            canvas.drawPath(this.mTrianglePath, this.mTickPaint);
            String format = this.cursorDateFormat.format(Long.valueOf(cursorValue));
            Rect rect = new Rect();
            this.mTickPaint.setTextSize(this.cursorValueSize);
            this.mTickPaint.getTextBounds(format, 0, format.length(), rect);
            RectF rectF = new RectF(0.0f, 0.0f, rect.width() + 20, rect.height() + this.tickValueBoundOffsetH);
            rectF.offset(cursorPosition - (rectF.width() * 0.5f), (f + 0.5f) - rectF.height());
            float width = rectF.width() * 0.5f;
            this.mTickPaint.setColor(this.cursorBackgroundColor);
            canvas.drawRoundRect(rectF, width, width, this.mTickPaint);
            this.mTickPaint.setColor(this.tickValueColor);
            canvas.drawText(format, cursorPosition, rectF.centerY() + (rect.height() * 0.5f), this.mTickPaint);
        }
    }
}
