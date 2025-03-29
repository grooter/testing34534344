package ru.tattelecom.intercom.feature.login.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.android.resources.customview.SupportContactView;
import ru.tattelecom.intercom.feature.login.R;

/* loaded from: classes7.dex */
public final class FragmentLoginBinding implements ViewBinding {
    public final MaterialButton btnLogIn;
    public final SupportContactView cvSupportContacts;
    public final CustomEditTextView etPhoneNumber;
    public final ImageView ivLogo;
    public final ConstraintLayout llParent;
    private final ConstraintLayout rootView;
    public final TextView tvHint;
    public final TextView tvPrivacyPolicy;

    private FragmentLoginBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, SupportContactView supportContactView, CustomEditTextView customEditTextView, ImageView imageView, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnLogIn = materialButton;
        this.cvSupportContacts = supportContactView;
        this.etPhoneNumber = customEditTextView;
        this.ivLogo = imageView;
        this.llParent = constraintLayout2;
        this.tvHint = textView;
        this.tvPrivacyPolicy = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLoginBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLoginBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentLoginBinding bind(View view) {
        int i = R.id.btn_log_in;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.cv_support_contacts;
            SupportContactView supportContactView = (SupportContactView) ViewBindings.findChildViewById(view, i);
            if (supportContactView != null) {
                i = R.id.et_phone_number;
                CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.findChildViewById(view, i);
                if (customEditTextView != null) {
                    i = R.id.iv_logo;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.tv_hint;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.tv_privacy_policy;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                return new FragmentLoginBinding(constraintLayout, materialButton, supportContactView, customEditTextView, imageView, constraintLayout, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
