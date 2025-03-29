package ru.tattelecom.intercom.feature.player;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.MutableStateFlow;
import ru.tattelecom.intercom.domain.interactors.StreamInteractor;
import ru.tattelecom.intercom.domain.model.StreamSourceDto;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;

/* compiled from: PlayerViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerViewModel$provideCameraStream$1", f = "PlayerViewModel.kt", i = {2}, l = {323, 325, 333, 338}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
/* loaded from: classes7.dex */
final class PlayerViewModel$provideCameraStream$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $additionalTimeInSeconds;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PlayerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerViewModel$provideCameraStream$1(PlayerViewModel playerViewModel, long j, Continuation<? super PlayerViewModel$provideCameraStream$1> continuation) {
        super(2, continuation);
        this.this$0 = playerViewModel;
        this.$additionalTimeInSeconds = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PlayerViewModel$provideCameraStream$1(this.this$0, this.$additionalTimeInSeconds, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PlayerViewModel$provideCameraStream$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel channel;
        Long selectedDayInSeconds;
        StreamInteractor streamInteractor;
        MutableStateFlow mutableStateFlow;
        SimpleDateFormat simpleDateFormat;
        String format;
        StreamInteractor streamInteractor2;
        String str;
        StreamSourceDto streamSourceDto;
        String streamUrl;
        PlayerViewModel playerViewModel;
        PlayerViewModel playerViewModel2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                channel = this.this$0._events;
                this.L$0 = null;
                this.L$1 = null;
                this.label = 4;
                if (channel.send(new PlayerViewModel.Event.ShowMessage(e.getMessage()), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.getStreamUrl().setValue(null);
                selectedDayInSeconds = this.this$0.selectedDayInSeconds();
                this.this$0.isStreamLoading().setValue(Boxing.boxBoolean(true));
                if (selectedDayInSeconds != null) {
                    mutableStateFlow = this.this$0._streamTimeInSeconds;
                    mutableStateFlow.setValue(Boxing.boxLong(this.$additionalTimeInSeconds));
                    if (!this.this$0.getIsFlussonic()) {
                        simpleDateFormat = this.this$0.cameraArchiveTimeFormatter;
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis((selectedDayInSeconds.longValue() + this.$additionalTimeInSeconds) * 1000);
                        calendar.add(11, -3);
                        format = simpleDateFormat.format(calendar.getTime());
                    } else {
                        format = selectedDayInSeconds.toString();
                    }
                    streamInteractor2 = this.this$0.streamInteractor;
                    str = this.this$0.cameraArchiveSource;
                    Intrinsics.checkNotNull(format);
                    this.label = 1;
                    obj = streamInteractor2.getArchiveUrl(str, format, this.this$0.getIsFlussonic(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    streamSourceDto = (StreamSourceDto) obj;
                } else {
                    streamInteractor = this.this$0.streamInteractor;
                    this.label = 2;
                    obj = streamInteractor.getLiveUrl(this.this$0.getCameraLiveSource(), this.this$0.getIsFlussonic(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    streamSourceDto = (StreamSourceDto) obj;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                streamSourceDto = (StreamSourceDto) obj;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        this.this$0.isStreamLoading().setValue(Boxing.boxBoolean(false));
                        return Unit.INSTANCE;
                    }
                    streamUrl = (String) this.L$1;
                    playerViewModel2 = (PlayerViewModel) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    playerViewModel = playerViewModel2;
                    playerViewModel.getStreamUrl().setValue(streamUrl);
                    this.this$0.isStreamLoading().setValue(Boxing.boxBoolean(false));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                streamSourceDto = (StreamSourceDto) obj;
            }
            streamUrl = streamSourceDto.getStreamUrl();
            playerViewModel = this.this$0;
            if (!playerViewModel.getIsFlussonic()) {
                this.L$0 = playerViewModel;
                this.L$1 = streamUrl;
                this.label = 3;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                playerViewModel2 = playerViewModel;
                playerViewModel = playerViewModel2;
            }
            playerViewModel.getStreamUrl().setValue(streamUrl);
            this.this$0.isStreamLoading().setValue(Boxing.boxBoolean(false));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.isStreamLoading().setValue(Boxing.boxBoolean(false));
            throw th;
        }
    }
}
