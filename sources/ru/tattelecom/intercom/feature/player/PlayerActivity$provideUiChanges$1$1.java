package ru.tattelecom.intercom.feature.player;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.Slider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.tattelecom.intercom.data.helper.ApartmentServiceName;
import ru.tattelecom.intercom.feature.call.CallService;
import ru.tattelecom.intercom.feature.call.SipManager;
import ru.tattelecom.intercom.feature.player.PlayerViewModel;
import ru.tattelecom.intercom.feature.player.databinding.ActivityPlayerBinding;
import ru.tattelecom.intercom.feature.player.downloadArchive.VideoDownloadDialogFragment;

/* compiled from: PlayerActivity.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lru/tattelecom/intercom/feature/player/PlayerViewModel$PlayerState;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes7.dex */
final class PlayerActivity$provideUiChanges$1$1 extends Lambda implements Function1<PlayerViewModel.PlayerState, Unit> {
    final /* synthetic */ PlayerViewModel $this_with;
    final /* synthetic */ PlayerActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PlayerActivity$provideUiChanges$1$1(PlayerActivity playerActivity, PlayerViewModel playerViewModel) {
        super(1);
        this.this$0 = playerActivity;
        this.$this_with = playerViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayerViewModel.PlayerState playerState) {
        invoke2(playerState);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayerViewModel.PlayerState playerState) {
        ActivityPlayerBinding binding;
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        boolean currentOrientationLandscape;
        PlayerViewModel viewModel3;
        PlayerViewModel viewModel4;
        boolean currentOrientationLandscape2;
        PlayerViewModel viewModel5;
        PlayerViewModel viewModel6;
        binding = this.this$0.getBinding();
        final PlayerActivity playerActivity = this.this$0;
        final PlayerViewModel playerViewModel = this.$this_with;
        if (Intrinsics.areEqual(playerState, PlayerViewModel.PlayerState.Call.INSTANCE)) {
            playerActivity.setOpenActivityOnLockScreen();
            ChipGroup cgDays = binding.cgDays;
            Intrinsics.checkNotNullExpressionValue(cgDays, "cgDays");
            cgDays.setVisibility(8);
            ConstraintLayout clPlayerControls = binding.clPlayerControls;
            Intrinsics.checkNotNullExpressionValue(clPlayerControls, "clPlayerControls");
            clPlayerControls.setVisibility(8);
            LinearLayout linearLayout = binding.llDownloadProgress;
            if (linearLayout != null) {
                Intrinsics.checkNotNull(linearLayout);
                linearLayout.setVisibility(8);
            }
            TextView textView = binding.toolbar;
            if (textView != null) {
                Intrinsics.checkNotNull(textView);
                textView.setVisibility(8);
            }
            playerActivity.setVolumeControlStream(0);
            binding.btnAcceptCall.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$0(PlayerActivity.this, view);
                }
            });
            return;
        }
        if (Intrinsics.areEqual(playerState, PlayerViewModel.PlayerState.IntercomArchive.INSTANCE)) {
            playerActivity.archiveDaysSetOnClickListener(PlayerViewModel.PlayerState.IntercomArchive.INSTANCE);
            Slider slSeconds = binding.slSeconds;
            Intrinsics.checkNotNullExpressionValue(slSeconds, "slSeconds");
            Slider slider = slSeconds;
            currentOrientationLandscape2 = playerActivity.currentOrientationLandscape();
            slider.setVisibility(currentOrientationLandscape2 ? 0 : 8);
            binding.btnAcceptCall.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$1(PlayerActivity.this, playerViewModel, view);
                }
            });
            binding.btnOpenIntercom.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$2(PlayerActivity.this, view);
                }
            });
            TextView textView2 = binding.toolbar;
            if (textView2 != null) {
                viewModel6 = playerActivity.getViewModel();
                textView2.setText(viewModel6.getDescription());
                textView2.setSelected(true);
            }
            ImageView imageView = binding.btnToolbarDownload;
            if (imageView != null) {
                viewModel5 = playerActivity.getViewModel();
                if (viewModel5.getStreamDownloadService()) {
                    imageView.setAlpha(1.0f);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$6$lambda$4(PlayerActivity.this, view);
                        }
                    });
                } else {
                    imageView.setAlpha(0.5f);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$6$lambda$5(PlayerActivity.this, view);
                        }
                    });
                }
            }
            playerActivity.pickDownloadState();
            return;
        }
        if (Intrinsics.areEqual(playerState, PlayerViewModel.PlayerState.CameraArchive.INSTANCE)) {
            playerActivity.archiveDaysSetOnClickListener(PlayerViewModel.PlayerState.CameraArchive.INSTANCE);
            ImageView btnRewind = binding.btnRewind;
            Intrinsics.checkNotNullExpressionValue(btnRewind, "btnRewind");
            ImageView imageView2 = btnRewind;
            viewModel = playerActivity.getViewModel();
            imageView2.setVisibility(viewModel.getIsFlussonic() ? 0 : 8);
            ImageView btnForward = binding.btnForward;
            Intrinsics.checkNotNullExpressionValue(btnForward, "btnForward");
            ImageView imageView3 = btnForward;
            viewModel2 = playerActivity.getViewModel();
            imageView3.setVisibility(viewModel2.getIsFlussonic() ? 0 : 8);
            ConstraintLayout clCallButtons = binding.clCallButtons;
            Intrinsics.checkNotNullExpressionValue(clCallButtons, "clCallButtons");
            clCallButtons.setVisibility(8);
            Slider slSeconds2 = binding.slSeconds;
            Intrinsics.checkNotNullExpressionValue(slSeconds2, "slSeconds");
            Slider slider2 = slSeconds2;
            currentOrientationLandscape = playerActivity.currentOrientationLandscape();
            slider2.setVisibility(currentOrientationLandscape ? 0 : 8);
            TextView textView3 = binding.toolbar;
            if (textView3 != null) {
                viewModel4 = playerActivity.getViewModel();
                textView3.setText(viewModel4.getDescription());
                textView3.setSelected(true);
            }
            ChipGroup cgDays2 = binding.cgDays;
            Intrinsics.checkNotNullExpressionValue(cgDays2, "cgDays");
            cgDays2.setVisibility(0);
            ImageView imageView4 = binding.btnToolbarDownload;
            if (imageView4 != null) {
                viewModel3 = playerActivity.getViewModel();
                if (viewModel3.getStreamDownloadService()) {
                    imageView4.setAlpha(1.0f);
                    imageView4.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda5
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$10$lambda$8(PlayerActivity.this, view);
                        }
                    });
                } else {
                    imageView4.setAlpha(0.5f);
                    imageView4.setOnClickListener(new View.OnClickListener() { // from class: ru.tattelecom.intercom.feature.player.PlayerActivity$provideUiChanges$1$1$$ExternalSyntheticLambda6
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            PlayerActivity$provideUiChanges$1$1.invoke$lambda$11$lambda$10$lambda$9(PlayerActivity.this, view);
                        }
                    });
                }
            }
            playerActivity.pickDownloadState();
            return;
        }
        if (Intrinsics.areEqual(playerState, PlayerViewModel.PlayerState.CallArchive.INSTANCE)) {
            ChipGroup cgDays3 = binding.cgDays;
            Intrinsics.checkNotNullExpressionValue(cgDays3, "cgDays");
            cgDays3.setVisibility(8);
            Slider slider3 = binding.slHour;
            if (slider3 != null) {
                Intrinsics.checkNotNull(slider3);
                slider3.setVisibility(8);
            }
            ImageView btnRewind2 = binding.btnRewind;
            Intrinsics.checkNotNullExpressionValue(btnRewind2, "btnRewind");
            btnRewind2.setVisibility(8);
            ImageView btnForward2 = binding.btnForward;
            Intrinsics.checkNotNullExpressionValue(btnForward2, "btnForward");
            btnForward2.setVisibility(8);
            Slider slider4 = binding.slMinutes;
            if (slider4 != null) {
                Intrinsics.checkNotNull(slider4);
                slider4.setVisibility(8);
            }
            ConstraintLayout clCallButtons2 = binding.clCallButtons;
            Intrinsics.checkNotNullExpressionValue(clCallButtons2, "clCallButtons");
            clCallButtons2.setVisibility(8);
            ConstraintLayout clPlayerControls2 = binding.clPlayerControls;
            Intrinsics.checkNotNullExpressionValue(clPlayerControls2, "clPlayerControls");
            clPlayerControls2.setVisibility(0);
            TextView textView4 = binding.tvEndHoursHint;
            if (textView4 != null) {
                Intrinsics.checkNotNull(textView4);
                textView4.setVisibility(8);
            }
            TextView textView5 = binding.tvStartHoursHint;
            if (textView5 != null) {
                Intrinsics.checkNotNull(textView5);
                textView5.setVisibility(8);
            }
            TextView textView6 = binding.tvEndMinutesHint;
            if (textView6 != null) {
                Intrinsics.checkNotNull(textView6);
                textView6.setVisibility(8);
            }
            TextView textView7 = binding.tvStartMinutesHint;
            if (textView7 != null) {
                Intrinsics.checkNotNull(textView7);
                textView7.setVisibility(8);
            }
            LinearLayout linearLayout2 = binding.llDownloadProgress;
            if (linearLayout2 != null) {
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.setVisibility(8);
            }
            TextView textView8 = binding.toolbar;
            if (textView8 == null) {
                return;
            }
            Intrinsics.checkNotNull(textView8);
            textView8.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$0(PlayerActivity this$0, View view) {
        PlayerViewModel viewModel;
        CallService callService;
        SipManager sipManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewModel = this$0.getViewModel();
        viewModel.reportEvent(20);
        callService = this$0.callService;
        if (callService == null || (sipManager = callService.getSipManager()) == null) {
            return;
        }
        sipManager.acceptCall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$1(PlayerActivity this$0, PlayerViewModel this_with, View view) {
        CallService callService;
        SipManager sipManager;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        callService = this$0.callService;
        if (callService == null || (sipManager = callService.getSipManager()) == null) {
            return;
        }
        sipManager.makeCall(this_with.getIntercomLogin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$2(PlayerActivity this$0, View view) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewModel = this$0.getViewModel();
        viewModel.reportEvent(15);
        viewModel2 = this$0.getViewModel();
        viewModel2.onOpenGateClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$6$lambda$4(PlayerActivity this$0, View view) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewModel = this$0.getViewModel();
        viewModel.onStreamPause();
        viewModel2 = this$0.getViewModel();
        this$0.startVideoDialogFragment(VideoDownloadDialogFragment.AVAILABLE_DAYS, Integer.valueOf(viewModel2.getStreamArchiveService()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$6$lambda$5(PlayerActivity this$0, View view) {
        PlayerViewModel viewModel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewModel = this$0.getViewModel();
        viewModel.reportEvent(38);
        this$0.showAttentionCustomSnackBar(R.string.need_internet_subscription, ApartmentServiceName.VIDEO_DOWNLOAD_ABILITY, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$10$lambda$8(PlayerActivity this$0, View view) {
        PlayerViewModel viewModel;
        PlayerViewModel viewModel2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewModel = this$0.getViewModel();
        viewModel.onStreamPause();
        viewModel2 = this$0.getViewModel();
        this$0.startVideoDialogFragment(VideoDownloadDialogFragment.AVAILABLE_DAYS, Integer.valueOf(viewModel2.getStreamArchiveService()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$11$lambda$10$lambda$9(PlayerActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showAttentionCustomSnackBar(R.string.need_internet_subscription, ApartmentServiceName.VIDEO_DOWNLOAD_ABILITY, false);
    }
}
