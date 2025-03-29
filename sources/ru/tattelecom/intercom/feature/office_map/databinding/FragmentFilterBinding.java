package ru.tattelecom.intercom.feature.office_map.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.chip.ChipGroup;
import ru.tattelecom.intercom.feature.office_map.R;

/* loaded from: classes7.dex */
public final class FragmentFilterBinding implements ViewBinding {
    public final TextView btnClean;
    public final ImageView btnClose;
    public final LinearLayout btnShow;
    public final ChipGroup cgServices;
    public final TextView checkedCountButtonTextView;
    private final LinearLayout rootView;

    private FragmentFilterBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, LinearLayout linearLayout2, ChipGroup chipGroup, TextView textView2) {
        this.rootView = linearLayout;
        this.btnClean = textView;
        this.btnClose = imageView;
        this.btnShow = linearLayout2;
        this.cgServices = chipGroup;
        this.checkedCountButtonTextView = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_filter, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentFilterBinding bind(View view) {
        int i = R.id.btnClean;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btnClose;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.btnShow;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.cgServices;
                    ChipGroup chipGroup = (ChipGroup) ViewBindings.findChildViewById(view, i);
                    if (chipGroup != null) {
                        i = R.id.checkedCountButtonTextView;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            return new FragmentFilterBinding((LinearLayout) view, textView, imageView, linearLayout, chipGroup, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
