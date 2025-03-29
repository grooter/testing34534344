package ru.tattelecom.intercom.feature.gate_widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.gate_widget.R;

/* loaded from: classes6.dex */
public final class WidgetGateBinding implements ViewBinding {
    public final ImageButton btnOpenDoor;
    public final LinearLayout llRoot;
    public final ProgressBar progress;
    private final RelativeLayout rootView;
    public final TextView tvError;
    public final TextView tvGateName;

    private WidgetGateBinding(RelativeLayout relativeLayout, ImageButton imageButton, LinearLayout linearLayout, ProgressBar progressBar, TextView textView, TextView textView2) {
        this.rootView = relativeLayout;
        this.btnOpenDoor = imageButton;
        this.llRoot = linearLayout;
        this.progress = progressBar;
        this.tvError = textView;
        this.tvGateName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WidgetGateBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WidgetGateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.widget_gate, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WidgetGateBinding bind(View view) {
        int i = R.id.btnOpenDoor;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i);
        if (imageButton != null) {
            i = R.id.llRoot;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.progress;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                if (progressBar != null) {
                    i = R.id.tvError;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tvGateName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new WidgetGateBinding((RelativeLayout) view, imageButton, linearLayout, progressBar, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
