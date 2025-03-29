package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class FragmentGenerateQrCodeBinding implements ViewBinding {
    public final MaterialButton btnGenerateQrCode;
    public final AppCompatAutoCompleteTextView etApartment;
    private final ConstraintLayout rootView;
    public final TextInputLayout tilApartment;
    public final TextView tvAddress;
    public final TextView tvApartment;

    private FragmentGenerateQrCodeBinding(ConstraintLayout constraintLayout, MaterialButton materialButton, AppCompatAutoCompleteTextView appCompatAutoCompleteTextView, TextInputLayout textInputLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.btnGenerateQrCode = materialButton;
        this.etApartment = appCompatAutoCompleteTextView;
        this.tilApartment = textInputLayout;
        this.tvAddress = textView;
        this.tvApartment = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentGenerateQrCodeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentGenerateQrCodeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_generate_qr_code, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentGenerateQrCodeBinding bind(View view) {
        int i = R.id.btn_generate_qr_code;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.et_apartment;
            AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
            if (appCompatAutoCompleteTextView != null) {
                i = R.id.til_apartment;
                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, i);
                if (textInputLayout != null) {
                    i = R.id.tv_address;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.tv_apartment;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentGenerateQrCodeBinding((ConstraintLayout) view, materialButton, appCompatAutoCompleteTextView, textInputLayout, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
