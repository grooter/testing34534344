package ru.tattelecom.intercom.main;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.bumptech.glide.Glide;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.main.MainActivity$onDestroy$1", f = "MainActivity.kt", i = {0}, l = {ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 251}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240"}, s = {"L$1"})
/* loaded from: classes8.dex */
final class MainActivity$onDestroy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$onDestroy$1(MainActivity mainActivity, Continuation<? super MainActivity$onDestroy$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$onDestroy$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$onDestroy$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Glide glide;
        Glide glide2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            glide = Glide.get(this.this$0.getApplicationContext());
            MainCoroutineDispatcher main = Dispatchers.getMain();
            MainActivity$onDestroy$1$1$1 mainActivity$onDestroy$1$1$1 = new MainActivity$onDestroy$1$1$1(glide, null);
            this.L$0 = glide;
            this.L$1 = glide;
            this.label = 1;
            if (BuildersKt.withContext(main, mainActivity$onDestroy$1$1$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            glide2 = glide;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            glide = (Glide) this.L$1;
            glide2 = (Glide) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        CoroutineDispatcher io2 = Dispatchers.getIO();
        MainActivity$onDestroy$1$1$2 mainActivity$onDestroy$1$1$2 = new MainActivity$onDestroy$1$1$2(glide, null);
        this.L$0 = glide2;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(io2, mainActivity$onDestroy$1$1$2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
