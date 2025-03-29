package ru.tattelecom.intercom.feature.familyaccess.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.tattelecom.intercom.android.resources.customview.CustomEditTextView;
import ru.tattelecom.intercom.feature.familyaccess.R;

/* loaded from: classes6.dex */
public final class FragmentInviteUserBinding implements ViewBinding {
    public final MaterialButton btnContinue;
    public final ImageView btnOpenContacts;
    public final AppCompatAutoCompleteTextView etApartment;
    public final CustomEditTextView etPhoneNumber;
    public final NestedScrollView nscRoot;
    private final NestedScrollView rootView;
    public final RecyclerView rvGuests;
    public final TextView tvApartment;
    public final TextView tvPhoneNumber;

    private FragmentInviteUserBinding(NestedScrollView nestedScrollView, MaterialButton materialButton, ImageView imageView, AppCompatAutoCompleteTextView appCompatAutoCompleteTextView, CustomEditTextView customEditTextView, NestedScrollView nestedScrollView2, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = nestedScrollView;
        this.btnContinue = materialButton;
        this.btnOpenContacts = imageView;
        this.etApartment = appCompatAutoCompleteTextView;
        this.etPhoneNumber = customEditTextView;
        this.nscRoot = nestedScrollView2;
        this.rvGuests = recyclerView;
        this.tvApartment = textView;
        this.tvPhoneNumber = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public NestedScrollView getRoot() {
        return this.rootView;
    }

    public static FragmentInviteUserBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentInviteUserBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_invite_user, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentInviteUserBinding bind(View view) {
        int i = R.id.btn_continue;
        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(view, i);
        if (materialButton != null) {
            i = R.id.btn_open_contacts;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.et_apartment;
                AppCompatAutoCompleteTextView appCompatAutoCompleteTextView = (AppCompatAutoCompleteTextView) ViewBindings.findChildViewById(view, i);
                if (appCompatAutoCompleteTextView != null) {
                    i = R.id.et_phone_number;
                    CustomEditTextView customEditTextView = (CustomEditTextView) ViewBindings.findChildViewById(view, i);
                    if (customEditTextView != null) {
                        NestedScrollView nestedScrollView = (NestedScrollView) view;
                        i = R.id.rv_guests;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.tv_apartment;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.tv_phone_number;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    return new FragmentInviteUserBinding(nestedScrollView, materialButton, imageView, appCompatAutoCompleteTextView, customEditTextView, nestedScrollView, recyclerView, textView, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
