package ru.tattelecom.intercom.feature.home.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.home.R;

/* loaded from: classes6.dex */
public final class DialogIntercomErrorBinding implements ViewBinding {
    public final ImageView btnClose;
    public final MaterialButton btnReportIssue;
    private final NestedScrollView rootView;
    public final TextView tvEmergencyCodeText;
    public final TextView tvEmergencyCodeTitle;

    private DialogIntercomErrorBinding(NestedScrollView nestedScrollView, ImageView imageView, MaterialButton materialButton, TextView textView, TextView textView2) {
        this.rootView = nestedScrollView;
        this.btnClose = imageView;
        this.btnReportIssue = materialButton;
        this.tvEmergencyCodeText = textView;
        this.tvEmergencyCodeTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static DialogIntercomErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogIntercomErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_intercom_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogIntercomErrorBinding bind(View view) {
        int i = R.id.btnClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btnReportIssue;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.tvEmergencyCodeText;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvEmergencyCodeTitle;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        return new DialogIntercomErrorBinding((NestedScrollView) view, imageView, materialButton, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
