package ru.tattelecom.intercom.feature.videoplayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.data.local.entity.EntitiesKt;
import ru.tattelecom.intercom.feature.videoplayer.model.DownloadItem;
import ru.tattelecom.intercom.feature.videoplayer.model.EventItem;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\u008a@"}, d2 = {"<anonymous>", "", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem;", "events", EntitiesKt.DOWNLOADS_TABLE, "Lru/tattelecom/intercom/feature/videoplayer/model/DownloadItem;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$2$1", f = "VideoPlayerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$2$1 extends SuspendLambda implements Function3<List<? extends EventItem>, List<? extends DownloadItem>, Continuation<? super List<? extends EventItem>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    VideoPlayerViewModel$2$1(Continuation<? super VideoPlayerViewModel$2$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends EventItem> list, List<? extends DownloadItem> list2, Continuation<? super List<? extends EventItem>> continuation) {
        return invoke2((List<EventItem>) list, (List<DownloadItem>) list2, (Continuation<? super List<EventItem>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(List<EventItem> list, List<DownloadItem> list2, Continuation<? super List<EventItem>> continuation) {
        VideoPlayerViewModel$2$1 videoPlayerViewModel$2$1 = new VideoPlayerViewModel$2$1(continuation);
        videoPlayerViewModel$2$1.L$0 = list;
        videoPlayerViewModel$2$1.L$1 = list2;
        return videoPlayerViewModel$2$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        EventItem.State.Error error;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        List list2 = (List) this.L$1;
        ArrayList arrayList = new ArrayList();
        List list3 = list2;
        Iterator it = list3.iterator();
        while (true) {
            Object obj3 = null;
            if (!it.hasNext()) {
                break;
            }
            DownloadItem downloadItem = (DownloadItem) it.next();
            Iterator it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (Intrinsics.areEqual(((EventItem) next).getId(), downloadItem.getEventId())) {
                    obj3 = next;
                    break;
                }
            }
            EventItem eventItem = (EventItem) obj3;
            if (eventItem != null) {
                arrayList.add(eventItem);
            }
        }
        List<EventItem> list4 = list;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        for (EventItem eventItem2 : list4) {
            Iterator it3 = list3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it3.next();
                if (Intrinsics.areEqual(((DownloadItem) obj2).getEventId(), eventItem2.getId())) {
                    break;
                }
            }
            DownloadItem downloadItem2 = (DownloadItem) obj2;
            if (downloadItem2 != null) {
                DownloadItem.State state = downloadItem2.getState();
                if (state instanceof DownloadItem.State.InProgress) {
                    error = new EventItem.State.Downloading(((DownloadItem.State.InProgress) downloadItem2.getState()).getProgress());
                } else {
                    if (!(state instanceof DownloadItem.State.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    error = EventItem.State.Error.INSTANCE;
                }
                EventItem copy$default = EventItem.copy$default(eventItem2, null, 0, null, null, 0L, error, 31, null);
                if (copy$default != null) {
                    eventItem2 = copy$default;
                }
            }
            arrayList2.add(eventItem2);
        }
        return arrayList2;
    }
}
