package ru.tattelecom.intercom.main;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "isEnabled", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.main.MainActivity$callServiceConnection$1$onServiceConnected$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class MainActivity$callServiceConnection$1$onServiceConnected$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$callServiceConnection$1$onServiceConnected$1(MainActivity mainActivity, Continuation<? super MainActivity$callServiceConnection$1$onServiceConnected$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MainActivity$callServiceConnection$1$onServiceConnected$1 mainActivity$callServiceConnection$1$onServiceConnected$1 = new MainActivity$callServiceConnection$1$onServiceConnected$1(this.this$0, continuation);
        mainActivity$callServiceConnection$1$onServiceConnected$1.Z$0 = ((Boolean) obj).booleanValue();
        return mainActivity$callServiceConnection$1$onServiceConnected$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((MainActivity$callServiceConnection$1$onServiceConnected$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Intent intent;
        Intent intent2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        Intent intent3 = null;
        if (this.Z$0) {
            MainActivity mainActivity = this.this$0;
            intent2 = mainActivity.callServiceIntent;
            if (intent2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callServiceIntent");
            } else {
                intent3 = intent2;
            }
            mainActivity.startService(intent3);
        } else {
            MainActivity mainActivity2 = this.this$0;
            intent = mainActivity2.callServiceIntent;
            if (intent == null) {
                Intrinsics.throwUninitializedPropertyAccessException("callServiceIntent");
            } else {
                intent3 = intent;
            }
            mainActivity2.stopService(intent3);
        }
        return Unit.INSTANCE;
    }
}
