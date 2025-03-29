package ru.tattelecom.intercom.feature.videoplayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$refreshEvents$1", f = "VideoPlayerViewModel.kt", i = {}, l = {555}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$refreshEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $gateId;
    final /* synthetic */ long $selectedDay;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$refreshEvents$1(VideoPlayerViewModel videoPlayerViewModel, int i, long j, Continuation<? super VideoPlayerViewModel$refreshEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$gateId = i;
        this.$selectedDay = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$refreshEvents$1(this.this$0, this.$gateId, this.$selectedDay, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$refreshEvents$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: VideoPlayerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$refreshEvents$1$1", f = "VideoPlayerViewModel.kt", i = {}, l = {558, 561}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$refreshEvents$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $gateId;
        final /* synthetic */ long $selectedDay;
        int label;
        final /* synthetic */ VideoPlayerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(VideoPlayerViewModel videoPlayerViewModel, int i, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = videoPlayerViewModel;
            this.$gateId = i;
            this.$selectedDay = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$gateId, this.$selectedDay, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0042 A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0040 -> B:12:0x001e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1b
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L1b
            Lf:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L17:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L34
                goto L34
            L1b:
                kotlin.ResultKt.throwOnFailure(r8)
            L1e:
                ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel r8 = r7.this$0     // Catch: java.lang.Exception -> L34
                ru.tattelecom.intercom.domain.interactors.GateInteractor r8 = ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel.access$getGateInteractor$p(r8)     // Catch: java.lang.Exception -> L34
                int r1 = r7.$gateId     // Catch: java.lang.Exception -> L34
                long r4 = r7.$selectedDay     // Catch: java.lang.Exception -> L34
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L34
                r7.label = r3     // Catch: java.lang.Exception -> L34
                java.lang.Object r8 = r8.refreshEvents(r1, r4, r6)     // Catch: java.lang.Exception -> L34
                if (r8 != r0) goto L34
                return r0
            L34:
                r8 = r7
                kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
                r7.label = r2
                r4 = 60000(0xea60, double:2.9644E-319)
                java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r4, r8)
                if (r8 != r0) goto L1e
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$refreshEvents$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1(this.this$0, this.$gateId, this.$selectedDay, null), this) == coroutine_suspended) {
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
