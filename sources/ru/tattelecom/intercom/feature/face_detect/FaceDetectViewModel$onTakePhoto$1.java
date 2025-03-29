package ru.tattelecom.intercom.feature.face_detect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FaceDetectViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel$onTakePhoto$1", f = "FaceDetectViewModel.kt", i = {}, l = {55, 58}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FaceDetectViewModel$onTakePhoto$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FaceDetectViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FaceDetectViewModel$onTakePhoto$1(FaceDetectViewModel faceDetectViewModel, Continuation<? super FaceDetectViewModel$onTakePhoto$1> continuation) {
        super(2, continuation);
        this.this$0 = faceDetectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FaceDetectViewModel$onTakePhoto$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FaceDetectViewModel$onTakePhoto$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x008a  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L1f
            goto L68
        L13:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1b:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            goto L4c
        L1f:
            r7 = move-exception
            goto Lc5
        L22:
            r7 = move-exception
            goto L52
        L24:
            kotlin.ResultKt.throwOnFailure(r7)
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            kotlinx.coroutines.flow.MutableStateFlow r7 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$get_isLoading$p(r7)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            r7.setValue(r1)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            ru.tattelecom.intercom.domain.interactors.UserInteractor r7 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$getUserInteractor$p(r7)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r1 = r6.this$0     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            java.lang.String r1 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$getCurrentPhotoPath$p(r1)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            r6.label = r4     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            java.lang.Object r7 = r7.uploadFaceDetectionPhoto(r1, r5)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            if (r7 != r0) goto L4c
            return r0
        L4c:
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r7 = r6.this$0     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$fetchPhotoList(r7)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L22
            goto L68
        L52:
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r1 = r6.this$0     // Catch: java.lang.Throwable -> L1f
            kotlinx.coroutines.channels.Channel r1 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$get_eventShowMessage$p(r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L1f
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch: java.lang.Throwable -> L1f
            r6.label = r2     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r7 = r1.send(r7, r4)     // Catch: java.lang.Throwable -> L1f
            if (r7 != r0) goto L68
            return r0
        L68:
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r7 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r7 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$get_isLoading$p(r7)
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r7.setValue(r0)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r0 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r0 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$get_photosList$p(r0)
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L99
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r7.addAll(r0)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
        L99:
            int r0 = r7.size()
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r1 = r6.this$0
            java.lang.String r1 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$getCurrentPhotoPath$p(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto Lc2
            ru.tattelecom.intercom.feature.face_detect.Photo r1 = new ru.tattelecom.intercom.feature.face_detect.Photo
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r2 = r6.this$0
            java.lang.String r2 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$getCurrentPhotoPath$p(r2)
            r1.<init>(r0, r2)
            r7.add(r1)
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r0 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r0 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$get_photosList$p(r0)
            r0.setValue(r7)
        Lc2:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        Lc5:
            ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel r0 = r6.this$0
            kotlinx.coroutines.flow.MutableStateFlow r0 = ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel.access$get_isLoading$p(r0)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r0.setValue(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.face_detect.FaceDetectViewModel$onTakePhoto$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
