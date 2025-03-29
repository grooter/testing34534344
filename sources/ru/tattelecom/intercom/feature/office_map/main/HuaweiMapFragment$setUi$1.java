package ru.tattelecom.intercom.feature.office_map.main;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HuaweiMapFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
/* synthetic */ class HuaweiMapFragment$setUi$1 extends FunctionReferenceImpl implements Function1<OfficeService, Unit> {
    HuaweiMapFragment$setUi$1(Object obj) {
        super(1, obj, MapViewModel.class, "onServiceItemClick", "onServiceItemClick(Lru/tattelecom/intercom/feature/office_map/main/OfficeService;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(OfficeService officeService) {
        invoke2(officeService);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(OfficeService p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((MapViewModel) this.receiver).onServiceItemClick(p0);
    }
}
