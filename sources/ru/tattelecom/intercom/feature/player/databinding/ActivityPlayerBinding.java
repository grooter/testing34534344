package ru.tattelecom.intercom.feature.player.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.slider.Slider;
import org.linphone.mediastream.video.capture.CaptureTextureView;
import ru.tattelecom.intercom.feature.player.R;

/* loaded from: classes7.dex */
public final class ActivityPlayerBinding implements ViewBinding {
    public final View bottomEmptySpace;
    public final FloatingActionButton btnAcceptCall;
    public final MaterialButton btnCancel;
    public final FloatingActionButton btnEndCall;
    public final ImageView btnForward;
    public final ImageView btnFullscreen;
    public final FloatingActionButton btnMic;
    public final FloatingActionButton btnOpenIntercom;
    public final ImageView btnPlay;
    public final MaterialButton btnRefreshStream;
    public final ImageView btnRewind;
    public final ImageView btnToolbarBack;
    public final ImageView btnToolbarDownload;
    public final ChipGroup cgDays;
    public final Chip chDayFive;
    public final Chip chDayFour;
    public final Chip chDayOne;
    public final Chip chDaySeven;
    public final Chip chDaySix;
    public final Chip chDayThree;
    public final Chip chDayTwo;
    public final Chip chLive;
    public final ConstraintLayout clCallButtons;
    public final ConstraintLayout clPlayerControls;
    public final View flRoot;
    public final HorizontalScrollView hsDays;
    public final LinearLayout llDownloadProgress;
    public final LinearLayout llVideoError;
    public final ProgressBar pbDownload;
    public final ProgressBar pbPrepareDownload;
    public final ProgressBar progressIntercomOpening;
    public final ProgressBar progressVideoLoading;
    private final View rootView;
    public final Slider slHour;
    public final Slider slMinutes;
    public final Slider slSeconds;
    public final TextView toolbar;
    public final View topEmptySpace;
    public final TextView tvDownloadProgress;
    public final TextView tvEndHoursHint;
    public final TextView tvEndMinutesHint;
    public final CaptureTextureView tvSipPreview;
    public final CaptureTextureView tvSipVideo;
    public final TextView tvStartHoursHint;
    public final TextView tvStartMinutesHint;
    public final TextView tvTime;
    public final PlayerView vvStream;

    private ActivityPlayerBinding(View view, View view2, FloatingActionButton floatingActionButton, MaterialButton materialButton, FloatingActionButton floatingActionButton2, ImageView imageView, ImageView imageView2, FloatingActionButton floatingActionButton3, FloatingActionButton floatingActionButton4, ImageView imageView3, MaterialButton materialButton2, ImageView imageView4, ImageView imageView5, ImageView imageView6, ChipGroup chipGroup, Chip chip, Chip chip2, Chip chip3, Chip chip4, Chip chip5, Chip chip6, Chip chip7, Chip chip8, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view3, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, ProgressBar progressBar2, ProgressBar progressBar3, ProgressBar progressBar4, Slider slider, Slider slider2, Slider slider3, TextView textView, View view4, TextView textView2, TextView textView3, TextView textView4, CaptureTextureView captureTextureView, CaptureTextureView captureTextureView2, TextView textView5, TextView textView6, TextView textView7, PlayerView playerView) {
        this.rootView = view;
        this.bottomEmptySpace = view2;
        this.btnAcceptCall = floatingActionButton;
        this.btnCancel = materialButton;
        this.btnEndCall = floatingActionButton2;
        this.btnForward = imageView;
        this.btnFullscreen = imageView2;
        this.btnMic = floatingActionButton3;
        this.btnOpenIntercom = floatingActionButton4;
        this.btnPlay = imageView3;
        this.btnRefreshStream = materialButton2;
        this.btnRewind = imageView4;
        this.btnToolbarBack = imageView5;
        this.btnToolbarDownload = imageView6;
        this.cgDays = chipGroup;
        this.chDayFive = chip;
        this.chDayFour = chip2;
        this.chDayOne = chip3;
        this.chDaySeven = chip4;
        this.chDaySix = chip5;
        this.chDayThree = chip6;
        this.chDayTwo = chip7;
        this.chLive = chip8;
        this.clCallButtons = constraintLayout;
        this.clPlayerControls = constraintLayout2;
        this.flRoot = view3;
        this.hsDays = horizontalScrollView;
        this.llDownloadProgress = linearLayout;
        this.llVideoError = linearLayout2;
        this.pbDownload = progressBar;
        this.pbPrepareDownload = progressBar2;
        this.progressIntercomOpening = progressBar3;
        this.progressVideoLoading = progressBar4;
        this.slHour = slider;
        this.slMinutes = slider2;
        this.slSeconds = slider3;
        this.toolbar = textView;
        this.topEmptySpace = view4;
        this.tvDownloadProgress = textView2;
        this.tvEndHoursHint = textView3;
        this.tvEndMinutesHint = textView4;
        this.tvSipPreview = captureTextureView;
        this.tvSipVideo = captureTextureView2;
        this.tvStartHoursHint = textView5;
        this.tvStartMinutesHint = textView6;
        this.tvTime = textView7;
        this.vvStream = playerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ActivityPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_player, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityPlayerBinding bind(View view) {
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.bottom_empty_space);
        int i = R.id.btn_accept_call;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
        if (floatingActionButton != null) {
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, R.id.btnCancel);
            i = R.id.btn_end_call;
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
            if (floatingActionButton2 != null) {
                i = R.id.btn_forward;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.btn_fullscreen;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.btn_mic;
                        FloatingActionButton floatingActionButton3 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                        if (floatingActionButton3 != null) {
                            i = R.id.btn_open_intercom;
                            FloatingActionButton floatingActionButton4 = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                            if (floatingActionButton4 != null) {
                                i = R.id.btn_play;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.btn_refresh_stream;
                                    MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(view, i);
                                    if (materialButton2 != null) {
                                        i = R.id.btn_rewind;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, R.id.btnToolbarBack);
                                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, R.id.btnToolbarDownload);
                                            i = R.id.cg_days;
                                            ChipGroup chipGroup = (ChipGroup) ViewBindings.findChildViewById(view, i);
                                            if (chipGroup != null) {
                                                i = R.id.ch_day_five;
                                                Chip chip = (Chip) ViewBindings.findChildViewById(view, i);
                                                if (chip != null) {
                                                    i = R.id.ch_day_four;
                                                    Chip chip2 = (Chip) ViewBindings.findChildViewById(view, i);
                                                    if (chip2 != null) {
                                                        i = R.id.ch_day_one;
                                                        Chip chip3 = (Chip) ViewBindings.findChildViewById(view, i);
                                                        if (chip3 != null) {
                                                            i = R.id.ch_day_seven;
                                                            Chip chip4 = (Chip) ViewBindings.findChildViewById(view, i);
                                                            if (chip4 != null) {
                                                                i = R.id.ch_day_six;
                                                                Chip chip5 = (Chip) ViewBindings.findChildViewById(view, i);
                                                                if (chip5 != null) {
                                                                    i = R.id.ch_day_three;
                                                                    Chip chip6 = (Chip) ViewBindings.findChildViewById(view, i);
                                                                    if (chip6 != null) {
                                                                        i = R.id.ch_day_two;
                                                                        Chip chip7 = (Chip) ViewBindings.findChildViewById(view, i);
                                                                        if (chip7 != null) {
                                                                            i = R.id.ch_live;
                                                                            Chip chip8 = (Chip) ViewBindings.findChildViewById(view, i);
                                                                            if (chip8 != null) {
                                                                                i = R.id.cl_call_buttons;
                                                                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (constraintLayout != null) {
                                                                                    i = R.id.cl_player_controls;
                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout2 != null) {
                                                                                        i = R.id.hs_days;
                                                                                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, i);
                                                                                        if (horizontalScrollView != null) {
                                                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.llDownloadProgress);
                                                                                            i = R.id.ll_video_error;
                                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                            if (linearLayout2 != null) {
                                                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pbDownload);
                                                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.pbPrepareDownload);
                                                                                                i = R.id.progress_intercom_opening;
                                                                                                ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                if (progressBar3 != null) {
                                                                                                    i = R.id.progress_video_loading;
                                                                                                    ProgressBar progressBar4 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                                                    if (progressBar4 != null) {
                                                                                                        Slider slider = (Slider) ViewBindings.findChildViewById(view, R.id.sl_hour);
                                                                                                        Slider slider2 = (Slider) ViewBindings.findChildViewById(view, R.id.sl_minutes);
                                                                                                        i = R.id.sl_seconds;
                                                                                                        Slider slider3 = (Slider) ViewBindings.findChildViewById(view, i);
                                                                                                        if (slider3 != null) {
                                                                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                                            View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.top_empty_space);
                                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvDownloadProgress);
                                                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_end_hours_hint);
                                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_end_minutes_hint);
                                                                                                            i = R.id.tv_sip_preview;
                                                                                                            CaptureTextureView captureTextureView = (CaptureTextureView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (captureTextureView != null) {
                                                                                                                i = R.id.tv_sip_video;
                                                                                                                CaptureTextureView captureTextureView2 = (CaptureTextureView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (captureTextureView2 != null) {
                                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_start_hours_hint);
                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.tv_start_minutes_hint);
                                                                                                                    i = R.id.tv_time;
                                                                                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView7 != null) {
                                                                                                                        i = R.id.vv_stream;
                                                                                                                        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (playerView != null) {
                                                                                                                            return new ActivityPlayerBinding(view, findChildViewById, floatingActionButton, materialButton, floatingActionButton2, imageView, imageView2, floatingActionButton3, floatingActionButton4, imageView3, materialButton2, imageView4, imageView5, imageView6, chipGroup, chip, chip2, chip3, chip4, chip5, chip6, chip7, chip8, constraintLayout, constraintLayout2, view, horizontalScrollView, linearLayout, linearLayout2, progressBar, progressBar2, progressBar3, progressBar4, slider, slider2, slider3, textView, findChildViewById2, textView2, textView3, textView4, captureTextureView, captureTextureView2, textView5, textView6, textView7, playerView);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
