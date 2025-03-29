package ru.tattelecom.intercom.feature.face_detect;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.UserInteractor;

/* compiled from: FaceDetectViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel$fetchPhotoList$1", f = "FaceDetectViewModel.kt", i = {}, l = {34, 40}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FaceDetectViewModel$fetchPhotoList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FaceDetectViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FaceDetectViewModel$fetchPhotoList$1(FaceDetectViewModel faceDetectViewModel, Continuation<? super FaceDetectViewModel$fetchPhotoList$1> continuation) {
        super(2, continuation);
        this.this$0 = faceDetectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaceDetectViewModel$fetchPhotoList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaceDetectViewModel$fetchPhotoList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        UserInteractor userInteractor;
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (Exception e) {
            channel = this.this$0._eventShowMessage;
            this.label = 2;
            if (channel.send(e.getLocalizedMessage(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            userInteractor = this.this$0.userInteractor;
            this.label = 1;
            obj = userInteractor.getPhotoList(this);
            if (obj == coroutine_suspended) {
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
        if (!((Boolean) obj).booleanValue()) {
            mutableStateFlow2 = this.this$0._photosList;
            mutableStateFlow2.setValue(new ArrayList());
        } else {
            mutableStateFlow = this.this$0._photosList;
            mutableStateFlow.setValue(new ArrayList());
        }
        return Unit.INSTANCE;
    }
}
