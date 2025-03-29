package ru.tattelecom.intercom.data.local.dao;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.DownloadEntity;
import ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel;

/* compiled from: DownloadDAO.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00160\u0015H'¨\u0006\u0017"}, d2 = {"Lru/tattelecom/intercom/data/local/dao/DownloadDAO;", "", "add", "", "download", "Lru/tattelecom/intercom/data/local/entity/DownloadEntity;", "(Lru/tattelecom/intercom/data/local/entity/DownloadEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addList", VideoPlayerViewModel.DOWNLOAD_LIST, "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "description", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByDescription", "getById", TtmlNode.ATTR_ID, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface DownloadDAO {
    Object add(DownloadEntity downloadEntity, Continuation<? super Unit> continuation);

    Object addList(List<DownloadEntity> list, Continuation<? super Unit> continuation);

    Object delete(String str, Continuation<? super Unit> continuation);

    Object getByDescription(String str, Continuation<? super DownloadEntity> continuation);

    Object getById(long j, Continuation<? super DownloadEntity> continuation);

    Flow<List<DownloadEntity>> observeAll();
}
