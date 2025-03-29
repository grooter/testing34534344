package ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: GenerateQRCodeViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "apartment", "", "invites"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeViewModel$isContinueButtonAllowed$1", f = "GenerateQRCodeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GenerateQRCodeViewModel$isContinueButtonAllowed$1 extends SuspendLambda implements Function3<Integer, Integer, Continuation<? super Boolean>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    GenerateQRCodeViewModel$isContinueButtonAllowed$1(Continuation<? super GenerateQRCodeViewModel$isContinueButtonAllowed$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(Integer num, int i, Continuation<? super Boolean> continuation) {
        GenerateQRCodeViewModel$isContinueButtonAllowed$1 generateQRCodeViewModel$isContinueButtonAllowed$1 = new GenerateQRCodeViewModel$isContinueButtonAllowed$1(continuation);
        generateQRCodeViewModel$isContinueButtonAllowed$1.L$0 = num;
        generateQRCodeViewModel$isContinueButtonAllowed$1.I$0 = i;
        return generateQRCodeViewModel$isContinueButtonAllowed$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Integer num2, Continuation<? super Boolean> continuation) {
        return invoke(num, num2.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(((Integer) this.L$0) != null && this.I$0 > 0);
    }
}
