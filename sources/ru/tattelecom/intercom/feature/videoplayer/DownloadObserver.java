package ru.tattelecom.intercom.feature.videoplayer;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DownloadObserver.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/tattelecom/intercom/feature/videoplayer/DownloadObserver;", "Landroid/database/ContentObserver;", "downloadId", "", "onChangeLambda", "Lkotlin/Function1;", "", "handler", "Landroid/os/Handler;", "(JLkotlin/jvm/functions/Function1;Landroid/os/Handler;)V", "getDownloadId", "()J", "onChange", "selfChange", "", "uri", "Landroid/net/Uri;", "videoplayer_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class DownloadObserver extends ContentObserver {
    private final long downloadId;
    private final Function1<Long, Unit> onChangeLambda;

    public final long getDownloadId() {
        return this.downloadId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadObserver(long j, Function1<? super Long, Unit> onChangeLambda, Handler handler) {
        super(handler);
        Intrinsics.checkNotNullParameter(onChangeLambda, "onChangeLambda");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.downloadId = j;
        this.onChangeLambda = onChangeLambda;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        this.onChangeLambda.invoke(Long.valueOf(this.downloadId));
    }
}
