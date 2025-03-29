package ru.tattelecom.intercom.feature.home;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.Flow;
import ru.tattelecom.intercom.data.local.entity.AdvBottomSheetDesignTheme;
import ru.tattelecom.intercom.domain.contracts.AdvBottomSheetInteractor;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.domain.model.AdvBottomSheetDto;
import ru.tattelecom.intercom.domain.model.DefaultThemeDto;

/* compiled from: HomeBottomSheetViewModel.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/tattelecom/intercom/feature/home/HomeBottomSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "logInteractor", "Lru/tattelecom/intercom/domain/interactors/LogInteractor;", "advInteractor", "Lru/tattelecom/intercom/domain/contracts/AdvBottomSheetInteractor;", "(Lru/tattelecom/intercom/domain/interactors/LogInteractor;Lru/tattelecom/intercom/domain/contracts/AdvBottomSheetInteractor;)V", "getAdv", "Lkotlinx/coroutines/flow/Flow;", "Lru/tattelecom/intercom/domain/model/AdvBottomSheetDto;", "theme", "Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;", "defaultTheme", "Lru/tattelecom/intercom/domain/model/DefaultThemeDto;", "(Lru/tattelecom/intercom/data/local/entity/AdvBottomSheetDesignTheme;Lru/tattelecom/intercom/domain/model/DefaultThemeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportEventAdv", "", "buttonId", "", "advId", "", "setAdvRead", TtmlNode.ATTR_ID, "Companion", "feature-home_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HomeBottomSheetViewModel extends ViewModel {
    public static final String TYPE_SCREEN = "screen";
    public static final String TYPE_URL = "url";
    private final AdvBottomSheetInteractor advInteractor;
    private final LogInteractor logInteractor;

    public HomeBottomSheetViewModel(LogInteractor logInteractor, AdvBottomSheetInteractor advInteractor) {
        Intrinsics.checkNotNullParameter(logInteractor, "logInteractor");
        Intrinsics.checkNotNullParameter(advInteractor, "advInteractor");
        this.logInteractor = logInteractor;
        this.advInteractor = advInteractor;
    }

    public final void reportEventAdv(int buttonId, long advId) {
        this.logInteractor.reportEvent(buttonId, MapsKt.mapOf(TuplesKt.to(LogInteractor.ADV_ID, Long.valueOf(advId))));
    }

    public final Object getAdv(AdvBottomSheetDesignTheme advBottomSheetDesignTheme, DefaultThemeDto defaultThemeDto, Continuation<? super Flow<AdvBottomSheetDto>> continuation) {
        return this.advInteractor.getAdv(advBottomSheetDesignTheme, defaultThemeDto, continuation);
    }

    public final void setAdvRead(long id) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HomeBottomSheetViewModel$setAdvRead$1(this, id, null), 3, null);
    }
}
