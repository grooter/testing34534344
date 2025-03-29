package ru.tattelecom.intercom.feature.videoplayer.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.videoplayer.R;
import ru.tattelecom.intercom.feature.videoplayer.doubleTapView.CircleClipTapView;

/* loaded from: classes8.dex */
public final class DoubleTapViewBinding implements ViewBinding {
    public final CircleClipTapView cctvBackward;
    public final CircleClipTapView cctvForward;
    public final ConstraintLayout clBackward;
    public final ConstraintLayout clForward;
    public final Guideline guidelineBackward;
    public final Guideline guidelineForward;
    public final Guideline guidelineLeft;
    public final Guideline guidelineRight;
    public final AppCompatImageView iconBackward;
    public final AppCompatImageView iconForward;
    private final ConstraintLayout rootView;
    public final AppCompatTextView tvSecondsBackward;
    public final AppCompatTextView tvSecondsForward;

    private DoubleTapViewBinding(ConstraintLayout constraintLayout, CircleClipTapView circleClipTapView, CircleClipTapView circleClipTapView2, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.cctvBackward = circleClipTapView;
        this.cctvForward = circleClipTapView2;
        this.clBackward = constraintLayout2;
        this.clForward = constraintLayout3;
        this.guidelineBackward = guideline;
        this.guidelineForward = guideline2;
        this.guidelineLeft = guideline3;
        this.guidelineRight = guideline4;
        this.iconBackward = appCompatImageView;
        this.iconForward = appCompatImageView2;
        this.tvSecondsBackward = appCompatTextView;
        this.tvSecondsForward = appCompatTextView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DoubleTapViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DoubleTapViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.double_tap_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DoubleTapViewBinding bind(View view) {
        int i = R.id.cctvBackward;
        CircleClipTapView circleClipTapView = (CircleClipTapView) ViewBindings.findChildViewById(view, i);
        if (circleClipTapView != null) {
            i = R.id.cctvForward;
            CircleClipTapView circleClipTapView2 = (CircleClipTapView) ViewBindings.findChildViewById(view, i);
            if (circleClipTapView2 != null) {
                i = R.id.clBackward;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                if (constraintLayout != null) {
                    i = R.id.clForward;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.guidelineBackward;
                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                        if (guideline != null) {
                            i = R.id.guidelineForward;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline2 != null) {
                                i = R.id.guidelineLeft;
                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline3 != null) {
                                    i = R.id.guidelineRight;
                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline4 != null) {
                                        i = R.id.iconBackward;
                                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                        if (appCompatImageView != null) {
                                            i = R.id.iconForward;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                            if (appCompatImageView2 != null) {
                                                i = R.id.tvSecondsBackward;
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                                if (appCompatTextView != null) {
                                                    i = R.id.tvSecondsForward;
                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i);
                                                    if (appCompatTextView2 != null) {
                                                        return new DoubleTapViewBinding((ConstraintLayout) view, circleClipTapView, circleClipTapView2, constraintLayout, constraintLayout2, guideline, guideline2, guideline3, guideline4, appCompatImageView, appCompatImageView2, appCompatTextView, appCompatTextView2);
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
