package ru.tattelecom.intercom.feature.videoplayer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import ru.tattelecom.intercom.feature.videoplayer.R;

/* loaded from: classes8.dex */
public final class ItemPlayerEventBinding implements ViewBinding {
    public final ImageView btnDownload;
    public final ImageView btnRefresh;
    public final ConstraintLayout clRoot;
    public final FrameLayout flDownload;
    public final ImageView ivEventIcon;
    public final LinearLayout llEvent;
    public final CircularProgressIndicator progress;
    private final ConstraintLayout rootView;
    public final TextView tvTime;

    private ItemPlayerEventBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, FrameLayout frameLayout, ImageView imageView3, LinearLayout linearLayout, CircularProgressIndicator circularProgressIndicator, TextView textView) {
        this.rootView = constraintLayout;
        this.btnDownload = imageView;
        this.btnRefresh = imageView2;
        this.clRoot = constraintLayout2;
        this.flDownload = frameLayout;
        this.ivEventIcon = imageView3;
        this.llEvent = linearLayout;
        this.progress = circularProgressIndicator;
        this.tvTime = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemPlayerEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemPlayerEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_player_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemPlayerEventBinding bind(View view) {
        int i = R.id.btnDownload;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btnRefresh;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.flDownload;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.ivEventIcon;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView3 != null) {
                        i = R.id.llEvent;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.progress;
                            CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.findChildViewById(view, i);
                            if (circularProgressIndicator != null) {
                                i = R.id.tvTime;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    return new ItemPlayerEventBinding(constraintLayout, imageView, imageView2, constraintLayout, frameLayout, imageView3, linearLayout, circularProgressIndicator, textView);
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
