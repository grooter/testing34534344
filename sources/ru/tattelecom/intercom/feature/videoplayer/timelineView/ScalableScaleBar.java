package ru.tattelecom.intercom.feature.videoplayer.timelineView;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.feature.dynamic.e.e;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.extensions.ExtensionsKt;

/* compiled from: ScalableScaleBar.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b/\b\u0016\u0018\u0000 «\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\b«\u0001¬\u0001\u00ad\u0001®\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010l\u001a\u00020\u00102\u0006\u0010m\u001a\u00020\nH\u0014J\b\u0010n\u001a\u00020oH\u0016J \u0010p\u001a\u00020o2\u0006\u0010q\u001a\u00020r2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J8\u0010s\u001a\u00020o2\u0006\u0010q\u001a\u00020r2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\u00152\u0006\u0010w\u001a\u00020#2\u0006\u0010x\u001a\u00020#H\u0002J\b\u0010y\u001a\u00020\u0015H\u0016J\u0018\u0010z\u001a\u00020\u00102\u0006\u0010{\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u0010H\u0002J\b\u0010}\u001a\u00020\u0015H\u0016J\u0011\u0010~\u001a\u00020#2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\u0011\u0010\u0081\u0001\u001a\u00020o2\u0006\u0010q\u001a\u00020rH\u0014J\u0013\u0010\u0082\u0001\u001a\u00020o2\b\u0010q\u001a\u0004\u0018\u00010rH\u0014J1\u0010\u0083\u0001\u001a\u00020#2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010\u0085\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0086\u0001\u001a\u00020\n2\u0007\u0010\u0087\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0088\u0001\u001a\u00020o2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\u001a\u0010\u0089\u0001\u001a\u00020o2\u0007\u0010\u008a\u0001\u001a\u00020\u00102\u0006\u0010|\u001a\u00020\u0010H\u0014J\u0012\u0010\u008b\u0001\u001a\u00020#2\u0007\u0010\u008c\u0001\u001a\u00020AH\u0016J \u0010\u008b\u0001\u001a\u00020o2\r\u0010\u008d\u0001\u001a\b\u0018\u00010CR\u00020\u00002\u0006\u0010i\u001a\u00020\nH\u0014J\u0012\u0010\u008e\u0001\u001a\u00020#2\u0007\u0010\u008c\u0001\u001a\u00020AH\u0016J\u0012\u0010\u008f\u0001\u001a\u00020o2\u0007\u0010\u008c\u0001\u001a\u00020AH\u0016J1\u0010\u0090\u0001\u001a\u00020#2\n\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0080\u00012\b\u0010\u0085\u0001\u001a\u00030\u0080\u00012\u0007\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u0092\u0001\u001a\u00020\nH\u0016J\u0012\u0010\u0093\u0001\u001a\u00020o2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J\u0012\u0010\u0094\u0001\u001a\u00020#2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016J-\u0010\u0095\u0001\u001a\u00020o2\u0007\u0010\u0096\u0001\u001a\u00020\u00102\u0007\u0010\u0097\u0001\u001a\u00020\u00102\u0007\u0010\u0098\u0001\u001a\u00020\u00102\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0014J\u0013\u0010\u009a\u0001\u001a\u00020#2\b\u0010\u009b\u0001\u001a\u00030\u0080\u0001H\u0017J\u0010\u0010\u009c\u0001\u001a\u00020o2\u0007\u0010\u009d\u0001\u001a\u00020\u0015J\u0015\u0010\u009e\u0001\u001a\u00020o2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150!J\u0012\u0010\u009f\u0001\u001a\u00020o2\t\u0010 \u0001\u001a\u0004\u0018\u00010?J\u001b\u0010¡\u0001\u001a\u00020o2\u0007\u0010¢\u0001\u001a\u00020\u00152\u0007\u0010£\u0001\u001a\u00020\u0015H\u0016J\u0014\u0010¤\u0001\u001a\u00020o2\t\b\u0001\u0010¥\u0001\u001a\u00020\nH\u0004J\u0012\u0010¦\u0001\u001a\u00020o2\t\u0010§\u0001\u001a\u0004\u0018\u00010MJ\u001b\u0010¨\u0001\u001a\u00020o2\u0007\u0010©\u0001\u001a\u00020\u00152\u0007\u0010ª\u0001\u001a\u00020\u0015H\u0004R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u000e\u00100\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010B\u001a\u00060CR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0017\"\u0004\bR\u0010\u0019R\u000e\u0010S\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020\u0015X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0017\"\u0004\bV\u0010\u0019R\u000e\u0010W\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010[\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010_\u001a\u0004\u0018\u00010G8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u000e\u0010b\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010f\u001a\u00020\nX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010\fR\u000e\u0010h\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\f\"\u0004\bk\u0010\u000e¨\u0006¯\u0001"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar;", "Landroid/view/View;", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "baselinePosition", "", "getBaselinePosition", "()F", "setBaselinePosition", "(F)V", "cursorLineColor", "", "cursorPosition", "getCursorPosition", "setCursorPosition", "cursorValue", "", "getCursorValue", "()J", "setCursorValue", "(J)V", "dividerAlpha", "dividerColor", "eventAlpha", "eventBackgroundAlpha", "eventBackgroundColor", "eventColor", "events", "", "eventsVisibility", "", "getEventsVisibility", "()Z", "setEventsVisibility", "(Z)V", "gestureDetectorCompat", "Landroid/view/GestureDetector;", "getGestureDetectorCompat", "()Landroid/view/GestureDetector;", "isBaselineVisible", "keyTickHeight", "getKeyTickHeight", "setKeyTickHeight", "leftSideTickAlpha", "leftSideTickColor", "leftSideTickValueColor", "mBaselinePositionProportion", "mCursorPaint", "Landroid/graphics/Paint;", "mCursorPositionProportion", "mCursorValue", "mEventBackgroundPaint", "mEventBackgroundRect", "Landroid/graphics/RectF;", "mEventPaint", "mGestureDetectorCompat", "mNormalTickAndKeyTickRatio", "mOnCursorListener", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$OnCursorListener;", "mScaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "mScaleInfo", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$ScaleMode;", "mScalePaint", "mScaleRatio", "mScroller", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/FloatScroller;", "mStrokeCap", "Landroid/graphics/Paint$Cap;", "mTextPaint", "mTickHeight", "mTickMarkStrategy", "Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$TickMarkStrategy;", "mTickSpacing", "maxScaleValueSize", "maxScreenSpanValue", "getMaxScreenSpanValue", "setMaxScreenSpanValue", "maxUnitPixel", "minScreenSpanValue", "getMinScreenSpanValue", "setMinScreenSpanValue", "minUnitPixel", "rightSideTickAlpha", "rightSideTickColor", "rightSideTickValueColor", "scaleGestureDetector", "getScaleGestureDetector", "()Landroid/view/ScaleGestureDetector;", "scrollHappened", "scroller", "getScroller", "()Lru/tattelecom/intercom/feature/videoplayer/timelineView/FloatScroller;", "showCursorLine", "showTickValue", "status", "tickFont", "tickStartY", "getTickStartY", "tickValueOffset", "unitPixel", "getUnitPixel", "setUnitPixel", "calcContentHeight", "baselinePositionProportion", "computeScroll", "", "drawCursor", "canvas", "Landroid/graphics/Canvas;", "drawTickValue", "x", "y", "scaleValue", "keyScale", "isOpaque", "getEndTime", "getHeightSize", ContentDisposition.Parameters.Size, "heightMeasureSpec", "getStartTime", "onDown", e.f202a, "Landroid/view/MotionEvent;", "onDraw", "onEndTickDraw", "onFling", "e1", "e2", "velocityX", "velocityY", "onLongPress", "onMeasure", "widthMeasureSpec", "onScale", "detector", "info", "onScaleBegin", "onScaleEnd", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapUp", "onSizeChanged", "w", CmcdData.Factory.STREAMING_FORMAT_HLS, "oldw", "oldh", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "scrollCursorTo", "timeInMs", "setEventList", "setOnCursorListener", CmcdData.Factory.STREAM_TYPE_LIVE, "setRange", TtmlNode.START, TtmlNode.END, "setScaleRatio", "scaleRatio", "setTickMarkStrategy", "tickMarkStrategy", "updateScaleInfo", "keyScaleRange", "unitValue", "Companion", "OnCursorListener", "ScaleMode", "TickMarkStrategy", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public class ScalableScaleBar extends View implements ScaleGestureDetector.OnScaleGestureListener, GestureDetector.OnGestureListener {
    public static final int STATUS_DOWN = 1;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_SCROLL = 2;
    public static final int STATUS_SCROLL_FLING = 3;
    public static final int STATUS_ZOOM = 4;
    private static final String TAG = "ScalableScaleBar";
    private float baselinePosition;
    private final int cursorLineColor;
    private float cursorPosition;
    private final int dividerAlpha;
    private final int dividerColor;
    private final int eventAlpha;
    private final int eventBackgroundAlpha;
    private final int eventBackgroundColor;
    private final int eventColor;
    private List<Long> events;
    private boolean eventsVisibility;
    private boolean isBaselineVisible;
    private float keyTickHeight;
    private final int leftSideTickAlpha;
    private final int leftSideTickColor;
    private final int leftSideTickValueColor;
    private float mBaselinePositionProportion;
    private final Paint mCursorPaint;
    private float mCursorPositionProportion;
    private long mCursorValue;
    private Paint mEventBackgroundPaint;
    private RectF mEventBackgroundRect;
    private Paint mEventPaint;
    private GestureDetector mGestureDetectorCompat;
    private float mNormalTickAndKeyTickRatio;
    private OnCursorListener mOnCursorListener;
    private ScaleGestureDetector mScaleGestureDetector;
    private final ScaleMode mScaleInfo;
    private final Paint mScalePaint;
    private float mScaleRatio;
    private FloatScroller mScroller;
    private final Paint.Cap mStrokeCap;
    private final Paint mTextPaint;
    private float mTickHeight;
    private TickMarkStrategy mTickMarkStrategy;
    private float mTickSpacing;
    private final float maxScaleValueSize;
    private long maxScreenSpanValue;
    private float maxUnitPixel;
    private long minScreenSpanValue;
    private float minUnitPixel;
    private final int rightSideTickAlpha;
    private final int rightSideTickColor;
    private final int rightSideTickValueColor;
    private boolean scrollHappened;
    private final boolean showCursorLine;
    private final boolean showTickValue;
    private int status;
    private final int tickFont;
    private final float tickStartY;
    private float tickValueOffset;
    private float unitPixel;

    /* compiled from: ScalableScaleBar.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$OnCursorListener;", "", "onEnd", "", "cursorValue", "", "onMoving", "onStart", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnCursorListener {
        void onEnd(long cursorValue);

        void onMoving(long cursorValue);

        void onStart(long cursorValue);
    }

    /* compiled from: ScalableScaleBar.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H'J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH'¨\u0006\u000e"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$TickMarkStrategy;", "", "disPlay", "", "scaleValue", "", "keyScale", "getColor", "", "getScaleValue", "", "getSize", "", "maxScaleValueSize", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface TickMarkStrategy {
        boolean disPlay(long scaleValue, boolean keyScale);

        int getColor(long scaleValue, boolean keyScale);

        String getScaleValue(long scaleValue, boolean keyScale);

        float getSize(long scaleValue, boolean keyScale, float maxScaleValueSize);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScalableScaleBar(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    protected void onEndTickDraw(Canvas canvas) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    protected void onScale(ScaleMode info, float unitPixel) {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        return false;
    }

    public /* synthetic */ ScalableScaleBar(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScalableScaleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint.Cap cap;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScaleRatio = 0.5f;
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        this.tickStartY = ExtensionsKt.dpToPx(29, r3);
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        this.keyTickHeight = ExtensionsKt.dpToPx(13, r3);
        this.mNormalTickAndKeyTickRatio = 0.5f;
        this.eventsVisibility = true;
        this.mCursorPositionProportion = 0.5f;
        this.mBaselinePositionProportion = 1.0f;
        this.isBaselineVisible = true;
        this.tickValueOffset = 15.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ScalableScaleBar);
        int i = R.styleable.ScalableScaleBar_keyTickHeight;
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes.getResources(), "getResources(...)");
        this.keyTickHeight = obtainStyledAttributes.getDimension(i, ExtensionsKt.dpToPx(8, r9));
        this.rightSideTickValueColor = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_rightSideTickValueColor, ViewCompat.MEASURED_STATE_MASK);
        this.leftSideTickValueColor = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_leftSideTickValueColor, ViewCompat.MEASURED_STATE_MASK);
        this.mNormalTickAndKeyTickRatio = obtainStyledAttributes.getFloat(R.styleable.ScalableScaleBar_normalTickRatio, 0.5f);
        this.dividerColor = obtainStyledAttributes.getColor(R.styleable.ScalableScaleBar_dividerColor, ViewCompat.MEASURED_STATE_MASK);
        this.dividerAlpha = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_dividerAlpha, 255);
        this.leftSideTickColor = obtainStyledAttributes.getColor(R.styleable.ScalableScaleBar_leftSideTickColor, ViewCompat.MEASURED_STATE_MASK);
        this.leftSideTickAlpha = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_leftSideTickAlpha, 255);
        this.rightSideTickColor = obtainStyledAttributes.getColor(R.styleable.ScalableScaleBar_rightSideTickColor, ViewCompat.MEASURED_STATE_MASK);
        this.rightSideTickAlpha = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_rightSideTickAlpha, 255);
        int i2 = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_strokeCap, 1);
        if (i2 == 0) {
            cap = Paint.Cap.BUTT;
        } else if (i2 == 1) {
            cap = Paint.Cap.ROUND;
        } else if (i2 == 2) {
            cap = Paint.Cap.SQUARE;
        } else {
            cap = Paint.Cap.ROUND;
        }
        this.mStrokeCap = cap;
        int color = obtainStyledAttributes.getColor(R.styleable.ScalableScaleBar_eventColor, ViewCompat.MEASURED_STATE_MASK);
        this.eventColor = color;
        int i3 = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_eventAlpha, 255);
        this.eventAlpha = i3;
        int color2 = obtainStyledAttributes.getColor(R.styleable.ScalableScaleBar_eventBackgroundColor, ViewCompat.MEASURED_STATE_MASK);
        this.eventBackgroundColor = color2;
        int i4 = obtainStyledAttributes.getInt(R.styleable.ScalableScaleBar_eventBackgroundAlpha, 255);
        this.eventBackgroundAlpha = i4;
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.ScalableScaleBar_tickFont, -1);
        this.tickFont = resourceId;
        this.cursorLineColor = obtainStyledAttributes.getColor(R.styleable.ScalableScaleBar_cursorLineColor, -256);
        this.showCursorLine = obtainStyledAttributes.getBoolean(R.styleable.ScalableScaleBar_showCursorLine, true);
        this.showTickValue = obtainStyledAttributes.getBoolean(R.styleable.ScalableScaleBar_showTickValue, true);
        int i5 = R.styleable.ScalableScaleBar_maxScaleValueSize;
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes.getResources(), "getResources(...)");
        this.maxScaleValueSize = obtainStyledAttributes.getDimension(i5, ExtensionsKt.dpToPx(15, r15));
        float f = obtainStyledAttributes.getFloat(R.styleable.ScalableScaleBar_cursorPosition, 0.5f);
        if (f != 0.0f) {
            this.mCursorPositionProportion = f;
        }
        float f2 = obtainStyledAttributes.getFloat(R.styleable.ScalableScaleBar_baselinePosition, 1.0f);
        if (f2 != 0.0f) {
            this.mBaselinePositionProportion = f2;
        }
        this.isBaselineVisible = obtainStyledAttributes.getBoolean(R.styleable.ScalableScaleBar_isBaselineVisible, true);
        obtainStyledAttributes.recycle();
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        this.tickValueOffset = ExtensionsKt.dpToPx(7, r2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        paint.setStrokeWidth(ExtensionsKt.dpToPx(2, r5));
        paint.setDither(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mScalePaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        paint2.setStrokeWidth(ExtensionsKt.dpToPx(2, r5));
        paint2.setDither(true);
        paint2.setStyle(Paint.Style.FILL);
        this.mCursorPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        paint3.setStrokeWidth(ExtensionsKt.dpToPx(2, r5));
        paint3.setDither(true);
        paint3.setStyle(Paint.Style.FILL_AND_STROKE);
        paint3.setColor(color);
        paint3.setAlpha(i3);
        paint3.setStrokeCap(cap);
        this.mEventPaint = paint3;
        Paint paint4 = new Paint();
        paint4.setAntiAlias(true);
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        paint4.setStrokeWidth(ExtensionsKt.dpToPx(2, r5));
        paint4.setDither(true);
        paint4.setStyle(Paint.Style.FILL_AND_STROKE);
        paint4.setColor(color2);
        paint4.setAlpha(i4);
        this.mEventBackgroundPaint = paint4;
        this.mEventBackgroundRect = new RectF();
        Paint paint5 = new Paint();
        paint5.setAntiAlias(true);
        Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
        paint5.setStrokeWidth(ExtensionsKt.dpToPx(2, r5));
        paint5.setDither(true);
        paint5.setStyle(Paint.Style.FILL);
        if (resourceId != -1) {
            paint5.setTypeface(ResourcesCompat.getFont(context, resourceId));
        }
        this.mTextPaint = paint5;
        this.minScreenSpanValue = 10000L;
        this.maxScreenSpanValue = 86400000L;
        ScaleMode scaleMode = new ScaleMode();
        scaleMode.setUnitValue(60000L);
        scaleMode.setKeyScaleRange(10000L);
        this.mScaleInfo = scaleMode;
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        scaleMode.setStartValue(calendar.getTimeInMillis());
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        scaleMode.setEndValue(calendar.getTimeInMillis());
        this.mCursorValue = scaleMode.getStartValue();
    }

    protected final float getTickStartY() {
        return this.tickStartY;
    }

    protected final float getKeyTickHeight() {
        return this.keyTickHeight;
    }

    protected final void setKeyTickHeight(float f) {
        this.keyTickHeight = f;
    }

    protected final float getUnitPixel() {
        return this.unitPixel;
    }

    protected final void setUnitPixel(float f) {
        this.unitPixel = f;
    }

    protected final long getMinScreenSpanValue() {
        return this.minScreenSpanValue;
    }

    protected final void setMinScreenSpanValue(long j) {
        this.minScreenSpanValue = j;
    }

    protected final long getMaxScreenSpanValue() {
        return this.maxScreenSpanValue;
    }

    protected final void setMaxScreenSpanValue(long j) {
        this.maxScreenSpanValue = j;
    }

    protected final float getCursorPosition() {
        return this.cursorPosition;
    }

    protected final void setCursorPosition(float f) {
        this.cursorPosition = f;
    }

    public final void setEventList(List<Long> events) {
        Intrinsics.checkNotNullParameter(events, "events");
        this.events = events;
        invalidate();
    }

    public final boolean getEventsVisibility() {
        return this.eventsVisibility;
    }

    public final void setEventsVisibility(boolean z) {
        this.eventsVisibility = z;
    }

    protected final float getBaselinePosition() {
        return this.baselinePosition;
    }

    protected final void setBaselinePosition(float f) {
        this.baselinePosition = f;
    }

    protected final void setScaleRatio(float scaleRatio) {
        this.mScaleRatio = scaleRatio;
    }

    /* renamed from: getCursorValue, reason: from getter */
    public final long getMCursorValue() {
        return this.mCursorValue;
    }

    public final void setCursorValue(long j) {
        if (this.status != 0) {
            Log.e(TAG, "scaleBar onTouched " + this.mCursorValue);
            return;
        }
        if (j < this.mScaleInfo.getStartValue() || j > this.mScaleInfo.getEndValue()) {
            Log.e(TAG, "Illegal parameter.   startValue: " + this.mScaleInfo.getStartValue() + "   endValue: " + this.mScaleInfo.getEndValue() + "   cursorValue: " + j + "   mCursorValue " + this.mCursorValue);
            return;
        }
        this.mCursorValue = j;
        invalidate();
    }

    public final void scrollCursorTo(long timeInMs) {
        OnCursorListener onCursorListener = this.mOnCursorListener;
        if (onCursorListener != null) {
            onCursorListener.onStart(getMCursorValue());
        }
        setCursorValue(timeInMs);
        OnCursorListener onCursorListener2 = this.mOnCursorListener;
        if (onCursorListener2 != null) {
            onCursorListener2.onEnd(getMCursorValue());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        this.mTickHeight = this.keyTickHeight * this.mNormalTickAndKeyTickRatio;
        float f = w;
        this.cursorPosition = this.mCursorPositionProportion * f;
        this.baselinePosition = h * this.mBaselinePositionProportion;
        float f2 = (0.1f * f) / this.minScreenSpanValue;
        this.maxUnitPixel = f2;
        this.minUnitPixel = (f * 3.0f) / this.maxScreenSpanValue;
        this.unitPixel = f2 * this.mScaleRatio;
        this.mTickSpacing = this.mScaleInfo.getUnitValue() * this.unitPixel;
    }

    public void setRange(long start, long end) {
        if (start >= end) {
            Log.e(TAG, "start cannot be greater than end.  start: " + start + "  end: " + end + " " + this.mCursorValue);
            return;
        }
        ScaleMode scaleMode = this.mScaleInfo;
        scaleMode.setStartValue(start);
        scaleMode.setEndValue(end);
        this.mCursorValue = start;
        invalidate();
    }

    public long getStartTime() {
        return this.mScaleInfo.getStartValue();
    }

    public long getEndTime() {
        return this.mScaleInfo.getEndValue();
    }

    protected final void updateScaleInfo(long keyScaleRange, long unitValue) {
        ScaleMode scaleMode = this.mScaleInfo;
        scaleMode.setKeyScaleRange(keyScaleRange);
        scaleMode.setUnitValue(unitValue);
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(View.getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), getHeightSize(getSuggestedMinimumHeight(), heightMeasureSpec));
    }

    private final int getHeightSize(int size, int heightMeasureSpec) {
        int calcContentHeight = calcContentHeight(this.mBaselinePositionProportion);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode != 1073741824) {
                    return size;
                }
                if (size2 > calcContentHeight) {
                    return size2;
                }
            } else if (size > calcContentHeight) {
                return size;
            }
        }
        return calcContentHeight;
    }

    protected int calcContentHeight(float baselinePositionProportion) {
        int i;
        if (!this.showTickValue || this.mTickMarkStrategy == null) {
            i = 0;
        } else {
            this.mScalePaint.setTextSize(this.maxScaleValueSize);
            Paint.FontMetrics fontMetrics = this.mScalePaint.getFontMetrics();
            i = (int) (Math.ceil(fontMetrics.bottom - fontMetrics.top) + this.tickValueOffset);
        }
        return (int) (((this.keyTickHeight + i) / baselinePositionProportion) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.isBaselineVisible) {
            float f = this.baselinePosition;
            Paint paint = this.mScalePaint;
            paint.setColor(this.dividerColor);
            paint.setAlpha(this.dividerAlpha);
            canvas.drawLine(getScrollX(), f, getScrollX() + getWidth(), f, this.mScalePaint);
        }
        long startValue = (this.mCursorValue - this.mScaleInfo.getStartValue()) % this.mScaleInfo.getUnitValue();
        long j = this.mCursorValue - startValue;
        float f2 = this.cursorPosition;
        float f3 = f2 - (startValue * this.unitPixel);
        int i3 = (int) ((f2 / this.mTickSpacing) + 0.5f);
        long j2 = j;
        float f4 = f3;
        int i4 = 0;
        while (i4 < i3) {
            Paint paint2 = this.mScalePaint;
            paint2.setColor(this.leftSideTickColor);
            paint2.setAlpha(this.leftSideTickAlpha);
            paint2.setStrokeCap(this.mStrokeCap);
            long unitValue = j - (this.mScaleInfo.getUnitValue() * i4);
            if (unitValue < this.mScaleInfo.getStartValue()) {
                break;
            }
            f4 = f3 - (this.mTickSpacing * i4);
            if ((unitValue - this.mScaleInfo.getStartValue()) % this.mScaleInfo.getKeyScaleRange() == 0) {
                float f5 = this.tickStartY;
                canvas.drawLine(f4, f5, f4, f5 - this.keyTickHeight, this.mScalePaint);
                i2 = i4;
                drawTickValue(canvas, f4, this.baselinePosition, unitValue, true, true);
            } else {
                i2 = i4;
                float f6 = this.tickStartY;
                canvas.drawLine(f4, f6, f4, f6 - this.mTickHeight, this.mScalePaint);
                drawTickValue(canvas, f4, this.baselinePosition, unitValue, false, true);
            }
            i4 = i2 + 1;
            j2 = unitValue;
        }
        long unitValue2 = j + this.mScaleInfo.getUnitValue();
        float f7 = f3 + this.mTickSpacing;
        int width = (int) (((getWidth() - this.cursorPosition) / this.mTickSpacing) + 0.5f);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        long j3 = unitValue2;
        float f8 = f7;
        int i5 = 0;
        while (true) {
            if (i5 >= width) {
                break;
            }
            long unitValue3 = unitValue2 + (this.mScaleInfo.getUnitValue() * i5);
            float f9 = i5;
            float f10 = f7 + (this.mTickSpacing * f9);
            if (unitValue3 > this.mScaleInfo.getEndValue()) {
                j3 = unitValue3;
                f8 = f10;
                break;
            }
            Paint paint3 = this.mScalePaint;
            paint3.setColor(this.rightSideTickColor);
            if (unitValue3 <= timeInMillis) {
                i = this.leftSideTickAlpha;
            } else {
                i = this.rightSideTickAlpha;
            }
            paint3.setAlpha(i);
            paint3.setStrokeCap(this.mStrokeCap);
            float f11 = f7 + (this.mTickSpacing * f9);
            if ((unitValue3 - this.mScaleInfo.getStartValue()) % this.mScaleInfo.getKeyScaleRange() == 0) {
                float f12 = this.tickStartY;
                canvas.drawLine(f11, f12, f11, f12 - this.keyTickHeight, this.mScalePaint);
                drawTickValue(canvas, f11, this.baselinePosition, unitValue3, true, unitValue3 <= timeInMillis);
            } else {
                float f13 = this.tickStartY;
                canvas.drawLine(f11, f13, f11, f13 - this.mTickHeight, this.mScalePaint);
                drawTickValue(canvas, f11, this.baselinePosition, unitValue3, false, unitValue3 <= timeInMillis);
            }
            i5++;
            j3 = unitValue3;
            f8 = f10;
        }
        onEndTickDraw(canvas);
        if (this.eventsVisibility) {
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            float dpToPx = ExtensionsKt.dpToPx(1, resources);
            float f14 = this.tickStartY - this.keyTickHeight;
            Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
            float dpToPx2 = f14 - ExtensionsKt.dpToPx(4, r5);
            long mCursorValue = timeInMillis - getMCursorValue();
            if (j3 != this.mScaleInfo.getEndValue() + 1 || j3 >= timeInMillis) {
                f8 = (this.cursorPosition + (mCursorValue * this.unitPixel)) - this.mEventBackgroundPaint.getStrokeWidth();
            }
            RectF rectF = this.mEventBackgroundRect;
            rectF.left = j2 <= this.mScaleInfo.getStartValue() ? f4 : 0.0f;
            rectF.top = 0.0f;
            rectF.right = f8;
            rectF.bottom = dpToPx2;
            canvas.drawRect(rectF, this.mEventBackgroundPaint);
            List<Long> list = this.events;
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    long longValue = ((Number) obj).longValue();
                    long startValue2 = this.mScaleInfo.getStartValue();
                    if (longValue <= this.mScaleInfo.getEndValue() && startValue2 <= longValue) {
                        arrayList.add(obj);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    float longValue2 = this.cursorPosition + ((((Number) it.next()).longValue() - getMCursorValue()) * this.unitPixel);
                    canvas.drawLine(longValue2, dpToPx2, longValue2, dpToPx, this.mEventPaint);
                }
            }
        }
        drawCursor(canvas, this.cursorPosition, this.mCursorValue);
    }

    protected void drawCursor(Canvas canvas, float cursorPosition, long cursorValue) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.showCursorLine) {
            Paint paint = this.mCursorPaint;
            paint.setColor(this.cursorLineColor);
            paint.setStrokeCap(this.mStrokeCap);
            float strokeWidth = cursorPosition - this.mCursorPaint.getStrokeWidth();
            canvas.drawLine(strokeWidth, 0.0f, strokeWidth, getHeight(), this.mCursorPaint);
            Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
            PointF pointF = new PointF(strokeWidth - ExtensionsKt.dpToPx(6, r10), getHeight());
            Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
            PointF pointF2 = new PointF(ExtensionsKt.dpToPx(6, r2) + strokeWidth, getHeight());
            float height = getHeight();
            Intrinsics.checkNotNullExpressionValue(getResources(), "getResources(...)");
            PointF pointF3 = new PointF(strokeWidth, height - ExtensionsKt.dpToPx(10, r3));
            Path path = new Path();
            path.setFillType(Path.FillType.EVEN_ODD);
            path.moveTo(pointF.x, pointF.y);
            path.lineTo(pointF3.x, pointF3.y);
            path.lineTo(pointF2.x, pointF2.y);
            path.lineTo(pointF.x, pointF.y);
            path.close();
            canvas.drawPath(path, this.mCursorPaint);
        }
    }

    private final void drawTickValue(Canvas canvas, float x, float y, long scaleValue, boolean keyScale, boolean isOpaque) {
        TickMarkStrategy tickMarkStrategy;
        if (!this.showTickValue || (tickMarkStrategy = this.mTickMarkStrategy) == null) {
            return;
        }
        Intrinsics.checkNotNull(tickMarkStrategy);
        if (tickMarkStrategy.disPlay(scaleValue, keyScale)) {
            TickMarkStrategy tickMarkStrategy2 = this.mTickMarkStrategy;
            Intrinsics.checkNotNull(tickMarkStrategy2);
            float coerceAtMost = RangesKt.coerceAtMost(this.maxScaleValueSize, tickMarkStrategy2.getSize(scaleValue, keyScale, this.maxScaleValueSize));
            Paint paint = this.mTextPaint;
            TickMarkStrategy tickMarkStrategy3 = this.mTickMarkStrategy;
            Intrinsics.checkNotNull(tickMarkStrategy3);
            paint.setColor(tickMarkStrategy3.getColor(scaleValue, keyScale));
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTextSize(coerceAtMost);
            paint.setColor(isOpaque ? this.leftSideTickValueColor : this.rightSideTickValueColor);
            paint.setAlpha(isOpaque ? this.leftSideTickAlpha : this.rightSideTickAlpha);
            TickMarkStrategy tickMarkStrategy4 = this.mTickMarkStrategy;
            Intrinsics.checkNotNull(tickMarkStrategy4);
            canvas.drawText(tickMarkStrategy4.getScaleValue(scaleValue, keyScale), x, y - this.tickValueOffset, this.mTextPaint);
        }
    }

    private final ScaleGestureDetector getScaleGestureDetector() {
        if (this.mScaleGestureDetector == null) {
            this.mScaleGestureDetector = new ScaleGestureDetector(getContext(), this);
        }
        return this.mScaleGestureDetector;
    }

    private final GestureDetector getGestureDetectorCompat() {
        if (this.mGestureDetectorCompat == null) {
            this.mGestureDetectorCompat = new GestureDetector(getContext(), this);
        }
        return this.mGestureDetectorCompat;
    }

    private final FloatScroller getScroller() {
        if (this.mScroller == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            this.mScroller = new FloatScroller(context, null, false, 6, null);
        }
        return this.mScroller;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        OnCursorListener onCursorListener;
        Intrinsics.checkNotNullParameter(event, "event");
        ScaleGestureDetector scaleGestureDetector = getScaleGestureDetector();
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(event);
        }
        GestureDetector gestureDetectorCompat = getGestureDetectorCompat();
        if (gestureDetectorCompat != null) {
            gestureDetectorCompat.onTouchEvent(event);
        }
        if (event.getActionMasked() == 1 || event.getActionMasked() == 3) {
            if (this.scrollHappened && this.status != 3 && (onCursorListener = this.mOnCursorListener) != null) {
                Intrinsics.checkNotNull(onCursorListener);
                onCursorListener.onEnd(this.mCursorValue);
            }
            this.scrollHappened = false;
            int i = this.status;
            if (i == 1 || i == 2 || i == 4) {
                this.status = 0;
            }
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        Intrinsics.checkNotNullParameter(detector, "detector");
        float scaleFactor = detector.getScaleFactor();
        this.status = 4;
        float f = this.unitPixel * scaleFactor;
        this.unitPixel = f;
        float f2 = this.maxUnitPixel;
        if (f > f2) {
            this.unitPixel = f2;
        } else {
            float f3 = this.minUnitPixel;
            if (f < f3) {
                this.unitPixel = f3;
            }
            onScale(this.mScaleInfo, this.unitPixel);
            this.mScaleRatio *= scaleFactor;
            this.mTickSpacing = this.mScaleInfo.getUnitValue() * this.unitPixel;
            invalidate();
            float f4 = this.unitPixel;
            return f4 >= this.maxUnitPixel || f4 > this.minUnitPixel;
        }
        scaleFactor = 0.5f;
        onScale(this.mScaleInfo, this.unitPixel);
        this.mScaleRatio *= scaleFactor;
        this.mTickSpacing = this.mScaleInfo.getUnitValue() * this.unitPixel;
        invalidate();
        float f42 = this.unitPixel;
        if (f42 >= this.maxUnitPixel) {
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.status == 3) {
            FloatScroller scroller = getScroller();
            if (scroller != null) {
                scroller.forceFinished(true);
            }
        } else {
            this.scrollHappened = false;
        }
        this.status = 1;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Intrinsics.checkNotNullParameter(e2, "e2");
        int pointerCount = e2.getPointerCount();
        boolean z = false;
        if (pointerCount > 1) {
            return false;
        }
        ScaleGestureDetector scaleGestureDetector = getScaleGestureDetector();
        if (scaleGestureDetector != null && scaleGestureDetector.isInProgress()) {
            return false;
        }
        if (!this.scrollHappened) {
            this.scrollHappened = true;
            OnCursorListener onCursorListener = this.mOnCursorListener;
            if (onCursorListener != null) {
                Intrinsics.checkNotNull(onCursorListener);
                onCursorListener.onStart(this.mCursorValue);
            }
            return true;
        }
        this.status = 2;
        this.mCursorValue += (long) (distanceX / this.unitPixel);
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.mCursorValue < this.mScaleInfo.getStartValue()) {
            this.mCursorValue = this.mScaleInfo.getStartValue();
        } else {
            long j = this.mCursorValue;
            if (j > timeInMillis) {
                this.mCursorValue = timeInMillis;
            } else if (j > this.mScaleInfo.getEndValue()) {
                this.mCursorValue = this.mScaleInfo.getEndValue();
            } else {
                z = true;
            }
        }
        OnCursorListener onCursorListener2 = this.mOnCursorListener;
        if (onCursorListener2 != null) {
            Intrinsics.checkNotNull(onCursorListener2);
            onCursorListener2.onMoving(this.mCursorValue);
        }
        invalidate();
        return z;
    }

    @Override // android.view.View
    public void computeScroll() {
        FloatScroller scroller = getScroller();
        if (scroller != null && scroller.computeScrollOffset()) {
            FloatScroller scroller2 = getScroller();
            Float valueOf = scroller2 != null ? Float.valueOf(scroller2.getCurrX()) : null;
            if (valueOf != null) {
                this.mCursorValue = this.mScaleInfo.getStartValue() + ((long) (valueOf.floatValue() / this.unitPixel));
            }
            if (this.mCursorValue < this.mScaleInfo.getStartValue()) {
                this.mCursorValue = this.mScaleInfo.getStartValue();
            } else if (this.mCursorValue > this.mScaleInfo.getEndValue()) {
                this.mCursorValue = this.mScaleInfo.getEndValue();
            }
            invalidate();
            return;
        }
        if (this.status == 3) {
            this.status = 0;
            OnCursorListener onCursorListener = this.mOnCursorListener;
            if (onCursorListener != null) {
                Intrinsics.checkNotNull(onCursorListener);
                onCursorListener.onEnd(this.mCursorValue);
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        float startValue;
        float f;
        Intrinsics.checkNotNullParameter(e2, "e2");
        this.status = 3;
        float startValue2 = (this.mCursorValue - this.mScaleInfo.getStartValue()) * this.unitPixel;
        long timeInMillis = Calendar.getInstance().getTimeInMillis();
        if (this.mScaleInfo.getEndValue() < timeInMillis) {
            startValue = this.mScaleInfo.getEndValue() - this.mScaleInfo.getStartValue();
            f = this.unitPixel;
        } else {
            startValue = timeInMillis - this.mScaleInfo.getStartValue();
            f = this.unitPixel;
        }
        float f2 = startValue * f;
        FloatScroller scroller = getScroller();
        if (scroller != null) {
            scroller.fling(startValue2, 0.0f, -velocityX, 0.0f, 0.0f, f2, 0.0f, 0.0f);
        }
        invalidate();
        return true;
    }

    public final void setOnCursorListener(OnCursorListener l) {
        this.mOnCursorListener = l;
    }

    public final void setTickMarkStrategy(TickMarkStrategy tickMarkStrategy) {
        this.mTickMarkStrategy = tickMarkStrategy;
    }

    /* compiled from: ScalableScaleBar.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\b\u0084\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar$ScaleMode;", "", "(Lru/tattelecom/intercom/feature/videoplayer/timelineView/ScalableScaleBar;)V", "endValue", "", "getEndValue", "()J", "setEndValue", "(J)V", "keyScaleRange", "getKeyScaleRange", "setKeyScaleRange", "startValue", "getStartValue", "setStartValue", "unitValue", "getUnitValue", "setUnitValue", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    protected final class ScaleMode {
        private long endValue;
        private long keyScaleRange;
        private long startValue;
        private long unitValue;

        public ScaleMode() {
        }

        public final long getUnitValue() {
            return this.unitValue;
        }

        public final void setUnitValue(long j) {
            this.unitValue = j;
        }

        public final long getStartValue() {
            return this.startValue;
        }

        public final void setStartValue(long j) {
            this.startValue = j;
        }

        public final long getEndValue() {
            return this.endValue;
        }

        public final void setEndValue(long j) {
            this.endValue = j;
        }

        public final long getKeyScaleRange() {
            return this.keyScaleRange;
        }

        public final void setKeyScaleRange(long j) {
            this.keyScaleRange = j;
        }
    }
}
