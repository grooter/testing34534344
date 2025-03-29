package ru.tattelecom.intercom.feature.trial.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.trial.R;

/* loaded from: classes7.dex */
public final class FragmentTrialBinding implements ViewBinding {
    public final ImageView btnClose;
    public final MaterialButton btnTrial;
    public final ConstraintLayout clRoot;
    public final ImageView ivBackground;
    private final ConstraintLayout rootView;
    public final TextView tvDescription;
    public final TextView tvTitle;

    private FragmentTrialBinding(ConstraintLayout constraintLayout, ImageView imageView, MaterialButton materialButton, ConstraintLayout constraintLayout2, ImageView imageView2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnClose = imageView;
        this.btnTrial = materialButton;
        this.clRoot = constraintLayout2;
        this.ivBackground = imageView2;
        this.tvDescription = textView;
        this.tvTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTrialBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentTrialBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_trial, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTrialBinding bind(View view) {
        int i = R.id.btnClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btnTrial;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.ivBackground;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.tvDescription;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tvTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentTrialBinding(constraintLayout, imageView, materialButton, constraintLayout, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
