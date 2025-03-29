package ru.tattelecom.intercom.feature.call_settings;

import android.widget.RadioButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: CallSettingsDialog.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class CallSettingsDialog$setUi$1$2$1$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RadioButton $this_apply;
    final /* synthetic */ CallSettingsDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CallSettingsDialog$setUi$1$2$1$2$1(RadioButton radioButton, CallSettingsDialog callSettingsDialog) {
        super(0);
        this.$this_apply = radioButton;
        this.this$0 = callSettingsDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$this_apply.setEnabled(false);
        final RadioButton radioButton = this.$this_apply;
        radioButton.postDelayed(new Runnable() { // from class: ru.tattelecom.intercom.feature.call_settings.CallSettingsDialog$setUi$1$2$1$2$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CallSettingsDialog$setUi$1$2$1$2$1.invoke$lambda$0(radioButton);
            }
        }, 1000L);
        this.this$0.openRingtoneSelection();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(RadioButton this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.setEnabled(true);
    }
}
