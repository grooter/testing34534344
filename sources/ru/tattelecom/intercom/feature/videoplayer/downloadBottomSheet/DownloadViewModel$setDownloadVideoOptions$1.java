package ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet;

import com.google.mlkit.common.MlKitException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import ru.tattelecom.intercom.domain.interactors.StreamInteractor;
import ru.tattelecom.intercom.domain.model.StreamDownloadStatus;
import ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadEvent;

/* compiled from: DownloadViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$setDownloadVideoOptions$1", f = "DownloadViewModel.kt", i = {2, 2}, l = {187, 198, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 218, 222}, m = "invokeSuspend", n = {"location", "url"}, s = {"L$0", "L$1"})
/* loaded from: classes8.dex */
final class DownloadViewModel$setDownloadVideoOptions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cameraArchiveExportSource;
    final /* synthetic */ int $duration;
    final /* synthetic */ boolean $isAxxon;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DownloadViewModel$setDownloadVideoOptions$1(DownloadViewModel downloadViewModel, boolean z, long j, String str, int i, Continuation<? super DownloadViewModel$setDownloadVideoOptions$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewModel;
        this.$isAxxon = z;
        this.$startTime = j;
        this.$cameraArchiveExportSource = str;
        this.$duration = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$setDownloadVideoOptions$1(this.this$0, this.$isAxxon, this.$startTime, this.$cameraArchiveExportSource, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DownloadViewModel$setDownloadVideoOptions$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ed A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:12:0x0023, B:16:0x0030, B:17:0x00e3, B:19:0x00be, B:22:0x00ed, B:25:0x0035, B:27:0x00a5, B:36:0x0076), top: B:2:0x000e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00e0 -> B:17:0x00e3). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$setDownloadVideoOptions$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* compiled from: DownloadViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$setDownloadVideoOptions$1$2", f = "DownloadViewModel.kt", i = {}, l = {208, 209}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: ru.tattelecom.intercom.feature.videoplayer.downloadBottomSheet.DownloadViewModel$setDownloadVideoOptions$1$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cameraArchiveExportSource;
        final /* synthetic */ String $location;
        final /* synthetic */ Ref.ObjectRef<String> $url;
        Object L$0;
        int label;
        final /* synthetic */ DownloadViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<String> objectRef, DownloadViewModel downloadViewModel, String str, String str2, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = objectRef;
            this.this$0 = downloadViewModel;
            this.$cameraArchiveExportSource = str;
            this.$location = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$url, this.this$0, this.$cameraArchiveExportSource, this.$location, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r8v8, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            StreamInteractor streamInteractor;
            Ref.ObjectRef<String> objectRef;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    objectRef = (Ref.ObjectRef) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    StreamDownloadStatus streamDownloadStatus = (StreamDownloadStatus) obj;
                    this.this$0.sendEvent(new DownloadEvent.ChangeProgress((int) (streamDownloadStatus.getStatus() * 100)));
                    objectRef.element = streamDownloadStatus.getUrl();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            Ref.ObjectRef<String> objectRef2 = this.$url;
            streamInteractor = this.this$0.streamInteractor;
            this.L$0 = objectRef2;
            this.label = 2;
            Object archiveStreamDownloadUrl = streamInteractor.getArchiveStreamDownloadUrl(this.$cameraArchiveExportSource, this.$location, this);
            if (archiveStreamDownloadUrl == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
            obj = archiveStreamDownloadUrl;
            StreamDownloadStatus streamDownloadStatus2 = (StreamDownloadStatus) obj;
            this.this$0.sendEvent(new DownloadEvent.ChangeProgress((int) (streamDownloadStatus2.getStatus() * 100)));
            objectRef.element = streamDownloadStatus2.getUrl();
            return Unit.INSTANCE;
        }
    }
}
