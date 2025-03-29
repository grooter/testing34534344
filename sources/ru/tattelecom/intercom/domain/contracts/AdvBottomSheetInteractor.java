package ru.tattelecom.intercom.domain.contracts;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.domain.model.AdvBottomSheetDto;
import ru.tattelecom.intercom.domain.model.DefaultThemeDto;

/* compiled from: AdvBottomSheetInteractor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\t¨\u0006\u0010"}, d2 = {"Lru/tattelecom/intercom/domain/contracts/AdvBottomSheetInteractor;", "", "getAdv", "Lkotlinx/coroutines/flow/Flow;", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "defaultTheme", "Lru/tattelecom/intercom/domain/model/DefaultThemeDto;", "(Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;Lru/tattelecom/intercom/domain/model/DefaultThemeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setRead", "", TtmlNode.ATTR_ID, "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAdv", "domain_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface AdvBottomSheetInteractor {
    Object getAdv(AdvBottomSheetDesignTheme advBottomSheetDesignTheme, DefaultThemeDto defaultThemeDto, Continuation<? super Flow<AdvBottomSheetDto>> continuation);

    Object setRead(long j, Continuation<? super Unit> continuation);

    Object updateAdv(AdvBottomSheetDesignTheme advBottomSheetDesignTheme, DefaultThemeDto defaultThemeDto, Continuation<? super Flow<AdvBottomSheetDto>> continuation);
}
