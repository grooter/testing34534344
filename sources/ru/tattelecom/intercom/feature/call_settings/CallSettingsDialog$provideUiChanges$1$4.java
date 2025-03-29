package ru.tattelecom.intercom.feature.call_settings;

import android.content.Context;
import android.widget.Toast;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;

/* compiled from: CallSettingsDialog.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$provideUiChanges$1$4", f = "CallSettingsDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallSettingsDialog$provideUiChanges$1$4 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CallSettingsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallSettingsDialog$provideUiChanges$1$4(CallSettingsDialog callSettingsDialog, Continuation<? super CallSettingsDialog$provideUiChanges$1$4> continuation) {
        super(2, continuation);
        this.this$0 = callSettingsDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CallSettingsDialog$provideUiChanges$1$4 callSettingsDialog$provideUiChanges$1$4 = new CallSettingsDialog$provideUiChanges$1$4(this.this$0, continuation);
        callSettingsDialog$provideUiChanges$1$4.L$0 = obj;
        return callSettingsDialog$provideUiChanges$1$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((CallSettingsDialog$provideUiChanges$1$4) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String str = (String) this.L$0;
        Context requireContext = this.this$0.requireContext();
        Context requireContext2 = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(str, requireContext2), 0).show();
        return Unit.INSTANCE;
    }
}
