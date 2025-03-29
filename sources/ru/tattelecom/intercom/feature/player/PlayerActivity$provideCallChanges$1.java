package ru.tattelecom.intercom.feature.player;

import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.media3.exoplayer.ExoPlayer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ru.tattelecom.intercom.feature.call.CallService;
import ru.tattelecom.intercom.feature.call.CallState;
import ru.tattelecom.intercom.feature.call.SipManager;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;
import ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/call/CallState;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$1", f = "PlayerActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class PlayerActivity$provideCallChanges$1 extends SuspendLambda implements Function2<CallState, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideCallChanges$1(PlayerActivity playerActivity, Continuation<? super PlayerActivity$provideCallChanges$1> continuation) {
        super(2, continuation);
        this.this$0 = playerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PlayerActivity$provideCallChanges$1 playerActivity$provideCallChanges$1 = new PlayerActivity$provideCallChanges$1(this.this$0, continuation);
        playerActivity$provideCallChanges$1.L$0 = obj;
        return playerActivity$provideCallChanges$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CallState callState, Continuation<? super Unit> continuation) {
        return ((PlayerActivity$provideCallChanges$1) create(callState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        ActivityPlayerBinding binding;
        HardwareManager hardwareManager;
        PlayerViewModel viewModel3;
        HardwareManager hardwareManager2;
        PlayerViewModel viewModel4;
        PlayerViewModel viewModel5;
        HardwareManager hardwareManager3;
        ExoPlayer exoPlayer;
        PlayerViewModel viewModel6;
        ActivityResultLauncher activityResultLauncher;
        HardwareManager hardwareManager4;
        PlayerViewModel viewModel7;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CallState callState = (CallState) this.L$0;
            viewModel = this.this$0.getViewModel();
            viewModel.onCallStateChanged(callState);
            viewModel2 = this.this$0.getViewModel();
            if (Intrinsics.areEqual(viewModel2.getScreenState().getValue(), PlayerViewModel.PlayerState.Call.INSTANCE)) {
                binding = this.this$0.getBinding();
                final PlayerActivity playerActivity = this.this$0;
                if (Intrinsics.areEqual(callState, CallState.NoCall.INSTANCE)) {
                    FloatingActionButton btnAcceptCall = binding.btnAcceptCall;
                    Intrinsics.checkNotNullExpressionValue(btnAcceptCall, "btnAcceptCall");
                    FloatingActionButton floatingActionButton = btnAcceptCall;
                    viewModel7 = playerActivity.getViewModel();
                    floatingActionButton.setVisibility(viewModel7.isAdmin() ? 0 : 8);
                    FloatingActionButton btnEndCall = binding.btnEndCall;
                    Intrinsics.checkNotNullExpressionValue(btnEndCall, "btnEndCall");
                    btnEndCall.setVisibility(8);
                    FloatingActionButton btnMic = binding.btnMic;
                    Intrinsics.checkNotNullExpressionValue(btnMic, "btnMic");
                    btnMic.setVisibility(8);
                } else {
                    HardwareManager hardwareManager5 = null;
                    HardwareManager hardwareManager6 = null;
                    ActivityResultLauncher activityResultLauncher2 = null;
                    HardwareManager hardwareManager7 = null;
                    if (Intrinsics.areEqual(callState, CallState.Incoming.INSTANCE)) {
                        FloatingActionButton btnAcceptCall2 = binding.btnAcceptCall;
                        Intrinsics.checkNotNullExpressionValue(btnAcceptCall2, "btnAcceptCall");
                        btnAcceptCall2.setVisibility(0);
                        FloatingActionButton btnEndCall2 = binding.btnEndCall;
                        Intrinsics.checkNotNullExpressionValue(btnEndCall2, "btnEndCall");
                        btnEndCall2.setVisibility(0);
                        FloatingActionButton btnMic2 = binding.btnMic;
                        Intrinsics.checkNotNullExpressionValue(btnMic2, "btnMic");
                        btnMic2.setVisibility(8);
                        hardwareManager4 = playerActivity.hardwareManager;
                        if (hardwareManager4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hardwareManager");
                        } else {
                            hardwareManager6 = hardwareManager4;
                        }
                        hardwareManager6.start();
                        binding.btnOpenIntercom.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PlayerActivity$provideCallChanges$1.invokeSuspend$lambda$4$lambda$0(PlayerActivity.this, view);
                            }
                        });
                        binding.btnEndCall.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$1$$ExternalSyntheticLambda1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PlayerActivity$provideCallChanges$1.invokeSuspend$lambda$4$lambda$1(PlayerActivity.this, view);
                            }
                        });
                    } else if (Intrinsics.areEqual(callState, CallState.Accepted.INSTANCE)) {
                        FloatingActionButton btnAcceptCall3 = binding.btnAcceptCall;
                        Intrinsics.checkNotNullExpressionValue(btnAcceptCall3, "btnAcceptCall");
                        btnAcceptCall3.setVisibility(8);
                        FloatingActionButton btnEndCall3 = binding.btnEndCall;
                        Intrinsics.checkNotNullExpressionValue(btnEndCall3, "btnEndCall");
                        btnEndCall3.setVisibility(0);
                        FloatingActionButton btnMic3 = binding.btnMic;
                        Intrinsics.checkNotNullExpressionValue(btnMic3, "btnMic");
                        btnMic3.setVisibility(0);
                        binding.btnOpenIntercom.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$1$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PlayerActivity$provideCallChanges$1.invokeSuspend$lambda$4$lambda$2(PlayerActivity.this, view);
                            }
                        });
                        binding.btnEndCall.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideCallChanges$1$$ExternalSyntheticLambda3
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PlayerActivity$provideCallChanges$1.invokeSuspend$lambda$4$lambda$3(PlayerActivity.this, view);
                            }
                        });
                        hardwareManager3 = playerActivity.hardwareManager;
                        if (hardwareManager3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hardwareManager");
                            hardwareManager3 = null;
                        }
                        hardwareManager3.start();
                        exoPlayer = playerActivity.streamPlayer;
                        if (exoPlayer != null) {
                            exoPlayer.setVolume(0.0f);
                        }
                        viewModel6 = playerActivity.getViewModel();
                        if (viewModel6.isMicEnabled().getValue() == null) {
                            activityResultLauncher = playerActivity.callPermissionsResultReceiver;
                            if (activityResultLauncher == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("callPermissionsResultReceiver");
                            } else {
                                activityResultLauncher2 = activityResultLauncher;
                            }
                            activityResultLauncher2.launch(new String[]{"android.permission.RECORD_AUDIO", "android.permission.CAMERA"});
                        }
                    } else if (Intrinsics.areEqual(callState, CallState.Ended.INSTANCE)) {
                        hardwareManager2 = playerActivity.hardwareManager;
                        if (hardwareManager2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hardwareManager");
                        } else {
                            hardwareManager7 = hardwareManager2;
                        }
                        hardwareManager7.stop();
                        viewModel4 = playerActivity.getViewModel();
                        playerActivity.setStreamCrop(viewModel4.isVideoZoomed().getValue());
                        viewModel5 = playerActivity.getViewModel();
                        if (Intrinsics.areEqual(viewModel5.getScreenState().getValue(), PlayerViewModel.PlayerState.Call.INSTANCE)) {
                            playerActivity.finish();
                        }
                    } else if (Intrinsics.areEqual(callState, CallState.Released.INSTANCE)) {
                        hardwareManager = playerActivity.hardwareManager;
                        if (hardwareManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("hardwareManager");
                        } else {
                            hardwareManager5 = hardwareManager;
                        }
                        hardwareManager5.stop();
                        viewModel3 = playerActivity.getViewModel();
                        if (Intrinsics.areEqual(viewModel3.getScreenState().getValue(), PlayerViewModel.PlayerState.Call.INSTANCE)) {
                            playerActivity.finish();
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4$lambda$0(PlayerActivity playerActivity, View view) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        CallService callService;
        SipManager sipManager;
        viewModel = playerActivity.getViewModel();
        viewModel.reportEvent(22);
        viewModel2 = playerActivity.getViewModel();
        viewModel2.onOpenGateClick();
        callService = playerActivity.callService;
        if (callService == null || (sipManager = callService.getSipManager()) == null) {
            return;
        }
        sipManager.acceptCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4$lambda$1(PlayerActivity playerActivity, View view) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        viewModel = playerActivity.getViewModel();
        viewModel.reportEvent(21);
        viewModel2 = playerActivity.getViewModel();
        viewModel2.onEndCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4$lambda$2(PlayerActivity playerActivity, View view) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        viewModel = playerActivity.getViewModel();
        viewModel.reportEvent(23);
        viewModel2 = playerActivity.getViewModel();
        viewModel2.onOpenGateClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$4$lambda$3(PlayerActivity playerActivity, View view) {
        PlayerViewModel viewModel;
        viewModel = playerActivity.getViewModel();
        viewModel.onEndCall();
    }
}
