package ru.tattelecom.intercom.domain.contracts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.domain.model.DownloadDto;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: PlayerUserInteractor.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0096@¢\u0006\u0002\u0010\tJ\b\u0010\u0014\u001a\u00020\fH&J$\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u0010H\u0016J*\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096@¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\fH&¨\u0006\u001e"}, d2 = {"Lru/tattelecom/intercom/domain/contracts/PlayerUserInteractor;", "", "addDownload", "", VideoPlayerViewModel.DOWNLOAD_LIST, "", "Lru/tattelecom/intercom/domain/model/DownloadDto;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download", "(Lru/tattelecom/intercom/domain/model/DownloadDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addStreamToFavorites", "isIntercom", "", TtmlNode.ATTR_ID, "", "stream", "", "(ZILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDownload", "model", "getDoubleTapHintShownState", "getDownload", "downloadId", "", "urlDescription", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserToken", "removeStreamFromFavorites", "setDoubleTapHintShownState", "isShown", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface PlayerUserInteractor {
    Object addDownload(List<DownloadDto> list, Continuation<? super Unit> continuation);

    Object addDownload(DownloadDto downloadDto, Continuation<? super Unit> continuation);

    Object addStreamToFavorites(boolean z, int i, String str, Continuation<? super Unit> continuation);

    Object deleteDownload(DownloadDto downloadDto, Continuation<? super Unit> continuation);

    boolean getDoubleTapHintShownState();

    Object getDownload(long j, String str, Continuation<? super DownloadDto> continuation);

    String getUserToken();

    Object removeStreamFromFavorites(boolean z, int i, String str, Continuation<? super Unit> continuation);

    void setDoubleTapHintShownState(boolean isShown);

    /* compiled from: PlayerUserInteractor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Object getDownload(PlayerUserInteractor playerUserInteractor, long j, String str, Continuation<? super DownloadDto> continuation) {
            return null;
        }

        public static Object addDownload(PlayerUserInteractor playerUserInteractor, List<DownloadDto> list, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static Object addDownload(PlayerUserInteractor playerUserInteractor, DownloadDto downloadDto, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Object getDownload$default(PlayerUserInteractor playerUserInteractor, long j, String str, Continuation continuation, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownload");
            }
            if ((i & 2) != 0) {
                str = null;
            }
            return playerUserInteractor.getDownload(j, str, continuation);
        }

        public static Object deleteDownload(PlayerUserInteractor playerUserInteractor, DownloadDto downloadDto, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static Object addStreamToFavorites(PlayerUserInteractor playerUserInteractor, boolean z, int i, String str, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Object addStreamToFavorites$default(PlayerUserInteractor playerUserInteractor, boolean z, int i, String str, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addStreamToFavorites");
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            return playerUserInteractor.addStreamToFavorites(z, i, str, continuation);
        }

        public static Object removeStreamFromFavorites(PlayerUserInteractor playerUserInteractor, boolean z, int i, String str, Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Object removeStreamFromFavorites$default(PlayerUserInteractor playerUserInteractor, boolean z, int i, String str, Continuation continuation, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeStreamFromFavorites");
            }
            if ((i2 & 4) != 0) {
                str = null;
            }
            return playerUserInteractor.removeStreamFromFavorites(z, i, str, continuation);
        }

        public static String getUserToken(PlayerUserInteractor playerUserInteractor) {
            return "";
        }
    }
}
