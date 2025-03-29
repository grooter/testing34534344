package ru.tattelecom.intercom.android.resources.timerangepicker;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Calendar;
import kotlin.Metadata;

/* compiled from: OnSliderRangeMovedListener.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, d2 = {"Lru/tattelecom/intercom/android/resources/timerangepicker/OnSliderRangeMovedListener;", "", "onChange", "", TtmlNode.START, "Ljava/util/Calendar;", TtmlNode.END, "android-resources_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface OnSliderRangeMovedListener {
    void onChange(Calendar start, Calendar end);
}
