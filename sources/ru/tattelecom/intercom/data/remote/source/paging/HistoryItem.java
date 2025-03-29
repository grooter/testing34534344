package ru.tattelecom.intercom.data.remote.source.paging;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;

/* compiled from: EventHistoryPagingSource.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem;", "", TtmlNode.ATTR_ID, "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", CrashHianalyticsData.TIME, "", "getTime", "()J", "setTime", "(J)V", "type", "", "getType", "()I", "setType", "(I)V", "Companion", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface HistoryItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String ID_BANNER = "key_banner";
    public static final int TYPE_BANNER = 1;
    public static final int TYPE_CALL = 3;
    public static final int TYPE_CODE = 5;
    public static final int TYPE_KEY = 4;
    public static final int TYPE_NULL = 0;

    String getId();

    long getTime();

    int getType();

    void setId(String str);

    void setTime(long j);

    void setType(int i);

    /* compiled from: EventHistoryPagingSource.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lru/tattelecom/intercom/data/remote/source/paging/HistoryItem$Companion;", "", "()V", "ID_BANNER", "", "TYPE_BANNER", "", "TYPE_CALL", "TYPE_CODE", "TYPE_KEY", "TYPE_NULL", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ID_BANNER = "key_banner";
        public static final int TYPE_BANNER = 1;
        public static final int TYPE_CALL = 3;
        public static final int TYPE_CODE = 5;
        public static final int TYPE_KEY = 4;
        public static final int TYPE_NULL = 0;

        private Companion() {
        }
    }
}
