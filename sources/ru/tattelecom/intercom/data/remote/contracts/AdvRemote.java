package ru.tattelecom.intercom.data.remote.contracts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import ru.tattelecom.intercom.data.remote.model.StatusResponse;
import ru.tattelecom.intercom.data.remote.model.responses.AdvBottomSheetResponse;

/* compiled from: AdvRemote.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lru/tattelecom/intercom/data/remote/contracts/AdvRemote;", "", "getAdvBottomSheet", "Lru/tattelecom/intercom/data/remote/model/responses/AdvBottomSheetResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAdvIsRead", "Lru/tattelecom/intercom/data/remote/model/StatusResponse;", TtmlNode.ATTR_ID, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AdvRemote {
    Object getAdvBottomSheet(Continuation<? super AdvBottomSheetResponse> continuation);

    Object setAdvIsRead(long j, Continuation<? super StatusResponse> continuation);
}
