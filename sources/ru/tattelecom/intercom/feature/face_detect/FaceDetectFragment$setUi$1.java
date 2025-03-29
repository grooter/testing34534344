package ru.tattelecom.intercom.feature.face_detect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: FaceDetectFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
/* synthetic */ class FaceDetectFragment$setUi$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    FaceDetectFragment$setUi$1(Object obj) {
        super(1, obj, FaceDetectViewModel.class, "onItemClick", "onItemClick(I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        ((FaceDetectViewModel) this.receiver).onItemClick(i);
    }
}
