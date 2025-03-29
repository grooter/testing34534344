package ru.tattelecom.intercom.feature.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import ru.tattelecom.intercom.feature.home.R;

/* loaded from: classes6.dex */
public final class ItemReaderBinding implements ViewBinding {
    public final FloatingActionButton btnOpenDoor;
    public final ConstraintLayout clFavorite;
    public final MaterialCardView cvStream;
    public final FrameLayout flRoot;
    public final ImageView ivHeart;
    public final ImageView ivHeartSelected;
    public final ProgressBar progressIntercomOpening;
    private final FrameLayout rootView;
    public final TextView tvDescription;

    private ItemReaderBinding(FrameLayout frameLayout, FloatingActionButton floatingActionButton, ConstraintLayout constraintLayout, MaterialCardView materialCardView, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, ProgressBar progressBar, TextView textView) {
        this.rootView = frameLayout;
        this.btnOpenDoor = floatingActionButton;
        this.clFavorite = constraintLayout;
        this.cvStream = materialCardView;
        this.flRoot = frameLayout2;
        this.ivHeart = imageView;
        this.ivHeartSelected = imageView2;
        this.progressIntercomOpening = progressBar;
        this.tvDescription = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemReaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemReaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_reader, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemReaderBinding bind(View view) {
        int i = R.id.btn_open_door;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, i);
        if (floatingActionButton != null) {
            i = R.id.cl_favorite;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout != null) {
                i = R.id.cv_stream;
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, i);
                if (materialCardView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.iv_heart;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.iv_heart_selected;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.progress_intercom_opening;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = R.id.tv_description;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new ItemReaderBinding(frameLayout, floatingActionButton, constraintLayout, materialCardView, frameLayout, imageView, imageView2, progressBar, textView);
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
