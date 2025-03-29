package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.data.remote.source.IntercomRemote;

/* compiled from: IntercomInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.IntercomInteractor$setCalls$2", f = "IntercomInteractor.kt", i = {}, l = {39, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class IntercomInteractor$setCalls$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $intercomId;
    final /* synthetic */ boolean $muted;
    int label;
    final /* synthetic */ IntercomInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntercomInteractor$setCalls$2(IntercomInteractor intercomInteractor, int i, boolean z, Continuation<? super IntercomInteractor$setCalls$2> continuation) {
        super(2, continuation);
        this.this$0 = intercomInteractor;
        this.$intercomId = i;
        this.$muted = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IntercomInteractor$setCalls$2(this.this$0, this.$intercomId, this.$muted, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IntercomInteractor$setCalls$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntercomRemote intercomRemote;
        AddressInteractor addressInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            intercomRemote = this.this$0.remote;
            this.label = 1;
            if (intercomRemote.setCalls(Boxing.boxInt(this.$intercomId), this.$muted, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        addressInteractor = this.this$0.addressInteractor;
        this.label = 2;
        if (addressInteractor.refreshAll(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
