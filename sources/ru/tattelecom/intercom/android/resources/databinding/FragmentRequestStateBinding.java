package ru.tattelecom.intercom.android.resources.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.android.resources.R;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;

/* loaded from: classes5.dex */
public final class FragmentRequestStateBinding implements ViewBinding {
    public final MaterialButton btnContinue;
    public final SupportContactView cvSupport;
    public final Guideline guideline;
    public final Guideline guidelineVertical;
    public final ImageView ivState;
    public final ConstraintLayout llParent;
    private final ConstraintLayout rootView;
    public final TextView tvMessage;
    public final TextView tvTitle;

    private FragmentRequestStateBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, SupportContactView supportContactView, Guideline guideline, Guideline guideline2, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnContinue = materialButton;
        this.cvSupport = supportContactView;
        this.guideline = guideline;
        this.guidelineVertical = guideline2;
        this.ivState = imageView;
        this.llParent = constraintLayout2;
        this.tvMessage = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRequestStateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRequestStateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_request_state, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentRequestStateBinding bind(View view) {
        int i = R.id.btn_continue;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.cv_support;
            SupportContactView supportContactView = (SupportContactView) ViewBindings.findChildViewById(view, i);
            if (supportContactView != null) {
                i = R.id.guideline;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                if (guideline != null) {
                    i = R.id.guideline_vertical;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                    if (guideline2 != null) {
                        i = R.id.iv_state;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = R.id.tv_message;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new FragmentRequestStateBinding(constraintLayout, materialButton, supportContactView, guideline, guideline2, imageView, constraintLayout, textView, textView2);
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
