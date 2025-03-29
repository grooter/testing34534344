package ru.tattelecom.intercom.feature.face_detect;

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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import ru.tattelecom.intercom.android.resources.StringResourceFinderKt;

/* compiled from: FaceDetectFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$provideUi$1$2", f = "FaceDetectFragment.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FaceDetectFragment$provideUi$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FaceDetectViewModel $this_with;
    int label;
    final /* synthetic */ FaceDetectFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FaceDetectFragment$provideUi$1$2(FaceDetectViewModel faceDetectViewModel, FaceDetectFragment faceDetectFragment, Continuation<? super FaceDetectFragment$provideUi$1$2> continuation) {
        super(2, continuation);
        this.$this_with = faceDetectViewModel;
        this.this$0 = faceDetectFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaceDetectFragment$provideUi$1$2(this.$this_with, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaceDetectFragment$provideUi$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<String> eventShowMessage = this.$this_with.getEventShowMessage();
            final FaceDetectFragment faceDetectFragment = this.this$0;
            this.label = 1;
            if (eventShowMessage.collect(new FlowCollector() { // from class: ru.tattelecom.intercom.feature.face_detect.FaceDetectFragment$provideUi$1$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((String) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(String str, Continuation<? super Unit> continuation) {
                    Context requireContext = FaceDetectFragment.this.requireContext();
                    Context requireContext2 = FaceDetectFragment.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                    Toast.makeText(requireContext, StringResourceFinderKt.getMessageText(str, requireContext2), 0).show();
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
        return Unit.INSTANCE;
    }
}
