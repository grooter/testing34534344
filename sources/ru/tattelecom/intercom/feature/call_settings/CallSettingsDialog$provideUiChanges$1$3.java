package ru.tattelecom.intercom.feature.call_settings;

import android.widget.ProgressBar;
import com.google.android.material.switchmaterial.SwitchMaterial;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.call_settings.databinding.DialogCallSettingsBinding;

/* compiled from: CallSettingsDialog.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$provideUiChanges$1$3", f = "CallSettingsDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class CallSettingsDialog$provideUiChanges$1$3 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ CallSettingsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallSettingsDialog$provideUiChanges$1$3(CallSettingsDialog callSettingsDialog, Continuation<? super CallSettingsDialog$provideUiChanges$1$3> continuation) {
        super(2, continuation);
        this.this$0 = callSettingsDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CallSettingsDialog$provideUiChanges$1$3 callSettingsDialog$provideUiChanges$1$3 = new CallSettingsDialog$provideUiChanges$1$3(this.this$0, continuation);
        callSettingsDialog$provideUiChanges$1$3.Z$0 = ((Boolean) obj).booleanValue();
        return callSettingsDialog$provideUiChanges$1$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((CallSettingsDialog$provideUiChanges$1$3) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DialogCallSettingsBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            boolean z = this.Z$0;
            binding = this.this$0.getBinding();
            ProgressBar progressDoNotDisturb = binding.progressDoNotDisturb;
            Intrinsics.checkNotNullExpressionValue(progressDoNotDisturb, "progressDoNotDisturb");
            progressDoNotDisturb.setVisibility(z ? 0 : 8);
            SwitchMaterial switchDoNotDisturb = binding.switchDoNotDisturb;
            Intrinsics.checkNotNullExpressionValue(switchDoNotDisturb, "switchDoNotDisturb");
            switchDoNotDisturb.setVisibility(z ? 8 : 0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
