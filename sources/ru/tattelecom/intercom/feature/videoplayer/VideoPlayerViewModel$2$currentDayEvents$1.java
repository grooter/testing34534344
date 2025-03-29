package ru.tattelecom.intercom.feature.videoplayer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import ru.tattelecom.intercom.domain.model.GateEventDto;
import ru.tattelecom.intercom.feature.videoplayer.model.EventItem;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u008a@"}, d2 = {"<anonymous>", "", "Lru/tattelecom/intercom/feature/videoplayer/model/EventItem;", "eventList", "Lru/tattelecom/intercom/domain/model/GateEventDto;", "dayId", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$2$currentDayEvents$1", f = "VideoPlayerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$2$currentDayEvents$1 extends SuspendLambda implements Function3<List<? extends GateEventDto>, Integer, Continuation<? super List<? extends EventItem>>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$2$currentDayEvents$1(VideoPlayerViewModel videoPlayerViewModel, Continuation<? super VideoPlayerViewModel$2$currentDayEvents$1> continuation) {
        super(3, continuation);
        this.this$0 = videoPlayerViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(List<? extends GateEventDto> list, Integer num, Continuation<? super List<? extends EventItem>> continuation) {
        return invoke((List<GateEventDto>) list, num.intValue(), (Continuation<? super List<EventItem>>) continuation);
    }

    public final Object invoke(List<GateEventDto> list, int i, Continuation<? super List<EventItem>> continuation) {
        VideoPlayerViewModel$2$currentDayEvents$1 videoPlayerViewModel$2$currentDayEvents$1 = new VideoPlayerViewModel$2$currentDayEvents$1(this.this$0, continuation);
        videoPlayerViewModel$2$currentDayEvents$1.L$0 = list;
        videoPlayerViewModel$2$currentDayEvents$1.I$0 = i;
        return videoPlayerViewModel$2$currentDayEvents$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long selectedDayInMs;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        List list = (List) this.L$0;
        int i = this.I$0;
        Calendar calendar = Calendar.getInstance();
        selectedDayInMs = this.this$0.selectedDayInMs(i);
        calendar.setTimeInMillis(selectedDayInMs);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        calendar.set(11, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        calendar.set(14, 59);
        Pair pair = TuplesKt.to(Boxing.boxLong(timeInMillis), Boxing.boxLong(calendar.getTimeInMillis()));
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            long longValue = ((Number) pair.getFirst()).longValue();
            long longValue2 = ((Number) pair.getSecond()).longValue();
            long time = ((GateEventDto) obj2).getStartDate().getTime();
            if (longValue <= time && time <= longValue2) {
                arrayList.add(obj2);
            }
        }
        ArrayList<GateEventDto> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (GateEventDto gateEventDto : arrayList2) {
            arrayList3.add(new EventItem(gateEventDto.getId(), gateEventDto.getGateId(), gateEventDto.getType(), gateEventDto.getStartDate(), gateEventDto.getDuration(), null, 32, null));
        }
        return arrayList3;
    }
}
