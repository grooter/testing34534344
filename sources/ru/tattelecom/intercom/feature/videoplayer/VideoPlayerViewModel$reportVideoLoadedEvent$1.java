package ru.tattelecom.intercom.feature.videoplayer;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ru.tattelecom.intercom.domain.interactors.LogInteractor;
import ru.tattelecom.intercom.feature.videoplayer.PlayerState;

/* compiled from: VideoPlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.videoplayer.VideoPlayerViewModel$reportVideoLoadedEvent$1", f = "VideoPlayerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes8.dex */
final class VideoPlayerViewModel$reportVideoLoadedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $timeInMs;
    int label;
    final /* synthetic */ VideoPlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VideoPlayerViewModel$reportVideoLoadedEvent$1(VideoPlayerViewModel videoPlayerViewModel, long j, Continuation<? super VideoPlayerViewModel$reportVideoLoadedEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = videoPlayerViewModel;
        this.$timeInMs = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VideoPlayerViewModel$reportVideoLoadedEvent$1(this.this$0, this.$timeInMs, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VideoPlayerViewModel$reportVideoLoadedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LogInteractor logInteractor;
        String str;
        String str2;
        String str3;
        String str4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setVideoLoadStartTime(Boxing.boxLong(0L));
            logInteractor = this.this$0.logInteractor;
            Pair[] pairArr = new Pair[3];
            String str5 = null;
            if (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerState.Intercom.INSTANCE)) {
                str4 = this.this$0.cameraUrl;
                if (str4 != null) {
                    str5 = StringsKt.substringBefore$default(StringsKt.substringAfter$default(str4, "https://", (String) null, 2, (Object) null), "?", (String) null, 2, (Object) null);
                }
            } else if (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerState.Camera.INSTANCE) && this.this$0.getIsFlussonic()) {
                str2 = this.this$0.cameraUrl;
                if (str2 != null) {
                    str5 = StringsKt.substringAfter$default(str2, "https://", (String) null, 2, (Object) null);
                }
            } else if (!Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerState.Camera.INSTANCE) || this.this$0.getIsFlussonic()) {
                str5 = this.this$0.cameraUrl;
            } else {
                str = this.this$0.cameraUrl;
                if (str != null) {
                    str5 = StringsKt.substringBeforeLast$default(str, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null) + RemoteSettings.FORWARD_SLASH_STRING + StringsKt.substringAfterLast$default(str, "?", (String) null, 2, (Object) null);
                }
            }
            pairArr[0] = TuplesKt.to("source", str5);
            pairArr[1] = TuplesKt.to(CrashHianalyticsData.TIME, Boxing.boxLong(this.$timeInMs));
            if (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerState.Intercom.INSTANCE)) {
                str3 = "intercom";
            } else if (Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerState.Camera.INSTANCE) && this.this$0.getIsFlussonic()) {
                str3 = "flussonic";
            } else {
                str3 = (!Intrinsics.areEqual(this.this$0.getScreenState().getValue(), PlayerState.Camera.INSTANCE) || this.this$0.getIsFlussonic()) ? "undefined" : "axxon";
            }
            pairArr[2] = TuplesKt.to("stream_type", str3);
            logInteractor.reportEvent(117, MapsKt.mapOf(pairArr));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
