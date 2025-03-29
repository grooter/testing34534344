package ru.tattelecom.intercom.feature.familyaccess.temporarycode;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.widget.Toast;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* compiled from: TemporaryCodeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$provideUiChanges$2", f = "TemporaryCodeFragment.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class TemporaryCodeFragment$provideUiChanges$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TemporaryCodeFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TemporaryCodeFragment$provideUiChanges$2(TemporaryCodeFragment temporaryCodeFragment, Continuation<? super TemporaryCodeFragment$provideUiChanges$2> continuation) {
        super(2, continuation);
        this.this$0 = temporaryCodeFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TemporaryCodeFragment$provideUiChanges$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TemporaryCodeFragment$provideUiChanges$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TemporaryCodeViewModel viewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            viewModel = this.this$0.getViewModel();
            SharedFlow<Pair<Integer, String>> eventShareCode = viewModel.getEventShareCode();
            final TemporaryCodeFragment temporaryCodeFragment = this.this$0;
            this.label = 1;
            if (eventShareCode.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.familyaccess.temporarycode.TemporaryCodeFragment$provideUiChanges$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((Pair<Integer, String>) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(Pair<Integer, String> pair, Continuation<? super Unit> continuation) {
                    if (pair.getFirst() != null && pair.getSecond() != null) {
                        Intent intent = new Intent();
                        TemporaryCodeFragment temporaryCodeFragment2 = TemporaryCodeFragment.this;
                        intent.setAction("android.intent.action.SEND");
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String string = temporaryCodeFragment2.getString(R.string.my_temporary_code);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String format = String.format(string, Arrays.copyOf(new Object[]{pair.getFirst(), pair.getSecond()}, 2));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        intent.putExtra("android.intent.extra.TEXT", format);
                        intent.setType("text/plain");
                        try {
                            TemporaryCodeFragment.this.startActivity(Intent.createChooser(intent, "Поделиться:"));
                        } catch (ActivityNotFoundException unused) {
                            Toast.makeText(TemporaryCodeFragment.this.requireContext(), TemporaryCodeFragment.this.getString(R.string.suitable_applications_not_found), 0).show();
                        }
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
