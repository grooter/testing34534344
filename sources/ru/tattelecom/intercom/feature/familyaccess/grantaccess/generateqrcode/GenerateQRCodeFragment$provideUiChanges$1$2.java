package ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode;

import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import ru.tattelecom.intercom.feature.familyaccess.databinding.FragmentGenerateQrCodeBinding;

/* compiled from: GenerateQRCodeFragment.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$provideUiChanges$1$2", f = "GenerateQRCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GenerateQRCodeFragment$provideUiChanges$1$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ GenerateQRCodeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GenerateQRCodeFragment$provideUiChanges$1$2(GenerateQRCodeFragment generateQRCodeFragment, Continuation<? super GenerateQRCodeFragment$provideUiChanges$1$2> continuation) {
        super(2, continuation);
        this.this$0 = generateQRCodeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GenerateQRCodeFragment$provideUiChanges$1$2 generateQRCodeFragment$provideUiChanges$1$2 = new GenerateQRCodeFragment$provideUiChanges$1$2(this.this$0, continuation);
        generateQRCodeFragment$provideUiChanges$1$2.Z$0 = ((Boolean) obj).booleanValue();
        return generateQRCodeFragment$provideUiChanges$1$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
        return invoke(bool.booleanValue(), continuation);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((GenerateQRCodeFragment$provideUiChanges$1$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FragmentGenerateQrCodeBinding binding;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final boolean z = this.Z$0;
            binding = this.this$0.getBinding();
            final MaterialButton materialButton = binding.btnGenerateQrCode;
            materialButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.familyaccess.grantaccess.generateqrcode.GenerateQRCodeFragment$provideUiChanges$1$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MaterialButton.this.setEnabled(z);
                }
            }, 10L);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
