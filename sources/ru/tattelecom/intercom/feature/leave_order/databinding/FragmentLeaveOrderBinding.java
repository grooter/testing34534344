package ru.tattelecom.intercom.feature.leave_order.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.ChipGroup;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.feature.leave_order.R;

/* loaded from: classes7.dex */
public final class FragmentLeaveOrderBinding implements ViewBinding {
    public final MaterialButton btnApply;
    public final ChipGroup cgServices;
    public final CustomEditTextView etName;
    public final CustomEditTextView etPhoneNumber;
    private final LinearLayout rootView;
    public final MaterialToolbar toolbar;
    public final TextView tvPrivacyPolicy;

    private FragmentLeaveOrderBinding(LinearLayout linearLayout, MaterialButton materialButton, ChipGroup chipGroup, CustomEditTextView customEditTextView, CustomEditTextView customEditTextView2, MaterialToolbar materialToolbar, TextView textView) {
        this.rootView = linearLayout;
        this.btnApply = materialButton;
        this.cgServices = chipGroup;
        this.etName = customEditTextView;
        this.etPhoneNumber = customEditTextView2;
        this.toolbar = materialToolbar;
        this.tvPrivacyPolicy = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLeaveOrderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentLeaveOrderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_leave_order, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentLeaveOrderBinding bind(View view) {
        int i = R.id.btn_apply;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.cg_services;
            ChipGroup chipGroup = (ChipGroup) ViewBindings.findChildViewById(view, i);
            if (chipGroup != null) {
                i = R.id.et_name;
                CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.findChildViewById(view, i);
                if (customEditTextView != null) {
                    i = R.id.et_phone_number;
                    CustomEditTextView customEditTextView2 = (CustomEditTextView) ViewBindings.findChildViewById(view, i);
                    if (customEditTextView2 != null) {
                        i = R.id.toolbar;
                        MaterialToolbar materialToolbar = (MaterialToolbar) ViewBindings.findChildViewById(view, i);
                        if (materialToolbar != null) {
                            i = R.id.tv_privacy_policy;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                return new FragmentLeaveOrderBinding((LinearLayout) view, materialButton, chipGroup, customEditTextView, customEditTextView2, materialToolbar, textView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
