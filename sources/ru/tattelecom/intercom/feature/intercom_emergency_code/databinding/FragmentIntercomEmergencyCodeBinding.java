package ru.tattelecom.intercom.feature.intercom_emergency_code.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.feature.intercom_emergency_code.R;

/* loaded from: classes7.dex */
public final class FragmentIntercomEmergencyCodeBinding implements ViewBinding {
    public final ImageView btnClose;
    public final MaterialButton btnReportIssue;
    private final NestedScrollView rootView;
    public final TextView tvEmergencyCode;
    public final TextView tvEmergencyCodeText;
    public final TextView tvEmergencyCodeTitle;

    private FragmentIntercomEmergencyCodeBinding(NestedScrollView nestedScrollView, ImageView imageView, MaterialButton materialButton, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = nestedScrollView;
        this.btnClose = imageView;
        this.btnReportIssue = materialButton;
        this.tvEmergencyCode = textView;
        this.tvEmergencyCodeText = textView2;
        this.tvEmergencyCodeTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentIntercomEmergencyCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentIntercomEmergencyCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_intercom_emergency_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentIntercomEmergencyCodeBinding bind(View view) {
        int i = R.id.btnClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btnReportIssue;
            MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
            if (materialButton != null) {
                i = R.id.tvEmergencyCode;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tvEmergencyCodeText;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tvEmergencyCodeTitle;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new FragmentIntercomEmergencyCodeBinding((NestedScrollView) view, imageView, materialButton, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
