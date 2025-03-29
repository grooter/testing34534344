package ru.tattelecom.intercom.feature.videoplayer.archiveDateBottomSheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: ArchiveDateBottomSheet.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes8.dex */
/* synthetic */ class ArchiveDateBottomSheet$onViewCreated$2 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    ArchiveDateBottomSheet$onViewCreated$2(Object obj) {
        super(1, obj, ArchiveDateBottomSheet.class, "onDayClick", "onDayClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((ArchiveDateBottomSheet) this.receiver).onDayClick(i);
    }
}
