package ru.tattelecom.intercom.domain.interactors;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.remote.model.OfficeResponse;
import ru.tattelecom.intercom.data.remote.source.OfficeMapRemote;

/* compiled from: OfficeInteractor.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lru/tattelecom/intercom/data/remote/model/OfficeResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.OfficeInteractor$observeOfficeList$2", f = "OfficeInteractor.kt", i = {}, l = {12}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class OfficeInteractor$observeOfficeList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends OfficeResponse>>, Object> {
    int label;
    final /* synthetic */ OfficeInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfficeInteractor$observeOfficeList$2(OfficeInteractor officeInteractor, Continuation<? super OfficeInteractor$observeOfficeList$2> continuation) {
        super(2, continuation);
        this.this$0 = officeInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfficeInteractor$observeOfficeList$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends OfficeResponse>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<OfficeResponse>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<OfficeResponse>> continuation) {
        return ((OfficeInteractor$observeOfficeList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        OfficeMapRemote officeMapRemote;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            officeMapRemote = this.this$0.remote;
            this.label = 1;
            obj = officeMapRemote.getAll(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
