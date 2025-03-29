package ru.tattelecom.intercom.android.resources.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.android.resources.R;

/* loaded from: classes5.dex */
public final class SnackbarCustomAttentionBinding implements ViewBinding {
    public final TextView btnBecomeSubscriber;
    public final ImageView btnClose;
    public final ConstraintLayout clRoot;
    private final ConstraintLayout rootView;
    public final TextView tvAttentionInfo;
    public final TextView tvAttentionTitle;

    private SnackbarCustomAttentionBinding(ConstraintLayout constraintLayout, TextView textView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.btnBecomeSubscriber = textView;
        this.btnClose = imageView;
        this.clRoot = constraintLayout2;
        this.tvAttentionInfo = textView2;
        this.tvAttentionTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SnackbarCustomAttentionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SnackbarCustomAttentionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.snackbar_custom_attention, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SnackbarCustomAttentionBinding bind(View view) {
        int i = R.id.btn_become_subscriber;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_close;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.tv_attention_info;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.tv_attention_title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView3 != null) {
                        return new SnackbarCustomAttentionBinding(constraintLayout, textView, imageView, constraintLayout, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
