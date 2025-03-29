package ru.tattelecom.intercom.feature.videoplayer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.doubleTapView.DoubleTapView;
import ru.tattelecom.intercom.feature.videoplayer.timelineView.VideoTimeBar;

/* loaded from: classes8.dex */
public final class FragmentVideoPlayerBinding implements ViewBinding {
    public final ImageView btnDownload;
    public final ImageView btnFastForward;
    public final MaterialButton btnFavorite;
    public final ImageView btnFullscreen;
    public final FloatingActionButton btnOpenDoor;
    public final ImageView btnPlaybackSpeed;
    public final ImageView btnPlayerPause;
    public final ImageView btnPlayerStart;
    public final Button btnRefreshStream;
    public final ImageView btnRewind;
    public final ImageView btnScreenshot;
    public final ImageView btnVolume;
    public final ChipGroup cgDays;
    public final Chip chDayFive;
    public final Chip chDayFour;
    public final Chip chDayOne;
    public final Chip chDaySeven;
    public final Chip chDaySix;
    public final Chip chDayThree;
    public final Chip chDayTwo;
    public final Chip chipDate;
    public final Chip chipLive;
    public final ConstraintLayout clControl;
    public final ConstraintLayout clMenu;
    public final ConstraintLayout clRoot;
    public final ConstraintLayout clVideoControl;
    public final DoubleTapView doubleTapView;
    public final FrameLayout flPlayerView;
    public final Guideline guideline;
    public final Guideline guideline2;
    public final HorizontalScrollView hsDays;
    public final ImageView ivDownload;
    public final ImageView ivFavorite;
    public final LinearLayout llVideoError;
    public final PlayerView playerView;
    public final AspectRatioFrameLayout playerViewContainer;
    public final ProgressBar progressView;
    private final ConstraintLayout rootView;
    public final RecyclerView rvEvents;
    public final VideoTimeBar timeBar;
    public final MaterialToolbar toolbar;
    public final TextView tvCursorTime;
    public final TextView tvEvents;
    public final TextView tvEventsEmpty;
    public final TextView tvScaleFactor;

    private FragmentVideoPlayerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, MaterialButton materialButton, ImageView imageView3, FloatingActionButton floatingActionButton, ImageView imageView4, ImageView imageView5, ImageView imageView6, Button button, ImageView imageView7, ImageView imageView8, ImageView imageView9, ChipGroup chipGroup, Chip chip, Chip chip2, Chip chip3, Chip chip4, Chip chip5, Chip chip6, Chip chip7, Chip chip8, Chip chip9, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, DoubleTapView doubleTapView, FrameLayout frameLayout, Guideline guideline, Guideline guideline2, HorizontalScrollView horizontalScrollView, ImageView imageView10, ImageView imageView11, LinearLayout linearLayout, PlayerView playerView, AspectRatioFrameLayout aspectRatioFrameLayout, ProgressBar progressBar, RecyclerView recyclerView, VideoTimeBar videoTimeBar, MaterialToolbar materialToolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.btnDownload = imageView;
        this.btnFastForward = imageView2;
        this.btnFavorite = materialButton;
        this.btnFullscreen = imageView3;
        this.btnOpenDoor = floatingActionButton;
        this.btnPlaybackSpeed = imageView4;
        this.btnPlayerPause = imageView5;
        this.btnPlayerStart = imageView6;
        this.btnRefreshStream = button;
        this.btnRewind = imageView7;
        this.btnScreenshot = imageView8;
        this.btnVolume = imageView9;
        this.cgDays = chipGroup;
        this.chDayFive = chip;
        this.chDayFour = chip2;
        this.chDayOne = chip3;
        this.chDaySeven = chip4;
        this.chDaySix = chip5;
        this.chDayThree = chip6;
        this.chDayTwo = chip7;
        this.chipDate = chip8;
        this.chipLive = chip9;
        this.clControl = constraintLayout2;
        this.clMenu = constraintLayout3;
        this.clRoot = constraintLayout4;
        this.clVideoControl = constraintLayout5;
        this.doubleTapView = doubleTapView;
        this.flPlayerView = frameLayout;
        this.guideline = guideline;
        this.guideline2 = guideline2;
        this.hsDays = horizontalScrollView;
        this.ivDownload = imageView10;
        this.ivFavorite = imageView11;
        this.llVideoError = linearLayout;
        this.playerView = playerView;
        this.playerViewContainer = aspectRatioFrameLayout;
        this.progressView = progressBar;
        this.rvEvents = recyclerView;
        this.timeBar = videoTimeBar;
        this.toolbar = materialToolbar;
        this.tvCursorTime = textView;
        this.tvEvents = textView2;
        this.tvEventsEmpty = textView3;
        this.tvScaleFactor = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVideoPlayerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVideoPlayerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_video_player, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentVideoPlayerBinding bind(View view) {
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.btnDownload);
        int i = R.id.btnFastForward;
        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView2 != null) {
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, R.id.btnFavorite);
            i = R.id.btnFullscreen;
            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView3 != null) {
                i = R.id.btnOpenDoor;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                if (floatingActionButton != null) {
                    i = R.id.btnPlaybackSpeed;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.btnPlayerPause;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.btnPlayerStart;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.btnRefreshStream;
                                Button button = (Button) ViewBindings.findChildViewById(view, i);
                                if (button != null) {
                                    i = R.id.btnRewind;
                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView7 != null) {
                                        i = R.id.btnScreenshot;
                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView8 != null) {
                                            i = R.id.btnVolume;
                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView9 != null) {
                                                ChipGroup chipGroup = (ChipGroup) ViewBindings.findChildViewById(view, R.id.cgDays);
                                                Chip chip = (Chip) ViewBindings.findChildViewById(view, R.id.chDayFive);
                                                Chip chip2 = (Chip) ViewBindings.findChildViewById(view, R.id.chDayFour);
                                                Chip chip3 = (Chip) ViewBindings.findChildViewById(view, R.id.chDayOne);
                                                Chip chip4 = (Chip) ViewBindings.findChildViewById(view, R.id.chDaySeven);
                                                Chip chip5 = (Chip) ViewBindings.findChildViewById(view, R.id.chDaySix);
                                                Chip chip6 = (Chip) ViewBindings.findChildViewById(view, R.id.chDayThree);
                                                Chip chip7 = (Chip) ViewBindings.findChildViewById(view, R.id.chDayTwo);
                                                Chip chip8 = (Chip) ViewBindings.findChildViewById(view, R.id.chipDate);
                                                i = R.id.chipLive;
                                                Chip chip9 = (Chip) ViewBindings.findChildViewById(view, i);
                                                if (chip9 != null) {
                                                    i = R.id.clControl;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                    if (constraintLayout != null) {
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.clMenu);
                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.clVideoControl);
                                                        i = R.id.doubleTapView;
                                                        DoubleTapView doubleTapView = (DoubleTapView) ViewBindings.findChildViewById(view, i);
                                                        if (doubleTapView != null) {
                                                            i = R.id.flPlayerView;
                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                            if (frameLayout != null) {
                                                                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, R.id.guideline);
                                                                i = R.id.guideline2;
                                                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                if (guideline2 != null) {
                                                                    HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(view, R.id.hsDays);
                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivDownload);
                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view, R.id.ivFavorite);
                                                                    i = R.id.llVideoError;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout != null) {
                                                                        i = R.id.playerView;
                                                                        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i);
                                                                        if (playerView != null) {
                                                                            AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) ViewBindings.findChildViewById(view, R.id.playerViewContainer);
                                                                            i = R.id.progressView;
                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                                            if (progressBar != null) {
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.rvEvents);
                                                                                i = R.id.timeBar;
                                                                                VideoTimeBar videoTimeBar = (VideoTimeBar) ViewBindings.findChildViewById(view, i);
                                                                                if (videoTimeBar != null) {
                                                                                    MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                                    i = R.id.tvCursorTime;
                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView != null) {
                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.tvEvents);
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.tvEventsEmpty);
                                                                                        i = R.id.tvScaleFactor;
                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView4 != null) {
                                                                                            return new FragmentVideoPlayerBinding(constraintLayout3, imageView, imageView2, materialButton, imageView3, floatingActionButton, imageView4, imageView5, imageView6, button, imageView7, imageView8, imageView9, chipGroup, chip, chip2, chip3, chip4, chip5, chip6, chip7, chip8, chip9, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, doubleTapView, frameLayout, guideline, guideline2, horizontalScrollView, imageView10, imageView11, linearLayout, playerView, aspectRatioFrameLayout, progressBar, recyclerView, videoTimeBar, materialToolbar, textView, textView2, textView3, textView4);
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
