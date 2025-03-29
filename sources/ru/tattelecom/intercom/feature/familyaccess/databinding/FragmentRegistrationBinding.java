package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class FragmentRegistrationBinding implements ViewBinding {
    public final MaterialButton btnRegister;
    public final CustomEditTextView etLogin;
    private final LinearLayout rootView;

    private FragmentRegistrationBinding(LinearLayout linearLayout, MaterialButton materialButton, CustomEditTextView customEditTextView) {
        this.rootView = linearLayout;
        this.btnRegister = materialButton;
        this.etLogin = customEditTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRegistrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRegistrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_registration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentRegistrationBinding bind(View view) {
        int i = R.id.btn_register;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.et_login;
            CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.findChildViewById(view, i);
            if (customEditTextView != null) {
                return new FragmentRegistrationBinding((LinearLayout) view, materialButton, customEditTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
