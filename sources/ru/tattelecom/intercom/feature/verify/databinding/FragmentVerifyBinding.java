package ru.tattelecom.intercom.feature.verify.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.android.resources.customview.CustomCodeEditText;
import ru.tattelecom.intercom.feature.verify.R;

/* loaded from: classes8.dex */
public final class FragmentVerifyBinding implements ViewBinding {
    public final MaterialButton btnResendCode;
    public final CustomCodeEditText etCode;
    private final LinearLayout rootView;
    public final MaterialToolbar toolbar;
    public final TextView tvAttemptsLeft;
    public final TextView tvErrorCode;
    public final TextView tvHint;

    private FragmentVerifyBinding(LinearLayout linearLayout, MaterialButton materialButton, CustomCodeEditText customCodeEditText, MaterialToolbar materialToolbar, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.btnResendCode = materialButton;
        this.etCode = customCodeEditText;
        this.toolbar = materialToolbar;
        this.tvAttemptsLeft = textView;
        this.tvErrorCode = textView2;
        this.tvHint = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVerifyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVerifyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_verify, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentVerifyBinding bind(View view) {
        int i = R.id.btn_resend_code;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.et_code;
            CustomCodeEditText customCodeEditText = (CustomCodeEditText) ViewBindings.findChildViewById(view, i);
            if (customCodeEditText != null) {
                i = R.id.toolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                if (materialToolbar != null) {
                    i = R.id.tv_attempts_left;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_error_code;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.tv_hint;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null) {
                                return new FragmentVerifyBinding((LinearLayout) view, materialButton, customCodeEditText, materialToolbar, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
