package ru.tattelecom.intercom.feature.office_map.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.tattelecom.intercom.feature.office_map.R;

/* loaded from: classes7.dex */
public final class ItemFilterMapBinding implements ViewBinding {
    public final TextView counter;
    public final TextView filterName;
    public final ImageView iconFilter;
    private final LinearLayout rootView;

    private ItemFilterMapBinding(LinearLayout linearLayout, TextView textView, TextView textView2, ImageView imageView) {
        this.rootView = linearLayout;
        this.counter = textView;
        this.filterName = textView2;
        this.iconFilter = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemFilterMapBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFilterMapBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_filter_map, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemFilterMapBinding bind(View view) {
        int i = R.id.counter;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.filterName;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.iconFilter;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    return new ItemFilterMapBinding((LinearLayout) view, textView, textView2, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
