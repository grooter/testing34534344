package ru.tattelecom.intercom.feature.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ru.tattelecom.intercom.feature.home.R;

/* loaded from: classes6.dex */
public final class ItemStreamBinding implements ViewBinding {
    public final MaterialButton btnGenerateTemporaryCode;
    public final ImageView btnNotification;
    public final FloatingActionButton btnOpenDoor;
    public final ImageButton btnShareCode;
    public final ConstraintLayout clFavorite;
    public final MaterialCardView cvStream;
    public final FrameLayout flRoot;
    public final ImageView ivHeart;
    public final ImageView ivHeartSelected;
    public final ImageView ivSnapshot;
    public final ProgressBar progressCodeLoading;
    public final ProgressBar progressIntercomOpening;
    private final FrameLayout rootView;
    public final TextView tvArchive;
    public final TextView tvDescription;
    public final TextView tvTimeCode;
    public final View viewFooterBottom;
    public final View viewFooterTop;

    private ItemStreamBinding(FrameLayout frameLayout, MaterialButton materialButton, ImageView imageView, FloatingActionButton floatingActionButton, ImageButton imageButton, ConstraintLayout constraintLayout, MaterialCardView materialCardView, FrameLayout frameLayout2, ImageView imageView2, ImageView imageView3, ImageView imageView4, ProgressBar progressBar, ProgressBar progressBar2, TextView textView, TextView textView2, TextView textView3, View view, View view2) {
        this.rootView = frameLayout;
        this.btnGenerateTemporaryCode = materialButton;
        this.btnNotification = imageView;
        this.btnOpenDoor = floatingActionButton;
        this.btnShareCode = imageButton;
        this.clFavorite = constraintLayout;
        this.cvStream = materialCardView;
        this.flRoot = frameLayout2;
        this.ivHeart = imageView2;
        this.ivHeartSelected = imageView3;
        this.ivSnapshot = imageView4;
        this.progressCodeLoading = progressBar;
        this.progressIntercomOpening = progressBar2;
        this.tvArchive = textView;
        this.tvDescription = textView2;
        this.tvTimeCode = textView3;
        this.viewFooterBottom = view;
        this.viewFooterTop = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemStreamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemStreamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_stream, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemStreamBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.btn_generate_temporary_code;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_notification;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btn_open_door;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
                if (floatingActionButton != null) {
                    i = R.id.btn_share_code;
                    ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
                    if (imageButton != null) {
                        i = R.id.cl_favorite;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout != null) {
                            i = R.id.cv_stream;
                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                            if (materialCardView != null) {
                                FrameLayout frameLayout = (FrameLayout) view;
                                i = R.id.iv_heart;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.iv_heart_selected;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView3 != null) {
                                        i = R.id.iv_snapshot;
                                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView4 != null) {
                                            i = R.id.progress_code_loading;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                            if (progressBar != null) {
                                                i = R.id.progress_intercom_opening;
                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                if (progressBar2 != null) {
                                                    i = R.id.tv_archive;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView != null) {
                                                        i = R.id.tv_description;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView2 != null) {
                                                            i = R.id.tv_time_code;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_footer_bottom))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_footer_top))) != null) {
                                                                return new ItemStreamBinding(frameLayout, materialButton, imageView, floatingActionButton, imageButton, constraintLayout, materialCardView, frameLayout, imageView2, imageView3, imageView4, progressBar, progressBar2, textView, textView2, textView3, findChildViewById, findChildViewById2);
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
