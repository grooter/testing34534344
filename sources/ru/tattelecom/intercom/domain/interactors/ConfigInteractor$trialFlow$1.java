package ru.tattelecom.intercom.domain.interactors;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import ru.tattelecom.intercom.domain.model.TrialDto;

/* compiled from: ConfigInteractor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "Lru/tattelecom/intercom/domain/model/TrialDto;", TtmlNode.ATTR_ID, "", "isActive", "", "remainingDays"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.ConfigInteractor$trialFlow$1", f = "ConfigInteractor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class ConfigInteractor$trialFlow$1 extends SuspendLambda implements Function4<Integer, Boolean, Integer, Continuation<? super TrialDto>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    /* synthetic */ boolean Z$0;
    int label;

    ConfigInteractor$trialFlow$1(Continuation<? super ConfigInteractor$trialFlow$1> continuation) {
        super(4, continuation);
    }

    public final Object invoke(int i, boolean z, int i2, Continuation<? super TrialDto> continuation) {
        ConfigInteractor$trialFlow$1 configInteractor$trialFlow$1 = new ConfigInteractor$trialFlow$1(continuation);
        configInteractor$trialFlow$1.I$0 = i;
        configInteractor$trialFlow$1.Z$0 = z;
        configInteractor$trialFlow$1.I$1 = i2;
        return configInteractor$trialFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Boolean bool, Integer num2, Continuation<? super TrialDto> continuation) {
        return invoke(num.intValue(), bool.booleanValue(), num2.intValue(), continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return new TrialDto(this.I$0, this.Z$0, this.I$1);
    }
}
