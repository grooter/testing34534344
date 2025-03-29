package ru.tattelecom.intercom.domain.interactors;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.NonCancellable;
import ru.tattelecom.intercom.data.remote.source.StreamRemote;

/* compiled from: UserInteractor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.domain.interactors.UserInteractor$removeStreamFromFavorites$2", f = "UserInteractor.kt", i = {}, l = {176, 177}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes5.dex */
final class UserInteractor$removeStreamFromFavorites$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $streamUrl;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ UserInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UserInteractor$removeStreamFromFavorites$2(String str, UserInteractor userInteractor, Continuation<? super UserInteractor$removeStreamFromFavorites$2> continuation) {
        super(2, continuation);
        this.$streamUrl = str;
        this.this$0 = userInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UserInteractor$removeStreamFromFavorites$2(this.$streamUrl, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UserInteractor$removeStreamFromFavorites$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        StreamRemote streamRemote;
        UserInteractor userInteractor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str = this.$streamUrl;
            if (str == null) {
                return null;
            }
            UserInteractor userInteractor2 = this.this$0;
            streamRemote = userInteractor2.streamRemote;
            this.L$0 = userInteractor2;
            this.L$1 = str;
            this.label = 1;
            if (streamRemote.setFavorite(str, false, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            userInteractor = userInteractor2;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            str = (String) this.L$1;
            userInteractor = (UserInteractor) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        NonCancellable nonCancellable = NonCancellable.INSTANCE;
        UserInteractor$removeStreamFromFavorites$2$1$1 userInteractor$removeStreamFromFavorites$2$1$1 = new UserInteractor$removeStreamFromFavorites$2$1$1(userInteractor, str, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(nonCancellable, userInteractor$removeStreamFromFavorites$2$1$1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
